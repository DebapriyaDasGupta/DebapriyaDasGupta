function findRepeatingNumbers(arr) {
    const n = arr.length;
    let slow = arr[0];
    let fast = arr[0];

    // Phase 1: Detect whether a cycle exists
    do {
        slow = arr[slow];
        fast = arr[arr[fast]];
    } while (slow !== fast);

    // Phase 2: Find the entry point of the cycle
    let ptr1 = arr[0];
    let ptr2 = slow;
    while (ptr1 !== ptr2) {
        ptr1 = arr[ptr1];
        ptr2 = arr[ptr2];
    }

    // Repeating elements are found at ptr1 (or ptr2)
    const repeatingNumbers = [];
    let current = arr[0];
    while (current !== ptr1) {
        current = arr[current];
    }

    while (current !== ptr1) {
        repeatingNumbers.push(current);
        current = arr[current];
    }
    repeatingNumbers.push(ptr1);

    return repeatingNumbers;
}

// Example usage:
const arr = [1, 2, 3, 6, 3, 6, 1];
const repeatingNumbers = findRepeatingNumbers(arr);
console.log("Repeating numbers:", repeatingNumbers);