package ocm.plcoding.tracker_domain.use_case

data class TrackerUsecases(
    val trackFood: TrackFood,
    val searchFood: SearchFood,
    val getFoodForDate: GetFoodForDate,
    val deleteTrackedFood: DeleteTrackedFood,
    val calculateMealNutrients: CalculateMealNutrients
)
