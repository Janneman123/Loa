package Functions;

public class Piece{

public static String Piece(String[] board2, String index2[],String startposition){
		int index =-1;
		for (int i=0;i<index2.length;i++) 
			{
    		if (index2[i].equals(startposition)) {index = i;}
    		}

    		return(board2[index]);

		}
}