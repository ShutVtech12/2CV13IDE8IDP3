/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escom.ipn.controlador.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;


public class DActualizar extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ruta=request.getRealPath("/");
        int id = Integer.parseInt(request.getParameter("idP"));
        int idI; 
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(ruta+"preguntas.xml");
        response.setContentType("text/html;charset=UTF-8");
        //String idP= request.getParameter("idP");
        String nomPregunta = request.getParameter("txtNombre");
        String textoPregunta = request.getParameter("txtPregunta");
        String respuestaPregunta = request.getParameter("txtRespuesta");
        String opcionA = request.getParameter("txtOpc1");
        String opcionB = request.getParameter("txtOpc2");
        String opcionC = request.getParameter("txtOpc3");
        String opcionD = request.getParameter("txtOpc4");
        String drg1 = request.getParameter("drag1");
        String drg2 = request.getParameter("drag2");
        String drg3 = request.getParameter("drag3");
        String drg4 = request.getParameter("drag4");
        String opcionTA = request.getParameter("txtOpc5");
        String opcionTB = request.getParameter("txtOpc6");
        String opcionTC = request.getParameter("txtOpc7");
        String opcionTD = request.getParameter("txtOpc8");
        String targ1 = request.getParameter("target1");
        String targ2 = request.getParameter("target2");
        String targ3 = request.getParameter("target3");
        String targ4 = request.getParameter("target4");
        
        
                PrintWriter out = response.getWriter();
                
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>DActualizar</title>");   
                out.println("<link href='style.css' rel='stylesheet' type='text/css'/>");
                out.println("</head>");
                out.println("<body>");
                
                try{

                    Document doc = (Document) builder.build(xmlFile);
                    Element rootNode = doc.getRootElement();
                    
                    //Element pregunta = rootNode.getChild("pregunta");
                    List idPregunta= rootNode.getChildren("pregunta");
                    
                    for(int z=0;z<idPregunta.size();z++){
                        Element pre = (Element) idPregunta.get(z);
                        List opc = pre.getChildren("opciones");
                        List tar = pre.getChildren("targets");
                        idI = Integer.parseInt(pre.getAttributeValue("id"));
                        if(id==idI){
                            //out.println("<h1 align='center'>"+pre.getAttributeValue("id")+"</h1>");
                            pre.getAttribute("texto").setValue(textoPregunta);
                            pre.getAttribute("respuesta").setValue(respuestaPregunta);
                            Element nombreP = pre.getChild("nombre");
                            nombreP.setText(nomPregunta);
                            
                            for(int i=0;i<opc.size();i++){

                                Element node1 = (Element) opc.get(i);
                                Element node2 = (Element) tar.get(i);

                                //node1.setText();
                                Element op1 = node1.getChild("opcion1");
                                op1.setText(opcionA);
                                Element op2 = node1.getChild("opcion2");
                                op2.setText(opcionB);
                                Element op3 = node1.getChild("opcion3");
                                op3.setText(opcionC);
                                Element op4 = node1.getChild("opcion4");
                                op4.setText(opcionD);
                                
                                
                                Element opT1 = node2.getChild("opcion1");
                                opT1.setText(opcionTA);
                                Element opT2 = node2.getChild("opcion2");
                                opT2.setText(opcionTB);
                                Element opT3 = node2.getChild("opcion3");
                                opT3.setText(opcionTC);
                                Element opT4 = node2.getChild("opcion4");
                                opT4.setText(opcionTD);
//                                node1.setText(opcionA);
//                                node1.setText(opcionB);
//                                node1.setText(opcionC);
//                                node1.setText(opcionD);
                                
//                                node2.setText(opcionTA);
//                                node2.setText(opcionTB);
//                                node2.setText(opcionTC);
//                                node2.setText(opcionTD);
                            }    
                        
                            XMLOutputter xmlOutput = new XMLOutputter();

                            xmlOutput.setFormat(Format.getPrettyFormat());
                            FileWriter writer = new FileWriter(ruta+"preguntas.xml");                
                            xmlOutput.output(doc, writer);
                            writer.flush();
                            writer.close();  
                        
                        }
                    
                    }
                    
                    
                }
                catch(IOException e){
                    e.printStackTrace();
                } catch (JDOMException ex) {
                ex.printStackTrace();
            }
                
                
                //out.println("<h1 align='center'>"+respuestaPregunta+"</h1>");
                out.println("<h1 align='center'>Se Actualizo Correctamente</h1>");
                out.println("<p align='center'><a href='MenuCRUD' class='btnE'>Regresar</a></p>");
                out.println("</body>");
                out.println("</html>");
                
            
        
        
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
