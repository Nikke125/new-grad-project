const app = getApp();
Page({
  data: {
    tabs: [
      { name: '全部', status: '' },
      { name: '在售', status: '1' },
      { name: '已下架', status: '2' },
      { name: '已卖出', status: '3' }
    ],
    activeTab: 0,
    list: [],
    loading: false
  },

  onLoad: function() {
    this.getList();
  },

  // 切换Tab
  onTabChange(e) {
    let index = e.currentTarget.dataset.index;
    this.setData({
      activeTab: index,
      list: [] // 切换时清空列表
    });
    this.getList();
  },

  // 获取数据逻辑（根据实际后端接口调整）
  getList() {
    const status = this.data.tabs[this.data.activeTab].status;
    this.setData({ loading: true });
    
    // 模拟请求，实际请替换为 app.request 或 wx.cloud.callFunction
    // 示例逻辑：根据 status 过滤
    console.log('正在请求状态为', status, '的商品列表');
    
    // 这里应调用后端接口，例如：
    // wx.request({
    //   url: app.globalData.baseUrl + '/product/myList',
    //   data: { status: status },
    //   success: (res) => { this.setData({ list: res.data }) }
    // })
  },

  // 下架操作
  handleOffShelf(e) {
    const id = e.currentTarget.dataset.id;
    wx.showModal({
      title: '提示',
      content: '确定要下架该商品吗？',
      success: (res) => {
        if (res.confirm) {
          console.log('下架商品ID:', id);
          // 调用接口后刷新列表
        }
      }
    });
  },

  // 编辑操作
  handleEdit(e) {
    const id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: `/pages/publish/publish?id=${id}&mode=edit`
    });
  },

  // 重新上架
  handleOnShelf(e) {
    const id = e.currentTarget.dataset.id;
    console.log('重新上架商品ID:', id);
    // 调用接口后刷新列表
  }
});
