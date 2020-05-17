package com.example.thursdaystore.fragments.sub_category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.thursdaystore.R
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse

class SubCategoryAdapter(private val list: List<SubcategoryResponse>) :
    RecyclerView.Adapter<SubCategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById(R.id.categoryItemText)
        val container: View = itemView.findViewById(R.id.categoryItemContainer)
        val image: ImageView = itemView.findViewById(R.id.categoryItemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder =
        CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val element = list[position]
        holder.text.text = element.name
        holder.container.setOnClickListener(SubCategoryItemListener(element.name, element.id, holder.itemView))
        Glide.with(holder.itemView).load(R.drawable.category_back_2).into(holder.image)
    }

}