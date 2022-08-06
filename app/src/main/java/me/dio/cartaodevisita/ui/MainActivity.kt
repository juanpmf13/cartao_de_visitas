package me.dio.cartaodevisita.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import me.dio.cartaodevisita.App
import me.dio.cartaodevisita.databinding.ActivityAddCartcaoDeVisitasBinding
import me.dio.cartaodevisita.databinding.ActivityMainBinding
import me.dio.cartaodevisita.util.Image

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as  App).repository)
    }

    private val adapter by lazy{ CartcaoDeVisitasAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllCartoesDeVisita()
        insertListener()
    }

    private fun insertListener(){
        binding.fab.setOnClickListener{
            val intent = Intent(this@MainActivity, AddCartaoDeVisitasActivity::class.java)
            startActivity(intent)
        }
        adapter.listenersShare = { card ->
            Image.share(this@MainActivity, card)

        }
    }
    private fun getAllCartoesDeVisita(){
        mainViewModel.getAll().observe(this, { cartaoDeVisitas ->
            adapter.submitList(cartaoDeVisitas)
        })
    }

}