function solution(park, routes) {
    // 공원 너비
    const lenr = park.length;
    const lenc = park[0].length;
    // 스타트지점 찾기
    let r = -1;
    let c = -1;
    for (rr = 0; rr<lenr; rr++) {
        for (cc = 0; cc<lenc; cc++) {
            if (park[rr][cc] == "S") {
                r = rr
                c = cc
                break
            }
        }
        if (r != -1) {
            break
        }
    }
    // park 돌아다니기
    let sr = r;
    let sc = c;
    for (route = 0; route<routes.length; route++) {
        let D = routes[route].slice(0, 1);
        let L = Number(routes[route].slice(2, 3));
        for (move = 0; move < L; move++) {
            if (D == "N") {
                if (0 <= r-1 && park[r-1][c] != "X") {
                    r -= 1;
                } else {
                    r = sr;
                    c = sc;
                    break
                }
            } else if (D == "S") {
                if (r+1 < lenr && park[r+1][c] != "X") {
                    r += 1;
                } else {
                    r = sr;
                    c = sc;
                    break
                }
            } else if (D == "W") {
                if (0 <= c-1 && park[r][c-1] != "X") {
                    c -= 1;
                } else {
                    r = sr;
                    c = sc;
                    break
                }
            } else if (D == "E") {
                if (c+1 < lenc && park[r][c+1] != "X") {
                    c += 1;
                } else {
                    r = sr;
                    c = sc;
                    break
                }   
            }
        }
        if (r != sr || c != sc) {
            sr = r;
            sc = c;
        }
    }
    console.log(r)
    console.log(c)
    var answer = [r, c];
    return answer;
}