import java.util.Scanner;
public class AtomApp{
	public static void main(String[] args) {
		AtomProblem atoms = new AtomProblem();
		Integer x = 2;
		Integer y = 2;
		boolean ok = false;
		Integer option = 0;
		Scanner in = new Scanner(System.in);
		/* select the difficulty*/
		System.out.println("SELECT DIFFICULTY\n1) EASY\n2) MEDIUM\n3) HARD");
		option = in.nextInt();
		/* create the engine*/
		MinMaxEngine<AtomProblem,AtomState> engine;
		/* depends the optio is the number of depth for the engine*/
		if (option == 1)
			engine = new MinMaxEngine<AtomProblem,AtomState>(atoms,1);
		else{
			if(option == 2)
				engine = new MinMaxEngine<AtomProblem,AtomState>(atoms,2);
			else
				engine = new MinMaxEngine<AtomProblem,AtomState>(atoms,3);
		}
		/* clear screen*/
		Screen.clear();
		/* we show the initial state*/
		System.out.println("ESTADO INICIAL");
		System.out.println(atoms.initialState().toString());
		System.out.println("PRESS ANY KEY TO PLAY");
		String key =in.next();
		/* and let's play , this ejecute until only player on the board*/
		while(!atoms.end(atoms.initialState())){
			System.out.println("COMPUTER THINKING...");
			atoms = new AtomProblem(engine.computeSuccessor(atoms.initialState().clone()));
			Screen.clear();
			System.out.println("COMPUTER");
			System.out.println(atoms.initialState().toString());
			ok = false;
			while(!ok){
				System.out.println("PLAYER");
				in = new Scanner(System.in);
		    System.out.println("Ingrese la x"); 
		    x = in.nextInt();

		    in = new Scanner(System.in);
		    System.out.println("ingrese la y"); 
		    y = in.nextInt();
		    ok = atoms.positionOk((x-1),(y-1));
		  }
		    atoms = new AtomProblem (atoms.putAnAtom(atoms.initialState(),(x-1),(y-1),new Atom(2)));
		    Screen.clear();
		    /* here we return the result of the game*/
		    System.out.println("PLAYER "+atoms.getWinner(atoms.initialState())+" WINS" );
		    System.out.println(atoms.initialState().toString());

	  }
		System.out.println("ESTADO FINAL");
	}
}