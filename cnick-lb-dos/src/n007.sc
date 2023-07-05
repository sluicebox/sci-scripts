;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use System)

(local
	[local0 9] = [180 0 45 90 135 180 225 270 315]
)

(class Class_7_0 of Obj
	(properties
		sel_20 -1
		sel_414 0
		sel_415 0
		sel_416 0
		sel_417 0
		sel_418 -1
		sel_419 -1
		sel_420 89
		sel_421 0
		sel_422 0
	)

	(method (sel_110)
		(gDirectionHandler sel_118: self)
	)

	(method (sel_424)
		(= sel_415 (GetPort))
		(SetPort 0)
	)

	(method (sel_425)
		(SetPort sel_415)
	)

	(method (sel_423 param1)
		(= sel_414 param1)
	)

	(method (sel_191 param1 &tmp temp0)
		(= temp0 0)
		(self sel_424:)
		(if (IsObject param1)
			(SetCursor
				(if (= sel_418 (self sel_426: param1)) sel_418 else 319)
				(if (= sel_419 (self sel_427: param1)) sel_419 else 199)
			)
			(= temp0 1)
			(= sel_422 param1)
		)
		(self sel_425:)
		(if (and temp0 sel_421)
			(sel_421 sel_57: param1)
		)
	)

	(method (sel_132 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(if
			(and
				(not (param1 sel_73:))
				sel_414
				(sel_414 sel_86:)
				(<= 1 (param1 sel_37:) 8)
			)
			(= temp6 [local0 (param1 sel_37:)])
			(= temp3 400)
			(= temp9 sel_420)
			(for
				((= temp4 (= temp2 0)))
				(< temp4 (sel_414 sel_86:))
				((++ temp4))
				
				(= temp1 (sel_414 sel_64: temp4))
				(if
					(or
						(!= gMouseX sel_418)
						(!= gMouseY sel_419)
						(!= (self sel_426: temp1) gMouseX)
						(!= (self sel_427: temp1) gMouseY)
					)
					(= temp7
						(GetAngle
							gMouseX
							gMouseY
							(self sel_426: temp1)
							(self sel_427: temp1)
						)
					)
					(= temp0
						(GetDistance
							gMouseX
							gMouseY
							(self sel_426: temp1)
							(self sel_427: temp1)
						)
					)
					(if (> (= temp8 (Abs (- temp6 temp7))) 180)
						(= temp8 (- 360 temp8))
					)
					(if (< temp8 sel_420)
						(cond
							((< (= temp5 (+ (/ temp0 3) temp8)) temp3)
								(= temp3 temp5)
								(= temp9 temp7)
								(= temp2 temp1)
							)
							((and (== temp5 temp3) (< temp7 temp9))
								(= temp3 temp5)
								(= temp9 temp7)
								(= temp2 temp1)
							)
						)
					)
				)
			)
			(if temp2
				(param1 sel_73: 1)
				(self sel_191: temp2)
			)
		)
		(param1 sel_73:)
	)

	(method (sel_426 param1)
		(return (+ (/ (+ (param1 sel_7:) (param1 sel_9:)) 2) sel_416))
	)

	(method (sel_427 param1)
		(return (+ (- (param1 sel_8:) 4) sel_417))
	)

	(method (sel_125)
		(sel_414 sel_125:)
	)
)

