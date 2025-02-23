package Model.DAO;

import Model.Medico;
import Model.Util.DateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicoDAO {
    private static final String FILE_PATH = "src/Banco/usuario.json"; // Caminho do arquivo JSON
    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateDeserializer())
            .setDateFormat("dd/MM/yyyy") // Define o formato da data
            .create();

    // Método para inserir um médico no JSON
    public void insert(Medico medico) {
        List<Medico> medicos = selectAll(); // Carrega os médicos existentes

        int novoId = medicos.stream()
                .mapToInt(Medico::getId)
                .max()
                .orElse(0) + 1;
        medico.setId(novoId); // Define o novo ID
        medicos.add(medico); // Adiciona o novo médico
        saveToFile(medicos); // Salva no arquivo
    }

    // Método para retornar todos os médicos do JSON
    public ArrayList<Medico> selectAll() {
        List<Medico> medicos = loadFromFile();
        return new ArrayList<>(medicos);
    }

    // Método para selecionar um Médico pelo nome e senha
    public Medico selectPorNomeESenha(Medico medico) {
        List<Medico> medicos = selectAll();

        for (Medico m : medicos) {
            if (m.getNome().equals(medico.getNome()) && m.getSenha().equals(medico.getSenha())) {
                return m;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Método para atualizar um médico
    public boolean update(Medico medicoAtualizado) {
        List<Medico> medicos = selectAll(); // Carrega todos os médicos

        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId() == medicoAtualizado.getId()) { // Atualiza pelo ID
                medicos.set(i, medicoAtualizado);
                saveToFile(medicos);
                return true;
            }
        }
        return false; // Retorna falso se o médico não foi encontrado
    }

    // Método para excluir um médico
    public boolean delete(Medico medico) {
        List<Medico> medicos = selectAll();
        boolean removed = medicos.removeIf(m -> m.getId() == medico.getId());

        if (removed) {
            saveToFile(medicos);
        }
        return removed;
    }

    // Método para salvar a lista de médicos no JSON
    private void saveToFile(List<Medico> medicos) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(medicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os médicos do JSON
    private List<Medico> loadFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Medico>>() {}.getType();
            List<Medico> medicos = gson.fromJson(reader, listType);
            return (medicos != null) ? medicos : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
