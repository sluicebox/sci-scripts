;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use SaveManager)
(use Game)

(class RamaRegion of Rgn
	(properties)

	(method (init)
		(super init: &rest)
		(= global122 self)
		(self modNum: number)
	)

	(method (setKeep))

	(method (serialize param1)
		(if (and argc param1)
			(gCurRoom setRegions: (self number:))
		else
			(SaveManager writeWord: number)
		)
	)

	(method (dispose)
		(if gSoundManager
			(gSoundManager cleanLocs: self)
		)
		(if gSoundManager
			(gSoundManager stopSounds: 1)
		)
		(super dispose:)
	)
)

