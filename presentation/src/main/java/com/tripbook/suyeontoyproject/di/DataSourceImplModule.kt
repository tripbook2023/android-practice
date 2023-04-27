package com.tripbook.suyeontoyproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceImplModule {

    //Retrofit , Room 등 Provide 이용해 DI 제공

    @Provides
    @Singleton
    fun provideMainDataSource () {

    }
}