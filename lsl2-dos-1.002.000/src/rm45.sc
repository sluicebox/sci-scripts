;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm45 0
)

(local
	work
	aBarber
	aChair
	talkedToBarber
)

(instance rm45 of Rm
	(properties
		picture 125
		south 40
	)

	(method (init)
		(Load rsVIEW gCurrentEgoView)
		(Load rsVIEW 232)
		(Load rsVIEW 430)
		(Load rsVIEW 149)
		(super init:)
		((= aChair (Prop new:))
			view: 232
			loop: 1
			cel: 0
			posn: 167 115
			setPri: 8
			ignoreActors:
			init:
		)
		((= aBarber (Act new:))
			view: 430
			loop: 0
			ignoreActors:
			illegalBits: 0
			posn: 184 91
			init:
		)
		(NormalEgo)
		(gEgo posn: 160 159 init:)
		(self setRegions: 7 400 setScript: rm45Script) ; rm7, rm400
	)
)

(instance rm45Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 40)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if
			(or
				(Said 'bath,fix,yes,cut')
				(Said 'drain/hair')
				(Said '(get<in)/barstool')
				(Said 'get/haircut,(cut<hair)')
			)
			(= talkedToBarber 1)
			(cond
				((not (gEgo inRect: 148 117 180 127))
					(Print 45 0) ; "Walk over to the front of the barber's chair and sit down."
				)
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				((and gBlondHair gBodyWaxed)
					(Print 45 1) ; "I'm sorry, Meester," says the barber, "I've donna all I canna do to, er, for you. Enjoy your new look!"
				)
				((not gBlondHair)
					(self changeState: 2)
				)
				((and (!= gCurrentEgoView 150) (!= gCurrentEgoView 151))
					(Print 45 2) ; "I'm sorry, Meester," says the barber, "I've gotta no more 'pointments today!"
				)
				(else
					(self changeState: 18)
				)
			)
		)
		(if (Said 'look/man')
			(Print 45 3) ; "Funny. This guy doesn't look Italian!"
		)
		(if (Said 'talk/man')
			(= talkedToBarber 1)
			(if (!= gCurrentEgoView 100)
				(Print 45 4) ; "You looka mucho better to me, buddy!"
			else
				(Print 45 5) ; ""I gotta no time for a ticky-talky," responds the barber."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gCurrentEgoView 151)
					(= seconds 10)
				)
			)
			(1
				(if (not talkedToBarber)
					(Print 45 6) ; "Goodda daya, Meester," says the barber. "Canna I helpa you?"
					(= seconds (Random 12 25))
					(= state 0)
				)
			)
			(2
				(= seconds (= cycles 0))
				(= gCurrentStatus 1009)
				(HandsOff)
				(Print 45 7) ; ""Is there anything you can do for my receding hairline?" you ask the barber."
				(Print 45 8) ; "Butta course, Mister," says the barber, "I gotta jus' ah whacha need."
				(Print 45 9) ; "Jus' havva seat inna da chair, please."
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 157 120 self
				)
				(aBarber setCycle: End)
			)
			(3
				(aChair hide:)
				(gEgo
					view: 232
					setLoop: 2
					cel: 0
					posn: 167 115
					setCycle: End self
				)
			)
			(4
				(aBarber setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gEgo hide:)
				(aBarber
					view: 430
					setLoop: 2
					cel: 0
					posn: 167 115
					setCycle: End self
				)
			)
			(6
				(Print 45 10 #at -1 20 #draw) ; "Fora youa today, I gotta special deal," he begins. "Imma gonna try somma my oxydol."
				(Print 45 11 #at -1 20) ; ""Don't you mean 'Minoxidol?'" you ask."
				(Print 45 12 #at -1 20) ; "No," he says, "I dunno whata dat is; Imma gonna rubba you head with somma dis liquid laundry detergent!"
				(Print 45 13 #at -1 152) ; "(Too late to leave now, Larry. He's got you!)"
				(= seconds 3)
			)
			(7
				(aBarber
					setLoop: 4
					cel: 0
					posn: 165 85
					cycleSpeed: 1
					setPri: 9
					setCycle: End self
				)
				(aChair view: 430 setLoop: 3 cel: 0 show:)
			)
			(8
				(aBarber setLoop: 5 cel: 0 cycleSpeed: 2 setCycle: CT 4 1 self)
			)
			(9
				(Print 45 14 #at -1 20 #draw) ; "Dere, alla set," says the barber, "now let'sa justa give it a second ta work."
				(Print 45 15 #at -1 20) ; "How ridiculous," you think, "I just let some guy I don't even know pour laundry detergent on my head!"
				(= seconds 3)
			)
			(10
				(aBarber setCycle: End self)
			)
			(11
				(Print 45 16 #at -1 20 #draw) ; "WOW!" you exclaim, "Not only does that stuff really work... it's fast, too!"
				(Print 45 17 #at -1 20) ; "I knew you'da be delighted," responds the barber, "comma back anda see me any time, Blondie!"
				(Print 45 18 #at -1 20) ; ""Why do you call me that?" you ask."
				(Print 45 19 #at -1 20) ; ""Oh, no reason," he says."
				(= seconds 3)
			)
			(12
				(aBarber setLoop: 6 cel: 0 setCycle: End self)
			)
			(13
				(= seconds 3)
			)
			(14
				(Print 45 20 #at -1 20) ; "Oh, great!" you cry, "now what am I supposed to do?"
				(Print 45 21 #at -1 20) ; ""Hava more fun," he answers."
				(= seconds 3)
			)
			(15
				(aBarber setLoop: 1 setCel: 0 setPri: -1 posn: 167 91)
				(aChair setLoop: 7 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(16
				(= gBlondHair 1)
				(gGame changeScore: 3)
				(aChair view: 232 setLoop: 1 setCel: 0)
				(= gCurrentEgoView 149)
				(NormalEgo 3)
				(gEgo posn: 157 119 show:)
				(Print 45 22 #draw) ; ""Well, at least my bald spot is gone," you say."
				(= cycles 5)
			)
			(17
				(Print (Format @gString 45 23 gTritePhrase)) ; "Along with your self-respect," says the barber. "%s"
				(aBarber stopUpd:)
				(aChair stopUpd:)
			)
			(18
				(= seconds (= cycles 0))
				(User canControl: 0 canInput: 0)
				(Print 45 24) ; ""Is there anything you can do about my excess body hair?" you ask the barber."
				(Print 45 25) ; "Butta course, Meester," says the barber, "I gotta jus' whacha need."
				(Print 45 26) ; "Justa hava seat inna da chair, please."
				(= gCurrentEgoView (gEgo view:))
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 157 120 self
				)
				(aBarber illegalBits: 0 setCycle: End)
			)
			(19
				(aChair hide:)
				(gEgo
					view: 431
					setLoop: 0
					cel: 7
					posn: 167 115
					setCycle: Beg self
				)
			)
			(20
				(aBarber setLoop: 1 cel: 0 setCycle: End self)
			)
			(21
				(gEgo hide:)
				(aBarber
					view: 431
					setLoop: 1
					cel: 0
					posn: 167 115
					setCycle: End self
				)
			)
			(22
				(Print 45 27 #at -1 20 #draw) ; ""Fora youa, today onaly, I gotta special deal," he begins."
				(Print 45 28 #at -1 20) ; ""Somehow I wonder," you reply."
				(Print 45 29 #at -1 20) ; "No," he says, "this'll worka reala good."
				(Print 45 30 #at -1 20) ; "What are you going to do to me this time?"
				(Print 45 31 #at -1 20) ; "BODY WAXING!"
				(Print 45 32 #at -1 152) ; "(Once again, he's got you trapped in the chair. You hope this time will turn out better!)"
				(= seconds 3)
			)
			(23
				(aBarber setLoop: 2 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(24
				(= seconds 3)
			)
			(25
				(aBarber setLoop: 3 cel: 0 posn: 165 81 setCycle: CT 1 1 self)
				(aChair view: 431 setLoop: 7 cel: 0 posn: 167 115 show:)
			)
			(26
				(= seconds 3)
			)
			(27
				(aBarber setCycle: End self)
			)
			(28
				(= seconds 3)
			)
			(29
				(Print 45 33 #at -1 20) ; "Dere, alla set," says the barber, "now justa lay dere and let it geta hard."
				(Print 45 34 #at -1 20) ; "How could I be so stupid," you think, "I have wax hardening all over my naked body!"
				(= seconds 3)
			)
			(30
				(aBarber setLoop: 4 cel: 0 setCycle: End self)
			)
			(31
				(Print 45 35 #at -1 152 #draw) ; "Yeeeeee yoooowwwwww!"
				(aBarber setLoop: 5 cel: 0 setCycle: End)
				(gEgo
					view: 431
					posn: 157 94
					setLoop: 6
					setCycle: Fwd
					setStep: 1 10
					setPri: 9
					setMotion: MoveTo 157 57 self
					show:
				)
			)
			(32
				(= seconds 4)
			)
			(33
				(gEgo setCel: 0)
				(= seconds 3)
			)
			(34
				(gEgo setMotion: MoveTo 157 94 self)
			)
			(35
				(gEgo hide:)
				(aChair hide:)
				(aBarber view: 431 setLoop: 2 setCel: 5 posn: 167 115)
				(= seconds 3)
			)
			(36
				(Print 45 36 #at -1 20) ; "Oh, gawd!" you cry, "was it good for you?"
				(Print 45 37 #at -1 20) ; ""I donna think that could be good for anybody!" he answers."
				(= seconds 3)
			)
			(37
				(aBarber setCycle: Beg self)
			)
			(38
				(aBarber view: 430 setLoop: 1 setCel: 0 setPri: -1 posn: 167 91)
				(aChair view: 431 setLoop: 0 cel: 0 setCycle: End self show:)
			)
			(39
				(= gBodyWaxed 1)
				(gGame changeScore: 3)
				(aChair view: 232 setLoop: 1 setCel: 0)
				(NormalEgo 3)
				(gEgo posn: 157 119 show:)
				(Print 45 38 #draw) ; ""Well, perhaps the pain was worth it; I DO like this 'clean-shaven' look!" you tell him."
				(= seconds 2)
			)
			(40
				(Print (Format @gString 45 39 gTritePhrase)) ; "You're the only one," concludes the barber. "%s"
			)
		)
	)
)

