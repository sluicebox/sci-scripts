;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use PolyPath)
(use User)
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
		modNum -1
		noun 0
	)

	(method (init)
		(gExHandler add: self)
		(= cursor ((Cursor new:) view: cursor))
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(= temp0 (if gDoVerbCode gDoVerbCode else dftDoVerb))
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		else
			(temp0 doit: theVerb self)
		)
	)

	(method (dispose &tmp temp0)
		(if (IsObject cursor)
			(= temp0 cursor)
			(= cursor (temp0 view:))
			(temp0 dispose:)
		)
		(gExHandler delete: self)
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
			(
				(or
					(and
						(== ((ScriptID 883 7) cel:) 1) ; iconBarCursor
						(not (== gTheIconBar (ScriptID 883 2))) ; pepperIconBar
					)
					(and
						(== ((ScriptID 883 7) cel:) 1) ; iconBarCursor
						(== gTheIconBar (ScriptID 883 2)) ; pepperIconBar
					)
				)
				(self doVerb: 6)
				(event claimed: 1)
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
				(if (and (User canControl:) (== lastCursor -1))
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

(instance dftDoVerb of Code
	(properties)

	(method (doit)
		(return 1)
	)
)

