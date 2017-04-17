/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinicius
 */
@Entity
@Table(name = "vaga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vaga.findAll", query = "SELECT v FROM Vaga v")
    , @NamedQuery(name = "Vaga.findById", query = "SELECT v FROM Vaga v WHERE v.id = :id")
    , @NamedQuery(name = "Vaga.findByNome", query = "SELECT v FROM Vaga v WHERE v.nome = :nome")
    , @NamedQuery(name = "Vaga.findByDescricao", query = "SELECT v FROM Vaga v WHERE v.descricao = :descricao")
    , @NamedQuery(name = "Vaga.findByPreRequisito", query = "SELECT v FROM Vaga v WHERE v.preRequisito = :preRequisito")
    , @NamedQuery(name = "Vaga.findByBeneficios", query = "SELECT v FROM Vaga v WHERE v.beneficios = :beneficios")
    , @NamedQuery(name = "Vaga.findByAtivo", query = "SELECT v FROM Vaga v WHERE v.ativo = :ativo")})
public class Vaga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preRequisito")
    private String preRequisito;
    @Column(name = "beneficios")
    private String beneficios;
    @Column(name = "ativo")
    private Integer ativo;
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id")
    @ManyToOne
    private Empresa idEmpresa;
    @OneToMany(mappedBy = "idVaga")
    private List<CandidatoVaga> candidatoVagaList;
    @Transient
    private String descricaoFormatada;
    

    public Vaga() {
    }

    public Vaga(Integer id) {
        this.id = id;
    }

    public String getDescricaoFormatada() {
        if (this.descricao != null) {
            int tamanhoDesc = this.descricao.length();
            if (tamanhoDesc < 125) {
                return this.descricao+"...";
            }
            return this.descricao.substring(0,123)+"...";
        }
        return "...";
    }

    public void setDescricaoFormatada(String descricaoFormatada) {
        this.descricaoFormatada = descricaoFormatada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(String preRequisito) {
        this.preRequisito = preRequisito;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @XmlTransient
    public List<CandidatoVaga> getCandidatoVagaList() {
        return candidatoVagaList;
    }

    public void setCandidatoVagaList(List<CandidatoVaga> candidatoVagaList) {
        this.candidatoVagaList = candidatoVagaList;
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
        if (!(object instanceof Vaga)) {
            return false;
        }
        Vaga other = (Vaga) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vaga[ id=" + id + " ]";
    }
    
    
}
