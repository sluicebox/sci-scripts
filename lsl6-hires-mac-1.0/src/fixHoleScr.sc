;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use fileScr)
(use Sound)
(use Motion)
(use System)

(public
	fixHoleScr 0
	wrenchTankScr 1
	operateTankLidScr 2
	takeOrPutFilterScr 3
	greasePistonScr 4
)

(local
	local0
)

(instance fixHoleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 6 11 0 0 self) ; "Hmmm. What if I wrapped this elastic belt around the hose?"
			)
			(2
				(gGame changeScore: 7 182)
				(gEgo
					view: 331
					loop: 3
					cel: 0
					setSpeed: 10
					posn: 214 98
					setCycle: CT 9 1 self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				((ScriptID 330 9) cue:) ; hoseWithHole
				(gEgo put: 4 normalize: 900 8 cel: 6) ; belt
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wrenchTankScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo view: 3311 loop: 2 cel: 0 setSpeed: 8 setCycle: 0)
				(= register 6)
				(= cycles 2)
			)
			(2
				(gGlobalSound2 number: 404 loop: 1 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(3
				(if (-- register)
					(-= state 2)
				)
				(= ticks 10)
			)
			(4
				(gGlobalSound2 stop:)
				(gEgo normalize: 900 8 cel: 7)
				(= cycles 2)
			)
			(5
				(if (not (IsFlag 29))
					(SetFlag 29)
					(= register 1)
					(gGame changeScore: 5 178)
				else
					(ClearFlag 29)
					(= register 0)
					(if (IsFlag 180)
						(gGame changeScore: 3 181)
					)
				)
				(gMessager say: 8 64 (if register 7 else 17) 0 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance operateTankLidScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGlobalSound2 loop: 1 number: 366 play:)
				(gEgo view: 3311 loop: 1 setSpeed: 13)
				((ScriptID 330 11) view: 3311 loop: 0) ; lid
				(if (= register (IsFlag 30))
					(gEgo cel: 3 setCycle: Beg self)
					((ScriptID 330 11) cel: 2 setCycle: Beg (ScriptID 330 11)) ; lid, lid
					(ClearFlag 30)
				else
					(if (== ((gInventory at: 13) owner:) gCurRoomNum) ; filter
						((ScriptID 330 10) init:) ; filter
					)
					(gEgo cel: 0 setCycle: End self)
					((ScriptID 330 11) cel: 0 setCycle: End self) ; lid
					(SetFlag 30)
				)
			)
			(2 0)
			(3
				(if (and register (== ((gInventory at: 13) owner:) gCurRoomNum)) ; filter
					((ScriptID 330 10) dispose:) ; filter
				)
				(gEgo normalize: 900 8 cel: 7)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance greasePistonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 6 setMotion: MoveTo 45 121 self)
				(= local0 register)
				(= register 3)
			)
			(1
				(gEgo
					view: 331
					loop: 5
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(= ticks 20)
			)
			(2
				(sfx play:)
			)
			(3
				(if (-- register)
					(-= state 3)
				)
				(= ticks 1)
			)
			(4
				((ScriptID 330 8) view: 336 loop: 2) ; pistonShaft
				(if (== local0 30)
					(gEgo put: 24) ; lard
				else
					((gInventory at: 23) cue: 1) ; lamp
					(gInventory show:)
				)
				(= register 3)
				(= ticks 1)
			)
			(5
				(gEgo
					view: 331
					loop: 5
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
				(= ticks 20)
			)
			(6
				(sfx play:)
			)
			(7
				(if (-- register)
					(-= state 3)
				)
				(= ticks 1)
			)
			(8
				(gEgo normalize: 900 8 cel: 3)
				(= cycles 2)
			)
			(9
				(gGame changeScore: 6 177)
				(= cycles 2)
			)
			(10
				(gEgo
					setSpeed: 6
					setMotion:
						MoveTo
						((ScriptID 330 8) approachX:) ; pistonShaft
						((ScriptID 330 8) approachY:) ; pistonShaft
						self
				)
			)
			(11
				(= cycles 2)
			)
			(12
				(gMessager say: 13 local0 0 0 self)
			)
			(13
				(gEgo setSpeed: global167)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gSounds delete: (sfx dispose: yourself:))
		(super dispose:)
	)
)

(instance takeOrPutFilterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gGame changeScore: 4 179)
				else
					(gGame changeScore: 4 180)
				)
				(= cycles 2)
			)
			(1
				(gEgo view: 3311 loop: 1 cel: 0 setCycle: 0)
				(= ticks 20)
			)
			(2
				(if register
					(gEgo get: 13) ; filter
					((ScriptID 330 10) dispose:) ; filter
				else
					(gEgo put: 13 gCurRoomNum) ; filter
					((ScriptID 330 10) init:) ; filter
				)
				(= ticks 20)
			)
			(3
				(gEgo normalize: 900 8 cel: 7)
				(= cycles 2)
			)
			(4
				(if register
					(gMessager say: 7 5 0 0 self) ; "(DISGUSTEDLY) Hmmmfh."
				else
					(= cycles 2)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 632
	)
)

