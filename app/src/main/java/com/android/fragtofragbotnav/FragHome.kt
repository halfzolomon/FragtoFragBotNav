package com.android.fragtofragbotnav

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.fragtofragbotnav.databinding.FragmentFragHomeBinding


@Suppress("DEPRECATION")
class FragHome : Fragment() {
    lateinit var binding : FragmentFragHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFragHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(binding.hdHome)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_nav_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_home -> {
                Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.option_info -> {
                findNavController().navigate(R.id.action_fragHome_to_fragInfo)
                Toast.makeText(context, "Info", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.option_profile -> {
                findNavController().navigate(R.id.action_fragHome_to_fragProfile)
                Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show()

                return true
            }
            else -> super.onOptionsItemSelected(item)
            //dua
        }
    }
}