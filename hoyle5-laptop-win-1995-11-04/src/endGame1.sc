;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1203)
(include sci.sh)
(use Main)
(use System)

(public
	endGame1 0
	endGame2 1
	endGame3 2
	endGame4 3
	lostGame 5
	findLoop 6
)

(instance endGame1 of Code
	(properties)

	(method (doit)
		(= global829 0)
		(if
			(or
				(== (global806 toSqr:) 1)
				(== (global806 toSqr:) 2)
				(== (global806 toSqr:) 3)
				(== (global806 toSqr:) 4)
				(== (global806 toSqr:) 5)
				(== (global806 toSqr:) 13)
				(== (global806 toSqr:) 21)
				(== (global806 toSqr:) 29)
				(== (global806 toSqr:) 30)
				(== (global806 toSqr:) 31)
				(== (global806 toSqr:) 32)
				(== (global806 toSqr:) 28)
				(== (global806 toSqr:) 20)
				(== (global806 toSqr:) 12)
			)
			(-= global829 10)
		)
		(if
			(or
				(== (global806 toSqr:) 6)
				(== (global806 toSqr:) 7)
				(== (global806 toSqr:) 8)
				(== (global806 toSqr:) 16)
				(== (global806 toSqr:) 24)
				(== (global806 toSqr:) 27)
				(== (global806 toSqr:) 26)
				(== (global806 toSqr:) 25)
				(== (global806 toSqr:) 17)
				(== (global806 toSqr:) 9)
			)
			(-= global829 5)
		)
		(if
			(or
				(== (global806 toSqr:) 10)
				(== (global806 toSqr:) 11)
				(== (global806 toSqr:) 14)
				(== (global806 toSqr:) 22)
				(== (global806 toSqr:) 23)
				(== (global806 toSqr:) 19)
			)
			(-= global829 2)
		)
		(if
			(or
				(and
					(== (global806 fromSqr:) 15)
					(!= ([global841 10] checker:) 2)
					(!= ([global841 11] checker:) 2)
					(!= ([global841 19] checker:) 2)
				)
				(and
					(== (global806 fromSqr:) 18)
					(!= ([global841 14] checker:) 2)
					(!= ([global841 22] checker:) 2)
					(!= ([global841 23] checker:) 2)
				)
			)
			(-= global829 15)
		)
	)
)

(instance endGame2 of Code
	(properties)

	(method (doit)
		(= global830 0)
		(= global831 0)
		(cond
			(
				(and
					(== ([global841 15] checker:) 2)
					(== ([global841 18] checker:) 2)
				)
				(cond
					(
						(or
							(== ([global841 24] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 18)
						(= global831 23)
					)
					(
						(or
							(== ([global841 28] checker:) -2)
							(== ([global841 27] checker:) -2)
						)
						(= global830 15)
						(= global831 19)
					)
					(
						(or
							(== ([global841 1] checker:) -2)
							(== ([global841 9] checker:) -2)
						)
						(= global830 15)
						(= global831 10)
					)
					(
						(or
							(== ([global841 5] checker:) -2)
							(== ([global841 6] checker:) -2)
						)
						(= global830 18)
						(= global831 14)
					)
				)
			)
			(
				(and
					(== ([global841 15] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(if
					(or
						(== ([global841 28] checker:) -2)
						(== ([global841 32] checker:) -2)
					)
					(= global830 15)
					(= global831 19)
				)
			)
			(
				(and
					(== ([global841 18] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(if
					(or
						(== ([global841 28] checker:) -2)
						(== ([global841 32] checker:) -2)
					)
					(= global830 18)
					(= global831 23)
				)
			)
			(
				(and
					(== ([global841 23] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 28] checker:) -2)
						(= global830 23)
						(= global831 27)
					)
					((== ([global841 32] checker:) -2)
						(= global830 19)
						(= global831 24)
					)
				)
			)
			(
				(and
					(== ([global841 23] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					((== ([global841 28] checker:) -2)
						(= global830 23)
						(= global831 19)
					)
					((== ([global841 32] checker:) -2)
						(= global830 24)
						(= global831 28)
					)
				)
			)
			(
				(and
					(== ([global841 27] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 28] checker:) -2)
						(= global830 27)
						(= global831 32)
					)
					((== ([global841 32] checker:) -2)
						(= global830 19)
						(= global831 23)
					)
				)
			)
			(
				(and
					(== ([global841 27] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					((== ([global841 28] checker:) -2)
						(= global830 27)
						(= global831 32)
					)
					((== ([global841 32] checker:) -2)
						(= global830 27)
						(= global831 24)
					)
				)
			)
			(
				(and
					(== ([global841 19] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					((== ([global841 28] checker:) -2)
						(= global830 24)
						(= global831 27)
					)
					((== ([global841 32] checker:) -2)
						(= global830 24)
						(= global831 28)
					)
				)
			)
			(
				(and
					(== ([global841 28] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 32] checker:) -2)
						(= global830 19)
						(= global831 24)
					)
					((== ([global841 27] checker:) -2)
						(= global830 28)
						(= global831 32)
					)
				)
			)
			(
				(and
					(== ([global841 19] checker:) 2)
					(== ([global841 32] checker:) 2)
				)
				(cond
					((== ([global841 31] checker:) -2)
						(= global830 19)
						(= global831 15)
					)
					((== ([global841 28] checker:) -2)
						(= global830 19)
						(= global831 23)
					)
				)
			)
			(
				(and
					(== ([global841 23] checker:) 2)
					(== ([global841 32] checker:) 2)
				)
				(cond
					(
						(or
							(== ([global841 27] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 23)
						(= global831 19)
					)
					((== ([global841 24] checker:) -2)
						(= global830 32)
						(= global831 28)
					)
				)
			)
			(
				(and
					(== ([global841 23] checker:) 2)
					(== ([global841 28] checker:) 2)
				)
				(cond
					((== ([global841 20] checker:) -2)
						(= global830 23)
						(= global831 18)
					)
					((== ([global841 32] checker:) -2)
						(= global830 23)
						(= global831 19)
					)
				)
			)
			(
				(and
					(== ([global841 18] checker:) 2)
					(== ([global841 10] checker:) 2)
				)
				(if
					(or
						(== ([global841 5] checker:) -2)
						(== ([global841 1] checker:) -2)
					)
					(= global830 18)
					(= global831 14)
				)
			)
			(
				(and
					(== ([global841 15] checker:) 2)
					(== ([global841 14] checker:) 2)
				)
				(if
					(or
						(== ([global841 5] checker:) -2)
						(== ([global841 1] checker:) -2)
					)
					(= global830 15)
					(= global831 10)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 14] checker:) 2)
				)
				(cond
					((== ([global841 5] checker:) -2)
						(= global830 10)
						(= global831 6)
					)
					((== ([global841 1] checker:) -2)
						(= global830 14)
						(= global831 9)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 9] checker:) 2)
				)
				(cond
					((== ([global841 5] checker:) -2)
						(= global830 10)
						(= global831 14)
					)
					((== ([global841 1] checker:) -2)
						(= global830 9)
						(= global831 5)
					)
				)
			)
			(
				(and
					(== ([global841 6] checker:) 2)
					(== ([global841 14] checker:) 2)
				)
				(cond
					((== ([global841 5] checker:) -2)
						(= global830 6)
						(= global831 1)
					)
					((== ([global841 1] checker:) -2)
						(= global830 14)
						(= global831 10)
					)
				)
			)
			(
				(and
					(== ([global841 6] checker:) 2)
					(== ([global841 10] checker:) 2)
				)
				(cond
					((== ([global841 5] checker:) -2)
						(= global830 6)
						(= global831 1)
					)
					((== ([global841 1] checker:) -2)
						(= global830 6)
						(= global831 9)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 9] checker:) 2)
				)
				(cond
					((== ([global841 5] checker:) -2)
						(= global830 9)
						(= global831 6)
					)
					((== ([global841 1] checker:) -2)
						(= global830 9)
						(= global831 5)
					)
				)
			)
			(
				(and
					(== ([global841 5] checker:) 2)
					(== ([global841 14] checker:) 2)
				)
				(cond
					((== ([global841 1] checker:) -2)
						(= global830 14)
						(= global831 9)
					)
					((== ([global841 6] checker:) -2)
						(= global830 5)
						(= global831 1)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 1] checker:) 2)
				)
				(cond
					((== ([global841 2] checker:) -2)
						(= global830 14)
						(= global831 18)
					)
					((== ([global841 5] checker:) -2)
						(= global830 14)
						(= global831 10)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 1] checker:) 2)
				)
				(cond
					(
						(or
							(== ([global841 6] checker:) -2)
							(== ([global841 5] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
					((== ([global841 9] checker:) -2)
						(= global830 1)
						(= global831 5)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 5] checker:) 2)
				)
				(cond
					((== ([global841 13] checker:) -2)
						(= global830 10)
						(= global831 15)
					)
					((== ([global841 1] checker:) -2)
						(= global830 10)
						(= global831 14)
					)
				)
			)
			(
				(and
					(== ([global841 18] checker:) 2)
					(== ([global841 1] checker:) 2)
				)
				(if (== ([global841 7] checker:) -2)
					(= global830 18)
					(= global831 15)
				)
			)
			(
				(and
					(== ([global841 15] checker:) 2)
					(== ([global841 32] checker:) 2)
				)
				(if (== ([global841 26] checker:) -2)
					(= global830 15)
					(= global831 18)
				)
			)
			(
				(and
					(== ([global841 15] checker:) 2)
					(== ([global841 5] checker:) 2)
				)
				(if (== ([global841 17] checker:) -2)
					(= global830 15)
					(= global831 18)
				)
			)
			(
				(and
					(== ([global841 18] checker:) 2)
					(== ([global841 28] checker:) 2)
					(== ([global841 16] checker:) -2)
				)
				(= global830 18)
				(= global831 15)
			)
		)
	)
)

(instance endGame3 of Code
	(properties)

	(method (doit)
		(= global830 0)
		(= global831 0)
		(cond
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					((== ([global841 6] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
							((== ([global841 32] checker:) -2)
								(= global830 23)
								(= global831 27)
							)
							((== ([global841 28] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 14)
								(= global831 9)
							)
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 9)
							)
							((== ([global841 32] checker:) -2)
								(= global830 14)
								(= global831 9)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
							((== ([global841 28] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
							((== ([global841 32] checker:) -2)
								(= global830 23)
								(= global831 27)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 9] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 32] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 28] checker:) -2)
								(= global830 19)
								(= global831 24)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 10)
								(= global831 6)
							)
							((== ([global841 32] checker:) -2)
								(= global830 10)
								(= global831 6)
							)
							((== ([global841 28] checker:) -2)
								(= global830 10)
								(= global831 6)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 32] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 28] checker:) -2)
								(= global830 19)
								(= global831 24)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					((== ([global841 6] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
							((== ([global841 28] checker:) -2)
								(= global830 23)
								(= global831 27)
							)
							((== ([global841 32] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 14)
								(= global831 9)
							)
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 9)
							)
							((== ([global841 32] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 9] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
							((== ([global841 32] checker:) -2)
								(= global830 19)
								(= global831 24)
							)
							((== ([global841 28] checker:) -2)
								(= global830 10)
								(= global831 14)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
							((== ([global841 32] checker:) -2)
								(= global830 10)
								(= global831 14)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 10)
								(= global831 6)
							)
							((== ([global841 32] checker:) -2)
								(= global830 10)
								(= global831 6)
							)
							((== ([global841 28] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 6] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
							((== ([global841 32] checker:) -2)
								(= global830 19)
								(= global831 24)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 28] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 32] checker:) -2)
								(= global830 19)
								(= global831 24)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					((== ([global841 9] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 10)
								(= global831 14)
							)
							((== ([global841 32] checker:) -2)
								(= global830 10)
								(= global831 14)
							)
							((== ([global841 28] checker:) -2)
								(= global830 23)
								(= global831 27)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
							((== ([global841 32] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
							((== ([global841 28] checker:) -2)
								(= global830 23)
								(= global831 27)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 10)
								(= global831 14)
							)
							((== ([global841 32] checker:) -2)
								(= global830 10)
								(= global831 14)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 6] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 15)
						(= global831 18)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 14)
						(= global831 10)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 9] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 18)
						(= global831 15)
					)
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					((== ([global841 9] checker:) -2)
						(cond
							((== ([global841 28] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
							((== ([global841 32] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
						)
					)
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 23)
						(= global831 19)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 28] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
							((== ([global841 32] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 6] checker:) -2)
						(cond
							((== ([global841 32] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
							((== ([global841 28] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
						)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 19)
						(= global831 23)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 32] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
							((== ([global841 28] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 9] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
							((== ([global841 28] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
							((== ([global841 28] checker:) -2)
								(= global830 23)
								(= global831 19)
							)
							((== ([global841 32] checker:) -2)
								(= global830 15)
								(= global831 18)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 6] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
							((== ([global841 32] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
						)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
							((== ([global841 32] checker:) -2)
								(= global830 19)
								(= global831 23)
							)
							((== ([global841 28] checker:) -2)
								(= global830 18)
								(= global831 15)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 9] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 9)
						(= global831 6)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 27] checker:) -2)
								(= global830 9)
								(= global831 6)
							)
							((== ([global841 28] checker:) -2)
								(= global830 9)
								(= global831 6)
							)
							((== ([global841 32] checker:) -2)
								(= global830 9)
								(= global831 6)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 6] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 6)
						(= global831 9)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 24] checker:) -2)
								(= global830 6)
								(= global831 9)
							)
							((== ([global841 32] checker:) -2)
								(= global830 6)
								(= global831 9)
							)
							((== ([global841 28] checker:) -2)
								(= global830 6)
								(= global831 9)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global841 9] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 23] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 9)
						(= global831 14)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 23)
						(= global831 27)
					)
				)
			)
			(
				(and
					(== ([global841 6] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 19] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 6)
						(= global831 10)
					)
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 19)
						(= global831 24)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 27)
						(= global831 24)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 27)
						(= global831 24)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 24)
						(= global831 27)
					)
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 24)
						(= global831 27)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 9] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 10)
						(= global831 14)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 27)
						(= global831 23)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 14)
						(= global831 9)
					)
				)
			)
			(
				(and
					(== ([global841 9] checker:) 2)
					(== ([global841 18] checker:) 2)
					(== ([global841 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 27)
						(= global831 23)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 9)
						(= global831 14)
					)
				)
			)
			(
				(and
					(== ([global841 10] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 10)
						(= global831 6)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 24)
						(= global831 19)
					)
				)
			)
			(
				(and
					(== ([global841 6] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 5] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 6)
						(= global831 10)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 32] checker:) -2)
						)
						(= global830 19)
						(= global831 24)
					)
					(
						(and
							(== ([global841 1] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 24)
						(= global831 19)
					)
				)
			)
			(
				(and
					(== ([global841 14] checker:) 2)
					(== ([global841 15] checker:) 2)
					(== ([global841 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global841 6] checker:) -2)
							(== ([global841 28] checker:) -2)
						)
						(= global830 14)
						(= global831 10)
					)
					((== ([global841 5] checker:) -2)
						(cond
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
							((== ([global841 32] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
						)
					)
					((== ([global841 1] checker:) -2)
						(cond
							((== ([global841 28] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
							((== ([global841 32] checker:) -2)
								(= global830 14)
								(= global831 10)
							)
						)
					)
				)
			)
		)
	)
)

(instance endGame4 of Code
	(properties)

	(method (doit)
		(= global829 0)
		(if
			(or
				(== (global806 toSqr:) 1)
				(== (global806 toSqr:) 2)
				(== (global806 toSqr:) 3)
				(== (global806 toSqr:) 4)
				(== (global806 toSqr:) 5)
				(== (global806 toSqr:) 13)
				(== (global806 toSqr:) 21)
				(== (global806 toSqr:) 29)
				(== (global806 toSqr:) 30)
				(== (global806 toSqr:) 31)
				(== (global806 toSqr:) 32)
				(== (global806 toSqr:) 28)
				(== (global806 toSqr:) 20)
				(== (global806 toSqr:) 12)
			)
			(-= global829 10)
		)
		(if
			(or
				(== (global806 toSqr:) 6)
				(== (global806 toSqr:) 7)
				(== (global806 toSqr:) 8)
				(== (global806 toSqr:) 16)
				(== (global806 toSqr:) 24)
				(== (global806 toSqr:) 11)
				(== (global806 toSqr:) 25)
			)
			(-= global829 5)
		)
		(if
			(or
				(== (global806 toSqr:) 9)
				(== (global806 toSqr:) 10)
				(== (global806 toSqr:) 15)
				(== (global806 toSqr:) 19)
				(== (global806 toSqr:) 27)
				(== (global806 toSqr:) 26)
				(== (global806 toSqr:) 22)
				(== (global806 toSqr:) 17)
			)
			(-= global829 2)
		)
		(if
			(or
				(and
					(== (global806 fromSqr:) 14)
					(!= ([global841 9] checker:) 2)
					(!= ([global841 10] checker:) 2)
					(!= ([global841 17] checker:) 2)
				)
				(and
					(== (global806 fromSqr:) 18)
					(!= ([global841 14] checker:) 2)
					(!= ([global841 15] checker:) 2)
					(!= ([global841 23] checker:) 2)
					(!= ([global841 22] checker:) 2)
				)
				(and
					(== (global806 fromSqr:) 23)
					(!= ([global841 19] checker:) 2)
					(!= ([global841 27] checker:) 2)
					(!= ([global841 26] checker:) 2)
				)
			)
			(-= global829 15)
		)
	)
)

(instance lostGame of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(if (== (global800 myColor:) -1)
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (< ([global841 temp2] checker:) 0)
					(for
						((= temp3 3))
						(>=
							temp3
							(if (== ([global841 temp2] checker:) -1) 2 else 0)
						)
						((-- temp3))
						
						(= temp0 ([global841 temp2] sqrOn: temp3))
						(= temp1 ([global841 temp0] sqrOn: temp3))
						(if
							(or
								(and
									(> ([global841 temp0] checker:) 0)
									(== ([global841 temp1] checker:) 0)
								)
								(== ([global841 temp0] checker:) 0)
							)
							(return 0)
						)
					)
				)
			)
		else
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (> ([global841 temp2] checker:) 0)
					(for
						((= temp3 0))
						(<=
							temp3
							(if (== ([global841 temp2] checker:) 1) 1 else 3)
						)
						((++ temp3))
						
						(= temp0 ([global841 temp2] sqrOn: temp3))
						(= temp1 ([global841 temp0] sqrOn: temp3))
						(if
							(or
								(and
									(< ([global841 temp0] checker:) 0)
									(== ([global841 temp1] checker:) 0)
								)
								(== ([global841 temp0] checker:) 0)
							)
							(return 0)
						)
					)
				)
			)
		)
		(return 1)
	)
)

(instance findLoop of Code
	(properties)

	(method (doit)
		(cond
			(
				(<
					(- (global189 prevX:) 10)
					(global189 x:)
					(+ (global189 prevX:) 10)
				)
				(if (< (global189 y:) (global189 prevY:))
					(global189 setLoop: 2)
				else
					(global189 setLoop: 3)
				)
			)
			(
				(<
					(- (global189 prevY:) 10)
					(global189 y:)
					(+ (global189 prevY:) 10)
				)
				(if (< (global189 x:) (global189 prevX:))
					(global189 setLoop: 0)
				else
					(global189 setLoop: 1)
				)
			)
			(
				(and
					(> (global189 x:) (global189 prevX:))
					(> (global189 y:) (global189 prevY:))
				)
				(global189 setLoop: 7)
			)
			(
				(and
					(> (global189 x:) (global189 prevX:))
					(< (global189 y:) (global189 prevY:))
				)
				(global189 setLoop: 5)
			)
			(
				(and
					(< (global189 x:) (global189 prevX:))
					(> (global189 y:) (global189 prevY:))
				)
				(global189 setLoop: 6)
			)
			(
				(and
					(< (global189 x:) (global189 prevX:))
					(< (global189 y:) (global189 prevY:))
				)
				(global189 setLoop: 4)
			)
		)
	)
)

