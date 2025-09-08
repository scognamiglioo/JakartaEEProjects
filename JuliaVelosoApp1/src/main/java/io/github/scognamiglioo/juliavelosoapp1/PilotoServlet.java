
package io.github.scognamiglioo.juliavelosoapp1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author wonuc
 */
@WebServlet(name = "PilotoServlet", urlPatterns = {"/Piloto"})
public class PilotoServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");

        if (nome == null) {
            out.println("<h2>Erro</h2>");
            out.println("<p>Insira um piloto.</p>");
            return;
        }

        nome = nome.trim().toLowerCase();

        switch (nome) {
            case "denny hamlin":
                response.sendRedirect("dennyhamlin.html");
                break;
            case "ryan blaney":
                response.sendRedirect("ryanblaney.html");
                break;
            case "chase elliott":
                response.sendRedirect("chaseelliott.html");
                break;
            default:
                response.sendRedirect("aplicacao3.html");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
