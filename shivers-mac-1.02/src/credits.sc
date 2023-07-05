;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 903)
(include sci.sh)
(use Main)
(use n951)
(use Plane)
(use System)

(public
	credits 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance credits of ShiversRoom
	(properties)

	(method (init)
		(gNormalCursor hide:)
		(= local2 57)
		(= local3 0)
		(= local4 255)
		(= local5 625)
		(= local0
			((Plane new:) picture: 903 priority: 40 init: 0 0 320 200 yourself:)
		)
		(= local1
			((Plane new:)
				picture: 902
				priority: 41
				init: 57 0 255 625
				yourself:
			)
		)
		(super init:)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(gDirectionHandler add: gCurRoom)
		(gCurRoom setScript: sScrollCredits)
	)

	(method (dispose)
		(local0 dispose:)
		(local1 dispose:)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gNormalCursor show:)
		(super dispose:)
	)

	(method (doVerb)
		(if (gUser canControl:)
			(gCurRoom setScript: sFade)
		)
	)
)

(instance sFade of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds fade: 25003 0 3 10 1 self)
			)
			(1
				(gCurRoom newRoom: 910) ; shiversLogo
				(self dispose:)
			)
		)
	)
)

(instance sScrollCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc951_9 25003)
				(gSounds play: 25003 -1 127 0)
				(= seconds 7)
			)
			(1
				(local1 setRect: local2 local3 local4 local5)
				(UpdatePlane local1)
				(= ticks 1)
			)
			(2
				(if (> (-= local3 1) 64911)
					(= state 0)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOff:)
				(gSounds fade: 25003 0 1 30 1 self)
			)
			(4
				(gGame handsOn:)
				(gCurRoom newRoom: 910) ; shiversLogo
				(self dispose:)
			)
		)
	)
)

