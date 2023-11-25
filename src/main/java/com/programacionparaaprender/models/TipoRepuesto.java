package com.programacionparaaprender.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lacorrea
 */
public class TipoRepuesto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pkId;

    private String nombre;

    private String descripcion;

    private Date fechaRegistro;

    private Collection<Repuesto> repuestoCollection;

    public TipoRepuesto() {
    }

    public TipoRepuesto(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<Repuesto> getRepuestoCollection() {
        return repuestoCollection;
    }

    public void setRepuestoCollection(Collection<Repuesto> repuestoCollection) {
        this.repuestoCollection = repuestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRepuesto)) {
            return false;
        }
        TipoRepuesto other = (TipoRepuesto) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoRepuesto[ pkId=" + pkId + " ]";
    }
    
}
