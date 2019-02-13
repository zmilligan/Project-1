public class HammingDist
{
	private String filename = "Mesonet.txt";
	private ArrayList<String> cities;
	
	private String city1;
	private String city2;
	
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
       	 		cities.add(strg.substring(0, 4));
        		strg = br.readLine();
        	}
        
        	// close reader
        	br.close();
	}
	
	public int hammingDist(String original, String compare)
	{
		return -1;
	}
	
	public int hammingDist(String city, int dist)
	{
		return -1;
	}
	
	public String toString()
	{
		
		return "";
	}
}
