// pages/course/course.js
import { $wuxToptips } from '../../dist/index'
import { $wuxSelect } from '../../dist/index'
var app = getApp()
var url = app.globalData.url
var header = { "Authorization": wx.getStorageSync('Authorization') }
Component({
  pageLifetimes: {

    show() {
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 0
        })
      }
      
      if (app.globalData.student != null) {
        this.setData({
          student: app.globalData.student,
          spinning: false
        })
        console.log("getCo")
        this.getCourses()

      } else {
        
        app.studentInfoCallBack = res => {
          if (res.data.body != null) {
            this.setData({
              student: res,
              spinning: false
            })
            console.log("getCo1")
            this.getCourses()
          } else {
            $wuxToptips().warn({
              hidden: false,
              text: res.data.msg,
              duration: 3000,
              success() {
              },
            })
          }

        }
      }
    },
    hide() {
      this.setData({
        spinning: true
      })
    }
  },
  properties: {
  },
  data: {
    student: null,
    spinning: true,
    word: null,
    courses: [],
    total: 0,
    current: 1,
    size: 0,
    label: "全部分类",
    items: [
      {
        title: '全部分类',
        value: '0',
      }, {
        title: '我收藏的',
        value: '1',
      },
      {
        title: '我参加的',
        value: '2',
      },
    ],
    join: 0,
    collect: 0,
    value:0

  },
  /**
   * 组件的方法列表
   */
  methods: {
    getCourses: function () {
      var header = { "Authorization": wx.getStorageSync('Authorization') }
      var data
      var r_url
      if (this.data.join == 0 && this.data.collect == 0) {
        data = { "courseName": this.data.word ,"schoolId":app.globalData.student.schoolId}
        r_url = url + "getCourses"
      } else {
        data = { "courseName": this.data.word, "join": this.data.join,"collect":this.data.collect, "studentId": app.globalData.student.studentId }
        r_url = url + "getStudentCourses"
      }
      wx.request({
        url: r_url,
        data: data,
        header: header,
        method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
        // header: {}, // 设置请求的 header
        success: (res) => {

          if (res.data.code == 1) {
            this.setData({
              courses: res.data.body.records,
              total: res.data.body.total,
              size: res.data.body.size,
              current: res.data.body.current,
              word:null
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
    onChange(e) {
      console.log('onChange', e)
      this.setData({
        word: e.detail.value,
      })
    },
    onConfirm(e) {
      console.log('confirm', e)
      this.setData({
        word: e.detail.value,
      })
      this.getCourses()
    },
    onClick(e) {
      $wuxSelect('#wux-select1').open({
        value: this.data.value,
        options: this.data.items,
        onConfirm: (value, index, options) => {
          console.log('onConfirm', value, index, options)
          if (index !== -1) {
            if (options[index].value == 1) {
              this.setData({
                value:options[index].value,
                collect: 1,
                join:0,
                label: options[index].title,
              })
              
            }else if(options[index].value==2){
              this.setData({
                value:options[index].value,
                join: 1,
                collect:0,
                label: options[index].title,
              })
            }else if(options[index].value==0){
              this.setData({
                value:options[index].value,
                join: 0,
                collect:0,
                label: options[index].title,
              })
            }
            this.getCourses()
          }
        },
      })

    },

  }
})
