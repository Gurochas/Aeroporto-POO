package boundary;

import java.sql.SQLException;

import control.DestinoControl;
import entity.Destino;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class TelaDestinos extends TelaMaeAdm implements SubTela, EventHandler<ActionEvent> {

	TableView<Destino> table = new TableView<>(); 
	TextField txtDestino = new TextField();
	TextField txtPreco = new TextField();
	
	DestinoControl dControl= new DestinoControl();
	
    @Override
    public Pane gerarTela() {
    	
        GridPane gp = new GridPane();

        gp.setBackground(new Background(new BackgroundFill( Color.LIGHTBLUE,null,null)));

        Button btnSalvar = new Button("Salvar Destino");
        
        btnSalvar.setOnAction(this);

        gp.setAlignment(Pos.CENTER);
        gp.setVgap(5);

        txtDestino.setMinWidth(200);

        gp.add(new Label("Destino"), 0, 0);
        gp.add(txtDestino, 0, 1);

        gp.add(new Label("Preco"), 0, 2);
        gp.add(txtPreco, 0, 3);
        
        btnSalvar.setPrefSize(150, 20);
        gp.add(btnSalvar, 0, 8);
        
        vincularCampos();

        BorderPane telaPrincipal = new BorderPane();

        telaPrincipal.setLeft(super.gerarTelaEsq("TelaDestinos"));
        telaPrincipal.setCenter(gp);
        telaPrincipal.setRight(table);
        
        limparCampos();
        
        return telaPrincipal;
        
    }
    
    private void vincularCampos() {
    	StringConverter<? extends Number> converter = new DoubleStringConverter();
    	
    	Bindings.bindBidirectional(txtDestino.textProperty(), dControl.getDestinoProperty());
    	Bindings.bindBidirectional(txtPreco.textProperty(), dControl.getPrecoProperty(), (StringConverter<Number>)converter);
        
    	TableColumn<Destino, Integer> colID = new TableColumn<>("ID");
        colID.setCellValueFactory( new PropertyValueFactory<Destino, Integer>("Codigo"));
        
        TableColumn<Destino, String> colDestino = new TableColumn<>("Destino");    	
        colDestino.setCellValueFactory( new PropertyValueFactory<Destino, String>("Destino"));
        
        TableColumn<Destino, Double> colPreco = new TableColumn<>("Preco");
        colPreco.setCellValueFactory(new PropertyValueFactory<Destino, Double>("Preco"));
        
        table.setPrefWidth(362);

        table.getColumns().addAll(colID, colDestino, colPreco);

        table.resizeColumn(colID, 10);
        table.resizeColumn(colDestino, 80);
        table.resizeColumn(colPreco, 30);
        colID.setResizable(false);
        colDestino.setResizable(false);
        colPreco.setResizable(false);
        
        atualizarTabela();
    }
    
    public void atualizarTabela() {
    	try {
			table.setItems(dControl.buscarDestinos());
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void handle(ActionEvent e) {
		try {
			dControl.adicionar();
			Alert a = new Alert(AlertType.CONFIRMATION, "Cadastro realizado!", ButtonType.OK);
			a.show();
			limparCampos();
			atualizarTabela();
		} catch (SQLException e1) {
			Alert a = new Alert(AlertType.ERROR, "Erro ao gravar o destino", ButtonType.OK);
			a.show();
			e1.printStackTrace();
		}
	}

	private void limparCampos() {
		 txtDestino.clear();
		 txtPreco.clear();
	}
    
}