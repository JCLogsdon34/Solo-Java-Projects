/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    // Add Button onclick handler
    $('#search-button').click(function (event) {

        $.ajax({
            type: 'POST',
            url: 'search/contacts',
            data: JSON.stringify({
                name: $('#search-name').val(),
                title: $('#search-title').val(),
                phoneNumber: $('#search-phone-number').val(),
                webAddress: $('#search-web-address').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function (data) {
                // clear errorMessages
                $('#errorMessages').empty();
                fillContactTable(data);
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text('Error calling web service.  Please try again later.'));
            }
        });
    });
});

function fillContactTable(data) {
    // we need to clear the previous content so we don't append to it
    clearContactTable();

    // grab the the tbody element that will hold the rows of contact information
    var contentRows = $('#contentRows');

    $.each(data, function (index, contact) {
        var name = contact.name;
        var title = contact.title;
        var phoneNumber = contact.phoneNumber;
        var webAddress = contact.webAddress;

        var row = '<tr>';
        row += '<td>' + name + '</td>';
        row += '<td>' + title + '</td>';
        row += '<td>' + phoneNumber + '</td>';
        row += '<td>' + webAddress + '</td>';
        row += '</tr>';
        contentRows.append(row);
    });
}

function clearContactTable() {
    $('#contentRows').empty();
}



