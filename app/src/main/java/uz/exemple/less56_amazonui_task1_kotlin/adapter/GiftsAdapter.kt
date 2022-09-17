package uz.exemple.less56_amazonui_task1_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less56_amazonui_task1_kotlin.R
import uz.exemple.less56_amazonui_task1_kotlin.model.GiftsModel

class GiftsAdapter(var context: Context, var items:ArrayList<GiftsModel>): RecyclerView.Adapter<GiftsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gifts,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var image:ImageView
        init {
           image = itemView.findViewById(R.id.iv_image_gift)
        }
    }


}