;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use eRS)
(use Scaler)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm660 0
)

(local
	local0 = 1
	local1
	local2
)

(instance rm660 of FPRoom
	(properties
		noun 25
		picture 660
		south 230
	)

	(method (init)
		(gEgo init: setScale: Scaler 100 73 159 110 normalize:)
		(switch gPrevRoomNum
			(south
				(self setScript: sEnterRoom)
			)
			(235
				(self setScript: sEnterRoom)
			)
			(680
				(gGame handsOn:)
			)
			(else
				(= style 100)
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 134 0 0 319 0 319 189 0 189 0 146 95 162 101 165 217 165 198 150 164 161 105 161 91 153 94 130 179 126 179 119 199 119 199 115 155 115 148 112 121 112 115 123
					yourself:
				)
		)
		((ScriptID 1800 49) y: (+ ((ScriptID 1800 49) y:) 70)) ; Freddy, Freddy
		(if (not (== gCurPuzzle 3))
			(helen
				init:
				setLoop: 2
				setCel: 0
				approachVerbs: 2 4 ; Talk, Do
				setScript: sHelenWorks
			)
		)
		(flies init:)
		(if (IsFlag 29)
			(hopSingh
				view: 664
				setLoop: 7
				setCel: 0
				posn: 206 116
				approachVerbs: 2 4 ; Talk, Do
				setPri: 9
				setCycle: Fwd
				init:
			)
			(swingDoors setCel: 0)
			(swingDoors2 setCel: 0)
			(plop init: setScale: -1 gEgo setCycle: Fwd)
			(gGameMusic1 number: 501 loop: -1 play:)
		else
			(gGameMusic1 number: 660 loop: -1 play:)
			(hopSingh
				init:
				approachVerbs: 2 4 ; Talk, Do
				setLoop: 0
				setCycle: OccasionalCycle 1 30 120 6 12
			)
		)
		(if (OneOf gCurPuzzle 8 9 22 23 24)
			(lady1
				init:
				setCycle: OccasionalCycle 1 10 40 2 6
				ignoreActors:
				setScript: sPlayContinuously
			)
			(penny init: setCycle: OccasionalCycle 1 10 40 2 6 ignoreActors:)
			(lady2 init: setCycle: OccasionalCycle 1 10 40 2 6 ignoreActors:)
		)
		(if (> gAct 2)
			(coffee init: setCycle: Fwd approachVerbs: 4) ; Do
		)
		(if (and (> gAct 2) (not (IsFlag 14)))
			(pie init: stopUpd:)
		)
		(if (not (IsFlag 25))
			(tinCan init: approachVerbs: 4) ; Do
		)
		(steam init: setCycle: Fwd)
		(orderWheel init: stopUpd:)
		(swingDoors init: stopUpd:)
		(swingDoors2 init: stopUpd:)
		(bottle init: setOnMeCheck: 1 2)
		(corn init: setOnMeCheck: 1 4)
		(leftTable init: setOnMeCheck: 1 8)
		(rightTable init: setOnMeCheck: 1 16)
		(shelf init: setOnMeCheck: 1 32)
		(lamp init: setOnMeCheck: 1 64)
		(post init: setOnMeCheck: 1 128)
		(cabinet init: setOnMeCheck: 1 256)
		(kitchen init: setOnMeCheck: 1 512)
		(kitchenDoor init: setOnMeCheck: 1 1024)
		(flowers init: setOnMeCheck: 1 2048)
		(counter init: setOnMeCheck: 1 4096)
		(kitchenCounter init: setOnMeCheck: 1 8192)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: noun theVerb 17) ; MISSING MESSAGE
				)
			)
			(1 ; Look
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: noun theVerb 17) ; MISSING MESSAGE
				)
			)
			(66 ; Horse_Plop
				(gCurRoom setScript: sDunkPlop)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((proc0_1 gEgo 2)
				(self setScript: sExitRoom)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 230) (OneOf gCurPuzzle 8 9 20 22))
			(= newRoomNumber 235)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(gGameMusic2 fade: 0 30 12 1)
		(gTimers delete: flyTimer)
		(super dispose:)
	)
)

(instance sPlayContinuously of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (gGameMusic2 number:) 2942) (== (gGameMusic2 prevSignal:) -1))
			(gGameMusic2 number: 2662 flags: 1 loop: 1 play: self)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameMusic2 number: 2662 flags: 1 loop: 1 play: self)
			)
			(1
				(gGameMusic2 prevSignal: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance sHelenWorks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(helen view: 661 setScale: 0 setLoop: 2 setCycle: End self)
			)
			(1
				(helen
					view: 661
					setLoop: 0
					setCycle: OccasionalCycle 1 30 120 2 6 self
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sGetFlies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 661
					setLoop: 1
					setCel: 0
					setScale: 0
					setCycle: End self
				)
			)
			(1
				(client setCycle: Beg self)
				(swatSound play:)
			)
			(2
				(flyTimer seconds: 1)
				(gMessager say: 9 0 0 (Random 1 5) self)
			)
			(3
				(= next sHelenWorks)
				(self dispose:)
			)
		)
	)
)

(instance sGetCan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 28 4 17 0 self) ; MISSING MESSAGE
			)
			(1
				(tinCan dispose:)
				(gEgo get: -1 56) ; Tin_Can
				(gGame points: 1)
				(SetFlag 25)
				(self dispose:)
			)
		)
	)
)

(instance sDunkPlop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local2 (gEgo moveSpeed:))
				(gEgo setSpeed: 6)
				(SetFlag 29)
				(SetFlag 103)
				(if (<= (gEgo y:) 141)
					(= cycles 2)
				else
					(gEgo
						view: 664
						setLoop: 2
						setCel: 0
						setCycle: Walk
						setMotion: PolyPath 92 152 self
					)
				)
			)
			(1
				(if (and (> (gEgo x:) 86) (< (gEgo y:) 125))
					(= cycles 2)
				else
					(gEgo
						view: 664
						setLoop: 1
						setCel: 0
						setCycle: Walk
						setMotion: PolyPath 149 124 self
					)
				)
			)
			(2
				(gEgo
					view: 664
					setLoop: 2
					setCel: 0
					setMotion: PolyPath 133 117 self
				)
			)
			(3
				(gEgo setLoop: 4 setCel: 0 setCycle: CT 4 1 self)
			)
			(4
				(gEgo setCycle: End self)
				(plop init: setCycle: Fwd)
			)
			(5
				(gEgo
					normalize:
					loop: 1
					put: 23 ; Horse_Plop
					setMotion: PolyPath 110 129 self
				)
				(helen
					setScript: 0
					view: 664
					setLoop: 5
					cel: 0
					setCycle: End self
				)
				(gTimers delete: flyTimer)
			)
			(6 0)
			(7
				(gMessager say: 4 0 0 0 self) ; MISSING MESSAGE
			)
			(8
				(hopSingh
					view: 664
					setLoop: 10
					setCel: 0
					y: (+ (hopSingh y:) 7)
					setCycle: ForwardCounter 3 self
				)
			)
			(9
				(gMessager say: 3 0 0 0 self) ; MISSING MESSAGE
			)
			(10
				(gGameMusic1 number: 501 loop: -1 play:)
				(hopSingh
					setLoop: 9
					setCycle: Walk
					setMotion: MoveTo 248 121 self
				)
			)
			(11
				(swingDoors setCycle: Beg)
				(swingDoors2 setCycle: Beg)
				(hopSingh
					setPri: 9
					ignoreActors:
					setMotion: MoveTo 215 113 self
				)
			)
			(12
				(swingDoors stopUpd:)
				(swingDoors2 stopUpd:)
				(hopSingh setLoop: 7 posn: 204 116 setCycle: Fwd)
				((ScriptID 0 12) setReal: (ScriptID 0 12) 0 3) ; horsePlopTimer, horsePlopTimer
				(gGame points: 9 158)
				(gEgo setSpeed: local2)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 660
					setLoop: 1
					setCel: 0
					posn: 0 138
					setMotion: MoveTo 65 138 self
				)
			)
			(1
				(gEgo
					normalize:
					loop: 0
					setCel: 0
					setMotion: MoveTo 86 141 self
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 56 141 self)
			)
			(1
				(gEgo
					view: 660
					setLoop: 2
					setCel: 0
					posn: 56 138
					setMotion: MoveTo -4 138 self
				)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance flies of Actor
	(properties
		noun 9
		view 660
		loop 8
	)

	(method (doit)
		(super doit:)
		(if (and (self inRect: 191 90 228 135) local0)
			(= local0 0)
			(= local1 1)
			(if (and (gCast contains: helen) (not (IsFlag 29)))
				(helen setScript: sGetFlies)
			)
			(self setMotion: MoveTo 206 (Random 105 122))
			(flyTimer setReal: flies (Random 6 12))
		)
	)

	(method (init)
		(super init:)
		(self
			x: (Random 10 300)
			y: (Random 10 180)
			setLoop: 8
			setPri: 13
			ignoreActors:
			ignoreHorizon:
			setCycle: RandCycle
			setMotion: MoveTo (Random 10 300) (Random 10 180) self
		)
	)

	(method (cue)
		(if (== (helen script:) sGetFlies)
			(helen setScript: sHelenWorks)
		)
		(if local1
			(= local1 0)
			(self setMotion: MoveTo (Random 10 300) (Random 10 180) self)
		else
			(= local0 1)
			(self setMotion: MoveTo (Random 10 300) (Random 10 180) self)
		)
	)
)

(instance helen of Actor
	(properties
		x 237
		y 141
		noun 11
		approachX 178
		approachY 123
		view 661
		loop 2
		priority 11
		signal 20497
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((gEgo has: 54) ; Snails
						(gMessager say: noun 2 15) ; "Mom, there was a fire last night that almost burned the whole town down."
						(SetFlag 32)
					)
					((and (== gAct 1) (not (IsFlag 88)))
						(gMessager say: noun theVerb 5) ; MISSING MESSAGE
						(SetFlag 88)
					)
					((and (== gAct 1) (not (IsFlag 89)))
						(gMessager say: noun theVerb 6) ; "'Morning, Helen!"
						(SetFlag 89)
					)
					((== gAct 1)
						(gMessager say: noun theVerb 7) ; "Hel...Mom! Did you know that the Hotel's been shut down?"
					)
					((and (== gCurPuzzle 16) (IsFlag 103))
						(gMessager say: noun theVerb 8) ; "Have you heard anything else?"
					)
					((== gCurPuzzle 16)
						(gMessager say: noun theVerb 9) ; "Mom, you'd better keep everyone inside 'til I can get this horse flatulence thing straightened out."
					)
					((== gCurPuzzle 17)
						(gMessager say: noun theVerb 10) ; "Mom, Mom!"
					)
					((== gCurPuzzle 13)
						(gMessager say: noun theVerb 11) ; "Mom, what do you know about ants?"
					)
					((== gCurPuzzle 8)
						(gMessager say: noun theVerb 12) ; "Mom, where are all your customers?"
					)
					((== gCurPuzzle 9)
						(gMessager say: noun theVerb 12) ; "Mom, where are all your customers?"
					)
					((== gCurPuzzle 12)
						(gMessager say: noun theVerb 13) ; "Mom, I'm going to be leaving town awhile. Just wanted to tip m' hat and say thanks."
					)
					((== gCurPuzzle 10)
						(gMessager say: noun theVerb 14) ; MISSING MESSAGE
					)
					(else
						(gMessager say: noun 2) ; MISSING MESSAGE
					)
				)
			)
			(30 ; Snails
				(if (IsFlag 32)
					(gMessager say: noun 0 3) ; "Hmmph. Dunno who around here will eat these, since they don't give you gas, but I'll put them in a bag of cornstarch and think about it."
					(gEgo put: 54) ; Snails
					(gGame points: 1)
				else
					(gMessager say: noun 2 15 0 self) ; "Mom, there was a fire last night that almost burned the whole town down."
					(SetFlag 32)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self doVerb: 30)
	)
)

(instance plop of Prop
	(properties
		x 125
		y 112
		noun 8
		view 664
		detailLevel 2
	)
)

(instance penny of Prop
	(properties
		x 155
		y 117
		noun 21
		view 663
		cel 2
		priority 12
		signal 4112
		cycleSpeed 15
		detailLevel 2
	)
)

(instance lady1 of Prop
	(properties
		x 129
		y 157
		noun 16
		view 663
		loop 1
		cel 3
		priority 12
		signal 4112
		cycleSpeed 10
		detailLevel 2
	)
)

(instance lady2 of Prop
	(properties
		x 175
		y 121
		noun 17
		view 663
		loop 2
		cel 5
		priority 11
		signal 4112
		cycleSpeed 10
		detailLevel 2
	)
)

(instance coffee of Prop
	(properties
		x 103
		y 110
		z 24
		noun 5
		approachX 121
		approachY 119
		view 660
		loop 3
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gEgo has: 11) ; Coffee
						(gMessager say: noun 4 1) ; MISSING MESSAGE
					)
					((IsFlag 157)
						(gEgo get: -1 11 2) ; Coffee
						(gMessager say: noun 4 2) ; MISSING MESSAGE
					)
					(else
						(gEgo get: 11 self 2) ; Coffee
						(gGame points: 1 157)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pie of Prop
	(properties
		x 269
		y 110
		z 20
		noun 22
		view 660
		loop 7
		signal 16385
		detailLevel 2
	)
)

(instance hopSingh of Actor
	(properties
		x 250
		y 108
		noun 12
		approachX 178
		approachY 123
		view 662
		signal 16384
		detailLevel 2
		xStep 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(cond
					((and (== gAct 1) (not (IsFlag 90)))
						(gMessager say: noun theVerb 5) ; MISSING MESSAGE
						(SetFlag 90)
					)
					((and (== gAct 1) (not (IsFlag 91)))
						(gMessager say: noun theVerb 6) ; MISSING MESSAGE
						(SetFlag 91)
					)
					((== gAct 1)
						(gMessager say: noun theVerb 7) ; MISSING MESSAGE
					)
					((and (== gCurPuzzle 16) (IsFlag 103))
						(gMessager say: noun theVerb 8) ; MISSING MESSAGE
					)
					((== gCurPuzzle 16)
						(gMessager say: noun theVerb 9) ; MISSING MESSAGE
					)
					((== gCurPuzzle 17)
						(gMessager say: noun theVerb 10) ; MISSING MESSAGE
					)
					((== gCurPuzzle 13)
						(gMessager say: noun theVerb 11) ; MISSING MESSAGE
					)
					((== gCurPuzzle 8)
						(gMessager say: noun theVerb 12) ; MISSING MESSAGE
					)
					((== gCurPuzzle 9)
						(gMessager say: noun theVerb 12) ; MISSING MESSAGE
					)
					((== gCurPuzzle 12)
						(gMessager say: noun theVerb 13) ; MISSING MESSAGE
					)
					((== gCurPuzzle 10)
						(gMessager say: noun theVerb 14) ; MISSING MESSAGE
					)
					(else
						(gMessager say: noun 2) ; MISSING MESSAGE
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance steam of Prop
	(properties
		x 259
		y 66
		view 660
		loop 4
		signal 16384
		detailLevel 2
	)
)

(instance orderWheel of Prop
	(properties
		x 262
		y 120
		z 55
		noun 20
		view 660
		loop 5
		priority 15
		signal 16401
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: noun theVerb 17) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swingDoors of Prop
	(properties
		x 226
		y 84
		noun 27
		view 660
		cel 2
		priority 9
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: 15 theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: 15 theVerb 17) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swingDoors2 of Prop
	(properties
		x 226
		y 84
		noun 27
		view 660
		loop 9
		cel 2
		priority 10
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: 15 theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: 15 theVerb 17) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tinCan of View
	(properties
		x 107
		y 170
		z 51
		noun 28
		approachX 126
		approachY 162
		view 660
		loop 6
		priority 14
		signal 20497
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gCurRoom setScript: sGetCan)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bottle of Feature
	(properties
		x 37
		y 200
		noun 1
		onMeCheck 2
	)
)

(instance corn of Feature
	(properties
		x 84
		y 200
		noun 6
		onMeCheck 4
	)
)

(instance leftTable of Feature
	(properties
		x 90
		y 100
		noun 19
		onMeCheck 8
	)
)

(instance rightTable of Feature
	(properties
		x 148
		y 120
		noun 24
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: noun theVerb 17) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shelf of Feature
	(properties
		x 97
		y 10
		noun 26
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: noun theVerb 17) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 136
		y 100
		noun 18
		onMeCheck 64
	)
)

(instance post of Feature
	(properties
		x 136
		y 100
		noun 23
		onMeCheck 128
	)
)

(instance cabinet of Feature
	(properties
		x 174
		y 1
		noun 2
		onMeCheck 256
	)
)

(instance kitchen of Feature
	(properties
		x 264
		y 100
		noun 13
		onMeCheck 512
	)
)

(instance kitchenDoor of Feature
	(properties
		x 218
		y 80
		noun 15
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== gCurPuzzle 3)
					(gMessager say: noun theVerb 16) ; MISSING MESSAGE
				else
					(gMessager say: noun theVerb 17) ; MISSING MESSAGE
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flowers of Feature
	(properties
		x 223
		y 200
		noun 10
		onMeCheck 2048
	)
)

(instance counter of Feature
	(properties
		x 203
		y 115
		noun 7
		onMeCheck 4096
	)
)

(instance kitchenCounter of Feature
	(properties
		x 250
		y 110
		noun 14
		onMeCheck 8192
	)
)

(instance flyTimer of Timer
	(properties)
)

(instance swatSound of FPSound
	(properties
		flags 1
		number 2543
	)
)

