;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 261)
(include sci.sh)
(use Main)
(use n013)
(use ROsc)
(use Osc)
(use PolyPath)
(use StopWalk)
(use Motion)
(use System)

(public
	enterEgoDay1 0
	interrogateGirl 1
	showSomethingGirl 2
	talkToGirl 3
	girlDoRandomStuff 4
	leaveRoom 5
)

(instance enterEgoDay1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 900
					setCel: 0
					setLoop: 0
					setCycle: StopWalk -1
					state: 2
					signal: (| (gEgo signal:) $1000)
					init:
					posn: 65 122
					setMotion: MoveTo 117 122
				)
				(= cycles 7)
			)
			(1
				((ScriptID 260 1) loop: 5 cel: 0 setCycle: CT 3 1 self) ; theGirl
			)
			(2
				(gMessager say: 26 0 1 1 self) ; "(SLIGHTLY BORED SOUNDING)Hi. Look around all you want."
				((ScriptID 260 1) loop: 5 cel: 4 setCycle: ROsc -1 4 5) ; theGirl
			)
			(3
				((ScriptID 260 1) setCycle: 0) ; theGirl
				(gMessager say: 26 0 1 2 self) ; "Okay. Thanks."
			)
			(4
				(SetFlag 278)
				((ScriptID 260 1) setScript: girlDoRandomStuff) ; theGirl
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interrogateGirl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 253 127 self)
			)
			(1
				(girlDoRandomStuff dispose:)
				(Face gEgo (ScriptID 260 1) self) ; theGirl
			)
			(2
				(gMessager say: 24 10 2 1 self) ; "Could I ask you a few questions?"
			)
			(3
				(gMessager say: 24 10 2 2 self) ; "I wouldn't be much help."
				((ScriptID 260 1) setCel: 0 setLoop: 5 setCycle: Osc 1 self) ; theGirl
			)
			(4)
			(5
				(gMessager say: 24 10 2 3 self) ; "You should talk to Dr. John, the owner? He'll be back tomorrow."
				((ScriptID 260 1) setCel: 0 setLoop: 5 setCycle: Osc 1 self) ; theGirl
			)
			(6)
			(7
				(gMessager say: 24 10 2 4 self) ; "I see. Thank you."
			)
			(8
				((ScriptID 260 1) setScript: girlDoRandomStuff) ; theGirl
				(= cycles 2)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showSomethingGirl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 253 127 self)
			)
			(1
				(girlDoRandomStuff dispose:)
				(Face gEgo (ScriptID 260 1) self) ; theGirl
			)
			(2
				(gMessager say: 24 0 0 1 self) ; "Do you know anything about this?"
				(gEgo view: 904 setCel: 0 setLoop: 4 setCycle: End self)
			)
			(3)
			(4
				(gMessager say: 24 0 0 2 self) ; "Nope."
				((ScriptID 260 1) setCel: 0 setLoop: 5 setCycle: Osc 1 self) ; theGirl
			)
			(5)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 6 900 ignoreActors: 1)
				((ScriptID 260 1) setScript: girlDoRandomStuff) ; theGirl
				(= cycles 2)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToGirl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 253) (!= (gEgo y:) 127))
					(gEgo setMotion: PolyPath 253 127 self)
				else
					(= cycles 1)
				)
			)
			(1
				(girlDoRandomStuff dispose:)
				(Face gEgo (ScriptID 260 1) self) ; theGirl
			)
			(2
				(gMessager say: 24 11 0 1 self) ; "So how's the museum business?"
			)
			(3
				(gMessager say: 24 11 0 2 self) ; "I dunno. I don't normally work here."
				((ScriptID 260 1) setCel: 0 setLoop: 5 setCycle: Osc 1 self) ; theGirl
			)
			(4)
			(5
				((ScriptID 260 1) setScript: girlDoRandomStuff) ; theGirl
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance girlDoRandomStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 260 1) loop: 1 cel: 0 setCycle: Osc 1 self) ; theGirl
			)
			(1
				(= seconds (Random 2 5))
			)
			(2
				((ScriptID 260 1) loop: 2 cel: 0 setCycle: Osc 1 self) ; theGirl
			)
			(3
				(= seconds (Random 2 5))
			)
			(4
				((ScriptID 260 1) loop: 3 cel: 0 setCycle: Osc 1 self) ; theGirl
			)
			(5
				(= seconds (Random 2 5))
			)
			(6
				((ScriptID 260 1) loop: 4 cel: 0 setCycle: Osc 1 self) ; theGirl
			)
			(7
				(= seconds (Random 2 5))
			)
			(8
				(self changeState: 0)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 129 122 self)
			)
			(1
				(if (== gDay 1)
					(girlDoRandomStuff dispose:)
					(Face gEgo (ScriptID 260 1) self) ; theGirl
				else
					(Face gEgo (ScriptID 260 2) self) ; drJohn
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (== gDay 1)
					(gMessager say: 26 0 55 1 self) ; "I'll be going now. Thanks."
				else
					(gMessager say: 26 0 56 (Random 1 3) self)
					((ScriptID 260 3) init: setCel: 0 setCycle: CT 3 1) ; drJohnHead
				)
			)
			(4
				(if (== gDay 1)
					((ScriptID 260 1) loop: 5 cel: 0 setCycle: CT 3 1 self) ; theGirl
				else
					((ScriptID 260 4) dispose:) ; drJohnReading
					(= cycles 2)
				)
			)
			(5
				(if (== gDay 1)
					(gMessager say: 26 0 55 2 self) ; "So long."
					((ScriptID 260 1) loop: 5 cel: 4 setCycle: ROsc -1 4 5) ; theGirl
				else
					(gMessager say: 26 0 57 (Random 1 3) self)
				)
			)
			(6
				(if (== gDay 1)
					((ScriptID 260 1) setCycle: 0) ; theGirl
				)
				(gEgo setMotion: PolyPath 109 122 self)
			)
			(7
				(gEgo setMotion: MoveTo 65 122 self)
			)
			(8
				(gCurRoom newRoom: 200)
			)
		)
	)
)

