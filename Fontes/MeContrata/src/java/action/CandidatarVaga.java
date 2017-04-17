/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.CandidatoVagaJpaController;
import dao.VagaJpaController;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CandidatoVaga;
import model.Usuario;
import model.Vaga;

/**
 *
 * @author viniciuspeixoto
 */
public class CandidatarVaga implements ICommander{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        VagaJpaController vagaDao = new VagaJpaController(emf);
        
        String idVaga = request.getParameter("idVaga");
        Vaga vaga = vagaDao.findVaga(Integer.parseInt(idVaga));
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        
        CandidatoVaga candidatoVaga = new CandidatoVaga();
        candidatoVaga.setIdCandidato(usuario);
        candidatoVaga.setIdVaga(vaga);
        
        CandidatoVagaJpaController candidatoVagaDao = new CandidatoVagaJpaController(emf);
        
        candidatoVagaDao.create(candidatoVaga);
        
        new VagasCandidatadas().execute(request, response);
    
    }
    
}
