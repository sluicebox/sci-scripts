;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 936)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	slideRm 0
)

(instance slideRm of ShiversRoom
	(properties)

	(method (init &tmp [temp0 4])
		(super init: &rest)
		(self playVMD: 39310 0)
		(self setScript: sDumb)
	)
)

(instance sDumb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 79)
				(proc951_9 20903)
				(gSounds play: 20903 -1 0 0)
				(gSounds fade: 20903 42 1 30 0 0)
				(if (IsFlag 42)
					(proc951_7 10908)
					(proc951_9 10908)
					(gSounds play: 10908 -1 26 0)
				)
				(gCurRoom drawPic: 9400)
				(= seconds 3)
			)
			(1
				(gCurRoom drawPic: 9430)
				(= seconds 1)
			)
			(2
				(gCurRoom newRoom: 9420) ; rm9v42
				(self dispose:)
			)
		)
	)
)

