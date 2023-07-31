package com.example.myhome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter (val context: Context, val ItemList : ArrayList<Item>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_item_user, null);

        val profile = view.findViewById<ImageView>(R.id.iv_profile)
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        val user = ItemList[position]

        profile.setImageResource(user.profile)
        name.text = user.name
        age.text = user.age.toString()

        return view
    }

    override fun getCount(): Int {
        return ItemList.size
    }

    override fun getItem(p0: Int): Any {
        return ItemList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    fun getAge(p : Int) : Int{
        return ItemList.get(p).age
    }

}