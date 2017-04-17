/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.VagaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vaga;

/**
 *
 * @author vinicius
 */
public class Home implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        VagaJpaController vagaDao = new VagaJpaController(emf);
        
        List<Vaga> vagas = vagaDao.recuperarVagasAleatorias();
        
        RequestDispatcher rd = null;  
        rd = request.getRequestDispatcher("template.jsp?page=home");
        request.setAttribute("vagas", vagas);
        rd.forward(request, response);
        
    }
    
}
