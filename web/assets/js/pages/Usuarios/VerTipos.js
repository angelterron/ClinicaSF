$(document).ready(function(){       
    verTipos();  

});
function verTipos(){
    $.get("showTipos",function(json){
      var opcion = $("#tablaTipos");
      var tipos = JSON.parse(json);
      var i;     
      $("<option value='0'>Seleccione un tipo</option>").appendTo(opcion);
      for(i = 0; i<tipos.length;i++){
              $("<option value="+(i+1)+">"+tipos[i].NombreTipo_Usuario+"</option>").appendTo(opcion);
      }
   });  
   
   $("#tablaTipos").change(function(){
    if($('#tablaTipos option:selected').val() == 0 ) {
        $("#miFormulario").attr("action", "./");
        if($("#formMed").length){
            var opcionc =$("#formMed");
            opcionc.remove();
        }
        if($("#formEmp").length){
            var opcionc =$("#formEmp");
            opcionc.remove();
        } 
    }  
    else if($('#tablaTipos option:selected').val() == 2 || $('#tablaTipos option:selected').val() == 3) {
        $("#miFormulario").attr("action", "addUserMed");
        if($("#formMed").length){
            var opcionc =$("#formMed");
            opcionc.remove();
        }
        if($("#formEmp").length){
            var opcionc =$("#formEmp");
            opcionc.remove();
        }
        var $opcion =$("#Formularios");
        $("<div class='col-md-6 col-sm-6' id='formMed'>").appendTo($opcion);
        var $opcion2=$("#formMed");
        $("<div class='form-group'><label>Nombre</label><input type='text' class='form-control' placeholder='Nombre' name='nombre'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Apellido Paterno</label><input type='text' class='form-control' placeholder='Apellido Paterno' name='apellidopat'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Apellido Materno</label><input type='text' class='form-control' placeholder='Apellido Materno' name='apellidomat'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Cédula</label><input type='text' class='form-control' placeholder='Cédula' name='cedula'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Correo electrónico</label><input type='text' class='form-control' placeholder='Correo electrónico' name='correo'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Especialidad</label> <select class='form-control' name='especialidad' id='tablaEspecialidad'>").appendTo($opcion2);
        //no supe como ejecutarda desde otro directorio , por eso la escribi aca abajo
           verEspecialidades();
        $("</select>").appendTo($opcion2);
        $("<div class='form-group'><div class='offset-md-3 col-md-9'><button type='submit' class='btn btn-info'>Submit</button><button type='button' class='btn btn-default'>Cancel</button></div></div>").appendTo($opcion2);
        $("</div").appendTo($opcion);
        
    }
    else {
        $("#miFormulario").attr("action", "addUserEmp");
        if($("#formMed").length){
            var opcionc =$("#formMed");
            opcionc.remove();
        }
        if($("#formEmp").length){
            var opcionc =$("#formEmp");
            opcionc.remove();
        }
        var $opcion =$("#Formularios");
        $("<div class='col-md-6 col-sm-6' id='formEmp'>").appendTo($opcion);
        var $opcion2=$("#formEmp");
        $("<div class='form-group'><label>Nombre</label><input type='text' class='form-control' placeholder='Nombre' name='nombre'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Apellido Paterno</label><input type='text' class='form-control' placeholder='Apellido Paterno' name='apellidopat'></div>").appendTo($opcion2);
        $("<div class='form-group'><label>Apellido Materno</label><input type='text' class='form-control' placeholder='Apellido Materno' name='apellidomat'></div>").appendTo($opcion2);
        $("<div class='form-group'><div class='offset-md-3 col-md-9'><button type='submit' class='btn btn-info'>Submit</button><button type='button' class='btn btn-default'>Cancel</button></div></div>").appendTo($opcion2);
        $("</div").appendTo($opcion);
    }
   });
   
   
};

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




