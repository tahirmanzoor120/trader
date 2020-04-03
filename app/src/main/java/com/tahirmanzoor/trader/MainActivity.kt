package com.tahirmanzoor.trader


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HALF_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.tahirmanzoor.trader.dto.Product
import com.tahirmanzoor.trader.fragment.product.ProductFragment


class MainActivity : AppCompatActivity(), ProductFragment.OnListFragmentInteractionListener {

    private lateinit var bottomAppBar: BottomAppBar
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var coordinatorLayout: CoordinatorLayout
    private lateinit var navigationView: NavigationView
    private lateinit var fabAddNewInvoice: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomAppBar = findViewById(R.id.bottom_app_bar)
        navigationView = findViewById(R.id.navigation_view)
        fabAddNewInvoice = findViewById(R.id.fab_add_new_bill)

        coordinatorLayout = findViewById(R.id.coordinator_layout)
        val bottomDrawer = coordinatorLayout.findViewById<View>(R.id.bottom_drawer)
        bottomSheetBehavior = BottomSheetBehavior.from(bottomDrawer)
        bottomSheetBehavior.isHideable = true
        bottomSheetBehavior.state = STATE_HIDDEN
        bottomAppBar.setNavigationOnClickListener {
            bottomSheetBehavior.state = STATE_HALF_EXPANDED
        }

        bottomAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.products -> {
                    addFragmentToActivity(
                        supportFragmentManager,
                        ProductFragment(),
                        R.id.fragment_view
                    )
                }
                R.id.customers -> Toast.makeText(
                    applicationContext,
                    "Customers Clicked.",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.invoices -> Toast.makeText(
                    applicationContext,
                    "Invoices Clicked.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.recoveries -> Toast.makeText(
                    applicationContext,
                    "Recoveries Clicked.",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.returns -> Toast.makeText(
                    applicationContext,
                    "Returns Clicked.",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.expenses -> Toast.makeText(
                    applicationContext,
                    "Expense Clicked.",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.schedule -> Toast.makeText(
                    applicationContext,
                    "Schedule Clicked.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }

        fabAddNewInvoice.setOnClickListener {
            Toast.makeText(applicationContext, "FAB Clicked.", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onListFragmentInteraction(product: Product) {
        Toast.makeText(applicationContext, "Clicked on the List", Toast.LENGTH_SHORT).show()
        if (product != null) {
            Toast.makeText(
                applicationContext,
                "Product Selected: " + product.productId,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun addFragmentToActivity(
        manager: FragmentManager,
        fragment: Fragment?,
        containerViewID: Int
    ) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        if (fragment != null) {
            transaction.add(containerViewID, fragment)
        }
        transaction.commit()
    }

}

