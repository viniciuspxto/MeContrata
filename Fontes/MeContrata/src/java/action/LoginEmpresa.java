/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.EmpresaJpaController;
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
import model.Empresa;

/**
 *
 * @author vinicius
 */
public class LoginEmpresa implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();

        // função conversar com banco
        EmpresaJpaController empresaDao = new EmpresaJpaController(emf);

        String login = request.getParameter("loginEmpresa");
        String senha = request.getParameter("senha");

        Empresa empresa = empresaDao.verificaLogin(login, senha);

        if (empresa == null) {
            loginEmpresaInvalida(request, response);
        } else {
            login(request, empresa, response);
        }
    }

    private void loginEmpresaInvalida(HttpServletRequest request, HttpServletResponse response) {
        try {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("template.jsp?page=home");
            request.setAttribute("loginEmpresaInvalida", true);
            rd.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // colocar objeto usuario na sessão 
    private void login(HttpServletRequest request, Empresa empresa, HttpServletResponse response) throws ServletException, IOException, Exception {
        HttpSession session = request.getSession();
        session.setAttribute("empresa", empresa);
        new Home().execute(request, response);
    }

}
