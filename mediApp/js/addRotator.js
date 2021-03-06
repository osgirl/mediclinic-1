var displayTime, speed, wait, banner1, banner2, link1, link2, bannerIndex, bannerLocations, bannerURLs;

function initVar() {
  displayTime = 3; // The amount of time each banner will be displayed in seconds.
  speed = 5; // The speed at which the banners is moved (1 - 10, anything above 5 is not recommended).
  wait = true;

  banner1 = document.getElementById("banner1");
  banner2 = document.getElementById("banner2");
  link1 = document.getElementById("link1");
  link2 = document.getElementById("link2");

  banner1 = document.getElementById("banner1");
  banner2 = document.getElementById("banner2");

  banner1.style.left = 0;
  banner2.style.left = 500;

  bannerIndex = 1;

  /* Important: In order for this script to work properly, please make sure that the banner graphic and the
  URL associated with it have the same index in both, the bannerLocations and bannerURLs arrays.
  Duplicate URLs are permitted. */

  // Enter the location of the banner graphics in the array below.
  bannerLocations = new Array(context+"/images/oie_shake_hands_concepts_3.jpg",context+"/images/oie_medical.jpg");

  // Enter the URL's to which the banners will link to in the array below.
  bannerURLs = new Array(context+"/appmentSignUp.htm",context+"/appmentSignUp.htm");
}

function moveBanner(){
  if(!wait){
    banner1.style.left = parseInt(banner1.style.left) -  (speed * 5);
    banner2.style.left = parseInt(banner2.style.left) - (speed * 5);
    if(parseInt(banner1.style.left) <= -500){
      banner1.style.left = 500;
      bannerIndex = (bannerIndex < (bannerLocations.length - 1)) ? ++bannerIndex :0;
      banner1.src = bannerLocations[bannerIndex];
      link1.href = bannerURLs[bannerIndex];
      wait = true;
    }
    if(parseInt(banner2.style.left) <= -500){
      banner2.style.left = 500;
      bannerIndex = (bannerIndex < (bannerLocations.length - 1)) ? ++bannerIndex :0;
      banner2.src = bannerLocations[bannerIndex];
      link2.href = bannerURLs[bannerIndex];
      wait = true;
    }

    setTimeout("moveBanner()",100);
  } else {
      wait = false;
      setTimeout("moveBanner()", displayTime * 1000);
  }
}


