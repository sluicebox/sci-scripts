;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 108)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm108 0
)

(local
	local0
)

(instance rm108 of Room
	(properties
		picture 10005
	)

	(method (init)
		(super init:)
		(star14 init: z: 1000)
		(star15 init: z: 1000)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(gDirectionHandler add: gCurRoom)
		(self setScript: sShowLogo)
	)

	(method (dispose)
		(gSfx stop:)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (doVerb)
		(gSfx client: 0 stop:)
		(gCurRoom newRoom: 90) ; intro
	)
)

(instance sShowLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(logo init:)
				(= seconds 1)
			)
			(2
				(gSfx number: 607 setLoop: 0 play: self)
				(= ticks 100)
			)
			(3
				(= seconds 13)
			)
			(4
				(star14 z: 0 setCycle: End star0)
				(= ticks 75)
			)
			(5
				(star15 z: 0 setCycle: End star0)
			)
			(6
				(gSfx client: 0 stop:)
				(= seconds 2)
			)
			(7
				(gCurRoom newRoom: 90) ; intro
			)
		)
	)
)

(instance logo of View
	(properties
		view 502
	)
)

(class Star of Prop
	(properties
		cycleSpeed 1
		cueWho 0
	)

	(method (cue)
		(if cueWho
			(cueWho z: 0 setCycle: End cueWho)
		)
		(self dispose:)
	)

	(method (init)
		(self cel: 0 setCycle: 0)
		(super init: &rest)
	)
)

(instance star0 of Star
	(properties
		x 232
		y 57
		view 10005
	)
)

(instance star1 of Star ; UNUSED
	(properties
		x 166
		y 78
		view 10005
	)
)

(instance star2 of Star ; UNUSED
	(properties
		x 174
		y 89
		view 10005
	)
)

(instance star3 of Star ; UNUSED
	(properties
		x 183
		y 100
		view 10005
	)
)

(instance star4 of Star ; UNUSED
	(properties
		x 237
		y 68
		view 10005
	)
)

(instance star5 of Star ; UNUSED
	(properties
		x 113
		y 78
		view 10005
	)
)

(instance star6 of Star ; UNUSED
	(properties
		x 162
		y 69
		view 10005
	)
)

(instance star7 of Star ; UNUSED
	(properties
		x 159
		y 58
		view 10005
	)
)

(instance star8 of Star ; UNUSED
	(properties
		x 141
		y 38
		view 10005
	)
)

(instance star9 of Star ; UNUSED
	(properties
		x 151
		y 47
		view 10005
	)
)

(instance star10 of Star ; UNUSED
	(properties
		x 187
		y 120
		view 10005
	)
)

(instance star11 of Star ; UNUSED
	(properties
		x 186
		y 111
		view 10005
	)
)

(instance star12 of Star ; UNUSED
	(properties
		x 99
		y 98
		view 10005
	)
)

(instance star13 of Star ; UNUSED
	(properties
		x 94
		y 109
		view 10005
	)
)

(instance star14 of Star
	(properties
		x 162
		y 69
		view 10005
	)
)

(instance star15 of Star
	(properties
		x 151
		y 47
		view 10005
	)
)

