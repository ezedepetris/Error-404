import libraries.abstract.AbstractImformedSearchProblem;
import java.util.*;

public class AtomProblem implements AbstractImformedSearchProblem<AtomState>{
	private AtomState init;

	public ReinaState initialState(){
		init = new AtomState();
	}

	public List<ReinaState> getSuccessors(AtomState s) {
		??????
	}


	public Boolean succes(AtomState s){
		int i;
		int x = 0;
		int y = 0;

		while(x<=5){
			while(y<=9){
				if(board[x][y]!= null)
					i = board[x[y].getPlayer();
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
		?????

	}

	public Comparator<AtomState> getComparator(){
		??????
	}

}