/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import model.Country;
import model.Countrylanguage;
import model.CountrylanguagePK;

/**
 *
 * @author viniciuspeixoto
 */
public class CountrylanguageJpaController implements Serializable {

    public CountrylanguageJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Countrylanguage countrylanguage) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (countrylanguage.getCountrylanguagePK() == null) {
            countrylanguage.setCountrylanguagePK(new CountrylanguagePK());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Country country = countrylanguage.getCountry();
            if (country != null) {
                country = em.getReference(country.getClass(), country.getCode());
                countrylanguage.setCountry(country);
            }
            em.persist(countrylanguage);
            if (country != null) {
                country.getCountrylanguageList().add(countrylanguage);
                country = em.merge(country);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCountrylanguage(countrylanguage.getCountrylanguagePK()) != null) {
                throw new PreexistingEntityException("Countrylanguage " + countrylanguage + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Countrylanguage countrylanguage) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Countrylanguage persistentCountrylanguage = em.find(Countrylanguage.class, countrylanguage.getCountrylanguagePK());
            Country countryOld = persistentCountrylanguage.getCountry();
            Country countryNew = countrylanguage.getCountry();
            if (countryNew != null) {
                countryNew = em.getReference(countryNew.getClass(), countryNew.getCode());
                countrylanguage.setCountry(countryNew);
            }
            countrylanguage = em.merge(countrylanguage);
            if (countryOld != null && !countryOld.equals(countryNew)) {
                countryOld.getCountrylanguageList().remove(countrylanguage);
                countryOld = em.merge(countryOld);
            }
            if (countryNew != null && !countryNew.equals(countryOld)) {
                countryNew.getCountrylanguageList().add(countrylanguage);
                countryNew = em.merge(countryNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CountrylanguagePK id = countrylanguage.getCountrylanguagePK();
                if (findCountrylanguage(id) == null) {
                    throw new NonexistentEntityException("The countrylanguage with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CountrylanguagePK id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Countrylanguage countrylanguage;
            try {
                countrylanguage = em.getReference(Countrylanguage.class, id);
                countrylanguage.getCountrylanguagePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The countrylanguage with id " + id + " no longer exists.", enfe);
            }
            Country country = countrylanguage.getCountry();
            if (country != null) {
                country.getCountrylanguageList().remove(countrylanguage);
                country = em.merge(country);
            }
            em.remove(countrylanguage);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Countrylanguage> findCountrylanguageEntities() {
        return findCountrylanguageEntities(true, -1, -1);
    }

    public List<Countrylanguage> findCountrylanguageEntities(int maxResults, int firstResult) {
        return findCountrylanguageEntities(false, maxResults, firstResult);
    }

    private List<Countrylanguage> findCountrylanguageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Countrylanguage.class));
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

    public Countrylanguage findCountrylanguage(CountrylanguagePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Countrylanguage.class, id);
        } finally {
            em.close();
        }
    }

    public int getCountrylanguageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Countrylanguage> rt = cq.from(Countrylanguage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
