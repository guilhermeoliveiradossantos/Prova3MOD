package Models;

import java.sql.Date;

public class AlunosModel {

    private int id;
    private String nome;
    private String Idade;
    private String Turma;

    public AlunosModel() {
    }

    public AlunosModel(int id, String nome, String Idade, String Turma) {
        this.id = id;
        this.nome = nome;
        this.Idade = Idade;
        this.Turma = Turma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String Idade) {
        this.Idade = Idade;
    }

    public String getTurma() {
        return Turma;
    }

    public void setTurma(String Turma) {
        this.Turma = Turma;
    }

   
}
