/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Empresa;
import model.Usuario;
import model.Vaga;

/**
 *
 * @author vinicius
 */
public class VagaJpaController implements Serializable {

    public VagaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vaga vaga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa idEmpresa = vaga.getIdEmpresa();
            if (idEmpresa != null) {
                idEmpresa = em.getReference(idEmpresa.getClass(), idEmpresa.getId());
                vaga.setIdEmpresa(idEmpresa);
            }
            em.persist(vaga);
            if (idEmpresa != null) {
                idEmpresa.getVagaList().add(vaga);
                idEmpresa = em.merge(idEmpresa);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vaga vaga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vaga persistentVaga = em.find(Vaga.class, vaga.getId());
            Empresa idEmpresaOld = persistentVaga.getIdEmpresa();
            Empresa idEmpresaNew = vaga.getIdEmpresa();
            if (idEmpresaNew != null) {
                idEmpresaNew = em.getReference(idEmpresaNew.getClass(), idEmpresaNew.getId());
                vaga.setIdEmpresa(idEmpresaNew);
            }
            vaga = em.merge(vaga);
            if (idEmpresaOld != null && !idEmpresaOld.equals(idEmpresaNew)) {
                idEmpresaOld.getVagaList().remove(vaga);
                idEmpresaOld = em.merge(idEmpresaOld);
            }
            if (idEmpresaNew != null && !idEmpresaNew.equals(idEmpresaOld)) {
                idEmpresaNew.getVagaList().add(vaga);
                idEmpresaNew = em.merge(idEmpresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vaga.getId();
                if (findVaga(id) == null) {
                    throw new NonexistentEntityException("The vaga with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vaga vaga;
            try {
                vaga = em.getReference(Vaga.class, id);
                vaga.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vaga with id " + id + " no longer exists.", enfe);
            }
            Empresa idEmpresa = vaga.getIdEmpresa();
            if (idEmpresa != null) {
                idEmpresa.getVagaList().remove(vaga);
                idEmpresa = em.merge(idEmpresa);
            }
            em.remove(vaga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vaga> findVagaEntities() {
        return findVagaEntities(true, -1, -1);
    }

    public List<Vaga> findVagaEntities(int maxResults, int firstResult) {
        return findVagaEntities(false, maxResults, firstResult);
    }

    private List<Vaga> findVagaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vaga.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Vaga findVaga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vaga.class, id);
        } finally {
            em.close();
        }
    }

    public int getVagaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vaga> rt = cq.from(Vaga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public List<Vaga> recuperarVagasAleatorias(){
        EntityManager em = getEntityManager();
        String query = "SELECT v FROM Vaga v WHERE v.ativo = 1 ORDER BY v.id desc";
        Query q = em.createQuery(query);
        q.setMaxResults(4);
        return q.getResultList();
    }
    
    @SuppressWarnings("empty-statement")
    public List<Vaga> pesquisarVagas(String pesquisa){
        EntityManager em = getEntityManager();
        String query = "SELECT v FROM Vaga v WHERE v.ativo = 1 and v.nome LIKE :pesquisa";
        Query q = em.createQuery(query);
        q.setParameter("pesquisa", "%" + pesquisa + "%");
        return q.getResultList();
    }
    
    @SuppressWarnings("empty-statement")
    public List<Vaga> buscarTodasVagas(){
        EntityManager em = getEntityManager();
        String query = "SELECT v FROM Vaga v WHERE v.ativo = 1";
        Query q = em.createQuery(query);
        return q.getResultList();
    }
}
