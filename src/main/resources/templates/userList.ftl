<!DOCTYPE html>
<html lang="en">
<head>
    <title>Phone Book</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="mindmup-editabletable.js"></script>
</head>
<body>

<div class="container">
    <h2>Phone Book</h2>
    <h3>Users and their Phones:</h3>
    <table class="table table-striped" data-toggle="validator">
        <thead>
        <tr>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Type</th>
            <th>Comment</th>
        </tr>
        </thead>

        <tbody>
        <#list users as user>
        <tr>
            <td data-name="phoneId" hidden>${user.phone.id}</td>
            <td data-name="changed" hidden>false</td>
            <td data-name="userName" onmousedown="return false" onselectstart="return false">${user.name}</td>
            <td data-name="phoneNumber">${user.phone.phoneNumber}</td>
            <td data-name="phoneType">
                <select style="width: 100%">
                    <#list phoneTypes as phoneType>
                        <option value="${phoneType}" <#if phoneType == user.phone.phoneType>selected="selected"</#if>>
                        ${phoneType}
                        </option>
                    </#list>
                </select>
            </td>
            <td data-name="phoneComment">${user.phone.comment}</td>
        </tr>
        </#list>
        </tbody>
    </table>

    <button class="submit-btn" type="button">Submit</button>
    <p style="margin-top: 20px">To edit phones, change one or more fields, and click "Submit".</p>

</div>

<script>
    $('document').ready(function () {
        $('.table').editableTableWidget();

        $('.submit-btn').on('click', function () {
            var res = [];
            $('tbody tr').each(function () {
                $this = $(this);
                var data = {
                    id: $this.find('td[data-name="phoneId"]').html(),
                    phoneNumber: $this.find('td[data-name="phoneNumber"]').html(),
                    phoneType: $this.find('td[data-name="phoneType"]').find('option:selected').val(),
                    comment: $this.find('td[data-name="phoneComment"]').html()
                };
                console.log(data);
                res.push(data);
            });

            $.ajax({
                type: 'POST',
                url: '/phones',
                data: JSON.stringify(res),
                contentType: "application/json",
                dataType: 'json'
            });
        })
    })
</script>
</body>
</html>