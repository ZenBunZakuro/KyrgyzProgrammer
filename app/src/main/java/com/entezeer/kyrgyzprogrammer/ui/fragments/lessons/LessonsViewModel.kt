package com.entezeer.kyrgyzprogrammer.ui.fragments.lessons

import androidx.lifecycle.MutableLiveData
import com.entezeer.core.base.BaseViewModel
import com.entezeer.kyrgyzprogrammer.data.ContentRepository
import com.entezeer.kyrgyzprogrammer.data.models.Event
import com.entezeer.kyrgyzprogrammer.data.models.Lessons
import javax.inject.Inject

class LessonsViewModel @Inject constructor(private var lessonRepo: ContentRepository) : BaseViewModel<Event>() {

    var lessons: MutableLiveData<ArrayList<Lessons>> = MutableLiveData()

    fun fetchLessons(id: Int) {
        runWithErrorHandling({
            lessons.value = lessonRepo.getLessonsByCategory(id)
        })
    }
}