use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read input");
    let x: i32 = input.trim().parse().expect("Please enter a valid number");

    let mut diagonal = 1;
    let mut sum = 0;

    while sum + diagonal < x {
        sum += diagonal;
        diagonal += 1;
    }

    let position = x - sum;

    let (numerator, denominator) = if diagonal % 2 == 0 {
        (position, diagonal - position + 1)
    } else {
        (diagonal - position + 1, position)
    };

    println!("{}/{}", numerator, denominator);
}
