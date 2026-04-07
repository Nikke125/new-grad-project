const app = getApp();

Page({
  data: {
    userId: null,
    currentScore: 0,
    logList: [],
    isEmpty: false
  },

  // onLoad: function() {
  //   const userInfo = wx.getStorageSync('userinfo');
  //   if (userInfo && userInfo.id) {
  //     this.setData({
  //       userId: userInfo.id,
  //       currentScore: userInfo.score || 0
  //     });
  //     this.getCreditLogList(userInfo.id);
  //   } else {
  //     wx.showToast({
  //       title: '请先登录',
  //       icon: 'none'
  //     });
  //     // Optionally redirect to login page
  //   }
  // },
  onLoad: function (options) {
    // 1. 直接从上一个页面传过来的包裹(options)里拿数据！这招绝对百发百中！
    let passedUid = options.uid;
    let passedScore = options.score;

    // 2. 如果没拿到 uid，或者是字符串的 'undefined'，说明真没登录
    if (!passedUid || passedUid === 'undefined') {
      wx.showToast({
        title: '未能获取身份信息',
        icon: 'none'
      });
      this.setData({ currentScore: 100, isEmpty: true });
      return;
    }

    // 3. 处理分数：如果没传过来分数，默认给 100
    let finalScore = 100;
    if (passedScore && passedScore !== 'undefined' && passedScore !== 'null') {
      finalScore = parseInt(passedScore);
    }

    // 4. 把确定的分数挂载到页面上
    this.setData({
      currentScore: finalScore
    });

    // 5. 拿着百分百准确的 uid，去后端查流水！
    this.getCreditLogList(passedUid);
  },

  // getCreditLogList: function(userId) {
  //   wx.showLoading({
  //     title: '加载中',
  //   });
  //   wx.request({
  //     url: app.globalData.baseUrl + '/credit/log/list', // Replace with your actual base URL
  //     method: 'GET',
  //     data: {
  //       userId: userId
  //     },
  //     success: (res) => {
  //       if (res.statusCode === 200 && res.data.code === 0) {
  //         const logList = res.data.data.map(item => ({
  //           ...item,
  //           createTimeFormatted: this.formatDate(new Date(item.createTime)),
  //           changeScoreDisplay: item.changeType === 1 ? `+${item.changeScore}` : `-${item.changeScore}`,
  //           changeScoreColor: item.changeType === 1 ? '#4CAF50' : '#F44336'
  //         }));
  //         this.setData({
  //           logList: logList,
  //           isEmpty: logList.length === 0
  //         });
  //       } else {
  //         wx.showToast({
  //           title: res.data.msg || '获取数据失败',
  //           icon: 'none'
  //         });
  //         this.setData({
  //           isEmpty: true
  //         });
  //       }
  //     },
  //     fail: (err) => {
  //       console.error('Request failed', err);
  //       wx.showToast({
  //         title: '网络请求失败',
  //         icon: 'none'
  //       });
  //       this.setData({
  //         isEmpty: true
  //       });
  //     },
  //     complete: () => {
  //       wx.hideLoading();
  //     }
  //   });
  // },

  getCreditLogList: function(userId) {
    wx.showLoading({
      title: '加载中',
      mask: true // 加上蒙层，防止连点
    });

    wx.request({
      // 把 app.globalData.baseUrl 删掉，直接换成你本地的 Spring Boot 地址
      url: 'http://localhost:8080/credit/log/list', 
      method: 'GET',
      data: {
        userId: userId
      },
      // ... 下面的 success 和 fail 保持不变
      success: (res) => {
        // 隐藏加载圈圈一定要放在最前面，防止后面的代码报错导致转圈不停！
        wx.hideLoading();

       if (res.statusCode === 200 && res.data.status_code === 1) {
          // 【核心修复】：如果后端返回 null，强制给个空数组 []，防止 .map() 崩溃！
          let rawData = res.data.data || []; 
          
          if (rawData.length === 0) {
            // 如果真的是空数组，直接显示空状态
            this.setData({
              logList: [],
              isEmpty: true
            });
            return;
          }

          const logList = rawData.map(item => ({
            ...item,
            createTimeFormatted: this.formatDate(new Date(item.createTime)),
            changeScoreDisplay: item.changeType === 1 ? `+${item.changeScore}` : `-${item.changeScore}`,
            changeScoreColor: item.changeType === 1 ? '#4CAF50' : '#F44336'
          }));
          
          this.setData({
            logList: logList,
            isEmpty: logList.length === 0
          });
        } else {
          wx.showToast({
            title: res.data.msg || '获取数据失败',
            icon: 'none'
          });
          this.setData({ isEmpty: true });
        }
      },
      fail: (err) => {
        wx.hideLoading(); // 失败也要关掉圈圈
        console.error('Request failed', err);
        wx.showToast({
          title: '网络请求失败，请检查后端是否启动',
          icon: 'none'
        });
        this.setData({ isEmpty: true });
      }
    });
  },

  formatDate: function(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    const hours = date.getHours().toString().padStart(2, '0');
    const minutes = date.getMinutes().toString().padStart(2, '0');
    return `${year}-${month}-${day} ${hours}:${minutes}`;
  }
});