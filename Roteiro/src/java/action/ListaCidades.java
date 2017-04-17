/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.CityJpaController;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.City;

/**
 *
 * @author viniciuspeixoto
 */
public class ListaCidades implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RoteiroPU");
        EntityManager em = emf.createEntityManager();

        CityJpaController cityDao = new CityJpaController(emf);
        List<City> listaCidade = cityDao.findCityEntities();
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp?page=lista");
        request.setAttribute("lista", listaCidade);

        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }    
        
        
    }
    
}
