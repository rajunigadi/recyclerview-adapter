package com.raju.generic.list.adapter.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.raju.generic.list.adapter.data.DashboardHeader
import com.raju.generic.list.adapter.data.DashboardItem
import com.raju.generic.list.adapter.data.ListItem
import com.raju.generic.list.adapter.databinding.FragmentDashboardBinding
import com.raju.generic.list.adapter.ui.adapters.DashboardAdapter

class DashboardFragment: Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private var dashboardAdapter: DashboardAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set up recycler view
        dashboardAdapter = DashboardAdapter() { item, view ->
            Toast.makeText(requireActivity(), "Item clicked: $item", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter = dashboardAdapter

        val users = mutableListOf<ListItem>().apply {
            add(DashboardHeader("Header 1"))
            add(DashboardItem("User 1", "user1@gmail.com"))
            add(DashboardItem("User 2", "user2@gmail.com"))
            add(DashboardItem("User 3", "user3@gmail.com"))
            add(DashboardHeader("Header 2"))
            add(DashboardItem("User 4", "user4@gmail.com"))
            add(DashboardItem("User 5", "user5@gmail.com"))
            add(DashboardItem("User 5", "user5@gmail.com"))
        }
        dashboardAdapter?.submitList(users)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}