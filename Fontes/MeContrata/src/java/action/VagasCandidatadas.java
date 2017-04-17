/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.CandidatoVagaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CandidatoVaga;
import model.Usuario;

/**
 *
 * @author viniciuspeixoto
 */
public class VagasCandidatadas implements ICommander{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        CandidatoVagaJpaController candidatoVagaDao = new CandidatoVagaJpaController(emf);
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        List<CandidatoVaga> canndidatoVagas = candidatoVagaDao.recuperarVagasPorCandidato(usuario.getId());
        
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("template.jsp?page=vagasCandidatadas");
        request.setAttribute("candidatoVagas", canndidatoVagas);
        rd.forward(request, response);
    }
    
}
