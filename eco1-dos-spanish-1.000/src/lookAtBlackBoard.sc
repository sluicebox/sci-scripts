;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use n819)
(use Talker)
(use Actor)
(use System)

(public
	lookAtBlackBoard 0
	lookAtCage 1
)

(local
	local0
	local1
)

(instance lookAtBlackBoard of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 69)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW (proc0_6 1377 2377 377 377 377))
				(HandsOff)
				(blackBoardInset view: (proc0_6 1377 2377 377 377 377) init:)
				((ScriptID gCurRoomNum 3) stopUpd:)
				(if (not (IsFlag 122))
					(= local1 1)
					(fris init:)
				)
				(= cycles 2)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 6)
				(switch register
					(-1
						(blackBoardInset doVerb: 2)
					)
					(-2
						(blackBoardInset doVerb: 3)
					)
				)
			)
			(2
				(HandsOff)
				(blackBoardInset hide:)
				(if (and local1 (not (gEgo has: 6))) ; frisbee
					(fris hide:)
				)
				(= cycles 3)
			)
			(3
				(blackBoardInset dispose: delete:)
				(if (and local1 (not (gEgo has: 6))) ; frisbee
					(fris dispose: delete:)
				)
				(UnLoad 128 (proc0_6 1377 2377 377 377 377))
				((ScriptID gCurRoomNum 3) startUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtCage of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 69)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 388)
				(HandsOff)
				(cageView init:)
				(gEgo stopUpd:)
				((ScriptID gCurRoomNum 3) stopUpd:)
				(= cycles 2)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4 6)
				(switch register
					(-1
						(cageView doVerb: 2)
					)
					(-2
						(cageView doVerb: 3)
					)
				)
			)
			(2
				(HandsOff)
				(cageView startUpd: hide:)
				(= cycles 3)
			)
			(3
				(cageView dispose: delete:)
				(= cycles 3)
			)
			(4
				(UnLoad 128 388)
				(gEgo startUpd:)
				((ScriptID gCurRoomNum 3) startUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance cageView of Prop
	(properties
		x 149
		y 139
		z 50
		lookStr 47
		view 388
		priority 15
		signal 20496
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(SetScore 5 241)
		(switch theVerb
			(2 ; Look
				(Narrator posn: -1 140 init: lookStr 0 380)
			)
			(3 ; Do
				(Narrator posn: -1 140 init: 123 0 380) ; "The cages need to stay where they are to protect animals who swim too close."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not (event modifiers:))
			)
			(event claimed: 1)
			((gCurRoom script:) cue:)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance blackBoardInset of Prop
	(properties
		x 110
		y 208
		z 200
		lookStr 104
		view 377
		priority 14
		signal 20496
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(SetScore 5 239)
		(switch theVerb
			(2 ; Look
				(Narrator posn: -1 140 init: lookStr 0 380)
			)
			(3 ; Do
				((ScriptID 2 1) init: 54 1 0 380) ; Adam, "I don't think I should erase the instructions."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not (event modifiers:))
			)
			(event claimed: 1)
			((gCurRoom script:) cue:)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance fris of View
	(properties
		z 200
		lookStr 53
		view 377
		loop 1
		priority 15
		signal 16400
	)

	(method (init)
		(= x (+ (blackBoardInset x:) 64))
		(= y (+ (blackBoardInset y:) 113))
		(super init: &rest)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(gEgo get: 6) ; frisbee
			((ScriptID 380 4) hide: stopUpd:) ; tFrisbee
			(SetScore 2 222)
			(SetFlag 122)
			(self dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

