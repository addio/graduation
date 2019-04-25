// pages/analysis/analysis.js
var app = getApp()
var url = app.globalData.url
var header = { "Authorization": wx.getStorageSync('Authorization') }
Page({

  /**
   * 页面的初始数据
   */
  data: {
    analysis:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var experimentId = options.experimentId;
    this.showAnalysis(experimentId)
  },

  showAnalysis(experimentId){
    wx.request({
     url: url + "getExperimentAnalysis",
     data: { "experimentId": experimentId},
     header: header,
     method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
     // header: {}, // 设置请求的 header
     success: (res) => {

         if (res.data.code == 1) {
           this.setData({
             analysis:res.data.body.experimentAnalysis
           })
             
         } else {
             $wuxToptips().error({
                 hidden: false,
                 text: res.data.msg,
                 duration: 3000,
                 success() {
                 },
             })
         }
     }
 })
 },
})