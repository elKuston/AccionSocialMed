/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jange
 */
@Entity
@Table(name = "MENSAJE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensaje.findAll", query = "SELECT m FROM Mensaje m")
    , @NamedQuery(name = "Mensaje.findByIdmensajenotificacion", query = "SELECT m FROM Mensaje m WHERE m.idmensajenotificacion = :idmensajenotificacion")
    , @NamedQuery(name = "Mensaje.findByLeido", query = "SELECT m FROM Mensaje m WHERE m.leido = :leido")
    , @NamedQuery(name = "Mensaje.findByContenido", query = "SELECT m FROM Mensaje m WHERE m.contenido = :contenido")
    , @NamedQuery(name = "Mensaje.findByTitulo", query = "SELECT m FROM Mensaje m WHERE m.titulo = :titulo")})
public class Mensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMENSAJENOTIFICACION")
    private Integer idmensajenotificacion;
    @Column(name = "LEIDO")
    private Boolean leido;
    @Size(max = 2000)
    @Column(name = "CONTENIDO")
    private String contenido;
    @Size(max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @JoinColumn(name = "EMISOR", referencedColumnName = "CORREO")
    @ManyToOne
    private Usuario emisor;
    @JoinColumn(name = "RECEPTOR", referencedColumnName = "CORREO")
    @ManyToOne
    private Usuario receptor;

    public Mensaje() {
    }

    public Mensaje(Integer idmensajenotificacion) {
        this.idmensajenotificacion = idmensajenotificacion;
    }

    public Integer getIdmensajenotificacion() {
        return idmensajenotificacion;
    }

    public void setIdmensajenotificacion(Integer idmensajenotificacion) {
        this.idmensajenotificacion = idmensajenotificacion;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmensajenotificacion != null ? idmensajenotificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mensaje)) {
            return false;
        }
        Mensaje other = (Mensaje) object;
        if ((this.idmensajenotificacion == null && other.idmensajenotificacion != null) || (this.idmensajenotificacion != null && !this.idmensajenotificacion.equals(other.idmensajenotificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mensaje[ idmensajenotificacion=" + idmensajenotificacion + " ]";
    }
    
}
