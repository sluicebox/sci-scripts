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
		sel_20 {Morris}
		sel_568 0
		sel_569 2
		sel_570 -20
		sel_571 -20
		sel_572 -20
		sel_573 9
		sel_574 0
		sel_575 0
		sel_576 9
		sel_577 0
		sel_578 0
	)

	(method (sel_579 param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if param1
			(= temp1 -32768)
			(if param2
				(= temp1 (~ temp1))
			)
			(= temp2 (= temp3 (= temp4 (= temp5 (= temp6 (= temp7 -20))))))
			(= temp8 (self sel_587: param4))
			(++ sel_568)
			(while (self sel_586: temp5 temp6 temp7 param3 param4 temp8)
				(= temp5 sel_570)
				(= temp6 sel_571)
				(= temp7 sel_572)
				(= temp0
					(self sel_579: (- param1 1) (~ param2) param4 param3 temp1)
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
						(= sel_570 temp5)
						(= sel_571 temp6)
						(= sel_572 temp7)
						(self sel_590: param3 param4)
						(return temp0)
					)
					(= temp1 temp0)
					(= temp2 temp5)
					(= temp3 temp6)
					(= temp4 temp7)
				)
			)
			(= sel_570 temp2)
			(= sel_571 temp3)
			(= sel_572 temp4)
			(-- sel_568)
		else
			(= temp1 (self sel_580:))
		)
		(return temp1)
	)

	(method (sel_586 param1 param2 param3 param4 param5 param6)
		(= sel_570 param1)
		(= sel_571 param2)
		(= sel_572 param3)
		(if (!= sel_572 -20)
			(return
				(if (!= (= sel_572 (self sel_585: sel_572 param6 param5)) -20)
					1
				else
					(self sel_586: sel_570 sel_571 sel_572 param4 param5 param6)
				)
			)
		)
		(if (<= sel_568 18)
			(if (!= (= sel_571 (self sel_582: sel_571 param4)) -20)
				(if (self sel_588: sel_571)
					(= sel_572 (self sel_585: -20 param6 param5))
				)
				(return 1)
			else
				(return 0)
			)
		else
			(if (!= sel_571 -20)
				(if (!= (= sel_571 (self sel_584: sel_570 sel_571 param4)) -20)
					(if (self sel_588: sel_571)
						(= sel_572 (self sel_585: -20 param6 param5))
					)
					(return 1)
				else
					(return
						(self
							sel_586:
								sel_570
								sel_571
								sel_572
								param4
								param5
								param6
						)
					)
				)
			)
			(if (!= (= sel_570 (self sel_583: sel_570 param4)) -20)
				(if (!= (= sel_571 (self sel_584: sel_570 sel_571 param4)) -20)
					(if (self sel_588: sel_571)
						(= sel_572 (self sel_585: -20 param6 param5))
					)
					(return 1)
				else
					(return
						(self
							sel_586:
								sel_570
								sel_571
								sel_572
								param4
								param5
								param6
						)
					)
				)
			else
				(return 0)
			)
		)
	)

	(method (sel_589 param1 param2)
		(if (!= sel_570 -20)
			(self sel_581: sel_570 (- param1))
			(= [local0 sel_570] 0)
			(= [local0 [local68 sel_570]] 0)
		)
		(self sel_581: sel_571 param1)
		(= [local0 sel_571] param1)
		(= [local0 [local68 sel_571]] param1)
		(if (!= sel_572 -20)
			(self sel_581: sel_572 (- param2))
			(if (== param1 1)
				(-- sel_576)
			else
				(-- sel_573)
			)
			(= [local0 sel_572] 0)
			(= [local0 [local68 sel_572]] 0)
		)
		(++ sel_568)
	)

	(method (sel_590 param1 param2)
		(if (!= sel_572 -20)
			(self sel_581: sel_572 param2)
			(if (== param1 1)
				(++ sel_576)
			else
				(++ sel_573)
			)
			(= [local0 sel_572] param2)
			(= [local0 [local68 sel_572]] param2)
		)
		(self sel_581: sel_571 (- param1))
		(= [local0 sel_571] 0)
		(= [local0 [local68 sel_571]] 0)
		(if (!= sel_570 -20)
			(self sel_581: sel_570 param1)
			(= [local0 sel_570] param1)
			(= [local0 [local68 sel_570]] param1)
		)
		(-- sel_568)
	)

	(method (sel_582 param1 param2)
		(if (!= param1 -20)
			(self sel_581: param1 (- param2))
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
				(self sel_581: param1 param2)
				(= [local0 param1] param2)
				(= [local0 [local68 param1]] param2)
				(return param1)
			)
		)
	)

	(method (sel_583 param1 param2)
		(if (!= param1 -20)
			(self sel_581: param1 param2)
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
				(self sel_581: param1 (- param2))
				(= [local0 param1] 0)
				(= [local0 [local68 param1]] 0)
				(return param1)
			)
		)
	)

	(method (sel_584 param1 param2 param3)
		(if (!= param2 -20)
			(self sel_581: param2 (- param3))
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
				(self sel_581: param2 param3)
				(= [local0 param2] param3)
				(= [local0 [local68 param2]] param3)
				(return param2)
			)
		)
	)

	(method (sel_585 param1 param2 param3)
		(if (!= param1 -20)
			(self sel_581: param1 param3)
			(if (== param3 16)
				(++ sel_576)
			else
				(++ sel_573)
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
					(or param2 (not (self sel_588: param1 param3)))
				)
				(self sel_581: param1 (- param3))
				(= [local0 param1] 0)
				(= [local0 [local68 param1]] 0)
				(if (== param3 16)
					(-- sel_576)
				else
					(-- sel_573)
				)
				(return param1)
			)
		)
	)

	(method (sel_580 &tmp temp0 temp1)
		(if (< sel_568 16)
			(= temp0 (+ sel_573 sel_575 sel_574))
			(= temp1 (+ sel_576 sel_578 sel_577))
			(return (- (* 31 temp0) (* 32 temp1)))
		else
			(= temp0 (+ (* 31 sel_573) sel_575))
			(= temp1 (+ (* 32 sel_576) sel_578))
		)
		(return (- temp0 temp1))
	)

	(method (sel_581 param1 param2 &tmp temp0 temp1 temp2)
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
				(-- sel_574)
			)
			(32
				(-- sel_577)
			)
			(3
				(-- sel_575)
			)
			(48
				(-- sel_578)
			)
		)
		(switch (+ temp2 param2)
			(32
				(++ sel_577)
			)
			(48
				(++ sel_578)
			)
			(2
				(++ sel_574)
			)
			(3
				(++ sel_575)
			)
		)
		(if (<= argc 2)
			(self sel_581: [local68 param1] param2 1)
		)
	)

	(method (sel_591 param1 param2 param3 &tmp temp0)
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
		(if (and (self sel_588: param3 16) (not (self sel_587: 1)))
			(return 0)
		)
		(return 1)
	)

	(method (sel_588 param1 &tmp temp0 temp1 temp2 temp3)
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

	(method (sel_587 param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 32) ((++ temp0))
			(if (and (== [local0 temp0] param1) (not (self sel_588: temp0)))
				(return 0)
			)
		)
		(return 1)
	)

	(method (sel_592 param1)
		(if (> param1 32)
			(return [local68 param1])
		else
			(return param1)
		)
	)
)

