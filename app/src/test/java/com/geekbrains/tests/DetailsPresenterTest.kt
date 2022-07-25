package com.geekbrains.tests

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.view.details.ViewDetailsContract
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class DetailsPresenterTest {
    private val count = 5
    private val presenter = DetailsPresenter()

    private val view = mock(ViewDetailsContract::class.java)

    @Before
    fun setUp() {
        presenter.onAttach(view)
        presenter.setCounter(count)
    }

    @Test
    fun incrementCount_Test() {
        presenter.onIncrement()
        verify(view, times(1)).setCount(count + 1)
    }

    @Test
    fun decrementCount_Test() {
        presenter.onDecrement()
        verify(view, times(1)).setCount(count - 1)
    }

    @Test
    fun onDetachView_Test() {
        presenter.onDetach()
        presenter.setCounter(5)
        verify(view, times(0)).setCount(count + 1)
    }
}