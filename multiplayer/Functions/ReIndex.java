package Functions;

public class ReIndex{

public static String[][] ReIndex(String[] stringarray,int size){
		String[][] temp = new String[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){temp[i][j]=stringarray[i*size+j];}
		}
		return(temp);}
}