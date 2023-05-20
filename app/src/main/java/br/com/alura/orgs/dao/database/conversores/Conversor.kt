package br.com.alura.orgs.dao.database.conversores

import androidx.room.TypeConverter
import java.math.BigDecimal

class Conversor {

    @TypeConverter
    fun paraBigDecimal(valor: Double?): BigDecimal {
        return valor?.let { BigDecimal(valor.toString()) } ?: BigDecimal.ZERO
    }

    @TypeConverter
    fun paraDouble(valor: BigDecimal?): Double? {
        return valor?.let { valor.toDouble() }
    }
}