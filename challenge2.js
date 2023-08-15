//Coded and tested in https://www.programiz.com/javascript/online-compiler/

  //coins = [1,2,5];
  coins = [5, 7, 1, 1, 2, 3, 22];


  let permutations = [];

  permutations.push([]);

  //Get all possible permutations of coins
  for(let i=0; i < coins.length;i++){

    let currentNum = coins[i];
    let len = permutations.length;

    for(let j=0; j < len; j++){
      let copyPermutations = permutations[j].slice();
      copyPermutations.push(currentNum);
      permutations.push(copyPermutations)
    }
  }
  
  let sumPermutations = [];
  let currentPermutationSum =0;

  //remove empty permutation
  permutations.shift();

  //sum inner values of permutations
  for(let i=0; i < permutations.length;i++){
      currentPermutationSum = permutations[i].reduce((x,y) => x + y);
      sumPermutations.push(currentPermutationSum);
  }  
    
  //remove duplicate values    
  sumPermutationsSet = removeDuplicates(sumPermutations);
  //sort array in ascending order
  sumPermutationsSort = sumPermutationsSet.sort((a, b) => a - b);
  
  // Loop through array of sum of inner permutations
  // If the next value in the array is not the successor of the number, then the successor
  // is the minimum amount of change that can't be created
  let minimumNoCreate =1;
  for(let i=0; i < sumPermutationsSort.length;i++){
      if (sumPermutationsSort[i+1]!== sumPermutationsSort[i]+1) {
          minimumNoCreate= sumPermutationsSort[i]+1;
          break;
      } 
  }  

  console.log("Minimum amount is:", minimumNoCreate); 
     
      
  function removeDuplicates(arr) {
    return [...new Set(arr)];
  }
      
      
