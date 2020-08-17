package java_swing_erp;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java_swing_erp.ui.component.DepartmentManagement;
import java_swing_erp.ui.component.StudentManagement;

@SuppressWarnings("serial")
public class Erp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnStudent;
	private JButton btnDepartment;
	private StudentManagement stdFrame;
	private DepartmentManagement deptFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Erp frame = new Erp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Erp() {
		initComponents();
	}
	private void initComponents() {
		setTitle("학사관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 102);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnStudent = new JButton("학생관리");
		btnStudent.addActionListener(this);
		contentPane.add(btnStudent);
		
		btnDepartment = new JButton("학과관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDepartment) {
			actionPerformedBtnDepartment(e);
		}
		if (e.getSource() == btnStudent) {
			actionPerformedBtnStudent(e);
		}
	}
	
	protected void actionPerformedBtnStudent(ActionEvent e) {
		if (stdFrame == null) {
			stdFrame = new StudentManagement();
		}
		stdFrame.setVisible(true);
	}
	
	protected void actionPerformedBtnDepartment(ActionEvent e) {
		if (deptFrame == null) {
			deptFrame = new DepartmentManagement();
		}
		deptFrame.setVisible(true);
	}
}
