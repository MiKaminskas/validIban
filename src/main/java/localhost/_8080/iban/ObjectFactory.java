//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.06 at 08:52:04 PM EET 
//


package localhost._8080.iban;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the localhost._8080.iban package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: localhost._8080.iban
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIbanDetailsResponse }
     * 
     */
    public GetIbanDetailsResponse createGetIbanDetailsResponse() {
        return new GetIbanDetailsResponse();
    }

    /**
     * Create an instance of {@link Iban }
     * 
     */
    public Iban createIban() {
        return new Iban();
    }

    /**
     * Create an instance of {@link GetIbanDetailsRequest }
     * 
     */
    public GetIbanDetailsRequest createGetIbanDetailsRequest() {
        return new GetIbanDetailsRequest();
    }

}
