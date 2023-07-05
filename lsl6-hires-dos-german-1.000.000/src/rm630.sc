;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use n078)
(use fileScr)
(use n082)
(use LarryRoom)
(use Print)
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
	local1 = 3
	local2
	local3
	local4
	local5
	local6 = -1
	[local7 7]
	[local14 7] = [0 2 4 6 8 10 12]
	[local21 7] = [132 120 100 112 97 86 31]
	[local28 28] = [88 85 74 82 78 71 63 1 4 2 8 8 4 -1 1 2 3 2 2 1 -1 -1 52 48 106 56 52 40]
	local56 = -1
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65 = -1
	local66
	local67 = 5
)

(class cObj of Obj
	(properties)
)

(instance rm630 of LarryRoom
	(properties
		noun 7
		picture 630
		horizon 0
	)

	(method (init &tmp [temp0 2])
		(SetFlag 77)
		(if global100
			(= local0 2)
		else
			(= local0 4)
		)
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
					setLoop: 0 1
					setCycle: Fwd
					x: 202
					y: 93
					setPri: 150
					setScript: workOnToiletScr
				)
			else
				(markus setScript: workOnSinkScr)
			)
			(= local57 1)
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
			(= style 9)
			(theDoor init: cel: 0 init: approachVerbs: 4 ignoreActors: 1) ; Do
			(gEgo
				x: (sink approachX:)
				y: (sink approachY:)
				init:
				view: 635
				setLoop: 7 1
				cycleSpeed: 6
				cel: 3
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
				setPri: 70
				actions: egoActions
			)
			(theDoor init: approachVerbs: 4 ignoreActors: 1) ; Do
			(self setScript: enterDoorScr)
		)
		(super init:)
		(if (== gPrevRoomNum 860)
			(gGame drawControls:)
		)
		(gGlobalSound2 number: 0 stop:)
		(if (or (not (== (gGlobalSound1 number:) 620)) (not (gGlobalSound1 handle:)))
			(gGlobalSound1 number: 620 loop: -1 setVol: 100 play:)
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
		(Load rsSCRIPT 1800)
		(Load rsVIEW 635)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				local57
				(not (IsFlag 12))
				(IsFlag 34)
				(== (markus script:) workOnToiletScr)
			)
			(ClearFlag 54)
			(ClearFlag 79)
		)
		(yuckTimer dispose: delete:)
		(fartTimer dispose: delete:)
		(if (!= newRoomNumber 620)
			(gGlobalSound1 fade: 0 10 10 1)
		)
		(gEgo setScaler: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				local66
				(== (gEgo view:) 635)
				(== (gEgo loop:) 5)
				(== (gEgo cel:) 2)
			)
			(jerkSound play:)
			(if (not (-- local67))
				(gEgo cycleSpeed: (Random 1 3))
				(= local67 (Random 5 10))
			)
		)
	)
)

(instance bedView of View
	(properties
		x 179
		y 5
		priority 40
		fixPriority 1
		view 637
		signal 26657
	)
)

(instance gasket of View
	(properties
		x 186
		y 94
		priority 106
		fixPriority 1
		view 630
		loop 5
		signal 26657
	)

	(method (doVerb theVerb)
		(egoActions doVerb: theVerb)
	)
)

(instance egoHead of View
	(properties
		signal 26657
	)

	(method (doVerb theVerb)
		(egoActions doVerb: theVerb)
	)
)

(instance theDoor of Prop
	(properties
		noun 14
		approachX 207
		approachY 65
		x 204
		y 63
		priority 65
		fixPriority 1
		view 630
		cel 5
		signal 26657
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
			(1 ; Look
				(if (and (== (-- local1) 1) local4)
					(sfx number: 1004 loop: 1 play:)
					(yuckTimer setReal: yuckTimer 3)
				else
					(gMessager say: 14 1) ; "This door leads back to your hotel room."
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
		priority 63
		fixPriority 1
		view 630
		loop -1
		signal 26657
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
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 105 0 150 95 90 95 87 99 112 127 112 139 0 139
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance larry of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 190 98 188 91 198 75 189 67 189 60 193 55 202 53 211 55 216 61 216 67 209 77 214 81 212 85 216 80 215 95
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(egoActions doVerb: theVerb)
	)
)

(instance rWindow of Feature
	(properties
		noun 8
	)

	(method (init)
		(self
			setPolygon:
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
			setPolygon:
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
			setPolygon:
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
		noun 9
		sightAngle 10
		x 250
		y 41
	)

	(method (init)
		(self
			setPolygon:
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
			setPolygon:
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
			setPolygon:
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
			setPolygon:
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
			setPolygon:
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
			setPolygon:
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
		noun 13
		sightAngle 10
		x 148
		y 35
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 139 31 149 25 158 37 145 42
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(cond
					(local4
						(gMessager say: 13 4 17) ; "You can't do that now-- you're on the can!"
					)
					((not (-- local0))
						(gEgo get: 38 36 37 19 6 39) ; towel
						(while (== (= temp0 (Random 1 61)) 9)
						)
						(DoAudio audPLAY 611 1 4 temp0 1)
						(Print
							width: 160
							font: gUserFont
							addTitle: {Carlos, are you cheating again?}
							addText: 1 4 temp0 1 50 1 611
							fore: 67
							addText:
								{You now have the towel, toilet cover, toilet paper, hand creme, brochure and the wash cloth.}
								50
								17
							fore: 0
							addIcon: 1592 1 0 0 0
							init:
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

(instance enterDoorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setScaler: Scaler 100 72 69 53)
				(if (and (IsFlag 240) (IsFlag 68))
					(bedView init:)
				)
				(= cycles 2)
			)
			(1
				(if (and (not local57) (IsFlag 50))
					(sinkWater init: ignoreActors: 1)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 72 self)
			)
			(2
				(gEgo setPri: 70)
				(gEgo setHeading: 360 self)
			)
			(3
				(theDoor setCycle: Beg self)
			)
			(4
				(doorFx number: 33 loop: 1 play:)
				(= ticks 90)
			)
			(5
				(if local57
					(gEgo setMotion: MoveTo 205 79 self)
				else
					(gEgo setHeading: 225 self)
				)
			)
			(6
				(if local57
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setMotion: MoveTo 191 87 self)
				)
			)
			(7
				(gEgo setScaler: 0 setHeading: 270 self)
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance runningWaterFx of Sound
	(properties
		flags 5
	)
)

(instance doorFx of Sound
	(properties
		flags 5
	)
)

(instance upperToilet of Feature
	(properties
		noun 12
		sightAngle 10
		approachX 200
		approachY 100
		x 200
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 187 115 187 100 191 94 200 92 209 93 217 95 214 97 215 101 219 103 219 107 223 108 223 111 220 115
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if local4
			(egoActions doVerb: theVerb)
		else
			(switch theVerb
				(4 ; Do
					(cond
						(local57
							(gMessager say: 12 4 7) ; "You can't get to the toilet with this plumber in your way!"
						)
						((and (> local60 1) (not local61) (not (IsFlag 79)))
							(sfx number: 633 loop: 1 play:)
							(= local61 1)
							(SetFlag 79)
							(gMessager say: 12 4 24) ; "Oh, no! The water's rising!"
						)
						((IsFlag 79)
							(sfx number: 633 loop: 1 play: toiletCue)
						)
						(else
							(= local61 1)
							(= local60 0)
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
						(local57
							(gMessager say: 12 61 7) ; "You don't really want to use the toilet while that plumber is here."
						)
						(local4
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
						(local57
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
						(local57
							(gMessager say: 12 6 7) ; "The plumber doesn't care to watch you right now."
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
			setPolygon:
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
			setPolygon:
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
		(if (and (not local66) local4 (== (gCurRoom script:) useToiletScr))
			(cond
				((fartTimer seconds:)
					(fartTimer seconds: 0 dispose: delete:)
					(self setReal: self 3)
				)
				((or (gTalkers size:) (Print dialog:))
					(self setReal: self 3)
				)
				(else
					((gCurRoom script:) setScript: yuckScr)
				)
			)
		)
	)
)

(instance fartTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				local4
				(== (gCurRoom script:) useToiletScr)
				(not local66)
				(!= (gEgo view:) 636)
			)
			(if (or (gTalkers size:) (Print dialog:))
				(self setReal: self 3)
			else
				((gCurRoom script:) setScript: fartScr)
			)
		)
	)
)

(instance crowdScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== register local56)
					(= ticks 10)
				else
					(= cycles 2)
				)
			)
			(1
				(if (== register local56)
					(client
						setMotion:
							MoveTo
							[local21 register]
							[local28 register]
							self
					)
				else
					(client setMotion: MoveTo 66 65 self)
				)
			)
			(2
				(if (== register local56)
					(client cel: 0 setCycle: 0)
					(= ticks 30)
				else
					(client
						setMotion:
							MoveTo
							[local21 register]
							[local28 register]
							self
					)
				)
			)
			(3
				(if (== register local56)
					(= local56 -1)
					(= local6 -1)
					((gEgo script:) cue:)
					(self dispose:)
				else
					(client setLoop: (+ (client loop:) 1) 1 cel: 0 setCycle: 0)
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
				(gEgo view: 635 setLoop: 1 1 cycleSpeed: 8 setCycle: Fwd)
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
				(gEgo normalize: 636 1 1 setPri: 70)
				(gGame handsOn:)
				(self dispose:)
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
				(if (not local62)
					(= local62 1)
					(if (== (markus script:) workOnSinkScr)
						(++ state)
						(gMessager sayRange: 4 2 26 1 8 self) ; "Thanks for coming so fast."
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
				(sfx number: 814 loop: 1 play: self)
				(gEgo put: 37) ; toiletpaper
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
				(gEgo view: 635 setLoop: 5 1 cycleSpeed: 4 cel: 0)
				(gMessager say: 2 54 2 1 self) ; "Well... since nobody's watching... AND you asked..."
			)
			(1
				(= local66 1)
				(gEgo setCycle: Fwd)
				(= ticks 180)
			)
			(2
				(if (< (++ local6) 6)
					(-- state)
				else
					(= local56 local6)
				)
				((= [local7 local6] (Actor new:))
					view: 638
					setLoop: [local14 local6] 1
					x: 0
					y: 62
					setStep: 1 1
					cycleSpeed: 4
					moveSpeed: 4
					ignoreActors: 1
					init:
					setCycle: Fwd
					setScript: (crowdScr new:) 0 local6
				)
				(if (== local6 5)
					(= ticks 300)
				else
					(= ticks 180)
				)
			)
			(3)
			(4
				(= local66 0)
				(sfx number: 141 loop: 1 play:)
				(UpdateScreenItem ((ScriptID 92 3) view: 1905)) ; larryTBust
				(gMessager say: 2 54 2 2 self) ; "How humiliating! A huge crowd of people watching you in your "most personal moment!""
			)
			(5
				(EgoDead 18 self)
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					([local7 temp1] dispose:)
					(= [local7 temp1] 0)
				)
			)
			(6
				(UpdateScreenItem ((ScriptID 92 3) view: 1900 loop: 1)) ; larryTBust
				((gCurRoom script:) dispose:)
				(egoHead dispose:)
				(gasket dispose:)
				(gEgo normalize: 636 2 1 setPri: 70)
				(= local4 0)
				(= local58 0)
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
		noun 4
		approachX 200
		approachY 85
		x 195
		y 100
		priority 100
		view 632
		signal 26657
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
			(6 ; Zipper
				(gCurRoom setScript: zipperOnMarkScr)
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
			(local4
				(switch theVerb
					(54 ; brochure
						(if (and local4 (not local58))
							(gEgo view: 635 setLoop: 5 1 cel: 0)
							(gMessager say: 2 54 20) ; "Suddenly, you are happy you decided to pause to study the brochure."
							(= local58 1)
							(return 1)
						else
							(super doVerb: theVerb)
						)
					)
					(59 ; handcreme
						(cond
							((and local4 (not local58))
								(gMessager say: 2 59 19) ; "Since no one's looking, you might try that here... since you're all alone."
								(return 1)
							)
							((and local4 local58)
								(gEgo setScript: jerkOffScr)
								(return 1)
							)
							(else
								(super doVerb: theVerb)
							)
						)
					)
					(62 ; toiletpaper
						(if local4
							(gEgo setScript: wipeAssScr)
							(return 1)
						else
							(super doVerb: theVerb)
						)
					)
					(else
						(gEgo doVerb: theVerb)
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

(instance sink of Feature
	(properties
		noun 10
		sightAngle 0
		approachX 182
		approachY 83
		x 151
		y 74
	)

	(method (init)
		(self
			setPolygon:
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
					((not local2)
						(= local2 1)
						(gMessager say: 10 1 11) ; "(Hey, I just thought of something. Remember back in Lost Wages? In Lefty's Bar? In his bathroom? Remember when I found that diamond ring lying on the sink? Remember that?)"
					)
					(else
						(gMessager say: 10 1 12) ; "This sink has a brown stain in the bottom."
					)
				)
			)
			(4 ; Do
				(cond
					(local57
						(if (== (markus script:) workOnSinkScr)
							(gMessager say: 10 4 7) ; "You can't wash your hands when the plumber's working under the sink."
						else
							(gMessager say: 10 4 27) ; "Wait until Mark's finished."
						)
					)
					(local4
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
					(local4
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
				(if local57
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
				(if local5
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
				(gEgo view: 635 setLoop: 1 1 setCycle: Fwd cycleSpeed: 6)
				(= ticks 300)
			)
			(4
				(gEgo setLoop: 2 1 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(if register
					(gEgo setLoop: 3 1 setCycle: Fwd)
					(= ticks 300)
				else
					(self cue:)
				)
			)
			(7
				(gEgo setLoop: 2 1 setCel: 255)
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
				(gEgo normalize: 636 1 1 setPri: 70)
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
				(= ticks 30)
			)
			(1
				(sfx number: 631 loop: 1 play:)
				(= ticks 90)
			)
			(2
				(gMessager say: 0 0 28 0 self) ; "Aaaaahhhhhh!"
			)
			(3
				(gGame handsOn:)
				(yuckTimer setReal: yuckTimer 10)
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
				(= local4 0)
				(= register 2)
				(gMessager say: 2 62 2 0 self) ; "Good idea."
			)
			(1
				(gEgo
					view: 631
					setLoop: 0 1
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
				(gEgo view: 631 setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(6
				(sfx number: 637 loop: 1 play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(7
				(sfx number: 637 loop: 1 play:)
				(cond
					((-- register)
						(= state 0)
						(gEgo setCycle: Beg self)
					)
					((not (Random 0 2))
						(gMessager say: 6 4 0 2 self 620) ; "Yuck. What's this stuff on my hand?!"
					)
					(else
						(self cue:)
					)
				)
			)
			(8
				(gEgo setCycle: Beg useToiletScr)
				(ClearFlag 55)
				(self dispose:)
			)
		)
	)
)

(instance afterShabScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UpdateScreenItem ((ScriptID 92 3) view: 1906)) ; larryTBust
				(= register (= cycles 2))
			)
			(1
				(sinkWater init: ignoreActors: 1)
				(gCurRoom showControls: 1)
				(gGame controlsVisible: 0 drawControls:)
				(gargleSound number: 635 loop: -1 play:)
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
				(gargleSound number: 0 stop:)
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
					(UpdateScreenItem ((ScriptID 92 3) view: 1900 loop: 1)) ; larryTBust
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
				(gargleSound number: 635 loop: -1 play:)
				(= state 1)
				(self cue:)
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
				(++ local60)
				(if (> (++ local5) 3)
					(gMessager say: 0 0 18 0 self) ; "Perhaps you should stop before you get hemorrhoids!"
				else
					(= local61 0)
					(gMessager say: 12 61 16 0 self) ; "Good idea. You bend over the pot and carefully install an "ass gasket.""
				)
			)
			(1
				(if (> local5 3)
					(gGame handsOn:)
					(self dispose:)
				else
					(proc79_11 814)
					(SetFlag 55)
					(ClearFlag 106)
					(ClearFlag 107)
					(ClearFlag 108)
					(ClearFlag 109)
					(= local4 1)
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
					setLoop: 0 1
					cel: 0
					setCycle: 0
					cycleSpeed: 8
					x: 202
					y: 101
					setCycle: CT 2 1 self
				)
			)
			(4
				(gEgo setPri: 150 setCycle: CT 4 1 self)
			)
			(5
				(gEgo cel: 5)
				(sfx number: 814 loop: 1 play: self)
				(egoHead
					view: 635
					setLoop: 4 1
					cel: 1
					x: 198
					y: 140
					ignoreActors: 1
					init:
				)
			)
			(6
				(sfx number: 0 dispose:)
				(proc79_12 814)
				(larry init:)
				(egoHead cel: 2)
				(gGame handsOn:)
				(fartTimer setReal: fartTimer 12)
				((ScriptID 0 11) init: self) ; iconExit
			)
			(7
				((ScriptID 0 11) dispose:) ; iconExit
				(gGame handsOff:)
				(gEgo view: 635 setLoop: 0 1 setCycle: 0 cel: 4)
				(egoHead cel: 1)
				(= cycles 2)
			)
			(8
				(gasket dispose:)
				(egoHead cel: 0)
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo normalize: 636 3 1 setPri: 70)
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
				(= local4 0)
				(= local58 0)
				(theDoor approachVerbs: 4) ; Do
				(sink approachVerbs: 4 35 57) ; Do, washcloth, soap
				(egoHead dispose:)
				(larry dispose:)
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
				(= local59 1)
				(if
					(and
						(!= (gEgo x:) (sink approachX:))
						(!= (gEgo y:) (sink approachY:))
					)
					(gEgo
						setMotion:
							PolyPath
							(sink approachX:)
							(sink approachY:)
							self
					)
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
					setLoop: 6 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(4
				(gEgo cel: 5)
				(= ticks 20)
			)
			(5
				(gEgo cel: 4)
				(sfx number: 355 loop: 1 play:)
				(= ticks 20)
			)
			(6
				(gEgo cel: 5)
				(= ticks 20)
			)
			(7
				(gEgo cel: 4)
				(sfx number: 355 loop: 1 play: self)
			)
			(8
				(runningWaterFx stop:)
				(ClearFlag 50)
				(if (gCast contains: sinkWater)
					(sinkWater dispose:)
				)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo normalize: 636 1 1 setPri: 70)
				(= local59 0)
				(= ticks 60)
			)
			(10
				(= cycles 2)
				(if (and (not local63) (== gPrevRoomNum 860))
					(= local63 1)
					(proc78_0)
				)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
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
				(= local59 1)
				(gEgo
					setMotion: PolyPath (sink approachX:) (sink approachY:) self
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
					setLoop: 6 1
					cel: 0
					cycleSpeed: 6
					setCycle: CT 3 1 self
				)
			)
			(4
				(gEgo cel: 4)
				(= ticks 30)
			)
			(5
				(gEgo cel: 5)
				(sfx number: 355 loop: 1 play:)
				(= ticks 20)
			)
			(6
				(SetFlag 50)
				(sinkWater init:)
				(= ticks 20)
			)
			(7
				(gEgo cel: 4)
				(= ticks 30)
			)
			(8
				(gEgo cel: 5)
				(sfx number: 355 loop: 1 play:)
				(= ticks 30)
			)
			(9
				(if (not (IsFlag 12))
					(gMessager say: 10 1 14 0 self) ; "Yuck! The water coming out of the sink is brown!"
				else
					(= cycles 2)
				)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gEgo normalize: 636 1 1 setPri: 70)
				(SetFlag 19)
				(= local59 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gargleSound of Sound
	(properties)
)

(instance sfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance jerkSound of Sound
	(properties
		number 632
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
				(if (and (IsFlag 240) (IsFlag 68))
					(bedView init:)
				)
				(= cycles 2)
			)
			(3
				(doorFx number: 32 loop: 1 play:)
				(theDoor setCycle: End self)
			)
			(4
				(gGlobalSound1 fade: 127 10 10 0)
				(gEgo
					setScaler: Scaler 100 72 69 53
					setMotion: MoveTo 205 58 self
				)
			)
			(5
				(gCurRoom newRoom: 620)
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
				(++ local64)
				(if (!= (gEgo heading:) 180)
					(gEgo setHeading: 180 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if (== local64 1)
					(gMessager say: 12 6 0 0 self) ; "Finally. The RIGHT place!"
				else
					(self cue:)
				)
			)
			(3
				(gEgo
					view: 634
					setLoop: 0 1
					cycleSpeed: 8
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(sfx number: 35 loop: 1 play: self)
				(gEgo setCycle: End self)
			)
			(5)
			(6
				(switch local64
					(1
						(sfx2 number: 30 loop: -1 play:)
						(= ticks 200)
						(gEgo
							setPri: 110
							setLoop: 1 1
							cycleSpeed: 4
							setCycle: Fwd
						)
						(= register 3)
					)
					(2
						(= ticks 30)
						(= register 2)
					)
					(else
						(= state 8)
						(= ticks 90)
					)
				)
			)
			(7
				(sfx2 number: 0 stop:)
				(gEgo setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(8
				(if (-- register)
					(-= state 2)
				)
				(sfx number: 351 loop: 1 play: self)
			)
			(9
				(if (>= local64 3)
					(gMessager say: 12 6 25 0 self) ; "(Guess I didn't have to go!)"
				else
					(self cue:)
				)
			)
			(10
				(gEgo
					setLoop: 0 1
					setCycle: 0
					cel: 10
					cycleSpeed: 8
					setCycle: CT 3 -1 self
				)
			)
			(11
				(gEgo setCycle: Beg self)
				(sfx number: 35 loop: 1 play:)
			)
			(12
				(gGame changeScore: 2 252 handsOn:)
				(gEgo normalize: 636 2 1 setPri: 70)
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
				(proc79_11 631 30)
				(= ticks 30)
			)
			(1
				(sfx number: 631 loop: 1 play:)
				(= ticks 60)
			)
			(2
				(sfx2 number: 30 loop: -1 play:)
				(= ticks 120)
			)
			(3
				(sfx2 number: 0 stop:)
				(gMessager say: 0 0 28 0 self) ; "Aaaaahhhhhh!"
			)
			(4
				(sfx number: 0 dispose:)
				(sfx2 number: 0 dispose:)
				(proc79_12 631 30)
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
				(markus setLoop: 1 1 setCycle: 0 cel: 0)
				(= ticks 30)
			)
			(2
				(markus setCycle: End self)
			)
			(3
				(markus setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(4
				(sfx number: 814 loop: 1 play:)
				(= ticks 180)
			)
			(5
				(switch (Random 0 5)
					(1
						(sfx number: 631 loop: 1 play:)
						(= ticks 60)
					)
					(2
						(sfx number: 516 loop: 1 play:)
						(= ticks 60)
					)
					(else
						(self cue:)
					)
				)
			)
			(6
				(markus setLoop: 3 1 cel: 0 setCycle: End self)
			)
			(7
				(markus setLoop: 0 1 setCycle: Fwd)
				(self init:)
			)
		)
	)
)

(instance zipperOnMarkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 198 85 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo
					view: 634
					setLoop: 3 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(4
				(sfx2 number: 35 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gMessager say: 4 6 0 0 self) ; "Let me guess? Just in from San Francisco?"
			)
			(6
				(gEgo setCycle: CT 2 -1 self)
			)
			(7
				(sfx2 number: 35 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo normalize: 636 2 1 setPri: 70)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance workOnSinkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(markus setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(1
				(if (gCast contains: sinkWater)
					(markus setLoop: 3 1 cel: 0 setCycle: End self)
				else
					(= state 5)
					(= ticks (Random 30 120))
				)
				(= register (Random 2 5))
			)
			(2
				(if (gCast contains: sinkWater)
					(sinkWater dispose:)
				)
				(= cycles 2)
			)
			(3
				(markus setLoop: 4 1 cycleSpeed: 6 cel: 0 setCycle: End self)
				(if (not (or (gTalkers size:) (Print dialog:)))
					(sfx number: 355 loop: 1 play:)
				)
				(if (-- register)
					(= state 1)
				)
			)
			(4
				(markus setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(5
				(= ticks (Random 30 120))
			)
			(6
				(markus setLoop: 1 1 cel: 0 setCycle: End self)
			)
			(7
				(markus setLoop: 2 1 cel: 0)
				(= cycles 2)
			)
			(8
				(= register (Random 3 5))
				(= ticks (Random 30 120))
			)
			(9
				(= ticks (Random 10 30))
			)
			(10
				(markus
					setLoop: 2 1
					cel: 0
					cycleSpeed: (Random 6 10)
					setCycle: End self
				)
				(if (not (or (gTalkers size:) (Print dialog:)))
					(sfx number: 404 loop: 1 play:)
				)
				(if (-- register)
					(-= state 2)
				)
			)
			(11
				(markus cel: 1 setCycle: Beg self)
			)
			(12
				(= seconds (Random 2 4))
			)
			(13
				(markus setLoop: 3 1 cel: 0 setCycle: End self)
			)
			(14
				(if
					(and
						(not (gCast contains: sinkWater))
						(> (Random 1 100) 30)
					)
					(sinkWater setLoop: 1 init:)
				)
				(= ticks 60)
				(= register (Random 2 5))
			)
			(15
				(= cycles 2)
			)
			(16
				(markus setLoop: 4 1 cycleSpeed: 6 cel: 0 setCycle: End self)
				(if (not (or (gTalkers size:) (Print dialog:)))
					(sfx number: 355 loop: 1 play:)
				)
			)
			(17
				(if (-- register)
					(= state 14)
				)
				(if (gCast contains: sinkWater)
					(if (> (Random 1 100) 50)
						(sinkWater setLoop: 2 1)
					else
						(sinkWater setLoop: 1 1)
					)
				)
				(= ticks (Random 10 30))
			)
			(18
				(markus setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(19
				(= ticks (Random 30 90))
				(= register 0)
			)
			(20
				(if (> (Random 1 100) 60)
					(markus setLoop: 6 1 cel: 0 setCycle: CT 4 1 self)
					(= register 1)
				else
					(= state 23)
					(= cycles 2)
				)
				(if (and (gCast contains: sinkWater) (== (sinkWater loop:) 2))
					(sinkWater setLoop: 1)
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
				(= local65 (Random 0 4))
				(cond
					(
						(and
							(not register)
							(== local65 1)
							(not (or (gTalkers size:) (Print dialog:)))
						)
						(sfx number: 631 loop: 1 play:)
						(= ticks 180)
					)
					(
						(and
							(not register)
							(== local65 2)
							(not (or (gTalkers size:) (Print dialog:)))
						)
						(sfx number: 516 loop: 1 play:)
						(= ticks 180)
					)
					(else
						(self init:)
					)
				)
			)
			(26
				(self init:)
			)
		)
	)
)

