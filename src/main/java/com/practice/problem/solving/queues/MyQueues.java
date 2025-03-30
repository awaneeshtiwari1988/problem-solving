package com.practice.problem.solving.queues;

import java.util.LinkedList;
import java.util.Stack;

public class MyQueues {
    private Stack<Integer> stack;
    private int top;

    public MyQueues() {
        stack = new Stack<>();
        top = 0;
    }

    public void push(int x) {
        stack.push(x);
        top++;
    }

    public int pop() {
        int element = stack.firstElement();
        stack.remove(stack.firstElement());
        return element;
    }

    public int peek() {
        return stack.firstElement();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
