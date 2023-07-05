;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
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
		exitDir 0
		noun 0
	)

	(method (init)
		(gLb2Exits add: self)
		(= cursor ((Cursor new:) view: cursor))
	)

	(method (dispose &tmp temp0)
		(if (IsObject cursor)
			(= temp0 cursor)
			(= cursor (temp0 view:))
			(temp0 dispose:)
		)
		(gLb2Exits delete: self)
	)

	(method (onMe param1 param2)
		(return (and (<= nsLeft param1 nsRight) (<= nsTop param2 nsBottom)))
	)

	(method (handleEvent event)
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
			((== gTheCursor ((gTheIconBar at: 1) cursor:))
				(event claimed: 1)
				(gMessager say: noun 1)
			)
			((!= gTheCursor cursor))
			(else
				(event claimed: 1)
				(switch exitDir
					(1
						(gEgo setMotion: PolyPath gMouseX 0)
					)
					(3
						(gEgo setMotion: PolyPath gMouseX 190)
					)
					(2
						(gEgo setMotion: PolyPath 320 (- gMouseY 10))
					)
					(4
						(gEgo setMotion: PolyPath 0 (- gMouseY 10))
					)
				)
			)
		)
	)

	(method (doit)
		(cond
			((self onMe: gMouseX (- gMouseY 10))
				(if (== lastCursor -1)
					(= lastCursor gTheCursor)
					(gGame setCursor: cursor)
				)
			)
			((!= lastCursor -1)
				(if (== gTheCursor cursor)
					(gGame setCursor: ((gTheIconBar walkIconItem:) cursor:))
				)
				(= lastCursor -1)
			)
		)
	)
)

