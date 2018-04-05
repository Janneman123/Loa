package multiplayer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import Functions.NumberOfJumps;
import Functions.RequiredPosition;
import Functions.SupposedNumberofJumps;
import Functions.MovementDirection;
import Functions.Piece;
import Functions.Board;
import Functions.Index;
import Functions.Units;
import Functions.ReIndex;
import Functions.Networking;

import Client_move_1.Client_move_1;


public class multiplayer
{
	public static void main(String[] args){



	

	Scanner scanner =new Scanner(System.in);
		Scanner textscanner=new Scanner(System.in);

		String direction="Not determined yet";
		String colour="B";


		int [] arguments = new int[args.length];

		for (int i=0;i<args.length;i++)
		 		{
		 			arguments[i]=Integer.parseInt(args[i]);
		 		} 

		 		int size= arguments[0];
		int mode = arguments[1];

		String[][] board3 = new String[size][size];
		String[][] index3 = new String[size][size];
		String board4[][] = new String[size+2][size+2];

		int bunits=size/2;
		int wunits=size/2;


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


		


		Functions.ReIndex ReIndex = new Functions.ReIndex();
		board3=ReIndex.ReIndex(board2,size);

		Functions.Board Board= new Functions.Board();
		board4=Board.Board(board3,alphabet2,alphabet3,size);


	for(int i=0;i<size+1;i++)
							
				{
					System.out.println("");
				for(int j=0;j<size+1;j++)
					{
			System.out.print(board4[i][j]+" ");
					}
				}


	board3=ReIndex.ReIndex(board2,size);
	index3=ReIndex.ReIndex(index2,size);


	String[] direction_of_movement = new String[8];

	direction_of_movement[0]="left";
	direction_of_movement[1]="right";
	direction_of_movement[2]="up";
	direction_of_movement[3]="down";
	direction_of_movement[4]="downleft";
	direction_of_movement[5]="downright";
	direction_of_movement[6]="upleft";
	direction_of_movement[7]="upright";

	Functions.Networking Networking = new Functions.Networking();
	Client_move_1 Client_move_1 = new Client_move_1();


	String host="temp";
	String client="temp";

	while(!(host.equals("B")||host.equals("W")))
	{
	System.out.println("Who is the host? (B or W)");
	host=textscanner.nextLine();
	if(host.equals("B")){client="W";} else {client="B";}

	}

	System.out.println("");
	System.out.println("State B's ip address");
	String bip = textscanner.nextLine();
	String playerb="B";

	System.out.println("");
	System.out.println("State W's ip address");
	String wip = textscanner.nextLine();
	String playerw="W";

	String hostip;
	String clientip;
	if(host.equals("B")){hostip=bip;} else {hostip=wip;}
	if(client.equals("B")){clientip=bip;} else {clientip=wip;}





	

	//int b=Networking.connect(wip);
	//System.out.println(b);


					String endposition;
					String requiredposition;
					String startingposition;
					String piece;
					int startindex;
					int endindex;
					int jumps;
					String move;
					Boolean legalmove;


							while(!(bunits==size||wunits==size)){
					 endposition="temp1";
					 requiredposition="temp2";
					 startingposition="temp3";
					 piece ="temp4";
					 startindex=-1;
					 endindex=-1;
					 jumps=0;
					 move="temp5";
					 legalmove = false;

							while(!endposition.equals(requiredposition) || legalmove==false){	
							System.out.println("");


							System.out.println("Make your move, " + colour);

							if(!colour.equals(host)){System.out.println("Waiting for Client to move");}
							String[] temparray = new String[1];
							temparray[0]=hostip;
							
							if(host.equals(colour)){move= textscanner.nextLine();} else {move=Client_move_1.Client_move_1(hostip);}
							if(move.equals("QUIT")){System.exit(0);}

							if(move.equals("PASS")){
								if(colour.equals("B")){colour="W";} 
								else {colour="B";}}


						 startingposition=move.substring(0,2);
						 endposition=move.substring(2,4);

						//System.out.println(startingposition);

						Functions.Piece Piece =new Functions.Piece();

						piece =Piece.Piece(board2,index2,startingposition);

						Functions.Index Index = new Functions.Index();

						 startindex = Index.Index(board2,index2,startingposition);
						 endindex = Index.Index(board2,index2,endposition);



						board3=ReIndex.ReIndex(board2,size);
						index3=ReIndex.ReIndex(index2,size);


						Functions.MovementDirection MovementDirection = new Functions.MovementDirection();

						direction=MovementDirection.MovementDirection(direction_of_movement,index3,startingposition,endposition,size);
						System.out.println("Direction: "+ direction);
						//System.out.println(direction);

						//Functions.NumberOfJumps NumberOfJumps = new Functions.NumberOfJumps();

						 jumps=NumberOfJumps.NumberOfJumps(index3,board3,startingposition,endposition,size,direction_of_movement,direction);

						int jumps_delta =NumberOfJumps.NumberOfJumps(index3,board3,endposition,endposition,size,direction_of_movement,direction);
						System.out.println("Jumps: "+jumps);

						Functions.SupposedNumberofJumps SupposedNumberofJumps = new Functions.SupposedNumberofJumps();
						boolean correct_number_of_jumps=SupposedNumberofJumps.SupposedNumberofJumps(direction_of_movement,jumps,size,direction,index3,board3,startingposition,endposition,jumps_delta);

						Functions.RequiredPosition RequiredPosition = new Functions.RequiredPosition();
						 requiredposition=RequiredPosition.RequiredPosition(index3,board3,size,direction,jumps,startingposition,endposition);
						 if(!endposition.equals(requiredposition)){System.out.println("ERROR:Illegal Move");}
						
						System.out.println("Required: "+ requiredposition);
					



						if(board2[endindex].equals(".") && board2[startindex].equals(colour) && requiredposition.equals(endposition) && jumps!=0
							&& board2[startindex].equals(colour)){	
							for(int i=0;i<board2.length;i++){
								legalmove=true;

								if(i==startindex){board2[i]=".";}
															}				
	//
							for(int i=0;i<board2.length;i++){
								if(i==endindex){board2[i]=piece;}
								}}

							else{System.out.println("ERROR: Illegal Move");
								  legalmove=false;}

						board3=ReIndex.ReIndex(board2,size);
						index3=ReIndex.ReIndex(index2,size);
						board4=Board.Board(board3,alphabet2,alphabet3,size);


						Functions.Units Units = new Functions.Units();

					 bunits=Units.Units("B",index3,board3,board2,size);
					 wunits=Units.Units("W",index3,board3,board2,size);

					 for(int i=0;i<size+1;i++)
									
						{
							System.out.println("");
						for(int j=0;j<size+1;j++)
							{
						System.out.print(board4[i][j]+" ");
							}
						}

						System.out.println("");


					  if(bunits==size||wunits==size){System.out.println("WINNER:"+colour);
					  								System.exit(0);}
					  							}


						if(colour.equals("B")){colour="W";} else {colour="B";}
					}
					

	//connection=Networking.connect("105.186.160.171");
	//String command=Networking.write("Hello");







				
	}
}