;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use InterFeature)
(use InterProp)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm804 0
)

(local
	local0
)

(instance rm804 of Rm
	(properties
		picture 111
		style 10
	)

	(method (dispose)
		(roomSound dispose:)
		(super dispose:)
	)

	(method (init &tmp [temp0 10])
		(super init:)
		(characters init: setCycle: Fwd)
		(= local0 (Random 1 6))
		(lArrows init:)
		(rArrows init:)
		(switch local0
			(1
				(= local0 110)
			)
			(2
				(= local0 111)
			)
			(3
				(= local0 112)
			)
			(4
				(= local0 113)
			)
			(5
				(= local0 130)
			)
			(else
				(= local0 150)
			)
		)
		(roomSound number: local0 loop: -1 play:)
		(gGame handsOn:)
	)

	(method (doVerb)
		(return 0)
	)
)

(instance sayOkScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1147 setLoop: 1 play:)
			)
			(1
				(gGame handsOff:)
				(gGame quitGame: 1)
			)
		)
	)
)

(instance goToRoom12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 910 setLoop: 1 play:)
				(lArrows setCel: 1)
				(= ticks 15)
			)
			(1
				(lArrows setCel: 0)
				(= ticks 15)
			)
			(2
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance goToRoom801 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 910 setLoop: 1 play:)
				(rArrows setCel: 1)
				(= ticks 15)
			)
			(1
				(rArrows setCel: 0)
				(= ticks 15)
			)
			(2
				(= global106 1)
				(gCurRoom newRoom: 801)
			)
		)
	)
)

(instance ltArrows of InterFeature ; UNUSED
	(properties
		nsTop 185
		nsLeft 308
		nsBottom 200
		nsRight 320
	)

	(method (doVerb)
		(gGame handsOff:)
		(gCurRoom setScript: goToRoom12)
	)
)

(instance rtArrows of InterFeature ; UNUSED
	(properties
		nsTop 185
		nsBottom 200
		nsRight 15
	)

	(method (doVerb)
		(gCurRoom setScript: goToRoom801)
	)
)

(instance characters of Prop
	(properties
		x 150
		y 110
		view 8
		priority 2
		signal 17
	)
)

(instance lArrows of InterProp
	(properties
		x 7
		y 198
		view 1301
		priority 3
		signal 17
	)

	(method (doVerb)
		(gGame handsOff:)
		(gCurRoom setScript: goToRoom12)
	)
)

(instance rArrows of InterProp
	(properties
		x 313
		y 198
		view 1300
		loop 1
		priority 3
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: goToRoom801)
	)
)

(instance roomSound of Sound
	(properties)
)

(instance mySound of Sound
	(properties)
)

