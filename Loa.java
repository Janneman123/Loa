import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Loa{



	public static int NumberOfJumps(String[][] index3,String[][] board3,
		String startingposition,String endposition ,int size,String[] direction_of_movement, String direction){
		int startcolumnindex=-1;
		int startrowindex=-1;
		int endcolumnindex=-1;
		int endrowindex=-1;

		int rowdirectioncount =0;
		int columndirectioncount =0;

		int rightdirectioncount=0;
		int leftdirectioncount=0;

		int updirectioncount=0;
		int downdirectioncount=0;

		int downrightdirectioncount=0;
		int downleftdirectioncount=0;

		int uprightdirectioncount=0;
		int upleftdirectioncount=0;

		//int rowpostjump=0;
		//int columnpostjump=0;

		int[] number_of_moves = new int[8];

		int jumps =0;



		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(index3[i][j].equals(startingposition)){startrowindex=i;startcolumnindex=j;}
			}
		}

				//for(int i=0;i<size;i++)
		//{
			//for(int j=0;j<size;j++)
			//{
			//	if(index3[i][j].equals(endposition)){endrowindex=i;endcolumnindex=j;}
			//}
		//}

		
			for(int j=startcolumnindex+1;j<size;j++)
			{
				if(board3[startrowindex][j]!="."){rightdirectioncount+=1;}
			}

			for(int j=startcolumnindex;j>=0;j--)
			{
				if(j==0){break;}
				j=j-1;
				if(board3[startrowindex][j]!="."){leftdirectioncount+=1;}
			}

			for(int i=startrowindex+1;i<size;i++)
			{
				if((board3[i][startcolumnindex]!=".") && index3[i][startcolumnindex]!=startingposition){downdirectioncount+=1;}
			}

			for(int i=0;i<startrowindex;i++)
			{
				if((board3[i][startcolumnindex]!=".") && index3[i][startcolumnindex]!=startingposition){updirectioncount+=1;}
			}

	
			for(int i=startrowindex,j=startcolumnindex;i<size;i++)
			
					{
						if(j==size-1){break;}
						if(i==size-1){break;}
						i=i+1;
						j=j+1;
						if((board3[i][j]!=".") && index3[i][j]!=startingposition){downrightdirectioncount+=1;}
						if(j==size-1){break;}
						if(j!=size-1){j+=1;}
					}


				

			for(int i=startcolumnindex,j=startcolumnindex;i<size;i++)
			
					
					{	if(j==0){break;}
						j-=1;
						if((board3[i][j]!=".") && index3[i][j]!=startingposition){downleftdirectioncount+=1;}
						if(j==0){break;}	
						if(j!=0){j-=1;}	

					}

			for(int i=startrowindex-1,j=startcolumnindex;i>=0;i--)
			
					
					{
						if(j==0){break;}
						j-=1;
						if((board3[i][j]!=".") && index3[i][j]!=startingposition){upleftdirectioncount+=1;}
						if(j==0){break;}	
						if(j!=0){j-=1;}	

					}

			for(int i=startrowindex,j=startcolumnindex;i>=0;i--)
			
					
					{
						if(i==0){break;}
						if(j==size-1){break;}
						//i=i-1;
							j=j+1;
						if((board3[i][j]!=".") && index3[i][j]!=startingposition){uprightdirectioncount+=1;}
						//System.out.println(board3[i][j]);
						//System.out.print(i + " "+ j);
						if(j==size-1){break;}	
						if(j!=size-1){j+=1;}	

					}

			number_of_moves[0]=leftdirectioncount;
			number_of_moves[1]=rightdirectioncount;
			number_of_moves[2]=uprightdirectioncount;
			number_of_moves[3]=downdirectioncount;
			number_of_moves[4]=downleftdirectioncount;
			number_of_moves[5]=downrightdirectioncount;
			number_of_moves[6]=upleftdirectioncount;
			number_of_moves[7]=uprightdirectioncount;

		

			for(int i=0;i<direction_of_movement.length;i++)
			{
				if(direction_of_movement[i].equals(direction)){jumps=number_of_moves[i];}
			}
		return(jumps);}

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

	public static void  main(String[] args){

	 	//Arguments and checks//
		Scanner scanner =new Scanner(System.in);
		Scanner textscanner=new Scanner(System.in);

		String direction="Not determined yet";

		 

		int [] arguments = new int[args.length];


		for (int i=0;i<args.length;i++)
		 		{
		 			arguments[i]=Integer.parseInt(args[i]);
		 		} 

		 	//check for arguments
		if(arguments.length<2)
				{System.out.println("ERROR : too few arguments");
				System.exit(0);
				}

			//check board size
		if(arguments[0]<4|| arguments[0]>16)
			{
				System.out.println("ERROR: illegal size");
				System.exit(0);
			}

		if(arguments[1]>=3 || arguments[1]<0)
			{
				System.out.println("ERROR: illegal mode");
				System.exit(0);
			}

		int size= arguments[0];
		int mode = arguments[1];

		String[][] board3 = new String[size][size];
		String[][] index3 = new String[size][size];
		String board4[][] = new String[size+2][size+2];

		int bunits=size/2;
		int wunits=size/2;

			//Draw the board

		String[][] boardlabels;
		String[][] topbottomlables;


		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] alphabet2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
								'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] alphabet3 =new char[25];

		for(int i=size-1;i>=0;i--)
		{ alphabet3[i]=alphabet2[size-1-i];

			//Initialise the board
		}
		String[][] board= new String[size][size];

		for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					if((j==0||j==size-1)) //&& !(j==0||j==size-1))
						{
							if(i==0||i==size-1){board[i][j]=".";}
							else if(i>0 && i<size-1){board[i][j]="W";}
						}
					if(!(j==0||j==size-1) && !(j==0||j==size+1))
						{
							if(i==0||i==size-1){board[i][j]="B";}
							else if (i>0 && i<size-1){board[i][j]=".";}

						}
				}
			}




			//Print the board	

		String[] board2 =new String[size*size];	

		List<String> arrayList = new ArrayList<String>();

		for(int i=0;i<size;i++)
			{
				System.out.println("");
				for(int j=0;j<size;j++)
				{
					//System.out.print(board[i][j]+" ");
					arrayList.add(board[i][j]);
				}
			}

		for(int i=0;i<arrayList.size();i++)
			{
				board2[i]=arrayList.get(i);
			}

		System.out.println("");


		String index[] =new String[size*size];

		StringBuilder indexstring = new StringBuilder();
		

		for(int k=0;k<1;k++)
			{	
				
				for(int j=0;j<size;j++)
				{

					for(int i=0;i<size;i++)
					{	indexstring.setLength(0);
						indexstring.append(alphabet2[j]);
						indexstring.append(alphabet2[i]);

						index[i*size+j]=indexstring.toString();
						
					}
				}
			}

		String index2[] =new String[size*size];

		for(int n=0;n<size;n++)
			{
				for(int j=n*size;j<(n+1)*size;j++)
				{
					//System.out.println(index[3-n+(j-n*4)*4]);
					index2[j]=index[size-1-n+(j-n*size)*size];
				}
			}

			

		String[][] positions = new String[size][size];


				board3=ReIndex(board2,size);
				board4=Board(board3,alphabet2,alphabet3,size);


				for(int i=0;i<size+1;i++)
							
				{
					System.out.println("");
				for(int j=0;j<size+1;j++)
					{
			System.out.print(board4[i][j]+" ");
					}
				}

			//test movement of pieces

			

			board3=ReIndex(board2,size);
			index3=ReIndex(index2,size);


					String[] direction_of_movement = new String[8];

					direction_of_movement[0]="left";
					direction_of_movement[1]="right";
					direction_of_movement[2]="up";
					direction_of_movement[3]="down";
					direction_of_movement[4]="downleft";
					direction_of_movement[5]="downright";
					direction_of_movement[6]="upleft";
					direction_of_movement[7]="upright";


			
			String colour="B";
			while(mode==1){
				while(bunits!=4||wunits!=4){
					
			
					System.out.println("Make your move, " + colour);
					String move= textscanner.nextLine();
					if(move.equals("QUIT")){System.exit(0);}
					String startingposition=move.substring(0,2);
					String endposition=move.substring(2,4);

					String piece =Piece(board2,index2,startingposition);

					int startindex = Index(board2,index2,startingposition);
					int endindex = Index(board2,index2,endposition);



					board3=ReIndex(board2,size);
					index3=ReIndex(index2,size);




					direction=MovementDirection(direction_of_movement,index3,startingposition,endposition,size);
					//System.out.println(direction);

					int jumps=NumberOfJumps(index3,board3,startingposition,endposition,size,direction_of_movement,direction);
					boolean correct_number_of_jumps=SupposedNumberofJumps(direction_of_movement,jumps,size,direction,index3,board3,startingposition,endposition);
					String requiredposition=RequiredPosition(index3,board3,size,direction,jumps,startingposition,endposition);




					if(board2[endindex].equals(".") && !board2[startindex].equals(".") && requiredposition.equals(endposition) && jumps!=0
						&& board2[startindex].equals(colour)){	
						for(int i=0;i<board2.length;i++){

							if(i==startindex){board2[i]=".";}
							}

						for(int i=0;i<board2.length;i++){
							if(i==endindex){board2[i]=piece;}
							}}

						else{System.out.println("ERROR: Illegal Move");}

					board3=ReIndex(board2,size);
					index3=ReIndex(index2,size);
					board4=Board(board3,alphabet2,alphabet3,size);


					for(int i=0;i<size+1;i++)
								
					{
						System.out.println("");
					for(int j=0;j<size+1;j++)
						{
					System.out.print(board4[i][j]+" ");
						}
					}

					System.out.println("");

					//System.out.println(Units("B",index3,board3,size));
					//continue;

					//String[][] aux2=Units("B",index3,board3,size);
					 bunits=Units("B",index3,board3,board2,size);
					 wunits=Units("B",index3,board3,board2,size);

					//System.out.println(bunits);
					//System.out.println(requiredposition);



					if(colour.equals(colour) && jumps!=0 && (bunits!=4||wunits!=4) ){colour="W";} else {colour="B";}}
				System.out.println("WINNER:"+colour);}

				//String dir=PossibleMoves(index3,board3,size,"bra",1,"bra","bra",direction_of_movement);
				//System.out.println(dir);

			while(mode==2){
				System.out.println("Which colour do you want to be? (B or W");
				String player_colour= textscanner.nextLine();
				
					while(colour.equals(player_colour)){

					
			
						System.out.println("Make your move, " + colour);
						String move= textscanner.nextLine();
						if(move.equals("QUIT")){System.exit(0);}
						String startingposition=move.substring(0,2);
						String endposition=move.substring(2,4);

						String piece =Piece(board2,index2,startingposition);

						int startindex = Index(board2,index2,startingposition);
						int endindex = Index(board2,index2,endposition);



						board3=ReIndex(board2,size);
						index3=ReIndex(index2,size);




						direction=MovementDirection(direction_of_movement,index3,startingposition,endposition,size);
						//System.out.println(direction);

						int jumps=NumberOfJumps(index3,board3,startingposition,endposition,size,direction_of_movement,direction);
						boolean correct_number_of_jumps=SupposedNumberofJumps(direction_of_movement,jumps,size,direction,index3,board3,startingposition,endposition);
						String requiredposition=RequiredPosition(index3,board3,size,direction,jumps,startingposition,endposition);
						//String pcrequiredposition=PossibleMoves(index3,board3,size,"bra",1,"bra","bra",direction_of_movement);



						if(board2[endindex].equals(".") && !board2[startindex].equals(".") && requiredposition.equals(endposition) && jumps!=0
							&& board2[startindex].equals(colour)){	
							for(int i=0;i<board2.length;i++){if(i==startindex){board2[i]=".";}}

							for(int i=0;i<board2.length;i++){if(i==endindex){board2[i]=piece;}}}

							else{System.out.println("ERROR: Illegal Move");}

						board3=ReIndex(board2,size);
						index3=ReIndex(index2,size);
						board4=Board(board3,alphabet2,alphabet3,size);


						for(int i=0;i<size+1;i++){System.out.println("");for(int j=0;j<size+1;j++){System.out.print(board4[i][j]+" ");}}

						System.out.println("");}

						 bunits=Units("B",index3,board3,board2,size);
						 wunits=Units("B",index3,board3,board2,size);

						 colour="W";

						 for(int i=0;i<size+1;i++){System.out.println("");for(int j=0;j<size+1;j++){System.out.print(board4[i][j]+" ");}}
						 break;
						}

											for(int i=0;i<size+1;i++)
								
					{
						System.out.println("");
					for(int j=0;j<size+1;j++)
						{
					System.out.print(board4[i][j]+" ");
						}
					}

				System.out.println("PC's turn");
				System.out.println("WINNER:"+colour);		

				//String dir=PossibleMoves(index3,board3,size,"bra",1,"bra","bra",direction_of_movement);
				//System.out.println(dir);
	  }
}