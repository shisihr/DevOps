<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>


  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
  <script type="text/javascript">
      function calc() {
            $.ajax({
                url: 'jquer',
                data: ({
                    firstNumber: $('#firstNumber').val(),
                    secondNumber: $('#secondNumber').val(),
                    operator: $('#operator').val()
                  }),
                success: function (data) {
                    document.getElementById('res').textContent = data;
                    var newH = '[' + $('#firstNumber').val() + $('#operator').val() + $('#secondNumber').val() + '=' + data + '] \t';
                    document.getElementById('his').textContent = document.getElementById('his').textContent +newH;
                }
            });
      }
  </script>

  <body>
  <h1>Online Calculator. Spring MVC, AJAX jQuery</h1>
      <form method="get">
        First number:<br>
        <input type="text" id="firstNumber" name="firstNumber" autocomplete="off">
        <br><br>
        <select name="operator" id="operator">
          <option selected>+</option>
          <option>-</option>
          <option>*</option>
          <option>/</option>
        </select>
        <br><br>
        Second number:<br>
        <input type="text" name="secondNumber" id="secondNumber" autocomplete="off">
        <br><br>
        <input type="button" value="Calc" onclick="calc()"/>
        <br><br><br>
      </form>

  <p>
    Result:
  <span id="res"/>
  </p>
  <p>
    History:
  <div id="his">
      <%ArrayList<String> list = (ArrayList)session.getAttribute("history");
      if (list != null) {
        for (String s: list) {
          String result = "[" + s+ "]\t";%>
          <%=result%>
        <%} }%>
  </div>
  </p>
  </body>
</html>
