package uz.murodjon_sattorov.androidnetworkingvolley

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.VolleyLog
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.murodjon_sattorov.androidnetworkingvolley.adapter.VolleyAdapter
import uz.murodjon_sattorov.androidnetworkingvolley.data.User
import uz.murodjon_sattorov.androidnetworkingvolley.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    private lateinit var requestQueue: RequestQueue
    private val url = "https://jsonplaceholder.typicode.com/users"
    private lateinit var adapter: VolleyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.recycler.layoutManager = LinearLayoutManager(this)

        requestQueue = Volley.newRequestQueue(this)
        VolleyLog.DEBUG = true
        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET,
            url,
            null,
            {
                val type = object : TypeToken<List<User>>() {}.type
                val list: List<User> = Gson().fromJson(it.toString(), type)

                adapter = VolleyAdapter(list)
                mainBinding.recycler.adapter = adapter
            },
            {

            }
        )

        requestQueue.add(jsonArrayRequest)

    }

}