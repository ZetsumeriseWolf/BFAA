package com.dicoding.submission1

import android.content.Intent
import android.content.res.Configuration
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<User>()

    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataImage: TypedArray
    private lateinit var dataLocation: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataRepository: Array<String>

    private fun dataUser() {
        dataName = resources.getStringArray(R.array.data_name)
        dataUsername = resources.getStringArray(R.array.data_username)
        dataImage = resources.obtainTypedArray(R.array.data_photo)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataFollowing = resources.getStringArray(R.array.data_following)
        dataFollower = resources.getStringArray(R.array.data_follower)
        dataRepository = resources.getStringArray(R.array.data_repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)
        dataUser()

        list.addAll(listUsers)
        showRecyclerList()
    }

    private val listUsers: ArrayList<User>
    get() {
        val userList = ArrayList<User>()
        for (i in dataName.indices) {
            val user = User(dataName[i], dataCompany[i], dataUsername[i], dataImage.getResourceId(i, -1), dataLocation[i], dataFollowing[i], dataFollower[i], dataRepository[i],
            )
            userList.add(user)
        }
        return userList
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(user: User) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra(DetailActivity.EXTRA_DATA, user)
                startActivity(intentToDetail)
            }
        })
    }
}