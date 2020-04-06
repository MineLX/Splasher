package main;

import java.util.ArrayList;
import java.util.List;

public class Context {

	public final int width;

	public final int height;

	private final List<Runnable> cleanups;

	Context(int width, int height) {
		this.width = width;
		this.height = height;

		cleanups = new ArrayList<>();
	}

	public void addCleanUp(Runnable cleanup) {
		cleanups.add(cleanup);
	}

	public List<Runnable> getCleanups() {
		return cleanups;
	}
}
