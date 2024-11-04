package com.forward.demo.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "infoPago" })
public class InfoAdicional {

    private InfoPago infoPago;

    @XmlElement(name = "infoPago", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoPago getInfoPago() {
        return infoPago;
    }

    public void setInfoPago(InfoPago infoPago) {
        this.infoPago = infoPago;
    }
}

class InfoPago {

    private String indicadorPago;
    private String tipoPago;
    private String tipoMontoRecurrente;

    @XmlElement(name = "indicadorPago", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getIndicadorPago() {
        return indicadorPago;
    }

    public void setIndicadorPago(String indicadorPago) {
        this.indicadorPago = indicadorPago;
    }

    @XmlElement(name = "tipoPago", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @XmlElement(name = "tipoMontoRecurrente", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getTipoMontoRecurrente() {
        return tipoMontoRecurrente;
    }

    public void setTipoMontoRecurrente(String tipoMontoRecurrente) {
        this.tipoMontoRecurrente = tipoMontoRecurrente;
    }
}

