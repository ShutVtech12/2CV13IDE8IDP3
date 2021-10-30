package escom.ipn.controlador.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Actualizar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = request.getRealPath("/");
        int id = Integer.parseInt(request.getParameter("id"));
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(ruta + "preguntas.xml");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Ver Ejercicio</title>");
        out.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
        out.println("</head>");
        out.println("<h3 align='center'>Ejercicio Numero "+id+"</h3>");
        out.println("<body>");
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            Element node = rootNode.getChild("pregunta");
            out.println("<form name='frmDatos' class='formchic formbasic' enctype='multipart/form-data'>");
            out.println("<div>");
            out.println("<input type='text' name='txtNombre' value='" + node.getChildText("nombre") + "' required='required'>");
            out.println("</div>");
            out.println("<div>");
            out.println("<input type='text' name='txtPregunta' value='" + node.getAttributeValue("texto") + "' required='required'>");
            out.println("</div>");
            out.println("<div>");
            out.println("<input type='text' name='txtRespuesta' value='" + node.getAttributeValue("respuesta") + "' required='required'>");
            out.println("</div>");
//                out.println("<div class='izquierda'>");
//                out.println("<label for='drag1' class='textex'>Drog opci&oacute;n 1</label>");
//                out.println("<input type='text' name='txtOpc1' placeholder='Opcion Columna 1' required='required'>");
//                out.println("<input type = 'file' name = 'drag1' id='drag1' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='derecha'>");
//                out.println("<label for='target1' class='textex'>Target opci&oacute;n 1</label>");
//                out.println("<input type='text' name='txtOpc5' placeholder='Opcion Columna 5' required='required'>");
//                out.println("<input type = 'file' name = 'target1' id='target1' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='izquierda'>");
//                out.println("<label for='drag2' class='textex'>Drog opci&oacute;n 2</label>");
//                out.println("<input type='text' name='txtOpc2' placeholder='Opcion Columna 2' required='required'>");
//                out.println("<input type = 'file' name = 'drag2' id='drag2' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='derecha'>");
//                out.println("<label for='target2' class='textex'>Target opci&oacute;n 2</label>");
//                out.println("<input type='text' name='txtOpc6' placeholder='Opcion Columna 6' required='required'>");
//                out.println("<input type = 'file' name = 'target2' id='target2' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='izquierda'>");
//                out.println("<label for='drag3' class='textex'>Drog opci&oacute;n 3</label>");
//                out.println("<input type='text' name='txtOpc3' placeholder='Opcion Columna 3' required='required'>");
//                out.println("<input type = 'file' name = 'drag3' id='drag3' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='derecha'>");
//                out.println("<label for='target3' class='textex'>Target opci&oacute;n 3</label>");
//                out.println("<input type='text' name='txtOpc7' placeholder='Opcion Columna 7' required='required'>");
//                out.println("<input type = 'file' name = 'target3' id='target3' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='izquierda'>");
//                out.println("<label for='drag4' class='textex'>Drog opci&oacute;n 4</label>");
//                out.println("<input type='text' name='txtOpc4' placeholder='Opcion Columna 4' required='required'>");
//                out.println("<input type = 'file' name = 'drag4' id='drag4' size = '90' required='required'/>");
//                out.println("</div>");
//                out.println("<div class='derecha'>");
//                out.println("<label for='target4' class='textex'>Target opci&oacute;n 4</label>");
//                out.println("<input type='text' name='txtOpc8' placeholder='Opcion Columna 8' required='required'>");
//                out.println("<input type = 'file' name = 'target4' id='target4' size = '90' required='required'/>");
//                out.println("</div>");
            out.println("<div align='center'>");
            out.println("<p><a class='btnE' aria-current='page' href='MenuCRUD'>Regresar</a></p>");
            out.println("</div>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        } catch (IOException | JDOMException io) {
            System.out.println(io.getMessage());
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