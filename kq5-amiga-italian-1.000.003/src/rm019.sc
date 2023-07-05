;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5Room)
(use Polygon)
(use RFeature)

(public
	rm019 0
)

(local
	[local0 14] = [0 88 11 88 15 128 113 170 143 175 141 189 0 189]
	[local14 24] = [0 74 0 0 319 0 319 68 278 88 240 98 237 113 164 133 103 135 75 113 46 109 42 78]
	[local38 10] = [200 189 186 154 293 100 319 100 319 189]
)

(instance rm019 of KQ5Room
	(properties
		picture 19
		east 20
		south 8
		west 25
	)

	(method (init)
		(super init:)
		(HandsOn)
		(self
			setFeatures: path19 forest
			setRegions: 551 200 ; toadRegion, witchRegion
			addObstacle: poly1 poly2 poly3
		)
		(if (not (IsFlag 44))
			(SetFlag 44)
			(SetScore 2)
		)
		(gEgo posn: 170 187)
		(gEgo init:)
		(poly1 points: @local0 size: 7)
		(poly2 points: @local14 size: 12)
		(poly3 points: @local38 size: 5)
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
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(if (== temp0 8)
					(gGlobalSound fade:)
				)
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

(instance path19 of RFeature
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
					(Print 19 0) ; "Numerous roots, rocks, and ruts choke the narrow forest path which branches either to the right or to the left."
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
					(Print 19 1) ; "Ensnarling roots, creeping vines, decaying logs, and twisted, gnarled trees...the close feeling of the gloomy forest quickly overwhelms Graham."
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

