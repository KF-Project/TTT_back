<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
  ani nega e girl hangeuldo an naonunde
  <input type="button" value="click" id="btn" style="width: 50px; height: 30px">

  <script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script type="text/javascript">
    $(function(){
      $('#btn').click(function(){
        $.ajax({
          type: 'post',
          url: '/num',
          
          success: function(){
            alert('들어감');
          },
          error: function(e){
            console.log(e);
          }
        });
      });
    });
  </script>
</body>
</html>