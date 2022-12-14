package com.company;

import java.util.*;

public class Right extends Action {
    public static final double P_UP = 0.1;
    public static final double P_DOWN = 0.1;
    public static final double P_RIGHT = 0.8;
    public static final double P_LEFT = 0;

    public Map<State, Double> reachableStates(State stateTo,
                                              ArrayList<State> statesFrom,
                                              Agent agent) {

        Map<State, Double> map = new HashMap<State, Double>();
        for (State stateFrom : statesFrom) {
            if(agent.beliefState.isTerminal(stateFrom))
                continue;

            double probability = 0;
            State stateRight = stateTo(right(stateFrom, agent), stateFrom);
            if (stateTo.equals(stateRight)) {
                probability = probability + P_RIGHT;
            }
            State stateUp = stateTo(up(stateFrom, agent), stateFrom);
            if (stateTo.equals(stateUp)) {
                probability = probability + P_UP;
            }
            State stateDown = stateTo(down(stateFrom, agent), stateFrom);
            if (stateTo.equals(stateDown)) {
                probability = probability + P_DOWN;
            }
            if (probability != 0) {
                map.put(stateFrom, probability);
            }
        }
        return map;
    }

}