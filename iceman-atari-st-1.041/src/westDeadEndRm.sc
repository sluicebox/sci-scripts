;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use scubaRg)
(use Motion)
(use Game)
(use System)

(public
	westDeadEndRm 0
)

(instance westDeadEndRm of Rm
	(properties
		picture 57
		north 999
		east 56
		south 51
	)

	(method (init)
		(super init:)
		(self setRegions: 305) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(56 ; caveEntranceRm
				(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
			)
			(else
				(gEgo setScript: fromTheDeep)
			)
		)
		(proc305_2 8 205 103 6)
		(proc305_2 8 179 128 9)
		(proc305_2 6 41 103 6)
		(proc305_2 6 276 85 5)
		(proc305_2 8 317 147 10)
		(proc305_2 7 105 92 5)
		(proc305_2 5 237 96 6)
		(proc305_2 8 119 100 6)
		(proc305_2 8 86 116 8)
		(proc305_1 2 1 303 142)
		(proc305_1 4 1 289 140)
		(proc305_1 1 4 218 145 0)
		(proc305_1 1 4 192 143 0)
		(proc305_1 1 4 22 118 0)
		(proc305_1 1 4 57 132 0)
		(proc305_1 1 4 95 104 0)
		(proc305_1 1 4 184 117 0)
		(gAddToPics doit:)
	)
)

(instance fromTheDeep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 175 148 loop: 3 setMotion: MoveTo 175 136 self)
			)
			(1
				(gEgo setMotion: MoveTo 325 136)
			)
		)
	)
)

