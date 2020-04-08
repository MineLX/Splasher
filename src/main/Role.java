package main;

public abstract class Role {

	protected boolean visible;

	public Role() {
		visible = true;
	}

	public void paint(IPalette palette) {
		palette.beginPaint();
		draw(palette);
		palette.endPaint();
	}

	protected final void draw(IPalette palette) {
		if (!visible)
			return;
		onDraw(palette);
	}

	public void hide() {
		visible = false;
	}

	public void show() {
		visible = true;
	}

	protected abstract void onDraw(IPalette palette);
}
