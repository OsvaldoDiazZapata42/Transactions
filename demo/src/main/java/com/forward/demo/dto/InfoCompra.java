package com.forward.demo.dto;

import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = { "montoTotal", "infoImpuestos", "cantidadCuotas" })
public class InfoCompra {

    private double montoTotal;
    private InfoImpuestos infoImpuestos;
    private int cantidadCuotas;

    @XmlElement(name = "montoTotal", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @XmlElement(name = "infoImpuestos", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoImpuestos getInfoImpuestos() {
        return infoImpuestos;
    }

    public void setInfoImpuestos(InfoImpuestos infoImpuestos) {
        this.infoImpuestos = infoImpuestos;
    }

    @XmlElement(name = "cantidadCuotas", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }
}

class InfoImpuestos {

    private String tipoImpuesto;
    private double monto;

    @XmlElement(name = "tipoImpuesto", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(String tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    @XmlElement(name = "monto", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
