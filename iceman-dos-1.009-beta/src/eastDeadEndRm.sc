;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use scubaRg)
(use Motion)
(use Game)

(public
	eastDeadEndRm 0
)

(instance eastDeadEndRm of Rm
	(properties
		picture 58
		north 999
		south 51
		west 61
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(61 ; tunisBeachRm
				(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
			)
			(else
				(gEgo posn: 61 180 loop: 3 setMotion: MoveTo 61 -5)
			)
		)
		(proc305_2 5 61 102 6)
		(proc305_2 6 218 128 9)
		(proc305_2 6 232 97 6)
		(proc305_2 5 189 103 6)
		(proc305_2 7 251 139 10)
		(proc305_2 6 18 85 5)
		(proc305_2 6 76 87 5)
		(proc305_2 6 113 103 6)
		(proc305_1 0 0 222 102 5)
		(proc305_1 1 3 215 96 5)
		(proc305_1 1 3 277 105 6)
		(proc305_1 1 2 73 103 6)
		(proc305_1 3 1 296 115 7)
		(proc305_1 3 0 236 135 9)
		(proc305_1 3 2 149 141 10)
		(proc305_1 1 3 184 101 6)
		(proc305_1 1 4 250 109 0)
		(proc305_1 1 4 167 121 0)
		(proc305_1 1 4 206 138 0)
		(gAddToPics doit:)
	)
)

