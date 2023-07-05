;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 404)
(include sci.sh)
(use Main)
(use System)

(public
	proc404_0 0
)

(procedure (proc404_0 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(if (== ((ScriptID 400 2) upCard:) (param1 passedOnCard:)) ; discardPile
		(param1 passedOnCard: 0)
		(return 0)
	)
	(= temp7 (((ScriptID 400 2) upCard:) rank:)) ; discardPile
	(for ((= temp2 (= temp4 0))) (< temp2 (param1 size:)) ((++ temp2))
		(= temp0 (param1 at: temp2))
		(if
			(and
				(== (temp0 rank:) temp7)
				(or (not (temp0 bestGroup:)) (> (temp0 bestGroup:) 100))
			)
			(++ temp4)
		)
	)
	(if (>= temp4 2)
		(return 1)
	else
		(= temp5 (param1 makeSuitList: (((ScriptID 400 2) upCard:) suit:))) ; discardPile
		((ScriptID 400 4) add: temp5) ; disposeList
		(for ((= temp2 0)) (< temp2 (param1 size:)) ((++ temp2))
			(= temp0 (param1 at: temp2))
			(if
				(and
					(== (temp0 suit:) (((ScriptID 400 2) upCard:) suit:)) ; discardPile
					(> (temp0 bestGroup:) 100)
				)
				(temp5 delete: temp0)
			)
		)
		(for ((= temp2 (= temp6 0))) (< temp2 (temp5 size:)) ((++ temp2))
			(if (> ((temp5 at: temp2) rank:) temp7)
				(if temp2
					(temp5
						addAfter:
							(temp5 at: (- temp2 1))
							((ScriptID 400 2) upCard:) ; discardPile
					)
				else
					(temp5 addToFront: ((ScriptID 400 2) upCard:)) ; discardPile
				)
				(break)
			)
		)
		(if (not temp6)
			(temp5 add: ((ScriptID 400 2) upCard:)) ; discardPile
		)
		(temp5 eachElementDo: #rating 0)
		(for ((= temp2 0)) (< temp2 (- (temp5 size:) 2)) ((++ temp2))
			(= temp0 (temp5 at: temp2))
			(if
				(and
					(== (+ (temp0 rank:) 1) ((temp5 at: (+ temp2 1)) rank:))
					(== (+ (temp0 rank:) 2) ((temp5 at: (+ temp2 2)) rank:))
				)
				(temp0 rating: 1)
				((temp5 at: (+ temp2 1)) rating: 1)
				((temp5 at: (+ temp2 2)) rating: 1)
			)
		)
		((ScriptID 400 4) delete: temp5) ; disposeList
		(temp5 release: dispose:)
		(if (((ScriptID 400 2) upCard:) rating:) ; discardPile
			(return 1)
		)
	)
	(if (<= global243 1)
		(param1 calcGroups:)
		(if (= temp4 (param1 howManyOfRank: temp7))
			(for ((= temp1 0)) (< temp1 (param1 size:)) ((++ temp1))
				(if
					(and
						(== ((param1 at: temp1) rank:) temp7)
						((param1 at: temp1) bestGroup:)
					)
					(-- temp4)
				)
			)
		)
		(if (<= temp7 3)
			(return (Random 0 (- 4 temp7)))
		)
		(if
			(and
				(<= temp7 8)
				(or
					temp4
					(and
						(>
							(= temp1
								(param1
									hasCard:
										(- temp7 1)
										(((ScriptID 400 2) upCard:) suit:) ; discardPile
								)
							)
							-1
						)
						(not ((param1 at: temp1) bestGroup:))
					)
					(and
						(>
							(= temp1
								(param1
									hasCard:
										(+ temp7 1)
										(((ScriptID 400 2) upCard:) suit:) ; discardPile
								)
							)
							-1
						)
						(not ((param1 at: temp1) bestGroup:))
					)
				)
			)
			(return 1)
		)
	)
	(if
		(and
			(< temp7 8)
			(<=
				(- (param1 bestDeadWood:) (- (param1 highestDeadWood:) temp7))
				param2
			)
		)
		(return 1)
	)
	(if (>= global243 3)
		(for ((= temp1 0)) (< temp1 (param1 size:)) ((++ temp1))
			(if (not ((param1 at: temp1) bestGroup:))
				((param1 deadWoodList:) add: (param1 at: temp1))
			)
		)
		(if
			(and
				(== ((param1 deadWoodList:) size:) 2)
				(numRankInDead doit: param1 temp7)
				(<= (gKnownCards howManyOfRank: temp7) 2)
			)
			((param1 deadWoodList:) release:)
			(return 1)
		)
		((param1 deadWoodList:) release:)
	)
	((param1 deadWoodList:) release:)
	(return 0)
)

(instance numRankInDead of Code
	(properties)

	(method (doit param1 param2 &tmp temp0 temp1)
		(= temp0 0)
		(for ((= temp1 0)) (< temp1 ((param1 deadWoodList:) size:)) ((++ temp1))
			(if (== (((param1 deadWoodList:) at: temp1) rank:) param2)
				(++ temp0)
			)
		)
		(return temp0)
	)
)

