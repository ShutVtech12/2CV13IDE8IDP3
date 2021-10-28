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
            String[] prueba={"Ejercicio 1", "Ejercicio 2", "Ejercicio 3"};
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenido</title>");
            out.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Crear, Altas, Bajas y Cambios</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Ejercicios</th>");
            out.println("<th>Acciones</th>");
            out.println("</tr>");
            for (String prueba1 : prueba) {
                out.println("<tr>");
                out.println("<td>");
                out.println(prueba1);
                out.println("</td>");
                out.println("<td>");
                out.println("<a href='Leer' class='btnV'>Mostrar Ejercicio</a>");
                out.println("<a href='Actualizar' class='btnM'>Modificar Ejercicio</a>");
                out.println("<a href='Eliminar' class='btnEli'>Eliminar Ejercicio</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("<p align='center'><a href='Crear' class='btnE'>Crear Nueva Pregunta</a></p>");
            out.println("<p align='center'><a href='"+request.getContextPath()+"' class='btnE'>Voler al menu principal</a></p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
