package ocm.plcoding.tracker_domain.use_case

import kotlinx.coroutines.flow.Flow

import ocm.plcoding.tracker_domain.model.TrackedFood
import ocm.plcoding.tracker_domain.respoditory.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class GetFoodForDate(
    private val repository: TrackerRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
       return repository.getFoodsForDate(date)
    }
}