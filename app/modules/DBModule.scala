package modules

import com.google.inject.{AbstractModule, Provides}
import play.api.db.slick.DatabaseConfigProvider
import slick.basic.DatabaseConfig
import slick.jdbc.{JdbcBackend, PostgresProfile}

private[modules] trait Database {
  def config: DatabaseConfig[MyPostgresProfile]
  def db: JdbcBackend#DatabaseDef
  def profile: PostgresProfile
}

trait AppDatabase extends Database

class DBModule extends AbstractModule {

  override def configure(): Unit = ()

  @Provides
  def provideDatabase(dbConfigProvider: DatabaseConfigProvider): AppDatabase = new AppDatabase {
    override def config = dbConfigProvider.get[MyPostgresProfile]

    override def db = config.db

    override def profile = config.profile
  }

}
