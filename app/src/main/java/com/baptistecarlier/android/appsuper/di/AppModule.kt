package com.baptistecarlier.android.appsuper.di

import android.app.Application
import android.content.Context
import com.baptistecarlier.android.appsuper.MyApplication
import com.baptistecarlier.android.appsuper.repository.StorageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMyApplication(@ApplicationContext application: Context): MyApplication {
        return application as MyApplication
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideStorageRepository(context: Context): StorageRepository {
        return StorageRepository(context)
    }

}