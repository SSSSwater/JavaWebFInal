function showDataHead(tDiv, queDiv, id, type, title, mode) {
    tDiv.id = 'div_' + id;
    tDiv.className = 'row m-3';
    queDiv.className = 'col-11';
    if (mode == 1) {
        let checkDiv = document.createElement('div');
        checkDiv.className = 'col-1';
        let check = document.createElement('input');
        check.type = "checkbox";
        check.name = "question1";
        check.className = "form-check-input";
        check.value = id;
        checkDiv.appendChild(check);
        tDiv.appendChild(checkDiv);
    }
    let titleP = document.createElement('p');
    queDiv.appendChild(titleP);
    tDiv.append(queDiv);
    let typeToName = new Map();
    typeToName.set("single", "单选");
    typeToName.set("multiple", "多选");
    typeToName.set("judge", "判断");
    typeToName.set("cloze", "填空");
    typeToName.set("short", "简答");
    typeToName.set("discuss", "论述");
    titleP.innerHTML = "(" + typeToName.get(type) + ")" + "[" + id + "]" + title;
}

function showDataFeet(tDiv, queDiv, answer, analysis, mode) {
    let ansDiv = document.createElement('div');
    let ansLabel = document.createElement('label');
    ansLabel.innerHTML = "答案:" + answer;
    let anlLabel = document.createElement('label');
    anlLabel.innerHTML = "解析:" + analysis;
    ansDiv.appendChild(ansLabel);
    ansDiv.appendChild(document.createElement('br'));
    ansDiv.appendChild(anlLabel);
    queDiv.appendChild(ansDiv)
    tDiv.appendChild(queDiv);
    ansDiv.style = "background-color: rgba(225, 225, 225,0.8);border-radius:4px";
    queDiv.style = "background-color: rgba(235, 235, 235,0.8);border-radius:10px";
    tDiv.style = "background-color: rgba(245, 245, 245,0.8);border-radius:10px";
    document.getElementById('exam').appendChild(tDiv);
}

function showData1(id, type, title, choiceA, choiceB, choiceC, choiceD, answer, analysis, mode) {

    let tDiv = document.createElement('div');
    let queDiv = document.createElement('div');
    showDataHead(tDiv, queDiv, id, type, title, mode);
    let divA = document.createElement('div');
    let divB = document.createElement('div');
    let divC = document.createElement('div');
    let divD = document.createElement('div');
    let choiceALabel = document.createElement('label');
    choiceALabel.innerHTML = "A." + choiceA + "  ";
    let choiceBLabel = document.createElement('label');
    choiceBLabel.innerHTML = "B." + choiceB + "  ";
    let choiceCLabel = document.createElement('label');
    choiceCLabel.innerHTML = "C." + choiceC + "  ";
    let choiceDLabel = document.createElement('label');
    choiceDLabel.innerHTML = "D." + choiceD + "  ";
    divA.appendChild(choiceALabel);
    divB.appendChild(choiceBLabel);
    divC.appendChild(choiceCLabel);
    divD.appendChild(choiceDLabel);
    queDiv.appendChild(divA);
    queDiv.appendChild(divB);
    queDiv.appendChild(divC);
    queDiv.appendChild(divD);
    showDataFeet(tDiv, queDiv, answer, analysis, mode);
}//mode 0:仅读 1:可选题 2:可做题(未完成)

function showData2(id, type, title, choiceT, choiceF, answer, analysis, mode) {

    let tDiv = document.createElement('div');
    let queDiv = document.createElement('div');
    showDataHead(tDiv, queDiv, id, type, title, mode);
    showDataFeet(tDiv, queDiv, answer, analysis, mode);
}//mode 0:仅读 1:可选题 2:可做题(未完成)

function showData3(id, type, title, answer, analysis, mode) {
    let tDiv = document.createElement('div');
    let queDiv = document.createElement('div');
    showDataHead(tDiv, queDiv, id, type, title, mode);
    showDataFeet(tDiv, queDiv, answer, analysis, mode);
}//mode 0:仅读 1:可选题 2:可做题(未完成)