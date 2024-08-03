# Write your MySQL query statement below
SELECT P.product_name, S.year, S.price
FROM Product AS P
INNER JOIN Sales AS S
ON S.product_id=P.product_id;