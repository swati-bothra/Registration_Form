$(document).ready(function () {
    $("#empfrm").validate({
        rules: {
            "txtEmpFname": {required: true},
            "txtEmpLname": {required: true},
            "txtEmail": {required: true},
            "txtMob": {required: true},
            "txtDob": {required: true},
            "txtAddress": {required: true},
            "selCity": {required: true},
            "txtHobby": {required: true},
            "txtGender": {required: true}
        },
        messages: {
            "txtEmpFname": {required: "plz enter Emp Fname"},
            "txtEmpLname": {required: "plz enter Emp Lname"},
            "txtEmail": {required: "plz enter Email"},
            "txtMob": {required: "plz enter Mobile No"},
            "txtDob": {required: "plz enter Dob"},
            "txtAddress": {required: "plz enter Address"},
            "selCity": {required: "plz enter City"},
            "txtHobby": {required: "plz select Hobby"},
            "txtGender": {required: "plz select Gender"}
        }
    });
});