;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use sStartEggTimer)
(use eureka)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	proc202_1 1
	panel 2
	sPushButtons 6
	monitor1 13
	monitor2 14
	monitor3 15
)

(local
	[local0 3] = [3 4 5]
)

(procedure (proc202_1)
	(panel cel: (panel lastCel:) setCycle: Beg panel)
	(panelNoise number: 217 loop: 1 play:)
)

(instance buttonNoise of Sound
	(properties)
)

(instance panelNoise of Sound
	(properties)
)

(instance sPushButtons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rogArm init:)
				(rogHand
					init:
					x: (if (== register 2) 202 else 200)
					y: (if (== register 2) 142 else 144)
					cel: 0
					setLoop: [local0 register]
					cycleSpeed: 4
				)
				(= cycles 1)
			)
			(1
				(= ticks 30)
			)
			(2
				(rogHand setCycle: End self)
			)
			(3
				(buttonNoise number: 124 loop: 1 play: self)
			)
			(4
				(rogArm dispose:)
				(rogHand dispose:)
				(switch register
					(0
						(if
							(and
								(< (eureka puke:) 1)
								(not (IsFlag 86))
								(> gCliffyState 0)
							)
							(= next sPushGreen)
						)
						(= cycles 1)
					)
					(1
						(cond
							((< gWD40State 2)
								(gMessager say: 6 1 0 4 self 202) ; "The Eureka does not currently have a science officer."
							)
							((and (< (eureka puke:) 1) (not (IsFlag 86)))
								(= next sPushOrange)
								(= cycles 1)
							)
							(else
								(= cycles 1)
							)
						)
					)
					(2
						(= cycles 1)
						(= next sPushRed)
					)
				)
			)
			(5
				(gGame handsOn:)
				(buttonNoise dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sPushGreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
				(monitor1 init:)
			)
			(1
				(if (IsFlag 60)
					(gMessager say: 6 0 8 1 self) ; "You rang?"
				else
					(gMessager say: 6 0 8 2 self) ; "Yes, Cap'n."
				)
			)
			(2
				(self setScript: (ScriptID 218 0) self) ; sCommandCliffy
			)
			(3
				(monitor1 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushOrange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
				(monitor2 init:)
			)
			(1
				(gMessager say: 40 0 0 1 self) ; "What function may I assist you with, Captain?"
			)
			(2
				(self setScript: (ScriptID 219 0) self) ; sCommandWD40
			)
			(3
				(monitor2 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushRed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(panel init: cel: 0 setCycle: CT 5 1 self)
				(panelNoise number: 217 loop: 1 play:)
			)
			(1
				(gCast eachElementDo: #stopUpd)
				(= cycles 1)
			)
			(2
				(panel setCycle: CT 9 1 self)
				(panelNoise number: 218 loop: 1 play:)
			)
			(3
				(proc204_1)
				(panel stopUpd:)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(panelNoise dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sCycle of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1 setCycle: Beg self)
			)
			(1
				(= seconds 1)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(monitor3 setCel: 1)
				(monitor1 setCel: 1)
				(if (gCast contains: monitor2)
					(monitor2 setCel: 1)
				)
				(= ticks 20)
			)
			(2
				(monitor1 setCel: 0)
				(if (gCast contains: monitor2)
					(monitor2 setCel: 0)
				)
				(monitor3 setCel: 0)
				(-= state 2)
				(= ticks 45)
			)
		)
	)
)

(instance monitor1 of Prop
	(properties
		x 88
		y 46
		z 20
		view 201
		loop 6
		priority 10
		signal 16401
	)

	(method (init)
		(if
			(or
				(>= (eureka puke:) 4)
				(IsFlag 84)
				(== (gCurRoom script:) (ScriptID 208 0)) ; sWD40Attacks
			)
			(self loop: 0 cel: 0 setScript: sBlink noun: 36)
			(if (and (not (IsFlag 84)) (!= (gSq5Music2 number:) 105))
				(gSq5Music2 number: 105 loop: -1 play:)
			)
		else
			(self loop: 6 cel: 0 noun: 6 setCycle: 0)
		)
		(super init: &rest)
	)
)

(instance monitor2 of Prop
	(properties
		x 208
		y 46
		z 20
		noun 37
		view 201
		loop 6
		cel 1
		priority 9
		signal 16401
	)

	(method (init)
		(cond
			((or (>= (eureka puke:) 4) (IsFlag 61))
				(self loop: 2 cel: 0 noun: 37)
				(super init: &rest)
			)
			((not (IsFlag 84))
				(self loop: 6 cel: 1 noun: 40)
				(super init: &rest)
			)
		)
	)
)

(instance monitor3 of View
	(properties
		x 145
		y 45
		z 20
		noun 38
		view 201
		loop 1
		priority 9
		signal 16401
	)
)

(instance rogArm of View
	(properties
		x 194
		y 142
		view 200
		loop 2
		priority 9
		signal 16
	)
)

(instance rogHand of Prop
	(properties
		x 200
		y 144
		view 200
		loop 3
		signal 1
	)
)

(instance panel of Prop
	(properties
		x 195
		y 144
		view 201
		loop 5
		priority 9
		signal 16
	)

	(method (init)
		(if (IsFlag 84)
			(self setLoop: 5 cel: (panel lastCel:) stopUpd:)
		else
			(self setLoop: 5 cel: 0 stopUpd:)
		)
		(super init: &rest)
	)

	(method (cue)
		(self dispose:)
	)

	(method (dispose)
		(panelNoise dispose:)
		(super dispose: &rest)
	)
)

