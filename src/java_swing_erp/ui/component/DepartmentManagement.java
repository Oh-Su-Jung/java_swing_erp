package java_swing_erp.ui.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java_swing_erp.dto.Department;
import java_swing_erp.ui.component.content.DepartmentPanel;
import java_swing_erp.ui.component.table.DepartmentTable;

@SuppressWarnings("serial")
public class DepartmentManagement extends JFrame implements ActionListener {

	private JPanel contentPane;
	private DepartmentPanel pDepartment;
	private JPanel pBtns;
	private JPanel pTable;
	private JButton btnAdd;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private DepartmentTable table;
	private ArrayList<Department> stdList;

	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentManagement frame = new DepartmentManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */

	public DepartmentManagement() {
		setTitle("학과 정보");
		initComponents();
		
		Department std = new Department(4, "컴퓨터과학", "010-1111-1111");
		pDepartment.setItem(std);
		
		stdList = new ArrayList<Department>();
		stdList.add(new Department(1, "컴퓨터", "010-1111-1111"));
		stdList.add(new Department(2, "관광", "010-1111-1111"));
		stdList.add(new Department(3, "경영", "010-1111-1111"));
		
		table.setItems(stdList);
		
		CustomPopupMenu popMenu = new CustomPopupMenu(this);
		table.setComponentPopupMenu(popMenu);
		scrollPane.setViewportView(table);
		
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		pDepartment = new DepartmentPanel();
		contentPane.add(pDepartment);

		pBtns = new JPanel();
		contentPane.add(pBtns);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pBtns.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtns.add(btnCancel);

		pTable = new JPanel();
		contentPane.add(pTable);
		pTable.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		pTable.add(scrollPane, BorderLayout.CENTER);

		table = new DepartmentTable();
		scrollPane.setViewportView(table);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnAdd) {
			if (e.getActionCommand().equals("추가")) {
				actionPerformedBtnAdd(e);
			} else {
				actionPerformedBtnUpdate();
			}
			
		}
		if (e.getSource() instanceof JMenuItem) {
			if (e.getActionCommand().equals("수정")) {
				//System.out.println("수정");
				actionperformeMenuUpdate();
			}
			if (e.getActionCommand().equals("삭제")) {
				//System.out.println("삭제");
				actionperformeMenuDelete();
			}
			if (e.getActionCommand().equals("세부 정보")) {
				//System.out.println("세부 정보");
				actionperformeMenuDetail();
			}
		}
	}

	private void actionperformeMenuDetail() {
		int selIdx = table.getSelectedRow();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세요.");
			return;
		}
		Department detailStd = stdList.get(selIdx);
		DepartmentDetailDlg dlg = new DepartmentDetailDlg();
		dlg.setStudent(detailStd);
		dlg.setTfNotEditable();
		dlg.setVisible(true);
		
		
	}

	private void actionperformeMenuDelete() {
		int selIdx = table.getSelectedRow();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세요.");
			return;
		}
		Department deleteStd = stdList.remove(selIdx);
		table.removeRow(selIdx);
		JOptionPane.showMessageDialog(null, String.format("%s(%d) 삭제 완료", deleteStd.getName(), deleteStd.getNo()));
		
	}

	private void actionPerformedBtnUpdate() {
		Department updateStd = pDepartment.getItem();
		int idx = stdList.indexOf(updateStd);
		stdList.set(idx, updateStd);
		table.updateRow(idx, updateStd);
		pDepartment.clearTf();
		pDepartment.setEditableNoTf(true);
		btnAdd.setText("추가");
		JOptionPane.showMessageDialog(null, String.format("%s(%d) 수정 완료", updateStd.getName(), updateStd.getNo()));
		
	}

	private void actionperformeMenuUpdate() {
		int selIdx = table.getSelectedRow();
		if (selIdx == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세요.");
			return;
		}
		Department selStd = stdList.get(selIdx);
		pDepartment.setItem(selStd);
		
		btnAdd.setText("수정");
		pDepartment.setEditableNoTf(false);
		
	}

	protected void actionPerformedBtnAdd(ActionEvent e) {
		Department newStd = pDepartment.getItem();
		table.addRow(newStd);
		pDepartment.clearTf();
		JOptionPane.showMessageDialog(null, String.format("%s(%d) 추가 완료", newStd.getName(), newStd.getNo()));
		stdList.add(newStd);
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pDepartment.clearTf();
		pDepartment.setEditableNoTf(true);
		btnAdd.setText("추가");
		table.clearSelection();
	}
	
	private class CustomPopupMenu extends JPopupMenu {
		
		public CustomPopupMenu(ActionListener listener) {
			JMenuItem updateMenu = new JMenuItem("수정");
			updateMenu.addActionListener(listener);
			add(updateMenu);
			JMenuItem deleteMenu = new JMenuItem("삭제");
			deleteMenu.addActionListener(listener);
			add(deleteMenu);
			JMenuItem detailMenu = new JMenuItem("세부 정보");
			detailMenu.addActionListener(listener);
			add(detailMenu);
		}
	}
}
