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
	(properties
		sel_20 {endGame1}
	)

	(method (sel_57)
		(= global263 0)
		(if
			(or
				(== (global240 sel_585:) 1)
				(== (global240 sel_585:) 2)
				(== (global240 sel_585:) 3)
				(== (global240 sel_585:) 4)
				(== (global240 sel_585:) 5)
				(== (global240 sel_585:) 13)
				(== (global240 sel_585:) 21)
				(== (global240 sel_585:) 29)
				(== (global240 sel_585:) 30)
				(== (global240 sel_585:) 31)
				(== (global240 sel_585:) 32)
				(== (global240 sel_585:) 28)
				(== (global240 sel_585:) 20)
				(== (global240 sel_585:) 12)
			)
			(-= global263 10)
		)
		(if
			(or
				(== (global240 sel_585:) 6)
				(== (global240 sel_585:) 7)
				(== (global240 sel_585:) 8)
				(== (global240 sel_585:) 16)
				(== (global240 sel_585:) 24)
				(== (global240 sel_585:) 27)
				(== (global240 sel_585:) 26)
				(== (global240 sel_585:) 25)
				(== (global240 sel_585:) 17)
				(== (global240 sel_585:) 9)
			)
			(-= global263 5)
		)
		(if
			(or
				(== (global240 sel_585:) 10)
				(== (global240 sel_585:) 11)
				(== (global240 sel_585:) 14)
				(== (global240 sel_585:) 22)
				(== (global240 sel_585:) 23)
				(== (global240 sel_585:) 19)
			)
			(-= global263 2)
		)
		(if
			(or
				(and
					(== (global240 sel_584:) 15)
					(!= ([global200 10] sel_574:) 2)
					(!= ([global200 11] sel_574:) 2)
					(!= ([global200 19] sel_574:) 2)
				)
				(and
					(== (global240 sel_584:) 18)
					(!= ([global200 14] sel_574:) 2)
					(!= ([global200 22] sel_574:) 2)
					(!= ([global200 23] sel_574:) 2)
				)
			)
			(-= global263 15)
		)
	)
)

(instance endGame2 of Code
	(properties
		sel_20 {endGame2}
	)

	(method (sel_57)
		(= global264 0)
		(= global265 0)
		(cond
			(
				(and
					(== ([global200 15] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
				)
				(cond
					(
						(or
							(== ([global200 24] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 18)
						(= global265 23)
					)
					(
						(or
							(== ([global200 28] sel_574:) -2)
							(== ([global200 27] sel_574:) -2)
						)
						(= global264 15)
						(= global265 19)
					)
					(
						(or
							(== ([global200 1] sel_574:) -2)
							(== ([global200 9] sel_574:) -2)
						)
						(= global264 15)
						(= global265 10)
					)
					(
						(or
							(== ([global200 5] sel_574:) -2)
							(== ([global200 6] sel_574:) -2)
						)
						(= global264 18)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 15] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(if
					(or
						(== ([global200 28] sel_574:) -2)
						(== ([global200 32] sel_574:) -2)
					)
					(= global264 15)
					(= global265 19)
				)
			)
			(
				(and
					(== ([global200 18] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(if
					(or
						(== ([global200 28] sel_574:) -2)
						(== ([global200 32] sel_574:) -2)
					)
					(= global264 18)
					(= global265 23)
				)
			)
			(
				(and
					(== ([global200 23] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 28] sel_574:) -2)
						(= global264 23)
						(= global265 27)
					)
					((== ([global200 32] sel_574:) -2)
						(= global264 19)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 23] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					((== ([global200 28] sel_574:) -2)
						(= global264 23)
						(= global265 19)
					)
					((== ([global200 32] sel_574:) -2)
						(= global264 24)
						(= global265 28)
					)
				)
			)
			(
				(and
					(== ([global200 27] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 28] sel_574:) -2)
						(= global264 27)
						(= global265 32)
					)
					((== ([global200 32] sel_574:) -2)
						(= global264 19)
						(= global265 23)
					)
				)
			)
			(
				(and
					(== ([global200 27] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					((== ([global200 28] sel_574:) -2)
						(= global264 27)
						(= global265 32)
					)
					((== ([global200 32] sel_574:) -2)
						(= global264 27)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 19] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					((== ([global200 28] sel_574:) -2)
						(= global264 24)
						(= global265 27)
					)
					((== ([global200 32] sel_574:) -2)
						(= global264 24)
						(= global265 28)
					)
				)
			)
			(
				(and
					(== ([global200 28] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 32] sel_574:) -2)
						(= global264 19)
						(= global265 24)
					)
					((== ([global200 27] sel_574:) -2)
						(= global264 28)
						(= global265 32)
					)
				)
			)
			(
				(and
					(== ([global200 19] sel_574:) 2)
					(== ([global200 32] sel_574:) 2)
				)
				(cond
					((== ([global200 31] sel_574:) -2)
						(= global264 19)
						(= global265 15)
					)
					((== ([global200 28] sel_574:) -2)
						(= global264 19)
						(= global265 23)
					)
				)
			)
			(
				(and
					(== ([global200 23] sel_574:) 2)
					(== ([global200 32] sel_574:) 2)
				)
				(cond
					(
						(or
							(== ([global200 27] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 23)
						(= global265 19)
					)
					((== ([global200 24] sel_574:) -2)
						(= global264 32)
						(= global265 28)
					)
				)
			)
			(
				(and
					(== ([global200 23] sel_574:) 2)
					(== ([global200 28] sel_574:) 2)
				)
				(cond
					((== ([global200 20] sel_574:) -2)
						(= global264 23)
						(= global265 18)
					)
					((== ([global200 32] sel_574:) -2)
						(= global264 23)
						(= global265 19)
					)
				)
			)
			(
				(and
					(== ([global200 18] sel_574:) 2)
					(== ([global200 10] sel_574:) 2)
				)
				(if
					(or
						(== ([global200 5] sel_574:) -2)
						(== ([global200 1] sel_574:) -2)
					)
					(= global264 18)
					(= global265 14)
				)
			)
			(
				(and
					(== ([global200 15] sel_574:) 2)
					(== ([global200 14] sel_574:) 2)
				)
				(if
					(or
						(== ([global200 5] sel_574:) -2)
						(== ([global200 1] sel_574:) -2)
					)
					(= global264 15)
					(= global265 10)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 14] sel_574:) 2)
				)
				(cond
					((== ([global200 5] sel_574:) -2)
						(= global264 10)
						(= global265 6)
					)
					((== ([global200 1] sel_574:) -2)
						(= global264 14)
						(= global265 9)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 9] sel_574:) 2)
				)
				(cond
					((== ([global200 5] sel_574:) -2)
						(= global264 10)
						(= global265 14)
					)
					((== ([global200 1] sel_574:) -2)
						(= global264 9)
						(= global265 5)
					)
				)
			)
			(
				(and
					(== ([global200 6] sel_574:) 2)
					(== ([global200 14] sel_574:) 2)
				)
				(cond
					((== ([global200 5] sel_574:) -2)
						(= global264 6)
						(= global265 1)
					)
					((== ([global200 1] sel_574:) -2)
						(= global264 14)
						(= global265 10)
					)
				)
			)
			(
				(and
					(== ([global200 6] sel_574:) 2)
					(== ([global200 10] sel_574:) 2)
				)
				(cond
					((== ([global200 5] sel_574:) -2)
						(= global264 6)
						(= global265 1)
					)
					((== ([global200 1] sel_574:) -2)
						(= global264 6)
						(= global265 9)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 9] sel_574:) 2)
				)
				(cond
					((== ([global200 5] sel_574:) -2)
						(= global264 9)
						(= global265 6)
					)
					((== ([global200 1] sel_574:) -2)
						(= global264 9)
						(= global265 5)
					)
				)
			)
			(
				(and
					(== ([global200 5] sel_574:) 2)
					(== ([global200 14] sel_574:) 2)
				)
				(cond
					((== ([global200 1] sel_574:) -2)
						(= global264 14)
						(= global265 9)
					)
					((== ([global200 6] sel_574:) -2)
						(= global264 5)
						(= global265 1)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 1] sel_574:) 2)
				)
				(cond
					((== ([global200 2] sel_574:) -2)
						(= global264 14)
						(= global265 18)
					)
					((== ([global200 5] sel_574:) -2)
						(= global264 14)
						(= global265 10)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 1] sel_574:) 2)
				)
				(cond
					(
						(or
							(== ([global200 6] sel_574:) -2)
							(== ([global200 5] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					((== ([global200 9] sel_574:) -2)
						(= global264 1)
						(= global265 5)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 5] sel_574:) 2)
				)
				(cond
					((== ([global200 13] sel_574:) -2)
						(= global264 10)
						(= global265 15)
					)
					((== ([global200 1] sel_574:) -2)
						(= global264 10)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 18] sel_574:) 2)
					(== ([global200 1] sel_574:) 2)
				)
				(if (== ([global200 7] sel_574:) -2)
					(= global264 18)
					(= global265 15)
				)
			)
			(
				(and
					(== ([global200 15] sel_574:) 2)
					(== ([global200 32] sel_574:) 2)
				)
				(if (== ([global200 26] sel_574:) -2)
					(= global264 15)
					(= global265 18)
				)
			)
			(
				(and
					(== ([global200 15] sel_574:) 2)
					(== ([global200 5] sel_574:) 2)
				)
				(if (== ([global200 17] sel_574:) -2)
					(= global264 15)
					(= global265 18)
				)
			)
			(
				(and
					(== ([global200 18] sel_574:) 2)
					(== ([global200 28] sel_574:) 2)
					(== ([global200 16] sel_574:) -2)
				)
				(= global264 18)
				(= global265 15)
			)
		)
	)
)

(instance endGame3 of Code
	(properties
		sel_20 {endGame3}
	)

	(method (sel_57)
		(= global264 0)
		(= global265 0)
		(cond
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					((== ([global200 6] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 23)
								(= global265 27)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 14)
								(= global265 9)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 23)
								(= global265 27)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 9] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 10)
								(= global265 6)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					((== ([global200 6] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 23)
								(= global265 27)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 9)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 9] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 19)
								(= global265 24)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 10)
								(= global265 14)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 10)
								(= global265 14)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 10)
								(= global265 6)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 6] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 19)
								(= global265 24)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					((== ([global200 9] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 10)
								(= global265 14)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 10)
								(= global265 14)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 23)
								(= global265 27)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 23)
								(= global265 27)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 10)
								(= global265 14)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 10)
								(= global265 14)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 27] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 6] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 15)
						(= global265 18)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 14)
						(= global265 10)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 9] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 18)
						(= global265 15)
					)
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					((== ([global200 9] sel_574:) -2)
						(cond
							((== ([global200 28] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 23)
						(= global265 19)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 28] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 6] sel_574:) -2)
						(cond
							((== ([global200 32] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 19)
						(= global265 23)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 32] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 9] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 23)
								(= global265 19)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 15)
								(= global265 18)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 6] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 19)
								(= global265 23)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 18)
								(= global265 15)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 9] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 9)
						(= global265 6)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 27] sel_574:) -2)
								(= global264 9)
								(= global265 6)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 9)
								(= global265 6)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 9)
								(= global265 6)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 6] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 6)
						(= global265 9)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 24] sel_574:) -2)
								(= global264 6)
								(= global265 9)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 6)
								(= global265 9)
							)
							((== ([global200 28] sel_574:) -2)
								(= global264 6)
								(= global265 9)
							)
						)
					)
				)
			)
			(
				(and
					(== ([global200 9] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 23] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 9)
						(= global265 14)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 23)
						(= global265 27)
					)
				)
			)
			(
				(and
					(== ([global200 6] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 19] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 6)
						(= global265 10)
					)
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 19)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 27] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 27)
						(= global265 24)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 27)
						(= global265 24)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 24)
						(= global265 27)
					)
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 24)
						(= global265 27)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 27] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 9] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 10)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 27] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 27)
						(= global265 23)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 14)
						(= global265 9)
					)
				)
			)
			(
				(and
					(== ([global200 9] sel_574:) 2)
					(== ([global200 18] sel_574:) 2)
					(== ([global200 27] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 27)
						(= global265 23)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 9)
						(= global265 14)
					)
				)
			)
			(
				(and
					(== ([global200 10] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 10)
						(= global265 6)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 24)
						(= global265 19)
					)
				)
			)
			(
				(and
					(== ([global200 6] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 5] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 6)
						(= global265 10)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 32] sel_574:) -2)
						)
						(= global264 19)
						(= global265 24)
					)
					(
						(and
							(== ([global200 1] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 24)
						(= global265 19)
					)
				)
			)
			(
				(and
					(== ([global200 14] sel_574:) 2)
					(== ([global200 15] sel_574:) 2)
					(== ([global200 24] sel_574:) 2)
				)
				(cond
					(
						(and
							(== ([global200 6] sel_574:) -2)
							(== ([global200 28] sel_574:) -2)
						)
						(= global264 14)
						(= global265 10)
					)
					((== ([global200 5] sel_574:) -2)
						(cond
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 32] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
						)
					)
					((== ([global200 1] sel_574:) -2)
						(cond
							((== ([global200 28] sel_574:) -2)
								(= global264 14)
								(= global265 10)
							)
							((== ([global200 32] sel_574:) -2)
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
	(properties
		sel_20 {endGame4}
	)

	(method (sel_57)
		(= global263 0)
		(if
			(or
				(== (global240 sel_585:) 1)
				(== (global240 sel_585:) 2)
				(== (global240 sel_585:) 3)
				(== (global240 sel_585:) 4)
				(== (global240 sel_585:) 5)
				(== (global240 sel_585:) 13)
				(== (global240 sel_585:) 21)
				(== (global240 sel_585:) 29)
				(== (global240 sel_585:) 30)
				(== (global240 sel_585:) 31)
				(== (global240 sel_585:) 32)
				(== (global240 sel_585:) 28)
				(== (global240 sel_585:) 20)
				(== (global240 sel_585:) 12)
			)
			(-= global263 10)
		)
		(if
			(or
				(== (global240 sel_585:) 6)
				(== (global240 sel_585:) 7)
				(== (global240 sel_585:) 8)
				(== (global240 sel_585:) 16)
				(== (global240 sel_585:) 24)
				(== (global240 sel_585:) 11)
				(== (global240 sel_585:) 25)
			)
			(-= global263 5)
		)
		(if
			(or
				(== (global240 sel_585:) 9)
				(== (global240 sel_585:) 10)
				(== (global240 sel_585:) 15)
				(== (global240 sel_585:) 19)
				(== (global240 sel_585:) 27)
				(== (global240 sel_585:) 26)
				(== (global240 sel_585:) 22)
				(== (global240 sel_585:) 17)
			)
			(-= global263 2)
		)
		(if
			(or
				(and
					(== (global240 sel_584:) 14)
					(!= ([global200 9] sel_574:) 2)
					(!= ([global200 10] sel_574:) 2)
					(!= ([global200 17] sel_574:) 2)
				)
				(and
					(== (global240 sel_584:) 18)
					(!= ([global200 14] sel_574:) 2)
					(!= ([global200 15] sel_574:) 2)
					(!= ([global200 23] sel_574:) 2)
					(!= ([global200 22] sel_574:) 2)
				)
				(and
					(== (global240 sel_584:) 23)
					(!= ([global200 19] sel_574:) 2)
					(!= ([global200 27] sel_574:) 2)
					(!= ([global200 26] sel_574:) 2)
				)
			)
			(-= global263 15)
		)
	)
)

(instance lostGame of Code
	(properties
		sel_20 {lostGame}
	)

	(method (sel_57 &tmp temp0 temp1 temp2 temp3)
		(if (== (global178 sel_526:) -1)
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (< ([global200 temp2] sel_574:) 0)
					(for
						((= temp3 3))
						(>=
							temp3
							(if (== ([global200 temp2] sel_574:) -1) 2 else 0)
						)
						((-- temp3))
						
						(= temp0 ([global200 temp2] sel_575: temp3))
						(= temp1 ([global200 temp0] sel_575: temp3))
						(if
							(or
								(and
									(> ([global200 temp0] sel_574:) 0)
									(== ([global200 temp1] sel_574:) 0)
								)
								(== ([global200 temp0] sel_574:) 0)
							)
							(return 0)
						)
					)
				)
			)
		else
			(for ((= temp2 1)) (< temp2 33) ((++ temp2))
				(if (> ([global200 temp2] sel_574:) 0)
					(for
						((= temp3 0))
						(<=
							temp3
							(if (== ([global200 temp2] sel_574:) 1) 1 else 3)
						)
						((++ temp3))
						
						(= temp0 ([global200 temp2] sel_575: temp3))
						(= temp1 ([global200 temp0] sel_575: temp3))
						(if
							(or
								(and
									(< ([global200 temp0] sel_574:) 0)
									(== ([global200 temp1] sel_574:) 0)
								)
								(== ([global200 temp0] sel_574:) 0)
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
	(properties
		sel_20 {findLoop}
	)

	(method (sel_57)
		(cond
			(
				(<
					(- (global181 sel_418:) 10)
					(global181 sel_1:)
					(+ (global181 sel_418:) 10)
				)
				(if (< (global181 sel_0:) (global181 sel_419:))
					(global181 sel_165: 2)
				else
					(global181 sel_165: 3)
				)
			)
			(
				(<
					(- (global181 sel_419:) 10)
					(global181 sel_0:)
					(+ (global181 sel_419:) 10)
				)
				(if (< (global181 sel_1:) (global181 sel_418:))
					(global181 sel_165: 0)
				else
					(global181 sel_165: 1)
				)
			)
			(
				(and
					(> (global181 sel_1:) (global181 sel_418:))
					(> (global181 sel_0:) (global181 sel_419:))
				)
				(global181 sel_165: 7)
			)
			(
				(and
					(> (global181 sel_1:) (global181 sel_418:))
					(< (global181 sel_0:) (global181 sel_419:))
				)
				(global181 sel_165: 5)
			)
			(
				(and
					(< (global181 sel_1:) (global181 sel_418:))
					(> (global181 sel_0:) (global181 sel_419:))
				)
				(global181 sel_165: 6)
			)
			(
				(and
					(< (global181 sel_1:) (global181 sel_418:))
					(< (global181 sel_0:) (global181 sel_419:))
				)
				(global181 sel_165: 4)
			)
		)
	)
)

