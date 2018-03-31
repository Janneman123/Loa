package Functions;

public class PCDirection{

public static String PCDirection(String[][] index3,String[][] board3,int size,String[] direction_of_movement){

		String[] moves={"left","right","down","up","downleft","downright","upleft","upright"};	
		
		double d1 =Math.random();
		double n1=8*d1;
		int m1=(int)(n1);

		//double d2 =Math.random();
		//double n2=size*d2;
		//int row=(int)(n2);

		//double d3 =Math.random();
		//double n3=size*d3;
		//int column=(int)(n2);

		//String pcstartingposition=index3[row][column];
		String pcdirection=direction_of_movement[m1];

		//int pcjumps=NumberOfJumps(index3,board3,pcstartingposition,"bra" ,size,direction_of_movement,pcdirection);

		//String pcrequiredposition= "test me";//RequiredPosition(index3,board3,size,pcdirection,pcjumps,pcstartingposition,"bra");
		//startingposition=




		return(pcdirection);}
}