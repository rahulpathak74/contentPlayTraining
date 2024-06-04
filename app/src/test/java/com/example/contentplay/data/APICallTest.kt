package com.example.contentplay.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.contentplay.Utils.TestCoroutineRule
import com.example.contentplay.data.repository.ContentPlayRepository
import com.example.contentplay.data.room_database.database.ContentPlayDatabase
import com.example.contentplay.ui.main.viewmodel.ContentPlayViewModel
import com.example.contentplay.utils.CommonUtils
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class APICallTest: TestCase() {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var repository: ContentPlayRepository

    @Mock
    private lateinit var viewModel: ContentPlayViewModel

    @Mock
    private lateinit var database: ContentPlayDatabase

    @Before
    public override fun setUp() {
        MockitoAnnotations.openMocks(this)
        super.setUp()
    }

    @Test
     fun testInsertDeleteDataInDb(): Unit  =runBlocking {
      Mockito.`when`(repository.addMovieDataToDB(CommonUtils.contentArrayListDB)).thenReturn(1)
      Mockito.`when`(repository.deleteMoviesDataFromDB()).thenReturn(1)

        val num1 = repository.addMovieDataToDB(CommonUtils.contentArrayListDB)
        val num2 = repository.deleteMoviesDataFromDB()

        assertEquals((num1 + num2), 2)


    }

    @Test
    fun testInsertDeleteReadDataInDb(): Unit  =runBlocking {
        Mockito.`when`(repository.addMovieDataToDB(CommonUtils.contentArrayListDB)).thenReturn(1)
        Mockito.`when`(repository.deleteMoviesDataFromDB()).thenReturn(1)

        val num1 = repository.addMovieDataToDB(CommonUtils.contentArrayListDB)
        val num2 = repository.deleteMoviesDataFromDB()

        assertEquals((num1 + num2), 2)

    }

    @After
     fun closeDb() {
        database.close()
    }



}