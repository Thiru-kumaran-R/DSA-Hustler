## XOR Tricks

### Rules
- A ^ A = 0
- A ^ 0 = A  
- A ^ B ^ A = B

### Kab Use Karo
| Problem Type | Trick |
|---|---|
| Missing Number | range XOR karo + array XOR karo |
| Single Number | sabko XOR karo, duplicate cancel |
| Two Missing | XOR + bit masking |
| Swap without temp | a^=b, b^=a, a^=b |

### Template
​```python
# Missing Number
xor = 0
for i in range(len(nums)+1): xor ^= i
for val in nums: xor ^= val
return xor

# Single Number (duplicate cancel)
xor = 0
for val in nums: xor ^= val
return xor
​```

### One Line Yaad Rakh
> Same number do baar aaye = cancel! 🎯


Problem dekho → Khud se poochho —

Kya array sorted hai?      → Binary Search
Kya subarray chahiye?      → Sliding Window  
Kya pairs chahiye?         → Two Pointer
Kya frequency chahiye?     → HashMap
Kya unique chahiye?        → Set
Kya cancel karna hai?      → XOR
Kya connected hai?         → Graph/Tree