package control;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import entity.Aviao;
import entity.Destino;
import entity.Viagem;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persistence.ViagemDAO;

public class ViagemControl {
	
	private ObservableList<Viagem> lista = FXCollections.observableArrayList();
	private IntegerProperty codigo = new SimpleIntegerProperty();
	private ObjectProperty<LocalDate> data = new SimpleObjectProperty<>();
	private ObjectProperty<LocalTime> hora = new SimpleObjectProperty<>();
	private AviaoControl aviao = new AviaoControl();
	private DestinoControl destino = new DestinoControl();
	
	public Viagem getViagem() {
		Viagem v = new Viagem();
		v.setCodigo(this.codigo.get());
		v.setData(this.data.get());
		v.setHora(this.hora.get());
		v.setAviao(this.aviao.getAviao());
		v.setDestino(this.destino.getDestino());
		return v;
	}
	
	public void setViagem (Viagem v) {
		if (v != null) {
			this.codigo.set(v.getCodigo());
			this.data.set(v.getData());
			this.hora.set(v.getHora());
			this.aviao.setAviao(v.getAviao());
			this.destino.setDestino(v.getDestino());
		}
	}
	
	public Viagem buscar (Viagem v) throws SQLException {
		ViagemDAO viagemDAO = new ViagemDAO();
		v = viagemDAO.buscarViagem(v);
		return v;
	}
	
	public void adicionar() throws SQLException {
		ViagemDAO viagemDAO = new ViagemDAO();
		Viagem v = getViagem();
		viagemDAO.inserirViagem(v);
	}
	
	public ObservableList<Viagem> buscarViagens() throws SQLException{
		ViagemDAO viagemDAO = new ViagemDAO();
		lista.clear();
		lista.addAll(viagemDAO.buscarViagens());
		return lista;
	}

	public IntegerProperty getCodigoProperty() {
		return codigo;
	}

	public void setCodigoProperty(IntegerProperty codigo) {
		this.codigo = codigo;
	}

	public ObjectProperty<LocalDate> getDataProperty() {
		return data;
	}

	public void setDataProperty(ObjectProperty<LocalDate> data) {
		this.data = data;
	}

	public ObjectProperty<LocalTime> getHoraProperty() {
		return hora;
	}

	public void setHoraProperty(ObjectProperty<LocalTime> hora) {
		this.hora = hora;
	}

	public AviaoControl getAviaoControl() {
		return aviao;
	}

	public void setAviaoControl(AviaoControl aviao) {
		this.aviao = aviao;
	}

	public DestinoControl getDestinoControl() {
		return destino;
	}

	public void setDestinoControl (DestinoControl destino) {
		this.destino = destino;
	}
	
	
	
}
