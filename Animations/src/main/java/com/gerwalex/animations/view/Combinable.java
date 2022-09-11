package com.gerwalex.animations.view;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;

/**
 * This interface is implemented only by animation classes that can be combined
 * to animate together.
 */
public interface Combinable {

	void animate();

	AnimatorSet getAnimatorSet();

	long getDuration();

	Animation setDuration(long duration);

	Animation setInterpolator(TimeInterpolator interpolator);

	Animation setListener(AnimationEndListener listener);
}
