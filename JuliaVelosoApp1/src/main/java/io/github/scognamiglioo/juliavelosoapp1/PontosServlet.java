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
@WebServlet(name = "PontosServlet", urlPatterns = {"/Pontos"})
public class PontosServlet extends HttpServlet {


    
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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

       

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultado da Distância</title>");
        out.println("<style>");
        out.println("body { background-color: #ffdde1; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        out.println(".result-container { background-color: #fff; padding: 30px; border-radius: 15px; box-shadow: 0 4px 10px rgba(0,0,0,0.2); text-align: center; width: 400px; }");
        out.println("h2 { color: #d63384; margin-bottom: 20px; }");
        out.println("p { font-size: 18px; color: #333; }");
        out.println("a { display: inline-block; margin-top: 20px; background-color: #d63384; color: white; text-decoration: none; padding: 10px 20px; border-radius: 10px; transition: 0.3s; }");
        out.println("a:hover { background-color: #b52d6f; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='result-container'>");

        try {
            double x1 = Double.parseDouble(request.getParameter("x1"));
            double y1 = Double.parseDouble(request.getParameter("y1"));
            double x2 = Double.parseDouble(request.getParameter("x2"));
            double y2 = Double.parseDouble(request.getParameter("y2"));

            Ponto p1 = new Ponto(x1, y1);
            Ponto p2 = new Ponto(x2, y2);
            
            double distancia = Distancia.calcular(p1, p2);

            out.println("<h2>Resultado</h2>");
            out.println("<p>A distância entre (" + x1 + ", " + y1 + ") e (" + x2 + ", " + y2 + ") é:</p>");
            out.println("<p><b>" + distancia + "</b></p>");
        } catch (NumberFormatException e) {
            out.println("<h2>Erro</h2>");
            out.println("<p>Por favor, insira valores numéricos válidos.</p>");
        }

        out.println("<a href='index.html'>Voltar</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
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
