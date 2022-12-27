package com.muradsapplications.tictactoegame.ui.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.muradsapplications.tictactoegame.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        binding.player1.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (event != null && event.keyCode === KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                //do what you want on the press of 'done'
                binding.buttonStart.performClick()
            }
            false
        })
        binding.player2.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (event != null && event.keyCode === KeyEvent.KEYCODE_ENTER || actionId == EditorInfo.IME_ACTION_DONE) {
                //do what you want on the press of 'done'
                binding.buttonStart.performClick()
            }
            false
        })

        binding.buttonStart.setOnClickListener{
          if(binding.player1.text.toString() != binding.player2.text.toString()){
            val player1 = binding.player1.text.toString()
            val player2 = binding.player2.text.toString()
            val navigation = HomeFragmentDirections.toGame(player1,player2)

            Navigation.findNavController(it).navigate(navigation)}
           else if(binding.player1.text.toString() == "" || binding.player2.text.toString() == "")
              Snackbar.make(it,"Name cannot be Blank! , Please add your name!!!",Snackbar.LENGTH_SHORT).show()
            else {
                Snackbar.make(it,"You Cannot insert same name!!!",Snackbar.LENGTH_SHORT).show()
          }
        }
        return binding.root
    }


}