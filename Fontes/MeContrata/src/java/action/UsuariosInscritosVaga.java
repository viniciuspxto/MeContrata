/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.CandidatoVagaJpaController;
import dao.VagaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CandidatoVaga;

/**
 *
 * @author viniciuspeixoto
 */
public class UsuariosInscritosVaga implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        CandidatoVagaJpaController candidatoVagaDao = new CandidatoVagaJpaController(emf);
        
        String idVaga = request.getParameter("idVaga");
        
        List<CandidatoVaga> candidatosVaga = candidatoVagaDao.recuperarCandidatoVagaPorVaga(Integer.parseInt(idVaga));
        
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("template.jsp?page=inscritosVaga");
        
        request.setAttribute("candidatosVaga", candidatosVaga);
        rd.forward(request, response);
        
    }
    
}
