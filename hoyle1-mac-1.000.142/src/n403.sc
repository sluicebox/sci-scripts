;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 403)
(include sci.sh)
(use Main)
(use g)

(public
	proc403_0 0
)

(procedure (proc403_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(= global859 param1)
	(param2
		base1GroupNum: 0
		base2GroupNum: 0
		base3GroupNum: 0
		group1List: (GinRummyCardList new:)
		group2List: (GinRummyCardList new:)
		group3List: (GinRummyCardList new:)
		deadWoodList: (GinRummyCardList new:)
	)
	(for ((= temp0 0)) (< temp0 (global859 size:)) ((++ temp0))
		(= temp2 (global859 at: temp0))
		(if (= temp1 (temp2 bestGroup:))
			(temp2 group: temp1 rating: 0)
			(cond
				(
					(or
						(not (param2 base1GroupNum:))
						(== temp1 (param2 base1GroupNum:))
					)
					(param2 base1GroupNum: temp1)
					((param2 group1List:) add: temp2)
				)
				(
					(or
						(not (param2 base2GroupNum:))
						(== temp1 (param2 base2GroupNum:))
					)
					(param2 base2GroupNum: temp1)
					((param2 group2List:) add: temp2)
				)
				(else
					(param2 base3GroupNum: temp1)
					((param2 group3List:) add: temp2)
				)
			)
		else
			(temp2 rating: 1 group: 0)
			((param2 deadWoodList:) add: temp2)
		)
	)
	(param2 base2: (+ (param2 base1:) (* ((param2 group1List:) size:) 7) 61))
	(param2 base3: (+ (param2 base2:) (* ((param2 group2List:) size:) 7) 61))
	(if (== param2 gPlayer0)
		(param2
			deadWoodBaseY:
				(- (param2 baseY:) (* ((param2 deadWoodList:) size:) 9))
		)
	)
	(global859 eachElementDo: #update 1)
	(global859 eachElementDo: #faceUp 1)
	(for ((= temp0 0)) (< temp0 ((param2 group1List:) size:)) ((++ temp0))
		(((param2 group1List:) at: temp0) x: (+ (param2 base1:) (* temp0 7)))
	)
	(for ((= temp0 0)) (< temp0 ((param2 group2List:) size:)) ((++ temp0))
		(((param2 group2List:) at: temp0) x: (+ (param2 base2:) (* temp0 7)))
	)
	(for ((= temp0 0)) (< temp0 ((param2 group3List:) size:)) ((++ temp0))
		(((param2 group3List:) at: temp0) x: (+ (param2 base3:) (* temp0 7)))
	)
	(global859 opponent: (if (== param2 gPlayer0) gPlayer2 else gPlayer0))
	(for ((= temp0 0)) (< temp0 (global859 size:)) ((++ temp0))
		(= temp2 (global859 at: temp0))
		(if
			(and
				(temp2 rating:)
				global426
				(!= global426 param2)
				(global426 bestDeadWood:)
			)
			(temp2 playOff: 0)
			(global859
				tryToPlayOffCard: temp2 ((global859 opponent:) group1List:)
				tryToPlayOffCard: temp2 ((global859 opponent:) group2List:)
				tryToPlayOffCard: temp2 ((global859 opponent:) group3List:)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 ((param2 deadWoodList:) size:)) ((++ temp0))
		(if (((param2 deadWoodList:) at: temp0) playOff:)
			(((param2 deadWoodList:) at: temp0) loop: 1)
		)
		(((param2 deadWoodList:) at: temp0)
			x: (param2 deadWoodBaseX:)
			y: (+ (param2 deadWoodBaseY:) (* temp0 9))
		)
	)
)

