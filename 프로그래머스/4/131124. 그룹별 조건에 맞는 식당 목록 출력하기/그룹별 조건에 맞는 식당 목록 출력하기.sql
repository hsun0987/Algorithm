SELECT MEMBER_NAME, REVIEW_TEXT, REVIEW_DATE
FROM MEMBER_PROFILE M
JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    HAVING COUNT(*) = 
                (
                    SELECT MAX(A.MC)
                    FROM (
                        SELECT COUNT(*) AS MC
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                    ) A
                )
)
ORDER BY R.REVIEW_DATE, R.REVIEW_TEXT;