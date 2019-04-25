// pages/courseDetail/courseDetail.js
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
        scrollTop: 100,
        tabs: [
            {
                key: 'tab1',
                title: '课程详情',
            },
            {
                key: 'tab2',
                title: '实验目录',
            },
           
        ],
        course: {
        },
        experiments:[],
        courseId: "",
        body: "课程详情",
        extra: "人工智能",
        index:0
    },
    onTabsChange(e) {
        console.log('onTabsChange', e)
        const { key } = e.detail
        const index = this.data.tabs.map((n) => n.key).indexOf(key)

        this.setData({
            key,
            index,
        })
        if(this.data.index==1){
            this.getExperiments()
        }
    },
    tapMove(e) {
        this.setData({
            scrollTop: this.data.scrollTop + 10
        })
    },
    collect() {
        var collect = this.data.course.collect
        this.setData({
            'course.collect': collect == 1 ? 0 : 1
        })
        console.log(this.data.course.collect)
        this.updateCourseInfo()
    },
    
    getExperiments(){
        wx.request({
            url: url + "getExperimentsByCourseId",
            data: { "courseId": this.data.courseId, "studentId": app.globalData.student.studentId,"current":1,"size":22},
            header: header,
            method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
            // header: {}, // 设置请求的 header
            success: (res) => {
                if (res.data.code == 1) {
                    this.setData({
                        experiments:res.data.body.records
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
    join() {
        var join = this.data.course.join
        var that =this;
        if(join==1){
            
            $wuxDialog().confirm({
                resetOnClose: true,
                closable: true,
                title: '提醒',
                content: '你确定要退出课程吗？',
                onConfirm(e) {
                    that.setData({
                        'course.join': 0
                    })
                    that.updateCourseInfo()
                },
                onCancel(e) {
                },
            })
        }else{
            this.setData({
                'course.join': 1
                
            })
            this.updateCourseInfo()
        }
        
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
            if(this.data.index==1){
                this.getExperiments()
            }
        }
    },
    sliderChange(e) {
        this.setData({
            slider: e.detail.value,
        })
        console.log(e.detail.value)
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        this.getCourseInfo(options.courseId)
        this.setData({
            courseId: options.courseId
        })
    },
    updateCourseInfo: function () {
        var courseinfo = this.data.course
        console.log(courseinfo)
        wx.request({
            url: url + "updateCourseInfo",
            data: { "courseId": this.data.courseId, "studentId": app.globalData.student.studentId, "join": courseinfo.join, "collect": courseinfo.collect },
            header: header,
            method: 'POST', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
            // header: {}, // 设置请求的 header
            success: (res) => {

                if (res.data.code == 1) {
                    $wuxToptips().success({
                        hidden: false,
                        text: '成功',
                        duration: 1000,
                        success() {
                        },
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
    getCourseInfo: function (courseId) {
        wx.request({
            url: url + "getCourseInfo",
            data: { "courseId": courseId, "studentId": app.globalData.student.studentId },
            header: header,
            method: 'GET', // OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT
            // header: {}, // 设置请求的 header
            success: (res) => {

                if (res.data.code == 1) {
                    this.setData({
                        course: res.data.body,
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
    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        this.getExperiments()
    },
})