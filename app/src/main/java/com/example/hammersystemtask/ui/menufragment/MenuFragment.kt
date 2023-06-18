package com.example.hammersystemtask.ui.menufragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hammersystemtask.common.mvvm.BaseFragment
import com.example.hammersystemtask.databinding.MenuFragmentBinding
import com.example.hammersystemtask.ui.main.MainActivity
import com.example.hammersystemtask.ui.mealsadapter.ItemMapper
import com.example.hammersystemtask.ui.mealsadapter.MealItemAdapter
import com.example.hammersystemtask.ui.utils.UIUtils.collectIn
import com.example.hammersystemtask.ui.utils.UIUtils.repeatOnCreated
import kotlinx.coroutines.flow.collectLatest
import java.io.LineNumberReader
import javax.inject.Inject

class MenuFragment: BaseFragment<MainActivity>() {
    @Inject
    lateinit var viewModel: MenuViewModel
    private lateinit var binding: MenuFragmentBinding

    private val mealsAdapter by lazy {
        MealItemAdapter()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        baseActivity.activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MenuFragmentBinding.inflate(inflater, container, false)

        binding.menu.apply {
            adapter = mealsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setCategory(requireArguments().getString("type", ""))

        

        viewModel.items.collectIn(lifecycleScope) {

            mealsAdapter.items = it.map { ItemMapper.fromDomainEntityToMapper(it) }
        }
    }
}