package functions;

import javafx.scene.control.TextField;
import main.CurrentGame;

public class SettingsFunctions 
{
	public static void onPrimaryClicked()
	{
		GameFunctions.gameStart(30, 20, 40);
	}
	public static void onMediumClicked()
	{
		GameFunctions.gameStart(30, 20, 60);
	}
	public static void onAdvanceClicked()
	{
		GameFunctions.gameStart(30, 20, 120);
	}
	public static void onSelectClicked()
	{
		CurrentGame.setting.show();
	}
	public static void onConfirmClicked(TextField txtfield_row,TextField txtfield_column,TextField txtfield_mine)
	{
		CurrentGame.setting.close();
		try
		{
			GameFunctions.gameStart(new Integer(txtfield_column.getText()).intValue(), new Integer(txtfield_row.getText()).intValue(),new Integer(txtfield_mine.getText()).intValue());
		}
		catch(Exception e)
		{
			onPrimaryClicked();
		}
	}
}
