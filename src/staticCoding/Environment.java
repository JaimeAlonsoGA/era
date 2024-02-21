package staticCoding;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Environment {
	


	public static int numberGenerator(int intervalExclusive)
	{
		return ((int)(Math.random()*intervalExclusive));
	}
	
	public static String nameGenerator() {
		String generatedName = "";
		
		String[][] letter = {
				{"a", "e", "i", "o", "u"},
				{"p", "b", "r", "k", "w", "s", "z", "t", "y"}
		};
		
		int randomIndex = ((numberGenerator(6)) + 2);
		
		for (int i = 0; i < randomIndex; i++) {
			
			int rowIndex = (numberGenerator(2));
			
			int columnIndex = (numberGenerator(letter[rowIndex].length));
			
			generatedName += letter[rowIndex][columnIndex];
		}
		
		return generatedName;
	}
	
	final public static int CATASTROPHE = 5;
	final public static int MILLIONYEARS = 1;
	
	public static void main(String[] args) {
		
		int organismInitiative = 0;
		Scanner input = new Scanner(System.in);
		
		String state = "";
		String begin = "era";
		String end = "end";
		int endOfTheWorld = 0;
		
		Organism.setDanger(numberGenerator(21));

		ArrayList<Organism> organism = new ArrayList<Organism>();
		
		for (int i = 0; i < Organism.INITPOPULATION; i++) {
		
			organism.add(new Organism(numberGenerator(4), nameGenerator()));
		}
		
		for (int i = 0; i < Organism.getOrganismsAlive(); i++) {
			organism.get(i).getOrganism();
		}
		
		Organism.getEcosystem();
		
		do {
			System.out.println('\n' + "Write 'era' to begin");
			state = input.next();
			if(state.equals(begin))
			{
				try 
				{
					do 
					{
						//all the organisms can do an action or none					
						for (int i = 0; i < organism.size(); i++) 
						{
							
							organismInitiative = numberGenerator(5);
							
							//checks if organism is alive
							if(organism.get(i).isAlive())
							{
									switch(organismInitiative) 
									{
									case 0: 
										//does nothing
										System.out.println('\n' + organism.get(i).getName() + " sleeps");

										break;
									case 1:
										organism.get(i).reproduce();
										System.out.println('\n' + organism.get(i).getName() + " has reproduce");
			
										break;
									case 2:
										organism.get(i).hunt();	
										System.out.println('\n' + organism.get(i).getName() + " has hunt");
			
										break;
									case 3:
										organism.get(i).scape();	
										System.out.println('\n' + organism.get(i).getName() + " has scaped");
			
										break;
									case 4: 
										organism.get(i).eat();	
										System.out.println('\n' + organism.get(i).getName() + " has eaten");
			
										break;
									}
									organism.get(i).getOld();
									organism.get(i).vitalCheck();
									organism.get(i).getVitals();
									if(!organism.get(i).isAlive()) System.out.println('\n' + organism.get(i).getName() + " has died");
									System.out.print("--------------------");
									
									TimeUnit.SECONDS.sleep(1);
							}
							
						}
						
						endOfTheWorld += MILLIONYEARS;
						
					} 
					while(endOfTheWorld != CATASTROPHE);
					
					System.out.print('\n' + "-*-*-*-*-*-*-*-*-*-*-*-*");
					Organism.getEcosystem();
					System.out.print("-*-*-*-*-*-*-*-*-*-*-*-*" + '\n');
				
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
				
			}
			// else 
			// {
			// 	System.out.println("Write 'era' to begin or 'end' to exit");
			// 	state = input.next();
			// }
			state = "end";
		}
		while(state.equals(end));
		
	input.close();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
