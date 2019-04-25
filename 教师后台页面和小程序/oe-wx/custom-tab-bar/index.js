Component({
  data: {
    selected: 0,
    color: "#7A7E83",
    selectedColor: "#3cc51f",
    "list": [//app.json中要把组件放在页面定义放在前面，不然不显示tabbar
      {
        pagePath: "/pages/course/course",
         iconPath: "../image/course.png",
         selectedIconPath: "../image/course_selected.png",
        text: "课程"
      },
      {
        pagePath: "/pages/my/my",
        iconPath: "../image/person.png",
        selectedIconPath: "../image/person_selected.png",
         text: "我的"
      }
    ]
  },
  attached() {
  },
  methods: {
    switchTab(e) {
      const data = e.currentTarget.dataset
      const url = data.path
      console.log(url)
      wx.switchTab({url})
      this.setData({
        selected: data.index
      })
    }
  }
})