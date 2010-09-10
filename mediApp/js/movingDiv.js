/**
 * Retrieve the absolute coordinates of an element.
 *
 * @param element
 *   A DOM element.
 * @return
 *   A hash containing keys 'x' and 'y'.
 */
function getAbsolutePosition(element) {
  var r = { x: element.offsetLeft, y: element.offsetTop };
  if (element.offsetParent) {
    var tmp = getAbsolutePosition(element.offsetParent);
    r.x += tmp.x;
    r.y += tmp.y;
  }
  return r;
};
 
/**
 * Retrieve the coordinates of the given event relative to the center
 * of the widget.
 *
 * @param event
 *   A mouse-related DOM event.
 * @param reference
 *   A DOM element whose position we want to transform the mouse coordinates to.
 * @return
 *    A hash containing keys 'x' and 'y'.
 */
function getRelativeCoordinates(event, reference) {
  var x, y;
  event = event || window.event;
  var el = event.target || event.srcElement;
 
  if (!window.opera && typeof event.offsetX != 'undefined') {
    // Use offset coordinates and find common offsetParent
    var pos = { x: event.offsetX, y: event.offsetY };
 
    // Send the coordinates upwards through the offsetParent chain.
    var e = el;
    while (e) {
      e.mouseX = pos.x;
      e.mouseY = pos.y;
      pos.x += e.offsetLeft;
      pos.y += e.offsetTop;
      e = e.offsetParent;
    }
 
    // Look for the coordinates starting from the reference element.
    var e = reference;
    var offset = { x: 0, y: 0 }
    while (e) {
      if (typeof e.mouseX != 'undefined') {
        x = e.mouseX - offset.x;
        y = e.mouseY - offset.y;
        break;
      }
      offset.x += e.offsetLeft;
      offset.y += e.offsetTop;
      e = e.offsetParent;
    }
 
    // Reset stored coordinates
    e = el;
    while (e) {
      e.mouseX = undefined;
      e.mouseY = undefined;
      e = e.offsetParent;
    }
  }
  else {
    // Use absolute coordinates
    var pos = getAbsolutePosition(reference);
    x = event.pageX  - pos.x;
    y = event.pageY - pos.y;
  }
  // Subtract distance to middle
  return { x: x, y: y };
}
 
window.onload = function () {
  //document.getElementById('more_clicky').onmousedown =
  //document.getElementById('other_clicky').onmousedown =
}

function fn_showOptions(loggedUserID,calendarUserID,appointmentTime,appointmentDate,appointmentID,confirmationIndicator){
    var e = event || window.event;
    var pos = getRelativeCoordinates(event, document.getElementById('reference'));
    var r = document.getElementById('reference');
    var m = document.getElementById('movingDiv');
   //this is done to align right corner
   // var referenceWidth = parseInt( r.style.width);
    //var t = (pos.x - referenceWidth + 30) ;
    //m.style.left = t +'px' ;
    //var tbl  = document.getElementById('menuTable');
    //var rows = tbl.getElementsByTagName('tr');
    if (loggedUserID == calendarUserID){
    	document.getElementById('confirm').style.display="none";
    	document.getElementById('propose').style.display="none";
    }else{
    	if(confirmationIndicator !='N'){
    		document.getElementById('confirm').style.display="none";
    	}else{
    		document.getElementById('open').style.display="none";
    	}
    	document.getElementById('reschedule').style.display="none";
    	document.getElementById('cancel').style.display="none";
    }    
    document.getElementById('AppointmentDateR').value=appointmentDate;
    document.getElementById('AppointmentID').value=appointmentID;
    document.getElementById('TimeOfAppointment').value=appointmentTime;    
    m.style.left = pos.x +'px' ;
    m.style.top = pos.y +'px';
	var menuStyle=document.getElementById('movingDiv').style; 
	menuStyle.display="block";

	
}
