package core;

public enum BlockType 
{
	ZERO(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),MINE(9);
	private int index;
	private BlockType(int index)
	{
		this.index=index;
	}
	public int getIndex() 
	{
		return index;
	}
	public void setIndex(int index) 
	{
		this.index = index;
	}
	
}
