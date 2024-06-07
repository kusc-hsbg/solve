use std::io;

fn eratos(n: usize) -> Vec<usize> {
    let mut prime = vec![true; n + 1];
    let mut primes = Vec::new();

    for i in 2..=((n as f64).sqrt() as usize) {
        if prime[i] {
            for j in (i * i..=n).step_by(i) {
                prime[j] = false;
            }
        }
    }

    for i in 2..=n {
        if prime[i] {
            primes.push(i);
        }
    }

    primes
}

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let n: usize = input.trim().parse().unwrap();

    if n == 1 {
        println!("0");
        return;
    }

    let primes = eratos(n);

    let s = primes.len();
    let mut ans = 0;
    let mut start = 0;
    let mut end = 0;
    let mut sum = 0;

    while end <= s {
        if sum >= n {
            sum -= primes[start];
            start += 1;
        }
        if sum < n {
            if end < s {
                sum += primes[end];
            }
            end += 1;
        }
        if sum == n {
            ans += 1;
        }
    }

    println!("{}", ans);
}