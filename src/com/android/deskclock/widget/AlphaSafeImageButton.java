/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.deskclock.widget;

import android.content.Context;
import android.graphics.drawable.RippleDrawable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

import com.android.deskclock.Utils;

/**
 * A lightweight {@code ImageButton} subclass to provide a workaround for bad interactions
 * when animating a View's alpha with a {@link RippleDrawable} background.
 */
public class AlphaSafeImageButton extends AppCompatImageButton {

    public AlphaSafeImageButton(Context context) {
        super(context);
    }

    public AlphaSafeImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AlphaSafeImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Returns {@code false} if the background is a {@link RippleDrawable}.
     */
    @Override
    public boolean hasOverlappingRendering() {
        if (Utils.isLOrLater() && getBackground() instanceof RippleDrawable) {
            return false;
        }
        return super.hasOverlappingRendering();
    }
}
