-- Write your PostgreSQL query statement below
SELECT 
    euni.unique_id,
    e.name
FROM 
    Employees e
LEFT JOIN 
    EmployeeUNI euni ON e.id = euni.id
ORDER BY 
    e.name;