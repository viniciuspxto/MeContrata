/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.UsuarioJpaController;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author viniciuspeixoto
 */
public class EditarPerfil implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();

        UsuarioJpaController usuarioDao = new UsuarioJpaController(emf);

        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuario");

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmaSenha = request.getParameter("confirmaSenha");
        String nome = request.getParameter("nome");
        String dataNascimento = request.getParameter("dataNascimento");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date data = df.parse(dataNascimento);

        Usuario usuario = new Usuario(usuarioLogado.getId(), nome, data, cpf, telefone, email, senha, usuarioLogado.getFormacaoAcademica(), usuarioLogado.getExperienciaProfissional());

        if (!senha.equals(confirmaSenha)) {
            exibirErroSenha(request, response, usuario);
        }

        usuarioDao.edit(usuario);

        // atualizando o usuario na sessão
        request.getSession().setAttribute("usuario", usuario);

        new Home().execute(request, response);

    }

    private void exibirErroSenha(HttpServletRequest request, HttpServletResponse response, Usuario usuario) {

        try {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("template.jsp?page=editarPerfil");
            request.setAttribute("existeErro", true);
            request.setAttribute("usuario", usuario);
            rd.forward(request, response);

        } catch (ServletException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
