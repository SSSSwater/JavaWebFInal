var titlenum = new Array();
var app = new Vue({
    el: '#app',
    data() {
        const generateData = _ => {
            const data = [];
            return data;
        };
        return {
            searchText:'',
            subjectSelectOptions: [{
                value: 'Chinese',
                label: '语文'
            }, {
                value: 'Math',
                label: '数学'
            }, {
                value: 'English',
                label: '外语'
            }, {
                value: 'Physics',
                label: '物理'
            }, {
                value: 'Chemical',
                label: '化学'
            }, {
                value: 'Biology',
                label: '生物'
            }, {
                value: 'History',
                label: '历史'
            }, {
                value: 'Geography',
                label: '地理'
            }, {
                value: 'Politics',
                label: '政治'
            }, {
                value: 'Technology',
                label: '技术'
            },
            ],
            subjectSelected: '',
            typeSelectOptions: [{
                value: 'single',
                label: '单选'
            }, {
                value: 'multiple',
                label: '多选'
            }, {
                value: 'judge',
                label: '判断'
            }, {
                value: 'cloze',
                label: '填空'
            }, {
                value: 'short',
                label: '简答'
            }, {
                value: 'discuss',
                label: '论述'
            }
            ],
            typeSelected: '',
            transferData: generateData(),
            transferValue: [],
            paperTitle: ''
        };
    },
    methods: {
        pop: (aa) => {
            if (aa.length > 0) {
                titlenum = aa;
                console.log(titlenum);
                axios({
                    methods: "GET",
                    url: "http://127.0.0.1:8080/teacher/make_paper",
                    params: {
                        id: aa
                    }
                }).then(function (res) {
                    examdiv = document.getElementById('exam');
                    while (examdiv.hasChildNodes()) {
                        examdiv.removeChild(examdiv.firstChild);
                    }
                    t = res.data;
                    i = 0;
                    while (t[i] != null) {
                        console.log(res.data[i]);
                        if (t[i].analysisEnabled) anl = t[i].analysis;
                        else anl = "无";
                        if (t[i].type == "single" || t[i].type == "multiple") showData1(t[i].id, t[i].type, t[i].title, t[i].choiceA, t[i].choiceB, t[i].choiceC, t[i].choiceD, t[i].answer, anl, 1);
                        else if (t[i].type == "judge") showData2(t[i].id, t[i].type, t[i].title, "Yes", "No", t[i].answer, anl, 1);
                        else showData3(t[i].id, t[i].type, t[i].title, t[i].answer, anl, 1);
                        i++;
                    }
                })
            }
        },
        bind() {
            console.log(app.subjectSelected);
            axios({
                method: 'GET',
                url: "http://127.0.0.1:8080/teacher/make_paper",
                params: {
                    subject: app.subjectSelected,
                    type: app.typeSelected,
                    id: app.searchText
                }
            })
                .then(function (res) {
                    console.log(res);
                    t = res.data;
                    i = 0;
                    tData=[];
                    while (t[i] != null) {
                        console.log(res.data[i]);
                        if (t[i].analysisEnabled) anl = t[i].analysis;
                        else anl = "无";

                        tData.push({
                            label: '[' + t[i].id + ']' + t[i].title,
                            key: t[i].id
                        })
                        i++;
                        console.log(tData);
                    }
                    app.transferData=tData;

                })
        },
        submitIt() {
            var papername = app.paperTitle;
            console.log(papername);
            var markIds = document.getElementsByName("mark");
            var markIdValue = new Array();
            console.log(markIds);
            for (i = 0; i < markIds.length; i++) {
                if (markIds[i].value > 0) {
                    markIdValue.push(markIds[i].value);
                }
            }
            console.log(markIdValue);
            axios({
                method:'post',
                 url:"http://127.0.0.1:8080/teacher/post_paper",
                params:{
                "examark": markIdValue,
                "titlenum": titlenum,
                "papername": papername
            }}).then(function (res) {
                console.log(res.data);
                alert("组卷成功");
            }).catch(function (res) {
                alert("hhh");
            })
            location.href="post_paper"
        }

    }
})