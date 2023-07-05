;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 560)
(include sci.sh)
(use Main)
(use eRS)
(use Scaler)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm560 0
)

(local
	local0
	local1
)

(instance rm560 of FPRoom
	(properties
		picture 560
	)

	(method (doit)
		(super doit:)
		(if local1
			(gGame setCursor: 10 1 160 180)
		)
	)

	(method (init)
		(gEgo wearingGuns: 1 get: -1 44) ; Pistols
		(= gAct 4)
		(LoadMany rsSOUND 2124)
		(LoadMany rsVIEW 560)
		(super init:)
		(hand1 init: stopUpd:)
		(hand2 init: stopUpd:)
		(gun1 init: stopUpd:)
		(gun2 init: stopUpd:)
		(gGameMusic1 number: 565 flags: 1 loop: -1 play:)
		(kenny
			posn: 151 141
			setCycle: Walk
			cycleSpeed: 5
			moveSpeed: 10
			setLoop: 1
			setScale: Scaler 100 0 148 137
			yStep: 1
			init:
		)
		(self setScript: sKennyTheKid)
	)

	(method (handleEvent event)
		(event claimed: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sKennyTheKid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gTheIconBar enable: 5)
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: ((gInventory at: 44) cursor: 10 yourself:) ; Pistols
					enable: (gTheIconBar at: 5)
				)
				((gTheIconBar curIcon:) cursor: 10)
				(gTheIconBar select: (gTheIconBar at: 5))
				(kenny setMotion: MoveTo 151 149 self)
			)
			(2
				(kenny
					view: 560
					loop: 2
					cel: 0
					cycleSpeed: 10
					scaleSignal: 0
					stopUpd:
				)
				(= cycles 5)
			)
			(3
				(gMessager say: 13 0 0 0 self) ; "Kid, I want you out of town by sundown!"
			)
			(4
				(gGame handsOn: setCursor: 996 1)
				(gTheIconBar disable: 0 1 2 3 4 6 7)
				(= local1 1)
				(= seconds (Random 2 5))
			)
			(5
				(= local1 0)
				(kenny setCycle: CT 6 1 self)
			)
			(6
				(gunShot play:)
				(kenny setCycle: End self)
			)
			(7
				(gTheIconBar enable:)
				(gCurRoom newRoom: 565)
				(self dispose:)
			)
		)
	)
)

(instance sTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gunShot play:)
				(= cycles 5)
				(hand2 dispose:)
				(gun2 dispose:)
			)
			(1
				(gMessager say: 16 0 0 0 self) ; MISSING MESSAGE
			)
			(2
				(hand2 init:)
				(gun2 init:)
				(self dispose:)
			)
		)
	)
)

(instance hand1 of Prop
	(properties
		x 38
		y 26
		view 560
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance hand2 of Prop
	(properties
		x 278
		y 26
		view 560
		cel 1
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance gun1 of Prop
	(properties
		x 61
		y 66
		view 560
		loop 3
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance gun2 of Prop
	(properties
		x 246
		y 68
		view 560
		loop 3
		cel 1
	)

	(method (handleEvent event)
		(event claimed: 1)
	)
)

(instance kenny of Actor
	(properties
		view 560
	)

	(method (doVerb theVerb)
		(= local0 cel)
		(switch theVerb
			(47 ; Pistols
				(cond
					(mover
						(self setScript: sTooSoon)
					)
					((== loop 2)
						(if (<= local0 6)
							(SetFlag 60)
							(hand2 dispose:)
							(gun2 dispose:)
							(gunShot play:)
						)
					)
					(else
						(gMessager say: 15) ; "Your respect for frontier etiquette won't let you draw first. Wait 'till you see Kenny start to draw, then do your best!"
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gunShot of FPSound
	(properties
		flags 1
		number 2124
	)
)

