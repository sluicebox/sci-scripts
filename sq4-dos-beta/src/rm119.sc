;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use SQRoom)
(use Motion)
(use Actor)
(use System)

(public
	rm119 0
)

(instance rm119 of SQRoom
	(properties
		picture 119
	)

	(method (init)
		(Load rsVIEW 120)
		(if (== gPrevRoomNum 59)
			(self setScript: flyInScript)
		else
			(self setScript: flyOutScript)
		)
		(ship init: setCycle: Fwd)
		(super init:)
	)
)

(instance flyInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship loop: 0 x: 72 y: -1 setMotion: MoveTo 168 46 self)
			)
			(1
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance flyOutScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship loop: 1 x: 188 y: 52 setMotion: MoveTo 70 -3 self)
			)
			(1
				(gCurRoom newRoom: 72)
			)
		)
	)
)

(instance ship of Actor
	(properties
		yStep 4
		view 120
		signal 8192
		xStep 6
	)
)

