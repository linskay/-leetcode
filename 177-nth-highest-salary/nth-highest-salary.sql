CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
  RETURN QUERY (
    WITH RankedSalaries AS (
      SELECT DISTINCT e.salary,
             DENSE_RANK() OVER (ORDER BY e.salary DESC) as rank
      FROM Employee e
    )
    SELECT rs.salary
    FROM RankedSalaries rs
    WHERE rs.rank = N
    LIMIT 1
  );
END;
$$ LANGUAGE plpgsql;