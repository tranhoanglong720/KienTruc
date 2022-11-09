package dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import entity.Student;

@WebService(targetNamespace = "tranhoanglong")
public class StudentDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -600237122355252362L;
	private static List<Student> list =new ArrayList<Student>();

	public boolean createSt(Student st) {
		for(Student st1:list) {
			if(st1.getMa().equalsIgnoreCase(st.getMa()))
				return false;
		}
		list.add(st);
		return true;
	}
	public Student getStudenById(String id) {
		for(Student st:list) {
			if(st.getMa().equalsIgnoreCase(id))
				return st;
		}
		return null;
	}
	public List<Student> getListST(){
		return list;
	}
	public boolean deleteSt(String ma) {
		for(Student st:list) {
			if(st.getMa().equalsIgnoreCase(ma)) {
				list.remove(st);
				return true;
			}
		}
		return false;
	}
	public boolean updateSTID(String ma,Student newst) {
		for(Student st:list) {
			if(st.getMa().equalsIgnoreCase(ma)) {
				st.setTen(newst.getTen());
				st.setSdt(newst.getSdt());
				st.setDiachi(newst.getDiachi());
				return true;
			}
		}
		return false;
	}
	public boolean LuuFile(Object obj,String filePath) throws Exception {
		ObjectOutputStream oss=new ObjectOutputStream(new FileOutputStream(filePath));
		oss.writeObject(obj);
		oss.flush();
		oss.close();
		return true;
	}
}
