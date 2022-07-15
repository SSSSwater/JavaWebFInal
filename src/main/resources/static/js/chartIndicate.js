var exam_id = sessionStorage.getItem("id");
axios.get("https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/exam?exam_id=" + exam_id
).then(function (res) {
    classes = res.data.exam[0].class;
    console.log(classes)
    for (i in classes) {
        app.classSelectOptions.push({
            // value: classes[i],
            value: parseInt(i)+1,
            label: classes[i]
        })
    }
})

function requestDetail(selected) {
    if (selected == "All") {
        axios.get("https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/mark?mark_id=" + exam_id).then(function (res) {
            handleData(res.data.mark);
        })
    } else {
        console.log(selected);
        axios(
            {
            method: "GET",
            url: "https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/mark"+selected,
            params: {
                mark_id: exam_id,
                class: selected
            }
        }
        ).then(function (res) {
            console.log(res.data.mark);
            handleData(res.data.mark);
        })
    }

}

function handleData(gotData){
    tData=[0,0,0];
    tScoreData=[];
    for(i in gotData){
        if(gotData[i].mark<60) tData[0]++;
        else if(gotData[i].mark<80) tData[1]++;
        else tData[2]++;
        tScoreData.push({
            name:gotData[i].name,
            score:gotData[i].mark,
        })
    }
    tMaxScore=0;
    tMaxScoreName='null';
    for(i=0;i<tScoreData.length;i++){
        if(tScoreData[i].score>tMaxScore) {tMaxScore=tScoreData[i].score;tMaxScoreName=tScoreData[i].name;}
    }
    app.gotScoreData=tScoreData;
    app.maxScore=tMaxScore;
    app.maxScoreName=tMaxScoreName;
    refreshData(classAverage,tData);
}

var app = new Vue({
    el: '#app',
    data() {
        return {
            tagActiveName: 'second',
            classSelectOptions: [{
                value: 'All',
                label: '全部'
            }],
            classSelectValue: '',
            gotScoreData:[],
            maxScoreName:'null',
            maxScore:0
        }
    },
    methods: {
        selectChange(selectedClass) {
            app.maxScore=0;
            app.maxScoreName='';
            requestDetail(selectedClass);
        },
        handleClick(tab, event) {
            console.log(tab, event);
        }
    }
})
function refreshData(chart,data){
    chart.data.datasets[0].data=data;
    chart.update();
}
;
const labels = ['不及格','及格','优秀']
const data = {
    labels: labels,
    datasets: [{
        label: '学生成绩分布',
        backgroundColor: ['rgb(255, 73, 71)','rgb(220, 145, 53)','rgb(109, 225, 134)'],
        data: [0,0,0],
    }]
};

const config = {
    type: 'pie',
    data: data,
    options: {}
};

classAverage = new Chart(
    document.getElementById('classAverage'),
    config
);