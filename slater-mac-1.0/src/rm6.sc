;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm6 0
)

(local
	local0
	local1
	local2
)

(instance rm6 of Rm
	(properties
		picture 600
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(super init:)
		(aTentDino init: setOnMeCheck: 1 4)
		(aMammouth init:)
		(aMammouth init: setOnMeCheck: 1 2)
		(littlePine init:)
		(aBigPine init:)
		(bucket init:)
		(aCharlie init:)
		(frontBush init: setOnMeCheck: 1 16)
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
		(rock init:)
		(coyote init:)
		(smallPine init:)
		(bigPine init:)
		(geyser init:)
		(pot init:)
		(potFeature init:)
		(tentFlap init:)
		(charlie init:)
		(slater init:)
		(bush init:)
		(foliage init:)
		(gLongSong number: 112 setLoop: -1 play: 10 fade: 127 10 30 0)
		(gCurRoom setScript: rockScript)
	)

	(method (doVerb)
		(return 0)
	)

	(method (doit)
		(super doit:)
		(if (and global120 (not local0) (not (gCurRoom script:)))
			(= local0 1)
			(self setScript: (ScriptID 0 4)) ; runScript
		)
	)

	(method (dispose)
		(mySound dispose:)
		(my2Sound dispose:)
		(my3Sound dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance frontBush of InterFeature
	(properties
		x 162
		y 128
		nsTop 96
		nsLeft 34
		nsBottom 161
		nsRight 290
	)

	(method (doVerb)
		(gCurRoom setScript: foliageScript)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 170
		nsLeft 53
		nsBottom 175
		nsRight 90
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 loop: 1 play: rm6)
		(theView view: 680 setLoop: 0 posn: 68 176 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 170
		nsLeft 93
		nsBottom 175
		nsRight 140
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1084 loop: 1 play: rm6)
		(theView view: 680 setLoop: 1 posn: 115 176 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 170
		nsLeft 145
		nsBottom 175
		nsRight 169
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 loop: 1 play: rm6)
		(theView view: 680 setLoop: 2 posn: 155 176 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 170
		nsLeft 172
		nsBottom 175
		nsRight 200
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1085 loop: 1 play: rm6)
		(theView view: 680 setLoop: 3 posn: 185 176 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 170
		nsLeft 214
		nsBottom 175
		nsRight 239
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1086 loop: 1 play: rm6)
		(theView view: 680 setLoop: 4 posn: 225 176 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 170
		nsLeft 246
		nsBottom 175
		nsRight 271
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 loop: 1 play: rm6)
		(theView view: 680 setLoop: 2 posn: 257 176 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 182
		nsLeft 19
		nsBottom 188
		nsRight 43
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1087 loop: 1 play: rm6)
		(theView view: 680 setLoop: 5 posn: 31 188 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 182
		nsLeft 45
		nsBottom 188
		nsRight 69
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1086 loop: 1 play: rm6)
		(theView view: 680 setLoop: 6 posn: 56 188 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 182
		nsLeft 71
		nsBottom 188
		nsRight 84
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1088 loop: 1 play: rm6)
		(theView view: 680 setLoop: 7 posn: 77 188 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 182
		nsLeft 87
		nsBottom 188
		nsRight 106
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 loop: 1 play: rm6)
		(theView view: 680 setLoop: 8 posn: 97 188 init:)
	)
)

(instance aWord10 of InterFeature
	(properties
		nsTop 182
		nsLeft 110
		nsBottom 188
		nsRight 138
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1085 loop: 1 play: rm6)
		(theView view: 680 setLoop: 3 posn: 124 188 init:)
	)
)

(instance aWord11 of InterFeature
	(properties
		nsTop 182
		nsLeft 142
		nsBottom 188
		nsRight 194
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1089 loop: 1 play: rm6)
		(theView view: 680 setLoop: 9 posn: 166 188 init:)
	)
)

(instance aWord12 of InterFeature
	(properties
		nsTop 182
		nsLeft 196
		nsBottom 188
		nsRight 210
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 loop: 1 play: rm6)
		(theView view: 680 setLoop: 10 posn: 202 188 init:)
	)
)

(instance aWord13 of InterFeature
	(properties
		nsTop 182
		nsLeft 212
		nsBottom 188
		nsRight 272
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1090 loop: 1 play: rm6)
		(theView view: 680 setLoop: 11 posn: 239 188 init:)
	)
)

(instance aWord14 of InterFeature
	(properties
		nsTop 182
		nsLeft 274
		nsBottom 188
		nsRight 300
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1091 loop: 1 play: rm6)
		(theView view: 680 setLoop: 12 posn: 286 188 init:)
	)
)

(instance aTentDino of InterFeature
	(properties
		nsTop 63
		nsLeft 34
		nsBottom 92
		nsRight 66
	)

	(method (doVerb)
		(gCurRoom setScript: tentDinoScript)
	)
)

(instance aMammouth of InterFeature
	(properties
		x 130
		y 191
		z 100
		nsTop 70
		nsLeft 106
		nsBottom 113
		nsRight 154
	)

	(method (doVerb)
		(if local2
			(gCurRoom setScript: mammouthScript)
		)
	)
)

(instance aBigPine of InterFeature
	(properties
		nsTop 6
		nsLeft 206
		nsBottom 71
		nsRight 249
	)

	(method (doVerb)
		(gCurRoom setScript: bigPineScript)
	)
)

(instance littlePine of InterFeature
	(properties
		nsTop 24
		nsLeft 176
		nsBottom 74
		nsRight 205
	)

	(method (doVerb)
		(gCurRoom setScript: littlePineScript)
	)
)

(instance bucket of InterView
	(properties
		x 250
		y 124
		view 690
		loop 2
		cel 2
		signal 26641
	)

	(method (doVerb)
		(gCurRoom setScript: bucketScript)
	)
)

(instance aCharlie of InterFeature
	(properties
		nsTop 113
		nsLeft 180
		nsBottom 121
		nsRight 211
	)

	(method (doVerb)
		(if local2
			(gCurRoom setScript: charlieScript)
		else
			(gCurRoom setScript: bucketScript)
		)
	)
)

(instance rock of InterView
	(properties
		x 40
		y 175
		view 685
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

(instance mammouth of InterActor
	(properties
		x 111
		y 134
		view 690
		loop 1
		signal 26641
	)

	(method (doVerb)
		(gCurRoom setScript: snakeScript)
	)
)

(instance bush of InterProp
	(properties
		x 80
		y 79
		view 690
		loop 3
		cel 2
		signal 1
	)

	(method (doVerb)
		(gCurRoom setScript: bushScript)
	)
)

(instance slater of InterActor
	(properties
		x 117
		y 136
		view 690
		loop 3
		signal 1
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance charlie of Prop
	(properties
		x 226
		y 147
		view 690
		loop 2
		signal 1
	)
)

(instance potFeature of InterFeature
	(properties
		x 260
		y 75
		nsTop 54
		nsLeft 243
		nsBottom 96
		nsRight 278
	)

	(method (doVerb)
		(gCurRoom setScript: potScript)
	)
)

(instance pot of InterProp
	(properties
		x 257
		y 90
		view 690
		loop 1
		cel 2
		signal 1
	)

	(method (doVerb)
		(gCurRoom setScript: potScript)
	)
)

(instance tentFlap of InterProp
	(properties
		x 49
		y 56
		view 690
		loop 2
		cel 1
		priority 12
		signal 26641
	)

	(method (doVerb)
		(gCurRoom setScript: tentFlapScript)
	)
)

(instance smallPine of Prop
	(properties
		x 196
		y 72
		view 690
		loop 1
		cel 1
		signal 1
	)
)

(instance bigPine of Prop
	(properties
		x 196
		y 72
		view 690
		loop 1
		cel 3
		signal 1
	)
)

(instance coyote of InterProp
	(properties
		x 160
		y 69
		view 690
		priority 2
		signal 4113
	)

	(method (doVerb)
		(gCurRoom setScript: coyoteScript)
	)
)

(instance geyser of InterProp
	(properties
		x 103
		y 78
		view 690
		cel 2
		signal 1
	)

	(method (doVerb)
		(geyser setScript: geyserScript)
	)
)

(instance tentDino of Prop
	(properties
		x 63
		y 68
		view 610
		priority 7
		signal 17
	)
)

(instance foliage of InterActor
	(properties
		x 232
		y 160
		view 690
		cel 1
		priority 13
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: foliageScript)
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
				(= ticks 60)
			)
			(1
				(theView view: 675 setLoop: 0 setCel: 1 posn: 121 176 init:)
				(= ticks 25)
			)
			(2
				(mySound number: 1047 loop: 1 play:)
				(= ticks 70)
			)
			(3
				(theProp view: 675 setLoop: 1 setCel: 1 posn: 243 176 init:)
				(= ticks 52)
			)
			(4
				(theView hide:)
				(= ticks 42)
			)
			(5
				(theView view: 675 setLoop: 2 setCel: 1 posn: 77 188 show:)
				(= ticks 75)
			)
			(6
				(theProp hide:)
				(= ticks 15)
			)
			(7
				(theProp view: 675 setLoop: 3 setCel: 1 posn: 215 188 show:)
				(= ticks 75)
			)
			(8
				(theView hide: dispose:)
				(= ticks 93)
			)
			(9
				(theProp hide: dispose:)
				(= ticks 60)
			)
			(10
				(rock setCel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bigPineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 922)
				(Load rsVIEW 630)
				(bigPine
					view: 630
					setLoop: 0
					cel: 0
					init:
					setCycle: CT 1 1 self
				)
			)
			(1
				(mySound number: 922 loop: 1 play:)
				(bigPine setCycle: CT 5 1 self)
			)
			(2
				(my2Sound number: 980 loop: 1 play:)
				(bigPine setCycle: End self)
			)
			(3
				(bigPine cel: 4 setCycle: Beg)
				(= local1 1)
				(self setScript: littlePineScript)
			)
		)
	)
)

(instance coyoteScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 928 loop: 1 play:)
				(coyote view: 605 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(mySound number: 1008 loop: 1 play: self)
			)
			(2
				(mySound number: 928 loop: 1 play:)
				(coyote setCycle: Beg self)
			)
			(3
				(coyote view: 690 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tentFlapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 932)
				(Load rsVIEW 645)
				(mySound number: 945 setLoop: 1 play:)
				(tentFlap
					view: 645
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(mySound number: 932 setLoop: 1 play: self)
				(tentFlap setLoop: 1 cel: 0 cycleSpeed: 3 setCycle: Fwd)
			)
			(2
				(mySound play: self)
			)
			(3
				(mySound number: 945 loop: 1 play:)
				(tentFlap setLoop: 2 cel: 0 cycleSpeed: 6 setCycle: CT 8 1 self)
				(Load rsSOUND 924)
			)
			(4
				(mySound number: 904 loop: 1 play:)
				(tentFlap setCycle: End self)
			)
			(5
				(= ticks 10)
			)
			(6
				(tentFlap view: 690 setLoop: 2 cel: 1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance potScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pot view: 635 setLoop: 0 setCel: 0 init: setCycle: CT 1 1 self)
			)
			(1
				(mySound number: 944 play: setLoop: -1)
				(pot setCycle: End self)
			)
			(2
				(mySound number: 1167 play: setLoop: -1)
				(pot setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(mySound number: 953 loop: -1 play:)
				(= cycles 2)
			)
			(4
				(pot setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				((= register (Actor new:))
					view: 635
					setLoop: 3
					posn: 186 91
					ignoreActors: 1
					illegalBits: 0
					init:
					setCycle: Fwd
					setStep: 8 8
					setMotion: MoveTo 44 74 self
				)
				(pot setLoop: 1 cycleSpeed: 8 setCycle: Fwd)
				(mySound number: 1005 setLoop: -1 play:)
			)
			(6
				(register dispose:)
				(mySound number: 944 loop: -1 play:)
				(= ticks 50)
			)
			(7
				(mySound stop:)
				(pot dispose:)
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
				(Load rsVIEW 650)
				(Load rsSOUND 957)
				(slater
					view: 650
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(1
				(slater cel: 5 forceUpd:)
				(my2Sound number: 957 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(slater setCycle: CT 3 -1 self)
			)
			(3
				(my2Sound number: 956 setLoop: 1 play:)
				(= ticks 100)
			)
			(4
				(slater setCycle: CT 7 1 self)
			)
			(5
				(my2Sound number: 956 setLoop: 1 play:)
				(= ticks 100)
			)
			(6
				(slater setCycle: End self)
			)
			(7
				(mySound number: 1003 loop: -1 play:)
				(slater setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(slater setLoop: 2 cel: 0 setCycle: End self)
				(Load rsVIEW 651)
			)
			(9
				(= ticks 30)
			)
			(10
				(my2Sound number: 934 setLoop: 1 play:)
				(slater view: 651 setLoop: 0 cel: 0 cycleSpeed: 6)
				(= ticks 30)
			)
			(11
				(slater cel: 1)
				(= ticks 20)
			)
			(12
				(my2Sound number: 914 setLoop: 1 play:)
				(slater cycleSpeed: 6 setCycle: CT 5 1 self)
			)
			(13
				(mySound number: 1004 setLoop: 1 play:)
				(slater setCycle: CT 8 1 self)
			)
			(14
				(= ticks 30)
			)
			(15
				(mySound number: 1005 setLoop: -1 play:)
				(slater setCycle: End self)
			)
			(16
				(my2Sound number: 941 setLoop: 1 play:)
				(slater hide: dispose:)
				(mySound stop:)
				(mammouth init:)
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bushScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bush view: 660 setLoop: 0 cel: 0 setCycle: CT 6 1 self)
			)
			(1
				(mySound number: 982 loop: 1 play:)
				(bush setCycle: CT 10 1 self)
			)
			(2
				(bush view: 690 setLoop: 3 cel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bucketScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(charlie view: 600 setLoop: 0 cel: 0 setCycle: CT 4 1 self)
				(bucket hide:)
			)
			(1
				(mySound number: 997 loop: 1 play:)
				(charlie setCycle: CT 14 1 self)
			)
			(2
				(bucket show:)
				(charlie cel: 15)
				(= cycles 2)
			)
			(3
				(mySound number: 957 loop: 1 play:)
				(charlie setLoop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(4
				(= ticks 50)
			)
			(5
				(charlie setCycle: CT 5 1 self)
			)
			(6
				(= ticks 50)
			)
			(7
				(charlie setCycle: CT 11 1 self)
			)
			(8
				(mySound number: 991 loop: 1 play:)
				(= ticks 100)
			)
			(9
				(charlie setCycle: End self)
			)
			(10
				(mySound number: 1003 loop: 1 play:)
				(charlie view: 601 setLoop: 0 cel: 0 setCycle: End self)
			)
			(11
				(charlie setLoop: 1 cel: 7)
				(= ticks 50)
			)
			(12
				(charlie cel: 0 setCycle: CT 7 1 self)
			)
			(13
				(= ticks 100)
			)
			(14
				(charlie setCycle: End self)
			)
			(15
				(charlie view: 690 setLoop: 2 cel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mammouth
					view: 655
					setLoop: 0
					setPri: -1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(1
				(mySound number: 910 loop: 1 play:)
				(mammouth setCycle: End self)
			)
			(2
				(mySound number: 933 loop: -1 play:)
				(gLongSong number: 112 setLoop: -1 play:)
				(mammouth
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 1
					setStep: 20 20
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 320 158 self
				)
			)
			(3
				(= ticks 60)
			)
			(4
				(mammouth
					posn: 320 75
					cycleSpeed: 3
					setStep: 10 10
					setLoop: 2
					setPri: 3
					setMotion: MoveTo 20 75 self
				)
			)
			(5
				(= ticks 60)
			)
			(6
				(mammouth
					posn: 0 134
					cycleSpeed: 3
					setStep: 20 20
					setLoop: 1
					setPri: -1
					setMotion: MoveTo 111 134 self
				)
			)
			(7
				(mySound number: 951 setLoop: 1 play:)
				(mammouth setLoop: 0 cel: 6 cycleSpeed: 8 setCycle: Beg self)
			)
			(8
				(mammouth view: 690 setLoop: 1 cel: 0 posn: 111 134 stopUpd:)
				(gLongSong number: 111 loop: -1 play:)
				(= ticks 30)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mammouthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(mammouth
					view: 625
					setLoop: 0
					cel: 0
					posn: 127 134
					setPri: 12
					setCycle: CT 4 1 self
				)
			)
			(1
				(mySound number: 1003 loop: 1 play:)
				(mammouth setCycle: End self)
			)
			(2
				(mammouth setLoop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(mySound number: 992 loop: 1 play: self)
			)
			(4
				(mammouth setCycle: CT 4 1 self)
				(Load rsSOUND 915)
			)
			(5
				(mySound number: 960 setLoop: 1 play:)
				(if (< (mammouth cel:) (mammouth lastCel:))
					(-- state)
				)
				(= ticks 8)
				(if (not register)
					(= register 1)
					(mammouth cycleSpeed: 6 setCycle: End)
				)
			)
			(6
				(= ticks 20)
			)
			(7
				(mySound stop:)
				(mammouth view: 690 setLoop: 1 cel: 0 posn: 111 134 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foliageScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 950)
				(Load rsVIEW 615)
				(foliage
					view: 615
					setLoop: 0
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					moveSpeed: 5
					setMotion: MoveTo 232 158 self
				)
			)
			(1
				(mySound number: 950 loop: 1 play:)
				(foliage setMotion: MoveTo 232 122 self)
			)
			(2
				(mySound number: 1012 loop: 1 play:)
				(foliage setCycle: CT 13 1 self)
			)
			(3
				(mySound number: 956 setLoop: 1 play: self)
			)
			(4
				(mySound number: 925 loop: 1 play:)
				(foliage setCycle: End self)
			)
			(5
				(foliage setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(foliage setLoop: 2 cel: 0 setCycle: End self)
			)
			(7
				(mySound number: 951 loop: 1 play:)
				(foliage setLoop: 0 cel: 0 setMotion: MoveTo 232 160 self)
			)
			(8
				(foliage view: 690 setLoop: 0 cel: 1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance littlePineScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 962)
				(Load rsVIEW 631)
				(my2Sound number: 904 loop: 1 play:)
				(smallPine view: 631 setLoop: 0 cel: 0 cycleSpeed: 8)
				(= ticks 5)
			)
			(1
				(if local1
					(smallPine setCycle: CT 1 1 self)
					(= local1 0)
				else
					(smallPine init: setCycle: CT 1 1 self)
				)
			)
			(2
				(my2Sound number: 930 loop: 1 play:)
				(smallPine setCycle: CT 4 1 self)
			)
			(3
				(my2Sound number: 915 play: setLoop: 1)
				(smallPine view: 632 setLoop: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(4
				(mySound number: 991 loop: 1 play:)
				(smallPine setCycle: End self)
			)
			(5
				(smallPine view: 690 setLoop: 1 cel: 1 stopUpd:)
				(bigPine view: 690 setLoop: 1 cel: 3 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tentDinoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 0)
				(Load rsVIEW 610)
				(Load rsSOUND 1006)
				(tentDino view: 610 init: setLoop: 0 cel: 0 posn: 57 73)
				(= ticks 50)
			)
			(1
				(tentDino cycleSpeed: 4 setCycle: CT 2 1 self)
			)
			(2
				(mySound number: 956 loop: 1 play:)
				(= ticks 20)
			)
			(3
				(tentDino setCycle: CT 0 -1 self)
			)
			(4
				(= ticks 20)
			)
			(5
				(tentDino cel: 4 setCycle: CT 7 1 self)
			)
			(6
				(= ticks 25)
			)
			(7
				(tentDino cel: 8 setPri: 12 setCycle: CT 10 1 self)
				(mySound number: 1006 loop: 1 play:)
			)
			(8
				(my2Sound number: 941 setLoop: 1 play:)
				(tentDino setCycle: End self)
				(= ticks 30)
			)
			(9)
			(10
				(if (< (++ register) 9)
					(-- state)
				)
				(tentDino loop: 1 cel: register)
				(if (OneOf register 1 5)
					(mySound number: 956 loop: 1 play:)
				)
				(if (OneOf register 3 7)
					(mySound number: 957 loop: 1 play:)
				)
				(= ticks (Random 15 20))
			)
			(11
				(mySound number: 946 setLoop: 1 play:)
				(tentDino setLoop: 2 cel: 0 setCycle: End self)
			)
			(12
				(mySound stop:)
				(tentDino dispose:)
				(gGame handsOn:)
				(UnLoad 132 924)
				(UnLoad 132 1006)
				(UnLoad 132 946)
				(UnLoad 132 961)
				(UnLoad 132 951)
				(self dispose:)
			)
		)
	)
)

(instance geyserScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(geyser view: 620 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(gCurRoom setScript: geyser2)
				(geyser setLoop: 3 setCycle: Fwd)
				(= ticks 100)
			)
			(2
				(geyser setLoop: 4 setCycle: Fwd)
				(= ticks 50)
			)
			(3
				(geyser setLoop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(4
				(gCurRoom setScript: 0)
				(geyser setCycle: CT 4 1 self)
				(mySound number: 924 setLoop: 1 play:)
				(= ticks 6)
			)
			(5
				(my2Sound number: 1001 play: setLoop: 1)
				(geyser setCycle: CT 15 1 self)
			)
			(6
				(geyser setLoop: 2 cel: 0 setCycle: CT 7 1 self)
			)
			(7
				(my2Sound number: 941 play: setLoop: 1)
				(geyser setCycle: CT 10 1 self)
			)
			(8
				(geyser view: 690 setLoop: 0 cel: 2 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance geyser2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySound number: 944 loop: 1 play:)
				(-- state)
				(= ticks (Random 10 20))
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
				(Load rsSOUND 1003)
				(Load rsVIEW 665)
				(mySound number: 1003 loop: 1 play:)
				(charlie
					view: 665
					loop: 0
					cel: 0
					x: 216
					y: 129
					cycleSpeed: 8
					setCycle: CT 9 1 self
				)
			)
			(1
				(mammouth hide:)
				(charlie setCycle: CT 11 1 self)
			)
			(2
				(mySound number: 992 loop: 1 play: self)
			)
			(3
				(charlie cel: 12)
				(= ticks 50)
			)
			(4
				(mySound number: 934 loop: 1 play:)
				(charlie setLoop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(5
				(mySound number: 941 loop: 1 play:)
				(charlie setCycle: CT 7 1 self)
			)
			(6
				(charlie setCycle: End self)
				(mammouth show:)
			)
			(7
				(charlie view: 690 setLoop: 2 cel: 0 x: 226 y: 147 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

