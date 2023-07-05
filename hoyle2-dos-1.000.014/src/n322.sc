;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 322)
(include sci.sh)
(use Main)

(public
	proc322_0 0
	proc322_1 1
	proc322_2 2
	proc322_3 3
	proc322_4 4
	proc322_5 5
)

(procedure (proc322_3))

(procedure (proc322_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(param1 dimmedObj: (param1 isThereADimmedObject: 1))
	(cond
		((param1 size:)
			(if (param1 dimmedObj:)
				(if (== (param1 dimmedObj:) param1)
					(= temp4 (param1 dimmedObj:))
					(proc0_1
						((temp4 at: 0) suit:)
						0
						((temp4 at: 0) rank:)
						((temp4 at: 0) x:)
						((temp4 at: 0) y:)
						(temp4 priority:)
					)
					((temp4 at: 0) dimmed: 0)
				else
					(= temp4 (param1 dimmedObj:))
					(proc0_1
						((temp4 at: 0) suit:)
						0
						((temp4 at: 0) rank:)
						((temp4 at: 0) x:)
						((temp4 at: 0) y:)
						(temp4 priority:)
					)
					((temp4 at: 0) dimmed: 0)
					(= temp4 (param1 at: 0))
					(proc0_1
						(temp4 suit:)
						1
						(temp4 rank:)
						(temp4 x:)
						(temp4 y:)
						(param1 priority:)
					)
					(temp4 dimmed: 1)
				)
			else
				(= temp4 (param1 at: 0))
				(proc0_1
					(temp4 suit:)
					1
					(temp4 rank:)
					(temp4 x:)
					(temp4 y:)
					(param1 priority:)
				)
				(temp4 dimmed: 1)
			)
		)
		((not (param1 dimmedObj:))
			(proc0_5 (Format @global100 322 0)) ; "Must select a card."
		)
		(else
			(= temp2 0)
			(= temp3 (gTheColumns indexOf: param1))
			(= temp0 (((param1 dimmedObj:) at: 0) suit:))
			(= temp1 (((param1 dimmedObj:) at: 0) rank:))
			(cond
				((not (mod temp3 13))
					(cond
						((< global337 400)
							(if
								(and
									(!= temp1 2)
									(or
										(not
											((gTheColumns at: (+ temp3 1)) size:)
										)
										(!=
											(((gTheColumns at: (+ temp3 1)) at: 0)
												rank:
											)
											(+ temp1 1)
										)
										(!=
											(((gTheColumns at: (+ temp3 1)) at: 0)
												suit:
											)
											temp0
										)
									)
								)
								(= temp2 1)
							)
						)
						((!= temp1 2)
							(= temp2 1)
						)
					)
				)
				((< global337 400)
					(if
						(and
							(or
								(not ((gTheColumns at: (- temp3 1)) size:))
								(!=
									(((gTheColumns at: (- temp3 1)) at: 0) rank:)
									(- temp1 1)
								)
								(!=
									(((gTheColumns at: (- temp3 1)) at: 0) suit:)
									temp0
								)
							)
							(or
								(== (mod temp3 13) 12)
								(not ((gTheColumns at: (+ temp3 1)) size:))
								(!=
									(((gTheColumns at: (+ temp3 1)) at: 0) rank:)
									(+ temp1 1)
								)
								(!=
									(((gTheColumns at: (+ temp3 1)) at: 0) suit:)
									temp0
								)
							)
						)
						(= temp2 1)
					)
				)
				(
					(or
						(not ((gTheColumns at: (- temp3 1)) size:))
						(!=
							(((gTheColumns at: (- temp3 1)) at: 0) rank:)
							(- temp1 1)
						)
						(!= (((gTheColumns at: (- temp3 1)) at: 0) suit:) temp0)
					)
					(= temp2 1)
				)
			)
			(if temp2
				(proc0_5 (Format @global100 322 1)) ; "Invalid Move."
			else
				(= temp4 ((param1 dimmedObj:) at: 0))
				((param1 dimmedObj:) giveUpCards:)
				(gTheCardToss init: temp4 param1 425)
			)
		)
	)
)

(procedure (proc322_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 52) ((++ temp0))
		(if (== (((gTheColumns at: temp0) at: 0) rank:) 1)
			(proc0_2)
			(Wait 15)
			(proc0_1
				(+ 400 global679)
				0
				1
				(((gTheColumns at: temp0) at: 0) x:)
				(((gTheColumns at: temp0) at: 0) y:)
				((gTheColumns at: temp0) priority:)
			)
			(gTheWorkingDeck add: ((gTheColumns at: temp0) at: 0))
			((gTheColumns at: temp0) delete: ((gTheColumns at: temp0) at: 0))
		)
	)
	(proc322_2)
)

(procedure (proc322_2 &tmp temp0 temp1 temp2 temp3)
	(= temp3 global400)
	(= global400 4)
	(for ((= temp0 0)) (< temp0 52) ((+= temp0 13))
		(if
			(and
				((gTheColumns at: temp0) size:)
				(== (((gTheColumns at: temp0) at: 0) rank:) 2)
			)
			(++ global400)
			(= temp2 (((gTheColumns at: temp0) at: 0) suit:))
			(for
				((= temp1 (+ temp0 1)))
				(and
					(< temp1 (+ temp0 13))
					((gTheColumns at: temp1) size:)
					(== (((gTheColumns at: temp1) at: 0) suit:) temp2)
					(==
						(((gTheColumns at: temp1) at: 0) rank:)
						(+ (mod temp1 13) 2)
					)
				)
				((++ temp1))
				
				(++ global400)
			)
		)
	)
	(if (!= temp3 global400)
		(proc0_4)
	)
)

(procedure (proc322_4 param1 &tmp temp0 temp1)
	(if (param1 size:)
		(if (not (mod (= temp0 (gTheColumns indexOf: param1)) 13))
			(if (== ((param1 at: 0) rank:) 2)
				(return 0)
			else
				(return 1)
			)
		else
			(= temp1 (* (/ temp0 13) 13))
			(if
				(and
					(== ((param1 at: 0) rank:) (+ (mod temp0 13) 2))
					((gTheColumns at: temp1) size:)
					(==
						((param1 at: 0) suit:)
						(((gTheColumns at: temp1) at: 0) suit:)
					)
					((gTheColumns at: (- temp0 1)) size:)
				)
				(return 0)
			else
				(return 1)
			)
		)
	)
	(return 0)
)

(procedure (proc322_5 param1 &tmp temp0)
	(gTheWorkingDeck eachElementDo: #faceUp 0)
	(for ((= temp0 3)) (>= temp0 0) ((-- temp0))
		(param1
			addAfter:
				(param1 at: (Random 0 (- (param1 size:) 1)))
				(gTheWorkingDeck at: temp0)
		)
	)
	(gTheWorkingDeck empty:)
)

