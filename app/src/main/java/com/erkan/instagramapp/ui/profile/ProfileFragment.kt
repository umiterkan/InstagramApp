package com.erkan.instagramapp.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.erkan.instagramapp.R
import com.erkan.instagramapp.databinding.FragmentProfileBinding
import com.erkan.instagramapp.data.model.User

/**
 * Created by umiterkan on 11/9/2020
 */

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = arguments?.getParcelable("user") as User?

        Log.d("msg","user : $user")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        user?.let {
            binding.user = it
        } ?: run {
            binding.user = User(
                22,
                "Ümit Erkan",
                "https://media.istockphoto.com/photos/robin-picture-id471196487"
            )
        }
    }

}