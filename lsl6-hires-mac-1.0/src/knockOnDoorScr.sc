;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use fileScr)
(use Sound)
(use Motion)
(use System)

(public
	knockOnDoorScr 0
)

(local
	local0
	local1 = -1
	local2
)

(instance knockOnDoorScr of Script
	(properties)

	(method (dispose)
		(proc79_12 38)
		(super dispose:)
		(DisposeScript 96)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 register)
				(gEgo cycleSpeed: 1)
				(proc79_11 1038)
				(= cycles 2)
			)
			(1
				(gEgo view: 901 loop: 7 cel: 0 setCycle: End self)
				((= local2 (Sound new:)) number: 1038 loop: 1)
				(= register 2)
			)
			(2
				(local2 play:)
				(= ticks 10)
			)
			(3
				(gEgo setCycle: CT (- (gEgo cel:) 1) -1 self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(local2 play:)
				(= ticks 10)
				(if (-- register)
					(-= state 3)
				)
			)
			(6
				(local2 number: 0 dispose:)
				(= local2 0)
				(gEgo normalize: 900 8 1 cel: 3)
				(if local0
					(++ state)
				)
				(= cycles 2)
			)
			(7
				(gGame changeScore: 1 211)
				(gMessager say: 2 4 0 (Random 1 28) self 205)
			)
			(8
				(if (not local0)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

