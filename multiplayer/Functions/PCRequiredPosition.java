package Functions;

public class PCRequiredPosition{

public static String PCRequiredPosition(String[][] index3,String[][] board3,int size,String direction,int jumps,String startingposition){
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

			
		if(direction.equals("left"))
		{
			requiredposition=index3[startrowindex][startcolumnindex-jumps];
		}

		if(direction.equals("right"))
		{
			requiredposition=index3[startrowindex][startcolumnindex+jumps-2];
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
			requiredposition=index3[startrowindex+jumps-1][startcolumnindex+jumps];
		}


		if(direction.equals("upleft"))

		{
			//increment=Math.pow(((Math.pow(jumps,2))/2),0.5);
			requiredposition=index3[startrowindex-jumps][startcolumnindex-jumps];
		}

				if(direction.equals("downright"))

		{
			//increment=Math.pow(((Math.pow(jumps,2))/2),0.5);
			requiredposition=index3[startrowindex+jumps][startcolumnindex+jumps];
		}

						if(direction.equals("downleft"))

		{
			//increment=Math.pow(((Math.pow(jumps,2))/2),0.5);
			requiredposition=index3[startrowindex+jumps][startcolumnindex-jumps];
		}



		return(requiredposition);}
	}