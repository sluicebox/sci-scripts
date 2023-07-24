;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v030 0
)

(instance rm17v030 of ShiversRoom
	(properties
		picture 17030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (proc951_11 9 17000)
			(proc951_7 21111)
			(gSounds play: 21111 -1 32 0)
		)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11712 0 32 0)
			(ClearFlag 43)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 17000) (!= newRoomNumber 17090)) ; rm17v090
			(gSounds fade: 21111 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17090
	)

	(method (init)
		(self
			createPoly: 94 143 92 98 98 93 115 86 114 75 123 68 121 57 125 49 145 49 154 62 153 69 166 70 161 76 164 82 179 97 178 145
		)
		(super init: &rest)
	)
)

