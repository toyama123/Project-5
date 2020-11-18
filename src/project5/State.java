package project5;

import java.util.LinkedList;

public class State
{
    private String state;
    private LinkedList<Integer> cases;
    private LinkedList<Integer> deaths;
    
    /**
     * 
     * @param state
     * @param cases
     * @param deaths
     */
    public State (String state, LinkedList<Integer> cases, LinkedList<Integer> deaths)
    {
        this.state = state;
        this.cases = cases;
        this.deaths = deaths;
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return state;
    }
    
    /**
     * Gets the cases.
     *
     * @return the cases
     */
    public LinkedList<Integer> getCases()
    {
        return cases;
    }
    
    /**
     * Gets the deaths.
     *
     * @return the deaths
     */
    public LinkedList<Integer> getDeaths()
    {
        return deaths;
    }
    


    /**
     * Gets the cases data.
     *
     * @param index the index
     * @return the data
     */
    public Integer getCaseData(int index)
    {
        
        if (index < 0 && index > 4)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        try
        {
            return cases.get(index);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    

    /**
     * Gets the deaths data.
     *
     * @param index the index
     * @return the deaths data
     */
    public Integer getDeathsData(int index)
    {
        
        if (index < 0 && index > 4)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        try
        {
            return deaths.get(index);
        }
        catch (Exception e)
        {
            return 0;
        }
    }
    
    /**
     * Calc CFR.
     *
     * @param raceIndex the race index
     * @return the double
     */
    public Double calcCFR(int raceIndex)
    {
        if (this.getCaseData(raceIndex) == 0 || this.getDeathsData(raceIndex) == 0 )
        {
            return null;
        }
        Double cfr = (double)(this.getCaseData(raceIndex) / this.getDeathsData(raceIndex));
        return cfr * 100;
    }
    
    /**
     * Compare to.
     *
     * @param first the first
     * @param other the other
     * @return the int
     */
    public int compareTo(int first, int other)
    {
        
        if (this.calcCFR(first) < this.calcCFR(other) || this.calcCFR(first) == null)
        {
            return -1;
        }
        else if (this.calcCFR(first) == this.calcCFR(other) || this.calcCFR(other) == null)
        {
            return 0;
        }
        return 1;
            
    }
    
    /**
     * Gets the CFR list.
     *
     * @return the CFR list
     */
    public LinkedList<Double> getCFRList()
    {
        LinkedList<Double> list = new LinkedList<Double>();
        for (int i = 1; i <= cases.size(); i++)
        {
            if (this.calcCFR(i) == null)
            {
                list.add(0.0);
            }
            else
            {
                list.add(this.calcCFR(i));
            }
        }
        return list;
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < this.getCFRList().size(); i++)
        {
            builder.append(this.getCFRList().get(i));
            if (i < this.getCFRList().size() - 1)
            {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    
    
    

}
