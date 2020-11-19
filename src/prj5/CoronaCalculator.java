package prj5;

import java.util.LinkedList;

/**
 * 
 * @author diamo
 *
 */
public class CoronaCalculator 
{
    private LinkedList<State> states;
    
    
    /**
     * Instantiates a new corona calculator.
     *
     * @param states the states
     */
    public CoronaCalculator(LinkedList<State> states)
    {
        if (states == null)
        {
            throw new IllegalArgumentException();
        }
        
        this.states = states;
    }
    
    /**
     * Gets the states.
     *
     * @return the states
     */
    public LinkedList<State> getStates()
    {
        return states;
    }
    
    /**
     * Check NA.
     *
     * @param state the state
     * @return the boolean
     */
    public Boolean checkNA(State state)
    {
        for (int i = 0; i < state.getCases().size(); i++)
        {
            if (state.getCaseData(i) == 0)
            {
                return false;
            }
        }
        
        for (int i = 0; i < state.getDeaths().size(); i++)
        {
            if (state.getDeathsData(i) == 0)
            {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Sort alpha.
     *
     * @param states the states
     * @return the linked list
     */
    public LinkedList<State> sortAlpha(LinkedList<State> states)
    {
        LinkedList<State> newStates = new LinkedList<State>();
        for (int i = 0; i < states.size(); i++)
        {
            State smallest = findAlpha(states, i, states.size());
            newStates.add(smallest);
        }
        return newStates;
    }
    
    /**
     * Find alpha.
     *
     * @param states the states
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the state
     */
    private State findAlpha(LinkedList<State> states, int p1, int p2)
    {
        State smallest = null;
        for (int i = p1 + 1; i < p2; i++)
        {
            if (states.get(i).getName().charAt(0) < states.get(p1).getName().charAt(0))
            {
                smallest = states.get(i);
            }
            else if (states.get(i).getName().charAt(0) == states.get(p1).getName().charAt(0))
            {
                if (states.get(i).getName().charAt(1) < states.get(p1).getName().charAt(1))
                {
                    smallest = states.get(i);
                }
            }
        }
        
        return smallest;
    }
    
    /**
     * Sort CFR.
     *
     * @param states the states
     * @return the linked list
     */
    public LinkedList<State> sortCFR(LinkedList<State> states)
    {
        LinkedList<State> newStates = new LinkedList<State>();
        for (int i = 0; i < states.size(); i++)
        {
            State smallest = findSmallest(states, i, states.size());
            newStates.add(smallest);
        }
        return newStates;
    }
    
    /**
     * Find smallest.
     *
     * @param states the states
     * @param p1 the p 1
     * @param p2 the p 2
     * @return the state
     */
    private State findSmallest(LinkedList<State> states, int p1, int p2)
    {
        State smallest = null;
        for (int i = p1 + 1; i < p2; i++)
        {
            if (states.get(i).calcCFR(i) < states.get(i).calcCFR(p1))
            {
                smallest = states.get(i);
            }
        }
        return smallest;
        
    }
    
    
    
    

}
