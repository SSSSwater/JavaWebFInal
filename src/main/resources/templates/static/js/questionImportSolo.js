window.onload=showTheElement();
window.onload=analysisRefresh();

function analysisRefresh(){

    var sel = document.getElementsByName("analysis_enabled");
    if(sel[0].checked) document.getElementById("analysis").style.display="block";
    else document.getElementById("analysis").style.display="none";
}

function showTheElement(){
    var questionType=document.getElementsByName("question_type");
    var selected=-1;
    for(var i=0;i<questionType.length;i++){
        if(questionType[i].checked){
            selected = i;
            break;
        }
    }
    switch(selected){

        case -1:{
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="none";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
        case 0: {
            document.getElementById("single").style.display="block";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="none";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
        case 1: {
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="block";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="none";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
        case 2: {
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="block";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="none";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
        case 3: {
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="block";
            document.getElementById("short").style.display="none";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
        case 4: {
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="block";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
        case 5: {
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="none";
            document.getElementsByName("analysis_enabled")[0].checked=true;
            document.getElementsByName("analysis_enabled")[0].disabled=true;
            analysisRefresh();
            break;
        }
        case 6: {
            document.getElementById("single").style.display="none";
            document.getElementById("multiple").style.display="none";
            document.getElementById("judge").style.display="none";
            document.getElementById("cloze").style.display="none";
            document.getElementById("short").style.display="block";
            document.getElementsByName("analysis_enabled")[0].disabled=false;
            break;
        }
    }
}