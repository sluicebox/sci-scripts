;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v410 0
)

(instance rm10v410 of ShiversRoom
	(properties
		picture 10410
	)

	(method (init)
		(if (== gPrevRoomNum 10142) ; rm10v142
			(gSounds play: 11020 0 82 0)
		)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efReportCard init: 3)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10420
	)

	(method (init)
		(self
			createPoly:
				78
				142
				78
				69
				86
				50
				111
				30
				135
				25
				166
				36
				192
				66
				192
				142
				149
				142
				149
				130
				161
				130
				161
				121
				146
				117
				135
				117
				135
				125
				149
				131
				149
				142
				78
				142
		)
		(super init: &rest)
	)
)

(instance efReportCard of ExitFeature
	(properties
		nextRoom 10142
	)

	(method (init)
		(self createPoly: 143 120 137 121 150 128 157 124 144 120)
		(super init: &rest)
	)
)

