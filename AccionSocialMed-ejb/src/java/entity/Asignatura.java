/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Angela
 */
@Entity
@Table(name = "ASIGNATURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findByCodAsignatura", query = "SELECT a FROM Asignatura a WHERE a.codAsignatura = :codAsignatura")
    , @NamedQuery(name = "Asignatura.findByNombreAsignatura", query = "SELECT a FROM Asignatura a WHERE a.nombreAsignatura = :nombreAsignatura")
    , @NamedQuery(name = "Asignatura.findByNCreditos", query = "SELECT a FROM Asignatura a WHERE a.nCreditos = :nCreditos")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ASIGNATURA")
    private Integer codAsignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "NOMBRE_ASIGNATURA")
    private String nombreAsignatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_CREDITOS")
    private int nCreditos;
    @ManyToMany(mappedBy = "asignaturaCollection")
    private Collection<Estudiante> estudianteCollection;
    @ManyToMany(mappedBy = "asignaturaCollection")
    private Collection<Profesor> profesorCollection;
    @OneToMany(mappedBy = "asignaturaAsociada")
    private Collection<Actividad> actividadCollection;

    public Asignatura() {
    }

    public Asignatura(Integer codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Asignatura(Integer codAsignatura, String nombreAsignatura, int nCreditos) {
        this.codAsignatura = codAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.nCreditos = nCreditos;
    }

    public Integer getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Integer codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public int getNCreditos() {
        return nCreditos;
    }

    public void setNCreditos(int nCreditos) {
        this.nCreditos = nCreditos;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<Profesor> getProfesorCollection() {
        return profesorCollection;
    }

    public void setProfesorCollection(Collection<Profesor> profesorCollection) {
        this.profesorCollection = profesorCollection;
    }

    @XmlTransient
    public Collection<Actividad> getActividadCollection() {
        return actividadCollection;
    }

    public void setActividadCollection(Collection<Actividad> actividadCollection) {
        this.actividadCollection = actividadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAsignatura != null ? codAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.codAsignatura == null && other.codAsignatura != null) || (this.codAsignatura != null && !this.codAsignatura.equals(other.codAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Asignatura[ codAsignatura=" + codAsignatura + " ]";
    }
    
}
