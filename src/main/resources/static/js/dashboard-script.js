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
            $(".weather-info-item").remove();
            $.ajax({
                url: "weathercheck?cityId=" + selectedCityId,
                success: function (result) {
                    if (result["valid"] === true) {
                        $.ajax({
                            url: "getweather?cityId=" + selectedCityId,
                            success: function (result) {
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
        })
    }
);