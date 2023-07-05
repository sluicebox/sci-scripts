;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Game)

(public
	TrollCave74 0
)

(instance TrollCave74 of Rm
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
		(gEgo view: 4 xStep: 4 yStep: 1)
		(switch gPrevRoomNum
			(75 ; TrollCave75
				(gEgo posn: 295 168 init:)
			)
			(else
				(gEgo posn: 109 85 init:)
			)
		)
		(gEgo priority: (CoordPri (gEgo y:)))
		(Notify 605 1)
	)
)

