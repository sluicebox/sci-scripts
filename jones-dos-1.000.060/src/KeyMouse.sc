;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 891)
(include sci.sh)
(use Main)
(use System)

(local
	[local0 9] = [180 0 45 90 135 180 225 270 315]
)

(class KeyMouse of Obj
	(properties
		listOfCoords 0
		curItem 0
		-oldPort- 0
		prevCursorX 0
		prevCursorY 0
	)

	(method (setPort)
		(= -oldPort- (GetPort))
		(SetPort 0)
	)

	(method (resetPort)
		(SetPort -oldPort-)
	)

	(method (setList param1)
		(= listOfCoords param1)
	)

	(method (setCursor param1)
		(if
			(and
				global302
				global439
				(not global443)
				(== (global302 playing:) 29)
			)
			(return)
		)
		(if (or global447 global518)
			(self setPort:)
			(if (IsObject param1)
				(SetCursor
					gTheCursor
					1
					(= prevCursorX (+ (param1 keyMouseX:) (param1 offsetX:)))
					(= prevCursorY (+ (param1 keyMouseY:) (param1 offsetY:)))
				)
				(= curItem param1)
			else
				(= curItem 0)
			)
			(self resetPort:)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if
			(and
				listOfCoords
				(listOfCoords size:)
				(not (event claimed:))
				(<= JOY_NULL (event message:) JOY_LEFT)
			)
			(= temp6 [local0 (event message:)])
			(= temp3 60)
			(= temp4 400)
			(for
				((= temp5 (= temp2 0)))
				(< temp5 (listOfCoords size:))
				((++ temp5))
				
				(= temp1 (listOfCoords at: temp5))
				(if
					(or
						(!= (event x:) (temp1 keyMouseX:))
						(!= (event y:) (temp1 keyMouseY:))
					)
					(= temp7
						(GetAngle
							(event x:)
							(event y:)
							(temp1 keyMouseX:)
							(temp1 keyMouseY:)
						)
					)
					(= temp0
						(GetDistance
							(event x:)
							(event y:)
							(temp1 keyMouseX:)
							(temp1 keyMouseY:)
						)
					)
					(if (> (= temp8 (Abs (- temp6 temp7))) 180)
						(= temp8 (- 360 temp8))
					)
					(if
						(or
							(<= temp8 (- temp3 10))
							(and
								(<= temp8 (+ temp3 10))
								(< (+ temp8 temp0) (+ temp3 temp4))
							)
							(and
								(<= temp8 (+ temp3 10))
								(== (+ temp8 temp0) (+ temp3 temp4))
								(< temp8 temp3)
							)
						)
						(= temp3 temp8)
						(= temp4 temp0)
						(= temp2 temp1)
					)
				)
			)
			(if temp2
				(event claimed: 1)
				(self setCursor: temp2)
			)
		)
	)

	(method (advance &tmp temp0)
		(if (and global447 (listOfCoords contains: curItem))
			(if
				(==
					(= temp0 (listOfCoords indexOf: curItem))
					(- (listOfCoords size:) 1)
				)
				(= temp0 -1)
			)
			(self setPort:)
			(self setCursor: (listOfCoords at: (+ temp0 1)))
			(self resetPort:)
		)
	)

	(method (retreat &tmp temp0)
		(if (and global447 (listOfCoords contains: curItem))
			(if (not (= temp0 (listOfCoords indexOf: curItem)))
				(= temp0 (listOfCoords size:))
			)
			(self setPort:)
			(self setCursor: (listOfCoords at: (- temp0 1)))
			(self resetPort:)
		)
	)
)

