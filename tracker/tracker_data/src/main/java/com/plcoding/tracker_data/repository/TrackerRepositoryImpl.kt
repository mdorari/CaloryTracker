package com.plcoding.tracker_data.repository

import com.plcoding.tracker_data.local.TrackerDao
import com.plcoding.tracker_data.mapper.toTrackableFood
import com.plcoding.tracker_data.mapper.toTrackedFood
import com.plcoding.tracker_data.mapper.toTrackedFoodEntity
import com.plcoding.tracker_data.remote.OpenFoodApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull
import ocm.plcoding.tracker_domain.model.TrackableFood
import ocm.plcoding.tracker_domain.model.TrackedFood
import ocm.plcoding.tracker_domain.respoditory.TrackerRepository
import java.lang.Exception
import java.time.LocalDate

class TrackerRepositoryImpl(
    val dao: TrackerDao,
    val api: OpenFoodApi
) : TrackerRepository {
    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): Result<List<TrackableFood>> {
        return try {
            val searchDao = api.searchFood(
                query = query,
                page = page,
                pageSize = pageSize
            )
            Result.success(
                searchDao.products.mapNotNull { it.toTrackableFood() }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun insertTrackedFood(food: TrackedFood) {
        dao.insertTrackedFood(food.toTrackedFoodEntity())
    }

    override suspend fun deleteTrackedFood(food: TrackedFood) {
        dao.deleteTrackedFood(food.toTrackedFoodEntity())
    }

    override fun getFoodsForDate(localDate: LocalDate): Flow<List<TrackedFood>> {
        return dao.getFoodsForDate(
            day = localDate.dayOfMonth,
            month = localDate.monthValue,
            year = localDate.year
        ).map { entities ->
            entities.map {
                it.toTrackedFood()
            }
        }
    }
}