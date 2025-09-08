package io.github.scognamiglioo.juliavelosoapp1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculadoraServlet", urlPatterns = {"/calculadora"})
public class CalculadoraServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Resultados</title>");
        out.println("<style>");
        out.println("body { background-color: #ffdde1; font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
        out.println(".result-container { background-color: #fff; padding: 30px; border-radius: 15px; box-shadow: 0 4px 10px rgba(0,0,0,0.2); text-align: center; width: 400px; }");
        out.println("h2 { color: #d63384; margin-bottom: 20px; }");
        out.println("p { font-size: 18px; margin: 8px 0; color: #333; }");
        out.println("a { display: inline-block; margin-top: 20px; background-color: #d63384; color: white; text-decoration: none; padding: 10px 20px; border-radius: 10px; transition: 0.3s; }");
        out.println("a:hover { background-color: #b52d6f; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='result-container'>");
        out.println("<h2>Resultados</h2>");

        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));

        try {
           
            Calculadora calc = new Calculadora(a, b);

            out.println("<p>" + a + " + " + b + " = <b>" + calc.somar() + "</b></p>");
            out.println("<p>" + a + " - " + b + " = <b>" + calc.subtrair() + "</b></p>");
            out.println("<p>" + a + " * " + b + " = <b>" + calc.multiplicar() + "</b></p>");
            try {
                out.println("<p>" + a + " / " + b + " = <b>" + calc.dividir() + "</b></p>");
            } catch (ArithmeticException e) {
                out.println("<p><b>Erro na divisão:</b> " + e.getMessage() + "</p>");
            }

        } catch (NumberFormatException e) {
            out.println("<p>Os valores devem ser numéricos!</p>");
        } catch (IllegalArgumentException e) {
            out.println("<p><b>Erro:</b> " + e.getMessage() + "</p>");
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
