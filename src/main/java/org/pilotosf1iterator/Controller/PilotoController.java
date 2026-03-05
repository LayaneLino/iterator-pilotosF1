package org.pilotosf1iterator.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.pilotosf1iterator.Model.Piloto;
import org.pilotosf1iterator.Repository.PilotoRepository;

import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class PilotoController implements Initializable {

    @FXML private TableView<Piloto> tabelaPilotos;
    @FXML private TableColumn<Piloto, Integer> colMatricula;
    @FXML private TableColumn<Piloto, String> colNome;
    @FXML private TableColumn<Piloto, String> colPais;
    @FXML private TableColumn<Piloto, Integer> colIdade;
    @FXML private TableColumn<Piloto, String> colEquipe;
    @FXML private TableColumn<Piloto, String> colMotor;
    @FXML private TableColumn<Piloto, Integer> colPontos;

    private PilotoRepository repository;
    private ObservableList<Piloto> listaObs;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        repository = new PilotoRepository("DadosDosPilotosF1 2.csv");
        listaObs = FXCollections.observableArrayList();

        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
        colIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        colEquipe.setCellValueFactory(new PropertyValueFactory<>("equipe"));
        colMotor.setCellValueFactory(new PropertyValueFactory<>("motor"));
        colPontos.setCellValueFactory(new PropertyValueFactory<>("pontos"));
    }

    private void preencherTabela(Iterator<Piloto> iterator) {
        listaObs.clear();

        while (iterator.hasNext()) {
            Piloto p = iterator.next();
            listaObs.add(p);
        }
        tabelaPilotos.setItems(listaObs);
        tabelaPilotos.refresh();
    }

    private void erro(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro na requisição!");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML
    void botaoPilha() {
        try {
            preencherTabela(repository.getPilha());
        } catch (Exception e) {
            erro("Erro ao carregar Pilha: " + e.getMessage());
        }
    }

    @FXML
    void botaoFila() {
        try {
            preencherTabela(repository.getFila());
        } catch (Exception e) {
            erro("Erro ao carregar Fila: " + e.getMessage());
        }
    }

    @FXML
    void botaoArvore() {
        try {
            preencherTabela(repository.getArvore());
        } catch (Exception e) {
            erro("Erro ao carregar Árvore: " + e.getMessage());
        }
    }

    @FXML
    void botaoMatriz() {
        try {
            preencherTabela(repository.getMatriz());
        } catch (Exception e) {
            erro("Erro ao carregar Matriz: " + e.getMessage());
        }
    }

    @FXML
    void botaoGrafo() {
        try {
            preencherTabela(repository.getGrafo());
        } catch (Exception e) {
            erro("Erro ao carregar Grafo: " + e.getMessage());
        }
    }

}
