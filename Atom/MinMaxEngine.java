/*this class modela the behaviour of the opponent and help to choose the best choise */
import static java.lang.Math.*;
import java.util.*;

public class MinMaxEngine <P extends AdversarySearchProblem<State>, State extends AdversarySearchState> extends AdversarySearchEngine<P,State> {
  
  public MinMaxEngine(){
  	super();
  }

	public MinMaxEngine(P p){
  	super(p);
  }

  public MinMaxEngine(P p,int maxDepth){
  	super(p,maxDepth);
  }

	public int minMaxAB (State s,int alfa, int beta, int maxLevel){ 
		if(problem.end(s)|| maxLevel==0)
			return problem.value(s);
		else{
			List<State> successors = problem.getSuccessors(s);
			while (!successors.isEmpty() && alfa<beta){ 
				if(s.isMax())
					alfa = max(alfa, minMaxAB(successors.get(0), alfa, beta,maxLevel-1));
				else
					beta = min(beta, minMaxAB(successors.get(0), alfa, beta,maxLevel-1));
				successors.remove(0);
			}
			if (s.isMax())
				return alfa;
			
			return beta;
		}
	}

/* this method uses min max for give a state value*/
	public int computeValue(State state){
		return minMaxAB(state,-1000,1000,maxDepth);
	}	

/* this method select the best state between the all successors state*/
	public State computeSuccessor(State state){
		List<State> successors = problem.getSuccessors(state);
		LinkedList<Doublet<State,Integer>> successorsValues = new LinkedList<Doublet<State,Integer>>();
		while (!successors.isEmpty()){
			successorsValues.add(new Doublet<State,Integer>(successors.get(0),computeValue(successors.get(0))));
			successors.remove(0);
		}
		int max = 0;
		int i =0;
		while (i<successorsValues.size()){
			if (successorsValues.get(max).getSnd() < successorsValues.get(i).getSnd()){
				max = i;
			}
			i++;
		}
		return successorsValues.get(max).getFst();
	}


	public void setProblem(P p) {
        problem = p;
    }

	public void report(){

	}


}
