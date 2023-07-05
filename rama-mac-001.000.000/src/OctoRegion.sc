;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use RamaRegion)
(use Sound)

(public
	OctoRegion 0
)

(instance OctoRegion of RamaRegion
	(properties)

	(method (init)
		(super init: &rest)
		(= global190 11)
	)

	(method (setKeep)
		(= keep (<= 7000 gNewRoomNum 7924)) ; octoAtriumRamp, ocMorphGateSW
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1)
			(if (< 7499 gCurRoomNum 7510)
				(cond
					((> global258 5)
						(= gSound
							((Sound new:)
								loop: -1
								owner: global122
								number: 7505
								play:
								yourself:
							)
						)
					)
					((< 0 global258 5)
						(= gSound
							((Sound new:)
								loop: -1
								owner: global122
								number: 7504
								play:
								yourself:
							)
						)
					)
				)
			)
		else
			(super serialize: param1)
		)
	)
)

