package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class TesteValidacao {
	
	public static void main(String[] args)
				throws JAXBException, SAXException, IOException {
		
		Livro livro = new Livro();
		livro.setCodigo("arq"); //codigo deve ser maiúsculo
		
		SchemaFactory sf = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("schema.xsd"));
		
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ValidationHandler());
		validator.validate(new StreamSource(new File("livro.xml")));
	}

}
