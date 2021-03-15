package com.example.minhaprova

import android.provider.BaseColumns

object LivroContrato {
    const val DATABASE_NAME = "livrodb.sqlite"
    const val DATA_BASE_VERSION = 1

    object LivroEntry : BaseColumns {
        const val TABLE_NAME = "livro"
        const val TITULO = "titulo"
        const val AUTOR = "autor"
        const val ANO = "ano"
        const val NOTA = "nota"
    }
}