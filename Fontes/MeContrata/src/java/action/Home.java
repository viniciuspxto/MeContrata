/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicius
 */
public class Home implements ICommander {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        RequestDispatcher rd = null;  
        rd = request.getRequestDispatcher("template.jsp?page=home");
        rd.forward(request, response);
        
    }
    
}
