package control;

import java.sql.SQLException;
import java.time.LocalDate;

import entity.Cliente;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import persistence.ClienteDAO;

public class ClienteControl {
	
	private ClienteDAO clienteDAO;
	
	private StringProperty cpf = new SimpleStringProperty();
	private StringProperty nome = new SimpleStringProperty();
	private StringProperty sobrenome = new SimpleStringProperty();
	private ObjectProperty<LocalDate> data_Nasc = new SimpleObjectProperty<>();
	private StringProperty email = new SimpleStringProperty();
	private StringProperty logradouro = new SimpleStringProperty();
	private IntegerProperty numero = new SimpleIntegerProperty();
	private StringProperty bairro = new SimpleStringProperty();
	private StringProperty cep = new SimpleStringProperty();
	private DoubleProperty milhas_percorridas = new SimpleDoubleProperty();
	
	public ClienteControl() throws ClassNotFoundException, SQLException {
		clienteDAO = new ClienteDAO();
	}
	
	public Cliente getCliente() {
		Cliente c = new Cliente();
		c.setCpf(this.cpf.get());
		c.setNome(this.nome.get());
		c.setSobrenome(this.sobrenome.get());
		c.setData_Nasc(this.data_Nasc.get());
		c.setEmail(this.email.get());
		c.setLogradouro(this.logradouro.get());
		c.setNumero(this.numero.get());
		c.setBairro(this.bairro.get());
		c.setCep(this.cep.get());
		c.setMilhas_percorridas(this.milhas_percorridas.get());
		return c;
	}
	
	public void setCliente(Cliente c) {
		if (c != null) {
			this.cpf.set(c.getCpf());
			this.nome.set(c.getNome());
			this.sobrenome.set(c.getSobrenome());
			this.data_Nasc.set(c.getData_Nasc());
			this.email.set(c.getEmail());
			this.logradouro.set(c.getLogradouro());
			this.numero.set(c.getNumero());
			this.bairro.set(c.getBairro());
			this.cep.set(c.getCep());
			this.milhas_percorridas.set(c.getMilhas_percorridas());
		}
	}
	
	public void adicionar() throws SQLException {
		Cliente c = getCliente();
		clienteDAO.inserirCliente(c);
	}
	
	
	public StringProperty getCpfProperty() {
		return cpf;
	}
	public void setCpfProperty(StringProperty cpf) {
		this.cpf = cpf;
	}
	public StringProperty getNomeProperty() {
		return nome;
	}
	public void setNomeProperty(StringProperty nome) {
		this.nome = nome;
	}
	public StringProperty getSobrenomeProperty() {
		return sobrenome;
	}
	public void setSobrenomeProperty(StringProperty sobrenome) {
		this.sobrenome = sobrenome;
	}
	public ObjectProperty<LocalDate> getData_NascProperty() {
		return data_Nasc;
	}
	public void setData_NascProperty(ObjectProperty<LocalDate> data_Nasc) {
		this.data_Nasc = data_Nasc;
	}
	public StringProperty getEmailProperty() {
		return email;
	}
	public void setEmailProperty(StringProperty email) {
		this.email = email;
	}
	public StringProperty getLogradouroProperty() {
		return logradouro;
	}
	public void setLogradouroProperty(StringProperty logradouro) {
		this.logradouro = logradouro;
	}
	public IntegerProperty getNumeroProperty() {
		return numero;
	}
	public void setNumeroProperty(IntegerProperty numero) {
		this.numero = numero;
	}
	public StringProperty getBairroProperty() {
		return bairro;
	}
	public void setBairroProperty(StringProperty bairro) {
		this.bairro = bairro;
	}
	public StringProperty getCepProperty() {
		return cep;
	}
	public void setCepProperty(StringProperty cep) {
		this.cep = cep;
	}
	public DoubleProperty getMilhas_percorridasProperty() {
		return milhas_percorridas;
	}
	public void setMilhas_percorridasProperty (DoubleProperty milhas_percorridas) {
		this.milhas_percorridas = milhas_percorridas;
	} 
	
	
	

}
