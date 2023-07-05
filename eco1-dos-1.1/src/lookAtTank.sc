;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use n819)
(use Talker)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	lookAtTank 0
	lookAtBlackBoard 1
	biteFinger 2
)

(instance cleanTank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 5 212)
				(= seconds 2)
			)
			(1
				(Narrator posn: 70 150 init: 3 0 0 94 self)
			)
			(2
				(oil setCycle: End self)
			)
			(3
				(oil dispose: delete:)
				(= seconds 2)
			)
			(4
				(Narrator posn: 70 150 init: 3 0 0 17 self) ; "Bacteria from the fertilizer solution breaks down the oil into harmless chemicals."
			)
			(5
				(SetFlag 16)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance lookAtTank of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 68)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 6)
			)
			(1
				(fishTankInset init:)
				(if (not (IsFlag 16))
					(oil init:)
				)
				(= cycles 6)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0)
				(switch register
					(-1
						(fishTankInset doVerb: 2)
					)
					(-2
						(fishTankInset doVerb: 3)
					)
					(else
						(fishTankInset doVerb: 4 register)
					)
				)
			)
			(3
				(HandsOff)
				(fishTankInset hide:)
				(if (not (IsFlag 16))
					(oil hide:)
				)
				(= cycles 3)
			)
			(4
				(fishTankInset dispose: delete:)
				(if (not (IsFlag 16))
					(oil dispose: delete:)
				)
				(= cycles 3)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookAtBlackBoard of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 68)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 1 canInput: 1)
				(gTheIconBar disable: 5 0 2 3 4 5)
				(if (IsFlag 15)
					(gTheIconBar disable: 6)
				)
				(blackBoardInset init:)
				(gTheIconBar disable: 0)
				(= cycles 2)
			)
			(1
				(SetScore 5 210)
				(switch register
					(-1
						(blackBoardInset doVerb: 2)
					)
					(-2
						(blackBoardInset doVerb: 3)
					)
					(else
						(blackBoardInset doVerb: 4 register)
					)
				)
			)
			(2
				(HandsOff)
				(blackBoardInset hide:)
				(= cycles 3)
			)
			(3
				(blackBoardInset dispose: delete:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fishTankInset of Prop
	(properties
		x 104
		y 206
		z 200
		view 405
		priority 13
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 16)
					(Narrator posn: 70 150 init: 3 0 0 16) ; "The sea water now appears clear. Some of the oil has fallen off the coral, too."
				else
					(Narrator posn: 70 150 init: 3 0 0 14) ; "The oil has begun to sink to the bottom."
				)
			)
			(3 ; Do
				(if (IsFlag 16)
					(Narrator posn: 70 150 init: 3 0 0 63) ; "The water looks clearer, but there's still no reason to touch it."
				else
					(Narrator posn: 70 150 init: 3 0 0 62) ; "Touching the oil-coated water might disturb the experiment."
				)
			)
			(4 ; Inventory
				(if (== invItem 3) ; beaker
					(if (IsFlag 16)
						((ScriptID 2 1) init: 2 0 0 36 1) ; Adam, "I better save this! Anyhow, the water's clean."
					else
						(fishTankInset setScript: cleanTank)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance oil of Prop
	(properties
		x 160
		y 187
		z 100
		lookStr 13
		view 405
		loop 1
		priority 14
		signal 16400
		cycleSpeed 20
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(fishTankInset doVerb: theVerb invItem &rest)
			)
			(2 ; Look
				(fishTankInset doVerb: theVerb invItem &rest)
			)
			(4 ; Inventory
				(if (== invItem 3) ; beaker
					(if (IsFlag 16)
						(Narrator posn: 70 150 init: 3 0 0 17) ; "Bacteria from the fertilizer solution breaks down the oil into harmless chemicals."
					else
						(fishTankInset setScript: cleanTank)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance blackBoardInset of Prop
	(properties
		x 140
		y 198
		z 200
		view 413
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

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((InRect 228 35 270 85 gMouseX gMouseY)
						(Narrator posn: 70 150 init: 3 0 0 36) ; "The buoy floats on the surface and the powerful transmitter sends a signal to a satellite. The satellite bounces the signal to a computer onshore."
					)
					((InRect 169 33 221 60 gMouseX gMouseY)
						(Narrator posn: 70 150 init: 3 0 0 34) ; "An extremely powerful sonar transmitter is attached to an inflatable buoy."
					)
					((InRect 169 57 221 87 gMouseX gMouseY)
						(Narrator posn: 70 150 init: 3 0 0 35) ; "A shielded cable attaches the float to the object for salvage."
					)
					(else
						(Narrator posn: 70 150 init: 3 0 0 33) ; "Adam's dad has drawn a diagram of an experimental satellite buoy."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance biteFinger of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 68)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90 self)
			)
			(1
				(gEgo view: 414 loop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				((ScriptID 400 8) startUpd: setCycle: End self) ; jaw
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				((ScriptID 400 8) setCycle: Beg self) ; jaw
			)
			(5
				(Narrator posn: 70 150 init: 3 0 0 29 self) ; "Watch it, Adam! The creature hasn't had a snack for a few thousand years!"
			)
			(6
				((ScriptID 400 8) stopUpd:) ; jaw
				(NormalEgo 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

