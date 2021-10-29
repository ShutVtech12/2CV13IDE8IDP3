package escom.ipn.controlador.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Eliminar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String filePath = request.getRealPath("/") + "/files/";

            /*File archivo = new File(filePath + "Figura27.JPG");

            boolean estatus = archivo.delete();

            if (!estatus) {

                System.out.println("Error no se ha podido eliminar el  archivo");

            } else {

                System.out.println("Se ha eliminado el archivo exitosamente");

            } */
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CUIDADO</title>");
            out.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align='center'>Este es un ejercicio</h1>");
            out.println("<p align='center'><a href='javascript: history.go(-1)' class='btnE'>Regresar</a></p>");
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
