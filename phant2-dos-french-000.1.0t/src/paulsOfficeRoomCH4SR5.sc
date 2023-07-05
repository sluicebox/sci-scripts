;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4654)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH4SR5 0
)

(instance paulsOfficeRoomCH4SR5 of WynLogin
	(properties
		exitRoom 4644
		whichComp 1
		docuStoreRm 4664
		postalWareRm 4674
		sysconRm 4684
		allowWho 48
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

