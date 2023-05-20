package br.com.alura.orgs.dao.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.dao.UsuarioDao
import br.com.alura.orgs.dao.database.conversores.Conversor
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.model.Usuario

@Database(entities = [Produto::class,
                     Usuario::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(Conversor::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao

    abstract fun usuarioDao(): UsuarioDao

    companion object {
        fun instancia(context: Context) : AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "orgs.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}