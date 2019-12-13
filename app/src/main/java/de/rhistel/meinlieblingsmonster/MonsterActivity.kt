package de.rhistel.meinlieblingsmonster

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.monster_activity_layout.*

/**
 * Diese Activity ermoeglicht es dem
 * User eines von drei Monstern durch Klick
 * auf den passenden Button anzuzeigen
 */
class MonsterActivity : AppCompatActivity() {

    //region 0. Konstanten
    companion object MonsterActivityConstants {
        private const val FILE_NAME_MONSTER_ONE = "monster01.webp"
        private const val FILE_NAME_MONSTER_TWO = "monster02.webp"
        private const val FILE_NAME_MONSTER_THREE = "monster03.webp"
    }
    //endregion

    //region 1. Lebenszyklus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        this.setContentView(R.layout.monster_activity_layout)
    }
    //endregion

    //region 2. Klickhandling

    /**
     * Wenn einer der Auswahl-Buttons geklickt wird
     * springt diese Methode an und laedt die passende Grafik
     * zur Laufzeit
     */
    fun loadImage(v: View) {
        when (v.id) {
            R.id.btnShowMonsterOne -> showImageFromDrawableResourceInImageView(R.drawable.monster01)
            R.id.btnShowMonsterTwo -> showImageFromDrawableResourceInImageView(R.drawable.monster02)
            R.id.btnShowMonsterThree -> showImageFromDrawableResourceInImageView(R.drawable.monster03)
        }
    }


    /**
     * Zeigt das Bild ueber die Recource Id an
     */
    private fun showImageFromDrawableResourceInImageView(resId: Int) {
        imgvCurrentMonster.setImageResource(resId)
    }

    /**
     * Liest ein Bild aus dem assets ordner aus und zeigt dieses auf
     * der ImageView an
     */
    private fun showImageFromAssetsInImageView(fileNameMonsterOne: String) {
        assets.open(fileNameMonsterOne).use {

            //Laufzeitobjekt aus Bild geneireren
            val drawableFromTheImageFile = Drawable.createFromStream(it, null)

            //Bild anzeigen
            this.imgvCurrentMonster.setImageDrawable(drawableFromTheImageFile)

        }
    }
    //endregion


}
