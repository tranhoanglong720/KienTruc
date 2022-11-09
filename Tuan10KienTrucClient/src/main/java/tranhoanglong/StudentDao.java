/**
 * StudentDao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tranhoanglong;

public interface StudentDao extends java.rmi.Remote {
    public boolean createSt(tranhoanglong.Student arg0) throws java.rmi.RemoteException;
    public tranhoanglong.Student getStudenById(java.lang.String arg0) throws java.rmi.RemoteException;
    public tranhoanglong.Student[] getListST() throws java.rmi.RemoteException;
    public boolean updateSTID(java.lang.String arg0, tranhoanglong.Student arg1) throws java.rmi.RemoteException;
    public boolean luuFile(java.lang.Object arg0, java.lang.String arg1) throws java.rmi.RemoteException, tranhoanglong.FileNotFoundException, tranhoanglong.IOException;
    public boolean deleteSt(java.lang.String arg0) throws java.rmi.RemoteException;
}
