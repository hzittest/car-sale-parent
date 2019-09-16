var pName;

$(function () {
    /*获取工程名称*/
    var projectName = $('#projectName').attr('project');
    console.log(projectName);
    pName = projectName;
    var but_login = $('#but_login');//登录按钮
    var CompanyName_login = $('#companyName_login');//公司名称
    var PositionName_login = $('#PositionName_login');//职务名称
    var EmpName_login = $('#EmpName_login');//员工名称
    var PhoneNumber_login = $('#PhoneNumber_login');//员工电话
    var Password_login = $('#Password_login');//密码


    /*加载公司信息*/
    getCompany();

    /*电话正则表达式*/
    var telphonePar = /^1[3|4|5|7|8][0-9]{9}$/;

    /*同步验证用户信息*/
    $('#but_login').click(function () {
        console.log("同步验证用户信息");
        //各种框是空的情况
        console.log($.isEmptyObject(CompanyName_login.val()));
        if ($.isEmptyObject(CompanyName_login.val())
            || 0 == (PositionName_login.val())
            //|| $.isEmptyObject(EmpName_login.val())
            //|| $.isEmptyObject(PhoneNumber_login.val())
            || $.isEmptyObject(Password_login.val())) {
            alert("输入框不能为空！");
        } else {
            var companyId = CompanyName_login.val();
            var positionName_login = PositionName_login.val();
            var empName = EmpName_login.val();
            var phoneNumber_login = PhoneNumber_login.val();
            var password_login = Password_login.val();

            /*var psw = $.md5(password_login);//md5加密*/

            //发起登录请求，远程请求校验
            //1.校验用户名是否存在该公司，和职位匹配
            $.getJSON(projectName + "/emp/isEmpExist?empName=" + empName + "&companyId=" + companyId + "&posiId=" + positionName_login, function (result) {

                if (result == 0) //验证失败
                {
                    console.log("用户名校验失败");
                    alert("用户名校验失败,请检查公司名称和职位!");
                    return;
                } else {
                    //2.根据用户名校验手机号
                    $.getJSON(projectName + "/emp/isPhoneExist?empName=" + empName + "&phone=" + phoneNumber_login, function (result) {
                        if (result == 0) {
                            console.log("手机号码和用户不匹配！");
                            alert("手机号码和用户不匹配！请检查");
                        }
                        else {
                            //3.发起请求登录，后台校验用户密码是否正确
                            $.post(projectName + "/emp/login", {
                                "empName": empName,
                                "pwd": password_login
                            }, function (result) {
                                if (result == 0) {
                                    console.log("用户名和密码错误！");
                                    alert("用户名和密码错误！请检查");
                                }
                                else {
                                    //成功
                                    console.log("成功！");
                                    alert("登录成功!");
                                    location.href = projectName+"/emp/goMain";
                                }
                            })

                        }

                    })


                }

            });


            /*发送get请求获取公司编号*/
            // $.getJSON(
            //     projectName + '/login/getCompanyId.action',
            //     {companyName: companyName},
            //     function (data) {
            //         var companyId = data.companyId;
            //
            //         /*发送post请求验证用户*/
            //         $.post(projectName + '/login/isLoginSuccess.action',
            //             { companyId: companyId, positionId: positionName_login,
            //                 empName: empName, empPhone:phoneNumber_login, empPassword: password_login },
            //             function(data){
            //                 var resultValue = data.resultLogin;
            //                 if ("false" == resultValue){
            //                     alert("登录失败,请查证后重试！");
            //                     location.reload();
            //                 } else {
            //                     console.log("登录成功！");
            //                     location.href = projectName + '/login/goMain.action?empId=' + resultValue;
            //                 }
            //             }, "json");
            //
            //     });
        }
    });


    /*异步判断企业名称是否存在*/
    // $('#CompanyName_login').blur(function () {
    //     var companyName = $(this).val();
    //     console.log(companyName);
    //
    //     /*ajax获取查询的json数据*/
    //     $.getJSON(
    //         projectName + '/login/isExistCompanyName.action',
    //         {companyName: companyName},
    //         function (json) {
    //             var resultName = json.resultName;
    //             if ("true" == resultName) {
    //                 //如果是true代表公司名称正确
    //                 CompanyName_login.removeAttr("style");
    //                 //解除按钮禁止
    //                 but_login.attr('class', 'btn btn-default submit');
    //             } else {
    //                 //如果是false代表公司名称错误
    //                 CompanyName_login.attr('style', 'border: red 2px solid');
    //                 //禁止提交按钮点击
    //                 but_login.attr('class', 'btn btn-danger disabled');
    //             }
    //         });
    // });

    /*异步判断员工姓名是否正确*/
    // $('#EmpName_login').blur(function () {
    //     var empName = $(this).val();
    //     console.log(empName);
    //
    //     /*ajax获取查询的json数据*/
    //     $.getJSON(
    //         projectName + '/login/isExistEmpName.action',
    //         {empName: empName},
    //         function (json) {
    //             var resultName = json.resultName;
    //             if ("true" == resultName) {
    //                 //如果是true代表员工名称正确
    //                 EmpName_login.removeAttr("style");
    //                 //解除按钮禁止
    //                 but_login.attr('class', 'btn btn-default submit');
    //             } else {
    //                 //如果是false代表员工名称错误
    //                 EmpName_login.attr('style', 'border: red 2px solid');
    //                 //禁止提交按钮点击
    //                 but_login.attr('class', 'btn btn-danger disabled');
    //             }
    //         });
    // });

    /*异步判断员工电话是否正确*/
    // $('#PhoneNumber_login').blur(function () {
    //     var empPhone = $(this).val();
    //     console.log(empPhone);
    //     var companyName = CompanyName_login.val();
    //     console.log(companyName);
    //     /*发送get请求获取公司编号*/
    //     $.getJSON(
    //         projectName + '/login/getCompanyId.action',
    //         {companyName: companyName},
    //         function (data) {
    //             var companyId = data.companyId;
    //             console.log(companyId);
    //             /*ajax获取查询的json数据*/
    //             $.getJSON(
    //                 projectName + '/login/isExistEmpPhone.action',
    //                 {companyId: companyId,empPhone: empPhone},
    //                 function (json) {
    //                     var resultName = json.resultName;
    //                     if ("true" == resultName) {
    //                         //如果是true代表员工电话正确
    //                         PhoneNumber_login.removeAttr("style");
    //                         //解除按钮禁止
    //                         but_login.attr('class', 'btn btn-default submit');
    //                     } else {
    //                         //如果是false代表员工电话错误
    //                         PhoneNumber_login.attr('style', 'border: red 2px solid');
    //                         //禁止提交按钮点击
    //                         but_login.attr('class', 'btn btn-danger disabled');
    //                     }
    //                 });
    //         });
    //
    // });

});

function getCompany() {
    $.getJSON(pName + "/company/list", function (result) {
        $.each(result, function (index, company) {
            var option = "<option value='" + company.companyId + "'>" + company.companyName + "</option>";
            $("#companyName_login").append($(option));
        })
    });

}