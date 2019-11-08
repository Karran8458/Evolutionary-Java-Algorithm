import java.util.Random;
import java.util.Scanner;


public class SGA 
{
	public static int gen;
	public static int maxgen=2;
	public static Population newpop = new Population();
	public static Population oldpop = new Population();
	
	
	
	
		public static void main(String[] args)
		{
			SGA.oldpop = new Population();
			SGA.newpop = new Population();
			
			gen = 0;
		
			SGA.oldpop.initialize();
					
			do
			{
			
				gen= gen +1;
						
				oldpop.generation();
				SGA.oldpop.statistics();
				oldpop.report();
				oldpop.changeIndex();
				if (oldpop.checkSudoku(1))
				{
					gen = maxgen;
				}
				oldpop = newpop;
				SGA.newpop = new Population();
				
				
			
			} while (gen < maxgen);
			
		}
}


