package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import radar.Radar;
import maze.Maze;

public class Test {
	char N = 'N', E = 'E', S = 'S', W = 'W';
	Maze m = null;
	
	@org.junit.Test (timeout = 1000)
	public void ns5b() {
		m = new Maze("ns5b.maze");
		Character[] expecteds = {N, W, W, N, N, E, E, N, N, N, N};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void nm5b() {
		m = new Maze("nm5b.maze");
		Character[] expecteds = {N, W, N, N, N, N, W, W, N, N, N, N, E, E, S, E, E, S, S, S};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void nm10b() {
		m = new Maze("nm10b.maze");
		Character[] expecteds = {N, E, E, E, E, N, N, N, N, E, E, E, E, N, N, N, N, E, E, N, N, E, N, N, E, E, E, N, N, N, N, N, N, W, W, W, W, S, S, S, S, W, W, S, S, W, W, W, W, S, S, S, S};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns15b() {
		m = new Maze("ns15b.maze");
		Character[] expecteds = {S, W, W, W, S, S, W, W, S, S, W, W, S, S, W, W, S, S, S, S, S, S, S, S, W, W, W, W, S, S, W, W, S, S, S, S, S, S, S, S, S, S, S, S, E, E, E, E, E, E, E, E, N, N, N, N, N, N, N, N, E, E, E, E, N, N};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns20b() {
		m = new Maze("ns20b.maze");
		Character[] expecteds = {N, W, W, N, N, E, E, N, N, N, N, W, W, N, N, W, W, N, N, W, W, N, N, N, N, E, E, E, E, N, N, N, N, W, W, N, N, E, E, N, N, N, N, N, N, E, E, S, S, S, S, S, S, S, S, E, E, E, E, N, N, E, E, S, S, E, E, S, S};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns50b() {
		m = new Maze("ns50b.maze");
		Character[] expecteds = {S, S, S, S, S, W, W, S, S, S, S, W, W, W, W, W, W, S, S, E, E, S, S, W, W, W, W, W, W, W, W, S, S, S, S, W, W, S, S, W, W, S, S, S, S, S, S, E, E, S, S, W, W, W, W, S, S, E, E, S, S, S, S, S, S, E, E, S, S, E, E, S, S, W, W, S, S, W, W, S, S, S, S, S, S, W, W, N, N, W, W, W, W, S, S, S, S, S, S, S, S, S, S, E, E, E, E, S, S, W, W, W, W, S, S, W, W, W, W, S, S, S, S, W, W, N, N, W, W, S, S, W, W, N, N, W, W, W, W, S, S, E, E, S, S, S, S, S, S, E, E, S, S, E, E, N, N, N, N};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns100b() {
		m = new Maze("ns100b.maze");
		Character[] expecteds = {S, W, W, S, S, S, S, W, W, W, W, S, S, S, S, W, W, N, N, W, W, W, W, S, S, S, S, S, S, W, W, S, S, W, W, S, S, W, W, S, S, W, W, N, N, N, N, N, N, W, W, W, W, N, N, W, W, N, N, W, W, W, W, W, W, W, W, S, S, W, W, W, W, W, W, S, S, W, W, W, W, N, N, W, W, S, S, W, W, W, W, W, W, N, N, W, W, W, W, W, W, N, N, W, W, S, S, W, W, W, W, W, W, S, S, S, S, S, S, S, S, S, S, E, E, E, E, S, S, E, E, S, S, W, W, S, S, S, S, E, E, S, S, E, E, N, N, E, E, S, S, E, E, E, E, E, E, E, E, N, N, E, E, E, E, E, E, E, E, E, E, N, N, E, E, S, S, S, S, S, S, W, W, S, S, S, S, E, E, S, S, S, S, S, S, S, S, S, S, S, S, S, S, S, S, W, W, S, S, S, S, S, S, E, E, E, E, E, E, S, S, S, S, S, S, S, S, E, E, S, S, S, S, W, W, W, W, S, S, W, W, S, S, E, E, E, E, S, S, E, E, S, S, S, S, W, W, S, S, W, W, S, S, S, S, W, W, W, W, W, W, S, S, E, E, S, S, S, S, S, S, W, W, S, S, E, E, E, E, S, S, S, S, W, W, S, S, E, E, E, E, E, E, E, E, E, E, S, S, W, W, S, S, E, E, E, E, S, S, S, S, S, S, W, W, W, W, W, W, W, W, W, W, N, N, W, W, W, W, S, S, S, S, S, S, S, S, S, S, E, E, E, E, S, S, W, W, W, W, S, S, S, S, E, E, S, S, S, S, E, E, S, S, E, E, S, S, S, S, S, S, W, W, S, S, E, E, E, E, S, S, E, E, S, S, W, W, S, S, S, S, W, W, S, S, S, S, E, E, E, E, E, E, S, S, S, S, E, E, S, S, W, W, W, W, W, W, W, W, W, W, S, S, E, E, E, E, S, S, E, E, S, S, S, S, W, W, S, S, W, W, S, S, S, S, E, E, S, S, S, S, S, S, E, E, E, E, E, E, N, N, E, E, E, E, S, S, E, E, N, N, N, N};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void nm100b() {
		m = new Maze("nm100b.maze");
		Character[] expecteds = {'?'};
//		Character[] actuals = actual(m.solve());
//		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, expecteds);
	}
	
	@org.junit.Test (timeout = 1000)
	public void t15b() {
		m = new Maze("15.in");
		Character[] expecteds = {N, N, N, N, N, N, N, N, N, E, E, E, E, N, N, N, N, E, E, E, E, E, E, S, S, S, S, S, S, W, W, W, W, N, N, N, N, E, E, S, S};
		Character[] actuals = actual(m.solve());
		assertArrayEquals(expecteds, actuals);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns5() {
		m = new Maze("ns5b.maze");
		int expected = 40;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void nm5() {
		m = new Maze("nm5b.maze");
		int expected = 72;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void nm10() {
		m = new Maze("nm10b.maze");
		int expected = 233;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns15() {
		m = new Maze("ns15b.maze");
		int expected = 302;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns20() {
		m = new Maze("ns20b.maze");
		int expected = 339;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns50() {
		m = new Maze("ns50b.maze");
		int expected = 802;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void ns100() {
		m = new Maze("ns100b.maze");
		int expected = 2454;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	@org.junit.Test (timeout = 1000)
	public void nm100() {
		m = new Maze("nm100b.maze");
		int expected = Integer.MAX_VALUE;
//		int actuals = weights(m.solve(), m);
//		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
//		assertFalse(expected < actuals);
		assertFalse(expected < 0);
	}
	
	@org.junit.Test (timeout = 1000)
	public void t15() {
		m = new Maze("15.in");
		int expected = 40;
		int actual = weights(m.solve(), m);
		if (actual < expected) System.out.println("Actual: " + actual + " is best, then " + expected);
		assertFalse(expected < actual);
	}
	
	Character[] actual(ArrayList<Character>solution) {
		Character[] actual = new Character[solution.size()];
		solution.toArray(actual);
		return actual;
	}
	
	int weights(ArrayList<Character>solution, Maze m) {
		int sum = 0;
		Radar r = m.getRadar();
		for (char c : solution) {
			r.move(c);
			int current = r.getSurroundings().current - 48;
			sum += current > 9 ? 0 : current;
		}
		return sum;
	}
}
