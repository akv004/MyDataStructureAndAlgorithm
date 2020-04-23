package my.aws;


public class MineSweeper {
	
	 public static void main(String args[]){
		 
		 // ask for Lines & Column how many mines
		 int lines = 3; int columns = 3;
		 int maxmines=3;
		// create grid for given line & columns
		 MineCell[][]  board =  createMinesBoard(lines, columns, maxmines);
		 
		 showallMines(board);
		 System.out.println("");
		 generateHints(board);
		 
		 //ask for user to get input
		 // 
		 
	 }

	private static void generateHints(MineCell[][] board) {
		int lines = board.length;
		int columns = board[0].length;
		
		for(int x = 0; x<lines; x++){
			System.out.println("");
			for(int y =0; y<columns; y++){
				MineCell c = board[x][y];
				
				//System.out.println("x,y :" + x +"," + y );
				// up

				if(x!=0 && board[x-1][y].hasMine ){
					c.hint++;
				}
			    // up-righ
				if(x!=0 && y!=columns-1 && board[x-1][y+1].hasMine){
					c.hint++;
				}
				//right
				if( y!=columns-1 && board[x][y+1].hasMine){
					c.hint++;
				}
		
				//righ-down
				if(x<lines-1 && y<columns-1 && board[x+1][y+1].hasMine){
					c.hint++;
				}
				
				//down
				if(x!=lines-1 && board[x+1][y].hasMine ){
					c.hint++;
				}			
				//down-left
				if(x!=lines-1 && y!=0 && board[x+1][y-1].hasMine ){
					c.hint++;
				}				
				//left
				if( y!=0 && board[x][y-1].hasMine){
					c.hint++;
				}
		
				//left-up
				if( y!=0 && x!=0 && board[x-1][y-1].hasMine){
					c.hint++;
				}			
			
				String display =  (c.hasMine) ? "*" : String.valueOf(c.hint);
				
				System.out.print(display + " ");
			}
		}
		
	}


	private static void showallMines(MineCell[][] board) {
		int lines = board.length;
		int columns = board[0].length;
		
		for(int x = 0; x<lines; x++){
			System.out.println("");
			for(int y =0; y<columns; y++){
				MineCell c = board[x][y];
				char display = (c.hasMine) ? '*' : '?';
				System.out.print(display + " ");
			}
		}
		
	}

	private static MineCell[][]  createMinesBoard(int lines, int columns, int mines) {
		MineCell[][] board = new MineCell[lines][columns];
		int mineCount =0; 
		for(int x = 0; x<lines; x++){
			for(int y =0; y<columns; y++){
				boolean b = false;
				if(mineCount<mines){
					b= randomBooean();
					if(b) mineCount++;
				}
				
				board[x][y] = new MineCell(x, y, b, 0, "?" );
			}
		}
		return board;
		
	}
	
	public static boolean randomBooean(){
		return (Math.random() > 0.5);
	}

}


class MineCell{
	int x; 
	int y;
	boolean hasMine;
	int hint;
	String display;
	
	
	public MineCell(int x, int y, boolean hasMine, int hint, String display) {
		super();
		this.x = x;
		this.y = y;
		this.hasMine = hasMine;
		this.hint = hint;
		this.display = display;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isHasMine() {
		return hasMine;
	}
	public void setHasMine(boolean hasMine) {
		this.hasMine = hasMine;
	}
	public int getHint() {
		return hint;
	}
	public void setHint(int hint) {
		this.hint = hint;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	
}
