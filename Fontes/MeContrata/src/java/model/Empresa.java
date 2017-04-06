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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vinicius
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findById", query = "SELECT e FROM Empresa e WHERE e.id = :id")
    , @NamedQuery(name = "Empresa.findByNomefantasia", query = "SELECT e FROM Empresa e WHERE e.nomefantasia = :nomefantasia")
    , @NamedQuery(name = "Empresa.findByRazaoSocial", query = "SELECT e FROM Empresa e WHERE e.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "Empresa.findByCnpj", query = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj")
    , @NamedQuery(name = "Empresa.findByEmail", query = "SELECT e FROM Empresa e WHERE e.email = :email")
    , @NamedQuery(name = "Empresa.findBySenha", query = "SELECT e FROM Empresa e WHERE e.senha = :senha")
    , @NamedQuery(name = "Empresa.findByCep", query = "SELECT e FROM Empresa e WHERE e.cep = :cep")
    , @NamedQuery(name = "Empresa.findByLogradouro", query = "SELECT e FROM Empresa e WHERE e.logradouro = :logradouro")
    , @NamedQuery(name = "Empresa.findByNumero", query = "SELECT e FROM Empresa e WHERE e.numero = :numero")
    , @NamedQuery(name = "Empresa.findByComplememto", query = "SELECT e FROM Empresa e WHERE e.complememto = :complememto")
    , @NamedQuery(name = "Empresa.findByBairro", query = "SELECT e FROM Empresa e WHERE e.bairro = :bairro")
    , @NamedQuery(name = "Empresa.findByCidade", query = "SELECT e FROM Empresa e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Empresa.findByEstado", query = "SELECT e FROM Empresa e WHERE e.estado = :estado")
    , @NamedQuery(name = "Empresa.findByTelefone", query = "SELECT e FROM Empresa e WHERE e.telefone = :telefone")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nomefantasia")
    private String nomefantasia;
    @Basic(optional = false)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "complememto")
    private String complememto;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(mappedBy = "idEmpresa")
    private List<Vaga> vagaList;

    public Empresa() {
    }

    public Empresa(Integer id) {
        this.id = id;
    }

    public Empresa(Integer id, String nomefantasia, String razaoSocial, String cnpj, String email, String senha, String cep, String logradouro, String numero, String complememto, String bairro, String cidade, String estado, String telefone) {
        this.id = id;
        this.nomefantasia = nomefantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.email = email;
        this.senha = senha;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complememto = complememto;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplememto() {
        return complememto;
    }

    public void setComplememto(String complememto) {
        this.complememto = complememto;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public List<Vaga> getVagaList() {
        return vagaList;
    }

    public void setVagaList(List<Vaga> vagaList) {
        this.vagaList = vagaList;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empresa[ id=" + id + " ]";
    }
    
}
