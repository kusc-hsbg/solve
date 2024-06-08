use std::collections::HashMap;
use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut input = stdin.lock().lines();

    let n: usize = input.next().unwrap().unwrap().trim().parse().unwrap();
    let mut numbers: Vec<i32> = Vec::with_capacity(n);

    for line in input.take(n) {
        let number = line.unwrap().trim().parse().unwrap();
        numbers.push(number);
    }

    numbers.sort();

    let sum: i32 = numbers.iter().sum();
    let mean = (sum as f64 / n as f64).round() as i32;

    let median = numbers[n / 2];
    let mut occurrences = HashMap::new();
    for &number in &numbers {
        *occurrences.entry(number).or_insert(0) += 1;
    }

    let mut freq_vec: Vec<_> = occurrences.iter().collect();
    freq_vec.sort_by(|a, b| {
        b.1.cmp(a.1).then_with(|| a.0.cmp(b.0))
    });

    let mode = if freq_vec.len() > 1 && freq_vec[0].1 == freq_vec[1].1 {
        *freq_vec[1].0
    } else {
        *freq_vec[0].0
    };

    let range = numbers[n - 1] - numbers[0];

    println!("{}", mean);
    println!("{}", median);
    println!("{}", mode);
    println!("{}", range);
}
