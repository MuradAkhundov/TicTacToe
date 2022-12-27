package com.muradsapplications.tictactoegame.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.muradsapplications.tictactoegame.R
import com.muradsapplications.tictactoegame.databinding.FragmentGameBinding


class GameFragment : Fragment() {
private lateinit var binding: FragmentGameBinding
var player = 1
    var countx = 0
    var counto = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(layoutInflater,container,false)
//var bundle : GameF
        val bundle: GameFragmentArgs by navArgs()
        val player1Name = bundle.player1
        val player2Name = bundle.player2

        binding.textViewPlayerOne.text = player1Name
        binding.textViewPlayerTwo.text = player2Name
        fun buttonChecker(btn :Button){




            if (player == 1) {
                player = 2
                btn.text = "X"
            } else if (player == 2) {
                player = 1
                btn.text = "O"
            }
winCheck()



        }
winCheck()

        binding.btn1.setOnClickListener{
            buttonChecker(binding.btn1)
            disableOneButton(binding.btn1)
        }
        binding.btn2.setOnClickListener{
            buttonChecker(binding.btn2)
            disableOneButton(binding.btn2)
        }
        binding.btn3.setOnClickListener{
            buttonChecker(binding.btn3)
            disableOneButton(binding.btn3)
        }
        binding.btn4.setOnClickListener{
            buttonChecker(binding.btn4)
            disableOneButton(binding.btn4)
        }
        binding.btn5.setOnClickListener{
            buttonChecker(binding.btn5)
            disableOneButton(binding.btn5)
        }
        binding.btn6.setOnClickListener{
            buttonChecker(binding.btn6)
            disableOneButton(binding.btn6)
        }
        binding.btn7.setOnClickListener{
            buttonChecker(binding.btn7)
            disableOneButton(binding.btn7)
        }
        binding.btn8.setOnClickListener{
            buttonChecker(binding.btn8)
            disableOneButton(binding.btn8)
        }
        binding.btn9.setOnClickListener{
            buttonChecker(binding.btn9)
            disableOneButton(binding.btn9)
        }


        binding.buttonReset.setOnClickListener{
    reset()
    player = 1
}

        return binding.root
    }
    fun winCheck()
    {
        if(    (binding.btn1.text == "X" && binding.btn2.text == "X" && binding.btn3.text =="X")
            || (binding.btn1.text == "X" && binding.btn2.text == "X" && binding.btn3.text =="X")
            || (binding.btn4.text == "X" && binding.btn5.text == "X" && binding.btn6.text =="X")
            || (binding.btn7.text == "X" && binding.btn8.text == "X" && binding.btn9.text =="X")
            || (binding.btn1.text == "X" && binding.btn4.text == "X" && binding.btn7.text =="X")
            || (binding.btn2.text == "X" && binding.btn5.text == "X" && binding.btn8.text =="X")
            || (binding.btn3.text == "X" && binding.btn6.text == "X" && binding.btn9.text =="X")
            || (binding.btn1.text == "X" && binding.btn5.text == "X" && binding.btn9.text =="X")
            || (binding.btn3.text == "X" && binding.btn5.text == "X" && binding.btn7.text =="X")
        )
        {
            countx++
            binding.textViewResult.text = "Winner is ${binding.textViewPlayerOne.text}"
            disableButton()
            binding.textViewScoreOne.text = countx.toString()
        }
        else if((binding.btn1.text == "O" && binding.btn2.text == "O" && binding.btn3.text =="O")
            || (binding.btn1.text == "O" && binding.btn2.text == "O" && binding.btn3.text =="O")
            || (binding.btn4.text == "O" && binding.btn5.text == "O" && binding.btn6.text =="O")
            ||  (binding.btn7.text == "O" && binding.btn8.text == "O" && binding.btn9.text =="O")
            ||  (binding.btn1.text == "O" && binding.btn4.text == "O" && binding.btn7.text =="O")
            ||  (binding.btn2.text == "O" && binding.btn5.text == "O" && binding.btn8.text =="O")
            ||  (binding.btn3.text == "O" && binding.btn6.text == "O" && binding.btn9.text =="O")
            ||  (binding.btn1.text == "O" && binding.btn5.text == "O" && binding.btn9.text =="O")
            ||  (binding.btn3.text == "O" && binding.btn5.text == "O" && binding.btn7.text =="O")){
            counto++
            binding.textViewResult.text = "Winner is ${binding.textViewPlayerTwo.text}"
            disableButton()
            binding.textViewScoreOne2.text = counto.toString()
        }
        else{

        }
    }

    fun reset(){

//        val arr = arrayOf(
//            "${binding.btn1.text}", "${binding.btn2.text}", "${binding.btn3.text}",
//            "${binding.btn1.text}", "${binding.btn2.text}", "${binding.btn3.text}",
//            "${binding.btn1.text}", "${binding.btn2.text}", "${binding.btn3.text}")
//
//        for (x in arr){
//            x = "0"
//        }

        binding.btn1.text =""
        binding.btn2.text =""
        binding.btn3.text =""
        binding.btn4.text =""
        binding.btn5.text =""
        binding.btn6.text =""
        binding.btn7.text =""
        binding.btn8.text =""
        binding.btn9.text =""
        enableButton()
        binding.textViewResult.text = ""
    }

    fun snack1(){
        Snackbar.make(requireView(),"Player 1 WON!!",Snackbar.LENGTH_SHORT).show()
    }
    fun snack2(){
        Snackbar.make(requireView(),"Player 2 WON!!",Snackbar.LENGTH_SHORT).show()
    }
    fun disableButton(){
        binding.btn1.isEnabled = false
        binding.btn2.isEnabled = false
        binding.btn3.isEnabled = false
        binding.btn4.isEnabled = false
        binding.btn5.isEnabled = false
        binding.btn6.isEnabled = false
        binding.btn7.isEnabled = false
        binding.btn8.isEnabled = false
        binding.btn9.isEnabled = false
    }
    fun disableOneButton(btn :Button){
        btn.isEnabled = false
    }
    fun enableButton(){
        binding.btn1.isEnabled = true
        binding.btn2.isEnabled = true
        binding.btn3.isEnabled = true
        binding.btn4.isEnabled = true
        binding.btn5.isEnabled = true
        binding.btn6.isEnabled = true
        binding.btn7.isEnabled = true
        binding.btn8.isEnabled = true
        binding.btn9.isEnabled = true
    }
}