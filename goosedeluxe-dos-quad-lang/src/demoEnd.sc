;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	demoEnd 0
)

(local
	local0
)

(instance demoEnd of Room
	(properties
		picture 119
	)

	(method (init)
		(proc0_2)
		(= global300 0)
		(= global104 1)
		(gThePlane setRect: 0 0 319 199)
		(super init:)
		(self setScript: sEndDemo)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance sEndDemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSfx number: 817 play: self)
				(gGame handsOff:)
			)
			(1
				(gSfx number: 818 play: self)
			)
			(2
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

