package server;

import javax.xml.ws.Endpoint;

import dao.StudentDao;

public class Server {
	public static void main(String[] args) {
		StudentDao stdao=new StudentDao();
		String address="http://localhost:44442/Student";
		System.out.println("web service bind at: "+address);
		Endpoint.publish(address, stdao);
	}
}
