package co.dasa.dasarang.di.module

import co.dasa.domain.repository.AuthRepository
import co.dasa.domain.repository.EducationRepository
import co.dasa.domain.repository.TokenRepository
import co.dasa.domain.usecases.auth.AuthUseCases
import co.dasa.domain.usecases.auth.JoinOwner
import co.dasa.domain.usecases.auth.JoinUser
import co.dasa.domain.usecases.auth.Login
import co.dasa.domain.usecases.education.EducationUseCases
import co.dasa.domain.usecases.education.GetEducationAll
import co.dasa.domain.usecases.token.DeleteToken
import co.dasa.domain.usecases.token.GetToken
import co.dasa.domain.usecases.token.TokenUseCases
import co.dasa.domain.usecases.token.UpdateNewToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideAuthUseCases(repository: AuthRepository): AuthUseCases =
        AuthUseCases(
            login = Login(repository),
            joinUser = JoinUser(repository),
            joinOwner = JoinOwner(repository)
        )

    @Provides
    @Singleton
    fun provideTokenUseCases(repository: TokenRepository): TokenUseCases =
        TokenUseCases(
            deleteToken = DeleteToken(repository),
            getToken = GetToken(repository),
            updateNewToken = UpdateNewToken(repository)
        )

    @Provides
    @Singleton
    fun provideEducationUseCases(repository: EducationRepository): EducationUseCases =
        EducationUseCases(
            getEducationAll = GetEducationAll(repository)
        )
}
