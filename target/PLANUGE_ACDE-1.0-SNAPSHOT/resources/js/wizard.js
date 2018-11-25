/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function wizard(id){
    switch(id){
        case 'b1':{
             change("s2", "a2", "a1");
                break;
        }
        case 'b2' :{
                if(verifier("tab_2")){
                    change("s3", "a3", "a2");
                }
               break; 
        }
        case 'b3' :{
                if(verifier("tab_3")){
                   change("s4", "a4", "a3");
                }
               break; 
        }
        case 'b4' :{
                if(verifier("tab_4")){
                   change("s5", "a5", "a4");
                }
               break; 
        }
        default :{
              alert("default");
              break;
        }  
    }           
}

function precedent(id){
    switch(id){
        case 'ba2':{
             change("s1", "a1", "a2");
             break;
        }
        case 'ba3' :{
                change("s2", "a2", "a3");
                break; 
        }
        case 'ba4' :{
              change("s3", "a3", "a4");
              break; 
        }
        case 'ba5' :{
               change("s4", "a4", "a5");
               break; 
        }
        default :{
              alert("default");
              break;
        }  
    }
}

function change(btn, nv, ancien){
    document.getElementById(ancien).parentNode.className="";
    document.getElementById(nv).parentNode.className="active";
    document.getElementById(btn).click();
}

function verifier(root){
    
    var elControls = document.getElementById(root).getElementsByClassName("wcontrol");
    var t = elControls.length;
    var check = true;
    //return true;
    //alert(elControls[0].className.indexOf("ignore"));
    for(var i=0; i < t; i++){
        if((elControls[i].className.indexOf("ignore") === -1)){
            if((elControls[i].style.display !=="none")) {

                if(elControls[i].value===""){
                    elControls[i].style.borderColor="red";
                    check=false;
                }
                else{
                    elControls[i].style.borderColor="";
                }
                if(elControls[i].className.indexOf("mail") !== -1){
                    if(!checkMail(elControls[i].value)){
                        elControls[i].style.borderColor="red";
                        check=false;
                    }
                }
            }
            else{
                elControls[i].style.borderColor="";
                check = true;
            }
        }
        else{
             elControls[i].style.borderColor="";
        }
    }
//    return check;
    return true;
}

function setValue(){
    var recapValues = document.getElementsByClassName("recap");
    var wValues = document.getElementsByClassName("wcontrol");
    var tr = recapValues.length;
    var t = wValues.length;
//    for(var i=0, j=0; i<tr && j<t; i++, j++){
//        
//        if(wValues[j].tagName.toLowerCase()==="table"){
//            
//            var el= wValues[j].getElementsByTagName("input");
//            for(var k = 0; k<el.length; k++){
//                
//                if(el[k].checked){
//                    recapValues[i].innerHTML = el[k].value;
//                } 
//            }
//        }else if(wValues[j].tagName.toLowerCase() === "select"){
//            var s= wValues[j];
//            if(s.selectedIndex !== -1){
//                recapValues[i].innerHTML = s[s.selectedIndex].innerHTML;
//            }
//            
//        }else{
            recapValues[i].innerHTML =wValues[j].value;
//        }
//        
//    }
}


(function (){
    
    if(document.getElementById("todoForm:terminer") === null){
        document.getElementById("todoForm:l7").style.display="";
        setValue();
        change("s5", "a5", "a1");
    }
    
    var inputs = document.getElementsByTagName("input");
    var t = inputs.length;
    for(var i=0; i<t; i++){
        if(inputs[i].type==="text" || inputs[i].type==="password" || inputs[i].type==="email"){
            inputs[i].onkeydown= function(e){
                if(e.keyCode===13){
                   // alert("Soumission du formulaire blocker by Darkst !!!")
                    return false;
                }
            };
        }
    }
});

$(function() {
    var regMat = $("#rowRegMat");
    var conjoint = $("#rowConjoint");
    var sexe = document.getElementById("todoForm:sexe").getElementsByTagName("input");
    var nbrEnfLeg = $("#todoForm\\:nbrEnfantLeg");
    var btnMoins_1 = $("#moins_1");
    var btnPlus_1 = $("#plus_1");
    var nbrPersAcharge = $("#todoForm\\:nbrPersAcharge");
    var btnMoins_2 = $("#moins_2");
    var btnPlus_2 = $("#plus_2");
    
    $(nbrEnfLeg).val(0);
    $(nbrPersAcharge).val(0);
    $(regMat).hide();
    $("#recapRegimeMat").parent().parent().parent().parent().hide();
    $(conjoint).hide();
    $("#recapConjoint").parent().parent().parent().parent().hide();
    $("#recapLangue1").html($("#todoForm\\:langue1").val());
    $("#recapSituationMat").html($("#todoForm\\:situationMat").val());
    $("#recapRegimeMat").html($("#todoForm\\:regimeMat").val());
    $("#recapNbrEnfLeg").html($("#todoForm\\:nbrEnfantLeg").val());
    $("#recapNbrEnfCharge").html($("#todoForm\\:nbrPersAcharge").val());
    
    // ======= pour gerer les btn + et - =============
    
    //nbre d'enfants legitimes
    $(btnMoins_1).click(function() {
        if($(nbrEnfLeg).val() > 0) {
            var nbr = $(nbrEnfLeg).val();
            nbr = eval((nbr*1)-1);
            $(nbrEnfLeg).val(nbr);
            $("#recapNbrEnfLeg").html(nbr);
        }
    });
    $(btnPlus_1).click(function() {
        var nbr = $(nbrEnfLeg).val();
        nbr = eval((nbr*1)+1);
        $(nbrEnfLeg).val(nbr);
        $("#recapNbrEnfLeg").html(nbr);
    });
    $(nbrEnfLeg).keydown(function() {
        if(!isNumeric($(nbrEnfLeg).val())) {}
    });
    
    //nbre d'enfants en charge
    $(btnMoins_2).click(function() {
        if($(nbrPersAcharge).val() > 0) {
            var nbr = $(nbrPersAcharge).val();
            nbr = eval((nbr*1)-1);
            $(nbrPersAcharge).val(nbr);
            $("#recapNbrEnfCharge").html(nbr);
        }
    });
    $(btnPlus_2).click(function() {
        var nbr = $(nbrPersAcharge).val();
        nbr = eval((nbr*1)+1);
        $(nbrPersAcharge).val(nbr);
        $("#recapNbrEnfCharge").html(nbr);
    });
    
    if(sexe[0].checked) {
        $("#recapSexe").html($(sexe[0]).next().text());
    }
    else if(sexe[1].checked) {
        $("#recapSexe").html($(sexe[1]).next().text());
    }
    else {$("#recapSexe").html("Undefined");}
    
    // ======== Affichage du recapitulatif des infos ==============
    $("#todoForm\\:nom").change(function() {
        $("#recapNom").html($("#todoForm\\:nom").val());
    });
    $("#todoForm\\:prenom").change(function() {
        $("#recapPrenom").html($("#todoForm\\:prenom").val());
    });
    //Recuperer le sexe
    $(sexe).change(function() {
        if(sexe[0].checked) {
            $("#recapSexe").html($(sexe[0]).next().text());
        }
        else if(sexe[1].checked) {
            $("#recapSexe").html($(sexe[1]).next().text());
        }
        else {$("#recapSexe").html("Undefined");}
    });

    $("#todoForm\\:dateNaissance").change(function() {
        $("#recapDateNais").html($("#todoForm\\:dateNaissance").val());
    });
    $("#todoForm\\:lieuNaissance").change(function() {
        $("#recapLieuNais").html($("#todoForm\\:lieuNaissance").val());
    });
    $("#todoForm\\:ville").change(function() {
        $("#recapVilleResi").html($("#todoForm\\:ville").val());
    });
    $("#todoForm\\:langue1").change(function() {
        $("#recapLangue1").html($("#todoForm\\:langue1").val());
    });
    $("#todoForm\\:telephone").change(function() {
        $("#recapTel").html($("#todoForm\\:telephone").val());
    });
    $("#todoForm\\:ncni").change(function() {
        $("#recapNumCni").html($("#todoForm\\:ncni").val());
    });
    $("#todoForm\\:datecni").change(function() {
        $("#recapDateCni").html($("#todoForm\\:datecni").val());
    });
    $("#todoForm\\:lieuCni").change(function() {
        $("#recapLieuCni").html($("#todoForm\\:lieuCni").val());
    });
    $("#todoForm\\:email").change(function() {
        $("#recapEmail").html($("#todoForm\\:email").val());
    });
    $("#todoForm\\:bp").change(function() {
        $("#recapAdr").html($("#todoForm\\:bp").val());
    });
    $("#todoForm\\:nomMere").change(function() {
        $("#recapNomMere").html($("#todoForm\\:nomMere").val());
    });
    $("#todoForm\\:residMere").change(function() {
        $("#recapResiMere").html($("#todoForm\\:residMere").val());
    });
    $("#todoForm\\:nomPere").change(function() {
        $("#recapNomPere").html($("#todoForm\\:nomPere").val());
    });
    $("#todoForm\\:residPere").change(function() {
        $("#recapResiPere").html($("#todoForm\\:residPere").val());
    });
    $("#todoForm\\:situationMat").change(function() {
        var sitMat = $("#todoForm\\:situationMat");
        $("#recapSituationMat").html(sitMat.val());
        if(sitMat.val() === "Marié(e)") {
            regMat.show(390);
            $("#recapRegimeMat").parent().parent().parent().parent().show();
            conjoint.show(400);
            $("#recapConjoint").parent().parent().parent().parent().show();
        }
        else {
            regMat.hide(390);
            $("#recapRegimeMat").parent().parent().parent().parent().hide();
            conjoint.hide(400);
            $("#recapConjoint").parent().parent().parent().parent().hide();
        }
    });
    $("#todoForm\\:regimeMat").change(function() {
        $("#recapRegimeMat").html($("#todoForm\\:regimeMat").val());
    });
    $("#todoForm\\:conjoint").blur(function() {
        $("#recapConjoint").html($("#todoForm\\:conjoint").val());
    });
    $("#todoForm\\:nbrEnfantLeg").change(function() {
        $("#recapNbrEnfLeg").html($("#todoForm\\:nbrEnfantLeg").val());
    });
    $("#todoForm\\:nbrPersAcharge").change(function() {
        $("#recapNbrEnfCharge").html($("#todoForm\\:nbrPersAcharge").val());
    });
    $("#todoForm\\:activitePro").change(function() {
        $("#recapActivProf").html($("#todoForm\\:activitePro").val());
    });
    $("#todoForm\\:lieuExerciceActivitePro").change(function() {
        $("#recapLieuExercActiv").html($("#todoForm\\:lieuExerciceActivitePro").val());
    });
    $("#todoForm\\:employeur").change(function() {
        $("#recapEmpl").html($("#todoForm\\:employeur").val());
    });
    $("#todoForm\\:adresseEmployeur").change(function() {
        $("#recapAdrEmpl").html($("#todoForm\\:adresseEmployeur").val());
    });
    $("#todoForm\\:raisonAdh").change(function() {
        $("#recapRaisonAdh").html($("#todoForm\\:raisonAdh").val());
    });
    $("#todoForm\\:dateIns").change(function() {
        $("#recapDateIns").html($("#todoForm\\:dateIns").val());
    });
    $("#todoForm\\:lieuIns").change(function() {
        $("#recapLieuAdh").html($("#todoForm\\:lieuIns").val());
    });
});

function trait(data) {
    var status = data.status; // Can be "begin", "complete" or "success".
    var source = data.source; // The parent HTML DOM element.

    switch (status) {
        case "begin": // Before the ajax request is sent.
            showImage();
            break;

        case "complete": // After the ajax response is arrived.
            hideImage();
            break;

        case "success": // After update of HTML DOM based on ajax response.
            // ...
            break;
    }

}

function showImage(){
    document.getElementById("todoForm:loader").style.display="";
}

function hideImage(){
    document.getElementById("todoForm:loader").style.display="none";
    document.getElementById("todoForm:terminer").style.display="none";
    document.getElementById("todoForm:l7").style.display="";
}

function checked(){
    var ch =  document.getElementById("confirmation").checked;
    if(!ch){
        alert("Veuiller confirmer vos informations avant de les soumettre, en cochant la case");
        return false;
    }
}


function checkMail(mail){
    var emailRegex = /^([a-z0-9A-Z._-]+)@([a-z0-9._-]+)\.([a-z]{2,6})$/;
    return emailRegex.test(mail);
}

function isNumeric(val) {
    //var nbr = new Array("1", "2", "3", "4", "5", "6", "7", "8", "9",)
    var numRegex = /^([0-9])$/;
    return numRegex.test(val);
}

/* Erreur obtenu
 * serverError: class javax.faces.el.EvaluationException Bean Validation constraint(s) violated while executing Automatic Bean Validation on callback event:'prePersist'. Please refer to embedded ConstraintViolations for details.
 */