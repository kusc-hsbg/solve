use std::io;

fn mod_exp(a: u64, b: u64, c: u64) -> u64 {
    if b == 0 {
        return 1;
    }
    let half = mod_exp(a, b / 2, c);
    let half_mod = (half * half) % c;
    if b % 2 == 0 {
        half_mod
    } else {
        (half_mod * a) % c
    }
}

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read input");
    let parts: Vec<u64> = input.trim().split_whitespace()
        .map(|s| s.parse().expect("Parse error"))
        .collect();
    let a = parts[0];
    let b = parts[1];
    let c = parts[2];

    let result = mod_exp(a, b, c);
    println!("{}", result);
}
