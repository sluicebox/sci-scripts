;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4672)
(include sci.sh)
(use Main)
(use WynIniFile)

(public
	paulsOfficeRoomCH2SR7 0
)

(instance paulsOfficeRoomCH2SR7 of WynDocuStore
	(properties
		exitRoom 4642
		whichComp 1
		docuStoreRm 24415
		postalWareRm 24415
		sysconRm 24415
	)

	(method (init &tmp temp0 temp1 temp2)
		(= temp0 (gWynNet findItem: 6301 21 0 101 1))
		(= temp1 (temp0 findItem: 6301 4 0 92 1))
		(self currentState: (| (& (self currentState:) $ff0f) $0020))
		(super init: &rest)
		(self openFolder: temp0)
		(self openDoco: temp1)
		(= temp2 (gThePlane cast:))
		(postalWareIcon isHot: 0)
		(docuStoreIcon isHot: 0)
		(sysconIcon isHot: 0)
		(logoutIcon isHot: 0)
		(gGame handsOn: 1)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (isKindOf param1)
		(return
			(if (== param1 WynCompBaseRoom)
				0
			else
				(super isKindOf: param1 &rest)
			)
		)
	)

	(method (slideDoors)
		(return 0)
	)
)

