
package start;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the start package. 
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

    private final static QName _GetNumberResponse_QNAME = new QName("http://start/", "getNumberResponse");
    private final static QName _GetNumber_QNAME = new QName("http://start/", "getNumber");
    private final static QName _GetList_QNAME = new QName("http://start/", "getList");
    private final static QName _GetListResponse_QNAME = new QName("http://start/", "getListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: start
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetNumber }
     * 
     */
    public GetNumber createGetNumber() {
        return new GetNumber();
    }

    /**
     * Create an instance of {@link GetList }
     * 
     */
    public GetList createGetList() {
        return new GetList();
    }

    /**
     * Create an instance of {@link GetListResponse }
     * 
     */
    public GetListResponse createGetListResponse() {
        return new GetListResponse();
    }

    /**
     * Create an instance of {@link GetNumberResponse }
     * 
     */
    public GetNumberResponse createGetNumberResponse() {
        return new GetNumberResponse();
    }

    /**
     * Create an instance of {@link Place }
     * 
     */
    public Place createPlace() {
        return new Place();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://start/", name = "getNumberResponse")
    public JAXBElement<GetNumberResponse> createGetNumberResponse(GetNumberResponse value) {
        return new JAXBElement<GetNumberResponse>(_GetNumberResponse_QNAME, GetNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://start/", name = "getNumber")
    public JAXBElement<GetNumber> createGetNumber(GetNumber value) {
        return new JAXBElement<GetNumber>(_GetNumber_QNAME, GetNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://start/", name = "getList")
    public JAXBElement<GetList> createGetList(GetList value) {
        return new JAXBElement<GetList>(_GetList_QNAME, GetList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://start/", name = "getListResponse")
    public JAXBElement<GetListResponse> createGetListResponse(GetListResponse value) {
        return new JAXBElement<GetListResponse>(_GetListResponse_QNAME, GetListResponse.class, null, value);
    }

}
