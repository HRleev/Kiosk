const countDown = (item_num) => {
  const number = document.getElementById('number_' + item_num).value; 

  if (number < 1) {
    return false;
  } else {
    const total_price = document.getElementById('total-price');
    const total_price_num = parseInt(total_price.innerHTML)

    switch (item_num) {
      case 1:
        const order_1 = document.getElementById('order_1');
        const price_1 = parseInt(order_1.innerHTML);
        order_1.innerHTML = price_1 - 2500;
        total_price.innerHTML = parseInt(total_price_num - 2500);
        break;
      case 2:
        const order_2 = document.getElementById('order_2');
        const price_2 = parseInt(order_2.innerHTML);
        order_2.innerHTML = price_2 - 2500;
        total_price.innerHTML = parseInt(total_price_num - 2500);
        break;
      case 3:
        const order_3 = document.getElementById('order_3');
        const price_3 = parseInt(order_3.innerHTML);
        order_3.innerHTML = price_3 - 2500;
        total_price.innerHTML = parseInt(total_price_num - 2500);
        break;
      case 4:
        const order_4 = document.getElementById('order_4');
        const price_4 = parseInt(order_4.innerHTML);
        order_4.innerHTML = price_4 - 2500;
        total_price.innerHTML = parseInt(total_price_num - 2500);
        break;
      case 5:
        const order_5 = document.getElementById('order_5');
        const price_5 = parseInt(order_5.innerHTML);
        order_5.innerHTML = price_5 - 2500;
        total_price.innerHTML = parseInt(total_price_num - 2500);
        break;
      case 6:
        const order_6 = document.getElementById('order_6');
        const price_6 = parseInt(order_6.innerHTML);
        order_6.innerHTML = price_6 - 2500;
        total_price.innerHTML = parseInt(total_price_num - 2500);
        break;
      default:
        break;
    }
  }
}

const countUp = (item_num) => {
  const number = document.getElementById('number_' + item_num).value; 
  const total_price = document.getElementById('total-price');
  const total_price_num = parseInt(total_price.innerHTML);

  switch (item_num) {
    case 1:
      const order_1 = document.getElementById('order_1');
      const price_1 = parseInt(order_1.innerHTML);
      order_1.innerHTML = price_1 + 2500;
      total_price.innerHTML = parseInt(total_price_num + 2500);
      break;
    case 2:
      const order_2 = document.getElementById('order_2');
      const price_2 = parseInt(order_2.innerHTML);
      order_2.innerHTML = price_2 + 2500;
      total_price.innerHTML = parseInt(total_price_num + 2500);
      break;
    case 3:
      const order_3 = document.getElementById('order_3');
      const price_3 = parseInt(order_3.innerHTML);
      order_3.innerHTML = price_3 + 2500;
      total_price.innerHTML = parseInt(total_price_num + 2500);
      break;
    case 4:
      const order_4 = document.getElementById('order_4');
      const price_4 = parseInt(order_4.innerHTML);
      order_4.innerHTML = price_4 + 2500;
      total_price.innerHTML = parseInt(total_price_num + 2500);
      break;
    case 5:
      const order_5 = document.getElementById('order_5');
      const price_5 = parseInt(order_5.innerHTML);
      order_5.innerHTML = price_5 + 2500;
      total_price.innerHTML = parseInt(total_price_num + 2500);
      break;
    case 6:
      const order_6 = document.getElementById('order_6');
      const price_6 = parseInt(order_6.innerHTML);
      order_6.innerHTML = price_6 + 2500;
      total_price.innerHTML = parseInt(total_price_num + 2500);
      break;
    default:
      break;
  }
}

const selectOption = (menu, price, menuFileName) => {
  $(".modal-body #menu").val(menu);
  $(".modal-body #price").val(price);
  $(".modal-body #menuFileName").attr("src", /upload/ + menuFileName);
  $(".modal-body #coffee-m").html(menu);
  $(".modal-body #coffee-p").html(price);
  $('#exampleModal').modal('show');
}

const coupon = () => {
  var mobile = document.getElementById("mobile").value;


  $.ajax({
    type: "delete",
    url: "/orderDelete",
    data: {},
    success: function () {
      $.ajax({
        type: "post",
        url: "/coupon",
        data: {
          "mobile": mobile
        },
        dataType: "text",
        success: function (result) {
          if (result != null) {
            $('#exampleModal1').modal('hide');
            document.getElementById("mobile").value = null;
            Swal.fire({
              text: '주문이 완료 되었습니다. 적립된 쿠폰은' + result + '개입니다.',
              showConfirmButton: false,
              timer: 2000
            }).then(function () {
              location.href = "/";
            });
          }
        }
      });
    }
  });
}

const orderDetail = () => {
  const menu = document.getElementById("menu").value;
  const price = document.getElementById("price").value;
  const orderItem = document.getElementById("order-item");
  const wonText = document.getElementById("won-text");
  var temp = $('input[name=temp]:checked').val();
  var shot = $('input[name=shot]:checked').val();

  $.ajax({
    type: "post",
    url: "/orderSave",
    data: {
      "menu": menu,
      "price": price,
      "temp": temp,
      "shot": shot
    },
    dataType: "json",
    success: function (result) {
      if (result != null) {
        $('#exampleModal').modal('hide');
        $("input:radio[name='temp']").prop('checked', false);
        $("input:radio[name='shot']").prop('checked', false);
        var output = "";

        for (let i in result) {
          output += "<div class=\"img-wrap\">" +
              "<img src=\"img/coffee.png\" alt=\"...\">" +
              "</div>" +
              "<div class=\"desc-wrap\">" +
              "<div class=\"name-wrap\">" +
              "<span>" + result[i].menu + "</span>" +
              "</div>" +
              "<div class=\"option-wrap\">";
          if (result[i].shot == "500") {
            output += "<span>" + "원샷" + "</span>";
          } else {
            output += "<span>" + "투샷" + "</span>";
          }
          output += "<span>" + result[i].temp + "</span>" +
              "</div>" +
              "</div>" +
              "<div class=\"mg-left-auto\">" +
              "<div class=\"number-input\">" +
              "<button onclick=\"this.parentNode.querySelector('input[type=number]').stepDown(); countDown(1);\" class=\"minus\"></button>" +
              "<input class=\"quantity\" id=\"number_1\" min=\"1\" name=\"quantity\" value=\"1\" type=\"number\">" +
              "<button onclick=\"this.parentNode.querySelector('input[type=number]').stepUp(); countUp(1);\" class=\"plus\"></button>" +
              "</div>" +
              "<div class=\"price-wrap\">" +
              "<span id=\"order_1\"></span>" +
              "<span></span>" +
              "</div>" +
              "</div>"+
              "<div class=\"price-wrap\">" +
              "<span>" + result[i].price + "</span>" +
              "<span></span>" +
              "</div>" +
              "<div class=\"delete-button-wrap\">" +
              "<svg onclick=\"cartDelete(" + result[i].id + ")\" xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"" +
              " fill=\"currentColor\" class=\"bi bi-x-circle-fill\" viewBox=\"0 0 16 16\">" +
              "<path d=\"M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 " +
              "8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z\"/>" +
              "</svg>" +
              "</div>";
        }
        $.ajax({
          type: "get",
          url: "/totalPrice",
          data: {},
          dataType: "text",
          success: function (str) {
            wonText.innerHTML = str;
            orderItem.innerHTML = output;
          }
        });
      }
    }
  });
}

const cartDelete = (id) => {
  const orderItem = document.getElementById("order-item");
  const wonText = document.getElementById("won-text");

  $.ajax({
    type: "delete",
    url: "/cartDelete",
    data: {
      "id": id
    },
    dataType: "json",
    success: function (result) {
      if (result != null) {
        var output = "";

        for (let i in result) {
          output += "<div class=\"img-wrap\">" +
              "<img src=\"img/coffee.png\" alt=\"...\">" +
              "</div>" +
              "<div class=\"desc-wrap\">" +
              "<div class=\"name-wrap\">" +
              "<span>" + result[i].menu + "</span>" +
              "</div>" +
              "<div class=\"option-wrap\">";
          if (result[i].shot == "500") {
            output += "<span>" + "원샷" + "</span>";
          } else {
            output += "<span>" + "투샷" + "</span>";
          }
          output += "<span>" + result[i].temp + "</span>" +
              "</div>" +
              "</div>" +
              "<div class=\"mg-left-auto\">" +
              "<div class=\"number-input\">" +
              "<button onclick=\"this.parentNode.querySelector('input[type=number]').stepDown(); countDown(1);\" class=\"minus\"></button>" +
              "<input class=\"quantity\" id=\"number_1\" min=\"1\" name=\"quantity\" value=\"1\" type=\"number\">" +
              "<button onclick=\"this.parentNode.querySelector('input[type=number]').stepUp(); countUp(1);\" class=\"plus\"></button>" +
              "</div>" +
              "<div class=\"price-wrap\">" +
              "<span id=\"order_1\"></span>" +
              "<span></span>" +
              "</div>" +
              "</div>"+
              "<div class=\"price-wrap\">" +
              "<span>" + result[i].price + "</span>" +
              "<span></span>" +
              "</div>" +
              "<div class=\"delete-button-wrap\">" +
              "<svg onclick=\"cartDelete(" + result[i].id + ")\" xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-x-circle-fill\" viewBox=\"0 0 16 16\">" +
              "<path d=\"M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z\"/>" +
              "</svg>" +
              "</div>";
        }
        $.ajax({
          type: "get",
          url: "/totalPrice",
          data: {},
          dataType: "text",
          success: function (str) {

            wonText.innerHTML = str;
            orderItem.innerHTML = output;
          }
        });
      }
    }
  });
}

$(document).on("click", ".menu", function () {
  var menu = $(this).data("menu");
  var price = $(this).data("price");
  var menuFileName = $(this).data("menuFileName");
  $(".modal-body #menu").val(menu);
  $(".modal-body #price").val(price);
  $(".modal-body #menuFileName").attr("src", /upload/ + menuFileName);
  $(".modal-body #coffee-m").html(menu);
  $(".modal-body #coffee-p").html(price);
});