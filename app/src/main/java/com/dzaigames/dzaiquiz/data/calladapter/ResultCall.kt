package com.dzaigames.dzaiquiz.data.calladapter

import okhttp3.Request
import okio.Timeout
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class UnknownError(message: String) : Throwable(message)

class ResultCall<T>(
    private val delegate: Call<T>
) :
    Call<Result<T?>> {

    override fun enqueue(callback: Callback<Result<T?>>) {
        delegate.enqueue(
            object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T?>) {
                    if (response.isSuccessful) {
                        callback.onResponse(
                            this@ResultCall,
                            Response.success(
                                response.code(),
                                Result.success(response.body())
                            )
                        )
                    } else {
                        val jObjErrorBody = JSONObject(response.errorBody()!!.string())
                        var error = ""
                        error = try {
                            jObjErrorBody.getString("error_description")
                        } catch (e: Exception) {
                            "UnknownError"
                        }
                        callback.onResponse(
                            this@ResultCall,
                            Response.success(
                                Result.failure(
                                    when {
                                        response.code() == 500 || error == "UnknownError" -> UnknownError(response.message()) //RuntimeException("Неизвестная ошибка", HttpException(response))
                                        error != "" -> Exception(error)
                                        else -> HttpException(response)
                                    }
                                )
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    callback.onResponse(
                        this@ResultCall,
                        Response.success(
                            Result.failure(
                                RuntimeException(
                                    when (t) {
                                        is IOException -> "Нет соединения с Интернетом"
                                        is HttpException -> {
                                            t.localizedMessage!!
                                        }
                                        else -> t.localizedMessage!!
                                    }
                                )
                            )
                        )
                    )
                }
            }
        )
    }

    override fun isExecuted(): Boolean {
        return delegate.isExecuted
    }

    override fun execute(): Response<Result<T?>> {
        return Response.success(Result.success(delegate.execute().body()!!))
    }

    override fun cancel() {
        delegate.cancel()
    }

    override fun isCanceled(): Boolean {
        return delegate.isCanceled
    }

    override fun clone(): Call<Result<T?>> {
        return ResultCall(delegate.clone())
    }

    override fun request(): Request {
        return delegate.request()
    }

    override fun timeout(): Timeout {
        return delegate.timeout()
    }
}