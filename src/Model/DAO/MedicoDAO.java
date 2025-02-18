package Model.DAO;

import Model.Medico;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    private static final String FILE_PATH = "src/Banco/medicos.json";
    private final Gson gson = new Gson();

    // Método para inserir um medico no JSON
    public void insert(Medico medico) {
        List<Medico> medicos = selectAll(); // Carrega os medicos existentes
        medicos.add(medico); // Adiciona o novo medico
        saveToFile(medicos); // Salva no arquivo
    }

    // Método para retornar todos os medicos do JSON
    public ArrayList<Medico> selectAll() {
        List<Medico> medicos = loadFromFile();
        return new ArrayList<>(medicos);
    }

    // Método para excluir um medico
    public boolean delete(Medico medico) {
        List<Medico> medicos = selectAll();
        boolean removed = medicos.removeIf(p -> p.getNome().equals(medico.getNome()));
        if (removed) {
            saveToFile(medicos);
        }
        return removed;
    }

    // Método para salvar a lista de medicos no JSON
    private void saveToFile(List<Medico> medicos) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(medicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os medicos do JSON
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
