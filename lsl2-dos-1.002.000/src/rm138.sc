;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 138)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm138 0
)

(local
	day
	aBigEgo
	aShip
	aCalendar
	aPage
	aDate
	aFlame
	aWave
)

(instance rm138 of Rm
	(properties
		picture 138
		horizon 5
	)

	(method (init)
		(Load rsVIEW 120)
		(Load rsVIEW 326)
		(Load rsVIEW 121)
		(Load rsVIEW 122)
		(Load rsVIEW 123)
		(Load rsVIEW 124)
		(super init:)
		((= aBigEgo (Prop new:))
			view: 120
			setLoop: 0
			setPri: 3
			cel: 0
			posn: 116 67
			stopUpd:
			init:
		)
		(if (== gWearingWig 1)
			((View new:)
				view: 120
				loop: 1
				setPri: 5
				posn: 116 67
				ignoreActors:
				stopUpd:
				init:
			)
		)
		((= aCalendar (Prop new:))
			view: 326
			setLoop: 1
			setCel: 0
			setPri: 7
			posn: 220 39
			setCycle: Fwd
			init:
			hide:
		)
		((= aDate (Prop new:))
			view: 326
			setLoop: 2
			setCel: 0
			setPri: 9
			posn: 228 71
			init:
			hide:
		)
		((= aPage (Act new:))
			view: 326
			setLoop: 3
			setCel: 0
			setPri: 11
			posn: 220 39
			ignoreActors:
			ignoreHorizon:
			cycleSpeed: 0
			setStep: 10 10
			init:
			hide:
		)
		((= aShip (Act new:))
			view: 326
			setLoop: 0
			setCel: 0
			setPri: 3
			setStep: 1 1
			moveSpeed: 8
			cycleSpeed: 8
			posn: 233 59
			ignoreActors:
			ignoreHorizon:
			init:
		)
		((= aWave (Prop new:))
			view: 326
			setLoop: 4
			setPri: 11
			posn: 115 155
			cycleSpeed: 2
			setCycle: Fwd
			isExtra: 1
			init:
		)
		((= aFlame (Prop new:))
			view: 120
			loop: 2
			posn: 115 66
			setPri: 5
			setCycle: Fwd
			init:
			hide:
		)
		(HandsOff)
		(= gCurrentStatus 21)
		(self setScript: rm138Script)
	)
)

(instance rm138Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aShip setCycle: End setMotion: MoveTo 233 50 self)
			)
			(1
				(aShip
					setPri: 1
					setCel:
					moveSpeed: 13
					setMotion: MoveTo 233 65 self
				)
				(Print 138 0) ; "And as the good ship U.S.S. Love Tub slowly sinks behind the horizon, we rejoin our noble hero in his latest predicament."
			)
			(2
				(Print 138 1) ; "Isn't it funny how time flies when you're having fun!"
				(aShip dispose:)
				(= seconds 3)
			)
			(3
				(aCalendar show:)
				(aDate show:)
				(= seconds 3)
			)
			(4
				(if (>= day 9)
					(Print 138 2) ; "During a particularly rough storm, late in your tenth night at sea, your lifeboat crashes on a coral reef and shatters to bits. You grab the largest piece of wood you can, hold on tight and survive the storm. The dawn finds you crashing through an offshore reef, tumbling through the surf to a gorgeous beach."
					(gCurRoom newRoom: 42)
				else
					(++ day)
					(calendarScript changeState: 1)
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(cond
					((== day 3)
						(Print 138 3 #at -1 20) ; "Boy, is that sun hot!"
						(if (or (== gWearingSunscreen 1) (== gWearingSunscreen 3))
							(Print 138 4 #at 15 -1 #width 280) ; "It's a good thing you used that sunscreen to block those ultraviolets! The sun out here is hot enough to fry an egg."
							(gGame changeScore: 5)
							(= seconds 1)
						else
							(self changeState: 8)
						)
					)
					((== day 4)
						(Print 138 5 #at -1 20) ; "You think the sun must be even hotter today!"
						(if gWearingWig
							(Print 138 6 #at -1 20) ; "It's a good thing you wore that silly wig. The sun out here is hot enough to fry your brains."
							(gGame changeScore: 5)
							(= seconds 1)
						else
							(self changeState: 11)
						)
					)
					((== day 5)
						(Print 138 7 #at 15 -1 #width 280) ; "Your thirst becomes more and more intense with every passing day. Visions of pre-Classic Coke float before your eyes!"
						(if (not (gEgo has: 8)) ; Grotesque_Gulp
							(self changeState: 18)
						else
							(Print 138 8 #at 15 -1 #width 280) ; "You extract the Grotesque Gulp from your inside coat pocket and are surprised to discover it has retained its entire 32-gallon capacity. You now have enough fluid to last you for weeks; but you are worried about your blood sugar level!"
							(gGame changeScore: 5)
							(gEgo put: 8 -1) ; Grotesque_Gulp
							(= seconds 1)
						)
					)
					((== day 6)
						(Print 138 9 #at 15 -1 #width 280) ; "Your hunger grows intense with the passing of the days. Visions of Danny's Pizza float before your eyes!"
						(cond
							((gEgo has: 13) ; Spinach_Dip
								(Print 138 10 #at -1 20) ; "It's a good thing you brought that spinach dip along."
								(gEgo put: 13 -1) ; Spinach_Dip
								(self changeState: 15)
							)
							((gEgo has: 12) ; Sewing_Kit
								(Print 138 11 #at 15 -1 #width 280) ; "You cleverly open the sewing kit you stole from that Mother's nightstand, extract a safety pin and thread. You patiently fish for hours, but eventually catch your limit."
								(Print 138 12) ; "(Your limit for raw fish is quite low!)"
								(gGame changeScore: 10)
								(= seconds 1)
							)
							((gEgo has: 11) ; Fruit
								(Print 138 13 #at -1 20) ; "You were so clever to grab that basket of fruit from the nightstand."
								(gEgo put: 11 -1) ; Fruit
								(gGame changeScore: 5)
								(= seconds 1)
							)
							(else
								(self changeState: 21)
							)
						)
					)
					(else
						(= seconds 1)
					)
				)
			)
			(7
				(= state 3)
				(= seconds 1)
			)
			(8
				(aBigEgo view: 123 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(9
				(= seconds 3)
			)
			(10
				(Print 138 14 #at -1 20) ; "Second-degree burns from the sun are no "Laff-ing" matter, Larry!"
				(if (== gWearingSunscreen 2)
					(Print 138 15 #at -1 152) ; "(Looks like that sunscreen is not waterproof!)"
				)
				(= state 24)
				(= seconds 3)
			)
			(11
				(aFlame show:)
				(= seconds 5)
			)
			(12
				(aBigEgo view: 123 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(13
				(= seconds 3)
			)
			(14
				(Print 138 16 #at -1 20) ; "The tropical sun has turned your balded brain into an omelette cooked until Sunnyside Soft, Larry!"
				(= state 24)
				(= seconds 3)
			)
			(15
				(aBigEgo view: 121 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(16
				(= seconds 3)
			)
			(17
				(Print 138 17 #at -1 20) ; "Unfortunately for you, the mayonnaise has spoiled in the hot, tropical sun!"
				(= state 24)
				(= seconds 3)
			)
			(18
				(aBigEgo view: 122 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(19
				(= seconds 3)
			)
			(20
				(Print 138 18 #at -1 20) ; "Perhaps next time you'll pack a little something to drink before beginning your trans-oceanic voyage!"
				(= state 24)
				(= seconds 3)
			)
			(21
				(aBigEgo view: 124 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(22
				(= seconds 3)
			)
			(23
				(Print 138 19 #at -1 20) ; "You've thought of all your needs, except food. Come on, you can find something to eat somewhere, can't you?"
				(= state 24)
				(= seconds 3)
			)
			(24
				(= seconds 3)
			)
			(25
				(calendarScript changeState: 6)
				(= seconds 3)
			)
			(26
				(Print 138 20 #at -1 20) ; "Better luck next cruise, Larry!"
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance calendarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aPage posn: 220 39 cel: 0 setCycle: CT 2 1 self show:)
			)
			(2
				(aDate setCel: (+ 1 (aDate cel:)) forceUpd:)
				(aPage setCycle: End self)
			)
			(3
				(aPage setMotion: MoveTo 360 -31 self)
			)
			(4
				(aPage hide:)
				(rm138Script cue:)
			)
			(6
				(aDate dispose:)
				(aPage dispose:)
				(aCalendar dispose:)
			)
		)
	)
)

