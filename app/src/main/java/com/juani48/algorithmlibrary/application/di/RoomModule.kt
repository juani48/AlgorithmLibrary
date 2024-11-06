package com.juani48.algorithmlibrary.application.di

import android.content.Context
import androidx.room.Room
import com.juani48.algorithmlibrary.data.repository.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "APP_DATABASE"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, this.DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideCubeDao(dataBase: AppDataBase) = dataBase.getCubeDao()
}