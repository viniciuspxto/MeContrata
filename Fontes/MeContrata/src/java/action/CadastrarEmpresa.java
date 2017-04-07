/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dao.EmpresaJpaController;
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
import model.Empresa;

/**
 *
 * @author vinicius
 */
public class CadastrarEmpresa implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeContrataPU");
        EntityManager em = emf.createEntityManager();
        
        EmpresaJpaController empresaDao = new EmpresaJpaController(emf);
        
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confirmaSenha = request.getParameter("confirmaSenha");
        String cnpj = request.getParameter("cnpj");
        String nomefantasia = request.getParameter("nomefantasia");
        String razaoSocial = request.getParameter("razaoSocial");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String telefone = request.getParameter("telefone");
        
        Empresa empresa = new Empresa (nomefantasia, razaoSocial, cnpj, email, senha, cep, logradouro, numero, complemento, bairro, cidade, estado, telefone);
        
        if (!senha.equals(confirmaSenha)) {
            exibirErroSenha(request, response, empresa);
        }
        
        empresaDao.create(empresa);
        
        // após cadastrar, redireciona pra Home        
        new Home().execute(request, response);
    }
    
    private void exibirErroSenha(HttpServletRequest request, HttpServletResponse response, Empresa empresa) {
        
        try {
            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("template.jsp?page=cadastroEmpresa");
            request.setAttribute("existeErro", true);
            request.setAttribute("empresa", empresa);
            rd.forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarEmpresa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
