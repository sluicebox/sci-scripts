;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	sPlugCharger 0
	sUnplugCharger 1
	sGetShocked 2
	charger 3
)

(local
	[chargerCoords 7] = [160 64 108 260 19 146 0]
)

(instance sPlugCharger of Script
	(properties)

	(method (changeState newState &tmp i)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(= i 0)
				(while (!= [chargerCoords i] 0)
					(if (== [chargerCoords i] gCurRoomNum)
						(charger
							x: [chargerCoords (++ i)]
							y: [chargerCoords (++ i)]
							init:
							setLoop: 3
						)
						(break)
					else
						(+= i 3)
					)
				)
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(3
				(gEgo put: 1 gCurRoom setLoop: 1 normalize:) ; Battery_Charger
				(Points 8 65)
				(TPrint 22 0) ; "Cleverly spotting an empty electrical outlet, you bend down and stick your battery charger in the socket."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sPlugCamcorder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(2
				(charger setLoop: 4)
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(3
				(gEgo put: 0 (Inv at: 1) setLoop: 1 normalize:) ; Camcorder, Battery_Charger
				(charger approachVerbs: 3 4 2) ; Do, Inventory, Look
				(Points 3 66)
				(TPrint 22 1) ; "Bending over, you insert your Pocket Camcorder into the battery charger and watch the "Charging" lamp illuminate."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sUnplugCharger of Script
	(properties)

	(method (changeState newState &tmp n)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 161
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
			)
			(1
				(charger dispose:)
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(2
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(3
				(gEgo get: 1 get: 0 setLoop: 1 normalize:) ; Battery_Charger, Camcorder
				((Inv at: 0) owner: 23) ; Camcorder
				(Points 1 67)
				(if (== (charger loop:) 4)
					(TPrint 22 2) ; "You bend down and remove your battery charger and camcorder from the electrical socket."
				else
					(TPrint 22 3) ; "You bend down and remove your battery charger from the electrical socket."
				)
				(HandsOn)
				(= n (* 300 (/ gCamcorderCharge 20)))
				(gChargeTimer setReal: gChargeTimer (/ n 100))
				(self dispose:)
			)
		)
	)
)

(instance sGetShocked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: (gEgo x:) (- (gEgo y:) 2)
					view: 560
					setLoop: 0
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(1
				(shockSound number: 561 setLoop: 1 play:)
				(gEgo setPri: 13 setLoop: 1 setCycle: Fwd)
				(= cycles (Random 25 40))
			)
			(2
				(shockSound number: 147 play:)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 2 normalize:)
				(= ticks 60)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shockSound of Sound
	(properties
		number 561
	)
)

(instance charger of View
	(properties
		description {the battery charger}
		view 161
		loop 3
	)

	(method (init)
		(super init:)
		(self approachVerbs: 3 4 signal: (&= signal $fffe)) ; Do, Inventory
		(= approachX (+ x 12))
		(= approachY (+ y 1))
	)

	(method (doVerb theVerb invItem &tmp [str 50])
		(switch theVerb
			(2 ; Look
				(if (== ((Inv at: 0) owner:) (Inv at: 1)) ; Camcorder, Battery_Charger
					(Format @str 22 4 (/ gCamcorderCharge 20) 37) ; "Battery Strength: %d%c"
					(TPrint @str #mode 1 #title {Camcorder Battery Strength})
				else
					(TPrint 22 5) ; "Your lonely battery charger sits all by itself, with plenty of power to suck from the wall, but with no place to push it!"
				)
			)
			(3 ; Do
				(gCurRoom setScript: sUnplugCharger)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Camcorder
						(gCurRoom setScript: sPlugCamcorder)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(10 ; Zipper
				(TPrint 22 6) ; "You want to stick it where?!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

