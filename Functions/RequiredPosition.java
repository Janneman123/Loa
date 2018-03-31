package Functions;

public class RequiredPosition{

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
			requiredposition=index3[startrowindex-jumps][startcolumnindex+jumps];
		}

				if(direction.equals("downright"))

		{
			//increment=Math.pow(((Math.pow(jumps,2))/2),0.5);
			requiredposition=index3[startrowindex+jumps][startcolumnindex+jumps];
		}



		return(requiredposition);}
	}