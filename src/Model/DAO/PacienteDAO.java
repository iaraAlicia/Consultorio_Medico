package Model.DAO;

import Model.Paciente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private static final String FILE_PATH = "src/Banco/pacientes.json";
    private final Gson gson = new Gson();

    // Método para inserir um paciente no JSON
    public void insert(Paciente paciente) {
        List<Paciente> pacientes = selectAll(); // Carrega os pacientes existentes
        pacientes.add(paciente); // Adiciona o novo paciente
        saveToFile(pacientes); // Salva no arquivo
    }

    // Método para retornar todos os pacientes do JSON
    public ArrayList<Paciente> selectAll() {
        List<Paciente> pacientes = loadFromFile();
        return new ArrayList<>(pacientes);
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
            gson.toJson(pacientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os pacientes do JSON
    private List<Paciente> loadFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Paciente>>() {}.getType();
            List<Paciente> pacientes = gson.fromJson(reader, listType);
            return (pacientes != null) ? pacientes : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
