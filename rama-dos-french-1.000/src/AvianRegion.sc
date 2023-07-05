;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 202)
(include sci.sh)
(use Main)
(use RamaRegion)
(use SoundManager)
(use n1111)

(public
	AvianRegion 0
)

(instance AvianRegion of RamaRegion
	(properties)

	(method (init)
		(if (and (not initialized) (IsFlag 134) (not script))
			(if (not global230)
				(= global230 (Random 0 15))
			)
			(self setScript: (ScriptID 103 0)) ; drippingAvianCisternScr
		)
		(SetFlag 230)
		(SoundManager playMusic: 0 -1 6010)
		(super init: &rest)
		(= global190 9)
	)

	(method (dispose)
		(SoundManager fadeMusic: 0 10 8 1)
		(if script
			(script dispose:)
			(= script 0)
			(DisposeScript 103)
		)
		(= global230 (= initialized 0))
		(super dispose:)
	)

	(method (setKeep)
		(= keep (<= 6001 gNewRoomNum 6911)) ; avianLeftShaft1, mirmicatPoolCloseUp
	)
)

