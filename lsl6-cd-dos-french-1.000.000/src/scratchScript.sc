;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	scratchScript 0
)

(local
	[local0 6] = [913 911 912 910 909 324]
)

(instance scratchScript of Script
	(properties)

	(method (doit)
		(if (gEgo edgeHit:)
			(gGame handsOn:)
			(gEgo normalize: 900 -1 1)
			(self dispose:)
			(DisposeScript 97)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0)
				(= register 0)
				(switch (++ global192)
					(1
						(if (!= (gEgo cel:) 4)
							(gEgo cycleSpeed: 8 setHeading: 125 self)
						else
							(gEgo heading: 125)
							(= cycles 2)
						)
						(Load rsSOUND 43)
						(= state 9)
					)
					(2
						(if (!= (gEgo cel:) 4)
							(gEgo cycleSpeed: 8 setHeading: 125 self)
						else
							(gEgo heading: 125)
							(= cycles 2)
						)
					)
					(3
						(= state 19)
						(if (!= (gEgo cel:) 6)
							(gEgo cycleSpeed: 8 setHeading: 45 self)
						else
							(gEgo heading: 45)
							(= cycles 2)
						)
					)
					(else
						(= state 29)
						(if (> global192 5)
							(= global192 0)
						)
						(if (!= (gEgo cel:) 2)
							(gEgo cycleSpeed: 8 setHeading: 180 self)
						else
							(gEgo heading: 180)
							(= cycles 2)
						)
					)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 911
					setLoop: 0
					cycleSpeed: 8
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setLoop: 1 cycleSpeed: 12 setCycle: Fwd)
				(= seconds 5)
			)
			(4
				(gEgo setLoop: 0 cel: 4 setCycle: Beg self)
				(= register 4)
				(= state 35)
			)
			(10
				(= cycles 2)
			)
			(11
				(gEgo
					view: 911
					setLoop: 0
					cycleSpeed: 8
					cel: 0
					setCycle: End self
				)
				(Load rsSOUND 43)
				(Load rsVIEW 910)
			)
			(12
				(whistle number: 43 loop: 1 play: self)
				(gEgo view: 910 setLoop: 0 cycleSpeed: 12 setCycle: Fwd)
			)
			(13
				(= register 4)
				(= state 35)
				(gEgo
					view: 911
					setLoop: 0
					cycleSpeed: 8
					cel: 4
					setCycle: Beg self
				)
			)
			(20
				(= cycles 2)
			)
			(21
				(gEgo
					view: 912
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(22
				(gEgo setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(23
				(gEgo setLoop: 0 cel: 3 setCycle: Beg self)
			)
			(24
				(gEgo normalize: 900 6 1 cycleSpeed: 8 setHeading: 180 self)
				(= state 35)
			)
			(30
				(= cycles 2)
			)
			(31
				(switch (Random 1 2)
					(1
						(gEgo
							view: 324
							setLoop: 0
							cel: 2
							cycleSpeed: 4
							setCycle: End self
						)
					)
					(2
						(gEgo
							view: 909
							setLoop: (Random 0 1)
							cel: 0
							cycleSpeed: 8
							setCycle: End self
						)
						(= state 35)
					)
				)
			)
			(32
				(= ticks 40)
			)
			(33
				(gEgo setCycle: Beg self)
			)
			(34
				(= ticks 40)
			)
			(35
				(gEgo setCycle: CT 2 1 self)
			)
			(36
				(= ticks 30)
			)
			(37
				(if register
					(gEgo normalize: 900 register 1)
				else
					(gEgo normalize: 900 2 1)
				)
				(for ((= temp0 0)) (<= temp0 5) ((++ temp0))
					(UnLoad 128 [local0 temp0])
				)
				(gGame handsOn:)
				(whistle dispose:)
				(self dispose:)
				(DisposeScript 97)
			)
		)
	)
)

(instance whistle of Sound
	(properties)
)

