var exam_id = sessionStorage.getItem("id");
axios.get("https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/exam?exam_id=" + exam_id
).then(function (res) {
    classes = res.data.exam[0].class;
    console.log(classes)
    for (i in classes) {
        classSelect.options.push({
            value: classes[i],
            label: classes[i]
        })
    }
})

function requestDetail(selected) {
    if (selected == "All") {
        axios.get("https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/mark?mark_id=" + exam_id).then(function (res) {
            console.log(res.data.mark);
            handleData(res.data.mark);
        })
    } else {
        axios({
            method: "GET",
            url: "https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/mark",
            params: {
                mark_id: exam_id,
                class: selected
            }
        }).then(function (res) {
            console.log(res.data.mark)
            handleData(res.data.mark);
        })
    }

}

function handleData(gotData){
    for(i in gotData){
        labels.push(gotData[i].name);
        data.datasets[0].data.push(gotData[i].mark);
    }
    console.log(labels);
}

var classSelect = new Vue({
    el: '#classSelect',
    data() {
        return {
            options: [{
                value: 'All',
                label: '全部'
            }],
            value: ''
        }
    },
    methods: {
        selectChange(selectedClass) {
            console.log(selectedClass);
            requestDetail(selectedClass);
            const classAverage = new Chart(
                document.getElementById('classAverage'),
                config
            );
        }
    }
})

const labels = [];

const data = {
    labels: labels,
    datasets: [{
        label: 'My First dataset',
        backgroundColor: 'rgb(255, 99, 132)',
        borderColor: 'rgb(255, 99, 132)',
        data: [],
    }]
};

const config = {
    type: 'bar',
    data: data,
    options: {}
};