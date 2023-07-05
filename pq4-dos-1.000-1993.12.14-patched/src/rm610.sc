;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use TellerIcon)
(use ExitArrow)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm610 0
	mitchTalker 1
)

(local
	local0
	local1
	local2
)

(instance rm610 of Room
	(properties
		picture 610
	)

	(method (init)
		(gGlobalSound0 number: 425 loop: -1 play:)
		(gGlobalSound1 stop:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 62 157 129 157 129 188 190 188 190 157 285 157 285 136 256 136 251 138 229 143 83 143 73 143 62 143
					yourself:
				)
		)
		(gEgo view: 9120)
		(super init: &rest)
		(if (and (gPqFlags test: 127) (not (gPqFlags test: 128)))
			(tea init:)
		)
		(cond
			((or (gPqFlags test: 101) (== gDay 6)))
			((and (gPqFlags test: 127) (not (gPqFlags test: 128)))
				(mitchell
					view: 612
					loop: 1
					cel: 0
					x: 165
					y: 91
					setCycle: Fwd
					init:
					approachVerbs: 2 ; Talk
				)
				(if (not (gPqFlags test: 149))
					(mitchellTeller init: mitchell 610)
				)
			)
			(else
				(mitchell view: 611 loop: 0 cel: 0 x: 169 y: 92 init:)
				(if (not (gPqFlags test: 149))
					(mitchellTeller init: mitchell 610)
				)
			)
		)
		(toStreet init:)
		(toRight init:)
		(toLeft init:)
		(teaPot init:)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(605
				(gEgo
					posn: 225 143
					setHeading: 312
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
				(gGame handsOff:)
				(gCurRoom
					setScript:
						(cond
							(
								(and
									(gPqFlags test: 128)
									(not (gPqFlags test: 101))
								)
								seeMovieScript
							)
							(
								(and
									(gPqFlags test: 127)
									(not (gPqFlags test: 128))
								)
								drinkTeaScript
							)
							(else
								(gGame intensity: 0)
								from605Script
							)
						)
				)
			)
			(620
				(gEgo normalize: 9120)
				(gEgo
					posn: 260 143
					setHeading: 270
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
			)
			(625
				(gEgo
					posn: 260 143
					setHeading: 270
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
			)
			(640
				(gEgo
					posn: 88 144
					setHeading: 90
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
			)
			(670
				(gEgo
					posn: 260 143
					setHeading: 180
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
			)
			(675
				(gEgo
					posn: 270 143
					setHeading: 180
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
			)
			(else
				(gEgo
					posn: 225 143
					setHeading: 0
					setTalker: careyTalker
					setScaler: Scaler 100 94 164 133
					init:
					normalize: 9120
				)
				(gPqFlags set: 102)
				(cond
					((== gDay 6))
					((and (gPqFlags test: 127) (not (gPqFlags test: 128)))
						(gGame handsOff:)
						(gCurRoom setScript: drinkTeaScript)
					)
					((and (gPqFlags test: 128) (not (gPqFlags test: 101)))
						(gGame handsOff:)
						(gCurRoom setScript: seeMovieScript)
					)
					(else
						(gCurRoom setScript: from605Script)
					)
				)
			)
		)
		(door init: approachVerbs: 4) ; Do
		(coffeeMaker init:)
		(trashCan init: approachVerbs: 4 32 74 30 45) ; Do, pretzels, candyBar, cigarette, matches
		(backWall init:)
		(popcorn init:)
		(counter init:)
		(cabinet init:)
		(leftCan init: approachVerbs: 4) ; Do
		(middleCan init: approachVerbs: 4) ; Do
		(if (not (gEgo has: 49)) ; sodaCan
			(rightCan init: approachVerbs: 4) ; Do
		)
		(cond
			((and (gPqFlags test: 101) (< gDay 6))
				(self setScript: afterDreamScript)
			)
			((and (gPqFlags test: 127) (not (gPqFlags test: 128)))
				(gCurRoom setScript: drinkTeaScript)
			)
			((and (gPqFlags test: 128) (not (gPqFlags test: 101)))
				(gCurRoom setScript: seeMovieScript)
			)
			((== gPrevRoomNum 605)
				(gCurRoom setScript: from605Script)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((self script:) 0)
			((> (gEgo x:) 279)
				(gCurRoom newRoom: 620)
			)
			((< (gEgo x:) 69)
				(gCurRoom newRoom: 640)
			)
			((> (gEgo y:) 160)
				(cond
					(
						(or
							(== local1 1)
							(gPqFlags test: 127)
							(and
								(gPqFlags test: 128)
								(not (gPqFlags test: 101))
							)
						)
						(gEgo y: 158 setMotion: 0)
						(gMessager say: 0 77 35 0) ; "Don't run off! Continue your investigation."
					)
					((!= gDay 6)
						(gCurRoom newRoom: 605)
					)
					(else
						(gEgo y: 159 setMotion: 0)
						(gMessager say: 0 0 35 0) ; "The doors leading to the street are locked!"
					)
				)
			)
		)
	)

	(method (dispose)
		(gGame intensity: 100)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 605)
			(gPqFlags clear: 169)
		else
			(gPqFlags set: 121)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance afterDreamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 3 0 34 0) ; "Pl... please go! I... I... have to... to get re... ready for the ne... next show. Yo... you fa... falling a... asleep pu... put me behind in..in mmm... my schedule."
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(2
				(gCurRoom newRoom: 605)
			)
		)
	)
)

(instance drinkTeaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 3 2 31 0 self) ; "Pl...please ha..have a..a cc..cup of tea o..on the ho..use."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance seeMovieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 3 2 32 2 self) ; "Ho..how about a... a moo..vie on th..the ho..use? Ev..everybo..body de..deserves a... a treat one...once in a while."
			)
			(2
				(mitchell
					view: 615
					loop: 0
					cel: 0
					x: 171
					y: 97
					setCycle: End self
				)
			)
			(3
				(mitchell loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance from605Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame intensity: 100 fade: 0 100 10)
				(= ticks 30)
			)
			(2
				(= local2 1)
				(gMessager say: 3 2 40 0 self) ; "Ho...how ma..ma.. may I help you?"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 2
		nsLeft 246
		nsTop 15
		nsRight 280
		nsBottom 138
		sightAngle 40
		approachX 271
		approachY 131
		approachDist 67
		x 264
		y 69
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (and (gPqFlags test: 128) (not (gPqFlags test: 101)))
					(gGame handsOff:)
					(gGame points: 3 83)
				)
				(gCurRoom newRoom: 670)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toRight of ExitArrow
	(properties
		nsLeft 280
		nsBottom 152
		nsRight 319
		exitDir 2
	)
)

(instance toLeft of ExitArrow
	(properties
		nsBottom 152
		nsRight 67
		exitDir 4
	)
)

(instance toTheatre of ExitArrow ; UNUSED
	(properties
		exitDir 1
	)

	(method (init)
		(self
			nsTop: (door nsTop:)
			nsLeft: (door nsLeft:)
			nsBottom: (door nsBottom:)
			nsRight: (door nsRight:)
		)
		(super init:)
	)
)

(instance toStreet of ExitArrow
	(properties
		nsTop 150
		nsLeft 130
		nsBottom 190
		nsRight 191
		exitDir 3
	)
)

(instance mitchCryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(mitchell view: 612 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(mitchell loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 3 4 13 0 self) ; "Ah... ah... ah... Am... am I... I un... under arest? Oh... oh..."
			)
			(3
				(mitchell loop: 2 cel: 0 setCycle: End self)
			)
			(4
				(mitchell view: 611 loop: 0 cel: 0 x: 169 y: 92)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coffeeMaker of Feature
	(properties
		noun 7
		nsLeft 68
		nsTop 77
		nsRight 85
		nsBottom 100
		sightAngle 40
		x 76
		y 88
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager
					say:
						noun
						theVerb
						(if (gCast contains: mitchell) 0 else 42)
						0
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trashCan of Feature
	(properties
		heading 180
		noun 6
		nsLeft 232
		nsTop 88
		nsRight 255
		nsBottom 128
		sightAngle 40
		approachX 245
		approachY 139
		approachDist 10
		x 243
		y 108
	)

	(method (doVerb theVerb)
		(switch theVerb
			(32 ; pretzels
				(gEgo put: 21) ; pretzels
				((gInventory at: 21) owner: gCurRoomNum) ; pretzels
				(gMessager say: 6 32 0 0) ; "It's about time you threw these pretzels away. All that salt was"
			)
			(74 ; candyBar
				(gEgo put: 48) ; candyBar
				((gInventory at: 48) owner: gCurRoomNum) ; candyBar
				(gMessager say: 6 74 0 0) ; "The candy bar is all melted from being carried around for so long."
			)
			(30 ; cigarette
				(gEgo put: 19) ; cigarette
				((gInventory at: 19) owner: gCurRoomNum) ; cigarette
				(gMessager say: 6 30 0 0) ; "This cigarette's been smelling up your suit long enough!"
			)
			(45 ; matches
				(gEgo put: 31) ; matches
				((gInventory at: 31) owner: gCurRoomNum) ; matches
				(gMessager say: 6 45 0 0) ; "Since you're not going camping anytime soon, you might as well"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance counter of Feature
	(properties
		noun 1
		nsLeft 112
		nsTop 84
		nsRight 222
		nsBottom 128
		sightAngle 40
		x 167
		y 106
	)
)

(instance popcorn of Feature
	(properties
		noun 9
		nsLeft 185
		nsTop 17
		nsRight 221
		nsBottom 83
		sightAngle 40
		x 203
		y 50
	)
)

(instance cabinet of Feature
	(properties
		noun 10
		nsLeft 121
		nsTop 16
		nsRight 158
		nsBottom 83
		sightAngle 40
		approachX 139
		approachY 49
		approachDist 0
		x 139
		y 49
	)

	(method (init)
		(self createPoly: 127 28 156 28 156 85 125 86 120 83 120 28)
		(super init: &rest)
	)
)

(instance backWall of Feature
	(properties
		noun 8
		nsLeft 58
		nsTop 9
		nsRight 221
		nsBottom 78
		sightAngle 40
		x 139
		y 17
	)
)

(instance makeTeaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gPqFlags set: 149)
				(gMessager say: 3 2 30 0 self) ; "I...It's hor..rible. All th..this cc..crying ha..has made me thi..thirsty. Ho..ow about you? Woo..uld you like som..something to.. to drink?"
			)
			(1
				(mitchell
					view: 610
					loop: 0
					cel: 0
					x: 135
					y: 85
					setCycle: End self
				)
			)
			(2
				(teaPot z: 1000)
				(mitchell loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(mitchell setCycle: CT 11 1 self)
			)
			(5
				(teaPot z: 0)
				(mitchell setCycle: End self)
			)
			(6
				(mitchell view: 616 loop: 0 cel: 0 setCycle: End self)
			)
			(7
				(tea init:)
				(mitchell view: 611 loop: 0 cel: 0 x: 169 y: 92)
				(= cycles 2)
			)
			(8
				(gMessager say: 3 2 31 0 self) ; "Pl...please ha..have a..a cc..cup of tea o..on the ho..use."
			)
			(9
				(gGame handsOn:)
				(gPqFlags set: 127)
				(= seconds 5)
			)
			(10
				(if (not (gPqFlags test: 128))
					(if (not register)
						(= register 1)
						(-= state 3)
						(self setScript: startCryScript self)
					else
						(= ticks 60)
						(-= state 1)
					)
				else
					(= cycles 2)
				)
			)
			(11)
		)
	)
)

(instance nowDrinkTeaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: PolyPath 179 143 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 3 0 33 0 self) ; "The tea is refreshing, if not a little bitter."
				(gPqFlags set: 128)
			)
			(5
				(self setScript: stopCryScript self)
			)
			(6
				(gMessager say: 3 2 32 0 self) ; "Do..don't you f..feel better? I... I kno..know I do."
			)
			(7
				(mitchell
					view: 615
					loop: 0
					cel: 0
					x: 171
					y: 97
					setCycle: End self
				)
			)
			(8
				(mitchell loop: 1 cel: 0 setCycle: End self)
			)
			(9
				(mitchell view: 611 loop: 0 cel: 0 x: 169 y: 92)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tea of Prop
	(properties
		noun 11
		x 176
		y 100
		z 17
		priority 130
		fixPriority 1
		view 616
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gPqFlags test: 128)
					(super doVerb: theVerb)
				else
					(gGame handsOff:)
					(gGame points: 3)
					(gPqFlags set: 128)
					(gCurRoom setScript: nowDrinkTeaScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance careyTalker of Narrator
	(properties
		x 110
		y 10
	)
)

(instance mitchTalker of Narrator
	(properties
		x 25
		y 10
	)
)

(instance leftCan of Feature
	(properties
		noun 12
		nsLeft 129
		nsTop 16
		nsRight 135
		nsBottom 25
		sightAngle 40
		approachX 142
		approachY 143
		approachDist 0
		x 132
		y 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: getCanScr 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance middleCan of Feature
	(properties
		noun 13
		nsLeft 136
		nsTop 16
		nsRight 142
		nsBottom 25
		sightAngle 40
		approachX 142
		approachY 143
		approachDist 0
		x 140
		y 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: getCanScr 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance teaPot of Prop
	(properties
		noun 7
		x 77
		y 96
		view 9950
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager
					say:
						noun
						theVerb
						(if (gCast contains: mitchell) 0 else 42)
						0
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightCan of Prop
	(properties
		noun 14
		sightAngle 40
		approachX 142
		approachY 143
		x 147
		y 18
		view 9950
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCast contains: mitchell)
						(gMessager say: 14 4 36 0) ; "A..are y..you thirsty?"
					)
					((not (gEgo has: 49)) ; sodaCan
						(gCurRoom setScript: getCanScr 0 self)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance getCanScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(switch register
					(rightCan
						(gGame points: 4)
						(gEgo get: 49) ; sodaCan
						(rightCan dispose:)
						(= cycles 2)
						(= register 0)
					)
					(leftCan
						(gMessager say: 12 4 0 0 self) ; "The can is stuck to the shelf. It won't lift off."
					)
					(else
						(gMessager say: 13 4 0 0 self) ; "The soda is stuck to the shelf and will not come off."
					)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance mitchell of Prop
	(properties
		noun 3
		approachX 225
		approachY 143
		approachDist 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; notebook
				(gMessager say: 3 52 21) ; "Wh..why are yy..you taking notes? Wa..what am I...I ss..s.saying?"
			)
			(4 ; Do
				(if local0
					(gMessager say: 3 4 16 0) ; "Better not, he'll probably just start crying again."
				else
					(gCurRoom setScript: mitchCryScript)
				)
			)
			(2 ; Talk
				(cond
					(local2
						(= local2 0)
						(gMessager say: 3 2 8 0) ; "Mitchell, I'd like to ask you a few questions, if that's all right?"
					)
					(
						(or
							(gPqFlags test: 118)
							(gPqFlags test: 120)
							(gPqFlags test: 119)
						)
						(gCurRoom setScript: talkScr)
					)
					((and (gPqFlags test: 128) (not (gPqFlags test: 101)))
						(gMessager say: 3 2 32 0) ; "Do..don't you f..feel better? I... I kno..know I do."
					)
					((and (gPqFlags test: 127) (not (gPqFlags test: 128)))
						(gMessager say: 3 2 31 0) ; "Pl...please ha..have a..a cc..cup of tea o..on the ho..use."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mitchellTeller of Teller
	(properties
		sayNoun 4
		verb 5
	)

	(method (doVerb)
		(cond
			(local2
				(client doVerb: &rest)
			)
			(
				(or
					(gPqFlags test: 118)
					(gPqFlags test: 120)
					(gPqFlags test: 119)
				)
				(gCurRoom setScript: talkScr)
			)
			(
				(and
					(== local1 1)
					(or (== iconValue 25) (== iconValue 26) (== iconValue 28))
				)
				(mitchell setScript: stopCryScript)
				(super doVerb: &rest)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)

	(method (showCases)
		(super
			showCases:
				23
				(== ((gInventory at: 22) state:) 1) ; folders
				9
				(not (gPqFlags test: 149))
				12
				(not (gPqFlags test: 149))
				11
				(not (gPqFlags test: 149))
				31
				(gPqFlags test: 149)
		)
	)

	(method (sayMessage)
		(cond
			((== iconValue 25)
				(mitchell setScript: talkScr 0 2)
			)
			((== iconValue 26)
				(mitchell setScript: talkScr 0 3)
			)
			((== iconValue 28)
				(mitchell setScript: luellaScript)
			)
			((== iconValue 30)
				(gCurRoom setScript: makeTeaScript)
			)
			(else
				(if (== local1 1)
					(gCurRoom setScript: stopCryScript)
				)
				(super sayMessage: &rest)
			)
		)
	)
)

(instance talkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(cond
					((== register 2)
						(if (!= local1 1)
							(self setScript: startCryScript self)
						else
							(= cycles 2)
						)
					)
					((== register 3)
						(if (== local1 1)
							(self setScript: stopCryScript self)
						else
							(= cycles 2)
						)
					)
					((== local1 1)
						(self setScript: stopCryScript self)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(2
				(cond
					((not register)
						(cond
							((gPqFlags test: 118)
								(gPqFlags clear: 118)
								(gMessager say: 3 2 17 0 self) ; "In the theater there are two doors, down by the screen. What's behind them?"
							)
							((gPqFlags test: 120)
								(gPqFlags clear: 120)
								(gMessager say: 3 2 18 0 self) ; "Mitchell, whose dress is in the women's bathroom?"
							)
							((gPqFlags test: 119)
								(gPqFlags clear: 119)
								(gMessager say: 3 2 19 0 self) ; "What's with the smell in the men's bathroom? It's horrible."
							)
							(else
								(= cycles 2)
							)
						)
					)
					((== register 2)
						(gMessager say: 4 5 25 0 self) ; "Mitchell, what is so sad? Why don't you calm down and slowly tell me what happened. OK, Mitchell? Real slow and easy."
					)
					((== register 3)
						(gMessager say: 4 5 26 0 self) ; "What about your dog, Mitchell? Did your dog hurt someone? Did your dog hurt Luella? Is that what happened, Mitchell? You can tell me, it's all right."
					)
					(else
						(= cycles 2)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance startCryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(mitchell
					view: 612
					loop: 0
					cel: 0
					x: 165
					y: 91
					setCycle: End self
				)
			)
			(2
				(mitchell loop: 1 cel: 0 setCycle: Fwd)
				(if (== client luellaScript)
					(= seconds 5)
				else
					(= cycles 2)
				)
			)
			(3
				(= local1 1)
				(if (== client luellaScript)
					(gGame handsOff:)
				)
				(self dispose:)
			)
		)
	)
)

(instance stopCryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(mitchell view: 612 loop: 2 cel: 0 setCycle: End self)
			)
			(1
				(mitchell view: 611 loop: 0 cel: 0 x: 169 y: 92)
				(= cycles 2)
			)
			(2
				(= local1 0)
				(if (== client luellaScript)
					(gGame handsOff:)
				)
				(self dispose:)
			)
		)
	)
)

(instance luellaScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(= cycles 2)
			)
			(1
				(gMessager say: 4 5 28 1 self) ; ""Mitchell, when was the last time you spoke to Luella? Do you remember?"
			)
			(2
				(gMessager say: 4 5 28 2 self) ; "Ma..maybe a...a c.c.couple of..of weeks a..a..ago. Wh..why a..are y..you asking so... so ma..ny ques..questions? Ha..has some... something ha..happened to..to Lu..ella?"
			)
			(3
				(gMessager say: 4 5 28 3 self) ; "Luella was found murdered, Mitchell. I'm looking for the person who killed her."
			)
			(4
				(self setScript: startCryScript self)
			)
			(5
				(gMessager say: 4 5 28 4 self) ; "Oh..oh... mm..my... oh... oh my! Oh... oh, no!"
			)
			(6
				(self setScript: stopCryScript self)
			)
			(7
				(mitchellTeller dispose:)
				(mitchell setScript: makeTeaScript)
				(self dispose:)
			)
		)
	)
)

