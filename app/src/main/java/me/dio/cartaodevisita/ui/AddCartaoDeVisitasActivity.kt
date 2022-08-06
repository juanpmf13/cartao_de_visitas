package me.dio.cartaodevisita.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import me.dio.cartaodevisita.App
import me.dio.cartaodevisita.R
import me.dio.cartaodevisita.data.CartaoDeVisitas
import me.dio.cartaodevisita.databinding.ActivityAddCartcaoDeVisitasBinding

class AddCartaoDeVisitasActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddCartcaoDeVisitasBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener(){
        binding.btnClose.setOnClickListener{
            finish()
        }
        binding.btnConfirma.setOnClickListener{
            val cartaoDeVisitas = CartaoDeVisitas(
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilNomeEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email =  binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(cartaoDeVisitas)
            Toast.makeText( this, R.string.label_show_success, Toast.LENGTH_SHORT ).show()
            finish()
        }
    }
}