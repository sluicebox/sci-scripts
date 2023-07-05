;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use RTEyeCycle)
(use PPath)
(use SlowDown)
(use FuzzyStop)
(use SyncStop)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	robbedOne 0
)

(local
	[local0 8] = [2 3 1 0 0 0 0 0]
	[local8 4] = [6 6 1 1]
	[local12 4] = [5 2 4 4]
	[local16 8] = [74 151 72 151 72 153 74 153]
	[local24 13] = [-1 {Sheriff} 17 0 0 0 0 0 0 111 112 113 114]
	[local37 7] = [1240 18 1 2 1 1 0]
	[local44 5] = [1240 22 2 2 0]
	[local49 5] = [1240 24 1 1 0]
	[local54 6] = [1240 26 1 2 3 0]
	[local60 4] = [1240 29 1 0]
	[local64 8] = [1240 30 2 1 1 2 1 0]
	[local72 5] = [1240 35 1 2 0]
	[local77 4] = [1240 37 1 0]
	[local81 7] = [1240 38 1 2 1 2 0]
	[local88 4] = [1240 0 1 0]
	[local92 7] = [1240 1 2 2 1 1 0]
	[local99 8] = [1240 5 2 1 2 1 1 0]
	[local107 5] = [1240 10 1 2 0]
	[local112 8] = [1240 13 1 2 2 1 3 0]
)

(instance robbedOne of Rm
	(properties
		picture 240
		style 8
	)

	(method (init)
		(LoadMany rsVIEW 173 33 29 30 32 151 154 155)
		(super init:)
		(HandsOff)
		(laughSound flags: (& (laughSound flags:) $fffe))
		(cond
			((and (| (== gDisguiseNum 3) (== gDisguiseNum 2)) (not (IsFlag 102))) ; jewler (rouge), jewler (no rouge)
				(gEgo
					init:
					x: 319
					y: 103
					cycleSpeed: 6
					moveSpeed: 6
					ignoreActors: 1
				)
				(NormalEgo 5 29 30)
				(gRgnMusic2 number: 392 loop: -1 play:)
				(lilj x: -10 y: 111 loop: 0 stopUpd:)
				(tuckie x: 179 y: 220 loop: 3 stopUpd:)
				(SetFlag 102)
				(self setScript: theTrap)
			)
			((not (IsFlag 102))
				(gEgo
					init:
					x: 319
					y: 103
					cycleSpeed: 6
					moveSpeed: 6
					ignoreActors: 1
				)
				(NormalEgo 5 33 34)
				(lilj x: -10 y: 111 loop: 0 stopUpd:)
				(tuckie x: 179 y: 220 loop: 3 stopUpd:)
				(gRgnMusic2 number: 392 loop: -1 play:)
				(SetFlag 102)
				(self setScript: theTrap)
			)
			(else
				(self setScript: xRated)
			)
		)
	)

	(method (dispose)
		(gRgnMusic2 fade: 0 20 12 1)
		(DisposeScript 890)
		(DisposeScript 891)
		(DisposeScript 892)
		(DisposeScript 852)
		(HandsOn)
		(super dispose: &rest)
	)
)

(instance sheriffRides of Actor
	(properties
		x 319
		y 103
		view 173
		loop 1
		signal 16384
		illegalBits 0
	)
)

(instance sheriffsHead of Prop
	(properties
		x 144
		y 70
		view 173
		loop 3
		priority 15
		signal 16
	)
)

(instance lilj of Actor
	(properties
		x 303
		y 214
		view 151
		loop 1
		signal 16384
	)
)

(instance tuckie of Actor
	(properties
		x 294
		y 137
		view 154
		loop 1
		signal 16384
	)
)

(instance theTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: trapHim self)
				(= ticks 840)
			)
			(1
				(if (| (== gDisguiseNum 3) (== gDisguiseNum 2)) ; jewler (rouge), jewler (no rouge)
					(sheriffRides setScript: youFool1 self)
				else
					(sheriffRides setScript: youFool2 self)
				)
			)
			(2)
			(3
				(if (| (== gDisguiseNum 3) (== gDisguiseNum 2)) ; jewler (rouge), jewler (no rouge)
					(gCurRoom setScript: theDeception)
					(self dispose:)
				else
					(gCurRoom setScript: theCharade)
					(self dispose:)
				)
			)
		)
	)
)

(instance trapHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: SyncStop 30 self
					setMotion: SlowDown 74 151 0 9 9 14
				)
			)
			(1
				(gEgo
					setCycle: StopWalk 30
					setMotion: PPath @local16 0 3 self
				)
			)
			(2
				(gEgo setMotion: 0 setCycle: 0)
				(= ticks 6)
			)
			(3
				(gEgo loop: 6 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance youFool1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sheriffRides
					init:
					setCycle: FuzzyStop @local0 self
					setMotion: SlowDown 141 131 0 9 9 8
				)
			)
			(1
				(sheriffsHead init:)
				(sheriffRides loop: 2 cel: 0 stopUpd:)
				(= ticks 6)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theDeception of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gDisguiseNum 3) ; jewler (rouge)
					(Converse 1 @local88 5 1 self) ; "This part shall do nicely."
				else
					(Converse 1 @local88 4 1 self) ; "This part shall do nicely."
				)
			)
			(1
				(sheriffsHead cycleSpeed: 12 setCycle: End self)
			)
			(2
				(sheriffsHead setCycle: Beg self)
			)
			(3
				(sheriffsHead setCycle: CT 3 1 self)
			)
			(4
				(sheriffsHead setCycle: CT 1 -1 self)
			)
			(5
				(if (== gDisguiseNum 3) ; jewler (rouge)
					(Converse 2 @local92 5 1 12 2 self) ; "Why are we stopping here? Where is the cave?"
				else
					(Converse 2 @local92 4 1 12 2 self) ; "Why are we stopping here? Where is the cave?"
				)
			)
			(6
				(gEgo view: 32 loop: 2 x: 79 y: 154)
				(= ticks 6)
			)
			(7
				(gEgo cycleSpeed: 12 setCycle: End self)
			)
			(8
				(= ticks 60)
			)
			(9
				(gEgo setCycle: Beg self)
			)
			(10
				(gEgo setCycle: 0 cycleSpeed: 6 stopUpd:)
				(= ticks 6)
			)
			(11
				(if (== gDisguiseNum 3) ; jewler (rouge)
					(Converse 2 @local99 5 1 12 2 self) ; "Your hair...why, it's...you're..."
				else
					(Converse 2 @local99 4 1 12 2 self) ; "Your hair...why, it's...you're..."
				)
			)
			(12
				(sheriffsHead setScript: egad)
				(tuckie setScript: tWalk2)
				(lilj setScript: jWalk2 self)
			)
			(13
				(sheriffsHead setScript: 0 setCycle: CT 1 -1 self)
				(Converse 2 @local107 15 1 12 0 self) ; "Merry day, Sir Sheriff."
			)
			(14)
			(15
				(lilj setCycle: FuzzyStop @local8 self setMotion: MoveTo 82 111)
			)
			(16
				(lilj stopUpd:)
				(Converse 1 @local60 13 0 self) ; "Have a care with your words, or I'll rap some manners into you."
			)
			(17
				(lilj cel: 6 stopUpd:)
				(= ticks 6)
			)
			(18
				(lilj stopUpd:)
				(Converse 3 @local112 12 2 999 3 15 0 self) ; "What difference does it make? You'll murder me sooner as later."
			)
			(19
				(gCurRoom newRoom: 150)
				(self dispose:)
			)
		)
	)
)

(instance youFool2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sheriffRides
					init:
					setCycle: FuzzyStop @local0 self
					setMotion: SlowDown 141 131 0 9 9 8
				)
			)
			(1
				(sheriffsHead init:)
				(sheriffRides loop: 2 cel: 0 stopUpd:)
				(= ticks 6)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theCharade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local37 6 1 12 2 self) ; "This is the place. M'lord Sheriff, I present to you - Robin Hood!"
			)
			(1
				(Converse 1 @local44 12 2 self) ; "You have two good eyes? But...are you...ZOUNDS!!!"
			)
			(2
				(sheriffsHead setScript: egad)
				(= ticks 6)
			)
			(3
				(Converse 1 @local49 6 1 self) ; "Since your men will not come, then perhaps my own will."
			)
			(4
				(tuckie setScript: tWalk2 self)
				(lilj setScript: jWalk2 self)
			)
			(5)
			(6
				(= ticks 12)
			)
			(7
				(tuckie stopUpd:)
				(lilj stopUpd:)
				(sheriffsHead setScript: 0)
				(Converse 3 @local54 6 1 15 3 12 2 self) ; "Is all well?"
			)
			(8
				(lilj setCycle: FuzzyStop @local8 self setMotion: MoveTo 82 111)
			)
			(9
				(lilj stopUpd:)
				(Converse 1 @local60 13 0 self) ; "Have a care with your words, or I'll rap some manners into you."
			)
			(10
				(lilj cel: 6 stopUpd:)
				(= ticks 6)
			)
			(11
				(Converse 2 @local64 6 3 12 2 self) ; "What difference does it make? You'll murder me sooner as later."
			)
			(12
				(gCurRoom newRoom: 150)
				(self dispose:)
			)
		)
	)
)

(instance egad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sheriffsHead setCycle: Beg self)
			)
			(1
				(sheriffsHead setCycle: CT 3 1 self)
			)
			(2
				(= ticks (* 10 (Random 3 9)))
			)
			(3
				(sheriffsHead setCycle: End self)
			)
			(4
				(sheriffsHead setCycle: Beg self)
			)
			(5
				(= ticks (* 10 (Random 3 9)))
			)
			(6
				(sheriffsHead setCycle: End self)
			)
			(7
				(= ticks (* 10 (Random 3 9)))
			)
			(8
				(sheriffsHead setCycle: CT 3 1 self)
			)
			(9
				(= state -1)
				(= ticks 6)
			)
		)
	)
)

(instance jWalk of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lilj
					init:
					setCycle: FuzzyStop @local8 self
					setMotion: SlowDown 177 189 0 9 9 8
				)
			)
			(1
				(lilj stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance tWalk of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tuckie
					init:
					setCycle: FuzzyStop @local12 self
					setMotion: SlowDown 192 144 0 9 9 8
				)
			)
			(1
				(tuckie stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance jWalk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lilj
					init:
					setCycle: FuzzyStop @local8 self
					setMotion: SlowDown 77 111 0 9 9 8
				)
			)
			(1
				(lilj stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance tWalk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tuckie
					init:
					setCycle: FuzzyStop @local12 self
					setMotion: SlowDown 159 158 0 9 9 8
				)
			)
			(1
				(tuckie stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance xRated of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 6
					loop: 6
					x: 50
					y: 145
					cycleSpeed: 6
					moveSpeed: 6
					init:
				)
				(sheriffRides
					view: 173
					loop: 0
					cel: 0
					x: 110
					y: 130
					init:
					stopUpd:
				)
				(= ticks 12)
			)
			(1
				(Converse 2 @local72 @local24 2 1 3 self) ; "You said I'd be sent back as whole as I entered, you dog!"
			)
			(2
				(gEgo setScript: veryFunny self)
			)
			(3
				(Converse 1 @local77 @local24 2 self) ; "Stop laughing at me, you dung eating knave!"
			)
			(4
				(Converse 2 @local81 @local24 2 1 3 self) ; "For every insult I've suffered today, I'll see that you suffer ten-fold!"
			)
			(5
				(gEgo setScript: veryFunny)
				(= ticks 6)
			)
			(6
				(sheriffRides
					setCycle: FuzzyStop @local0 0
					setMotion: MoveTo 325 75 self
				)
			)
			(7
				(gEgo setScript: 0 setCycle: 0)
				(gCurRoom newRoom: 160)
				(self dispose:)
			)
		)
	)
)

(instance veryFunny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Fwd)
				(laughSound play:)
				(= ticks 120)
			)
			(1
				(gEgo setCycle: 0)
				(laughSound stop:)
				(= ticks (* 10 (Random 3 8)))
			)
			(2
				(gEgo loop: 7 setCycle: Fwd)
				(laughSound play:)
				(= ticks 120)
			)
			(3
				(gEgo setCycle: 0 loop: 6)
				(laughSound stop:)
				(= ticks 30)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance laughSound of Sound
	(properties
		number 394
	)
)

