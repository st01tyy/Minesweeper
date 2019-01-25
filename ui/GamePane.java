package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GamePane extends BorderPane
{
	private VBox vbox;
	private HBox firstLine;
	private HBox secondLine;
	private MyGridPane gridpane;
	private MyMenuButton menubutton;
	private Label space;
	private Button restart;
	private Timer timer;
	public GamePane(int width,int height)
	{
		super();
		gridpane=new MyGridPane(width,height);
		firstLine=new HBox();
		menubutton=new MyMenuButton("Settings");
		menubutton.setStyle("-fx-background-color: transparent");
		firstLine.getChildren().add(menubutton);
		firstLine.setPadding(new Insets(0,0,5,0));
		secondLine=new HBox();
		timer=new Timer();
		restart=new Button("");
		restart.setStyle("-fx-background-image: url('/background/R.jpg')");
		restart.setOnMouseClicked(e -> functions.GameFunctions.restart());
		space=new Label();
		secondLine.getChildren().addAll(restart,space,timer);
		secondLine.setAlignment(Pos.TOP_RIGHT);
		secondLine.setPadding(new Insets(0,5,0,0));
		vbox=new VBox();
		vbox.getChildren().addAll(firstLine,secondLine);
		super.setTop(vbox);
		super.setBottom(gridpane);
		super.setAlignment(vbox, Pos.TOP_CENTER);
		super.setAlignment(gridpane, Pos.BOTTOM_CENTER);
		this.calculateSize();
	}
	private void calculateSize()
	{
		int width=(int)gridpane.getPrefWidth()+10;
		int height=(int)gridpane.getPrefHeight()+80;
		if(width<100)
			width=100;
		super.setPrefSize(width, height);
		super.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		super.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		restart.setPrefSize(50, 50);
		restart.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		restart.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		firstLine.setPrefSize(width, 30);
		firstLine.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		firstLine.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		secondLine.setPrefSize(width, 50);
		secondLine.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		secondLine.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		space.setPrefSize(width/2-125, 50);
		space.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		space.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		vbox.setPrefSize(width, 80);
		vbox.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		vbox.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
	}
	public void start()
	{
		this.timer.start();
	}
	public void end()
	{
		this.timer.stop();
	}
	public MyButton[][] getButtons()
	{
		return this.gridpane.getButtons();
	}
}
