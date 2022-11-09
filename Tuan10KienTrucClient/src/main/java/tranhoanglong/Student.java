/**
 * Student.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tranhoanglong;

public class Student  implements java.io.Serializable {
    private java.lang.String diachi;

    private java.lang.String ma;

    private java.lang.String sdt;

    private java.lang.String ten;

    public Student() {
    }

    public Student(
           java.lang.String diachi,
           java.lang.String ma,
           java.lang.String sdt,
           java.lang.String ten) {
           this.diachi = diachi;
           this.ma = ma;
           this.sdt = sdt;
           this.ten = ten;
    }


    /**
     * Gets the diachi value for this Student.
     * 
     * @return diachi
     */
    public java.lang.String getDiachi() {
        return diachi;
    }


    /**
     * Sets the diachi value for this Student.
     * 
     * @param diachi
     */
    public void setDiachi(java.lang.String diachi) {
        this.diachi = diachi;
    }


    /**
     * Gets the ma value for this Student.
     * 
     * @return ma
     */
    public java.lang.String getMa() {
        return ma;
    }


    /**
     * Sets the ma value for this Student.
     * 
     * @param ma
     */
    public void setMa(java.lang.String ma) {
        this.ma = ma;
    }


    /**
     * Gets the sdt value for this Student.
     * 
     * @return sdt
     */
    public java.lang.String getSdt() {
        return sdt;
    }


    /**
     * Sets the sdt value for this Student.
     * 
     * @param sdt
     */
    public void setSdt(java.lang.String sdt) {
        this.sdt = sdt;
    }


    /**
     * Gets the ten value for this Student.
     * 
     * @return ten
     */
    public java.lang.String getTen() {
        return ten;
    }


    /**
     * Sets the ten value for this Student.
     * 
     * @param ten
     */
    public void setTen(java.lang.String ten) {
        this.ten = ten;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.diachi==null && other.getDiachi()==null) || 
             (this.diachi!=null &&
              this.diachi.equals(other.getDiachi()))) &&
            ((this.ma==null && other.getMa()==null) || 
             (this.ma!=null &&
              this.ma.equals(other.getMa()))) &&
            ((this.sdt==null && other.getSdt()==null) || 
             (this.sdt!=null &&
              this.sdt.equals(other.getSdt()))) &&
            ((this.ten==null && other.getTen()==null) || 
             (this.ten!=null &&
              this.ten.equals(other.getTen())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDiachi() != null) {
            _hashCode += getDiachi().hashCode();
        }
        if (getMa() != null) {
            _hashCode += getMa().hashCode();
        }
        if (getSdt() != null) {
            _hashCode += getSdt().hashCode();
        }
        if (getTen() != null) {
            _hashCode += getTen().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Student.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("tranhoanglong", "student"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diachi");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diachi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ma");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ma"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sdt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sdt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ten");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ten"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
