package Functions;

public class Board{

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
}
