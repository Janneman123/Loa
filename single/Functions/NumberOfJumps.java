package Functions;

public class NumberOfJumps{

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
						//i=i-1;
						//j=j-1;
						if((board3[i][j]!=".") && index3[i][j]!=startingposition){downrightdirectioncount+=1;}
						if(j==size-1){break;}
						if(j!=size-1){j+=1;}
					}


				

			for(int i=startcolumnindex,j=startcolumnindex;i<size;i++)
			
					
					{	if(j==0){break;}
						//j-=1;
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
							//j=j+1;
						if((board3[i][j]!=".") && index3[i][j]!=startingposition){uprightdirectioncount+=1;}
						//System.out.println(board3[i][j]);
						//System.out.print(i + " "+ j);
						if(j==size-1){break;}	
						if(j!=size-1){j+=1;}	

					}



			number_of_moves[0]=leftdirectioncount;
			number_of_moves[1]=rightdirectioncount;
			number_of_moves[2]=updirectioncount;
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
	}