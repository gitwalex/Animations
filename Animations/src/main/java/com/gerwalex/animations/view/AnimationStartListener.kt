package com.gerwalex.animations.view

/**
 * This interface is a custom listener to determine the start of an animation.
 *
 * @author Phu
 */
fun interface AnimationStartListener {

    /**
     * This method is called when the animation ends.
     *
     * @param animation The Animation object.
     */
    fun onAnimationStart(animation: Animation?)
}