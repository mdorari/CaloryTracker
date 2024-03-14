package com.plcoding.tracker_presentation.search

import ocm.plcoding.tracker_domain.model.TrackableFood

data class TrackableFoodUiState(
    val food:TrackableFood,
    val isExpanded:Boolean = false,
    val amount:String = ""
)
