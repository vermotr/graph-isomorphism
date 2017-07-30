package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph isomorphism
 * Copyright (c) 2017 Romain Vermot
 *
 * This class will determine if two graphs are isomorphic or not.
 *
 * @author Romain Vermot <rfmv2@kent.ac.uk>
 */
public class Isomorphism {
	private Graph graphA;

	/**
	 * Constructor initialises the class with a graph.
	 *
	 * @param graphA One graph to be tested
	 */
	public Isomorphism(Graph graphA) {
		this.graphA = graphA;
	}

	/**
	 * This method determines if two graphs are isomorphic.
	 *
	 * @param graphB The graph to compare
	 * @return True if the two graphs are isomorphic, else False
	 */
	public boolean areIsomorphic(Graph graphB) {
		if (graphA.getNumberOfVertices() != graphB.getNumberOfVertices()) {
			return false;
		}

		Partition partitionA = new Partition();
		List<Integer> elementsA = new ArrayList<>();
		for (int i = 0, len = graphA.getNumberOfVertices(); i < len; i++) {
			elementsA.add(i);
		}
		partitionA. addCell(elementsA);
		graphA.setup(new PermutationGroup(graphA.getNumberOfVertices()));
		graphA.canon(partitionA);

		Partition partitionB = new Partition();
		List<Integer> elementsB = new ArrayList<>();
		for (int i = 0, len = graphA.getNumberOfVertices(); i < len; i++) {
			elementsB.add(i);
		}
		partitionB.addCell(elementsB);
		graphB.setup(new PermutationGroup(graphB.getNumberOfVertices()));
		graphB.canon(partitionB);

		// System.out.println("Isomorphic: " + graphA.getCertificate() + " " + graphB.getCertificate());

		return graphA.getCertificate().equals(graphB.getCertificate());
	}
}
