;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Inset)
(use Actor)
(use System)

(public
	invInset 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 (param1 cel:))
	(param1 cel: param2)
	(UpdateScreenItem param1)
	(FrameOut)
	(= temp2 1)
	(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
		(temp0 localize: gThePlane)
		(cond
			((param1 onMe: temp0)
				(if (== (param1 cel:) temp1)
					(param1 cel: param2)
					(= temp2 1)
					(UpdateScreenItem param1)
					(FrameOut)
				)
			)
			((!= (param1 cel:) temp1)
				(param1 cel: temp1)
				(= temp2 0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
		)
		(temp0 dispose:)
	)
	(temp0 dispose:)
	(param1 cel: temp1)
	(UpdateScreenItem param1)
	(return temp2)
)

(instance invInset of Inset
	(properties
		view 9100
		x 90
		y 30
	)

	(method (init param1 param2 param3 param4)
		(super init: param1 param2 param3 param4)
		(if (Robot 6) ; Exists
			(Robot 10) ; Pause
		)
		(gTheControlList eachElementDo: #enable 0)
		(gInventory eachElementDo: #enable 0)
		(closeButton init:)
		(FrameOut)
		(gNormalCursor view: 9961 loop: 0 cel: 1)
		(gGame setCursor: gNormalCursor 1)
		(= local2 global118)
		(= local3 global161)
		(= global118 0)
		(= global161 0)
		(gExtMouseHandler add: self)
		(gKeyDownHandler add: self)
		(= local1 (+ param4 50))
		(= local0 (ScriptID local1 0))
		(local0
			init: 0 0 (CelHigh view loop cel) (CelWide view loop cel)
			setPri: 15
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evKEYBOARD
				(super handleEvent: event)
			)
			(else
				(cond
					((closeButton onMe: event)
						(local0 rotating: 0)
						(closeButton handleEvent: event)
					)
					((and (local0 scratch:) (local0 onMe: event))
						(local0 rotating: 0)
						(super handleEvent: event)
					)
					((and (local0 myFeat:) ((local0 myFeat:) onMe: event))
						(local0 rotating: 0)
						((local0 myFeat:) handleEvent: event)
					)
					(else
						(local0 handleEvent: event)
					)
				)
			)
		)
	)

	(method (doVerb)
		(gGame pragmaFail:)
	)

	(method (dispose &tmp temp0 temp1)
		(local0 dispose:)
		(gExtMouseHandler delete: self)
		(gKeyDownHandler delete: self)
		(gTheControlList eachElementDo: #enable 1)
		(gInventory eachElementDo: #enable 1)
		(= temp0 (gInventory at: register))
		(gCurrentControl select: (temp0 verb:) gInvCursor)
		(gUser message: -1)
		(= global118 local2)
		(= global161 local3)
		(= global192 gInvCursor)
		(gGame setCursor: gInvCursor 1 269 170)
		(gNormalCursor view: 9960)
		(super dispose:)
		(ClearFlag 64)
		(if (and (Robot 6) (not (IsFlag 297))) ; Exists
			(Robot 4) ; Play
		)
		((gUser curEvent:) new:)
		((ScriptID 0 19) doit: 0) ; intHSCode
		(FrameOut)
	)
)

(instance closeButton of View
	(properties
		x 4
		y 3
		view 9100
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 200 setHotspot: 4 3) ; Do, Move
	)

	(method (doVerb)
		(if (localproc_0 self 1)
			(invInset dispose:)
		)
	)
)

(instance dispScr of Script ; UNUSED
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(invInset dispose:)
			)
		)
	)
)

