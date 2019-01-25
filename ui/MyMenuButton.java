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
		primary=new MenuItem("����");
		primary.setOnAction(e -> functions.SettingsFunctions.onPrimaryClicked());
		medium=new MenuItem("�м�");
		medium.setOnAction(e -> functions.SettingsFunctions.onMediumClicked());
		advance=new MenuItem("�߼�");
		advance.setOnAction(e -> functions.SettingsFunctions.onAdvanceClicked());
		select=new MenuItem("�Զ���");
		select.setOnAction(e -> functions.SettingsFunctions.onSelectClicked());
		super.getItems().addAll(primary,medium,advance,select);
	}
}
