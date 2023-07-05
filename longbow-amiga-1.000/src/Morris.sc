;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 541)
(include sci.sh)
(use System)

(local
	[local0 68]
	[local68 68] = [36 48 64 0 40 49 60 0 44 50 56 0 37 41 45 0 57 61 65 0 46 52 58 0 42 53 62 0 38 54 66 0 0 0 0 0 0 12 28 0 4 13 24 0 8 14 20 0 1 5 9 0 21 25 29 0 10 16 22 0 6 17 26 0 2 18 30 0]
)

(class Morris of Script
	(properties
		moves 0
		scan 2
		doFrom -20
		doTo -20
		doTake -20
		us 9
		usThreat 0
		usMills 0
		them 9
		themThreat 0
		themMills 0
	)

	(method (minimax param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if param1
			(= temp1 -32768)
			(if param2
				(= temp1 (~ temp1))
			)
			(= temp2 (= temp3 (= temp4 (= temp5 (= temp6 (= temp7 -20))))))
			(= temp8 (self findLoners: param4))
			(++ moves)
			(while (self tryAMove: temp5 temp6 temp7 param3 param4 temp8)
				(= temp5 doFrom)
				(= temp6 doTo)
				(= temp7 doTake)
				(= temp0
					(self minimax: (- param1 1) (~ param2) param4 param3 temp1)
				)
				(if
					(or
						(and (not param2) (>= temp0 temp1))
						(and param2 (<= temp0 temp1))
					)
					(if
						(or
							(and (not param2) (> temp0 param5))
							(and param2 (< temp0 param5))
						)
						(= doFrom temp5)
						(= doTo temp6)
						(= doTake temp7)
						(self unDoMove: param3 param4)
						(return temp0)
					)
					(= temp1 temp0)
					(= temp2 temp5)
					(= temp3 temp6)
					(= temp4 temp7)
				)
			)
			(= doFrom temp2)
			(= doTo temp3)
			(= doTake temp4)
			(-- moves)
		else
			(= temp1 (self eval:))
		)
		(return temp1)
	)

	(method (tryAMove param1 param2 param3 param4 param5 param6)
		(= doFrom param1)
		(= doTo param2)
		(= doTake param3)
		(if (!= doTake -20)
			(return
				(if (!= (= doTake (self tryATake: doTake param6 param5)) -20)
					1
				else
					(self tryAMove: doFrom doTo doTake param4 param5 param6)
				)
			)
		)
		(if (<= moves 18)
			(if (!= (= doTo (self tryAPlace: doTo param4)) -20)
				(if (self inMill: doTo)
					(= doTake (self tryATake: -20 param6 param5))
				)
				(return 1)
			else
				(return 0)
			)
		else
			(if (!= doTo -20)
				(if (!= (= doTo (self tryATo: doFrom doTo param4)) -20)
					(if (self inMill: doTo)
						(= doTake (self tryATake: -20 param6 param5))
					)
					(return 1)
				else
					(return
						(self tryAMove: doFrom doTo doTake param4 param5 param6)
					)
				)
			)
			(if (!= (= doFrom (self tryAFrom: doFrom param4)) -20)
				(if (!= (= doTo (self tryATo: doFrom doTo param4)) -20)
					(if (self inMill: doTo)
						(= doTake (self tryATake: -20 param6 param5))
					)
					(return 1)
				else
					(return
						(self tryAMove: doFrom doTo doTake param4 param5 param6)
					)
				)
			else
				(return 0)
			)
		)
	)

	(method (doMove param1 param2)
		(if (!= doFrom -20)
			(self tally: doFrom (- param1))
			(= [local0 doFrom] 0)
			(= [local0 [local68 doFrom]] 0)
		)
		(self tally: doTo param1)
		(= [local0 doTo] param1)
		(= [local0 [local68 doTo]] param1)
		(if (!= doTake -20)
			(self tally: doTake (- param2))
			(if (== param1 1)
				(-- them)
			else
				(-- us)
			)
			(= [local0 doTake] 0)
			(= [local0 [local68 doTake]] 0)
		)
		(++ moves)
	)

	(method (unDoMove param1 param2)
		(if (!= doTake -20)
			(self tally: doTake param2)
			(if (== param1 1)
				(++ them)
			else
				(++ us)
			)
			(= [local0 doTake] param2)
			(= [local0 [local68 doTake]] param2)
		)
		(self tally: doTo (- param1))
		(= [local0 doTo] 0)
		(= [local0 [local68 doTo]] 0)
		(if (!= doFrom -20)
			(self tally: doFrom param1)
			(= [local0 doFrom] param1)
			(= [local0 [local68 doFrom]] param1)
		)
		(-- moves)
	)

	(method (tryAPlace param1 param2)
		(if (!= param1 -20)
			(self tally: param1 (- param2))
			(= [local0 param1] 0)
			(= [local0 [local68 param1]] 0)
		else
			(= param1 -1)
		)
		(while 1
			(if (>= (++ param1) 32)
				(return -20)
			)
			(if (and (!= (& param1 $0003) 3) (== [local0 param1] 0))
				(self tally: param1 param2)
				(= [local0 param1] param2)
				(= [local0 [local68 param1]] param2)
				(return param1)
			)
		)
	)

	(method (tryAFrom param1 param2)
		(if (!= param1 -20)
			(self tally: param1 param2)
			(= [local0 param1] param2)
			(= [local0 [local68 param1]] param2)
		else
			(= param1 -1)
		)
		(while 1
			(if (>= (++ param1) 32)
				(return -20)
			)
			(if (and (!= (& param1 $0003) 3) (== [local0 param1] param2))
				(self tally: param1 (- param2))
				(= [local0 param1] 0)
				(= [local0 [local68 param1]] 0)
				(return param1)
			)
		)
	)

	(method (tryATo param1 param2 param3)
		(if (!= param2 -20)
			(self tally: param2 (- param3))
			(= [local0 param2] 0)
			(= [local0 [local68 param2]] 0)
		)
		(while 1
			(cond
				((== param2 -20)
					(= param2 (- param1 1))
				)
				((< param2 param1)
					(= param2 (+ param1 1))
				)
				((< param2 32)
					(= param2 (- [local68 param1] 1))
				)
				((< param2 [local68 param1])
					(= param2 (+ [local68 param1] 1))
				)
				(else
					(return -20)
				)
			)
			(if (and (!= (& param2 $0003) 3) (== [local0 param2] 0))
				(self tally: param2 param3)
				(= [local0 param2] param3)
				(= [local0 [local68 param2]] param3)
				(return param2)
			)
		)
	)

	(method (tryATake param1 param2 param3)
		(if (!= param1 -20)
			(self tally: param1 param3)
			(if (== param3 16)
				(++ them)
			else
				(++ us)
			)
			(= [local0 param1] param3)
			(= [local0 [local68 param1]] param3)
		else
			(= param1 -1)
		)
		(while 1
			(if (>= (++ param1) 32)
				(return -20)
			)
			(if
				(and
					(!= (& param1 $0003) 3)
					(== [local0 param1] param3)
					(or param2 (not (self inMill: param1 param3)))
				)
				(self tally: param1 (- param3))
				(= [local0 param1] 0)
				(= [local0 [local68 param1]] 0)
				(if (== param3 16)
					(-- them)
				else
					(-- us)
				)
				(return param1)
			)
		)
	)

	(method (eval &tmp temp0 temp1)
		(if (< moves 16)
			(= temp0 (+ us usMills usThreat))
			(= temp1 (+ them themMills themThreat))
			(return (- (* 31 temp0) (* 32 temp1)))
		else
			(= temp0 (+ (* 31 us) usMills))
			(= temp1 (+ (* 32 them) themMills))
		)
		(return (- temp0 temp1))
	)

	(method (tally param1 param2 &tmp temp0 temp1 temp2)
		(= temp1 (& param1 $fffc))
		(= temp2 0)
		(= temp0 3)
		(while temp0
			(+= temp2 [local0 temp1])
			(-- temp0)
			(++ temp1)
		)
		(switch temp2
			(2
				(-- usThreat)
			)
			(32
				(-- themThreat)
			)
			(3
				(-- usMills)
			)
			(48
				(-- themMills)
			)
		)
		(switch (+ temp2 param2)
			(32
				(++ themThreat)
			)
			(48
				(++ themMills)
			)
			(2
				(++ usThreat)
			)
			(3
				(++ usMills)
			)
		)
		(if (<= argc 2)
			(self tally: [local68 param1] param2 1)
		)
	)

	(method (isValid param1 param2 param3 &tmp temp0)
		(if (and (!= param1 -20) (!= [local0 param1] 16))
			(return 0)
		)
		(if (and (!= param2 -20) (!= [local0 param2] 0))
			(return 0)
		)
		(if
			(and
				(!= param1 -20)
				(!= (Abs (- param1 param2)) 1)
				(!= (Abs (- [local68 param1] [local68 param2])) 1)
			)
			(return 0)
		)
		(if (== param3 -20)
			(return 1)
		)
		(if (!= [local0 param3] 1)
			(return 0)
		)
		(if (and (self inMill: param3 16) (not (self findLoners: 1)))
			(return 0)
		)
		(return 1)
	)

	(method (inMill param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 (* [local0 param1] 3))
		(= temp2 (& param1 $fffc))
		(= temp3 0)
		(= temp1 3)
		(while temp1
			(+= temp3 [local0 temp2])
			(-- temp1)
			(++ temp2)
		)
		(if (== temp3 temp0)
			(return 1)
		)
		(= temp2 (& [local68 param1] $fffc))
		(= temp3 0)
		(= temp1 3)
		(while temp1
			(+= temp3 [local0 temp2])
			(-- temp1)
			(++ temp2)
		)
		(if (== temp3 temp0)
			(return 1)
		)
		(return 0)
	)

	(method (findLoners param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 32) ((++ temp0))
			(if (and (== [local0 temp0] param1) (not (self inMill: temp0)))
				(return 0)
			)
		)
		(return 1)
	)

	(method (lowerize param1)
		(if (> param1 32)
			(return [local68 param1])
		else
			(return param1)
		)
	)
)

