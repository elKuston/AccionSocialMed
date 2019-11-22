/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jange
 */
@Entity
@Table(name = "ACTIVIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByNactividad", query = "SELECT a FROM Actividad a WHERE a.nactividad = :nactividad")
    , @NamedQuery(name = "Actividad.findByTitulo", query = "SELECT a FROM Actividad a WHERE a.titulo = :titulo")
    , @NamedQuery(name = "Actividad.findByDescripcion", query = "SELECT a FROM Actividad a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Actividad.findByFechaInicio", query = "SELECT a FROM Actividad a WHERE a.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Actividad.findByFechaFin", query = "SELECT a FROM Actividad a WHERE a.fechaFin = :fechaFin")
    , @NamedQuery(name = "Actividad.findByNpersonas", query = "SELECT a FROM Actividad a WHERE a.npersonas = :npersonas")
    , @NamedQuery(name = "Actividad.findByLugar", query = "SELECT a FROM Actividad a WHERE a.lugar = :lugar")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NACTIVIDAD")
    private Integer nactividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITULO")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "NPERSONAS")
    private Integer npersonas;
    @Size(max = 50)
    @Column(name = "LUGAR")
    private String lugar;
    @JoinTable(name = "PARTICIPACION", joinColumns = {
        @JoinColumn(name = "NACTIVIDAD", referencedColumnName = "NACTIVIDAD")}, inverseJoinColumns = {
        @JoinColumn(name = "USUARIO", referencedColumnName = "CORREO")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinTable(name = "ETIQUETAS_ACTIVIDAD", joinColumns = {
        @JoinColumn(name = "ACTIVIDAD", referencedColumnName = "NACTIVIDAD")}, inverseJoinColumns = {
        @JoinColumn(name = "ETIQUETA", referencedColumnName = "ETIQUETA")})
    @ManyToMany
    private List<Etiqueta> etiquetaList;
    @JoinColumn(name = "ASIGNATURA_ASOCIADA", referencedColumnName = "COD_ASIGNATURA")
    @ManyToOne
    private Asignatura asignaturaAsociada;
    @JoinColumn(name = "ONG", referencedColumnName = "CORREO")
    @ManyToOne(optional = false)
    private Ong ong;
    @JoinColumn(name = "CORREO_PROFESOR", referencedColumnName = "CORREO")
    @ManyToOne
    private Profesor correoProfesor;

    public Actividad() {
    }

    public Actividad(Integer nactividad) {
        this.nactividad = nactividad;
    }

    public Actividad(Integer nactividad, String titulo, String descripcion, Date fechaInicio) {
        this.nactividad = nactividad;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
    }

    public Integer getNactividad() {
        return nactividad;
    }

    public void setNactividad(Integer nactividad) {
        this.nactividad = nactividad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getNpersonas() {
        return npersonas;
    }

    public void setNpersonas(Integer npersonas) {
        this.npersonas = npersonas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Etiqueta> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<Etiqueta> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public Asignatura getAsignaturaAsociada() {
        return asignaturaAsociada;
    }

    public void setAsignaturaAsociada(Asignatura asignaturaAsociada) {
        this.asignaturaAsociada = asignaturaAsociada;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public Profesor getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(Profesor correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nactividad != null ? nactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.nactividad == null && other.nactividad != null) || (this.nactividad != null && !this.nactividad.equals(other.nactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Actividad[ nactividad=" + nactividad + " ]";
    }
    
}
