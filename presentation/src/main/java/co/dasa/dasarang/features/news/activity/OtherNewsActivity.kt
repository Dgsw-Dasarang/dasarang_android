package co.dasa.dasarang.features.news.activity

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import co.dasa.dasarang.R
import co.dasa.dasarang.base.BaseActivity
import co.dasa.dasarang.databinding.ActivityOtherNewsBinding
import co.dasa.dasarang.extensions.repeatOnStarted
import co.dasa.dasarang.extensions.shortToast
import co.dasa.dasarang.features.news.adapter.CommentAdapter
import co.dasa.dasarang.features.news.state.WriteCommentState
import co.dasa.dasarang.features.news.viewmodel.OtherNewsViewModel
import co.dasa.domain.model.comment.Comment
import co.dasa.domain.model.comment.CommentList
import co.dasa.domain.model.news.OtherNewsData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherNewsActivity : BaseActivity<ActivityOtherNewsBinding, OtherNewsViewModel>(R.layout.activity_other_news) {
    override val viewModel: OtherNewsViewModel by viewModels()

    private lateinit var commentAdapter: CommentAdapter
    private var newsId = 0
    private var reload = false

    override fun start() {
        repeatOnStarted {
            viewModel.eventFlow.collect() { event -> handleEvent(event) }
        }
        setCommentListener()
        setCommentAdapter()
        collectCommentState()
        collectWriteCommentState()

    }

    private fun collectCommentState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                getcommentState.collect { state ->
                    if (state.isUpdate) {
                        state.result.let {
                            if(reload) {
                                commentAdapter.submitList(it!!.list)
                                reload = false

                            } else {
                                commentAdapter.submitList((commentAdapter.currentList + it!!.list))
                            }
                        }
                    } else if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    }
                }
            }
        }
    }

    private fun collectWriteCommentState() {
        with(viewModel) {
            lifecycleScope.launchWhenStarted {
                writecommentState.collect { state ->
                    if (state.isUpdate) {
                        state.result.let {
                            viewModel.clearWriteCommentState()
                            shortToast("댓글 작성에 성공하였습니다.")
                            reload = true
                            getComment(newsId, 1)
                        }
                    } else if (state.error.isNotBlank()) {
                        shortToast(state.error)
                    }
                }
            }
        }
    }

    private fun setCommentListener() {
        binding.recyclerComment.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.recyclerComment.canScrollVertically(1)) {
                    viewModel.getComment(newsId, commentAdapter.itemCount / 10 + 1)
                }
            }
        })
    }

    private fun setCommentAdapter() {
        commentAdapter = CommentAdapter()
        binding.recyclerComment.adapter = commentAdapter
        setData()
    }

    private fun setData() {
        val data = intent.getSerializableExtra("data") as OtherNewsData
        binding.tvNewsTitle.text = data.title
        binding.tvBody.text = data.content
        binding.tvCategory.text = when(data.category) {
            "SCHOOL" -> "학교별 소식"
            "PRESCHOOL" -> "유치원 소식"
            "DAYCARE_CENTER" -> "어린이집 소식"
            "EDUCATION_OFFICE" -> "교육청 소식"
            else -> "error"
        }
        newsId = data.newsId
        viewModel.getComment(newsId, 1)
    }

    private fun handleEvent(event: OtherNewsViewModel.Event) {
        when (event) {
            OtherNewsViewModel.Event.WriteComment -> {
                viewModel.writeComment(binding.etComment.text.toString(), newsId)
            }
            else -> {}
        }
    }
}