
package org.donstu.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.donstu.client package. 
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

    private final static QName _GetMasters_QNAME = new QName("https://donstu.org/workshop", "getMasters");
    private final static QName _GetMastersResponse_QNAME = new QName("https://donstu.org/workshop", "getMastersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.donstu.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMastersResponse }
     * 
     */
    public GetMastersResponse createGetMastersResponse() {
        return new GetMastersResponse();
    }

    /**
     * Create an instance of {@link GetMasters }
     * 
     */
    public GetMasters createGetMasters() {
        return new GetMasters();
    }

    /**
     * Create an instance of {@link Master }
     * 
     */
    public Master createMaster() {
        return new Master();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMasters }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/workshop", name = "getMasters")
    public JAXBElement<GetMasters> createGetMasters(GetMasters value) {
        return new JAXBElement<GetMasters>(_GetMasters_QNAME, GetMasters.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMastersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/workshop", name = "getMastersResponse")
    public JAXBElement<GetMastersResponse> createGetMastersResponse(GetMastersResponse value) {
        return new JAXBElement<GetMastersResponse>(_GetMastersResponse_QNAME, GetMastersResponse.class, null, value);
    }

}
