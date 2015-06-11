package engines;
import static java.lang.Math.*;
import java.util.List;

public abstract class MinMaxEngine <S extends State, Problem extends AdversarySearchProblem<S>> extends AdversarySearchEngine<S,Problem> {
   protected path = new LinkedList<S>();


	public int minMaxAB (S n,int alfa, int beta, int maxLevel){ 
		if(n.succes()||n.getSuccessors()==null || maxLevel==0)
			return n.getValue();
		else{
			List<AtomState> successors = n.getSuccessors();
			while (!successors.isEmpty() && alfa<beta ){ 
				if( n.isMax())
					alfa = max(alfa, minMaxAB(successors.get(0), alfa, beta,maxLevel-1));
				else
					beta = min(beta, minMaxAB(successors.get(0), alfa, beta,maxLevel-1));
				successors.remove(0);
			}
			if (n.isMax)
				return alfa;
			else
				return beta;
		}
	}


	public int computeValue(State state){
		return state.getValue();

	}	


	public State computeSuccessor(State state){

	}

	public void report(){

	}

	public void setProblem(P p) {
        problem = p;
    }
	
}
