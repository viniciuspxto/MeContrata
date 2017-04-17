/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.UsuarioJpaController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author viniciuspeixoto
 */
public class SalvarCurriculo implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
        
        Usuario usuarioLogado = (Usuario)request.getSession().getAttribute("usuario");
        
        String formacaoAcademica = request.getParameter("academico");
        String experienciaProfissional = request.getParameter("experienciaProfissional");
        
        Usuario usuario = new Usuario(usuarioLogado.getId(), usuarioLogado.getNome(), usuarioLogado.getDatanascimento(), usuarioLogado.getCpf(), usuarioLogado.getTelefone(), usuarioLogado.getEmail(), formacaoAcademica, experienciaProfissional);
        
        usuario.setSenha(usuarioLogado.getSenha());
        usuarioDao.edit(usuario);
        
        // atualizando o usuario na sessão
        request.getSession().setAttribute("usuario", usuario);
        
        new Home().execute(request, response);
        
    }
    
}
