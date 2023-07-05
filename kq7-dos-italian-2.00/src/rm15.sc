;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use ExitButton)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm15 0
)

(local
	local0
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
)

(instance rm15 of Room
	(properties
		modNum 1000
		picture 10005
	)

	(method (init)
		(ClearFlag 21)
		(super init:)
		(star0 init: z: 1000 cueWho: star1)
		(star1 init: z: 1000 cueWho: star2)
		(star2 init: z: 1000 cueWho: star3)
		(star3 init: z: 1000 cueWho: star4)
		(star4 init: z: 1000 cueWho: star5)
		(star5 init: z: 1000 cueWho: star6)
		(star6 init: z: 1000 cueWho: star7)
		(star7 init: z: 1000 cueWho: star8)
		(star8 init: z: 1000 cueWho: star9)
		(star9 init: z: 1000 cueWho: star10)
		(star10 init: z: 1000 cueWho: star11)
		(star11 init: z: 1000 cueWho: star12)
		(star12 init: z: 1000 cueWho: star13)
		(star13 init: z: 1000)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(gDirectionHandler add: gCurRoom)
		(self setScript: doTheLogo)
	)

	(method (dispose)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (< (doTheLogo state:) 4)
			(doTheLogo changeState: 4)
		)
		(event claimed: 1)
		(return 1)
	)
)

(instance doTheLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 10) ; WAVE
				(= cycles 1)
			)
			(1
				(gKqMusic1 number: 10 setLoop: 1 play: self)
				(= ticks 120)
			)
			(2
				(star0 z: 0 setCycle: End star0)
			)
			(3
				1
				(self cue:)
			)
			(4
				1
				(self cue:)
			)
			(5
				1
				(self cue:)
			)
			(6
				(gKqMusic1 client: 0 stop:)
				(= seconds 2)
			)
			(7
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance logo of View ; UNUSED
	(properties
		view 15
	)
)

(instance star0 of Star
	(properties
		x 232
		y 57
		view 10005
	)
)

(instance star1 of Star
	(properties
		x 166
		y 78
		view 10005
	)
)

(instance star2 of Star
	(properties
		x 174
		y 89
		view 10005
	)
)

(instance star3 of Star
	(properties
		x 183
		y 100
		view 10005
	)
)

(instance star4 of Star
	(properties
		x 237
		y 68
		view 10005
	)
)

(instance star5 of Star
	(properties
		x 113
		y 78
		view 10005
	)
)

(instance star6 of Star
	(properties
		x 162
		y 69
		view 10005
	)
)

(instance star7 of Star
	(properties
		x 159
		y 58
		view 10005
	)
)

(instance star8 of Star
	(properties
		x 141
		y 38
		view 10005
	)
)

(instance star9 of Star
	(properties
		x 151
		y 47
		view 10005
	)
)

(instance star10 of Star
	(properties
		x 187
		y 120
		view 10005
	)
)

(instance star11 of Star
	(properties
		x 186
		y 111
		view 10005
	)
)

(instance star12 of Star
	(properties
		x 99
		y 98
		view 10005
	)
)

(instance star13 of Star
	(properties
		x 94
		y 109
		view 10005
	)
)

(instance myInvisCursor of Cursor ; UNUSED
	(properties
		view 996
	)
)

