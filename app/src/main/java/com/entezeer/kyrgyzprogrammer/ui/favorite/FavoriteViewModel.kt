package com.entezeer.kyrgyzprogrammer.ui.favorite

import com.entezeer.core.base.BaseViewModel
import com.entezeer.kyrgyzprogrammer.data.ContentRepository
import com.entezeer.kyrgyzprogrammer.data.models.Event
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(private var favoriteRepo: ContentRepository) : BaseViewModel<Event>() {

}