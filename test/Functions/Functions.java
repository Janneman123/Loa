

//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;

package Functions;

public class Functions{



	public static String RequiredPosition(String[][] index3,String[][] board3,int size,String direction,int jumps,String startingposition,String endposition){
		String requiredposition="Undetermined";
		int startrowindex =0;
		int startcolumnindex =0;

		int endrowindex =0;
		int endcolumnindex =0;
		double increment=0;


		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(index3[i][j].equals(startingposition)){startrowindex=i;startcolumnindex=j;}
			}
		}

		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(index3[i][j].equals(endposition)){endrowindex=i;startcolumnindex=j;}
			}
		}
			
		if(direction.equals("left"))
		{
			requiredposition=index3[startrowindex][startcolumnindex-jumps+1];
		}

		if(direction.equals("right"))
		{
			requiredposition=index3[startrowindex][startcolumnindex+jumps-1];
		}

		if(direction.equals("up"))
		{
			requiredposition=index3[startrowindex-jumps][startcolumnindex];
		}

		if(direction.equals("down"))
		{
			requiredposition=index3[startrowindex+jumps][startcolumnindex];
		}

		if(direction.equals("upright"))

		{
			//increment=Math.pow(((Math.pow(jumps,2))/2),0.5);
			requiredposition=index3[startrowindex-jumps][startcolumnindex];
		}



		return(requiredposition);}

	public static boolean SupposedNumberofJumps(String[] direction_of_movement,int jumps,int size, String direction, String[][] index3, String[][] board3,
		String startingposition,String endposition){
		int jumps_required=jumps;
		//String direction=MovementDirection(direction_of_movement,index3,startingposition,endposition,size);
		int jumps_delta=NumberOfJumps(index3,board3,endposition,endposition,size,direction_of_movement,direction);

		boolean correct_number_of_jumps=(jumps_required==jumps_delta);



		return(correct_number_of_jumps);}

	public static String MovementDirection(String[] direction_of_movement, String[][] index3,
		String startingposition,String endposition,int size){

		int startcolumnindex=-1;
		int startrowindex=-1;
		int endcolumnindex=-1;
		int endrowindex=-1;

		String direction ="Error";

		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(index3[i][j].equals(startingposition)){startrowindex=i;startcolumnindex=j;}
			}
		}

				for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(index3[i][j].equals(endposition)){endrowindex=i;endcolumnindex=j;}
			}
		}

		if(endcolumnindex==startcolumnindex && endrowindex>startrowindex)
		{
			direction="down";
		}

		 if (endcolumnindex==startcolumnindex && endrowindex<startrowindex)
		{
			direction="up";
		}

		 if (endrowindex==startrowindex && endcolumnindex<startcolumnindex)
		{
			direction="left";
		}

		 if (endrowindex==startrowindex && endcolumnindex>startcolumnindex)
		{
			direction="right";
		}

		 if (endrowindex<startrowindex && endcolumnindex>startcolumnindex)
		{
			direction ="upright";
		}

		 if (endrowindex>startrowindex && endcolumnindex<startcolumnindex)
		{
			direction ="upleft";
		}

		 if (endrowindex<startrowindex && endcolumnindex<startcolumnindex)
		{
			direction ="downleft";
		}

		//else if (endrowindex<startrowindex && endcolumnindex>startcolumnindex)
		//{
			//direction ="downright";
		//}



		return(direction);}


	public static String Piece(String[] board2, String index2[],String startposition){
		int index =-1;
		for (int i=0;i<index2.length;i++) 
			{
    		if (index2[i].equals(startposition)) {index = i;}
    		}

    		return(board2[index]);

		}

	public static int Index(String[] board2, String index2[], String start_or_end){

		int indexvalue=0;
		for(int i=0;i<index2.length;i++)
		{
			if(index2[i].equals(start_or_end)){indexvalue=i;}
		}

		return(indexvalue);}

	public static String[][] ReIndex(String[] stringarray,int size){
		String[][] temp = new String[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){temp[i][j]=stringarray[i*size+j];}
		}
		return(temp);}

	public static int Units(String colour,String[][] index3,String[][] board3,String[] board2,int size){
		int units=0;
		int touching=0;
		int touching2=0;
		int touchingrow=0;
		int touchingcolumn=0;
		String[][] aux=new String[size+2][size+2];

		int righttouch=0;
		int downrighttouch=0;
		int downlefttouch=0;

		for(int i=0;i<=size+1;i++)
		{
			for(int j=0;j<=size+1;j++)
			{
				

				 if (j==0 || i==0 || j==size+1 || i==size+1)
				{
					aux[i][j]="*";
				}

				else
				{
					aux[i][j]=board3[i-1][j-1];
				}
			}
		}


		for(int i=1;i<=size;i++)
		{
			for(int j=1;j<=size;j++)
			{
				if(aux[i][j].equals(colour))
				{	
					if(
						aux[i][j].equals(aux[i+1][j+1])  //downright
						//||
						//aux[i][j].equals(aux[i-1][j-1])
						|| 
						aux[i][j].equals(aux[i+1][j]) //down
						||
						aux[i][j].equals(aux[i][j+1]) //right
						//||
						//aux[i][j].equals(aux[i-1][j])
						//||
						//aux[i][j].equals(aux[i][j-1])
						//||
						//aux[i][j].equals(aux[i-1][j+1]) //upright
						||
						aux[i][j].equals(aux[i+1][j-1]) //downleft
						)
					{
						touching+=1;
						touchingrow=i;
						touchingcolumn=j;
					}
				//touching=touching-1;	
				}
			}
		}

		touching+=1;



			//for(int i=1;i<=size;i++)
			//{
				//for(int j=1;j<=size;j++)
				//{
					//if(aux[i][j].equals(aux[i+1][j-1]) &&  aux[i][j].equals(colour))
				//	downlefttouch+=1;	
				//}
			//}
		

		return(touching);}

	public static String[][] Board(String[][] board3,char[] alphabet2, char[] alphabet3,int size){
		String [][] temp=new String[size+2][size+2];

		for(int i=0;i<size+2;i++)

		{
			
			for(int j=0;j<size+2;j++)
			{
				{
					

						if(i>0 && j<=size && j>0 && i<=size){temp[i][j]=board3[i-1][j-1];}

						if(i==0 && j==0){temp[i][j]=" ";}

						if(i==0 && j!=0){temp[i][j]=String.valueOf(alphabet2[j-1]);}
						
						if(j==0 && i!=0){temp[i][j]=String.valueOf(alphabet3[i-1]);}


				}
			}
		}	
		return(temp);}

	public static String PossibleMoves(String[][] index3,String[][] board3,int size,String direction,int jumps,String startingposition,String endposition,String[] direction_of_movement){

		String[] moves={"left","right","down","up","downleft","downright","upleft","upright"};	
		
		double d1 =Math.random();
		double n1=8*d1;
		int m1=(int)(n1);

		double d2 =Math.random();
		double n2=size*d2;
		int row=(int)(n2);

		double d3 =Math.random();
		double n3=size*d3;
		int column=(int)(n2);

		String pcstartingposition=index3[row][column];
		String pcdirection=direction_of_movement[m1];

		int pcjumps=NumberOfJumps(index3,board3,pcstartingposition,"bra" ,size,direction_of_movement,pcdirection);

		String pcrequiredposition=RequiredPosition(index3,board3,size,pcdirection,pcjumps,pcstartingposition,"bra");
		//startingposition=




		return(pcrequiredposition);}	


}



