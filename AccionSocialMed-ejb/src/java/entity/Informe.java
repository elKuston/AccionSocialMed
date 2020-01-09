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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "INFORME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informe.findAll", query = "SELECT i FROM Informe i")
    , @NamedQuery(name = "Informe.findByIdinforme", query = "SELECT i FROM Informe i WHERE i.idinforme = :idinforme")
    , @NamedQuery(name = "Informe.findByNotaong", query = "SELECT i FROM Informe i WHERE i.notaong = :notaong")
    , @NamedQuery(name = "Informe.findByComentarioong", query = "SELECT i FROM Informe i WHERE i.comentarioong = :comentarioong")
    , @NamedQuery(name = "Informe.findByComentarioprofesor", query = "SELECT i FROM Informe i WHERE i.comentarioprofesor = :comentarioprofesor")
    , @NamedQuery(name = "Informe.findByNotaprofesor", query = "SELECT i FROM Informe i WHERE i.notaprofesor = :notaprofesor")
    , @NamedQuery(name = "Informe.findByFechainforme", query = "SELECT i FROM Informe i WHERE i.fechainforme = :fechainforme")
    , @NamedQuery(name = "Informe.findByFechaevaluacion", query = "SELECT i FROM Informe i WHERE i.fechaevaluacion = :fechaevaluacion")
    , @NamedQuery(name = "Informe.findByNhoras", query = "SELECT i FROM Informe i WHERE i.nhoras = :nhoras")})
public class Informe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDINFORME")
    private Integer idinforme;
    @Column(name = "NOTAONG")
    private Integer notaong;
    @Size(max = 5000)
    @Column(name = "COMENTARIOONG")
    private String comentarioong;
    @Size(max = 5000)
    @Column(name = "COMENTARIOPROFESOR")
    private String comentarioprofesor;
    @Column(name = "NOTAPROFESOR")
    private Integer notaprofesor;
    @Column(name = "FECHAINFORME")
    @Temporal(TemporalType.DATE)
    private Date fechainforme;
    @Column(name = "FECHAEVALUACION")
    @Temporal(TemporalType.DATE)
    private Date fechaevaluacion;
    @Column(name = "NHORAS")
    private Integer nhoras;
    @JoinColumn(name = "ACTIVIDAD", referencedColumnName = "NACTIVIDAD")
    @ManyToOne
    private Actividad actividad;
    @JoinColumn(name = "ESTUDIANTE", referencedColumnName = "CORREO")
    @ManyToOne
    private Usuario estudiante;
    @JoinColumn(name = "PROFESOR", referencedColumnName = "CORREO")
    @ManyToOne
    private Usuario profesor;

    public Informe() {
    }

    public Informe(Integer idinforme) {
        this.idinforme = idinforme;
    }

    public Integer getIdinforme() {
        return idinforme;
    }

    public void setIdinforme(Integer idinforme) {
        this.idinforme = idinforme;
    }

    public Integer getNotaong() {
        return notaong;
    }

    public void setNotaong(Integer notaong) {
        this.notaong = notaong;
    }

    public String getComentarioong() {
        return comentarioong;
    }

    public void setComentarioong(String comentarioong) {
        this.comentarioong = comentarioong;
    }

    public String getComentarioprofesor() {
        return comentarioprofesor;
    }

    public void setComentarioprofesor(String comentarioprofesor) {
        this.comentarioprofesor = comentarioprofesor;
    }

    public Integer getNotaprofesor() {
        return notaprofesor;
    }

    public void setNotaprofesor(Integer notaprofesor) {
        this.notaprofesor = notaprofesor;
    }

    public Date getFechainforme() {
        return fechainforme;
    }

    public void setFechainforme(Date fechainforme) {
        this.fechainforme = fechainforme;
    }

    public Date getFechaevaluacion() {
        return fechaevaluacion;
    }

    public void setFechaevaluacion(Date fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    public Integer getNhoras() {
        return nhoras;
    }

    public void setNhoras(Integer nhoras) {
        this.nhoras = nhoras;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinforme != null ? idinforme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informe)) {
            return false;
        }
        Informe other = (Informe) object;
        if ((this.idinforme == null && other.idinforme != null) || (this.idinforme != null && !this.idinforme.equals(other.idinforme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Informe[ idinforme=" + idinforme + " ]";
    }
    
}
