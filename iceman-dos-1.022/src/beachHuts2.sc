;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use n954)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	beachHuts2 0
)

(local
	[local0 2]
	[local2 14] = [0 0 0 0 0 142 179 179 163 111 97 99 104 109]
	[local16 14] = [81 105 117 170 181 81 162 173 173 162 168 147 148 147]
	[local30 14] = [141 141 141 96 178 319 319 319 178 179 110 105 109 141]
	[local44 14] = [104 116 147 173 189 160 173 189 179 173 173 151 156 160]
	[local58 14] = [148 148 148 102 184 153 178 190 175 110 116 148 148 152]
	[local72 14] = [104 112 146 172 185 163 166 172 172 167 172 148 155 154]
)

(instance beachHuts2 of Rm
	(properties
		picture 5
		horizon 80
		north 7
		east 4
		south 8
		west 8
		vanishingX 0
		vanishingY -50
	)

	(method (init)
		(if (== gPrevRoomNum west)
			((User alterEgo:) edgeHit: EDGE_NONE)
		)
		(super init:)
		(gEgo init:)
		(self
			setRegions: 301 300 ; Water, tahiti
			setFeatures:
				Door__6
				hutWindow
				jungleFeature
				oceanFeature
				beachViewFeature
				horizonFeat
				otherHutDoor
				((Clone hutWindow)
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
		)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 310 170)
			)
			(6 ; inEgosHut
				(if (> (gEgo x:) 90)
					(gEgo posn: 110 167 loop: 0)
				else
					(gEgo posn: 13 172 loop: 0)
				)
			)
			(else
				(gEgo posn: 120 82)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'look>') (Said '[<around,at][/beach]'))
				(switch (Random 1 5)
					(1
						(Print 5 0) ; "Nice beach!"
					)
					(2
						(Print 5 1) ; "We should be close to Johnny's hut."
					)
					(else
						(Print 5 2) ; "This is the beach with Johnny's hut."
					)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (> (gEgo y:) 198) (> (gEgo x:) 100))
				(self newRoom: 4) ; beachHuts1
			)
			((== (gEgo onControl: 1) 32)
				(self newRoom: 6) ; inEgosHut
			)
		)
	)
)

(instance Door__6 of RFeature
	(properties
		name {Door #6}
		y 142
		x 93
		heading 909
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
					((TurnIfSaid self event))
					((Said 'look[<at]')
						(Print 5 3) ; "This is the door to your hut, #6"
					)
					((Said 'open,unlock')
						(if (gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(HandsOff)
							(gEgo setScript: openDoorScript)
						else
							(Print 5 4) ; "You don't have the key."
						)
					)
					((or (Said 'lock') (Said 'lock<to<key<use'))
						(Print 5 5) ; "It's already locked."
					)
					((Said 'knock')
						(Print 5 6) ; "There is no response."
					)
				)
			)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp1 0)
				(for ((= temp0 0)) (< temp0 14) ((++ temp0))
					(if
						(gEgo
							inRect:
								[local2 temp0]
								[local16 temp0]
								[local30 temp0]
								[local44 temp0]
						)
						(gEgo
							setMotion:
								MoveTo
								[local58 temp0]
								[local72 temp0]
								self
						)
						(= temp1 1)
					)
				)
				(if (not temp1)
					(HandsOn)
					(gCurRoom newRoom: 6) ; inEgosHut
				)
			)
			(1
				(if (and (== (gEgo x:) 110) (== (gEgo y:) 167))
					(HandsOn)
					(gCurRoom newRoom: 6) ; inEgosHut
				else
					(self init:)
				)
			)
		)
	)
)

(instance otherHutDoor of RFeature
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
						(Print 5 7) ; "This is the door to Hut #7."
					)
					((Said 'open,unlock')
						(Print 5 8) ; "This isn't your hut."
					)
					((Said 'knock')
						(Print 5 9) ; "Don't bother."
					)
					((or (Said 'lock') (Said 'lock<to<key<use'))
						(Print 5 5) ; "It's already locked."
					)
				)
			)
		)
	)
)

(instance hutWindow of RFeature
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
					((Said 'look[<at]')
						(Print 5 10) ; "A hut window."
					)
					((Said 'look<in,through')
						(Print 5 11) ; "The reflection on the window prevents you from looking in."
					)
				)
			)
			((Said 'look[<in]/building')
				(Print 5 11) ; "The reflection on the window prevents you from looking in."
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
						(Print 5 12) ; "You see the dense Tahitian jungle."
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
			((and (Said 'look[<at]>') (Said '[/beach]'))
				(Print 5 13) ; "You see more beachfront bungalows further up the beach."
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
			((Said 'look[<at]>')
				(cond
					((TurnIfSaid self event '[/water,bay]/*'))
					((Said '[/water,bay]')
						(Print 5 14) ; "You see the beautiful Tahitian waters."
					)
				)
			)
		)
	)
)

(instance horizonFeat of Feature
	(properties
		y 55
		x 95
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/horizon]')
				(Print 5 15) ; "You can see the long beach stretching off towards the horizon."
			)
		)
	)
)

