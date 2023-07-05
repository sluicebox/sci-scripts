;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm36 0
)

(local
	work
)

(instance rm36 of Rm
	(properties
		picture 36
		south 31
	)

	(method (init)
		(Load rsVIEW gCurrentEgoView)
		(Load rsVIEW 322)
		(Load rsVIEW 323)
		(Load rsVIEW 324)
		(Load rsVIEW 321)
		(super init:)
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
			doit:
		)
		(aDials1 loop: 1 setPri: 6 setCycle: Fwd cycleSpeed: 1 isExtra: 1 init:)
		(aDials2 setPri: 6 setCycle: Fwd cycleSpeed: 2 isExtra: 1 init:)
		(aDials3 setPri: 8 setCycle: Fwd cycleSpeed: 3 isExtra: 1 init:)
		(aDials4 setPri: 6 setCycle: Fwd cycleSpeed: 5 isExtra: 1 init:)
		(aDials5 setPri: 6 setCycle: Fwd cycleSpeed: 5 isExtra: 1 init:)
		(aDials6 setPri: 8 setCycle: Fwd cycleSpeed: 6 isExtra: 1 init:)
		(aHorizonEast setPri: 3 setCycle: Fwd cycleSpeed: 3 isExtra: 1 init:)
		(aHorizonWest setPri: 3 setCycle: Fwd cycleSpeed: 3 isExtra: 1 init:)
		(aLever setCel: (if gLoweredLifeboats 255 else 0) setPri: 8 stopUpd: init:)
		(aWheel setPri: 6 init:)
		(aCaptain setPri: 8 init: setScript: captainScript)
		(aHench setLoop: 1 setPri: 5 illegalBits: 0 setCycle: Walk init: hide:)
		(NormalEgo 3)
		(gEgo posn: 164 151 init:)
		(self setRegions: 300 setScript: rm36Script) ; rm300
	)
)

(instance rm36Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl:) $0002)
				(gCurRoom newRoom: 31)
			)
			((and (< state 1) (< (gEgo y:) 111))
				(self changeState: 1)
			)
			((and (< state 9) (< (gEgo x:) 155))
				(self changeState: 9)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/console,buffet,(console<control)')
				(Print 36 0) ; "There are many flashing dials, lights, video display terminals, etc. Mostly, they just confuse you."
			)
			(if (Said '/control,computer,amp,burn,krod')
				(Print 36 1) ; "The ship's flashing dials and lights reveal nothing, but there is a large switch on the center console, directly behind the Captain."
			)
			(if (Said '/cord,cord')
				(Print 36 2) ; "There is a large toggle switch labeled "LIFEBOAT TIMER" on the console directly behind the Captain."
			)
			(if (Said '/man')
				(Print 36 3) ; "He's intently steering this ship. Don't disturb him."
			)
			(if (Said '[/airport,cabin]')
				(Print 36 4) ; "You have the distinct feeling that you should not be messing around on the bridge of a large, ocean-going vessel. So far, the Captain hasn't noticed you."
				(Print 36 5) ; "You'd better keep it that way."
			)
		)
		(if (Said '/man,man')
			(Print 36 6) ; "No, better not. You're not supposed to be in here, and as of now, he hasn't seen you. Leave him alone."
		)
		(if (Said 'throw,cord,pull/cord')
			(cond
				(gLoweredLifeboats
					(Print 36 7) ; "Try as you might, you are unable to return the switch to its previous position. It is locked "ON." Once a lifeboat drill begins, there is no turning back!"
				)
				((not (gEgo inRect: 175 110 202 128))
					(NotClose) ; "You're not close enough."
				)
				(else
					(= gLoweredLifeboats 1)
					(gGame changeScore: 8)
					(aLever setCycle: End)
					(Print 36 8 #draw #at -1 15 #width 280) ; "Silently, cautiously, so as not to attract the Captain's attention, you move the large toggle switch to the "START" position. A faint ticking sound begins."
					(SetRgTimer 3 2 10)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds (= cycles 0))
				(HandsOff)
				(= gCurrentStatus 1000)
				(aHench show: setMotion: MoveTo 167 92 self)
				(captainScript dispose:)
				(gEgo stopUpd:)
			)
			(2
				(aHench setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(aHench cycleSpeed: 0 setCycle: Beg)
				(aDart
					setLoop: 3
					illegalBits: 0
					setStep: 4 4
					init:
					setMotion: MoveTo 146 95 self
				)
				(Print 36 9 #at -1 20 #draw) ; "Look out, Larry! He's firing a poisoned dart!!"
			)
			(4
				(aDart dispose:)
				(aHench
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 192 92
				)
				(aWheel setCycle: End)
				(aCaptain
					view: 324
					setLoop: 0
					setCel: 0
					posn: 140 115
					setPri: 8
					ignoreActors:
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(gAddToPics add: aDying doit:)
				(aCaptain view: 324 setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(Print 36 10) ; "At least he missed you. However, the Captain lies dying on the deck, and the ship is drifting helplessly on the high seas!"
				(aCaptain stopUpd:)
				(aWheel stopUpd:)
				(= seconds 3)
			)
			(7
				(Print 36 11) ; "Through your ineptitude you've allowed your Captain to be killed by a KGB poisoned dart. Unbeknown to the passengers and crew the ship now charts its own course, a course (of course) that courses straight for the nearest reef."
				(Print 36 12) ; "Perhaps you'll miss the reef and miss the grief; save the ship and save the day; perhaps you'll even escape safely!"
				(aHench dispose:)
				(= seconds 3)
			)
			(8
				(ShakeScreen 8 (Random 1 3))
				(Print 36 13) ; "Nah, no way!!"
				(Print 36 14) ; "You knew better than that!"
				(= gCurrentStatus 1001)
			)
			(9
				(= seconds (= cycles 0))
				(= gCurrentStatus 1000)
				(HandsOff)
				(gEgo stopUpd:)
				(Print 36 15 #draw) ; "Hold it right there, buddy!" says the Captain. "No one's allowed on MY bridge without permission!"
				(= seconds 3)
			)
			(10
				(gEgo hide:)
				(Print 36 16 #draw) ; "The security guards take you away to the brig, which is located on a deck even lower than your cabin! The conditions there aren't that bad, although seepage does keep the floor covered with oily, slimy water. Unfortunately, during one particularly wet dream, you slide off your bunk and drown in bilge water."
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance captainScript of Script
	(properties)

	(method (changeState newState &tmp tmpSpeed tmpDelay)
		(switch (= state newState)
			(0
				(= cycles (Random 5 10))
			)
			(1
				(= tmpSpeed (Random 0 3))
				(aCaptain cycleSpeed: tmpSpeed setCycle: End)
				(aWheel cycleSpeed: tmpSpeed setCycle: End)
				(= cycles (Random 5 10))
			)
			(2
				(aCaptain setCel:)
				(aWheel setCel:)
				(= cycles (Random 5 10))
			)
			(3
				(= tmpSpeed (Random 0 3))
				(aCaptain cycleSpeed: tmpSpeed setCycle: Beg)
				(aWheel cycleSpeed: tmpSpeed setCycle: Beg)
				(= cycles (Random 5 10))
			)
			(4
				(aCaptain setCel:)
				(aWheel setCel:)
				(self changeState: 0)
			)
		)
	)
)

(instance aView1 of PV
	(properties
		y 111
		x 80
		view 322
		priority 7
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 106
		x 94
		view 322
		cel 1
		priority 7
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 111
		x 82
		view 322
		cel 1
		priority 7
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 116
		x 71
		view 322
		cel 1
		priority 8
		signal 16384
	)
)

(instance aView5 of PV
	(properties
		y 84
		x 144
		view 322
		cel 2
		priority 6
		signal 16384
	)
)

(instance aView6 of PV
	(properties
		y 84
		x 152
		view 322
		cel 2
		priority 6
		signal 16384
	)
)

(instance aView7 of PV
	(properties
		y 93
		x 117
		view 322
		cel 2
		priority 6
		signal 16384
	)
)

(instance aView8 of PV
	(properties
		y 100
		x 98
		view 322
		cel 2
		priority 6
		signal 16384
	)
)

(instance aView9 of PV
	(properties
		y 150
		x 99
		view 322
		loop 9
		priority 15
		signal 16384
	)
)

(instance aView10 of PV
	(properties
		y 150
		x 229
		view 322
		loop 9
		cel 1
		priority 15
		signal 16384
	)
)

(instance aDying of PV
	(properties
		y 115
		x 140
		view 324
		loop 2
		priority 7
		signal 16384
	)
)

(instance aDials1 of Prop
	(properties
		y 92
		x 201
		view 322
		cel 2
		signal 16384
	)
)

(instance aDials2 of Prop
	(properties
		y 84
		x 199
		view 322
		loop 2
		signal 16384
	)
)

(instance aDials3 of Prop
	(properties
		y 98
		x 107
		view 322
		loop 7
		signal 16384
	)
)

(instance aDials4 of Prop
	(properties
		y 104
		x 101
		view 322
		loop 6
	)
)

(instance aDials5 of Prop
	(properties
		y 90
		x 128
		view 322
		loop 7
		signal 16384
	)
)

(instance aDials6 of Prop
	(properties
		y 101
		x 217
		view 322
		loop 8
		signal 16384
	)
)

(instance aHorizonEast of Prop
	(properties
		y 68
		x 181
		view 322
		loop 5
	)
)

(instance aHorizonWest of Prop
	(properties
		y 68
		x 68
		view 322
		loop 4
	)
)

(instance aLever of Prop
	(properties
		y 102
		x 190
		view 322
		loop 3
	)
)

(instance aWheel of Prop
	(properties
		y 104
		x 125
		view 323
		loop 1
	)
)

(instance aCaptain of Act
	(properties
		y 115
		x 140
		view 323
	)
)

(instance aHench of Act
	(properties
		y 91
		x 192
		view 321
		signal 16384
	)
)

(instance aDart of Act
	(properties
		y 76
		x 169
		view 321
		signal 16384
	)
)

