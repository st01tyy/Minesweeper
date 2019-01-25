package ui;

import core.Index;
import javafx.scene.control.Button;

public class MyButton extends Button
{
	private Index index;
	public MyButton(Index index)
	{
		super();
		super.setPrefSize(25, 25);
		super.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		super.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		super.setFocused(false);
		this.index=index;
		super.setOnMouseClicked(e -> functions.ButtonFunctions.onMouseClicked(e, this.index));
	}
	public Index getIndex() 
	{
		return index;
	}
	
}
