const API_URL = "http://localhost:8080/game";
const requestOptions = {
    mode: 'no-cors'
};
async function fetchGameState() {
    const response = await fetch(`${API_URL}/state`);
    const gameState = await response.json();
    renderBoard(gameState.board);
}

async function makeMove(pitIndex) {
    await fetch(`${API_URL}/move/${pitIndex}`, { method: "POST" });
    fetchGameState();
}

async function resetGame() {
    await fetch(`${API_URL}/reset`, { method: "POST" });
    fetchGameState();
}

function renderBoard(board) {
    const wells = document.querySelectorAll("div[index]");
    wells.forEach(well => {
        well.innerText = board[well.index];
    })

}
document.addEventListener('DOMContentLoaded', function() { 
    // Add event listeners to each well
    fetchGameState();
    document.querySelectorAll('.well').forEach(function(well) {
        well.addEventListener('click', function() {
            makeMove(well.index);
            fetchGameState();
            console.log(well.getAttribute("index"));
        });
    });
});
function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
}