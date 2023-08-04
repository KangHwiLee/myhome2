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
        val cnt = view.findViewById<TextView>(R.id.tv_cnt)
        val type = view.findViewById<TextView>(R.id.tv_type)

        val user = ItemList[position]

        profile.setImageBitmap(user.profile)
        name.text = user.name
        cnt.text = user.cnt.toString()
        type.text = user.type.toString()

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

    fun getCnt(p : Int) : Int{
        return ItemList.get(p).cnt
    }
   fun getName(p : Int) : String{
        return ItemList.get(p).name
    }
    fun getType(p : Int) : Int{
        return ItemList.get(p).type
    }

    fun getInfo(p : Int) : Item{
        return ItemList.get(p)
    }

}