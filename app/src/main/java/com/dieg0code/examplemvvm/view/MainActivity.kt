package com.dieg0code.examplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dieg0code.examplemvvm.databinding.ActivityMainBinding
import com.dieg0code.examplemvvm.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    // simple viewBinding implementation
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* todo lo  que este aqui dentro esta vinculado al live data, y cuando nuestro liveData
        *  obtenga un cambio, por ejmplo una nueva sita, se va a ejecutar lo que se declare aqui*/
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}