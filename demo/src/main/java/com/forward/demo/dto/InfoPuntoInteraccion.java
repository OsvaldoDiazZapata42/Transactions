package com.forward.demo.dto;

import javax.xml.bind.annotation.XmlElement;

public class InfoPuntoInteraccion {

    private String tipoTerminal;
    private String idTerminal;
    private String idAdquiriente;

    @XmlElement(name = "tipoTerminal", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getTipoTerminal() {
        return tipoTerminal;
    }

    public void setTipoTerminal(String tipoTerminal) {
        this.tipoTerminal = tipoTerminal;
    }

    @XmlElement(name = "idTerminal", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(String idTerminal) {
        this.idTerminal = idTerminal;
    }

    @XmlElement(name = "idAdquiriente", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getIdAdquiriente() {
        return idAdquiriente;
    }

    public void setIdAdquiriente(String idAdquiriente) {
        this.idAdquiriente = idAdquiriente;
    }
}

