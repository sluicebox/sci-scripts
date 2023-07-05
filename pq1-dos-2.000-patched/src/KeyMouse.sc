;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 157)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	proc157_0 0
	proc157_1 1
	proc157_2 2
)

(local
	[local0 9] = [180 0 45 90 135 180 225 270 315]
)

(procedure (proc157_1)
	(if (== gPrevRoomNum 56)
		(= global202 (/ global221 2))
		(= global204 2)
		(= global203 10)
	else
		(= global202 (/ global221 5))
		(= global204 5)
		(= global203 25)
	)
	(= global200 (/ global202 2))
	(= global201 (/ global202 4))
)

(procedure (proc157_2)
	(if (== gPrevRoomNum 56)
		(= global221 (* global202 2))
	else
		(= global221 (* global202 5))
	)
)

(procedure (proc157_0 param1)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(Print font: gSmallFont posn: -1 130 addText: param1 init:)
)

(class KeyMouse of Obj
	(properties
		objList 0
		offsetX 0
		offsetY 0
		prevX -1
		prevY -1
		scope 89
		keyMouseObj 0
	)

	(method (init)
		(gDirectionHandler add: self)
	)

	(method (setList param1)
		(= objList param1)
	)

	(method (setCursor param1)
		(if (IsObject param1)
			(SetCursor
				(if (= prevX (self placementX: param1)) prevX else 319)
				(if (= prevY (self placementY: param1)) prevY else 199)
			)
			(= keyMouseObj param1)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
		(if
			(and
				(not (event claimed:))
				objList
				(objList size:)
				(<= JOY_UP (event message:) JOY_UPLEFT)
			)
			(= temp6 [local0 (event message:)])
			(= temp3 400)
			(= temp9 scope)
			(event localize:)
			(= temp10 (event x:))
			(= temp11 (event y:))
			(for ((= temp4 (= temp2 0))) (< temp4 (objList size:)) ((++ temp4))
				(= temp1 (objList at: temp4))
				(if
					(or
						(!= temp10 prevX)
						(!= temp11 prevY)
						(!= (self placementX: temp1) temp10)
						(!= (self placementY: temp1) temp11)
					)
					(= temp7
						(GetAngle
							temp10
							temp11
							(self placementX: temp1)
							(self placementY: temp1)
						)
					)
					(= temp0
						(GetDistance
							temp10
							temp11
							(self placementX: temp1)
							(self placementY: temp1)
						)
					)
					(if (> (= temp8 (Abs (- temp6 temp7))) 180)
						(= temp8 (- 360 temp8))
					)
					(if (< temp8 scope)
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
			(event claimed: 1)
			(if temp2
				(self setCursor: temp2)
			)
		)
		(event claimed:)
	)

	(method (placementX param1)
		(return (+ (/ (+ (param1 nsLeft:) (param1 nsRight:)) 2) offsetX))
	)

	(method (placementY param1)
		(return (+ (- (param1 nsBottom:) 4) offsetY))
	)

	(method (release)
		(objList eachElementDo: #delete release:)
	)
)

