;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Actor)
(use System)

(public
	openToon 0
)

(instance openToon of PQRoom
	(properties
		modNum 6000
		picture 6450
	)

	(method (init)
		(super init: &rest)
		(textItem init:)
		(gGame handsOff:)
		(self setScript: showOpeningSeq)
	)
)

(instance showOpeningSeq of Script
	(properties)

	(method (handleEvent event)
		(if (& (event type:) evMOUSEBUTTON)
			(gMouseDownHandler delete: self)
			(proc4_5 0 0)
			(textItem dispose:)
			(gCurRoom setScript: interuptRooker)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 37)
				(proc4_6 6001 197 101 0 0 250)
			)
			(1
				(gMouseDownHandler add: self)
			)
			(2
				(textItem dispose:)
			)
			(3
				(gMouseDownHandler delete: self)
			)
			(4
				(proc4_5)
				(gFxSound number: 13 loop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 6000)
			)
		)
	)
)

(instance interuptRooker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom drawPic: 0)
				(self cue:)
			)
			(1
				(gGame showCloseUp: 60053 -1 101 self 1)
			)
			(2
				(gFxSound number: 13 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 6000)
			)
		)
	)
)

(instance textItem of Prop
	(properties
		x 242
		y 293
		priority 600
		fixPriority 1
		view 6450
	)
)

