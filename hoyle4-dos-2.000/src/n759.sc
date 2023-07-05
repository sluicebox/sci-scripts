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
		(if (== (Signal moveY:) param1)
			(switch param2
				(1 927)
				(2 928)
				(3 929)
				(4 930)
			)
		else
			(switch param2
				(1 931)
				(2 932)
				(3 933)
				(4 934)
			)
		)
	)
)

(class Signal of Obj
	(properties
		moveY 0
		doYourThing 0
		weGame1 0
		weGame2 0
		weGame3 0
		weRubberBonus 0
		weSlamBonus 0
		weMadeDoubled 0
		weHonors 0
	)

	(method (init &tmp temp0)
		(if (== (= temp0 (+ (global117 indexOf: global429) 1)) 4)
			(= temp0 0)
		)
		(= moveY (global117 at: temp0))
		(= weRubberBonus
			(= weSlamBonus
				(= weMadeDoubled
					(= weHonors
						(= doYourThing (= weGame1 (= weGame2 (= weGame3 0))))
					)
				)
			)
		)
	)

	(method (weOvertricks param1 &tmp temp0 temp1)
		(if (not (IsObject param1))
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
									(self
										weHandTotal: (Dealer curPlayer:) param1
									)
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

	(method (weUndertricks &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp4 ((Dealer curPlayer:) partner:))
		(if
			(and
				(= temp0 (self weGamesWon: temp4))
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

	(method (weTotal &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 4] [temp13 4] temp17 temp18 temp19)
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
				(self weOvertricks: temp19 1)
				(return temp19)
			else
				(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
					(if
						(and
							(== [temp9 (= temp19 temp0)] temp18)
							(not (-- temp17))
						)
						(self weOvertricks: temp0 1)
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
				(self weOvertricks: temp19 2)
				(return temp19)
			else
				(for ((= temp0 4)) (>= temp0 1) ((-- temp0))
					(if
						(and
							(== [temp13 (= temp19 temp0)] temp18)
							(not (-- temp17))
						)
						(self weOvertricks: temp0 2)
						(return temp19)
					)
				)
			)
		)
		(return -1)
	)

	(method (weOverLine param1 param2 &tmp temp0)
		(= temp0 (localproc_0 param1 param2))
		(Eval self temp0)
	)

	(method (weGamesWon param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
			(= [local0 temp0] 0)
		)
		(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
			(if
				(or
					(== (gTrick trump:) temp0)
					(not (param1 weVulnerable: temp0))
					(== (= temp1 (Eval self (localproc_0 param1 temp0))) 2)
				)
				(= [local0 temp0] 1)
				(++ temp2) ; UNINIT
			)
		)
		(return temp2) ; UNINIT
	)

	(method (weHandTotal param1 param2 &tmp temp0 temp1)
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

