window.addEventListener('scroll', function(e) {
  if(window.scrollY > 300){
    document.body.classList.add('scroll-down');
  } else {
    document.body.classList.remove('scroll-down');
  }
});