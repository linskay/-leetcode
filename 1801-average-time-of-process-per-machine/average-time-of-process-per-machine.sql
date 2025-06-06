SELECT 
    s.machine_id,
    ROUND(CAST(AVG(e.timestamp - s.timestamp) AS numeric), 3) AS processing_time
FROM 
    Activity s
JOIN 
    Activity e ON s.machine_id = e.machine_id 
    AND s.process_id = e.process_id
    AND s.activity_type = 'start'
    AND e.activity_type = 'end'
GROUP BY 
    s.machine_id
ORDER BY 
    s.machine_id;