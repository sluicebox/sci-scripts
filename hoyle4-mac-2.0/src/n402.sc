;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use System)

(public
	proc402_0 0
)

(procedure (proc402_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(gWL eachElementDo: #offRating 0)
	(for ((= temp4 0)) (< temp4 (gWL size:)) ((++ temp4))
		(= temp2 ((= temp1 (gWL at: temp4)) rank:))
		(= temp3 (temp1 suit:))
		(if (temp1 rating:)
			(for
				((= temp5 (= temp0 0)))
				(< temp5 (gWL size:))
				((++ temp5))
				
				(if (== ((gWL at: temp5) rank:) temp2)
					(++ temp0)
				)
			)
			(if (== temp0 2)
				(temp1
					offRating:
						(+
							(temp1 offRating:)
							(- 2 (numInWorkingDeck doit: temp2))
						)
				)
			)
			(if
				(and
					(> temp2 2)
					(> (= temp8 (param1 hasCard: (- temp2 1) temp3)) -1)
					(or
						(not ((param1 at: temp8) bestGroup:))
						(==
							(param1 howManyOfRank: ((param1 at: temp8) rank:))
							4
						)
					)
				)
				(temp1
					offRating:
						(+
							(temp1 offRating:)
							(= temp7
								(-
									1
									(isCardInWorkingDeck
										doit: (- temp2 2) temp3
									)
								)
							)
						)
				)
				(if (< temp2 13)
					(temp1
						offRating:
							(+
								(temp1 offRating:)
								(= temp7
									(-
										1
										(isCardInWorkingDeck
											doit: (+ temp2 1) temp3
										)
									)
								)
							)
					)
				)
			)
			(if
				(and
					(< temp2 12)
					(> (= temp8 (param1 hasCard: (+ temp2 1) temp3)) -1)
					(or
						(not ((param1 at: temp8) bestGroup:))
						(==
							(param1 howManyOfRank: ((param1 at: temp8) rank:))
							4
						)
					)
				)
				(temp1
					offRating:
						(+
							(temp1 offRating:)
							(= temp7
								(-
									1
									(isCardInWorkingDeck
										doit: (+ temp2 2) temp3
									)
								)
							)
						)
				)
				(if (> temp2 1)
					(temp1
						offRating:
							(+
								(temp1 offRating:)
								(= temp7
									(-
										1
										(isCardInWorkingDeck
											doit: (- temp2 1) temp3
										)
									)
								)
							)
					)
				)
			)
			(if (== global196 0)
				(return)
			)
			(if
				(and
					(> temp2 2)
					(> (= temp8 (param1 hasCard: (- temp2 2) temp3)) -1)
					(or
						(not ((param1 at: temp8) bestGroup:))
						(==
							(param1 howManyOfRank: ((param1 at: temp8) rank:))
							4
						)
					)
				)
				(temp1
					offRating:
						(+
							(temp1 offRating:)
							(= temp7
								(-
									1
									(isCardInWorkingDeck
										doit: (- temp2 1) temp3
									)
								)
							)
						)
				)
			)
			(if
				(and
					(< temp2 12)
					(> (= temp8 (param1 hasCard: (+ temp2 2) temp3)) -1)
					(or
						(not ((param1 at: temp8) bestGroup:))
						(==
							(param1 howManyOfRank: ((param1 at: temp8) rank:))
							4
						)
					)
				)
				(temp1
					offRating:
						(+
							(temp1 offRating:)
							(= temp7
								(-
									1
									(isCardInWorkingDeck
										doit: (+ temp2 1) temp3
									)
								)
							)
						)
				)
			)
			(if (<= temp2 3)
				(temp1 offRating: (+ (temp1 offRating:) (- 4 temp2)))
			)
			(if
				(or
					(and (> global243 4) (>= temp2 10))
					(and (> global243 5) (>= temp2 9))
					(and (> global243 6) (>= temp2 8))
					(and (> global243 7) (>= temp2 7))
				)
				(temp1 offRating: (- (temp1 offRating:) (- global243 4)))
			)
		)
	)
)

(instance numInWorkingDeck of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(if (== (((ScriptID 15 1) at: temp0) rank:) param1) ; discardList
				(++ temp1)
			)
		)
		(return temp1)
	)
)

(instance isCardInWorkingDeck of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 ((ScriptID 15 1) size:)) ((++ temp0)) ; discardList
			(if
				(and
					(== (((ScriptID 15 1) at: temp0) rank:) param1) ; discardList
					(== (((ScriptID 15 1) at: temp0) suit:) param2) ; discardList
				)
				(return 1)
			)
		)
		(return 0)
	)
)

