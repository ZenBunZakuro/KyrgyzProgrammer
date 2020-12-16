package com.entezeer.core.utils

import androidx.transition.ChangeBounds
import androidx.transition.ChangeImageTransform
import androidx.transition.ChangeTransform
import androidx.transition.TransitionSet

class TransitionUtil: TransitionSet() {
    init {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds())
            .addTransition(ChangeTransform())
            .addTransition(ChangeImageTransform())
    }
}