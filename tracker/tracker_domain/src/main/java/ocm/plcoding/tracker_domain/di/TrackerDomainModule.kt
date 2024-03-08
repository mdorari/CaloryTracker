package ocm.plcoding.tracker_domain.di

import com.plcoding.core.domain.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ocm.plcoding.tracker_domain.respoditory.TrackerRepository
import ocm.plcoding.tracker_domain.use_case.CalculateMealNutrients
import ocm.plcoding.tracker_domain.use_case.DeleteTrackedFood
import ocm.plcoding.tracker_domain.use_case.GetFoodForDate
import ocm.plcoding.tracker_domain.use_case.SearchFood
import ocm.plcoding.tracker_domain.use_case.TrackFood
import ocm.plcoding.tracker_domain.use_case.TrackerUsecases


@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ):TrackerUsecases{
        return TrackerUsecases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodForDate = GetFoodForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences)
        )
    }
}