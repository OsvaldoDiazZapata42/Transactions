package com.forward.demo.dto;

import jakarta.xml.bind.annotation.*;

@XmlType(propOrder = { "direccion", "ciudad", "departamento", "emailComercio", "telefonoFijo", "celular" })
public class InfoPersona {

    private String direccion;
    private String ciudad;
    private String departamento;
    private String emailComercio;
    private String telefonoFijo;
    private String celular;

    @XmlElement(name = "direccion", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlElement(name = "ciudad", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlElement(name = "departamento", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @XmlElement(name = "emailComercio", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getEmailComercio() {
        return emailComercio;
    }

    public void setEmailComercio(String emailComercio) {
        this.emailComercio = emailComercio;
    }

    @XmlElement(name = "telefonoFijo", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    @XmlElement(name = "celular", namespace = "https://www.txstestrbm.com:9990/CompraElectronica//")
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
