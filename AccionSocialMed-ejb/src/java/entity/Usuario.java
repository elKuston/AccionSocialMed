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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author Angela
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuario.findByLocalidad", query = "SELECT u FROM Usuario u WHERE u.localidad = :localidad")
    , @NamedQuery(name = "Usuario.findByTurnotarde", query = "SELECT u FROM Usuario u WHERE u.turnotarde = :turnotarde")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CORREO")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TELEFONO")
    private Integer telefono;
    @Size(max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Size(max = 50)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "TURNOTARDE")
    private Boolean turnotarde;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Actividad> actividadList;
    @JoinTable(name = "ETIQUETAS_USUARIO", joinColumns = {
        @JoinColumn(name = "CORREO", referencedColumnName = "CORREO")}, inverseJoinColumns = {
        @JoinColumn(name = "ETIQUETA", referencedColumnName = "ETIQUETA")})
    @ManyToMany
    private List<Etiqueta> etiquetaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Pas pas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Ong ong;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Profesor profesor;
    @OneToMany(mappedBy = "participante")
    private List<Informe> informeList;
    @OneToMany(mappedBy = "profesor")
    private List<Informe> informeList1;
    @OneToMany(mappedBy = "emisor")
    private List<Notificacion> notificacionList;
    @OneToMany(mappedBy = "receptor")
    private List<Notificacion> notificacionList1;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Estudiante estudiante;
    @OneToMany(mappedBy = "emisor")
    private List<Mensaje> mensajeList;
    @OneToMany(mappedBy = "receptor")
    private List<Mensaje> mensajeList1;

    public Usuario() {
    }

    public Usuario(String correo) {
        this.correo = correo;
    }

    public Usuario(String correo, String nombre) {
        this.correo = correo;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Boolean getTurnotarde() {
        return turnotarde;
    }

    public void setTurnotarde(Boolean turnotarde) {
        this.turnotarde = turnotarde;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @XmlTransient
    public List<Etiqueta> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<Etiqueta> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public Pas getPas() {
        return pas;
    }

    public void setPas(Pas pas) {
        this.pas = pas;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @XmlTransient
    public List<Informe> getInformeList() {
        return informeList;
    }

    public void setInformeList(List<Informe> informeList) {
        this.informeList = informeList;
    }

    @XmlTransient
    public List<Informe> getInformeList1() {
        return informeList1;
    }

    public void setInformeList1(List<Informe> informeList1) {
        this.informeList1 = informeList1;
    }

    @XmlTransient
    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    @XmlTransient
    public List<Notificacion> getNotificacionList1() {
        return notificacionList1;
    }

    public void setNotificacionList1(List<Notificacion> notificacionList1) {
        this.notificacionList1 = notificacionList1;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList() {
        return mensajeList;
    }

    public void setMensajeList(List<Mensaje> mensajeList) {
        this.mensajeList = mensajeList;
    }

    @XmlTransient
    public List<Mensaje> getMensajeList1() {
        return mensajeList1;
    }

    public void setMensajeList1(List<Mensaje> mensajeList1) {
        this.mensajeList1 = mensajeList1;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.correo == null && other.correo != null) || (this.correo != null && !this.correo.equals(other.correo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ correo=" + correo + " ]";
    }
    
}
