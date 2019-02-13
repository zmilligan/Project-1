public class HammingDist
{
	private String filename = "Mesonet.txt";
	private ArrayList<String> cities;
	
	private String city1;
	private String city2;
	
	private distance;
	private int[] city1Dists;
	private int[] city2Dists;
	
	public HammingDist(String city1, String city2)
	{
		this.city1 = city1;
		this.city2 = city2;
		
		try
    		{
    			readFile();
    		}
    		catch(IOException e)
    		{
    			System.out.println("Error reading from file!\n");
    			e.printStackTrace();
    		}
		
		distance = findHammingDist(city1, city2);
		city1Dists = hammingDist(city1);
		city2Dists = hammingDist(city2);
	}
	
	public void readFile()
	{
		cities = new ArrayList<String>(120);
		
		// Use a buffered Reader on the file:
    		BufferedReader br = new BufferedReader(new FileReader(filename));
        	String strg;
        
        	// read in the first three lines not important
        	strg = br.readLine();
        	strg = br.readLine();
        	strg = br.readLine();
        
        	//read in the first readable line
        	strg = br.readLine();
        	while(strg != null)
        	{
       	 		cities.add(strg.substring(1, 5));
        		strg = br.readLine();
        	}
        
        	// close reader
        	br.close();
	}
	
	public int findHammingDist(String original, String compare)
	{
		return -1;
	}
	
	public int[] hammingDist(String city)
	{
		return null;
	}
	
	public String toString()
	{
		
		return "";
	}
}
