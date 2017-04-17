/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viniciuspeixoto
 */
public class CallpageAction implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        
        String pg = "";
        if (request.getParameter("page") != null){
            pg = "?page="+request.getParameter("page");
        }
        
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp"+pg);
    
        try {
            rd.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }
        
    }
    
}
