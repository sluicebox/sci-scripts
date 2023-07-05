;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 239)
(include sci.sh)
(use Main)
(use Interface)
(use CursorCoords)
(use System)

(public
	chooseSpell 0
)

(local
	[local0 4] = [48 122 198 274]
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6)
	(return
		(and
			(<= param3 param1)
			(< param1 param5)
			(<= param4 param2)
			(< param2 param6)
		)
	)
)

(procedure (localproc_1)
	(button1 init:)
	((ScriptID 32 1) add: button1) ; objList
	(button2 init:)
	((ScriptID 32 1) add: button2) ; objList
	(button3 init:)
	((ScriptID 32 1) add: button3) ; objList
	(button4 init:)
	((ScriptID 32 1) add: button4) ; objList
)

(instance chooseSpell of Script
	(properties)

	(method (dispose)
		((ScriptID 32 1) empty:) ; objList
		(super dispose:)
		(DisposeScript 239)
	)

	(method (handleEvent event &tmp [temp0 3] temp3 temp4)
		(if (and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			(event type: evMOUSEBUTTON)
		)
		(cond
			((super handleEvent: event))
			((== (event type:) $0040) ; direction
				((ScriptID 32 1) handleEvent: event) ; objList
			)
			((== (event type:) evMOUSEBUTTON)
				(= temp3 (event x:))
				(= temp4 (event y:))
				(event claimed: 1)
				(cond
					((localproc_0 temp3 temp4 17 18 79 29)
						(= global202 0)
						(= global203 2)
						(self dispose:)
					)
					((localproc_0 temp3 temp4 91 18 153 29)
						(= global202 1)
						(= global203 3)
						(self dispose:)
					)
					((localproc_0 temp3 temp4 167 18 229 29)
						(= global202 2)
						(= global203 4)
						(self dispose:)
					)
					((localproc_0 temp3 temp4 243 18 305 29)
						(= global202 3)
						(= global203 5)
						(self dispose:)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((!= (event type:) evSAID))
			((Said 'drink')
				(event claimed: 0)
			)
			((or (Said 'cast/fetch') (Said 'fetch,get'))
				(= global202 0)
				(= global203 2)
				(self dispose:)
			)
			((or (Said 'cast/open') (Said 'open'))
				(= global202 1)
				(= global203 3)
				(self dispose:)
			)
			((or (Said 'cast/trigger') (Said '/trigger'))
				(= global202 2)
				(= global203 4)
				(self dispose:)
			)
			((or (Said 'cast/dart,flame,fire') (Said '/flame,fire,torch'))
				(= global202 3)
				(= global203 5)
				(self dispose:)
			)
			((or (Said 'resign,quit,done,stop') (Said '/bye[<bye]'))
				(= global203 0)
				(SetFlag 337)
				((ScriptID 32 0) cue:) ; wizGame
				(self dispose:)
			)
			((Said 'throw')
				(Print 239 0) ; "Your bug doesn't have any hands. This makes throwing anything out of the question."
			)
			((Said 'run,sneak')
				(Print 239 1) ; "Looks like all you can do is wriggle."
			)
			((Said 'drink')
				(event claimed: 0)
			)
			(else
				(Print 239 2) ; "Better concentrate on the game."
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetCursor gTheCursor 1 [local0 global202] 23)
				((ScriptID 32 1) empty:) ; objList
				(localproc_1)
			)
		)
	)
)

(instance button1 of CursorCoords
	(properties
		cursorX 48
		cursorY 23
	)
)

(instance button2 of CursorCoords
	(properties
		cursorX 122
		cursorY 23
	)
)

(instance button3 of CursorCoords
	(properties
		cursorX 198
		cursorY 23
	)
)

(instance button4 of CursorCoords
	(properties
		cursorX 274
		cursorY 23
	)
)

