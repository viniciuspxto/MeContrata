/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.IllegalOrphanException;
import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.City;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import model.Country;
import model.Countrylanguage;

/**
 *
 * @author viniciuspeixoto
 */
public class CountryJpaController implements Serializable {

    public CountryJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    
    public CountryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
            
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Country country) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (country.getCityList() == null) {
            country.setCityList(new ArrayList<City>());
        }
        if (country.getCountrylanguageList() == null) {
            country.setCountrylanguageList(new ArrayList<Countrylanguage>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<City> attachedCityList = new ArrayList<City>();
            for (City cityListCityToAttach : country.getCityList()) {
                cityListCityToAttach = em.getReference(cityListCityToAttach.getClass(), cityListCityToAttach.getId());
                attachedCityList.add(cityListCityToAttach);
            }
            country.setCityList(attachedCityList);
            List<Countrylanguage> attachedCountrylanguageList = new ArrayList<Countrylanguage>();
            for (Countrylanguage countrylanguageListCountrylanguageToAttach : country.getCountrylanguageList()) {
                countrylanguageListCountrylanguageToAttach = em.getReference(countrylanguageListCountrylanguageToAttach.getClass(), countrylanguageListCountrylanguageToAttach.getCountrylanguagePK());
                attachedCountrylanguageList.add(countrylanguageListCountrylanguageToAttach);
            }
            country.setCountrylanguageList(attachedCountrylanguageList);
            em.persist(country);
            for (City cityListCity : country.getCityList()) {
                Country oldCountryCodeOfCityListCity = cityListCity.getCountryCode();
                cityListCity.setCountryCode(country);
                cityListCity = em.merge(cityListCity);
                if (oldCountryCodeOfCityListCity != null) {
                    oldCountryCodeOfCityListCity.getCityList().remove(cityListCity);
                    oldCountryCodeOfCityListCity = em.merge(oldCountryCodeOfCityListCity);
                }
            }
            for (Countrylanguage countrylanguageListCountrylanguage : country.getCountrylanguageList()) {
                Country oldCountryOfCountrylanguageListCountrylanguage = countrylanguageListCountrylanguage.getCountry();
                countrylanguageListCountrylanguage.setCountry(country);
                countrylanguageListCountrylanguage = em.merge(countrylanguageListCountrylanguage);
                if (oldCountryOfCountrylanguageListCountrylanguage != null) {
                    oldCountryOfCountrylanguageListCountrylanguage.getCountrylanguageList().remove(countrylanguageListCountrylanguage);
                    oldCountryOfCountrylanguageListCountrylanguage = em.merge(oldCountryOfCountrylanguageListCountrylanguage);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findCountry(country.getCode()) != null) {
                throw new PreexistingEntityException("Country " + country + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Country country) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Country persistentCountry = em.find(Country.class, country.getCode());
            List<City> cityListOld = persistentCountry.getCityList();
            List<City> cityListNew = country.getCityList();
            List<Countrylanguage> countrylanguageListOld = persistentCountry.getCountrylanguageList();
            List<Countrylanguage> countrylanguageListNew = country.getCountrylanguageList();
            List<String> illegalOrphanMessages = null;
            for (City cityListOldCity : cityListOld) {
                if (!cityListNew.contains(cityListOldCity)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain City " + cityListOldCity + " since its countryCode field is not nullable.");
                }
            }
            for (Countrylanguage countrylanguageListOldCountrylanguage : countrylanguageListOld) {
                if (!countrylanguageListNew.contains(countrylanguageListOldCountrylanguage)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Countrylanguage " + countrylanguageListOldCountrylanguage + " since its country field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<City> attachedCityListNew = new ArrayList<City>();
            for (City cityListNewCityToAttach : cityListNew) {
                cityListNewCityToAttach = em.getReference(cityListNewCityToAttach.getClass(), cityListNewCityToAttach.getId());
                attachedCityListNew.add(cityListNewCityToAttach);
            }
            cityListNew = attachedCityListNew;
            country.setCityList(cityListNew);
            List<Countrylanguage> attachedCountrylanguageListNew = new ArrayList<Countrylanguage>();
            for (Countrylanguage countrylanguageListNewCountrylanguageToAttach : countrylanguageListNew) {
                countrylanguageListNewCountrylanguageToAttach = em.getReference(countrylanguageListNewCountrylanguageToAttach.getClass(), countrylanguageListNewCountrylanguageToAttach.getCountrylanguagePK());
                attachedCountrylanguageListNew.add(countrylanguageListNewCountrylanguageToAttach);
            }
            countrylanguageListNew = attachedCountrylanguageListNew;
            country.setCountrylanguageList(countrylanguageListNew);
            country = em.merge(country);
            for (City cityListNewCity : cityListNew) {
                if (!cityListOld.contains(cityListNewCity)) {
                    Country oldCountryCodeOfCityListNewCity = cityListNewCity.getCountryCode();
                    cityListNewCity.setCountryCode(country);
                    cityListNewCity = em.merge(cityListNewCity);
                    if (oldCountryCodeOfCityListNewCity != null && !oldCountryCodeOfCityListNewCity.equals(country)) {
                        oldCountryCodeOfCityListNewCity.getCityList().remove(cityListNewCity);
                        oldCountryCodeOfCityListNewCity = em.merge(oldCountryCodeOfCityListNewCity);
                    }
                }
            }
            for (Countrylanguage countrylanguageListNewCountrylanguage : countrylanguageListNew) {
                if (!countrylanguageListOld.contains(countrylanguageListNewCountrylanguage)) {
                    Country oldCountryOfCountrylanguageListNewCountrylanguage = countrylanguageListNewCountrylanguage.getCountry();
                    countrylanguageListNewCountrylanguage.setCountry(country);
                    countrylanguageListNewCountrylanguage = em.merge(countrylanguageListNewCountrylanguage);
                    if (oldCountryOfCountrylanguageListNewCountrylanguage != null && !oldCountryOfCountrylanguageListNewCountrylanguage.equals(country)) {
                        oldCountryOfCountrylanguageListNewCountrylanguage.getCountrylanguageList().remove(countrylanguageListNewCountrylanguage);
                        oldCountryOfCountrylanguageListNewCountrylanguage = em.merge(oldCountryOfCountrylanguageListNewCountrylanguage);
                    }
                }
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
                String id = country.getCode();
                if (findCountry(id) == null) {
                    throw new NonexistentEntityException("The country with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Country country;
            try {
                country = em.getReference(Country.class, id);
                country.getCode();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The country with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<City> cityListOrphanCheck = country.getCityList();
            for (City cityListOrphanCheckCity : cityListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Country (" + country + ") cannot be destroyed since the City " + cityListOrphanCheckCity + " in its cityList field has a non-nullable countryCode field.");
            }
            List<Countrylanguage> countrylanguageListOrphanCheck = country.getCountrylanguageList();
            for (Countrylanguage countrylanguageListOrphanCheckCountrylanguage : countrylanguageListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Country (" + country + ") cannot be destroyed since the Countrylanguage " + countrylanguageListOrphanCheckCountrylanguage + " in its countrylanguageList field has a non-nullable country field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(country);
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

    public List<Country> findCountryEntities() {
        return findCountryEntities(true, -1, -1);
    }

    public List<Country> findCountryEntities(int maxResults, int firstResult) {
        return findCountryEntities(false, maxResults, firstResult);
    }

    private List<Country> findCountryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Country.class));
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

    public Country findCountry(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Country.class, id);
        } finally {
            em.close();
        }
    }

    public int getCountryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Country> rt = cq.from(Country.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
