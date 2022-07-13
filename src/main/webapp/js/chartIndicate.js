var exam_id = sessionStorage.getItem("id");
axios.get("https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/exam?exam_id="+exam_id
).then(function (res){
    console.log(res.data.exam[0].class);
})

if(!false)
{
    axios.get("https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/mark?mark_id="+exam_id).then(function (res){
        console.log(res.data.mark);
    })
}
else
{
    axios({
        method:"GET",
        url:"https://www.fastmock.site/mock/e9925219f50cf7e3886d239c029d58a8/test/mark",
        params:{
            mark_id:exam_id,
            class:classes
        }
    }).then(function (res){
        console.log(res.data.mark)
    })
}
var classSelect = new Vue({
    el: '#classSelect',
    data() {
        return {
            options: [{
                value: '选项1',
                label: '黄金糕'
            }, {
                value: '选项2',
                label: '双皮奶'
            }],
            value: ''
        }
    }
})

const labels = [
    'January',
    'February',
    'March',
    'April',
    'May',
    'June',
];

const data = {
    labels: labels,
    datasets: [{
        label: 'My First dataset',
        backgroundColor: 'rgb(255, 99, 132)',
        borderColor: 'rgb(255, 99, 132)',
        data: [0, 10, 5, 2, 20, 30, 45],
    }]
};

const config = {
    type: 'bar',
    data: data,
    options: {}
};
const classAverage = new Chart(
    document.getElementById('classAverage'),
    config
);