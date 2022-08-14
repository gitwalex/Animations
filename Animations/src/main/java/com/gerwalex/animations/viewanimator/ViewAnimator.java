package com.gerwalex.animations.viewanimator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;

import androidx.annotation.IntDef;
import androidx.annotation.IntRange;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 22/12/2015.
 * Modified by gzu-liyujiang on 24/01/2016.
 * <p>
 * https://github.com/florent37/ViewAnimator
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
public class ViewAnimator {
    public static final int INFINITE = ValueAnimator.INFINITE;
    public static final int RESTART = ValueAnimator.RESTART;
    public static final int REVERSE = ValueAnimator.REVERSE;
    private static final long DEFAULT_DURATION = 3000;

    private final List<AnimationBuilder> animationList = new ArrayList<>();
    private AnimatorSet animatorSet;
    private long duration = DEFAULT_DURATION;
    private Interpolator interpolator = null;
    private ViewAnimator next = null;
    private ViewAnimator prev = null;
    private int repeatCount = 0;
    private int repeatMode = RESTART;
    private long startDelay = 0;
    private AnimationListener.Start startListener;
    private AnimationListener.Stop stopListener;
    private View waitForThisViewHeight = null;

    public static AnimationBuilder animate(View... view) {
        ViewAnimator viewAnimator = new ViewAnimator();
        return viewAnimator.addAnimationBuilder(view);
    }

    public AnimationBuilder addAnimationBuilder(View... views) {
        AnimationBuilder animationBuilder = new AnimationBuilder(this, views);
        animationList.add(animationBuilder);
        return animationBuilder;
    }

    public void cancel() {
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (next != null) {
            next.cancel();
            next = null;
        }
    }

    protected AnimatorSet createAnimatorSet() {
        List<Animator> animators = new ArrayList<>();
        for (AnimationBuilder animationBuilder : animationList) {
            List<Animator> animatorList = animationBuilder.createAnimators();
            if (animationBuilder.getSingleInterpolator() != null) {
                for (Animator animator : animatorList) {
                    animator.setInterpolator(animationBuilder.getSingleInterpolator());
                }
            }
            animators.addAll(animatorList);
        }
        for (AnimationBuilder animationBuilder : animationList) {
            if (animationBuilder.isWaitForHeight()) {
                waitForThisViewHeight = animationBuilder.getView();
                break;
            }
        }
        for (Animator animator : animators) {
            if (animator instanceof ValueAnimator) {
                ValueAnimator valueAnimator = (ValueAnimator) animator;
                valueAnimator.setRepeatCount(repeatCount);
                valueAnimator.setRepeatMode(repeatMode);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animators);
        animatorSet.setDuration(duration);
        animatorSet.setStartDelay(startDelay);
        if (interpolator != null) {
            animatorSet.setInterpolator(interpolator);
        }
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (stopListener != null) {
                    stopListener.onStop();
                }
                if (next != null) {
                    next.prev = null;
                    next.start();
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }

            @Override
            public void onAnimationStart(Animator animation) {
                if (startListener != null) {
                    startListener.onStart();
                }
            }
        });
        return animatorSet;
    }

    public ViewAnimator duration(@IntRange(from = 1) long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * see https://github.com/cimi-chen/EaseInterpolator
     */
    public ViewAnimator interpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    public ViewAnimator onStart(AnimationListener.Start startListener) {
        this.startListener = startListener;
        return this;
    }

    public ViewAnimator onStop(AnimationListener.Stop stopListener) {
        this.stopListener = stopListener;
        return this;
    }

    /**
     * -1 or INFINITE will repeat forever
     */
    public ViewAnimator repeatCount(@IntRange(from = -1) int repeatCount) {
        this.repeatCount = repeatCount;
        return this;
    }

    public ViewAnimator repeatMode(@RepeatMode int repeatMode) {
        this.repeatMode = repeatMode;
        return this;
    }

    public void start() {
        if (prev != null) {
            prev.start();
        } else {
            animatorSet = createAnimatorSet();
            if (waitForThisViewHeight != null) {
                waitForThisViewHeight
                        .getViewTreeObserver()
                        .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                            @Override
                            public boolean onPreDraw() {
                                animatorSet.start();
                                waitForThisViewHeight
                                        .getViewTreeObserver()
                                        .removeOnPreDrawListener(this);
                                return false;
                            }
                        });
            } else {
                animatorSet.start();
            }
        }
    }

    public ViewAnimator startDelay(@IntRange(from = 0) long startDelay) {
        this.startDelay = startDelay;
        return this;
    }

    public AnimationBuilder thenAnimate(View... views) {
        ViewAnimator nextViewAnimator = new ViewAnimator();
        this.next = nextViewAnimator;
        nextViewAnimator.prev = this;
        return nextViewAnimator.addAnimationBuilder(views);
    }

    @IntDef(value = {RESTART, REVERSE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
        // use this instead enum, I heard that the enumeration will take a lot of memory
    }
}