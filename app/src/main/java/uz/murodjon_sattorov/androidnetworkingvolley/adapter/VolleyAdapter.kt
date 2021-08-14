package uz.murodjon_sattorov.androidnetworkingvolley.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.murodjon_sattorov.androidnetworkingvolley.R
import uz.murodjon_sattorov.androidnetworkingvolley.data.User
import uz.murodjon_sattorov.androidnetworkingvolley.databinding.ItemUsersBinding

class VolleyAdapter(private var data: List<User>) : RecyclerView.Adapter<VolleyAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ItemUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: User) {
            binding.userName.text = user.name
            binding.userEmail.text = user.email
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolleyAdapter.ViewHolder {
        return ViewHolder(
            ItemUsersBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: VolleyAdapter.ViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}