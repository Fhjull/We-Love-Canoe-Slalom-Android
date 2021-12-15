package ru.dillab.welovecanoeslalomandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import ru.dillab.welovecanoeslalomandroid.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Getting a reference to the nav_host_fragment and assign it to the navController property
        // This is needed to construct our navigation as we specified in nav_graph.xml
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Adds up button (back button) in title (top left corner)
        setupActionBarWithNavController(navController)
    }

    // This method allows to handle the up button.
    // Needed with setupActionBarWithNavController(navController)
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}

// fun Activity.hideSoftKeyboard(editText: EditText){
//     (getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
//         hideSoftInputFromWindow(editText.windowToken, 0)
//     }
// }