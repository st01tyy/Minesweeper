package ui;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Timer extends StackPane
{
	private final int MAX_MINUTE=99;
	
	private int minute,second;
	
	private HBox hbox;
	private MyLabel m10,m1,middle,s10,s1;
	
	private Timeline timeline;
	
	public Timer()
	{
		super();
		super.setPrefSize(100, 50);
		super.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		super.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		
		hbox=new HBox();
		m10=new MyLabel("0");
		m1=new MyLabel("0");
		s10=new MyLabel("0");
		s1=new MyLabel("0");
		middle=new MyLabel(":");
		hbox.getChildren().addAll(m10,m1,middle,s10,s1);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPrefSize(100, 50);
		hbox.setMinSize(USE_PREF_SIZE, USE_PREF_SIZE);
		hbox.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
		
		super.getChildren().add(hbox);
		
		this.minute=this.second=0;
		
		timeline=new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		Duration duration=Duration.millis(1000);
		timeline.getKeyFrames().add(new KeyFrame(duration,e -> this.add()));
	}
	
	private void add()
	{
		if(this.minute!=this.MAX_MINUTE)
		{
			second++;
			if(second==60)
			{
				minute++;
				second=0;
			}
			m10.setText(new Integer((int)(minute/10)).toString());
			m1.setText(new Integer(minute%10).toString());
			s10.setText(new Integer((int)(second/10)).toString());
			s1.setText(new Integer(second%10).toString());
		}
	}
	public void start()
	{
		timeline.play();
	}
	public void stop()
	{
		this.timeline.stop();
	}
	public void refresh()
	{
		this.stop();
		this.minute=this.second=0;
		this.start();
	}
	public int getMinute() 
	{
		return minute;
	}
	public int getSecond() 
	{
		return second;
	}
	
}
