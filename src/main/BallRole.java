package main;

import com.zyh.pro.animator.main.animators.Animator;
import com.zyh.pro.animator.main.animators.CompositeAnimatorBuilder;
import com.zyh.pro.animator.main.animators.GetterAnimatorBuilder;
import com.zyh.pro.animator.main.animators.ToggleAnimatorBuilder;
import com.zyh.pro.animator.main.animators.valueanimator.ValueAnimatorBuilder;
import com.zyh.pro.animator.test.TestAnimatorListener;
import org.jetbrains.annotations.NotNull;

public class BallRole extends Role {

	private static final int START_RADIUS = 120;

	private static final int END_RADIUS = 170;

	private Oval ball;

	private Animator animator;

	public BallRole(Context context) {
		ball = new Oval(context.width / 2, context.height / 2, START_RADIUS, START_RADIUS);
	}

	@Override
	protected void onDraw(IPalette palette) {
		palette.fillOval(ball.getCenterX() + 2, ball.getCenterY() + 5, ball.getRadiusX(), ball.getRadiusY(), 0x7C2BB1);
		palette.fillOval(ball.getCenterX(), ball.getCenterY(), ball.getRadiusX(), ball.getRadiusY(), 0xFC009C);
	}

	public void animate() {
		if (animator != null && animator.isRunning())
			animator.stop();

		animator = new ToggleAnimatorBuilder().addToggle(
				new CompositeAnimatorBuilder()
						.with(new GetterAnimatorBuilder<>(this::cloneCurrentBall, this::createEnd, new Oval.OvalEvaluator())
								.addUpdater(oval -> ball = oval)
								.setDuration(150))
						.after(new GetterAnimatorBuilder<>(this::cloneCurrentBall, this::createStart, new Oval.OvalEvaluator())
								.addUpdater(oval -> ball = oval)
								.setDuration(300))
		).build();
		animator.start();
	}

	@NotNull
	private Oval cloneCurrentBall() {
		return new Oval(ball.getCenterX(), ball.getCenterY(), ball.getRadiusX(), ball.getRadiusY());
	}

	@NotNull
	private Oval createStart() {
		return new Oval(ball.getCenterX(), ball.getCenterY(), START_RADIUS, START_RADIUS);
	}

	@NotNull
	private Oval createEnd() {
		return new Oval(ball.getCenterX(), ball.getCenterY(), END_RADIUS, END_RADIUS);
	}
}
