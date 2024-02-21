package staticCoding;

public class Organism {
	
	final private double AUREO = 1.618034;
	
	final public static int INITPOPULATION = 5;
	private static String [] ecosystem = {"warm", "cold", "humid", "water"};
	private static int organismsCounter;
	private static int organismsAlive;
	private static int organismsDead;
	private static int danger;
	
	private String organismEcosystem;
	//private int ecosystemIndex;
	private String name;
	private int longevity;
	private int health;
	private boolean isAlive;
	private boolean isLonesome;
	private boolean isHermaphrodite;
	
	//Constructor
	public Organism(int ecosystemIndex, String name)
	{
		int loneliness = (int)(Math.random()*11);
		int sexuality = (int)(Math.random()*11);
		
		//this.ecosystemIndex = ecosystemIndex;
		organismEcosystem = ecosystem[ecosystemIndex];
		
		this.name = name;
		
		this.health = (int)(Math.random()*100);
		
		this.longevity = (int)(this.health*AUREO);
		
		if(longevity < 5) 
		{
			this.setAlive(false);
			organismsDead++;
		}
		else 
		{
			this.setAlive(true);
		}
		
		if(loneliness > 5)
		{
			this.isLonesome = false;
		}
		else this.isLonesome = true;
		
		if(sexuality > 5)
		{
			this.isHermaphrodite = false;
		}
		else this.isHermaphrodite = true;
		
		organismsCounter++;
		
	}
	
	//Getters & Setters
	public static int getOrganismsCounter()
	{
		return organismsCounter;
	}
	
	public static int getOrganismsAlive()
	{
		updateOrganismsAlive();
		return organismsCounter;
	}
	
	public boolean isAlive() 
	{
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) 
	{
		this.isAlive = isAlive;
	}
	
	public static int getDanger() 
	{
		return danger;
	}
	
	public static void setDanger(int danger) 
	{
		Organism.danger = danger;
	}
	
	public static void organismDies() 
	{
		organismsDead++;
	}
	
	public static void updateOrganismsAlive() 
	{
		organismsAlive = (organismsCounter - organismsDead);
	}
	
	public static void getEcosystem()
	{
		updateOrganismsAlive();
		System.out.println('\n' + "danger: " + danger + '\n' + "organisms counter: " + organismsCounter + '\n' + "organisms alive: " + organismsAlive + '\n' + "organisms dead: " + organismsDead);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void getOrganism()
	{
		System.out.println('\n' + "name: " + name + '\n' + "alive? "+ isAlive + '\n' + "ecosystem: " + organismEcosystem + '\n' + "longevity: " + longevity + '\n' + "health: " + health + '\n' + "lonely? " + isLonesome + '\n' + "Hermaphrodite? " + isHermaphrodite);
	}

	public void getVitals()
	{
		System.out.println('\n' + name + " alive? " + "[" + isAlive + "]" + '\n' + "health: " + "{" + health + "}" + '\n' + "longevity: " + "(" + longevity + ")");
	}
	
	
	//Object methods
	public void eat()
	{
		health = health + 20;
	}
	
	public void reproduce()
	{
		if(this.isHermaphrodite)
		{
			health = health + 50;
			//new Organism(this.ecosystemIndex ,this.name + " child");
			//organismsCounter++;
			//this is wrong, the correct way would be to return a new object and to index that into the ArrayList. For the purpose of this exercise I'll leave it like this.

		}
		else longevity = longevity + 20;
	}
	
	public void hunt()
	{
		health = health + 50;
	}
	
	public void die()
	{
		isAlive = false;
		organismsDead++;
	}
	
	public void getOld()
	{
		if(health != 0)
			health = (health  - (int)(1.5 * danger));
		else longevity = (longevity - 20);
	}
	
	public void vitalCheck()
	{
		if(longevity <= 0)
			die();
		if(health >= 100) longevity = longevity + 10;
		if(health <= 0) longevity = longevity - 50;
	}
	
	public void scape()
	{
		if(!isLonesome)
			longevity = longevity - 20;
		else longevity = longevity - 50;
	}
	
	
	
	
	
}




