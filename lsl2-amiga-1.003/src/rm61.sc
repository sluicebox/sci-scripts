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
		(gAddToPics
			add:
				aView1
				aView2
				aView3
				aView4
				aView5
				aView6
				aView7
				aView8
				aView9
				aView10
				aView11
				aView12
				aView13
				aView14
				aView15
				aView16
				aView17
			doit:
		)
		(aNewspaper setPri: 6 pauseCel: 255 minPause: 3 maxPause: 8 init:)
		(aHand
			setPri: 9
			pauseCel: 255
			minPause: 3
			maxPause: 8
			minCycles: 5
			maxCycles: 11
			init:
		)
		(aKnitting
			setPri: 5
			pauseCel: 255
			minPause: 3
			maxPause: 11
			minCycles: 15
			maxCycles: 31
			init:
		)
		(self setRegions: 600 setScript: rm61Script) ; rm600
		(aCockDoor setPri: 5 stopUpd: init:)
		(if (== gPrevRoomNum 62)
			(gEgo observeControl: 16384 loop: 1 posn: 300 101)
			(gAddToPics add: aMainDoor doit:)
		else
			(Load rsVIEW 23)
			(aStewardess stopUpd: init:)
			(gEgo loop: 3 posn: 42 143)
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

(instance aView1 of PV
	(properties
		y 75
		x 254
		view 661
		cel 2
		priority 4
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 75
		x 205
		view 661
		cel 3
		priority 4
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 76
		x 151
		view 661
		cel 4
		priority 4
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 90
		x 206
		view 661
		cel 1
		priority 5
		signal 16384
	)
)

(instance aView5 of PV
	(properties
		y 91
		x 261
		view 661
		cel 4
		priority 5
		signal 16384
	)
)

(instance aView6 of PV
	(properties
		y 91
		x 150
		view 661
		priority 5
		signal 16384
	)
)

(instance aView7 of PV
	(properties
		y 119
		x 157
		view 661
		loop 1
		cel 4
		priority 8
		signal 16384
	)
)

(instance aView8 of PV
	(properties
		y 119
		x 286
		view 661
		loop 1
		cel 5
		priority 8
		signal 16384
	)
)

(instance aView9 of PV
	(properties
		y 120
		x 223
		view 661
		loop 1
		cel 3
		priority 8
		signal 16384
	)
)

(instance aView10 of PV
	(properties
		y 137
		x 152
		view 661
		loop 1
		priority 10
		signal 16384
	)
)

(instance aView11 of PV
	(properties
		y 137
		x 288
		view 661
		loop 1
		cel 2
		priority 10
		signal 16384
	)
)

(instance aView12 of PV
	(properties
		y 138
		x 226
		view 661
		loop 1
		cel 1
		priority 10
		signal 16384
	)
)

(instance aView13 of PV
	(properties
		y 77
		x 189
		view 661
		loop 2
		cel 1
		priority 4
		signal 16384
	)
)

(instance aView14 of PV
	(properties
		y 93
		x 239
		view 661
		loop 2
		cel 2
		priority 5
		signal 16384
	)
)

(instance aView15 of PV
	(properties
		y 110
		x 188
		view 661
		loop 2
		priority 7
		signal 16384
	)
)

(instance aView16 of PV
	(properties
		y 110
		x 255
		view 661
		loop 2
		cel 1
		priority 7
		signal 16384
	)
)

(instance aView17 of PV
	(properties
		y 129
		x 279
		view 661
		loop 2
		cel 2
		priority 9
		signal 16384
	)
)

(instance aMainDoor of PV
	(properties
		y 156
		x 38
		view 603
		loop 1
		priority 15
		signal 16384
	)
)

(instance aNewspaper of Extra
	(properties
		y 74
		x 146
		view 661
		loop 3
	)
)

(instance aHand of Extra
	(properties
		y 108
		x 279
		view 661
		loop 4
	)
)

(instance aKnitting of Extra
	(properties
		y 59
		x 149
		view 661
		loop 5
	)
)

(instance aCockDoor of Prop
	(properties
		y 103
		x 41
		view 603
		signal 16384
	)
)

(instance aStewardess of Prop
	(properties
		y 100
		x 55
		view 600
		loop 4
	)
)

