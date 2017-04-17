/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import action.CadastrarEmpresa;
import action.CadastrarUsuario;
import action.CadastrarVaga;
import action.CandidatarVaga;
import action.DetalheVaga;
import action.EditarPerfil;
import action.Home;
import action.ICommander;
import action.LoginEmpresa;
import action.LoginUsuario;
import action.Logout;
import action.MinhasVagas;
import action.PesquisarVaga;
import action.SalvarCurriculo;
import action.VagasCandidatadas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius
 */
@WebServlet(name = "HomeCentral", urlPatterns = {"/HomeCentral"})
public class HomeCentral extends HttpServlet {

    static Map<String, ICommander> listaActions = new HashMap<String, ICommander>();

    //Chamada lista de actions
    static {
        listaActions.put("cadastrarUsuario", new CadastrarUsuario());
        listaActions.put("cadastrarEmpresa", new CadastrarEmpresa());
        listaActions.put("home", new Home());
        listaActions.put("loginUsuario", new LoginUsuario());
        listaActions.put("loginEmpresa", new LoginEmpresa());
        listaActions.put("logoutUsuario", new Logout());
        listaActions.put("salvarCurriculo", new SalvarCurriculo());
        listaActions.put("editarPerfil", new EditarPerfil());
        listaActions.put("cadastrarVaga", new CadastrarVaga());
        listaActions.put("pesquisarVaga", new PesquisarVaga());
        listaActions.put("detalheVaga", new DetalheVaga());
        listaActions.put("vagasCandidatadas", new VagasCandidatadas());
        listaActions.put("candidatarVaga", new CandidatarVaga());
        listaActions.put("minhasVagas", new MinhasVagas());
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String operacao = request.getParameter("op");
        if (operacao == null) {
            operacao = "home";
        }
        try {
            listaActions.get(operacao).execute(request, response);

        } catch (Exception ex) {
            Logger.getLogger(HomeCentral.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
