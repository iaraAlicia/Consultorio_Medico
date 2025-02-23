/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

/**
 *
 * @author iara4
 */
import Model.Agendamento;
import Model.Medico;
import Model.Paciente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BancoJSON {
    private static final String FILE_NAME = "src/Banco/pacientes.json";
    private static final Gson gson = new Gson();

    public static List<Paciente> carregarPacientes() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<ArrayList<Paciente>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void salvarPacientes(List<Paciente> pacientes) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(pacientes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // medicos 
    private static final String FILE_NAME_MEDICO = "src/Banco/usuario.json";
   

    public static List<Medico> carregarMedicos() {
        File file = new File(FILE_NAME_MEDICO);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(FILE_NAME_MEDICO)) {
            Type listType = new TypeToken<ArrayList<Medico>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void salvarMedicos(List<Medico> medicos) {
        try (FileWriter writer = new FileWriter(FILE_NAME_MEDICO)) {
            gson.toJson(medicos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ------------------- Cadastrar Consultas -----------------------
    
    private static final String FILE_PATH_AGENDAMENTO = "src/Banco/agendamentos.json";
          
    // Método para salvar a lista no arquivo JSON
    public static void salvar(List<Agendamento> agendamentos) {
        try (FileWriter writer = new FileWriter(FILE_PATH_AGENDAMENTO)) {
            gson.toJson(agendamentos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar a lista do arquivo JSON
    public static List<Agendamento> carregar() {
        try (FileReader reader = new FileReader(FILE_PATH_AGENDAMENTO)) {
            Type listType = new TypeToken<ArrayList<Agendamento>>() {}.getType();
            List<Agendamento> agendamentos = gson.fromJson(reader, listType);
            return (agendamentos != null) ? agendamentos : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    
}

