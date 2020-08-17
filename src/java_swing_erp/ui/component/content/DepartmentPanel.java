package java_swing_erp.ui.component.content;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java_swing_erp.dto.Department;
import java_swing_erp.ui.exception.EmptyTfException;
import java_swing_erp.ui.exception.InValidTfValue;

@SuppressWarnings("serial")
public class DepartmentPanel extends AbstractItemPanel<Department> {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfTel;

	/**
	 * Create the panel.
	 */
	public DepartmentPanel() {

		initComponents();
	}
	private void initComponents() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(0, 2, 20, 10));
		
		setPreferredSize(new Dimension(450, 230));
		
		JLabel lblNo = new JLabel("학과 번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("학과명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
		
		JLabel lblTel = new JLabel("연락처");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		add(tfTel);
	}

	@Override
	public void setItem(Department item) {
		tfNo.setText(String.valueOf(item.getNo()));
		tfName.setText(item.getName());
		tfTel.setText(item.getTel());
		
	}

	@Override
	public Department getItem() {
		if (isTfEmpty()) {
			throw new EmptyTfException("공란이 존재");
		}
		if (!isValidTf()) {
			throw new InValidTfValue("학과번호는 숫자만, 학과명은 한글만, 연락처는 000-0000-0000만 가능");
		}
		int no = Integer.parseInt(tfNo.getText().trim());
		String name = tfName.getText().trim();
		String tel = tfTel.getText().trim();
		return new Department(no, name, tel);
	}

	@Override
	boolean isValidTf() {
		// 1. 정규표현식
		// no 숫자만 가능
		// name 한글만 가능
		// tel 3자리숫자-3(4)자리숫자-4자리숫자
		String no = tfNo.getText().trim();
		String name = tfName.getText().trim();
		String tel = tfTel.getText().trim();
		
		//정규 표현식 적용
		boolean noCheck = Pattern.matches("\\d{1,3}", no);
		boolean nameCheck = Pattern.matches("^[가-힣]+$", name);
		boolean telCheck = Pattern.matches("\\d{3}-\\d{3,4}-\\d{4}", tel);
		return noCheck && nameCheck && telCheck;
	}

	@Override
	public void setEditableNoTf(boolean isEditable) {
		tfNo.setEditable(isEditable);
		
	}

}
