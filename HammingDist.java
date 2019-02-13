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
	private String filename = "Mesonet.txt";
	private ArrayList<String> cities;
	
	private String city1;
	private String city2;
	
	private distance;
	private int[] city1Dists;
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
