;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use Game)

(public
	TrollCave72 0
)

(instance TrollCave72 of Rm
	(properties
		picture 72
		style 16
	)

	(method (init)
		(self setRegions: 605) ; regTroll
		(super init:)
		(= gIndoors 1)
		(= south 75)
		(gEgo view: 4 xStep: 4 yStep: 1)
		(if (== gPrevRoomNum 75) ; TrollCave75
			(gEgo posn: 160 173 init:)
		else
			(gEgo posn: 85 95 init:)
		)
		(gEgo priority: (CoordPri (gEgo y:)))
		(Notify 605 1)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(= gNewRoomNum 71) ; TrollEnter
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

