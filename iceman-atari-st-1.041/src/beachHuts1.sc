;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use n824)
(use n954)
(use LoadMany)
(use RFeature)
(use Game)
(use User)
(use Actor)

(public
	beachHuts1 0
)

(local
	local0
)

(instance beachHuts1 of Rm
	(properties
		picture 4
		east 3
		south 8
		west 8
		vanishingX 0
		vanishingY -50
	)

	(method (init)
		(if (== gPrevRoomNum west)
			((User alterEgo:) edgeHit: 0)
		)
		(super init:)
		(LoadMany rsVIEW 200 206)
		(switch gPrevRoomNum
			(east
				(switch (gEgo view:)
					(214
						(gEgo posn: 192 185 loop: 3)
					)
					(215
						(gEgo posn: 170 185 loop: 3)
					)
					(216
						(gEgo posn: 100 185 loop: 3)
					)
					(else
						(gEgo posn: 310 166)
					)
				)
			)
			(5 ; beachHuts2
				(gEgo
					posn: 86 95
					view: (if (== (gEgo view:) 206) 206 else 200)
				)
			)
		)
		(gEgo init:)
		(self
			setRegions: 301 300 ; Water, tahiti
			setFeatures:
				islanderHutDoor
				hutDoor
				jungleFeature
				oceanFeature
				beachViewFeature
				window1
				((Clone window1)
					x: 64
					y: 76
					nsLeft: 47
					nsTop: 67
					nsRight: 81
					nsBottom: 86
					yourself:
				)
				((Clone jungleFeature) x: 175 y: 60)
				((Clone jungleFeature) x: 130 y: 60)
				((Clone jungleFeature) x: 80 y: 60)
		)
		(proc824_0)
	)

	(method (doit)
		(super doit:)
		(switch (gEgo onControl: 1)
			(8192
				(self newRoom: 5) ; beachHuts2
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber south) (> (gEgo x:) 80))
			(super newRoom: 3) ; volleyRm
			(gEgo loop: 0)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'look[<at,around]>') (Said '/room,hotel,building'))
				(Print 4 0) ; "The beachfront bungalows look comfortable."
			)
		)
	)
)

(instance islanderHutDoor of RFeature
	(properties
		y 142
		x 93
		heading 90
		nsTop 120
		nsLeft 89
		nsBottom 164
		nsRight 97
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event '*/*'))
					((Said 'look[<at]')
						(Print 4 1) ; "This is the door to Hut #4."
					)
					((Said 'open,unlock')
						(Print 4 2) ; "This isn't your hut."
					)
					((Said 'knock')
						(Print 4 3) ; "Don't bother."
					)
				)
			)
		)
	)
)

(instance hutDoor of RFeature
	(properties
		y 87
		x 83
		heading 90
		nsTop 67
		nsLeft 82
		nsBottom 107
		nsRight 85
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event '*/*'))
					((Said 'look[<at]')
						(Print 4 4) ; "This is the door to Hut #5."
					)
					((Said 'open,unlock')
						(Print 4 2) ; "This isn't your hut."
					)
					((Said 'knock')
						(Print 4 3) ; "Don't bother."
					)
				)
			)
		)
	)
)

(instance window1 of RFeature
	(properties
		y 131
		x 44
		heading 180
		nsTop 120
		nsBottom 143
		nsRight 88
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event '*/*'))
					((Said 'look[<at]')
						(Print 4 5) ; "A hut window."
					)
					((Said 'look<in')
						(Print 4 6) ; "The reflection on the window prevents you from looking in."
					)
				)
			)
		)
	)
)

(instance jungleFeature of Feature
	(properties
		y 60
		x 300
		heading 235
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bush]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 4 7) ; "You see the dense Tahitian jungle."
					)
				)
			)
		)
	)
)

(instance beachViewFeature of Feature
	(properties
		y 160
		x 315
		heading 315
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/beach]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 4 8) ; "You see the hotel and volleyball areas further up the beach."
					)
				)
			)
		)
	)
)

(instance oceanFeature of Feature
	(properties
		y 186
		x 254
		heading 35
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/water,bay]')
				(Print 4 9) ; "You see the beautiful Tahitian waters."
			)
		)
	)
)

