package com.gerwalex.animations.view

/**
 * This interface is a custom listener to determine the end of an animation.
 *
 * @author Phu
 */
fun interface AnimationEndListener {

    /**
     * This method is called when the animation ends.
     *
     * @param animation The Animation object.
     */
    fun onAnimationEnd(animation: Animation?)
}