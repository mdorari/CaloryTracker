package ocm.plcoding.tracker_domain.respoditory


import kotlinx.coroutines.flow.Flow
import ocm.plcoding.tracker_domain.model.TrackableFood
import ocm.plcoding.tracker_domain.model.TrackedFood
import java.time.LocalDate

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>>

    suspend fun insertTrackedFood(food: TrackedFood)

    suspend fun deleteTrackedFood(food: TrackedFood)

    fun getFoodsForDate(localDate: LocalDate):Flow<List<TrackedFood>>

}