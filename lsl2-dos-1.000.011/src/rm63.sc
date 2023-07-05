;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm63 0
)

(local
	aSmoker1
	aSmoker2
	aSmoker3
	aJohnLight
	aJohnDoor
	aJohnUser1
	aJohnUser2
	aEmergencyExit
)

(instance rm63 of Rm
	(properties
		picture 63
		west 62
	)

	(method (init)
		(Load rsVIEW gCurrentEgoView)
		(Load rsVIEW 605)
		(Load rsVIEW 161)
		(Load rsVIEW 608)
		(super init:)
		((View new:)
			view: 605
			loop: 4
			cel: 0
			posn: 253 93
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((= aSmoker1 (Prop new:))
			view: 605
			loop: 2
			cel: 0
			posn: 113 84
			setPri: 5
			cycleSpeed: 3
			setCycle: Fwd
			stopUpd:
			init:
			setScript: smokerScript
		)
		((= aSmoker2 (Prop new:))
			view: 605
			loop: 2
			cel: 0
			posn: 62 114
			setPri: 8
			ignoreActors:
			cycleSpeed: 2
			setCycle: Fwd
			stopUpd:
			init:
		)
		((= aSmoker3 (Prop new:))
			view: 605
			loop: 2
			cel: 0
			posn: 155 106
			setPri: 7
			ignoreActors:
			cycleSpeed: 3
			setCycle: Fwd
			stopUpd:
			init:
		)
		((= aJohnLight (Prop new:))
			view: 605
			loop: 3
			cel: 1
			posn: 203 60
			setPri: 3
			stopUpd:
			init:
		)
		((= aJohnDoor (Prop new:))
			view: 605
			loop: 1
			cel: 0
			posn: 232 83
			setPri: 5
			stopUpd:
			ignoreActors:
			init:
			setScript: johnScript
		)
		((= aJohnUser1 (Act new:))
			view: 608
			posn: 222 80
			setPri: 0
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
			init:
			hide:
		)
		((= aJohnUser2 (Act new:))
			view: 608
			posn: 0 0
			setPri: 0
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
			init:
			hide:
		)
		((= aEmergencyExit (Act new:))
			view: 605
			illegalBits: 0
			ignoreActors:
			setLoop: 0
			cel: 0
			posn: 274 146
			setPri: 15
			setStep: 5 5
			stopUpd:
			init:
		)
		(NormalEgo 0)
		(gEgo posn: 37 105 init: observeControl: 16384)
		(self setRegions: 600 setScript: rm63Script) ; rm600
	)
)

(instance rm63Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== gCurrentStatus 0) (& (gEgo onControl:) $0002))
			(gCurRoom newRoom: 62)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if
			(Said
				'look,board,apply,open/(airport<bath),(airport<bath),bathroom'
			)
			(cond
				((gEgo inRect: 206 0 236 92)
					(Print 63 0) ; "The red light indicates it's currently "Occupado.""
				)
				((gEgo inRect: 242 90 254 102)
					(Print 63 1) ; "You are not desperate enough to use the Women's restroom. Besides, some gal has been in there for hours!"
				)
				(else
					(Print 63 2) ; "You're not near a restroom."
				)
			)
		)
		(if (Said 'bang/door')
			(Print 63 3) ; "Knock, knock."
			(Print 63 4) ; "Who's there?"
			(Print 63 5) ; "Larry; Larry Laffer."
			(Print 63 6 #at -1 152) ; "(You never were good at jokes!)"
		)
		(if (Said 'talk')
			(Print (Format @gString 63 7 gLaffer)) ; ""Hello," you say to the men in the smoking area, %s"
			(Print 63 8) ; "Hack."
			(Print 63 9) ; "Cough."
			(Print 63 10) ; "Wheeze."
		)
		(if (Said '(blow<up),blow/cord')
			(Print 63 11) ; "Puff, puff."
		)
		(if (Said 'look>')
			(if (Said '/door')
				(cond
					((== gAirplaneDoorStatus 2)
						(Print 63 12) ; "It's still securely closed, although the safety handle is in the open position."
					)
					((== gAirplaneDoorStatus 1)
						(Print 63 13) ; "Even though the padlock is now off, the large red handle is still in the closed position."
					)
					(else
						(Print 63 14) ; "There are three doors here. Two are labeled "Restroom." One is labeled "DANGER -- EMERGENCY EXIT!""
					)
				)
			)
			(if (Said '/carpet,ceiling')
				(Print 63 15) ; "It's difficult to see with all the smoke back here, but you think you detect three doors at the rear of the plane!"
			)
			(if (Said '/burn')
				(Print 63 16) ; "When the light near the restroom is lit, the restroom is currently occupied."
			)
			(if (Said '[/children,man,woman,airline,airport]')
				(Print 63 17) ; "The smell of stale cigarette smoke makes you fondly recall your days as a lounge lizard!"
				(Print 63 18) ; "Available at your local software dealer as "Leisure Suit Larry in the Land of the Lounge Lizards!""
				(Print 63 19) ; "Pick up a couple of copies today!"
			)
		)
		(if (Said 'smell')
			(Print 63 17) ; "The smell of stale cigarette smoke makes you fondly recall your days as a lounge lizard!"
			(Print 63 20) ; "Remember, those wonderful days of yesteryear are available now, at your local software dealer as "Leisure Suit Larry in the Land of the Lounge Lizards!""
			(Print 63 21) ; "Be sure to pick up several copies today!"
		)
		(if (Said '(drop<on),wear,afix,buckle,afix,apply/parachute')
			(cond
				(gWearingParachute
					(ItIs) ; "It is."
				)
				((not (gEgo has: 24)) ; Parachute
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(Print 63 22) ; "The other passengers stare at you with suspicious expressions, so you slide the parachute under your coat."
					(gGame changeScore: 4)
					(= gWearingParachute 1)
				)
			)
		)
		(if (and gWearingParachute (Said 'alter,(get<off),drain/parachute'))
			(Ok) ; "Ok."
			(= gWearingParachute 0)
		)
		(if (Said 'drain,apply,drop/rejuvenator/bolt,door,cord')
			(cond
				((not (gEgo has: 21)) ; Hair_Rejuvenator
					(DontHave) ; "You don't have it."
				)
				((not (gEgo inRect: 0 127 320 190))
					(NotClose) ; "You're not close enough."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(Print 63 23) ; "Ok. You carefully pour your bottle of highly flammable hair rejuvenator on the emergency exit's padlock. It makes the look look really new!"
					(gEgo put: 21 -1) ; Hair_Rejuvenator
					(gGame changeScore: -5)
				)
			)
		)
		(if (Said '/gun/bolt,door,cord')
			(cond
				((not (gEgo has: 17)) ; Knife
					(DontHave) ; "You don't have it."
				)
				((not (gEgo inRect: 0 127 320 190))
					(NotClose) ; "You're not close enough."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(Print 63 24) ; "You try your best to jimmy the lock with the dull cheese knife, but for naught."
				)
			)
		)
		(if
			(or
				(Said 'apply/bobbypin')
				(Said 'unbolt,open/bolt,cord/bobbypin')
				(Said 'get/bolt')
			)
			(cond
				((not (gEgo inRect: 0 127 320 190))
					(NotClose) ; "You're not close enough."
				)
				((not (gEgo has: 25)) ; Bobby_Pin
					(Print 63 25) ; "You don't have the proper equipment to do that."
					(Print 63 26 #at -1 152) ; "(You've heard that line before!)"
				)
				(else
					(gGame changeScore: 5)
					(Print 63 27) ; "Cleverly, you insert the bobby pin into the safety lock. (Wouldn't you guess this is against some Federal regulation?)"
					(Print 63 28) ; "The pin works! The door is unlocked."
					(= gAirplaneDoorStatus 1)
					(gEgo put: 25 -1) ; Bobby_Pin
				)
			)
		)
		(if (Said 'pull,apply,pull,pull/cord,cord,button')
			(cond
				((not (gEgo inRect: 0 127 320 190))
					(NotClose) ; "You're not close enough."
				)
				((== gAirplaneDoorStatus 1)
					(Print 63 29) ; "With great difficulty, you push the large red handle until you feel something tear. Crossing your legs, you shove the handle a quarter-turn to the left, until it is near the word "DANGER.""
					(= gAirplaneDoorStatus 2)
				)
				((< gAirplaneDoorStatus 1)
					(Print 63 30) ; "A heavy, locked padlock on the handle prevents you from doing that."
				)
				(else
					(Print 63 31) ; "It IS!"
				)
			)
		)
		(if (Said 'pull,open/door')
			(cond
				((gEgo inRect: 206 0 236 92)
					(Print 63 0) ; "The red light indicates it's currently "Occupado.""
				)
				((gEgo inRect: 242 90 254 102)
					(Print 63 32) ; "Some gal has been in that one for hours!"
				)
				((not (gEgo inRect: 0 127 320 190))
					(NotClose) ; "You're not close enough."
				)
				((== gAirplaneDoorStatus 2)
					(= gAirplaneDoorStatus 3)
					(self changeState: 1)
				)
				((< gAirplaneDoorStatus 2)
					(Print 63 33) ; "There's a large red handle preventing that."
				)
				(else
					(Print 63 31) ; "It IS!"
				)
			)
		)
		(if (Said 'man,(ask<for)/cigarette')
			(Print 63 34) ; "Hey, buddy," you shout, "how's 'bout givin' me one of them coffin nails?"
			(Print 63 35 #at -1 152) ; "(Why, Larry! You don't even smoke!)"
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds (= cycles 0))
				(HandsOff)
				(gEgo posn: 250 145)
				(Print 63 36 #draw) ; "You give the door a firm shove..."
				(gGame changeScore: 6)
				(aEmergencyExit cycleSpeed: 3 setCycle: End self)
			)
			(2
				(aEmergencyExit setMotion: MoveTo 324 (aEmergencyExit y:) self)
				(Print 63 37 #draw) ; "...and the blast of the airstream tears it from its hinges!"
			)
			(3
				(Print 63 38) ; "You feel yourself being sucked..."
				(Print 63 39) ; "...out, unfortunately!"
				(gEgo
					ignoreActors:
					illegalBits: 0
					view: 161
					posn: 261 135
					cycleSpeed: 1
					setLoop: 0
					setCel: 0
					setCycle: End self
					setPri: 15
				)
			)
			(4
				(gEgo setCel: setStep: 5 5 setMotion: MoveTo 333 135 self)
			)
			(5
				(gCurRoom newRoom: 64)
			)
		)
	)
)

(instance smokerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(aSmoker1 startUpd: setCel: 0 setCycle: End self)
			)
			(2
				(aSmoker1 stopUpd:)
				(= seconds (Random 1 5))
			)
			(3
				(aSmoker2 startUpd: setCel: 0 setCycle: End self)
			)
			(4
				(aSmoker2 stopUpd:)
				(= seconds (Random 1 5))
			)
			(5
				(aSmoker3 startUpd: setCel: 0 setCycle: End self)
			)
			(6
				(aSmoker3 stopUpd:)
				(= seconds (Random 1 5))
				(= state 0)
			)
		)
	)
)

(instance johnScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl:) $1000) (== state 0))
			(johnScript changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds (= cycles 0))
				(aJohnDoor startUpd: setCycle: End self)
				(aJohnLight setCel: 0 forceUpd:)
			)
			(2
				(aJohnDoor stopUpd:)
				(aJohnUser1
					loop: 1
					posn: 219 86
					setPri: 5
					startUpd:
					show:
					setCycle: Walk
					setMotion: MoveTo 192 98 self
				)
				(aJohnUser2
					loop: 0
					posn: 174 104
					setPri: 6
					startUpd:
					show:
					setCycle: Walk
					setMotion: MoveTo 210 104
				)
			)
			(3
				(aJohnUser1 setMotion: MoveTo 174 98)
				(aJohnUser2 setMotion: MoveTo 222 86 self)
			)
			(4
				(aJohnUser1 hide:)
				(aJohnUser2 hide:)
				(aJohnDoor startUpd: setCycle: Beg self)
			)
			(5
				(aJohnDoor stopUpd:)
				(aJohnLight setCel: 1 forceUpd:)
				(= seconds (Random 11 33))
			)
			(6
				(= state 0)
			)
		)
	)
)

