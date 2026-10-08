SELECT NAME, DATETIME
FROM ANIMAL_INS
WHERE ANIMAL_ID NOT IN (
                        -- 입양된 동물 목록
                        SELECT ANIMAL_ID
                        FROM ANIMAL_OUTS
                        )
ORDER BY DATETIME
LIMIT 3;