;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1490)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Actor)
(use System)

(public
	rm1490 0
)

(instance rm1490 of PQRoom
	(properties
		picture 1490
	)

	(method (init)
		(if (!= 10305 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10305)
			(gBackMusic number: 10305 loop: -1 play:)
			(Lock rsAUDIO 10305 1)
		)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25 14902)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 1460 15 8) ; mainMenu, sierraLogo
			(rightSide init: setPri: 420)
			(gCurRoom setScript: enterFrom1460)
		)
	)
)

(instance enterFrom1460 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 14903 0 -67)
			)
			(1
				(gSwatInterface showHandAni: 6)
			)
			(2
				(= global415 1)
				(gCurRoom newRoom: 1460)
			)
		)
	)
)

(instance rightSide of View
	(properties
		x 491
		view 14902
		loop 1
	)
)

