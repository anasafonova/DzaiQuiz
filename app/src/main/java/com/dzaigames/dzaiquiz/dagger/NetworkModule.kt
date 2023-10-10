package com.dzaigames.dzaiquiz.dagger

import com.dzaigames.dzaiquiz.BuildConfig
import com.dzaigames.dzaiquiz.data.api.QuestionApi
import com.dzaigames.dzaiquiz.data.api.QuestionApiImpl
import com.dzaigames.dzaiquiz.data.api.RetrofitQuestionApi
import com.dzaigames.dzaiquiz.data.calladapter.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val okHttpBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(httpLoggingInterceptor)

        val resultCallAdapterFactory = ResultCallAdapterFactory()

        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(resultCallAdapterFactory)
            .client(okHttpBuilder.build())
            .build()
    }

    @Singleton
    @Provides
    fun providesRetrofitQuestionsApi(retrofit: Retrofit): RetrofitQuestionApi {
        return retrofit.create(RetrofitQuestionApi::class.java)
    }

    @Singleton
    @Provides
    fun providesQuestionsApi(retrofitQuestionApi: RetrofitQuestionApi): QuestionApi {
        return QuestionApiImpl(retrofitQuestionApi = retrofitQuestionApi)
    }
}