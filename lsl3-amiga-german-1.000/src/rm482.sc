;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 482)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm482 0
)

(local
	[string 400]
)

(instance aWine of View
	(properties
		x 162
		y 115
		view 480
		loop 4
		cel 3
	)

	(method (init)
		(super init:)
		(self setPri: 10 setCel: 3 ignoreActors: stopUpd:)
	)
)

(instance aDoor of Prop
	(properties
		x 159
		y 65
		view 480
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors: stopUpd:)
	)
)

(instance aPanties of View
	(properties
		x 63
		y 131
		view 480
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aBra of View
	(properties
		x 63
		y 131
		view 480
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aPantyhose of View
	(properties
		x 63
		y 141
		view 480
		loop 1
		cel 2
	)

	(method (init)
		(super init:)
		(self setPri: 11 ignoreActors: stopUpd:)
	)
)

(instance aDress of Prop
	(properties
		x 39
		y 107
		view 480
		loop 2
	)

	(method (init)
		(super init:)
		(self
			setPri: 11
			setCel: (if (InRoom 17 484) 0 else 255)
			ignoreActors:
			stopUpd:
		)
	)
)

(instance atpTelescope of PicView
	(properties
		x 160
		y 50
		view 480
		loop 3
		priority 1
		signal 16384
	)
)

(instance rm482 of Rm
	(properties
		picture 480
	)

	(method (init)
		(HandsOff)
		(Load rsSCRIPT 969)
		(Load rsVIEW 721)
		(Load rsSOUND 486)
		(Load rsSOUND 487)
		(Load rsSOUND 488)
		(super init:)
		(gMusic number: 486 loop: 2 play:)
		(aWine init: setCel: 1 stopUpd:)
		(aDoor init:)
		(aPanties init:)
		(aBra init:)
		(aPantyhose init:)
		(aDress init:)
		(aBubbleLarry setScript: PrintLarry init:)
		(aBubblePatti setScript: PrintPatti init:)
		(gAddToPics add: atpTelescope doit:)
		(self setScript: RoomScript)
		(aPatti init:)
		(gEgo
			ignoreActors:
			illegalBits: 0
			setPri: 8
			view: 484
			loop: 0
			cycleSpeed: 4
			cel: 1
			setCycle: Fwd
			posn: 178 105
			init:
		)
		(gSystemWindow color: gTextColor back: gBackgroundColor)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(gGame setSpeed: 6)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(== (event claimed:) 0)
				(== (event message:) KEY_F8)
			)
			(Print 482 0) ; "Skipping ahead..."
			(SetFlag 69)
			(gCurRoom newRoom: 484)
		)
	)

	(method (changeState newState &tmp t)
		(ShowState self newState 1 4)
		(switch (= state newState)
			(0
				(= cycles 33)
			)
			(1
				(Format @string 482 1) ; "The woman of my dreams..."
				(PrintLarry cue:)
			)
			(2
				(= cycles 22)
			)
			(3
				(Format @string 482 2) ; "The man of my dreams..."
				(PrintPatti cue:)
			)
			(4
				(= cycles 22)
			)
			(5
				(Format @string 482 3) ; "I'm in love!"
				(PrintLarry cue:)
				(aBubblePatti cel: 0 setCycle: End)
			)
			(6
				(aBubblePatti setCycle: Beg)
				(= cycles 22)
			)
			(7
				(Format @string 482 4) ; "There'll never be another woman for me!"
				(PrintLarry cue:)
			)
			(8
				(= cycles 22)
			)
			(9
				(Format @string 482 5) ; "How I wish I still smoked!"
				(PrintPatti cue:)
			)
			(10
				(= cycles 33)
			)
			(11
				(Format @string 482 6) ; "The two of you drift off to sleep bathed in the glow of your experience together..."
				(= seconds (= t (+ 3 (/ (StrLen @string) gStringDelay))))
				(Print
					@string
					#time
					(LangSwitch t t (+ t t) (+ t t))
					#dispose
				)
			)
			(12
				(= cycles 33)
			)
			(13
				(Format @string 482 7) ; "That settles it; from now on it's Larry Laffer forever! Tomorrow I must call my boy friend and tell him I'm breaking off our relationship for good. Sorry, Arnold."
				(PrintPatti cue:)
			)
			(14
				(= cycles 33)
			)
			(15
				(Format @string 482 8) ; "As she falls asleep, thinking about how she'll handle the end of her other relationship, Patti murmurs softly a single, devastating word: "...Arnold.""
				(= seconds (= t (+ 3 (/ (StrLen @string) gStringDelay))))
				(Print
					@string
					#time
					(LangSwitch t t (+ t t) (+ t t))
					#dispose
				)
			)
			(16
				(= cycles 3)
			)
			(17
				(gMusic number: 487 loop: 2 play:)
				(aBubbleLarry cycleSpeed: 0)
				(Format @string 482 9) ; "What! What did she say?! Arnold? Arnold! Oh, no!"
				(PrintLarry cue:)
				(gEgo loop: 2 cel: 0 setCycle: CT 3 1)
			)
			(18
				(= cycles 5)
			)
			(19
				(Format @string 482 10) ; "I thought she felt something... I know I felt it... During the best sexual experience of my life she was thinking of another man?! I am so stupid! By now, I should have learned: some men have a way with women and some men don't!"
				(PrintLarry cue:)
			)
			(20
				(= cycles 5)
			)
			(21
				(Format @string 482 11) ; "I was a fool to believe my new body would make a difference. Nothing makes any difference! Once you're a loser, you're always a loser!"
				(PrintLarry cue:)
				(gEgo setCycle: End)
			)
			(22
				(= cycles 22)
			)
			(23
				(gEgo loop: 3 setCycle: End)
				(= cycles 44)
			)
			(24
				(Format @string 482 12) ; "I give up. I've had it with women! It's just not worth it! I'm going where no woman will ever frustrate me again!"
				(PrintLarry cue:)
			)
			(25
				(= cycles 22)
			)
			(26
				(gEgo
					posn: 188 95
					setLoop: 4
					setCycle: Fwd
					setStep: 1 1
					cycleSpeed: 0
					setMotion: MoveTo 193 90 self
				)
			)
			(27
				(gEgo
					posn: 196 103
					view: 721
					setLoop: 0
					setCel: 255
					setPri: -1
					cycleSpeed: 1
				)
				(= cycles 6)
			)
			(28
				(gEgo setCycle: Beg self)
			)
			(29
				(= cycles 11)
			)
			(30
				(NormalEgo 0 720)
				(HandsOff)
				(gEgo setMotion: MoveTo 231 (gEgo y:) self)
			)
			(31
				(gEgo setMotion: MoveTo 231 120 self)
			)
			(32
				(gEgo setMotion: MoveTo 160 188 self)
			)
			(33
				(gEgo setMotion: MoveTo 160 444 self)
			)
			(34
				(aPatti cycleSpeed: 1 loop: 2 cel: 0 setCycle: End)
				(= cycles 33)
			)
			(35
				(aPatti setCycle: CT 7 -1)
				(= cycles 22)
			)
			(36
				(aPatti setCycle: End)
				(= cycles 22)
			)
			(37
				(aPatti setCycle: CT 7 -1 self)
			)
			(38
				(aPatti setCycle: End self)
			)
			(39
				(aPatti cycleSpeed: 0 setCycle: CT 7 -1 self)
			)
			(40
				(aPatti setCycle: End self)
			)
			(41
				(gMusic number: 488 loop: 2 play:)
				(aPatti posn: 155 98 setLoop: 3 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(42
				(aBubblePatti cycleSpeed: 0)
				(Format @string 482 13) ; "HE'S GONE! What happened? Where could he be?"
				(PrintPatti cue:)
			)
			(43
				(= cycles 11)
			)
			(44
				(Format @string 482 14) ; "Oh, no! I finally meet the man of my dreams, and now he vanishes into thin air!"
				(PrintPatti cue:)
			)
			(45
				(= cycles 33)
			)
			(46
				(Format @string 482 15) ; "Now what will I do?"
				(PrintPatti cue:)
			)
			(47
				(= cycles 33)
			)
			(48
				(Format @string 482 16) ; "Where is he?"
				(PrintPatti cue:)
			)
			(49
				(cls)
				(aPatti
					posn: 154 97
					cycleSpeed: 0
					setLoop: 4
					cel: 0
					setCycle: End self
					setMotion: MoveTo 148 89 self
				)
			)
			(50)
			(51
				(aPatti
					posn: 143 84
					setPri: -1
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(52
				(aPatti
					posn: 143 84
					view: 482
					setLoop: -1
					loop: 3
					setCycle: Walk
					setMotion: MoveTo 159 65 self
				)
			)
			(53
				(aDoor setCycle: End self)
			)
			(54
				(aDoor stopUpd:)
				(aPatti setMotion: MoveTo 159 55 self)
			)
			(55
				(gCurRoom newRoom: 483)
			)
		)
	)
)

(instance PrintLarry of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 2 4)
		(switch (= state newState)
			(0)
			(1
				(aBubbleLarry cel: 0 setCycle: End self)
			)
			(2
				(= seconds (PrintDelay @string))
				(Print
					@string
					#at
					10
					5
					#width
					290
					#mode
					1
					#time
					(LangSwitch
						seconds
						seconds
						(+ seconds seconds)
						(+ seconds seconds)
					)
					#dispose
				)
			)
			(3
				(aBubbleLarry setCycle: Beg)
				(= state 0)
				(RoomScript cue:)
			)
		)
	)
)

(instance PrintPatti of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 3 4)
		(switch (= state newState)
			(0)
			(1
				(aBubblePatti cel: 0 setCycle: End self)
			)
			(2
				(= seconds (PrintDelay @string))
				(Print
					@string
					#at
					10
					5
					#width
					290
					#mode
					1
					#time
					(LangSwitch
						seconds
						seconds
						(+ seconds seconds)
						(+ seconds seconds)
					)
					#dispose
				)
			)
			(3
				(aBubblePatti setCycle: Beg)
				(= state 0)
				(RoomScript cue:)
			)
		)
	)
)

(instance aBubblePatti of Prop
	(properties
		x 141
		y 82
		view 485
		loop 1
		cycleSpeed 1
	)
)

(instance aBubbleLarry of Prop
	(properties
		x 179
		y 82
		view 484
		loop 1
		cycleSpeed 1
	)
)

(instance aPatti of Actor
	(properties
		view 485
		cycleSpeed 4
	)

	(method (init)
		(super init:)
		(self ignoreActors: posn: 155 98 setPri: 8 setCycle: Fwd)
	)
)

