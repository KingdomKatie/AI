package pacman.game;

import java.util.EnumMap;

import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

public class MinMax {
	int alpha;
	int beta;
	int best =0;
	int score = 0;
	public int scoreMove(Game gameCopy,Boolean Max,int depth,MOVE tryMOVE)
	{	

		
		
		if ( depth == 0)
		{
			//if(Max)
			//{
			// gameCopy.updatePacMan(tryMOVE);
			//}
			
		// gameCopy.updateGame();
		 score = gameCopy.getScore();
		 return score;
		}
		
		//move 
		if (Max)
		{
			int currentNode = gameCopy.getPacmanCurrentNodeIndex();
		    MOVE[]posMove;
		    posMove = gameCopy.getPossibleMoves(currentNode);
		    int noOfMoves = posMove.length;
		   
		    gameCopy.updatePacMan(tryMOVE);
		   // gameCopy.updateGame();
		    for (int i = 0;i<noOfMoves;i++)
		    {
		    	
		    score = scoreMove(gameCopy.copy(),!Max,depth-1,posMove[i]);
		   
		    }
		   
		    
		
		}
		else if(!Max)
		{ 
			
			
			for(GHOST ghost : GHOST.values())
			{
				int currentGNode = gameCopy.getGhostCurrentNodeIndex(ghost);
			    MOVE[] GMove;
			    GMove = gameCopy.getPossibleMoves(currentGNode);
			    int noOfGMoves =GMove.length;
			    EnumMap<GHOST, MOVE> myMap = new EnumMap<GHOST,MOVE>(GHOST.class);
			    myMap.put(ghost, tryMOVE);
			    gameCopy.updateGhosts(myMap);
			
			    for (int i = 0;i<noOfGMoves;i++)
			    {
			    	
			     
			    score = scoreMove(gameCopy.copy(),Max,depth-1,GMove[i]);
			    }
			}
		}
		
		gameCopy.updateGame();
	
		//score = gameCopy.getScore();
		//alpha = result;
		
		//MOVE bestMove = tryMOVE;
		//if(score > alpha)
		//{
			//alpha = score;
			//bestMove = tryMOVE;
		//}
		
		return score;
		
	}

}
