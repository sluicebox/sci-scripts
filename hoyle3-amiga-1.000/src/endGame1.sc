;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
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
		(= global263 0)
		(if
			(or
				(== (global240 toSqr:) 1)
				(== (global240 toSqr:) 2)
				(== (global240 toSqr:) 3)
				(== (global240 toSqr:) 4)
				(== (global240 toSqr:) 5)
				(== (global240 toSqr:) 13)
				(== (global240 toSqr:) 21)
				(== (global240 toSqr:) 29)
				(== (global240 toSqr:) 30)
				(== (global240 toSqr:) 31)
				(== (global240 toSqr:) 32)
				(== (global240 toSqr:) 28)
				(== (global240 toSqr:) 20)
				(== (global240 toSqr:) 12)
			)
			(-= global263 10)
		)
		(if
			(or
				(== (global240 toSqr:) 6)
				(== (global240 toSqr:) 7)
				(== (global240 toSqr:) 8)
				(== (global240 toSqr:) 16)
				(== (global240 toSqr:) 24)
				(== (global240 toSqr:) 27)
				(== (global240 toSqr:) 26)
				(== (global240 toSqr:) 25)
				(== (global240 toSqr:) 17)
				(== (global240 toSqr:) 9)
			)
			(-= global263 5)
		)
		(if
			(or
				(== (global240 toSqr:) 10)
				(== (global240 toSqr:) 11)
				(== (global240 toSqr:) 14)
				(== (global240 toSqr:) 22)
				(== (global240 toSqr:) 23)
				(== (global240 toSqr:) 19)
			)
			(-= global263 2)
		)
		(if
			(or
				(and
					(== (global240 fromSqr:) 15)
					(!= ([global200 10] checker:) 2)
					(!= ([global200 11] checker:) 2)
					(!= ([global200 19] checker:) 2)
				)
				(and
					(== (global240 fromSqr:) 18)
					(!= ([global200 14] checker:) 2)
					(!= ([global200 22] checker:) 2)
					(!= ([global200 23] checker:) 2)
				)
			)
			(-= global263 15)
		)
	)
)

(instance endGame2 of Code
	(properties)

	(method (doit)
		(= global264 0)
		(= global265 0)
		(cond
			(
				(and
					(== ([global200 15] checker:) 2)
					(== ([global200 18] checker:) 2)
				)
				(cond
					(
						(or
							(== ([global200 24] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 18)
						(= global265 23)
					)
					(
						(or
							(== ([global200 28] checker:) -2)
							(== ([global200 27] checker:) -2)
						)
						(= global264 15)
						(= global265 19)
					)
					(
						(or
							(== ([global200 1] checker:) -2)
							(== ([global200 9] checker:) -2)
						)
						(= global264 15)
						(= global265 10)
					)
					(
						(or
							(== ([global200 5] checker:) -2)
							(== ([global200 6] checker:) -2)
						)
						(= global264 18)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 15] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(if
					(or
						(== ([global200 28] checker:) -2)
						(== ([global200 32] checker:) -2)
					)
					(= global264 15)
					(= global265 19)
				)
			)
			(
				(and
					(== ([global200 18] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(if
					(or
						(== ([global200 28] checker:) -2)
						(== ([global200 32] checker:) -2)
					)
					(= global264 18)
					(= global265 23)
				)
			)
			(
				(and
					(== ([global200 23] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 28] checker:) -2)
						(= global264 23)
						(= global265 27)
					)
					((== ([global200 32] checker:) -2)
						(= global264 19)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 23] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					((== ([global200 28] checker:) -2)
						(= global264 23)
						(= global265 19)
					)
					((== ([global200 32] checker:) -2)
						(= global264 24)
						(= global265 28)
					)
				)
			)
			(
				(and
					(== ([global200 27] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 28] checker:) -2)
						(= global264 27)
						(= global265 32)
					)
					((== ([global200 32] checker:) -2)
						(= global264 19)
						(= global265 23)
					)
				)
			)
			(
				(and
					(== ([global200 27] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					((== ([global200 28] checker:) -2)
						(= global264 27)
						(= global265 32)
					)
					((== ([global200 32] checker:) -2)
						(= global264 27)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 19] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					((== ([global200 28] checker:) -2)
						(= global264 24)
						(= global265 27)
					)
					((== ([global200 32] checker:) -2)
						(= global264 24)
						(= global265 28)
					)
				)
			)
			(
				(and
					(== ([global200 28] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 32] checker:) -2)
						(= global264 19)
						(= global265 24)
					)
					((== ([global200 27] checker:) -2)
						(= global264 28)
						(= global265 32)
					)
				)
			)
			(
				(and
					(== ([global200 19] checker:) 2)
					(== ([global200 32] checker:) 2)
				)
				(cond
					((== ([global200 31] checker:) -2)
						(= global264 19)
						(= global265 15)
					)
					((== ([global200 28] checker:) -2)
						(= global264 19)
						(= global265 23)
					)
				)
			)
			(
				(and
					(== ([global200 23] checker:) 2)
					(== ([global200 32] checker:) 2)
				)
				(cond
					(
						(or
							(== ([global200 27] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 23)
						(= global265 19)
					)
					((== ([global200 24] checker:) -2)
						(= global264 32)
						(= global265 28)
					)
				)
			)
			(
				(and
					(== ([global200 23] checker:) 2)
					(== ([global200 28] checker:) 2)
				)
				(cond
					((== ([global200 20] checker:) -2)
						(= global264 23)
						(= global265 18)
					)
					((== ([global200 32] checker:) -2)
						(= global264 23)
						(= global265 19)
					)
				)
			)
			(
				(and
					(== ([global200 18] checker:) 2)
					(== ([global200 10] checker:) 2)
				)
				(if
					(or
						(== ([global200 5] checker:) -2)
						(== ([global200 1] checker:) -2)
					)
					(= global264 18)
					(= global265 14)
				)
			)
			(
				(and
					(== ([global200 15] checker:) 2)
					(== ([global200 14] checker:) 2)
				)
				(if
					(or
						(== ([global200 5] checker:) -2)
						(== ([global200 1] checker:) -2)
					)
					(= global264 15)
					(= global265 10)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 14] checker:) 2)
				)
				(cond
					((== ([global200 5] checker:) -2)
						(= global264 10)
						(= global265 6)
					)
					((== ([global200 1] checker:) -2)
						(= global264 14)
						(= global265 9)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 9] checker:) 2)
				)
				(cond
					((== ([global200 5] checker:) -2)
						(= global264 10)
						(= global265 14)
					)
					((== ([global200 1] checker:) -2)
						(= global264 9)
						(= global265 5)
					)
				)
			)
			(
				(and
					(== ([global200 6] checker:) 2)
					(== ([global200 14] checker:) 2)
				)
				(cond
					((== ([global200 5] checker:) -2)
						(= global264 6)
						(= global265 1)
					)
					((== ([global200 1] checker:) -2)
						(= global264 14)
						(= global265 10)
					)
				)
			)
			(
				(and
					(== ([global200 6] checker:) 2)
					(== ([global200 10] checker:) 2)
				)
				(cond
					((== ([global200 5] checker:) -2)
						(= global264 6)
						(= global265 1)
					)
					((== ([global200 1] checker:) -2)
						(= global264 6)
						(= global265 9)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 9] checker:) 2)
				)
				(cond
					((== ([global200 5] checker:) -2)
						(= global264 9)
						(= global265 6)
					)
					((== ([global200 1] checker:) -2)
						(= global264 9)
						(= global265 5)
					)
				)
			)
			(
				(and
					(== ([global200 5] checker:) 2)
					(== ([global200 14] checker:) 2)
				)
				(cond
					((== ([global200 1] checker:) -2)
						(= global264 14)
						(= global265 9)
					)
					((== ([global200 6] checker:) -2)
						(= global264 5)
						(= global265 1)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 1] checker:) 2)
				)
				(cond
					((== ([global200 2] checker:) -2)
						(= global264 14)
						(= global265 18)
					)
					((== ([global200 5] checker:) -2)
						(= global264 14)
						(= global265 10)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 1] checker:) 2)
				)
				(cond
					(
						(or
							(== ([global200 6] checker:) -2)
							(== ([global200 5] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					((== ([global200 9] checker:) -2)
						(= global264 1)
						(= global265 5)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 5] checker:) 2)
				)
				(cond
					((== ([global200 13] checker:) -2)
						(= global264 10)
						(= global265 15)
					)
					((== ([global200 1] checker:) -2)
						(= global264 10)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 18] checker:) 2)
					(== ([global200 1] checker:) 2)
				)
				(if (== ([global200 7] checker:) -2)
					(= global264 18)
					(= global265 15)
				)
			)
			(
				(and
					(== ([global200 15] checker:) 2)
					(== ([global200 32] checker:) 2)
				)
				(if (== ([global200 26] checker:) -2)
					(= global264 15)
					(= global265 18)
				)
			)
			(
				(and
					(== ([global200 15] checker:) 2)
					(== ([global200 5] checker:) 2)
				)
				(if (== ([global200 17] checker:) -2)
					(= global264 15)
					(= global265 18)
				)
			)
			(
				(and
					(== ([global200 18] checker:) 2)
					(== ([global200 28] checker:) 2)
					(== ([global200 16] checker:) -2)
				)
				(= global264 18)
				(= global265 15)
			)
		)
	)
)

(instance endGame3 of Code
	(properties)

	(method (doit)
		(= global264 0)
		(= global265 0)
		(cond
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					((== ([global200 6] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] checker:) -2)
								(= global264 23)
								(= global265 27)
							)
							((== ([global200 28] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 32] checker:) -2)
								(= global264 14)
								(= global265 9)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 28] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] checker:) -2)
								(= global264 23)
								(= global265 27)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 9] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 32] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] checker:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 32] checker:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 28] checker:) -2)
								(= global264 10)
								(= global265 6)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 32] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] checker:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					((== ([global200 6] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 28] checker:) -2)
								(= global264 23)
								(= global265 27)
							)
							((== ([global200 32] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 32] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 9] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 32] checker:) -2)
								(= global264 19)
								(= global265 24)
							)
							((== ([global200 28] checker:) -2)
								(= global264 10)
								(= global265 14)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 32] checker:) -2)
								(= global264 10)
								(= global265 14)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 32] checker:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 28] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 6] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 32] checker:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 32] checker:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					((== ([global200 9] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 10)
								(= global265 14)
							)
							((== ([global200 32] checker:) -2)
								(= global264 10)
								(= global265 14)
							)
							((== ([global200 28] checker:) -2)
								(= global264 23)
								(= global265 27)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 28] checker:) -2)
								(= global264 23)
								(= global265 27)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 10)
								(= global265 14)
							)
							((== ([global200 32] checker:) -2)
								(= global264 10)
								(= global265 14)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 6] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 15)
						(= global265 18)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 14)
						(= global265 10)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 9] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 18)
						(= global265 15)
					)
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					((== ([global200 9] checker:) -2)
						(cond
							((== ([global200 28] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 32] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 23)
						(= global265 19)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 28] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 32] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 6] checker:) -2)
						(cond
							((== ([global200 32] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 28] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 19)
						(= global265 23)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 32] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 28] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 9] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 28] checker:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 32] checker:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 6] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 32] checker:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 28] checker:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 9] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 9)
						(= global265 6)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 27] checker:) -2)
								(= global264 9)
								(= global265 6)
							)
							((== ([global200 28] checker:) -2)
								(= global264 9)
								(= global265 6)
							)
							((== ([global200 32] checker:) -2)
								(= global264 9)
								(= global265 6)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 6] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 6)
						(= global265 9)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 24] checker:) -2)
								(= global264 6)
								(= global265 9)
							)
							((== ([global200 32] checker:) -2)
								(= global264 6)
								(= global265 9)
							)
							((== ([global200 28] checker:) -2)
								(= global264 6)
								(= global265 9)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 9] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 23] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 9)
						(= global265 14)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 23)
						(= global265 27)
					)
				)
			)
			(
				(and
					(== ([global200 6] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 19] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 6)
						(= global265 10)
					)
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 19)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 27)
						(= global265 24)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 27)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 24)
						(= global265 27)
					)
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 24)
						(= global265 27)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 9] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 27)
						(= global265 23)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 14)
						(= global265 9)
					)
				)
			)
			(
				(and
					(== ([global200 9] checker:) 2)
					(== ([global200 18] checker:) 2)
					(== ([global200 27] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 27)
						(= global265 23)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 9)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 10] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 10)
						(= global265 6)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 24)
						(= global265 19)
					)
				)
			)
			(
				(and
					(== ([global200 6] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 6)
						(= global265 10)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 32] checker:) -2)
						)
						(= global264 19)
						(= global265 24)
					)
					(
						(and
							(== ([global200 1] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 24)
						(= global265 19)
					)
				)
			)
			(
				(and
					(== ([global200 14] checker:) 2)
					(== ([global200 15] checker:) 2)
					(== ([global200 24] checker:) 2)
				)
				(cond
					(
						(and
							(== ([global200 6] checker:) -2)
							(== ([global200 28] checker:) -2)
						)
						(= global264 14)
						(= global265 10)
					)
					((== ([global200 5] checker:) -2)
						(cond
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 32] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
					((== ([global200 1] checker:) -2)
						(cond
							((== ([global200 28] checker:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 32] checker:) -2)
								(= global264 14)
								(= global265 10)
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
		(= global263 0)
		(if
			(or
				(== (global240 toSqr:) 1)
				(== (global240 toSqr:) 2)
				(== (global240 toSqr:) 3)
				(== (global240 toSqr:) 4)
				(== (global240 toSqr:) 5)
				(== (global240 toSqr:) 13)
				(== (global240 toSqr:) 21)
				(== (global240 toSqr:) 29)
				(== (global240 toSqr:) 30)
				(== (global240 toSqr:) 31)
				(== (global240 toSqr:) 32)
				(== (global240 toSqr:) 28)
				(== (global240 toSqr:) 20)
				(== (global240 toSqr:) 12)
			)
			(-= global263 10)
		)
		(if
			(or
				(== (global240 toSqr:) 6)
				(== (global240 toSqr:) 7)
				(== (global240 toSqr:) 8)
				(== (global240 toSqr:) 16)
				(== (global240 toSqr:) 24)
				(== (global240 toSqr:) 11)
				(== (global240 toSqr:) 25)
			)
			(-= global263 5)
		)
		(if
			(or
				(== (global240 toSqr:) 9)
				(== (global240 toSqr:) 10)
				(== (global240 toSqr:) 15)
				(== (global240 toSqr:) 19)
				(== (global240 toSqr:) 27)
				(== (global240 toSqr:) 26)
				(== (global240 toSqr:) 22)
				(== (global240 toSqr:) 17)
			)
			(-= global263 2)
		)
		(if
			(or
				(and
					(== (global240 fromSqr:) 14)
					(!= ([global200 9] checker:) 2)
					(!= ([global200 10] checker:) 2)
					(!= ([global200 17] checker:) 2)
				)
				(and
					(== (global240 fromSqr:) 18)
					(!= ([global200 14] checker:) 2)
					(!= ([global200 15] checker:) 2)
					(!= ([global200 23] checker:) 2)
					(!= ([global200 22] checker:) 2)
				)
				(and
					(== (global240 fromSqr:) 23)
					(!= ([global200 19] checker:) 2)
					(!= ([global200 27] checker:) 2)
					(!= ([global200 26] checker:) 2)
				)
			)
			(-= global263 15)
		)
	)
)

(instance lostGame of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(if (== (global178 myColor:) -1)
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (< ([global200 temp2] checker:) 0)
					(for
						((= temp3 3))
						(>=
							temp3
							(if (== ([global200 temp2] checker:) -1) 2 else 0)
						)
						((-- temp3))
						
						(= temp0 ([global200 temp2] sqrOn: temp3))
						(= temp1 ([global200 temp0] sqrOn: temp3))
						(if
							(or
								(and
									(> ([global200 temp0] checker:) 0)
									(== ([global200 temp1] checker:) 0)
								)
								(== ([global200 temp0] checker:) 0)
							)
							(return 0)
						)
					)
				)
			)
		else
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (> ([global200 temp2] checker:) 0)
					(for
						((= temp3 0))
						(<=
							temp3
							(if (== ([global200 temp2] checker:) 1) 1 else 3)
						)
						((++ temp3))
						
						(= temp0 ([global200 temp2] sqrOn: temp3))
						(= temp1 ([global200 temp0] sqrOn: temp3))
						(if
							(or
								(and
									(< ([global200 temp0] checker:) 0)
									(== ([global200 temp1] checker:) 0)
								)
								(== ([global200 temp0] checker:) 0)
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
					(- (global181 prevX:) 10)
					(global181 x:)
					(+ (global181 prevX:) 10)
				)
				(if (< (global181 y:) (global181 prevY:))
					(global181 setLoop: 2)
				else
					(global181 setLoop: 3)
				)
			)
			(
				(<
					(- (global181 prevY:) 10)
					(global181 y:)
					(+ (global181 prevY:) 10)
				)
				(if (< (global181 x:) (global181 prevX:))
					(global181 setLoop: 0)
				else
					(global181 setLoop: 1)
				)
			)
			(
				(and
					(> (global181 x:) (global181 prevX:))
					(> (global181 y:) (global181 prevY:))
				)
				(global181 setLoop: 7)
			)
			(
				(and
					(> (global181 x:) (global181 prevX:))
					(< (global181 y:) (global181 prevY:))
				)
				(global181 setLoop: 5)
			)
			(
				(and
					(< (global181 x:) (global181 prevX:))
					(> (global181 y:) (global181 prevY:))
				)
				(global181 setLoop: 6)
			)
			(
				(and
					(< (global181 x:) (global181 prevX:))
					(< (global181 y:) (global181 prevY:))
				)
				(global181 setLoop: 4)
			)
		)
	)
)

