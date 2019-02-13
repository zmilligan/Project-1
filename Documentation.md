# Project-1
CS 2334 Project 1

When I was starting out, I first focused on the main method. I knew that there were no methods called outside of the creation of the hamming distance variable and the calling of the toString() method. Thus I knew that all of my information had to be collected in the constructor and be ready for my toString() to access.

I first created variables method headings for the elements I thought I would need. This gave me a rough outline of my project. I started out with my constructor as the very basic assigning of the two cities. Then I focused on the readFile() method. I got an outline of that from the UtiliyBelt class from the labs. I adjusted that to get just the substring of the first four letters. It took a second to realize that there is a space before the city name, which threw me for a bit of a loop. But I figured it out before I moved on to another method.

When I tried to call this method in my constructor, I forgot that I needed to catch the possible IOException, so I also retrieved that from the UtilityBelt class and changed it as needed.

All of my checking was done via alteration of my toString() method because Main() was already calling that method, so I did not have to change it. 

I next realized that it would be better to have the hamming distances determined from the other 119 cities be in an array instead of trying to determine all of one distance for each four possibilities. I changed my method signature to reflect that and began to work on the findHammingDist method, which determines just the distance between two given cities. I tested this from the distance between city1 and city2 variables from the object's creation.

Next I worked on the hammingDist method which takes in the name of the city to be compared to the other cities on the file. Once I got the basic for loop figured out, it was doable. I was going to do if-elseif statements before I remembered that the hamming distance between the given city and its version in the list would result in a difference of 0. I didn't want that one getting stuck in my distance 4 variable, so I decided to go with a succession of not-directly-related if statements instead.

When testing this method (using my toString to print out wach index in my array for city1) I realized that in my findHammingDist method, I ended up using the object's city1 and city2 variables instead of the method's city and temorary comp variables. This resulted in me getting an array that said all cities (including city1's own city name) were distance 2 away. It was a strange array, to say the least! Luckily, i spotted it as soon as I looked at the find... method with that bug in mind. Once I got that figured out, I ran my Main program again. I got a nice array of numbers, but I did not know if they were correct. Instead of going through the whole mesonet file to determine the right numbers, I just changed the object created in Main to have city1 be the examples given in the pdf file. Both passed the test, so I changed the Main back to its original state without commiting changes to git because they were not necessary ones.

Then I got to deal with my toString method for real. I copied the desired outcome from the project pdf and used String.format for each of the three lines (much easier than trying to make it all one block). I ran Main for each line that I modified to ensure it was correct before continuing. I probably should have saved the changes to git, but I was planning on just doing that once I completed the method as a whole. Once I got that figured out, I ran the Main method as it was and it seemed to work. Just to be sure, however, I changed the cities back to the ones given in the example to have another test. All seemed well.

I finished by putting javadoc documentation for all of my variables (which I like to do last so that I don't have to scroll for forever and a day to see all of my object's variables whilst coding). I also added a few clarifying comments throughout the HammingDist class. See the code itself for all JavaDoc and further explainations of the methods.

Project 1 has officially passed all tests for ZyLabs submission.
