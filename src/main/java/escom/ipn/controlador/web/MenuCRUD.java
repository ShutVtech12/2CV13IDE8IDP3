package escom.ipn.controlador.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MenuCRUD extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenido</title>");
            out.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Crear, Altas, Bajas y Cambios</h1>");
            out.println("");
            out.println("<ul>");
            out.println("<li><a href='crear'>Crear Nueva Pregunta</a></li>");
            out.println("</ul>");
            out.println("<div>");
            out.println("<table>");
            out.println("<thead>");
            out.println("<th>Nombre de la Pregunta</th>");
            out.println("<th>Acciones</th>");
            out.println("</thead>");
            out.println("<tr>");
            out.println("<td>Raza</td>");
            out.println("<td>Jack Russell</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
