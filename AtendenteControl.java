package edu.curso.livro;

import java.util.ArrayList;
import java.util.List;


import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AtendenteControl {

    private List<Atendente> atendente = new ArrayList<>();

    private LongProperty cpf = new SimpleLongProperty(0);
    private StringProperty nome = new SimpleStringProperty("");
    private StringProperty cargo = new SimpleStringProperty("");
    private LongProperty senha = new SimpleLongProperty(0);
        
    public void setEntity(Atendente a) {
    	if (a != null){
    		cpf.set(a.getCpf());
    		nome.set(a.getNome());
    		cargo.set(a.getCargo());
    		senha.set(a.getSenha());
    	}
	}

    public Atendente getEntity() {
    	Atendente a = new Atendente();
    	a.setCpf(cpf.get());
    	a.setNome(nome.get());
    	a.setCargo(cargo.get());
    	a.setSenha(senha.get());
    	return a;
        }
    
    public void adicionar() {
        Atendente a = getEntity();
        atendente.add(a);
    }

    public void pesquisar() {
        for (Atendente a : atendente) {
            if (a.getNome().contains(nome.get())) {
                this.setEntity(a);
            }
        }
    }
	public long getCpf(){
    	return cpf.get();
    }
	public LongProperty cpfProperty(){
    	return cpf;
	}
	public String getNome(){
		return nome.get();
	}
	public StringProperty nomeProperty(){
    	return nome;
    }
    public long getSenha(){
    	return senha.get();
    }
    public LongProperty senhaProperty() {
    	return senha;
	}
    public String getCargo() {
    	return cargo.get();
	}
    public StringProperty cargoProperty() {
    	return cargo;
    }
    
}