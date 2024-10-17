package com.example.hw0305

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import com.example.hw0305.databinding.FragmentFirstBinding


    class FirstFragment : Fragment() {
        lateinit var binding: FragmentFirstBinding
        private var counter = 0
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentFirstBinding.inflate(layoutInflater)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            binding.idButton.setOnClickListener(View.OnClickListener {
                if (binding.idButton.text == "+1"){
                    if (counter < 10){
                        counter++
                        binding.idCounter.text = counter.toString()
                    }
                    else{
                        binding.idButton.text = "-1"
                    }
                }else{
                    if (counter <= 10 && counter > 0) {
                        counter--
                        binding.idCounter.text = counter.toString()
                    }
                    else{
                        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment()).commit()
                    }
                }

            })
        }


    }
