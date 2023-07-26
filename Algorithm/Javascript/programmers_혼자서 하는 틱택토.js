// 왜 X는 checkwin으로 처리를 안 해줘도 괜찮지?
// 언제나 O가 선공이라서 그런걸까?
// 아니면 테스트케이스에 관련된 데이터가 없는 걸까...?

function solution(board) {
    var answer = 1;
    dr = [-1, -1, -1, 1, 1, 1, 0, 0]
    dc = [-1, 0, 1, -1, 0, 1, -1, 1]
    
    winX = 0
    winO = 0
    
    cntX = 0
    cntO = 0
    
    checkwin = []
    for (let r = 0; r<3; r++) {
        for (let c = 0; c<3; c++) {
            if (board[r][c] === "O") {
                cntO++;
                if (winO === 0) {
                    for (let d = 0; d<8; d++) {
                        let nr = r
                        let nc = c
                        let cont = 1
                        let tmp = [(r, c)]
                        for (let move = 1; move<3; move++) {
                            nr = nr + dr[d]
                            nc = nc + dc[d]
                            if (0 <= nr && 0 <= nc && 3 > nr && 3 > nc && board[r][c] === board[nr][nc]) {
                                cont++;
                                tmp.push((nr, nc))
                            } else {
                                break;
                            }
                        }
                        if (cont === 3 && !checkwin.includes(tmp[0])) {
                            checkwin.push(tmp[0])
                            checkwin.push(tmp[2])
                            winO++;
                        }
                    }
                }
            } else if (board[r][c] === "X") {
                cntX++;
                if (winX === 0) {
                    for (let d = 0; d<8; d++) {
                        let nr = r
                        let nc = c
                        let cont = 1
                        for (let move = 1; move<3; move++) {
                            nr = nr + dr[d]
                            nc = nc + dc[d]
                            if (0 <= nr && 0 <= nc && 3 > nr && 3 > nc && board[r][c] === board[nr][nc]) {
                                cont++;
                            } else {
                                break;
                            }
                        }
                        if (cont === 3) {
                            winX++;
                        }
                    }
                }
            }
        }
    }
    console.log('winO', winO, 'winX', winX, 'cntO', cntO, 'cntX', cntX)
    if (1 < winO + winX) {
        answer = 0;
    }
    if (0 > cntO-cntX || 1 < cntO-cntX) {
        answer = 0;
    }
    if (winX === 1 && cntO-cntX != 0) {
        answer = 0;
    }
    if (winO === 1 && cntO-cntX != 1) {
        answer = 0;
    }
    return answer;
}