;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 321)
(include sci.sh)
(use Main)

(public
	proc321_0 0
	proc321_1 1
	proc321_2 2
)

(local
	local0
)

(procedure (proc321_0 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp0 ((param1 lastCard:) rank:))
	(= temp1 ((param2 lastCard:) rank:))
	(= temp2 ((param3 lastCard:) rank:))
	(= temp4 ((param1 lastCard:) suit:))
	(= temp5 ((param2 lastCard:) suit:))
	(= temp6 ((param3 lastCard:) suit:))
	(if (or (== temp0 1) (== temp1 1) (== temp2 1))
		(if (< temp0 8)
			(+= temp0 13)
		)
		(if (< temp1 8)
			(+= temp1 13)
		)
		(if (< temp2 8)
			(+= temp2 13)
		)
	)
	(return
		(and
			(= temp3
				(if (>= global337 400)
					(if (!= temp4 temp5)
						(and (!= temp4 temp6) (!= temp5 temp6))
					)
				else
					1
				)
			)
			(not (mod (+ temp0 temp1 temp2) 3))
			(!= temp0 temp1)
			(!= temp0 temp2)
			(!= temp1 temp2)
			(<= -2 (- temp0 temp1) 2)
			(<= -2 (- temp0 temp2) 2)
			(<= -2 (- temp1 temp2) 2)
		)
	)
)

(procedure (proc321_1 &tmp temp0 temp1 temp2)
	(for ((= temp0 (= temp1 0))) (< temp0 (gTheColumns size:)) ((++ temp0))
		(if ((gTheColumns at: temp0) size:)
			(= temp2 (((gTheColumns at: temp0) at: 0) rank:))
		)
		(+= temp1 ((gTheColumns at: temp0) size:))
	)
	(if (and (not local0) (== temp1 1))
		(+= global400 temp2)
		(= local0 1)
	)
	(if (!= temp1 1)
		(= local0 0)
	)
)

(procedure (proc321_2 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp0 (param1 isThereADimmedObject: 2))
	(= temp1 (param1 isThereADimmedObject: 3))
	(cond
		((and temp0 temp1 (proc321_0 param2 temp0 temp1))
			(= temp2 (param2 firstDimmed:))
			(param2 giveUpCards:)
			(gTheCardToss init: temp2 param1)
			(= temp3 (temp0 firstDimmed:))
			(temp0 giveUpCards: gTheTransferList2)
			(gTheAutoCardToss init: temp3 param1)
			(= temp4 (temp1 firstDimmed:))
			(temp1 giveUpCards: gTheTransferList3)
			(gTheAutoCardToss2 init: temp4 param1)
		)
		((>= global337 400)
			(proc0_5 (Format @global100 321 0)) ; "Three cards in sequence and of different suits must be chosen."
		)
		(else
			(proc0_5 (Format @global100 321 1)) ; "Three cards in sequence must be chosen."
		)
	)
)

