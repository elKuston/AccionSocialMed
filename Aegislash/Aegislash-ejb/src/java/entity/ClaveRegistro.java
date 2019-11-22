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
@Table(name = "CLAVE_REGISTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaveRegistro.findAll", query = "SELECT c FROM ClaveRegistro c")
    , @NamedQuery(name = "ClaveRegistro.findByClave", query = "SELECT c FROM ClaveRegistro c WHERE c.clave = :clave")})
public class ClaveRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "CLAVE")
    private String clave;

    public ClaveRegistro() {
    }

    public ClaveRegistro(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaveRegistro)) {
            return false;
        }
        ClaveRegistro other = (ClaveRegistro) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ClaveRegistro[ clave=" + clave + " ]";
    }
    
}
