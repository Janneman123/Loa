import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



import test.test;
import single.single;


//import Functions2.Functions;
//import test.test;

public class bra{


	

	public static void main(String[] args){
	//int size =Integer.parseInt(args[0]);
	//int mode =Integer.parseInt(args[1]);

	int [] arguments = new int[args.length];

	for (int i=0;i<args.length;i++)
		 		{
		 			arguments[i]=Integer.parseInt(args[i]);
		 		} 

		 	//check for arguments
		if(arguments.length<2)
				{System.out.println("ERROR : too few arguments");
				System.exit(0);
				}

			//check board size
		if(arguments[0]<4|| arguments[0]>16)
			{
				System.out.println("ERROR: illegal size");
				System.exit(0);
			}

		if(arguments[1]>=3 || arguments[1]<0)
			{
				System.out.println("ERROR: illegal mode");
				System.exit(0);
			}
		int size =arguments[0];
		int mode =arguments[1];
	
	test obj =new test();

	while(mode==1)
	{
	obj.main(args);
	}
	

	single obj2 =new single();

		while(mode==2)
	{
	obj2.main(args);
	}
	

}
}