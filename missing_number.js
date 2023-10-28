function findMissingNumber(arr) {
    // Calculate the expected sum of the first N natural numbers
    const n = arr.length + 1; // Since there are N-1 elements in the array
    const expectedSum = (n * (n + 1)) / 2;

    // Calculate the sum of elements in the array
    const actualSum = arr.reduce((acc, num) => acc + num, 0);

    // Calculate the missing number
    const missingNumber = expectedSum - actualSum;

    return missingNumber;
}

// Example usage:
const arr = [1, 2, 4, 6, 3, 7, 8];
const missing = findMissingNumber(arr);
console.log("The missing number is: " + missing);