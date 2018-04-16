package Functions;

public class PossibleMoves2{
	public static String PossibleMoves2(String[] index2, String[] board2,String colour,int size){

	int[] correct_pieces = new int[(size-2)*2];
	int chosen_index;
        
        

	for(int i=0,j=0;i<board2.length;i++)
	{
		if(board2[i].equals(colour)){correct_pieces[j]=i;
										if(j<size-1){j+=1;}}
	}

	

	double d=Math.random();
	int n=(int)(d*size);


	chosen_index=correct_pieces[n];

    String pcstartingposition=index2[chosen_index];
        
    

	return(pcstartingposition);}
}