;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4674)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH4SR7 0
)

(instance paulsOfficeRoomCH4SR7 of WynPostalWare
	(properties
		exitRoom 4644
		whichComp 1
		docuStoreRm 4664
		sysconRm 4684
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

