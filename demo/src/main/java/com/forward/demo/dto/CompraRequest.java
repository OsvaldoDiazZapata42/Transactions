package com.forward.demo.dto;

import jakarta.xml.bind.annotation.*;

//@XmlRootElement(name = "compraProcesarSolicitud", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
@XmlRootElement(name = "CompraRequest")
@XmlType(propOrder = { "cabeceraSolicitud", "idPersona", "infoMedioPago", "infoCompra", "infoPersona", "infoAdicional" })
public class CompraRequest {

    private CabeceraSolicitud cabeceraSolicitud;
    private IdPersona idPersona;
    private InfoMedioPago infoMedioPago;
    private InfoCompra infoCompra;
    private InfoPersona infoPersona;
    private InfoAdicional infoAdicional;

    @XmlElement(name = "cabeceraSolicitud", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public CabeceraSolicitud getCabeceraSolicitud() {
        return cabeceraSolicitud;
    }

    public void setCabeceraSolicitud(CabeceraSolicitud cabeceraSolicitud) {
        this.cabeceraSolicitud = cabeceraSolicitud;
    }

    @XmlElement(name = "idPersona", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public IdPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(IdPersona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlElement(name = "infoMedioPago", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoMedioPago getInfoMedioPago() {
        return infoMedioPago;
    }

    public void setInfoMedioPago(InfoMedioPago infoMedioPago) {
        this.infoMedioPago = infoMedioPago;
    }

    @XmlElement(name = "infoCompra", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoCompra getInfoCompra() {
        return infoCompra;
    }

    public void setInfoCompra(InfoCompra infoCompra) {
        this.infoCompra = infoCompra;
    }

    @XmlElement(name = "infoPersona", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoPersona getInfoPersona() {
        return infoPersona;
    }

    public void setInfoPersona(InfoPersona infoPersona) {
        this.infoPersona = infoPersona;
    }

    @XmlElement(name = "infoAdicional", namespace = "https://www.txstestrbm.com:9990/CompraElectronica/Compra")
    public InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(InfoAdicional infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
}
