/**
 * StudentDaoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tranhoanglong;

public class StudentDaoServiceLocator extends org.apache.axis.client.Service implements tranhoanglong.StudentDaoService {

    public StudentDaoServiceLocator() {
    }


    public StudentDaoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentDaoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentDaoPort
    private java.lang.String StudentDaoPort_address = "http://localhost:44442/Student";

    public java.lang.String getStudentDaoPortAddress() {
        return StudentDaoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentDaoPortWSDDServiceName = "StudentDaoPort";

    public java.lang.String getStudentDaoPortWSDDServiceName() {
        return StudentDaoPortWSDDServiceName;
    }

    public void setStudentDaoPortWSDDServiceName(java.lang.String name) {
        StudentDaoPortWSDDServiceName = name;
    }

    public tranhoanglong.StudentDao getStudentDaoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentDaoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentDaoPort(endpoint);
    }

    public tranhoanglong.StudentDao getStudentDaoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tranhoanglong.StudentDaoPortBindingStub _stub = new tranhoanglong.StudentDaoPortBindingStub(portAddress, this);
            _stub.setPortName(getStudentDaoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentDaoPortEndpointAddress(java.lang.String address) {
        StudentDaoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tranhoanglong.StudentDao.class.isAssignableFrom(serviceEndpointInterface)) {
                tranhoanglong.StudentDaoPortBindingStub _stub = new tranhoanglong.StudentDaoPortBindingStub(new java.net.URL(StudentDaoPort_address), this);
                _stub.setPortName(getStudentDaoPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentDaoPort".equals(inputPortName)) {
            return getStudentDaoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("tranhoanglong", "StudentDaoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("tranhoanglong", "StudentDaoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentDaoPort".equals(portName)) {
            setStudentDaoPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
