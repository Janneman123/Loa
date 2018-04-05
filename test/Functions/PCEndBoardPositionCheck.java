package Functions;

public class PCEndBoardPositionCheck{
	public static Boolean PCEndBoardPositionCheck(String[] board2, int pcendindex){
	boolean check;

	if(board2[pcendindex].equals(".")){check=true;} else {check=false;}

		return(check);
	}
}