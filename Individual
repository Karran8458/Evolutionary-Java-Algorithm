import java.util.Random;
import java.util.Scanner;


public class Individual 
{
	private boolean[] chromosome = new boolean[lchrom+1];
	private static int lchrom = 100;
	private int[]arraytemp = new int[81];
	private int[][] grid = new int[9][9];
	//private int[]arraytemp = {4,5,2,3,9,1,8,7,6,3,1,8,6,7,5,2,9,4,6,7,9,4,2,8,3,1,5,8,3,1,5,6,4,7,2,9,2,4,5,9,8,7,1,6,3,9,6,7,2,1,3,5,4,8,7,9,6,8,5,2,4,3,1,1,8,3,7,4,9,6,5,2,5,2,4,1,3,6,9,8,7};
	private double x;
	private double fitness;
	private int parent1;
	private int parent2;
	private int xsite;
	
	public Individual ()
	{
		x = 0;
		fitness = 0;
		parent1 = 0;
		parent2 = 0;
		xsite = 0;
	}
	
	
	public float decode(boolean[] chromosome, int lbits)
	{
		int j;
		float accum, powerof2;
		lbits=lchrom-1;
		accum = 0;
		powerof2=1;
		for (j=lbits-1;j>=0;j--)
		{
			if(chromosome[j])
			{
				accum= accum + powerof2;
			}
			powerof2*=2;
		}
		float decode=accum;
		return decode;
	}
	//--------------------------------------------------------------
		// Sets x to have the same value as the 
		// base 10 integer of the boolean array (string).
		// Precondition: Passes in int xvalue.
		// Postcondition: Puts the value of xvalue to 
		// be the value of x.
		//--------------------------------------------------------------
		public void setX(int xvalue)
		{
			x = xvalue;
		}
			
		//--------------------------------------------------------------
		// Returns the value of x. 
		// Precondition: None
		// Postcondition: Returns x to the calling method. 
		//--------------------------------------------------------------
		public double getX()
		{
			return x;
		}
			
		//--------------------------------------------------------------
		// Sets the fitness to have the same value as the 
		// f(x) of x.
		// Precondition: Passes in double fitness1.
		// Postcondition: Puts the value of fitness1 to 
		// be the value of fitness.
		//--------------------------------------------------------------
		public void setFitness(double fitness1)
		{
			fitness = fitness1;
		}
			
		//--------------------------------------------------------------
		// Returns the value of fitness. 
		// Precondition: None
		// Postcondition: Returns fitness to the calling method. 
		//--------------------------------------------------------------
		public double getFitness()
		{
			return fitness;
		}
			
		//--------------------------------------------------------------
		// Sets parent 1 to have the same value as  
		// mate 1.
		// Precondition: Passes in int parent.
		// Postcondition: Puts the value of parent to 
		// be the value of parent1.
		//--------------------------------------------------------------
		public void setParent1(int parent)
		{
			parent1 = parent;
		}
			
		//--------------------------------------------------------------
		// Returns the value of parent 1. 
		// Precondition: None
		// Postcondition: Returns parent 1 to the calling method. 
		//--------------------------------------------------------------
		public int getParent1()
		{
			return parent1;
		}
		//--------------------------------------------------------------
		// Sets parent 2 to have the same value as 
		// mate 2.
		// Precondition: Passes in int parent.
		// Postcondition: Puts the value of parent to 
		// be the value of parent2.
		//--------------------------------------------------------------
		public void setParent2(int parent)
		{
			parent2 = parent;
		}
			
		//--------------------------------------------------------------
		// Returns the value of parent 2. 
		// Precondition: None
		// Postcondition: Returns parent 2 to the calling method. 
		//--------------------------------------------------------------
		public int getParent2()
		{
			return parent2;
		}
			
		//--------------------------------------------------------------
		// Sets the crossing point to have the same value as  
		// xsite.
		// Precondition: Passes in int crossingPoint.
		// Postcondition: Puts the value of crossingPoint to 
		// be the value of xsite.
		//--------------------------------------------------------------
		public void setCrossingpoint(int crossingPoint)
		{
			xsite = crossingPoint;
		}
			
		//--------------------------------------------------------------
		// Returns the value of the crossing point. 
		// Precondition: None
		// Postcondition: Returns xsite to the calling method. 
		//--------------------------------------------------------------
		public int getCrossingPoint()
		{
			return xsite;
		}
		//--------------------------------------------------------------
		// The getChrom method returns the array chromosome to the calling method.
		// Precondition: None
		// Postcondition: Returns chromosome to the calling method. 
		//--------------------------------------------------------------
		public boolean[] getChrom()
		{
			return chromosome;
		}
		//--------------------------------------------------------------
		// The method setChrom sets a new boolean chromosome array. 
		// Precondition: None
		// Postcondition: Uses a for loop to set all values for chromosome. 
		//--------------------------------------------------------------
		public void setChrom(int lchrom, boolean rand)
		{
		    for (int i = 1; i < lchrom+1; i++)
		    {
		    	chromosome[i] = rand;
		    }
		}
		
		//-------------------------------------------------------------------
		// The flip method returns either true or false given a biased probability.
		// Precondition: double probability is passed in as a parameter.
		// Postcondition: If the random value is lower than the probability, then
		// it will return true. Otherwise, it will return false.
		//-------------------------------------------------------------------
		public static boolean flip(double probability)
		{
				
			if (Math.random() < probability)
			{
				return true;
			}
			return false;
		}
		
		//--------------------------------------------------------------
		// The setLchrom sets the length of the chromosome every time a mutation happens. 
		// Precondition: None
		// Postcondition: Sets the variable lchrom. 
		//--------------------------------------------------------------
		public static void setLchrom(int lchrom1)
		{
			lchrom = lchrom1;
		}
		
		//--------------------------------------------------------------
		// The getLchrom method returns the length of the chromosome to the calling method.
		// Precondition: None
		// Postcondition: Returns lchrom to the calling method. 
		//--------------------------------------------------------------
		public static int getLchrom()
		{
			return lchrom;
		}	
		
	//------------------------------------------------------------------------------------------------
	//This method changes the content of the Sudoku puzzles at a certain position with a single value. 
	//It takes a position and a value as parameters.	
	//------------------------------------------------------------------------------------------------
	public void setArray(int i, int num)
	{
		arraytemp[i] = num;
	}
		
	//This method returns one position in the Sudoku puzzle back to the calling method.
	public int getArray(int i)
	{
		return arraytemp[i];
	}
	
	//This method returns the entire Sudoku puzzle back to the calling method.
	public int[] getArray()
	{
		return arraytemp;
	}
	
	public void writechrom(boolean[] array, int length)
	{
		Random ran = new Random();
	    for (int i = 1; i < length; i++)
	    {
	    	array[i] = ran.nextBoolean();
	    }
	}
	
	public String generateString(boolean[] array)
	{
		char[] reparray = new char[lchrom+1];
		for (int j=1; j<= lchrom;j++)
		{
			if (array[j]==true)
			{
				reparray[j]='1';
			}
			else if (array[j]==false)
			{
				reparray[j]='0';
			}
		}
		String str = new String(reparray);
		return str;
	}
	
	public void printGrid1(int i)
	{
		for (int a=0;a<81;a++)
		{
			System.out.print(arraytemp[a] + " ");
			if (a==8)
			{
				System.out.println();
			}
			else if (a==17)
			{
				System.out.println();
			}
			else if (a==26)
			{
				System.out.println();
			}
			else if (a==35)
			{
				System.out.println();
			}
			else if (a==44)
			{
				System.out.println();
			}
			else if (a==53)
			{
				System.out.println();
			}
			else if (a==62)
			{
				System.out.println();
			}
			else if (a==71)
			{
				System.out.println();
			}
			else if (a==80)
			{
				System.out.println();
			}
		}
	}
	
	public float objfunc(float x)
	{
		double coef = 1073741823.0;
		float objfunc = ((float) Math.pow(x/coef,10));
		//double num = ((float) Math.pow(x, 10));
		//float objfunc = (float) (num/coef);
		
		return objfunc;
	}
	
	//-----------------------------------------------------------------------------------------------------------------------------------------------------
	//This method checks if the Sudoku puzzle is a complete Sudoku. 
	//I created a temporary array with numbers 1 through 9. 
	//Every time a space in each row, column, and sub-square has a number from this array, I would change that exact value in the temporary array to be 0. 
	//At the end of each row, column or sub-square, I would look for the remaining values in the temporary array and add them up since they are “penalties”. 
	//I would then reset the temporary array for the next row, column, or sub-square.
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	public float objfunc2()
	{
		int value =0;
		
		int[] temp = new int[9]; // checks for each number in Sudoku row, column or subsquare
		
		for (int index = 0; index < 9; index++) // initializes temp
		{
			temp[index]= index+1;
		}
		
		//checks every row
		for (int i = 0; i <9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		// puts penalties into the variable value
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 9; i <18; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 18; i <27; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 27; i <36; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 36; i <45; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 45; i <54; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 54; i <63; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 63; i <72; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i = 72; i <81; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				if (arraytemp[i]==j+1)
				{
					temp[j]=0;
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		//checks every column
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 0; i1 < 9; i1++)
		{
			for (int i = i1; i <81; i+=9)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int i1 = 3; i1 < 27; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 6; i1 < 27; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 9; i1 < 27; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 30; i1 < 54; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 33; i1 < 54; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 36; i1 < 54; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 57; i1 < 81; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		for (int i1 = 60; i1 < 81; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		
		for (int i1 = 63; i1 < 81; i1 = i1 + 9)
		{
			for (int i = i1-3; i < i1; i++)
			{
				for (int j = 0; j < 9; j++)
				{
					if (arraytemp[i]==j+1)
					{
						temp[j]=0;
					}
				}
			}
		}
		
		for (int x = 0; x < 9; x++)
		{
			if (temp[x]==x+1)
			{
				value += x;
			}
		}
		
		for (int index = 0; index < 9; index++)
		{
			temp[index]= index+1;
		}
		
		float objfunc = value;
		
		return objfunc;
	}
	
	
	public boolean containedIn3x3Box2(int row, int col, int value) {
		// Find the top left of its 3x3 box to start validating from
		
		int sRow = row / 3 * 3;
		int sCol = col / 3 * 3;
	 
		// Check within its 3x3 box except its cell
		for (int i = sRow; i < sRow + 3; i++)
			for (int j = sCol; j < sCol + 3; j++) {
				if (!(i == row && j == col)) {
					if (grid[i][j] == value){
						return true;
					}
				}
			}
	 
		return false;
	}
	
	public boolean containedInRowCol2(int row, int col, int value) {
		for (int n = 0; n < 9; n++) {
			// Don't check the same cell
			if (n != col)
				if (grid[row][n] == value)
					return true;
			if (n != row)
				if (grid[n][col] == value)
					return true;
		}
	 
		return false;
	}
	/*
	public boolean containedInRowCol(int i, int value)
	{
		if (i < 9)
		{
			for (int i1 = 0; i1 < 9; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (9 < i && i < 18)
		{
			for (int i1 = 9; i1 < 18; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (18 < i && i < 27)
		{
			for (int i1 = 18; i1 < 27; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (27 < i && i < 36)
		{
			for (int i1 = 27; i1 < 36; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (36 < i && i < 45)
		{
			for (int i1 = 36; i1 < 45; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (45 < i && i < 54)
		{
			for (int i1 = 45; i1 < 54; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (54 < i && i < 63)
		{
			for (int i1 = 54; i1 < 63; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (63 < i && i < 72)
		{
			for (int i1 = 63; i1 < 72; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		else if (72 < i && i < 81)
		{
			for (int i1 = 72; i1 < 81; i1++)
			{
				if (i == i1)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		
		for (int i1 = 0; i1 < 81; i1++)
		{
			if (i == i1)
			{
				for (i1 =1;i1 < 81; i1 += 9)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
				
				for (i1=i;i1 < 81; i1 += 9)
				{
					if (arraytemp[i]==value)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	*/

	/*
	public boolean containedIn3x3Box(int i, int num)
	{
		if (i < 3)
		{
			for (int i1 = 3; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (8 < i && i < 12)
		{
			for (int i1 = 3; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (17 < i && i < 21)
		{
			for (int i1 = 3; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (2 < i && i < 6)
		{
			for (int i1 = 6; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (11 < i && i < 15)
		{
			for (int i1 = 6; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (20 < i && i < 24)
		{
			for (int i1 = 6; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (5 < i && i < 9)
		{
			for (int i1 = 9; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (14 < i && i < 18)
		{
			for (int i1 = 9; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (23 < i && i < 27)
		{
			for (int i1 = 9; i1 < 27; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if  (26 < i && i < 30)
		{
			for (int i1 = 30; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (35 < i && i < 39)
		{
			for (int i1 = 30; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (44 < i && i < 48)
		{
			for (int i1 = 30; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i] == num)
					{
						return true;
					}
				}
			}
		}
		else if (29 < i && i < 33)
		{
			for (int i1 = 33; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (38 < i && i < 42)
		{
			for (int i1 = 33; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (47 < i && i < 51)
		{
			for (int i1 = 33; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (32 < i && i < 36)
		{
			for (int i1 = 36; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (41 < i && i < 45)
		{
			for (int i1 = 36; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (50 < i && i < 54)
		{
			for (int i1 = 36; i1 < 54; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (53 < i && i < 57)
		{
			for (int i1 = 57; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (62 < i && i < 66)
		{
			for (int i1 = 57; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (71 < i && i < 75)
		{
			for (int i1 = 57; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (56 < i && i < 60)
		{
			for (int i1 = 60; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (65 < i && i < 69)
		{
			for (int i1 = 60; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (74 < i && i < 78)
		{
			for (int i1 = 60; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (59 < i && i < 63)
		{
			for (int i1 = 63; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (68 < i && i < 72)
		{
			for (int i1 = 63; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		else if (77 < i && i < 81)
		{
			for (int i1 = 63; i1 < 81; i1 = i1 + 9)
			{
				for (int i2 = i1-3; i2 < i1; i2++)
				{
					if (arraytemp[i]==num)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	*/
	
}

