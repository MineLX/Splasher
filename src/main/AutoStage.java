package main;

import com.zyh.pro.animator.main.animators.*;

import java.util.ArrayList;
import java.util.List;

public class AutoStage {

	private final List<Role> roles;

	private final IPalette palette;

	private final Context context;

	public AutoStage(Context context, IPalette palette) {
		this.palette = palette;
		this.context = context;
		roles = new ArrayList<>();

		Animator repaint = Animators.justDoIt(this::repaint);
		palette.addCleanUp(() -> stopRepaint(repaint));
		repaint.start();
	}

	private void stopRepaint(Animator repaint) {
		repaint.stop();
		try {
			Thread.sleep(200);
		} catch (InterruptedException ignored) {
		}
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public void repaint() {
		for (Role role : roles)
			role.paint(palette);
	}

	public Context getContext() {
		return context;
	}

	public static AutoStage create(IPaletteFactory paletteFactory, int width, int height) {
		Context context = new Context(width, height);
		paletteFactory.addCleanup(() -> context.getCleanups().forEach(Runnable::run));
		return new AutoStage(context, paletteFactory.createPalette(context));
	}
}
