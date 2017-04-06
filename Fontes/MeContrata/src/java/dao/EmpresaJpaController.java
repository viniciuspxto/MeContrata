/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Vaga;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Empresa;

/**
 *
 * @author vinicius
 */
public class EmpresaJpaController implements Serializable {

    public EmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresa empresa) {
        if (empresa.getVagaList() == null) {
            empresa.setVagaList(new ArrayList<Vaga>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Vaga> attachedVagaList = new ArrayList<Vaga>();
            for (Vaga vagaListVagaToAttach : empresa.getVagaList()) {
                vagaListVagaToAttach = em.getReference(vagaListVagaToAttach.getClass(), vagaListVagaToAttach.getId());
                attachedVagaList.add(vagaListVagaToAttach);
            }
            empresa.setVagaList(attachedVagaList);
            em.persist(empresa);
            for (Vaga vagaListVaga : empresa.getVagaList()) {
                Empresa oldIdEmpresaOfVagaListVaga = vagaListVaga.getIdEmpresa();
                vagaListVaga.setIdEmpresa(empresa);
                vagaListVaga = em.merge(vagaListVaga);
                if (oldIdEmpresaOfVagaListVaga != null) {
                    oldIdEmpresaOfVagaListVaga.getVagaList().remove(vagaListVaga);
                    oldIdEmpresaOfVagaListVaga = em.merge(oldIdEmpresaOfVagaListVaga);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresa empresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa persistentEmpresa = em.find(Empresa.class, empresa.getId());
            List<Vaga> vagaListOld = persistentEmpresa.getVagaList();
            List<Vaga> vagaListNew = empresa.getVagaList();
            List<Vaga> attachedVagaListNew = new ArrayList<Vaga>();
            for (Vaga vagaListNewVagaToAttach : vagaListNew) {
                vagaListNewVagaToAttach = em.getReference(vagaListNewVagaToAttach.getClass(), vagaListNewVagaToAttach.getId());
                attachedVagaListNew.add(vagaListNewVagaToAttach);
            }
            vagaListNew = attachedVagaListNew;
            empresa.setVagaList(vagaListNew);
            empresa = em.merge(empresa);
            for (Vaga vagaListOldVaga : vagaListOld) {
                if (!vagaListNew.contains(vagaListOldVaga)) {
                    vagaListOldVaga.setIdEmpresa(null);
                    vagaListOldVaga = em.merge(vagaListOldVaga);
                }
            }
            for (Vaga vagaListNewVaga : vagaListNew) {
                if (!vagaListOld.contains(vagaListNewVaga)) {
                    Empresa oldIdEmpresaOfVagaListNewVaga = vagaListNewVaga.getIdEmpresa();
                    vagaListNewVaga.setIdEmpresa(empresa);
                    vagaListNewVaga = em.merge(vagaListNewVaga);
                    if (oldIdEmpresaOfVagaListNewVaga != null && !oldIdEmpresaOfVagaListNewVaga.equals(empresa)) {
                        oldIdEmpresaOfVagaListNewVaga.getVagaList().remove(vagaListNewVaga);
                        oldIdEmpresaOfVagaListNewVaga = em.merge(oldIdEmpresaOfVagaListNewVaga);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empresa.getId();
                if (findEmpresa(id) == null) {
                    throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.");
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
            Empresa empresa;
            try {
                empresa = em.getReference(Empresa.class, id);
                empresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.", enfe);
            }
            List<Vaga> vagaList = empresa.getVagaList();
            for (Vaga vagaListVaga : vagaList) {
                vagaListVaga.setIdEmpresa(null);
                vagaListVaga = em.merge(vagaListVaga);
            }
            em.remove(empresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresa> findEmpresaEntities() {
        return findEmpresaEntities(true, -1, -1);
    }

    public List<Empresa> findEmpresaEntities(int maxResults, int firstResult) {
        return findEmpresaEntities(false, maxResults, firstResult);
    }

    private List<Empresa> findEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
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

    public Empresa findEmpresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
