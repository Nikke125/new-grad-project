<template>
    <div class="admin-wrapper">
        <el-container>
            <el-header>
                <div class="header">
                    <div class="app-logo">
                        <i class="el-icon-shopping-bag-2"></i>
                        <router-link to="/platform-admin">校园二手</router-link>
                    </div>
                    <div class="app-title">后台管理系统</div>
                    <div class="app-actions">
                        <span class="admin-name"><i class="el-icon-user"></i> {{admin.nickname}}</span>
                        <el-button type="primary" size="small" round @click="logout">
                            <i class="el-icon-switch-button"></i> 退出登录
                        </el-button>
                    </div>
                </div>
            </el-header>
            <el-container class="main-container">
                <el-aside class="sidebar">
                    <el-col :span="24">
                        <el-menu
                                :default-active="String(mode)"
                                class="sidebar-menu"
                                @select="handleSelect"
                                background-color="#FFFFFF"
                                text-color="#606266"
                                active-text-color="#2EB872"
                                :unique-opened="true"
                                :router="false">
                            <el-menu-item index="1">
                                <i class="el-icon-goods"></i>
                                <span>商品管理</span>
                            </el-menu-item>
                            <el-menu-item index="2">
                                <i class="el-icon-tickets"></i>
                                <span>订单管理</span>
                            </el-menu-item>
                            <el-menu-item index="3">
                                <i class="el-icon-user"></i>
                                <span>用户管理</span>
                            </el-menu-item>
                            <el-menu-item index="4">
                                <i class="el-icon-data-analysis"></i>
                                <span>数据统计</span>
                            </el-menu-item>
                        </el-menu>
                    </el-col>
                </el-aside>
                <el-main class="main-content">
                    <IdleGoods v-if="mode == 1"></IdleGoods>
                    <orderList v-if="mode == 2"></orderList>
                    <userList v-if="mode == 3"></userList>
                    <Dashboard v-if="mode == 4"></Dashboard>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    import AppFoot from '../common/AppFoot.vue'
    import IdleGoods from '../common/IdleGoods.vue'
    import orderList from '../common/orderList.vue'
    import userList from '../common/userList.vue'
    import Dashboard from '../Dashboard.vue'
    export default {
        name: "platform-admin",
        components: {
            AppFoot,
            IdleGoods,
            orderList,
            userList,
            Dashboard
        },
        data(){
            return {
                mode:1,
                admin:{
                    nickname:'管理员',
                },
            }
        },
        created() {
            this.admin.nickname=this.$sta.adminName || '管理员';
        },
        methods: {
            logout(){
                this.$api.loginOut({
                }).then(res => {
                    if(res.status_code === 1){
                        this.$sta.isLogin=false;
                        this.$sta.adminName='';
                        this.$router.push({path:'/login-admin'});
                    }
                }).catch(e => {
                    console.log(e)
                })
            },
            handleSelect(val){
                if(this.mode !== parseInt(val)){
                    this.mode = parseInt(val);
                }
            },
        },
    }
</script>

<style scoped>
.admin-wrapper {
    min-height: 100vh;
    background-color: #F5F7FA;
}

.header {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    height: 64px;
    background: #FFFFFF;
    display: flex;
    justify-content: space-between;
    align-items: center;
    box-shadow: 0 2px 16px rgba(0, 0, 0, 0.06);
    z-index: 1000;
    padding: 0 24px;
}

.app-logo {
    display: flex;
    align-items: center;
    gap: 8px;
    min-width: 180px;
}

.app-logo i {
    font-size: 28px;
    color: #2EB872;
}

.app-logo a {
    color: #303133;
    font-size: 20px;
    font-weight: 700;
    text-decoration: none;
    letter-spacing: 1px;
}

.app-title {
    flex: 1;
    text-align: center;
    font-size: 16px;
    color: #909399;
    font-weight: 500;
}

.app-actions {
    display: flex;
    align-items: center;
    gap: 16px;
    min-width: 200px;
    justify-content: flex-end;
}

.admin-name {
    color: #606266;
    font-size: 14px;
    display: flex;
    align-items: center;
    gap: 6px;
}

.main-container {
    margin-top: 64px;
    min-height: calc(100vh - 64px - 60px);
}

.sidebar {
    width: 220px !important;
    min-height: calc(100vh - 64px);
    background-color: #FFFFFF;
    box-shadow: 2px 0 12px rgba(0, 0, 0, 0.04);
    padding: 16px 0;
}

.sidebar-menu {
    background-color: transparent !important;
}

.sidebar-menu >>> .el-menu-item {
    height: 50px;
    line-height: 50px;
    margin: 6px 12px;
    border-radius: 10px;
    font-size: 15px;
}

.sidebar-menu >>> .el-menu-item i {
    font-size: 18px;
    margin-right: 10px;
}

.sidebar-menu >>> .el-menu-item:hover {
    background-color: #F0F9F4 !important;
}

.sidebar-menu >>> .el-menu-item.is-active {
    background-color: #E8F7EE !important;
    font-weight: 600;
}

.main-content {
    padding: 20px 24px;
    background-color: #F5F7FA;
    min-height: calc(100vh - 64px - 60px);
}
</style>