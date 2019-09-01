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