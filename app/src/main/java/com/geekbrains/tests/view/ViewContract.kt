package com.geekbrains.tests.view

import com.geekbrains.tests.presenter.PresenterContract

interface ViewContract {
    fun attachToPresenter()
    fun detachFromPresenter()
}
