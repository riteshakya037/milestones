package com.ysl.milestones

import com.ysl.milestones.base.BaseActivity
import com.ysl.milestones.base.BasePresenter
import com.ysl.milestones.base.BaseView

class LandingActivity : BaseActivity() {
    override val presenter: BasePresenter<BaseView>?
        get() = null

    override val isFragmentContainer: Boolean
        get() = true
}
