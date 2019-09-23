/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



//This function validates if a given date is weekend or holyday
function isValidDate(date){
    date_aux=date.replace(/-/g, '\/'); 
    let fecha=new Date(date_aux);
    //if day is saturday or sunday
    if(fecha.getDay()===0 || fecha.getDay()===6){
        return false;
        
    }

    //array with all the posible holidays of the year excluding easter
    let holiday =['01-01','04-11','05-01','07-25','08-02','08-15','09-15','10-12','12-25'];

    for(let i=0; i<holiday.length; i++){
        let aux=''+fecha.getFullYear+'-'+holiday[i]; 
        if(date===aux)
          return false;
    }


let URL="https://www.googleapis.com/calendar/v3/calendars/es.cr%23holiday%40group.v.calendar.google.com/events?key=AIzaSyAJuTl-gxVHcY80RvGL8T9fzY8sgfwU8Xw";
var result=true;
$.getJSON(URL).then(data=>{
  data.items.forEach(item=>{
   //if the day is eastern   
 if(item.summary==='Jueves Santo' || item.summary==='Viernes Santo' ){
     if(date===item.start.date){
      result=false;
     return false;
     }
     
 }
})

  return result;
});


}

/*
 * -------------------------------------------------------------------------------------
 * 
 **/
var states =null;
var types= null;


//this function initialize all functions of formulary
function init(){
    fullComboStay();
    
    
}
function initData1(newData){
    stays = newData;
    
}

//this funtion upload the stay of accord on comboBox
 function fullComboState() 
    {
      var comboState = document.getElementsByName("comboState");
      if(comboState){
          comboState.options.length =0;
          
     
        {
            var opc = document.createElement("OPTION");
            opc.setAttribute("value", "null");
            opc.setAttribute("selected", "selected");
            opc.appendChild(document.createTextNode("(Estado)"));
            refMenu.appendChild(opc);
        }

        for (var i = 0; i < states.length; i++) {
            var sta = comercios[i];

            var opc = document.createElement("OPTION");
            opc.setAttribute("value", sta.id + " " + sta.description);
            opc.appendChild(document.createTextNode(local.ciudad+ " " + local.direccion));
            refMenu.appendChild(opc);

        }
          
      }
    }


//this funtion upload the type on comboBox 