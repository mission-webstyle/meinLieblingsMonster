package de.rhistel.meinlieblingsmonster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity_content_layout.*
import kotlinx.android.synthetic.main.main_activity_layout.*

/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {

    //region 1 Lebenszyklus

    /**
     * Startet als erstes nach dem Konstruktor
     * Setzt das Layout und generiert alle direkt
     * benoetigten Widgets. Setzt Listener
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1. Layout setzen
        this.setContentView(R.layout.main_activity_layout)

        //2. Setzen der Toolbar
        setSupportActionBar(mainToolbar)

        btnLogIn.setOnClickListener{
            val strUserName = txtInputUserName.text.toString()
            val strUserPw = txtUserPw.text.toString()

            if((strUserName.isNotEmpty())&&(strUserPw.isNotEmpty())){
                val strCredentialsMessage = getString(R.string.strUserCredentialsMessage) +
                        strUserName + " " + strUserPw

                Toast.makeText(this,
                    strCredentialsMessage,
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,
                    R.string.strUserMessageFillInUserNameAndPw,
                    Toast.LENGTH_LONG).show()
            }
        }


    }

    //endregion

    //region 2. MenuHandling
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
//endregion
}
