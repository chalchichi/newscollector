function dataSend() {

    var data=$("#uri").val();
    var Collection_VO={
        uri:data,
        account:1
    };

    $.ajax({
        url: "localhost:8080/Save",
        data: Collection_VO,
        type:"POST",
    }).done(function (fragment) {
        $("#resultDiv").replaceWith(fragment);
    });
}