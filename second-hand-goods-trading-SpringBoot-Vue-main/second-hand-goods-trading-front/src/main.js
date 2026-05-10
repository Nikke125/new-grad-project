import Vue from 'vue';
import App from './App.vue';
import router from './router';
import ElementUI from 'element-ui';
import $ from 'jquery'
import 'element-ui/lib/theme-chalk/index.css';
import 'babel-polyfill';

import api from './api/index.js';
Vue.prototype.$api = api;

let globalData={
    userInfo:{
        nickname:''
    }
};
let sta={
    isLogin:false,
    adminName:''
};
Vue.prototype.$sta = sta;

Vue.prototype.$globalData=globalData;

Vue.config.productionTip = false;

Vue.use(ElementUI, {
    size: 'medium'
});

// ===========================================
// Element UI 主题色覆盖 - 薄荷绿/青绿色主题
// ===========================================
const MintGreenTheme = {
    '--color-primary': '#2EB872',        // 薄荷绿主色
    '--color-success': '#2EB872',         // 成功色
    '--color-warning': '#FFB800',         // 警示色（低饱和度黄）
    '--color-danger': '#FF6B6B',          // 危险色（柔和红）
    '--color-info': '#909399',            // 信息灰
    '--color-text-primary': '#303133',     // 主要文字
    '--color-text-regular': '#606266',     // 常规文字
    '--color-text-secondary': '#909399',   // 次要文字
    '--color-text-placeholder': '#C0C4CC', // 占位符文字
    '--border-color-base': '#DCDFE6',     // 基础边框
    '--border-color-light': '#E4E7ED',     // 浅色边框
    '--border-color-lighter': '#EBEEF5',  // 更浅边框
    '--border-color-extra-light': '#F2F6FC', // 极浅边框
    '--background-color-base': '#F5F7FA', // 基础背景
    '--box-shadow-base': '0 8px 32px rgba(0, 0, 0, 0.08)', // 弥散阴影基础
    '--box-shadow-light': '0 4px 16px rgba(0, 0, 0, 0.06)', // 轻阴影
    '--border-radius-base': '12px',       // 大圆角
    '--border-radius-small': '8px',       // 小圆角
    '--border-radius-mini': '4px'          // 迷你圆角
};

// 动态创建style标签注入全局CSS变量
const styleEl = document.createElement('style');
styleEl.innerHTML = `
:root {
    --mint-primary: #2EB872;
    --mint-success: #2EB872;
    --mint-warning: #FFB800;
    --mint-danger: #FF6B6B;
    --mint-info: #909399;
    --mint-bg: #F0F9F4;
    --mint-sidebar-bg: #FFFFFF;
    --mint-sidebar-active-bg: #E8F7EE;
    --mint-text: #303133;
    --mint-text-light: #606266;
    --mint-border: #E4E7ED;
    --mint-shadow: 0 8px 32px rgba(46, 184, 114, 0.12);
    --mint-shadow-light: 0 4px 16px rgba(46, 184, 114, 0.08);
    --mint-radius: 12px;
    --mint-radius-sm: 8px;
}

/* Element UI 主色调覆盖 */
.el-button--primary {
    background-color: var(--mint-primary) !important;
    border-color: var(--mint-primary) !important;
}
.el-button--primary:hover,
.el-button--primary:focus {
    background-color: #27a863 !important;
    border-color: #27a863 !important;
}
.el-button--primary:active {
    background-color: #249560 !important;
    border-color: #249560 !important;
}

/* 成功按钮 - 薄荷绿 */
.el-button--success {
    background-color: var(--mint-success) !important;
    border-color: var(--mint-success) !important;
}

/* 危险按钮 - 柔和红 */
.el-button--danger {
    background-color: #FF6B6B !important;
    border-color: #FF6B6B !important;
    color: #fff !important;
}
.el-button--danger:hover,
.el-button--danger:focus {
    background-color: #ff8585 !important;
    border-color: #ff8585 !important;
}

/* 警告按钮 - 低饱和黄 */
.el-button--warning {
    background-color: #FFB800 !important;
    border-color: #FFB800 !important;
}

/* 默认按钮圆角 */
.el-button {
    border-radius: var(--mint-radius-sm) !important;
}

/* 卡片圆角和阴影 */
.el-card {
    border-radius: var(--mint-radius) !important;
    border: none !important;
    box-shadow: var(--mint-shadow-light) !important;
}
.el-card:hover {
    box-shadow: var(--mint-shadow) !important;
}
.el-card__header {
    border-bottom: 1px solid var(--mint-border) !important;
    border-radius: var(--mint-radius) var(--mint-radius) 0 0 !important;
}

/* 表格样式 */
.el-table {
    border-radius: var(--mint-radius) !important;
    overflow: hidden;
}
.el-table th {
    background-color: var(--mint-bg) !important;
    color: var(--mint-text) !important;
    font-weight: 600 !important;
}
.el-table tr {
    transition: background-color 0.3s ease;
}
.el-table tr:hover > td {
    background-color: var(--mint-bg) !important;
}

/* 菜单样式 - 侧边栏 */
.el-menu {
    border-right: none !important;
}
.el-menu-item {
    border-radius: var(--mint-radius-sm) !important;
    margin: 4px 8px !important;
    transition: all 0.3s ease !important;
}
.el-menu-item:hover {
    background-color: var(--mint-bg) !important;
}
.el-menu-item.is-active {
    background-color: var(--mint-sidebar-active-bg) !important;
    color: var(--mint-primary) !important;
}
.el-menu-item.is-active::before {
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    width: 4px;
    background-color: var(--mint-primary);
    border-radius: 0 4px 4px 0;
}

/* 输入框圆角 */
.el-input__inner {
    border-radius: var(--mint-radius-sm) !important;
}

/* 分页组件 */
.el-pagination {
    border-radius: var(--mint-radius) !important;
}

/* 标签页 */
.el-tabs__item {
    border-radius: var(--mint-radius-sm) !important;
}
.el-tabs__item.is-active {
    color: var(--mint-primary) !important;
}
.el-tabs__active-bar {
    background-color: var(--mint-primary) !important;
}

/* 弹出框 */
.el-dialog {
    border-radius: var(--mint-radius) !important;
}
.el-dialog__header {
    border-bottom: 1px solid var(--mint-border);
}

/* 消息提示 */
.el-message {
    border-radius: var(--mint-radius-sm) !important;
}

/* 下拉菜单 */
.el-dropdown-menu {
    border-radius: var(--mint-radius-sm) !important;
}
`;
document.head.appendChild(styleEl);


router.beforeEach((to, from, next) => {
    document.title = `${to.meta.title}`;
    // console.log(to.path,'userInfo:',Vue.prototype.$globalData.userInfo);
    const nickname = Vue.prototype.$globalData.userInfo.nickname;
    if (!nickname
        &&(to.path === '/me'
        || to.path === '/message'
        || to.path === '/release'
        || to.path === '/order')) {
        api.getUserInfo().then(res=>{
           console.log('getUserInfo:',res);
           if(res.status_code!==1){
               next('/login');
           }else {
               res.data.signInTime=res.data.signInTime.substring(0,10);
               Vue.prototype.$globalData.userInfo=res.data;
               next();
           }
        }).catch(e=>{
            next('/login');
        });

    }else{
        next();
    }
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');
