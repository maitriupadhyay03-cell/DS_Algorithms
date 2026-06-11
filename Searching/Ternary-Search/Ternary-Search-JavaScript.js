// Ternary Search in JavaScript
// Ternary search divides the array into three parts using two mid points
// Time Complexity: O(log3 n), Space Complexity: O(1) for iterative

/**
 * Performs ternary search on a sorted array
 * @param {number[]} arr - Sorted array to search in
 * @param {number} key - Value to search for
 * @param {number} l - Left (start) index
 * @param {number} r - Right (end) index
 * @returns {number} Index of key if found, -1 otherwise
 */
function ternarySearch(arr, key, l, r) {
      while (l <= r) {
                // Find the mid1 and mid2
          const mid1 = l + Math.floor((r - l) / 3);
                const mid2 = r - Math.floor((r - l) / 3);

          // Check if key is present at any mid
          if (arr[mid1] === key) {
                        return mid1;
          }
                if (arr[mid2] === key) {
                              return mid2;
                }

          // Since key is not present at mid,
          // check in which region it is present
          if (key < arr[mid1]) {
                        // key lies in the left third
                    r = mid1 - 1;
          } else if (key > arr[mid2]) {
                        // key lies in the right third
                    l = mid2 + 1;
          } else {
                        // key lies in the middle third
                    l = mid1 + 1;
                        r = mid2 - 1;
          }
      }

    // Key not found
    return -1;
}

// Driver code
const arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const l = 0;
const r = arr.length - 1;

// Search for 5
let key = 5;
let result = ternarySearch(arr, key, l, r);
console.log(`Index of ${key} is ${result}`); // Output: Index of 5 is 4

// Search for 50 (not in array)
key = 50;
result = ternarySearch(arr, key, l, r);
console.log(`Index of ${key} is ${result}`); // Output: Index of 50 is -1
