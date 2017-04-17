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
import model.Empresa;
import model.Usuario;
import model.Vaga;

/**
 *
 * @author vinicius
 */
public class CandidatoVagaJpaController implements Serializable {

    public CandidatoVagaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CandidatoVaga candidatoVaga) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario idCandidato = candidatoVaga.getIdCandidato();
            if (idCandidato != null) {
                idCandidato = em.getReference(idCandidato.getClass(), idCandidato.getId());
                candidatoVaga.setIdCandidato(idCandidato);
            }
            Vaga idVaga = candidatoVaga.getIdVaga();
            if (idVaga != null) {
                idVaga = em.getReference(idVaga.getClass(), idVaga.getId());
                candidatoVaga.setIdVaga(idVaga);
            }
            em.persist(candidatoVaga);
            if (idCandidato != null) {
                idCandidato.getCandidatoVagaList().add(candidatoVaga);
                idCandidato = em.merge(idCandidato);
            }
            if (idVaga != null) {
                idVaga.getCandidatoVagaList().add(candidatoVaga);
                idVaga = em.merge(idVaga);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CandidatoVaga candidatoVaga) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CandidatoVaga persistentCandidatoVaga = em.find(CandidatoVaga.class, candidatoVaga.getId());
            Usuario idCandidatoOld = persistentCandidatoVaga.getIdCandidato();
            Usuario idCandidatoNew = candidatoVaga.getIdCandidato();
            Vaga idVagaOld = persistentCandidatoVaga.getIdVaga();
            Vaga idVagaNew = candidatoVaga.getIdVaga();
            if (idCandidatoNew != null) {
                idCandidatoNew = em.getReference(idCandidatoNew.getClass(), idCandidatoNew.getId());
                candidatoVaga.setIdCandidato(idCandidatoNew);
            }
            if (idVagaNew != null) {
                idVagaNew = em.getReference(idVagaNew.getClass(), idVagaNew.getId());
                candidatoVaga.setIdVaga(idVagaNew);
            }
            candidatoVaga = em.merge(candidatoVaga);
            if (idCandidatoOld != null && !idCandidatoOld.equals(idCandidatoNew)) {
                idCandidatoOld.getCandidatoVagaList().remove(candidatoVaga);
                idCandidatoOld = em.merge(idCandidatoOld);
            }
            if (idCandidatoNew != null && !idCandidatoNew.equals(idCandidatoOld)) {
                idCandidatoNew.getCandidatoVagaList().add(candidatoVaga);
                idCandidatoNew = em.merge(idCandidatoNew);
            }
            if (idVagaOld != null && !idVagaOld.equals(idVagaNew)) {
                idVagaOld.getCandidatoVagaList().remove(candidatoVaga);
                idVagaOld = em.merge(idVagaOld);
            }
            if (idVagaNew != null && !idVagaNew.equals(idVagaOld)) {
                idVagaNew.getCandidatoVagaList().add(candidatoVaga);
                idVagaNew = em.merge(idVagaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = candidatoVaga.getId();
                if (findCandidatoVaga(id) == null) {
                    throw new NonexistentEntityException("The candidatoVaga with id " + id + " no longer exists.");
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
            CandidatoVaga candidatoVaga;
            try {
                candidatoVaga = em.getReference(CandidatoVaga.class, id);
                candidatoVaga.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The candidatoVaga with id " + id + " no longer exists.", enfe);
            }
            Usuario idCandidato = candidatoVaga.getIdCandidato();
            if (idCandidato != null) {
                idCandidato.getCandidatoVagaList().remove(candidatoVaga);
                idCandidato = em.merge(idCandidato);
            }
            Vaga idVaga = candidatoVaga.getIdVaga();
            if (idVaga != null) {
                idVaga.getCandidatoVagaList().remove(candidatoVaga);
                idVaga = em.merge(idVaga);
            }
            em.remove(candidatoVaga);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CandidatoVaga> findCandidatoVagaEntities() {
        return findCandidatoVagaEntities(true, -1, -1);
    }

    public List<CandidatoVaga> findCandidatoVagaEntities(int maxResults, int firstResult) {
        return findCandidatoVagaEntities(false, maxResults, firstResult);
    }

    private List<CandidatoVaga> findCandidatoVagaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CandidatoVaga.class));
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

    public CandidatoVaga findCandidatoVaga(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CandidatoVaga.class, id);
        } finally {
            em.close();
        }
    }

    public int getCandidatoVagaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CandidatoVaga> rt = cq.from(CandidatoVaga.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
//    RECUPERAR VAGAS POR CANDIDATO
    public List<CandidatoVaga> recuperarVagasPorCandidato(int id) {
        EntityManager em = getEntityManager();
        String query = "select c from CandidatoVaga c where c.idCandidato.id = :id";
        Query q = em.createQuery(query);
        q.setParameter("id", id);
        return q.getResultList();
    }
}
