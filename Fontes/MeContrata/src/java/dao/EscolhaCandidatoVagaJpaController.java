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
import model.CandidatoVaga;
import model.EscolhaCandidatoVaga;
import model.Vaga;

/**
 *
 * @author viniciuspeixoto
 */
public class EscolhaCandidatoVagaJpaController implements Serializable {

    public EscolhaCandidatoVagaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EscolhaCandidatoVaga escolhaCandidatoVaga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CandidatoVaga idCandidatoVaga = escolhaCandidatoVaga.getIdCandidatoVaga();
            if (idCandidatoVaga != null) {
                idCandidatoVaga = em.getReference(idCandidatoVaga.getClass(), idCandidatoVaga.getId());
                escolhaCandidatoVaga.setIdCandidatoVaga(idCandidatoVaga);
            }
            em.persist(escolhaCandidatoVaga);
            if (idCandidatoVaga != null) {
                idCandidatoVaga.getEscolhaCandidatoVagaList().add(escolhaCandidatoVaga);
                idCandidatoVaga = em.merge(idCandidatoVaga);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EscolhaCandidatoVaga escolhaCandidatoVaga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EscolhaCandidatoVaga persistentEscolhaCandidatoVaga = em.find(EscolhaCandidatoVaga.class, escolhaCandidatoVaga.getId());
            CandidatoVaga idCandidatoVagaOld = persistentEscolhaCandidatoVaga.getIdCandidatoVaga();
            CandidatoVaga idCandidatoVagaNew = escolhaCandidatoVaga.getIdCandidatoVaga();
            if (idCandidatoVagaNew != null) {
                idCandidatoVagaNew = em.getReference(idCandidatoVagaNew.getClass(), idCandidatoVagaNew.getId());
                escolhaCandidatoVaga.setIdCandidatoVaga(idCandidatoVagaNew);
            }
            escolhaCandidatoVaga = em.merge(escolhaCandidatoVaga);
            if (idCandidatoVagaOld != null && !idCandidatoVagaOld.equals(idCandidatoVagaNew)) {
                idCandidatoVagaOld.getEscolhaCandidatoVagaList().remove(escolhaCandidatoVaga);
                idCandidatoVagaOld = em.merge(idCandidatoVagaOld);
            }
            if (idCandidatoVagaNew != null && !idCandidatoVagaNew.equals(idCandidatoVagaOld)) {
                idCandidatoVagaNew.getEscolhaCandidatoVagaList().add(escolhaCandidatoVaga);
                idCandidatoVagaNew = em.merge(idCandidatoVagaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = escolhaCandidatoVaga.getId();
                if (findEscolhaCandidatoVaga(id) == null) {
                    throw new NonexistentEntityException("The escolhaCandidatoVaga with id " + id + " no longer exists.");
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
            EscolhaCandidatoVaga escolhaCandidatoVaga;
            try {
                escolhaCandidatoVaga = em.getReference(EscolhaCandidatoVaga.class, id);
                escolhaCandidatoVaga.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The escolhaCandidatoVaga with id " + id + " no longer exists.", enfe);
            }
            CandidatoVaga idCandidatoVaga = escolhaCandidatoVaga.getIdCandidatoVaga();
            if (idCandidatoVaga != null) {
                idCandidatoVaga.getEscolhaCandidatoVagaList().remove(escolhaCandidatoVaga);
                idCandidatoVaga = em.merge(idCandidatoVaga);
            }
            em.remove(escolhaCandidatoVaga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EscolhaCandidatoVaga> findEscolhaCandidatoVagaEntities() {
        return findEscolhaCandidatoVagaEntities(true, -1, -1);
    }

    public List<EscolhaCandidatoVaga> findEscolhaCandidatoVagaEntities(int maxResults, int firstResult) {
        return findEscolhaCandidatoVagaEntities(false, maxResults, firstResult);
    }

    private List<EscolhaCandidatoVaga> findEscolhaCandidatoVagaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EscolhaCandidatoVaga.class));
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

    public EscolhaCandidatoVaga findEscolhaCandidatoVaga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EscolhaCandidatoVaga.class, id);
        } finally {
            em.close();
        }
    }

    public int getEscolhaCandidatoVagaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EscolhaCandidatoVaga> rt = cq.from(EscolhaCandidatoVaga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    @SuppressWarnings("empty-statement")
    public List<EscolhaCandidatoVaga> buscarNotificacoesPorUsuario(int id){
        EntityManager em = getEntityManager();
        String query = "SELECT v FROM EscolhaCandidatoVaga v WHERE v.idCandidatoVaga.idCandidato.id = :id ORDER BY v.id desc";
        Query q = em.createQuery(query);
        q.setParameter("id", id);
        return q.getResultList();
    }
    
    @SuppressWarnings("empty-statement")
    public List<EscolhaCandidatoVaga> buscarNotificacoesNaoLidas(int id){
        EntityManager em = getEntityManager();
        String query = "SELECT v FROM EscolhaCandidatoVaga v WHERE v.idCandidatoVaga.idCandidato.id = :id AND v.visualizada = 0";
        Query q = em.createQuery(query);
        q.setParameter("id", id);
        return q.getResultList();
    }
    
}
