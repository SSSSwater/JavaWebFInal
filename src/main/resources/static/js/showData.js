function showDataHead(tDiv, queDiv, id, type, title, mode) {
    tDiv.id = 'div_' + id;
    tDiv.className = 'row m-3';
    queDiv.className = 'col-10';
    if (mode == 1) {
        let checkDiv = document.createElement('div');
        checkDiv.className = 'col-2';
        checkDiv.style="padding:0";
        checkDiv.id='check_'+id;
        let check = document.createElement('input');
        check.type = 'text';
        check.name = "mark";
        check.style=" width: 27.99148px";
        check.className='form-control';
        check.style="padding:0";

        // check.className = "form-check-input";
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
    if(mode!=2){
        let ansDiv = document.createElement('div');
        let ansLabel = document.createElement('label');
        ansLabel.innerHTML = "答案:" + answer;
        let anlLabel = document.createElement('label');
        anlLabel.innerHTML = "解析:" + analysis;
        ansDiv.appendChild(ansLabel);
        ansDiv.appendChild(document.createElement('br'));
        ansDiv.appendChild(anlLabel);
        queDiv.appendChild(ansDiv)
        ansDiv.style = "background-color: rgba(225, 225, 225,0.8);border-radius:4px";
    }
    tDiv.appendChild(queDiv);
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
    choiceALabel.className='form-check-label';
    let choiceBLabel = document.createElement('label');
    choiceBLabel.innerHTML = "B." + choiceB + "  ";
    choiceBLabel.className='form-check-label';
    let choiceCLabel = document.createElement('label');
    choiceCLabel.innerHTML = "C." + choiceC + "  ";
    choiceCLabel.className='form-check-label';
    let choiceDLabel = document.createElement('label');
    choiceDLabel.innerHTML = "D." + choiceD + "  ";
    choiceDLabel.className='form-check-label';
    if(mode==2){
        let choiceARadio=document.createElement('input');
        if(type=='single') choiceARadio.type='radio';
        else choiceARadio.type='checkbox';
        choiceARadio.name='answer_'+id;
        choiceARadio.value='A';
        choiceARadio.className='form-check-input';
        let choiceBRadio=document.createElement('input');
        if(type=='single') choiceBRadio.type='radio';
        else choiceBRadio.type='checkbox';
        choiceBRadio.name='answer_'+id;
        choiceBRadio.value='B';
        choiceBRadio.className='form-check-input';
        let choiceCRadio=document.createElement('input');
        if(type=='single') choiceCRadio.type='radio';
        else choiceCRadio.type='checkbox';
        choiceCRadio.name='answer_'+id;
        choiceCRadio.value='C';
        choiceCRadio.className='form-check-input';
        let choiceDRadio=document.createElement('input');
        if(type=='single') choiceDRadio.type='radio';
        else choiceDRadio.type='checkbox';
        choiceDRadio.name='answer_'+id;
        choiceDRadio.value='D';
        choiceDRadio.className='form-check-input';
        divA.appendChild(choiceARadio);
        divB.appendChild(choiceBRadio);
        divC.appendChild(choiceCRadio);
        divD.appendChild(choiceDRadio);
    }
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
    if(mode==2){
        let divT = document.createElement('div');
        let divF = document.createElement('div');
        let choiceTLabel = document.createElement('label');
        choiceTLabel.innerHTML = " " + choiceT + "  ";
        choiceTLabel.className='form-check-label';
        let choiceFLabel = document.createElement('label');
        choiceFLabel.innerHTML = " " + choiceF + "  ";
        choiceFLabel.className='form-check-label';
        let choiceTRadio=document.createElement('input');
        choiceTRadio.type='radio';
        choiceTRadio.name='answer_'+id;
        choiceTRadio.value='T'
        choiceTRadio.className='form-check-input';
        let choiceFRadio=document.createElement('input');
        choiceFRadio.type='radio';
        choiceFRadio.name='answer_'+id;
        choiceFRadio.value='F';
        choiceFRadio.className='form-check-input';
        divT.appendChild(choiceTRadio);
        divF.appendChild(choiceFRadio);
        divT.appendChild(choiceTLabel);
        divF.appendChild(choiceFLabel);
        queDiv.appendChild(divT);
        queDiv.appendChild(divF);
    }
    showDataFeet(tDiv, queDiv, answer, analysis, mode);
}//mode 0:仅读 1:可选题 2:可做题(未完成)

function showData3(id, type, title, answer, analysis, mode) {
    let tDiv = document.createElement('div');
    let queDiv = document.createElement('div');
    showDataHead(tDiv, queDiv, id, type, title, mode);
    if(mode==2){
        let divAnswer = document.createElement('div');
        let answerLabel = document.createElement('label');
        answerLabel.innerHTML='输入答案: '
        let answerInput;
        if(type=='cloze') answerInput = document.createElement('input');
        else answerInput = document.createElement('textarea');
        answerInput.name='answer';
        answerInput.className='form-control';
        if(type=='short'){
            answerInput.style='height: 25vh;resize: none;';
        }
        divAnswer.appendChild(answerLabel);
        divAnswer.appendChild(answerInput);
        queDiv.appendChild(divAnswer);
    }
    showDataFeet(tDiv, queDiv, answer, analysis, mode);
}//mode 0:仅读 1:可选题 2:可做题(未完成)