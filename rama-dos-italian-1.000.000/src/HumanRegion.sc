;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)
(use n1111)

(public
	HumanRegion 0
)

(instance HumanRegion of RamaRegion
	(properties)

	(method (init &tmp temp0)
		(if (and (<= 8000 gNewRoomNum 8130) (not initialized)) ; HumanRamp, HumanBeds
			(if (IsFlag 157)
				(= temp0 6030)
			else
				(= temp0 1010)
			)
			(SoundManager fadeMusic: 0 20 8 1 0 playMusic: 0 -1 temp0)
		)
		(super init: &rest)
		(= global190 13)
	)

	(method (setKeep)
		(= keep (<= 8000 gNewRoomNum 8130)) ; HumanRamp, HumanBeds
	)
)

