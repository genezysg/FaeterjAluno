package br.com.aluno.faeterj.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Anotacao {
	  @Id
	  private Date data;
	  private String texto;
	
	  static SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	  
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public String getDataToString() {
		return sdf.format(data);
	}
	
	public void setData(String datastr) {
		Date data;
		try {
			data = sdf.parse(datastr);
		} catch (ParseException e){
			data = new Date();
		}
		this.data = data;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
}
