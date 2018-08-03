
package com.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservice.server package. 
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

    private final static QName _GetAddressByPhoneNumber_QNAME = new QName("http://server.webservice.com/", "getAddressByPhoneNumber");
    private final static QName _GetAddressByPhoneNumberResponse_QNAME = new QName("http://server.webservice.com/", "getAddressByPhoneNumberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservice.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAddressByPhoneNumberResponse }
     * 
     */
    public GetAddressByPhoneNumberResponse createGetAddressByPhoneNumberResponse() {
        return new GetAddressByPhoneNumberResponse();
    }

    /**
     * Create an instance of {@link GetAddressByPhoneNumber }
     * 
     */
    public GetAddressByPhoneNumber createGetAddressByPhoneNumber() {
        return new GetAddressByPhoneNumber();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressByPhoneNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.com/", name = "getAddressByPhoneNumber")
    public JAXBElement<GetAddressByPhoneNumber> createGetAddressByPhoneNumber(GetAddressByPhoneNumber value) {
        return new JAXBElement<GetAddressByPhoneNumber>(_GetAddressByPhoneNumber_QNAME, GetAddressByPhoneNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressByPhoneNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.webservice.com/", name = "getAddressByPhoneNumberResponse")
    public JAXBElement<GetAddressByPhoneNumberResponse> createGetAddressByPhoneNumberResponse(GetAddressByPhoneNumberResponse value) {
        return new JAXBElement<GetAddressByPhoneNumberResponse>(_GetAddressByPhoneNumberResponse_QNAME, GetAddressByPhoneNumberResponse.class, null, value);
    }

}
