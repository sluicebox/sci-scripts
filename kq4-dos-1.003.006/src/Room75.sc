;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Game)

(public
	Room75 0
)

(instance Room75 of Rm
	(properties
		picture 75
		style 16
		horizon 65
		north 72
	)

	(method (init)
		(self setRegions: 605) ; regTroll
		(super init:)
		(= gIndoors 1)
		(= west 74)
		(= east 76)
		(gEgo view: 904 xStep: 4 yStep: 1)
		(switch gPrevRoomNum
			(72
				(gEgo posn: 132 83 init:)
			)
			(74
				(gEgo posn: 10 167 init:)
			)
			(else
				(gEgo posn: 307 163 init:)
			)
		)
		(gEgo priority: (CoordPri (gEgo y:)))
		(Notify 605 1)
	)
)

