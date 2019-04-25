//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.setStorageSync('logs') || []
    logs.unshift(Date.now())
    this.oeLogin()
    var that = this
    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })
  },
  globalData: {
    Authorization: "",
    url_auth: "http://129.204.38.10/oe/account/",
    url: "http://129.204.38.10/oe/student/",
    student: null
  },
  oeLogin: function () {
    var expiration_time = wx.getStorageSync('index_data_expiration')
    console.log(expiration_time)
    var now = Date.parse(new Date());
    if (expiration_time && now < expiration_time) {
      this.getStudentInfo()
    } else {
      wx.login({
        success: res => {
          wx.request({
            url: this.globalData.url_auth + 'wxLogin',
            data: { "code": res.code },
            method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
            // header: {}, // 设置请求的 header
            success: res => {
              if (res.data.code == 1) {
                wx.setStorageSync("Authorization", res.header.Authorization)
                //存一个过期时间
                var timestamp = Date.parse(new Date());
                var expiration = timestamp + 86000000;
                wx.setStorageSync("index_data_expiration", expiration);
                this.getStudentInfo()
              }
            }
          })
        }
      })
    }
  },
  getStudentInfo: function () {
    var authorization = wx.getStorageSync('Authorization')
    this.globalData.student = null;
    wx.request({
      url: this.globalData.url + 'getStudentInfo',
      header: { "Authorization": authorization },
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: (res) => {
          this.globalData.student = res.data.body
          if (this.studentInfoCallBack) {
            this.studentInfoCallBack(res)
          }
          if (this.myCallBack) {
            this.myCallBack(res)
          }
      }
    })
  }
})