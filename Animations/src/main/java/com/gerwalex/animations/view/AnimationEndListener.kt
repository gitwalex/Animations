package com.gerwalex.animations.view;

/**
 * This interface is a custom listener to determine the end of an animation.
 *
 * @author Phu
 */
public interface AnimationListener {

    /**
     * This method is called when the animation ends.
     *
     * @param animation The Animation object.
     */
    void onAnimationEnd(Animation animation);

    /**
     * This method is called when the animation starts.
     *
     * @param animation The Animation object.
     */
    default void onAnimationStart(Animation animation) {
        throw new RuntimeException("Not implemented yet");
    }
}

