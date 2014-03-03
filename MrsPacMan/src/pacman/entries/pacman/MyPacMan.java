package pacman.entries.pacman;

import java.awt.List;
import java.util.ArrayList;

import pacman.controllers.Controller;
import pacman.game.Constants.MOVE;
import pacman.game.Game;
import pacman.game.MinMax;

/*
 * This is the class you need to modify for your entry. In particular, you need to
 * fill in the getAction() method. Any additional classes you write should either
 * be placed in this package or sub-packages (e.g., game.entries.pacman.mypackage).
 */
public class MyPacMan extends Controller<MOVE>
{
	MinMax myMinMax = new MinMax();
	int bestscore = 0;
	int score = 0;
	int lastscore = 0;
	MOVE myMove;
	
	//private MOVE myMove=MOVE.NEUTRAL;
	
	public MOVE getMove(Game game, long timeDue) 
	{
		//Place your game logic here to play the game as Ms Pac-Man
		//do play here
		int currentNode = game.getPacmanCurrentNodeIndex();
	    MOVE[]posMove;
	    posMove = game.getPossibleMoves(currentNode);
	    int noOfMoves = posMove.length;
	    //Game GameCopy = game.copy();
	    //go tho all pacmans moves 
	    for(int i = 0; i < noOfMoves;i++)
	    {
	     //Game GameCopy = game.copy();
	     //call min max for player turn , game, move[i], depth?
	    	score = myMinMax.scoreMove(game, true, 4, posMove[i]);
	       if (score >lastscore)
	       {
	         bestscore = score;
	       
	    	myMove = posMove[i];
	       }
	       
	       lastscore = score;
	       
	    	
	    }
	  
	   // myMove=MOVE.DOWN;
		return myMove;
	}
	

}