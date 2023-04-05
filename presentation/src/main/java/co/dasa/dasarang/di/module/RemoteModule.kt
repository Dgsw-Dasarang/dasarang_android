package co.dasa.dasarang.di.module

import co.dasa.dasarang.di.OtherRemoteRetrofit
import co.dasa.data.network.api.AuthApi
import co.dasa.data.network.api.TokenApi
import co.dasa.data.network.remote.AuthRemote
import co.dasa.data.network.remote.EducationRemote
import co.dasa.data.network.remote.TokenRemote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideAuthRemote(): AuthRemote = AuthRemote()

    @Singleton
    @Provides
    fun provideTokenRemote() : TokenRemote = TokenRemote()

    @Singleton
    @Provides
    fun provideEducationRemote() : EducationRemote = EducationRemote()

}