$(document).ready(function(){   
   $.get("Usuarios",function(json){
      var $table = $("#tablaUsuarios");
      var usuarios = JSON.parse(json);
      var i;
      for(i = 0; i<usuarios.length;i++){
              $("<td>"+usuarios[i].idUsuarios+"</td>").appendTo($table);
              $("<td>"+usuarios[i].nombre_usuario+"</td>").appendTo($table);
              $("<td>"+usuarios[i].idTipo_Usuario+"</td>").appendTo($table);
              $("<td>"+usuarios[i].Status+"</td>").appendTo($table);
              $("<td>"+usuarios[i].Descipcion+"</td>").appendTo($table);              
      }
   });
});

