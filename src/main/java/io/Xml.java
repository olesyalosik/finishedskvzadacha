package io;

import domain.DataSource;
import models.Expression;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class Xml implements DataSource {
    public List<Expression> readData(String path) {
        List<Expression> result = new ArrayList<>();
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(path));
            boolean exp = false;
            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();
                String expression;
                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName == "expression") {
                            exp = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (exp) {
                            Characters characters = event.asCharacters();
                            expression = characters.getData();
                            result.add(new Expression(expression));
                            exp = false;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return result;

    }

    public void writeData(List<Expression> data, String path) {
        try {
            StringWriter stringWriter = new StringWriter();

            XMLOutputFactory xMLOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xMLStreamWriter =
                    xMLOutputFactory.createXMLStreamWriter(stringWriter);

            xMLStreamWriter.writeStartDocument();
            xMLStreamWriter.writeStartElement("expressions");

            for (Expression exp : data) {
                xMLStreamWriter.writeStartElement("expression");
                xMLStreamWriter.writeCharacters(exp.getResult());
                xMLStreamWriter.writeEndElement();
            }

            xMLStreamWriter.writeEndElement();
            xMLStreamWriter.writeEndDocument();
            xMLStreamWriter.flush();
            xMLStreamWriter.close();
            String xmlString = stringWriter.getBuffer().toString();

            stringWriter.close();
            FileWriter writer = new FileWriter(path);
            writer.write(xmlString);
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
