;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm430 0
)

(local
	aHoist
	aTrapdoor
	aCherri
	[aMoney 6]
	[aDancer 6]
	[dancerPosn 14] = [0 0 54 74 41 78 26 83 11 88 -4 93 0 0]
)

(instance rm430 of Rm
	(properties
		picture 430
		horizon 1
	)

	(method (init &tmp i)
		(= gShowroomState 1)
		(= gOldEgoState gEgoState)
		(= gEgoState gCurRoomNum)
		(HandsOff)
		(Load rsVIEW 432)
		(Load rsSOUND 431)
		(Load rsSOUND 13)
		(Load rsSOUND 10)
		(Load rsSCRIPT 991)
		(Load rsPIC 431)
		(gMusic number: 430 loop: -1 play:)
		(super init:)
		(aCurtain ignoreActors: init:)
		(aActor1 ignoreActors: init:)
		(aActor2 ignoreActors: init:)
		(aActor3 ignoreActors: init:)
		(aActor4 ignoreActors: init:)
		(aActor5 ignoreActors: init:)
		(= gOldGameSpeed (gGame setSpeed: 6))
		(= [aDancer 1] aActor1)
		(= [aDancer 2] aActor2)
		(= [aDancer 3] aActor3)
		(= [aDancer 4] aActor4)
		(= [aDancer 5] aActor5)
		(aMoney1 ignoreActors: init:)
		(aMoney2 ignoreActors: init:)
		(aMoney3 ignoreActors: init:)
		(aMoney4 ignoreActors: init:)
		(aMoney5 ignoreActors: init:)
		(= [aMoney 1] aMoney1)
		(= [aMoney 2] aMoney2)
		(= [aMoney 3] aMoney3)
		(= [aMoney 4] aMoney4)
		(= [aMoney 5] aMoney5)
		(= aTrapdoor aActor3)
		(= aHoist aActor4)
		(= aCherri aActor5)
		(gEgo posn: 999 999 init: hide:)
		(for ((= i 1)) (<= i 5) ((++ i))
			([aDancer i]
				view: 433
				posn: [dancerPosn (* i 2)] [dancerPosn (+ 1 (* i 2))]
				setPri: 3
				setStep: 1 1
			)
		)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState &tmp i)
		(ShowState self newState 1 12)
		(switch (= state newState)
			(0
				([aDancer 1] setCycle: End self)
			)
			(1
				([aDancer 1] cel: 0 setCycle: End)
				([aDancer 2] setCycle: End self)
			)
			(2
				([aDancer 1] cel: 0 setCycle: End)
				([aDancer 2] cel: 0 setCycle: End)
				([aDancer 3] setCycle: End self)
			)
			(3
				([aDancer 1] cel: 0)
				([aDancer 2] cel: 0 setCycle: End)
				([aDancer 3] cel: 0 setCycle: End)
				([aDancer 4] setCycle: End self)
			)
			(4
				(Print 430 0 #at 10 144 #width 290 #dispose) ; "You quickly make your way through a crowd of men and take one of the few remaining seats near the rear of the showroom."
				([aDancer 2] cel: 0)
				([aDancer 3] cel: 0 setCycle: End)
				([aDancer 4] cel: 0 setCycle: End)
				([aDancer 5] setCycle: End self)
			)
			(5
				([aDancer 3] cel: 0)
				([aDancer 4] cel: 0 setCycle: End)
				([aDancer 5] cel: 0 setCycle: End self)
			)
			(6
				([aDancer 4] cel: 0)
				([aDancer 5] setCycle: End self)
			)
			(7
				([aDancer 5] cel: 0 setCycle: End self)
			)
			(8
				([aDancer 4] cel: 0 setCycle: End self)
			)
			(9
				([aDancer 3] cel: 0 setCycle: End self)
			)
			(10
				([aDancer 2] cel: 0 setCycle: End self)
			)
			(11
				([aDancer 1] cel: 0 setCycle: End self)
			)
			(12
				([aDancer 2] setCycle: End self)
			)
			(13
				([aDancer 3] setCycle: End self)
			)
			(14
				([aDancer 4] setCycle: End self)
			)
			(15
				([aDancer 5] setCycle: End self)
			)
			(16
				([aDancer 4] setCycle: End self)
			)
			(17
				([aDancer 3] setCycle: End self)
			)
			(18
				([aDancer 2] setCycle: End self)
			)
			(19
				(cls)
				([aDancer 1] setCycle: End self)
			)
			(20
				([aDancer 1] setCycle: End self)
				([aDancer 2] setCycle: Fwd)
			)
			(21
				([aDancer 1] setCycle: End self)
				([aDancer 3] setCycle: Fwd)
			)
			(22
				([aDancer 1] setCycle: End self)
				([aDancer 4] setCycle: Fwd)
			)
			(23
				([aDancer 1] setCycle: Fwd)
				([aDancer 5] setCycle: Fwd)
				(= cycles 55)
			)
			(24
				(for ((= i 1)) (<= i 5) ((++ i))
					([aDancer i] setMotion: MoveTo 119 52)
				)
				(= cycles 66)
			)
			(25
				(gMusic fade:)
				(= cycles 66)
			)
			(26
				(gMusic number: 10 loop: -1 play:)
				(Print 430 1 #at 10 5 #width 290) ; "The announcer's voice booms over the public address system, "And now, lady and gentlemen, the moment you've all been waiting for: the star of our show, Miss Cherri Tart!""
				([aDancer 1] dispose:)
				([aDancer 2] dispose:)
				(aTrapdoor view: 430 setLoop: 3 posn: 167 97 setPri: 2 hide:)
				(aHoist view: 430 setLoop: 4 posn: 148 163 setPri: 3 hide:)
				(aCherri
					view: 432
					setLoop: 0
					setCel: 0
					posn: 149 140
					setPri: 4
					hide:
				)
				(= cycles 22)
			)
			(27
				(gCurRoom drawPic: 431 8)
				(aSpotlight
					loop: 1
					setCel: 1
					posn: 160 45
					setPri: 1
					ignoreActors:
					init:
					stopUpd:
				)
				(aFloor
					loop: 2
					setCel: 1
					posn: 152 102
					setPri: 6
					ignoreActors:
					init:
					stopUpd:
				)
				(aHoist show:)
				(aCherri show:)
				(= cycles 11)
			)
			(28
				(aTrapdoor show: setMotion: MoveTo 149 97 self)
			)
			(29
				(aTrapdoor stopUpd:)
				(aCherri setMotion: MoveTo 149 86)
				(aHoist setMotion: MoveTo 148 109 self)
			)
			(30
				(aHoist stopUpd:)
				(gMusic number: 431 loop: -1 play:)
				(aCherri setLoop: 3 setCycle: Fwd)
				(= cycles 33)
			)
			(31
				(aCherri setLoop: 4)
				(= cycles 33)
			)
			(32
				(aCherri cel: 0 setCycle: End self)
			)
			(33
				(aCherri setLoop: 1 setCycle: Fwd)
				(Print 430 2 #at 10 144 #width 290 #dispose) ; "Evidently the men in the audience like Cherri's act, as they begin to toss dollar bills onto the stage."
				(for ((= i 1)) (<= i 5) ((++ i))
					([aMoney i] setScript: (MoneyScript new:))
				)
				(self cue:)
			)
			(34
				(= cycles (* 2 (NumCels aCherri)))
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
					(-- state)
				)
			)
			(35
				(cls)
				(aCherri setCycle: Fwd)
				(= cycles (+ 7 (* gMachineSpeed 2)))
			)
			(36
				(if (< gMachineSpeed 39)
					(self cue:)
				else
					(aSpotlight setCycle: Fwd)
					(aFloor setCycle: Fwd)
					(= cycles (+ 7 (* gMachineSpeed 2)))
				)
			)
			(37
				(aSpotlight setCel: 1 stopUpd:)
				(aFloor setCel: 1 stopUpd:)
				(self cue:)
			)
			(38
				(= cycles (* (+ 1 (> gMachineSpeed 39)) (NumCels aCherri)))
				(if (< gSpeed 6)
					(gGame setSpeed: (++ gSpeed))
					(-- state)
				)
			)
			(39
				(aCherri setLoop: 2 setCycle: End self)
			)
			(40
				(aCherri setCel: 255)
				(gMusic fade:)
				(= seconds 4)
			)
			(41
				(Print 430 3 #at 10 5 #width 290) ; "Isn't she wonderful, lady and gentlemen?!" screams the announcer. "Let's really hear it for our own little Cherri Tart!!"
				(gMusic number: 13 loop: -1 play:)
				(aHoist setMotion: MoveTo 148 163)
				(aCherri setMotion: MoveTo 149 140 self)
				(for ((= i 1)) (<= i 5) ((++ i))
					(([aMoney i] script:) changeState: 2)
				)
			)
			(42
				(gMusic fade:)
				(Print 430 4 #at 10 5 #width 290) ; "That concludes tonight's two-hour spectacle, `Nontoonyt For You!' You must clear the auditorium now, as our second show begins shortly. Good seats are still available, so tell your friends!"
				(aTrapdoor setMotion: MoveTo 167 97 self)
			)
			(43
				(gCurRoom drawPic: 430 8)
				(aTrapdoor dispose:)
				(aSpotlight dispose:)
				(aFloor dispose:)
				(Animate (gCast elements:) 0)
				(Print 430 5 #at 10 5 #width 290) ; "He concludes with a trite, "Good night, and walk safely on your way home.""
				(= seconds 3)
			)
			(44
				(Print 430 6) ; "What a show, eh, Larry?"
				(Print 430 7 #at -1 144) ; "(Too bad you came in so late; you only saw the last minute!)"
				(= seconds 2)
			)
			(45
				(gGame setSpeed: gOldGameSpeed)
				(= gEgoState gOldEgoState)
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance aActor1 of Act
	(properties)
)

(instance aActor2 of Act
	(properties)
)

(instance aActor3 of Act
	(properties)
)

(instance aActor4 of Act
	(properties)
)

(instance aActor5 of Act
	(properties)
)

(instance aSpotlight of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aFloor of Prop
	(properties
		y 999
		x 999
		view 430
	)
)

(instance aCurtain of Prop
	(properties
		y 63
		x 15
		view 430
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 2 ignoreActors: stopUpd:)
	)
)

(instance aMoney1 of Act
	(properties)
)

(instance aMoney2 of Act
	(properties)
)

(instance aMoney3 of Act
	(properties)
)

(instance aMoney4 of Act
	(properties)
)

(instance aMoney5 of Act
	(properties)
)

(instance MoneyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client view: 430 setLoop: 7 setCycle: Fwd setStep: 7 7)
				(= cycles (Random 1 9))
			)
			(1
				(client
					posn: (Random 8 290) (Random 144 157)
					setMotion:
						JumpTo
						(aCherri x:)
						(- (aCherri y:) (Random 0 33))
						self
				)
				(-- state)
			)
			(2
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

