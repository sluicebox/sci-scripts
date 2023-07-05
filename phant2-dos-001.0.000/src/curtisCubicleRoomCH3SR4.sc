;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4043)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	curtisCubicleRoomCH3SR4 0
)

(instance curtisCubicleRoomCH3SR4 of WynLogin
	(properties
		exitRoom 4023
		docuStoreRm 4053
		postalWareRm 4063
	)

	(method (init &tmp temp0)
		(super init: &rest)
		(= temp0 (/ (* (gP2SongPlyr volPercent:) global241) 100))
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: temp0)
		else
			(gP2SongPlyr fadeTo: temp0)
		)
		(gGame handsOn: 1)
	)
)

