/*! AdminLTE Perso
* @Author  Benjisolo
*/

/* global moment */

$(function() {
    var checkBoxMembre = document.getElementById("userForm:dataTable").getElementsByTagName("input");
    var checkBoxAll = document.getElementById("cheche");
    
    $(checkBoxAll).click(function() {
        if(this.checked) {
            for(var i=0; i<=checkBoxMembre.length; i++) {
                checkBoxMembre[i].checked = true;
                toggleBtnTrash("show"); 
            }
        }
        else {
            for(var i=0; i<=checkBoxMembre.length; i++) {
                checkBoxMembre[i].checked = false;
                toggleBtnTrash("hide"); 
            }
        }
    });
    toggleBtnTrash("hide"); 
    
    /*
    //Initialize Select2 Elements
    $('.select2').select2();

    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' });
    //Datemask2 mm/dd/yyyy
    $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' });
    //Money Euro
    $('[data-mask]').inputmask();

    //Date range picker
    $('#reservation').daterangepicker();
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' });
    //Date range as a button
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate  : moment()
      },
      function (start, end) {
        $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
      }
    );

    //Date picker
    $('#datepicker').datepicker({
      autoclose: true
    });

    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass   : 'iradio_minimal-blue'
    });
    //Red color scheme for iCheck
    $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
      checkboxClass: 'icheckbox_minimal-red',
      radioClass   : 'iradio_minimal-red'
    });
    //Flat red color scheme for iCheck
    $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
      checkboxClass: 'icheckbox_flat-green',
      radioClass   : 'iradio_flat-green'
    });

    //Colorpicker
    $('.my-colorpicker1').colorpicker();
    //color picker with addon
    $('.my-colorpicker2').colorpicker();

    //Timepicker
    $('.timepicker').timepicker({
      showInputs: false
    });*/
});

function isAllChecked(dataTable) {
    var checkBox = document.getElementById(dataTable).getElementsByTagName("input");
    var unchecked = false;
    toggleBtnTrash("hide");  
    for(var i=1; i<checkBox.length; i++) {
        if(!checkBox[i].checked) {
            unchecked = true;
        }
        else {
            toggleBtnTrash("show"); 
       }
    }
    if(unchecked) {
        document.getElementById("cheche").checked = false;
    }
    else {
        document.getElementById("cheche").checked = true;
    }
}

function toggleBtnTrash(value) {
    if(value==="show")
        $("#userForm\\:btn-trash").show();
    else 
        $("#userForm\\:btn-trash").hide();
}
