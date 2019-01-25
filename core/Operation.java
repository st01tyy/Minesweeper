package core;

public class Operation 
{
	private Index target;
	private String style;
	public Operation(Index target,String style)
	{
		this.target=target;
		this.style=style;
	}
	public Index getTarget() 
	{
		return target;
	}
	public String getStyle() 
	{
		return style;
	}
	
}
