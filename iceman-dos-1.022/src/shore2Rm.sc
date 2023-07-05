;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use scubaRg)
(use Motion)
(use Game)

(public
	shore2Rm 0
)

(instance shore2Rm of Rm
	(properties
		picture 55
		north 999
		east 53
		south 51
		west 56
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init: observeControl: 1024)
		(switch gPrevRoomNum
			(56 ; caveEntranceRm
				(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
			)
			(53 ; antiSubNetRm
				(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
			)
			(else
				(gEgo posn: 122 185 loop: 3 setMotion: MoveTo 122 -5)
			)
		)
		(proc305_2 6 121 131 9)
		(proc305_2 5 148 129 9)
		(proc305_2 5 194 127 9)
		(proc305_2 7 271 125 8)
		(proc305_2 7 48 179 14)
		(proc305_2 6 31 105 6)
		(proc305_2 5 74 106 7)
		(proc305_2 6 231 71 3)
		(proc305_2 5 183 72 3)
		(proc305_2 5 44 78 4)
		(proc305_1 0 0 230 125 8)
		(proc305_1 0 1 260 129 9)
		(proc305_1 0 2 205 137 10)
		(proc305_1 2 2 296 130 9)
		(proc305_1 1 0 290 85 5)
		(proc305_1 3 0 35 179 14)
		(gAddToPics doit:)
	)
)

