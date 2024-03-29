package com.gerwalex.animations.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * This animation scales in the view from 0 to 1.
 * 
 * @author SiYao
 * 
 */
public class ScaleInAnimation extends Animation implements Combinable {

	TimeInterpolator interpolator;
	long duration;
	AnimationEndListener listener;
	float enlargeFactor;

	/**
	 * This animation scales in the view from 0 to 1.
	 * 
	 * @param view
	 *            The view to be animated.
	 */
	public ScaleInAnimation(View view) {
		this.view = view;
		interpolator = new AccelerateDecelerateInterpolator();
		duration = DURATION_LONG;
		listener = null;
		this.enlargeFactor = 1;
	}

	@Override
	public void animate() {
		getAnimatorSet().start();
	}

	@Override
	public AnimatorSet getAnimatorSet() {
		ViewGroup parentView = (ViewGroup) view.getParent();
		ViewGroup rootView = (ViewGroup) view.getRootView();
		while (parentView != rootView) {
			parentView.setClipChildren(false);
			parentView = (ViewGroup) parentView.getParent();
		}

		view.setScaleX(0f);
		view.setScaleY(0f);
		view.setVisibility(View.VISIBLE);

		AnimatorSet scaleSet = new AnimatorSet();
		scaleSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, enlargeFactor),
				ObjectAnimator.ofFloat(view, View.SCALE_Y, enlargeFactor));
		scaleSet.setInterpolator(interpolator);
		scaleSet.setDuration(duration);
		scaleSet.addListener(new AnimatorListenerAdapter() {

			@Override
			public void onAnimationEnd(Animator animation) {
				if (getListener() != null) {
					getListener().onAnimationEnd(ScaleInAnimation.this);
				}
			}
		});
		return scaleSet;
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
	public ScaleInAnimation setInterpolator(TimeInterpolator interpolator) {
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
	public ScaleInAnimation setDuration(long duration) {
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
	public ScaleInAnimation setListener(AnimationEndListener listener) {
		this.listener = listener;
		return this;
	}

	/**
	 * @return The enlarging factor at the end of the animation.
	 */
	public float getEnlargeFactor() {
		return enlargeFactor;
	}

	/**
	 * @param factor
	 * The factor of the view to be enlarged at the end of the animation.
	 * @return This object, allowing calls to methods in this class to be chained.
	 */
	public ScaleInAnimation setEnlargeFactor(double factor) {
		this.enlargeFactor = (float) factor;
		return this;
	}
}
