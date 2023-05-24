package co.dasa.dasarang.di.module

import co.dasa.domain.repository.*
import co.dasa.domain.usecases.auth.*
import co.dasa.domain.usecases.board.EduBoardUseCases
import co.dasa.domain.usecases.board.GetBoardData
import co.dasa.domain.usecases.education.EducationUseCases
import co.dasa.domain.usecases.education.GetEducationAll
import co.dasa.domain.usecases.payment.CanclePayment
import co.dasa.domain.usecases.payment.GetPayment
import co.dasa.domain.usecases.payment.Payment
import co.dasa.domain.usecases.payment.PaymentUseCases
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
            joinOwner = JoinOwner(repository),
            getUser = GetUser(repository),
            logout = Logout(repository)
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

    @Provides
    @Singleton
    fun provideBoardUseCases(repository: BoardRepository): EduBoardUseCases =
        EduBoardUseCases(
            getBoardData = GetBoardData(repository)
        )

    @Provides
    @Singleton
    fun providePaymentUseCases(repository: PaymentRepository): PaymentUseCases =
        PaymentUseCases(
            payment = Payment(repository),
            getPayment = GetPayment(repository),
            canclePayment = CanclePayment(repository)
        )
}
