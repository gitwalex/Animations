package com.gerwalex.animations.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

/**
 * This animation causes the view to slide in underneath from its own borders.
 * 
 * @author SiYao
 * 
 */
public class SlideInUnderneathAnimation extends Animation {

	int direction;
	TimeInterpolator interpolator;
	long duration;
	AnimationEndListener listener;
	ValueAnimator slideAnim;

	/**
	 * This animation causes the view to slide in underneath from its own
	 * borders.
	 * 
	 * @param view
	 *            The view to be animated.
	 */
	public SlideInUnderneathAnimation(View view) {
		this.view = view;
		direction = DIRECTION_LEFT;
		interpolator = new AccelerateDecelerateInterpolator();
		duration = DURATION_LONG;
		listener = null;
	}

	@Override
	public void animate() {
		final ViewGroup parentView = (ViewGroup) view.getParent();
		final FrameLayout slideInFrame = new FrameLayout(view.getContext());
		final int positionView = parentView.indexOfChild(view);
		slideInFrame.setLayoutParams(view.getLayoutParams());
		slideInFrame.setClipChildren(true);
		parentView.removeView(view);
		slideInFrame.addView(view);
		parentView.addView(slideInFrame, positionView);

		float viewWidth = view.getWidth();
		float viewHeight = view.getHeight();
		switch (direction) {
			case DIRECTION_LEFT:
				view.setTranslationX(-viewWidth);
				slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, slideInFrame.getX());
				break;
			case DIRECTION_RIGHT:
				view.setTranslationX(viewWidth);
				slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, slideInFrame.getX());
				break;
			case DIRECTION_UP:
				view.setTranslationY(-viewHeight);
				slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, slideInFrame.getY());
				break;
			case DIRECTION_DOWN:
				view.setTranslationY(viewHeight);
				slideAnim = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, slideInFrame.getY());
				break;
			default:
				break;
		}
		AnimatorSet slideSet = new AnimatorSet();
		slideSet.play(slideAnim);
		slideSet.setInterpolator(interpolator);
		slideSet.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				slideInFrame.removeAllViews();
				view.setLayoutParams(slideInFrame.getLayoutParams());
				parentView.addView(view, positionView);
				if (getListener() != null) {
					getListener().onAnimationEnd(SlideInUnderneathAnimation.this);
				}
			}

			@Override
			public void onAnimationStart(Animator animation) {
				view.setVisibility(View.VISIBLE);
			}
		});
		slideAnim.start();
	}

	/**
	 * The available directions to slide in from are <code>DIRECTION_LEFT</code>
	 * , <code>DIRECTION_RIGHT</code>, <code>DIRECTION_TOP</code> and
	 * <code>DIRECTION_BOTTOM</code>.
	 * 
	 * @return The direction to slide the view in from.
	 * @see Animation
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * The available directions to slide in from are <code>DIRECTION_LEFT</code>
	 * , <code>DIRECTION_RIGHT</code>, <code>DIRECTION_TOP</code> and
	 * <code>DIRECTION_BOTTOM</code>.
	 * 
	 * @param direction
	 *            The direction to set to slide the view in from.
	 * @return This object, allowing calls to methods in this class to be
	 *         chained.
	 * @see Animation
	 */
	public SlideInUnderneathAnimation setDirection(int direction) {
		this.direction = direction;
		return this;
	}

	/**
	 * @return The interpolator of the entire animation.
	 */
	public TimeInterpolator getInterpolator() {
		return interpolator;
	}

	/**
	 * @param interpolator
	 *            The interpolator of the entire animation to set.
	 */
	public SlideInUnderneathAnimation setInterpolator(
			TimeInterpolator interpolator) {
		this.interpolator = interpolator;
		return this;
	}

	/**
	 * @return The duration of the entire animation.
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            The duration of the entire animation to set.
	 * @return This object, allowing calls to methods in this class to be
	 *         chained.
	 */
	public SlideInUnderneathAnimation setDuration(long duration) {
		this.duration = duration;
		return this;
	}

	/**
	 * @return The listener for the end of the animation.
	 */
	public AnimationEndListener getListener() {
		return listener;
	}

	/**
	 * @param listener The listener to set for the end of the animation.
	 * @return This object, allowing calls to methods in this class to be
	 * chained.
	 */
	public SlideInUnderneathAnimation setListener(AnimationEndListener listener) {
		this.listener = listener;
		return this;
	}

}
