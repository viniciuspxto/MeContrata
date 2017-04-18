/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.CandidatoVagaJpaController;
import dao.EscolhaCandidatoVagaJpaController;
import dao.VagaJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CandidatoVaga;
import model.EscolhaCandidatoVaga;
import model.Vaga;

/**
 *
 * @author viniciuspeixoto
 */
public class Contratar implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        VagaJpaController vagaDao = new VagaJpaController(emf);
        EscolhaCandidatoVagaJpaController escolhaCandidatoDao = new EscolhaCandidatoVagaJpaController(emf);
        CandidatoVagaJpaController candidatoVagaDao = new CandidatoVagaJpaController(emf);
        
        String idCandidatovaga = request.getParameter("idCandidatoVaga");
        CandidatoVaga candidatoVaga = candidatoVagaDao.findCandidatoVaga(Integer.parseInt(idCandidatovaga));
        
        Vaga vaga = vagaDao.findVaga(candidatoVaga.getIdVaga().getId());
        
        vaga.setAtivo(0);
        vagaDao.edit(vaga);
        
        EscolhaCandidatoVaga candidatoEscvolhido = new EscolhaCandidatoVaga(candidatoVaga);
        candidatoEscvolhido.setVisualizada(0);
        escolhaCandidatoDao.create(candidatoEscvolhido);
        
        new MinhasVagas().execute(request, response);
        
        
        
    }
    
}
