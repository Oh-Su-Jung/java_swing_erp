package java_swing_erp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java_swing_erp.dto.Department;
import java_swing_erp.dto.Student;
import java_swing_erp.ui.component.StudentManagement;
import java_swing_erp.ui.component.content.DepartmentPanel;
import java_swing_erp.ui.component.content.StudentPanel;
import java_swing_erp.ui.component.table.DepartmentTable;
import java_swing_erp.ui.component.table.StudentTable;

public class TestMain {

	public static void main(String[] args) {
		// test정규표현식적용();
		
		// test();
		
		//testDepartment();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagement frame = new StudentManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void test정규표현식적용() {
		String no = "123";
		boolean isValid = Pattern.matches("\\d{1,3}", no);
		System.out.println(isValid);
		
		String name = "오수정";
		boolean isValidHan = Pattern.matches("^[가-힣]+$", name);
		System.out.println(isValidHan);
		
		String tel = "053-1544-1111";
		boolean isValidTel = Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", tel);
		System.out.println(isValidTel);
	}
	
	private static void testDepartment() {
		JFrame frame = new JFrame(); // 기본 레이아웃은 borderlayout(동 서 남 북)
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DepartmentPanel sp = new DepartmentPanel();
		frame.add(sp, BorderLayout.NORTH); // center에 들어감
		
		Department std = new Department(1, "경영학과", "053-111-3333");
		sp.setItem(std);
		
		JButton btn = new JButton("확인"); // borderlayout의 south에 추가
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(sp.getItem());
				
			}
		});
		frame.add(btn, BorderLayout.EAST);
		
		// System.out.println(sp.getStudent());
		
		ArrayList<Department> stdList = new ArrayList<>();
		stdList.add(new Department(1, "경영", "053-1111-1111"));
		stdList.add(new Department(2, "무역", "053-2222-2222"));
		
		DepartmentTable table = new DepartmentTable();
		table.setItems(stdList);

		JScrollPane jp = new JScrollPane();
		jp.setViewportView(table);
		
		frame.add(jp, BorderLayout.CENTER);
		
		
		Department tstd = new Department(3, "컴퓨터관광", "053-3333-3333");
		stdList.add(tstd);
		table.addRow(tstd);
		
		table.removeRow(1);
		stdList.remove(1);
		
		tstd.setName("컴퓨터과학");
		tstd.setTel("053-4444-4444");
		
		int serachIdx = stdList.indexOf(tstd);
		
		table.updateRow(serachIdx, tstd);
		
		frame.setVisible(true);
	}

	private static void test() {
		JFrame frame = new JFrame(); // 기본 레이아웃은 borderlayout(동 서 남 북)
		frame.setSize(400, 600);
		StudentPanel sp = new StudentPanel();
		frame.add(sp, BorderLayout.NORTH); // center에 들어감
		frame.setVisible(true);
		
		Student std = new Student(1, "김대훈", 80, 70, 60);
		sp.setItem(std);
		
		JButton btn = new JButton("확인"); // borderlayout의 south에 추가
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(sp.getItem());
				
			}
		});
		frame.add(btn, BorderLayout.EAST);
		
		// System.out.println(sp.getStudent());
		
		ArrayList<Student> stdList = new ArrayList<Student>();
		stdList.add(new Student(1, "김대훈", 90, 80, 71));
		stdList.add(new Student(2, "이현석", 91, 81, 100));
		stdList.add(new Student(3, "윤원주", 92, 82, 90));
		stdList.add(new Student(4, "배성덕", 93, 83, 60));
		
		StudentTable table = new StudentTable();
		table.setItems(stdList);

		JScrollPane jp = new JScrollPane();
		jp.setViewportView(table);
		
		frame.add(jp, BorderLayout.CENTER);
		
		Student tstd = new Student(5, "이지수", 80, 70, 60);
		stdList.add(tstd);
		table.addRow(tstd);
		
		table.removeRow(1);
		stdList.remove(1);
		
		tstd.setName("백령");
		tstd.setKor(100);
		tstd.setEng(0);
		tstd.setMath(100);
		
		int serachIdx = stdList.indexOf(tstd);
		
		table.updateRow(serachIdx, tstd);
		
		frame.setVisible(true);
	}

}
