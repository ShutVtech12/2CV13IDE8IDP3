package escom.ipn.controlador.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class Leer extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta=request.getRealPath("/");                
	  SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File(ruta+"preguntas.xml");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletREADXML</title>");            
            out.println("</head>");
            out.println("<body>");
	  try {
		Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
                out.println("Valor <br />");
		List list = rootNode.getChildren("pregunta");             
		for (int i = 0; i < list.size(); i++) 
                {
                    out.println("Opciones <br />");
                    Element node = (Element) list.get(i);
                    out.println("Pregunta: " + node.getAttributeValue("texto")+"<br />");
                    out.println("Respuesta: " + node.getAttributeValue("respuesta")+"<br />");
                    out.println("Texto1: " + node.getChildText("opciones")+"<br />");
                    List list2 = (List) node.getChild("opciones");
                    out.println("Tamaño: " + list2.size()+"<br />");
                    for(int j=0; j<list2.size();j++){
                        out.println("Opciones de opciones <br />");
                        Element node2 = (Element) list2.get(j);
                        out.println("Imagen: " + node2.getAttributeValue("Imagen")+"<br />");
                        out.println("Texto2: " + node2.getChildText("opcion")+"<br />");
                    }
//		   out.println("Nombre: " + node.getChildText("nombre")+"<br />");
//		   out.println("Apellido : " + node.getChildText("apellido")+"<br />");                                   
		}
            out.println("</body>");
            out.println("</html>");     

	  } 
          catch (IOException | JDOMException io) 
          {
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
