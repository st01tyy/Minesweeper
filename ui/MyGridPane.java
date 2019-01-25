package ui;

import core.Index;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class MyGridPane extends GridPane
{
	private MyButton[][] buttons;
	public MyGridPane(int width,int height)
	{
		super();
		this.buttons=new MyButton[height][width];
		for(int a=0;a<height;a++)
		{
			for(int b=0;b<width;b++)
			{
				Index index=new Index(a,b);
				buttons[a][b]=new MyButton(index);
				super.add(buttons[a][b], b, a);
			}
		}
		super.setPadding(new Insets(5,5,5,5));
		super.setPrefSize(25*width+10, 25*height+10);
		super.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		super.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		super.setGridLinesVisible(true);
	}
	public MyButton[][] getButtons() 
	{
		return buttons;
	}
	
}
