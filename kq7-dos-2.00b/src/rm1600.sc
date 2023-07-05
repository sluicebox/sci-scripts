;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1600)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Dune)
(use DuneMover)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm1600 0
)

(local
	local0
	local1
)

(instance rm1600 of KQRoom
	(properties
		picture 1600
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 6200)
			(gKqMusic1
				number: 1320
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(gGame handsOn:)
		(SetFlag 389)
		(Load rsVIEW 800)
		(Load rsMESSAGE 1600)
		(if
			(and
				(not (gEgo has: 8)) ; Hunting_Horn
				(or (not (IsFlag 18)) (gEgo has: 18) (IsFlag 23)) ; Bug_Reducing_Powder
				(not (IsFlag 324))
				(== gChapter 1)
			)
			(horn init:)
		)
		(if (== gPrevRoomNum 1610)
			(bones init:)
		)
		(desertEast init:)
		(desertSouth init:)
		(desertNorth init:)
		(desertWest init:)
		(duneManager add: dune1 dune2 dune3 eachElementDo: #init)
		(gEgo init: normalize:)
		(= global312 3)
		(if (or (IsFlag 5) (not (OneOf gPrevRoomNum 1610 1500)))
			(ClearFlag 5)
			(gEgo posn: 150 128 setHeading: 180)
			(= global314 1)
		)
		(SetFlag 21)
		(= local0 ((ScriptID 0 7) seconds:)) ; desertDeathTimer
		((ScriptID 0 7) client: 0 delete: dispose:) ; desertDeathTimer
		(if (and (not (IsFlag 18)) (IsFlag 17))
			(theSpirit init: posn: 150 100)
			(pouch init:)
			(if (!= gPrevRoomNum 1610)
				(self setScript: showBody)
			)
		)
		(if (and (== gChapter 1) (not (IsFlag 18)) (!= gPrevRoomNum 1610))
			(storm init:)
		)
		(cond
			((== gPrevRoomNum 1610)
				(theSpirit
					init:
					posn: 280 113
					view: 1502
					setLoop: 4 1
					setCel: 0
				)
				(pouch init:)
				(self setScript: spiritLeaves)
			)
			((== gPrevRoomNum 3100)
				(gKqMusic1
					number: 1320
					setLoop: -1
					play:
					setVol: 0
					fade: 127 25 10 0
				)
				(gEgo hide:)
				(self setScript: fallIn)
			)
			((== gPrevRoomNum 6200)
				(gEgo hide:)
				(self setScript: fallIn)
			)
			((== gPrevRoomNum 1601)
				(gEgo posn: 186 98)
				(self setScript: fromBones)
			)
		)
		(cond
			((IsFlag 17)
				(ClearFlag 17)
			)
			((== gPrevRoomNum 1500)
				(self setScript: walkIn)
			)
		)
		(if (and (== gPrevRoomNum 1610) (or (gEgo has: 17) (gEgo has: 18))) ; Rope, Bug_Reducing_Powder
			(SetFlag 18)
		)
		(gEgo perform: duneSetupCode)
		(if (gCast contains: theSpirit)
			(theSpirit perform: duneSetupCode)
		)
		(if (and (gCast contains: storm) (== script showBody))
			(storm perform: duneSetupCode)
		)
	)

	(method (handleEvent event)
		(if (== script lookAtBones)
			(event claimed: 1)
			(return)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(gCast contains: storm)
				(not script)
				(not (gEgo script:))
				(dune1 onMe: gEgo)
				(>= (gEgo priority:) 99)
				(< (gEgo distanceTo: storm) 80)
			)
			(gEgo setMotion: 0)
			(self setScript: tooCloseToStorm)
		)
	)

	(method (notify)
		(duneManager setup: gEgo (duneManager curDune:))
	)

	(method (dispose)
		(duneManager release: dispose:)
		(if (OneOf gPrevRoomNum 3100 6200)
			((ScriptID 0 7) setReal: (ScriptID 0 7) 120) ; desertDeathTimer, desertDeathTimer
		else
			((ScriptID 0 7) setReal: (ScriptID 0 7) (+ local0 60)) ; desertDeathTimer, desertDeathTimer
		)
		(super dispose:)
	)
)

(instance showBody of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo hide:)
				(theSpirit setMotion: DuneMover 190 130 self)
				(= ticks 45)
			)
			(1
				(gEgo show: posn: 1 90 setMotion: DuneMover 181 125 self)
			)
			(2
				(theSpirit setMotion: DuneMover 280 113 self)
			)
			(3 0)
			(4
				(gEgo setHeading: 45)
				(proc11_3 theSpirit gEgo self)
			)
			(5
				(theSpirit view: 1502 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(storm setLoop: 0 1 setMotion: PolyPath 150 60 self)
				(theSpirit setLoop: 2 setCel: 0 setCycle: End)
			)
			(7
				(storm dispose:)
				(gEgo hide:)
				(theSpirit hide:)
				(pouch view: 1611 setLoop: 0 setCel: 0 posn: 204 119)
				(if (gCast contains: horn)
					(horn hide:)
				)
				(gCurRoom drawPic: 1610)
				(= seconds 6)
			)
			(8
				(gCurRoom drawPic: 1600)
				(gEgo show:)
				(theSpirit show:)
				(pouch view: 1500 setLoop: 3 setCel: 0 posn: 214 88)
				(if (gCast contains: horn)
					(horn show:)
				)
				(= seconds 1)
			)
			(9
				(gMessager say: 0 0 1 1 self) ; "Is that..."
			)
			(10
				(theSpirit setLoop: 3 setCel: 0 setCycle: End self)
			)
			(11
				(gMessager sayRange: 0 0 1 2 4 self) ; "Yes. That is all that remains of Colin Farwalker, the great adventurer. Me."
			)
			(12
				(gCurRoom newRoom: 1610)
			)
		)
	)
)

(instance checkStorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover 157 97 self)
			)
			(1
				(gEgo view: 1501 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(= ticks 90)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 8021 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(5
				(gEgo posn: 140 97 normalize: 0)
				(duneManager setup: gEgo)
				(self cue:)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tooCloseToStorm of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 1501
					setLoop: (if (< (gEgo x:) (storm x:)) 0 else 1)
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(= ticks 90)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo
					view: 8021
					setLoop: (if (< (gEgo x:) (storm x:)) 0 else 1)
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(if (< (gEgo x:) (storm x:))
					(gEgo
						posn: (- (gEgo x:) 17) (gEgo y:)
						normalize: 0
					)
				else
					(gEgo
						posn: (+ (gEgo x:) 17) (gEgo y:)
						normalize: 1
					)
				)
				(= cycles 1)
			)
			(5
				(if (or (> 0 (gEgo x:)) (< 320 (gEgo x:)))
					(= temp0 (Max (Min 320 (gEgo x:)) 0))
					(gEgo setMotion: MoveTo temp0 (gEgo y:) self)
				else
					(duneManager setup: gEgo)
					(= cycles 1)
				)
			)
			(6
				(duneManager setup: gEgo)
				(self cue:)
			)
			(7
				(gMessager say: 5 24 0 0 self 1100) ; "Oh...my..."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spiritLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 60)
			)
			(1
				(gMessager say: 1 8 0 1 self) ; "I thank you, good sir."
			)
			(2
				(gMessager say: 1 8 0 2 self) ; "May it help you in your journeys, my lady. Farewell."
			)
			(3
				(if (and (gEgo has: 17) (gCast contains: horn)) ; Rope
					(horn setLoop: 2 setCycle: End)
				)
				(pouch setLoop: 4 setCycle: End)
				(theSpirit setCycle: End self)
				(gKqSound1 number: 831 setLoop: 1 play:)
			)
			(4
				(theSpirit dispose:)
				(pouch dispose:)
				(if (and (gEgo has: 17) (gCast contains: horn)) ; Rope
					(horn dispose:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch global314
					(1
						(gEgo
							posn: 160 138
							setMotion: DuneMover 160 129 self
						)
					)
					(3
						(gEgo posn: 160 40 setMotion: DuneMover 160 50 self)
					)
					(2
						(gEgo posn: 1 100 setMotion: DuneMover 11 100 self)
					)
					(4
						(gEgo
							posn: 319 100
							setMotion: DuneMover 309 100 self
						)
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walkNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover (gEgo x:) 35 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance walkSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover (gEgo x:) 139 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance walkEast of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover 319 (gEgo y:) self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance walkWest of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover 0 100 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 1500)
			)
		)
	)
)

(instance lookAtBones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover 186 98 self)
			)
			(1
				(gEgo view: 8161 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(gCurRoom newRoom: 1601)
			)
		)
	)
)

(instance fromBones of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 8161
					setLoop: 0
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(gEgo normalize: 0)
				(duneManager setup: gEgo)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(storm setMotion: 0 setCycle: Fwd)
				(= ticks 600)
			)
			(1
				(storm setLoop: 0 1 setMotion: MoveTo 228 118 self)
			)
			(2
				(= ticks 120)
			)
			(3
				(if
					(or
						(== (gCurRoom script:) getTheHorn)
						(== (gCurRoom script:) checkStorm)
					)
					(-- state)
				else
					(storm setMotion: MoveTo 218 97 self)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance getTheHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: DuneMover 162 92 self)
			)
			(1
				(gEgo
					posn: 160 92
					view: 8061
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(horn dispose:)
				(gEgo get: 8 setCycle: Beg self) ; Hunting_Horn
			)
			(3
				(if (gCast contains: storm)
					(gEgo
						posn: 160 90
						view: 8021
						setLoop: 0
						setCel: 0
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(4
				(if (gCast contains: storm)
					(gEgo posn: 138 91 normalize: 0)
				else
					(gEgo posn: 162 92 normalize: 0)
				)
				(duneManager setup: gEgo)
				(gGame handsOn:)
				(storm setScript: blow)
				(self dispose:)
			)
		)
	)
)

(instance fallIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 865) ; WAVE
				(= ticks 60)
			)
			(1
				(gKqSound1 number: 852 setLoop: 1 play:)
				(gEgo
					posn: 140 110
					show:
					view: 1601
					setLoop: 0
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(2
				(gKqSound1 number: 865 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo normalize: 6)
				(duneManager setup: gEgo)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theSpirit of Actor
	(properties
		x 190
		y 85
		view 9101
	)

	(method (init)
		(super init:)
		(if (== gPrevRoomNum 1500)
			(self
				setHotspot: 8 10 ; Do, Exit
				ignoreActors: 1
				setLoop: -1
				setLooper: gGrooper
				setCycle: StopWalk -1
			)
		)
		((ScriptID 7001 3) client: self view: 1502) ; spiritTalker
		(if (== gPrevRoomNum 1610)
			(self posn: 280 113)
		)
	)
)

(instance storm of Actor
	(properties
		x 218
		y 97
		view 1500
	)

	(method (init)
		(super init:)
		(self setPri: 98 1)
		(if (gCast contains: theSpirit)
			(self setCycle: Fwd)
		else
			(self setScript: blow)
		)
		(Load 140 878) ; WAVE
		(gKqSound1 number: 878 setLoop: -1 play:)
	)

	(method (dispose)
		(gKqSound1 setLoop: 1 fade:)
		(super dispose:)
	)
)

(instance horn of Prop
	(properties
		x 195
		y 90
		view 1500
		loop 1
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 ignoreActors: 1 setPri: 97) ; Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if
					(or
						(== (blow state:) 1)
						(== (blow state:) 2)
						(not (gCast contains: storm))
					)
					(gCurRoom setScript: getTheHorn)
				else
					(gCurRoom setScript: checkStorm)
				)
			)
		)
	)
)

(instance pouch of Prop
	(properties
		x 214
		y 88
		view 1500
		loop 3
	)

	(method (init)
		(super init:)
		(self setPri: 97 ignoreActors: 1)
	)
)

(instance bones of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 202 78 203 87 235 102 241 97 212 75
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: lookAtBones)
			)
		)
	)
)

(instance desertEast of ExitFeature
	(properties
		nsLeft 300
		nsRight 319
		nsBottom 140
		sightAngle 360
		exitDir 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(= approachX 319)
		(= approachY (event y:))
		(super handleEvent: event)
	)

	(method (doVerb)
		(if (== (gCurRoom picture:) 1610)
			(lookAtBones cue:)
		else
			(= global313 3)
			(= global312 3)
			(= global314 2)
			(gCurRoom newRoom: 1500)
		)
	)
)

(instance desertWest of ExitFeature
	(properties
		nsRight 22
		nsBottom 140
		sightAngle 360
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(= approachX 0)
		(= approachY (event y:))
		(super handleEvent: event)
	)

	(method (doVerb)
		(if (== (gCurRoom picture:) 1610)
			(lookAtBones cue:)
		else
			(= global313 1)
			(= global312 3)
			(= global314 4)
			(gCurRoom newRoom: 1500)
		)
	)
)

(instance desertNorth of ExitFeature
	(properties
		nsRight 320
		nsBottom 40
		sightAngle 360
		y 1
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(= approachX (event x:))
		(= approachY 45)
		(super handleEvent: event)
	)

	(method (doVerb)
		(if (== (gCurRoom picture:) 1610)
			(lookAtBones cue:)
		else
			(= global312 2)
			(= global313 2)
			(= global314 1)
			(gCurRoom setScript: walkNorth)
		)
	)
)

(instance desertSouth of ExitFeature
	(properties
		nsLeft 21
		nsTop 126
		nsRight 289
		nsBottom 135
		sightAngle 360
		exitDir 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 10 10 approachVerbs: 10) ; Exit, Exit, Exit
	)

	(method (handleEvent event)
		(if (< (event x:) 128)
			(= approachX 128)
		else
			(= approachX (event x:))
		)
		(= approachY 134)
		(super handleEvent: event)
	)

	(method (doVerb)
		(if (== (gCurRoom picture:) 1610)
			(lookAtBones cue:)
		else
			(= global312 4)
			(= global313 2)
			(= global314 3)
			(gCurRoom setScript: walkSouth)
		)
	)
)

(instance duneManager of DuneHandler
	(properties)

	(method (addToFront)
		(if oldWalkHandler
			(oldWalkHandler addToFront: &rest)
		else
			(super addToFront: &rest)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(or
				(event claimed:)
				(oldWalkHandler handleEvent: event)
				(self checkDunes: event)
				(and
					(event y: (+ (dune3 findRidge: (event x:)) 5))
					(self checkDunes: event)
				)
			)
			(= temp0 1)
		)
		(return temp0)
	)
)

(instance dune1 of Dune
	(properties)

	(method (init)
		(super init: &rest)
		(= roomPoly
			((Polygon new:)
				type: PBarredAccess
				init: 127 114 112 151 38 146 0 143 0 108 66 97 106 102
				yourself:
			)
		)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 73 110 73 130 75 162 75 192 76 220 80 251 85 286 92 320 98 320 110 231 102 157 98 0 98
				yourself:
			)
		)
		(self
			setPri: 99 95
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 187 319 189 320 98 298 94 265 87 231 81 201 77 175 75 148 75 110 74 79 73 0 73
					yourself:
				)
		)
	)
)

(instance dune2 of Dune
	(properties
		duneScaleSize 85
	)

	(method (init)
		(super init: &rest)
		(= roomPoly
			((Polygon new:) type: PBarredAccess init: 80 78 107 78 107 87 80 87 yourself:)
		)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 59 16 58 37 60 62 60 104 56 143 50 191 45 238 42 262 42 279 43 320 47 320 66 167 66 138 69 93 73 23 76 0 76
				yourself:
			)
		)
		(self
			setPri: 84 80
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 138 320 138 320 47 301 45 269 42 238 42 205 45 169 47 122 53 73 60 47 61 16 58 0 59
					yourself:
				)
		)
	)
)

(instance dune3 of Dune
	(properties
		duneScaleSize 45
	)

	(method (init)
		(super init: &rest)
		(= roomPoly 0)
		(= ridgeValleyPoly
			((Polygon new:)
				type: PTotalAccess
				init: 0 0 100 0 127 7 165 12 208 13 243 13 279 14 312 15 320 13 320 27 0 27
				yourself:
			)
		)
		(self
			setPri: -1 -1
			setPolygon:
				((Polygon new:)
					type: PContainedAccess
					init: 0 138 320 138 320 14 302 15 268 14 246 13 231 13 180 13 151 11 133 8 100 0 0 0
					yourself:
				)
		)
	)
)

(instance duneSetupCode of Code
	(properties)

	(method (doit param1)
		(if (and param1 (param1 isKindOf: Actor))
			(gWalkHandler setup: param1)
		)
	)
)

