package core;

import java.util.ArrayList;

import functions.ButtonFunctions;
import functions.GameFunctions;

public class Game 
{
	private Block[][] blocks;
	private ArrayList<Index> mineList;
	private int blockRevealed;
	private int mines;
	private GameStatus status;
	public Game(int gameWidth,int gameHeight,int mines)
	{
		blocks=new Block[gameHeight][gameWidth];
		for(int a=0;a<gameHeight;a++)
		{
			for(int b=0;b<gameWidth;b++)
			{
				Index index=new Index(a,b);
				blocks[a][b]=new Block(index);
			}
		}
		this.mines=mines;
		this.setBlockType();
		this.status=GameStatus.NOTEND;
	}
	private boolean validIndex(Index index)
	{
		boolean result=false;
		if(index.getRow()>=0&&index.getRow()<this.blocks.length&&index.getColumn()>=0&&index.getColumn()<this.blocks[0].length)
			result=true;
		return result;
	}
	private void setBlockType()
	{
		mineList=new ArrayList<Index>();
		int count=0;
		while(count<this.mines)
		{
			Index index=new Index((int)(Math.random()*(this.blocks.length-1)),(int)(Math.random()*(this.blocks[0].length-1)));
			if(this.blocks[index.getRow()][index.getColumn()].getType()!=BlockType.MINE)
			{
				mineList.add(index);
				this.blocks[index.getRow()][index.getColumn()].getType().setIndex(9);;
				count++;
				this.blocks[index.getRow()][index.getColumn()].setType(BlockType.MINE);
			}
		}
		for(int a=0;a<mineList.size();a++)
		{
			Index index=mineList.get(a);
			for(int m=-1;m<=1;m++)
			{
				for(int n=-1;n<=1;n++)
				{
					if(m==n&&m==0)
						continue;
					else
					{
						Index temp=new Index(index.getRow()+m,index.getColumn()+n);
						if(validIndex(temp))
						{
							if(this.blocks[temp.getRow()][temp.getColumn()].getType().equals(BlockType.MINE)==false)
								this.stupidEnum(this.blocks[temp.getRow()][temp.getColumn()]);
						}
					}
				}
			}
		}
	}
	private void stupidEnum(Block block)
	{
		if(block.getType().equals(BlockType.ZERO))
			block.setType(BlockType.ONE);
		else if(block.getType().equals(BlockType.ONE))
			block.setType(BlockType.TWO);
		else if(block.getType().equals(BlockType.TWO))
			block.setType(BlockType.THREE);
		else if(block.getType().equals(BlockType.THREE))
			block.setType(BlockType.FOUR);
		else if(block.getType().equals(BlockType.FOUR))
			block.setType(BlockType.FIVE);
		else if(block.getType().equals(BlockType.FIVE))
			block.setType(BlockType.SIX);
		else if(block.getType().equals(BlockType.SIX))
			block.setType(BlockType.SEVEN);
		else
			block.setType(BlockType.EIGHT);
	}
	public void userLeftClick(Index index)
	{
		if(this.status.equals(GameStatus.NOTEND))
		{
			BlockStatus status=this.blocks[index.getRow()][index.getColumn()].getStatus();
			if(status.equals(BlockStatus.IDLE))
			{
				this.blocks[index.getRow()][index.getColumn()].setStatus(BlockStatus.LEFTCLICKED);
				BlockType type=this.blocks[index.getRow()][index.getColumn()].getType();
				if(type.equals(BlockType.MINE))
					GameFunctions.gameLost();
				else
				{
					ArrayList<Operation> operationList=new ArrayList<Operation>();
					this.dfs(operationList, index);
					ButtonFunctions.setButtonBackground(operationList);
					if(this.blockRevealed==this.blocks.length*this.blocks[0].length-this.mines)
						GameFunctions.gameWin();
				}
			}
			else if(status.equals(BlockStatus.LEFTCLICKED))
				return;
			else
				return;
		}
	}
	public void userRightClick(Index index)
	{
		if(this.status.equals(GameStatus.NOTEND))
		{
			BlockStatus status=this.blocks[index.getRow()][index.getColumn()].getStatus();
			if(status.equals(BlockStatus.IDLE))
			{
				Operation operation=new Operation(index,"-fx-background-image: url('/background/flag.jpg')");
				ButtonFunctions.setButtonBackground(operation);
				this.blocks[index.getRow()][index.getColumn()].setStatus(BlockStatus.RIGHTCLICKED);
			}
			else if(status.equals(BlockStatus.LEFTCLICKED))
				return;
			else
			{
				Operation operation=new Operation(index,"");
				ButtonFunctions.setButtonBackground(operation);
				this.blocks[index.getRow()][index.getColumn()].setStatus(BlockStatus.IDLE);
			}
		}
	}
	private void dfs(ArrayList<Operation> operationList,Index index)
	{
		this.blockRevealed++;
		this.blocks[index.getRow()][index.getColumn()].setStatus(BlockStatus.LEFTCLICKED);
		int row=index.getRow();
		int column=index.getColumn();
		if(this.blocks[row][column].getType().equals(BlockType.ZERO))
		{
			operationList.add(new Operation(index,"-fx-background-color: transparent"));
			for(int a=-1;a<=1;a++)
			{
				for(int b=-1;b<=1;b++)
				{
					if(a==b&&a==0)
						continue;
					else if(row+a>=0&&row+a<this.blocks.length&&column+b>=0&&column+b<this.blocks[0].length&&this.blocks[row+a][column+b].getStatus().equals(BlockStatus.IDLE)&&this.blocks[row+a][column+b].getType().equals(BlockType.MINE)==false)
						dfs(operationList,new Index(row+a,column+b));
				}
			}
		}
		else
			operationList.add(new Operation(index,"-fx-background-image: url('/background/"+new Integer(this.blocks[row][column].getType().getIndex()).toString()+".jpg')"));
	}
	public ArrayList<Operation> lose()
	{
		this.status=GameStatus.END;
		ArrayList<Operation> operationList=new ArrayList<Operation>();
		for(int a=0;a<this.mineList.size();a++)
		{
			operationList.add(new Operation(this.mineList.get(a),"-fx-background-image: url('/background/mine.jpg')"));
		}
		return operationList;
	}
	public ArrayList<Operation> win()
	{
		this.status=GameStatus.END;
		ArrayList<Operation> operationList=new ArrayList<Operation>();
		for(int a=0;a<this.mineList.size();a++)
		{
			operationList.add(new Operation(this.mineList.get(a),"-fx-background-image: url('/background/flag.jpg')"));
		}
		return operationList;
	}
	public int getMines() 
	{
		return mines;
	}
	
}
