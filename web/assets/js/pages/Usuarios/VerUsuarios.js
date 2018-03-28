$(document).ready(function(){   
   $.get("Usuarios",function(json){
      var $table = $("#tablaUsuarios");
      var usuarios = JSON.parse(json);
      var i;
      for(i = 0; i<usuarios.length;i++){
              $("<tr>").appendTo($table);
              $("<td>"+usuarios[i].idUsuarios+"</td>").appendTo($table);
              $("<td>"+usuarios[i].nombre_usuario+"</td>").appendTo($table);
              $("<td>"+usuarios[i].ObjTipo_Usuario.NombreTipo_Usuario+"</td>").appendTo($table);
              if(usuarios[i].Status==1){
                $("<td><form action='desactivateUser' method='post'><input type='hidden' name='id' value='"+usuarios[i].idUsuarios+"'> <button class='btn btn-success btn-s' ><i class='fa fa-check'></i></button></form> </td>").appendTo($table);  
              }
              else if (usuarios[i].Status==0)
               $("<td><form action='activate' method='post'><input type='hidden' name='id' value='"+usuarios[i].idUsuarios+"'> <button class='btn btn-danger btn-s'  ><i class='fa fa-minus'></i> </button> </form></td>").appendTo($table); 
              
              $("<td>"+usuarios[i].Descipcion+"</td>").appendTo($table);
              $("</tr>").appendTo($table);
      }
   });
});

