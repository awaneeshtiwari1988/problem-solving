package com.practice.problem.solving.application;

import java.util.*;

public class ElectoralVotingBallotWinner {

    public static void main(String[] args) {
        String[] votes
                = { "john", "johnny", "jackie", "johnny",
                "john", "jackie", "jamie",  "jamie",
                "john", "johnny", "jamie",  "johnny",
                "john" };
        ElectoralVotingBallotWinner electoralVotingBallotWinner = new ElectoralVotingBallotWinner();
        System.out.println(electoralVotingBallotWinner.findWinner(votes));
    }

    public String findWinner(String[] votes){
        Map<String, Integer> voterVotesMap = getStringIntegerMap(votes);
        int finalMaxValue = getMaxValue(voterVotesMap);
        Optional<String> voterOptional = voterVotesMap.keySet().stream()
                .filter(voter -> voterVotesMap.get(voter).equals(finalMaxValue)).findFirst();
        return voterOptional.orElse("");
    }

    private int getMaxValue(Map<String, Integer> voterVotesMap) {
        Optional<Integer> maxValueOptional = voterVotesMap.values().stream().max(Comparator.comparing(Integer::intValue));
        int maxValue = 0;
        if(maxValueOptional.isPresent()){
            maxValue = maxValueOptional.get();
        }
        return maxValue;
    }

    private Map<String, Integer> getStringIntegerMap(String[] votes) {
        Map<String,Integer> voterVotesMap = new TreeMap<>();
        Arrays.stream(votes).forEach(vote -> {
            if(voterVotesMap.containsKey(vote)){
                voterVotesMap.put(vote, voterVotesMap.get(vote) + 1);
            } else {
                voterVotesMap.put(vote, 1);
            }
        });
        return voterVotesMap;
    }
}
