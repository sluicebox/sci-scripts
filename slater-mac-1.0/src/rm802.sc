;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 802)
(include sci.sh)
(use Main)
(use Sync)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm802 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	[local9 12] = [0 0 69 24 169 120 217 122 278 122 144 152]
	[local21 10] = [0 102 113 128 143 159 174 189 204 216]
	[local31 16] = [102 102 113 128 128 143 143 159 159 174 174 189 189 204 204 216]
	[local47 9] = [0 2 4 6 8 10 12 14 15]
	local56
)

(instance rm802 of Rm
	(properties
		picture 111
		style 10
	)

	(method (init &tmp temp0)
		(gGame handsOff:)
		(super init:)
		(gUser mapKeyToDir: 0)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(= local7 (= local6 (gGame masterVolume:)))
		(= temp0 (- (= temp0 global106) 1))
		(whichNumber init: setCel: temp0)
		(if (<= global106 6)
			(+= temp0 1)
			(roomPic view: 5 setLoop: 0 setCel: temp0 init: stopUpd:)
		else
			(-= temp0 6)
			(roomPic view: 6 setLoop: 0 setCel: temp0 init: stopUpd:)
		)
		(goLeft init:)
		(tFrame init:)
		(nFrame init:)
		(teleLeft init:)
		(teleRight init:)
		(OKButton init:)
		(okFeat init:)
		(creditButton init:)
		(volButton posn: [local31 local6] 166 init:)
		(button1 init:)
		(button2 init:)
		(button3 init:)
		(button4 init:)
		(button5 init:)
		(button6 init:)
		(button7 init:)
		(button8 init:)
		(volSlider init: stopUpd:)
		(slater init:)
		(if (not global122)
			(= global122 1)
			(gCurRoom setScript: describeButtonScript)
		else
			(gGame handsOn:)
		)
	)

	(method (doVerb)
		(return 0)
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
						(if (> (++ local8) 5)
							(= local8 1)
						)
						(gGame
							setCursor:
								999
								1
								[local9 (* local8 2)]
								[local9 (+ (* local8 2) 1)]
						)
					)
					(KEY_TAB
						(if (> (++ local8) 5)
							(= local8 1)
						)
						(gGame
							setCursor:
								999
								1
								[local9 (* local8 2)]
								[local9 (+ (* local8 2) 1)]
						)
					)
					(KEY_UP
						(if (< (-- local8) 1)
							(= local8 5)
						)
						(gGame
							setCursor:
								999
								1
								[local9 (* local8 2)]
								[local9 (+ (* local8 2) 1)]
						)
					)
					(KEY_SHIFTTAB
						(if (< (-- local8) 1)
							(= local8 5)
						)
						(gGame
							setCursor:
								999
								1
								[local9 (* local8 2)]
								[local9 (+ (* local8 2) 1)]
						)
					)
					(KEY_LEFT
						(if (== local8 5)
							(if (< (-- local7) 1)
								(= local7 1)
							)
							(gGame masterVolume: [local47 local7])
							(volButton posn: [local21 local7] 166)
							(mySound number: 992 setLoop: 1 play:)
						else
							(if (< (-- local8) 1)
								(= local8 5)
							)
							(gGame
								setCursor:
									999
									1
									[local9 (* local8 2)]
									[local9 (+ (* local8 2) 1)]
							)
						)
					)
					(KEY_RIGHT
						(if (== local8 5)
							(if (> (++ local7) 9)
								(= local7 9)
							)
							(gGame masterVolume: [local47 local7])
							(volButton posn: [local21 local7] 166)
							(mySound number: 992 setLoop: 1 play:)
						else
							(if (> (++ local8) 5)
								(= local8 1)
							)
							(gGame
								setCursor:
									999
									1
									[local9 (* local8 2)]
									[local9 (+ (* local8 2) 1)]
							)
						)
					)
					(else
						(event claimed: 0)
						(super handleEvent: event)
					)
				)
				(= local56 0)
			)
			(evMOUSERELEASE
				(= local56 1)
			)
			(evMOUSEBUTTON
				(= local56 2)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (dispose)
		(DisposeScript 929)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gUser mapKeyToDir: 1)
		(mySound dispose:)
		(my2Sound dispose:)
		(super dispose:)
	)
)

(instance goToRoom801 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goLeft setCel: 1)
				(= cycles 2)
			)
			(1
				(mySound number: 910 setLoop: 1 play: self)
			)
			(2
				(goLeft setCel: 0 stopUpd:)
				(= ticks 6)
			)
			(3
				(gCurRoom newRoom: 801)
			)
		)
	)
)

(instance theScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 6)
			)
			(1
				(if local1
					(teleLeft setCel: 1)
				else
					(teleRight setCel: 1)
				)
				(= cycles 2)
			)
			(2
				(mySound number: 910 setLoop: 1 play:)
				(if local1
					(teleLeft setCel: 0)
				else
					(teleRight setCel: 0)
				)
				(= ticks 6)
			)
			(3
				(cond
					(local1
						(if (== global106 1)
							(= global106 global118)
						else
							(-- global106)
						)
					)
					((== global106 global118)
						(= global106 1)
					)
					(else
						(++ global106)
					)
				)
				(= local0 (- (= local0 global106) 1))
				(whichNumber setCel: local0 stopUpd:)
				(if (<= global106 6)
					(+= local0 1)
					(roomPic view: 5 setCel: local0 stopUpd:)
				else
					(-= local0 6)
					(roomPic view: 6 setCel: local0 stopUpd:)
				)
				(= ticks 6)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance describeButtonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global106 1)
				(= ticks 24)
			)
			(1
				(gGame handsOff:)
				(slater setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(slater setLoop: 4 setCel: 0)
				(= global83 0)
				(= ticks 6)
			)
			(3
				(sHead
					setLoop: 0
					setCel: 0
					setPri: 14
					posn: 93 74
					init:
					setCycle: MouthSync 804 0 0 0 2
				)
				(= ticks 10)
			)
			(4
				(= global83 (GetTime))
				(mySound number: 1137 loop: 1 play:)
				(= cycles 1)
			)
			(5
				(DoAudio audPLAY 804 0 0 0 2)
				(= ticks 100)
			)
			(6
				(slater setCycle: 0 setLoop: 3 setCel: 0 stopUpd:)
				(sHead setCycle: 0 setCel: 0 hide: posn: 96 92 dispose:)
				(= ticks 25)
			)
			(7
				(teleRight setCel: 1)
				(= cycles 1)
			)
			(8
				(mySound number: 910 setLoop: 1 play:)
				(whichNumber setCel: (+ (whichNumber cel:) 1))
				(roomPic setCel: (+ (roomPic cel:) 1))
				(= ticks 25)
			)
			(9
				(teleRight setCel: 0)
				(= ticks 50)
			)
			(10
				(teleRight setCel: 1)
				(= cycles 1)
			)
			(11
				(mySound number: 910 setLoop: 1 play:)
				(whichNumber setCel: (+ (whichNumber cel:) 1))
				(roomPic setCel: (+ (roomPic cel:) 1))
				(= ticks 25)
			)
			(12
				(teleRight setCel: 0)
				(= ticks 75)
			)
			(13
				(teleLeft setCel: 1)
				(= cycles 1)
			)
			(14
				(mySound number: 910 setLoop: 1 play:)
				(whichNumber setCel: (- (whichNumber cel:) 1))
				(roomPic setCel: (- (roomPic cel:) 1))
				(= ticks 25)
			)
			(15
				(teleLeft setCel: 0)
				(= ticks 50)
			)
			(16
				(teleLeft setCel: 1)
				(= cycles 1)
			)
			(17
				(mySound number: 910 setLoop: 1 play:)
				(whichNumber setCel: (- (whichNumber cel:) 1))
				(roomPic setCel: (- (roomPic cel:) 1))
				(= ticks 25)
			)
			(18
				(teleLeft setCel: 0)
				(= ticks 50)
			)
			(19
				(OKButton setCel: 1)
				(= cycles 1)
			)
			(20
				(mySound number: 910 setLoop: 1 play:)
				(= ticks 25)
			)
			(21
				(OKButton setCel: 0)
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
				(cHead init:)
				(sHead setLoop: 1 setCel: 0 posn: 96 92 setPri: 14 init:)
				(if local2
					(OKButton setCel: 1)
				)
				(= cycles 1)
			)
			(1
				(if local2
					(my2Sound number: 910 setLoop: 1 play:)
					(= ticks 15)
				else
					(self cue:)
				)
			)
			(2
				(if local2
					(OKButton setCel: 0)
					(sHead setCycle: CT 1 1)
					(cHead setCycle: CT 1 1)
				)
				(= ticks 6)
			)
			(3
				(if local2
					(mySound number: 1146 loop: 1 play: self)
					(sHead setCycle: CT 2 1)
					(cHead setCycle: CT 2 1)
				else
					(self cue:)
				)
			)
			(4
				(if local2
					(sHead setCycle: 0 setCel: 0)
					(cHead setCycle: 0 setCel: 0)
				)
				(= ticks 6)
			)
			(5
				(cond
					(local2
						(= local2 0)
						(gCurRoom newRoom: global106)
					)
					(local3
						(creditButton setCel: 1)
						(= cycles 1)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(if local3
					(mySound number: 910 setLoop: 1 play:)
				)
				(cHead dispose:)
				(sHead dispose:)
				(creditButton setCel: 0 stopUpd:)
				(= ticks 25)
			)
			(7
				(if local3
					(= local3 0)
					(gCurRoom setScript: goTo111)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance goTo111 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cHead init:)
				(sHead setLoop: 1 setCel: 0 posn: 96 92 setPri: 14 init:)
				(self cue:)
			)
			(1
				(sHead setCycle: CT 1 1)
				(cHead setCycle: CT 1 1)
				(= ticks 6)
			)
			(2
				(mySound number: 1146 loop: 1 play: self)
				(sHead setCycle: CT 2 1)
				(cHead setCycle: CT 2 1)
			)
			(3
				(sHead setCycle: 0 setCel: 0)
				(cHead setCycle: 0 setCel: 0)
				(= ticks 6)
			)
			(4
				(cHead dispose:)
				(sHead dispose:)
				(= ticks 6)
			)
			(5
				(gCurRoom newRoom: 111)
			)
		)
	)
)

(instance okFeat of InterFeature
	(properties
		x 224
		y 157
		z 100
		nsTop 17
		nsLeft 160
		nsBottom 98
		nsRight 288
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local2 1)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance button1 of Feature
	(properties
		nsTop 152
		nsLeft 101
		nsBottom 164
		nsRight 113
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 0)
		)
	)
)

(instance button2 of Feature
	(properties
		nsTop 152
		nsLeft 113
		nsBottom 164
		nsRight 129
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 2)
		)
	)
)

(instance button3 of Feature
	(properties
		nsTop 152
		nsLeft 129
		nsBottom 164
		nsRight 145
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 4)
		)
	)
)

(instance button4 of Feature
	(properties
		nsTop 152
		nsLeft 145
		nsBottom 164
		nsRight 161
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 6)
		)
	)
)

(instance button5 of Feature
	(properties
		nsTop 152
		nsLeft 161
		nsBottom 164
		nsRight 175
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 8)
		)
	)
)

(instance button6 of Feature
	(properties
		nsTop 152
		nsLeft 175
		nsBottom 164
		nsRight 190
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 10)
		)
	)
)

(instance button7 of Feature
	(properties
		nsTop 152
		nsLeft 190
		nsBottom 164
		nsRight 207
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 12)
		)
	)
)

(instance button8 of Feature
	(properties
		nsTop 152
		nsLeft 207
		nsBottom 164
		nsRight 218
	)

	(method (doit)
		(if (super onMe: gMouseX gMouseY)
			(gGame masterVolume: 15)
		)
	)
)

(instance tFrame of View
	(properties
		x 221
		y 103
		view 2
		priority 2
		signal 17
	)
)

(instance nFrame of View
	(properties
		x 248
		y 132
		view 2
		loop 1
		priority 2
		signal 17
	)
)

(instance whichNumber of View
	(properties
		x 248
		y 120
		view 2
		loop 2
		priority 3
		signal 17
	)
)

(instance teleLeft of InterView
	(properties
		x 219
		y 134
		view 2
		loop 7
		priority 2
		signal 17
	)

	(method (doVerb)
		(= local1 1)
		(= local5 1)
		(gCurRoom setScript: theScript)
	)
)

(instance teleRight of InterView
	(properties
		x 276
		y 134
		view 2
		loop 8
		priority 2
		signal 17
	)

	(method (doVerb)
		(= local1 0)
		(= local4 1)
		(gCurRoom setScript: theScript)
	)
)

(instance OKButton of InterView
	(properties
		x 170
		y 133
		view 2
		loop 6
		priority 2
		signal 17
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local2 1)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance creditButton of InterView
	(properties
		x 73
		y 38
		view 2
		loop 5
		priority 2
		signal 17
	)

	(method (doVerb)
		(= local3 1)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance roomPic of View
	(properties
		x 226
		y 97
		view 5
		cel 1
		priority 3
		signal 17
	)

	(method (doVerb)
		(gGame handsOff:)
		(= local2 1)
		(gCurRoom setScript: sayOkScript)
	)
)

(instance goLeft of InterView
	(properties
		x 7
		y 199
		view 1301
		priority 15
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: goToRoom801)
	)
)

(instance volSlider of InterProp
	(properties
		x 166
		y 185
		view 1301
		loop 1
		priority 12
		signal 16400
	)
)

(instance slater of Prop
	(properties
		x 77
		y 135
		view 2
		loop 3
		priority 2
		signal 17
	)
)

(instance sHead of Prop
	(properties
		x 96
		y 92
		view 991
		priority 15
		signal 16400
	)
)

(instance cHead of Prop
	(properties
		x 61
		y 103
		view 992
		priority 15
		signal 16400
	)
)

(instance volButton of View
	(properties
		x 144
		y 166
		view 1301
		loop 2
		priority 15
		signal 18448
	)

	(method (doit &tmp [temp0 21] temp21)
		(if
			(and
				(== local56 2)
				(gUser canInput:)
				(< 80 gMouseX 230)
				(< 147 gMouseY 171)
			)
			(cond
				((< gMouseX 105)
					(= temp21 105)
				)
				((> gMouseX 213)
					(= temp21 213)
				)
				(else
					(= temp21 gMouseX)
				)
			)
			(volButton x: temp21 y: 166 startUpd:)
			(Animate (gCast elements:) 0)
			(gFeatures eachElementDo: #doit)
			(if (not (mySound handle:))
				(mySound number: 992 setLoop: 1 play:)
			)
		else
			(self stopUpd:)
		)
		(super doit:)
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

