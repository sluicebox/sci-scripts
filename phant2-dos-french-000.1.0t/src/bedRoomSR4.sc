;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2040)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	bedRoomSR4 0
)

(instance bedRoomSR4 of CloseupRoom
	(properties
		picture 30
		style 0
	)

	(method (init)
		(= exitRoom (- (+ 2021 gChapter) 1))
		(drawerFeat init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance drawerFeat of ExitFeature
	(properties
		priority 300
	)

	(method (init)
		(if (and (== gChapter 1) (not (IsFlag 13)) (IsFlag 19))
			(= exitScene 750)
			(= nextRoom (- (+ 2021 gChapter) 1))
		else
			(= nextRoom 2050)
			(= exitScene 740)
		)
		(super init: (proc63002_10 140 29 539 97 529 145 152 80))
	)
)

