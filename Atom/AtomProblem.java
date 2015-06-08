import libraries.abstract.AdversarySearchProblem;
import java.util.*;

public class AtomProblem implements AdversarySearchProblem<AtomState>{
	private AtomState init;

	public ReinaState initialState(){
		init = new AtomState();
	}

	public List<AtomState> getSuccessors(AtomState s) {
		??????
	}


	public Boolean succes(AtomState s){
		int i = 0;
		int x = 0;
		int y = 0;

		while(x<=5){
			while(y<=9){
				if(board[x][y]!= null)
					i = board[x][y].getPlayer();
				y++;
			}
			x++;
		}

		for (int i = 0; i<6; i++)
			for (int j = 0; j<10; j++) 
				if(board[i][j]!=null)
					if(board[i][j].getPlayer() != i)
						return false;
		return true;

	}

	public int getValue(AtomState s){
		int pc = 0;
		int human = 0;
		for (int i = 0; i<6; i++){
			for (int j = 0; j<10; j++){
				if(s.board[i][j]!=null){
					if((i == 0 || i == 5) && (j == 0 || j == 9))
						aux = s.board[i][j].getValue() * 2;
					if((i==0 && j < 9 && j>0)||(i==5 && j < 9 && j>0)||(j==0 && i < 4 && i>0)||(j==9 && i < 4 && i>0))
						aux = s.board[i][j].getValue() * 3;
					if(i != 0 && j != 0 && i != 5 && j != 9)
						aux = s.board[i][j].getValue() * 4;

					if(s.board[i][j].getPlayer() == 1)
						pc += aux;
					else
						human += aux;
				}
			} 
		}
		if (s.isMax())
			return pc - human;
		return humn - pc;
	}

	public Comparator<AtomState> getComparator(){
		return this;
		}
}