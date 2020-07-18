package org.bloodwyn.userdata.view.viewassertion

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import junit.framework.TestCase.assertEquals
import java.lang.AssertionError
import java.lang.ClassCastException


/**
 *Utility functions for testing recycler view with Espresso
 */




fun isRVAdapterHasChildCount(expected: Int): ViewAssertion {
    return ViewAssertion { view: View, noMatchingViewException: NoMatchingViewException? ->
        val recyclerView =
            try {
                view as RecyclerView
            } catch (e: ClassCastException) {
                throw AssertionError(e.message)
            }
        requireNotNull(recyclerView.adapter) {
            "Impossible to check item's count on the recycler view" +
                "because adapter == null"
        }
        assertEquals(expected, recyclerView.adapter!!.itemCount)
    }
}

