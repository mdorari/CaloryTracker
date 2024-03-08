package ocm.plcoding.tracker_domain.use_case

import ocm.plcoding.tracker_domain.model.TrackableFood
import ocm.plcoding.tracker_domain.respoditory.TrackerRepository

class SearchFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        query: String,
        page: Int,
        pageSize: Int = 40
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }
}