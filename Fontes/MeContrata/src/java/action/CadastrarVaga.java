/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.VagaJpaController;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import model.Vaga;

/**
 *
 * @author viniciuspeixoto
 */
public class CadastrarVaga implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        VagaJpaController vagaDao = new VagaJpaController(emf);
        
        String nome = request.getParameter("nomeVaga");
        String descricao = request.getParameter("descricao");
        String beneficios = request.getParameter("beneficios");
        String requisitos = request.getParameter("requisitos");
        
        Vaga vaga = new Vaga();
        
        Empresa empresa = (Empresa) request.getSession().getAttribute("empresa");
        
        vaga.setNome(nome);
        vaga.setDescricao(descricao);
        vaga.setPreRequisito(requisitos);
        vaga.setBeneficios(beneficios);
        vaga.setAtivo(1);
        vaga.setIdEmpresa(empresa);
        
        vagaDao.create(vaga);
        
        new Home().execute(request, response);
        
        
    }
    
}
