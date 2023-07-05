;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 208)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)

(public
	iceportRegion 0
)

(instance iceportRegion of RamaRegion
	(properties)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 2000) ; cplains
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 1020)
		)
		(= global190 4)
	)

	(method (setKeep)
		(= keep (<= 2100 gNewRoomNum 2109)) ; CPIceport1, icemobileCU
	)
)

