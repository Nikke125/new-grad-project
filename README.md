
```
new-grad-project
├─ second-hand-goods-trading-SpringBoot-Vue-main
│  ├─ .DS_Store
│  ├─ mysql
│  │  └─ db_second_hand_trading.sql
│  ├─ pic
│  ├─ README.md
│  ├─ second-hand-goods-trading-back
│  │  ├─ .DS_Store
│  │  ├─ pom.xml
│  │  ├─ src
│  │  │  ├─ .DS_Store
│  │  │  └─ main
│  │  │     ├─ .DS_Store
│  │  │     ├─ java
│  │  │     │  └─ com
│  │  │     │     └─ second
│  │  │     │        └─ hand
│  │  │     │           └─ trading
│  │  │     │              └─ server
│  │  │     │                 ├─ controller
│  │  │     │                 │  ├─ AddressController.java
│  │  │     │                 │  ├─ AdminController.java
│  │  │     │                 │  ├─ FavoriteController.java
│  │  │     │                 │  ├─ FileController.java
│  │  │     │                 │  ├─ IdleItemController.java
│  │  │     │                 │  ├─ MessageController.java
│  │  │     │                 │  ├─ OrderAddressController.java
│  │  │     │                 │  ├─ OrderController.java
│  │  │     │                 │  ├─ UserController.java
│  │  │     │                 │  ├─ UserWXController.java
│  │  │     │                 │  └─ 毕业设计校园交易.code-workspace
│  │  │     │                 ├─ dao
│  │  │     │                 │  ├─ AddressDao.java
│  │  │     │                 │  ├─ AdminDao.java
│  │  │     │                 │  ├─ CreditLogDao.java
│  │  │     │                 │  ├─ FavoriteDao.java
│  │  │     │                 │  ├─ IdleItemDao.java
│  │  │     │                 │  ├─ MessageDao.java
│  │  │     │                 │  ├─ OrderAddressDao.java
│  │  │     │                 │  ├─ OrderDao.java
│  │  │     │                 │  ├─ UserDao.java
│  │  │     │                 │  └─ UserWXDao.java
│  │  │     │                 ├─ enums
│  │  │     │                 │  └─ ErrorMsg.java
│  │  │     │                 ├─ Exception
│  │  │     │                 │  └─ ParamException.java
│  │  │     │                 ├─ Handler
│  │  │     │                 │  └─ GlobalExceptionHandler.java
│  │  │     │                 ├─ LogCostInterceptor.java
│  │  │     │                 ├─ mapper
│  │  │     │                 ├─ model
│  │  │     │                 │  ├─ AddressModel.java
│  │  │     │                 │  ├─ AdminModel.java
│  │  │     │                 │  ├─ CreditLogModel.java
│  │  │     │                 │  ├─ FavoriteModel.java
│  │  │     │                 │  ├─ IdleItemModel.java
│  │  │     │                 │  ├─ MessageModel.java
│  │  │     │                 │  ├─ OrderAddressModel.java
│  │  │     │                 │  ├─ OrderModel.java
│  │  │     │                 │  └─ UserModel.java
│  │  │     │                 ├─ ServerApplication.java
│  │  │     │                 ├─ service
│  │  │     │                 │  ├─ AddressService.java
│  │  │     │                 │  ├─ AdminService.java
│  │  │     │                 │  ├─ FavoriteService.java
│  │  │     │                 │  ├─ FileService.java
│  │  │     │                 │  ├─ IdleItemService.java
│  │  │     │                 │  ├─ impl
│  │  │     │                 │  │  ├─ AddressServiceImpl.java
│  │  │     │                 │  │  ├─ AdminServiceImpl.java
│  │  │     │                 │  │  ├─ FavoriteServiceImpl.java
│  │  │     │                 │  │  ├─ FileServiceImpl.java
│  │  │     │                 │  │  ├─ IdleItemServiceImpl.java
│  │  │     │                 │  │  ├─ MessageServiceImpl.java
│  │  │     │                 │  │  ├─ OrderAddressServiceImpl.java
│  │  │     │                 │  │  ├─ OrderServiceImpl.java
│  │  │     │                 │  │  ├─ UserServiceImpl.java
│  │  │     │                 │  │  └─ UserWXServiceImpl.java
│  │  │     │                 │  ├─ MessageService.java
│  │  │     │                 │  ├─ OrderAddressService.java
│  │  │     │                 │  ├─ OrderService.java
│  │  │     │                 │  ├─ UserService.java
│  │  │     │                 │  └─ UserWXService.java
│  │  │     │                 ├─ utils
│  │  │     │                 │  ├─ IdFactoryUtil.java
│  │  │     │                 │  ├─ JWTUtils.java
│  │  │     │                 │  ├─ OrderTask.java
│  │  │     │                 │  └─ OrderTaskHandler.java
│  │  │     │                 ├─ vo
│  │  │     │                 │  ├─ PageVo.java
│  │  │     │                 │  └─ ResultVo.java
│  │  │     │                 └─ WebMvcConfig.java
│  │  │     └─ resources
│  │  │        ├─ .DS_Store
│  │  │        ├─ application-dev.properties
│  │  │        ├─ application-test.properties
│  │  │        ├─ application.properties
│  │  │        └─ mapper
│  │  │           ├─ AddressDao.xml
│  │  │           ├─ AdminDao.xml
│  │  │           ├─ CreditLogDao.xml
│  │  │           ├─ FavoriteDao.xml
│  │  │           ├─ IdleItemDao.xml
│  │  │           ├─ MessageDao.xml
│  │  │           ├─ OrderAddressDao.xml
│  │  │           ├─ OrderDao.xml
│  │  │           ├─ UserDao.xml
│  │  │           └─ UserWXDao.xml
│  │  └─ target
│  │     ├─ classes
│  │     │  ├─ application-dev.properties
│  │     │  ├─ application-test.properties
│  │     │  ├─ application.properties
│  │     │  ├─ com
│  │     │  │  └─ second
│  │     │  │     └─ hand
│  │     │  │        └─ trading
│  │     │  │           └─ server
│  │     │  │              ├─ controller
│  │     │  │              │  ├─ AddressController.class
│  │     │  │              │  ├─ AdminController.class
│  │     │  │              │  ├─ FavoriteController.class
│  │     │  │              │  ├─ FileController.class
│  │     │  │              │  ├─ IdleItemController.class
│  │     │  │              │  ├─ MessageController.class
│  │     │  │              │  ├─ OrderAddressController.class
│  │     │  │              │  ├─ OrderController.class
│  │     │  │              │  ├─ UserController.class
│  │     │  │              │  ├─ UserWXController.class
│  │     │  │              │  └─ 毕业设计校园交易.code-workspace
│  │     │  │              ├─ dao
│  │     │  │              │  ├─ AddressDao.class
│  │     │  │              │  ├─ AdminDao.class
│  │     │  │              │  ├─ CreditLogDao.class
│  │     │  │              │  ├─ FavoriteDao.class
│  │     │  │              │  ├─ IdleItemDao.class
│  │     │  │              │  ├─ MessageDao.class
│  │     │  │              │  ├─ OrderAddressDao.class
│  │     │  │              │  ├─ OrderDao.class
│  │     │  │              │  ├─ UserDao.class
│  │     │  │              │  └─ UserWXDao.class
│  │     │  │              ├─ enums
│  │     │  │              │  └─ ErrorMsg.class
│  │     │  │              ├─ Exception
│  │     │  │              │  └─ ParamException.class
│  │     │  │              ├─ Handler
│  │     │  │              │  └─ GlobalExceptionHandler.class
│  │     │  │              ├─ LogCostInterceptor.class
│  │     │  │              ├─ mapper
│  │     │  │              ├─ model
│  │     │  │              │  ├─ AddressModel.class
│  │     │  │              │  ├─ AdminModel.class
│  │     │  │              │  ├─ CreditLogModel.class
│  │     │  │              │  ├─ FavoriteModel.class
│  │     │  │              │  ├─ IdleItemModel.class
│  │     │  │              │  ├─ MessageModel.class
│  │     │  │              │  ├─ OrderAddressModel.class
│  │     │  │              │  ├─ OrderModel.class
│  │     │  │              │  └─ UserModel.class
│  │     │  │              ├─ ServerApplication.class
│  │     │  │              ├─ service
│  │     │  │              │  ├─ AddressService.class
│  │     │  │              │  ├─ AdminService.class
│  │     │  │              │  ├─ FavoriteService.class
│  │     │  │              │  ├─ FileService.class
│  │     │  │              │  ├─ IdleItemService.class
│  │     │  │              │  ├─ impl
│  │     │  │              │  │  ├─ AddressServiceImpl.class
│  │     │  │              │  │  ├─ AdminServiceImpl.class
│  │     │  │              │  │  ├─ FavoriteServiceImpl.class
│  │     │  │              │  │  ├─ FileServiceImpl.class
│  │     │  │              │  │  ├─ IdleItemServiceImpl.class
│  │     │  │              │  │  ├─ MessageServiceImpl.class
│  │     │  │              │  │  ├─ OrderAddressServiceImpl.class
│  │     │  │              │  │  ├─ OrderServiceImpl.class
│  │     │  │              │  │  ├─ UserServiceImpl.class
│  │     │  │              │  │  └─ UserWXServiceImpl.class
│  │     │  │              │  ├─ MessageService.class
│  │     │  │              │  ├─ OrderAddressService.class
│  │     │  │              │  ├─ OrderService.class
│  │     │  │              │  ├─ UserService.class
│  │     │  │              │  └─ UserWXService.class
│  │     │  │              ├─ utils
│  │     │  │              │  ├─ IdFactoryUtil.class
│  │     │  │              │  ├─ JWTUtils.class
│  │     │  │              │  ├─ OrderTask.class
│  │     │  │              │  └─ OrderTaskHandler.class
│  │     │  │              ├─ vo
│  │     │  │              │  ├─ PageVo.class
│  │     │  │              │  └─ ResultVo.class
│  │     │  │              └─ WebMvcConfig.class
│  │     │  └─ mapper
│  │     │     ├─ AddressDao.xml
│  │     │     ├─ AdminDao.xml
│  │     │     ├─ CreditLogDao.xml
│  │     │     ├─ FavoriteDao.xml
│  │     │     ├─ IdleItemDao.xml
│  │     │     ├─ MessageDao.xml
│  │     │     ├─ OrderAddressDao.xml
│  │     │     ├─ OrderDao.xml
│  │     │     ├─ UserDao.xml
│  │     │     └─ UserWXDao.xml
│  │     ├─ generated-sources
│  │     │  └─ annotations
│  │     ├─ generated-test-sources
│  │     │  └─ test-annotations
│  │     └─ test-classes
│  ├─ second-hand-goods-trading-front
│  │  ├─ .browserslistrc
│  │  ├─ .env.development
│  │  ├─ .env.production
│  │  ├─ .prettierrc
│  │  ├─ babel.config.js
│  │  ├─ image
│  │  │  └─ bg2.jpg
│  │  ├─ package-lock.json
│  │  ├─ package.json
│  │  ├─ postcss.config.js
│  │  ├─ public
│  │  │  └─ index.html
│  │  ├─ src
│  │  │  ├─ api
│  │  │  │  └─ index.js
│  │  │  ├─ App.vue
│  │  │  ├─ components
│  │  │  │  ├─ common
│  │  │  │  │  ├─ AppFoot.vue
│  │  │  │  │  ├─ AppHeader.vue
│  │  │  │  │  ├─ AppPageBody.vue
│  │  │  │  │  ├─ bus.js
│  │  │  │  │  ├─ country-data.js
│  │  │  │  │  ├─ IdleGoods.vue
│  │  │  │  │  ├─ orderList.vue
│  │  │  │  │  └─ userList.vue
│  │  │  │  └─ page
│  │  │  │     ├─ idle-details.vue
│  │  │  │     ├─ index.vue
│  │  │  │     ├─ login-admin.vue
│  │  │  │     ├─ login.vue
│  │  │  │     ├─ me.vue
│  │  │  │     ├─ message.vue
│  │  │  │     ├─ order.vue
│  │  │  │     ├─ platform-admin.vue
│  │  │  │     ├─ release.vue
│  │  │  │     ├─ search.vue
│  │  │  │     └─ sign-in.vue
│  │  │  ├─ main.js
│  │  │  ├─ router
│  │  │  │  └─ index.js
│  │  │  └─ utils
│  │  │     └─ request.js
│  │  └─ vue.config.js
│  └─ settings.xml
└─ second-hand-goods-trading-wx-main
   ├─ .DS_Store
   ├─ cloudfunctions
   │  ├─ .DS_Store
   │  ├─ his
   │  │  ├─ index.js
   │  │  ├─ package-lock.json
   │  │  └─ package.json
   │  ├─ imgSecCheck
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  ├─ login
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  ├─ package-lock.json
   │  │  └─ package.json
   │  ├─ node
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  ├─ pay
   │  │  ├─ index.js
   │  │  ├─ package-lock.json
   │  │  └─ package.json
   │  ├─ poking
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  ├─ ref
   │  │  ├─ index.js
   │  │  ├─ package-lock.json
   │  │  └─ package.json
   │  ├─ regist
   │  │  ├─ .DS_Store
   │  │  ├─ cryptojs
   │  │  │  ├─ cryptojs.js
   │  │  │  ├─ lib
   │  │  │  │  ├─ AES.js
   │  │  │  │  ├─ BlockModes.js
   │  │  │  │  ├─ Crypto.js
   │  │  │  │  ├─ CryptoMath.js
   │  │  │  │  ├─ DES.js
   │  │  │  │  ├─ HMAC.js
   │  │  │  │  ├─ MARC4.js
   │  │  │  │  ├─ MD5.js
   │  │  │  │  ├─ PBKDF2.js
   │  │  │  │  ├─ PBKDF2Async.js
   │  │  │  │  ├─ Rabbit.js
   │  │  │  │  ├─ SHA1.js
   │  │  │  │  └─ SHA256.js
   │  │  │  ├─ package.json
   │  │  │  └─ test
   │  │  │     └─ PBKDF2-test.js
   │  │  ├─ index.js
   │  │  ├─ package-lock.json
   │  │  ├─ package.json
   │  │  └─ RdWXBizDataCrypt.js
   │  ├─ removeChat
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  ├─ removeOrder
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  ├─ sell
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  ├─ sendMsg
   │  │  ├─ config.json
   │  │  ├─ index.js
   │  │  └─ package.json
   │  └─ sendTip
   │     ├─ config.json
   │     ├─ index.js
   │     └─ package.json
   ├─ miniprogram
   │  ├─ .DS_Store
   │  ├─ app.js
   │  ├─ app.json
   │  ├─ app.wxss
   │  ├─ common.wxml
   │  ├─ common.wxs
   │  ├─ components
   │  │  ├─ .DS_Store
   │  │  ├─ add_tips
   │  │  │  ├─ assets
   │  │  │  │  ├─ fav-1.jpg
   │  │  │  │  ├─ fav-2.jpg
   │  │  │  │  └─ fav-3.jpg
   │  │  │  ├─ index.js
   │  │  │  ├─ index.json
   │  │  │  ├─ index.wxml
   │  │  │  ├─ index.wxss
   │  │  │  └─ README.md
   │  │  ├─ canvasdrawer
   │  │  │  ├─ canvasdrawer.js
   │  │  │  ├─ canvasdrawer.json
   │  │  │  ├─ canvasdrawer.wxml
   │  │  │  └─ canvasdrawer.wxss
   │  │  ├─ chatroom
   │  │  │  ├─ chatroom.js
   │  │  │  ├─ chatroom.json
   │  │  │  ├─ chatroom.wxml
   │  │  │  ├─ chatroom.wxss
   │  │  │  ├─ dots.gif
   │  │  │  └─ photo.png
   │  │  └─ welcome
   │  │     ├─ assets
   │  │     │  ├─ about.jpg
   │  │     │  ├─ about_2.jpg
   │  │     │  └─ ad_1.jpg
   │  │     ├─ welcome.js
   │  │     ├─ welcome.json
   │  │     ├─ welcome.wxml
   │  │     └─ welcome.wxss
   │  ├─ config.js
   │  ├─ images
   │  │  ├─ .DS_Store
   │  │  ├─ about.png
   │  │  ├─ add.png
   │  │  ├─ appreciate.png
   │  │  ├─ avator.png
   │  │  ├─ blank.png
   │  │  ├─ boy.png
   │  │  ├─ buy.png
   │  │  ├─ card.png
   │  │  ├─ chat.png
   │  │  ├─ collect.png
   │  │  ├─ del.png
   │  │  ├─ editAddress.png
   │  │  ├─ feedback.png
   │  │  ├─ girl.png
   │  │  ├─ go.png
   │  │  ├─ good.png
   │  │  ├─ guanyu.png
   │  │  ├─ gzh.png
   │  │  ├─ help.png
   │  │  ├─ his.png
   │  │  ├─ history.png
   │  │  ├─ home.png
   │  │  ├─ illustrate.png
   │  │  ├─ kefu.jpg
   │  │  ├─ kefu.png
   │  │  ├─ lianxi.png
   │  │  ├─ list.png
   │  │  ├─ local.png
   │  │  ├─ logout.png
   │  │  ├─ l_down.png
   │  │  ├─ l_right.png
   │  │  ├─ more.gif
   │  │  ├─ myhelp.png
   │  │  ├─ next.png
   │  │  ├─ none.png
   │  │  ├─ off.png
   │  │  ├─ on.png
   │  │  ├─ online.png
   │  │  ├─ onsell.png
   │  │  ├─ order.png
   │  │  ├─ parse.png
   │  │  ├─ phone.png
   │  │  ├─ poster.jpg
   │  │  ├─ publish.png
   │  │  ├─ qq.png
   │  │  ├─ recommend.png
   │  │  ├─ result.png
   │  │  ├─ right.png
   │  │  ├─ sale.png
   │  │  ├─ scan.png
   │  │  ├─ search.png
   │  │  ├─ share.png
   │  │  ├─ shelf.png
   │  │  ├─ shelf_2.png
   │  │  ├─ suc.png
   │  │  ├─ success.png
   │  │  ├─ tabbar
   │  │  │  ├─ home.png
   │  │  │  ├─ home_on.png
   │  │  │  ├─ my.png
   │  │  │  ├─ my_on.png
   │  │  │  ├─ publish.png
   │  │  │  └─ publish_on.png
   │  │  ├─ tip.png
   │  │  ├─ top.png
   │  │  ├─ weixin.png
   │  │  └─ weixin_2.png
   │  ├─ pages
   │  │  ├─ .DS_Store
   │  │  ├─ about
   │  │  │  ├─ about.js
   │  │  │  ├─ about.json
   │  │  │  ├─ about.wxml
   │  │  │  ├─ about.wxss
   │  │  │  ├─ chen.jpg
   │  │  │  └─ tao.jpg
   │  │  ├─ address
   │  │  │  ├─ address.js
   │  │  │  ├─ address.json
   │  │  │  ├─ address.wxml
   │  │  │  └─ address.wxss
   │  │  ├─ addressList
   │  │  │  ├─ addressList.js
   │  │  │  ├─ addressList.json
   │  │  │  ├─ addressList.wxml
   │  │  │  └─ addressList.wxss
   │  │  ├─ appreciateCode
   │  │  │  ├─ appreciateCode.js
   │  │  │  ├─ appreciateCode.json
   │  │  │  ├─ appreciateCode.wxml
   │  │  │  └─ appreciateCode.wxss
   │  │  ├─ collect
   │  │  │  ├─ collect.js
   │  │  │  ├─ collect.json
   │  │  │  ├─ collect.wxml
   │  │  │  └─ collect.wxss
   │  │  ├─ detail
   │  │  │  ├─ detail.js
   │  │  │  ├─ detail.json
   │  │  │  ├─ detail.wxml
   │  │  │  ├─ detail.wxss
   │  │  │  └─ room
   │  │  │     ├─ room.js
   │  │  │     ├─ room.json
   │  │  │     ├─ room.wxml
   │  │  │     └─ room.wxss
   │  │  ├─ edit
   │  │  │  ├─ edit.js
   │  │  │  ├─ edit.json
   │  │  │  ├─ edit.wxml
   │  │  │  └─ edit.wxss
   │  │  ├─ help
   │  │  │  ├─ help.js
   │  │  │  ├─ help.json
   │  │  │  ├─ help.wxml
   │  │  │  └─ help.wxss
   │  │  ├─ index
   │  │  │  ├─ index.js
   │  │  │  ├─ index.json
   │  │  │  ├─ index.wxml
   │  │  │  └─ index.wxss
   │  │  ├─ kefu
   │  │  │  ├─ kefu.js
   │  │  │  ├─ kefu.json
   │  │  │  ├─ kefu.wxml
   │  │  │  └─ kefu.wxss
   │  │  ├─ login
   │  │  │  ├─ login.js
   │  │  │  ├─ login.json
   │  │  │  ├─ login.wxml
   │  │  │  ├─ login.wxss
   │  │  │  └─ quickLogin
   │  │  │     ├─ quickLogin.js
   │  │  │     ├─ quickLogin.json
   │  │  │     ├─ quickLogin.wxml
   │  │  │     └─ quickLogin.wxss
   │  │  ├─ message
   │  │  │  ├─ message.js
   │  │  │  ├─ message.json
   │  │  │  ├─ message.wxml
   │  │  │  └─ message.wxss
   │  │  ├─ my
   │  │  │  ├─ my.js
   │  │  │  ├─ my.json
   │  │  │  ├─ my.wxml
   │  │  │  └─ my.wxss
   │  │  ├─ my_publish
   │  │  │  ├─ my_publish.js
   │  │  │  ├─ my_publish.wxml
   │  │  │  └─ my_publish.wxss
   │  │  ├─ order
   │  │  │  ├─ detail
   │  │  │  │  ├─ detail.js
   │  │  │  │  ├─ detail.json
   │  │  │  │  ├─ detail.wxml
   │  │  │  │  └─ detail.wxss
   │  │  │  └─ list
   │  │  │     ├─ list.js
   │  │  │     ├─ list.json
   │  │  │     ├─ list.wxml
   │  │  │     └─ list.wxss
   │  │  ├─ publish
   │  │  │  ├─ publish.js
   │  │  │  ├─ publish.json
   │  │  │  ├─ publish.wxml
   │  │  │  └─ publish.wxss
   │  │  ├─ register
   │  │  │  ├─ register.js
   │  │  │  ├─ register.json
   │  │  │  ├─ register.wxml
   │  │  │  └─ register.wxss
   │  │  ├─ sale
   │  │  │  ├─ detail
   │  │  │  │  ├─ detail.js
   │  │  │  │  ├─ detail.json
   │  │  │  │  ├─ detail.wxml
   │  │  │  │  └─ detail.wxss
   │  │  │  ├─ sale.js
   │  │  │  ├─ sale.json
   │  │  │  ├─ sale.wxml
   │  │  │  └─ sale.wxss
   │  │  ├─ search
   │  │  │  ├─ search.js
   │  │  │  ├─ search.json
   │  │  │  ├─ search.wxml
   │  │  │  └─ search.wxss
   │  │  ├─ sell
   │  │  │  └─ list
   │  │  │     ├─ list.js
   │  │  │     ├─ list.json
   │  │  │     ├─ list.wxml
   │  │  │     └─ list.wxss
   │  │  ├─ shelf
   │  │  │  ├─ shelf.js
   │  │  │  ├─ shelf.json
   │  │  │  ├─ shelf.wxml
   │  │  │  └─ shelf.wxss
   │  │  ├─ start
   │  │  │  ├─ start.js
   │  │  │  ├─ start.json
   │  │  │  ├─ start.wxml
   │  │  │  └─ start.wxss
   │  │  ├─ use
   │  │  │  ├─ use.js
   │  │  │  ├─ use.json
   │  │  │  ├─ use.wxml
   │  │  │  └─ use.wxss
   │  │  └─ web
   │  │     ├─ web.js
   │  │     ├─ web.json
   │  │     ├─ web.wxml
   │  │     └─ web.wxss
   │  ├─ sitemap.json
   │  ├─ utils
   │  │  ├─ area.js
   │  │  ├─ request.js
   │  │  ├─ uploadFile.js
   │  │  ├─ util.js
   │  │  └─ weui.wxss
   │  └─ vant
   │     ├─ .DS_Store
   │     ├─ action-sheet
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ area
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ button
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ calendar
   │     │  ├─ calendar.wxml
   │     │  ├─ components
   │     │  │  ├─ header
   │     │  │  │  ├─ index.d.ts
   │     │  │  │  ├─ index.js
   │     │  │  │  ├─ index.json
   │     │  │  │  ├─ index.wxml
   │     │  │  │  └─ index.wxss
   │     │  │  └─ month
   │     │  │     ├─ index.d.ts
   │     │  │     ├─ index.js
   │     │  │     ├─ index.json
   │     │  │     ├─ index.wxml
   │     │  │     ├─ index.wxs
   │     │  │     └─ index.wxss
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  ├─ index.wxss
   │     │  ├─ utils.d.ts
   │     │  ├─ utils.js
   │     │  └─ utils.wxs
   │     ├─ card
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ cell
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ cell-group
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ checkbox
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ checkbox-group
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ circle
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ col
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ collapse
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ collapse-item
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ common
   │     │  ├─ color.d.ts
   │     │  ├─ color.js
   │     │  ├─ component.d.ts
   │     │  ├─ component.js
   │     │  ├─ index.wxss
   │     │  ├─ style
   │     │  │  ├─ clearfix.wxss
   │     │  │  ├─ ellipsis.wxss
   │     │  │  ├─ hairline.wxss
   │     │  │  ├─ mixins
   │     │  │  │  ├─ clearfix.wxss
   │     │  │  │  ├─ ellipsis.wxss
   │     │  │  │  └─ hairline.wxss
   │     │  │  ├─ theme.wxss
   │     │  │  └─ var.wxss
   │     │  ├─ utils.d.ts
   │     │  ├─ utils.js
   │     │  ├─ version.d.ts
   │     │  └─ version.js
   │     ├─ count-down
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxss
   │     │  ├─ utils.d.ts
   │     │  └─ utils.js
   │     ├─ datetime-picker
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ definitions
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ weapp.d.ts
   │     │  └─ weapp.js
   │     ├─ dialog
   │     │  ├─ dialog.d.ts
   │     │  ├─ dialog.js
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ divider
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ dropdown-item
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ dropdown-menu
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ field
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  ├─ index.wxss
   │     │  ├─ props.d.ts
   │     │  └─ props.js
   │     ├─ goods-action
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ goods-action-button
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ goods-action-icon
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ grid
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ grid-item
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ icon
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ image
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ index-anchor
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ index-bar
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ info
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ loading
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ mixins
   │     │  ├─ basic.d.ts
   │     │  ├─ basic.js
   │     │  ├─ button.d.ts
   │     │  ├─ button.js
   │     │  ├─ link.d.ts
   │     │  ├─ link.js
   │     │  ├─ open-type.d.ts
   │     │  ├─ open-type.js
   │     │  ├─ page-scroll.d.ts
   │     │  ├─ page-scroll.js
   │     │  ├─ touch.d.ts
   │     │  ├─ touch.js
   │     │  ├─ transition.d.ts
   │     │  └─ transition.js
   │     ├─ nav-bar
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ notice-bar
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ notify
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxss
   │     │  ├─ notify.d.ts
   │     │  └─ notify.js
   │     ├─ overlay
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ panel
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ picker
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxss
   │     │  ├─ shared.d.ts
   │     │  ├─ shared.js
   │     │  └─ toolbar.wxml
   │     ├─ picker-column
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ popup
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ progress
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ radio
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ radio-group
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ rate
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ row
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ search
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ sidebar
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ sidebar-item
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ skeleton
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ slider
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ stepper
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ steps
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ sticky
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ submit-bar
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ swipe-cell
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ switch
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ tab
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ tabbar
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ tabbar-item
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ tabs
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ tag
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ toast
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxss
   │     │  ├─ toast.d.ts
   │     │  └─ toast.js
   │     ├─ transition
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  └─ index.wxss
   │     ├─ tree-select
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxs
   │     │  └─ index.wxss
   │     ├─ uploader
   │     │  ├─ index.d.ts
   │     │  ├─ index.js
   │     │  ├─ index.json
   │     │  ├─ index.wxml
   │     │  ├─ index.wxss
   │     │  ├─ shared.d.ts
   │     │  ├─ shared.js
   │     │  ├─ utils.d.ts
   │     │  └─ utils.js
   │     └─ wxs
   │        ├─ add-unit.wxs
   │        ├─ array.wxs
   │        ├─ bem.wxs
   │        ├─ memoize.wxs
   │        ├─ object.wxs
   │        └─ utils.wxs
   ├─ package-lock.json
   ├─ project.config.json
   ├─ project.private.config.json
   ├─ README.assets
   │  ├─ image-20200920215844159.png
   │  ├─ image-20200920220005803.png
   │  ├─ image-20200920220841085.png
   │  ├─ image-20200920220948222.png
   │  ├─ image-20200920221442425.png
   │  ├─ image-20200920221729375.png
   │  ├─ image-20200920221738182.png
   │  ├─ image-20200920221751633.png
   │  ├─ image-20200920221852958.png
   │  ├─ image-20200920221938299.png
   │  ├─ image-20200920222108667.png
   │  ├─ image-20200920222151402.png
   │  ├─ image-20200920222300547.png
   │  ├─ image-20200920222352110.png
   │  ├─ image-20200920222529192.png
   │  ├─ image-20200920222737231.png
   │  ├─ image-20200920222748670.png
   │  ├─ image-20200920222804302.png
   │  ├─ image-20200920222934149.png
   │  ├─ image-20200920223013113.png
   │  ├─ image-20200920223554236.png
   │  ├─ image-20200920223633305.png
   │  ├─ image-20200920223729148.png
   │  ├─ image-20200920223930768.png
   │  ├─ image-20200920224111392.png
   │  ├─ image-20200920224159506.png
   │  ├─ image-20200920224235782.png
   │  ├─ image-20200920224525938.png
   │  ├─ one day.jpg
   │  └─ RhiHTSOsG6aLK2D.png
   └─ README.md

```