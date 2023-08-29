package co.dasa.dasarang.di.module

import co.dasa.data.repository.*
import co.dasa.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository = authRepositoryImpl

    @Singleton
    @Provides
    fun provideTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl): TokenRepository = tokenRepositoryImpl

    @Singleton
    @Provides
    fun provideEducationRepository(educationRepositoryImpl: EducationRepositoryImpl): EducationRepository = educationRepositoryImpl

    @Singleton
    @Provides
    fun provideBoardRepository(boardRepositoryImpl: BoardRepositoryImpl): BoardRepository = boardRepositoryImpl

    @Singleton
    @Provides
    fun providePaymentRepository(paymentRepositoryImpl: PaymentRepositoryImpl): PaymentRepository = paymentRepositoryImpl

    @Singleton
    @Provides
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository = newsRepositoryImpl
}
