/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.EscolhaCandidatoVagaJpaController;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EscolhaCandidatoVaga;
import model.Usuario;

/**
 *
 * @author viniciuspeixoto
 */
public class NotificacaoVaga implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");
        
        EscolhaCandidatoVagaJpaController escolhaCandidatoVagaDao = new EscolhaCandidatoVagaJpaController(emf);
        
        List<EscolhaCandidatoVaga> notificacoes = escolhaCandidatoVagaDao.buscarNotificacoesPorUsuario(usuarioLogado.getId());
        
        for(EscolhaCandidatoVaga e: notificacoes){
            if(e.getVisualizada() == 0){
                e.setVisualizada(1);
            }
           escolhaCandidatoVagaDao.edit(e);
        }
        
        RequestDispatcher rd = null;
        rd = request.getRequestDispatcher("template.jsp?page=notificacoes");
        request.setAttribute("notificacoes", notificacoes);
        rd.forward(request, response);
        
        
    }
    
    
    
}
