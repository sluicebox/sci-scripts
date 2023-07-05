;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use Feature)

(public
	rm25 0
)

(instance rm25 of SQRoom
	(properties
		lookStr {This looks like it might have been a minimally developed, manipulative appendage for the fallen and fossilized beast.}
		picture 25
		horizon 20
		north 22
		east 26
		south 18
		west 38
		walkOffTop 1
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 276 0 269 17 226 29 170 29 146 14 127 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 232 137 182 134 125 118 38 76 51 65 30 63 51 52 275 52 309 94 277 108 233 93 231 87 205 84 179 96 222 93 247 103 249 127
					yourself:
				)
		)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(HandsOn)
			)
			(north
				(= style 13)
				(HandsOn)
			)
			(south
				(gEgo x: 160)
				(= style 10)
			)
			(else
				(= style 10)
			)
		)
		(gEgo init:)
		(self setRegions: 704) ; keronaRegion
		((ScriptID 704 1) x: 47 y: 56 approachX: 42 approachY: 56) ; plant
		(super init:)
		(if (> 72 (gEgo y:) 49)
			(gEgo y: 51)
		)
		(claws init:)
	)
)

(instance claws of Feature
	(properties
		description {claws}
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 25 0) ; "Check out the claws on this sucker. We're talking major manicure action. Can't you imagine what it must have been like to serve as one of many hundreds of live meals the gigundasaurus must have shredded and refined internally in it's lifetime."
				(Print 25 1) ; "Can't you just feel the points of those talon-like claws slowly pressing through the thin outer-armour we call skin, popping through and separating ribs, and pushing aside anything it didn't pierce on the way, only to meet mid-torso."
			)
			(3 ; Do
				(Print 25 2) ; "The claws are much too large - not to mention much too deep in the sand - for you to do anything with."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

