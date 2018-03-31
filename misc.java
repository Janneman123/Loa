//Arguments and checks//
		

			//Draw the board

		




			//Print the board	

		
			



				


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
				System.out.println("WINNER:"+colour);

				//String dir=PossibleMoves(index3,board3,size,"bra",1,"bra","bra",direction_of_movement);
				//System.out.println(dir);
		

				//String dir=PossibleMoves(index3,board3,size,"bra",1,"bra","bra",direction_of_movement);
				//System.out.println(dir);