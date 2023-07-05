;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm020 0
)

(local
	[local0 18] = [0 0 69 0 218 85 191 122 173 137 89 133 84 143 25 170 0 170]
	[local18 26] = [0 185 106 164 155 168 212 184 279 157 231 131 231 119 217 102 249 88 226 74 319 0 319 189 0 189]
)

(instance rm020 of KQ5Room
	(properties
		picture 20
		horizon 90
		north 21
		west 26
	)

	(method (init &tmp temp0)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 227 91)
			)
			(208 ; releaseGenie
				(gEgo posn: global110 global111 view: 0)
				(NormalEgo 0 0)
			)
			(else
				(gEgo posn: 13 185)
			)
		)
		(self
			setFeatures: path20 forest
			setRegions: 200 551 552 ; witchRegion, toadRegion, spiderRegion
			addObstacle: poly1 poly2
		)
		(toad setScript: toadScript init:)
		(gEgo init:)
		(poly1 points: @local0 size: 9)
		(poly2 points: @local18 size: 13)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(self setScript: (ScriptID 200 1) 0 (gEgo edgeHit:)) ; poofOutScript
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance toadScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 12))
			)
			(1
				(toad
					posn: 62 189
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 271 152 self
				)
			)
			(2
				(= seconds (Random 3 12))
			)
			(3
				(toad setMotion: MoveTo 127 134 self)
			)
			(4
				(client setScript: 0 dispose:)
			)
		)
	)
)

(instance path20 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 20 0) ; "The rocky, rutted footpath staggers its way through the oppressive forest to the north or to the west."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance forest of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 20 1) ; "The pervasive gloom of the forest settles around Graham like a tight, suffocating blanket. All around he can hear the eerie sounds of strange creatures."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance toad of Actor
	(properties
		view 459
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if (== (self cel:) 1)
			(gGlobalSound4 number: (Random 99 100) loop: 1 vol: 127 play:)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 20 2) ; "It seems to Graham that there is an unusually large number of toads in this forest."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 20 3) ; "These toads look too repulsive to catch!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

