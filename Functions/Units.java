package Functions;

public class Units{

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
	}
