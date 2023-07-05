;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Game)

(public
	Room74 0
)

(instance Room74 of Rm
	(properties
		picture 74
		style 16
		horizon 65
		north 71
	)

	(method (init)
		(super init:)
		(self setRegions: 605) ; regTroll
		(= gIndoors 1)
		(= east 75)
		(gEgo view: 904 xStep: 4 yStep: 1)
		(switch gPrevRoomNum
			(75
				(gEgo posn: 295 167 init:)
			)
			(else
				(gEgo posn: 109 84 init:)
			)
		)
		(gEgo priority: (CoordPri (gEgo y:)))
		(Notify 605 1)
	)
)

