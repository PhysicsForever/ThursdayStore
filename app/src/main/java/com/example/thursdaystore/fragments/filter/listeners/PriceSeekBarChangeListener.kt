package com.example.thursdaystore.fragments.filter.listeners

import android.widget.SeekBar
import android.widget.TextView
import com.example.thursdaystore.fragments.filter.FilterViewModel

class PriceSeekBarChangeListener(
    private val priceMax: TextView,
    private val viewModel: FilterViewModel
) : SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        priceMax.text = progress.toString()
        val filter = viewModel.liveDataFilterItem.value
        if (filter != null) {
            filter.filterPricesRequest.max = progress.toLong()
            viewModel.liveDataFilterItem.value = filter
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}