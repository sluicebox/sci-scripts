;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use Interface)
(use scubaRg)
(use Motion)
(use Game)
(use Actor)

(public
	tunisBeachRm 0
)

(instance tunisBeachRm of Rm
	(properties
		picture 61
		east 58
		south 51
		west 54
	)

	(method (init)
		(super init:)
		(self setFeatures: pierPilings setRegions: 305) ; scubaRg
		(gEgo init:)
		(switch gPrevRoomNum
			(54 ; shoreRm
				(gEgo x: 10 loop: 0 setMotion: MoveTo 325 (gEgo y:))
			)
			(58 ; eastDeadEndRm
				(gEgo x: 310 loop: 1 setMotion: MoveTo -5 (gEgo y:))
			)
			(else
				(gEgo posn: 172 180 loop: 3 setMotion: MoveTo 172 -5)
			)
		)
		(proc305_2 6 192 84 4)
		(proc305_2 6 293 93 5)
		(proc305_2 7 272 128 9)
		(proc305_2 7 97 105 6)
		(proc305_2 6 53 107 7)
		(proc305_2 7 26 149 11)
		(proc305_2 5 80 142 11)
		(proc305_2 6 7 182 14)
		(proc305_2 8 315 134 9)
		(proc305_1 2 0 139 94)
		(proc305_1 2 0 44 149)
		(proc305_1 0 0 10 133)
		(proc305_1 0 0 23 178)
		(proc305_1 1 0 263 94)
		(proc305_1 3 0 278 126)
		(proc305_1 2 2 214 86)
		(proc305_1 0 2 313 135)
		(proc305_1 1 4 308 133 0)
		(gAddToPics doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 61 0) ; "You see heavy brush and old rotten pier pilings."
				(Print 61 1) ; "You think to yourself, "This looks like the area that was described in the briefing.""
			)
			((Said 'surface')
				(Print 61 2) ; "You swim to the surface and just before getting out of the water you conceal your scuba equipment."
			)
			((Said 'secure/diver')
				(Print 61 3) ; "You will need to find a better spot."
			)
		)
	)
)

(instance pierPilings of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'secure/diver')
				(Print 61 4) ; "You wedge the DV-3X vehicle under the heavy brush and secure it."
			)
		)
	)
)

