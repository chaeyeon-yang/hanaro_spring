
// JSON (JavaScript Object Notation)
var datas = [
    {"id":"id01","name":"wonpil"},
    {"id":"id02","name":"yonghyun"},
    {"id":"id03","name":"sungjin"},
    {"id":"id04","name":"dowoon"},
    {"id":"id05","name":"chaeyeon"}
];
let html2 = {
    init: function () {
        $('#btn').click(function () {
            // this.display(datas);
            html2.display(datas);
        })
    },
    display: function (datas) {
        let result = ''
        $(datas).each(function (index, data) {
            result += '<tr>';
            result += '<td>' +data.id+'</td>';
            result += '<td>' +data.name+'</td>';
            // result += '<td>' +data.id+'</td>';
            result += '</tr>';
        });
        $('#cust_tb > tbody').html(result)
    }
}

let login = {
    init: function () {
        $('#login_form > button').click(function (){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            if (id == '' || id == null) {
                alert('ID를 입력하세요');
                $('#id').focus();
                return;
            }
            if (pwd == '' || pwd == null) {
                alert('PWD를 입력하세요');
                $('#pwd').focus();
                return;
            }
            login.send();
        });
    },
    send: function () {
        $('#login_form').attr({
            'method':'post',
            'action':'/loginimpl'
        });
        $('#login_form').submit();
    }
}