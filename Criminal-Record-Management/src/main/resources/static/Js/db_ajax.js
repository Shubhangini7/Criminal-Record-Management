function fetchCriminal()
{
    var criminalName = $("#criminal").val();
    $.post(
        "/searchCriminal",
        {cn:criminalName},
        function (data) {
            $("#search_place").html(data);
        }
    )
}
