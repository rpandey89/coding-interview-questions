package practice2024;

import java.util.Deque;
import java.util.ArrayDeque;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/description/
 */

public class MovingAverage {

	private final Deque<Integer> window;
	private final int maxSize;
    private double totalSum = 0.0;

	public MovingAverage(int size) {
        window = new ArrayDeque<>(size);
        maxSize = size;
    }

    public double next(int val) {
    	if (window.size() == maxSize) {
    		totalSum = totalSum - window.removeFirst();
    	}
        window.addLast(val);
        totalSum = totalSum + val;
        return totalSum / window.size();
    }

	public static void main(String[] args) {
        MovingAverage obj = new MovingAverage(3);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
	}

}