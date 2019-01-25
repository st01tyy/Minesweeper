package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Setting 
{

    @FXML
    private TextField label_row;

    @FXML
    private TextField label_column;

    @FXML
    private TextField label_mine;

    @FXML
    private Button btn_confirm;
    
    public void initialize()
    {
    	this.btn_confirm.setOnMouseClicked(e -> functions.SettingsFunctions.onConfirmClicked(this.label_row,this.label_column,this.label_mine));
    }

}
