;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Menu)
(use System)

(local
	local0
)

(class KeyMouse of Obj
	(properties
		prevX 160
		prevY 90
		cursrX 160
		cursrY 90
		moveDir 0
		cursorSpeed 2
	)

	(method (tab param1)
		(= prevX cursrX)
		(= prevY cursrY)
		(+= cursrX (* [global660 param1] 7))
		(+= cursrY (* [global669 param1] 7))
		(self setCursor:)
		(= moveDir 0)
	)

	(method (doit &tmp temp0)
		(if moveDir
			(= temp0
				(cond
					(cursorSpeed cursorSpeed)
					(global688 1)
					(else 0)
				)
			)
			(= prevX cursrX)
			(= prevY cursrY)
			(+= cursrX (* [global642 moveDir] temp0 gCurRoomNum))
			(+= cursrY (* [global651 moveDir] temp0 gCurRoomNum))
			(self setCursor:)
			(if (and (== prevX cursrX) (== prevY cursrY))
				(if (> (++ local0) 1)
					(= moveDir (= local0 0))
				)
			else
				(= local0 0)
			)
		)
	)

	(method (setCursor)
		(if (> cursrX 320)
			(= cursrX 320)
		)
		(if (< cursrX 0)
			(= cursrX 0)
		)
		(if (> cursrY 200)
			(= cursrY 200)
		)
		(if (< cursrY -10)
			(= cursrY -10)
		)
		(SetCursor gTheCursor 1 cursrX cursrY)
	)
)

(class User of Obj
	(properties
		x -1
		y -1
	)

	(method (doit &tmp temp0 temp1)
		(if (= global312 ((= temp0 (Event new:)) type:))
			(temp0 modifiers: (& (temp0 modifiers:) $000f)) ; emALT | emCTRL | emSHIFT
			(= gLastEvent temp0)
			(MapKeyToDir temp0)
			(if (<= KEY_1 (temp0 message:) KEY_9)
				(KeyMouse tab: (- (temp0 message:) 49))
				(temp0 message: JOY_NULL)
			)
			(if (or (== (temp0 message:) KEY_RETURN) (== (temp0 type:) evJOYDOWN))
				(temp0 type: evMOUSEBUTTON)
				(KeyMouse moveDir: 0)
			)
			(if (== (temp0 message:) KEY_INSERT)
				(temp0 type: evMOUSEBUTTON modifiers: emALT)
				(KeyMouse moveDir: 0)
			)
			(if (== (temp0 type:) $0040) ; direction
				(if (KeyMouse moveDir:)
					(if (!= (temp0 message:) (KeyMouse moveDir:))
						(KeyMouse moveDir: (temp0 message:))
						(= local0 0)
					else
						(KeyMouse moveDir: 0)
						(= local0 0)
					)
				else
					(KeyMouse moveDir: (temp0 message:))
					(= local0 0)
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

