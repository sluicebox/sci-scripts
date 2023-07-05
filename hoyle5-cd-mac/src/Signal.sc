;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 759)
(include sci.sh)
(use Main)
(use Piles)
(use System)

(local
	[local0 5]
)

(procedure (localproc_0 param1 param2)
	(return
		(if (== (Signal LHO:) param1)
			(switch param2
				(1 1621)
				(2 1622)
				(3 1623)
				(4 1624)
			)
		else
			(switch param2
				(1 1625)
				(2 1626)
				(3 1627)
				(4 1628)
			)
		)
	)
)

(class Signal of Obj
	(properties
		LHO 0
		LHOClub 0
		LHODiamond 0
		LHOHeart 0
		LHOSpade 0
		RHOClub 0
		RHODiamond 0
		RHOHeart 0
		RHOSpade 0
	)

	(method (init &tmp temp0 temp1)
		(if (== (= temp0 (+ (global117 indexOf: global429) 1)) 4)
			(= temp0 0)
		)
		(= LHO (global117 at: temp0))
		(for
			((= temp1
				(= RHOClub
					(= RHODiamond
						(= RHOHeart
							(= RHOSpade
								(= LHOClub
									(= LHODiamond (= LHOHeart (= LHOSpade 0)))
								)
							)
						)
					)
				)
			))
			(< temp1 5)
			((++ temp1))
			
			(= [local0 temp1] 0)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (setSignal param1 &tmp temp0 temp1)
		(if (not param1)
			(= temp0 (localproc_0 (Dealer curPlayer:) param1))
			(return (Eval self temp0 [param1 1]))
		)
		(= temp0 (localproc_0 (Dealer curPlayer:) (param1 suit:)))
		(if (<= (= temp1 (Eval self temp0)) 0)
			(cond
				((< temp1 0)
					(if (> (param1 rank:) (Abs temp1))
						(Eval self temp0 2)
					else
						(Eval self temp0 1)
					)
				)
				(
					(and
						(not temp1)
						(or
							(= temp1
								(not
									(self anyLower: (Dealer curPlayer:) param1)
								)
							)
							(>= (param1 rank:) 10)
						)
					)
					(Eval self temp0 (+ temp1 1))
				)
				(else
					(Eval self temp0 (- (param1 rank:)))
				)
			)
		)
		(return param1)
	)

	(method (readSignal &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp4 ((Dealer curPlayer:) partner:))
		(if
			(and
				(= temp0 (self setCheckArray: temp4))
				(or
					(and (== (gTrick trump:) -1) (== temp0 3))
					(and (gTrick trump:) (== temp0 2))
				)
			)
			(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
				(if (not [local0 temp1])
					(= temp3 (localproc_0 temp4 temp1))
					(Eval self temp3 1)
					(return temp1)
				)
			)
		)
		(= temp7 (= temp0 0))
		(for ((= temp2 1)) (< temp2 3) ((++ temp2))
			(for ((= temp1 1)) (<= temp1 4) ((++ temp1))
				(= temp3 (localproc_0 temp4 temp1))
				(= temp5 (Eval self temp3))
				(= [local0 temp1] 0)
				(if (== temp5 temp2)
					(= [local0 temp1] 1)
					(++ temp0)
				)
			)
			(cond
				((and (== temp0 1) [local0 1])
					(= temp7 1)
				)
				((and (== temp0 1) [local0 2])
					(= temp7 2)
				)
				((and (== temp0 1) [local0 3])
					(= temp7 3)
				)
				((and (== temp0 1) [local0 4])
					(= temp7 4)
				)
				((and [local0 1] [local0 2])
					(= temp7 5)
				)
				((and [local0 1] [local0 3])
					(= temp7 6)
				)
				((and [local0 1] [local0 4])
					(= temp7 7)
				)
				((and [local0 2] [local0 3])
					(= temp7 8)
				)
				((and [local0 2] [local0 4])
					(= temp7 9)
				)
				((and [local0 3] [local0 4])
					(= temp7 10)
				)
			)
			(if (and temp7 (< temp2 2))
				(break)
			)
		)
		(if (and (> temp2 1) temp7)
			(return (- temp7))
		)
		(return temp7)
	)

	(method (checkSignal &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 4] [temp13 4] temp17 temp18 temp19)
		(= temp3 (Dealer curPlayer:))
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(= [temp9 temp0] (= [temp13 temp0] 0))
			(= temp4 (localproc_0 temp3 temp0))
			(if (< (= temp2 (Eval self temp4)) 0)
				(for ((= temp1 0)) (< temp1 (temp3 size:)) ((++ temp1))
					(= temp8 (temp3 at: temp1))
					(if (and (== (temp8 suit:) temp0) (< (temp8 rank:) temp5))
						(= temp5 (temp8 rank:))
					)
				)
				(if (< temp5 (Abs temp2))
					(= [temp9 temp0] (Abs temp2))
					(++ temp6)
				else
					(= [temp13 temp0] (Abs temp2))
					(++ temp7)
				)
			)
		)
		(= temp18 (= temp17 0))
		(if temp6
			(= temp5 15)
			(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
				(if (= temp2 [temp9 temp0])
					(if (== temp5 temp2)
						(++ temp17)
						(= temp18 temp2)
					)
					(if (< temp2 temp5)
						(= temp18 (= temp17 0))
						(= temp5 temp2)
						(= temp19 temp0)
					)
				)
			)
			(if (not temp17)
				(self setSignal: temp19 1)
				(return temp19)
			else
				(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
					(if
						(and
							(== [temp9 (= temp19 temp0)] temp18)
							(not (-- temp17))
						)
						(self setSignal: temp0 1)
						(return temp0)
					)
				)
			)
		)
		(if temp7
			(= temp5 0)
			(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
				(if (= temp2 [temp13 temp0])
					(if (== temp5 temp2)
						(++ temp17)
						(= temp18 temp2)
					)
					(if (> temp2 temp5)
						(= temp18 (= temp17 0))
						(= temp5 temp2)
						(= temp19 temp0)
					)
				)
			)
			(if (not temp17)
				(self setSignal: temp19 2)
				(return temp19)
			else
				(for ((= temp0 4)) (>= temp0 1) ((-- temp0))
					(if
						(and
							(== [temp13 (= temp19 temp0)] temp18)
							(not (-- temp17))
						)
						(self setSignal: temp0 2)
						(return temp19)
					)
				)
			)
		)
		(return -1)
	)

	(method (getValue param1 param2 &tmp temp0)
		(= temp0 (localproc_0 param1 param2))
		(Eval self temp0)
	)

	(method (setCheckArray param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(or
					(== (gTrick trump:) temp0)
					(not (param1 countSuit: temp0))
					(==
						(= temp1 (Eval self (localproc_0 param1 temp0)))
						2
					)
				)
				(= [local0 temp0] 1)
				(++ temp2) ; UNINIT
			)
		)
		(return temp2) ; UNINIT
	)

	(method (anyLower param1 param2 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 (param1 size:)) ((++ temp0))
			(= temp1 (param1 at: temp0))
			(if
				(and
					(== (temp1 suit:) (param2 suit:))
					(< (temp1 rank:) (param2 rank:))
				)
				(return 1)
			)
		)
		(return 0)
	)
)

