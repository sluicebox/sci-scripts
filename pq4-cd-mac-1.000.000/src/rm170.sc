;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 170)
(include sci.sh)
(use Main)
(use n030)
(use Array)
(use Print)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Orbit)
(use Sound)
(use Motion)
(use Game)
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
	local6 = 2
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
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34 = 2
	local35
	local36 = 4
)

(procedure (localproc_0)
	(gUser canControl: 0 canInput: 0)
)

(procedure (localproc_1)
	(gUser canControl: 1 canInput: 1)
)

(procedure (localproc_2)
	(gGame handsOff:)
	(gEgo setMotion: 0 setLooper: 0)
	(sEnter next: hideAndSeek dispose:)
)

(procedure (localproc_3)
	(if (not argc)
		(return
			(or
				(gTalkers size:)
				(Print dialog:)
				(sfx handle:)
				(egoHitFx handle:)
				(handGunFx handle:)
				(shotGunFx handle:)
				(shooterGun handle:)
			)
		)
	else
		(sfx number: 0 stop:)
		(shooterGun number: 0 stop:)
		(return (or (gTalkers size:) (Print dialog:) (egoHitFx handle:)))
	)
)

(procedure (localproc_4 param1 param2 param3)
	(if
		(and
			(not (Random 0 1))
			(> param2 (- local3 8))
			(< param2 (+ local3 8))
			(> param3 (- local4 8))
			(< param3 (+ local4 8))
		)
		(++ local0)
		(= local5 1)
		(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
			(localproc_5 926)
		else
			(localproc_5 932)
		)
		(param1 cel: 1)
		(UpdateScreenItem param1)
	)
	(= local3 0)
	(= local4 0)
)

(procedure (localproc_5 param1)
	(if (or (gTalkers size:) (Print dialog:))
		(return)
	else
		(sfx number: 0 stop:)
		(shooterGun number: 0 stop:)
		(handGunFx number: 0 stop:)
		(shotGunFx number: 0 stop:)
		(switch param1
			(926
				(egoHitFx number: 930 loop: 1 play:)
			)
			(932
				(egoHitFx number: 931 loop: 1 play:)
			)
		)
	)
)

(procedure (localproc_6 param1 param2 &tmp temp0 temp1 temp2)
	(cond
		((or (== (gCurRoom script:) egoDie) local2 local33)
			(if (== local1 1)
				(Printf
					{can't create shooter... curRoom script: %s\nCan't be: egoDie\nnumShooters= %d shooterUp= %d}
					((gCurRoom script:) name:)
					local2
					local33
				)
			)
		)
		(
			(and
				(not argc)
				(not (OneOf (gCurRoom script:) shooter hideAndSeek))
			)
			(if (== local1 1)
				(Printf
					{argc = %d curRoom script: %s\n}
					argc
					((gCurRoom script:) name:)
				)
			)
		)
		(else
			(++ local2)
			(if (== (gCurRoom picture:) 140)
				(= temp2 1407)
				(= temp1 82)
				(if argc
					(= temp0 (local18 at: 1))
				else
					(= temp0 (local18 at: (Random 1 3)))
				)
				((Shooter_140 new:)
					view: temp2
					loop: (Random 0 1)
					y: temp1
					yStep: 0
					x: temp0
					init:
					setScript: (popAndFire new:)
					yourself:
				)
			else
				(= temp2 170)
				(= temp1 87)
				(= temp0 (local19 at: (Random 1 3)))
				((Prop new:)
					view: temp2
					loop: (Random 0 1)
					y: temp1
					yStep: 0
					x: temp0
					init:
					setScript: (popAndFire new:)
					yourself:
				)
			)
		)
	)
	(if (and param2 (> argc 1))
		(= local35 param2)
	else
		(= local35 0)
	)
)

(instance rm170 of Room
	(properties
		noun 6
		picture 140
		picAngle 15
	)

	(method (init &tmp temp0)
		(if (and global105 (== gPrevRoomNum 6) (ResCheck rsSCRIPT 6969)) ; speedRoom
			(gEgo get: 5) ; vest
			(= local34 10)
			(= local6 5)
		)
		(= local1 0)
		(= local11 (IntArray newWith: 4 55 68 109 127))
		(= local12 (IntArray newWith: 4 86 86 86 85))
		(= local13
			(IntArray newWith: 10 45 56 62 68 80 106 113 119 125 131 150)
		)
		(= local14 (IntArray newWith: 10 55 68 83 94 102 110 118 126 134 142))
		(= local15 (IntArray newWith: 8 0 0 0 0 0 0 0 0))
		(= local16 (IntArray newWith: 4 window1 window2 window3 window4))
		(= local17 (IntArray newWith: 4 70 85 110 128))
		(= local18 (IntArray newWith: 4 73 103 167 193))
		(= local19 (IntArray newWith: 4 54 69 108 126))
		(gGame doRemap: 2 243 150 2)
		(proc0_4 1)
		(gPqFlags set: 27)
		(gGlobalSound1 number: 0 stop:)
		(gGlobalSound0 number: 130 loop: -1 flags: 5 play: setVol: 90)
		(super init:)
		(gGame intensity: 0)
		(PalVary 8 140) ; PalVaryNewSource
		(gTheIconBar curIcon: (gTheIconBar at: 0))
		(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
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
		(centerDoor setPri: 56 ignoreActors: 1 init:)
		((= temp0 (View new:))
			view: 139
			name: {Burned Building addToPic}
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
			name: {Rainbow addToPic}
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
		(trunk init:)
		(door init: setPri: 8)
		(burnedBldg140 init:)
		(car init:)
		(rainbow140 init:)
		(billboard init:)
		(emo init:)
		(gEgo get: 11) ; handgun
		(gEgo get: 13) ; fullClip
		(gEgo get: 32) ; keys
		(sfx number: 917 loop: 1 play:)
		(self setScript: sEnter)
	)

	(method (doit)
		(if (and (== local34 2) ((gInventory at: 5) state:)) ; vest
			(= local34 4)
		)
		(if
			(and
				local33
				(not local5)
				(!= script getShotgun)
				(== (cop script:) bangBang)
				(not ((cop script:) register:))
				(not ((cop script:) state:))
				(not (getHit register:))
				(not (Random 0 20))
				(or
					(and
						(== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
						(not ((gInventory at: 11) state:)) ; handgun
					)
					(and
						(== (gTheIconBar curInvIcon:) (gInventory at: 12)) ; shotgun
						(not ((gInventory at: 12) state:)) ; shotgun
					)
				)
			)
			((cop script:) cue:)
		)
		(super doit:)
	)

	(method (dispose)
		(local11 dispose:)
		(local12 dispose:)
		(local13 dispose:)
		(local14 dispose:)
		(local15 dispose:)
		(local16 dispose:)
		(local17 dispose:)
		(local18 dispose:)
		(local19 dispose:)
		(PalVary 3) ; PalVaryKill
		(super dispose: &rest)
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
		priority 120
		fixPriority 1
		view 172
	)

	(method (init)
		(|= signal $5000)
		(super init:)
	)

	(method (cue)
		(gCurRoom setScript: copKiller)
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

(instance crossHairs of View
	(properties
		view 49350
		signal 26657
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
				(gCurRoom setInset: (ScriptID 28)) ; trunkInset
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
				(if local26
					(if (== (hideAndSeek state:) 4)
						(gGame handsOff: points: 2 41)
						(gCurRoom setScript: getShotgun)
					else
						(gMessager say: 1 4 7) ; "You can't reach your trunk from here!"
					)
				else
					(gTheCursor show:)
					(gGame setCursor: gWaitCursor 1)
					(proc30_0 0 0 4 1 170)
				)
			)
			((== theVerb 4) ; Do
				(if (== (hideAndSeek state:) 4)
					(gMessager say: 1 4 2) ; "Your trunk is locked, Carey."
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

(instance copPopAndFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(sfx number: 32 loop: 1 play:)
				(door setCycle: End)
				(cop
					view: 1401
					setLoop: 0
					cel: 0
					x: 247
					y: 122
					setPri: 122
					init:
					setCycle: End self
				)
			)
			(2
				(= local26 1)
				(if (getHit register:)
					(-- state)
					(= ticks 30)
				else
					(sfx number: 935 loop: 1 play:)
					(= ticks 90)
				)
			)
			(3
				(cop setLoop: 1 setCycle: End self)
			)
			(4
				(cop setScript: bangBang 0 0)
				(self dispose:)
			)
		)
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
				(if (not global170)
					(gTheCursor hide:)
				)
				(SetCursor -2)
				(localproc_0)
				(sight view: 9051)
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(sight setLoop: 1 cel: 0 setCycle: End self)
				else
					(sight setLoop: 0 cel: 0 setCycle: End self)
				)
			)
			(1
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(sight view: 9052 cel: 0)
				else
					(sight view: 9050 cel: 0)
				)
				(localproc_1)
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
				(SetCursor -2)
				(gGame setCursor: gWaitCursor 1)
				(gGame handsOff:)
				(if local10
					(local10 eachElementDo: #dispose release: dispose:)
					(= local10 0)
				)
				(= ticks 30)
			)
			(1
				(proc30_0 0 0 4 1 170)
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
		priority 199
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
		priority 199
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
		priority 199
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
		priority 199
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

	(method (init)
		(super init: &rest)
		(if (not (run register:))
			(shooterGun number: 901 loop: 1 play:)
		)
	)
)

(instance sight of Prop
	(properties
		x 130
		y 164
		priority 198
		view 9051
		loop 1
		cycleSpeed 2
	)

	(method (init &tmp [temp0 2])
		(crossHairs init: posn: gMouseX gMouseY)
		(|= signal $6000)
		(super init: &rest)
		(= actions gEgo)
		(self doit:)
	)

	(method (doit)
		(if (or script (not local24))
			(super doit:)
			(return)
		)
		(crossHairs posn: gMouseX gMouseY)
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
		(crossHairs dispose:)
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

(instance sfx of Sound
	(properties
		flags 5
	)

	(method (play)
		(if (not (localproc_3))
			(super play: &rest)
		else
			(self number: 0 stop:)
		)
	)
)

(instance egoHitFx of Sound
	(properties
		flags 5
	)
)

(instance handGunFx of Sound
	(properties
		flags 5
	)

	(method (play)
		(if (not (localproc_3 1))
			(super play: &rest)
		)
	)
)

(instance shotGunFx of Sound
	(properties
		flags 5
	)

	(method (play)
		(if (not (localproc_3 1))
			(super play: &rest)
		)
	)
)

(instance shooterGun of Sound
	(properties
		flags 5
	)

	(method (play)
		(if (not (localproc_3))
			(super play: &rest)
		else
			(self number: 0 stop:)
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
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				1
				(gGame intensity: 100 fade: 0 100 (gGame fadeSpeed:))
				(= cycles 2)
			)
			(2
				2
				(emo cycleSpeed: 8 cel: 0 setCycle: CT 5 1)
				(gEgo setMotion: MoveTo 146 167 self)
			)
			(3
				3
				(emo cycleSpeed: 6 setCycle: End)
				(gEgo setHeading: 0 self)
			)
			(4
				4
				(sfx number: 933 loop: 1 play:)
				(gGlobalSound0 number: 102 loop: 1 play: setVol: 90)
				(emo setScript: run)
			)
			(5
				5
				(gGame handsOn:)
				(= seconds 8)
			)
			(6
				6
				(localproc_6 1 self)
			)
			(7
				7
				(= state 3)
				(= seconds 4)
			)
		)
	)

	(method (handleEvent event)
		(if (and (>= state 4) (& (event type:) evMOVE))
			(if (car onMe: (event x:) (event y:))
				(= next hideAndSeek)
				(gEgo setMotion: 0 setLooper: 0)
				(self dispose:)
				(event claimed: 1)
				(return)
			else
				(gEgo setMotion: 0)
				(gTheCursor show:)
				(gGame handsOff: setCursor: gWaitCursor 1)
				(proc30_0 0 0 4 1 170)
				(self dispose:)
				(event claimed: 1)
				(return)
			)
		)
		(return 0)
	)
)

(instance reLoad of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(local15 fill: 0 4 0)
		(if (and (not local33) (not local10))
			(= local10 (List new:))
			(= local20 2)
			(for ((= temp2 1)) (<= temp2 2) ((++ temp2))
				(= temp0 (shootest new:))
				(temp0
					view: 170
					signal: (| (temp0 signal:) $6000)
					setPri: 20
					scaleSignal: 1
					setLoop: (Random 0 1) 1
					cel: 0
				)
				(local10 add: temp0)
				(= temp3 1)
				(while temp3
					(= temp1 (Random 0 3))
					(if (not (local15 at: temp1))
						(local15 at: temp1 1)
						(= temp3 0)
					)
				)
				(temp0
					yStep: (local16 at: temp1)
					scaleX: (local17 at: temp1)
					scaleY: (local17 at: temp1)
					x: (+ (local11 at: temp1) (- 3 (Random 0 4)))
					y: (local12 at: temp1)
					setScript: (popAndFire new:)
					init:
				)
			)
		else
			(for ((= temp2 0)) (< temp2 (local10 size:)) ((++ temp2))
				(= local20 (local10 size:))
				(= temp3 1)
				(while temp3
					(= temp1 (Random 0 3))
					(if (not (local15 at: temp1))
						(local15 at: temp1 1)
						(= temp3 0)
					)
				)
				((local10 at: temp2)
					setLoop: (Random 0 1) 1
					cel: 0
					yStep: (local16 at: temp1)
					scaleX: (local17 at: temp1)
					scaleY: (local17 at: temp1)
					x: (+ (local11 at: temp1) (- 3 (Random 0 4)))
					y: (local12 at: temp1)
					setPri: 20
					setScript: (popAndFire new:)
				)
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

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) sEnter) (== theVerb 22)) ; handgun
			(localproc_2)
		else
			(super doVerb: theVerb)
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

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) sEnter) (== theVerb 22)) ; handgun
			(localproc_2)
		else
			(super doVerb: theVerb)
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

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) sEnter) (== theVerb 22)) ; handgun
			(localproc_2)
		else
			(super doVerb: theVerb)
		)
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

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) sEnter) (== theVerb 22)) ; handgun
			(localproc_2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance centerDoor of View
	(properties
		noun 5
		x 118
		y 56
		view 145
		loop 1
	)

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) sEnter) (== theVerb 22)) ; handgun
			(localproc_2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance resetter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (sight view:) 9051)
					(sight setScript: duck 0 0)
				)
				(if (and local10 (local10 isEmpty:))
					(local10 dispose:)
					(= local10 0)
				)
				(= ticks 90)
			)
			(1
				(cop cel: 0 setCycle: End self)
			)
			(2
				(gCast eachElementDo: #dispose release:)
				(gFeatures eachElementDo: #dispose release:)
				((View new:)
					view: 139
					loop: 0
					cel: 0
					x: 248
					y: 44
					ignoreActors: 1
					setPri: 44
					init:
				)
				((View new:)
					view: 139
					loop: 0
					cel: 1
					x: 156
					y: 136
					ignoreActors: 1
					setPri: 136
					init:
				)
				(car init:)
				(door init:)
				(emo init:)
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
					ignoreActors: 1
					setCycle: End self
					init:
				)
				((View new:)
					view: 145
					loop: 1
					cel: 0
					x: 118
					y: 56
					ignoreActors: 1
					setPri: 56
					init:
				)
				((Actor new:)
					view: 1403
					x: 246
					y: 127
					setLoop: 1 1
					setStep: 3 1
					setCycle: Walk
					scaleSignal: 1
					scaleX: 115
					scaleY: 115
					setPri: (- (car priority:) 1)
					init:
					ignoreActors: 1
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
				(gCurRoom drawPic: 140 0 1)
				(PalVary 8 140) ; PalVaryNewSource
				(FrameOut)
			)
			(3
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
				(register setLoop: 1 cel: 0 setCycle: End self)
			)
			(4)
			(5
				(gGlobalSound0 stop:)
				(gGame doRemap: 0 243)
				(= gDay 3)
				(gGame points: 5)
				(if ((gInventory at: 5) state:) ; vest
					(gEgo get: 5) ; vest
					((gInventory at: 5) state: 0) ; vest
				)
				(gEgo put: 12 580) ; shotgun
				(gEgo put: 11 580) ; handgun
				(gEgo put: 15) ; shells
				(gTheCursor show:)
				(gGame setCursor: gWaitCursor 1)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance shootGunScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(if (= local8 ((gInventory at: 11) state:)) ; handgun
					((gInventory at: 11) state: (- local8 1)) ; handgun
					(= local9 ((bulletHole new:) init: gMouseX gMouseY))
					((= register (View new:))
						view: 175
						loop: (sight loop:)
						cel: (sight cel:)
						x: (sight x:)
						y: (sight y:)
						setPri: (- (sight priority:) 1)
						ignoreActors:
						init:
					)
					(UpdateScreenItem register)
					(= cycles 2)
				else
					(++ state)
					(self setScript: emptyScr self 0)
				)
			)
			(1
				(register dispose:)
				(if local9
					(localproc_5 926)
				else
					(handGunFx number: 926 loop: 1 play:)
				)
				(= ticks 120)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance copKiller of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(getHit register: 2)
				(cop setCycle: 0 setScript: 0)
				(gMessager say: 4 0 6 1 self) ; "Carey, you've just shot and killed fellow officer Jim Varaz..."
			)
			(1
				(proc30_0 0 0 10 1 170)
			)
		)
	)
)

(instance getShotgun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local33
					(-- state)
					(= ticks 20)
				else
					(gThePlane drawPic: -1)
					(gCast eachElementDo: #hide)
					(= cycles 2)
				)
			)
			(1
				(= register gCast)
				(PalVary 3) ; PalVaryKill
				(gGame handsOn:)
				(gCurRoom setInset: (ScriptID 28) self) ; trunkInset
			)
			(2
				(register
					eachElementDo: #dispose
					eachElementDo: #delete
					release:
				)
				(if (gPqFlags test: 180)
					(gPqFlags clear: 180)
					(-- local25)
				)
				(UnLoad 128 149)
				(UnLoad 128 9044)
				(gCurRoom picture: 170 drawPic: 170)
				(PalVary 8 170) ; PalVaryNewSource
				(gGame doRemap: 2 243 150 2)
				(cop
					view: 172
					loop: 0
					cel: 0
					x: 167
					y: 135
					init:
					setPri: 135
					setScript: bangBang 0 0
				)
				(= local7 0)
				(= local33 0)
				(= local2 0)
				(gGame handsOn:)
				(gCurRoom setScript: shooter)
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
				(localproc_6)
				(cond
					((>= (event x:) (car x:))
						(if (== state 7)
							(= state 2)
						)
						(cond
							((OneOf state 2 3 6)
								(= local27 End)
								(self changeState: (+ state 1))
							)
							((!= state 4)
								(= local27 Beg)
								(self changeState: state)
								(-- state)
							)
						)
					)
					((OneOf state 4 5)
						(= local27 End)
						(self changeState: (+ state 1))
					)
					((!= state 6)
						(if (OneOf state 2 7)
							(= state 7)
							(= local27 Beg)
							(self changeState: state)
							(= state 6)
						else
							(= local27 Beg)
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
					(= local3 (event x:))
					(= local4 (event y:))
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
				(= local3 0)
				(= local4 0)
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setSpeed: 0)
				(gEgo setHeading: 90 self)
			)
			(1
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
				(UnLoad 128 0)
				(UnLoad 128 5)
				(= local27 End)
				(gEgo setSpeed: 4 view: 9044 setLoop: 2 cel: 7)
				(door setScript: copPopAndFire)
				(gGame handsOn:)
			)
			(3
				(gEgo view: 9043 setLoop: 1 1)
				(gEgo
					cel:
						(if (== local27 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local27
				)
			)
			(4
				(gEgo view: 9043 setLoop: 2 1)
				(gEgo
					cel:
						(if (== local27 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local27
				)
			)
			(5
				(gEgo view: 9044 setLoop: 0 1)
				(gEgo
					cel:
						(if (== local27 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local27
				)
				(if (not register)
					(= register 1)
				)
			)
			(6
				(gEgo view: 9044 setLoop: 1 1)
				(gEgo
					cel:
						(if (== local27 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local27
				)
			)
			(7
				(gEgo view: 9044 setLoop: 2 1)
				(gEgo
					cel:
						(if (== local27 End)
							0
						else
							(gEgo lastCel:)
						)
					setCycle: local27
				)
			)
		)
	)

	(method (doit)
		(if (not (Random 0 400))
			(getHit init:)
		)
		(if (not (Random 0 400))
			(localproc_6)
		)
		(super doit:)
	)
)

(instance shootShotgunScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gInventory at: 12) state: (- local8 1)) ; shotgun
				((= register (View new:))
					view: 174
					loop: (sight loop:)
					cel: (sight cel:)
					x: (sight x:)
					y: (sight y:)
					setPri: 200
					ignoreActors: 1
					init:
				)
				(UpdateScreenItem register)
				(= cycles 2)
			)
			(1
				(register dispose:)
				(if (not (getHit register:))
					(if local9
						(localproc_5 932)
					else
						(shotGunFx number: 932 loop: 1 play:)
					)
				)
				(= ticks 120)
			)
			(2
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
				(= register 1)
				(gGlobalSound0 number: 170 loop: -1 play: setVol: 90)
				(localproc_6 1)
				(= ticks 90)
			)
			(1
				(emo loop: 1 cel: 0 cycleSpeed: 1 setCycle: End self)
				(sfx number: 934 loop: 1 play:)
			)
			(2
				(emo view: 147 loop: 0 cel: 1 cycleSpeed: 1 setCycle: End self)
			)
			(3
				(localproc_5 932)
				(= cycles 2)
			)
			(4
				(emo loop: 1 cel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(5
				(emo view: 1147)
				(UnLoad 128 147)
				(= ticks 60)
			)
			(6
				(= register 0)
				(sEnter cue:)
				(self dispose:)
			)
		)
	)
)

(instance bulletHole of Prop
	(properties)

	(method (init param1 param2)
		(|= signal $6000)
		(= fixPriority 1)
		(= view 173)
		(= cycleSpeed (= cel 0))
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
		(if local10
			(= detailLevel (local10 firstTrue: #onMe x y))
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
				(= priority 201)
				(= fixPriority 1)
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
				(= priority 201)
				(= fixPriority 1)
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
				local10
				(local10 contains: detailLevel)
			)
			(-- local6)
			(= local33 0)
			(= local7 0)
		)
		(self dispose:)
	)
)

(instance duck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
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
				(if register
					(= register 0)
					(gTheIconBar state: (& (gTheIconBar state:) $fffb))
					(gGame handsOn:)
					(gTheIconBar disable: 0)
				)
				(= local24 0)
				(self dispose:)
			)
		)
	)
)

(instance Shooter_140 of Prop
	(properties)

	(method (dispose)
		(if yStep
			(yStep dispose:)
			(= yStep 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (and (== (gCurRoom script:) sEnter) (== theVerb 22)) ; handgun
			(localproc_2)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance egoPopAndFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local32 (gEgo view:))
				(= local30 (gEgo loop:))
				(= local31 (gEgo cel:))
				(if (not global170)
					(gTheCursor hide:)
				)
				(switch (gEgo view:)
					(9043
						(switch (gEgo loop:)
							(1
								(if local31
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
								(if local31
									(gEgo view: 9046 loop: 1)
								else
									(gEgo view: 9046 loop: 0)
								)
							)
							(1
								(gEgo view: 9047 loop: 0)
							)
							(2
								(if local31
									(gEgo view: 9045 loop: 0)
								else
									(gEgo view: 9047 loop: 0)
								)
							)
						)
					)
				)
				(gEgo cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(crossHairs init: posn: gMouseX gMouseY)
				(UpdateScreenItem crossHairs)
				(if (= local8 ((gInventory at: 11) state:)) ; handgun
					((gInventory at: 11) state: (- local8 1)) ; handgun
					(if register
						(handGunFx number: 926 loop: 1 play:)
						(gCurRoom setScript: copKiller)
					else
						(if (not local5)
							(handGunFx number: 926 loop: 1 play:)
						)
						(= ticks (Random 40 90))
					)
				else
					(self setScript: emptyScr self 0)
				)
			)
			(2
				(gEgo cycleSpeed: 0 setCycle: Beg self)
			)
			(3
				(crossHairs dispose:)
				(gEgo view: local32 loop: local30 cel: local31)
				(= local5 0)
				(gTheCursor show:)
				(self dispose:)
			)
		)
	)
)

(class popAndFire of Script
	(properties
		reg2 0
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if (run register:)
					(= ticks 30)
				else
					(= ticks (Random 30 180))
				)
			)
			(1
				(if (not local33)
					(= local33 1)
					(client
						cel: 0
						cycleSpeed: 4
						setPri: 20
						signal: 26657
						setCycle: End self
					)
				else
					(-- state)
					(= ticks 120)
				)
			)
			(2
				(= local7 1)
				(cond
					((client yStep:)
						((= register (dud new:))
							x: (client x:)
							y: (client y:)
							ignoreActors:
							fixPriority: 1
							priority: 200
							view: 170
							xStep: 1
							yStep: 1
							cycleSpeed: 6
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
						(= ticks 90)
					)
					((== (gCurRoom picture:) 140)
						((= register (dud new:))
							x: (client x:)
							y: (client y:)
							ignoreActors: 1
							setPri: 200
							view: 1407
							xStep: 1
							yStep: 1
							cycleSpeed: 2
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
						(= ticks 90)
					)
					(else
						(self cue:)
					)
				)
				(if
					(and
						(< local29 2)
						(not (Random 0 1))
						(== (gCurRoom picture:) 170)
					)
					(switch local29
						(0
							(= local29 1)
							((Prop new:)
								view: 173
								loop: 6
								cel: 0
								x: 34
								y: 108
								ignoreActors:
								setPri: 197
								init:
								setScript: (crack new:)
							)
						)
						(1
							(= local29 2)
							((Prop new:)
								view: 173
								loop: 7
								cel: 0
								x: 46
								y: 108
								setPri: 197
								ignoreActors:
								init:
								setScript: (crack new:)
							)
						)
					)
				)
			)
			(3
				(if (or local3 local4)
					(localproc_4 client (client x:) (client y:))
				)
				(if (== (gCurRoom picture:) 140)
					(if register
						(register setCycle: 0 dispose:)
						(= register 0)
					)
					(= temp0 (gEgo view:))
					(= temp1 (gEgo cel:))
					(= temp2 (gEgo loop:))
					(cond
						(local5)
						((gEgo cycler:)
							(getHit init:)
						)
						((not (Random 0 500))
							(getHit init:)
						)
						((and (> local0 4) (not (Random 0 100)))
							(getHit init:)
						)
						(
							(and
								(not (Random 0 100))
								(or
									(OneOf temp0 0 5)
									(and
										(== temp0 9045)
										(< temp1 7)
										(== temp2 0)
									)
									(and
										(== temp0 9045)
										(< temp1 6)
										(== temp2 1)
									)
									(and (== temp0 9046) (< temp1 11))
									(and (== temp0 9047) (< temp1 9))
									(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
									(== (gTheIconBar curIcon:) (gTheIconBar at: 1))
								)
							)
							(getHit init:)
						)
					)
					(if local5
						(self cue:)
					else
						(client cycleSpeed: 4 setCycle: CT 4 -1 self)
					)
				else
					(if register
						(register setCycle: 0 dispose:)
						(= register 0)
					)
					(if (client yStep:)
						((client yStep:) setCycle: 0 dispose:)
					)
					(if local5
						(self cue:)
					else
						(client
							yStep: 0
							setLoop: 0
							cel: 6
							cycleSpeed: 4
							setCycle: CT 4 -1 self
						)
					)
				)
			)
			(4
				(= local7 0)
				(shooterGun number: 0 stop:)
				(client setCycle: Beg self)
			)
			(5
				(= local33 0)
				(= local5 0)
				(if (and local35 (== (gCurRoom script:) local35))
					(local35 cue:)
				)
				(if (== (gCurRoom picture:) 140)
					(client dispose:)
				else
					(-- local20)
					(self dispose:)
				)
				(-- local2)
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
						(and local24 (Random 0 2))
						(and (not local24) (not (Random 0 100)))
					)
				)
				(getHit init:)
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

(instance getHit of Script
	(properties)

	(method (init)
		(cond
			((and (not (run register:)) local7 local33 (not register))
				(= register 1)
				(super init: &rest)
				(gTheDoits add: self)
			)
			((== local1 1)
				(Printf
					{can't init getHit: run register: %d (0)\nshooterReady: %d (1) shooterUp: %d (1) register %d (0)\n}
					(run register:)
					local7
					local33
					register
				)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(if (== register 2)
			(gSounds eachElementDo: #pause 0)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(++ local25)
					(localproc_5 926)
					(if (== (gCurRoom picture:) 140)
						(PalVary 8 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryNewSource
						(FrameOut)
						(PalVary 8 140) ; PalVaryNewSource
						(FrameOut)
					else
						(PalVary 9 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryMergeSource
						(FrameOut)
						(PalVary 3) ; PalVaryKill
						(FrameOut)
					)
					(= ticks 120)
				)
				(1
					(cond
						((localproc_3)
							(-- state)
							(= ticks 30)
						)
						((== local25 1)
							(gMessager say: 0 0 3 1 self) ; "You're hit, Carey. Lucky it's only a graze..."
						)
						((ResCheck 146 170 0 0 8 1) ; CHUNK
							(gMessager say: 0 0 8 1 self) ; "You're hit!"
						)
						(else
							(self cue:)
						)
					)
				)
				(2
					(if (== local25 local34)
						(gCurRoom setScript: egoDie)
					else
						(= register 0)
					)
					(self dispose:)
				)
			)
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
						setLoop: 2
						x: 230
						y: 95
						ignoreActors: 1
						setPri: 200
						init:
					)
				else
					(register
						view: 172
						setLoop: 1
						x: 145
						y: 101
						ignoreActors: 1
						setPri: 200
						init:
					)
				)
				(sfx number: 926 loop: 1 play:)
				(UpdateScreenItem register)
				(= cycles 2)
			)
			(2
				(register dispose:)
				(= ticks (Random 30 60))
			)
			(3
				(= register 0)
				(self init:)
			)
		)
	)
)

(instance shooter of Script
	(properties)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gGame handsOn:)
		(gTheIconBar disable: 0)
		(wall init:)
		(leftWindow init:)
		(sight init:)
		(rightWindow init:)
		(trunk170 init:)
		(LoadMany rsVIEW 173 174)
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
			priority: 4
			fixPriority: 1
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
		(if (not (Random 0 400))
			(getHit init:)
		)
		(if (not script)
			(cond
				((or (not local6) (and local10 (local10 isEmpty:)))
					(client setScript: resetter)
				)
				((and (not local33) (not local20))
					(reLoad doit:)
				)
			)
		else
			(script doit:)
		)
	)

	(method (dispose)
		(gTheIconBar enable: 0)
		(if local10
			(local10 release: dispose:)
			(= local10 0)
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (changeState))

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11)
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
					(gTheIconBar state: (| (gTheIconBar state:) $0004))
					(= local21 (event x:))
					(= local22 (event y:))
					(= register 1)
					(sight setScript: kill)
					(= local24 1)
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
								(event claimed: 1)
								(sight setScript: shootGunScr)
							)
							((= local8 ((gInventory at: 12) state:)) ; shotgun
								(= temp0 (- gMouseX (Random 2 8)))
								(= temp1 (+ gMouseX (Random 2 8)))
								(= temp2 (- gMouseX (Random 2 8)))
								(= temp3 (+ gMouseX (Random 2 8)))
								(= temp4 (- gMouseX (Random 2 8)))
								(= temp5 (+ gMouseX (Random 2 8)))
								(= temp6 (- gMouseY (Random 2 8)))
								(= temp7 (- gMouseY (Random 2 8)))
								(= temp8 (- gMouseY (Random 2 8)))
								(= temp9 (+ gMouseY (Random 2 8)))
								(= temp10 (+ gMouseY (Random 2 8)))
								(= temp11 (+ gMouseY (Random 2 8)))
								(= local9
									(if local7
										(or
											((bulletHole new:)
												init: temp0 temp6
											)
											((bulletHole new:)
												init: gMouseX temp7
											)
											((bulletHole new:)
												init: temp1 temp8
											)
											((bulletHole new:)
												init: temp2 gMouseY
											)
											((bulletHole new:)
												init: gMouseX gMouseY
											)
											((bulletHole new:)
												init: temp3 gMouseY
											)
											((bulletHole new:)
												init: temp4 temp9
											)
											((bulletHole new:)
												init: gMouseX temp10
											)
											((bulletHole new:)
												init: temp5 temp11
											)
										)
									)
								)
								(event claimed: 1)
								(sight setScript: shootShotgunScr)
							)
							(else
								(event claimed: 1)
								(sight setScript: emptyScr 0 1)
							)
						)
					else
						(event claimed: 1)
						(= register 0)
						(sight setScript: duck 0 1)
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

(instance emptyScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shooter register: 0)
				(localproc_0)
				(sfx number: 12 loop: 1 play:)
				(= ticks 35)
			)
			(1
				(if register
					(gMessager say: 0 23 1 0 self) ; "Carey, your shotgun has exhausted it's supply of 12 gauge shells!"
				else
					(gMessager say: 0 22 1 0 self) ; "Carey, you've run out rounds for your Beretta..."
				)
			)
			(2
				(if (== (gTheIconBar curInvIcon:) (gInventory at: 11)) ; handgun
					(localproc_1)
					(self dispose:)
				else
					(self setScript: duck self 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

