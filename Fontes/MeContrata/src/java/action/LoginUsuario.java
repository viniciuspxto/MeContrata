/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.UsuarioJpaController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import model.Usuario_;

/**
 *
 * @author vinicius
 */
public class LoginUsuario implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);
        
        String login = request.getParameter("loginUsuario");
        String senha = request.getParameter("senha");
        
        Usuario usuario = usuarioDao.verificaLogin(login, senha);
        
        // validação login
        if (usuario == null) {
            loginUsuarioInvalido(request, response);
        }else{
            login(request, usuario);
        }
            
        
        
        
        
    }
    
    private void loginUsuarioInvalido(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("template.jsp?page=home");
            request.setAttribute("loginUsuarioInvalido", true);
            rd.forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // colocar objeto usuario na sessão 
    private void login(HttpServletRequest request, Usuario usuario){
        HttpSession session = request.getSession();
        session.setAttribute("usuario", usuario);
    }
    
}
