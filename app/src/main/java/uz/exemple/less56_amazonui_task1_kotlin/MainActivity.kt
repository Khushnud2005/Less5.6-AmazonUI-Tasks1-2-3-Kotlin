package uz.exemple.less56_amazonui_task1_kotlin

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less56_amazonui_task1_kotlin.adapter.*
import uz.exemple.less56_amazonui_task1_kotlin.model.*

class MainActivity : AppCompatActivity() {
    lateinit var rv_essential: RecyclerView
    lateinit var rv_sneakers: RecyclerView
    lateinit var rv_gifts: RecyclerView
    lateinit var rv_books: RecyclerView
    lateinit var rv_category: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){

        rv_essential = findViewById(R.id.rv_essential)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_essential.setLayoutManager(manager)

        rv_sneakers = findViewById(R.id.rv_sneakers)
        val sneakersManager = GridLayoutManager(this, 2)
        rv_sneakers.setLayoutManager(sneakersManager)

        rv_gifts = findViewById(R.id.rv_gifts)
        val giftsManager = GridLayoutManager(this, 2)
        rv_gifts.setLayoutManager(giftsManager)

        rv_books = findViewById(R.id.rv_books)
        val booksManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_books.layoutManager = booksManager

        rv_category = findViewById(R.id.rv_category)
        val categoryManager = GridLayoutManager(this, 2)
        rv_category.setLayoutManager(categoryManager)

        refreshAdapter(getEssentials())
        refreshSneakers(getSneakers())
        refreshGifts(getGifts())
        refreshBooks(getBooks())
        refreshCategories(getCategories())
    }

    fun setLinearHeight(layout: LinearLayout){
        // Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPixels = displayMetrics.widthPixels

        // Set layout width programmatically
        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }


    fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this, items)
        rv_essential.adapter = adapter
    }

    fun refreshSneakers(items: java.util.ArrayList<SneakersModel>) {
        val adapter = SneakersAdapter(this, items)
        rv_sneakers.setAdapter(adapter)
    }

    fun refreshGifts(items: java.util.ArrayList<GiftsModel>) {
        val adapter = GiftsAdapter(this, items)
        rv_gifts.setAdapter(adapter)
    }

    fun refreshBooks(items: ArrayList<BooksModel>) {
        val adapter = BooksAdapter(this, items)
        rv_books.adapter = adapter
    }

    fun refreshCategories(items: java.util.ArrayList<CategoryModel>) {
        val adapter = CategoryAdapter(this, items)
        rv_category.adapter = adapter
    }

    fun getEssentials(): ArrayList<Essential> {
        val items: ArrayList<Essential> = ArrayList<Essential>()
        items.add(Essential("Oculus", R.drawable.oculus))
        items.add(Essential("Gamer", R.drawable.gamer))
        items.add(Essential("Mobile", R.drawable.gamer_mob))

        return items
    }

    fun getSneakers(): ArrayList<SneakersModel> {
        val items: ArrayList<SneakersModel> = ArrayList<SneakersModel>()
        items.add(SneakersModel(R.drawable.sneakers5))
        items.add(SneakersModel(R.drawable.sneakers6))
        items.add(SneakersModel(R.drawable.sneakers7))
        items.add(SneakersModel(R.drawable.sneakers8))
        return items
    }

    fun getGifts(): ArrayList<GiftsModel> {
        val items: ArrayList<GiftsModel> = ArrayList<GiftsModel>()
        items.add(GiftsModel(R.drawable.camera1))
        items.add(GiftsModel(R.drawable.camera2))
        items.add(GiftsModel(R.drawable.camera3))
        items.add(GiftsModel(R.drawable.camera4))
        return items
    }

    fun getBooks(): ArrayList<BooksModel>{
        val items = ArrayList<BooksModel>()
        items.add(BooksModel(R.drawable.book1, "Wedding Bels for the Victory Girls", 4.75, 7.55))
        items.add(BooksModel(R.drawable.book2,"The Complete Peas and Carrots Collection",12.30,8.40))
        items.add(BooksModel(R.drawable.book3, "Apple Tree Cottage", 3.22, null))
        return items
    }

    fun getCategories(): ArrayList<CategoryModel> {
        val items = ArrayList<CategoryModel>()
        items.add(CategoryModel(R.drawable.beauty, "Beauty"))
        items.add(CategoryModel(R.drawable.homeand, "Home and Kitchen"))
        items.add(CategoryModel(R.drawable.sportsand, "Sports and Outdoors"))
        items.add(CategoryModel(R.drawable.electronic, "Electronics"))
        items.add(CategoryModel(R.drawable.outdoor_clothing, "Outdoor Clothing"))
        items.add(CategoryModel(R.drawable.pet, "Pet Supplies"))
        return items
    }
}