package com.flysoft.maisonier.dataBase;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by LARUMEUR on 20/07/2016.
 */

@Database(name = Maisonier.NAME, version = Maisonier.VERSION)
public class Maisonier {

    public static final String NAME = "\n" +
            "compile \"com.github.Raizlabs.DBFlow:dbflow-sqlcipher:3.1.1@aar\"";

    public static final int VERSION = 1;
}