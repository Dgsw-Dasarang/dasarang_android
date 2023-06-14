package co.dasa.dasarang.features.payment.activity

import androidx.activity.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityPaymentInfoBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.features.payment.viewmodel.PaymentInfoViewModel

class PaymentInfoActivity : BaseActivity<ActivityPaymentInfoBinding, PaymentInfoViewModel>(R.layout.activity_payment_info) {

    override val viewModel: PaymentInfoViewModel by viewModels()

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect { event -> handleEvent(event) }
        }
    }

    private fun handleEvent(event: PaymentInfoViewModel.Event) {
        when (event) {
            is PaymentInfoViewModel.Event.Payment -> payment()
        }
    }

    private fun payment() {
        //결제창으로
    }
}