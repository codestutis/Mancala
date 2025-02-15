const API_URL = "http://localhost:8080/game";
let first;
let last;

async function fetchGameState() {
    const response = await fetch(`${API_URL}/state`);
    const gameState = await response.json();
    let move = gameState.currentPlayer % 2 == 1;
    first = move ? 7 : 0;
    last = move ? 12 : 5;
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
        well.innerText = board[well.getAttribute("index")];
    });
}

document.addEventListener('DOMContentLoaded', function() { 
    // Add event listeners to each well
    fetchGameState();
    document.querySelectorAll('.well').forEach(function(well) {
        well.addEventListener('click', function() {
            const index = parseInt(well.getAttribute("index"));
            if (parseInt(well.innerText) != 0 && index >= first && index <= last) {
                makeMove(index);
                console.log("Move accepted");
            } else {
                console.log("Invalid move");
            }
        });
    });
});

function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
}