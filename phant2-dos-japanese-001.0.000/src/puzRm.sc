;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9021)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use BorderWindow)
(use Cel)
(use Cycle)
(use Button)
(use Jump)

(public
	puzRm 0
)

(local
	local0
	local1
)

(instance puzRm of P2Room
	(properties
		picture 911
		south 9000
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 999) ; poorSadDeadCrazyAlienSucker
			(gP2SongPlyr start: 811)
		)
		(panelP init: setScript: openPanel)
		(butnA init:)
		(butnB init:)
		(butnC init:)
		(butnD init:)
	)

	(method (notify)
		(if local1
			(gP2SongPlyr fadeIn: local1)
		)
		(super newRoom: local0)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 999) ; poorSadDeadCrazyAlienSucker
			(= local0 newRoomNumber)
			(panelP setScript: closePanel)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance panelP of Prop
	(properties
		x 136
		y 28
		view 911
		loop 2
	)
)

(instance openPanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 10)
			)
			(1
				(gP2SoundFX play: 9021)
				(panelP setCycle: End self)
			)
			(2
				(gGame handsOn:)
			)
		)
	)
)

(instance closePanel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gP2SoundFX play: 9021)
				(panelP setPri: 2000 setCycle: Beg self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom notify:)
			)
		)
	)
)

(instance wrongButtonS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gP2SoundFX play: 9022)
				(= ticks 30)
			)
			(1
				(= global211 1)
				(= global212 0)
				(= global209 6535)
				(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
			)
		)
	)
)

(instance correctButtonS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gP2SoundFX play: 9023)
				(= ticks 30)
			)
			(1
				(SetFlag 747)
				(= global211 0)
				(= global212 1)
				(= global209 6580)
				(= local1 9400)
				(gCurRoom newRoom: 9400) ; humanThresholdRm
			)
		)
	)
)

(instance butnA of Button
	(properties
		x 152
		y 202
		view 911
		loop 1
	)

	(method (action)
		(hiA init:)
		(panelP setScript: wrongButtonS)
	)
)

(instance butnB of Button
	(properties
		x 253
		y 202
		view 911
		loop 3
	)

	(method (action)
		(hiB init:)
		(panelP setScript: correctButtonS)
	)
)

(instance butnC of Button
	(properties
		x 344
		y 202
		view 911
		loop 4
	)

	(method (action)
		(hiC init:)
		(panelP setScript: wrongButtonS)
	)
)

(instance butnD of Button
	(properties
		x 435
		y 202
		view 911
		loop 5
	)

	(method (action)
		(hiD init:)
		(panelP setScript: wrongButtonS)
	)
)

(instance hiA of Cel
	(properties
		x 160
		y 58
		view 911
	)
)

(instance hiB of Cel
	(properties
		x 253
		y 58
		view 911
		cel 1
	)
)

(instance hiC of Cel
	(properties
		x 342
		y 58
		view 911
		cel 2
	)
)

(instance hiD of Cel
	(properties
		x 436
		y 58
		view 911
		cel 3
	)
)

