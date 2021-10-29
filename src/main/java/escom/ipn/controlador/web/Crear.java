package escom.ipn.controlador.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.jdom.Document;
import org.jdom.Element;

public class Crear extends HttpServlet {   
    
    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 90 * 1024;
    private int maxMemSize = 9 * 1024;
    private File file ;
    private String[] extens = {".png", ".jpg", ".jpeg",};
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String drg1 = request.getParameter("drag1");
        String drg2 = request.getParameter("drag2");
        String drg3 = request.getParameter("drag3");
        String drg4 = request.getParameter("drag4");
        String targ1 = request.getParameter("target1");
        String targ2 = request.getParameter("target2");
        String targ3 = request.getParameter("target3");
        String targ4 = request.getParameter("target4");
        String nom = request.getParameter("txtNombre");
        String pre = request.getParameter("txtPregunta");
        String res = request.getParameter("txtRespuesta");
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
            //La ruta de nuestra proyecto
            filePath = request.getRealPath("/") + "/files/";
            //Nos regresaun falso o un verdadero
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            if (!isMultipart) {
                out.println("<title>Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 align='center'>Imagen no subida. Reintete</h1>");
                out.println("<p align='center'><a href='javascript: history.go(-1)' class='btnE'>Regresar</a></p>");
            }
            //Instaciamos un tipo de identificador del objeto
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Establecemos el tamaño maximo gracias al objeto
            factory.setSizeThreshold(maxMemSize);

            //AQUI SE DIRA DONDE SE GUARDARA 
            factory.setRepository(new File(filePath));

            //Instaciamos un objeto Factory llamado upload
            ServletFileUpload upload = new ServletFileUpload(factory);

            //Indicamos el tamaño maximo de los archivos
            upload.setSizeMax(maxFileSize);

            try {
                //Recuperamos toda la parte de nuestro formulario.
                List fileItems = upload.parseRequest(request);

                //Recorremos los items del archivo
                Iterator i = fileItems.iterator();
                
                out.println("<title>Ejercicio</title>");
                
                //Con el while vamos pasando por los items recuperados.
                //while solo se ocupa cuando no sabemos cuando terminar
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();

                        // Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                        } else {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                        }
                        fi.write(file);
                        out.println("Archivo subido: " + fileName + "<br />");
                    } else{
                    }
                }
                out.println("</body>");
                out.println("</html>");
            } catch (Exception ex) {
                out.println("Falle 10");
                System.out.println(ex);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}