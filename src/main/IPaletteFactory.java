package main;

import java.awt.event.KeyListener;

public interface IPaletteFactory {
	IPalette createPalette(Context context);

	void addKeyListener(KeyListener keyListener);

	void addCleanup(Runnable cleanup);
}
