;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use CycleBet)
(use LoadMany)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm9 0
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
)

(instance rm9 of Rm
	(properties
		picture 900
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(LoadMany rsSCRIPT 874 991)
		(super init: &rest)
		(aFire init:)
		(aVineDino init:)
		(pondWater init:)
		(moon init:)
		(blowFtr init:)
		(aWord0 init:)
		(aWord1 init:)
		(aWord2 init:)
		(aWord3 init:)
		(aWord4 init:)
		(aWord5 init:)
		(aWord6 init:)
		(aWord7 init:)
		(aWord8 init:)
		(aWord9 init:)
		(aWord10 init:)
		(aWord11 init:)
		(aWord12 init:)
		(aWord13 init:)
		(aWord14 init:)
		(aWord15 init:)
		(aWord16 init:)
		(rock init:)
		(slater init:)
		(charlie init:)
		(bushCat init:)
		(aBugBush init:)
		(rockDino init: stopUpd:)
		(foliageMorph init: stopUpd:)
		(vineDino init: stopUpd:)
		(theVine init: stopUpd:)
		(drinkingTree init: stopUpd:)
		(gLongSong2 number: 111 setLoop: -1 play: 10 fade: 127 10 30 0)
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
		(DisposeScript 991)
		(mySound dispose:)
		(my2Sound dispose:)
		(my3Sound dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade: 0 10 20 1)
		(super newRoom: newRoomNumber)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 164
		nsLeft 41
		nsBottom 172
		nsRight 67
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 0 posn: 55 172 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 164
		nsLeft 71
		nsBottom 172
		nsRight 104
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1101 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 1 posn: 85 172 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 164
		nsLeft 107
		nsBottom 172
		nsRight 132
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1102 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 2 posn: 119 172 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 164
		nsLeft 137
		nsBottom 172
		nsRight 169
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1103 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 3 posn: 150 172 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 164
		nsLeft 172
		nsBottom 172
		nsRight 203
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1074 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 4 posn: 186 172 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 164
		nsLeft 205
		nsBottom 172
		nsRight 238
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1104 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 5 posn: 221 172 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 164
		nsLeft 242
		nsBottom 172
		nsRight 278
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1105 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 6 posn: 263 172 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 175
		nsLeft 40
		nsBottom 182
		nsRight 85
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 7 posn: 59 183 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 175
		nsLeft 89
		nsBottom 182
		nsRight 114
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1079 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 8 posn: 99 183 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 175
		nsLeft 127
		nsBottom 182
		nsRight 160
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1106 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 9 posn: 143 183 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 175
		nsLeft 164
		nsBottom 182
		nsRight 206
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1107 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 10 posn: 183 183 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 175
		nsLeft 215
		nsBottom 182
		nsRight 235
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 11 posn: 224 183 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 175
		nsLeft 238
		nsBottom 182
		nsRight 282
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1105 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 6 posn: 257 183 init:)
	)
)

(instance aWord13 of InterFeature
	(properties
		nsTop 186
		nsLeft 95
		nsBottom 196
		nsRight 119
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1108 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 12 posn: 107 194 init:)
	)
)

(instance aWord14 of InterFeature
	(properties
		nsTop 186
		nsLeft 120
		nsBottom 196
		nsRight 144
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1109 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 13 posn: 131 194 init:)
	)
)

(instance aWord15 of InterFeature
	(properties
		nsTop 186
		nsLeft 150
		nsBottom 196
		nsRight 173
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1109 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 13 posn: 160 194 init:)
	)
)

(instance aWord16 of InterFeature
	(properties
		nsTop 186
		nsLeft 175
		nsBottom 196
		nsRight 214
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1110 setLoop: 1 play: rm9)
		(theView view: 970 setLoop: 14 posn: 192 194 init:)
	)
)

(instance moon of InterFeature
	(properties
		nsTop 6
		nsLeft 150
		nsBottom 19
		nsRight 166
	)

	(method (doVerb)
		(gCurRoom setScript: shootTheMoonScr)
	)
)

(instance blowFtr of InterFeature
	(properties
		nsTop 31
		nsLeft 70
		nsBottom 63
		nsRight 94
	)

	(method (doVerb)
		(gCurRoom setScript: blowScr)
	)
)

(instance aBugBush of InterFeature
	(properties
		nsTop 144
		nsLeft 184
		nsBottom 158
		nsRight 288
	)

	(method (doVerb)
		(gCurRoom setScript: bugScr)
	)
)

(instance aFire of InterFeature
	(properties
		nsTop 82
		nsLeft 232
		nsBottom 115
		nsRight 288
	)

	(method (doVerb)
		(gCurRoom setScript: flameScr)
	)
)

(instance aVineDino of InterFeature
	(properties
		nsLeft 68
		nsBottom 21
		nsRight 93
	)

	(method (doVerb)
		(gCurRoom setScript: tickleScr)
	)
)

(instance rock of InterView
	(properties
		x 35
		y 172
		view 975
		loop 3
		priority 15
		signal 16401
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance footEffect of View
	(properties
		x 96
		y 154
		view 950
		cel 2
	)
)

(instance theView of Prop
	(properties
		cel 1
		priority 15
		signal 16
	)
)

(instance theProp of Prop
	(properties
		cel 1
		priority 15
		signal 16
	)
)

(instance oddView of Prop
	(properties
		cel 1
		priority 15
		signal 16
	)
)

(instance slater of InterProp
	(properties
		x 88
		y 160
		view 980
		priority 6
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance rubble of InterProp
	(properties
		x 96
		y 55
		z -100
		view 980
		cel 2
		priority 3
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: sneakAPeekScr)
	)
)

(instance charlie of InterProp
	(properties
		x 193
		y 136
		view 980
		loop 1
		priority 4
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: openBagScr)
	)
)

(instance drinkingTree of InterProp
	(properties
		x 254
		y 69
		view 980
		loop 1
		cel 1
		priority 2
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: emptyPondScript)
	)
)

(instance wavingFish of Prop
	(properties
		x 242
		y 68
		view 960
		loop 2
		signal 20481
	)
)

(instance pondWater of InterProp
	(properties
		x 244
		y 70
		view 980
		loop 1
		cel 2
		priority 1
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: emptyPondScript)
	)
)

(instance fire of Prop
	(properties
		x 263
		y 117
		view 925
		loop 2
		cel 1
		priority 10
		signal 16400
	)
)

(instance hoseIt of Prop
	(properties
		x 267
		y 120
		view 925
		loop 1
		cel 5
		priority 10
		signal 16400
	)
)

(instance rockDino of InterProp
	(properties
		x 63
		y 68
		view 980
		loop 2
		priority 2
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: rockDinoScr)
	)
)

(instance foliageMorph of InterProp
	(properties
		x 210
		y 23
		view 980
		loop 2
		cel 1
		signal 20481
	)

	(method (cue)
		(self view: 980 setLoop: 2 setCel: 1 stopUpd:)
		(mySound stop:)
		(gGame handsOn:)
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1003 setLoop: -1 play:)
		(self view: 915 setLoop: 0 setCel: 0 setCycle: End self)
	)
)

(instance theVine of InterProp
	(properties
		x 74
		y 125
		view 980
		loop 3
		priority 12
		signal 16401
	)

	(method (doVerb)
		(if local1
			(gCurRoom setScript: vinePucksEyeScript)
		)
	)
)

(instance bushCat of InterActor
	(properties
		x 83
		y 160
		view 980
		loop 3
		cel 2
		priority 6
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: bushCatScr)
	)
)

(instance catEyes of Actor
	(properties
		x 42
		y 108
		view 945
		loop 3
		priority 2
		signal 20497
	)
)

(instance fireTruck of Actor
	(properties
		x -15
		y 83
		view 925
		loop 3
		priority 3
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self setStep: 7 7)
	)
)

(instance cow of Actor
	(properties
		x 102
		y 77
		view 910
		priority 4
		signal 26640
	)
)

(instance hornBlowingDino of Actor
	(properties
		x 78
		y 70
		view 930
		priority 1
		signal 16400
	)

	(method (cue)
		(super cue:)
		(if local7
			(my2Sound play: self)
		)
	)
)

(instance vineDino of InterActor
	(properties
		x 129
		y 60
		view 980
		loop 2
		cel 2
		signal 18432
	)

	(method (doVerb)
		(gCurRoom setScript: tickleScr)
	)
)

(instance bug of Actor
	(properties
		x 275
		y 181
		view 905
		priority 4
		signal 18448
	)
)

(instance bugEyes of Actor
	(properties
		x 267
		y 159
		view 905
		loop 2
		cel 2
		priority 5
		signal 18448
	)
)

(instance foot of Actor
	(properties
		x 97
		y 155
		view 950
		signal 16384
	)

	(method (init)
		(super init:)
		(my2Sound number: 915 setLoop: 1 play:)
	)
)

(instance mySound of Sound
	(properties)
)

(instance my2Sound of Sound
	(properties)
)

(instance my3Sound of Sound
	(properties)
)

(instance rockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rock setCel: 1)
				(= ticks 12)
			)
			(1
				(gGame handsOff:)
				(theView view: 965 setLoop: 0 setCel: 1 posn: 73 172 init:)
				(mySound number: 1050 setLoop: 1 play:)
				(= ticks 14)
			)
			(2
				(gGame handsOff:)
				(theProp view: 965 setLoop: 1 setCel: 1 posn: 137 172 init:)
				(= ticks 17)
			)
			(3
				(oddView view: 965 setLoop: 2 setCel: 1 posn: 228 172 init:)
				(= ticks 22)
			)
			(4
				(theView hide:)
				(= ticks 20)
			)
			(5
				(theProp hide:)
				(= ticks 33)
			)
			(6
				(theProp view: 965 setLoop: 3 setCel: 1 posn: 73 183 show:)
				(= ticks 50)
			)
			(7
				(oddView hide:)
				(= ticks 10)
			)
			(8
				(theView view: 965 setLoop: 4 setCel: 1 posn: 162 183 show:)
				(= ticks 59)
			)
			(9
				(theProp view: 965 setLoop: 5 setCel: 1 posn: 249 183 show:)
				(= ticks 29)
			)
			(10
				(oddView view: 965 setLoop: 6 setCel: 1 posn: 119 194 show:)
				(= ticks 45)
			)
			(11
				(theView hide:)
				(= ticks 5)
			)
			(12
				(theView view: 965 setLoop: 7 setCel: 1 posn: 184 194 show:)
				(= ticks 25)
			)
			(13
				(theProp hide: dispose:)
				(= ticks 50)
			)
			(14
				(oddView hide: dispose:)
				(= ticks 56)
			)
			(15
				(theView hide: dispose:)
				(rock setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rockDinoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rockDino view: 940 setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
				(mySound number: 1029 setLoop: 1 play:)
			)
			(1
				(mySound number: 956 setLoop: 1 play:)
				(rockDino setCycle: CT 5 1 self)
			)
			(2
				(mySound number: 1030 setLoop: -1 play:)
				(rockDino setLoop: 1 setCel: 0 setCycle: Fwd)
				(= ticks 150)
			)
			(3
				(mySound number: 920 setLoop: 1 play:)
				(rockDino setLoop: 0 setCel: 5 setCycle: Beg self)
			)
			(4
				(rockDino view: 980 setLoop: 2 setCel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance emptyPondScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(drinkingTree
					view: 960
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: CT 1 1 self
				)
			)
			(1
				(mySound number: 942 setLoop: -1 play:)
				(my2Sound number: 930 setLoop: 1 play:)
				(drinkingTree setCycle: CT 4 1 self)
			)
			(2
				(my2Sound number: 956 setLoop: 1 play:)
				(pondWater
					view: 960
					setLoop: 1
					setCel: 0
					init:
					setCycle: End self
				)
				(drinkingTree setCycle: CT 6 1 self)
			)
			(3)
			(4
				(wavingFish init: setLoop: 2 setCycle: CT 1 1 self)
			)
			(5
				(mySound number: 1023 setLoop: -1 play:)
				(wavingFish setCycle: CT 4 1 self)
				(pondWater hide:)
			)
			(6
				(wavingFish setCycle: CycleBet 4 6 6 self)
			)
			(7
				(mySound number: 964 setLoop: -1 play:)
				(= ticks 20)
			)
			(8
				(drinkingTree setCycle: Fwd cycleSpeed: 4 setLoop: 5)
				(= cycles 2)
			)
			(9
				(wavingFish setCel: 0 hide: dispose:)
				(pondWater
					show:
					setLoop: 4
					cel: (pondWater lastCel:)
					setCycle: Beg
				)
				(= ticks 60)
			)
			(10
				(drinkingTree setLoop: 3 cel: 4 setCycle: End self)
			)
			(11
				(mySound stop:)
				(pondWater view: 980 setLoop: 1 cel: 2 forceUpd: stopUpd:)
				(if (!= (gLongSong2 number:) 130)
					(gLongSong2 number: 130 setLoop: -1 play:)
				)
				(drinkingTree view: 980 setLoop: 1 cel: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blowScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local7 1)
				(my2Sound number: 1163 setLoop: 1 play: hornBlowingDino)
				(= ticks 50)
			)
			(1
				(hornBlowingDino
					setLoop: 0
					setCel: 0
					setCycle: 0
					setLoop: 0
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo 146 67 self
				)
			)
			(2
				(hornBlowingDino loop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(hornBlowingDino
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 93 70 self
				)
			)
			(4
				(hornBlowingDino
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 78 70 self
				)
			)
			(5
				(hornBlowingDino hide:)
				(= ticks 50)
			)
			(6
				(= local7 0)
				(hornBlowingDino dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flameScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(fire init: setCycle: Fwd)
				(mySound number: 944 setLoop: -1 play:)
				(= ticks 60)
			)
			(1
				(mySound number: 1028 setLoop: -1 play: 10 fade: 127 10 10 0)
				(= cycles 10)
			)
			(2
				(fireTruck
					setLoop: 3
					setCel: 0
					ignoreActors: 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 330 83 self
				)
			)
			(3
				(fireTruck setLoop: 0 setCel: 0 setMotion: MoveTo 263 83 self)
			)
			(4
				(fireTruck setCel: 1)
				(hoseIt init:)
				(= ticks 30)
			)
			(5
				(mySound number: 964 setLoop: -1 play:)
				(hoseIt setCycle: CT 3 1 self)
			)
			(6
				(hoseIt setCycle: CycleBet 1 3 5 self)
			)
			(7
				(hoseIt setCycle: CT 5 1 self)
			)
			(8
				(hoseIt setCel: 0 dispose:)
				(fire dispose:)
				(mySound number: 1028 setLoop: 1 play:)
				(fireTruck setLoop: 0 setCel: 0 setMotion: MoveTo 0 83 self)
			)
			(9
				(mySound number: 944 setLoop: 1 fade: 0 10 10 1)
				(fireTruck setLoop: 3 setCel: 0 posn: -15 83 dispose:)
				(gLongSong2 number: 150 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openBagScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 6)
			)
			(1
				(charlie
					view: 955
					setLoop: 0
					cel: 0
					setPri: 14
					setCycle: CT 1 1 self
				)
			)
			(2
				(mySound number: 1027 setLoop: 1 play:)
				(charlie setCycle: CT 6 1 self)
			)
			(3
				(= ticks 100)
			)
			(4
				(charlie setCycle: CT 9 1 self)
			)
			(5
				(charlie setCycle: CT 11 1 self)
			)
			(6
				(mySound number: 1027 setLoop: 1 play: self)
				(charlie cel: 12)
			)
			(7
				(charlie view: 980 loop: 1 setCel: 0 setPri: 4 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sneakAPeekScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 929 setLoop: -1 play:)
				(slater view: 900 setLoop: 0 setCel: 0 init: setCycle: End self)
				(= register 2)
			)
			(1
				(if (-- register)
					(-- state)
				)
				(slater setLoop: 1 cycleSpeed: (Random 8 12))
				(switch (Random 1 3)
					(1
						(slater setCycle: Fwd)
						(= ticks 60)
					)
					(2
						(slater setCycle: End self)
					)
					(3
						(slater setCycle: Beg self)
					)
				)
			)
			(2
				(mySound stop:)
				(foot setLoop: 0 cel: 0 x: 97 y: 155 init:)
				(rubble init:)
				(footEffect init:)
				(slater hide:)
				(= ticks 9)
			)
			(3
				(footEffect dispose:)
				(ShakeScreen 1 ssUPDOWN)
				(slater view: 980 loop: 0 setCel: 1 posn: 112 113 dispose:)
				(rubble view: 980 setLoop: 0 setCel: 2 stopUpd:)
				(charlie view: 980 setLoop: 1 setCel: 0 stopUpd:)
				(foot ignoreActors: 1 ignoreHorizon: setLoop: 0 moveSpeed: 0)
				(= ticks 60)
			)
			(4
				(foot setStep: 20 20 setMotion: MoveTo 97 -10 self)
			)
			(5
				(foot dispose:)
				(= local1 1)
				(gGame handsOn:)
				(slater dispose:)
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
				(mySound number: 1163 setLoop: 1 play:)
				(= ticks 25)
			)
			(1
				(my2Sound number: 950 setLoop: 1 play:)
				(slater view: 951 setLoop: 1 setCel: 0)
				(= ticks 25)
			)
			(2
				(if (mySound handle:)
					(-- state)
				else
					(mySound number: 1163 setLoop: 1 play:)
				)
				(= ticks 25)
			)
			(3
				(slater setCycle: CT 4 1 self)
			)
			(4
				(= ticks 25)
			)
			(5
				(slater setCel: 0)
				(= ticks 25)
			)
			(6
				(slater setCycle: CT 5 1 self)
			)
			(7
				(charlie view: 951 setLoop: 0 setCel: 0 setCycle: End self)
				(= register 8)
			)
			(8
				(mySound number: 975 setLoop: 1 play:)
				(charlie cel: 3)
				(= ticks (Random 5 20))
			)
			(9
				(if (-- register)
					(-= state 2)
				)
				(charlie cel: 4)
				(= ticks (Random 5 20))
			)
			(10
				(mySound stop:)
				(charlie setCycle: Beg self)
			)
			(11
				(slater setCel: 6)
				(= ticks 100)
			)
			(12
				(slater cycleSpeed: 10 setCycle: End self)
			)
			(13
				(slater view: 950 setLoop: 1 cel: 0)
				(= ticks 60)
			)
			(14
				(slater cycleSpeed: 14 setCycle: End self)
			)
			(15
				(= ticks 30)
			)
			(16
				(slater cel: 0)
				(= ticks 100)
			)
			(17
				(slater cycleSpeed: 10 setCycle: End self)
			)
			(18
				(foot init:)
				(rubble init:)
				((= local5 (View new:))
					name: {pillow}
					view: 980
					setLoop: 0
					cel: 3
					x: 95
					y: 123
					setPri: 7
					ignoreActors: 1
					init:
					addToPic:
				)
				(footEffect init:)
				(slater hide:)
				(= ticks 12)
			)
			(19
				(footEffect dispose:)
				(slater view: 980 loop: 0 setCel: 1 posn: 112 113 dispose:)
				(rubble view: 980 setLoop: 0 setCel: 2 stopUpd:)
				(charlie view: 980 setLoop: 1 setCel: 0 stopUpd:)
				(foot ignoreActors: 1 ignoreHorizon: setLoop: 0 moveSpeed: 0)
				(= ticks 60)
			)
			(20
				(foot setStep: 20 20 setMotion: MoveTo 97 -10 self)
			)
			(21
				(= local1 1)
				(foot dispose:)
				(gGame handsOn:)
				(slater dispose:)
			)
		)
	)
)

(instance bugScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 1025 setLoop: -1 play:)
				(bugEyes init: ignoreActors: setMotion: MoveTo 219 129)
				(bug
					init:
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 226 151 self
				)
			)
			(1
				(mySound number: 1013 setLoop: 1 play:)
				(bugEyes setCycle: CT 0 -1 self)
			)
			(2
				(= ticks 50)
			)
			(3
				(bugEyes setCycle: CT 1 1 self)
			)
			(4
				(bugEyes setCel: 5)
				(= ticks 2)
			)
			(5
				(gLongSong2 pause: 1)
				(mySound number: 961 setLoop: -1 play: self)
				(bug setLoop: 1 setCel: 0 setCycle: CycleBet 2 4 5 self)
			)
			(6
				(mySound stop:)
				(bugEyes cel: 2)
				(= ticks 30)
			)
			(7
				(bug setCel: 5)
				(= ticks 30)
			)
			(8
				(mySound number: 1026 setLoop: 1 setVol: 127 play:)
				(bug setCel: 6)
				(= ticks 30)
			)
			(9
				(bug setCel: 5)
				(= ticks 20)
			)
			(10
				(bug setCel: 6)
				(mySound number: 1026 setLoop: 1 play:)
				(= ticks 60)
			)
			(11
				(mySound number: 928 setLoop: 1 play:)
				(bugEyes setCycle: CT 0 -1 self)
				(bug setCycle: CT 3 -1 self)
			)
			(12)
			(13
				(mySound stop:)
				(gLongSong2 pause: 0)
				(= ticks 30)
			)
			(14
				(mySound number: 1025 setLoop: -1 play:)
				(bugEyes dispose:)
				(bug setCycle: Walk loop: 0 setMotion: MoveTo 275 181 self)
			)
			(15
				(mySound stop:)
				(bug setLoop: 0 setCel: 0 posn: 275 181 dispose:)
				(bugEyes setCel: 2 posn: 268 159 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tickleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 951 setLoop: 1 play:)
				(vineDino
					view: 935
					setLoop: 0
					setCel: 0
					moveSpeed: 0
					setMotion: MoveTo 145 88 self
				)
			)
			(1
				(vineDino setCycle: End self)
			)
			(2
				(= ticks 50)
			)
			(3
				(vineDino setLoop: 1)
				(= ticks 5)
			)
			(4
				(mySound number: 1016 setLoop: -1 play:)
				(charlie view: 935 loop: 2 setCel: 0 posn: 182 132)
				(vineDino loop: 1 setCycle: Fwd)
				(= ticks 120)
			)
			(5
				(mySound stop:)
				(charlie view: 980 loop: 1 setCel: 0 posn: 193 136)
				(vineDino loop: 0 setCel: 2 setCycle: 0)
				(= cycles 2)
			)
			(6
				(vineDino setCycle: Beg self)
			)
			(7
				(mySound number: 951 setLoop: 1 play:)
				(vineDino setMotion: MoveTo 129 60 self)
			)
			(8
				(vineDino view: 980 setLoop: 2 setCel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bushCatScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bushCat
					view: 945
					setLoop: 0
					setCel: 0
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 80 160 self
				)
			)
			(1
				(mySound number: 956 setLoop: -1 play:)
				(bushCat setMotion: MoveTo 60 160 self)
			)
			(2
				(bushCat
					setLoop: 6
					setCel: 0
					cycleSpeed: 10
					posn: 33 160
					setCycle: End self
				)
			)
			(3
				(bushCat
					setLoop: 7
					setCycle: Fwd
					cycleSpeed: 6
					setMotion: MoveTo 43 122 self
				)
			)
			(4
				(theVine hide:)
				(bushCat
					setLoop: 1
					setCel: 0
					posn: 37 105
					setCycle: CT 5 1 self
				)
				(mySound stop:)
			)
			(5
				(bushCat posn: 41 108 setCel: 6)
				(my2Sound number: 934 setLoop: 1 play:)
				(= ticks 60)
			)
			(6
				(my2Sound stop:)
				(mySound number: 904 setLoop: 1 play:)
				(bushCat setLoop: 2 setCel: 0)
				(catEyes
					cel: 1
					setLoop: 3
					init:
					posn: 42 108
					ignoreActors: 1
					setPri: 15
					setStep: 3 2
					setCycle: End self
				)
			)
			(7
				(catEyes
					setLoop: 4
					setCel: 0
					posn: 46 56
					ignoreActors:
					moveSpeed: 0
					setMotion: JumpTo 69 33 self
				)
				(mySound number: 930 setLoop: 1 play:)
			)
			(8
				(my2Sound play:)
				(catEyes posn: 106 88)
				(= ticks 10)
			)
			(9
				(catEyes posn: 122 138)
				(= ticks 10)
			)
			(10
				(catEyes setPri: 6 posn: 127 167)
				(= ticks 10)
			)
			(11
				(my2Sound number: 924 setLoop: 1 play:)
				(bushCat setLoop: 5 setCel: 0 setCycle: CT 1 1 self)
			)
			(12
				(bushCat setCycle: CT 4 1)
				(catEyes setLoop: 8 posn: 111 99)
				(= ticks 10)
			)
			(13
				(catEyes posn: 114 203)
				(= ticks 5)
			)
			(14
				(catEyes dispose:)
				(theVine show: stopUpd:)
				(mySound number: 988 setLoop: 1 play:)
				(bushCat view: 980 setLoop: 3 setCel: 2 setCycle: 0 hide:)
				(= ticks 25)
			)
			(15
				(bushCat
					show:
					posn: 83 190
					moveSpeed: 0
					setStep: 4 4
					setMotion: MoveTo 83 160 self
				)
			)
			(16
				(bushCat setStep: 3 2 moveSpeed: 6 cycleSpeed: 6 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vinePucksEyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theVine cel: 1 forceUpd:)
				((= local3 (Prop new:))
					name: {pinkVine}
					view: 920
					setLoop: 4
					cel: 0
					setPri: 4
					x: 34
					y: 99
					cycleSpeed: 8
					ignoreActors: 1
					init:
				)
				((= local4 (Prop new:))
					name: {purpleVine}
					view: 920
					setLoop: 5
					cel: 0
					setPri: 4
					x: 36
					y: 107
					cycleSpeed: 8
					ignoreActors: 1
					init:
				)
				(= ticks 20)
			)
			(1
				(local4 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(mySound number: 961 setLoop: -1 play:)
				(local4 setCycle: CycleBet 2 3 -1)
				(= register 10)
				(= cycles 2)
			)
			(3
				(if (-- register)
					(-- state)
					(local4 cycleSpeed: (Random 8 12))
				)
				(= ticks 10)
			)
			(4
				(local4 setLoop: 2 cel: 1 setCycle: CT 3 1 self)
			)
			(5
				(mySound number: 904 setLoop: 1 play:)
				(local4 setCycle: CT 8 1 self)
			)
			(6
				(local3 setLoop: 4 setCycle: CT 2 1 self)
			)
			(7
				(local3 y: 102 setCycle: CycleBet 2 3 -1)
				(mySound number: 961 setLoop: -1 play:)
				(= register 10)
				(= cycles 2)
			)
			(8
				(if (-- register)
					(-- state)
					(local3 cycleSpeed: (Random 8 12))
				)
				(= ticks 10)
			)
			(9
				(local3 setLoop: 1 cel: 1 setCycle: CT 3 1 self)
				(Load rsSOUND 924)
			)
			(10
				(mySound number: 904 setLoop: 1 play:)
				(local3 y: 99 setCycle: CT 8 1 self)
			)
			(11
				(= ticks 30)
			)
			(12
				(local3 setCycle: CT 10 1 self)
				(local4 setCycle: CT 10 1 self)
			)
			(13)
			(14
				(= ticks 100)
				(= register 10)
			)
			(15
				(if (-- register)
					(-- state)
					(local3 cel: (Random 8 15) forceUpd:)
					(local4 cel: (Random 8 15) forceUpd:)
				)
				(= ticks (Random 10 20))
			)
			(16
				((= local6 (Prop new:))
					name: {arm}
					view: 920
					setLoop: 3
					cel: 0
					setPri: 5
					ignoreActors: 1
					x: 80
					y: 138
					cycleSpeed: 0
					init:
				)
				(= ticks 30)
			)
			(17
				(local6 posn: 71 114)
				(= ticks 20)
			)
			(18
				(local6 posn: 63 97)
				(= ticks 20)
			)
			(19
				(local6 cel: 1 forceUpd:)
				(local4 setLoop: 5 cel: 0 setCycle: 0 forceUpd:)
				(= ticks 25)
			)
			(20
				(mySound number: 904 setLoop: 1 play:)
				(local6 setCycle: End self)
			)
			(21
				(local6 posn: 71 114)
				(= ticks 2)
			)
			(22
				(local6 posn: 80 138)
				(= ticks 2)
			)
			(23
				(local6 hide:)
				(local3 setCycle: CycleBet 8 15 -1)
				(= ticks 100)
			)
			(24
				(local6 show: cel: 0 posn: 60 130)
				(= ticks 20)
			)
			(25
				(local6 posn: 52 109)
				(= ticks 20)
			)
			(26
				(local6 posn: 43 90)
				(= ticks 20)
			)
			(27
				(local6 cel: 1 forceUpd:)
				(local3 setLoop: 4 cel: 0 setCycle: 0 forceUpd:)
				(= ticks 25)
			)
			(28
				(mySound number: 904 setLoop: 1 play:)
				(local6 setCycle: End self)
			)
			(29
				(local6 posn: 52 109)
				(= ticks 2)
			)
			(30
				(local6 posn: 60 130)
				(= ticks 2)
			)
			(31
				(local6 dispose:)
				(= ticks 60)
			)
			(32
				(local4 setCycle: End self)
				(local3 setLoop: 6 cel: 0 setCycle: End self)
			)
			(33)
			(34
				(local4 dispose:)
				(local3 dispose:)
				(theVine cel: 0 forceUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shootTheMoonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cow init: setPri: 4 setCycle: CT 1 1 self)
			)
			(1
				(my3Sound number: 912 setLoop: 1 play:)
				(cow setCycle: CT 5 1 self)
			)
			(2
				(mySound number: 911 setLoop: 1 play:)
				(cow setPri: 1 setCycle: CT 10 1 self)
			)
			(3
				(cow setCel: 10)
				(my2Sound number: 914 setLoop: 1 play: self)
			)
			(4
				(cow setPri: 0 setCycle: CT 11 1 setMotion: MoveTo 102 110 self)
				(my2Sound number: 1006 setLoop: 1 play:)
			)
			(5
				(cow setCel: 0 posn: 102 77 dispose:)
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

