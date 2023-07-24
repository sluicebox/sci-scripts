;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21080)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	rm21v080 0
)

(local
	local0
)

(instance rm21v080 of ShiversRoom
	(properties
		picture 21080
	)

	(method (init)
		(efExitRight init: 1)
		(pDrawer init:)
		(hsDrawerClosed init:)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21070
	)
)

(instance hsDrawerOpen of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 53 85 53 109 86 141 87 135 120 125 120 105 85 116 85 110 54 85
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDrawerClose)
	)
)

(instance hsDrawerClosed of HotSpot
	(properties)

	(method (init)
		(self createPoly: 83 74 126 105 126 131 84 97 83 75)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sDrawerOpen)
	)
)

(instance pDrawer of Prop
	(properties
		priority 25
		fixPriority 1
		view 21073
	)
)

(instance sDrawerClose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12105 0 82 0)
				(PrintDebug {Close Drawer})
				(= local0 0)
				(hsDrawerClosed init:)
				(pDrawer setCycle: Beg self)
				(hsDrawerClosed init:)
				(hsDrawerOpen dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrawerOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12101 0 82 0)
				(PrintDebug {Open Drawer})
				(= local0 1)
				(pDrawer setCycle: End self)
				(hsDrawerOpen init:)
				(hsDrawerClosed dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

