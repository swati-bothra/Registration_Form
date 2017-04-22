$(document).ready(function () {
    $("#loginfrm").validate({
        rules: {
            "txtUsername": {required: true},
            "txtPwd": {required: true}

        },
        messages: {
            "txtUsername": {required: "plz enter username"},
            "txtPwd": {required: "plz enter pwd"}

        }
    });
});