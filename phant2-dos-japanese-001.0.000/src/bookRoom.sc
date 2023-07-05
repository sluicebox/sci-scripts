;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2171)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use n63002)

(public
	bookRoom 0
)

(instance bookRoom of CloseupRoom
	(properties
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(switch gChapter
			(5
				(= picture 21785)
				(SetFlag 769)
				(eggAMatic add: 2171 16 1)
			)
			(4
				(= picture 21784)
				(SetFlag 583)
				(eggAMatic add: 2171 8 1)
			)
			(3
				(= picture 21783)
				(SetFlag 412)
				(eggAMatic add: 2171 4 1)
			)
			(2
				(= picture 21782)
				(SetFlag 270)
				(eggAMatic add: 2171 2 1)
			)
			(else
				(= picture 21781)
				(SetFlag 117)
				(eggAMatic add: 2171 1 1)
			)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

