//Appear
document.querySelector('.cls-22').addEventListener('click', function(e) {

    document.querySelector('#login>.popUpForm').style.display = 'block';
});
document.querySelector('.cls-7').addEventListener('click', function(e) {

    document.querySelector('#registration>.popUpForm').style.display = 'block';
});
  
//Disappear
document.querySelector('.cls-7').addEventListener('click', function(e) {
    
        document.querySelector('#login>.popUpForm').style.display = 'none';
    });
document.querySelector('.cls-22').addEventListener('click', function(e) {
    
        document.querySelector('#registration>.popUpForm').style.display = 'none';
    });
