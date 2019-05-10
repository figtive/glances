console.log('ready');
$(document).ready(function () {
        $('.city-query-submit').click(function () {
            let term = $('.city-query').val();
            $.ajax({
                url: "getcityid?city=" + term,
                type: "GET",
                success: function (result) {
                    $(".city-list-item").remove();
                    let optionSelector = $("#cityGroupOption");
                    if (result.length > 0) {
                        for (let i = 0; i < result.length; i++) {
                            optionSelector.append(
                                "    <option class='city-list-item' value=\"" + result[i]["id"] + "\">" + result[i]["name"] + " " + result[i]["coord"]["lon"] + ", " + result[i]["coord"]["lat"] + "</option>\n"
                            )
                        }
                        optionSelector.removeAttr("disabled");
                        $("#city-selection-button").removeAttr("disabled")
                    } else {
                        optionSelector.attr("disabled", "");
                        $("#city-selection-button").attr("disabled", "")
                    }
                }
            })
        });
        $("#city-selection-button").click(function () {
            let selectedCityId = $("#cityGroupOption").children("option:selected").val();
            let weatherData = {};
            $.ajax({
                url: "weathercheck?cityId=" + selectedCityId,
                success: function (result) {
                    if (result["valid"] === true) {
                        $.ajax({
                            url: "getweather?cityId=" + selectedCityId,
                            success: function (result) {
                                $(".weather-info-item").remove();
                                console.log(result);
                                weatherData = result;
                                console.log(weatherData);
                                $("#weather-display").append(
                                    "                <span class=\"weather-info-item\">" + weatherData["name"] + "<br></span>\n" +
                                    "                <span class=\"weather-info-item\">" + weatherData["weather"][0]["main"] + ", " + weatherData["weather"][0]["description"] + "<br></span>\n" +
                                    "                <span class=\"weather-info-item\">Temperature: " + weatherData["main"]["temp"] + "</span>\n"
                                )
                            }
                        })
                    } else {
                        $.ajax({
                            url: "https://api.openweathermap.org/data/2.5/weather?&id=" + selectedCityId + "&appId=0d6924c4e1929aa81a8f8fa9b54a597a&units=metric",
                            success: function (result) {
                                weatherData = result;
                                $.ajax({
                                    url: "postweather",
                                    data: JSON.stringify(weatherData),
                                    method: "POST",
                                    dataType: "json",
                                    contentType: "application/json",
                                    success: function () {
                                        console.log("post weather to database successful");
                                        console.log(weatherData);
                                        $("#weather-display").append(
                                            "                <span class=\"weather-info-item\">" + weatherData["name"] + "<br></span>\n" +
                                            "                <span class=\"weather-info-item\">" + weatherData["weather"][0]["main"] + ", " + weatherData["weather"][0]["description"] + "<br></span>\n" +
                                            "                <span class=\"weather-info-item\">Temperature: " + weatherData["main"]["temp"] + "</span>\n"
                                        )
                                    }
                                });
                            }
                        })
                    }
                }
            });
        });

        let noteCounter = 0;
        let nameArray = [];
        $.ajax({
            url: "note/getall",
            success: function (result) {
                let tabSelector = $("#note-list-tab");
                let detailSelector = $("#note-list-detail");
                for (let i = 0; i < result.length; i++) {
                    tabSelector.append(
                        "                        <a class=\"list-group-item list-group-item-action\" id=\"list-" + i + "-list\" data-toggle=\"list\" href=\"#list-" + i + "\" role=\"tab\" aria-controls=\"" + i + "\">" + result[i]["name"] + "</a>\n"
                    );
                    detailSelector.append(
                        "                        <div class=\"tab-pane fade\" id=\"list-" + i + "\" role=\"tabpanel\" aria-labelledby=\"list-" + i + "-list\"><span>" + result[i]["detail"] + "</span><br><button type='button' class='btn btn-outline-danger mt-3 delete-note' role='button' value='" + i + "'>Delete</button></div>\n"
                    );
                    noteCounter++;
                    nameArray[nameArray.length] = result[i]["name"];
                }
                $(".delete-note").click(function () {
                    let num = $(this).val();
                    let nameSelector = $("#list-" + num + "-list");
                    let nameText = nameSelector.text();
                    $.ajax({
                       url: "note/delete?name=" + nameText,
                        success: function (result) {
                            if (result["success"]) {
                                nameSelector.remove();
                                $("#list-" + num).remove();
                                let index = nameArray.indexOf(nameText);
                                nameArray.splice(index, 1)
                            }
                        }
                    });
                });
            }
        });
        $("#note-add-submit").click(function () {
            let noteName = $("#add-note-name").val();
            let noteDetail = $("#note-add-detail").val();
            if (noteName.length > 0 && noteDetail.length > 0 && !nameArray.includes(noteName)) {
                $.ajax({
                    url: "note/post",
                    data: JSON.stringify({"name": noteName, "detail": noteDetail}),
                    method: "POST",
                    dataType: "json",
                    contentType: "application/json",
                    success: function (result) {
                        console.log(nameArray);
                        console.log(noteName);
                        nameArray[nameArray.length] = noteName;
                        let tabSelector = $("#note-list-tab");
                        let detailSelector = $("#note-list-detail");
                        tabSelector.append(
                            "                        <a class=\"list-group-item list-group-item-action\" id=\"list-" + noteCounter + "-list\" data-toggle=\"list\" href=\"#list-" + noteCounter + "\" role=\"tab\" aria-controls=\"" + noteCounter + "\">" + result["name"] + "</a>\n"
                        );
                        detailSelector.append(
                            "                        <div class=\"tab-pane fade\" id=\"list-" + noteCounter + "\" role=\"tabpanel\" aria-labelledby=\"list-" + noteCounter + "-list\"><span>" + result["detail"] + "</span><br><button type='button' class='btn btn-outline-danger mt-3 delete-note' role='button' value='" + noteCounter + "'>Delete</button></div>\n"
                        );
                        noteCounter++;
                        $(".delete-note").click(function () {
                            let num = $(this).val();
                            let nameSelector = $("#list-" + num + "-list");
                            let nameText = nameSelector.text();
                            $.ajax({
                                url: "note/delete?name=" + nameSelector.text(),
                                success: function (result) {
                                    if (result["success"]) {
                                        nameSelector.remove();
                                        $("#list-" + num).remove();
                                        let index = nameArray.indexOf(nameText);
                                        nameArray.splice(index, 1)
                                    }
                                }
                            });
                        });
                    }
                })
            }
        })
    }
);