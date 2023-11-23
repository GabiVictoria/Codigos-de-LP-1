package br.graecus.neptunum.controller;

import br.graecus.neptunum.HelloApplication;
import br.graecus.neptunum.modelos.*;
import br.graecus.neptunum.Sessao.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

    public class HomeController implements Initializable {

        @FXML
        private Label aviso;

        @FXML
        private TableColumn<Tarefa, String> titulo;
        @FXML
        private TableColumn<Tarefa, Integer> colid;

        @FXML
        private TableColumn<Tarefa, String> datee;

        @FXML
        private TableColumn<Tarefa, String> descri;

        @FXML
        private TableColumn<Tarefa, Boolean> checkBoxCol;

        @FXML
        private TableView<Tarefa> tabela;
        @FXML
        private TextField tituloTarefa;
        @FXML
        private TextField descricaoTarefa;
        @FXML
        private DatePicker dataTarefa;
        @FXML
        private Button btnsalvar;
        @FXML
        private MenuButton btnCategoria;
        @FXML
        private TextField categoria;
        Integer id = null;
        CategoriaSesao categoriaSesao = new CategoriaSesao();

        TarefaSessao tarefaSessao = new TarefaSessao();

        List<Tarefa> tarefas = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            exibirTarefas();
            mostrarCategorias();
        }

        private void exibirTarefas() {
            tarefas = tarefaSessao.listaTarefas();
            tabela.setItems(FXCollections.observableList(tarefas));
            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            descri.setCellValueFactory(new PropertyValueFactory<>("descricao"));
            checkBoxCol.setCellValueFactory(new PropertyValueFactory<>("status"));
            datee.setCellValueFactory(new PropertyValueFactory<>("dataLimite"));


//            checkBoxCol.setCellFactory(tc -> new CheckBoxTableCell<Tarefa, Boolean>() {
//                @Override
//                public void updateItem(Boolean item, boolean empty) {
//                    super.updateItem(item, empty);
//                    if (!isEmpty()) {
//                        CheckBox checkBox = new CheckBox();
//                        checkBox.setSelected(item);
//                        setGraphic(checkBox);
//                        checkBox.setOnAction(event -> {
//                            Tarefa tarefa = getTableView().getItems().get(getIndex());
//                            tarefa.setStatus(checkBox.isSelected());
//                        });
//                    }
//                }
//            });
        }



        @FXML
        public void salvarTarefa() {
            String nome = tituloTarefa.getText();
            String descricao = descricaoTarefa.getText();
            String data = String.valueOf(dataTarefa.getValue());
            System.out.println(data);
            Tarefa tarefa = new Tarefa(nome, descricao, data, false, new Categoria("romano"));
            System.out.println("salvou tarefa");
            tarefaSessao.salvarTarefa(tarefa);
            exibirTarefas();
        }



        @FXML
        void deletarTarefa(ActionEvent event) {
        tarefaSessao.deletarTarefa(id);
        exibirTarefas();
        }

        @FXML
        void editarTarefa(ActionEvent event) {
            Tarefa tarefa = tarefaSessao.buscarTarefa(id);
            tarefa.setTitulo(tituloTarefa.getText());
            tarefa.setDescricao(descricaoTarefa.getText());
            tarefa.setDataLimite(String.valueOf(dataTarefa.getValue()));
            tarefaSessao.salvarTarefa(tarefa);
            exibirTarefas();
        }

        @FXML
        void getData(MouseEvent event) {
            Tarefa tarefa = tabela.getSelectionModel().getSelectedItem();
            id = tarefa.getId();
            tituloTarefa.setText(tarefa.getTitulo());
            descricaoTarefa.setText(tarefa.getDescricao());
            dataTarefa.setValue(LocalDate.parse(tarefa.getDataLimite()));
            btnsalvar.setDisable(true);
        }

        void clear(){
            exibirTarefas();
            id = null;
            tituloTarefa.setText(null);
            descricaoTarefa.setText(null);
            dataTarefa.setValue(null);
            btnsalvar.setDisable(false);
        }

        @FXML
        void limparTarefa(ActionEvent event) {
            clear();
        }

        @FXML
        void addCategoria(ActionEvent event){

        }

        public void mostrarCategorias() {
            categorias = categoriaSesao.listaCategoria();
            for (Categoria categoria : categorias) {
                MenuItem menuItem = new MenuItem(categoria.getNome());


                menuItem.setOnAction(event -> btnCategoria.setText(categoria.getNome()));

                btnCategoria.getItems().add(menuItem);
            }
        }


        @FXML
        public void retornar(ActionEvent event) {
            HelloApplication.telas("login");
        }
    }
