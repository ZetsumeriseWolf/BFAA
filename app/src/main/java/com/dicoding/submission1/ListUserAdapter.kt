package com.dicoding.submission1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ListUserAdapter(private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, company, username, image) = listUser[position]

        holder.imgImage.setImageResource(image)
        holder.tvName.text = name
        holder.tvCompany.text = company
        holder.tvUsername.text = username
        holder.itemView.setOnClickListener {onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listUser.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgImage: CircleImageView = itemView.findViewById(R.id.circleImageView)
        var tvName: TextView = itemView.findViewById(R.id.name)
        var tvCompany: TextView = itemView.findViewById(R.id.company)
        var tvUsername: TextView = itemView.findViewById(R.id.username)
    }

    interface OnItemClickCallback {
        fun onItemClicked(user: User)
    }


}
