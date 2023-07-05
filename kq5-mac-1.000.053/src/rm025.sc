;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)

(public
	rm025 0
)

(local
	local0
	[local1 20] = [0 56 36 56 38 66 70 83 77 106 70 131 156 172 319 173 319 189 0 189]
	[local21 20] = [76 62 76 0 319 0 319 136 184 133 131 124 125 114 192 104 197 86 106 86]
	[local41 10] = [309 133 187 131 133 122 129 115 281 93]
)

(instance rm025 of KQ5Room
	(properties
		picture 25
		north 24
		east 26
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 55 69)
			)
			(208 ; releaseGenie
				(gEgo posn: global110 global111 view: 0)
				(NormalEgo 0 0)
			)
			(else
				(gEgo posn: 311 153)
			)
		)
		(self setFeatures: path25 forest setRegions: 200 551 552) ; witchRegion, toadRegion, spiderRegion
		(gEgo init:)
		(poly1 points: @local1 size: 10)
		(poly2 points: @local21 size: 10)
		(poly3 points: @local41 size: 5)
		(self addObstacle: poly1 poly2 poly3)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(self setScript: (ScriptID 200 1) 0 (gEgo edgeHit:)) ; poofOutScript
			)
			((& (gEgo onControl: 0) $4000)
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(self setScript: (ScriptID 200 1) 0 1) ; poofOutScript
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

(instance path25 of RFeature
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
					(PrintDC 25 0) ; "A path, tangled with roots and vines, leads to the north and east through the dense foliage of the dark forest."
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
					(PrintDC 25 1) ; "Unseen eyes seem to watch Graham as he stumbles confusedly through the thick maze of the gloomy forest."
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

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

