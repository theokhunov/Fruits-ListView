package com.example.fruits

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.fruits.databinding.FruitListItemLayoutBinding

class CustomAdapter(context:Context, val fruitList:ArrayList<FruitModel>):ArrayAdapter<FruitModel>(context,R.layout.fruit_list_item_layout,fruitList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding:FruitListItemLayoutBinding
        if (convertView==null){
            binding = FruitListItemLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        }else{
            binding = FruitListItemLayoutBinding.bind(convertView)
        }

        binding.fruitName.text = fruitList[position].name
        binding.fruitImage.setImageResource(fruitList[position].image)
        return binding.root
    }


}