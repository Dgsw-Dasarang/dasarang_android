package co.dasa.dasarang.di.module

import co.dasa.data.network.remote.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Singleton
    @Provides
    fun provideAuthRemote(): AuthRemote = AuthRemote()

    @Singleton
    @Provides
    fun provideTokenRemote(): TokenRemote = TokenRemote()

    @Singleton
    @Provides
    fun provideEducationRemote(): EducationRemote = EducationRemote()

    @Singleton
    @Provides
    fun provideBoardRemote(): BoardRemote = BoardRemote()

    @Singleton
    @Provides
    fun providePaymentRemote(): PaymentRemote = PaymentRemote()
}
