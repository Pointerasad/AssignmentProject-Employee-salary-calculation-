/**
 * Created by User on 12/17/2020.
 */
$(document).ready(function () {

    $("#accountId").change(function () {
        //id_courses
        var accId= $('#accountId').val();
       if(accId!='') {
           $.ajax({
               url: 'get-list',
               data: {instId: $("#accountId").val()},
               success: function (data) {
                   console.log(data);
                   $('#currency').val('Tk');
                   $('#avBalance').val(data.availableAmt);
                   $('#clientAccName').val(data.accountName);

               }
           });
       }else{
           $('#currency').val('');
           $('#avBalance').val('');
           $('#clientAccName').val('');
        }

    });

});