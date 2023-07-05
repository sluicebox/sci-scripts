;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Game)
(use Actor)

(public
	rm026 0
)

(local
	local0
	[local1 10] = [33 153 34 169 160 160 236 147 165 138]
	[local11 8] = [0 187 319 187 319 189 0 189]
	[local19 18] = [0 144 19 138 174 125 190 111 172 101 180 65 186 57 66 0 0 0]
	[local37 18] = [319 127 222 126 200 108 216 96 204 93 187 76 199 62 186 44 319 0]
)

(instance rm026 of Rm
	(properties
		picture 26
		horizon 90
		north 22
		east 20
		west 25
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 312 141)
			)
			(north
				(gEgo posn: 185 92)
			)
			(208 ; releaseGenie
				(gEgo posn: global110 global111 view: 0)
				(NormalEgo 0 0)
			)
			(else
				(gEgo posn: 8 163)
			)
		)
		(self
			setFeatures: path26 house forest
			setRegions: 200 551 552 ; witchRegion, toadRegion, spiderRegion
			addObstacle: poly1 poly2 poly3 poly4
		)
		(gEgo view: 0 offset: 3 ignoreHorizon: 1 init:)
		(poly1 points: @local1 size: 5)
		(poly2 points: @local11 size: 4)
		(poly3 points: @local19 size: 9)
		(poly4 points: @local37 size: 9)
	)

	(method (doit &tmp temp0)
		(if (< (gEgo y:) 110)
			(gEgo setPri: 6)
		else
			(gEgo setPri: -1)
		)
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

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance path26 of RFeature
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
					(PrintDC 26 0) ; "A root-rutted path stumbles its way east, west, and north through the dark and gloomy forest."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance house of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 26 1) ; "Through the gloom of the forest, Graham can barely make out a small, house-like form to the north."
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setMotion: PolyPath 186 49)
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
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 26 2) ; "The dark forest seems to close in on Graham as he makes his tentative way through it."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance toads of Act ; UNUSED
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 26 3) ; "It seems to Graham that there is an unusually large number of toads in this forest."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local0)
						(++ local0)
						(PrintDC 26 4) ; "These toads look too repulsive to catch!"
						(event claimed: 1)
					)
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

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

