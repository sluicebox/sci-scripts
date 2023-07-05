;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 403)
(include sci.sh)
(use Main)
(use System)

(public
	proc403_0 0
)

(procedure (proc403_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
	(for ((= temp0 0)) (< temp0 (gWL size:)) ((++ temp0))
		(= temp5 0)
		(= temp3 ((= temp1 (gWL at: temp0)) rank:))
		(= temp4 (temp1 suit:))
		(= temp6 0)
		(if
			(and
				(!= temp3 13)
				(== (param1 hasCard: (+ temp3 1) temp4) -1)
				(not (isCardInWorkingDeck doit: (+ temp3 1) temp4))
			)
			(= temp6 1)
			(++ temp5)
		)
		(= temp7 0)
		(if
			(and
				(!= temp3 1)
				(== (param1 hasCard: (- temp3 1) temp4) -1)
				(not (isCardInWorkingDeck doit: (- temp3 1) temp4))
			)
			(= temp7 1)
			(++ temp5)
		)
		(if
			(==
				(= temp2
					(-
						(= temp2 (- (= temp2 4) (param1 howManyOfRank: temp3)))
						(numInWorkingDeck doit: (temp1 rank:))
					)
				)
				3
			)
			(+= temp5 2)
		)
		(if (== temp2 2)
			(++ temp5)
		)
		(if (<= temp3 3)
			(+= temp5 (- 4 temp3))
		)
		(if (>= temp3 8)
			(-- temp5)
		)
		(= temp2 (gKnownCards howManyOfRank: temp3 1))
		(= temp9 (gKnownCards hasCard: (- temp3 1) temp4))
		(= temp11 (gKnownCards hasCard: (- temp3 2) temp4))
		(= temp10 (gKnownCards hasCard: (+ temp3 1) temp4))
		(= temp12 (gKnownCards hasCard: (+ temp3 2) temp4))
		(= temp8
			(+ (numInWorkingDeck doit: temp3) (param1 howManyOfRank: temp3))
		)
		(if (and (== temp2 1) (< (gKnownCards size:) 10))
			(if (== temp8 2)
				(+= temp5 2)
			else
				(+= temp5 4)
			)
		)
		(if (>= temp2 2)
			(= temp5 16)
		)
		(if (== global196 2)
			(if (>= temp9 0)
				(cond
					((>= temp11 0)
						(= temp5 16)
					)
					((>= temp10 0)
						(= temp5 16)
					)
					(else
						(if
							(and
								(not
									(isCardInWorkingDeck
										doit: (- temp3 2) temp4
									)
								)
								(== (param1 hasCard: (- temp3 2) temp4) -1)
							)
							(+= temp5 2)
						)
						(if temp6
							(+= temp5 2)
						)
					)
				)
			)
			(if (>= temp10 0)
				(cond
					((>= temp12 0)
						(= temp5 16)
					)
					((>= temp9 0)
						(= temp5 16)
					)
					(else
						(if
							(and
								(not
									(isCardInWorkingDeck
										doit: (+ temp3 2) temp4
									)
								)
								(== (param1 hasCard: (+ temp3 2) temp4) -1)
							)
							(+= temp5 2)
						)
						(if temp7
							(+= temp5 2)
						)
					)
				)
			)
			(if (!= temp5 16)
				(if (>= temp11 0)
					(+= temp5 1)
					(if temp7
						(+= temp5 1)
					)
				)
				(if (>= temp12 0)
					(+= temp5 1)
					(if temp6
						(+= temp5 1)
					)
				)
			)
		)
		(if (== temp0 (- (param1 size:) 1))
			(temp1 defRating: 15)
		)
		(temp1 offRating: (+ (temp1 offRating:) (/ temp5 5)) defRating: temp5)
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

