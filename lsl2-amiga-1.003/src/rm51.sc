;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use airplaneScript)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm51 0
)

(local
	work
	goto95
	henchInvited
	LarrySaidYes
)

(instance rm51 of Rm
	(properties
		picture 51
		horizon 1
		north 151
	)

	(method (init)
		(Load rsVIEW 506)
		(Load rsVIEW 230)
		(Load rsVIEW 511)
		(super init:)
		(gAddToPics add: aChair1 aChair2 aSign aNorthChair1 doit:)
		(aBarberPole setCycle: Fwd isExtra: 1 init:)
		(aPlane setPri: 1 startX: -20 startY: 18 endX: 111 endY: 11 init:)
		(if (or (!= 1 (Random 1 3)) (!= gCurrentEgoView 100))
			(gAddToPics add: aNorthChair2 doit:)
		else
			(self setRegions: 8) ; rm8
			(= gHenchOnScreen 1)
			(= gCurrentHenchView 523)
			(Load rsVIEW 523)
			(Load rsVIEW 524)
			(aHench
				setPri: 5
				illegalBits: 0
				init:
				cycleSpeed: 2
				setCycle: Fwd
				setScript: henchScript
			)
			(Notify 8 1)
		)
		(if (or (== gPrevRoomNum 151) (== gPrevRoomNum 0))
			(gEgo posn: 210 100)
		)
		(NormalEgo)
		(gEgo init:)
		(self setRegions: 500 setScript: rm51Script) ; rm500
	)
)

(instance rm51Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 151)
		)
		(if (== 2 (gEgo edgeHit:))
			(if (== goto95 0)
				(gCurRoom newRoom: 52)
			else
				(Print 51 0 #at 15 -1 #width 280) ; "The two of you head for the tarmac where she introduces herself as an interior decorator and professional hair styling consultant. You enter her "corporate helicopter," which bears a large logo consisting of just a circle and a slash. "Oh, that," she explains, "that means 'no plain areas.'" A short, romantic, low-altitude chopper ride across the South Pacific is followed by..."
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 95)
			)
		)
		(if (and gHenchOnScreen henchInvited (> (gEgo x:) 300))
			(= henchInvited 0)
			(= goto95 1)
			(gCurRoom east: 95)
			(Print 51 1) ; "Hey, baby," you cry, "wait for me!!"
			(HandsOff)
			(gEgo setMotion: MoveTo 333 (gEgo y:) self)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/barstool,woman')
				(if (and gHenchOnScreen (< (henchScript state:) 7))
					(Print 51 2) ; "She's beautiful!"
				else
					(Print 51 3) ; "These chairs have a beautiful, plastic covering."
				)
			)
			(if (Said '/art')
				(Print 51 4) ; "Jim Whistler is about as modern as you can stand."
			)
			(if (Said '[/building,airport]')
				(Print 51 5) ; "This end of the airport contains some chairs, a window looking out on the runway, and the entrance to the airport barber shop."
				(if gHenchOnScreen
					(Print 51 6) ; "There is a gorgeous woman reading a paper."
				)
			)
		)
		(if
			(and
				gHenchOnScreen
				(< (henchScript state:) 7)
				(not LarrySaidYes)
				(or
					(Said 'fuck')
					(Said 'talk/woman')
					(Said 'yes')
					(Said 'bath[/down,barstool]')
					(Said 'embrace')
				)
			)
			(= LarrySaidYes 1)
			(Print 51 7) ; "Hi, baby," you charm her, you charmer. "How's about if I sit here beside you, and you let me see that photo spread?"
			(Print 51 8) ; "Ok," she responds, "but not here. I'd rather do it at my place! Follow me!!"
			(henchScript changeState: 7)
		)
		(if (Said 'bath[/down,barstool]')
			(Print 51 9) ; "Nah. You don't have time to sit here!"
		)
	)
)

(instance henchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(aHench cycleSpeed: 1 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(aHench cycleSpeed: 0 setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(aHench setLoop: 1 setCel: 0)
				(Print 51 10 #draw) ; "Hello, sweetie," says the beautiful woman with the magazine, "wanna look through my layouts?"
				(Print 51 11 #at -1 130) ; "(What an opportunity! You've never met a woman from the magazine industry before!)"
				(= seconds 5)
			)
			(4
				(aHench setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(Print 51 12) ; "Come on, I just can't wait to see you sans serif!"
				(= seconds 3)
			)
			(6
				(Print 51 13) ; ""Well, ok. Maybe next month!" she gives up."
				(aHench setLoop: 0 cel: 0 setCycle: Fwd cycleSpeed: 2)
				(= seconds (Random 10 40))
				(= state 0)
			)
			(7
				(= cycles (= seconds 0))
				(gAddToPics add: aNewChair doit:)
				(aHench
					view: gCurrentHenchView
					ignoreActors: 0
					loop: 0
					cycleSpeed: 0
					posn: 237 108
					setStep: 3 2
					setLoop: -1
					setAvoider: (Avoid new:)
					setCycle: Walk
					setMotion: MoveTo 305 118 self
				)
			)
			(8
				(Print 51 14) ; "Come on to my place and I'll show you my galleys!"
				(aHench setMotion: MoveTo 333 118 self)
				(= henchInvited 1)
			)
			(9
				(= seconds 10)
			)
			(10
				(aHench dispose:)
				(= gCurrentHenchView 0)
				(= gHenchOnScreen 0)
				(= henchInvited 0)
			)
		)
	)
)

(instance aChair1 of PV
	(properties
		y 156
		x 59
		view 506
		priority 10
		signal 16384
	)
)

(instance aChair2 of PV
	(properties
		y 182
		x 19
		view 506
		priority 11
		signal 16384
	)
)

(instance aSign of PV
	(properties
		y 74
		x 152
		view 506
		cel 1
		priority 4
		signal 16384
	)
)

(instance aNorthChair1 of PV
	(properties
		y 103
		x 266
		view 506
		cel 2
		priority 5
		signal 16384
	)
)

(instance aNorthChair2 of PV
	(properties
		y 103
		x 240
		view 506
		cel 2
		priority 5
		signal 16384
	)
)

(instance aNewChair of PV
	(properties
		y 103
		x 240
		view 506
		cel 2
		priority 5
		signal 16384
	)
)

(instance aBarberPole of Prop
	(properties
		y 74
		x 236
		view 230
		priority 4
	)
)

(instance aPlane of Airplane
	(properties)
)

(instance aHench of Act
	(properties
		y 103
		x 240
		view 524
		signal 16384
	)
)

