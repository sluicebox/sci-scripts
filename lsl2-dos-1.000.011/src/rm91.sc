;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm91 0
)

(local
	work
	aMouth
	aCar
	aDog
)

(instance theSound of Sound
	(properties
		number 101
		priority 10
		loop -1
	)
)

(instance rm91 of Rm
	(properties
		picture 23
		style 7
	)

	(method (init)
		(Load rsVIEW 192)
		(Load rsVIEW 253)
		(Load rsVIEW 802)
		(Load rsVIEW 803)
		(Load rsVIEW 804)
		(Load rsSOUND 101)
		(super init:)
		(theSound play:)
		((View new:)
			view: 253
			loop: 0
			cel: 0
			posn: 95 131
			setPri: 1
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 253
			loop: 0
			cel: 2
			posn: 136 140
			setPri: 9
			ignoreActors:
			addToPic:
		)
		((View new:) view: 253 loop: 0 cel: 2 posn: 49 139 setPri: 9 addToPic:)
		((View new:) view: 253 loop: 0 cel: 2 posn: 35 144 setPri: 9 addToPic:)
		((View new:)
			view: 253
			loop: 0
			cel: 3
			posn: 149 111
			setPri: 13
			addToPic:
		)
		((View new:) view: 253 loop: 0 cel: 1 posn: 15 136 setPri: 1 addToPic:)
		((= aMouth (Prop new:))
			view: 802
			ignoreActors:
			setLoop: 1
			setCel: 0
			setPri: 15
			posn: 3 1152
			setCycle: Fwd
			init:
		)
		((= aCar (Act new:))
			view: 802
			ignoreActors:
			illegalBits: 0
			setLoop: 0
			setCel: 0
			setPri: 13
			posn: -64 223
			init:
		)
		((= aDog (Act new:))
			view: 803
			ignoreActors:
			illegalBits: 0
			setLoop: 0
			setCel: 0
			setPri: 14
			posn: 31 151
			init:
			hide:
		)
		(gEgo
			view: 192
			ignoreActors:
			illegalBits: 0
			posn: 119 146
			setCel: 0
			setCycle: Walk
			setPri: -1
			setStep: 3 2
			init:
		)
		(self setScript: rm91Script)
	)
)

(instance rm91Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(gGame restart:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 185 146 self)
			)
			(1
				(gEgo loop: 1 posn: 179 148 setMotion: MoveTo 116 148 self)
			)
			(2
				(gEgo loop: 0 posn: 110 152 setMotion: MoveTo 167 152 self)
			)
			(3
				(gEgo setLoop: 1 posn: 155 156 setCel: 0 stopUpd:)
				(aCar setMotion: MoveTo 0 183 self)
			)
			(4
				(= seconds 3)
			)
			(5
				(Print 91 0 #at -1 15 #width 280 #time 8) ; "Eve, baby," you greet your woman with love in your voice, "you're finally home! I've been worried sick about you."
				(aMouth posn: 3 152)
				(= seconds 3)
			)
			(6
				(Print 91 1 #time 7) ; "Who are you?" asks the voluptuous woman in the the magnificent red sports car. "And, why are you mowing my lawn?"
				(aMouth posn: 3 1152)
				(= seconds 3)
			)
			(7
				(Print 91 2 #at -1 15 #width 280 #time 6) ; "Why, Eve! Don't you remember me? It's me, Larry; Larry Laffer!"
				(Print 91 3 #at -1 15 #width 280 #time 12) ; "We met in that hot tub in Lost Wages... in your luxury penthouse apartment... in "The Land of the Lounge Lizards..." just before my big finale (wink, wink)... at the end of the game, remember?"
				(aMouth posn: 3 152)
				(= seconds 2)
			)
			(8
				(Print 91 4 #time 5) ; "Vaguely," she says. "So why are you here?"
				(aMouth posn: 3 1152)
				(= seconds 3)
			)
			(9
				(Print 91 5 #at -1 15 #width 280 #time 10) ; "Why, I, er, ah, that is," you stammer, "why, I just kinda assumed when two people are as deeply in love as we are, uh, er, the natural thing to do to move in together, and, so here I am..."
				(Print 91 6 #time 9) ; "Move in?! You creep! You've got exactly five minutes to get everything out of my house, and out of my life."
				(Print 91 7 #time 4) ; "Brutus," she commands her dog, "ON GUARD!"
				(aDog show:)
				(= seconds 3)
			)
			(10
				(aDog setCycle: End self)
			)
			(11
				(= cycles 5)
			)
			(12
				(aDog
					view: 804
					posn: 52 167
					setPri: -1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 193 161 self
				)
				(Print 91 8 #at -1 15 #width 280 #time 7) ; "Hmm," you think to yourself, "that dog looks rather familiar."
				(aMouth posn: 3 152)
				(= cycles 30)
			)
			(13
				(Print 91 9 #time 8) ; "I'll be back here in five minutes," Eve shouts, "and you WON'T!!"
				(aMouth dispose:)
				(aCar setMotion: MoveTo -99 288)
			)
			(14
				(aDog setLoop: 2 setCycle: Fwd)
				(= cycles 30)
			)
			(15
				(Print 91 10 #at -1 152 #time 3) ; "(Sigh.)"
				(= cycles 30)
			)
			(16
				(aDog
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 123 161 self
				)
			)
			(17
				(Print 91 11 #at -1 15 #width 280 #time 13) ; "Gee, Larry; looks like things are just the way they used to be. You thought your life was complete: you had found true love with a beautiful woman, with a beautiful car and a beautiful home, all in beautiful Los Angeles..."
				(Print 91 12 #at -1 15 #width 280 #time 4) ; "...but instead, you're out on the streets again!"
				(aDog setMotion: MoveTo -22 151)
				(= seconds 3)
			)
			(18
				(Print 91 13 #time 3) ; "What will you do?"
				(gCurRoom newRoom: 92 7)
			)
		)
	)
)

