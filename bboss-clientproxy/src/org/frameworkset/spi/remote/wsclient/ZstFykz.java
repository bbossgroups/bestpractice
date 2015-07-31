
package org.frameworkset.spi.remote.wsclient;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ZstFykz complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ZstFykz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GlAccount" type="{urn:sap-com:document:sap:rfc:functions}char10"/>
 *         &lt;element name="Txtsh" type="{urn:sap-com:document:sap:rfc:functions}char60"/>
 *         &lt;element name="DebCreLc" type="{urn:sap-com:document:sap:rfc:functions}curr17.2"/>
 *         &lt;element name="LocCurrcy" type="{urn:sap-com:document:sap:rfc:functions}cuky5"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZstFykz", propOrder = {
    "glAccount",
    "txtsh",
    "debCreLc",
    "locCurrcy"
})
public class ZstFykz {

    @XmlElement(name = "GlAccount", required = true)
    protected String glAccount;
    @XmlElement(name = "Txtsh", required = true)
    protected String txtsh;
    @XmlElement(name = "DebCreLc", required = true)
    protected BigDecimal debCreLc;
    @XmlElement(name = "LocCurrcy", required = true)
    protected String locCurrcy;

    /**
     * ��ȡglAccount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlAccount() {
        return glAccount;
    }

    /**
     * ����glAccount���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlAccount(String value) {
        this.glAccount = value;
    }

    /**
     * ��ȡtxtsh���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxtsh() {
        return txtsh;
    }

    /**
     * ����txtsh���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxtsh(String value) {
        this.txtsh = value;
    }

    /**
     * ��ȡdebCreLc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebCreLc() {
        return debCreLc;
    }

    /**
     * ����debCreLc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebCreLc(BigDecimal value) {
        this.debCreLc = value;
    }

    /**
     * ��ȡlocCurrcy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocCurrcy() {
        return locCurrcy;
    }

    /**
     * ����locCurrcy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocCurrcy(String value) {
        this.locCurrcy = value;
    }

}
