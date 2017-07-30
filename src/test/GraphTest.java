package test;

import main.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Graph isomorphism
 * Copyright (c) 2017 Romain Vermot
 *
 * @author Romain Vermot <rfmv2@kent.ac.uk>
 */
public class GraphTest {
	/**
	 * Example 7.6 in C.A.G.E.S.
	 *
	 * @return The generated graph
	 */
	private static Graph graph76() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 8; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 7);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(2, 6);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		return graph;
	}

	/**
	 * Example 7.6 in C.A.G.E.S.
	 *
	 * This graph and graph76 are isomorphic.
	 *
	 * @return The generated graph
	 */
	private static Graph graph76_2() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 8; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 6);
		graph.addEdge(1, 6);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 7);
		graph.addEdge(4, 5);
		graph.addEdge(4, 7);
		graph.addEdge(6, 7);
		return graph;
	}

	/**
	 * Example 7.8 in C.A.G.E.S.
	 *
	 * @return The generated graph
	 */
	private static Graph graph78() {
		List<Vertex> vertices = new ArrayList<>();
		for (char i = 0; i < 7; i++) {
			Vertex va = new Vertex(i);
			vertices.add(va);
		}
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 6);
		graph.addEdge(1, 4);
		graph.addEdge(1, 5);
		graph.addEdge(2, 3);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 6);
		return graph;
	}

	@Test
	public void testRefine() {
		Graph graph = graph76();
		Partition p = new Partition();
		p.addCell(0);
		p.addCell(1, 2, 3, 4, 5, 6, 7);
		p = graph.refine(p);
		System.out.println(p);
		assertEquals(p.toString(), "(0|24|56|7|13)");
	}

	@Test
	public void testRefine2() {
		Graph graph = graph78();
		Partition p = new Partition();
		p.addCell(0);
		p.addCell(1, 2);
		p.addCell(3, 4, 6);
		p.addCell(5);
		p = graph.refine(p);
		System.out.println(p);
		assertEquals(p.toString(), "(0|12|34|6|5)");

		Partition b1 = p.splitBefore(1, 1);
		b1 = graph.refine(b1);
		System.out.println(b1);
		assertEquals(b1.toString(), "(0|1|2|3|4|6|5)");

		Partition b2 = p.splitBefore(1, 2);
		b2 = graph.refine(b2);
		System.out.println(b2);
		assertEquals(b2.toString(), "(0|2|1|4|3|6|5)");
	}

	@Test
	public void testCanon() {
		Graph graph = graph78();
		Partition p = new Partition();
		p.addCell(0);
		p.addCell(1, 2);
		p.addCell(3, 4, 6);
		p.addCell(5);
		graph.setup(new PermutationGroup(7));
		graph.canon(p);

		System.out.println("First: " + graph.getFirst());
		System.out.println("Best: " + graph.getBest());
		System.out.println("Certificate: " + graph.getCertificate());
	}

	@Test
	public void testCanon2() {
		Graph graph = graph76();
		Partition p = new Partition();
		p.addCell(0, 1, 2, 3, 4, 5, 6, 7);
		graph.setup(new PermutationGroup(8));
		graph.canon(p);

		System.out.println("First: " + graph.getFirst());
		System.out.println("Best: " + graph.getBest());
		System.out.println("Certificate: " + graph.getCertificate());
	}

	@Test
	public void testCanon3() {
		Graph graph = graph76_2();
		Partition p = new Partition();
		p.addCell(0, 1, 2, 3, 4, 5, 6, 7);
		graph.setup(new PermutationGroup(8));
		graph.canon(p);

		System.out.println("First: " + graph.getFirst());
		System.out.println("Best: " + graph.getBest());
		System.out.println("Certificate: " + graph.getCertificate());
	}
}
