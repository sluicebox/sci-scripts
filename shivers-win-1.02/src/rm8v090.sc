;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8090)
(include sci.sh)
(use Main)
(use Motion)

(public
	rm8v090 0
)

(local
	local0
)

(instance rm8v090 of ShiversRoom
	(properties
		picture 8090
	)

	(method (init)
		(efExitUp init: 4)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if local0
			(gSounds play: 10802 0 32 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 8080
	)
)

(instance cupboard of ShiversProp ; UNUSED
	(properties
		priority 255
		fixPriority 1
		view 8090
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
			)
			(if local0
				(gSounds play: 10801 0 32 0)
				(= local0 0)
				(self setCycle: Beg)
			else
				(gSounds play: 10802 0 32 0)
				(= local0 1)
				(self setCycle: End)
			)
			(event claimed: 1)
		)
	)
)

