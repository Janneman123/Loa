package single;


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

import Functions.PossibleMoves;
import Functions.PCDirection;
import Functions.PCEndBoardPositionCheck;
import Functions.PossibleMoves2;
import Functions.PossibleMoves3;
import Functions.PCNumberofJumps;
import Functions.PCRequiredPosition;



public class single
    {

        public static void main(String[] args)
        {

            Scanner scanner =new Scanner(System.in);
            Scanner textscanner=new Scanner(System.in);

            Functions.NumberOfJumps NumberOfJumps =new Functions.NumberOfJumps();

            String direction="Not determined yet";
            String pcrequiredposition ="Undetermined";
            boolean pcendboardpositioncheck=false;
            String pcpiece ="Undetermined";



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

            String[][] boardlabels;
            String[][] topbottomlables;


            char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            char[] alphabet2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                                    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            char[] alphabet3 =new char[25];

            for(int i=size-1;i>=0;i--)
                { 
                    alphabet3[i]=alphabet2[size-1-i];
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

            String colour="B";
            String player_colour="na";

            while(!(player_colour.equals("B"))&&!(player_colour.equals("W")))
                    {
                        System.out.println("Which colour do you want to be? (B or W)");
                        player_colour= textscanner.nextLine();
                    }

            String pccolour;
            if(player_colour.equals("B")){pccolour="W";} else {pccolour="B";}

            while(bunits!=size && wunits!=size)
                {
                    while(player_colour.equals(colour))
                        {

                            String endposition="temp1";
                            String requiredposition="temp2";
                            String startingposition="temp3";
                            String piece ="temp4";
                            int startindex=-1;
                            int endindex=-1;
                            int jumps=0;

                            while(!endposition.equals(requiredposition))
                                {	
                                        System.out.println("");

                                    System.out.println("Make your move, " + colour);
                                    String move= textscanner.nextLine();
                                    if(move.equals("QUIT")){System.exit(0);}

                                    if(move.equals("PASS"))
                                        {
                                            if(colour.equals("B")){colour="W";} 
                                            else {colour="B";}
                                        }

                                    startingposition=move.substring(0,2);
                                    endposition=move.substring(2,4);


                                    Functions.Piece Piece =new Functions.Piece();

                                    piece =Piece.Piece(board2,index2,startingposition);

                                    Functions.Index Index = new Functions.Index();
                                    startindex = Index.Index(board2,index2,startingposition);
                                    endindex = Index.Index(board2,index2,endposition);


                                    board3=ReIndex.ReIndex(board2,size);
                                    index3=ReIndex.ReIndex(index2,size);


                                    Functions.MovementDirection MovementDirection = new Functions.MovementDirection();

                                    direction=MovementDirection.MovementDirection(direction_of_movement,index3,startingposition,endposition,size);
                                    jumps=NumberOfJumps.NumberOfJumps(index3,board3,startingposition,endposition,size,direction_of_movement,direction);

                                    int jumps_delta =NumberOfJumps.NumberOfJumps(index3,board3,endposition,endposition,size,direction_of_movement,direction);


                                    Functions.SupposedNumberofJumps SupposedNumberofJumps = new Functions.SupposedNumberofJumps();
                                    boolean correct_number_of_jumps=SupposedNumberofJumps.SupposedNumberofJumps(direction_of_movement,jumps,size,direction,index3,board3,startingposition,endposition,jumps_delta);


                                    Functions.RequiredPosition RequiredPosition = new Functions.RequiredPosition();
                                    requiredposition=RequiredPosition.RequiredPosition(index3,board3,size,direction,jumps,startingposition,endposition);
                                    if(!endposition.equals(requiredposition)){System.out.println("ERROR:Illegal Move");}


                                }

                            if(board2[endindex].equals(".") && !board2[startindex].equals(".") && requiredposition.equals(endposition) && jumps!=0
                                    && board2[startindex].equals(colour))
                                {	
                                        for(int i=0;i<board2.length;i++)
                                            {
                                                if(i==startindex){board2[i]=".";}
                                            }				

                                        for(int i=0;i<board2.length;i++)
                                            {
                                                if(i==endindex){board2[i]=piece;}
                                            }
                                }

                            else
                                {
                                    System.out.println("ERROR: Illegal Move");
                                }

                            board3=ReIndex.ReIndex(board2,size);
                            index3=ReIndex.ReIndex(index2,size);
                            board4=Board.Board(board3,alphabet2,alphabet3,size);

                            Functions.Units Units = new Functions.Units();

                            bunits=Units.Units("B",index3,board3,board2,size);
                            wunits=Units.Units("W",index3,board3,board2,size);

                            if(bunits==size||wunits==size)
                                {
                                    System.out.println("WINNER:"+colour);
                                    System.exit(0);
                                }

                            if(colour.equals("B"))
                                {colour="W";}
                            else {colour="B";} 								
                        }

                    for(int i=0;i<size+1;i++)
                        {
                            System.out.println("");
                            for(int j=0;j<size+1;j++)
                                {
                                  System.out.print(board4[i][j]+" ");
                                }
                        }

                    System.out.println("");





                    while(colour.equals(pccolour))

                    {



                        Functions.PCEndBoardPositionCheck PCEndBoardPositionCheck = new Functions.PCEndBoardPositionCheck();

                        int pcendindex=-1;
                        boolean check=false;
                        boolean check2 =false;
                        int pcstartingindex=-1;
                        int pcwhilecounter=0;

                        String pcendposition="temp1";
                        pcrequiredposition="temp2";

                        Functions.PossibleMoves2 PossibleMoves2=new Functions.PossibleMoves2();
                        String pcstartingposition=PossibleMoves2.PossibleMoves2(index2,board2,pccolour,size);

                        double d=Math.random();
                        int n =(int)(d*8);

                        Functions.PCNumberofJumps PCNumberofJumps = new Functions.PCNumberofJumps();

                        int[] pcjumps_array=PCNumberofJumps.PCNumberofJumps(index3,board3,pcstartingposition,"na" ,size,direction_of_movement,"na");


                        int pcjumps=0;
                        String pcdirection="Undetermined";
                        int correct_index=-1;

                        for(int i=0;i<8;i++)
                            {
                                pcjumps=pcjumps_array[i];
                                pcdirection=direction_of_movement[i];



                                Functions.PCRequiredPosition PCRequiredPosition =new Functions.PCRequiredPosition();
                                pcrequiredposition=PCRequiredPosition.PCRequiredPosition(index3,board3,size,pcdirection,pcjumps,pcstartingposition);

                                if(board2[Index.Index(board2,index2,pcrequiredposition)].equals(".")){correct_index=i; break;}

                            }   


                        if(board2[Index.Index(board2,index2,pcrequiredposition)].equals("."))
                            {
                                board2[Index.Index(board2,index2,pcstartingposition)]=".";
                                board2[Index.Index(board2,index2,pcrequiredposition)]=pccolour;
                            }

                        board3=ReIndex.ReIndex(board2,size);
                        index3=ReIndex.ReIndex(index2,size);

                        board4=Board.Board(board3,alphabet2,alphabet3,size);


                        Functions.Units Units = new Functions.Units();

                         bunits=Units.Units("B",index3,board3,board2,size);
                         wunits=Units.Units("W",index3,board3,board2,size);
                        
                        System.out.println("B Units`: "+bunits + "WUnits: "+wunits);

//                        if(bunits==size||wunits==size)
//                            {
//                                if(bunits==size && wunits==size)
//                                {
//                                System.out.println("Draw");
//                                System.exit(0);
//                                }
//                            
//                                else 
//                                {
//                                System.out.println("WINNER:"+colour);
//                                System.exit(0);
//                                }
//                            }
//

                        if(colour.equals("B"))
                            {
                                colour="W";
                            }
                        else 
                            {
                                colour="B";
                            }

                        }


                    System.out.print("PC has moved");

                    System.out.print("");


                    for(int i=0;i<size+1;i++)
                        {
                            System.out.println("");
                            for(int j=0;j<size+1;j++)
                                {
                                  System.out.print(board4[i][j]+" ");
                                }
                        }

                    System.out.println("");
                }
        }				

    }
