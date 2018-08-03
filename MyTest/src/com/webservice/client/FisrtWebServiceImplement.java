
package com.webservice.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FisrtWebServiceImplement", targetNamespace = "http://server.webservice.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FisrtWebServiceImplement {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAddressByPhoneNumber", targetNamespace = "http://server.webservice.com/", className = "com.webservice.server.GetAddressByPhoneNumber")
    @ResponseWrapper(localName = "getAddressByPhoneNumberResponse", targetNamespace = "http://server.webservice.com/", className = "com.webservice.server.GetAddressByPhoneNumberResponse")
    @Action(input = "http://server.webservice.com/FisrtWebServiceImplement/getAddressByPhoneNumberRequest", output = "http://server.webservice.com/FisrtWebServiceImplement/getAddressByPhoneNumberResponse")
    public String getAddressByPhoneNumber(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
