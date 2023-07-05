;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use movieScr)
(use Sound)
(use Game)
(use System)

(public
	introRoom 0
)

(instance introSong of Sound ; UNUSED
	(properties)
)

(instance introRoom of Room
	(properties)

	(method (init)
		(gThePlane setRect: 0 0 319 199)
		(super init:)
		(= style 0)
		(self setScript: introScr)
	)
)

(instance introScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(PlayVMD 0 {10.vmd}) ; Open
				(proc26_0 10 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gCurRoom setScript: endScr)
			)
		)
	)
)

(instance endScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global108 1100)
				(gCurRoom newRoom: 91) ; saveRest
			)
		)
	)
)

