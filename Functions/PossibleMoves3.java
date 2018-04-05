package Functions;

public class PossibleMoves3{

public static String PossibleMoves3(String[] index2,String[] board2,int size,String[] direction_of_movement){


	int[] correct_pieces = new int[size*size-2*size];
	int chosen_index;

	for(int i=0,j=0;i<board2.length;i++)
	{
		if(board2[i].equals(".")){correct_pieces[j]=i;
										j+=1;}
	}

	

	double d=Math.random();
	int n=(int)(d*(size*size-2*size));


	chosen_index=correct_pieces[n];

	String pcendposition=index2[chosen_index];


	return(pcendposition);}
}