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
import model.EscolhaCandidatoVaga;

/**
 *
 * @author vinicius
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
            em.persist(escolhaCandidatoVaga);
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
            escolhaCandidatoVaga = em.merge(escolhaCandidatoVaga);
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
    
}
