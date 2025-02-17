const API_URL = "http://localhost:8080/game";
let first;
let last;

async function fetchGameState() {
    try {
        const response = await fetch(`${API_URL}/state`);
        const gameState = await response.json();
        let move = gameState.currentPlayer % 2 == 1;
        first = move ? 7 : 0;
        last = move ? 12 : 5;
        renderBoard(gameState.board, move);
    } catch (error) {
        console.error("Failed to fetch game state:", error);
    }
}

async function makeMove(pitIndex) {
    try {
        await fetch(`${API_URL}/move/${pitIndex}`, { method: "POST" });
        fetchGameState();
    } catch (error) {
        console.error("Failed to make move:", error);
    }
}

async function resetGame() {
    try {
        await fetch(`${API_URL}/reset`, { method: "POST" });
        fetchGameState();
    } catch (error) {
        console.error("Failed to reset game:", error);
    }
}

function renderBoard(board, move) {
    // add board values
    const wells = document.querySelectorAll("div[index]");
    wells.forEach(well => {
        const index = well.getAttribute("index");
        well.innerText = board[index];
        console.log(`Updated well at index ${index} with value ${board[index]}`);
    });
}

document.addEventListener('DOMContentLoaded', function() { 
    // Add event listeners to each well
    fetchGameState();
    turnGreen();
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

function turnGreen() {
    if (move) {
        document.body.classList.toggle('green');
    }
    else {
        document.body.classList.toggle('green');
    }

}

function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
}