package project5;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class CoronaReader {
    private LinkedList<State> corona;
    
    
    /**
     * Instantiates a new corona reader.
     *
     * @param filename the filename
     */
    public CoronaReader(String filename)
    {
        corona = new LinkedList<State>();
        corona = this.readCoronaFile(filename);
    }
    
    private LinkedList<State> readCoronaFile(String filename)
    {
        LinkedList<State> corona2 = new LinkedList<State>();
        Scanner file = new Scanner(new File(filename));
        while(file.hasNextLine())
        {
            String[] count = file.nextLine().split(", *");
            
            if(count.length != 11)
            {
                file.close();
                throw new ParseException();
            }
            LinkedList<Integer> cases = new LinkedList<Integer>();
            LinkedList<Integer> deaths = new LinkedList<Integer>();
            for (int i = 1; i < count.length / 2; i++)
            {
                try
                {
                    cases.add(Integer.valueOf(count[i]));
                }
                catch (NullPointerException e)
                {
                    cases.add(0);
                }
            }
            
            for (int i = count.length / 2; i < count.length; i++)
            {
                try
                {
                    cases.add(Integer.valueOf(count[i]));
                }
                catch (NullPointerException e)
                {
                    cases.add(0);
                }
            }
            
            
            
            
            corona2.add(new State(count[0], cases, deaths));
            
            
        }
    }

}
