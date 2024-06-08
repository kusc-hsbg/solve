use std::io::{self, BufRead};

fn sieve_of_eratosthenes(limit: usize) -> Vec<bool> {
    let mut is_prime = vec![true; limit + 1];
    is_prime[0] = false;
    is_prime[1] = false;

    for i in 2..=((limit as f64).sqrt() as usize) {
        if is_prime[i] {
            for j in (i * i..=limit).step_by(i) {
                is_prime[j] = false;
            }
        }
    }

    is_prime
}

fn main() {
    let stdin = io::stdin();
    let mut input = String::new();
    stdin.lock().read_line(&mut input).expect("Failed to read input");
    let t: usize = input.trim().parse().expect("Please enter a valid number");

    let mut cases = Vec::new();
    for _ in 0..t {
        input.clear();
        stdin.lock().read_line(&mut input).expect("Failed to read input");
        let n: usize = input.trim().parse().expect("Please enter a valid number");
        cases.push(n);
    }

    let max_n = *cases.iter().max().unwrap();
    let is_prime = sieve_of_eratosthenes(max_n);

    for n in cases {
        let mut a = 0;
        let mut b = 0;
        for i in (2..=n / 2).rev() {
            if is_prime[i] && is_prime[n - i] {
                a = i;
                b = n - i;
                break;
            }
        }
        println!("{} {}", a, b);
    }
}
