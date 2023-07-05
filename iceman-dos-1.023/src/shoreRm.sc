;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use scubaRg)
(use Motion)
(use Game)

(public
	shoreRm 0
)

(instance shoreRm of Rm
	(properties
		picture 54
		north 999
		east 61
		south 51
		west 53
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(61 ; tunisBeachRm
				(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
			)
			(53 ; antiSubNetRm
				(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
			)
			(else
				(gEgo posn: 199 185 loop: 3 setMotion: MoveTo 199 -5)
			)
		)
		(proc305_1 3 0 147 97 6)
		(proc305_1 1 0 49 146 10)
		(proc305_1 1 0 83 84)
		(proc305_1 3 1 25 132 9)
		(proc305_1 2 2 162 158 12)
		(proc305_1 2 0 265 184 14)
		(proc305_1 4 1 118 156 11)
		(proc305_2 5 176 154 11)
		(proc305_2 6 79 165 12)
		(proc305_2 6 22 185 14)
		(proc305_2 6 284 179 14)
		(proc305_2 8 283 106 7)
		(proc305_2 8 319 104 6)
		(proc305_2 8 79 158 11)
		(proc305_2 8 130 93 5)
		(proc305_2 8 285 81 4)
		(proc305_2 6 259 79 4)
		(proc305_2 6 177 93 5)
		(proc305_2 5 55 77 4)
		(gAddToPics doit:)
	)
)

