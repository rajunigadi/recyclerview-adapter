package com.raju.generic.list.adapter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.raju.generic.list.adapter.data.User
import com.raju.generic.list.adapter.databinding.FragmentHomeBinding
import com.raju.generic.list.adapter.ui.adapters.HomeAdapter

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeAdapter = HomeAdapter() { item, view ->
            Toast.makeText(requireActivity(), "Item clicked: ${item.name}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter = homeAdapter

        val users = mutableListOf<User>().apply {
            add(User("User 1", "user1@gmail.com", ""))
            add(User("User 2", "user2@gmail.com", ""))
            add(User("User 3", "user3@gmail.com", ""))
            add(User("User 4", "user4@gmail.com", ""))
            add(User("User 5", "user5@gmail.com", ""))
        }
        homeAdapter?.submitList(users)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}