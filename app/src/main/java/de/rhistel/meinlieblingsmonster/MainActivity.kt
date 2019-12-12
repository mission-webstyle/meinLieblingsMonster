package de.rhistel.meinlieblingsmonster

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {

    //region 1. Decl. and Init Widgets und Attribute
    private lateinit var mainToolbar: Toolbar
    private lateinit var txtInputUserName: EditText
    private lateinit var txtUserPw: EditText
    private lateinit var btnLogIn: Button
    //endregion

    //region 2. Lebenszyklus

    /**
     * Startet als erstes nach dem Konstruktor
     * Setzt das Layout und generiert alle direkt
     * benoetigten Widgets. Setzt Listener
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //1. Layout setzen
        this.setContentView(R.layout.main_activity_layout)

        //2. Widgets generieren
        this.mainToolbar = this.findViewById(R.id.mainToolbar)
        this.btnLogIn = this.findViewById(R.id.btnLogIn)
        this.txtInputUserName = this.findViewById(R.id.txtInputUserName)
        this.txtUserPw = this.findViewById(R.id.txtUserPw)

        //2. Setzen der Toolbar
        setSupportActionBar(this.mainToolbar)

        //3. Listener setzen
        this.btnLogIn.setOnClickListener {
            val strUserName = this.txtInputUserName.text.toString()
            val strUserPw = this.txtUserPw.text.toString()

            if ((strUserName.isNotEmpty()) && (strUserPw.isNotEmpty())) {
                val strCredentialsMessage = getString(R.string.strUserCredentialsMessage) +
                        strUserName + " " + strUserPw

                Toast.makeText(
                    this,
                    strCredentialsMessage,
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    R.string.strUserMessageFillInUserNameAndPw,
                    Toast.LENGTH_LONG
                ).show()
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
