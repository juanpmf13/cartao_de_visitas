package me.dio.cartaodevisita.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.dio.cartaodevisita.data.CartaoDeVisitas
import me.dio.cartaodevisita.databinding.ItemCartaoDeVisitaBinding
import java.util.Date.from

class CartcaoDeVisitasAdapter : ListAdapter<CartaoDeVisitas, CartcaoDeVisitasAdapter.ViewHolder>(DiffCallback()) {

    var listenersShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoDeVisitaBinding.inflate(inflater)
        return  ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class  ViewHolder(
        private val binding : ItemCartaoDeVisitaBinding
        ): RecyclerView.ViewHolder(binding.root){
            fun bind(item: CartaoDeVisitas){
                binding.tvName.text = item.nome
                binding.tvEmail.text = item.email
                binding.tvTelefone.text = item.telefone
                binding.tvNomeEmpresa.text = item.empresa
                binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
                binding.mcvContent.setOnClickListener{
                    listenersShare(it)
                }
            }
        }


}

class  DiffCallback : DiffUtil.ItemCallback<CartaoDeVisitas>(){
    override fun areItemsTheSame(oldItem: CartaoDeVisitas, newItem: CartaoDeVisitas) = oldItem == newItem

    override fun areContentsTheSame(oldItem: CartaoDeVisitas, newItem: CartaoDeVisitas): Boolean =oldItem.id ==  newItem.id

}