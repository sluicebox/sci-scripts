;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Game)

(public
	TrollCave75 0
)

(instance TrollCave75 of Rm
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
		(gEgo view: 4 xStep: 4 yStep: 1)
		(switch gPrevRoomNum
			(72 ; TrollCave72
				(gEgo posn: 132 84 init:)
			)
			(74 ; TrollCave74
				(gEgo posn: 10 168 init:)
			)
			(else
				(gEgo posn: 307 164 init:)
			)
		)
		(gEgo priority: (CoordPri (gEgo y:)))
		(Notify 605 1)
	)
)

