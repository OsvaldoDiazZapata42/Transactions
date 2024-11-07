package com.forward.demo.dto;

import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = { "idTarjetaCredito" })
public class InfoMedioPago {

    private IdTarjetaCredito idTarjetaCredito;

    @XmlElement(name = "idTarjetaCredito", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public IdTarjetaCredito getIdTarjetaCredito() {
        return idTarjetaCredito;
    }

    public void setIdTarjetaCredito(IdTarjetaCredito idTarjetaCredito) {
        this.idTarjetaCredito = idTarjetaCredito;
    }
}

class IdTarjetaCredito {

    private String franquicia;
    private String numTarjeta;
    private String fechaExpiracion;
    private String codVerificacion;

    @XmlElement(name = "franquicia", namespace = "http://www.rbm.com.co/esb/")
    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    @XmlElement(name = "numTarjeta", namespace = "http://www.rbm.com.co/esb/")
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    @XmlElement(name = "fechaExpiracion", namespace = "http://www.rbm.com.co/esb/")
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    @XmlElement(name = "codVerificacion", namespace = "http://www.rbm.com.co/esb/")
    public String getCodVerificacion() {
        return codVerificacion;
    }

    public void setCodVerificacion(String codVerificacion) {
        this.codVerificacion = codVerificacion;
    }
}
