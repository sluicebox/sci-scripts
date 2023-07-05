;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use eRS)
(use Motion)
(use Actor)
(use System)

(public
	rm120 0
)

(instance rm120 of SQRoom
	(properties
		picture 120
	)

	(method (init)
		(ship init: setCycle: Fwd)
		(super init:)
		(self setScript: shipScript)
		(gLongSong2 hold: 3)
	)
)

(instance shipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(ship setMotion: MoveTo 153 116 self)
			)
			(2
				(gCurRoom newRoom: 535)
			)
		)
	)
)

(instance ship of Actor
	(properties
		x 153
		y -4
		view 120
		loop 2
		signal 8192
		xStep 4
	)
)

