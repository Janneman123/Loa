
package Functions;


public class SupposedNumberofJumps{


public static boolean SupposedNumberofJumps(String[] direction_of_movement,int jumps,int size, String direction, String[][] index3, String[][] board3,
		String startingposition,String endposition, int jumps_delta){
		int jumps_required=jumps;
		//String direction=MovementDirection(direction_of_movement,index3,startingposition,endposition,size);
		//int jumps_delta =0 ;//=NumberOfJumps(index3,board3,endposition,endposition,size,direction_of_movement,direction);

		boolean correct_number_of_jumps=(jumps_required==jumps_delta);



		return(correct_number_of_jumps);}
}
