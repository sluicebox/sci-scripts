;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 87)
(include sci.sh)
(use Main)
(use Interface)
(use User)
(use Actor)
(use System)

(public
	TitleButton 0
)

(local
	[local0 4] = [58 161 58 161]
	[local4 4] = [146 146 165 165]
	local8
	local9
	local10
)

(procedure (localproc_0 param1 param2)
	(= param1 local8)
	(highLight x: [local0 local8] y: [local4 local8])
	(if (== argc 2)
		(= local8 (= local10 param2))
		(highLight x: [local0 local10] y: [local4 local10])
		(TitleButton changeState: 1)
	)
)

(procedure (localproc_1)
	(proc0_7)
	(Display 87 1 dsCOORD 76 149 dsFONT 4 dsCOLOR 14) ; "Introduction"
	(Display 87 2 dsCOORD 179 149 dsFONT 4 dsCOLOR 14) ; "Begin Game"
	(Display 87 3 dsCOORD 84 168 dsFONT 4 dsCOLOR 14) ; "Credits"
	(Display 87 4 dsCOORD 173 168 dsFONT 4 dsCOLOR 14) ; "Continue Game"
)

(instance TitleButton of Script
	(properties)

	(method (init)
		(Animate (gCast elements:) 1)
		(super init: &rest)
		(= global108 1)
		(User mapKeyToDir: 0)
		(gAddToPics add: b0 b1 b2 b3 eachElementDo: #init doit:)
		(= local8 0)
		(highLight init: x: [local0 0] y: [local4 0])
		(localproc_1)
	)

	(method (dispose)
		(DisposeScript 87)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= local9 local8)
			(= local8 (= local9 local8))
			(localproc_0 local8)
		)
		(if (!= gTheCursor gNormalCursor)
			(= gTheCursor gNormalCursor)
			(SetCursor gNormalCursor (HaveMouse))
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_RIGHT
						(if (or (== local8 0) (== local8 2))
							(++ local8)
						else
							(-- local8)
						)
					)
					(KEY_LEFT
						(if (or (== local8 1) (== local8 3))
							(-- local8)
						else
							(++ local8)
						)
					)
					(KEY_UP
						(if (<= local8 1)
							(+= local8 2)
						else
							(-= local8 2)
						)
					)
					(KEY_DOWN
						(if (>= local8 2)
							(-= local8 2)
						else
							(+= local8 2)
						)
					)
					(KEY_TAB
						(if (== local8 3)
							(= local8 0)
						else
							(+= local8 1)
						)
					)
					(KEY_SHIFTTAB
						(if (== local8 0)
							(= local8 3)
						else
							(-= local8 1)
						)
					)
					(KEY_RETURN
						(localproc_0 local8 local8)
					)
					(KEY_F2
						(super handleEvent: event)
					)
					(else
						(Print 87 0) ; "Use the arrow keys then enter or mouse to select option."
					)
				)
			)
			(evMOUSEBUTTON
				(cond
					((MousedOn b0 event)
						(localproc_0 0 0)
					)
					((MousedOn b1 event)
						(localproc_0 1 1)
					)
					((MousedOn b2 event)
						(localproc_0 2 2)
					)
					((MousedOn b3 event)
						(localproc_0 3 3)
					)
					(else
						(Print 87 0) ; "Use the arrow keys then enter or mouse to select option."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(= cycles 2)
			)
			(2
				(if (== local8 3)
					(self state: 0)
					(User mapKeyToDir: 1)
					(gGame restore:)
					(User mapKeyToDir: 0)
				else
					((ScriptID 86 1) changeState: 3) ; showTitle
				)
			)
			(3
				(User mapKeyToDir: 1)
				(= global108 0)
				(switch local10
					(0
						(gCurRoom newRoom: 200) ; intro
					)
					(1
						(gCurRoom newRoom: 1)
					)
					(2
						(gCurRoom newRoom: 84) ; openCredits
					)
				)
			)
		)
	)
)

(instance b0 of View
	(properties
		x 58
		y 146
		view 950
		loop 1
	)
)

(instance b1 of View
	(properties
		x 161
		y 146
		view 950
		loop 1
	)
)

(instance b2 of View
	(properties
		x 58
		y 165
		view 950
		loop 1
	)
)

(instance b3 of View
	(properties
		x 161
		y 165
		view 950
		loop 1
	)
)

(instance highLight of View
	(properties
		view 950
		loop 2
		signal 22528
	)
)

