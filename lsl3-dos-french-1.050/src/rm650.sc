;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	theCounter
	seenMsg
	[string 444]
)

(procedure (Print650 w &tmp t)
	(if (< argc 1)
		(= w 200)
	)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		-1
		10
		#width
		w
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 2 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm650 of Rm
	(properties
		picture 650
	)

	(method (init)
		(HandsOff)
		(Load rsSCRIPT 969)
		(aLeg init:)
		(aMonitor init:)
		(aLeftHand init:)
		(aRightHand init:)
		(aDoor init:)
		(aTheEnd init:)
		(super init:)
		(gAddToPics add: atpKeyboard add: atpGlass add: atpBigGlass doit:)
		(self setScript: RoomScript)
		(= gOldGameSpeed (gGame setSpeed: 6))
		(NormalEgo 6 650)
		(HandsOff)
		(gEgo
			posn: 999 999
			setPri: 15
			setStep: 1 1
			setLoop: 6
			ignoreActors:
			moveSpeed: 2
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				seconds
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(= seconds 0)
			(cls)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Format @string 650 0) ; "Let's see, now: it all begins in Lost Wages...%"
				(= seconds (Print650 200))
			)
			(2
				(Format @string 650 1) ; "...outside a bar named, "Louie's." No, "Lois'." No, that's not right either. Hey, Patti! Gimme a name for a bar.%"
				(= seconds (Print650 200))
			)
			(3
				(Format @string 650 2) ; ""How about `Lefty's?'"%"
				(= seconds (Print650 122))
			)
			(4
				(Format @string 650 3) ; ""That's good, babe!"%"
				(= seconds (Print650 111))
			)
			(5
				(Format @string 650 4) ; "Hmmm. Maybe I should compile and test this.%"
				(= seconds (Print650 200))
			)
			(6
				(Format @string 650 5) ; "Let's see if my little Larry can go inside...%"
				(aMonitor hide:)
				(= seconds (Print650 200))
			)
			(7
				(aMonitor show: setLoop: 5 setCycle: Fwd)
				(aDoor posn: 64 99)
				(gEgo posn: 64 103)
				(= seconds 6)
			)
			(8
				(gEgo setMotion: MoveTo 64 100 self)
			)
			(9
				(aDoor setCycle: End self)
			)
			(10
				(gEgo posn: 999 999)
				(= seconds 3)
			)
			(11
				(aDoor setCycle: Beg self)
			)
			(12
				(= seconds 6)
			)
			(13
				(aMonitor hide:)
				(aDoor posn: 234 345)
				(gEgo posn: 999 999)
				(= seconds 3)
			)
			(14
				(aMonitor show: loop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(15
				(if seenMsg
					(= seconds 7)
					(= state 6)
				else
					(aTheEnd init: setCycle: End self)
				)
			)
			(16
				(aTheEnd setLoop: 1 cycleSpeed: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(17
				(= seenMsg 1)
				(Format @string 650 6) ; "Congratulations! You did it! You've won!!%"
				(= seconds (Print650 200))
			)
			(18
				(Format @string 650 7) ; "We hope you've enjoyed "Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals!" You, Larry and Patti have certainly been through a lot together!%"
				(= seconds (Print650 200))
			)
			(19
				(if
					(and
						(TestFlag 11)
						(TestFlag 56)
						(TestFlag 52)
						(TestFlag 43)
						(not (TestFlag 77))
						(not (TestFlag 70))
						(TestFlag 45)
					)
					(Format @string 650 8) ; "You did an excellect job! What a score!!%"
				else
					(Format @string 650 9) ; "You did a great job, but you did miss a little something. For instance...%"
				)
				(= seconds (Print650 200))
			)
			(20
				(if (not (TestFlag 77))
					(self cue:)
				else
					(Format @string 650 10) ; "You shouldn't have short-changed yourself while straddling that log!%"
					(= seconds (Print650 200))
				)
			)
			(21
				(if (TestFlag 43)
					(self cue:)
				else
					(Format @string 650 11) ; "You know, you could find some of your missing points back at "The Comedy Hut."%"
					(= seconds (Print650 200))
				)
			)
			(22
				(if (TestFlag 70)
					(Format @string 650 12) ; "What a shame you didn't "sleuth" more when you had your divorce.%"
					(= seconds (Print650 200))
				else
					(self cue:)
				)
			)
			(23
				(if (TestFlag 11)
					(self cue:)
				else
					(Format @string 650 13) ; "Isn't it surprising that you spent so much time at a tropical resort and never took time out to improve your tan?%"
					(= seconds (Print650 200))
				)
			)
			(24
				(if (not (TestFlag 56))
					(Format @string 650 14) ; "You wonder now why you ignored Chip 'n' Dale's on your way to the bamboo forest.%"
					(= seconds (Print650 200))
				else
					(self cue:)
				)
			)
			(25
				(if (TestFlag 52)
					(self cue:)
				else
					(Format @string 650 15) ; "Do you remember when you were at Fat City? Someone was waiting for you, but you missed her!%"
					(= seconds (Print650 200))
				)
			)
			(26
				(if (TestFlag 45)
					(self cue:)
				else
					(Format @string 650 16) ; "You probably don't know it, but a lot of the points that are missing above got lost when you didn't completely explore the island in your showgirl costume.%"
					(= seconds (Print650 200))
				)
			)
			(27
				(= state 6)
			)
		)
	)
)

(instance atpKeyboard of PV
	(properties
		y 189
		x 60
		view 650
		priority 14
	)
)

(instance atpGlass of PV
	(properties
		y 158
		x 221
		view 650
		cel 1
		priority 15
		signal 16384
	)
)

(instance atpBigGlass of PV
	(properties
		y 173
		x 192
		view 650
		cel 2
		priority 15
		signal 16384
	)
)

(instance aRightHand of Prop
	(properties
		y 173
		x 103
		view 650
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd ignoreActors:)
	)

	(method (doit &tmp i)
		(super doit:)
		(cond
			((== (= i (Random 0 33)) 1)
				(self posn: 100 178)
			)
			((== i 2)
				(self posn: 101 184)
			)
			((== i 3)
				(self posn: 34 180)
			)
			((== i 4)
				(self posn: 36 184)
			)
			((< i 17)
				(self cel: 0)
			)
			(else
				(self cel: 1)
			)
		)
	)
)

(instance aLeftHand of Prop
	(properties
		y 173
		x 17
		view 650
		loop 2
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 setCycle: Fwd ignoreActors:)
	)

	(method (doit &tmp i)
		(super doit:)
		(cond
			((== (= i (Random 0 33)) 1)
				(self posn: 11 173)
			)
			((== i 2)
				(self posn: 18 180)
			)
			((== i 3)
				(self posn: 8 185)
			)
			((< i 17)
				(self cel: 0)
			)
			(else
				(self cel: 1)
			)
		)
	)
)

(instance aMonitor of Prop
	(properties
		y 104
		x 61
		view 650
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 4 setCycle: Fwd ignoreActors:)
	)

	(method (doit)
		(super doit:)
		(if (== loop 3)
			(switch (Random 0 7)
				(1
					(self setCycle: Fwd)
				)
				(2
					(self setCycle: Rev)
				)
				(3
					(self cycleSpeed: (Random 0 1))
				)
			)
		)
	)
)

(instance aLeg of Prop
	(properties
		y 189
		x 306
		view 650
		loop 4
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doit)
		(super doit:)
		(switch (Random 0 7)
			(0
				(self setCycle: Fwd)
			)
			(7
				(self setCel:)
			)
		)
	)
)

(instance aDoor of Prop
	(properties
		y 990
		x 640
		view 650
		loop 7
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 7 ignoreActors:)
	)
)

(instance aTheEnd of Prop
	(properties
		y 47
		x 96
	)

	(method (init)
		(= view (LangSwitch 651 914))
		(super init:)
	)
)

