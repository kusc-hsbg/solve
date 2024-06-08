use std::io::{self, BufRead};

fn combinations(arr: &[i32], k: usize, start: usize, current: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
    if current.len() == k {
        result.push(current.clone());
        return;
    }

    for i in start..arr.len() {
        current.push(arr[i]);
        combinations(arr, k, i + 1, current, result);
        current.pop();
    }
}

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();

    while let Some(Ok(line)) = lines.next() {
        let data: Vec<i32> = line.split_whitespace().map(|s| s.parse().unwrap()).collect();
        if data[0] == 0 {
            break;
        }

        let s = &data[1..];

        let mut result = Vec::new();
        let mut current = Vec::new();

        combinations(s, 6, 0, &mut current, &mut result);

        for combination in result {
            println!("{}", combination.iter().map(|x| x.to_string()).collect::<Vec<String>>().join(" "));
        }
        println!();
    }
}
