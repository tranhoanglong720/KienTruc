package tranhoanglong;

public class StudentDaoProxy implements tranhoanglong.StudentDao {
  private String _endpoint = null;
  private tranhoanglong.StudentDao studentDao = null;
  
  public StudentDaoProxy() {
    _initStudentDaoProxy();
  }
  
  public StudentDaoProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentDaoProxy();
  }
  
  private void _initStudentDaoProxy() {
    try {
      studentDao = (new tranhoanglong.StudentDaoServiceLocator()).getStudentDaoPort();
      if (studentDao != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentDao)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentDao)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentDao != null)
      ((javax.xml.rpc.Stub)studentDao)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public tranhoanglong.StudentDao getStudentDao() {
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao;
  }
  
  public boolean createSt(tranhoanglong.Student arg0) throws java.rmi.RemoteException{
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao.createSt(arg0);
  }
  
  public tranhoanglong.Student getStudenById(java.lang.String arg0) throws java.rmi.RemoteException{
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao.getStudenById(arg0);
  }
  
  public tranhoanglong.Student[] getListST() throws java.rmi.RemoteException{
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao.getListST();
  }
  
  public boolean updateSTID(java.lang.String arg0, tranhoanglong.Student arg1) throws java.rmi.RemoteException{
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao.updateSTID(arg0, arg1);
  }
  
  public boolean luuFile(java.lang.Object arg0, java.lang.String arg1) throws java.rmi.RemoteException, tranhoanglong.FileNotFoundException, tranhoanglong.IOException{
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao.luuFile(arg0, arg1);
  }
  
  public boolean deleteSt(java.lang.String arg0) throws java.rmi.RemoteException{
    if (studentDao == null)
      _initStudentDaoProxy();
    return studentDao.deleteSt(arg0);
  }
  
  
}