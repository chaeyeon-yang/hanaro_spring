

let login = {
    url:'',
    init:function(url){
        this.url = url;
        $('#login_form > button').click(function(){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            if(id == '' || id == null){
                alert('ID를 입력 하세요');
                $('#id').focus();
                return;
            }
            if(pwd == '' || pwd == null){
                alert('PWD를 입력 하세요');
                $('#pwd').focus();
                return;
            }
            login.send();
        });
    },
    send:function(){
        $('#login_form').attr({
            'method':'post',
            'action':this.url
        });
        $('#login_form').submit();
    }
};
let register = {
    url:'',
    init:function(url){
        this.url = url;
        $('#register_form > button').click(function(){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            let name = $('#name').val();
            if(id == '' || id == null){
                alert('ID를 입력 하세요');
                $('#id').focus();
                return;
            }
            if(pwd == '' || pwd == null){
                alert('PWD를 입력 하세요');
                $('#pwd').focus();
                return;
            }
            if(name == '' || name == null){
                alert('NAME를 입력 하세요');
                $('#name').focus();
                return;
            }
            register.send();
        });
    },
    send:function(){
        $('#register_form').attr({
            'method':'post',
            'action':this.url
        });
        $('#register_form').submit();
    }
};
// JSON (JavaScript Object Notation)
let datas = [
    {"id":"id01","name":"james1"},
    {"id":"id02","name":"james2"},
    {"id":"id03","name":"james3"},
    {"id":"id04","name":"james4"},
    {"id":"id05","name":"james5"}
];
let html2 = {

    init:function (){
        $('#btn').click(function(){
            html2.display(datas);
        });
    },
    display:function(datas){
        let result = '';
        $(datas).each(function(index, data){
            result += '<tr>';
            result += '<td>'+data.id+'</td>';
            result += '<td>'+data.name+'</td>';
            result += '</tr>';
        });
        $('#cust_tb > tbody').html(result);
    }
};

let addrRegister = {
    url:'',
    init:function(url){
        this.url = url;
        $(".addr_register > #addr_register_btn").click(function(){
            let addrName = $('#addrName').val();
            let addrDetail = $('#addrDetail').val();

            if(addrName == '' || addrName == null){
                alert('주소명을 입력 하세요');
                $('#addrName').focus();
                return;
            }
            if(addrDetail == '' || addrDetail == null){
                alert('상세 주소를 입력 하세요');
                $('#addrDetail').focus();
                return;
            }
            addrRegister.send();
        });
    },
    send:function(){
        $('.addr_register').attr({
            'method':'post',
            'action':this.url
        });
        $('.addr_register').submit();
    }
};

let boardRegister = {
    init:function(){
        $('#board_register_form > button').click(function(){

            let c = confirm('게시하시겠습니까?');
            if(c == true){
                let title = $('#title').val();
                let content = $('#content').val();
                if(title == '' || title == null){
                    alert('제목을 입력 하세요');
                    $('#title').focus();
                    return;
                }
                if(content == '' || content == null){
                    alert('내용을 입력 하세요');
                    $('#content').focus();
                    return;
                }
            }

            boardRegister.send();
        });
    },
    send:function(){
        $('#board_register_form').attr({
            'method':'post',
            'action': '/board/addimpl'
        });
        $('#board_register_form').submit();
    }
};

