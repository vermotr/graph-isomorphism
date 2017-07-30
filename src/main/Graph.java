package main;

import java.util.*;

/**
 * Graph isomorphism
 * Copyright (c) 2017 Romain Vermot
 *
 * This class represents a graph.
 *
 * @author Romain Vermot <rfmv2@kent.ac.uk>
*/
public class Graph {
	private List<Vertex> vertices;

	/**
	 * Constructor creates a graph from a list of vertices.
	 *
	 * @param vertices A list of vertices that composes a graph
	 */
	public Graph(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	/**
	 * This method returns the list of vertices.
	 *
	 * @return The list of vertices
	 */
	public List<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * This method sets the list of vertices.
	 *
	 * @param vertices A list of vertices
	 */
	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}

	/**
	 * This method adds an edge between two vertices.
	 *
	 * @param start The first vertex
	 * @param end The second vertex
	 */
	public void addEdge(int start, int end) {
		Vertex s = vertices.get(start);
		Vertex e = vertices.get(end);

		s.addAdjacentVertex(e);
		e.addAdjacentVertex(s);
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Vertex v : vertices) {
			sb.append(v.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
