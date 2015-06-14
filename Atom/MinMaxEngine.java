package engines;
import static java.lang.Math.*;
import java.util.List;

public abstract class MinMaxEngine <S extends State, Problem extends AdversarySearchProblem<S>> extends AdversarySearchEngine<S,Problem> {
  
  public MinMaxEngine(){
  	super();
  }

  public MinMaxEngine(Problem p){
  	super(p);
  }

  public MinMaxEngine(Problem p, int level){
  	super(p,level);
  }

	public int minMaxAB (S n,int alfa, int beta, int maxLevel){ 
		s.flag = maxLevel%2==0;
		if(n.succes()||n.getSuccessors()==null || maxLevel==0)
			return n.getValue();
		else{
			List<S> successors = n.getSuccessors();
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
		return minMaxAB(state,MIN_VALUE,MAX_VALUE,level);

	}	


public State computeSuccessor(State state){
		List<State> successors = Problem.getSuccessors(state);
		List<Pair<State,Integer>> successorsValues = new List<Pair<State,Integer>>();
		while (!successors.isEmpty()){
			successorsValues.add(new Pair<State,Integer>(successors.get(0),computeValue(successors.get(0)));
			successors.remove(0);
		}
		int max = 0;
		int i =0;
		while (i<successorsValues.size()){
			if (successorsValues.get(max).getRight() < successorsValues.get(i).getRight()){
				max = i;
			}
			i++;
		}
		return successorsValues.get(max).getLeft();
	}


	public void report(){

	}

	public void setProblem(P p) {
        problem = p;
    }
	
}
