package com.example.app.model.parsers;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class XMLParser {
    private JAXBContext jaxbContext;

    public XMLParser() {
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> clazz, String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
        T object = null;
        try(
                InputStream inputStream = this.getClass().getResourceAsStream(path)

                ) {
            object = (T) unmarshaller.unmarshal(inputStream);
        }
        return object;
    }

    public <T> void writeObject(T obj,String path) throws JAXBException, IOException {
        this.jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        try (
                OutputStream outputStream = new FileOutputStream(path)
                ){
            marshaller.marshal(obj,outputStream);
        }
    }
}
