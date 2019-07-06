$(document).ready(function(){



    initTable();


});

/**
 * 初始化表格
 */
function  initTable(){
    $.ajax({
        type : "POST",
        data : {},
        dataType:"json",
        url : contextPath+'index/getInitData',
        success: function(result){
            console.log(result);
            $('#tbody').html(null);
            var trs = '';
            for (var i = 0; i < result.length; i++) {
                var info = result[i];
                var tds = '<tr><td id="'+info.accountNum+'_name">'+info.name+'</td>\n' +
                    '<td id="'+info.accountNum+'_accountNum">'+info.accountNum+'</td>\n' +
                    '<td id="'+info.accountNum+'_totalAmount">'+info.totalAmount+'</td>\n' +
                    '<td id="'+info.accountNum+'_transTime">'+info.transTime+'</td>\n' +
                    '<td id="'+info.accountNum+'_expenditureIncomeState">'+info.expenditureIncomeState+'</td>\n' +
                    '<td id="'+info.accountNum+'_amount">'+info.amount+'</td></tr>';
                trs += tds;
            }
            $('#tbody').html(trs);
        }
    });
}


