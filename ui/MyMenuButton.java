package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;

public class MyMenuButton extends MenuButton
{
	private MenuItem primary;
	private MenuItem medium;
	private MenuItem advance;
	private MenuItem select;
	public MyMenuButton(String str)
	{
		super(str);
		super.setFont(new Font("Cambria",18));
		super.setAlignment(Pos.CENTER);
		super.setPadding(new Insets(0,0,5,0));
		primary=new MenuItem("初级");
		primary.setOnAction(e -> functions.SettingsFunctions.onPrimaryClicked());
		medium=new MenuItem("中级");
		medium.setOnAction(e -> functions.SettingsFunctions.onMediumClicked());
		advance=new MenuItem("高级");
		advance.setOnAction(e -> functions.SettingsFunctions.onAdvanceClicked());
		select=new MenuItem("自定义");
		select.setOnAction(e -> functions.SettingsFunctions.onSelectClicked());
		super.getItems().addAll(primary,medium,advance,select);
	}
}
