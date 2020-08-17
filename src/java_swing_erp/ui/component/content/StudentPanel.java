package java_swing_erp.ui.component.content;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java_swing_erp.dto.Student;
import java_swing_erp.ui.exception.EmptyTfException;
import java_swing_erp.ui.exception.InValidTfValue;

@SuppressWarnings("serial")
public class StudentPanel extends AbstractItemPanel<Student> {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfKor;
	private JTextField tfEng;
	private JTextField tfMath;

	public StudentPanel() {
		initComponents();
	}

	private void initComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 20, 10));
		
		setPreferredSize(new Dimension(450, 350));
		
		JLabel lblNo = new JLabel("학생 번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);

		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);

		JLabel lblName = new JLabel("학생 성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);

		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);

		JLabel lblKor = new JLabel("국어");
		lblKor.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblKor);

		tfKor = new JTextField();
		tfKor.setColumns(10);
		add(tfKor);

		JLabel lblEng = new JLabel("영어");
		lblEng.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblEng);

		tfEng = new JTextField();
		tfEng.setColumns(10);
		add(tfEng);

		JLabel lblMath = new JLabel("수학");
		lblMath.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMath);

		tfMath = new JTextField();
		tfMath.setColumns(10);
		add(tfMath);
	}
	
	@Override
	public void setItem(Student item) {
		tfNo.setText(String.valueOf(item.getNo()));
		tfName.setText(item.getName());
		tfKor.setText(String.valueOf(item.getKor()));
		tfEng.setText(String.valueOf(item.getEng()));
		tfMath.setText(String.valueOf(item.getMath()));
	}
	
	@Override
	public Student getItem() {
		if (isTfEmpty()) {
			// textfidle가 하나라도 비어있으면
			throw new EmptyTfException("공란이 존재");
		}
		if (isValidTf()) {
			// 국어, 영어, 수학이 0미만 100초과면
			throw new InValidTfValue("0에서 100사이면 입력가능");
		}
		int no = Integer.parseInt(tfNo.getText().trim());
		String name = tfName.getText().trim();
		int kor = Integer.parseInt(tfKor.getText().trim());
		int eng = Integer.parseInt(tfEng.getText().trim());
		int math = Integer.parseInt(tfMath.getText().trim());
		return new Student(no, name, kor, eng, math);
	}

	@Override
	boolean isValidTf() {
		// 국어, 영어, 수학이 0미만 100초과면
		int kor = Integer.parseInt(tfKor.getText().trim());
		int eng = Integer.parseInt(tfEng.getText().trim());
		int math = Integer.parseInt(tfMath.getText().trim());
		
		if (kor < 0 || kor > 100) return true;
		if (eng < 0 || eng > 100) return true;
		if (math < 0 || math > 100) return true;
		
		return false;
	}
	
	@Override
	public void setEditableNoTf(boolean isEditable) {
		tfNo.setEditable(isEditable);
	}

}
