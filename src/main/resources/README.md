## liquibase


2023/12/27現在はliquibaseはr2dbcには対応していない。
そのため、r2dbcを使いたいと思ったら、liquibaseでのマイグレーション実行時は
jdbc driverを、application 実行時の接続driverはr2dbcを使う、という形を取るしかなさそう。

https://stackoverflow.com/questions/62555217/r2dbc-and-liquibase

