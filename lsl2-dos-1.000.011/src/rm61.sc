;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm61 0
)

(local
	aStewardess
	aCockDoor
	aKnitting
	aNewspaper
	aHand
)

(instance rm61 of Rm
	(properties
		picture 61
	)

	(method (init)
		(Load rsVIEW 100)
		(Load rsVIEW 661)
		(Load rsVIEW 603)
		(super init:)
		(NormalEgo)
		((View new:)
			view: 661
			loop: 0
			cel: 2
			posn: 254 76
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 0
			cel: 3
			posn: 205 76
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 0
			cel: 4
			posn: 151 77
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 0
			cel: 1
			posn: 206 91
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 0
			cel: 4
			posn: 261 92
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 0
			cel: 0
			posn: 150 92
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 1
			cel: 4
			posn: 157 120
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 1
			cel: 5
			posn: 286 120
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 1
			cel: 3
			posn: 223 121
			setPri: 8
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 1
			cel: 0
			posn: 152 138
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 1
			cel: 2
			posn: 288 138
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 1
			cel: 1
			posn: 226 139
			setPri: 10
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 2
			cel: 1
			posn: 189 78
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 2
			cel: 2
			posn: 239 94
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 2
			cel: 0
			posn: 188 111
			setPri: 7
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 2
			cel: 1
			posn: 255 111
			setPri: 7
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 661
			loop: 2
			cel: 2
			posn: 279 130
			setPri: 9
			ignoreActors:
			addToPic:
		)
		((= aNewspaper (Extra new:))
			view: 661
			loop: 3
			posn: 146 75
			setPri: 6
			pauseCel: 255
			minPause: 3
			maxPause: 8
			init:
		)
		((= aHand (Extra new:))
			view: 661
			loop: 4
			posn: 279 109
			setPri: 9
			pauseCel: 255
			minPause: 3
			maxPause: 8
			minCycles: 5
			maxCycles: 11
			init:
		)
		((= aKnitting (Extra new:))
			view: 661
			loop: 5
			posn: 149 60
			setPri: 5
			pauseCel: 255
			minPause: 3
			maxPause: 11
			minCycles: 15
			maxCycles: 31
			init:
		)
		(self setRegions: 600 setScript: rm61Script) ; rm600
		((= aCockDoor (Prop new:))
			view: 603
			ignoreActors:
			setLoop: 0
			posn: 41 104
			setPri: 5
			setCel: 0
			stopUpd:
			init:
		)
		(if (== gPrevRoomNum 62)
			(gEgo observeControl: 16384 loop: 1 posn: 300 102)
			((View new:)
				view: 603
				loop: 1
				cel: 0
				posn: 38 157
				setPri: 15
				ignoreActors:
				addToPic:
			)
		else
			(Load rsVIEW 23)
			((= aStewardess (Prop new:))
				view: 600
				setLoop: 4
				posn: 55 101
				stopUpd:
				init:
			)
			(gEgo loop: 3 posn: 42 144)
			(HandsOff)
			(= gCurrentStatus 9)
			(rm61Script changeState: 1)
		)
		(gEgo init:)
	)
)

(instance rm61Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 17)
			(ShakeScreen 1 (Random 1 3))
		)
		(if (& (gEgo onControl:) $0004)
			(gCurRoom newRoom: 62)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/galley,curtain,woman')
				(if (gEgo inRect: 0 0 106 92)
					(Print 61 0) ; "There's nothing behind the curtain that you need."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(if (Said '/door')
				(Print 61 1) ; "There are two doors here, one leading to the outside and the other to the cockpit."
			)
			(if (Said '[/children,man,woman,airline,airport]')
				(Print 61 2) ; "First Class is certainly more comfortable than "Cattle Class!""
				(Print 61 3) ; "The door to the cockpit is at the front of the airplane."
			)
		)
		(if (Said 'talk/man,woman,children')
			(Print 61 4) ; ""Is there any one here who would like to trade seats?" you ask."
			(Print 61 5) ; ""NO!" they yell back in unison."
		)
		(if (Said 'open/door')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((& (gEgo onControl:) $0010)
					(Print 61 6) ; "This door was locked from the outside before takeoff and there's no way you're ever going to open it!"
				)
				((not (& (gEgo onControl:) $0008))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 12)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds 2)
			)
			(2
				(gEgo setMotion: MoveTo 53 117 self)
			)
			(3
				(aStewardess setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(aStewardess setCel: 0)
				(Print 61 7 #draw) ; "Welcome aboard, sir!" says the stewardess with her best plastic smile. "May I see your ticket, please?"
				(Print 61 8 #icon 23 0 0) ; "You give it to her."
				(= seconds 3)
			)
			(5
				(aStewardess setCycle: Fwd)
				(= seconds 3)
			)
			(6
				(aStewardess setCel: 0)
				(Print 61 9 #draw) ; ""Your seat is on your left, in the second compartment Mr. uh, Laffer" she says, keeping your ticket."
				(gEgo put: 23 -1) ; Airline_Ticket
				(Print 61 10) ; ""Say! Haven't I seen you on TV? Weren't you the big winner of the Lucky Life Lottery?" she asks."
				(Print 61 11) ; "Yep, that's me, baby," you grin, and hand her a $100 bill. "And here's a little something for you."
				(= seconds 3)
			)
			(7
				(aStewardess setCycle: Fwd)
				(= seconds 3)
			)
			(8
				(aStewardess setCel: 0 stopUpd:)
				(Print 61 12 #draw) ; ""It appears that what I've heard is true," she says."
				(Print 61 13) ; ""About me, gorgeous?" you respond."
				(Print 61 14) ; "No, about the nouveau riche. They ARE incredibly crude!"
				(Print (Format @gString 61 15 gTritePhrase)) ; "She gives you her best phony smile. "%s""
				(= seconds 2)
			)
			(9
				(gEgo setMotion: MoveTo 103 102 self)
			)
			(10
				(= seconds 3)
			)
			(11
				(Print 61 16) ; "Why, this plane isn't so small!" you think. "Look at all the room in here."
				(gEgo setMotion: MoveTo 326 102)
			)
			(12
				(HandsOff)
				(= gCurrentStatus 1000)
				(Ok) ; "Ok."
				(aCockDoor setCycle: End self)
			)
			(13
				(gEgo illegalBits: 0 setMotion: MoveTo 0 102 self)
			)
			(14
				(aCockDoor setCycle: Beg self)
			)
			(15
				(Print 61 17) ; "Carrumba!" somebody screams, "It's one of those wacko foreign terrorists!"
				(= seconds 3)
			)
			(16
				(Print 61 18) ; "Grab the fire ax!"
				(Print 61 19) ; "Got him, el Capitan!"
				(= seconds 3)
			)
			(17
				(= seconds 3)
			)
			(18
				(Print 61 20) ; "What a waste, Larry! To come so far and then try to hijack an airliner!"
				(= gCurrentStatus 1001)
			)
		)
	)
)

