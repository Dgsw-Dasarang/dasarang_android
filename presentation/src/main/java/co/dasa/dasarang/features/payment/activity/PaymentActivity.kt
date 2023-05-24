package co.dasa.dasarang.features.payment.activity

import android.content.Intent
import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityPaymentBinding
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.main.activity.MainActivity
import co.dasa.dasarang.features.payment.viewmodel.PaymentViewModel
import co.dasa.dasarang.features.plaza.viewmodel.PlazaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentActivity : BaseActivity<ActivityPaymentBinding, PaymentViewModel>(R.layout.activity_payment) {
    override val viewModel: PaymentViewModel by viewModels()

    override fun start() {
        settingWebView()
        collectPaymentState()
    }

    private fun settingWebView() {
        binding.webview.apply {
            webViewClient = WebViewClientClass()
            settings.javaScriptEnabled = true
        }
        binding.webview.visibility = View.VISIBLE
        binding.webview.loadUrl("https://server.dasaedu.com/payment.html")
    }

    private fun collectPaymentState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                paymentState.collect { state ->
                    if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    } else if (state.isUpdate) {
                        shortToast("정기 결제 등록에 성공하였습니다.")
                        Intent(binding.root.context, MainActivity::class.java).run {
                            startActivity(this)
                        }
                        finishAffinity()
                    }
                }
            }
        }
    }

    inner class WebViewClientClass : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            if(url!!.contains("success?")){
                binding.webview.loadUrl("")
                var splitString = url.split("customerKey=")[1].split("&authKey=")
                Log.d("customerKey ", splitString[0])
                Log.d("authKey ", splitString[1])
                viewModel.payment(splitString[1], splitString[0])
            }
        }
    }
}