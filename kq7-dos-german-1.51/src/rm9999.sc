;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9999)
(include sci.sh)
(use Main)
(use skipCartoon)
(use System)

(public
	rm9999 0
)

(local
	local0
	local1
)

(instance rm9999 of KQRoom
	(properties
		picture 3150
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(self setScript: scroll)
	)
)

(instance scroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom setRect: -319 0 319 136)
				(UpdatePlane gThePlane)
				(= seconds 4)
			)
			(1
				(= local0 -319)
				(= local1 319)
				(while (<= (gThePlane left:) -5)
					(gThePlane setRect: local0 0 local1 136)
					(+= local0 3)
					(+= local1 3)
					(UpdatePlane gThePlane)
					(FrameOut)
				)
				(= seconds 4)
			)
			(2
				(gCurRoom newRoom: 9998)
			)
		)
	)
)

