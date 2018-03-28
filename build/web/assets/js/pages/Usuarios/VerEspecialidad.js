$(document).ready(function(){       
    verEspecialidades();  

});
function verEspecialidades(){
    $.get("showEspecialidades",function(json){
      var $table = $("#tablaEspecialidad");
      var tipos = JSON.parse(json);
      var i;
      for(i = 0; i<tipos.length;i++){

              $("<option value="+(i+1)+">"+tipos[i].NombreEsp_Medica+"</option>").appendTo($table);

      }
      
      
      
   });  
   
 };