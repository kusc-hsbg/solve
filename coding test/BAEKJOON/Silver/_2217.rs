use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    lines.next();
    let mut ropes: Vec<i32> = lines.map(|line| line.unwrap().trim().parse().unwrap()).collect();

    ropes.sort_unstable_by(|a, b| b.cmp(a));

    let mut max_weight = 0;
    for (i, &rope) in ropes.iter().enumerate() {
        let weight = rope * (i as i32 + 1);
        if weight > max_weight {
            max_weight = weight;
        }
    }

    println!("{}", max_weight);
}