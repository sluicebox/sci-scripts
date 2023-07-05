;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4655)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH5SR5 0
)

(instance paulsOfficeRoomCH5SR5 of WynLogin
	(properties
		exitRoom 4645
		whichComp 1
		docuStoreRm 4665
		postalWareRm 4675
		sysconRm 4685
		allowWho 48
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

