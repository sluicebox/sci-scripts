;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
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
		lastCursor 0
		exitDir 0
		eCursor 1
		noun 0
	)

	(method (init)
		(gGk1Exits add: self)
		(= lastCursor gTheCursor)
		(= eCursor 1)
	)

	(method (dispose)
		(if (== gTheCursor (ScriptID 0 1)) ; globeCursor
			(gGame setCursor: lastCursor)
		)
		(gGk1Exits delete: self)
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
				(= eCursor 1)
			)
			((!= gTheCursor (ScriptID 0 1))) ; globeCursor
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
				(if eCursor
					(= lastCursor gTheCursor)
					((ScriptID 0 1) view: cursor setCel: 0 setLoop: 0) ; globeCursor
					(gGame setCursor: (ScriptID 0 1)) ; globeCursor
					(= eCursor 0)
				)
			)
			((not eCursor)
				(if (== gTheCursor (ScriptID 0 1)) ; globeCursor
					(gGame setCursor: lastCursor)
				)
				(= eCursor 1)
			)
		)
	)
)

