package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import tranhoanglong.FileNotFoundException;
import tranhoanglong.IOException;
import tranhoanglong.Student;
import tranhoanglong.StudentDaoProxy;

public class Gui extends JFrame implements ActionListener,MouseListener{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -7450916399768278253L;
		private JTextField txtMa;
		private JTextField txtTen;
		private JTextField txtDiaChi;
		private JTextField txtSdt;
		private JTextField txtTim;
		private JButton btnTim;
		private JButton btnthem;
		private JButton btnSua;
		private JButton btnXoa;
		private JButton btnLuu;
		private JButton btnLam;
		
		private static DefaultTableModel model;
		private static JTable table;
		public Gui() throws RemoteException{
			setTitle("Kiem Tra Tuan 10");
			setSize(800,500);
			//setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			
			JPanel p=new JPanel(new BorderLayout());
			this.add(p);
			
			JPanel pTop=new JPanel(new BorderLayout());
			p.add(pTop,BorderLayout.NORTH);
			
			JLabel lblTitle=new JLabel("Thong Tin Sinh Vien");
			lblTitle.setFont(new Font("Aria",Font.BOLD,30));
			pTop.add(lblTitle,BorderLayout.NORTH);
			
			Box b=Box.createVerticalBox();
			Box b1=Box.createHorizontalBox();
			Box b2=Box.createHorizontalBox();
			Box b3=Box.createHorizontalBox();
			Box b4=Box.createHorizontalBox();
			
			pTop.add(b,BorderLayout.CENTER);
			
			b1.add(new JLabel("Ma Sinh Vien"));
			b1.add(txtMa=new JTextField(20));
			b.add(b1);
			
			b2.add(new JLabel("Ten Sinh Vien"));
			b2.add(txtTen=new JTextField(20));
			b.add(b2);
			
			b3.add(new JLabel("Dia Chi Sinh Vien"));
			b3.add(txtDiaChi=new JTextField(20));
			b.add(b3);
			
			b4.add(new JLabel("SDT Chi Sinh Vien"));
			b4.add(txtSdt=new JTextField(20));
			b.add(b4);
			
			JPanel pBtn=new JPanel();
			pTop.add(pBtn,BorderLayout.SOUTH);
			pBtn.add(new JLabel("Nhap Sinh Vien Can Tim"));
			pBtn.add(txtTim=new JTextField(15));
			pBtn.add(btnTim=new JButton("Tim"));
			pBtn.add(btnthem=new JButton("Them"));
			pBtn.add(btnLam=new JButton("LamMoi"));
			pBtn.add(btnSua=new JButton("Sua"));
			pBtn.add(btnXoa=new JButton("Xoa"));
			
			pBtn.add(btnLuu=new JButton("Luu"));
			
			String[] header= {"Ma Sinh Vien","Ten Sinh Vien","Dia Chi","SDt"};
			model=new DefaultTableModel(header,0);
			table=new JTable(model);
			p.add(new JScrollPane(table),BorderLayout.CENTER);
			DocDL();
			
			
			btnTim.addActionListener(this);
			btnthem.addActionListener(this);
			btnLam.addActionListener(this);
			btnXoa.addActionListener(this);
			btnSua.addActionListener(this);
			btnLuu.addActionListener(this);
			table.addMouseListener(this);
		}
		public static void main(String[] args) throws RemoteException {
			new Gui().setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			Object o=e.getSource();
			if(o.equals(btnthem)) {
				String ma=txtMa.getText();
				String ten=txtTen.getText();
				String diachi=txtDiaChi.getText();
				String sdt=txtSdt.getText();
				Student st=new Student(diachi, ma, sdt, ten);
				try {
					StudentDaoProxy proxy=new StudentDaoProxy();
					if(proxy.createSt(st)) {
						XoaDL();
						try {
							DocDL();
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Them Thanh Cong");
					};
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			};
			if(o.equals(btnLam)) {
				txtMa.setText("");
				txtTen.setText("");
				txtDiaChi.setText("");
				txtSdt.setText("");
				XoaDL();
				try {
					DocDL();
				} catch (Exception e2) {
						e2.printStackTrace();
				}
			}
			if(o.equals(btnXoa)) {
				int n=table.getSelectedRow();
				if(n ==-1) {
					JOptionPane.showMessageDialog(null, "Chua Chon");
					return;
				}
				String ma=model.getValueAt(n, 0).toString();
				try {
					StudentDaoProxy proxy=new StudentDaoProxy();
					if(proxy.deleteSt(ma)) {
						model.removeRow(n);
					}
				} catch (Exception e2) {

						e2.printStackTrace();
				}
			}
			if(o.equals(btnSua)) {
				int n=table.getSelectedRow();
				String ma=model.getValueAt(n, 0).toString();
				String ten=txtTen.getText();
				String diachi=txtDiaChi.getText();
				String sdt=txtSdt.getText();
				Student stnew=new Student(diachi, ma, sdt, ten);
				try {
					StudentDaoProxy proxy=new StudentDaoProxy();
					if(proxy.updateSTID(ma,stnew)) {
						XoaDL();
						try {
							DocDL();
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				} catch (Exception e2) {

						e2.printStackTrace();
				}
			}
			if(o.equals(btnTim)) {
				String id=txtTim.getText();
				StudentDaoProxy proxy=new StudentDaoProxy();
				try {
					Student st=proxy.getStudenById(id);
					if(st==null) {
						JOptionPane.showMessageDialog(null, "Khong Tim Thay");
					}
					else
					{
						XoaDL();
						model.addRow(new Object[] {
								st.getMa(),st.getTen(),st.getDiachi(),st.getSdt()
						});
					}
				} catch (RemoteException e1) {
					
					e1.printStackTrace();
				}
			}
			if(o.equals(btnLuu)) {
				
				StudentDaoProxy proxy =new StudentDaoProxy();
				
				Student[] list = null;
				try {
					list = proxy.getListST();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				for(Student st:list) {
					try {		
								
						System.out.println(proxy.luuFile(st,"SinhVien.txt"));
						System.out.println(st);
						JOptionPane.showMessageDialog(null, "Luu thanh cong");
					} catch (FileNotFoundException e1) {
					
						e1.printStackTrace();
					} catch (IOException e1) {
					
						e1.printStackTrace();
					} catch (RemoteException e1) {
					
						e1.printStackTrace();
					}
				}
					
		
			
			}
			
		}
		public void XoaDL() {
			DefaultTableModel df=(DefaultTableModel) table.getModel();
			df.getDataVector().removeAllElements();
		}
		public void DocDL() throws RemoteException {
			StudentDaoProxy proxy=new StudentDaoProxy();
			Student[] list =proxy.getListST();
			if(list !=null) {
				for(Student st:list) {
					model.addRow(new Object[] {
							st.getMa(),st.getTen(),st.getDiachi(),st.getSdt()
					});
				}
			}
			System.out.println(list);
		}
		public void mouseClicked(MouseEvent e) {
			int n=table.getSelectedRow();
			
			txtMa.setText(model.getValueAt(n, 0).toString());
			txtTen.setText(model.getValueAt(n, 1).toString());
			txtDiaChi.setText(model.getValueAt(n, 2).toString());
			txtSdt.setText(model.getValueAt(n, 3).toString());
		}
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
