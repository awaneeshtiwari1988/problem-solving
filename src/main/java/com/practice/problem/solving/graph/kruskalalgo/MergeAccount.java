package com.practice.problem.solving.graph.kruskalalgo;

import java.util.*;

public class MergeAccount {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Vertex> graph = buildGraph(accounts);
        List<Edge> edgeList = buildEdges(graph,accounts);
        List<Vertex> vertexList = new ArrayList<>(graph.values());
        DisjointSet disjointSet = new DisjointSet(vertexList);

        for(Edge edge : edgeList){
            disjointSet.union(edge.getStartVertex().getNode(), edge.getTargetVertex().getNode());
        }

        Map<Node, List<String>> rootToEmails = new HashMap<>();
        for(String email : graph.keySet()){
            Vertex vertex = graph.get(email);
            Node vertexNode = disjointSet.find(vertex.getNode());
            rootToEmails.computeIfAbsent(vertexNode, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> mergedAccounts = new ArrayList<>();
        for(List<String> emails : rootToEmails.values()){
            Collections.sort(emails);
            String name = findNameByEmail(accounts,emails.get(0));
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(name);
            mergedAccount.addAll(emails);
            mergedAccounts.add(mergedAccount);
        }

        return mergedAccounts;
    }

    private String findNameByEmail(List<List<String>> accounts, String email) {
        for (List<String> account: accounts) {
            if(account.contains(email)){
                return account.get(0);
            }
        }

        return "";
    }

    private Map<String, Vertex> buildGraph(List<List<String>> accounts){
        Map<String, Vertex> graph = new HashMap<>();
        for(List<String> account : accounts){
            for(int i = 1; i < account.size(); i++){
                graph.putIfAbsent(account.get(i), new Vertex(account.get(i)));
            }
        }

        return graph;
    }

    private List<Edge> buildEdges(Map<String, Vertex> graph, List<List<String>> accounts){
        List<Edge> edgeList = new ArrayList<>();
        for(List<String> account : accounts){
            Vertex firstNameVertex = graph.get(account.get(1));
            for (int i = 2; i < account.size(); i++) {
                Vertex nextNameVertex = graph.get(account.get(i));
                edgeList.add(new Edge(firstNameVertex,nextNameVertex));
            }
        }

        return edgeList;
    }
}
