package edu.curso.livro;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import javafx.util.converter.LongStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtendenteBoundary extends Application {

    private TextField txtCpf = new TextField();
    private TextField txtCargo = new TextField();
    private TextField txtNome = new TextField();
    private TextField txtSenha = new TextField();
    private Button btnAdicionar = new Button("Adicionar");
    private Button btnPesquisar = new Button("Pesquisar");
    private edu.curso.livro.AtendenteControl control = new edu.curso.livro.AtendenteControl();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void start(Stage stage) throws Exception {
        GridPane gp = new GridPane();
        Scene scn = new Scene(gp, 400, 250);
        gp.add(new Label("CPF"), 0, 0);
        gp.add(txtCpf,1, 0);
        gp.add(new Label("Cargo"), 0, 2);
        gp.add(txtCargo,1, 2);
        gp.add(new Label("Nome"), 0, 3);
        gp.add(txtNome,1, 3);
        gp.add(new Label("Senha"), 0, 4);
        gp.add(txtSenha,1, 4);
        gp.add(btnAdicionar, 0, 7);
        gp.add(btnPesquisar, 1, 7);

        btnAdicionar.setOnAction((e)->{control.adicionar();});
        btnPesquisar.setOnAction((e)->{control.pesquisar();});

        StringConverter longToStringConverter = new LongStringConverter();


        Bindings.bindBidirectional(txtCpf.textProperty(), control.cpfProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
        Bindings.bindBidirectional(txtSenha.textProperty(), control.senhaProperty(), longToStringConverter);
        Bindings.bindBidirectional(txtCargo.textProperty(), control.cargoProperty());

        stage.setScene(scn);
        stage.setTitle("Cadastro de Atendente");
        stage.show();
    }

    public Atendente boundaryToEntity() {
        Atendente al = new Atendente();
        al.setNome(txtNome.getText());
        al.setNome(txtCargo.getText());
        try {
            al.setCpf(Long.parseLong(txtCpf.getText()));
            al.setSenha(Long.parseLong(txtSenha.getText()));;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return al;
    }

    public void entityToBoundary(Atendente a) {
        if (a != null) {

            txtCpf.setText(String.valueOf(a.getCpf()));
            txtNome.setText(a.getNome());
            txtSenha.setText(String.valueOf(a.getSenha()));
            txtCargo.setText(a.getCargo());

        }
    }

    public static void main(String[] args) {
        Application.launch(AtendenteBoundary.class, args);
    }
}