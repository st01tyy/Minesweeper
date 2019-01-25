package functions;

import java.io.IOException;

import core.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.CurrentGame;
import ui.GamePane;
import ui.Setting;

public class GameFunctions 
{
	public static void initialStart(Stage stage) throws IOException
	{
		CurrentGame.stage=stage;
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(GameFunctions.class.getResource("/Setting.fxml"));
		Pane pane=loader.load();
		CurrentGame.setting=new Stage();
		CurrentGame.setting.setScene(new Scene(pane,pane.getPrefWidth(),pane.getPrefHeight()));
		CurrentGame.setting.setTitle("…Ë÷√");
		Setting setting=loader.getController();
		setting.initialize();
		gameStart(30,20,20);
	}
	public static void gameStart(int width,int height,int mines)
	{
		CurrentGame.game=new Game(width,height,mines);
		CurrentGame.gamePane=new GamePane(width,height);
		CurrentGame.stage.setScene(new Scene(CurrentGame.gamePane,CurrentGame.gamePane.getPrefWidth(),CurrentGame.gamePane.getPrefHeight()));
		CurrentGame.stage.setTitle("Minesweeper v1.0 - Made by Ruben");
		CurrentGame.stage.show();
		CurrentGame.gamePane.start();
	}
	public static void restart()
	{
		gameStart(CurrentGame.gamePane.getButtons()[0].length,CurrentGame.gamePane.getButtons().length,CurrentGame.game.getMines());
	}
	public static void gameLost()
	{
		ButtonFunctions.setButtonBackground(CurrentGame.game.lose());
		CurrentGame.gamePane.end();
	}
	public static void gameWin()
	{
		ButtonFunctions.setButtonBackground(CurrentGame.game.win());
		CurrentGame.gamePane.end();
	}
}
