package java_swing_erp.ui.component.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import java_swing_erp.dto.Student;

@SuppressWarnings("serial")
public class StudentTable extends AbstractItemTable<Student> {
	
	@Override
	Object[] getColName() {
		return new String[] {"번호", "성명", "국어", "영어", "수학", "총점", "평균"};
	}

	@Override
	Object[] toArray(Student std) {
		return new Object[] {
				std.getNo(), 
				std.getName(), 
				std.getKor(), 
				std.getEng(), 
				std.getMath(), 
				std.getTotal(), 
				std.getAverage()};
	}

	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		double value = (double) getValueAt(row, 6);
		
		if (value >= 90) {
			c.setBackground(new Color(255, 0, 0, 127));
		} else {
			c.setBackground(Color.WHITE);
		}
		
		super.prepareRenderer(renderer, row, column);
		return c;
	}

	@Override
	void setWidthAndAlign() {
		// column width 
		tableSetWidth(150, 200, 100, 100, 100, 100, 100); 
		// column alingment 
		tableCellAlign(SwingConstants.CENTER, 0, 1);
		tableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6);
	}

}
