;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 315)
(include sci.sh)
(use Main)
(use Column)
(use WL)

(public
	proc315_0 0
	proc315_1 1
	proc315_2 2
	proc315_3 3
	proc315_4 4
	proc315_5 5
	proc315_6 6
)

(procedure (proc315_0 param1 param2 &tmp temp0 temp1) ; UNUSED
	(if (param1 isMemberOf: Column)
		(localproc_0 param1)
	)
	(if (and (>= argc 2) (param2 isMemberOf: Column))
		(localproc_0 param2)
	)
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		(for ((= temp1 0)) (< temp1 ((global423 at: temp0) size:)) ((++ temp1))
			(if (((global423 at: temp0) at: temp1) marked:)
				(((global423 at: temp0) at: temp1) marked: 0)
				(if (((global423 at: temp0) at: temp1) size:)
					((((global423 at: temp0) at: temp1) at: 0) whiten: update:)
				)
			)
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1
		(- (= temp0 ((global423 at: (param1 rowNumber:)) indexOf: param1)) 1)
	)
	(if (< (= temp2 (- (param1 rowNumber:) 2)) 0)
		(= temp2 0)
	)
	(if (>= temp1 ((global423 at: temp2) size:))
		(++ temp2)
	)
	(if (== temp1 -1)
		(= temp1 0)
		(++ temp2)
	)
	(for ((= temp3 temp2)) (< temp3 7) ((++ temp3))
		(((global423 at: temp3) at: temp1) marked: 1)
		(((global423 at: temp3) at: (+ temp1 (- temp3 temp2))) marked: 1)
	)
)

(procedure (proc315_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (gTheColumns size:)) ((++ temp0))
		(if ((gTheColumns at: temp0) underBits:)
			(UnLoad 133 ((gTheColumns at: temp0) underBits:))
			((gTheColumns at: temp0) underBits: 0)
		)
	)
)

(procedure (localproc_1 param1 &tmp temp0 temp1)
	(= temp1
		(if (== (param1 rowNumber:) 6)
			0
		else
			(global423 at: (+ (param1 rowNumber:) 1))
		)
	)
	(= temp0 ((global423 at: (param1 rowNumber:)) indexOf: param1))
	(return
		(or
			(not temp1)
			(and
				(not ((temp1 at: temp0) size:))
				(not ((temp1 at: (+ temp0 1)) size:))
			)
		)
	)
)

(procedure (proc315_2 param1)
	(if (and (param1 isMemberOf: Column) (not (localproc_1 param1)))
		(proc0_5 (Format @global100 315 0)) ; "Card must be completely uncovered."
		(return 1)
	)
	(return 0)
)

(procedure (proc315_3 param1)
	(if
		(and
			(not (param1 isThereADimmedObject: 2))
			(== param1 (gTheReserves at: 0))
		)
		(param1 dim: (param1 at: (- (param1 size:) 1)))
		(return 1)
	)
	(return 0)
)

(procedure (proc315_4 &tmp temp0 temp1)
	(= global412 28)
	((= global423 (WL new:)) add:)
	(global423 name: {Rows})
	(for ((= temp0 0)) (< temp0 7) ((++ temp0))
		((= temp1 (WL new:)) add: name: {aRow})
		(global423 add: temp1)
	)
)

(procedure (proc315_5 &tmp temp0)
	(if ((gTheWastePiles at: 0) size:)
		((gTheWastePiles at: 0) dim:)
		(if ((gTheReserves at: 0) size:)
			((gTheReserves at: 0) whiten:)
		)
		(= temp0 ((gTheWastePiles at: 0) at: 0))
		((gTheWastePiles at: 0) giveUpCards: gTheTransferList3)
		(gTheAutoCardToss2 init: temp0 (gTheReserves at: 0) 425)
	)
)

(procedure (proc315_6 param1 param2 &tmp temp0 temp1 temp2)
	(cond
		(
			(and
				(= temp0 (param1 isThereADimmedObject: 2))
				(== (+ ((param2 lastCard:) rank:) ((temp0 lastCard:) rank:)) 13)
			)
			(= temp1 (param2 firstDimmed:))
			(if (param2 underBits:)
				(Graph grRESTORE_BOX (param2 underBits:))
				(Graph
					grSAVE_BOX
					(param2 y:)
					(param2 x:)
					(+ (param2 y:) 43)
					(+ (param2 x:) 35)
					1
				)
				(Graph
					grUPDATE_BOX
					(param2 y:)
					(param2 x:)
					(+ (param2 y:) 43)
					(+ (param2 x:) 35)
					1
				)
				(param2 underBits: 0)
			)
			(param2 giveUpCards: 0 (if (param2 isMemberOf: Column) 1 else 0))
			(gTheCardToss init: temp1 param1)
			(= temp2 (temp0 firstDimmed:))
			(if (temp0 underBits:)
				(Graph grRESTORE_BOX (temp0 underBits:))
				(Graph
					grUPDATE_BOX
					(temp0 y:)
					(temp0 x:)
					(+ (temp0 y:) 43)
					(+ (temp0 x:) 35)
					1
				)
				(temp0 underBits: 0)
			)
			(temp0
				giveUpCards: gTheTransferList3 (if (temp0 isMemberOf: Column) 1 else 0)
			)
			(gTheAutoCardToss2 init: temp2 param1)
		)
		((or temp0 (!= ((param2 lastCard:) rank:) 13))
			(proc0_5 (Format @global100 315 1)) ; "Not a Valid Move. Cards must total 13."
		)
		(else
			(= temp1 (param2 firstDimmed:))
			(if (param2 underBits:)
				(Graph grRESTORE_BOX (param2 underBits:))
				(Graph
					grUPDATE_BOX
					(param2 y:)
					(param2 x:)
					(+ (param2 y:) 43)
					(+ (param2 x:) 35)
					1
				)
				(param2 underBits: 0)
			)
			(param2 giveUpCards: 0 (if (param2 isMemberOf: Column) 1 else 0))
			(gTheCardToss init: temp1 param1)
		)
	)
)

