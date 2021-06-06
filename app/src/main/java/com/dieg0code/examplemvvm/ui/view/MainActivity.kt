package com.dieg0code.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.dieg0code.examplemvvm.databinding.ActivityMainBinding
import com.dieg0code.examplemvvm.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    // simple viewBinding implementation
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        /* todo lo  que este aqui dentro esta vinculado al live data, y cuando nuestro liveData
        *  obtenga un cambio, por ejemplo una nueva cita, se va a ejecutar lo que se declare aquí*/
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            // vinculamos la data obtenida con el layout
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }
}