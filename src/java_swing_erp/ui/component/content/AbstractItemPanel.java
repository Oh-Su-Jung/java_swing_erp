package java_swing_erp.ui.component.content;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public abstract class AbstractItemPanel<T> extends JPanel {
	
	public abstract void setItem(T item);
	
	public abstract T getItem();

	abstract boolean isValidTf();

	boolean isTfEmpty() {
		for (Component c : getComponents()) {
			if (c instanceof JTextField) {
				if (((JTextField) c).getText().isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void setTfEditable(boolean isEditable) {
		for (Component c : getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setEditable(isEditable);
			}
		}
	}

	public void clearTf() {
		for (Component c : getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setText("");
			}
		}
		
	}
	
	public abstract void setEditableNoTf(boolean isEditable);

}
