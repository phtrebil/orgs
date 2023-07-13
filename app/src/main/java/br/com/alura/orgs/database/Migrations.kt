package br.com.alura.orgs.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS `Usuario` (
            `id` TEXT NOT NULL, 
            `nome` TEXT NOT NULL, 
            `senha` TEXT NOT NULL, PRIMARY KEY(`id`))
            """
        )
    }
}
val MIGRATION_2_3 = object : Migration(2, 3) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE Produto ADD COLUMN 'usuarioId' TEXT")
    }

}

val MIGRATION_3_4 = object : Migration(3, 4) {
    override fun migrate(database: SupportSQLiteDatabase) {
        // 1. Renomear a tabela existente
        database.execSQL("ALTER TABLE `Usuario` RENAME TO `temp_Usuario`")

        // 2. Criar a nova tabela com a estrutura atualizada
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS `Usuario` (
            `id` TEXT NOT NULL, 
            `email` TEXT NOT NULL, 
            `senha` TEXT NOT NULL, PRIMARY KEY(`id`))
            """
        )

        // 3. Copiar os dados da tabela temporária para a nova tabela
        database.execSQL(
            """
            INSERT INTO `Usuario` (`id`, `email`, `senha`)
            SELECT `id`, `nome`, `senha` FROM `temp_Usuario`
            """
        )

        // 4. Remover a tabela temporária
        database.execSQL("DROP TABLE IF EXISTS `temp_Usuario`")
    }
}



