/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jange
 */
@Entity
@Table(name = "ONG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ong.findAll", query = "SELECT o FROM Ong o")
    , @NamedQuery(name = "Ong.findByCorreo", query = "SELECT o FROM Ong o WHERE o.correo = :correo")
    , @NamedQuery(name = "Ong.findByDireccion", query = "SELECT o FROM Ong o WHERE o.direccion = :direccion")
    , @NamedQuery(name = "Ong.findByWeb", query = "SELECT o FROM Ong o WHERE o.web = :web")})
public class Ong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "WEB")
    private String web;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ong")
    private List<Actividad> actividadList;
    @JoinColumn(name = "CORREO", referencedColumnName = "CORREO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Ong() {
    }

    public Ong(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correo != null ? correo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ong)) {
            return false;
        }
        Ong other = (Ong) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ong[ correo=" + correo + " ]";
    }
    
}
