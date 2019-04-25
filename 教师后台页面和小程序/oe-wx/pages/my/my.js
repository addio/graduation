// pages/my/my.js
import { $wuxSelect } from '../../dist/index'
import { $wuxToptips } from '../../dist/index'
var app = getApp()
var url = app.globalData.url
var header = { "Authorization": wx.getStorageSync('Authorization') }
Component({
  pageLifetimes: {
    show() {
      if (typeof this.getTabBar === 'function' &&
        this.getTabBar()) {
        this.getTabBar().setData({
          selected: 1
        })
      }
      if (app.globalData.student != null) {
        var svalue;
        var slabel;
        if (app.globalData.student.sex == 1) {
          svalue = "1",
            slabel = "男"
        } else {
          svalue = "2",
            slabel = "女"
        }
        this.setData({
          student: app.globalData.student,
          avatarUrl: app.globalData.student.avatarUrl,
          schoolName: app.globalData.student.schoolName,
          items: [{
            value: svalue,
            label: slabel
          }],
          disabled: false
        })

      } else {
        this.setData({
          disabled: true
        })
      }
      console.log(this.data.student)
    }
  },
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    avatarUrl: "",
    schoolName: "点击选择学校",
    schoolId: "",
    schools: [
    ],
    word: null,
    value: "",
    items: [{
      value: '1',
      label: '男'
    }, {
      value: '2',
      label: '女'
    }],
    current: '1',
    checked: false,
    student: {},
    disabled: false
  },

  /**
   * 组件的方法列表
   */
  methods: {
    getUserInfo: function (e) {
      this.setData({
        avatarUrl: e.detail.userInfo.avatarUrl
      })
      this.updateStudent()
    },
    modify() {
      this.setData({
        disabled: true,
        items: [{
          value: '1',
          label: '男'
        }, {
          value: '2',
          label: '女'
        }]
      })
    },
    chooseSchool: function () {
      wx.request({
        url: url + 'getSchools',
        data: { "schoolName": this.data.word },
        header: header,
        method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
        // header: {}, // 设置请求的 header
        success: (res) => {
          if(res.data.code==1){
          this.setData({
            schools: res.data.body.records
          })
          console.log(this.data.schools)
          var op = []
          for (var i = 0; i < this.data.schools.length; i++) {
            op.push({ title: this.data.schools[i].schoolName, value: this.data.schools[i].schoolId })
          }
          $wuxSelect('#wux-select1').open({
            value: this.data.value,
            options: op,
            onConfirm: (value, index, options) => {
              console.log('onConfirm', value, index, options)
              if (index !== -1) {
                this.setData({
                  schoolId: options[index].value,
                  schoolName: options[index].title,
                })
              }
            },
          })
        }else{
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
      console.log(e)
      this.setData({
        current: e.detail.value,
      })
    },
    idInput(e) {
      console.log(e)
      this.setData({
        studentId: e.detail.value,
      })
    },
    nameInput(e) {
      console.log(e)
      this.setData({
        studentName: e.detail.value,
      })
    },
    updateStudent: function () {
      wx.request({
        url: url + 'updateStudent',
        data: {
          "studentId": this.data.studentId,
          "studentName": this.data.studentName,
          "sex": parseInt(this.data.current),
          "schoolId": this.data.schoolId,
          "schoolName": this.data.schoolName,
          "avatarUrl": this.data.avatarUrl
        },
        header: header,
        method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
        // header: {}, // 设置请求的 header
        success: (res) => {
          if (res.data.code == 1) {
            app.getStudentInfo()
            wx.switchTab({
              url: '/pages/course/course',

            })

          }else{
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
    }
  }
})
