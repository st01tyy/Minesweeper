package ui;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class MyLabel extends Label
{
	public MyLabel(String name)
	{
		super(name);
		super.setFont(new Font("Cambria math",36));
	}
}
