package com.example.instagram

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var nameEdt: EditText
    private lateinit var jobEdt: EditText
    private lateinit var postDataBtn: Button
    private lateinit var responseTV: TextView
    private lateinit var loadingPB: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEdt = findViewById(R.id.idEdtName)
        jobEdt = findViewById(R.id.idEdtJob)
        postDataBtn = findViewById(R.id.idBtnPost)
        responseTV = findViewById(R.id.idTVResponse)
        loadingPB = findViewById(R.id.idLoadingPB)

        postDataBtn.setOnClickListener {
            if (nameEdt.text.isEmpty() || jobEdt.text.isEmpty()) {
                Toast.makeText(this, "Please enter both name and job", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            postData(nameEdt.text.toString(), jobEdt.text.toString())
        }
    }

    private fun postData(name: String, job: String) {
        loadingPB.visibility = View.VISIBLE

        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/") // Replace with your API base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

        val dataModal = DataModal(name, job)

        val call = retrofitAPI.createPost(dataModal)

        call.enqueue(object : Callback<DataModal> {
            override fun onResponse(call: Call<DataModal>, response: Response<DataModal>) {
                loadingPB.visibility = View.GONE
                nameEdt.text.clear()
                jobEdt.text.clear()

                if (response.isSuccessful) {
                    val responseData = response.body()
                    val responseString = "Response Code: ${response.code()}\nName: ${responseData?.name}\nJob: ${responseData?.job}"
                    responseTV.text = responseString
                    Toast.makeText(this@MainActivity, "Data added to API", Toast.LENGTH_SHORT).show()
                } else {
                    responseTV.text = "Response Code: ${response.code()}\nError: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<DataModal>, t: Throwable) {
                loadingPB.visibility = View.GONE
                responseTV.text = "Error found: ${t.message}"
            }
        })
    }
}
