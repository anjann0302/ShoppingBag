package com.dsw.shoppingbag

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dsw.shoppingbag.db.DbManagerImp
import com.dsw.shoppingbag.db.model.DBShoppingBagSummary
import com.dsw.shoppingbag.db.model.ShoppingBagSummaryModel
import com.dsw.shoppingbag.model.ShoppingBagModel
import com.dsw.shoppingbag.model.Summary
import com.dsw.shoppingbag.network.Resource
import com.dsw.shoppingbag.network.ShoppingBagRepository
import com.dsw.shoppingbag.utils.TestCoroutineRule
import com.dsw.shoppingbag.viewmodel.ShoppingBagViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ShoppingBagViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var shoppingBagRepository: ShoppingBagRepository

    @Mock
    private lateinit var dbManager: DbManagerImp

    @Mock
    private lateinit var shoppingBagObserver: Observer<Resource<ShoppingBagModel>>

    @Mock
    private lateinit var dbShoppingBagSummary: DBShoppingBagSummary

    @Mock
    private lateinit var bagSummaryLiveData: MutableLiveData<ArrayList<ShoppingBagSummaryModel>>

    @Mock
    private lateinit var shoppingBagSummaryList: ArrayList<ShoppingBagSummaryModel>

    @Mock
    private lateinit var shoppingBagSummaryModel: ShoppingBagSummaryModel

    @Mock
    private lateinit var application: MainApplication

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(
                ShoppingBagModel(
                    emptyList(), emptyList(), Summary("", "", "", "")
                )
            )
                .`when`(shoppingBagRepository)
                .getBagDetails()
            val viewModel = ShoppingBagViewModel(shoppingBagRepository, dbManager, application)
            viewModel.shoppingBagModel.observeForever(shoppingBagObserver)
            verify(shoppingBagRepository).getBagDetails()
            verify(shoppingBagObserver).onChanged(
                Resource.success(
                    ShoppingBagModel(
                        emptyList(), emptyList(), Summary("", "", "", "")
                    )
                )
            )
            viewModel.shoppingBagModel.removeObserver(shoppingBagObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(null, RuntimeException(errorMessage))
                .`when`(shoppingBagRepository)
                .getBagDetails()
            val viewModel = ShoppingBagViewModel(shoppingBagRepository, dbManager, application)
            viewModel.shoppingBagModel.observeForever(shoppingBagObserver)
            verify(shoppingBagRepository).getBagDetails()
            verify(shoppingBagObserver).onChanged(
                Resource.error(
                    null, RuntimeException(errorMessage).toString()
                )
            )
            viewModel.shoppingBagModel.removeObserver(shoppingBagObserver)
        }
    }

    @Test
    fun getSubTotalSomeValue(){
        /*dbShoppingBagSummary = DBShoppingBagSummary("100", "100", "100", "100")
        shoppingBagSummaryModel.dbShoppingBagSummary = dbShoppingBagSummary
        shoppingBagSummaryList.add(shoppingBagSummaryModel)
        bagSummaryLiveData.value = shoppingBagSummaryList
        val viewModel = ShoppingBagViewModel(shoppingBagRepository, dbManager, application)
        var actual: String? = viewModel.getTax()
        assertEquals("50", bagSummaryLiveData?.value?.get(0)?.dbShoppingBagSummary?.tax)*/
    }

    @Test
    fun getSubTotalEmpty(){
    }

    @Test
    fun getTotalSomeValue(){
    }

    @Test
    fun getTotalEmpty(){
    }

    @Test
    fun getTaxSomeValue(){
    }

    @Test
    fun getTaxEmpty(){
    }

    @Test
    fun getDiscountsSomeValue(){
    }

    @Test
    fun getDiscountsEmpty(){
    }

    @After
    fun tearDown() {
        // do something if required
    }
}