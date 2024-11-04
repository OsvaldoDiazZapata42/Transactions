package com.forward.demo.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "infoPuntoInteraccion" })
public class CabeceraSolicitud {

    private InfoPuntoInteraccion infoPuntoInteraccion;

    @XmlElement(name = "infoPuntoInteraccion", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoPuntoInteraccion getInfoPuntoInteraccion() {
        return infoPuntoInteraccion;
    }

    public void setInfoPuntoInteraccion(InfoPuntoInteraccion infoPuntoInteraccion) {
        this.infoPuntoInteraccion = infoPuntoInteraccion;
    }
}
