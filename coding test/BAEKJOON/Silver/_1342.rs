use std::io;

fn dfs(idx: usize, cur: &mut String, origin: &str, res: &mut i32, p: &mut [i32; 26]) {
    if idx == origin.len() {
        *res += 1;
        return;
    }

    for i in 0..26 {
        if p[i] == 0 {
            continue;
        }
        if !cur.is_empty() && cur.chars().last().unwrap() == (b'a' + i as u8) as char {
            continue;
        }
        p[i] -= 1;
        cur.push((b'a' + i as u8) as char);
        dfs(idx + 1, cur, origin, res, p);
        cur.pop();
        p[i] += 1;
    }
}

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let origin = input.trim();

    let mut p = [0; 26];
    for c in origin.chars() {
        p[c as usize - 'a' as usize] += 1;
    }

    let mut res = 0;
    let mut cur = String::new();
    dfs(0, &mut cur, origin, &mut res, &mut p);

    println!("{}", res);
}
