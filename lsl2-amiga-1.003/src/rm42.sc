;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm42 0
)

(instance rm42 of Rm
	(properties
		picture 42
		horizon 5
		east 47
		south 40
		west 41
	)

	(method (init)
		(Load rsVIEW 407)
		(super init:)
		(gAddToPics add: aUmbrella1 aUmbrella2 aUmbrella3 doit:)
		(self setRegions: 401 setScript: rm42Script) ; rm401
		(if (or (== gPrevRoomNum 138) (== gPrevRoomNum 10))
			(Load rsVIEW 144)
			(Load rsVIEW 408)
			(Load rsVIEW 409)
			(gEgo
				view: 144
				setLoop: 0
				illegalBits: 0
				ignoreActors:
				cycleSpeed: 1
				moveSpeed: 1
				setStep: 1 1
				posn: -8 54
				setCycle: Fwd
				init:
				put: 5 -1 ; Swimsuit
				put: 9 -1 ; Sunscreen
				put: 14 -1 ; Wig
				put: 12 -1 ; Sewing_Kit
				put: 11 -1 ; Fruit
			)
			(aCreep illegalBits: 0 setCycle: Walk init:)
			(HandsOff)
			(rm42Script changeState: 1)
			(= gCurrentStatus 21)
			(gCurRoom west: 0)
		else
			(aSport
				illegalBits: 0
				setCycle: Fwd
				hide:
				setScript: sportsScript
				init:
			)
			(if (or (== gPrevRoomNum 0) (== gPrevRoomNum 40))
				(gEgo posn: 155 185)
			)
			(NormalEgo)
			(gEgo init:)
		)
	)
)

(instance rm42Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/umbrella')
				(Print 42 0) ; "It looks as though they are all unoccupied."
			)
			(if (Said '[/airport,palm,bush]')
				(Print 42 1) ; "You are on the beach of a beautiful resort hotel, a tropical paradise for the rich and famous. In the distance you see people enjoying water sports of all kinds."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo setMotion: MoveTo 3 61 self)
			)
			(2
				(Print 42 2) ; "Hey, Larry! That's you out there in the surf!"
				(Print 42 3) ; ""LAND HO!!" you cry."
				(= seconds 3)
			)
			(3
				(gEgo setMotion: MoveTo 70 95 self)
			)
			(4
				(gEgo
					cycleSpeed: 2
					setLoop: 1
					cel: 0
					posn: 72 96
					setStep: 3 2
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 2 posn: 84 111 cel: 0 setCycle: End self)
			)
			(6
				(gEgo
					cycleSpeed: 1
					setLoop: 3
					posn: 92 124
					cel: 0
					setCycle: End self
				)
			)
			(7
				(= seconds 5)
			)
			(8
				(aCreep setMotion: MoveTo 84 150 self)
				(= cycles 15)
			)
			(9
				(Print 42 4) ; "Oh, good; here comes someone to help you."
			)
			(10
				(aCreep view: 409 cel: 0 setCycle: Fwd)
				(= cycles 18)
			)
			(11
				(aCreep view: 408 setCycle: Walk setMotion: MoveTo 333 120 self)
				(= cycles 25)
			)
			(12
				(if (> gFilthLevel 10)
					(Print 42 5 #at -1 130) ; "(Asshole!)"
				)
			)
			(13
				(aCreep hide:)
				(Print 42 6 #at -1 15 #width 280 #draw) ; "Congratulations, Larry! You have survived weeks adrift on the high seas with nothing but your courage, perseverance and a few humble provisions; endured tropical storms, vicious winds and high seas in just a tiny lifeboat; prevailed over the surf, off-shore barrier reef, and razor-sharp coral; escaped the dangerous Mother; avoided the vicious KGB and the tempting enticements of the evil Dr. Nonookee's henchette hordes, and withstood that creep's audacious humor..."
				(gEgo
					cycleSpeed: 1
					setLoop: 4
					cel: 0
					posn: 101 150
					setCycle: End self
				)
			)
			(14
				(Print 42 7 #at -1 20 #draw) ; "...and you're still as good as new!"
				(Print 42 8 #at -1 130) ; "(But boy, is your suit a mess!!)"
				(= seconds 3)
			)
			(15
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
			)
			(16
				(= seconds 3)
			)
			(17
				(Print 42 9 #at -1 130) ; "(Don't you just love a good polyester?)"
				(= seconds 3)
			)
			(18
				(Print 42 10) ; "But now you wonder, "Where am I?""
				(Print 42 11) ; "And what possessions survived your disastrous journey?"
				(NormalEgo 2)
				(rm42 west: 41)
			)
		)
	)
)

(instance sportsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (!= gPrevRoomNum 138)
					(= seconds (Random 3 5))
				)
			)
			(1
				(aSport
					setLoop: 0
					cel: 0
					posn: -30 49
					setStep: 5 2
					cycleSpeed: 3
					show:
					setMotion: MoveTo 360 50 self
				)
			)
			(2
				(aSport hide:)
				(= seconds (Random 2 5))
			)
			(3
				(aSport
					setLoop: 1
					posn: -24 107
					setStep: 3 1
					cycleSpeed: 4
					show:
					setMotion: MoveTo 343 64 self
				)
			)
			(4
				(aSport hide:)
				(= seconds (Random 2 5))
			)
			(5
				(aSport
					setLoop: 2
					posn: -29 57
					setStep: 1 1
					cycleSpeed: 0
					moveSpeed: 1
					show:
					setMotion: MoveTo 337 58 self
				)
			)
			(6
				(aSport hide:)
				(= seconds (Random 2 5))
			)
			(7
				(aSport
					setLoop: 3
					posn: -10 47
					setStep: 3 1
					cycleSpeed: 4
					moveSpeed: 0
					show:
					setMotion: MoveTo 333 48 self
				)
			)
			(8
				(aSport hide:)
				(= seconds (Random 2 5))
			)
			(9
				(aSport
					setLoop: 4
					posn: -35 79
					setStep: 2 1
					cycleSpeed: 1
					show:
					setMotion: MoveTo 334 55 self
				)
			)
			(10
				(aSport hide:)
				(= seconds (Random 2 5))
			)
			(11
				(aSport
					setLoop: 5
					posn: 358 76
					setStep: 3 1
					cycleSpeed: 4
					show:
					setMotion: MoveTo -30 113 self
				)
			)
			(12
				(aSport hide:)
				(= seconds (Random 2 5))
			)
			(13
				(aSport
					setLoop: 6
					posn: -23 73
					setStep: 5 2
					cycleSpeed: 3
					show:
					setMotion: MoveTo 377 48 self
				)
			)
			(14
				(aSport hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance aUmbrella1 of PV
	(properties
		y 172
		x 76
		view 407
		loop 7
		cel 1
		priority 13
		signal 16384
	)
)

(instance aUmbrella2 of PV
	(properties
		y 159
		x 206
		view 407
		loop 7
		priority 12
		signal 16384
	)
)

(instance aUmbrella3 of PV
	(properties
		y 174
		x 294
		view 407
		loop 7
		cel 2
		priority 13
		signal 16384
	)
)

(instance aCreep of Act
	(properties
		y 149
		x -12
		view 408
		signal 16384
	)
)

(instance aSport of Act
	(properties
		y 79
		x -40
		view 407
		priority 1
		signal 16384
	)
)

