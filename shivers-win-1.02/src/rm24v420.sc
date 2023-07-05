;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24420)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm24v420 0
)

(instance rm24v420 of ShiversRoom
	(properties
		picture 24420
	)

	(method (init)
		(if (IsFlag 67)
			(= picture 24421)
			(if (!= [global118 31] 0)
				(vPotView init:)
			)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (and (proc951_11 1 24000) (!= gPrevRoomNum 24360)) ; rm24v360
			(proc951_9 20803)
			(gSounds play: 20803 -1 0 0)
			(gSounds fade: 20803 50 5 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 24360) (proc951_11 1 24000)) ; rm24v360
			(gSounds fade: 20803 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vPotView of View
	(properties
		x 32
		y 141
		view 0
	)

	(method (init)
		(self view: [global118 31] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 42 scaleY: 42 setPri: 10)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24360
	)

	(method (init)
		(self createPoly: 228 0 228 49 174 118 174 144 262 144 262 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24355
	)
)

