package com.forward.demo.dto;

import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = { "tipoDocumento", "numDocumento" })
public class IdPersona {

    private String tipoDocumento;
    private String numDocumento;

    @XmlElement(name = "tipoDocumento", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlElement(name = "numDocumento", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
}
