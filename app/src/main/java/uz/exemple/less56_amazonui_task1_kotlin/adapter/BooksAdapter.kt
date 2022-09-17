package uz.exemple.less56_amazonui_task1_kotlin.adapter

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less56_amazonui_task1_kotlin.R
import uz.exemple.less56_amazonui_task1_kotlin.model.BooksModel

class BooksAdapter(var context: Context,var items:ArrayList<BooksModel>):RecyclerView.Adapter<BooksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_books, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: BooksModel = items.get(position)
        holder.image.setImageResource(item.image)
        holder.title.setText(item.title)
        val price = Math.floor(item.price).toInt()
        holder.price.setText("$$price")
        val price2 = ((item.price * 100) % 100).toInt()
        holder.price2.setText("$price2")
        if (item.oldPrise != null) {
            val oldPrice = SpannableString("$" + item.oldPrise)
            oldPrice.setSpan(
                StrikethroughSpan(),
                0,
                oldPrice.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            holder.oldPrice.setText(oldPrice)
            holder.oldPrice.setVisibility(View.VISIBLE)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var price: TextView
        var price2: TextView
        var oldPrice: TextView
        init {
            image = itemView.findViewById(R.id.iv_image_book)
            title = itemView.findViewById(R.id.tv_titleBook)
            price = itemView.findViewById(R.id.tv_priceBook1)
            price2 = itemView.findViewById(R.id.tv_priceBook2)
            oldPrice = itemView.findViewById(R.id.tv_oldPriceBook)
        }
    }

}