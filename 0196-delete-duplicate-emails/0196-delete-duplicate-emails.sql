DELETE p1
--                         p1 and p2. This allows for self-joining the table to compare rows within the same table.
FROM person p1, person p2
--                         This condition ensures that the query is comparing rows that have the same email address.
WHERE p1.email = p2.email
--                         condition ensures that for any pair of rows with the same email, the row with the higher id value is 
--                         selected for deletion. This helps to keep only the row with the smaller id.
  AND p1.id > p2.id;