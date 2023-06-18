package com.example.hammersystemtask.ui.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.widget.EditText
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object UIUtils {
    fun LifecycleOwner.repeatOnCreated(block: suspend CoroutineScope.() -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED, block)
        }
    }

    fun NavController.destinationFlow() = callbackFlow {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            runBlocking { send(destination) }
        }
        addOnDestinationChangedListener(listener)
        awaitClose { removeOnDestinationChangedListener(listener) }
    }
    fun Snackbar.top(): Snackbar = apply {
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.TOP
        view.layoutParams = params
    }

    fun <T> Flow<T>.collectOnLifeCycle(
        owner: LifecycleOwner,
        state: Lifecycle.State = Lifecycle.State.CREATED,
        collector: FlowCollector<T>,
    ) {
        owner.lifecycleScope.launch {
            owner.repeatOnLifecycle(state) {
                collect(collector)
            }
        }
    }

    fun <T> Flow<T>.collectIn(
        coroutineScope: CoroutineScope,
        flowCollector: FlowCollector<T>
    ) {
        coroutineScope.launch {
            collect(flowCollector)
        }
    }

    fun EditText.replaceText(newText: String) {
        if (text.toString() != newText) setText(newText)
    }

    fun EditText.onTextChanged(debounce: Long = 250) = callbackFlow<String> {
        val listener = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                runBlocking { send(p0.toString()) }
            }

            override fun afterTextChanged(p0: Editable?) {
                runBlocking { send(p0.toString()) }
            }

        }
        addTextChangedListener(listener)

        send(text.toString())

        awaitClose {
            removeTextChangedListener(listener)
        }
    }.debounce(debounce).distinctUntilChanged()
}