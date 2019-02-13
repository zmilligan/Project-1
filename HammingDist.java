/**
 * This class determines the Hamming Distance between two given cities and between the cities in a file
 * 
 * @author - Zandi Milligan
 * @version 2019-02-13
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist
{
	/**
	 * The name of the file from which the other cities are retrieved
	 */
	private String filename = "Mesonet.txt";
	/**
	 * The number of cites from the file
	 */
	private final int NUMCITIES = 120;
	/**
	 * The ArrayList to hold all of the cities from the file
	 */
	private ArrayList<String> cities;
	
	/**
	 * The four-letter abbreviation of the name of the first city
	 */
	private String city1;
	/**
	 * The four-letter abbreviation of the name of the second city
	 */
	private String city2;
	
	/**
	 * The hamming distance between city1 and city2
	 */
	private distance;
	/**
	 * Array holding the hamming distances between city1 and the other cities in the file
	 * index 0 holds the number with distance 1
	 * index 1 holds the number with distance 2
	 * index 2 holds the number with distance 3
	 * index 3 holds the number with distance 4
	 */
	private int[] city1Dists;
	/**
	 * Array holding the hamming distances between city2 and the other cities in the file
	 * index 0 holds the number with distance 1
	 * index 1 holds the number with distance 2
	 * index 2 holds the number with distance 3
	 * index 3 holds the number with distance 4
	 */
	private int[] city2Dists;
	
	/**
	 * Constructor for a HammingDist object. This constructor reads a file of cities and puts all city abbreviations in an ArrayList
	 * then determines the hamming distance between the two given cities and between each city and the others in the file. It saves
	 * those resulting arrays in the city#Dists arrays.
	 * 
	 * @param city1 String four-letter abbreviation of the first city
	 * @param city2 String four-letter abbreviation of the second city
	 */
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
	
	/**
	 * This method reads from the file and saves the abbreviated city names into the cities ArrayList
	 * 
	 * @throws IOException Throw this exception if a major issue with the file occurs.
	 */
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
	
	/**
	 * This method determines the hamming distance (1, 2, 3, 4) between the two given cities
	 * 
	 * @param original String the first city
	 * @param compare String the second city to be compared to the first
	 * @return int number 1-4 representing the hamming distance between the two given cities
	 */
	public int findHammingDist(String original, String compare)
	{
		int dists = 0;
		for(int index = 0; index < original.length(); ++index)
		{
			if(original.charAt(index) != compare.charAt(index))
			{
				++dists;
			}
		}
		return dists;
	}
	
	/**
	 * This method finds the hamming distances between the given city and all other cities in the file. It saves those distances in
	 * an int array
	 * 
	 * @param city String the name of the city to compare
	 * @return int[] an array of hamming distances. Index 0 holds the number of those of hamming dist 1, index 1 holds the number
	 * of cities of hamming distance 2, and indexes 2 and 3 for distances 3 and 4 respectively. 
	 */
	public int[] hammingDist(String city)
	{
		int[] distances = new int[4];
		int dist1 = 0;
		int dist2 = 0;
		int dist3 = 0;
		int dist4 = 0;
		
		for(String comp : cities)
		{
			int tempDist = findHammingDist(city, comp);
			// update the correct variable based on the hamming distance
			//NOTE: the distance will only be 0 for the original city, so we don't need to count that one.
			if(tempDist == 1)
				++dist1;
			if(tempDist == 2)
				++dist2;
			if(tempDist == 3)
				++dist3;
			if(tempDist == 4)
				++dist4;
		}
		
		//put the distances into the array at the proper index
		distances[0] = dist1;
		distances[1] = dist2;
		distances[2] = dist3;
		distances[3] = dist4;
		
		return distances;
	}
	
	 /**
     	* toString override. Gives all information about the hamming distances.
     	* 
     	* @return All information about the hamming distances formatted as (replacing parentheses with member variables):
     	* The Hamming Distance of (city1) and (city2): (distance).
     	* Out of (NUMCITIES - 1), for (city1), number of nodes are: (city1Dists[0]), (city1Dists[1]), (city1Dists[2]), (city1Dists[3]) and
     	* for (city2), number of nodes are: (city2Dists[0]), (city2Dists[1]), (city2Dists[2]), (city2Dists[3]) respectively.
     	*/
	@Override
	public String toString()
	{
		return String.format("The Hamming Distance of %s and %s: %d.\n", city1, city2, distance) + 
				String.format("Out of %d, for %s, number of nodes are: %d, %d, %d, %d and\n", 
						NUMCITIES -1, city1, city1Dists[0], city1Dists[1], city1Dists[2], city1Dists[3]) + 
				String.format("for %s, number of nodes are: %d, %d, %d, %d respectively.",
						city2, city2Dists[0], city2Dists[1], city2Dists[2], city2Dists[3]);
	}
}
