import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Population 
{
	private static int maxpop = 100;
	private Individual[] poprecord = new Individual[maxpop+1];
	private static int[] sudoku = new int[81];
	private static int gennum;
	private int ncross;
	private static double pcross=1.0;
	private static double pmutation;
	private int nmutation;
	private static float max=0;
	private static float avg=0;
	private static float min=0;
	private static float sumfitness=0;
	private static int index = 0;
	
	
	public Population()
	{
		int j;
		
		for (j = 1; j <= maxpop; j++)
		{
			poprecord[j]= new Individual();
		}
	}
	
	//-------------------------------------------------------------------
	// The initialize method calls on initdata, initpop, statistics and initreport.
	// Precondition: None
	// Postcondition: Four methods are called to initialize.
	//-------------------------------------------------------------------
			public void initialize()
			{
				initdata();
				initpop();
				statistics();
				initreport();
			}
	
			//-------------------------------------------------------------------
			// The initreport method prints information from initdata.
			// Precondition: None.
			// Postcondition: The SGA Parameters and Statistics are printed.
			//-------------------------------------------------------------------
			private static void initreport()
			{
				System.out.println("-----------------------------------------------------");
				System.out.println("     A Simple Genetic Algorithm - SGA - v1.0         ");
				System.out.println("     (c) David Edward Goldberg 1986 ");
				System.out.println("           All Rights Reserved        ");
				System.out.println("-----------------------------------------------------");
				System.out.println("      ******** SGA Parameters *********");
				System.out.println();
				System.out.println("        Population size(popsize)           =     " + Population.maxpop);
				System.out.println("        Chromosome length (lchrom)         =     " + Individual.getLchrom());
				System.out.println("        Maximum # of generation (maxgen)   =     " + SGA.maxgen);
				System.out.println("        Crossover probability (pcross)   =     " + Population.pcross);
				System.out.println("        Mutation probability (pmutation)   =     " + pmutation);
				System.out.println();
				System.out.println();
				System.out.println("          Initial Generation Statistics");
				System.out.println("          -----------------------------");
				System.out.println();
				System.out.println("        Initial population maximum fitness = " + max);
				System.out.println("        Initial population average fitness = " + avg);
				System.out.println("        Initial population minimum fitness = " + min);
				System.out.println("        Initial population sum of fitness = " + sumfitness);
			}
			//-------------------------------------------------------------------
			// The initdata method prints information and scans input from the user.
			// Precondition: Scanner scan is enabled and ch and j are declared.
			// Postcondition: Information is printed for input from the user.
			//-------------------------------------------------------------------
			private static void initdata()
			{
				Scanner scan = new Scanner(System.in);
				char ch;
				int j;
				
				System.out.println("--------------------------------");
				System.out.println("A Simple Genetic Algorithm - SGA");
				System.out.println(" (c) David Edward Goldberg 1986 ");
				System.out.println("     All Rights Reserved        ");
				System.out.println("--------------------------------");
				System.out.println("******** SGA Data Entry and Initialization *********");
				System.out.println("Enter population size: ");
				Population.maxpop = scan.nextInt();
				System.out.println("Enter chromosome length: ");
				int lchrom1 = scan.nextInt();
				Individual.setLchrom(lchrom1);
				System.out.println("Enter maximum generations: ");
				SGA.maxgen = scan.nextInt();
				System.out.println("Enter crossover probability: ");
				Population.pcross = scan.nextDouble();
				System.out.println("Enter mutation probability: ");
				pmutation = scan.nextDouble();
				SGA.oldpop.nmutation = 0;
				SGA.oldpop.ncross = 0;
			}
	
	//-------------------------------------------------------------------
		// The statistics method is adding up the fitness values and storing them in sumfitness
		// then dividing the sumfitness by maxpop to get and return the average.
		// Precondition: j, sumfitness, min and max are instantiated.
		// Postcondition: The fitness values are organized by getting the max and 
		// min values. The method also returns the average.
		//-------------------------------------------------------------------
		int statistics()
		{
			int j;
			sumfitness = (float) this.poprecord[1].getFitness();
			min = (float) this.poprecord[1].getFitness();
			max = (float) this.poprecord[1].getFitness();
			for(j=2;j<=maxpop;j++)
			{
				sumfitness = sumfitness + (float) this.poprecord[j].getFitness();
				if ((float)this.poprecord[j].getFitness() > max)
				{
					max = (float) this.poprecord[j].getFitness();
				}
				if ((float)this.poprecord[j].getFitness() < min)
				{
					min = (float) this.poprecord[j].getFitness();
				}
			}
			
			avg = sumfitness/maxpop;
			return (int) avg;
		}
	//----------------------------------------------------------------------------------------------------------------------------
	//This method has a new crossover method and puts a random value for one empty space in the Sudoku puzzles in that generation. 
	//This method also checks to see if any of the Sudoku puzzles in that generation find a solution with the checkSudoku method.
	//----------------------------------------------------------------------------------------------------------------------------
	public void generation()
	{
		int j, mate1, mate2, jcross = 0;
		j=1;
		
		while (j <= maxpop)
		{
		
			mate1 = /*select(maxpop, sumfitness)*/j;
			mate2 = /*select(maxpop, sumfitness)*/j+1;
			int value = pseudorandom(1,9);
			if (SGA.oldpop.poprecord[j].getArray(index)==0)
			{
				//SGA.oldpop.poprecord[j].setArray(index, value);
				//SGA.oldpop.poprecord[j+1].setArray(index, value);
				sudoku[index]=value;
				for (int i = index; i >= 0; i--)
				{
					SGA.oldpop.poprecord[j].setArray(i, sudoku[i]); 
					SGA.oldpop.poprecord[j+1].setArray(i, sudoku[i]);
				}
				for (int i = index; i >= 0; i--)
				{
					if (SGA.oldpop.poprecord[j].getArray(index)==sudoku[i])
					{
						int value2 = pseudorandom(1,9);
						SGA.oldpop.poprecord[j].setArray(i, value2);
						SGA.oldpop.poprecord[j+1].setArray(i, value2);
					}
				}
			}
			
			
			//crossover(this.poprecord[mate1].getChrom(), this.poprecord[mate2].getChrom(), SGA.newpop.poprecord[j].getChrom(), SGA.newpop.poprecord[j+1].getChrom());
			crossover2(this.poprecord[mate1].getArray(), this.poprecord[mate2].getArray(), SGA.newpop.poprecord[j].getArray(), SGA.newpop.poprecord[j+1].getArray());
			
			//SGA.newpop.poprecord[j].setX((int) SGA.newpop.poprecord[j].decode(SGA.newpop.poprecord[j].getChrom(),SGA.newpop.poprecord[j].getLchrom()+1));
			//SGA.newpop.poprecord[j].setFitness(SGA.newpop.poprecord[j].objfunc((float) SGA.newpop.poprecord[j].getX()));
			SGA.newpop.poprecord[j].setFitness(SGA.newpop.poprecord[j].objfunc2());
			SGA.newpop.poprecord[j].setParent1(mate1);
			SGA.newpop.poprecord[j].setParent2(mate2);
			SGA.newpop.poprecord[j].setCrossingpoint(jcross);
			
			
			//SGA.newpop.poprecord[j+1].setX((int) SGA.newpop.poprecord[j+1].decode(SGA.newpop.poprecord[j+1].getChrom(),SGA.newpop.poprecord[j].getLchrom()+1));
			//SGA.newpop.poprecord[j+1].setFitness(SGA.newpop.poprecord[j+1].objfunc((float) SGA.newpop.poprecord[j+1].getX()));
			SGA.newpop.poprecord[j].setFitness(SGA.newpop.poprecord[j].objfunc2());
			SGA.newpop.poprecord[j+1].setParent1(mate1);
			SGA.newpop.poprecord[j+1].setParent2(mate2);
			SGA.newpop.poprecord[j+1].setCrossingpoint(jcross);
			//Math.pow(SGA.newpop.poprecord[j+1].x,2);
			if (checkSudoku(j))
			{
				j = maxpop+1;
			}
			
			j+=2;
			
		}	
		
	}
	
	public int select(int popsize, float sumfitness)
	{
		Random random = new Random();
		float partsum;
		int j=0;
		partsum = 0;
		float rand = (float) (random.nextDouble() * sumfitness);
		do
		{
			j+=1;
			partsum = (float) (partsum + this.poprecord[j].getFitness());
		} while (partsum < rand && j != popsize);
		
		return j;
	}
	
	public void crossover(boolean[] parent1, boolean[] parent2, boolean[] child1, boolean[] child2)
	{
		int j;
		int jcross;
		
		if (flip(pcross))
		{
			jcross = pseudorandom(1, Individual.getLchrom());
			ncross = ncross + 1;
		}
		else
		{
			jcross = Individual.getLchrom()+1;
		}
		
		for (j = 1; j < jcross; j++)
		{
			child1[j] = mutation(parent1[j]);
			child2[j] = mutation(parent2[j]);
		}
		
		if (jcross != Individual.getLchrom()+1)
		{
			for (j = jcross+1; j <= Individual.getLchrom(); j++)
			{
			child1[j]= mutation(parent2[j]);
			child2[j]= mutation(parent1[j]);
			}
		}
	}
	//----------------------------------------------------------------------------------------------------
	//This method crosses over each Sudoku puzzle with an empty Sudoku puzzle with 0s in vacant positions. 
	//This method has parameters for int arrays because the old one used Boolean arrays.
	//----------------------------------------------------------------------------------------------------
	public void crossover2 (int [] parent1, int [] parent2, int[] child1, int[] child2)
	{
		int j;
		int jcross;
		jcross = pseudorandom(1,81);
		
		if (flip(pcross))
			{
				jcross = pseudorandom(1,81);
				ncross += 1;
			}
		
		for (j = 1; j < jcross; j++)
		{
			child1[j]=mutation2(parent1[j]);
			child2[j]=mutation2(parent2[j]);
		}
		
		for (j = jcross; j < 81; j++)
		{
			child1[j]=mutation2(parent2[j]);
			child2[j]=mutation2(parent1[j]);
		}
	}
	//-------------------------------------------------------------------------------------------------------------------------------
	//This method mutates one vacant spot in the Sudoku puzzle. 
	//It passes in an int value  and returns an int value because the old one passed in a Boolean value and returned a Boolean value.
	//-------------------------------------------------------------------------------------------------------------------------------
	public int mutation2 (int value)
	{
		if (value == 0)
		{
		boolean mutate= flip (pmutation);
			if (mutate)
			{	
				return value;	
			}
		}
		return value;
		
	}
	
	public void changeIndex()
	{
		index++;
	}
	
	public static boolean flip(double probability)
	{
		
		if (Math.random() < probability)
		{
			return true;
		}
		return false;
		
	}
	
	public void setGen(int generation)
	{
		gennum = generation;
	}
	
	public int getGen()
	{
		return gennum;
	}
	
	//--------------------------------------------------------------
		// The getLchrom method returns minimum fitness to the calling method.
		// Precondition: None
		// Postcondition: Returns minFitness to the calling method. 
		//--------------------------------------------------------------
		public double getminFitness()
		{
			return min;
		}
		
		//--------------------------------------------------------------
		// The getLchrom method returns the maximum fitness to the calling method.
		// Precondition: None
		// Postcondition: Returns maxFitness to the calling method. 
		//--------------------------------------------------------------
		public double getmaxFitness()
		{
			return max;
		}
		
		//--------------------------------------------------------------
		// The getLchrom method returns the average fitness to the calling method.
		// Precondition: None
		// Postcondition: Returns avgFitness to the calling method. 
		//--------------------------------------------------------------
		public double getavgFitness()
		{
			return avg;
		}
		
		//--------------------------------------------------------------
		// The getLchrom method returns the sum of the fitness to the calling method.
		// Precondition: None
		// Postcondition: Returns sumFitness to the calling method. 
		//--------------------------------------------------------------
		public double getsumFitness()
		{
			return sumfitness;
		}
	
	public boolean mutation(boolean alleleval)
	{
		boolean mutate;
		mutate = flip(pmutation);
		
		if (mutate)
		{
			nmutation = nmutation + 1;
			return !alleleval;
		}
		else
		{
			return alleleval;
		}
		
	}
	
	//----------------------------------------------------------------------------------------------------------
	//This method checks if the Sudoku puzzles being crossed over in the generation method are complete Sudokus. 
	//The value being passed into this method is the value from the generation method. 
	//The value being checked in the method is from the objective function. 
	//A complete Sudoku from the objective function would be 0 since it has no penalties. 
	//If the value is 0 in the checkSudoku method, the method would return 0.
	//-----------------------------------------------------------------------------------------------------------
	public boolean checkSudoku(int j)
	{
		double value = SGA.newpop.poprecord[j].getFitness();
		
		if (value == 0.0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//--------------------------------------------------------------
	//This method converts from a string to a one-dimensional array. 
	//It takes a one-dimensional array and a string as parameters. 
	//It uses Unicode to transfer each character to the array.
	//---------------------------------------------------------------
	public String IntArrayToString(int []arrayofnumbers)
	{
		String temp = "";
		for (int i = 0; i <81; i++)
		{
			temp += Integer.toString(arrayofnumbers[i]);
		}
		return temp;
	}
	
	//--------------------------------------------------------------
	//This method converts from a string to a one-dimensional array. 
	//It takes a one-dimensional array and a string as parameters. 
	//It uses Unicode to transfer each character to the array.
	//--------------------------------------------------------------
	public void StringToIntArray(String firststring, int[] arrayofnumbers)
	{
		/*
		for(int i=0;i<firststring.length();i++) 
		{
		      if (!Character.isDigit(firststring.charAt(i))) 
		      {
		        System.out.println("Contains an invalid digit");
		        break;
		      }
		      setArray(i,arrayofnumbers,Integer.parseInt(String.valueOf(firststring.charAt(i))));
		 }
		*/
		System.out.println("Array:" + " ");
		
		for (int i = 0; i < 81;i++)
		{
			
			arrayofnumbers[i]=firststring.charAt(i)-48;
				System.out.println(arrayofnumbers[i]);
		}
	}
	
	//-------------------------------------------------------------------
	// The report method prints the information including the strings, x values, 
	// fitness values, parent values, crossing point values, and statistics.
	// Precondition: j and linelength are declared.
	// Postcondition: The information is printed in a line by line format 
	// calling the repchar method for spacing out the details.
	// For this method, I needed to print 30 Sudoku puzzles for each generation.
	//-------------------------------------------------------------------
		public void report()
		{
			int linelength = 132;
			int j;
			repchar('-',linelength+57); 
			System.out.println();
			repchar(' ',50); 
			System.out.println("Population Report");
			repchar(' ',23); 
			System.out.print("Generation " + (SGA.gen-1));
			repchar(' ',57); System.out.println("Generation " + SGA.gen);
			System.out.println();
			System.out.print(" #                  string            x            fitness");
			System.out.print("                         #    parents xsite");
			System.out.println("          string                        x            fitness");
			repchar('-',linelength);
			System.out.println();
			for (j=1; j <= maxpop; j++)
			{
				System.out.println("" + j + ")" + IntArrayToString(SGA.oldpop.poprecord[j].getArray())/*IntArrayToString(sudoku)*/ + "  " + SGA.oldpop.poprecord[j].getX() + " " + SGA.oldpop.poprecord[j].getFitness() + "          |    " + j + ")  " + "(" + SGA.newpop.poprecord[j].getParent1() + "," + SGA.newpop.poprecord[j].getParent2() + ")" + "    " + SGA.newpop.poprecord[j].getCrossingPoint() + " " + IntArrayToString(SGA.oldpop.poprecord[j].getArray()) + "  " + SGA.newpop.poprecord[j].getX() + "  " + SGA.newpop.poprecord[j].getFitness());
			}
			repchar('-',linelength+57);
			System.out.println();
			System.out.println("Note: Generation 1 & Accumulated Statistics: " + "    max = " + max + "    min = " + min + "    avg = " + avg + "    sum = " + sumfitness + "     nmutation = " + SGA.oldpop.nmutation + "    ncross = " + SGA.oldpop.ncross);
			repchar('-',linelength+57);
			System.out.println();
		}
		
		//-------------------------------------------------------------------
		// The repchar method is used to space out information.
		// Precondition: j is declared.
		// Postcondition: the character that is passed in is printed multiple times.
		//-------------------------------------------------------------------
		private void repchar(char ch, int repcount)
		{
			int j;
			for (j=1; j < repcount; j++)
			{
				System.out.print(ch);
			}
		}
		
	// This method creates a new empty array.
	public static void setSudokuString()
	{
		for (int i1 = 1; i1 <= maxpop; i1++)
		{
			for (int i = 0; i <81; i++)
			{
				SGA.oldpop.poprecord[i1].setArray(i, 0);
				sudoku[i]=0;
			}
		}
		/*
		for (int i = 1; i <= maxpop; i++)
		{
		SGA.oldpop.poprecord[i].printGrid1(i);
		}
		*/
	}
		
	private static int pseudorandom(int lowerLimit, int upperLimit)
	{
	Random generator = new Random(); 
	int randomnumber;
	randomnumber = generator.nextInt((upperLimit-lowerLimit)+1) + lowerLimit;
	return randomnumber; 
	}
	
	
		//-------------------------------------------------------------------
		// The initpop method initializes the chromosome values, the x values, 
		// the fitness values, the parent1 and parent2 values, and the crossing point value.
		// Precondition: None.
		// Postcondition: The for loops initializes all the indices of poprecord and 
		// instantiates the values of chromosome.
		//-------------------------------------------------------------------
		public static void initpop()
		{   
			System.out.println(maxpop);
			for (int i=1; i<= maxpop;i++)
			{
				/*
				for (int j1=1;j1 < lchrom; j1++)
				{
					SGA.oldpop.poprecord[i].chromosome[j1] = flip(0.5);
				}
				*/
				
				boolean truth = flip(0.5);
				SGA.oldpop.poprecord[i].setChrom(i, truth);
			}
			
			for (int i1 = 1; i1 <= maxpop; i1++)
			{
				setSudokuString();
				SGA.newpop.poprecord[i1].setParent1(0);
				SGA.newpop.poprecord[i1].setParent2(0);
				SGA.newpop.poprecord[i1].setCrossingpoint(0);
			}
			
			
			/*
			for (int i = 0; i < 81; i++)
			{
			SGA.oldpop.poprecord[1].setArray(i, pseudorandom(1,9));
			}
			*/
			/*
				for (int j=1; j<= maxpop;j++)
				{
				SGA.oldpop.poprecord[j].setX((int)SGA.oldpop.poprecord[j].decode(SGA.oldpop.poprecord[j].getChrom(),SGA.newpop.poprecord[j].getLchrom()));
				SGA.oldpop.poprecord[j].setFitness((float)SGA.oldpop.poprecord[j].objfunc((float) SGA.oldpop.poprecord[j].getX()));
				SGA.oldpop.poprecord[j].setParent1(0);
				SGA.oldpop.poprecord[j].setParent2(0);
				SGA.oldpop.poprecord[j].setCrossingpoint(0);
				}
				*/
				
				/*
			}
			*/
		}
	
}

