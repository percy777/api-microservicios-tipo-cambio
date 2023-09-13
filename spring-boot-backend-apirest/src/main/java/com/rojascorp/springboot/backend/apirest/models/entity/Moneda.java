package com.rojascorp.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="monedas")
@Getter
@Setter
public class Moneda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double monto;
	@Column(name = "moneda_origen")
	private String monedaOrigen;
	@Column(name = "moneda_destino")
	private String monedaDestino;
	@Column(name = "tipo_cambio")
	private double tipoCambio;
	@Column(name = "moneda_cambio")
	private double monedaCambio;
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@PrePersist
	public void PrePersist() {
		createAt = new Date();
	}
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	
//	public double getMonto() {
//		return monto;
//	}
//
//	public void setMonto(double monto) {
//		this.monto = monto;
//	}
//
//	public String getMonedaOrigen() {
//		return monedaOrigen;
//	}
//
//	public void setMonedaOrigen(String monedaOrigen) {
//		this.monedaOrigen = monedaOrigen;
//	}
//
//	public String getMonedaDestino() {
//		return monedaDestino;
//	}
//
//	public void setMonedaDestino(String monedaDestino) {
//		this.monedaDestino = monedaDestino;
//	}
//
//	public double getTipoCambio() {
//		return tipoCambio;
//	}
//
//	public void setTipoCambio(double tipoCambio) {
//		this.tipoCambio = tipoCambio;
//	}
//
//	public double getMonedaCambio() {
//		return monedaCambio;
//	}
//
//	public void setMonedaCambio(double monedaCambio) {
//		this.monedaCambio = monedaCambio;
//	}
//
//	public Date getCreateAt() {
//		return createAt;
//	}
//	public void setCreateAt(Date createAt) {
//		this.createAt = createAt;
//	}
	

}
