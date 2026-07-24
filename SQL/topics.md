# 📊 SQL Window Functions Cheat Sheet: `LAG` & `LEAD` Patterns

A quick-reference guide and cheat sheet for real-world analytical SQL patterns using `LAG()` and `LEAD()` window functions.

---

## 📌 Overview

| Function | Direction | Common Use Cases |
| :--- | :--- | :--- |
| **`LAG(column, offset, default)`** | Looks **backward** (previous rows) | DoD/MoM growth, time gap analysis, detecting consecutive trends |
| **`LEAD(column, offset, default)`** | Looks **forward** (next rows) | Next order prediction, funnel step duration, future comparison |

---

## 🛠️ Pattern 1: Day-over-Day / Month-over-Month Comparison (Growth Check)

### 🎯 Scenario
Calculate daily sales growth/decline by comparing today's revenue against yesterday's revenue.

### 💻 SQL Query
```sql
SELECT 
    date,
    sales AS today_sales,
    -- Get yesterday's sales (default to 0 if no previous record exists)
    LAG(sales, 1, 0) OVER (ORDER BY date) AS yesterday_sales,
    -- Difference between today and yesterday
    sales - LAG(sales, 1, 0) OVER (ORDER BY date) AS difference
FROM daily_sales;
```

### 💡 Key Takeaway
* `LAG(sales, 1, 0)` reads 1 row back. If it's the first record (no previous row), it returns `0` instead of `NULL`.
* Useful for **KPI Dashboards**, **Growth Reports**, and **Anomaly Detection**.

---

## 🛠️ Pattern 2: Time Gap Between Events (User Activity & Latency)

### 🎯 Scenario
Calculate the time elapsed (in seconds/minutes/hours) between consecutive user logins to measure session frequency or delay.

### 💻 SQL Query
```sql
SELECT 
    user_id,
    login_time,
    -- Get previous login time for the same user
    LAG(login_time) OVER (
        PARTITION BY user_id 
        ORDER BY login_time
    ) AS prev_login,
    
    -- Calculate time gap (PostgreSQL / Standard SQL syntax)
    login_time - LAG(login_time) OVER (
        PARTITION BY user_id 
        ORDER BY login_time
    ) AS time_gap
FROM user_logins;
```

### 💡 Key Takeaway
* **`PARTITION BY user_id`** resets the window calculation for each user so user A's login doesn't mix with user B's login.
* **Dialect-specific time differences:**
  * **PostgreSQL:** `login_time - LAG(...)`
  * **MySQL:** `TIMESTAMPDIFF(MINUTE, LAG(...), login_time)`
  * **BigQuery / Snowflake:** `DATETIME_DIFF(login_time, LAG(...), MINUTE)`

---

## 🛠️ Pattern 3: Consecutive Occurrences (LeetCode 180 Style)

### 🎯 Scenario
Find values or events that occur **at least 3 times sequentially** (e.g., 3 continuous logins, identical values in 3 consecutive logs).

### 💻 SQL Query
```sql
WITH RankedLogs AS (
    SELECT 
        num AS current_num,
        LAG(num, 1) OVER (ORDER BY id) AS prev_num_1,
        LAG(num, 2) OVER (ORDER BY id) AS prev_num_2
    FROM Logs
)
SELECT DISTINCT current_num AS ConsecutiveNum
FROM RankedLogs
WHERE current_num = prev_num_1 
  AND current_num = prev_num_2;
```

### 💡 Key Takeaway
* `LAG(num, 1)` gets the immediate previous row.
* `LAG(num, 2)` gets the row before that.
* Using `DISTINCT` eliminates duplicate results when a sequence continues beyond 3 rows.

---

## 🛠️ Pattern 4: Future Event Comparison using `LEAD`

### 🎯 Scenario
Inspect upcoming order details to calculate price jumps, customer upgrade behavior, or order flow transitions.

### 💻 SQL Query
```sql
SELECT 
    order_id,
    customer_id,
    amount AS current_order_amount,
    -- Look ahead to the next order amount
    LEAD(amount, 1) OVER (PARTITION BY customer_id ORDER BY order_date) AS next_order_amount,
    -- Jump/difference in order value
    LEAD(amount, 1) OVER (PARTITION BY customer_id ORDER BY order_date) - amount AS jump_in_next_order
FROM orders;
```

### 💡 Key Takeaway
* `LEAD()` looks into future rows relative to the current row order.
* Useful for analyzing **Up-sell / Cross-sell trends** and **User Conversion Funnels**.

---

## 🚀 Pro Tips & Best Practices

1. **Syntax Signature:** `LAG(column_name, offset_number, default_value_if_null)`
2. **Performance:** Ensure columns used in `ORDER BY` and `PARTITION BY` (like `date`, `user_id`, `id`) are properly **indexed** for large databases.
3. **Handling First/Last Rows:** Always handle `NULL` values when `LAG` reaches the top or `LEAD` reaches the bottom of a partition


RANGE BETWEEN INTERVAL 6 DAY PRECEDING AND CURRENT ROW (💥 Important Part):

ROWS BETWEEN rows count karta hai (chahe date repeat ho ya missing ho).

RANGE BETWEEN actual dates/calendar days ko dekhta hai.

Yeh bol raha hai: "Aaj ki date (CURRENT ROW) se lekar exact 6 din purani date tak ka time period cover karo."

Total kitne din huye? Current day + past 6 days = Total 7 days!

Fayda: Agar ek hi date par 5 alag-alag customer hain, toh RANGE un sab ke amounts ko group karke exact calendar week ka total nikal deta hai.