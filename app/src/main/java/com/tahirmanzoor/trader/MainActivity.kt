package com.tahirmanzoor.trader


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HALF_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN

class MainActivity : AppCompatActivity() {

    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var coordinatorLayout: CoordinatorLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomAppBar = findViewById(R.id.bottom_app_bar)
        coordinatorLayout = findViewById(R.id.coordinator_layout)
        val bottomDrawer = coordinatorLayout.findViewById<View>(R.id.bottom_drawer)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomDrawer)
        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.state = STATE_HIDDEN
        bottomAppBar.setNavigationOnClickListener {
            bottomSheetBehavior.state = STATE_HALF_EXPANDED
        }

    }
}

