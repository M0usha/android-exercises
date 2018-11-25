package fr.android.nicolasf


import fr.android.nicolasf.book.Book
import retrofit2.Call
import retrofit2.http.GET

interface HenriPotierService {
    // TODO Method GET books which return a List<Book>
    @GET("books")
    fun listBooks(): Call<Array<Book>>
}