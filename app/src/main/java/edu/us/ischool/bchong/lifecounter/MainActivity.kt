package edu.us.ischool.bchong.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainLayout = findViewById<ConstraintLayout>(R.id.mainLayout)

        var lp: IntArray = intArrayOf(20, 20, 20, 20)
        val buttons: HashMap<String, Int>
                = hashMapOf("Minus5" to -5, "Minus1" to -1, "Plus1" to 1, "Plus5" to 5)

        for (i in 0..3) {
            for (button in buttons) {
                val resButtonID = resources.getIdentifier(
                    "player" + (i + 1) + button.key,
                    "id",
                    packageName
                )
                findViewById<Button>(resButtonID).setOnClickListener(object : View.OnClickListener{
                    override fun onClick(v: View?) {
                        val origLP = lp[i]
                        lp[i] += button.value
                        val resLPID = resources.getIdentifier(
                            "player" + (i + 1) + "LP",
                            "id",
                            packageName
                        )
                        if (lp[i] <= 0 && origLP > 0) {
                            val playerLostLabel = findViewById<TextView>(R.id.playerLostLabel)
                                playerLostLabel.append("Player " + (i + 1) + " LOSES!\n")
                                playerLostLabel.visibility = View.VISIBLE
                        }
                        findViewById<TextView>(resLPID).text = lp[i].toString()
                    }
                })
            }
        }
    }
}
