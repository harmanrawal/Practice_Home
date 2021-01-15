import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XSDValidator {
   public static void main(String[] args) {
     
         boolean isValid = validateXMLSchema("D:\\XSDSchema\\22-Nov-2019\\INTF_1.xsd","D:\\\\XSDSchema\\22-Nov-2019\\INTF_1.xml");
         
         if(isValid){
            System.out.println(" is valid against ");
         } else {
            System.out.println(" is not valid against ");
         }
      
   }
   
   public static boolean validateXMLSchema(String xsdPath, String xmlPath){
      try {
         SchemaFactory factory =
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("D:\\XSDSchema\\22-Nov-2019\\INTF_1.xsd"));
            Validator validator = schema.newValidator();
            System.out.println("Yup Here");
            validator.validate(new StreamSource(new File("D:\\XSDSchema\\22-Nov-2019\\INTF_1.xml")));
      } catch (IOException e){
         System.out.println("Exception: "+e.getMessage());
         return false;
      }catch(SAXException e1){
         //System.out.println("SAX Exception: "+e1.getMessage());
         e1.printStackTrace();
         return false;
      }
		
      return true;
	
   }
}