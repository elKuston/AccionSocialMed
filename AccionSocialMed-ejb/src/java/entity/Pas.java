/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jange
 */
@Entity
@Table(name = "PAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pas.findAll", query = "SELECT p FROM Pas p")
    , @NamedQuery(name = "Pas.findByCorreo", query = "SELECT p FROM Pas p WHERE p.correo = :correo")
    , @NamedQuery(name = "Pas.findByFechaNacimiento", query = "SELECT p FROM Pas p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Pas.findByApellidos", query = "SELECT p FROM Pas p WHERE p.apellidos = :apellidos")})
public class Pas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Size(max = 50)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @JoinColumn(name = "CORREO", referencedColumnName = "CORREO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Pas() {
    }

    public Pas(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof Pas)) {
            return false;
        }
        Pas other = (Pas) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Pas[ correo=" + correo + " ]";
    }
    
}