package Model.DAO;

import Model.Paciente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

    public class PacienteDAO {
        private static final String FILE_PATH = "src/Banco/pacientes.json";
        private final Gson gson = new Gson();

    public void insert(Paciente paciente) {
        List<Paciente> pacientes = selectAll(); // Carrega os pacientes existentes

        // Gera o próximo ID automaticamente
        int novoId = pacientes.stream()
                              .mapToInt(Paciente::getId)
                              .max()
                              .orElse(0) + 1;

        paciente.setId(novoId); // Define o novo ID
        pacientes.add(paciente); // Adiciona o paciente à lista
        saveToFile(pacientes); // Salva no arquivo JSON
    }

    // Método para retornar todos os pacientes do JSON
    public ArrayList<Paciente> selectAll() {
        List<Paciente> pacientes = loadFromFile();
        return new ArrayList<>(pacientes);
    }

    // Método para atualizar um paciente
    public boolean update(Paciente pacienteAtualizado) {
        List<Paciente> pacientes = selectAll(); // Carrega todos os pacientes

        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getNome().equals(pacienteAtualizado.getNome())) { // Identifica pelo nome (ou use ID se houver)
                pacientes.set(i, pacienteAtualizado); // Atualiza os dados do paciente
                saveToFile(pacientes); // Salva as alterações no arquivo JSON
                return true;
            }
        }
        return false; // Retorna falso se o paciente não foi encontrado
    }

    // Método para excluir um paciente
    public boolean delete(Paciente paciente) {
        List<Paciente> pacientes = selectAll();
        boolean removed = pacientes.removeIf(p -> p.getNome().equals(paciente.getNome()));
        if (removed) {
            saveToFile(pacientes);
        }
        return removed;
    }

    // Método para salvar a lista de pacientes no JSON
    private void saveToFile(List<Paciente> pacientes) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("dd/MM/yyyy") // Define o formato da data
                    .create();
            gson.toJson(pacientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Método para carregar os pacientes do JSON
    private List<Paciente> loadFromFile() {
       try (Reader reader = new FileReader(FILE_PATH)) {
           Gson gson = new GsonBuilder()
                   .setDateFormat("dd/MM/yyyy") // Define o formato da data ao carregar
                   .create();
           Type listType = new TypeToken<ArrayList<Paciente>>() {}.getType();
           List<Paciente> pacientes = gson.fromJson(reader, listType);
           return (pacientes != null) ? pacientes : new ArrayList<>();
       } catch (IOException e) {
           return new ArrayList<>();
       }
   }


}
