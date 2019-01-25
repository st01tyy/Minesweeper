package core;

public class Block 
{
	private Index index;
	private BlockType type;
	private BlockStatus status;
	public Block(Index index)
	{
		this.index=index;
		this.type=BlockType.ZERO;
		this.status=BlockStatus.IDLE;
	}
	public Index getIndex() 
	{
		return index;
	}
	public BlockType getType() 
	{
		return type;
	}
	
	public void setType(BlockType type) 
	{
		this.type = type;
	}
	public void setStatus(BlockStatus status) 
	{
		this.status = status;
	}
	public BlockStatus getStatus() 
	{
		return status;
	}
	
}
