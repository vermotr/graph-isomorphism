package test;

import main.Graph;
import main.Isomorphism;
import main.Vertex;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Graph isomorphism
 * Copyright (c) 2017 Romain Vermot
 *
 * @author Romain Vermot <rfmv2@kent.ac.uk>
 */
public class IsomorphismTest {
	/**
	 * Graph 1 (The house graph)
	 *
	 *   A
	 *  / \
	 * E - B
	 * |   |
	 * D - C
	 *
	 * @return graph 1
	 */
	private static Graph graph1() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 5; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 4);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		return graph;
	}

	/**
	 * Graph 2 (The house graph)
	 *
	 *   1
	 *  / \
	 * 2 - 3
	 * |   |
	 * 4 - 5
	 *
	 * @return graph 2
	 */
	private static Graph graph2() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 5; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		return graph;
	}

	/**
	 * Graph 3
	 *
	 * Wikipedia example:
	 * https://en.wikipedia.org/wiki/Graph_isomorphism#/media/File:Graph_isomorphism_a.svg
	 *
	 * @return graph 3
	 */
	private static Graph graph3() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 8; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 4);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(1, 7);
		graph.addEdge(2, 4);
		graph.addEdge(2, 6);
		graph.addEdge(2, 7);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);
		return graph;
	}

	/**
	 * Graph 4
	 *
	 * Wikipedia example:
	 * https://en.wikipedia.org/wiki/Graph_isomorphism#/media/File:Graph_isomorphism_b.svg
	 *
	 * @return graph 4
	 */
	private static Graph graph4() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 8; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(2, 1);
		graph.addEdge(2, 3);
		graph.addEdge(2, 6);
		graph.addEdge(3, 7);
		graph.addEdge(5, 1);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 4);
		return graph;
	}

	/**
	 * Graph 5
	 *
	 * A - B - C - D
	 *     |   |
	 *     E - F
	 *
	 * @return graph 5
	 */
	private static Graph graph5() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 6; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(4, 5);
		return graph;
	}

	/**
	 * Graph 6
	 *
	 * 1 - 5 - 6
	 *     |   |
	 *     2 - 3 - 4
	 *
	 * @return graph 6
	 */
	private static Graph graph6() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 6; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 4);
		graph.addEdge(4, 1);
		graph.addEdge(4, 5);
		graph.addEdge(1, 2);
		graph.addEdge(5, 2);
		graph.addEdge(2, 3);
		return graph;
	}

	@Test
	public void testSameGraph001() {
		Graph graphA = graph1();
		Graph graphB = graph1();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(i.areIsomorphic(graphB));
	}

	@Test
	public void testSameGraph002() {
		Graph graphA = graph2();
		Graph graphB = graph2();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(i.areIsomorphic(graphB));
	}

	@Test
	public void testIsIsomorphicGraph001() {
		Graph graphA = graph1();
		Graph graphB = graph2();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(i.areIsomorphic(graphB));
	}

	@Test
	public void testIsIsomorphicGraph002() {
		Graph graphA = graph3();
		Graph graphB = graph4();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(i.areIsomorphic(graphB));
	}

	@Test
	public void testIsNotIsomorphicGraph001() {
		Graph graphA = graph1();
		Graph graphB = graph3();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(!i.areIsomorphic(graphB));
	}

	@Test
	public void testIsNotIsomorphicGraph002() {
		Graph graphA = graph5();
		Graph graphB = graph6();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(!i.areIsomorphic(graphB));
	}

	@Test
	public void testIsNotIsomorphicGraph003() {
		Graph graphA = graph4();
		Graph graphB = graph6();

		Isomorphism i = new Isomorphism(graphA);
		assertTrue(!i.areIsomorphic(graphB));
	}
}
