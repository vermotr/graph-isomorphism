package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph isomorphism
 * Copyright (c) 2017 Romain Vermot
 *
 * This class represents a graph vertex.
 *
 * @author Romain Vermot <rfmv2@kent.ac.uk>
 */
public class Vertex {
	private int name;
	private List<Vertex> adjacentVertices;

	/**
	 * Constructor creates a vertex with a specified name.
	 *
	 * @param name The vertex name
	 */
	public Vertex(int name) {
		this.name = name;
		this.adjacentVertices = new ArrayList<>();
	}

	/**
	 * This method returns the vertex name.
	 *
	 * @return The vertex name
	 */
	public int getName() {
		return name;
	}

	/**
	 * This method sets the vertex name.
	 *
	 * @param name The vertex name
	 */
	public void setName(int name) {
		this.name = name;
	}
	/**
	 * This method adds adjacent vertex to this vertex.
	 *
	 * @param v The vertex to add
	 */
	public void addAdjacentVertex(Vertex v) {
		adjacentVertices.add(v);
	}

	/**
	 * This method returns the list of adjacent vertices.
	 *
	 * @return The list of adjacent vertices
	 */
	public List<Vertex> getAdjacentVertices() {
		return adjacentVertices;
	}

	/**
	 * This method returns the degree of the vertex.
	 *
	 * @return The degree of the vertex
	 */
	public int getDegree() {
		return adjacentVertices.size();
	}

	/**
	 * This method sets the list of adjacent vertices.
	 *
	 * @param adjacentVertices The list of adjacent vertices
	 */
	public void setAdjacentVertices(List<Vertex> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

	/**
	 * @inheritDoc
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.name);
		sb.append( ": ");
		for (Vertex v : adjacentVertices) {
			sb.append(v.getName());
		}
		return sb.toString();
	}
}
