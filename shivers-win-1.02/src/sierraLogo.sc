;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use n951)
(use Plane)
(use Motion)
(use Actor)
(use System)

(public
	sierraLogo 0
)

(local
	local0
	local1
	local2
)

(instance sierraLogo of ShiversRoom
	(properties)

	(method (init)
		(gNormalCursor hide:)
		(= local2 ((Cast new:) init: yourself:))
		(= local1
			((Plane new:)
				picture: 899
				priority: 40
				init: 0 0 320 200
				addCast: local2
				yourself:
			)
		)
		(logo init:)
		(super init:)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(gDirectionHandler add: gCurRoom)
		(gCast add: local2)
		(self setScript: sShowLogo)
	)

	(method (dispose)
		(local1 dispose:)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gNormalCursor show:)
		(gCast delete: local2)
		(super dispose:)
	)

	(method (doVerb)
		(gSounds stop: 25002)
		(gGame handsOn:)
		(gCurRoom newRoom: 937) ; flyThrough
	)
)

(instance logo of Prop
	(properties
		priority 45
		fixPriority 1
		view 899
		cycleSpeed 18
	)

	(method (init)
		(super init: local2)
	)
)

(instance sShowLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc951_9 25002)
				(gSounds play: 25002 0 127 0)
				(= seconds 4)
			)
			(1
				(logo setCycle: End)
				(= cycles 1)
			)
			(2
				(= seconds 10)
			)
			(3
				(gSounds stop: 25002)
				(gCurRoom newRoom: 937) ; flyThrough
				(self dispose:)
			)
		)
	)
)

