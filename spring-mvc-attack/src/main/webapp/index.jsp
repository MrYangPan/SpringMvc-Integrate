<html>
<body>
<h2>Hello World!</h2>
<a href="region_del?name=zhang">Delete</a>

<input type="hidden" value="${CSRFToken}"/>

</body>
<script type="text/javascript">

    //  AJAX POST的CSRF防御
    var headers = {};
    headers['__RequestVerificationToken'] = $("#CSRFToken").val();

    $.ajax({
        type: "POST",
        headers: headers,
        cache: false,
        url: base + "ajax/domain/delete.do",
        data: "id=123",
        dataType: "json",
        async: true,
        error: function (data, error) {
        },
        success: function (data) {
        }
    });

</script>
</html>
