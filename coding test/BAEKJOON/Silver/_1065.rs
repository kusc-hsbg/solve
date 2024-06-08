use std::io;

fn is_han_number(n: i32) -> bool {
    let digits: Vec<i32> = n.to_string().chars().map(|d| d.to_digit(10).unwrap() as i32).collect();
    if digits.len() <= 2 {
        return true;
    }
    let diff = digits[1] - digits[0];
    for i in 1..digits.len() - 1 {
        if digits[i + 1] - digits[i] != diff {
            return false;
        }
    }
    true
}

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let n: i32 = input.trim().parse().expect("Please type a number!");

    let mut count = 0;
    for i in 1..=n {
        if is_han_number(i) {
            count += 1;
        }
    }
    println!("{}", count);
}
