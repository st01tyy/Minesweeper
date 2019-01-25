package functions;

import java.util.ArrayList;

import core.Index;
import core.Operation;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import main.CurrentGame;
import ui.MyButton;

public class ButtonFunctions 
{
	public static void onMouseClicked(MouseEvent e, Index index)
	{
		MouseButton mousebutton=e.getButton();
		if(mousebutton.equals(MouseButton.PRIMARY))
		{
			CurrentGame.game.userLeftClick(index);
		}
		else if(mousebutton.equals(MouseButton.SECONDARY))
		{
			CurrentGame.game.userRightClick(index);
		}
	}
	public static void setButtonBackground(ArrayList<Operation> operationList)
	{
		MyButton[][] buttons=CurrentGame.gamePane.getButtons();
		for(int a=0;a<operationList.size();a++)
		{
			int row=operationList.get(a).getTarget().getRow();
			int column=operationList.get(a).getTarget().getColumn();
			buttons[row][column].setStyle(operationList.get(a).getStyle());
		}
	}
	public static void setButtonBackground(Operation operation)
	{
		CurrentGame.gamePane.getButtons()[operation.getTarget().getRow()][operation.getTarget().getColumn()].setStyle(operation.getStyle());
	}
}
