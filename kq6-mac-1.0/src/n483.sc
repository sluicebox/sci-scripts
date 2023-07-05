;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 483)
(include sci.sh)
(use Main)
(use n913)
(use Conversation)
(use PolyPath)
(use Motion)
(use System)

(public
	proc483_0 0
	proc483_1 1
	proc483_2 2
	proc483_3 3
	proc483_4 4
)

(procedure (proc483_0 param1)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: getBottle 0 param1)
)

(procedure (proc483_1)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: getGrapes)
)

(procedure (proc483_2 param1)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: getTomato 0 param1)
)

(procedure (proc483_3 param1)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: pickLettuce 0 param1)
)

(procedure (proc483_4 param1)
	((ScriptID 480 5) register: 1) ; wallFlowerDance
	(gEgo setScript: chokeDie 0 param1)
)

(instance myConv of Conversation
	(properties)
)

(instance getGrapes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 12 5 0 1 self 480) ; "Alexander gets closer to the sour grapes."
			)
			(1
				(gEgo setMotion: PolyPath 16 95 self)
			)
			(2
				(gEgo setHeading: 0)
				(= ticks 6)
			)
			(3
				(myConv add: 480 12 5 0 2 add: 480 12 5 0 3 init: self) ; "BACK OFF, BUCK-O!", "Oh! Excuse me!"
			)
			(4
				(gGame handsOn:)
				(gEgo setHeading: 180)
				(self dispose:)
				(DisposeScript 483)
			)
		)
	)
)

(instance getTomato of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 170 157 self)
			)
			(1
				(gEgo setPri: 12 setMotion: PolyPath 154 157 self)
			)
			(2
				(gGame givePoints: 1)
				(gEgo
					view: 481
					setLoop: 0
					cel: 0
					posn: 151 157
					normal: 0
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(3
				(gMessager say: 6 5 0 1 self 480) ; "Hey! Whaddaya think yer doin' there! Get yer hands off me! Hey!"
			)
			(4
				(register dispose:)
				(gEgo setCycle: End self)
			)
			(5
				(gMessager say: 6 5 0 2 self 480) ; "Alexander picks up Rotten Tomato and puts him away. One never knows when one will need a rotten tomato."
			)
			(6
				(gGame handsOn:)
				(gEgo posn: 154 157 reset: 7)
				(self dispose:)
				(DisposeScript 483)
			)
		)
	)
)

(instance pickLettuce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 119))
					(SetFlag 119)
					(gGame givePoints: 1)
				)
				(if (gEgo has: 21) ; lettuce
					(gMessager say: 10 5 31 1 self 480) ; "Alexander replaces his watery lettuce with a freshly picked specimen."
				else
					(gMessager say: 10 5 0 1 self 480) ; "Alexander picks a head of iceberg lettuce."
				)
			)
			(1
				(gEgo setMotion: PolyPath 180 133 self)
			)
			(2
				(gEgo setHeading: 335)
				(= ticks 6)
			)
			(3
				(gEgo
					view: 481
					posn: 170 136
					setLoop: 2
					cel: 0
					normal: 0
					cycleSpeed: 12
					get: 21 ; lettuce
					setCycle: End self
				)
			)
			(4
				(gMessager say: 10 5 0 2 self 480) ; "Ye gads, is that cold!"
			)
			(5
				(gGame handsOn:)
				(gEgo posn: 180 133 reset: 7)
				((gInventory at: 21) ; lettuce
					state: 0
					noun: 20
					message: 52
					cel: 4
					setCursor: 990 1 4
				)
				((ScriptID 0 7) setReal: (gInventory at: 21) 30 2) ; lettuceTimer, lettuce
				(self dispose:)
				(DisposeScript 483)
			)
		)
	)
)

(instance chokeDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 5)
					(gMessager say: 13 5 0 1 self 480) ; "Alexander decides to examine the vines on the wall more closely."
				else
					(gMessager say: 13 3 0 1 self 480) ; "Alexander gets a little too close to the vines on the wall."
				)
			)
			(1
				(if (== register 5)
					(gEgo setMotion: PolyPath 60 98 self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setHeading: 0)
				(= cycles 8)
			)
			(3
				(gEgo normal: 0 view: 486 setLoop: 0 cel: 0)
				(gGlobalSound number: 487 setLoop: 1 play:)
				(= cycles 6)
			)
			(4
				(gMessager say: 13 5 0 2 self 480) ; "(VERY WHINY VOICES)<whine> Come CLOSER! We lIKe you!"
			)
			(5
				(gEgo cycleSpeed: 12 setCycle: CT 3 1 self)
			)
			(6
				(myConv
					add: 480 13 5 0 3 ; "!!!Removed msg"
					add: 480 13 5 0 4 ; "!!!Removed msg"
					add: 480 13 5 0 5 ; "Uh...I appreciate <cough> your enthusiasm <choke>, but I'm really not interested...<gag>!"
					add: 480 13 5 0 6 ; "Don't LEAve us! We LIke you!"
					init: self
				)
			)
			(7
				(gEgo cel: 4)
				(= ticks 6)
			)
			(8
				(gMessager say: 13 5 0 7 self 480) ; "!!!removed msg"
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(gMessager say: 13 5 0 8 self 480) ; "!!!Do sound effect: "GASP!""
			)
			(11
				(gMessager say: 13 5 0 9 self 480) ; "!!!Removed msg"
			)
			(12
				(EgoDead 22) ; "Just wanna be loved by you...."
			)
		)
	)
)

(instance getBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 0)
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						setMotion: PolyPath 215 155 self
					)
				else
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						setMotion: PolyPath 286 79 self
					)
				)
			)
			(1
				(if (== register 1)
					(gEgo
						normal: 0
						view: 488
						setLoop: 0
						cel: 0
						cycleSpeed: 12
						setCycle: CT 2 1 self
						posn: 292 78
					)
				else
					(gEgo
						normal: 0
						view: 4811
						setLoop: 2
						cel: 0
						cycleSpeed: 12
						setCycle: CT 1 1 self
						posn: 227 161
					)
				)
			)
			(2
				(if (not register)
					((ScriptID 480 3) dispose:) ; drinkBottle
				else
					((ScriptID 480 4) dispose:) ; myTeaCup
				)
				(gEgo setCycle: End self)
			)
			(3
				(if (== register 1)
					(gMessager say: 22 5 0 1 self 480) ; "Alexander takes the teacup."
				else
					(gMessager say: 8 5 0 1 self 480) ; "Alexander picks up the bottle."
				)
			)
			(4
				(if (== register 1)
					(gEgo reset: 0 setMotion: PolyPath 197 116 self get: 46) ; teaCup
				else
					(gEgo
						posn: (- (gEgo x:) 15) (- (gEgo y:) 6)
						get: 33 ; potion
						reset: 0
					)
					(= cycles 2)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 483)
			)
		)
	)
)

