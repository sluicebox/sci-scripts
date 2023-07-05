;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	knockOnDoorScr 0
)

(local
	local0
)

(instance knockOnDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 register)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 901
					loop: 7
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
				(= register 5)
			)
			(2
				(knockFX play:)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: CT (- (gEgo cel:) 1) -1 self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(knockFX play:)
				(if (-- register)
					(-= state 3)
				)
				(= ticks 1)
			)
			(6
				(gEgo normalize: 900 8 1 cel: 3)
				(if local0
					(++ state)
				)
				(= cycles 2)
			)
			(7
				(gNarrator y: 10)
				(gGame changeScore: 1 211)
				(gMessager say: 2 4 0 (Random 1 28) self 205)
			)
			(8
				(if (not local0)
					(gNarrator y: -1)
					(gGame handsOn:)
				)
				(knockFX dispose:)
				(self dispose:)
				(DisposeScript 96)
			)
		)
	)
)

(instance knockFX of Sound
	(properties
		number 38
	)
)

