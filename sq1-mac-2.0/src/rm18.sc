;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use eRS)

(public
	rm18 0
)

(instance rm18 of SQRoom
	(properties
		lookStr {In the distance stand the skeletal remains of of a massive beast of some type, the likes of which you never saw on Xenon. You hope it's a one of a kind relic.}
		picture 18
		style 8
		horizon 161
		east 138
		south 38
		west 338
	)

	(method (init)
		(switch gPrevRoomNum
			(west
				(gEgo y: 166 init:)
			)
			(east
				(gEgo y: 166 init:)
			)
			(south
				(gEgo x: 160 init:)
			)
			(else
				(= north gPrevRoomNum)
				(gEgo
					x:
						(switch north
							(25 54)
							(26 160)
							(27 275)
						)
					init:
				)
			)
		)
		(self setRegions: 704) ; keronaRegion
		(super init:)
	)

	(method (doit)
		(= north
			(cond
				((<= (gEgo x:) horizon) 25)
				((>= (gEgo x:) 212) 27)
				(else 26)
			)
		)
		(super doit:)
	)
)

