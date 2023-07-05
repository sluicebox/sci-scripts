;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 277)
(include sci.sh)
(use Main)
(use n913)
(use PolyPath)
(use Motion)
(use System)

(public
	talkClownNotFriendScr 0
	talkClownFriendScr 1
	showClownScr 2
	showItemScr 3
)

(local
	local0
)

(instance talkClownNotFriendScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 78)
					(= register 16)
				else
					(SetFlag 78)
					(= register 8)
				)
				(gGame handsOff:)
				(gMessager say: 10 2 register 1 self)
			)
			(1
				((ScriptID 274 0) ; clown
					setScript: 0
					view: 2721
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 10 2 register 2 self)
			)
			(3
				((ScriptID 274 0) setCycle: Beg self) ; clown
			)
			(4
				(gGame handsOn:)
				((ScriptID 274 0) setScript: (ScriptID 274 2)) ; clown, clownScr
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 277)
	)
)

(instance talkClownFriendScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						PolyPath
						((ScriptID 274 0) approachX:) ; clown
						((ScriptID 274 0) approachY:) ; clown
						self
				)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(= register (if (== gAct 3) 14 else 15))
				(gMessager say: 10 2 register 1 self)
			)
			(4
				((ScriptID 274 0) ; clown
					setScript: 0
					view: 274
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(5
				(UnLoad 128 2721)
				((ScriptID 270 3) init:) ; clownBook
				(= cycles 2)
			)
			(6
				((ScriptID 274 0) setCycle: CT 5 1 self) ; clown
			)
			(7
				(gMessager say: 10 2 register 2 self)
			)
			(8
				(gMessager say: 10 2 register 3 self)
			)
			(9
				(gMessager say: 10 2 register 4 self)
			)
			(10
				(= cycles 2)
			)
			(11
				(gMessager
					say:
						19
						0
						(if (== gAct 3)
							28
						else
							(SetFlag 52)
							29
						)
						0
						self
				)
			)
			(12
				(= cycles 2)
			)
			(13
				(if (== gAct 3)
					(gMessager say: 10 2 register 5 self)
				else
					(= cycles 2)
				)
			)
			(14
				((ScriptID 274 0) view: 274 loop: 0 cel: 5 setCycle: End self) ; clown
			)
			(15
				(client setScript: (ScriptID 274 1)) ; clownExitScr
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 277)
	)
)

(instance showClownScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 274 0) setScript: 0) ; clown
				(if register
					(= local0 register)
				)
				(= register (if (IsFlag 10) 7 else 8))
				(self setScript: showItemScr self)
			)
			(1
				(gMessager say: 10 0 register 1 self)
			)
			(2
				((ScriptID 274 0) view: 2721 loop: 1 cel: 0 setCycle: End self) ; clown
			)
			(3
				(if local0
					(gMessager say: 10 local0 0 0 self)
				else
					(gMessager say: 10 0 register 2 self)
				)
			)
			(4
				(script cue:)
				((ScriptID 274 0) setCycle: Beg) ; clown
			)
			(5
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				((ScriptID 274 0) setScript: (ScriptID 274 2)) ; clown, clownScr
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= register (= local0 0))
		(DisposeScript 277)
	)
)

(instance showItemScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setSpeed: 6
					normal: 0
					view: 272
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(1
				(client cue:)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(if register
					(client cue:)
				else
					(= cycles 2)
				)
			)
			(4
				(gEgo
					posn:
						((ScriptID 274 0) approachX:) ; clown
						((ScriptID 274 0) approachY:) ; clown
					reset: 7
				)
				(= cycles 2)
			)
			(5
				(UnLoad 128 272)
				(= register 0)
				(self dispose:)
			)
		)
	)
)

