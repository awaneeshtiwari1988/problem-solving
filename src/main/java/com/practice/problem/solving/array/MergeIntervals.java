package com.practice.problem.solving.array;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public List<Pair> createOverlappingPairInterval(List<Pair> pairs){
        if (pairs == null || pairs.isEmpty()){
            return new ArrayList<>();
        }

        List<Pair> output = new ArrayList<>();
        output.add(new Pair(pairs.get(0).first, pairs.get(0).second));

        for(int i = 1; i < pairs.size(); i++){
            Pair pair = output.get(pairs.size() - 1);

            int currentStartElement = pairs.get(i).first;
            int currentEndElement = pairs.get(i).second;
            int previousEndElement = pair.second;

            if(previousEndElement >= currentEndElement){
                pair.second = Math.max(previousEndElement, currentEndElement);
            } else {
                output.add(new Pair(currentStartElement, currentEndElement));
            }
        }

        return output;
    }
}
