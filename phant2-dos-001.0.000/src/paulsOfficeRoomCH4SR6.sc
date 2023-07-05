;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4664)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH4SR6 0
)

(instance paulsOfficeRoomCH4SR6 of WynDocuStore
	(properties
		exitRoom 4644
		whichComp 1
		postalWareRm 4674
		sysconRm 4684
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

