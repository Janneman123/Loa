package Functions;

public class MovementDirection{

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

		 if (endrowindex>startrowindex && endcolumnindex<startcolumnindex)
		{
			direction ="downleft";
		}

			 if (endrowindex>startrowindex && endcolumnindex>startcolumnindex)
		{
			direction ="downright";
		}

		//else if (endrowindex<startrowindex && endcolumnindex>startcolumnindex)
		//{
			//direction ="downright";
		//}



		return(direction);}
}