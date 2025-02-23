package Model.DAO;

import Model.Administrador;
import Model.Util.DateDeserializer; // Importando o deserializador de data
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministradorDAO {
    private static final String FILE_PATH = "src/Banco/usuario.json"; // Caminho do arquivo JSON

    // Criando Gson com deserializador de datas
    private final Gson gson = new GsonBuilder()
        .registerTypeAdapter(Date.class, new DateDeserializer())
        .create();

    // Método para inserir um Administrador no JSON
    public void insert(Administrador administrador) {
        List<Administrador> administradores = selectAll(); // Carrega os administradores existentes
        
        int novoId = administradores.stream()
                                    .mapToInt(Administrador::getId)
                                    .max()
                                    .orElse(0) + 1;
        administrador.setId(novoId); // Define o novo ID
        administradores.add(administrador); // Adiciona o novo administrador
        saveToFile(administradores); // Salva no arquivo
    }

    // Método para retornar todos os Administradores do JSON
    public ArrayList<Administrador> selectAll() {
        List<Administrador> administradores = loadFromFile();
        return new ArrayList<>(administradores);
    }

    // Método para selecionar um Administrador pelo nome e senha
    public Administrador selectPorNomeESenha(Administrador administrador) {
        List<Administrador> administradores = selectAll();
        
        for (Administrador admin : administradores) {
            if (admin.getNome().equals(administrador.getNome()) && admin.getSenha().equals(administrador.getSenha())) {
                return admin;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Método para atualizar um Administrador
    public boolean update(Administrador administradorAtualizado) {
        List<Administrador> administradores = selectAll();

        for (int i = 0; i < administradores.size(); i++) {
            if (administradores.get(i).getId() == administradorAtualizado.getId()) {
                administradores.set(i, administradorAtualizado);
                saveToFile(administradores);
                return true;
            }
        }
        return false;
    }

    // Método para excluir um Administrador
    public boolean delete(Administrador administrador) {
        List<Administrador> administradores = selectAll();
        boolean removed = administradores.removeIf(a -> a.getId() == administrador.getId());
        
        if (removed) {
            saveToFile(administradores);
        }
        return removed;
    }

    // Método para salvar a lista de Administradores no JSON
    private void saveToFile(List<Administrador> administradores) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(administradores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar os Administradores do JSON
    private List<Administrador> loadFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<ArrayList<Administrador>>() {}.getType();
            List<Administrador> administradores = gson.fromJson(reader, listType);
            return (administradores != null) ? administradores : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
