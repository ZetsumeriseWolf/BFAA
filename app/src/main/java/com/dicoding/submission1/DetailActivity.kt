package com.dicoding.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dicoding.submission1.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val data = intent.getParcelableExtra<User>(EXTRA_DATA)
        println(data)

        supportActionBar?.title = "Detail User"

        detailBinding.apply {
            Glide.with(this@DetailActivity)
                .load(data?.image)
                .circleCrop()
                .into(circleImageViewDetail)
            nameDetail.text = data?.name
            usernameDetail.text = data?.username
            companyDetail.text = data?.company
            locationDetail.text = data?.location
            followingDetail.text = data?.following
            followerDetail.text = data?.follower
            repositoryDetail.text = data?.repository
        }

//        var avatarDetail: ImageView = findViewById(R.id.circleImageView_detail)
//        var nameDetail: TextView = findViewById(R.id.name_detail)
//        var userNameDetail: TextView = findViewById(R.id.username_detail)
//        var companyDetail: TextView = findViewById(R.id.company_detail)
//        var locationDetail: TextView = findViewById(R.id.location_detail)
//        var followerDetail: TextView = findViewById(R.id.follower_detail)
//        var followingDetail: TextView = findViewById(R.id.following_detail)
//        var repositoryDetail: TextView = findViewById(R.id.repository_detail)
//
//        data?.image?.let { avatarDetail?.setImageResource(it.toInt()) }
//        nameDetail?.text = data?.name
//        userNameDetail?.text = data?.username
//        companyDetail?.text = data?.company
//        locationDetail?.text = data?.location.toString()
//        followingDetail?.text = data?.following.toString()
//        followerDetail.text = data?.follower.toString()
//        repositoryDetail?.text = data?.repository.toString()


    }

    companion object {
        const val EXTRA_DATA = "0"
    }
}