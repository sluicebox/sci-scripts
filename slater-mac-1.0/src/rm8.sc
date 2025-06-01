;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use CycleBet)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm8 0
)

(local
	local0
	local1
	local2 = 1
	[local3 4]
)

(instance rm8 of Rm
	(properties
		picture 800
		style 10
	)

	(method (cue)
		(theView hide: dispose:)
		(gGame handsOn:)
		(super cue:)
	)

	(method (init)
		(aMountain init: setOnMeCheck: 1 16384)
		(path init: setOnMeCheck: 1 4)
		(sky init: setOnMeCheck: 1 16)
		(mouseHole init: setOnMeCheck: 1 2)
		(cave init:)
		(super init:)
		(bigCliffRock init:)
		(smallCliffRock init:)
		(smallCliffRock2 init:)
		(slater init:)
		(bird init:)
		(charlie init:)
		(aJogger init:)
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
		(rock init:)
		(dog init:)
		(pineapple init:)
		(rubber init:)
		(climber init:)
		(bigRock init:)
		(gLongSong number: 150 setLoop: -1 play: 10 fade: 127 10 30 0)
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
		(my3Sound dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade: 0 10 30 1)
		(super newRoom: newRoomNumber)
	)
)

(instance aWord0 of InterFeature
	(properties
		nsTop 170
		nsLeft 84
		nsBottom 176
		nsRight 121
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1054 loop: 1 play: rm8)
		(theView view: 860 setLoop: 0 posn: 101 177 init:)
	)
)

(instance aWord1 of InterFeature
	(properties
		nsTop 170
		nsLeft 123
		nsBottom 176
		nsRight 175
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1095 loop: 1 play: rm8)
		(theView view: 860 setLoop: 1 posn: 148 177 init:)
	)
)

(instance aWord2 of InterFeature
	(properties
		nsTop 170
		nsLeft 175
		nsBottom 176
		nsRight 188
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1058 loop: 1 play: rm8)
		(theView view: 860 setLoop: 2 posn: 182 177 init:)
	)
)

(instance aWord3 of InterFeature
	(properties
		nsTop 170
		nsLeft 189
		nsBottom 176
		nsRight 212
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1096 loop: 1 play: rm8)
		(theView view: 860 setLoop: 3 posn: 201 177 init:)
	)
)

(instance aWord4 of InterFeature
	(properties
		nsTop 170
		nsLeft 216
		nsBottom 176
		nsRight 242
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1097 loop: 1 play: rm8)
		(theView view: 860 setLoop: 4 posn: 228 177 init:)
	)
)

(instance aWord5 of InterFeature
	(properties
		nsTop 180
		nsLeft 65
		nsBottom 189
		nsRight 102
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1098 loop: 1 play: rm8)
		(theView view: 860 setLoop: 5 posn: 84 189 init:)
	)
)

(instance aWord6 of InterFeature
	(properties
		nsTop 180
		nsLeft 104
		nsBottom 189
		nsRight 150
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1056 loop: 1 play: rm8)
		(theView view: 860 setLoop: 6 posn: 125 189 init:)
	)
)

(instance aWord7 of InterFeature
	(properties
		nsTop 180
		nsLeft 151
		nsBottom 189
		nsRight 200
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1099 loop: 1 play: rm8)
		(theView view: 860 setLoop: 7 posn: 175 189 init:)
	)
)

(instance aWord8 of InterFeature
	(properties
		nsTop 180
		nsLeft 202
		nsBottom 189
		nsRight 224
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1061 loop: 1 play: rm8)
		(theView view: 860 setLoop: 8 posn: 213 189 init:)
	)
)

(instance aWord9 of InterFeature
	(properties
		nsTop 180
		nsLeft 226
		nsBottom 189
		nsRight 258
	)

	(method (doVerb)
		(gGame handsOff:)
		(mySound number: 1100 loop: 1 play: rm8)
		(theView view: 860 setLoop: 9 posn: 243 189 init:)
	)
)

(instance path of InterFeature
	(properties
		x 166
		z -81
		nsTop 3
		nsLeft 42
		nsBottom 160
		nsRight 290
	)

	(method (doVerb)
		(if (not local2)
			(gCurRoom setScript: aJoggerScript)
		)
	)
)

(instance sky of InterFeature
	(properties
		x 160
		y 56
		nsTop -1
		nsLeft 33
		nsBottom 114
		nsRight 288
	)

	(method (doVerb)
		(gCurRoom setScript: helloScript)
	)
)

(instance aMountain of InterFeature
	(properties
		x 175
		y 157
		nsTop 27
		nsLeft 145
		nsBottom 83
		nsRight 197
	)

	(method (doVerb)
		(gCurRoom setScript: birdScript)
	)
)

(instance aJogger of InterFeature
	(properties
		nsTop 21
		nsLeft 250
		nsBottom 51
		nsRight 288
	)

	(method (doVerb)
		(if (not local2)
			(gCurRoom setScript: aJoggerScript)
		else
			(gCurRoom setScript: slaterScript)
		)
	)
)

(instance cave of InterFeature
	(properties
		nsTop 116
		nsLeft 226
		nsBottom 159
		nsRight 246
	)

	(method (doVerb)
		(gCurRoom setScript: caveScript)
	)
)

(instance mouseHole of InterFeature
	(properties
		x 116
		y 95
		nsTop 85
		nsLeft 101
		nsBottom 105
		nsRight 131
	)

	(method (doVerb)
		(gCurRoom setScript: mouseScript)
	)
)

(instance rock of InterView
	(properties
		x 71
		y 177
		view 865
		loop 3
		priority 15
		signal 17
	)

	(method (doVerb)
		(gCurRoom setScript: rockScript)
	)
)

(instance bigRock of InterProp
	(properties
		x 261
		y 35
		view 870
		loop 3
		cel 1
		priority 9
		signal 24593
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance bigCliffRock of InterProp
	(properties
		x 264
		y 142
		view 845
		loop 1
		priority 11
		signal 28689
	)

	(method (doVerb)
		(gCurRoom setScript: cliffScript 0 self)
	)
)

(instance smallCliffRock of InterProp
	(properties
		x 268
		y 153
		view 845
		priority 10
		signal 28689
	)

	(method (doVerb)
		(gCurRoom setScript: cliffScript 0 self)
	)
)

(instance smallCliffRock2 of InterProp
	(properties
		x 259
		y 173
		view 845
		priority 10
		signal 28689
	)

	(method (doVerb)
		(gCurRoom setScript: cliffScript 0 self)
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

(instance runningBird of Actor
	(properties
		view 875
		priority 11
		signal 16401
	)
)

(instance dynomite of Prop ; UNUSED
	(properties
		x 264
		y 141
		view 845
		signal 16385
	)
)

(instance rollingRock of Actor
	(properties
		view 840
	)
)

(instance pineapple of InterActor
	(properties
		x 52
		y 116
		view 870
		loop 1
		priority 8
		signal 28688
	)

	(method (doVerb)
		(gCurRoom setScript: pineappleScript)
	)
)

(instance dog of InterProp
	(properties
		x 224
		y 105
		view 870
		loop 2
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: dinoDogScript)
	)
)

(instance bird of InterProp
	(properties
		x 156
		y 62
		view 870
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: birdScript)
	)
)

(instance charlie of InterProp
	(properties
		x 224
		y 105
		view 870
		cel 1
		priority 9
		signal 22545
	)

	(method (doVerb)
		(gCurRoom setScript: charlieScript)
	)
)

(instance slater of InterProp
	(properties
		x 204
		y 108
		view 870
		loop 3
		signal 20481
	)

	(method (doVerb)
		(gCurRoom setScript: slaterScript)
	)
)

(instance climber of InterActor
	(properties
		x 52
		y 107
		view 870
		loop 1
		cel 4
		priority 2
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: mountainScript)
	)
)

(instance rubber of InterProp
	(properties
		x 100
		y 110
		view 870
		loop 1
		cel 1
		priority 7
		signal 20497
	)

	(method (doVerb)
		(gCurRoom setScript: rubberScript)
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
				(gGame handsOff:)
				(theView view: 855 setLoop: 0 cel: 1 posn: 131 177 init:)
				(mySound number: 1049 loop: 1 play:)
				(= ticks 18)
			)
			(2
				(gGame handsOff:)
				(theProp view: 855 setLoop: 1 cel: 1 posn: 213 177 init:)
				(= ticks 31)
			)
			(3
				(oddView view: 855 setLoop: 2 cel: 1 posn: 109 189 init:)
				(= ticks 19)
			)
			(4
				(theView hide:)
				(= ticks 31)
			)
			(5
				(theProp hide: dispose:)
				(theView view: 855 setLoop: 3 cel: 1 posn: 205 189 show:)
				(= ticks 51)
			)
			(6
				(oddView hide: dispose:)
				(= ticks 60)
			)
			(7
				(theView hide: dispose:)
				(rock setCel: 0 stopUpd:)
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
				(mySound number: 951 loop: 1 play:)
				(charlie
					view: 805
					setLoop: 0
					cel: 0
					x: 238
					y: 105
					setCycle: CT 5 1 self
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(charlie setCycle: CT 7 1 self)
			)
			(3
				(mySound number: 957 loop: 1 play:)
				(charlie setCycle: CT 5 -1 self)
			)
			(4
				(= ticks 60)
			)
			(5
				(charlie setCycle: Beg self)
			)
			(6
				(mySound stop:)
				(charlie view: 870 setLoop: 0 cel: 1 x: 224 y: 105 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance cliffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(register setCycle: CT 1 1 self)
			)
			(1
				(register setCycle: End self)
				(mySound number: 1152 loop: 1 play: self)
			)
			(2)
			(3
				(register dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance birdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bird view: 800 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(1
				(mySound number: 985 setLoop: 1 play:)
				(bird setCycle: CT 10 1 self)
			)
			(2
				(mySound number: 929 setLoop: 1 play: self)
				(bird setCycle: CycleBet 9 14 -1)
			)
			(3
				(bird cel: 14 setCycle: End self)
			)
			(4
				(= ticks 60)
			)
			(5
				(bird setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(6
				(mySound number: 929 setLoop: 1 play: self)
				(bird setCycle: CycleBet 3 8 -1)
			)
			(7
				(bird cel: 9 setCycle: CT 11 1 self)
			)
			(8
				(bird setLoop: 0 cel: 5 setCycle: CT 3 -1 self)
			)
			(9
				(bird setCycle: Beg self)
				(mySound number: 968 setLoop: 1 play:)
			)
			(10
				(bird view: 870 setLoop: 0 cel: 0 forceUpd: stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rollingRockScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rollingRock setMotion: MoveTo 277 31 self)
			)
			(1
				(rollingRock setMotion: MoveTo 245 48 self)
			)
			(2
				(rollingRock setMotion: MoveTo 207 82 self)
			)
			(3
				(rollingRock setMotion: MoveTo 156 109 self)
			)
			(4
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
				(= local2 0)
				(slater view: 835 setLoop: 0 cel: 0 setCycle: CT 10 1 self)
				(Load rsSOUND 976)
			)
			(1
				(Load rsSOUND 984)
				(Load rsVIEW 838)
				(slater setCycle: End self)
				(mySound number: 976 setLoop: 1 play: self)
			)
			(2)
			(3
				(charlie view: 838 setLoop: 1 setCycle: Fwd cycleSpeed: 0)
				(bigRock view: 838 setLoop: 2 setCycle: Fwd cycleSpeed: 0)
				(my2Sound number: 984 setLoop: -1 play:)
				(Load rsVIEW 836)
				(= ticks 10)
			)
			(4
				(UnLoad 128 835)
				(slater
					view: 836
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(5
				(UnLoad 128 838)
				(mySound number: 991 setLoop: 1 play:)
				(slater setCycle: End self)
			)
			(6
				(slater view: 838 setLoop: 0 cycleSpeed: 0 setCycle: Fwd)
				(Load rsVIEW 839)
				(= ticks 60)
			)
			(7
				(charlie view: 870 setCycle: 0 setLoop: 0 cel: 1 x: 224 y: 105)
				(bigRock setCycle: 0 dispose:)
				(slater
					view: 839
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
				(Load rsVIEW 837)
				(Load rsSOUND 1019)
				(Load rsSOUND 915)
			)
			(8
				(mySound number: 1019 loop: 1 play:)
				(slater cycleSpeed: 4 setCycle: CT 7 1 self)
				(charlie
					view: 837
					setLoop: 0
					cel: 0
					cycleSpeed: 6
					x: 224
					y: 105
					setCycle: End
				)
			)
			(9
				(mySound number: 915 setLoop: 1 play:)
				(slater cycleSpeed: 4 setCycle: End self)
			)
			(10
				(slater posn: 181 82)
				(= cycles 1)
			)
			(11
				(slater posn: 168 64)
				(= cycles 1)
			)
			(12
				(slater posn: 151 32)
				(= cycles 1)
			)
			(13
				(slater dispose:)
				(my2Sound stop:)
				(= ticks 60)
			)
			(14
				(charlie
					view: 871
					setLoop: 1
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(15
				(charlie view: 870 setLoop: 0 cel: 1 x: 224 y: 105 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mouseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(charlie
					view: 825
					setLoop: 0
					cel: 0
					x: 224
					y: 105
					cycleSpeed: 14
					setCycle: CT 1 1 self
				)
			)
			(1
				(mySound number: 1021 loop: -1 play:)
				(charlie setCycle: CT 2 1 self)
			)
			(2
				(charlie cycleSpeed: 6 setCycle: CT 9 1 self)
			)
			(3
				(my2Sound number: 1014 loop: 1 play:)
				(charlie setCycle: CT 14 1 self)
			)
			(4
				(my3Sound number: 960 setLoop: 1 play:)
				(charlie cel: 15)
				(= cycles 2)
			)
			(5
				(charlie setLoop: 1 cel: 0 x: 224 y: 110 cel: 0)
				(= cycles 2)
			)
			(6
				(my3Sound number: 960 setLoop: 1 play:)
				(charlie setCycle: CT 4 1 self)
			)
			(7
				(my2Sound number: 1014 loop: 1 play:)
				(charlie setCycle: CT 6 1 self)
			)
			(8
				(mySound stop:)
				(charlie x: 224 y: 105 cel: 7 setCycle: CT 11 1 self)
				(my3Sound number: 960 setLoop: 1 play:)
			)
			(9
				(= ticks 75)
			)
			(10
				(charlie setCycle: End self)
			)
			(11
				(mySound stop:)
				(charlie view: 870 setLoop: 0 cel: 1 x: 224 y: 105 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pineappleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pineapple view: 815 setLoop: 0 cel: 0 setCycle: End self)
				(= cycles 2)
			)
			(1
				(mySound number: 1020 loop: -1 play:)
			)
			(2
				(pineapple
					setLoop: 1
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 88 39 self
				)
			)
			(3
				(my2Sound number: 904 loop: 1 play:)
				(pineapple setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(pineapple setLoop: 3 setCycle: Fwd)
				(= ticks 30)
			)
			(5
				((= register (Actor new:))
					name: {birdie}
					view: 815
					setLoop: 4
					setPri: 9
					cel: 0
					posn: (+ (pineapple x:) 9) 52
					ignoreActors: 1
					illegalBits: 0
					init:
					setCycle: CT 4 1 self
				)
				(Load rsSOUND 937)
			)
			(6
				(my3Sound number: 937 setLoop: 1 play:)
				(register setCycle: CT 7 1 self)
			)
			(7
				(my2Sound number: 928 setLoop: 1 play:)
				(register setCycle: End self)
			)
			(8
				(register
					setLoop: 6
					posn: (+ (register x:) 26) 40
					setCycle: Fwd
					moveSpeed: 5
					cycleSpeed: 6
					setPri: 4
					setMotion: MoveTo (Random 130 150) 92
				)
				(my2Sound number: 1001 setLoop: 1 play: self)
			)
			(9
				(register
					setLoop: 5
					posn: (+ (pineapple x:) 12) 53
					cel: 0
					setPri: 9
					setCycle: CT 4 1 self
				)
				(Load rsSOUND 938)
			)
			(10
				(my3Sound number: 938 setLoop: 1 play:)
				(register setCycle: CT 7 1 self)
			)
			(11
				(my2Sound number: 928 setLoop: 1 play:)
				(register setCycle: End self)
			)
			(12
				(register
					setLoop: 6
					posn: (- (register x:) 23) 39
					setCycle: Fwd
					moveSpeed: 5
					cycleSpeed: 6
					setPri: 4
					setMotion: MoveTo (Random 80 110) 92
				)
				(my2Sound number: 1001 setLoop: 1 play: self)
			)
			(13
				(register
					setLoop: 4
					setPri: 9
					cel: 0
					posn: (+ (pineapple x:) 9) 52
					setCycle: CT 4 1 self
				)
				(Load rsSOUND 937)
			)
			(14
				(my3Sound number: 937 setLoop: 1 play:)
				(register setCycle: CT 7 1 self)
			)
			(15
				(my2Sound number: 928 loop: 1 play:)
				(register setCycle: End self)
			)
			(16
				(register
					setLoop: 6
					posn: (+ (register x:) 26) 40
					setCycle: Fwd
					moveSpeed: 5
					cycleSpeed: 6
					setPri: 4
					setMotion: MoveTo (Random 130 150) 92
				)
				(my2Sound number: 1001 setLoop: 1 play: self)
			)
			(17
				(register dispose:)
				(pineapple
					setLoop: 2
					cel: (pineapple lastCel:)
					setCycle: Beg self
				)
				(my2Sound number: 904 loop: 1 play:)
			)
			(18
				(pineapple
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 57 105 self
				)
			)
			(19
				(pineapple setMotion: MoveTo 52 116 self)
			)
			(20
				(pineapple setLoop: 0 cel: 15 setCycle: CT 5 -1 self)
			)
			(21
				(mySound fade: 0 10 30 1)
				(pineapple setCycle: Beg self)
			)
			(22
				(gLongSong number: 113 setLoop: -1 play:)
				(pineapple
					view: 870
					setLoop: 1
					cel: 0
					x: 52
					y: 116
					setCycle: 0
					forceUpd:
					stopUpd:
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rubberScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rubber
					view: 820
					setLoop: 4
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(mySound number: 950 loop: 1 play:)
			)
			(1
				(rubber setLoop: 0 cel: 0 setCycle: CT 7 1 self)
				(Load rsSOUND 980)
			)
			(2
				(gLongSong pause: 1)
				(mySound number: 980 loop: -1 play:)
				(rubber cycleSpeed: 4 setCycle: End self)
			)
			(3
				(rubber setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(rubber setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(rubber setLoop: 3 cel: 0 cycleSpeed: 8 setCycle: End self)
			)
			(6
				(gLongSong pause: 0)
				(mySound stop:)
				(rubber setLoop: 4 cel: 5)
				(= ticks 50)
			)
			(7
				(mySound number: 951 loop: 1 play: self)
				(rubber setCycle: Beg self)
			)
			(8)
			(9
				(rubber view: 870 setLoop: 1 cel: 1 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aJoggerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 984 setLoop: -1 play:)
				(= ticks 30)
			)
			(1
				(runningBird
					init:
					setCycle: Fwd
					setLoop: 0
					setPri: 8
					ignoreActors: 1
					illegalBits: 0
					posn: 307 18
					moveSpeed: 3
					setMotion: MoveTo 263 40 self
				)
			)
			(2
				(runningBird setMotion: MoveTo 231 59 self)
			)
			(3
				(runningBird setMotion: MoveTo 192 89 self)
			)
			(4
				(runningBird setMotion: MoveTo 144 115 self)
			)
			(5
				(runningBird
					setLoop: 2
					cel: 0
					setCycle: 0
					setPri: 9
					setCycle: End self
				)
			)
			(6
				(mySound number: 1022 setLoop: -1 play:)
				(runningBird setLoop: 3 setCycle: Fwd)
				(= ticks 200)
			)
			(7
				(runningBird
					setLoop: 1
					setCycle: Fwd
					posn: 147 119
					setPri: 13
					setMotion: MoveTo 265 204 self
				)
				(mySound number: 984 setLoop: -1 play:)
			)
			(8
				(mySound stop:)
				(runningBird dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mountainScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(climber view: 830 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(mySound number: 978 setLoop: 1 play:)
				(climber setCycle: End self)
			)
			(2
				(climber setLoop: 1 cel: 0 setCycle: CT 9 1 self)
			)
			(3
				(mySound number: 978 loop: 1 play:)
				(climber setCycle: End self)
			)
			(4
				(climber setLoop: 2 cel: 0 setCycle: CT 5 1 self)
			)
			(5
				(mySound number: 978 loop: 1 play:)
				(climber setCycle: End self)
			)
			(6
				(climber setLoop: 3 cel: 0 setCycle: CT 1 1 self)
			)
			(7
				(mySound number: 978 loop: 1 play:)
				(climber setCycle: CT 8 1 self)
			)
			(8
				(mySound number: 912 loop: 1 play:)
				(climber setCycle: End self)
			)
			(9
				(= ticks 30)
			)
			(10
				(mySound number: 942 loop: 1 play:)
				(climber setLoop: 4 cel: 0 setCycle: Fwd)
				(= ticks 50)
			)
			(11
				(climber moveSpeed: 5 setMotion: MoveTo 52 174 self)
			)
			(12
				(climber hide: dispose:)
				(mySound stop:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance helloScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mySound number: 976 setLoop: 1 play:)
				((= [local3 1] (Prop new:))
					name: {hello}
					view: 871
					setLoop: 0
					cel: 0
					x: 62
					y: 30
					init:
					setCycle: End
				)
				(= ticks 30)
			)
			(1
				([local3 1] dispose:)
				((= [local3 2] (Prop new:))
					name: {hello}
					view: 871
					setLoop: 0
					cel: 0
					x: 79
					y: 39
					init:
					setCycle: End
				)
				(= ticks 40)
			)
			(2
				([local3 2] dispose:)
				((= [local3 3] (Prop new:))
					name: {hello}
					view: 871
					setLoop: 0
					cel: 0
					x: 89
					y: 46
					init:
					setCycle: End self
				)
			)
			(3
				([local3 3] dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dinoDogScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsSOUND 1003)
				(Load rsVIEW 810)
				(dog
					view: 810
					setLoop: 0
					cel: 0
					setPri: 10
					ignoreActors: 1
					x: 224
					y: 105
					setCycle: End self
				)
				(= cycles 2)
			)
			(1
				(mySound number: 928 loop: 1 play: self)
			)
			(2
				(mySound number: 1023 loop: -1 play:)
				(dog view: 812 setLoop: 1 setCycle: Fwd)
				(Load rsVIEW 811)
				(= ticks 150)
			)
			(3
				(charlie
					view: 811
					setLoop: 0
					cel: 0
					ignoreActors: 1
					x: 224
					y: 105
					setCycle: CT 4 1 self
				)
			)
			(4
				(dog
					view: 811
					setLoop: 0
					cel: 11
					setPri: 10
					x: 224
					y: 105
					setPri: -1
					hide:
				)
				(mySound number: 947 loop: 1 play:)
				(charlie setCycle: CT 8 1 self)
			)
			(5
				(mySound number: 904 loop: 1 play:)
				(charlie setCycle: CT 9 1 self)
			)
			(6
				(charlie view: 870 loop: 0 cel: 1 x: 224 y: 105 forceUpd:)
				(dog
					view: 811
					setLoop: 0
					cel: 9
					setPri: 10
					x: 224
					y: 105
					show:
					forceUpd:
				)
				(= cycles 2)
			)
			(7
				(dog cel: 10 ignoreActors: 1 x: 224 y: 105 setCycle: End self)
				(mySound number: 991 loop: 1 play:)
			)
			(8
				(= ticks 100)
			)
			(9
				(mySound number: 930 loop: 1 play:)
				(dog
					view: 813
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					x: 224
					y: 105
					setCycle: CT 5 1 self
				)
			)
			(10
				(mySound number: 914 loop: 1 play:)
				(dog setCycle: End self)
			)
			(11
				(dog view: 870 setLoop: 2 cel: 0 x: 224 y: 105 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance caveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 850)
				(mySound number: 950 loop: 1 play:)
				(= ticks 20)
			)
			(1
				((= register (Prop new:))
					name: {caveDino}
					view: 850
					setLoop: 0
					cel: 0
					x: 231
					y: 145
					setPri: 10
					ignoreActors: 1
					init:
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(2
				(register setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(mySound number: 957 loop: 1 play:)
				(= ticks 10)
			)
			(4
				(register setCycle: Beg self)
			)
			(5
				(charlie
					view: 850
					setLoop: 1
					cel: 0
					x: 242
					y: 143
					setCycle: CT 1 1 self
				)
			)
			(6
				(mySound number: 1014 loop: 1 play:)
				(charlie setCycle: CT 7 1 self)
			)
			(7
				(= ticks 30)
			)
			(8
				(mySound number: 951 loop: 1 play:)
				(register cycleSpeed: 6 setLoop: 0 cel: 4 setCycle: Beg self)
			)
			(9
				(register dispose:)
				(= ticks 50)
			)
			(10
				(charlie setCycle: End self)
			)
			(11
				(charlie view: 870 setLoop: 0 cel: 1 x: 224 y: 105 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

