package com.alokomkar.base.data.remote

//TODO Replace with Retrofit response class
class Response<T>( val errorMessage : String? = "", val data : T )