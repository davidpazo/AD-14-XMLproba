package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * ** @author oracle *****
 */
public class XMLproba {
    String ruta=("/home/oracle/Desktop/Pruebas/autores.xml");

    public static void main(String[] args) {
        XMLproba xp = new XMLproba();
        xp.Escribir();
        xp.Leer();
    }

    public void Escribir() {
        try {
            
            XMLStreamWriter xmls = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new FileOutputStream(ruta));

            
            xmls.writeStartDocument("1.0");
            xmls.writeStartElement("autores");
            xmls.writeStartElement("autor");
            xmls.writeAttribute("codigo", "a1");
            xmls.writeStartElement("nome");
            xmls.writeCharacters("Alexandre Dumas");
            xmls.writeEndElement();
            xmls.writeStartElement("titulo");
            xmls.writeCharacters("El conde de montecristo");
            xmls.writeEndElement();
            xmls.writeStartElement("titulo");
            xmls.writeCharacters("Los miserables");
            xmls.writeEndElement();
            xmls.writeEndElement();
            xmls.writeStartElement("autor");
            xmls.writeAttribute("codigo", "a2");
            xmls.writeStartElement("nome");
            xmls.writeCharacters("Fiodor Dostoyevski");
            xmls.writeEndElement();
            xmls.writeStartElement("titulo");
            xmls.writeCharacters(" El idiota");
            xmls.writeEndElement();
            xmls.writeStartElement("titulo");
            xmls.writeCharacters("Noches blancas");
            xmls.writeEndDocument();
            xmls.flush();
            xmls.close();
        } catch (XMLStreamException | FileNotFoundException ex) {
            System.out.println("Excepcion de Streaming,\nFichero no encontrado");
        }
    }

    public void Leer() {
        try {

            XMLEventReader xml = XMLInputFactory.newInstance().createXMLEventReader(ruta,
                    new FileInputStream(ruta));
            while (xml.hasNext()) {
                System.out.println(xml.nextEvent().toString());
            }
            xml.close();

        } catch (XMLStreamException | FileNotFoundException ex) {
            System.out.println("Excepcion de Streaming, \nFichero no encontrado");        }

    }

}


