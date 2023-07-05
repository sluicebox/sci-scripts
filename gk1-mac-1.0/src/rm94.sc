;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use Cursor)
(use Game)
(use Actor)
(use System)

(public
	rm94 0
)

(local
	local0
)

(instance rm94 of Room
	(properties
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(super init:)
		(gTheIconBar disable:)
		(= local0 gTheCursor)
		(gGame setCursor: myInvisCursor 1)
		(gMouseDownHandler add: gCurRoom)
		(gKeyDownHandler add: gCurRoom)
		(gDirectionHandler add: gCurRoom)
		(gGkMusic1
			number: 1
			setLoop: 1
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(self setScript: doTheLogo)
	)

	(method (dispose)
		(gGkMusic1 fade:)
		(gMouseDownHandler delete: gCurRoom)
		(gKeyDownHandler delete: gCurRoom)
		(gDirectionHandler delete: gCurRoom)
		(gGame setCursor: local0 1)
		(super dispose:)
	)

	(method (doVerb)
		(if (== (doTheLogo state:) 2)
			(doTheLogo cue:)
		)
	)
)

(instance doTheLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(if (IsHiRes)
					(logo init:)
				else
					(gCurRoom drawPic: 50 14)
				)
				(= seconds 1)
			)
			(2
				(= seconds 12)
			)
			(3
				(gCurRoom newRoom: 375) ; titleRoom
			)
		)
	)
)

(instance logo of View
	(properties
		view 1050
	)
)

(instance myInvisCursor of Cursor
	(properties
		view 996
	)
)

