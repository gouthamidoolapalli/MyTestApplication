package com.waracle.mytestapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.waracle.mytestapplication.network.ApiHelper
import com.waracle.mytestapplication.network.ApiHelperImpl
import com.waracle.mytestapplication.network.ApiService
import com.waracle.mytestapplication.repository.MainRepository
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@RunWith(JUnit4::class)
class GetAPIResponseTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    private val server = MockWebServer()
    private lateinit var apiHelper : ApiHelper
    private lateinit var repository: MainRepository
    private lateinit var mockedResponse: String
    private val gson = GsonBuilder()
        .setLenient()
        .create()
    @Before
    fun init() {
        server.start(8000)
        var BASE_URL = server.url("/").toString()
        val okHttpClient = OkHttpClient
            .Builder()
            .build()
        val service = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build().create(ApiService::class.java)
        apiHelper= ApiHelperImpl(service)
        repository = MainRepository(apiHelper)
    }
    @Test
    fun testApiSuccess() {
        mockedResponse = "[" +
                "{" +
               "\"title\":\"Lemon cheesecake\"," +
               "\"desc\":\"A cheesecake made of lemon\"," +
               "\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"victoria sponge\"," +
               "\"desc\":\"sponge with jam\"," +
               "\"image\":\"https://upload.wikimedia.org/wikipedia/commons/0/05/111rfyh.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Carrot cake\"," +
               "\"desc\":\"Bugs bunnys favourite\"," +
               "\"image\":\"https://hips.hearstapps.com/del.h-cdn.co/assets/18/08/1519321610-carrot-cake-vertical.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Banana cake\"," +
               "\"desc\":\"Donkey kongs favourite\"," +
               "\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Birthday cake\"," +
               "\"desc\":\"a yearly treat\"," +
               "\"image\":\"https://www.frenchvillagebakery.co.uk/databaseimages/prd_8594342__painted_pink_and_gold_cake_512x640.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Lemon cheesecake\"," +
               "\"desc\":\"A cheesecake made of lemon\"," +
               "\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"victoria sponge\"," +
               "\"desc\":\"sponge with jam\"," +
               "\"image\":\"https://upload.wikimedia.org/wikipedia/commons/0/05/111rfyh.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Carrot cake\"," +
               "\"desc\":\"Bugs bunnys favourite\"," +
               "\"image\":\"https://hips.hearstapps.com/del.h-cdn.co/assets/18/08/1519321610-carrot-cake-vertical.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Banana cake\"," +
               "\"desc\":\"Donkey kongs favourite\"," +
               "\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Birthday cake\"," +
               "\"desc\":\"a yearly treat\"," +
               "\"image\":\"https://www.frenchvillagebakery.co.uk/databaseimages/prd_8594342__painted_pink_and_gold_cake_512x640.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Lemon cheesecake\"," +
               "\"desc\":\"A cheesecake made of lemon\"," +
               "\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"victoria sponge\"," +
               "\"desc\":\"sponge with jam\"," +
               "\"image\":\"https://upload.wikimedia.org/wikipedia/commons/0/05/111rfyh.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Carrot cake\"," +
               "\"desc\":\"Bugs bunnys favourite\"," +
               "\"image\":\"https://hips.hearstapps.com/del.h-cdn.co/assets/18/08/1519321610-carrot-cake-vertical.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Banana cake\"," +
               "\"desc\":\"Donkey kongs favourite\"," +
               "\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Birthday cake\"," +
               "\"desc\":\"a yearly treat\"," +
               "\"image\":\"https://www.frenchvillagebakery.co.uk/databaseimages/prd_8594342__painted_pink_and_gold_cake_512x640.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Lemon cheesecake\"," +
               "\"desc\":\"A cheesecake made of lemon\"," +
               "\"image\":\"https://s3-eu-west-1.amazonaws.com/s3.mediafileserver.co.uk/carnation/WebFiles/RecipeImages/lemoncheesecake_lg.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"victoria sponge\"," +
               "\"desc\":\"sponge with jam\"," +
               "\"image\":\"https://upload.wikimedia.org/wikipedia/commons/0/05/111rfyh.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Carrot cake\"," +
               "\"desc\":\"Bugs bunnys favourite\"," +
               "\"image\":\"https://hips.hearstapps.com/del.h-cdn.co/assets/18/08/1519321610-carrot-cake-vertical.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Banana cake\"," +
               "\"desc\":\"Donkey kongs favourite\"," +
               "\"image\":\"http://ukcdn.ar-cdn.com/recipes/xlarge/ff22df7f-dbcd-4a09-81f7-9c1d8395d936.jpg\"" +
                "}," +
                "{" +
               "\"title\":\"Birthday cake\"," +
               "\"desc\":\"a yearly treat\"," +
               "\"image\":\"https://www.frenchvillagebakery.co.uk/databaseimages/prd_8594342__painted_pink_and_gold_cake_512x640.jpg\"" +
                "}" +
                "]"
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(mockedResponse)
        )
        val response = runBlocking { apiHelper.getCakes() }
        val json = gson.toJson(response.body())
        val resultResponse = listOf(json)
        val expectedresponse = listOf(mockedResponse)
        Assert.assertNotNull(response)
        Assert.assertTrue(resultResponse.equals(expectedresponse))
    }
    @After
    fun tearDown() {
        server.shutdown()
    }
}