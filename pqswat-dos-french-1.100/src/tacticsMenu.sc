;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use PQRoom)
(use Actor)
(use System)

(public
	tacticsMenu 0
)

(local
	local0
)

(instance tacticsMenu of PQRoom
	(properties
		picture 180
		infoRoomSignal 1
	)

	(method (init)
		(super init: &rest)
		(if (== (gGame printLang:) 1)
			(Load rsAUDIO 18501)
			(Lock rsAUDIO 18501 1)
		)
		(if (!= (gBackMusic number:) 18501)
			(gBackMusic number: 18501 loop: -1 play:)
		)
		(= global122 0)
		(training init:)
		(commendation init:)
		(d_platoon init:)
		(tacticalCon init:)
		(tacticalMove init:)
		(shooterCon init:)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(gUser input:)
				(or (not local0) (not (local0 onMe: gMouseX gMouseY)))
			)
			(if local0
				(local0 cel: 0)
				(UpdateScreenItem local0)
			)
			(if (= local0 (gCast firstTrue: #onMe gMouseX gMouseY))
				(local0 cel: 1)
				(UpdateScreenItem local0)
				(FrameOut)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 190 185))
			(Lock rsAUDIO 18501 0)
			(gBackMusic fade: 0 2 21 1)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance changeRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(class ChalkView of View
	(properties
		view 1800
		topic 0
		nextRoom 185
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
	)

	(method (doVerb)
		(= global122 topic)
		(gCurRoom setScript: changeRoom 0 nextRoom)
	)
)

(instance training of ChalkView
	(properties
		x 90
		y 76
		topic 1
	)
)

(instance commendation of ChalkView
	(properties
		x 84
		y 117
		loop 1
		topic 2
	)
)

(instance d_platoon of ChalkView
	(properties
		name {d-platoon}
		x 84
		y 158
		loop 2
		topic 3
	)
)

(instance tacticalCon of ChalkView
	(properties
		x 82
		y 199
		loop 3
		topic 4
	)
)

(instance tacticalMove of ChalkView
	(properties
		x 90
		y 240
		loop 4
		topic 5
		nextRoom 190
	)
)

(instance shooterCon of ChalkView
	(properties
		x 88
		y 280
		loop 5
		topic 6
		nextRoom 190
	)
)

