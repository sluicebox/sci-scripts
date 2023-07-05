;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm125 0
)

(local
	aBarber
	aChair
	aThoughtBalloon
	aThought
	aHeads
	aHandle
	cycSpeed
	thoughtView
	talkedToBarber
)

(instance rm125 of Rm
	(properties
		picture 125
		horizon 5
		south 25
	)

	(method (init)
		(Load rsVIEW 233)
		(Load rsVIEW 232)
		(Load rsVIEW 244)
		(Load rsVIEW 246)
		(if (> gFilthLevel 4)
			(= thoughtView 245)
		else
			(= thoughtView 248)
		)
		(Load rsVIEW thoughtView)
		(super init:)
		(cond
			((> gMachineSpeed 60)
				(= cycSpeed 3)
			)
			((> gMachineSpeed 40)
				(= cycSpeed 2)
			)
			((> gMachineSpeed 20)
				(= cycSpeed 1)
			)
		)
		((= aThoughtBalloon (Prop new:))
			view: thoughtView
			ignoreActors:
			posn: 160 1128
			setPri: 14
			init:
		)
		((= aThought (Prop new:))
			view: thoughtView
			ignoreActors:
			posn: 161 1120
			setPri: 15
			init:
		)
		((= aHandle (View new:))
			view: 246
			setCel: 1
			setPri: 14
			ignoreActors:
			posn: 160 1129
			init:
		)
		((= aHeads (Prop new:)) view: 244 ignoreActors: init: hide:)
		((= aChair (View new:))
			view: 232
			loop: 1
			cel: 0
			posn: 164 119
			setPri: 8
			ignoreActors:
			stopUpd:
			init:
		)
		((= aBarber (Act new:))
			view: 233
			loop: 2
			posn: 113 153
			setCycle: Walk
			illegalBits: -32768
			init:
		)
		(NormalEgo 3)
		(gEgo posn: 160 160 init:)
		(self setRegions: 7 200 setScript: rm125Script) ; rm7, rm200
	)
)

(instance rm125Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 25)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if
			(or
				(Said 'bath,fix,yes,cut')
				(Said '(get<in)/barstool')
				(Said 'get/haircut,(cut<hair)')
			)
			(= talkedToBarber 1)
			(cond
				((not (gEgo inRect: 148 117 180 127))
					(Print 125 0) ; "Walk over to the front of the barber's chair and sit down."
				)
				((gEgo has: 4) ; Million_Dollar_Bill
					(Print 125 1) ; ""Do you have change for a million-dollar bill?" you ask the barber."
					(Print 125 2) ; "Get lost," replies the barber, "I don't appreciate practical jokes."
				)
				((not (gEgo has: 6)) ; Wad_O__Dough
					(Print 125 3) ; "You'd like to get a haircut, but you just don't have enough money!"
				)
				(gLAhaircut
					(Print 125 4) ; "I'm sorry, monsieur," says the barber rudely, "I have no more appointments left today!"
					(Print 125 5) ; "In fact, I'd appreciate it if you'd leave now before I have to call the Hair Police!"
				)
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				(else
					(= gLAhaircut 1)
					(self changeState: 2)
				)
			)
		)
		(if (Said 'talk/man')
			(= talkedToBarber 1)
			(if (== gLAhaircut 1)
				(Print 125 6) ; "You look much better to me, monsieur!"
			else
				(Print 125 7) ; "I have no time for idle conversation," responds the barber. "It's bad enough I have to talk to customers while I cut their hair, I certainly don't want to talk when I'm NOT cutting hair!"
				(Print 125 8) ; "If you want me to work on that problem head of yours, you'd better sit down in the chair."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not gLAhaircut)
					(= seconds 10)
				)
			)
			(1
				(if (not talkedToBarber)
					(Print 125 9) ; "Good day, monsieur," says the barber. "May I help you?"
					(= seconds (Random 12 25))
					(= state 0)
				)
			)
			(2
				(= seconds (= cycles 0))
				(= gCurrentStatus 1009)
				(HandsOff)
				(Print 125 10) ; ""How about a quick styling?" you ask."
				(Print 125 11) ; "Oui, monsieur, but of course," replies the barber, "allow me to correct that receding hairline of yours with my patented, special, proprietary technique... macrobiotic styling reweaving!"
				(Print 125 12) ; "Just have a seat in the chair, please."
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 157 120 self
				)
				(aBarber setMotion: MoveTo 185 119 self)
			)
			(3
				(aChair hide:)
				(gEgo
					view: 232
					setLoop: 2
					cel: 0
					posn: 167 116
					setCycle: End
				)
			)
			(4
				(aBarber setMotion: MoveTo 179 111 self)
			)
			(5
				(aBarber setMotion: MoveTo 166 111 self illegalBits: 0)
			)
			(6
				(Print 125 13) ; "Here," says the barber, "take a look in this mirror and remember what you look like. When I'm done, you won't be able to recognize your own hairline! Why, you'll be a different man!"
				(aThoughtBalloon view: 246 setCel: 0 posn: 160 128 setPri: 14 stopUpd:)
				(aHandle posn: 160 129 stopUpd:)
				(aThought
					view: 246
					setLoop: 1
					cel: 0
					posn: 161 120
					setPri: 15
					setCycle: Fwd
					cycleSpeed: (* 2 cycSpeed)
				)
				(= seconds 6)
			)
			(7
				(Print 125 14 #at -1 15 #width 280) ; "You think to yourself, "Yeah, this is exactly what I need... a new look. I'll make Bachelorette Barbie change her tune!""
				(= seconds 3)
			)
			(8
				(aThought posn: 161 1120)
				(aHandle posn: 160 1129)
				(aThoughtBalloon posn: 160 1128)
				(Print 125 15 #at -1 20 #draw) ; ""Ok, go for it!" you tell the barber."
				(= seconds 3)
			)
			(9
				(gEgo hide:)
				(aBarber view: 244 setLoop: 0 posn: 167 116 setCel: 0)
				(= cycles 30)
			)
			(10
				(aBarber cycleSpeed: 1 setCycle: End self)
			)
			(11
				(Print 125 16 #draw) ; "Allow me to begin with a thorough cleansing to rid your hair and scalp of any possible pollutants," says the barber. "I assure you, I use only the trendiest products, all organically grown and available only in undersized, overpriced, biodegradable bottles!"
				(aBarber setLoop: 1 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(12
				(aHeads
					posn: 166 101
					setLoop: 2
					cel: 0
					setPri: 9
					cycleSpeed: 2
					show:
					setCycle: Fwd
				)
				(aBarber stopUpd:)
				(= seconds 5)
			)
			(13
				(Print 125 17) ; "You wonder to yourself, "What will I look like when he's done?""
				(Print 125 18) ; "Will I be handsome?"
				(Print 125 19) ; "Will I ever find true love?"
				(= seconds 5)
			)
			(14
				(aThoughtBalloon
					view: thoughtView
					setLoop: 0
					cel: 0
					setPri: 14
					posn: 154 92
					cycleSpeed: cycSpeed
					setCycle: End self
				)
			)
			(15
				(aThoughtBalloon stopUpd:)
				(aThought
					view: thoughtView
					setLoop: 2
					setPri: 15
					setCel: 0
					posn: 110 46
					cycleSpeed: cycSpeed
					setCycle: End self
				)
			)
			(16
				(aThought setCycle: Beg self)
			)
			(17
				(aThought setCycle: End self)
			)
			(18
				(aThought setCycle: Beg self)
			)
			(19
				(aThought setCycle: End self)
			)
			(20
				(aThought setCycle: Beg self)
			)
			(21
				(aThought posn: 161 1120)
				(= seconds 5)
			)
			(22
				(aThought
					setLoop: 1
					posn: 112 41
					cel: 0
					setPri: 15
					setCycle: End self
				)
			)
			(23
				(aThought posn: 161 1120)
				(= seconds 3)
			)
			(24
				(Print 125 20) ; ""You certainly have interesting daydreams!" says the barber."
				(= seconds 3)
			)
			(25
				(aThought
					setLoop: 3
					cel: 0
					posn: 103 42
					cycleSpeed: cycSpeed
					setCycle: CT 10 1 self
				)
			)
			(26
				(Print 125 21 #draw) ; "Hey, Brutus! Get outta here!!"
				(= cycles 8)
			)
			(27
				(aThought setCycle: End self)
			)
			(28
				(aThought posn: 161 1120)
				(aThoughtBalloon posn: 160 1128)
				(= seconds 6)
			)
			(29
				(aHeads hide:)
				(aBarber setLoop: 3 cel: 0 cycleSpeed: cycSpeed setCycle: End self)
				(Print 125 22 #draw) ; "Your hair is clean and conditioned," says the barber, "now for the special styling."
				(Print 125 23) ; "However, in the future, may I recommend 10w40 and no more than 3,000 miles between oil changes!"
			)
			(30
				(aHeads
					posn: 166 95
					setLoop: 4
					cel: 0
					setPri: 14
					setCycle: Fwd
					show:
				)
				(aBarber stopUpd:)
				(= seconds 11)
			)
			(31
				(aHeads dispose:)
				(Print 125 24 #draw) ; "All done," says the barber. "Take a look in this mirror... what do you think?"
				(= seconds 3)
			)
			(32
				(aThoughtBalloon view: 246 setCel: 0 posn: 160 128 setPri: 14 stopUpd:)
				(aHandle posn: 160 129 stopUpd:)
				(aThought
					view: 246
					setLoop: 1
					cel: 0
					setPri: 15
					posn: 161 120
					setCycle: Fwd
					cycleSpeed: cycSpeed
				)
				(= seconds 6)
			)
			(33
				(Print 125 25 #at -1 20 #draw) ; "Oh, well. You can't judge a book by its cover!"
				(= seconds 3)
			)
			(34
				(aThought dispose:)
				(aHandle dispose:)
				(aThoughtBalloon dispose:)
				(Print 125 26 #at -1 20 #draw) ; ""That'll be fine," you tell the barber."
				(= seconds 3)
			)
			(35
				(Print 125 27) ; "Say," you ask him, "exactly how could I know I was getting a macrobiotic styling?"
				(= seconds 3)
			)
			(36
				(Print 125 28) ; "By the price!"
				(= seconds 2)
			)
			(37
				(aBarber setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(38
				(aBarber setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(39
				(aBarber
					view: 233
					posn: 182 115
					loop: 2
					setCycle: Walk
					illegalBits: -32768
				)
				(gEgo
					view: 232
					setLoop: 2
					setCel: 255
					posn: 167 116
					setCycle: Beg self
					show:
				)
			)
			(40
				(NormalEgo 2)
				(gEgo ignoreActors: 0)
				(aChair show:)
				(gGame changeScore: 3)
				(= seconds 2)
			)
			(41
				(Print 125 29) ; ""That'll be a hundred bucks," says the barber."
				(Print 125 30) ; ""Thanks, I guess," you say, flipping the barber one of your C-notes."
				(Print (Format @gString 125 31 gTritePhrase)) ; "The barber replies, "%s""
			)
		)
	)
)

