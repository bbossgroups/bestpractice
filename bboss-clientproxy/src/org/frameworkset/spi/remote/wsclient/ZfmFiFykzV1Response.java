
package org.frameworkset.spi.remote.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fi00O06" type="{urn:sap-com:document:sap:soap:functions:mc-style}TableOfZstFykz"/>
 *         &lt;element name="OFuncArea" type="{urn:sap-com:document:sap:rfc:functions}char16"/>
 *         &lt;element name="OPstngDate" type="{urn:sap-com:document:sap:rfc:functions}date"/>
 *         &lt;element name="OTxtlg" type="{urn:sap-com:document:sap:rfc:functions}char60"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fi00O06",
    "oFuncArea",
    "oPstngDate",
    "oTxtlg"
})
@XmlRootElement(name = "ZfmFiFykzV1Response")
public class ZfmFiFykzV1Response {

    @XmlElement(name = "Fi00O06", required = true)
    protected TableOfZstFykz fi00O06;
    @XmlElement(name = "OFuncArea", required = true)
    protected String oFuncArea;
    @XmlElement(name = "OPstngDate", required = true)
    protected String oPstngDate;
    @XmlElement(name = "OTxtlg", required = true)
    protected String oTxtlg;

    /**
     * ��ȡfi00O06���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TableOfZstFykz }
     *     
     */
    public TableOfZstFykz getFi00O06() {
        return fi00O06;
    }

    /**
     * ����fi00O06���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TableOfZstFykz }
     *     
     */
    public void setFi00O06(TableOfZstFykz value) {
        this.fi00O06 = value;
    }

    /**
     * ��ȡoFuncArea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFuncArea() {
        return oFuncArea;
    }

    /**
     * ����oFuncArea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFuncArea(String value) {
        this.oFuncArea = value;
    }

    /**
     * ��ȡoPstngDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPstngDate() {
        return oPstngDate;
    }

    /**
     * ����oPstngDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPstngDate(String value) {
        this.oPstngDate = value;
    }

    /**
     * ��ȡoTxtlg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTxtlg() {
        return oTxtlg;
    }

    /**
     * ����oTxtlg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTxtlg(String value) {
        this.oTxtlg = value;
    }

}
