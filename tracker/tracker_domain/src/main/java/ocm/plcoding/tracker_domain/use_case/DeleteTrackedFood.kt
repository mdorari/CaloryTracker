package ocm.plcoding.tracker_domain.use_case

import kotlinx.coroutines.flow.Flow

import ocm.plcoding.tracker_domain.model.TrackedFood
import ocm.plcoding.tracker_domain.respoditory.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(trackedFood: TrackedFood) {
       repository.deleteTrackedFood(trackedFood)
    }
}