プロジェクト作成時に、Springのプロジェクト依存性を設定する箇所で、
１。webと検索窓に入れないと表示されなかった
２。書籍上は、web 、表示されていたのは　web starter project

application.propertiesに記載していたうち、下記は書籍と異なっていた
spring.datasource.initialization-mode=always
　（alwaysではなく、embededで良いかもしれない）

thymeleafとspringを連動させる箇所で、新規プロジェクトで作成したSpringが５を
使用しているので、 連動するjarも４->５に変更する必要があった
（そうしないと、sec:authorizeなどが htmlでそのまま表示されていた）

画面テストでの設定で、ユーザを特定する箇所
 書籍　： @WithMockUser(username = "satou", roles = {"ROLE_ADMIN"})
 修正後： @WithMockUser(username = "satou", roles = {"ADMIN"})


課題：４−４、ライフサイクルの違いの件、どう対応するようにSpringでは推奨しているか

画面一覧
　ログイン
　ユーザー登録
　ホーム
　ユーザー一覧
　ユーザー詳細
　管理者権限専用

(主な）使用しているライブラリ・FWについて

| カテゴリ  | 名前 | バージョン    | 公式サイト  | 参考度合い  |
|-------|:---:|-----------|-------:|-------:|
| ログ  | slf4j-api |1.7.26 | https://www.slf4j.org/  | △ |
| ログ | logback  | 1.2.3  | https://logback.qos.ch/manual/index_ja.html  | ◯ |
| 画面  | bootstrap   | 3.3.7.1 | https://getbootstrap.com/docs/3.3/css/  | x |
| 画面  | jquery   | 1.11.1 | https://jquery.com/  | x |
| 入力チェック  | hibernate-validator   | 6.0.17.Final | https://hibernate.org/validator/     | x |
| 画面（サーバ）  | thymeleaf-extras-springsecurity5   | 3.0.4 |   | x |
| 画面（サーバ）  | thymeleaf-spring5   | 3.0.11 |   | x |
| 画面（サーバ）  | thymeleaf   | 3.0.11 |  https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf_ja.html  | ◯ |
| Spring  | spring-web   | 5.1.9 |   | x |
| DB  | h2   | 1.4.199 | https://www.h2database.com/html/main.html     | x |
| DB  | mybatis   | 3.4.6 |  http://www.mybatis.org/mybatis-3/ja/index.html    | ◯ |
| その他  | lombok   | 1.18.8 | https://projectlombok.org/  | △ |

Springは多すぎるのでほぼ全て割愛



