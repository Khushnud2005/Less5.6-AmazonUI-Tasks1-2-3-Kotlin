package uz.exemple.less56_amazonui_task1_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less56_amazonui_task1_kotlin.R
import uz.exemple.less56_amazonui_task1_kotlin.model.CategoryModel

class CategoryAdapter(var context: Context,var items:ArrayList<CategoryModel>):RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.title.setText(item.title)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        init {
            image = itemView.findViewById<ImageView>(R.id.iv_image_category)
            title = itemView.findViewById<TextView>(R.id.tv_categoryTitle)
        }
    }
}