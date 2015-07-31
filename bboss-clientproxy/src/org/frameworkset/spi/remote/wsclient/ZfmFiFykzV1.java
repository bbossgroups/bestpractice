
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
 *         &lt;element name="IFuncArea" type="{urn:sap-com:document:sap:rfc:functions}char16"/>
 *         &lt;element name="IPstngDate" type="{urn:sap-com:document:sap:rfc:functions}date"/>
 *         &lt;element name="ITxtlg" type="{urn:sap-com:document:sap:rfc:functions}char60"/>
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
    "iFuncArea",
    "iPstngDate",
    "iTxtlg"
})
@XmlRootElement(name = "ZfmFiFykzV1")
public class ZfmFiFykzV1 {

    @XmlElement(name = "Fi00O06", required = true)
    protected TableOfZstFykz fi00O06;
    @XmlElement(name = "IFuncArea", required = true)
    protected String iFuncArea;
    @XmlElement(name = "IPstngDate", required = true)
    protected String iPstngDate;
    @XmlElement(name = "ITxtlg", required = true)
    protected String iTxtlg;

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
     * ��ȡiFuncArea���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIFuncArea() {
        return iFuncArea;
    }

    /**
     * ����iFuncArea���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIFuncArea(String value) {
        this.iFuncArea = value;
    }

    /**
     * ��ȡiPstngDate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPstngDate() {
        return iPstngDate;
    }

    /**
     * ����iPstngDate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPstngDate(String value) {
        this.iPstngDate = value;
    }

    /**
     * ��ȡiTxtlg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getITxtlg() {
        return iTxtlg;
    }

    /**
     * ����iTxtlg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setITxtlg(String value) {
        this.iTxtlg = value;
    }

}
