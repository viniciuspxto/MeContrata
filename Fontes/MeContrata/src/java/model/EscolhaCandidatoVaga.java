/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author viniciuspeixoto
 */
@Entity
@Table(name = "escolha_candidato_vaga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EscolhaCandidatoVaga.findAll", query = "SELECT e FROM EscolhaCandidatoVaga e")
    , @NamedQuery(name = "EscolhaCandidatoVaga.findById", query = "SELECT e FROM EscolhaCandidatoVaga e WHERE e.id = :id")
    , @NamedQuery(name = "EscolhaCandidatoVaga.findByVisualizada", query = "SELECT e FROM EscolhaCandidatoVaga e WHERE e.visualizada = :visualizada")})
public class EscolhaCandidatoVaga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "visualizada")
    private Integer visualizada;
    @JoinColumn(name = "idCandidatoVaga", referencedColumnName = "id")
    @ManyToOne
    private CandidatoVaga idCandidatoVaga;

    public EscolhaCandidatoVaga() {
    }
    
    public EscolhaCandidatoVaga(CandidatoVaga idCandidatoVaga) {
        this.idCandidatoVaga = idCandidatoVaga;
    }

    public EscolhaCandidatoVaga(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVisualizada() {
        return visualizada;
    }

    public void setVisualizada(Integer visualizada) {
        this.visualizada = visualizada;
    }

    public CandidatoVaga getIdCandidatoVaga() {
        return idCandidatoVaga;
    }

    public void setIdCandidatoVaga(CandidatoVaga idCandidatoVaga) {
        this.idCandidatoVaga = idCandidatoVaga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscolhaCandidatoVaga)) {
            return false;
        }
        EscolhaCandidatoVaga other = (EscolhaCandidatoVaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EscolhaCandidatoVaga[ id=" + id + " ]";
    }
    
}
