package com.gerwalex.animations.view;

/**
 * This method is called when the parallel animation ends.
 * 
 * @author SiYao
 * 
 */
public interface ParallelAnimatorListener {

	/**
	 * This method is called when the parallel animation ends.
	 * 
	 * @param parallelAnimator
	 *            The ParallelAnimator object.
	 */
	public void onAnimationEnd(ParallelAnimator parallelAnimator);
}