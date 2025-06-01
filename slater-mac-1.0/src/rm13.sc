;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	rm13 0
)

(instance rm13 of Rm
	(properties
		picture 1300
		style 10
	)

	(method (init)
		(super init:)
		(gLongSong number: 110 setLoop: -1 play: 10 fade: 127 10 30 0)
		(gCurRoom setScript: waitAWhile)
	)

	(method (dispose)
		(gMouseDownHandler delete: waitAWhile)
		(gKeyDownHandler delete: waitAWhile)
		(super dispose:)
	)
)

(instance waitAWhile of Script
	(properties)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			(gGame handsOn:)
			(gCurRoom newRoom: 801)
		)
		(if (and (== (event type:) evMOUSEBUTTON) (> (event x:) 290) (> (event y:) 175))
			(gGame handsOn:)
			(gCurRoom setScript: highlightArrow)
		)
		(super handleEvent: event)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gMouseDownHandler addToFront: waitAWhile)
				(gKeyDownHandler addToFront: waitAWhile)
				(= ticks 800)
			)
			(1
				(gCurRoom newRoom: 801)
			)
		)
	)
)

(instance highlightArrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 910 loop: 1 play:)
				(anArrow setCel: 1 init:)
				(= ticks 24)
			)
			(1
				(anArrow setCel: 0)
				(= ticks 6)
			)
			(2
				(gCurRoom newRoom: 801)
			)
		)
	)
)

(instance anArrow of View
	(properties
		x 313
		y 198
		view 1302
		priority 15
		signal 16
	)
)

(instance mySound of Sound
	(properties)
)

