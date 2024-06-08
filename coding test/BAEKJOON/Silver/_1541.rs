use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read input");
    let input = input.trim();

    let split_by_minus: Vec<&str> = input.split('-').collect();
    
    let mut result = 0;
    if !split_by_minus.is_empty() {
        let first_sum: i32 = split_by_minus[0]
            .split('+')
            .map(|x| x.parse::<i32>().unwrap())
            .sum();

        result = first_sum;

        for part in &split_by_minus[1..] {
            let sum: i32 = part
                .split('+')
                .map(|x| x.parse::<i32>().unwrap())
                .sum();
            result -= sum;
        }
    }

    println!("{}", result);
}
