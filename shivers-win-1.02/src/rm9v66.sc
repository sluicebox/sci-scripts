;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9660)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm9v66 0
)

(instance rm9v66 of ShiversRoom
	(properties
		picture 9660
	)

	(method (init)
		(if (IsFlag 42)
			((Prop new:)
				view: 9660
				setPri: 5 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
		else
			((Prop new:) view: 9660 setPri: 5 1 loop: 0 init:)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 1550) ; rm1v550
			(proc951_7 20903)
			(proc951_9 20903)
			(gSounds play: 20903 -1 0 0)
			(gSounds fade: 20903 42 5 16 0 0)
			(gSounds stop: 11602)
			(gSounds play: 11602 0 82 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9670
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9160
	)

	(method (init)
		(self
			createPoly:
				92
				141
				93
				132
				114
				127
				76
				99
				74
				42
				156
				44
				212
				93
				233
				88
				233
				110
				229
				115
				229
				124
				238
				124
				238
				145
		)
		(super init: &rest)
	)
)

