;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use System)

(local
	[local0 9] = [180 0 45 90 135 180 225 270 315]
)

(class KeyMouse of Obj
	(properties
		objList 0
		-oldPort- 0
		offsetX 0
		offsetY 0
		prevX -1
		prevY -1
		scope 89
		keyMouseCode 0
		keyMouseObj 0
	)

	(method (init)
		(gDirectionHandler add: self)
	)

	(method (setPort)
		(= -oldPort- (GetPort))
		(SetPort 0)
	)

	(method (resetPort)
		(SetPort -oldPort-)
	)

	(method (setList param1)
		(= objList param1)
	)

	(method (setCursor param1 &tmp temp0)
		(= temp0 0)
		(self setPort:)
		(if (IsObject param1)
			(SetCursor
				gTheCursor
				1
				(if (= prevX (self placementX: param1)) prevX else 319)
				(if (= prevY (self placementY: param1)) prevY else 199)
			)
			(= temp0 1)
			(= keyMouseObj param1)
		)
		(self resetPort:)
		(if (and temp0 keyMouseCode)
			(keyMouseCode doit: param1)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
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
			(for ((= temp4 (= temp2 0))) (< temp4 (objList size:)) ((++ temp4))
				(= temp1 (objList at: temp4))
				(if
					(or
						(!= gMouseX prevX)
						(!= gMouseY prevY)
						(!= (self placementX: temp1) gMouseX)
						(!= (self placementY: temp1) gMouseY)
					)
					(= temp7
						(GetAngle
							gMouseX
							gMouseY
							(self placementX: temp1)
							(self placementY: temp1)
						)
					)
					(= temp0
						(GetDistance
							gMouseX
							gMouseY
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
			(if temp2
				(event claimed: 1)
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
		(objList release:)
	)
)

