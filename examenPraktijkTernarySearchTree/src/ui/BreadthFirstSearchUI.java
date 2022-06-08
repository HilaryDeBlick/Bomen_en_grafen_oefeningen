package ui;

import domain.Graph;

import java.util.List;

public class BreadthFirstSearchUI {

	public static void main(String[] args) {

		int data[][]= {
				// A  2  3  4  5  6  7  B
				{0, 1, 0, 1, 0, 0, 0, 0}, //A
				{1, 0, 1, 0, 0, 0, 0, 0}, //2
				{0, 0, 0, 1, 0, 0, 1, 1}, //3
				{1, 0, 1, 0, 1, 1, 0, 0}, //4
				{0, 0, 0, 0, 0, 0, 1, 1}, //5
				{1, 0, 0, 1, 0, 0, 0, 0}, //6
				{0, 0, 1, 0, 0, 1, 0, 0}, //7
				{0, 0, 0, 0, 0, 0, 1, 0}};//B

		Graph bfs = new Graph(data);

		System.out.println("Ze ontmoeten elkaar op knooppunt: " + bfs.ontmoeting(1, 8));
	}
}
