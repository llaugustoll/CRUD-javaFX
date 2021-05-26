package edu.curso.livro;

public class Atendente {

    private String nome = "";
    private String cargo  = "";
    private long senha ;
    private long cpf;



    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf){
        this.cpf = cpf ;
    }
    public String getCargo() {
        return cargo ;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public  long getSenha() {
        return senha;
    }
    public void setSenha(long senha) {
        this.senha = senha ;
    }  
}