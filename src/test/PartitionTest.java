package test;

import main.Partition;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Graph isomorphism
 * Copyright (c) 2017 Romain Vermot
 *
 * @author Romain Vermot <rfmv2@kent.ac.uk>
 */
public class PartitionTest {
	/**
	 * Generate a partition: (1379|2468|5)
	 *
	 * @return the partition
	 */
	private static Partition generatePartition() {
		Partition p = new Partition();
		p.addCell(1, 3, 7, 9);
		p.addCell(2, 4, 6, 8);
		p.addCell(5);
		return p;
	}

	/**
	 * Generate a discret partition: (1379|2468|5)
	 * (All the cells are singletons)
	 *
	 * @return the partition
	 */
	private static Partition generateDiscretePartition() {
		Partition p = new Partition();
		p.addCell(1);
		p.addCell(9);
		p.addCell(3);
		p.addCell(7);
		p.addCell(8);
		p.addCell(6);
		p.addCell(4);
		p.addCell(2);
		p.addCell(5);
		return p;
	}

	@Test
	public void generationTest() {
		Partition p = generatePartition();
		System.out.println(p);
		assertEquals(p.toString(), "(1379|2468|5)");
	}

	@Test
	public void generateDiscreteTest() {
		Partition p = generateDiscretePartition();
		System.out.println(p);
		assertEquals(p.toString(), "(1|9|3|7|8|6|4|2|5)");
	}

	@Test
	public void splitsTest() {
		Partition p = generatePartition();
		Partition individualized = p.splitBefore(0, 1);
		System.out.println(individualized);
		assertEquals(individualized.toString(), "(1|379|2468|5)");
		individualized = individualized.splitAfter(2, 2, 4);
		System.out.println(individualized);
		assertEquals(individualized.toString(), "(1|379|68|24|5)");
	}

	@Test
	public void splitAfterTest() {
		Partition p = generatePartition();
		Partition individualized = p.splitBefore(0, 1);
		System.out.println(individualized);
		assertEquals(individualized.toString(), "(1|379|2468|5)");
	}

	@Test
	public void isDiscreteTest() {
		Partition p = generatePartition();
		assertEquals(p.isDiscrete(), false);
	}

	@Test
	public void isDiscreteTest2() {
		Partition p = generateDiscretePartition();
		assertEquals(p.isDiscrete(), true);
	}
}
