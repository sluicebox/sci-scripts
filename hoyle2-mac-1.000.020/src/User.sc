;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use CardList)
(use Menu)
(use System)

(local
	[local0 9] = [180 0 45 90 135 180 225 270 315]
)

(class KeyMouse of Obj
	(properties
		listOfCoords 0
		allowance 15
	)

	(method (setList param1)
		(= listOfCoords param1)
	)

	(method (setCursor param1)
		(SetCursor
			gTheCursor
			1
			(+ (param1 x:) global638)
			(+ (param1 y:) global639)
		)
	)

	(method (handleEvent event param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12)
		(if
			(and
				listOfCoords
				(listOfCoords size:)
				(not (event claimed:))
				(<= JOY_NULL (event message:) JOY_UPLEFT)
			)
			(= temp6 [local0 (event message:)])
			(= temp3 60)
			(= temp4 400)
			(cond
				((and (== listOfCoords gMainKeyMouseList) (IsObject global637))
					(= temp9 (+ (global637 x:) global638))
					(= temp10 (+ (global637 y:) global639))
				)
				((== listOfCoords gMainKeyMouseList)
					(= temp9 (- (event x:) global638))
					(= temp10 (- (- (event y:) 10) 100))
				)
				(else
					(= temp9 (event x:))
					(= temp10 (- (event y:) 10))
				)
			)
			(= temp5
				(if
					(and
						(!= listOfCoords gMainKeyMouseList)
						(IsObject global637)
						(global637 isKindOf: CardList)
						(or
							(== (global637 dimRule:) 0)
							(== (global637 dimRule:) 8)
						)
					)
					(- (listOfCoords size:) 1)
				else
					0
				)
			)
			(= temp2 0)
			(while (< temp5 (listOfCoords size:))
				(= temp1 (listOfCoords at: temp5))
				(if
					(and
						(!= listOfCoords gMainKeyMouseList)
						(IsObject global637)
						(global637 isKindOf: CardList)
						(not (temp1 faceUp:))
						(!= temp5 (- (listOfCoords size:) 1))
					)
				else
					(= temp11 (+ (temp1 x:) global638))
					(= temp12 (+ (temp1 y:) global639))
					(if (or (!= temp9 temp11) (!= temp10 temp12))
						(= temp7 (GetAngle temp9 temp10 temp11 temp12))
						(= temp0 (GetDistance temp9 temp10 temp11 temp12))
						(if (> (= temp8 (Abs (- temp6 temp7))) 180)
							(= temp8 (- 360 temp8))
						)
						(if
							(or
								(<= temp8 (- temp3 allowance))
								(and
									(<= temp8 (+ temp3 allowance))
									(< (+ temp8 temp0) (+ temp3 temp4))
								)
								(and
									(<= temp8 (+ temp3 allowance))
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
				(++ temp5)
			)
			(if temp2
				(if (and (>= argc 2) param2)
					(= global637 temp2)
				else
					(event claimed: 1)
					(self setCursor: temp2)
				)
				(return 1)
			)
		)
		(if (and (== temp6 0) (>= argc 2) param2)
			(SetCursor gTheCursor 1 (event x:) -3)
			(= global637 -1)
		)
		(return 0)
	)
)

(class User of Obj
	(properties
		x -1
		y -1
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (= global312 ((= temp0 (Event new:)) type:))
			(temp0 modifiers: (& (temp0 modifiers:) $000f)) ; emALT | emCTRL | emSHIFT
			(= gLastEvent temp0)
			(MapKeyToDir temp0)
			(if (or (== (temp0 message:) KEY_RETURN) (== (temp0 type:) evJOYDOWN))
				(temp0 type: evMOUSEBUTTON)
			)
			(if (== (temp0 message:) KEY_INSERT)
				(temp0 type: evMOUSEBUTTON modifiers: emALT)
			)
			(if (or (== (temp0 type:) $0040) (<= KEY_1 (temp0 message:) KEY_9)) ; direction
				(= temp2 0)
				(if
					(and
						(< JOY_NULL (temp0 message:) KEY_TAB)
						(IsObject global637)
						(global637 isKindOf: List)
						(> (global637 size:) 1)
						(!= global637 gTheStock)
					)
					(KeyMouse setList: global637)
					(= temp2 (KeyMouse handleEvent: temp0 0))
				)
				(if (<= KEY_1 (temp0 message:) KEY_9)
					(temp0
						message:
							(switch (temp0 message:)
								(KEY_1 6)
								(KEY_2 5)
								(KEY_3 4)
								(KEY_4 7)
								(KEY_5 0)
								(KEY_6 3)
								(KEY_7 8)
								(KEY_8 1)
								(KEY_9 2)
							)
					)
				)
				(temp0 type: (if (temp0 message:) 64 else 0))
				(if (not (temp0 type:))
					(= temp2 1)
				)
				(if (not temp2)
					(KeyMouse setList: gMainKeyMouseList)
					(if (= temp2 (KeyMouse handleEvent: temp0 1))
						(cond
							(
								(and
									(IsObject global637)
									(global637 isKindOf: List)
									(> (global637 size:) 1)
									(!= global637 gTheStock)
								)
								(KeyMouse setList: global637)
								(= temp2 (KeyMouse handleEvent: temp0 0))
							)
							((IsObject global637)
								(KeyMouse setCursor: global637)
							)
						)
					)
				)
			)
			(= global313 (temp0 message:))
			(if (!= global312 4)
				(= global313 $ffff)
			)
			(if (and (!= gTheCursor 997) MenuBar)
				(gTheSound pause: 0)
				(MenuBar handleEvent: temp0)
			)
			(GlobalToLocal temp0)
			(if (not (temp0 claimed:))
				(gGame handleEvent: temp0)
			)
		)
		(temp0 dispose:)
		(= gLastEvent 0)
	)
)

