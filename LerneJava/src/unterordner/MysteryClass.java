package unterordner;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class MysteryClass {
	IntegerProperty num1 = new SimpleIntegerProperty();
	IntegerProperty num2 = new SimpleIntegerProperty();
	
	public final int getNum1() {
		return num1.getValue();
	}
	public final void setNum1(int value) {
		num1.setValue(value);
	}
	public IntegerProperty num1Property() {
		return num1;
	}
	
	public final int getNum2() {
		return num2.getValue();
	}
	public final void setNum2(int value) {
		num2.setValue(value);
	}
	public IntegerProperty num2Property() {
		return num2;
	}
	
	public static int mysteryMethod(int wert, int wert2) {
		NumberBinding nb = new SimpleIntegerProperty(wert).add(new SimpleIntegerProperty(wert2));
		if(wert==wert2) {
			return (int) nb.getValue();
		}
		return 0;
	}
}
