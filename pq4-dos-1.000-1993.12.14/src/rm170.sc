;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use n030)
(use Array)
(use Scaler)
(use Polygon)
(use Feature)
(use Orbit)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm170 0
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23 = 2
)

(instance rm170 of Room
	(properties
		noun 6
		picture 140
		picAngle 15
	)

	(method (doit)
		(if (and (== local23 2) ((gInventory at: 5) state:)) ; vest
			(= local23 4)
		)
		(super doit:)
	)

	(method (init &tmp temp0)
		(= local1 (IntArray newWith: 4 55 68 109 127))
		(= local2 (IntArray newWith: 4 86 86 86 85))
		(= local3 (IntArray newWith: 10 45 56 62 68 80 106 113 119 125 131 150))
		(= local4 (IntArray newWith: 10 55 68 83 94 102 110 118 126 134 142))
		(= local5 (IntArray newWith: 8 0 0 0 0 0 0 0 0))
		(= local6 (IntArray newWith: 4 window1 window2 window3 window4))
		(= local7 (IntArray newWith: 4 70 85 110 128))
		(= local8 (IntArray newWith: 4 73 103 167 193))
		(gGame doRemap: 2 253 150 2)
		(proc0_4 1)
		(gPqFlags set: 27)
		(gGlobalSound1
			stop:
			number: 130
			setLoop: -1
			setVol: 0
			play:
			fade: 127 4 2 0
		)
		(sFx1 init:)
		(sFx2 init:)
		(sFx3 init:)
		(sFx4 init:)
		(sFx5 init:)
		(super init:)
		(PalVary 8 140) ; PalVaryNewSource
		(gTheIconBar curIcon: (gTheIconBar at: 0))
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
		(gGame handsOff:)
		(gEgo
			x: 200
			y: 170
			setHeading: 270
			normalize: 0
			setScaler: Scaler 100 57 182 116
			init:
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 117 319 116 319 145 292 145 293 168 115 167 115 147 0 147
					yourself:
				)
		)
		((= temp0 (View new:))
			view: 145
			loop: 1
			cel: 0
			x: 118
			y: 56
			ignoreActors:
			init:
		)
		(temp0 signal: (| (temp0 signal:) $1000))
		((= temp0 (View new:))
			view: 139
			loop: 0
			cel: 0
			x: 248
			y: 44
			priority: 8
			ignoreActors:
			noun: 5
			init:
		)
		(temp0 signal: (| (temp0 signal:) $1000))
		((= temp0 (View new:))
			view: 139
			loop: 0
			cel: 1
			x: 156
			y: 136
			priority: 8
			ignoreActors:
			noun: 7
			init:
		)
		(temp0 signal: (| (temp0 signal:) $1000))
		(car init:)
		(trunk init:)
		(door init:)
		(burnedBldg140 init:)
		(rainbow140 init:)
		(billboard init:)
		(emo init:)
		(gEgo get: 11) ; handgun
		(gEgo get: 13) ; fullClip
		(gEgo get: 32) ; keys
		(sFx1 stop: number: 917 setLoop: 1 play:)
		(self setScript: sEnter)
	)

	(method (dispose)
		(local1 dispose:)
		(local2 dispose:)
		(local3 dispose:)
		(local4 dispose:)
		(local5 dispose:)
		(local6 dispose:)
		(local7 dispose:)
		(local8 dispose:)
		(PalVary 3) ; PalVaryKill
		(super dispose: &rest)
	)
)

(instance bulletHole of Prop
	(properties)

	(method (init param1 param2)
		(|= signal $6000)
		(= fixPriority 1)
		(= view 173)
		(= cel 0)
		(= cycleSpeed 0)
		(= x param1)
		(= y param2)
		(= scaleSignal 1)
		(= scaleX
			(Max
				20
				(- 128 (/ (GetDistance x y (sight x:) (sight y:)) 4))
			)
		)
		(= scaleY scaleX)
		(cond
			((< x (+ (sight x:) 20))
				(= loop 0)
			)
			((> x (+ (sight x:) 100))
				(= loop 4)
			)
			(else
				(= loop 2)
			)
		)
		(if local0
			(= detailLevel (local0 firstTrue: #onMe x y))
		)
		(if (not detailLevel)
			(if (cop onMe: x y)
				(= detailLevel cop)
			else
				(= detailLevel 0)
			)
		)
		(cond
			(detailLevel
				(+= loop 1)
				(= priority (+ (detailLevel priority:) 1))
				(super init:)
				(if (== detailLevel cop)
					(self setCycle: End cop)
				else
					(self setCycle: End self)
				)
			)
			(
				(and
					(wall onMe: x y)
					(not (or (leftWindow onMe: x y) (rightWindow onMe: x y)))
				)
				(= priority 150)
				(super init:)
				(self setCycle: End self)
			)
			(else
				(DisposeClone self)
				(return 0)
			)
		)
		(return detailLevel)
	)

	(method (checkDetail))

	(method (cue)
		(if
			(and
				detailLevel
				(gCast contains: detailLevel)
				(detailLevel isMemberOf: Prop)
				local0
				(local0 contains: detailLevel)
			)
			(local0 delete: detailLevel)
			(-= local9 1)
			(if (detailLevel yStep:)
				(switch (detailLevel yStep:)
					(window1
						(sFx1 setLoop: 1 stop:)
					)
					(window2
						(sFx2 setLoop: 1 stop:)
					)
					(window3
						(sFx3 setLoop: 1 stop:)
					)
					(window4
						(sFx4 setLoop: 1 stop:)
					)
				)
			)
			(detailLevel setScript: 0 dispose:)
		)
		(= detailLevel 0)
		(self dispose:)
	)
)

(instance shootest of Prop
	(properties)

	(method (dispose)
		(if yStep
			(yStep dispose:)
			(= yStep 0)
		)
		(super dispose:)
	)
)

(instance cop of Prop
	(properties
		noun 4
		x 167
		y 135
		view 172
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)

	(method (cue)
		(self setScript: copKiller)
	)
)

(instance emo of Prop
	(properties
		noun 3
		x 119
		y 127
		view 146
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)
)

(instance door of Prop
	(properties
		x 229
		y 60
		priority 8
		view 145
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)
)

(instance car of View
	(properties
		noun 2
		x 182
		y 152
		view 149
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)
)

(instance trunk170 of Feature
	(properties
		noun 1
		nsLeft 35
		nsTop 128
		nsRight 123
		nsBottom 150
		sightAngle 40
		x 79
		y 139
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 35 129 93 129 117 137 120 143 90 148 35 148
				yourself:
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; keys
				(gGame points: 2 41)
				(gCurRoom setInset: (ScriptID 28) blahScr) ; trunkInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blahScr of Script
	(properties)

	(method (cue)
		(gTheIconBar disable: 0)
	)
)

(instance trunk of View
	(properties
		noun 1
		x 240
		y 156
		z 40
		priority 12
		view 149
		cel 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 46) ; keys
				(if local15
					(if (== (hideAndSeek state:) 4)
						(gGame points: 2 41)
						(gCurRoom setScript: getShotgun)
					else
						(gMessager say: 1 4 7) ; "You can't reach your trunk from here!"
					)
				else
					(gTheCursor show:)
					(proc30_0 0 0 4 1 170)
				)
			)
			((== theVerb 4) ; Do
				(if (== (hideAndSeek state:) 4)
					(gMessager say: 1 4 2) ; "Your trunk is locked."
				else
					(gMessager say: 1 4 7) ; "You can't reach your trunk from here!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties)

	(method (init)
		(super init:)
		(= y 50)
		(= noun 5)
		(= onMeCheck
			((Polygon new:)
				type: PBarredAccess
				init: 147 32 147 0 285 0 286 148 123 148 99 141 69 121 34 119 34 108 44 108 44 51
				yourself:
			)
		)
	)
)

(instance leftWindow of Feature
	(properties)

	(method (init)
		(super init:)
		(= y 50)
		(= noun 5)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 74 70 74 86 51 86 51 73 yourself:)
		)
	)
)

(instance rightWindow of Feature
	(properties)

	(method (init)
		(super init:)
		(= y 50)
		(= noun 5)
		(= onMeCheck
			((Polygon new:) type: PBarredAccess init: 135 67 135 85 104 85 102 68 yourself:)
		)
	)
)

(instance copKiller of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 0 6 0 self) ; "You've just shot and killed fellow officer Jim Varaz!"
			)
			(1
				(SetCursor -2)
				(gTheCursor show:)
				(proc30_0 0 0 4 1 170)
			)
		)
	)
)

(instance getShotgun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register gCast)
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
				(register
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
			)
			(1
				(gTheIconBar disable: 0)
				(gCurRoom picture: 170 drawPic: 170)
				(gGame doRemap: 2 253 150 2)
				(gCurRoom setScript: shooter)
			)
		)
	)
)

(instance resetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 fade: 0 2 1 1)
				(gGame handsOff:)
				(if (!= (sight view:) 9051)
					(sight setScript: duck)
				)
				(= ticks 240)
				(if (and local0 (local0 isEmpty:))
					(local0 dispose:)
					(= local0 0)
				)
			)
			(1
				(gGlobalSound0
					stop:
					number: 919
					setLoop: -1
					setVol: 0
					play:
					fade: 127 12 2 0
				)
				(= seconds 4)
			)
			(2
				(cop cel: 0 setCycle: End self)
			)
			(3
				(gGame fade: 100 0 10)
				(gGlobalSound1
					stop:
					number: 920
					setLoop: -1
					setVol: 0
					play:
					fade: 127 12 2 0
				)
				(= ticks 240)
			)
			(4
				(gCast eachElementDo: #dispose release:)
				(gFeatures eachElementDo: #dispose release:)
				(gCurRoom drawPic: 140 0 1)
				(PalVary 8 140) ; PalVaryNewSource
				(FrameOut)
				((View new:)
					view: 139
					loop: 0
					cel: 0
					x: 248
					y: 44
					ignoreActors:
					init:
				)
				((View new:)
					view: 139
					loop: 0
					cel: 1
					x: 156
					y: 136
					ignoreActors:
					init:
				)
				(car init:)
				(door init:)
				(emo init:)
				(SetCursor -2)
				((= register (Prop new:))
					view: 9053
					loop: 0
					cel: 0
					x: 262
					y: 155
					scaleSignal: 1
					scaleX: 119
					scaleY: 119
					setPri: 140
					ignoreActors:
					setCycle: End self
					init:
				)
				((View new:)
					view: 145
					loop: 1
					cel: 0
					x: 118
					y: 56
					ignoreActors:
					init:
				)
				((Actor new:)
					view: 1403
					x: 246
					y: 127
					ignoreActors:
					setLoop: 1 1
					setStep: 3 1
					setCycle: Walk
					scaleSignal: 1
					scaleX: 115
					scaleY: 115
					fixPriority: 1
					priority: 130
					init:
					setMotion: MoveTo 220 130
				)
				((Actor new:)
					view: 1406
					setLoop: 0 1
					cel: 0
					x: -15
					y: 163
					setSpeed: 8
					setScaler: Scaler 100 64 170 116
					setCycle: Walk
					init:
					setMotion: MoveTo 72 136
				)
				(FrameOut)
				(gGame fade: 0 100 10)
			)
			(5
				((Actor new:)
					view: 1405
					setLoop: 0 1
					cel: 0
					x: -10
					y: 125
					scaleSignal: 1
					scaleX: 100
					scaleY: 100
					setSpeed: 8
					init:
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 41 123 self
				)
				(register loop: 1 cel: 0 setCycle: End self)
			)
			(6)
			(7
				(gMessager say: 0 0 5 0 self) ; "Your second day on the case comes to an end."
				(gGame doRemap: 0 253)
				(= gDay 3)
			)
			(8
				(gGame points: 5)
				(if ((gInventory at: 5) state:) ; vest
					(gEgo get: 5) ; vest
					((gInventory at: 5) state: 0) ; vest
				)
				(gEgo put: 12 580) ; shotgun
				(gEgo put: 11 580) ; handgun
				(gEgo put: 15) ; shells
				(gTheCursor show:)
				(gGame setCursor: gTheCursor 1)
				(gGlobalSound0 stop:)
				(gGlobalSound1 stop:)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance hideAndSeek of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGame handsOff:)
				(gEgo setSpeed: 0)
				(gEgo setHeading: 90 self)
			)
			(1
				1
				(gEgo
					view: 9043
					setLoop: 0 1
					cel: 0
					x: 191
					y: 167
					setCycle: End self
				)
			)
			(2
				2
				(= local16 End)
				(gEgo setSpeed: global112 view: 9044 loop: 2 cel: 7)
				(door setScript: copPopAndFire)
				(gGame handsOn:)
			)
			(3
				3
				(gEgo view: 9043 setLoop: 1 1)
				(gEgo
					cel:
						(if (== local16 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local16
				)
			)
			(4
				4
				(gEgo view: 9043 setLoop: 2 1)
				(gEgo
					cel:
						(if (== local16 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local16
				)
			)
			(5
				5
				(gEgo view: 9044 setLoop: 0 1)
				(gEgo
					cel:
						(if (== local16 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local16
				)
				(if (not register)
					(= register 1)
				)
			)
			(6
				6
				(gEgo view: 9044 setLoop: 1 1)
				(gEgo
					cel:
						(if (== local16 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local16
				)
			)
			(7
				7
				(gEgo view: 9044 setLoop: 2 1)
				(gEgo
					cel:
						(if (== local16 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local16
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (gEgo mover:)
			(gEgo setMotion: 0)
		)
		(if (event modifiers:)
			(event claimed: 0)
			(return)
		)
		(if script
			(event claimed: 1)
			(return)
		)
		(if (gEgo cycler:)
			(if
				(or
					(& (event type:) evMOVE)
					(and
						(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
						(== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					)
					(= temp1 (== (gTheIconBar curIcon:) (gTheIconBar at: 1)))
				)
				(if temp1
					(event claimed: 0)
					(return)
				else
					(event claimed: 1)
					(return)
				)
			else
				(event claimed: 0)
				(return)
			)
		)
		(cond
			(
				(or
					(& (event type:) evMOVE)
					(= temp1 (== (gTheIconBar curIcon:) (gTheIconBar at: 1)))
				)
				(if (and (> state 2) (not local22))
					((Prop new:)
						view: 1407
						loop: (Random 0 1)
						y: 82
						yStep: 0
						x: (local8 at: (Random 0 3))
						init:
						setScript: (popAndFire new:)
						yourself:
					)
				)
				(cond
					((>= (event x:) (car x:))
						(if (== state 7)
							(= state 2)
						)
						(cond
							((OneOf state 2 3 6)
								(= local16 End)
								(self changeState: (+ state 1))
							)
							((!= state 4)
								(= local16 Beg)
								(self changeState: state)
								(-- state)
							)
						)
					)
					((OneOf state 4 5)
						(= local16 End)
						(self changeState: (+ state 1))
					)
					((!= state 6)
						(if (OneOf state 2 7)
							(= state 7)
							(= local16 Beg)
							(self changeState: state)
							(= state 6)
						else
							(= local16 Beg)
							(self changeState: state)
							(-- state)
						)
					)
				)
				(if (or (& (event type:) evMOVE) (not temp1))
					(event claimed: 1)
					(return)
				)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
					(== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
				)
				(if (OneOf (event type:) evMOUSEBUTTON evKEYBOARD $0020) ; joyUp
					(self
						setScript:
							egoPopAndFire
							0
							(if (cop onMe: event) 1 else 0)
					)
					(event claimed: 1)
					(return)
				)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)
)

(instance egoPopAndFire of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local21 (gEgo view:))
				(= local19 (gEgo loop:))
				(= local20 (gEgo cel:))
				(if (!= (Platform) 2)
					(gTheCursor hide:)
				)
				(switch (gEgo view:)
					(9043
						(switch (gEgo loop:)
							(1
								(if local20
									(gEgo view: 9045 loop: 1)
								else
									(gEgo view: 9045 loop: 0)
								)
							)
							(2
								(gEgo view: 9046 loop: 0)
							)
						)
					)
					(9044
						(switch (gEgo loop:)
							(0
								(if local20
									(gEgo view: 9046 loop: 1)
								else
									(gEgo view: 9046 loop: 0)
								)
							)
							(1
								(gEgo view: 9047 loop: 0)
							)
							(2
								(if local20
									(gEgo view: 9045 loop: 0)
								else
									(gEgo view: 9047 loop: 0)
								)
							)
						)
					)
				)
				(gEgo cel: 0 setCycle: End self)
				((Prop new:)
					view: 1407
					loop: (Random 0 1)
					y: 82
					yStep: 0
					x: (local8 at: (Random 0 3))
					init:
					setScript: (popAndFire new:)
				)
			)
			(1
				(if (= temp0 ((gInventory at: 11) state:)) ; handgun
					((gInventory at: 11) state: (- temp0 1)) ; handgun
					(if register
						(sFx5 stop: number: 926 setLoop: 1 play:)
						(client setScript: copKiller)
					else
						(sFx5 stop: number: 926 setLoop: 1 play:)
						(= ticks 30)
					)
				else
					(sFx5 stop: number: 12 setLoop: 1 play:)
					(= ticks 30)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo view: local21 loop: local19 cel: local20)
				(gTheCursor show:)
				(self dispose:)
			)
		)
	)
)

(instance run of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sFx5 stop: number: 934 setLoop: 1 play: self)
			)
			(1
				(emo loop: 1 cel: 0 setCycle: End self)
				((Prop new:)
					view: 1407
					loop: (Random 0 1)
					yStep: 0
					y: 82
					x: (local8 at: 1)
					init:
					setScript: (popAndFire new:)
				)
			)
			(2
				(emo view: 147 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(sFx5 stop: number: 930 setLoop: 1 play:)
				(gGlobalSound1 fade: 0 4 2 1)
				(gGlobalSound0 stop: number: 170 setLoop: -1 setVol: 127 play:)
				(emo loop: 1 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gWalkHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(emo setCycle: End)
				(gEgo setMotion: MoveTo 146 167 self)
			)
			(1
				1
				(gEgo setHeading: 0)
				(= cycles 20)
			)
			(2
				2
				(gGame handsOn:)
				(sFx1 stop: number: 933 setLoop: 1 play:)
				(gGlobalSound1 setLoop: 1 fade: 0 4 2 1)
				(gGlobalSound0 stop: number: 102 setLoop: 1 setVol: 127 play:)
				(emo setScript: run)
				(= seconds 3)
			)
			(3
				3
				(gGame handsOff:)
				(gTheCursor show:)
				(proc30_0 0 0 4 1 170)
			)
		)
	)

	(method (handleEvent event)
		(if (and (== state 2) (& (event type:) evMOVE))
			(if (car onMe: (event x:) (event y:))
				(gEgo setLooper: 0)
				(client setScript: hideAndSeek)
				(event claimed: 1)
				(return)
			else
				(self cue:)
			)
		)
		(return 0)
	)
)

(instance shooter of Script
	(properties)

	(method (init)
		(gTheIconBar disable: 0)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gGame handsOn:)
		(gTheIconBar disable: 0)
		(wall init:)
		(leftWindow init:)
		(sight init:)
		(rightWindow init:)
		(trunk170 init:)
		(cop view: 172 loop: 0 cel: 0 x: 167 y: 135 init: setScript: bangBang)
		((View new:)
			view: 171
			loop: 0
			cel: 0
			x: 116
			y: 171
			z: 30
			scaleSignal: 1
			scaleX: 76
			scaleY: 76
			fixPriority: 1
			priority: 4
			ignoreActors:
			signal: 20480
			noun: 3
			init:
		)
		(burnedBldg170 init:)
		(rainbow170 init:)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(if (not script)
			(cond
				((and local0 (local0 isEmpty:))
					(client setScript: resetter)
				)
				((not local9)
					(reLoad doit:)
				)
			)
		else
			(script doit:)
		)
	)

	(method (dispose)
		(gTheIconBar enable: 0)
		(if local0
			(local0 release: dispose:)
			(= local0 0)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState))

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14)
		(if
			(and
				(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
				(or
					(== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(== (gTheIconBar curInvIcon:) (gInventory at: 12)) ; shotgun
				)
			)
			(if
				(or
					(& (event type:) evMOUSEBUTTON)
					(& (event type:) $0020) ; joyUp
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(if (not register)
					(if (event modifiers:)
						(return 0)
					)
					(if (!= (Platform) 2)
						(SetCursor 63 0 131 179)
					)
					(gTheIconBar state: (| (gTheIconBar state:) $0004))
					(= local10 (event x:))
					(= local11 (event y:))
					(= register 1)
					(if (!= (Platform) 2)
						(gTheCursor hide:)
					)
					(sight setScript: kill)
					(= local13 1)
					(event claimed: 1)
					(return)
				else
					(if (not (& (event modifiers:) emSHIFT))
						(if (sight script:)
							(event claimed: 1)
							(return)
						)
						(cond
							((== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
								(if (= temp1 ((gInventory at: 11) state:)) ; handgun
									(= temp0
										((bulletHole new:)
											init: gMouseX gMouseY
										)
									)
									((= temp14 (View new:))
										view: 175
										loop: (sight loop:)
										cel: (sight cel:)
										x: (sight x:)
										y: (sight y:)
										fixPriority: 1
										ignoreActors:
										priority: (+ (sight priority:) 1)
										init:
									)
									(FrameOut)
									(temp14 dispose:)
									(FrameOut)
									((gInventory at: 11) state: (- temp1 1)) ; handgun
									(if temp0
										(gGlobalSound1
											stop:
											setLoop: 1
											number: 930
											play:
										)
									else
										(gGlobalSound1
											stop:
											setLoop: 1
											number: 926
											play:
										)
									)
								else
									(gGlobalSound1
										stop:
										setLoop: 1
										number: 12
										play:
									)
									(gMessager say: 0 22 1) ; "You've run out rounds for your Beretta!"
								)
							)
							((= temp1 ((gInventory at: 12) state:)) ; shotgun
								(= temp2 (- gMouseX (Random 2 8)))
								(= temp3 (+ gMouseX (Random 2 8)))
								(= temp4 (- gMouseX (Random 2 8)))
								(= temp5 (+ gMouseX (Random 2 8)))
								(= temp6 (- gMouseX (Random 2 8)))
								(= temp7 (+ gMouseX (Random 2 8)))
								(= temp8 (- gMouseY (Random 2 8)))
								(= temp9 (- gMouseY (Random 2 8)))
								(= temp10 (- gMouseY (Random 2 8)))
								(= temp11 (+ gMouseY (Random 2 8)))
								(= temp12 (+ gMouseY (Random 2 8)))
								(= temp13 (+ gMouseY (Random 2 8)))
								(= temp0
									(or
										((bulletHole new:) init: temp2 temp8)
										((bulletHole new:) init: gMouseX temp9)
										((bulletHole new:) init: temp3 temp10)
										((bulletHole new:) init: temp4 gMouseY)
										((bulletHole new:)
											init: gMouseX gMouseY
										)
										((bulletHole new:) init: temp5 gMouseY)
										((bulletHole new:) init: temp6 temp11)
										((bulletHole new:)
											init: gMouseX temp12
										)
										((bulletHole new:) init: temp7 temp13)
									)
								)
								((gInventory at: 12) state: (- temp1 1)) ; shotgun
								(if temp0
									(gGlobalSound1
										stop:
										setLoop: 1
										number: 931
										play:
									)
								else
									(gGlobalSound1
										stop:
										setLoop: 1
										number: 932
										play:
									)
								)
								((= temp14 (View new:))
									view: 174
									loop: (sight loop:)
									cel: (sight cel:)
									x: (sight x:)
									y: (sight y:)
									ignoreActors:
									fixPriority: 1
									priority: (+ (sight priority:) 1)
									init:
								)
								(FrameOut)
								(temp14 dispose:)
								(FrameOut)
							)
							(else
								(gGlobalSound1 stop: setLoop: 1 number: 12 play:)
								(gMessager say: 0 23 1) ; "You've exhausted your supply of 12 gauge shotgun shells!"
							)
						)
					else
						(sight setScript: duck 0 1)
						(= register 0)
					)
					(event claimed: 1)
					(return)
				)
			else
				(super handleEvent: event)
				(event claimed:)
				(return)
			)
		else
			(return 0)
		)
	)
)

(instance bangBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= register (View new:))
				(if (== (gCurRoom picture:) 140)
					(register
						view: 1401
						loop: 2
						x: 230
						y: 95
						ignoreActors:
						priority: 8
						init:
					)
				else
					(register view: 172 loop: 1 x: 145 y: 101 init:)
				)
				(sFx5 stop: number: 926 setLoop: 1 play:)
				(FrameOut)
				(register dispose:)
				(= state 0)
			)
		)
	)
)

(instance copPopAndFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(door setCycle: End)
				(cop
					view: 1401
					loop: 0
					cel: 0
					x: 247
					y: 122
					priority: 8
					init:
					setCycle: End self
				)
			)
			(2
				(sFx5 stop: number: 935 setLoop: 1 play:)
				(= cycles 5)
			)
			(3
				(cop loop: 1 setCycle: End self)
			)
			(4
				(= local15 1)
				(cop setScript: bangBang)
				(self dispose:)
			)
		)
	)
)

(class popAndFire of Script
	(properties
		reg2 0
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(if (== (gCurRoom picture:) 140)
					(= ticks (Random 2 60))
				else
					(= ticks (Random 20 240))
				)
			)
			(1
				1
				(if local22
					(self changeState: 0)
					(return)
				else
					(= local22 1)
				)
				(client cycleSpeed: (Random 1 4) setCycle: End self)
			)
			(2
				2
				(if
					(and
						(== (cop script:) bangBang)
						(not ((cop script:) state:))
						(Random 0 1)
					)
					((cop script:) cue:)
				)
				(cond
					((client yStep:)
						((= register (dud new:))
							x: (client x:)
							y: (client y:)
							ignoreActors:
							fixPriority: 1
							priority: (+ (client priority:) 1)
							view: 170
							xStep: 1
							yStep: 1
							cycleSpeed: 0
							moveSpeed: 0
							setLoop: 2 1
							cel: 0
							setMotion:
								Orbit
								client
								4
								0
								65
								5
								(if (Random 0 1) 1 else -1)
								(Random 0 359)
							setCycle: Fwd
							init:
						)
						(= reg2
							(GetAngle
								(client x:)
								(client y:)
								(sight x:)
								(sight y:)
							)
						)
						((client yStep:)
							cel: 0
							cycleSpeed: 0
							setCycle: (sForward new:)
							init:
						)
						(= cycles (Random 5 100))
					)
					((== (gCurRoom picture:) 140)
						((= register (dud new:))
							x: (client x:)
							y: (client y:)
							ignoreActors:
							priority: (+ (client priority:) 1)
							view: 1407
							xStep: 1
							yStep: 1
							cycleSpeed: 1
							moveSpeed: 0
							setLoop: 2 1
							cel: 0
							setMotion:
								Orbit
								client
								4
								0
								65
								5
								(if (Random 0 1) 1 else -1)
								(Random 0 359)
							setCycle: (sForward new:)
							init:
						)
						(= cycles (Random 5 20))
					)
					(else
						(self cue:)
					)
				)
				(if
					(and
						(< local18 2)
						(not (Random 0 1))
						(== (gCurRoom picture:) 170)
					)
					(switch local18
						(0
							(= local18 1)
							((Prop new:)
								view: 173
								loop: 6
								cel: 0
								x: 34
								y: 108
								ignoreActors:
								init:
								setScript: (crack new:)
							)
						)
						(1
							(= local18 2)
							((Prop new:)
								view: 173
								loop: 7
								cel: 0
								x: 46
								y: 108
								ignoreActors:
								init:
								setScript: (crack new:)
							)
						)
					)
				)
			)
			(3
				(if (== (gCurRoom picture:) 140)
					(if register
						(register setCycle: 0 dispose:)
						(= register 0)
					)
					(if
						(or
							(OneOf (gEgo view:) 9045 9046 9047)
							(and
								(or
									(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
									(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
								)
								(gEgo cycler:)
							)
						)
						(++ local14)
						(if (== local14 local23)
							(gCurRoom setScript: egoDie)
						else
							(gMessager say: 0 0 3) ; "You're hit! Lucky it's only a graze!"
						)
					)
					(client setCycle: Beg self)
				else
					(if register
						(register setCycle: 0 dispose:)
						(= register 0)
					)
					(if (client yStep:)
						((client yStep:) setCycle: 0 dispose:)
					)
					(client yStep: 0 loop: 0 cel: 6 setCycle: Beg self)
				)
				(= local22 0)
			)
			(4
				(if (== (gCurRoom picture:) 140)
					(client dispose:)
				else
					(-- local9)
					(self dispose:)
				)
			)
		)
	)

	(method (handleEvent)
		(return 0)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if (and reg2 register)
			(= temp1 ((register mover:) curAngle:))
			(if
				(and
					(<= (Abs (- reg2 temp1)) 2)
					(or
						(and local13 (Random 0 1))
						(and (not local13) (not (Random 0 100)))
					)
				)
				(++ local14)
				(= temp2 (Clone Event))
				(temp2 type: 1 modifiers: 3)
				(shooter handleEvent: temp2)
				(temp2 dispose:)
				(if (== local14 local23)
					(gCurRoom setScript: egoDie)
				else
					(gMessager say: 0 0 3) ; "You're hit! Lucky it's only a graze!"
				)
			)
		)
		(cond
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(= lastSeconds temp0)
					(if (not (-- seconds))
						(self cue:)
					)
				)
			)
			((and ticks (<= (-= ticks (Abs (- gGameTime lastTicks))) 0))
				(= ticks 0)
				(self cue:)
			)
		)
		(= lastTicks gGameTime)
	)

	(method (dispose)
		(if register
			(register setCycle: 0 dispose:)
			(= register 0)
		)
		(super dispose:)
	)
)

(instance crack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance kill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User controls: 0 input: 0)
				(sight view: 9051)
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(sight loop: 1 cel: 0 setCycle: End self)
				else
					(sight loop: 0 cel: 0 setCycle: End self)
				)
			)
			(1
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(sight view: 9052 cel: 0)
				else
					(sight view: 9050 cel: 0)
				)
				(User controls: 1 input: 1)
				(self dispose:)
			)
		)
	)
)

(instance duck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User controls: 0 input: 0)
				(sight setCycle: Beg self)
			)
			(1
				(sight view: 9051)
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(sight loop: 1 cel: 7 setCycle: Beg self)
				else
					(sight loop: 0 cel: 7 setCycle: Beg self)
				)
			)
			(2
				(sight loop: 1 cel: 0)
				(gTheIconBar state: (& (gTheIconBar state:) $fffb))
				(SetCursor -2)
				(if register
					(User controls: 1 input: 1)
					(gTheCursor show:)
					(= register 0)
				)
				(= local13 0)
				(self dispose:)
			)
		)
	)
)

(instance egoDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(local0 eachElementDo: #dispose release: dispose:)
					(= local0 0)
				)
				(gGame handsOff:)
				(SetCursor -2)
				(gGlobalSound0 stop: setLoop: 1 number: 930 setVol: 127 play: self)
			)
			(1
				(gTheCursor show:)
				(proc30_0 0 0 4 1 170)
			)
		)
	)
)

(instance reLoad of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(local5 fill: 0 4 0)
		(= local22 0)
		(if (not local0)
			(= local0 (List new:))
			(= local9 2)
			(for ((= temp2 1)) (<= temp2 2) ((++ temp2))
				(= temp0 (shootest new:))
				(temp0
					view: 170
					signal: (| (temp0 signal:) $6000)
					fixPriority: 1
					scaleSignal: 1
					priority: 0
					setLoop: (Random 0 1) 1
					cel: 0
				)
				(local0 add: temp0)
				(= temp3 1)
				(while temp3
					(= temp1 (Random 0 3))
					(if (not (local5 at: temp1))
						(local5 at: temp1 1)
						(= temp3 0)
					)
				)
				(temp0
					yStep: (local6 at: temp1)
					scaleX: (local7 at: temp1)
					scaleY: (local7 at: temp1)
					x: (+ (local1 at: temp1) (- 3 (Random 0 4)))
					y: (local2 at: temp1)
					setScript: (popAndFire new:)
					init:
				)
			)
		else
			(for ((= temp2 0)) (< temp2 (local0 size:)) ((++ temp2))
				(= local9 (local0 size:))
				(= temp3 1)
				(while temp3
					(= temp1 (Random 0 3))
					(if (not (local5 at: temp1))
						(local5 at: temp1 1)
						(= temp3 0)
					)
				)
				((local0 at: temp2)
					setLoop: (Random 0 1) 1
					cel: 0
					yStep: (local6 at: temp1)
					scaleX: (local7 at: temp1)
					scaleY: (local7 at: temp1)
					x: (+ (local1 at: temp1) (- 3 (Random 0 4)))
					y: (local2 at: temp1)
					setScript: (popAndFire new:)
				)
			)
		)
	)
)

(instance dud of Actor
	(properties)

	(method (onMe)
		(return 0)
	)
)

(instance window1 of Prop
	(properties
		x 48
		y 70
		priority 2
		view 170
		loop 3
		cel 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance window2 of Prop
	(properties
		x 61
		y 70
		priority 2
		view 170
		loop 4
		cel 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance window3 of Prop
	(properties
		x 97
		y 64
		priority 2
		view 170
		loop 5
		cel 1
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance window4 of Prop
	(properties
		x 121
		y 65
		priority 2
		view 170
		loop 6
	)

	(method (init)
		(|= signal $4000)
		(super init:)
	)
)

(instance sForward of Fwd
	(properties)

	(method (dispose)
		(switch client
			(window1
				(sFx1
					stop:
					setLoop: 1
					number: 901
					setVol: (Random 25 127)
					play:
				)
			)
			(window2
				(sFx2
					stop:
					setLoop: 1
					number: 901
					setVol: (Random 25 127)
					play:
				)
			)
			(window3
				(sFx3
					stop:
					setLoop: 1
					number: 901
					setVol: (Random 25 127)
					play:
				)
			)
			(else
				(sFx4
					stop:
					setLoop: 1
					number: 901
					setVol: (Random 25 127)
					play:
				)
			)
		)
		(= local22 0)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		(switch client
			(window1
				(sFx1 stop: setLoop: -1 setVol: 127 number: 900 play:)
			)
			(window2
				(sFx2 stop: setLoop: -1 setVol: 127 number: 900 play:)
			)
			(window3
				(sFx3 stop: setLoop: -1 setVol: 127 number: 900 play:)
			)
			(else
				(sFx4 stop: setLoop: -1 setVol: 127 number: 900 play:)
			)
		)
	)
)

(instance sight of Prop
	(properties
		x 130
		y 164
		priority 14
		view 9051
		loop 1
		cycleSpeed 2
	)

	(method (init &tmp [temp0 2])
		(|= signal $6000)
		(super init: &rest)
		(= actions gEgo)
		(self doit:)
	)

	(method (doit)
		(if (or script (not local13))
			(super doit:)
			(return)
		)
		(cond
			((< (Abs (- y gMouseY)) 40)
				(= loop 3)
			)
			((< gMouseY (- y 70))
				(= loop 0)
			)
			((< gMouseY (- y 55))
				(= loop 1)
			)
			((< gMouseY (- y 40))
				(= loop 2)
			)
		)
		(cond
			((< (Abs (- x gMouseX)) 10)
				(= cel 6)
			)
			((< gMouseX (- x 129))
				(= cel 0)
			)
			((< gMouseX (- x 100))
				(= cel 1)
			)
			((< gMouseX (- x 70))
				(= cel 2)
			)
			((< gMouseX (- x 45))
				(= cel 3)
			)
			((< gMouseX (- x 25))
				(= cel 4)
			)
			((< gMouseX (- x 10))
				(= cel 5)
			)
			((> gMouseX (+ x 10))
				(= cel 7)
			)
		)
		(UpdateScreenItem self)
	)

	(method (dispose)
		(= actions 0)
		(super dispose:)
	)
)

(instance rainbow140 of Feature
	(properties
		noun 7
		nsLeft 222
		nsRight 319
		nsBottom 115
		sightAngle 360
		x 270
		y 57
	)
)

(instance burnedBldg140 of Feature
	(properties
		noun 5
		nsLeft 48
		nsTop 33
		nsRight 222
		nsBottom 115
		sightAngle 360
		x 135
		y 50
	)
)

(instance rainbow170 of Feature
	(properties
		noun 7
		sightAngle 360
		x 270
		y 57
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 147 0 285 0 285 144 148 129
					yourself:
				)
		)
	)
)

(instance burnedBldg170 of Feature
	(properties
		noun 5
		sightAngle 360
		x 135
		y 60
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 44 50 146 31 147 129 72 117 55 106 44 102
					yourself:
				)
		)
	)
)

(instance billboard of Feature
	(properties
		noun 8
		nsLeft 8
		nsTop 52
		nsRight 37
		nsBottom 70
		x 15
		y 60
	)
)

(instance sFx1 of Sound
	(properties)
)

(instance sFx2 of Sound
	(properties)
)

(instance sFx3 of Sound
	(properties)
)

(instance sFx4 of Sound
	(properties)
)

(instance sFx5 of Sound
	(properties)
)

