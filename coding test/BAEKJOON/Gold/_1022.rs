use std::cmp::{max, min};
use std::io::{self, Write};

fn get_value(i: i32, j: i32) -> i32 {
    let n = max(i.abs(), j.abs());
    let mut val = (2 * n + 1) * (2 * n + 1);
    let diff = 2 * n;

    if i == n {
        return val - (n - j);
    }
    val -= diff;
    if j == -n {
        return val - (n - i);
    }
    val -= diff;
    if i == -n {
        return val - (j + n);
    }
    val -= diff;
    return val - (i + n);
}

fn get_digit_length(val: i32) -> usize {
    if val == 0 {
        return 1;
    }
    (val as f64).log10().floor() as usize + 1
}

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let parts: Vec<i32> = input.trim().split_whitespace()
                               .map(|s| s.parse().unwrap())
                               .collect();
    let r1 = parts[0];
    let c1 = parts[1];
    let r2 = parts[2];
    let c2 = parts[3];

    let mut k = 0;
    for i in r1..=r2 {
        for j in c1..=c2 {
            k = max(k, get_digit_length(get_value(i, j)) as i32);
        }
    }

    let width = k as usize;
    let stdout = io::stdout();
    let mut handle = stdout.lock();
    for i in r1..=r2 {
        for j in c1..=c2 {
            if j != c1 {
                write!(handle, " ").unwrap();
            }
            write!(handle, "{:width$}", get_value(i, j), width = width).unwrap();
        }
        writeln!(handle).unwrap();
    }
}
