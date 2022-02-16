import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tiempo {
    public static void main (String[]args){

        try {
            SAXBuilder builder = new SAXBuilder();
            File xml = new File("Concesionario.xml");
            Document document = builder.build (new StringReader(xml));
            Element root = document.getRootElements();

            List<Element> list = root.getChildren("coches");

            System.out.println("Matricula\tMarca\tPrecio");

            for (int i = 0; i < list.size(); i++) {

                Element coche = list.get(i);

                List<Element> valores_coche = coche.getChildren();

                for (int j = 0; j < valores_coche.size(); j++) {

                    Element campo = valores_coche.get(j);

                    String matricula = campo.getAttributeValue("matricula");
                    String marca = campo.getChildTextTrim("marca");
                    String precio = campo.getChildTextTrim("precio");

                    System.out.println(matricula + "\t\t" + marca + "\t" + precio);

                }
            }

        } catch (JDOMException | IOException ex) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}




       /* try {
           Connection tiempo = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c");
           tiempo.timeout(1000)
                   .method(Connection.Method.GET)
                   .userAgent("Mozilla/5.0")
                   .execute();

           Document getTiempo = tiempo.get();
           System.out.println(getTiempo.getElementsByClass("CurrentConditions--columns--3KgfN"));

       }
       catch(Exception exception){
           System.exit(0);
       }*/


