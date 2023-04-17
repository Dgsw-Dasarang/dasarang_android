package co.dasa.dasarang.features.payment.activity

import androidx.activity.viewModels
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityPaymentBinding
import co.dasa.dasarang.features.payment.viewmodel.PaymentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentActivity : BaseActivity<ActivityPaymentBinding, PaymentViewModel>(R.layout.activity_payment) {
    override val viewModel: PaymentViewModel by viewModels()

    override fun start() {

    }
}