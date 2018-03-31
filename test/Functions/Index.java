package Functions;

public class Index{

public static int Index(String[] board2, String index2[], String start_or_end){

		int indexvalue=0;
		for(int i=0;i<index2.length;i++)
		{
			if(index2[i].equals(start_or_end)){indexvalue=i;}
		}

		return(indexvalue);}
}