;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use SQRoom)
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
	)
)

(instance shipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship setMotion: MoveTo 153 116 self)
			)
			(1
				(gCurRoom newRoom: 535)
			)
		)
	)
)

(instance ship of Actor
	(properties
		x 153
		y -4
		yStep 4
		view 120
		loop 2
		xStep 4
	)
)

