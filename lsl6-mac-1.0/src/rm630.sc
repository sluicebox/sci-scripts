;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use n078)
(use n079)
(use n082)
(use LarryRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm630 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = -1
	[local6 7]
	[local13 7] = [0 2 4 6 8 10 12]
	[local20 7] = [132 120 100 112 97 86 31]
	[local27 28] = [88 85 74 82 78 71 63 1 4 2 8 8 4 -1 1 2 3 2 2 1 -1 -1 52 48 106 56 52 40]
	local55 = -1
	local56
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64 = -1
	local65
)

(class cObj of Obj
	(properties)
)

(instance rm630 of LarryRoom
	(properties
		noun 7
		picture 630
		style 15
		horizon 0
	)

	(method (init)
		(if (== global100 2)
			(= local2 5)
		)
		(SetFlag 77)
		(if
			(and
				(== gPrevRoomNum 620)
				(IsFlag 52)
				(or
					(and (IsFlag 34) (not (IsFlag 12)))
					(and (IsFlag 80) (IsFlag 79))
				)
			)
			(markus init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
			(if (IsFlag 79)
				(markus
					view: 639
					setLoop: 0
					setCycle: Fwd
					x: 202
					y: 93
					setPri: 7
					setScript: workOnToiletScr
				)
			else
				(markus setScript: workOnSinkScr)
			)
			(= local56 1)
			(SetFlag 54)
			(SetFlag 101)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 183 71 183 85 236 85 223 71
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 183 71 167 101 243 101 223 71
						yourself:
					)
			)
		)
		(if (== gPrevRoomNum 860)
			(= style 7)
			(gGame setCursor: gWaitCursor)
			(theDoor cel: 0 init: approachVerbs: 4 stopUpd:) ; Do
			(gEgo
				show:
				x: (sink approachX:)
				y: (sink approachY:)
				init:
				view: 635
				setLoop: 7
				cycleSpeed: 6
				cel: 3
				setScale: Scaler 100 72 69 53
				actions: egoActions
			)
			(SetFlag 50)
			(ClearFlag 52)
			(self setScript: afterShabScr)
		else
			(gEgo
				x: 205
				y: 58
				init:
				normalize: 636 2 1
				setScale: Scaler 100 72 69 53
				setPri: 1
				actions: egoActions
			)
			(theDoor init: stopUpd: approachVerbs: 4) ; Do
			(self setScript: enterDoorScr)
		)
		(super init:)
		(if (== gPrevRoomNum 860)
			(gGame drawControls:)
		)
		(gGlobalSound2 number: 0 stop:)
		(if (or (not (== (gGlobalSound1 number:) 620)) (not (gGlobalSound1 handle:)))
			(gGlobalSound1 number: 620 loop: -1 play: 100)
		else
			(gGlobalSound1 fade: 100 10 10 0)
		)
		(flowers init:)
		(toiletCovers init:)
		(upperToilet init: approachVerbs: 4 61 6) ; Do, toiletcover, Zipper
		(lowerToilet init: approachVerbs: 4 61 6) ; Do, toiletcover, Zipper
		(lowerToilet3 init: approachVerbs: 4 61 6) ; Do, toiletcover, Zipper
		(shower init:)
		(sink init: approachVerbs: 4 57 35) ; Do, soap, washcloth
		(rWindow init:)
		(lWindow init:)
		(towelHandle init:)
		(mirror1 init:)
		(mirror init:)
		(mirror2 init:)
		(fWindow init:)
		(fWindow2 init:)
		(= local1 (gNarrator talkWidth:))
		(gNarrator x: 5 y: 30 talkWidth: 130)
		(Load rsSCRIPT 1800)
		(Load rsSOUND 1030)
		(Load rsVIEW 635)
		(Load rsSOUND 355)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				local56
				(not (IsFlag 12))
				(IsFlag 34)
				(== (markus script:) workOnToiletScr)
			)
			(ClearFlag 54)
			(ClearFlag 79)
		)
		(yuckTimer dispose: delete:)
		(fartTimer dispose: delete:)
		(gNarrator x: -1 y: -1 talkWidth: local1)
		(if (!= newRoomNumber 620)
			(gGlobalSound1 fade: 0 10 10 1)
		)
		(gEgo setScale: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				local65
				(== (gEgo view:) 635)
				(== (gEgo loop:) 5)
				(not (gEgo cel:))
			)
			(sfx number: 632 loop: 1 play:)
		)
	)
)

(instance gasket of View
	(properties
		x 185
		y 93
		view 630
		loop 5
		priority 7
		signal 18448
	)
)

(instance egoHead of View
	(properties)

	(method (doVerb theVerb)
		(gEgo doVerb: theVerb)
	)
)

(instance theDoor of Prop
	(properties
		x 182
		y 7
		noun 14
		approachX 207
		approachY 65
		view 630
		cel 5
		priority 1
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: exitDoorScr)
				else
					(gMessager say: 14 4 2) ; "Keep that door closed! Somebody's on the can in here!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sinkWater of Prop
	(properties
		x 156
		y 63
		view 630
		loop -1
		priority 2
		signal 18448
	)

	(method (init)
		(if (IsFlag 12)
			(= loop 2)
		else
			(= loop 1)
		)
		(runningWaterFx number: 634 loop: -1 play:)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (dispose)
		(runningWaterFx stop:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(sink doVerb: theVerb)
	)
)

(instance lWindow of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 105 0 150 95 90 95 87 99 112 127 112 139 0 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rWindow of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 262 0 319 0 319 60 303 96 268 96
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fWindow of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 163 127 166 119 224 110 224 117 222 120 221 128 218 132 161 132 153 139 112 139 112 127
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fWindow2 of Feature
	(properties
		noun 1
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 247 139 243 132 237 133 236 129 239 121 243 121 243 124 247 127 251 126 252 133 256 129 255 122 260 126 263 118 270 117 273 112 268 107 267 107 269 103 269 97 295 97 277 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance shower of Feature
	(properties
		x 250
		y 41
		noun 9
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 255 0 255 88 228 62 228 58 230 55 231 49 226 45 225 41 231 39 234 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance toiletCovers of Feature
	(properties
		noun 11
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 91 96 152 96 164 121 163 126 113 127 90 100
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance flowers of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 214 87 222 88 223 84 230 84 232 89 237 83 243 87 247 87 247 95 266 96 266 107 272 114 269 117 264 116 263 123 259 126 254 121 256 130 251 131 250 126 245 126 242 122 239 121 237 128 238 135 236 139 217 139 217 133 221 127 222 120 224 118 225 109 221 107 219 104 215 104 214 101 215 99 216 93
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance mirror of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 126 22 152 48 142 57 yourself:)
		)
		(super init: &rest)
	)
)

(instance mirror1 of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 106 0 116 0 168 107 187 104 187 115 163 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance mirror2 of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 254 0 262 0 267 96 259 96 248 94 246 90 255 89
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance towelHandle of Feature
	(properties
		x 148
		y 35
		noun 13
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 139 31 149 25 158 37 145 42
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local3
					(gMessager say: 13 4 17) ; "You can't do that now-- you're on the can!"
				else
					(if (not (-- local2))
						(gEgo get: 38 36 37 19 6) ; towel
					)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (and (not local56) (IsFlag 50))
					(sinkWater init:)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 72 self)
			)
			(2
				(gEgo setPri: -1)
				(gEgo setHeading: 360 self)
			)
			(3
				(theDoor setCycle: Beg self)
			)
			(4
				(sfx number: 1033 loop: 1 play:)
				(= ticks 60)
			)
			(5
				(if local56
					(gEgo setMotion: MoveTo 205 79 self)
				else
					(gEgo setHeading: 225 self)
				)
			)
			(6
				(if local56
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 191 87 self)
				)
			)
			(7
				(gEgo setHeading: 270 self)
			)
			(8
				(theDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance exitDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 30)
			)
			(1
				(gEgo setHeading: 360 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(sfx number: 1032 loop: 1 play:)
				(theDoor setCycle: End self)
			)
			(4
				(gGlobalSound1 fade: 127 10 10 0)
				(gEgo setMotion: MoveTo 205 58 self)
			)
			(5
				(gCurRoom newRoom: 620)
			)
		)
	)
)

(instance turnOnWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local58 1)
				(gEgo setMotion: PolyPath 181 85 self)
			)
			(1
				(if (!= (gEgo heading:) 270)
					(gEgo setHeading: 270 self)
				else
					(= cycles 2)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					view: 635
					setCycle: 0
					setLoop: 6
					cel: 0
					cycleSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(4
				(sfx number: 355 loop: 1 play: self)
			)
			(5
				(SetFlag 50)
				(sinkWater init:)
				(= ticks 20)
			)
			(6
				(sfx number: 355 loop: 1 play: self)
			)
			(7
				(= ticks 20)
			)
			(8
				(sfx number: 355 loop: 1 play: self)
			)
			(9
				(= seconds 3)
			)
			(10
				(if (not (IsFlag 12))
					(gNarrator modeless: 1)
					(gMessager say: 10 1 14 0 self) ; "Yuck! The water coming out of the sink is brown!"
				else
					(= cycles 2)
				)
			)
			(11
				(gNarrator modeless: 0)
				(gEgo normalize: 636 1 1)
				(SetFlag 19)
				(= local58 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfxL of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance runningWaterFx of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance upperToilet of Feature
	(properties
		x 200
		y 104
		noun 12
		sightAngle 10
		approachX 201
		approachY 100
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 187 115 187 100 191 94 200 92 209 93 217 95 214 97 215 101 219 103 219 107 223 108 223 111 220 115
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if local3
			(gEgo doVerb: theVerb)
		else
			(switch theVerb
				(4 ; Do
					(cond
						(local56
							(gMessager say: 12 4 7) ; "You can't get to the toilet with this plumber in your way!"
						)
						((and (> local59 1) (not local60) (not (IsFlag 79)))
							(sfx number: 633 loop: 1 play:)
							(= local60 1)
							(SetFlag 79)
							(gMessager say: 12 4 24) ; "Oh, no! The water's rising!"
						)
						((IsFlag 79)
							(sfx number: 633 loop: 1 play: toiletCue)
						)
						(else
							(= local60 1)
							(= local59 0)
							(sfx number: 633 loop: 1 play:)
							(gMessager say: 12 4) ; "You flush the toilet. Good boy!"
						)
					)
				)
				(61 ; toiletcover
					(cond
						((IsFlag 79)
							(gMessager say: 12 61 24) ; "There's no way you want to increase your contribution to the contents of THAT mess!"
						)
						(local56
							(gMessager say: 12 61 7) ; "You don't really want to use the toilet while that plumber is here."
						)
						(local3
							(gMessager say: 12 61 17) ; MISSING MESSAGE
						)
						(else
							(gCurRoom setScript: useToiletScr)
						)
					)
				)
				(62 ; toiletpaper
					(cond
						((IsFlag 79)
							(gMessager say: 12 62 24) ; "You've already clogged this toilet bowl! There's no need for another "contribution!""
						)
						(local56
							(gMessager say: 12 62 7) ; "You would never try to flush a whole roll of toilet paper down the can. At least, not when the plumber is right here!"
						)
						(else
							(gCurRoom setScript: plugToiletScr)
						)
					)
				)
				(1 ; Look
					(cond
						((IsFlag 79)
							(gMessager say: 12 1 24) ; "The water in your toilet is all the way up to the very top! How can you fix it?"
						)
						((gEgo has: 36) ; toiletcover
							(gMessager say: 12 1 15) ; "What a beautiful setting in which to obey Nature's call."
						)
						(else
							(gMessager say: 12 1) ; "The toilet looks clean, but a guy can never be too sure! You wouldn't want to catch one of those diseases you heard about."
						)
					)
				)
				(6 ; Zipper
					(cond
						((IsFlag 79)
							(gMessager say: 12 6 24) ; "Even another drop would run this mess over the top and onto the floor!"
						)
						(local56
							(gMessager say: 12 6 7) ; "The plumber doesn't care to watch you right now."
						)
						((>= local63 2)
							(gMessager say: 12 6 25) ; "(Guess I didn't have to go!)"
						)
						(else
							(gCurRoom setScript: pissScr)
						)
					)
				)
				(35 ; washcloth
					(gGame changeScore: 6 250)
					(= global185 4)
					((gInventory at: 39) cue:) ; washcloth
					(gMessager say: 2 35 0 0 0 85) ; "You wet the washcloth in the water."
				)
				(37 ; washCloth [ chilled ]
					(gMessager say: 2 37 0 0 0 85) ; "If you re-wet your now-chilled washcloth, it won't be chilled any more."
				)
				(36 ; washCloth [ wet ]
					(gMessager say: 2 36 0 0 0 85) ; "Hey, you can never get a washcloth too wet!"
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance lowerToilet of Feature
	(properties
		noun 12
		approachX 201
		approachY 100
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 237 133 244 133 248 140 236 140
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(upperToilet doVerb: theVerb)
	)
)

(instance lowerToilet3 of Feature
	(properties
		noun 12
		approachX 201
		approachY 100
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 154 139 160 132 218 132 216 135 218 139
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(upperToilet doVerb: theVerb)
	)
)

(instance yuckTimer of Timer
	(properties)

	(method (cue)
		(if (and local3 (not ((gCurRoom script:) script:)))
			((gCurRoom script:) setScript: yuckScr)
		)
	)
)

(instance fartTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				local3
				(not ((gCurRoom script:) script:))
				(not local65)
				(!= (gEgo view:) 636)
			)
			((gCurRoom script:) setScript: fartScr)
		)
	)
)

(instance crowdScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register local55)
					(= ticks 10)
				else
					(= cycles 2)
				)
			)
			(1
				(if (== register local55)
					(client
						setMotion:
							MoveTo
							[local20 register]
							[local27 register]
							self
					)
				else
					(client setMotion: MoveTo 66 65 self)
				)
			)
			(2
				(if (== register local55)
					(client cel: 0 setCycle: 0)
					(= ticks 30)
				else
					(client
						setMotion:
							MoveTo
							[local20 register]
							[local27 register]
							self
					)
				)
			)
			(3
				(if (== register local55)
					(= local55 -1)
					(= local5 -1)
					((gEgo script:) cue:)
					(self dispose:)
				else
					(client setLoop: (+ (client loop:) 1) cel: 0 setCycle: 0)
					(= cycles 2)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance wetClothScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 635 setLoop: 1 cycleSpeed: 8 setCycle: Fwd)
				(= ticks 120)
			)
			(1
				(if (not (IsFlag 12))
					(= global185 8)
				else
					(= global185 0)
				)
				(gGame changeScore: 6 250)
				(gMessager say: 2 35 0 0 self 85) ; "You wet the washcloth in the water."
			)
			(2
				((gInventory at: 39) cue:) ; washcloth
				(gEgo normalize: 636 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnOffWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local58 1)
				(if (and (!= (gEgo x:) 181) (!= (gEgo y:) 85))
					(gEgo setMotion: PolyPath 181 85 self)
				else
					(= cycles 2)
				)
			)
			(1
				(if (!= (gEgo heading:) 270)
					(gEgo setHeading: 270 self)
				else
					(= cycles 2)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					view: 635
					setCycle: 0
					setLoop: 6
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(4
				(sfx number: 355 loop: 1 play: self)
			)
			(5
				(= ticks 20)
			)
			(6
				(sfx number: 355 loop: 1 play: self)
			)
			(7
				(= ticks 20)
			)
			(8
				(sfx number: 355 loop: 1 play: self)
			)
			(9
				(runningWaterFx stop:)
				(ClearFlag 50)
				(sinkWater dispose:)
				(= ticks 60)
			)
			(10
				(gEgo normalize: 636 1 1)
				(= local58 0)
				(= ticks 60)
			)
			(11
				(= cycles 2)
				(if (and (not local62) (== gPrevRoomNum 860))
					(= local62 1)
					(proc78_0)
				)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance workOnToiletScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (markus loop:) 0) (== (markus cel:) 1) (not (sfx handle:)))
			(sfx number: 328 loop: 1 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(markus setLoop: 1 setCycle: 0 cel: 0)
				(= ticks 30)
			)
			(2
				(markus setCycle: End self)
			)
			(3
				(markus setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(sfx number: 814 loop: 1 play:)
				(= seconds 3)
			)
			(5
				(switch (Random 0 5)
					(1
						(sfx number: 631 loop: 1 play:)
					)
					(2
						(sfx number: 516 loop: 1 play:)
					)
				)
				(= ticks 60)
			)
			(6
				(markus setLoop: 3 cel: 0 setCycle: End self)
			)
			(7
				(markus setLoop: 0 setCycle: Fwd)
				(self init:)
			)
		)
	)
)

(instance talkToMarkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local61)
					(= local61 1)
					(if (== (markus script:) workOnSinkScr)
						(++ state)
						(gMessager say: 4 2 26 1 8 self) ; "Thanks for coming so fast."
					else
						(gMessager say: 4 2 27 0 self) ; "Oh, hi. Thanks for fixing my toilet."
					)
				else
					(gMessager say: 4 2 23 0 self) ; "Say..."
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
			(2
				(= seconds 3)
			)
			(3
				(gMessager say: 4 2 26 9 self) ; "(Geez, what an asshole!)"
			)
			(4
				(= seconds 3)
			)
			(5
				(gMessager say: 4 2 26 10 self) ; "(Geez, what an asshole!)"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pissScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 12 6 0 0 self) ; "Finally. The RIGHT place!"
			)
			(1
				(gEgo
					view: 634
					setLoop: 0
					cycleSpeed: 8
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
				(sfx number: 1035 loop: 1 play:)
			)
			(3
				(sfxL number: 1031 loop: -1 play:)
				(gEgo setPri: 7 setLoop: 1 cycleSpeed: 4 setCycle: Fwd)
				(if (> (++ local63) 1)
					(= seconds 2)
				else
					(= seconds 4)
				)
			)
			(4
				(sfxL stop:)
				(= register 3)
				(= cycles 2)
			)
			(5
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(sfx number: 351 loop: 1 play:)
				(if (-- register)
					(-= state 2)
				)
				(= ticks 60)
			)
			(7
				(gEgo
					setLoop: 0
					setCycle: 0
					cel: 10
					cycleSpeed: 8
					setCycle: CT 3 -1 self
				)
			)
			(8
				(gEgo setCycle: Beg self)
				(sfx number: 1035 loop: 1 play:)
			)
			(9
				(gGame changeScore: 2 252 handsOn:)
				(gEgo normalize: 636 2 1)
				(self dispose:)
			)
		)
	)
)

(instance plugToiletScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 79)
				(gMessager say: 12 62 16 1 self) ; "You briefly consider stuffing the toilet with the whole roll of toilet paper, but you outgrew such juvenile behavior years ago!"
			)
			(1
				(= seconds 2)
			)
			(2
				(gMessager say: 12 62 16 2 self) ; "Oh, yeah?"
			)
			(3
				(sfx number: 814 loop: 1 play:)
				(gEgo put: 37) ; toiletpaper
				(= ticks 30)
			)
			(4
				(gMessager say: 12 62 16 3 self) ; "Okay, okay! You stuff the entire roll of toilet paper into the commode."
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance jerkOffScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theDoor stopUpd:)
				(gEgo view: 635 setLoop: 5 cycleSpeed: 4 cel: 0)
				(gMessager say: 2 54 2 1 self) ; "Well... since nobody's watching... AND you asked..."
			)
			(1
				(= local65 1)
				(gEgo setCycle: Fwd)
				(= ticks 180)
			)
			(2
				(if (< (++ local5) 6)
					(-- state)
				else
					(= local55 local5)
				)
				((= [local6 local5] (Actor new:))
					view: 638
					setLoop: [local13 local5]
					x: 0
					y: 62
					setStep: 1 1
					cycleSpeed: 4
					moveSpeed: 4
					ignoreActors: 1
					init:
					setCycle: Fwd
					setScript: (crowdScr new:) 0 local5
				)
				(if (== local5 5)
					(= ticks 300)
				else
					(= ticks 180)
				)
			)
			(3)
			(4
				(sfxL number: 141 loop: -1 play:)
				(gNarrator x: 150 y: 5)
				(= cycles 1)
			)
			(5
				(gMessager say: 2 54 2 2 self) ; "How humiliating! A huge crowd of people watching you in your "most personal moment!""
			)
			(6
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					([local6 temp1] dispose:)
					(= [local6 temp1] 0)
				)
				(sfxL number: 0 stop:)
				(EgoDead 18 self)
			)
			(7
				(gNarrator x: 5 y: 30 talkWidth: 130)
				((gCurRoom script:) dispose:)
				(egoHead dispose:)
				(gasket dispose:)
				(gEgo normalize: 636 2 1)
				(= local65 0)
				(= local3 0)
				(= local57 0)
				((ScriptID 0 11) dispose:) ; iconExit
				(theDoor approachVerbs: 4) ; Do
				(sink approachVerbs: 4 35 57) ; Do, washcloth, soap
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance markus of Prop
	(properties
		x 195
		y 100
		noun 4
		approachX 200
		approachY 85
		view 632
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(cond
					((and (not (gEgo has: 41)) (not (gEgo has: 12))) ; wrench, bastardfile
						(gEgo get: 41) ; wrench
						(gGame changeScore: 8 248)
						(gMessager say: 4 5 5) ; "(Say, I bet he'd never miss a simple adjustable wrench!)"
					)
					((not (gEgo has: 12)) ; bastardfile
						(gEgo get: 12) ; bastardfile
						(gGame changeScore: 8 249)
						(gMessager say: 4 5 6) ; "(Say, I bet he'd never miss a simple file!)"
					)
					(else
						(gMessager say: 4 5 3) ; "Mark has nothing more for you to stea..., er, "borrow.""
					)
				)
			)
			(2 ; Talk
				(gCurRoom setScript: talkToMarkScr)
			)
			(9 ; beer
				(gEgo put: 3) ; beer
				(gMessager say: 4 9) ; "Hey, thanks!"
			)
			(1 ; Look
				(if (== (markus script:) workOnSinkScr)
					(gMessager say: 4 1 26) ; "Mark, the spa plumber, lies under your sink, working hard to correct your brown water."
				else
					(gMessager say: 4 1 27) ; "Mark, the spa plumber, is working hard to correct your stopped-up toilet."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(cond
			((OneOf theVerb 56 48) ; towel, beaver
				(gMessager say: 2 theVerb)
				(return 1)
			)
			(local3
				(switch theVerb
					(54 ; brochure
						(if (and local3 (not local57))
							(gEgo view: 635 setLoop: 5 cel: 0)
							(gMessager say: 2 54 20) ; "Suddenly, you are happy you decided to pause to study the brochure."
							(= local57 1)
							(return 1)
						else
							(super doVerb: theVerb)
						)
					)
					(59 ; handcreme
						(cond
							((and local3 (not local57))
								(gMessager say: 2 59 19) ; "Since no one's looking, you might try that here... since you're all alone."
								(return 1)
							)
							((and local3 local57)
								(gEgo setScript: jerkOffScr)
								(return 1)
							)
							(else
								(super doVerb: theVerb)
							)
						)
					)
					(62 ; toiletpaper
						(if local3
							(gEgo setScript: wipeAssScr)
							(return 1)
						else
							(super doVerb: theVerb)
						)
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

(instance toiletCue of cObj
	(properties)

	(method (cue)
		(gMessager say: 12 4 24) ; "Oh, no! The water's rising!"
	)
)

(instance workOnSinkScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(markus setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(if (gCast contains: sinkWater)
					(markus setLoop: 3 cel: 0 setCycle: End self)
				else
					(= state 5)
					(= ticks (Random 30 120))
				)
				(= register (Random 2 5))
			)
			(2
				(sfx stop:)
				(sinkWater dispose:)
				(= cycles 2)
			)
			(3
				(markus setLoop: 4 cycleSpeed: 6 cel: 0 setCycle: End self)
				(sfx number: 355 loop: 1 play:)
				(if (-- register)
					(= state 1)
				)
			)
			(4
				(markus setLoop: 5 cel: 0 setCycle: End self)
			)
			(5
				(= ticks (Random 30 120))
			)
			(6
				(markus setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(markus setLoop: 2 cel: 0)
				(Load rsSOUND 404)
				(= cycles 2)
			)
			(8
				(= register (Random 3 5))
				(= ticks (Random 30 120))
			)
			(9
				(sfx stop:)
				(= ticks (Random 10 30))
			)
			(10
				(markus
					setLoop: 2
					cel: 0
					cycleSpeed: (Random 6 10)
					setCycle: End self
				)
				(sfx number: 404 loop: 1 play:)
				(if (-- register)
					(-= state 2)
				)
			)
			(11
				(sfx stop:)
				(markus cel: 1 setCycle: Beg self)
			)
			(12
				(= seconds (Random 2 4))
			)
			(13
				(markus setLoop: 3 cel: 0 setCycle: End self)
			)
			(14
				(if
					(and
						(not (gCast contains: sinkWater))
						(> (Random 1 100) 40)
					)
					(sinkWater init:)
					(= ticks (Random 20 90))
				else
					(= ticks 60)
				)
				(= register (Random 2 5))
			)
			(15
				(sfx stop:)
				(= cycles 2)
			)
			(16
				(markus setLoop: 4 cycleSpeed: 6 cel: 0 setCycle: End self)
				(sfx number: 355 loop: 1 play:)
			)
			(17
				(if (-- register)
					(= state 14)
				)
				(if (gCast contains: sinkWater)
					(if (> (Random 1 100) 50)
						(sinkWater setLoop: 2)
					else
						(sinkWater setLoop: 1)
					)
				)
				(= ticks (Random 10 30))
			)
			(18
				(markus setLoop: 5 cel: 0 setCycle: End self)
			)
			(19
				(= ticks (Random 30 90))
				(= register 0)
			)
			(20
				(if (> (Random 1 100) 50)
					(markus setLoop: 6 cel: 0 setCycle: CT 4 1 self)
					(= register 1)
				else
					(= state 23)
					(= cycles 2)
				)
			)
			(21
				(sfx number: 637 loop: 1 play:)
				(markus setCycle: End self)
			)
			(22
				(sfx number: 637 loop: 1 play:)
				(markus setCycle: CT 3 -1 self)
			)
			(23
				(sfx number: 637 loop: 1 play:)
				(markus setCycle: Beg self)
			)
			(24
				(= ticks 60)
			)
			(25
				(switch (= local64 (Random 0 6))
					(1
						(sfx number: 631 loop: 1 play:)
					)
					(2
						(sfx number: 516 loop: 1 play:)
					)
				)
				(= seconds (Random 2 4))
			)
			(26
				(self init:)
			)
		)
	)
)

(instance useToiletScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: changeScore: 2 245)
				(++ local59)
				(if (> (++ local4) 3)
					(gMessager say: 0 0 18 0 self) ; "Perhaps you should stop before you get hemorrhoids!"
				else
					(= local60 0)
					(gMessager say: 12 61 16 0 self) ; "Good idea. You bend over the pot and carefully install an "ass gasket.""
				)
			)
			(1
				(if (> local4 3)
					(gGame handsOn:)
					(self dispose:)
				else
					(SetFlag 55)
					(= local3 1)
					(theDoor approachVerbs: 0)
					(sink approachVerbs: 0)
					(gEgo setHeading: 360 self)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gasket init:)
				(gEgo
					view: 635
					setLoop: 0
					cel: 0
					setCycle: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo setPri: 8 setCycle: CT 4 1 self)
			)
			(5
				(egoHead
					view: 635
					setLoop: 4
					cel: 1
					x: 198
					y: 139
					ignoreActors: 1
					init:
				)
				(sfx number: 814 loop: 1 play:)
				(= cycles 1)
			)
			(6
				(gEgo cel: 5)
				(egoHead cel: 2 stopUpd:)
				(gGame handsOn:)
				(fartTimer setReal: fartTimer 20)
				(yuckTimer setReal: yuckTimer 90)
				((ScriptID 0 11) init: self) ; iconExit
			)
			(7
				((ScriptID 0 11) dispose:) ; iconExit
				(gGame handsOff:)
				(gEgo view: 635 setLoop: 0 setCycle: 0 cel: 4)
				(egoHead cel: 1 forceUpd:)
				(= cycles 2)
			)
			(8
				(gasket dispose:)
				(egoHead cel: 0 forceUpd:)
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo normalize: 636 3 1)
				(= ticks 30)
			)
			(10
				(gEgo setHeading: 180 self)
			)
			(11
				(if (IsFlag 55)
					(gGame changeScore: -2 246)
					(gMessager say: 2 3 2 0 self) ; "But shouldn't you have wiped first?"
				else
					(= cycles 2)
				)
			)
			(12
				(gGame handsOn:)
				(= local3 0)
				(= local57 0)
				(theDoor approachVerbs: 4) ; Do
				(sink approachVerbs: 4 35 57) ; Do, washcloth, soap
				(egoHead dispose:)
				(self dispose:)
			)
		)
	)
)

(instance yuckScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sfx number: 631 loop: 1 play: self)
			)
			(1
				(sfxL number: 1030 loop: -1 play:)
				(= ticks 30)
			)
			(2
				(sfx stop:)
				(sfxL stop:)
				(= ticks 30)
			)
			(3
				(gMessager say: 0 0 28 0 self) ; "Aaaaahhhhhh!"
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sink of Feature
	(properties
		x 151
		y 74
		noun 10
		sightAngle 0
		approachX 181
		approachY 85
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 149 59 157 59 158 58 171 58 174 67 168 76 173 84 170 89 160 86 154 80 149 68 152 65 148 63
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(cond
					((and (not (gCast contains: sinkWater)) (IsFlag 12))
						(gMessager say: 10 1 13) ; "Thanks to Mark, the plumber, your sink now produces cool, clean, clear water."
					)
					((and (gCast contains: sinkWater) (IsFlag 12))
						(gMessager say: 10 1 10) ; "The water runs clean and clear. That plumber may be grumpy, but he sure does his job!"
					)
					((and (gCast contains: sinkWater) (not (IsFlag 12)))
						(gMessager say: 10 1 14) ; "Yuck! The water coming out of the sink is brown!"
					)
					((not local0)
						(= local0 1)
						(gMessager say: 10 1 11) ; "(Hey, I just thought of something. Remember back in Lost Wages? In Lefty's Bar? In his bathroom? Remember when I found that diamond ring lying on the sink? Remember that?)"
					)
					(else
						(gMessager say: 10 1 12) ; "This sink has a brown stain in the bottom."
					)
				)
			)
			(4 ; Do
				(cond
					(local56
						(if (== (markus script:) workOnSinkScr)
							(gMessager say: 10 4 7) ; "You can't wash your hands when the plumber's working under the sink."
						else
							(gMessager say: 10 4 27) ; "Wait until Mark's finished."
						)
					)
					(local3
						(gMessager say: 10 4 2) ; "Very efficient. But... impractical! Your mother taught you to wash your hands AFTER you went to the toilet... not DURING!"
					)
					((gCast contains: sinkWater)
						(gCurRoom setScript: turnOffWaterScr)
					)
					(else
						(gCurRoom setScript: turnOnWaterScr)
					)
				)
			)
			(35 ; washcloth
				(cond
					((not (gCast contains: sinkWater))
						(gMessager say: 10 35 8) ; "Turn on the water first."
					)
					(local3
						(gMessager say: 10 35 14) ; "You don't really want to wash your face in THAT water!"
					)
					(else
						(gCurRoom setScript: washHandsScr 0 1)
					)
				)
			)
			(37 ; washCloth [ chilled ]
				(gMessager say: 2 37 0 0 0 85) ; "If you re-wet your now-chilled washcloth, it won't be chilled any more."
			)
			(36 ; washCloth [ wet ]
				(gMessager say: 2 36 0 0 0 85) ; "Hey, you can never get a washcloth too wet!"
			)
			(6 ; Zipper
				(if local56
					(gMessager say: 10 6 7) ; "While you sometimes do that when you're in a hurry, you decide this plumber wouldn't see the humor in your actions!"
				else
					(super doVerb: theVerb)
				)
			)
			(57 ; soap
				(cond
					((not (gCast contains: sinkWater))
						(gMessager say: 10 57 8) ; "Turn on the water first."
					)
					((not (IsFlag 12))
						(gMessager say: 10 57 14) ; "You wouldn't want to wash your hands in brown water!"
					)
					(else
						(gCurRoom setScript: washHandsScr 0 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance washHandsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local4
					(gGame changeScore: 2 247)
				)
				(= ticks 30)
			)
			(1
				(if (!= (gEgo heading:) 270)
					(gEgo setHeading: 270 self)
				else
					(= cycles 2)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 635 setLoop: 1 setCycle: Fwd cycleSpeed: 6)
				(= ticks 300)
			)
			(4
				(gEgo setLoop: 2 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(if register
					(gEgo setLoop: 3 setCycle: Fwd)
					(= ticks 300)
				else
					(self cue:)
				)
			)
			(7
				(gEgo setLoop: 2 setCel: 255)
				(= ticks 30)
			)
			(8
				(if (not register)
					(gEgo put: 34) ; soap
					(+= state 2)
				)
				(gEgo setCycle: Beg self)
			)
			(9
				(if (not (IsFlag 12))
					(= global185 8)
				else
					(= global185 0)
				)
				(gMessager say: 2 35 0 0 self 85) ; "You wet the washcloth in the water."
			)
			(10
				(gGame changeScore: 6 250)
				((gInventory at: 39) cue:) ; washcloth
				(= cycles 2)
			)
			(11
				(gEgo normalize: 636 1 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fartScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sfx number: 631 loop: 1 play: self)
			)
			(1
				(= ticks 30)
			)
			(2
				(gMessager say: 0 0 28 0 self) ; "Aaaaahhhhhh!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wipeAssScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: changeScore: 1 251)
				(= local3 0)
				(= register 2)
				(gMessager say: 2 62 2 0 self) ; "Good idea."
			)
			(1
				(gEgo
					view: 631
					setLoop: 0
					cel: 0
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(2
				(= ticks (Random 30 60))
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(= ticks (Random 30 60))
			)
			(5
				(gEgo view: 631 setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(sfx number: 637 loop: 1 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(7
				(sfx number: 637 loop: 1 play:)
				(if (-- register)
					(= state 0)
					(gEgo setCycle: Beg self)
				else
					(gEgo setCycle: Beg useToiletScr)
					(ClearFlag 55)
					(self dispose:)
				)
			)
		)
	)
)

(instance afterShabScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (= cycles 2))
			)
			(1
				(sinkWater init:)
				(gCurRoom showControls: 1)
				(gGame controlsVisible: 0 drawControls:)
				(sfxL number: 635 loop: -1 play:)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: CT 8 1 self)
			)
			(3
				(gEgo setCycle: CT 3 -1 self)
			)
			(4
				(gEgo setCycle: CT 12 1 self)
			)
			(5
				(gEgo setCycle: End self)
				(sfxL number: 0 stop:)
				(sfx number: 636 loop: 1 play:)
				(switch (-- register)
					(1
						(gMessager say: 0 0 1 1 self) ; "(SPITTING) Puuuiiitttueee!"
					)
					(0
						(gMessager say: 0 0 1 2 self) ; "YUCK!"
					)
				)
			)
			(6)
			(7
				(gEgo cel: 0)
				(if (not register)
					((ScriptID 1820 31) modeless: 0) ; You
					(= next turnOffWaterScr)
					(self dispose:)
				else
					(= ticks 90)
				)
			)
			(8
				(gEgo setCycle: CT 3 1 self)
			)
			(9
				(sfxL number: 635 loop: -1 play:)
				(= state 1)
				(self cue:)
			)
		)
	)
)

