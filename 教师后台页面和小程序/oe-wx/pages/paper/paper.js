// pages/paper/paper.js
import { $wuxToptips } from '../../dist/index'
import { $wuxDialog } from '../../dist/index'
var app = getApp()
var url = app.globalData.url
var header = { "Authorization": wx.getStorageSync('Authorization') }
Page({

  /**
   * 页面的初始数据
   */
  data: {
    experimentId: "",
    paper: {},
    result:"",
    args:"",
    index:0,
    tabs: [
      {
        key: 'tab1',
        title: '实验内容',
      },
      {
        key: 'tab2',
        title: '实验代码',
      },
      {
        key: 'tab3',
        title: '实验心得',
      },
    ],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    this.setData({
      experimentId: options.experimentId
    })
    
    
  },
  onShow:function(){
    this.getPaper()
  },
  onTabsChange(e) {
    console.log('onTabsChange', e)
    const { key } = e.detail
    const index = this.data.tabs.map((n) => n.key).indexOf(key)

    this.setData({
      key,
      index,
    })
  },
  tapMove(e) {
    this.setData({
      scrollTop: this.data.scrollTop + 10
    })
  },
  onSwiperChange(e) {
    console.log('onSwiperChange', e)
    const { current: index, source } = e.detail
    const { key } = this.data.tabs[index]

    if (!!source) {
      this.setData({
        key,
        index,
      })
    }
  },
  sliderChange(e) {
    this.setData({
      slider: e.detail.value,
    })
    console.log(e.detail.value)
  },
  getPaper() {
    wx.request({
      url: url + "getPaper",
      data: { "studentId": app.globalData.student.studentId, "experimentId": this.data.experimentId },
      header: header,
      method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: (res) => {

        if (res.data.code == 1) {
          this.setData({
            paper: res.data.body
          })
          console.log(res.data.body)
          wx.setNavigationBarTitle({
            title: res.data.body.experimentTitle,
            success: function (res) {
              // success
            }
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
  onCodeInput(e) {
    var index = e.currentTarget.dataset.index
    var code = 'paper.experimentSteps[' + index + '].stepCode'
    this.setData({
      [code]: e.detail.value
    })
  },
  onArgsInput(e) {
    this.setData({
      args: e.detail.value
    })
  },
  save() {
    this.updatePaper(1)
  },
  submit() {
    this.updatePaper(2)
  },
  feelingInput(e) {
    this.setData({
      'paper.experimentFeeling': e.detail.value
    })
  },
  execute() {
    var steps = this.data.paper.experimentSteps
    var data = {"experimentSteps":steps,"studentId":app.globalData.student.studentId,"experimentId":this.data.experimentId,"args":this.data.args}
    wx.request({
      url: url + 'executeCode',
      data: data,
      header: header,
      method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: res=> {
        if (res.data.code == 1) {
          this.setData({
            result: res.data.body.result
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
  updatePaper(status) {
    this.setData({
      'paper.experimentStatus': status
    }
    )
    var data = this.data.paper;
    wx.request({
      url: url + "updatePaper",
      data: data,
      header: header,
      method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
      // header: {}, // 设置请求的 header
      success: function (res) {
        console.log(res)
        wx.navigateBack({
          delta: 1
        })
      },
      fail: function () {
        // fail
      },
      complete: function () {
        // complete
      }
    })
  }
})