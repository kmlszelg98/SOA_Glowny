
package start;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for place complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="place">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idTable" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="strefa" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="time" type="{http://start/}timestamp" minOccurs="0"/>
 *         &lt;element name="wolne" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "place", propOrder = {
    "id",
    "idTable",
    "strefa",
    "time",
    "wolne"
})
public class Place {

    protected Integer id;
    protected int idTable;
    protected Integer strefa;
    protected Timestamp time;
    protected String wolne;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the idTable property.
     * 
     */
    public int getIdTable() {
        return idTable;
    }

    /**
     * Sets the value of the idTable property.
     * 
     */
    public void setIdTable(int value) {
        this.idTable = value;
    }

    /**
     * Gets the value of the strefa property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStrefa() {
        return strefa;
    }

    /**
     * Sets the value of the strefa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStrefa(Integer value) {
        this.strefa = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link Timestamp }
     *     
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link Timestamp }
     *     
     */
    public void setTime(Timestamp value) {
        this.time = value;
    }

    /**
     * Gets the value of the wolne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWolne() {
        return wolne;
    }

    /**
     * Sets the value of the wolne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWolne(String value) {
        this.wolne = value;
    }

}
