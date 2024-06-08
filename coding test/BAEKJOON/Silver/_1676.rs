use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read input");
    let n: u32 = input.trim().parse().expect("Please enter a valid number");

    let mut count = 0;
    let mut i = 5;

    while i <= n {
        count += n / i;
        i *= 5;
    }

    println!("{}", count);
}