package com.example.datajetpackapplication.di//package com.example.datajetpackapplication.di

import com.example.datajetpackapplication.domain.usecase.GetListItemsUseCase
import com.example.datajetpackapplication.domain.repository.ListRepository
import com.example.datajetpackapplication.model.ListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideListRepository(): ListRepository {
        return ListRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideGetItemListUseCases(repository: ListRepository): GetListItemsUseCase {
        return GetListItemsUseCase(repository)
    }
}