;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4130)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use System)

(public
	s1_4130 0
)

(instance s1_4130 of PQRoom
	(properties
		picture 4130
	)

	(method (init)
		(super init: &rest)
		(self setScript: coverCarmicheal)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance coverCarmicheal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(proc4_6 41300 96 -28 0 0 250 1)
			)
			(2
				(gSwatInterface showHandAni: 2 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gSwatInterface showHandAni: 3)
			)
			(5
				(gCurRoom newRoom: 4140) ; s1_4140
			)
		)
	)
)

