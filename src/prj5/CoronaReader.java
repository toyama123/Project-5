package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import bsh.ParseException;

/**
 * Creates a corona reader
 * @author toyama1
 * @version 11/18/20
 *
 */
public class CoronaReader {
    private LinkedList<State> corona;
    
    
    /**
     * Instantiates a new corona reader.
     *
     * @param filename the filename
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    public CoronaReader(String filename) throws ParseException, FileNotFoundException
    {
        corona = new LinkedList<State>();
        corona = this.readCoronaFile(filename);
        
        
    }
    
    /**
     * Read corona file.
     *
     * @param filename the filename
     * @return the linked list
     * @throws ParseException 
     * @throws FileNotFoundException 
     */
    private LinkedList<State> readCoronaFile(String filename) throws ParseException, FileNotFoundException
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
            file.nextLine();
            
            
        }
        return corona2;
    }

}
