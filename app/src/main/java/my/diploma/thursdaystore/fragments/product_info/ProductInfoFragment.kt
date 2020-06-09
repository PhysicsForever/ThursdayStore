package my.diploma.thursdaystore.fragments.product_tree

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_product_info.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.product_adapter.listeners.ProductCartClickListener
import my.diploma.thursdaystore.product_adapter.listeners.ProductFavoriteClickListener
import my.diploma.thursdaystore.repository.WebRepositoryActions


class ProductInfoFragment : Fragment() {

    private lateinit var productTreeViewModel: ProductInfoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {bundle ->
            val id = ProductInfoFragmentArgs.fromBundle(bundle).productId

            (activity as AppCompatActivity).supportActionBar?.let {
                it.title = "${it.title}: $id"
            }

            WebRepositoryActions.INSTANCE.getProduct(this, id)
        }
    }

    fun setImage(url:String){
        Glide.with(requireView()).load(url).into(product_info_image)
    }

    fun setFavoriteState(state: Boolean){
        product_info_favorite.setState(state)
    }

    fun setFavoriteListener(productId: Long){
        product_info_favorite.setOnClickListener(ProductFavoriteClickListener(productId))
    }

    fun setCartState(state: Boolean){
        product_info_cart.setState(state)
    }

    fun setCartListener(productId: Long){
        product_info_cart.setOnClickListener(ProductCartClickListener(productId))
    }

    fun setTitle(name: String){
        product_info_name_text.text = name
    }

    @SuppressLint("SetTextI18n")
    fun setPrice(price: String){
        product_info_price_text.text = price
    }

    fun setDescription(description: String){
        product_info_description_text.text = description
    }

    fun setCharacteristics(){
        product_info_rv
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productTreeViewModel = ViewModelProvider(this).get(ProductInfoViewModel::class.java)
        return inflater.inflate(R.layout.fragment_product_info, container, false)
    }

}
