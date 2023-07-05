;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use eRS)
(use Polygon)
(use Feature)

(public
	rm26 0
)

(instance rm26 of SQRoom
	(properties
		lookStr {This is just south of the gigundasaurus remains. Ligament jerky-deep in the joints is all that holds some of these incredibly huge skeletal components together.}
		picture 26
		horizon 20
		north 23
		east 27
		south 18
		west 25
		walkOffTop 1
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 -10 319 52 269 59 246 86 286 114 314 132 309 154 291 163 267 163 230 140 253 132 190 102 177 86 223 22 113 22 83 -10
					yourself:
				)
		)
		(switch gPrevRoomNum
			(east
				(= style 11)
				(HandsOn)
			)
			(west
				(= style 12)
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
		(sand init:)
		(self setRegions: 704) ; keronaRegion
		((ScriptID 704 1) x: 171 y: 89 approachX: 166 approachY: 89) ; plant
		(super init:)
	)

	(method (doit)
		(if (& (gEgo onControl: 1) $4000)
			(gEgo setPri: 10)
		else
			(gEgo setPri: -1)
		)
		(super doit: &rest)
	)
)

(instance sand of Feature
	(properties
		description {sand}
		onMeCheck 16384
		lookStr {The sand of Kerona has a reddish-orange color to it. Were you a geologist instead of a janitor, you might find this fact interesting.}
	)
)

