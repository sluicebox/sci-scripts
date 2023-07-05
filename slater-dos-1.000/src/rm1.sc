;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use InterActor)
(use InterFeature)
(use InterProp)
(use InterView)
(use Feature)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm1 0
)

(local
	local0
)

(instance rm1 of Rm
	(properties
		picture 100
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 939)
		(gLongSong2 number: 110 loop: -1 play: 10 fade: 127 10 30 0)
		(fishingMen init:)
		(dinoKid init:)
		(charlie init:)
		(aSign init:)
		(slater init:)
		(twoHeadedGuy init:)
		(aDSnake init:)
		(fBlueChar init:)
		(fPurpleChar init:)
		(aTenacle init:)
		(twoChars init:)
		(aWord0 init:)
		(aWord1 init:)
		(aWord2 init:)
		(aWord3 init:)
		(aWord4 init:)
		(aWord5 init:)
		(aWord6 init:)
		(rock init:)
		(leg init:)
		(Palette palSET_FROM_RESOURCE 100)
		(gCurRoom setScript: rockScript)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local0) (not (gCurRoom script:)))
			(= local0 1)
			(self setScript: (ScriptID 0 4)) ; runScript
		)
	)

	(method (doVerb)
		(return 0)
	)

	(method (dispose)
		(mySound dispose:)
		(my2Sound dispose:)
		(DisposeScript 939)
		(DisposeScript 991)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance rockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(rock setCel: 1)
				(theView view: 165 setLoop: 0 setCel: 1 posn: 97 183 init:)
				(= ticks 25)
			)
			(2
				(mySound number: 1042 setLoop: 1 play:)
				(= ticks 75)
			)
			(3
				(gGame handsOff:)
				(theProp view: 165 setLoop: 1 setCel: 1 posn: 222 183 init:)
				(= ticks 25)
			)
			(4
				(theView hide: dispose:)
				(= ticks 30)
			)
			(5
				(theProp hide: dispose:)
				(self cue:)
			)
			(6
				(rock setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dizzySnakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(dizzySnake
					view: 125
					setLoop: 0
					setCel: 0
					setPri: 7
					init:
					setCycle: CT 2 1 self
				)
			)
			(1
				(mySound number: 944 setLoop: 1 play:)
				(dizzySnake setCel: 2 setCycle: End self)
			)
			(2
				(= ticks 90)
			)
			(3
				(dizzySnake
					setLoop: 1
					setCel: 0
					posn: 66 13
					setCycle: CT 1 1 self
				)
			)
			(4
				(my2Sound number: 928 setLoop: 1 play:)
				(dizzySnake setCycle: CT 2 1 self)
			)
			(5
				(mySound number: 1016 setLoop: 1 play:)
				(dizzySnake setCycle: CT 7 1 self)
			)
			(6
				(dizzySnake setCycle: CT 11 1 self)
			)
			(7
				(my2Sound number: 952 setLoop: 1 play:)
				(dizzySnake setLoop: 2 setCel: 0 posn: 64 10 setCycle: End self)
				(mySound number: 929 setLoop: 1 play:)
			)
			(8
				(dizzySnake
					setLoop: 3
					setCel: 0
					posn: 67 14
					setCycle: CT 3 1 self
				)
			)
			(9
				(mySound number: 952 setLoop: 1 play:)
				(dizzySnake setCycle: CT 5 1 self)
			)
			(10
				(mySound number: 952 setLoop: 1 play:)
				(dizzySnake setCycle: CT 10 1 self)
			)
			(11
				(my2Sound number: 924 setLoop: 1 play:)
				(dizzySnake view: 160 setLoop: 1 setCel: 1 posn: 66 16 dispose:)
				(= cycles 2)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dinoKidScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong2 number: 112 setLoop: -1 play:)
				(dinoKid view: 120 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(mySound number: 954 setLoop: 1 play:)
				(dinoKid setCel: 0 setLoop: 1 setCycle: CT 3 1 self)
			)
			(2
				(mySound number: 941 setLoop: 1 play: self)
				(dinoKid setCel: 4)
			)
			(3
				(dinoKid setLoop: 2 setCel: 0 x: 171 setCycle: CT 6 1 self)
			)
			(4
				(mySound number: 940 setLoop: 1 play: self)
				(dinoKid setCycle: CT 13 1 self)
			)
			(5
				(mySound number: 954 setLoop: 1 play:)
				(dinoKid setLoop: 0 setCel: 14 x: 145 setCycle: CT 9 -1 self)
			)
			(6
				(dinoKid setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(dinoKid view: 160 setLoop: 1 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
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
				(charlie view: 145 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(charlie setCycle: CT 7 1 self)
				(my2Sound number: 930 setLoop: 1 play:)
			)
			(2
				(mySound number: 914 setLoop: 1 play:)
				(charlie setCycle: End self)
			)
			(3
				(mySound number: 919 setLoop: 1 play: self)
			)
			(4
				(mySound stop:)
				(charlie view: 160 setLoop: 0 setCel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aSignScript of Script
	(properties)

	(method (doit)
		(if (== (aSign cel:) 1)
			(mySound number: 916 setLoop: 1 play:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(aSign
					view: 140
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: Fwd
				)
				(= ticks 100)
			)
			(1
				(sHead init: setCycle: End self)
			)
			(2
				(= ticks 132)
			)
			(3
				(sHead setCycle: Beg self)
			)
			(4
				(sHead dispose:)
				(mySound stop:)
				(aSign view: 160 setLoop: 1 setCel: 3 setCycle: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fishingMenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 950)
				(mHands init: setCycle: CT 1 1 self)
			)
			(1
				(my2Sound number: 950 setLoop: 1 play:)
				(mHands setCycle: CT 14 1 self)
			)
			(2
				(my2Sound number: 990 setLoop: 1 play:)
				(fishingMen view: 100 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(fishingMen setLoop: 2 setCel: 0 cycleSpeed: 0 setCycle: Fwd)
				(= ticks 24)
			)
			(4
				(mHands setCel: 14 cycleSpeed: 6 setCycle: CT 6 -1 self)
			)
			(5
				(my2Sound number: 951 setLoop: 1 play: self)
				(mHands setCycle: CT 0 -1 self)
			)
			(6
				(fishingMen setLoop: 1 setCel: 14 setCycle: Beg self)
			)
			(7)
			(8
				(mySound stop:)
				(mHands stopUpd:)
				(fishingMen view: 160 setLoop: 0 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leg1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 943)
				(leg1
					init:
					setLoop: 0
					setCel: 0
					moveSpeed: 0
					setMotion: JumpTo 275 92 self
				)
			)
			(1
				(leg1 setLoop: 0 setCel: 0 setMotion: JumpTo 275 145 self)
				(ball1 init: hide:)
			)
			(2
				(mySound number: 915 setLoop: 1 play:)
				(ball1 show: setCel: 1 setCycle: CT 2 1 self)
			)
			(3
				(my2Sound number: 943 setLoop: 1 play:)
				(ball1 setCycle: CT 7 1 self)
			)
			(4
				(ball1 hide:)
				(leg2 init: moveSpeed: 0 setMotion: JumpTo 243 92 self)
			)
			(5
				(leg2 setMotion: JumpTo 243 135 self)
			)
			(6
				(mySound number: 915 setLoop: 1 play:)
				(ball1 setCel: 0 posn: 217 154 show: setCycle: CT 2 1 self)
			)
			(7
				(my2Sound number: 943 setLoop: 1 play:)
				(ball1 show: setCel: 1 posn: 217 154 setCycle: CT 7 1 self)
			)
			(8
				(ball1 hide:)
				(leg1 setMotion: JumpTo 179 92 self)
			)
			(9
				(leg1 setMotion: JumpTo 179 147 self)
			)
			(10
				(mySound number: 915 setLoop: 1 play:)
				(ball1 setCel: 0 posn: 120 154 show: setCycle: CT 2 1 self)
			)
			(11
				(my2Sound number: 943 setLoop: 1 play:)
				(ball1 setCycle: CT 7 1 self)
			)
			(12
				(ball1 hide:)
				(leg2 setMotion: JumpTo 145 92 self)
			)
			(13
				(leg2 setMotion: JumpTo 145 137 self)
			)
			(14
				(mySound number: 915 setLoop: 1 play:)
				(ball1 setCel: 0 posn: 120 154 show: setCycle: CT 2 1 self)
			)
			(15
				(my2Sound number: 943 setLoop: 1 play:)
				(ball1 setCycle: CT 7 1 self)
			)
			(16
				(ball1 hide:)
				(leg1 setMotion: JumpTo 80 92 self)
			)
			(17
				(leg1 setMotion: JumpTo 80 147 self)
			)
			(18
				(mySound number: 915 setLoop: 1 play:)
				(ball1 setCel: 0 posn: 38 156 show: setCycle: CT 2 1 self)
			)
			(19
				(my2Sound number: 943 setLoop: 1 play:)
				(ball1 setCycle: CT 7 1 self)
			)
			(20
				(ball1 hide:)
				(leg2 setMotion: JumpTo 49 92 self)
			)
			(21
				(leg2 setMotion: JumpTo 49 137 self)
			)
			(22
				(mySound number: 915 setLoop: 1 play:)
				(ball1 setCel: 0 posn: 38 156 show: setCycle: CT 2 1 self)
			)
			(23
				(my2Sound number: 943 setLoop: 1 play:)
				(ball1 setCycle: CT 7 1 self)
			)
			(24
				(ball1 hide:)
				(leg1 setMotion: JumpTo 20 92 self)
			)
			(25
				(leg1 setMotion: JumpTo 20 147 self)
			)
			(26
				(mySound number: 915 setLoop: 1 play:)
				(ball1 setCel: 0 posn: 38 156 show: setCycle: CT 2 1 self)
			)
			(27
				(mySound number: 943 setLoop: 1 play:)
				(ball1 setCycle: CT 7 1 self)
			)
			(28
				(ball1 posn: 217 154 dispose:)
				(leg2 setMotion: JumpTo -19 92 self)
			)
			(29
				(leg2 setMotion: JumpTo -19 137 self)
			)
			(30
				(mySound number: 915 setLoop: 1 play:)
				(leg1 posn: 315 145 dispose:)
				(leg2 posn: 315 95 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tenacleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tenacle setLoop: 0 init: setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 928 setLoop: -1 play:)
				(tenacle setCycle: CT 11 1 self)
			)
			(2
				(mySound number: 912 setLoop: 1 play:)
				(charlie
					view: 115
					loop: 1
					setCel: 0
					posn: 211 131
					setCycle: CT 2 1
				)
				(tenacle setCycle: End self)
			)
			(3
				(tenacle setCycle: CT 11 -1 self)
			)
			(4
				(mySound number: 912 play: setLoop: 1)
				(tenacle setLoop: 0 setCel: 11 setCycle: Beg self)
				(my2Sound number: 928 setLoop: -1 play:)
			)
			(5
				(charlie setCycle: End self)
			)
			(6
				(my2Sound stop:)
				(tenacle hide:)
				(= ticks 100)
			)
			(7
				(charlie setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8
				(charlie setCycle: 0)
				(= ticks 6)
			)
			(9
				(charlie view: 160 loop: 0 setCel: 3 posn: 207 120 stopUpd:)
				(= ticks 6)
			)
			(10
				(tenacle setLoop: 4 setCel: 0 dispose:)
				(= cycles 2)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(slater view: 130 setLoop: 1 setCel: 0 setCycle: CT 1 1 self)
			)
			(1
				(my2Sound number: 947 setLoop: 1 play:)
				(slater setCycle: CT 3 1 self)
			)
			(2
				(my2Sound number: 947 setLoop: 1 play:)
				(slater setCycle: CT 5 1 self)
			)
			(3
				(my2Sound number: 947 setLoop: 1 play:)
				(slater setLoop: 1 setCel: 0 setCycle: CT 1 1 self)
			)
			(4
				(my2Sound number: 947 setLoop: 1 play:)
				(slater setCycle: CT 3 1 self)
			)
			(5
				(my2Sound number: 947 setLoop: 1 play:)
				(slater setCycle: CT 5 1 self)
			)
			(6
				(my2Sound number: 947 setLoop: 1 play:)
				(slater setLoop: 2 setCel: 0 setCycle: End self)
			)
			(7
				(slater view: 160 setLoop: 1 setCel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance twoHeadedGuyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong2 number: 113 setLoop: -1 play:)
				(if (== (twoHeadedGuy x:) 36)
					(twoHeadedGuy
						view: 155
						setLoop: 1
						setCel: 1
						ignoreActors:
						setStep: 5 1
						setCycle: Walk
						setMotion: MoveTo 303 119 self
					)
				else
					(twoHeadedGuy
						view: 155
						setLoop: 0
						setCel: 1
						ignoreActors:
						setStep: 5 1
						setCycle: Walk
						setMotion: MoveTo 36 119 self
					)
				)
			)
			(1
				(mySound stop:)
				(twoHeadedGuy view: 160 setLoop: 2 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fBlueCharScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(twoChars view: 135 setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(mySound number: 904 setLoop: 1 play:)
				(twoChars setCycle: CT 5 1 self)
			)
			(2
				(= ticks 120)
			)
			(3
				(twoChars setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(4
				(mySound number: 989 setLoop: -1 play:)
				(twoChars setCycle: CT 6 1 self)
			)
			(5
				(mySound stop:)
				(twoChars setCycle: CT 10 1 self)
			)
			(6
				(= ticks 90)
			)
			(7
				(twoChars setCycle: CT 13 1 self)
			)
			(8
				(twoChars view: 160 setLoop: 0 setCel: 1 show: stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fPurpleCharScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 110)
				(twoChars view: 110 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(1
				(twoChars setCel: 3 setCycle: CT 0 -1 self)
				(mySound number: 975 setLoop: -1 play:)
			)
			(2
				(twoChars setCycle: CT 3 1 self)
			)
			(3
				(twoChars setCel: 3 setCycle: Beg self)
			)
			(4
				(mySound number: 944 setLoop: 1 play:)
				(my2Sound number: 945 setLoop: 1 play:)
				(twoChars setCel: 4)
				(= ticks 1)
			)
			(5
				(twoChars setCycle: CT 13 1 self)
			)
			(6
				(twoChars setCycle: CT 12 -1 self)
			)
			(7
				(twoChars setCycle: CT 13 1 self)
			)
			(8
				(twoChars setCycle: CT 12 -1 self)
			)
			(9
				(twoChars setCycle: CT 14 1 self)
			)
			(10
				(twoChars setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(11
				(mySound number: 904 setLoop: 1 play:)
				(twoChars setCycle: CT 6 1 self)
			)
			(12
				(my2Sound number: 930 setLoop: 1 play:)
				(twoChars setCycle: CT 9 1 self)
			)
			(13
				(twoChars view: 135 setLoop: 1 setCel: 1 setCycle: CT 2 1 self)
			)
			(14
				(mySound number: 989 setLoop: -1 play:)
				(twoChars setCycle: CT 6 1 self)
			)
			(15
				(mySound stop:)
				(twoChars setCycle: CT 10 1 self)
			)
			(16
				(= ticks 90)
			)
			(17
				(twoChars setCycle: CT 13 1 self)
			)
			(18
				(twoChars view: 160 setLoop: 0 setCel: 1 show: stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leg of Feature
	(properties
		nsTop 131
		nsLeft 143
		nsBottom 159
		nsRight 288
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: leg)
		(gKeyDownHandler addToEnd: leg)
	)

	(method (dispose)
		(gMouseDownHandler delete: leg)
		(gKeyDownHandler delete: leg)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(== (User canInput:) 1)
				(self onMe: event)
				(not (== (OnControl CONTROL (event x:) (event y:)) 8))
			)
			(leg1 setScript: leg1Script)
		else
			(super handleEvent: event)
		)
	)
)

(instance fBlueChar of InterFeature
	(properties
		nsTop 119
		nsLeft 34
		nsBottom 158
		nsRight 80
	)

	(method (doVerb)
		(gCurRoom setScript: fBlueCharScript)
	)
)

(instance fPurpleChar of InterFeature
	(properties
		nsTop 119
		nsLeft 85
		nsBottom 159
		nsRight 143
	)

	(method (doVerb)
		(gCurRoom setScript: fPurpleCharScript)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 175
		nsLeft 41
		nsBottom 182
		nsRight 79
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 0 posn: 59 183 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 175
		nsLeft 84
		nsBottom 182
		nsRight 106
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1055 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 1 posn: 94 183 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 175
		nsLeft 111
		nsBottom 182
		nsRight 154
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 2 posn: 130 183 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 175
		nsLeft 160
		nsBottom 182
		nsRight 192
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1057 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 3 posn: 174 183 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 175
		nsLeft 195
		nsBottom 182
		nsRight 207
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 4 posn: 201 183 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 175
		nsLeft 211
		nsBottom 182
		nsRight 224
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1059 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 5 posn: 217 183 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 175
		nsLeft 228
		nsBottom 182
		nsRight 279
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1060 setLoop: 1 play: rm1)
		(theView view: 170 setLoop: 6 posn: 251 183 init:)
	)
)

(instance aDSnake of InterFeature
	(properties
		nsTop 5
		nsLeft 40
		nsBottom 58
		nsRight 92
	)

	(method (doVerb)
		(gCurRoom setScript: dizzySnakeScript)
	)
)

(instance aTenacle of InterFeature
	(properties
		nsTop 120
		nsLeft 88
		nsBottom 128
		nsRight 232
	)

	(method (doVerb)
		(gCurRoom setScript: tenacleScript)
	)
)

(instance rock of InterView
	(properties
		x 32
		y 183
		view 175
		loop 3
		priority 15
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance theView of Prop
	(properties
		view 170
		cel 1
		priority 15
		signal 16
	)
)

(instance theProp of Prop
	(properties
		view 165
		cel 1
		priority 15
		signal 16
	)
)

(instance tongue of Prop ; UNUSED
	(properties
		x 84
		y 84
		view 110
		cel 2
		priority 15
		signal 17
	)
)

(instance mHands of Prop
	(properties
		x 153
		y 62
		view 100
		signal 16
		cycleSpeed 12
	)
)

(instance fishingMen of InterProp
	(properties
		x 153
		y 63
		view 160
		priority 5
		signal 17
	)

	(method (doVerb)
		(fishingMen setScript: fishingMenScript)
	)
)

(instance ball1 of Prop
	(properties
		x 217
		y 154
		view 105
		loop 1
		priority 12
		signal 16400
	)
)

(instance tenacle of Prop
	(properties
		x 212
		y 130
		view 115
		priority 10
		signal 16401
	)
)

(instance slater of InterProp
	(properties
		x 106
		y 95
		view 160
		loop 1
		cel 2
		signal 20481
	)

	(method (doVerb)
		(leg1 setScript: slaterScript)
	)
)

(instance charlie of InterProp
	(properties
		x 207
		y 120
		view 160
		cel 2
		priority 6
		signal 20497
	)

	(method (doVerb)
		(leg1 setScript: charlieScript)
	)
)

(instance aSign of InterProp
	(properties
		x 237
		y 40
		view 160
		loop 1
		cel 3
		signal 16385
	)

	(method (doVerb)
		(aSign setScript: aSignScript)
	)
)

(instance sHead of Prop
	(properties
		x 217
		y 23
		view 140
		loop 1
		priority 6
		signal 16
	)
)

(instance twoChars of Prop
	(properties
		x 86
		y 169
		view 160
		cel 1
		priority 13
		signal 17
	)
)

(instance dinoKid of InterProp
	(properties
		x 145
		y 116
		view 160
		loop 1
		signal 20481
	)

	(method (doVerb)
		(dinoKid setScript: dinoKidScript)
	)
)

(instance dizzySnake of Prop
	(properties
		x 66
		y 16
		view 160
		loop 1
		cel 1
		signal 20481
	)
)

(instance leg1 of Actor
	(properties
		x 315
		y 145
		view 105
		priority 10
		signal 20497
	)
)

(instance leg2 of Actor
	(properties
		x 315
		y 95
		view 105
		priority 9
		signal 16400
	)
)

(instance twoHeadedGuy of InterActor
	(properties
		x 303
		y 119
		view 160
		loop 2
		signal 16385
	)

	(method (doVerb)
		(twoHeadedGuy setScript: twoHeadedGuyScript)
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

