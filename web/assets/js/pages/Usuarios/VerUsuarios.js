$(document).ready(function(){       
    verUsuarios();            
});
function verUsuarios(){
    $.get("Usuarios",function(json){
      var $table = $("#tablaUsuarios");
      var usuarios = JSON.parse(json);
      var i;     
      $table.find("td").remove();
      for(i = 0; i<usuarios.length;i++){
              $("<tr>").appendTo($table);
              $("<td>"+usuarios[i].idUsuarios+"</td>").appendTo($table);
              $("<td>"+usuarios[i].nombre_usuario+"</td>").appendTo($table);
              $("<td>"+usuarios[i].ObjTipo_Usuario.NombreTipo_Usuario+"</td>").appendTo($table);
              if(usuarios[i].Status==1){
                $("<td><form><input type='hidden'> <button value='"+usuarios[i].idUsuarios+"' class='baja btn btn-success btn-s' ><i class='fa fa-check'></i></button></form> </td>").appendTo($table);  
              }
              else if (usuarios[i].Status==0)
               $("<td><form><input type='hidden' > <button value='"+usuarios[i].idUsuarios+"' class='alta btn btn-danger btn-s'  ><i class='fa fa-minus'></i> </button> </form></td>").appendTo($table); 
              
              $("<td>"+usuarios[i].Descipcion+"</td>").appendTo($table);
              $("</tr>").appendTo($table);
      }
      $(".baja").on("click",function(){
       $.get("desactivateUser",{id:$(this).val()},function(){
           verUsuarios();
       });
       
    });
    $(".alta").on("click",function(){
       $.post("activate",{id:$(this).val()},function(){
           verUsuarios();
       });
       
    });
   });  
   
};


