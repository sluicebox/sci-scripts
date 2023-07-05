;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use ROsc)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	rm210 0
)

(instance rm210 of PQRoom
	(properties
		picture 210
		infoRoomSignal 136
	)

	(method (init)
		(SetFlag 15)
		(SetFlag 12)
		(super init: &rest)
		(if (== gPrevRoomNum 205)
			(ClearFlag 69)
			(SetFlag 40)
		)
		(glassFeat init:)
		(doubleDoors init:)
		(Yard7Walls init:)
		(Yard15Walls init:)
		(cement init:)
		(buckets init:)
		(building init:)
		(targetBuilding init:)
		(hill init:)
		(= global114 okToShoot)
		(if (== gPrevRoomNum 205)
			(rhea init: setCycle: ROsc -1 22 44)
			(wixell init: setCycle: ROsc -1 20 60)
			(carmichael init: setCycle: ROsc -1 23 60)
			(denton init: setCycle: ROsc -1 22 50)
			(if (not (IsFlag 19))
				(pacmeyer init: setCycle: ROsc -1 24 42)
			)
			(cond
				((and (IsFlag 19) (not (SetFlag 33)))
					(self setScript: enterRangeLead)
				)
				((not (IsFlag 42))
					(SetFlag 42)
					(self setScript: firstEnterRange)
				)
				((IsFlag 19)
					(self setScript: enterRangeAsLeader)
				)
				(else
					(self setScript: enterRange)
				)
			)
		else
			(ClearFlag 35)
			(ClearFlag 37)
			(ClearFlag 39)
			(ClearFlag 115)
			(if (IsFlag 40)
				(rhea view: 2129 loop: 0 cel: 0 init: setCycle: End)
				(wixell view: 2130 loop: 0 cel: 0 init: setCycle: End)
				(carmichael view: 2131 setLoop: 0 cel: 0 init: setCycle: End)
				(denton view: 2132 setLoop: 0 cel: 0 init: setCycle: End)
				(if (not (IsFlag 19))
					(pacmeyer
						view: 2133
						setLoop: 0
						cel: 0
						init:
						setCycle: CT 24 1
					)
				)
				(if (not (IsFlag 41))
					(gEgo
						view: 21052
						loop: 1
						cel: 0
						posn: 56 295
						setPri: 304
						init:
					)
					(pauldon
						view: 21050
						loop: 0
						cel: 0
						posn: 229 265
						setPri: 303
						init:
					)
				else
					(WalkieTalkie showFrame: 21050 160 186 113 304)
				)
			else
				(rhea init:)
				(wixell init:)
				(carmichael init:)
				(denton init:)
				(if (not (IsFlag 19))
					(pacmeyer init:)
				)
				(if (IsFlag 41)
					(WalkieTalkie showFrame: 21051 0 41 115 320)
				else
					(gEgo
						view: 21052
						loop: 0
						cel: 16
						posn: 56 295
						setPri: 304
						init:
					)
					(pauldon
						view: 21051
						loop: 0
						cel: 0
						posn: 172 313
						setPri: 500
						init:
					)
				)
			)
			(cond
				(script 0)
				((IsFlag 41)
					(self setScript: leaveRange)
				)
				(else
					(self setScript: afterDrill)
				)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(= global114 0)
		(ClearFlag 41)
		(if (not (OneOf newRoomNumber 220 225))
			(ClearFlag 12)
			(ClearFlag 15)
			(ClearFlag 40)
			(if (and (IsFlag 69) (not (IsFlag 111)))
				(SetFlag 75)
			)
			(if (== (gGame printLang:) 1)
				(gBackMusic fade: 0 2 21 1)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance enterRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(WalkieTalkie showFrame: 2102 0 188 131)
				(= ticks 1)
			)
			(1
				(WalkieTalkie killRobot:)
				(proc4_6 2102 188 131 0 0 300 1)
				(rhea setScript: rheaScript)
				(wixell setScript: wixellScript)
				(carmichael setScript: carmichaelScript)
				(denton setScript: dentonScript)
				(if (not (IsFlag 19))
					(pacmeyer setScript: pacmeyerScript)
				)
			)
			(2
				(rheaScript cue:)
				(wixellScript cue:)
				(carmichaelScript cue:)
				(dentonScript cue:)
				(if (not (IsFlag 19))
					(pacmeyerScript cue:)
				)
				(= seconds 5)
			)
			(3
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance enterRangeAsLeader of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(WalkieTalkie showFrame: 2104 0 204 129)
				(= ticks 1)
			)
			(1
				(WalkieTalkie killRobot:)
				(proc4_6 2104 204 129 0 0 304 1)
				(rhea setScript: rheaScript)
				(wixell setScript: wixellScript)
				(carmichael setScript: carmichaelScript)
				(denton setScript: dentonScript)
				(if (not (IsFlag 19))
					(pacmeyer setScript: pacmeyerScript)
				)
			)
			(2
				(rheaScript cue:)
				(wixellScript cue:)
				(carmichaelScript cue:)
				(dentonScript cue:)
				(if (not (IsFlag 19))
					(pacmeyerScript cue:)
				)
			)
			(3
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance firstEnterRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(WalkieTalkie showFrame: 2101 0 173 100)
				(SetFlag 37)
				(= cycles 2)
			)
			(1
				(WalkieTalkie killRobot:)
				(proc4_6 2101 173 100 0 0 304 1)
			)
			(2
				(rhea setScript: rheaScript 0 1)
				(wixell setScript: wixellScript 0 1)
				(carmichael setScript: carmichaelScript 0 1)
				(pacmeyer setScript: pacmeyerScript 0 1)
				(denton setScript: dentonScript 0 1)
			)
			(3
				(rheaScript cue:)
				(wixellScript cue:)
				(carmichaelScript cue:)
				(pacmeyerScript cue:)
				(dentonScript cue:)
			)
			(4
				(rheaScript cue:)
				(wixellScript cue:)
				(carmichaelScript cue:)
				(pacmeyerScript cue:)
				(dentonScript cue:)
			)
			(5
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance enterRangeLead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 37)
				(rhea view: 2119 setLoop: 0 setCel: 20 setCycle: End)
				(carmichael view: 2127 setCel: 10 setLoop: 0 setCycle: End)
				(wixell view: 2122 setCel: 0 setLoop: 0 setCycle: ROsc -1 20 60)
				(denton view: 21282 setLoop: 0 setCel: 1 setCycle: End)
				(proc4_6 2103 194 115 0 0 300 1)
			)
			(1
				(gMessager say: 3 0 1 0 self) ; "Way to go, man!"
			)
			(2
				(gMessager say: 2 0 1 0 self) ; "Woof, woof, woof!"
			)
			(3
				(gMessager say: 4 0 1 0 self) ; "Alright!"
			)
			(4
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance afterDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(= seconds 5)
				(if (not (IsFlag 40))
					(rhea setCycle: End)
					(wixell setCycle: End)
					(carmichael setCycle: End)
					(if (gCast contains: pacmeyer)
						(pacmeyer setCycle: End)
					)
					(denton setCycle: End)
					(gEgo setCycle: CT 50 1)
				else
					(gEgo setCycle: CT 29 1)
				)
			)
			(2
				(if (IsFlag 40)
					(rhea setCycle: Beg self)
					(wixell setCycle: Beg)
					(carmichael setCycle: Beg)
					(if (gCast contains: pacmeyer)
						(pacmeyer setCycle: Beg)
					)
					(denton setCycle: Beg)
					(gEgo setCycle: Beg)
				else
					(gEgo setCycle: CT 16 -1)
					(rhea setCycle: Beg self)
					(wixell setCycle: Beg)
					(carmichael setCycle: Beg)
					(if (gCast contains: pacmeyer)
						(pacmeyer setCycle: Beg)
					)
					(denton setCycle: Beg)
				)
			)
			(3
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance chooseDrill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cond
					((not (IsFlag 36))
						(SetFlag 37)
					)
					((not (IsFlag 34))
						(SetFlag 35)
					)
					((not (IsFlag 38))
						(SetFlag 39)
					)
					((not (IsFlag 117))
						(SetFlag 115)
					)
					(else
						(ClearFlag 35)
						(ClearFlag 37)
						(ClearFlag 39)
						(ClearFlag 115)
						(switch (Random 0 3)
							(0
								(SetFlag 35)
							)
							(1
								(SetFlag 37)
							)
							(2
								(SetFlag 39)
							)
							(3
								(SetFlag 115)
							)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(if (not (IsFlag 40))
					(gCurRoom newRoom: 225)
				else
					(gCurRoom newRoom: 220)
				)
			)
		)
	)
)

(instance misUse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(rhea setCycle: 0)
			)
			(1
				(gGame handsOff:)
				(gGame showCloseUp: 2113 -1 -1 self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame restart:)
			)
		)
	)
)

(instance firstDegreeMurder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhea setCycle: 0)
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(gGame showCloseUp: 2112 -1 -1 self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame restart:)
			)
		)
	)
)

(instance pauldonMisUse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhea setCycle: 0)
				(= cycles 2)
			)
			(1
				(gGame handsOff:)
				(gGame showCloseUp: 2111 -1 -1 self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(gGame restart:)
			)
		)
	)
)

(instance comedian of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 2108 -1 -1 self)
			)
			(1
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance dontSocialize of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 2110 -1 -1 self)
			)
			(1
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance cementClick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 2109 -1 -1 self)
			)
			(1
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance dropShells of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: register setLoop: 0 play: self)
			)
			(1
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance leaveRange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (if (IsFlag 41) global138 else 100))
				(if (IsFlag 40)
					(proc4_6 21050 186 113 160 0 304 1)
				else
					(proc4_6 21051 41 115 0 0 320 1)
				)
			)
			(1
				(if (IsFlag 40)
					(gEgo show:)
				)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance changeLanes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: End self)
			)
			(1
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance rheaScript of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhea setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(if (not register)
					(= cycles 1)
				else
					(rhea setCycle: CT 6 -1)
				)
			)
			(2
				(rhea setCycle: Beg self)
			)
			(3
				(rhea setLoop: 0 setCycle: ROsc -1 22 44)
			)
			(4
				(rhea setCycle: Beg self)
			)
			(5
				(rhea setLoop: 2 setCel: 20 setCycle: Beg self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance wixellScript of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wixell setLoop: 1 setCel: 0 setCycle: End)
			)
			(1
				(if (not register)
					(= cycles 1)
				else
					(wixell setCycle: CT 11 -1)
				)
			)
			(2
				(wixell setCycle: Beg self)
			)
			(3
				(wixell setLoop: 0 setCel: 20 setCycle: ROsc -1 20 60)
			)
			(4
				(wixell setCycle: Beg self)
			)
			(5
				(wixell setLoop: 2 setCel: 26 setCycle: Beg self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance carmichaelScript of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(carmichael setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(if (not register)
					(= cycles 1)
				else
					(carmichael setCycle: CT 6 -1)
				)
			)
			(2
				(carmichael setCycle: Beg self)
			)
			(3
				(carmichael setLoop: 0 setCycle: ROsc -1 23 60)
			)
			(4
				(carmichael setCycle: Beg self)
			)
			(5
				(carmichael setLoop: 2 setCel: 21 setCycle: Beg self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance dentonScript of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(denton setLoop: 1 setCel: 16 setCycle: CT 21 1 self)
			)
			(1
				(if (not register)
					(= cycles 1)
				)
			)
			(2
				(denton setCycle: CT 16 -1 self)
			)
			(3
				(denton setLoop: 0 setCel: 0 setCycle: ROsc -1 22 50)
			)
			(4
				(denton setCycle: Beg self)
			)
			(5
				(denton setLoop: 2 setCel: 20 setCycle: Beg self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance pacmeyerScript of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pacmeyer setCel: 43 setCycle: CT 52 1 self)
			)
			(1
				(if (not register)
					(= cycles 1)
				else
					(pacmeyer setCycle: CT 49 -1)
				)
			)
			(2
				(pacmeyer setCycle: CT 43 -1 self)
			)
			(3
				(pacmeyer setCycle: ROsc -1 24 42)
			)
			(4
				(pacmeyer setCel: 24 setCycle: Beg self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance talkToPacmeyer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 40)
					(gGame showCloseUp: 2116 -1 -1 self)
				else
					(gGame showCloseUp: 21160 -1 -1 self)
				)
			)
			(1
				(gCurRoom setScript: chooseDrill)
			)
		)
	)
)

(instance pauldon of Prop
	(properties
		x 140
		y 192
		view 210
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: dontSocialize)
			)
			(6
				(gCurRoom setScript: pauldonMisUse)
			)
			(7
				(gCurRoom setScript: pauldonMisUse)
			)
			(10
				(gCurRoom setScript: pauldonMisUse)
			)
			(8
				(gCurRoom setScript: pauldonMisUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance rhea of Prop
	(properties
		x 378
		y 245
		priority 200
		fixPriority 1
		view 2118
		cel 22
		scaleSignal 1
	)

	(method (init)
		(if (IsFlag 40)
			(self view: 2118 posn: 378 245 setPri: 274 scaleX: 150 scaleY: 150)
		else
			(self view: 2120 loop: 0 cel: 0 posn: 153 257 setPri: 259)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29)
			(6
				(gCurRoom setScript: firstDegreeMurder)
			)
			(7
				(gCurRoom setScript: firstDegreeMurder)
			)
			(10
				(gCurRoom setScript: firstDegreeMurder)
			)
			(8
				(gCurRoom setScript: firstDegreeMurder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wixell of Prop
	(properties
		x 394
		y 240
		priority 190
		fixPriority 1
		view 2122
		cel 20
		scaleSignal 1
	)

	(method (init)
		(if (IsFlag 40)
			(self posn: 375 235 setPri: 240)
		else
			(self
				view: 2124
				loop: 0
				cel: 0
				posn: 190 237
				setPri: 241
				scaleX: 95
				scaleY: 95
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29)
			(6
				(gCurRoom setScript: firstDegreeMurder)
			)
			(7
				(gCurRoom setScript: firstDegreeMurder)
			)
			(10
				(gCurRoom setScript: firstDegreeMurder)
			)
			(8
				(gCurRoom setScript: firstDegreeMurder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carmichael of Prop
	(properties
		x 393
		y 239
		priority 170
		fixPriority 1
		view 2126
		cel 23
		scaleSignal 1
	)

	(method (init)
		(if (IsFlag 40)
			(self setPri: 220 x: 375 scaleX: 130 scaleY: 130)
		else
			(self
				view: 2128
				loop: 0
				cel: 0
				posn: 229 227
				setPri: 229
				scaleX: 80
				scaleY: 80
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29)
			(6
				(gCurRoom setScript: firstDegreeMurder)
			)
			(7
				(gCurRoom setScript: firstDegreeMurder)
			)
			(10
				(gCurRoom setScript: firstDegreeMurder)
			)
			(8
				(gCurRoom setScript: firstDegreeMurder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties
		noun 6
		x 340
		y 240
		view 2116
		cel 24
	)

	(method (init)
		(if (IsFlag 40)
			(self view: 2116 posn: 395 264 setPri: 299)
		else
			(self view: 2114 loop: 0 cel: 0 posn: 120 270 setPri: 274)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: talkToPacmeyer)
			)
			(6
				(gCurRoom setScript: firstDegreeMurder)
			)
			(7
				(gCurRoom setScript: firstDegreeMurder)
			)
			(10
				(gCurRoom setScript: firstDegreeMurder)
			)
			(8
				(gCurRoom setScript: firstDegreeMurder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance denton of Prop
	(properties
		x 383
		y 236
		priority 150
		fixPriority 1
		view 21282
		cel 22
		scaleSignal 1
	)

	(method (init)
		(if (IsFlag 40)
			(self posn: 369 215 setPri: 10 scaleX: 90 scaleY: 90)
		else
			(self
				view: 21283
				loop: 0
				cel: 0
				posn: 248 217
				setPri: 110
				scaleX: 70
				scaleY: 70
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29)
			(6
				(gCurRoom setScript: firstDegreeMurder)
			)
			(7
				(gCurRoom setScript: firstDegreeMurder)
			)
			(10
				(gCurRoom setScript: firstDegreeMurder)
			)
			(8
				(gCurRoom setScript: firstDegreeMurder)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glassFeat of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 12 0 70 0 112 7 150 28 144 64 138 98 234 129 234 158 132 148 132 115 98 108 24 103
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 29)
			(return (super doVerb: theVerb &rest))
		)
		(if (OneOf theVerb 7 6 8 10)
			(gFxSound number: 21003 loop: 1 play:)
			(gCurRoom setScript: misUse)
		else
			(return 0)
		)
	)
)

(instance doubleDoors of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 306 132 368 132 368 204 306 204
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gCurRoom newRoom: 100)
			)
			(6
				(gCurRoom setScript: misUse)
			)
			(7
				(gCurRoom setScript: misUse)
			)
			(10
				(gCurRoom setScript: misUse)
			)
			(8
				(gCurRoom setScript: misUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance cement of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 368 204 398 355 0 355 290 204
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: cementClick)
			)
			(6
				(gCurRoom setScript: misUse)
			)
			(7
				(gCurRoom setScript: misUse)
			)
			(10
				(gCurRoom setScript: misUse)
			)
			(8
				(gCurRoom setScript: misUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance buckets of Feature
	(properties
		y 200
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 348 309 350 355 390 355 384 312
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 360 256 376 256 366 201 356 201
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: dropShells 0 22502)
			)
			(6
				(gCurRoom setScript: dropShells 0 22502)
			)
			(7
				(gCurRoom setScript: dropShells 0 22502)
			)
			(10
				(gCurRoom setScript: dropShells 0 22502)
			)
			(8
				(gCurRoom setScript: dropShells 0 22502)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance Yard7Walls of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 402 360 364 204 366 180 404 177 640 247 640 355
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not (IsFlag 40))
					(SetFlag 40)
					(gCurRoom setScript: changeLanes)
				)
			)
			(6
				(gCurRoom setScript: misUse)
			)
			(7
				(gCurRoom setScript: misUse)
			)
			(10
				(gCurRoom setScript: misUse)
			)
			(8
				(gCurRoom setScript: misUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance Yard15Walls of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 206 0 348 0 139 286 160
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (IsFlag 40)
					(ClearFlag 40)
					(gCurRoom setScript: changeLanes)
				)
			)
			(6
				(gCurRoom setScript: misUse)
			)
			(7
				(gCurRoom setScript: misUse)
			)
			(10
				(gCurRoom setScript: misUse)
			)
			(8
				(gCurRoom setScript: misUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance building of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 0 150 36 134 136 0 110 0 0
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29)
			(6
				(gCurRoom setScript: misUse)
			)
			(7
				(gCurRoom setScript: misUse)
			)
			(10
				(gCurRoom setScript: misUse)
			)
			(8
				(gCurRoom setScript: misUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance targetBuilding of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 498 132 498 183 476 192 639 223 639 100
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: chooseDrill)
			)
			(6
				(gCurRoom setScript: 0)
				(SetFlag 35)
				(ClearFlag 37)
				(ClearFlag 39)
				(ClearFlag 115)
				(if (IsFlag 40)
					(gCurRoom newRoom: 220)
				else
					(gCurRoom newRoom: 225)
				)
			)
			(7
				(gCurRoom setScript: 0)
				(ClearFlag 35)
				(SetFlag 37)
				(ClearFlag 39)
				(ClearFlag 115)
				(if (IsFlag 40)
					(gCurRoom newRoom: 220)
				else
					(gCurRoom newRoom: 225)
				)
			)
			(8
				(gCurRoom setScript: 0)
				(ClearFlag 35)
				(ClearFlag 37)
				(SetFlag 39)
				(ClearFlag 115)
				(if (IsFlag 40)
					(gCurRoom newRoom: 220)
				else
					(gCurRoom newRoom: 225)
				)
			)
			(10
				(gCurRoom setScript: 0)
				(ClearFlag 35)
				(ClearFlag 37)
				(ClearFlag 39)
				(SetFlag 115)
				(if (IsFlag 40)
					(gCurRoom newRoom: 220)
				else
					(gCurRoom newRoom: 225)
				)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance hill of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 236 0 248 21 162 31 158 62 206 62 276 108 280 127 522 124 640 98 640 0
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29)
			(6
				(gCurRoom setScript: misUse)
			)
			(7
				(gCurRoom setScript: misUse)
			)
			(10
				(gCurRoom setScript: misUse)
			)
			(8
				(gCurRoom setScript: misUse)
			)
			(else
				(gCurRoom setScript: comedian)
			)
		)
	)
)

(instance okToShoot of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(param1 localize: gThePlane)
		(= temp0
			(not (or (targetBuilding onMe: param1) (buckets onMe: param1)))
		)
	)
)

