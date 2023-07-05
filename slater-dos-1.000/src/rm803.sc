;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 803)
(include sci.sh)
(use Main)
(use InterProp)
(use Sync)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm803 0
)

(local
	local0
	[local1 6] = [0 0 83 144 239 145]
)

(instance rm803 of Rm
	(properties
		picture 111
		style 10
	)

	(method (dispose)
		(gUser mapKeyToDir: 1)
		(DisposeScript 929)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(theSound dispose:)
		(mySound dispose:)
		(super dispose:)
	)

	(method (init &tmp [temp0 10])
		(super init:)
		(gUser mapKeyToDir: 0)
		(cHead init:)
		(sHead init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(characters init:)
		(nSign init:)
		(ySign init:)
		(nHead init: setCycle: Fwd)
		(yHead init: setCycle: Fwd)
		(gCurRoom setScript: charlieScript)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_DOWN
						(if (> (++ local0) 2)
							(= local0 1)
						)
						(gGame
							setCursor:
								999
								1
								[local1 (* local0 2)]
								[local1 (+ (* local0 2) 1)]
						)
					)
					(KEY_TAB
						(if (> (++ local0) 2)
							(= local0 1)
						)
						(gGame
							setCursor:
								999
								1
								[local1 (* local0 2)]
								[local1 (+ (* local0 2) 1)]
						)
					)
					(KEY_UP
						(if (< (-- local0) 1)
							(= local0 2)
						)
						(gGame
							setCursor:
								999
								1
								[local1 (* local0 2)]
								[local1 (+ (* local0 2) 1)]
						)
					)
					(KEY_SHIFTTAB
						(if (< (-- local0) 1)
							(= local0 2)
						)
						(gGame
							setCursor:
								999
								1
								[local1 (* local0 2)]
								[local1 (+ (* local0 2) 1)]
						)
					)
					(KEY_LEFT
						(if (< (-- local0) 1)
							(= local0 2)
						)
						(gGame
							setCursor:
								999
								1
								[local1 (* local0 2)]
								[local1 (+ (* local0 2) 1)]
						)
					)
					(KEY_RIGHT
						(if (> (++ local0) 2)
							(= local0 1)
						)
						(gGame
							setCursor:
								999
								1
								[local1 (* local0 2)]
								[local1 (+ (* local0 2) 1)]
						)
					)
					(else
						(event claimed: 0)
						(super handleEvent: event)
					)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb)
		(return 0)
	)
)

(instance goBackScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(nSign setCel: 1)
				(= cycles 1)
			)
			(1
				(mySound number: 910 setLoop: 1 play:)
				(= ticks 6)
			)
			(2
				(nSign setCel: 0)
				(= ticks 6)
			)
			(3
				(mySound number: 1146 setLoop: 1 play: self)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(cHead setPri: 15 setCycle: CT 2 1)
					(sHead setPri: 15 setCycle: CT 2 1)
				)
			)
			(4
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(cHead setCycle: 0 setCel: 0)
					(sHead setCycle: 0 setCel: 0)
				)
				(= cycles 2)
			)
			(5
				(gCurRoom newRoom: 801)
			)
		)
	)
)

(instance charlieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(cHead
					setLoop: 0
					setCel: 0
					setPri: 15
					setCycle: MouthSync 803 0 0 0 2
				)
				(= cycles 1)
			)
			(2
				(DoAudio audPLAY 803 0 0 0 2)
				(= ticks 54)
			)
			(3
				(cHead setCycle: 0 setCel: 0)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayOkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ySign setCel: 1)
				(= cycles 1)
			)
			(1
				(mySound number: 910 setLoop: 1 play:)
				(= ticks 6)
			)
			(2
				(ySign setCel: 0)
				(= ticks 6)
			)
			(3
				(theSound number: 1147 loop: 1 play: self)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(cHead setPri: 15 setCycle: CT 2 1)
					(sHead setPri: 15 setCycle: CT 2 1)
				)
			)
			(4
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(cHead setCycle: 0 setCel: 0)
					(sHead setCycle: 0 setCel: 0)
				)
				(= cycles 2)
			)
			(5
				(gGame handsOff:)
				(gGame quitGame: 1)
			)
		)
	)
)

(instance characters of View
	(properties
		x 160
		y 89
		view 1
		signal 17
	)
)

(instance cHead of Prop
	(properties
		x 144
		y 57
		view 992
	)
)

(instance sHead of Prop
	(properties
		x 179
		y 46
		view 991
		loop 1
		priority 15
		signal 16
	)
)

(instance nSign of InterProp
	(properties
		x 80
		y 159
		view 1
		loop 6
		priority 2
		signal 17
	)

	(method (doVerb)
		(gGame handsOff:)
		(gCurRoom setScript: goBackScript)
	)
)

(instance ySign of InterProp
	(properties
		x 239
		y 161
		view 1
		loop 7
		priority 2
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance nHead of Prop
	(properties
		x 79
		y 133
		view 1
		loop 2
		priority 3
		signal 17
	)
)

(instance yHead of Prop
	(properties
		x 241
		y 135
		view 1
		loop 1
		priority 3
		signal 17
	)
)

(instance theSound of Sound
	(properties)
)

(instance mySound of Sound
	(properties)
)

