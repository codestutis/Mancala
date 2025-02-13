document.addEventListener('DOMContentLoaded', function() { 
    // Add event listeners to each well
    document.querySelectorAll('.well').forEach(function(well) {
        well.addEventListener('click', function() {
            well.innerText = '0';
            console.log(well.getAttribute("index"));
        });
    });
});
function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
}