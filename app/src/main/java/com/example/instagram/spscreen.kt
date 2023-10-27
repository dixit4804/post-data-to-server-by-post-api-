package com.example.instagram

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class spscreen : AppCompatActivity() {
    private lateinit var minusButton1: Button
    private lateinit var plusButton1: Button
    private lateinit var quantityTextView1: TextView
    private lateinit var quantityTextView2: TextView
    private lateinit var quantityTextView3: TextView
    private lateinit var quantityTextView4: TextView
    private lateinit var quantityTextView5: TextView
    private lateinit var quantityTextView6: TextView
    private lateinit var quantityTextView7: TextView
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox
    private lateinit var checkBox5: CheckBox
    private lateinit var checkBox6: CheckBox
    private lateinit var checkBox7: CheckBox


    private lateinit var photobtnmin: Button
    private lateinit var photobtnmax: Button

    private lateinit var cinemabtnmax: Button
    private lateinit var cinemabtnmin: Button

    private lateinit var candidbtnmax: Button
    private lateinit var candidbtnmin: Button

    private lateinit var dronebtnmax: Button
    private lateinit var dronebtnmin: Button

    private lateinit var boothbtnmax: Button
    private lateinit var boothbtnmin: Button

    private lateinit var ledbtnmax: Button
    private lateinit var ledbtnmin: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spscreen)

        // Initialize views for the videography
        minusButton1 = findViewById(R.id.minusButton)
        plusButton1 = findViewById(R.id.plusButton)
        quantityTextView1 = findViewById(R.id.quantityTextView)
        checkBox1 = findViewById(R.id.videography)

        // Set click listeners for the videography
        minusButton1.setOnClickListener { decrementQuantity(quantityTextView1) }
        plusButton1.setOnClickListener { incrementQuantity(quantityTextView1) }
        checkBox1.setOnCheckedChangeListener { _, isChecked ->
            // Handle checkbox state change for the first set
            if (isChecked) {
                // Checkbox is checked for the first set
            } else {
                // Checkbox is unchecked for the first set
            }
        }

        // Initialize views for the photograhy (you need to add the rest of the sets)
        photobtnmin = findViewById(R.id.photobtnmin)
        photobtnmax = findViewById(R.id.photobtnmax)
        quantityTextView2 = findViewById(R.id.quantityTextView2)
        checkBox2 = findViewById(R.id.photograhy)

        // Set click listeners for the second set
        photobtnmin.setOnClickListener { decrementQuantity(quantityTextView2) }
        photobtnmax.setOnClickListener { incrementQuantity(quantityTextView2) }
        checkBox2.setOnCheckedChangeListener { _, isChecked ->
            // Handle checkbox state change for the second set
            if (isChecked) {
                // Checkbox is checked for the second set
            } else {
                // Checkbox is unchecked for the second set
            }
        }

        // Initialize views for the cinema (you need to add the rest of the sets)
        cinemabtnmin = findViewById(R.id.cinemabtnmin)
        cinemabtnmax = findViewById(R.id.cinemabtnmax)
        quantityTextView3 = findViewById(R.id.quantityTextView3)
        checkBox3 = findViewById(R.id.cinematography)



        // Initialize views for the candid (you need to add the rest of the sets)
        candidbtnmin = findViewById(R.id.candidbtnmin)
        candidbtnmax = findViewById(R.id.candidbtnmax)
        quantityTextView4 = findViewById(R.id.quantityTextView4)
        checkBox4 = findViewById(R.id.candidgraphy)

        // Set click listeners for candid
        candidbtnmin.setOnClickListener { decrementQuantity(quantityTextView4) }
        candidbtnmax.setOnClickListener { incrementQuantity(quantityTextView4) }
        checkBox4.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {

            } else
            {

            }
        }

        // Set click listeners for cinema
        cinemabtnmin.setOnClickListener { decrementQuantity(quantityTextView3) }
        cinemabtnmax.setOnClickListener { incrementQuantity(quantityTextView3) }
        checkBox3.setOnCheckedChangeListener { _, isChecked ->
            // Handle checkbox state change for the second set
            if (isChecked) {
                // Checkbox is checked for the second set
            } else {
                // Checkbox is unchecked for the second set
            }
        }
        // Initialize views for the drone (you need to add the rest of the sets)
        dronebtnmax = findViewById(R.id.dronebtnmax)
        dronebtnmin = findViewById(R.id.dronebtnmin)
        quantityTextView5 = findViewById(R.id.quantityTextView5)
        checkBox5 = findViewById(R.id.drone)

        // Set click listeners for drone
        dronebtnmin.setOnClickListener { decrementQuantity(quantityTextView5) }
        dronebtnmax.setOnClickListener { incrementQuantity(quantityTextView5) }
        checkBox5.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {

            } else {
            }
        }

        // Initialize views for the PhotoBooth (you need to add the rest of the sets)
        boothbtnmax = findViewById(R.id.boothbtnmax)
        boothbtnmin = findViewById(R.id.boothbtnmin)
        quantityTextView6 = findViewById(R.id.quantityTextView6)
        checkBox6 = findViewById(R.id.photobooth)

        // Set click listeners for PhotoBooth
        boothbtnmin.setOnClickListener { decrementQuantity(quantityTextView6) }
        boothbtnmax.setOnClickListener { incrementQuantity(quantityTextView6) }
        checkBox5.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {

            } else {
            }
        }
        // Initialize views for the LEdScreen (you need to add the rest of the sets)
        ledbtnmax = findViewById(R.id.ledbtnmax)
        ledbtnmin = findViewById(R.id.ledbtnmin)
        quantityTextView7 = findViewById(R.id.quantityTextView7)
        checkBox7 = findViewById(R.id.ledScreen)

        // Set click listeners for LED Screen
        ledbtnmin.setOnClickListener { decrementQuantity(quantityTextView7) }
        ledbtnmax.setOnClickListener { incrementQuantity(quantityTextView7) }
        checkBox5.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {

            } else {
            }
        }

    }

    private fun decrementQuantity(quantityTextView: TextView) {
        var currentQuantity = quantityTextView.text.toString().toInt()
        if (currentQuantity > 0) {
            currentQuantity--
            quantityTextView.text = currentQuantity.toString()
        }
    }

    private fun incrementQuantity(quantityTextView: TextView) {
        var currentQuantity = quantityTextView.text.toString().toInt()
        currentQuantity++
        quantityTextView.text = currentQuantity.toString()
    }
}
