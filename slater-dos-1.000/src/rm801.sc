;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use InterView)
(use Sync)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm801 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 10] = [0 0 53 41 268 41 62 146 267 147]
	local17
)

(instance rm801 of Rm
	(properties
		picture 111
		style 10
	)

	(method (init &tmp [temp0 10])
		(super init:)
		(Load rsSCRIPT 929)
		(if (!= gPrevRoomNum 13)
			(gLongSong3 number: 110 loop: -1 play: 10 fade: 127 10 30 0)
		)
		(gUser mapKeyToDir: 0)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(readToMe init:)
		(letMePlay init:)
		(quitSlater init:)
		(more init:)
		(mySlater init:)
		(myCharlie init:)
		(if global121
			(gCurRoom setScript: doTheAnimation)
		else
			(= global121 1)
			(gCurRoom setScript: slaterScript)
		)
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
						(if (> (++ local6) 4)
							(= local6 1)
						)
						(gGame
							setCursor:
								999
								1
								[local7 (* local6 2)]
								[local7 (+ (* local6 2) 1)]
						)
					)
					(KEY_TAB
						(if (> (++ local6) 4)
							(= local6 1)
						)
						(gGame
							setCursor:
								999
								1
								[local7 (* local6 2)]
								[local7 (+ (* local6 2) 1)]
						)
					)
					(KEY_UP
						(if (< (-- local6) 1)
							(= local6 4)
						)
						(gGame
							setCursor:
								999
								1
								[local7 (* local6 2)]
								[local7 (+ (* local6 2) 1)]
						)
					)
					(KEY_SHIFTTAB
						(if (< (-- local6) 1)
							(= local6 4)
						)
						(gGame
							setCursor:
								999
								1
								[local7 (* local6 2)]
								[local7 (+ (* local6 2) 1)]
						)
					)
					(KEY_LEFT
						(if (< (-- local6) 1)
							(= local6 4)
						)
						(gGame
							setCursor:
								999
								1
								[local7 (* local6 2)]
								[local7 (+ (* local6 2) 1)]
						)
					)
					(KEY_RIGHT
						(if (> (++ local6) 4)
							(= local6 1)
						)
						(gGame
							setCursor:
								999
								1
								[local7 (* local6 2)]
								[local7 (+ (* local6 2) 1)]
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

	(method (newRoom newRoomNumber)
		(if (== gPrevRoomNum 13)
			(gLongSong fade: 0 10 30 1)
		else
			(gLongSong3 fade: 0 10 30 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(mySound dispose:)
		(my2Sound dispose:)
		(DisposeScript 929)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gUser mapKeyToDir: 1)
		(super dispose:)
	)
)

(instance slaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gGame handsOff:)
				(myCharlie setLoop: 4 setCel: 0 setCycle: CT 2 1 self)
				(Load rsVIEW 992)
			)
			(2
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(cHead
						view: 992
						setLoop: 1
						setPri: 15
						init:
						setCycle: MouthSync 801 0 0 0 1
					)
				)
				(DoAudio audPLAY 801 0 0 0 1)
				(= ticks 86)
			)
			(3
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(cHead setCycle: 0 setCel: 0)
				)
				(= ticks 25)
			)
			(4
				(readToMe setCel: 1)
				(= cycles 1)
			)
			(5
				(mySound number: 910 setLoop: 1 play: self)
			)
			(6
				(myCharlie setCycle: Beg self)
				(cHead setCycle: 0 setCel: 0 hide: dispose:)
				(readToMe setCel: 0)
			)
			(7
				(= ticks 50)
			)
			(8
				(mySlater setCycle: CT 2 1 self)
				(Load rsVIEW 991)
			)
			(9
				(myCharlie stopUpd:)
				(mySlater setCel: 3)
				(sHead
					init:
					setCel: 0
					setLoop: 2
					ignoreActors:
					setPri: 15
					setCycle: MouthSync 801 0 0 0 2
				)
				(DoAudio audPLAY 801 0 0 0 2)
				(= ticks 46)
			)
			(10
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(sHead setCycle: 0 setCel: 0)
				)
				(= ticks 25)
			)
			(11
				(letMePlay setCel: 1)
				(= cycles 1)
			)
			(12
				(mySound number: 910 setLoop: 1 play: self)
			)
			(13
				(sHead dispose:)
				(mySlater setCel: 2 setCycle: Beg self)
				(letMePlay setCel: 0)
			)
			(14
				(mySlater stopUpd:)
				(self setScript: doTheAnimation)
			)
		)
	)
)

(instance doTheAnimation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(= ticks 250)
			)
			(1
				(mySlater setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(mySlater setLoop: 2 setCel: 0 cycleSpeed: 6 setCycle: Fwd)
				(= ticks 250)
			)
			(3
				(myCharlie setLoop: 0 setCel: 0 setCycle: End self)
			)
			(4
				(myCharlie setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 250)
			)
			(5
				(self cue:)
			)
			(6
				(switch (= local0 (Random 1 6))
					(1
						(self changeState: 11)
					)
					(2
						(self changeState: 7)
					)
					(3
						(self changeState: 11)
					)
					(4
						(self changeState: 7)
					)
					(5
						(self changeState: 11)
					)
					(6
						(self changeState: 7)
					)
				)
			)
			(7
				(self cue:)
			)
			(8
				(= local17 (Random 1 2))
				(= local4 (Random 1 2))
				(if (== local17 1)
					(= local17 1144)
				else
					(= local17 1145)
				)
				(if (== local4 1)
					(= local4 3)
				else
					(= local4 2)
					(mySound number: local17 setLoop: 1 play:)
				)
				(myCharlie
					setLoop: local4
					setCel: 0
					cycleSpeed: 12
					setCycle: Fwd
				)
				(if (== local4 3)
					(= ticks 100)
				else
					(self cue:)
				)
			)
			(9
				(= ticks 25)
			)
			(10
				(myCharlie setLoop: 1 setCel: 0 cycleSpeed: 6 setCycle: Fwd)
				(self changeState: 5)
			)
			(11
				(= ticks 6)
			)
			(12
				(= local3 (Random 2 3))
				(mySlater
					setLoop: local3
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(13
				(mySlater setLoop: 1 setCel: 0 setCycle: End self)
			)
			(14
				(mySlater setLoop: 2 setCel: 0 setCycle: Fwd)
				(self changeState: 5)
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
				(mySound stop:)
				(my2Sound stop:)
				(= ticks 6)
			)
			(1
				(switch local5
					(1
						(readToMe setCel: 1)
					)
					(2
						(letMePlay setCel: 1)
					)
					(3
						(quitSlater setCel: 1)
					)
					(4
						(more setCel: 1)
					)
				)
				(= cycles 1)
			)
			(2
				(mySound number: 910 setLoop: 1 play: self)
				(cond
					((and (> (myCharlie loop:) 0) (< (myCharlie loop:) 4))
						(mySlater setLoop: 0 setCel: 6 setCycle: Beg)
						(myCharlie setLoop: 0 setCel: 10 setCycle: Beg self)
					)
					((and (> (mySlater loop:) 0) (< (mySlater loop:) 4))
						(mySlater setLoop: 0 setCel: 6 setCycle: Beg self)
						(myCharlie setLoop: 4 setCel: 0 setCycle: 0)
					)
					(else
						(mySlater setLoop: 4 setCel: 0 setCycle: 0)
						(myCharlie setLoop: 4 setCel: 0 setCycle: 0)
						(self cue:)
					)
				)
			)
			(3)
			(4
				(switch local5
					(1
						(readToMe setCel: 0 stopUpd:)
					)
					(2
						(letMePlay setCel: 0 stopUpd:)
					)
					(3
						(quitSlater setCel: 0 stopUpd:)
					)
					(4
						(more setCel: 0 stopUpd:)
					)
				)
				(= cycles 2)
			)
			(5
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(sHead
						setLoop: 1
						setCel: 0
						posn: 187 73
						setPri: 15
						init:
						setCycle: CT 2 1
					)
					(cHead
						setLoop: 0
						setCel: 0
						posn: 137 85
						setPri: 15
						init:
						setCycle: CT 2 1
					)
				)
				(mySound number: 1146 setLoop: 1 play: self)
			)
			(6
				(cHead setCycle: 0 setCel: 0 dispose:)
				(sHead setCycle: 0 setCel: 0 dispose:)
				(= ticks 6)
			)
			(7
				(cond
					(local2
						(gCurRoom newRoom: 803)
					)
					(local1
						(gCurRoom newRoom: 802)
					)
					((== local5 1)
						(= global106 1)
						(gCurRoom newRoom: 1)
					)
					(else
						(gCurRoom newRoom: global106)
					)
				)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance readToMe of InterView
	(properties
		x 55
		y 51
		view 4
		priority 2
		signal 16
	)

	(method (doVerb)
		(gGame handsOff:)
		(= global120 1)
		(= local5 1)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance letMePlay of InterView
	(properties
		x 262
		y 55
		view 4
		loop 1
		priority 2
		signal 16
	)

	(method (doVerb)
		(= global120 0)
		(gGame handsOff:)
		(= local5 2)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance quitSlater of InterView
	(properties
		x 263
		y 165
		view 4
		loop 2
		priority 2
		signal 16
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local2 1)
		(= local5 3)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance more of InterView
	(properties
		x 64
		y 162
		view 4
		loop 3
		priority 2
		signal 16
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local1 1)
		(= local5 4)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance mySlater of Prop
	(properties
		x 194
		y 115
		view 3
		loop 4
		priority 6
		signal 16
	)
)

(instance sHead of Prop
	(properties
		x 176
		y 55
		view 991
		loop 2
		priority 15
		signal 16400
	)
)

(instance myCharlie of Prop
	(properties
		x 139
		y 117
		view 7
		loop 4
		priority 6
		signal 16
	)
)

(instance cHead of Prop
	(properties
		x 130
		y 71
		view 992
		priority 15
		signal 16400
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

