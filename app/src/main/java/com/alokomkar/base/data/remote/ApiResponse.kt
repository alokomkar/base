package com.alokomkar.base.data.remote

//https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/api/ApiResponse.kt
sealed class ApiResponse<T> {
    companion object {
        fun <T> create(error: Throwable): ApiErrorResponse<T> {
            return ApiErrorResponse(error.message ?: "Unknown Error")
        }
        //Replace response class with retrofit response class
        fun <T> create( response : Response<T>? ) : ApiResponse<T> {
            return when {
                response == null -> ApiEmptyResponse()
                response.errorMessage != null -> ApiErrorResponse(response.errorMessage)
                else -> ApiSuccessResponse(response.data)
            }
        }
    }
}

class ApiEmptyResponse<T> : ApiResponse<T>()

class ApiErrorResponse<T>( val errorMessage : String ) : ApiResponse<T>()

class ApiSuccessResponse<T>( val data : T ) : ApiResponse<T>()