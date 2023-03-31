
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.gerwalex.animations.view;

import com.gerwalex.animations.view.attention.BounceAnimator;
import com.gerwalex.animations.view.attention.FlashAnimator;
import com.gerwalex.animations.view.attention.PulseAnimator;
import com.gerwalex.animations.view.attention.RubberBandAnimator;
import com.gerwalex.animations.view.attention.ShakeAnimator;
import com.gerwalex.animations.view.attention.StandUpAnimator;
import com.gerwalex.animations.view.attention.SwingAnimator;
import com.gerwalex.animations.view.attention.TadaAnimator;
import com.gerwalex.animations.view.attention.WaveAnimator;
import com.gerwalex.animations.view.attention.WobbleAnimator;
import com.gerwalex.animations.view.bouncing_entrances.BounceInAnimator;
import com.gerwalex.animations.view.bouncing_entrances.BounceInDownAnimator;
import com.gerwalex.animations.view.bouncing_entrances.BounceInLeftAnimator;
import com.gerwalex.animations.view.bouncing_entrances.BounceInRightAnimator;
import com.gerwalex.animations.view.bouncing_entrances.BounceInUpAnimator;
import com.gerwalex.animations.view.fading_entrances.FadeInAnimator;
import com.gerwalex.animations.view.fading_entrances.FadeInDownAnimator;
import com.gerwalex.animations.view.fading_entrances.FadeInLeftAnimator;
import com.gerwalex.animations.view.fading_entrances.FadeInRightAnimator;
import com.gerwalex.animations.view.fading_entrances.FadeInUpAnimator;
import com.gerwalex.animations.view.fading_exits.FadeOutAnimator;
import com.gerwalex.animations.view.fading_exits.FadeOutDownAnimator;
import com.gerwalex.animations.view.fading_exits.FadeOutLeftAnimator;
import com.gerwalex.animations.view.fading_exits.FadeOutRightAnimator;
import com.gerwalex.animations.view.fading_exits.FadeOutUpAnimator;
import com.gerwalex.animations.view.flippers.FlipInXAnimator;
import com.gerwalex.animations.view.flippers.FlipInYAnimator;
import com.gerwalex.animations.view.flippers.FlipOutXAnimator;
import com.gerwalex.animations.view.flippers.FlipOutYAnimator;
import com.gerwalex.animations.view.rotating_entrances.RotateInAnimator;
import com.gerwalex.animations.view.rotating_entrances.RotateInDownLeftAnimator;
import com.gerwalex.animations.view.rotating_entrances.RotateInDownRightAnimator;
import com.gerwalex.animations.view.rotating_entrances.RotateInUpLeftAnimator;
import com.gerwalex.animations.view.rotating_entrances.RotateInUpRightAnimator;
import com.gerwalex.animations.view.rotating_exits.RotateOutAnimator;
import com.gerwalex.animations.view.rotating_exits.RotateOutDownLeftAnimator;
import com.gerwalex.animations.view.rotating_exits.RotateOutDownRightAnimator;
import com.gerwalex.animations.view.rotating_exits.RotateOutUpLeftAnimator;
import com.gerwalex.animations.view.rotating_exits.RotateOutUpRightAnimator;
import com.gerwalex.animations.view.sliders.SlideInDownAnimator;
import com.gerwalex.animations.view.sliders.SlideInLeftAnimator;
import com.gerwalex.animations.view.sliders.SlideInRightAnimator;
import com.gerwalex.animations.view.sliders.SlideInUpAnimator;
import com.gerwalex.animations.view.sliders.SlideOutDownAnimator;
import com.gerwalex.animations.view.sliders.SlideOutLeftAnimator;
import com.gerwalex.animations.view.sliders.SlideOutRightAnimator;
import com.gerwalex.animations.view.sliders.SlideOutUpAnimator;
import com.gerwalex.animations.view.specials.HingeAnimator;
import com.gerwalex.animations.view.specials.RollInAnimator;
import com.gerwalex.animations.view.specials.RollOutAnimator;
import com.gerwalex.animations.view.specials.in.DropOutAnimator;
import com.gerwalex.animations.view.specials.in.LandingAnimator;
import com.gerwalex.animations.view.specials.out.TakingOffAnimator;
import com.gerwalex.animations.view.zooming_entrances.ZoomInAnimator;
import com.gerwalex.animations.view.zooming_entrances.ZoomInDownAnimator;
import com.gerwalex.animations.view.zooming_entrances.ZoomInLeftAnimator;
import com.gerwalex.animations.view.zooming_entrances.ZoomInRightAnimator;
import com.gerwalex.animations.view.zooming_entrances.ZoomInUpAnimator;
import com.gerwalex.animations.view.zooming_exits.ZoomOutAnimator;
import com.gerwalex.animations.view.zooming_exits.ZoomOutDownAnimator;
import com.gerwalex.animations.view.zooming_exits.ZoomOutLeftAnimator;
import com.gerwalex.animations.view.zooming_exits.ZoomOutRightAnimator;
import com.gerwalex.animations.view.zooming_exits.ZoomOutUpAnimator;

public enum Techniques {

    DropOut(DropOutAnimator.class),
    Landing(LandingAnimator.class),
    TakingOff(TakingOffAnimator.class),

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),

    Hinge(HingeAnimator.class),
    RollIn(RollInAnimator.class),
    RollOut(RollOutAnimator.class),

    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),

    FadeIn(FadeInAnimator.class),
    FadeInUp(FadeInUpAnimator.class),
    FadeInDown(FadeInDownAnimator.class),
    FadeInLeft(FadeInLeftAnimator.class),
    FadeInRight(FadeInRightAnimator.class),

    FadeOut(FadeOutAnimator.class),
    FadeOutDown(FadeOutDownAnimator.class),
    FadeOutLeft(FadeOutLeftAnimator.class),
    FadeOutRight(FadeOutRightAnimator.class),
    FadeOutUp(FadeOutUpAnimator.class),

    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),

    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),

    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),

    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),

    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),

    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);


    private final Class animatorClazz;

    Techniques(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}