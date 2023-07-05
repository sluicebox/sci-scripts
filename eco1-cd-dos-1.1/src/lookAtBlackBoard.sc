;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use Talker)
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
				(Load rsVIEW 377)
				(HandsOff)
				(blackBoardInset init:)
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
						(blackBoardInset doVerb: 1)
					)
					(-2
						(blackBoardInset doVerb: 4)
					)
				)
			)
			(2
				(HandsOff)
				(blackBoardInset hide:)
				(if (and local1 (not (gEgo has: 15))) ; frisbee
					(fris hide:)
				)
				(= cycles 3)
			)
			(3
				(blackBoardInset dispose: delete:)
				(if (and local1 (not (gEgo has: 15))) ; frisbee
					(fris dispose: delete:)
				)
				(UnLoad 128 377)
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
						(cageView doVerb: 1)
					)
					(-2
						(cageView doVerb: 4)
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

(instance cageView of EcoView
	(properties
		x 149
		y 139
		z 50
		view 388
		priority 14
		signal 16400
		lookStr 47
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
			(1 ; Look
				(EcoNarrator posn: -1 140 init: 5 0 0 lookStr 0 380)
			)
			(4 ; Do
				(EcoNarrator posn: -1 140 init: 6 0 0 23 0 380) ; "The cages need to stay where they are to protect animals who swim too close."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
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

(instance blackBoardInset of EcoProp
	(properties
		x 110
		y 208
		z 200
		view 377
		priority 14
		signal 16400
		lookStr 104
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
			(1 ; Look
				(EcoNarrator posn: -1 140 init: 6 0 0 4 0 380) ; "A set of instructions insures that all helpers treat the dolphin alike."
			)
			(4 ; Do
				((ScriptID 2 1) init: 2 0 0 54 1 0 380) ; Adam, "I don't think I should erase the instructions."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(not (& (event type:) $000a)) ; evKEYUP | evMOUSERELEASE
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

(instance fris of EcoView
	(properties
		z 200
		view 377
		loop 1
		priority 15
		signal 16400
		lookStr 53
	)

	(method (init)
		(= x (+ (blackBoardInset x:) 55))
		(= y (+ (blackBoardInset y:) 79))
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
		(switch theVerb
			(4 ; Do
				(gEgo get: 15) ; frisbee
				((ScriptID 380 4) hide: stopUpd:) ; tFrisbee
				(SetScore 4 222)
				(SetFlag 122)
				(self dispose:)
			)
			(1 ; Look
				(EcoNarrator posn: -1 140 init: 5 0 0 lookStr 0 380)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

