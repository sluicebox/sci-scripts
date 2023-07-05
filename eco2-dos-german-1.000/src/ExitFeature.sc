;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class ExitFeature of Obj
	(properties
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		cursor 999
		lastCursor -1
		retCursor -1
		exitDir 0
		noun 0
		toX 0
		toY 0
	)

	(method (init)
		(gEH add: self)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (dispose &tmp temp0)
		(gEH delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
	)

	(method (onMe param1 param2)
		(return (and (<= nsLeft param1 nsRight) (<= nsTop param2 nsBottom)))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			(
				(and
					(== (gTheCursor loop:) 10)
					(OneOf (gTheCursor cel:) 10 11 12 13)
				)
				(= temp0 (= temp1 0))
				(= temp0
					(if toX
						toX
					else
						(switch exitDir
							(1 gMouseX)
							(3 gMouseX)
							(2 320)
							(4 0)
							(else 999)
						)
					)
				)
				(= temp1
					(if toY
						toY
					else
						(switch exitDir
							(1 0)
							(3 190)
							(2
								(- gMouseY 10)
							)
							(4
								(- gMouseY 10)
							)
							(else 999)
						)
					)
				)
				(gEgo setMotion: PolyPath temp0 temp1)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)

	(method (doit)
		(cond
			((self onMe: gMouseX (- gMouseY 10))
				(if (== retCursor -1)
					(= retCursor (gTheCursor cel:))
				)
				(if (== lastCursor -1)
					(= lastCursor 1)
					(gGame setCursor: cursor)
				)
			)
			((!= lastCursor -1)
				(if (OneOf (gTheCursor cel:) 10 11 12 13)
					(gGame setCursor: retCursor)
					(= retCursor -1)
				)
				(= lastCursor -1)
			)
		)
	)
)

