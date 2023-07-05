;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use TellerIcon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	local0 = 2
	local1 = 2
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm540 of Room
	(properties
		picture 540
	)

	(method (doRemap)
		(gGame doRemap: 2 243 85)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(gGame intensity: 100)
		(gGame handsOff:)
		(cond
			((OneOf gPrevRoomNum 545 560 540)
				(gGlobalSound0 fade: 127 4 2 0)
			)
			((!= gPrevRoomNum 535)
				(gGlobalSound0 number: 983 setLoop: -1 setVol: 127 play:)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 20 100 84 103 98 108 134 129 168 151 221 143 212 141 179 144 153 128 165 128 163 126 136 126 87 98 72 98 66 95 27 95 27 79 20 79
					yourself:
				)
		)
		(computer init: approachVerbs: 4) ; Do
		(door init: approachVerbs: 4 16) ; Do, stick
		(int init:)
		(homicideBanner init:)
		(statusBoard init:)
		(extinguisher init:)
		(crimeBooks init:)
		(messageBoard init:)
		(calendar init:)
		(boarHead init:)
		(fileCabinets init:)
		(otherDesk1 init:)
		(otherDesk2 init:)
		(self setScript: sEnter)
		(newDetective init: setScript: phoneTalk)
		(hal init: approachVerbs: 67) ; actionReports
		(gEgo sightAngle: 70)
		(chair init: approachVerbs: 4) ; Do
		(desk init: approachVerbs: 4 1) ; Do, Look
		(window2 init:)
		(rightDesks init:)
		(windows1 init:)
		(exitSign init:)
		(if (== gDay 5)
			(if (== global151 4)
				(= global151 1)
			else
				(++ global151)
			)
		)
		(super init: &rest)
		(if (IsHiRes)
			(hiResBanner init:)
		)
	)

	(method (doit)
		(super doit:)
		(if (<= (gEgo y:) 85)
			(gCurRoom newRoom: 535)
		)
	)

	(method (dispose)
		(sfx dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (gGame script:) (!= newRoomNumber 560))
			(gGame setScript: 0)
		)
		(if (and (== global124 1) (== newRoomNumber 535))
			(= global124 0)
		)
		(if (!= newRoomNumber 535)
			(gGlobalSound0 fade: 90 10 10 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance exitSign of Feature
	(properties
		noun 30
		nsLeft 12
		nsTop 30
		nsRight 35
		nsBottom 38
		sightAngle 40
		approachX 23
		approachY 34
		approachDist 0
		x 23
		y 34
	)
)

(instance windows1 of Feature
	(properties
		noun 29
		nsLeft 203
		nsTop 50
		nsRight 209
		nsBottom 54
		sightAngle 40
		approachX 206
		approachY 52
		approachDist 0
		x 206
		y 52
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 168 33 260 20 260 55 250 55 250 50 222 51 222 65 213 66 213 59 206 59 205 60 201 60 199 66 173 65 173 69 168 69
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightDesks of Feature
	(properties
		noun 28
		nsLeft 276
		nsTop 104
		nsRight 287
		nsBottom 111
		sightAngle 40
		approachX 281
		approachY 107
		approachDist 0
		x 281
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 195 92 319 119 319 134 307 131 306 152 278 152 278 142 272 137 263 136 263 116 246 120 246 112 240 106 230 104 227 107 230 128 229 133 237 136 238 143 208 130 208 105 192 105 187 96 178 95
					yourself:
				)
		)
		(super init:)
	)
)

(instance window2 of Feature
	(properties
		noun 29
		nsLeft 293
		nsTop 102
		nsRight 300
		nsBottom 106
		sightAngle 40
		approachX 296
		approachY 104
		approachDist 0
		x 296
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 294 16 319 12 319 38 293 39
					yourself:
				)
		)
		(super init:)
	)
)

(instance chair of Feature
	(properties
		noun 26
		nsLeft 127
		nsTop 81
		nsRight 161
		nsBottom 118
		sightAngle 40
		approachX 163
		approachY 118
		approachDist 0
		x 165
		y 120
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PContainedAccess
				init: 129 82 129 93 133 106 150 109 162 105 161 101 157 101 156 96 142 96 139 88 137 81
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (== (gEgo view:) 9057))
					(gEgo setScript: sitDown)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance desk of Feature
	(properties
		noun 27
		nsLeft 127
		nsTop 81
		nsRight 161
		nsBottom 118
		sightAngle 40
		approachX 163
		approachY 118
		approachDist 0
		x 144
		y 99
	)

	(method (init)
		(super init:)
		(= onMeCheck
			((Polygon new:)
				type: PContainedAccess
				init: 157 113 168 110 176 111 175 95 195 92 178 88 150 90 150 95 158 99
				yourself:
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCast contains: garcia) 0)
					((& (gEgo signal:) $0800)
						(gCurRoom setScript: toDesk)
					)
					(else
						(gEgo setScript: sitDown 0 1)
					)
				)
			)
			(1 ; Look
				(cond
					((gCast contains: garcia) 0)
					((& (gEgo signal:) $0800)
						(gCurRoom setScript: toDesk)
					)
					(else
						(gEgo setScript: sitDown 0 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hal of Prop
	(properties
		sightAngle 90
		approachX 193
		approachY 138
		x 246
		y 142
		z 40
		priority 130
		fixPriority 1
		view 541
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(73 ; crimeSceneReport
				(cond
					((& (gEgo signal:) $0800)
						(gMessager say: 2 0 27) ; "You'll need to stand up and move to accomplish that!"
					)
					((== script yak)
						(gMessager say: 2 0 37) ; "Hal's busy on the telephone. Get back to him later."
					)
					(else
						(= local3 73)
						(self setScript: takeForms)
					)
				)
			)
			(67 ; actionReports
				(cond
					((& (gEgo signal:) $0800)
						(gMessager say: 2 0 27) ; "You'll need to stand up and move to accomplish that!"
					)
					((== script yak)
						(gMessager say: 2 0 37) ; "Hal's busy on the telephone. Get back to him later."
					)
					(else
						(= local3 67)
						(self setScript: takeForms)
					)
				)
			)
			(2 ; Talk
				(cond
					((== script yak)
						(= temp0 noun)
						(= noun 2)
						(super doVerb: theVerb)
						(= noun temp0)
					)
					((== gDay 5)
						(switch global151
							(1
								(self setScript: halTalks 0 2 2 29)
							)
							(2
								(self setScript: halTalks 0 2 2 32)
							)
							(3
								(self setScript: halTalks 0 2 2 34)
							)
							(4
								(self setScript: halTalks 0 2 2 36)
							)
						)
					)
					(else
						(= temp0 noun)
						(= noun 2)
						(super doVerb: theVerb)
						(= noun temp0)
					)
				)
			)
			(else
				(= temp0 noun)
				(= noun 2)
				(super doVerb: theVerb)
				(= noun temp0)
			)
		)
	)
)

(instance halTell of Teller
	(properties)

	(method (sayMessage)
		(if (== iconValue 25)
			(gPqFlags set: 24 15)
		)
		(hal setScript: halTalks 0 sayNoun verb iconValue)
		(return 1)
	)
)

(instance computer of Feature
	(properties
		noun 16
		nsLeft 74
		nsTop 71
		nsRight 96
		nsBottom 83
		sightAngle 40
		approachX 92
		approachY 98
		approachDist 0
		x 85
		y 77
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (& (gEgo signal:) $0800)
					(super doVerb: theVerb)
				else
					(gCurRoom setInset: (ScriptID 19)) ; compute
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance int of View
	(properties
		noun 1
		sightAngle 40
		approachX 50
		approachY 94
		x 42
		y 90
		fixPriority 1
		view 544
		loop 1
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		noun 1
		sightAngle 40
		approachX 50
		approachY 94
		x 42
		y 90
		view 544
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; stick
				(if (& (gEgo signal:) $0800)
					(super doVerb: 4)
				else
					(gCurRoom setScript: thruDoorScr 0 self)
				)
			)
			(4 ; Do
				(if (& (gEgo signal:) $0800)
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: thruDoorScr)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance halWrite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hal view: 541 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(hal view: 541 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(if (Random 0 1)
					(hal loop: 1 cel: 0)
				)
				(= ticks (Random 30 120))
				(= state 0)
			)
		)
	)
)

(instance phoneTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(newDetective setCycle: End self)
			)
			(1
				(= ticks (Random 60 180))
			)
			(2
				(newDetective cel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance knockSnd of Sound
	(properties
		number 980
	)
)

(instance thruDoorScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(OneOf state 0 2)
				(OneOf (gEgo cel:) 5 8)
				(not register)
			)
			(knockSnd play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((= local8 (View new:))
					view: 9008
					loop: 1
					cel: 0
					scaleSignal: 1
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					x: (gEgo x:)
					y: (gEgo y:)
					init:
				)
				(gEgo view: 9008 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(if register
					(gMessager say: 1 16 0 1 self) ; "Rat-a-tat-tat..."
				else
					(self cue:)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= ticks 80)
			)
			(4
				(if
					(and
						(== gDay 5)
						(gPqFlags test: 158)
						(== gPrevRoomNum 535)
					)
					(gEgo normalize: 0 2)
					(local8 dispose:)
					(= register 1)
					(gMessager say: 1 4 38 0 self) ; "No one answers. The Lieutenant must be out of his office."
				else
					(= register 0)
					(gMessager sayRandom: 1 4 1 self)
				)
			)
			(5
				(if register
					(gGame handsOn:)
					(self dispose:)
				else
					(gCurRoom newRoom: 545)
				)
			)
		)
	)
)

(instance takeForms of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hal setCycle: End self)
				(if (= temp0 ((gEgo looper:) oldMover:))
					(temp0 dispose:)
				)
				(if (or (< (gEgo heading:) 45) (> (gEgo heading:) 75))
					(gEgo setHeading: 60)
				)
			)
			(1
				(hal loop: 0)
				(hal cel: (hal lastCel:) setCycle: Beg self)
			)
			(2
				(gEgo view: 9033 loop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(3
				(cond
					((== local3 73)
						(gMessager say: 2 73 0 1 self) ; "Hal, here's the Hickman Crime Scene log. It was prepared by Officer Woodbury from the 77th."
					)
					(
						(and
							(& (= temp0 ((gInventory at: 44) value:)) $0002) ; actionReports
							(not (& temp0 $fffd))
						)
						(gMessager say: 3 67 16 1 self) ; "Here you go, Hal, my follow-up report on last night's events."
					)
					(else
						(gMessager say: 2 67 0 1 self) ; "Here you go, Hal."
					)
				)
				(hal view: 543 loop: 0 cel: 0 setCycle: End)
			)
			(4
				(if (== local3 67)
					(if
						(and
							(& (= temp0 ((gInventory at: 44) value:)) $0002) ; actionReports
							(not (& temp0 $fffd))
						)
						(gMessager say: 3 67 16 2) ; "Thanks, kid. Keep 'em coming!"
					else
						(gMessager say: 2 67 0 2) ; "Sure, Junior."
					)
				)
				(gEgo setCycle: Beg)
				(hal loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(cond
					((== local3 73)
						(gMessager say: 2 73 0 2) ; "You're damn lucky ya got me takin' care of this book, Junior, damn lucky."
						(= register 1)
						(hal view: 542 loop: 0 cel: 0 setCycle: End self)
						(gGame points: 2)
						(gEgo put: 47) ; crimeSceneReport
					)
					(((gInventory at: 44) state:) ; actionReports
						(= register 1)
						(hal view: 542 loop: 0 cel: 0 setCycle: End self)
						(gGame points: 2)
						(gEgo put: 44) ; actionReports
					)
					(else
						(= register 0)
						(= ticks 60)
					)
				)
			)
			(6
				(if register
					(hal loop: 1 cel: 0 setCycle: End self)
				else
					(hal setCycle: Beg self)
				)
			)
			(7
				(if register
					(gEgo normalize: 0 0)
					(hal setScript: halWrite)
					(gGame handsOn:)
				else
					(gEgo setCycle: CT 6 1 self)
				)
			)
			(8
				(gMessager say: 2 2 8 0 self) ; "Look, Junior, I'm not gonna do all of the paperwork around here. Fill out the damn report and then give it to me!"
			)
			(9
				(hal loop: 0)
				(hal cel: (hal lastCel:) setCycle: Beg self)
				(gEgo setCycle: Beg self)
			)
			(10)
			(11
				(gEgo normalize: 0 0)
				(hal setScript: halWrite)
				(gGame handsOn:)
			)
		)
	)
)

(instance ringer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfx number: 937 setLoop: 1 play: self)
			)
			(1
				(= state -1)
				(= ticks 200)
			)
		)
	)

	(method (dispose)
		(sfx stop:)
		(super dispose:)
	)
)

(instance phoneCall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: ringer)
				(= ticks 300)
			)
			(1
				(hal loop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(2
				(self setScript: 0)
				(hal setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(hal loop: 3 cel: 0 setScript: yak)
			)
		)
	)
)

(instance firstEntranceDay2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 163 118 self)
			)
			(1
				(gEgo setScript: sitDown self)
			)
			(2
				(hal setScript: halTalks self 2 2 7 noun: 3)
				(halTell init: hal 540 4 5)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance yak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (hal cel:)
					(hal setCycle: Beg self)
				else
					(hal setCycle: End self)
				)
			)
			(1
				(= ticks (Random 30 120))
				(= state -1)
			)
		)
	)
)

(instance garcia of Actor
	(properties
		noun 7
		x 56
		y 90
		priority 80
		fixPriority 1
		view 5400
		origStep 1282
	)

	(method (init)
		(|= signal $5800)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(garciaEncounter cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance garciaCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 2 13 0 self) ; "Yes, I'm Detective John Carey. Let me extend my sincere sympathy for your loss, Mrs. Garcia. I didn't know Rene personally, but I..."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance garciaEncounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(gWalkHandler addToFront: self)
				(gPqFlags set: 35)
				(= cycles 10)
			)
			(1
				1
				(gMessager say: 2 2 14 0 self) ; "Whew... that girlfriend of Walker's is something else! Tough for being so petite!"
			)
			(2
				2
				(garcia init: setCycle: Walk setScaler: Scaler 100 53 130 92)
				(door setCycle: End self)
			)
			(3
				3
				(garcia fixPriority: 0 setMotion: MoveTo 127 132 self)
				(= ticks 50)
			)
			(4
				4
				(door setCycle: Beg)
			)
			(5
				5
				(garcia view: 5407 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				6
				(garcia view: 5404 loop: 0 cel: 0)
				(= cycles 5)
			)
			(7
				7
				(if register
					(gMessager say: 7 2 27 0 self) ; "I am talking to YOU! Have you no respect for a grieving mother!"
				else
					(gMessager say: 7 2 12 0 self) ; "I am Rosa Garcia. Are you the detective investigating my son's death?"
					(= register 1)
				)
			)
			(8
				8
				(gGame handsOn:)
				(= seconds 5)
			)
			(9
				9
				(if seconds
					(++ state)
					(= seconds 0)
					(self setScript: garciaCartoon self)
				else
					(gGame handsOff:)
					(garcia view: 5404 loop: 0 cel: 0 setCycle: End self)
				)
			)
			(10
				10
				(garcia loop: 1 cel: 0 setCycle: End self)
				(-= state 4)
			)
			(11
				11
				(= register 0)
				(garcia view: 5401 loop: 0 cel: 0 setCycle: End self)
			)
			(12
				12
				(garcia loop: 1 cel: 0 setCycle: End self)
			)
			(13
				13
				(garcia
					view: 5402
					loop: 0
					cel: 0
					setCycle: Walk
					setMotion: MoveTo 75 105 self
				)
				(if local5
					(gEgo setHeading: 120)
				)
			)
			(14
				(garcia view: 5403 loop: 0 cel: 0 setMotion: MoveTo 37 96 self)
				(if local5
					(= local5 0)
					(gEgo setScript: sitDown)
				)
			)
			(15
				15
				(gGame handsOn:)
				(gMessager say: 2 2 15) ; "I see what you mean, Hal."
				(garcia dispose:)
				(if (gEgo script:)
					(self dispose:)
				else
					(= register 1)
				)
			)
			(16
				16
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (gEgo mover:)
			(gEgo setMotion: 0)
		)
		(if (& (event type:) evMOVE)
			(if (not local5)
				(= local5 1)
				(self setScript: standUp (if register self else 0))
			)
			(event claimed: 1)
			(return)
		else
			(event claimed: 0)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance garciaDay4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gWalkHandler addToFront: self)
				(= cycles 10)
			)
			(1
				(gMessager say: 2 2 23 0 self) ; "What a morning I've had. First the Mayor and the City Council, and then Walker. Geez... the feds are talking to Walker right now. Apparently he's a real special case."
			)
			(2
				(hal noun: 19)
				(halTell init: hal 540 20 5)
				(gGame handsOn:)
			)
			(3
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(self setScript: standUp self)
			(event claimed: 1)
			(return)
		else
			(event claimed: 0)
			(return)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance goSeeBlock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hal setScript: halTalks self 2 2 2)
			)
			(1
				(= state -1)
				(= seconds (Random 10 20))
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 43) ; parkerID
				(cond
					((== gPrevRoomNum 535)
						(gEgo
							x: 51
							y: 95
							setHeading: 180
							normalize: 0 2
							setScaler: Scaler 110 51 165 93
							init:
						)
					)
					((or (== gPrevRoomNum 560) (== gPrevRoomNum 885) (== gPrevRoomNum 390))
						(gPqFlags set: 1)
						(gEgo x: 163 y: 126 view: 9057 setLoop: 0 1)
						(gEgo
							cel: (gEgo lastCel:)
							heading: 90
							setScaler: Scaler 110 51 165 93
							init:
						)
					)
					(else
						(gEgo
							x: 51
							y: 95
							setHeading: 180
							normalize: 0 2
							setScaler: Scaler 110 51 165 93
							init:
						)
					)
				)
				(cond
					((and (== gDay 2) (not (gPqFlags test: 112)))
						(gPqFlags set: 112)
						(hal setScript: halWrite)
						(client setScript: firstEntranceDay2)
						(return)
					)
					((and (== gDay 3) (not (gPqFlags test: 113)))
						(gPqFlags set: 113)
						(client setScript: firstEntranceDay3)
						(return)
					)
					(
						(and
							(== gDay 3)
							(not (gPqFlags test: 37))
							(!= gPrevRoomNum 885)
						)
						(hal view: 541 loop: 3 cel: 0 setScript: yak noun: 2)
						(if (== gPrevRoomNum 560)
							(client setScript: standUp)
							(return)
						else
							(gGame handsOn:)
							(gEgo setMotion: PolyPath 88 102)
						)
						(return)
					)
					((== gPrevRoomNum 390)
						(hal setScript: halWrite)
						(client setScript: garciaDay4)
						(return)
					)
					((== gPrevRoomNum 885)
						(client setScript: garciaEncounter)
						(return)
					)
					(else
						(switch gDay
							(2
								(hal noun: 5 setScript: halWrite)
								(halTell init: hal 540 6 5)
								(cond
									(
										(and
											(gPqFlags test: 36)
											(== gPrevRoomNum 535)
											(gPqFlags test: 32)
										)
										(gGame handsOn:)
										(client setScript: goSeeBlock)
										(return)
									)
									(
										(and
											(== gDay 2)
											(gPqFlags test: 25)
											(gPqFlags test: 30)
											(gPqFlags test: 45)
											(gPqPointFlags test: 9)
											((gInventory at: 4) owner:) ; hickmanStuff
											((gInventory at: 40) owner:) ; washStuff
											(== ((gInventory at: 1) owner:) 515) ; ammoBaggie
											(or
												(== gPrevRoomNum 535)
												(== gPrevRoomNum 545)
											)
										)
										(gGame setScript: (ScriptID 541 0)) ; phoneCall
									)
								)
							)
							(4
								(hal noun: 19 setScript: halWrite)
								(halTell init: hal 540 20 5)
							)
							(5
								(hal setScript: halWrite)
								(if (== gPrevRoomNum 535)
									(switch global151
										(1
											(gMessager say: 2 2 30) ; "How ya doin', kid?"
										)
										(2
											(gMessager say: 2 2 31) ; "Hey there, Junior. How goes the war?"
										)
										(3
											(gMessager say: 2 2 33) ; "Well, if it ain't the Boy Wonder!"
										)
										(4
											(gMessager say: 2 2 35) ; "Welcome back, Junior! Find our killer yet?"
										)
									)
								)
							)
							(else
								(hal setScript: halWrite)
							)
						)
						(if (== gPrevRoomNum 560)
							(client setScript: standUp)
							(return)
						else
							(gEgo setMotion: PolyPath 88 102)
							(gGame handsOn:)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance toDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 27 1 0 0 self) ; "It's your very own desk."
			)
			(2
				(gCurRoom newRoom: 560)
			)
		)
	)
)

(instance newDetective of Prop
	(properties
		noun 14
		x 149
		y 139
		priority 160
		fixPriority 1
		view 540
	)

	(method (init)
		(|= signal $5000)
		(super init: &rest)
	)
)

(instance homicideBanner of Feature
	(properties
		noun 18
		nsLeft 84
		nsTop 31
		nsRight 145
		nsBottom 51
		x 114
		y 41
	)
)

(instance statusBoard of Feature
	(properties
		noun 22
		nsLeft 77
		nsTop 54
		nsRight 94
		nsBottom 70
		x 85
		y 62
	)
)

(instance extinguisher of Feature
	(properties
		noun 23
		nsLeft 63
		nsTop 67
		nsRight 68
		nsBottom 77
		x 65
		y 72
	)
)

(instance crimeBooks of Feature
	(properties
		noun 25
		nsLeft 281
		nsTop 40
		nsRight 319
		nsBottom 66
		x 300
		y 53
	)
)

(instance messageBoard of Feature
	(properties
		noun 21
		nsLeft 75
		nsTop 54
		nsRight 95
		nsBottom 74
		x 85
		y 54
	)
)

(instance calendar of Feature
	(properties
		noun 24
		nsLeft 15
		nsTop 45
		nsRight 32
		nsBottom 69
		x 23
		y 57
	)
)

(instance boarHead of Feature
	(properties
		noun 15
		x 258
		y 49
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 261 34 266 35 268 33 269 37 273 38 273 47 270 49 267 49 264 44 258 44 256 42 259 40 260 38
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Talk
			(sfx number: 1043 loop: 1 play:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fileCabinets of Feature
	(properties
		noun 17
		x 175
		y 64
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 175 66 219 68 219 88 178 86 173 83
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 274 64 319 66 319 112 272 103
					yourself:
				)
		)
	)
)

(instance otherDesk1 of Feature
	(properties
		noun 12
		x 50
		y 116
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PBarredAccess init: 0 90 62 91 95 110 0 116 yourself:)
		)
	)
)

(instance otherDesk2 of Feature
	(properties
		noun 13
		x 50
		y 152
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 1 118 103 114 168 152 5 152
					yourself:
				)
		)
	)
)

(instance hiResBanner of View
	(properties
		noun 18
		x 80
		y 29
		view 5405
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local9 1)
				((User curEvent:) claimed: 1)
				(gEgo setMotion: 0 setHeading: 160 self)
			)
			(1
				(gEgo
					setMotion: 0
					view: 9057
					setLoop: 0 1
					cel: 0
					setPri: 6
					setCycle: End self
				)
			)
			(2
				(cond
					(register
						(gCurRoom newRoom: 560)
					)
					((OneOf caller firstEntranceDay2 firstEntranceDay3)
						(caller cue:)
						(= caller 0)
					)
					(else
						(gGame handsOn:)
					)
				)
			)
			(3
				(gEgo setMotion: PolyPath local6 local7)
				(self dispose:)
			)
		)
	)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (& (event type:) evMOVE)
			(= local6 (event x:))
			(= local7 (event y:))
			(self setScript: standUp self)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo heading: 120 normalize: 0 2)
				(= local9 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstEntranceDay3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hal view: 541 setLoop: 3 1 cel: 0 setScript: yak)
				(gEgo setMotion: PolyPath 163 118 self)
			)
			(1
				(if (!= (gEgo view:) 9057)
					(gEgo setScript: sitDown self)
				else
					(= local9 1)
					(self cue:)
				)
			)
			(2
				(hal setScript: 0 cycleSpeed: 12 setCycle: Fwd)
				(= ticks 180)
				(= register (gNarrator modeless:))
				(gNarrator modeless: 2)
				(= local10 1)
				(gMessager say: 2 2 20 0 self) ; "Yeah? Ya can just drop dead!"
			)
			(3
				(hal setLoop: 3 1 setCycle: 0 cel: 9 cycleSpeed: 6)
			)
			(4
				(gNarrator modeless: register)
				(hal setScript: halTalks self 2 2 16 noun: 8)
				(halTell init: hal 540 9 5)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance halTalks of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(= lastTicks gGameTime)
		((= client param1) script: self)
		(= caller param2)
		(= local0 param3)
		(= local1 param4)
		(= local2 param5)
		(= state (- start 1))
		(gGame handsOff:)
		(self cue:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (!= (hal view:) 541) (!= (hal loop:) 2))
					(hal setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(1
				(cond
					((OneOf (hal loop:) 1 3)
						(hal loop: (- (hal loop:) 1))
						(hal cel: (hal lastCel:) setCycle: CT 4 -1 self)
					)
					((== (hal loop:) 2)
						(hal cel: 6 setCycle: Beg self)
					)
					(else
						(hal setCycle: Beg self)
					)
				)
			)
			(2
				(if local10
					(sfx number: 623 loop: 1 play:)
					(= ticks 120)
				else
					(hal setCycle: Beg self)
				)
			)
			(3
				(cond
					(local10
						(-- state)
						(= local10 0)
						(hal setCycle: Beg self)
					)
					((and caller (== caller goSeeBlock))
						(gMessager sayRandom: local0 local1 local2 self)
					)
					(else
						(gMessager say: local0 local1 local2 0 self)
					)
				)
			)
			(4
				(if (== gDay 5)
					(hal setScript: phoneCall)
				else
					(gGame handsOn:)
					(hal setScript: halWrite)
				)
				(self dispose:)
			)
		)
	)
)

