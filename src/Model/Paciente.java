package Model;

import java.util.Date;

public class Paciente extends Pessoa{


    public Paciente(int id, String nome, char sexo, String dataNascimento, String telefone, String email, String CPF, String endereco, int idade) {
        super(id, nome, sexo, dataNascimento, telefone, email, CPF, endereco, idade);

    }
       public Paciente(int id, String nome, char sexo, String telefone, String email, String CPF, String endereco, int idade) {
        super(id, nome, sexo, telefone, email, CPF, endereco, idade);

    }

    public Paciente(int id, String nome, char sexo, String telefone, String endereco) {
        super(id, nome, sexo, telefone, endereco);
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
    
    
    
}
