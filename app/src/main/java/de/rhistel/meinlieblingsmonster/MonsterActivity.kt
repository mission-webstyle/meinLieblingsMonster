package de.rhistel.meinlieblingsmonster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Diese Activity ermoeglicht es dem
 * User eines von drei Monstern durch Klick
 * auf den passenden Button anzuzeigen
 */
class MonsterActivity : AppCompatActivity() {

    //region 0. Konstanten
    //endregion

    //region 1. Lebenszyklus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        this.setContentView(R.layout.monster_activity_layout)
    }
    //endregion

    //region 2. Klickhandling
    //endregion



}
