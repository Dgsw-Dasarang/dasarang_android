package co.dasa.dasarang.di.module

import co.dasa.data.repository.AuthRepositoryImpl
import co.dasa.data.repository.BoardRepositoryImpl
import co.dasa.data.repository.EducationRepositoryImpl
import co.dasa.data.repository.TokenRepositoryImpl
import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.repository.BoardRepository
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.TokenRepository
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
}
