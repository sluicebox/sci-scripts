;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use Talker)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm801 0
	alien1Tkr 1
	alien2Tkr 2
)

(local
	local0
	local1
	local2 = 1300
	local3
	local4
	local5
	local6 = 1
	local7
	local8
	local9
	local10
	local11 = 1300
	[local12 4]
	local16 = -1
	local17
	local18
	local19
	local20
	local21
	local22
	[local23 3]
	local26
	local27
	[local28 50]
	[local78 9] = [4 5 6 7 8 9 10 11 12]
)

(procedure (localproc_0)
	(gGame handsOn:)
	(gTheIconBar disable: 0 3 4 5 6)
)

(procedure (localproc_1)
	(gSq5Music2 fade: 0 10 5 1)
	(= local26 0)
	(if (or local9 local10)
		(= local9 0)
		(= local10 0)
	else
		(return)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(if (< (+= local2 (* param1 2)) 0)
		(= local2 3599)
	)
	(if (> local2 3599)
		(= local2 0)
	)
	(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
		(if
			(and
				((= temp1 (gCast at: temp0)) isKindOf: FloatObj)
				(not (and (== temp1 cliffy) (IsFlag 87)))
			)
			(= temp5 local4)
			(= temp6 local5)
			(= temp3 (- (temp1 d3x:) temp5))
			(= temp4 (- (temp1 d3y:) temp6))
			(if (< (= temp2 (- 180 (GetAngle temp5 temp6 temp3 temp4))) 0)
				(+= temp2 360)
			)
			(if (> (= temp2 (- 450 temp2)) 359)
				(-= temp2 360)
			)
			(if (< (-= temp2 (/ local2 10)) 0)
				(= temp2 (+ 360 temp2))
			)
			(if (> temp2 359)
				(-= temp2 360)
			)
			(= temp7 (GetDistance temp5 temp6 temp3 temp4))
			(temp1 startUpd: x: (+ 160 (* (SinMult temp2 temp7) 4)))
			(switch temp1
				(cliffy
					(if (IsFlag 87)
						(cliffyBlip x: 158 y: 120)
					else
						(cliffyBlip
							x: (+ 158 (/ (SinMult temp2 temp7) 20))
							y: (- 120 (/ (CosMult temp2 temp7) 20))
						)
						(if (not (InRect 136 100 180 130 cliffyBlip))
							(cliffyBlip hide:)
						else
							(cliffyBlip show:)
						)
					)
				)
				(yourShip
					(shipBlip
						x: (+ 158 (/ (SinMult temp2 temp7) 20))
						y: (- 120 (/ (CosMult temp2 temp7) 20))
					)
					(if (not (InRect 136 100 180 130 shipBlip))
						(shipBlip hide:)
					else
						(shipBlip show:)
					)
				)
			)
			(if (< 90 temp2 270)
				(if (temp1 isNotHidden:)
					(temp1 hide:)
					(if (and (== temp1 cliffy) local21)
						(= local21 0)
						(target dispose:)
					)
				)
			else
				(if (not (temp1 isNotHidden:))
					(temp1 show:)
				)
				(switch temp1
					(cliffy
						(if
							(and
								(< (GetDistance temp5 temp6 temp3 temp4) 60)
								(<= 200 (cliffy x:) 210)
							)
							(= local18 1)
							(if (and (not (IsFlag 87)) (not local21))
								(= local21 1)
								(target init:)
							)
						else
							(= local18 0)
							(if local21
								(= local21 0)
								(target dispose:)
							)
						)
					)
					(yourShip
						(if (< (GetDistance temp5 temp6 temp3 temp4) 60)
							(= local19 1)
						else
							(= local19 0)
							(= local20 0)
						)
					)
				)
			)
			(if (< (= temp2 (- 220 (GetDistance temp5 temp6 temp3 temp4))) 1)
				(= temp2 1)
			)
			(if (> temp2 200)
				(= temp2 200)
			)
			(if (and (== temp1 cliffy) (> temp2 128))
				(= temp2 128)
			)
			(temp1 scaleX: temp2 scaleY: temp2 setPri: (/ temp2 44))
		)
	)
	(if (updateThrust client:)
		(updateThrust cue:)
	)
)

(procedure (localproc_3 param1 &tmp [temp0 3])
	(+= local4 (CosMult (/ local2 10) (/ param1 4)))
	(+= local5 (SinMult (/ local2 10) (/ param1 4)))
	(if (or (!= local16 (/ local4 300)) (!= local17 (/ local5 300)))
		(= local16 (/ local4 300))
		(= local17 (/ local5 300))
		(ast0 init: 0)
		(ast1 init: 1)
		(ast2 init: 2)
		(ast3 init: 3)
		(if (>= (gGame _detailLevel:) 2)
			(ast4 init: 4)
			(ast5 init: 5)
			(ast6 init: 6)
		)
		(if (>= (gGame _detailLevel:) 3)
			(ast7 init: 7)
			(ast8 init: 8)
		)
	)
)

(procedure (localproc_4)
	(if (and (!= local8 0) (not local26))
		(= local26 1)
		(gSq5Music2 number: 156 loop: -1 vol: 64 play:)
	)
	(switch local8
		(1
			(if (> local10 -6)
				(-= local10 1)
			)
			(if local10
				(-= local11 1)
			)
		)
		(2
			(if (< local10 6)
				(+= local10 1)
			)
			(if local10
				(-= local11 1)
			)
		)
		(3
			(if (< local9 10)
				(+= local9 1)
			)
			(if 10
				(-= local11 2)
			)
		)
		(4
			(if (> local9 -10)
				(-= local9 1)
			)
			(if 10
				(-= local11 2)
			)
		)
		(0
			(localproc_1)
		)
	)
	(fuel setCel: (- (fuel lastCel:) (/ local11 100)))
	(cond
		((and (== (fuel cel:) (fuel lastCel:)) (not (gCurRoom script:)))
			(= local10 0)
			(= local9 0)
			(gCurRoom setScript: outOfFuel)
		)
		((and local19 (not (gCurRoom script:)) (not local20))
			(if (not (IsFlag 87))
				(gCurRoom setScript: warning)
			else
				(gCurRoom setScript: returnToEureka)
			)
		)
		((not (gCurRoom script:))
			(localproc_3 local9)
			(localproc_2 local10)
		)
	)
)

(class FloatObj of Prop
	(properties
		priority 2
		signal 30736
		scaleSignal 1
		d3x 0
		d3y 0
	)
)

(class Asteroid of FloatObj
	(properties
		y 70
		view 272
		detailLevel 3
		oldD3x 0
		oldD3y 0
	)

	(method (init param1)
		(= d3y (+ (* local17 200) oldD3x))
		(= d3x (+ (* local16 200) oldD3y))
		(Random (/ (+ d3x (* 2 d3y)) 10))
		(if (not (gCast contains: self))
			(self setCycle: (if (Random 0 1) Fwd else Rev))
			(super init: &rest)
		)
		(if (>= (gGame _detailLevel:) detailLevel)
			(self startUpd:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: [local78 (= local27 (mod (++ local27) 9))] 1 0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance updateThrust of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(localproc_4)
			)
			(1
				(= cycles 2)
			)
			(2
				(hand1 stopUpd:)
				(lever1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance handCursor of Cursor
	(properties
		view 3270
		cel 6
	)

	(method (init)
		(cond
			((and (arm cel:) (InRect 203 124 226 149 gMouseX gMouseY))
				(= cel 5)
			)
			((hand2 onMe: gMouseX gMouseY)
				(= cel (if (arm cel:) 3 else 1))
			)
			((InRect 62 134 104 160 gMouseX gMouseY)
				(= cel 4)
			)
			((InRect 29 134 61 160 gMouseX gMouseY)
				(= cel 0)
			)
			((InRect 105 134 139 160 gMouseX gMouseY)
				(= cel 2)
			)
			((InRect 62 104 104 133 gMouseX gMouseY)
				(= cel 1)
			)
			((InRect 62 161 104 189 gMouseX gMouseY)
				(= cel 3)
			)
			(else
				(= cel 6)
			)
		)
		(super init: &rest)
	)
)

(instance rm801 of Rm
	(properties
		picture 48
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local7
						(local7 doVerb: 4)
					)
					((InRect 62 134 104 160 gMouseX gMouseY)
						(lever1 handleEvent: 0)
					)
					((InRect 29 134 61 160 gMouseX gMouseY)
						(lever1 handleEvent: 7)
					)
					((InRect 105 134 139 160 gMouseX gMouseY)
						(lever1 handleEvent: 3)
					)
					((InRect 62 104 104 133 gMouseX gMouseY)
						(lever1 handleEvent: 1)
					)
					((InRect 62 161 104 189 gMouseX gMouseY)
						(lever1 handleEvent: 5)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
		)
	)

	(method (doit)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 2))
			(handCursor init:)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 273 272 269 270 271 570 3270 3271 3272 3273)
		(gSq5Music1 number: 37 loop: -1 play:)
		(if (Message msgSIZE 801 32 0 0 1) ; "Target In Range"
			(Message msgGET 801 32 0 0 1 @local28) ; "Target In Range"
		else
			(Format @local28 {%s} {Need Message})
		)
		(if (== gPrevRoomNum 100)
			(gEgo get: 9) ; Oxygen_Tank
		)
		((gTheIconBar at: 2) cursor: handCursor)
		(radar init: setOnMeCheck: 1 8)
		(headsUp init: setOnMeCheck: 1 32)
		(directions init: setOnMeCheck: 1 2)
		(fuelF init: setOnMeCheck: 1 16)
		(oxygenF init: setOnMeCheck: 1 4)
		(= local22
			(cond
				((== global137 2) 1)
				((not (gEgo has: 9)) 2) ; Oxygen_Tank
				(else 0)
			)
		)
		(arm init: stopUpd:)
		(lever1 init: stopUpd:)
		(lever2 init: stopUpd:)
		(hand1 init: stopUpd:)
		(hand2 init: stopUpd:)
		(lthrust init:)
		(rthrust init:)
		(fthrust init:)
		(bthrust init:)
		(if (gEgo has: 9) ; Oxygen_Tank
			(gEgo put: 9) ; Oxygen_Tank
		)
		(oxygen init: setScript: losingAir)
		(fuel init:)
		(clawButton init: setOnMeCheck: 26505)
		(cliffy init: setScript: breathing)
		(yourShip init: stopUpd:)
		(cliffyBlip init: setCycle: Fwd)
		(shipBlip init: setCycle: Fwd)
		(localproc_3 0)
		(localproc_2 0)
		(gDirectionHandler addToFront: lever1)
		(self setScript: startItAll)
	)

	(method (dispose)
		(PalVary pvUNINIT)
		(Palette palSET_FROM_RESOURCE 999 2)
		(gDirectionHandler delete: lever1)
		((gTheIconBar at: 2) cursor: 982)
		(super dispose: &rest)
	)
)

(instance ast0 of Asteroid
	(properties
		y 52
		noun 4
		d3x 100
		d3y 100
		oldD3x 100
		oldD3y 100
	)
)

(instance ast1 of Asteroid
	(properties
		y 59
		noun 5
		loop 2
		d3x 100
		d3y -100
		oldD3x 100
		oldD3y -100
	)
)

(instance ast2 of Asteroid
	(properties
		y 38
		noun 6
		loop 6
		d3y 300
		oldD3y 300
	)
)

(instance ast3 of Asteroid
	(properties
		y 43
		noun 7
		d3x -100
		d3y -100
		oldD3x -100
		oldD3y -100
	)
)

(instance ast4 of Asteroid
	(properties
		y 34
		noun 8
		loop 2
		d3x -150
		d3y 75
		oldD3x -150
		oldD3y 75
	)
)

(instance ast5 of Asteroid
	(properties
		y 50
		noun 9
		loop 6
		d3x 300
		d3y 200
		oldD3x 300
		oldD3y 200
	)
)

(instance ast6 of Asteroid
	(properties
		y 36
		noun 10
		d3x 200
		oldD3x 200
	)
)

(instance ast7 of Asteroid
	(properties
		y 22
		noun 11
		loop 2
		d3y -200
		oldD3y -200
	)
)

(instance ast8 of Asteroid
	(properties
		y 28
		noun 12
		loop 6
		d3x -200
		oldD3x -200
	)
)

(instance yourShip of FloatObj
	(properties
		y 60
		noun 20
		view 272
		loop 5
		d3y -200
	)
)

(instance cliffy of FloatObj
	(properties
		y 90
		noun 17
		view 272
		loop 1
		d3x 200
	)
)

(instance arm of Prop
	(properties
		x 319
		y 27
		noun 3
		view 269
		priority 6
		signal 20496
		cycleSpeed 12
	)
)

(instance claw of Prop
	(properties
		x 216
		y 81
		noun 15
		view 269
		loop 1
		priority 6
		signal 20496
		cycleSpeed 12
	)
)

(instance lever1 of Prop
	(properties
		x 54
		y 135
		noun 31
		view 270
		cel 1
		signal 16384
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			(
				(and
					(not script)
					(gUser canControl:)
					(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(InRect 29 104 139 189 gMouseX gMouseY)
					(not (IsObject event))
				)
				(= temp0 event)
				(self startUpd:)
				(hand1 startUpd:)
				(switch temp0
					(7
						(self x: 50 y: 135)
						(= temp1 1)
					)
					(3
						(self x: 59 y: 135)
						(= temp1 2)
					)
					(1
						(self x: 54 y: 130)
						(= temp1 3)
					)
					(5
						(self x: 54 y: 140)
						(= temp1 4)
					)
					(0
						(self x: 54 y: 135)
						(= temp1 0)
					)
				)
				(if (!= temp1 local8)
					(if (!= local8 0)
						(self x: 54 y: 135)
						(= local8 0)
					else
						(= local8 temp1)
					)
				)
				(self forceUpd: setScript: updateThrust)
				(return 1)
			)
			((IsObject event)
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doit &tmp [temp0 3])
		(if (!= local8 0)
			(localproc_4)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lever2 of View
	(properties
		x 270
		y 135
		noun 2
		view 270
		loop 1
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 87)
					(gMessager say: noun 4 2 0) ; "Retracting the arm now would be unwise: You might damage your chief engineer."
				else
					(gCurRoom setScript: operateArm)
				)
			)
		)
	)
)

(instance hand1 of View
	(properties
		y 125
		noun 24
		view 270
		priority 15
		signal 16400
	)

	(method (doit)
		(self x: (- (lever1 x:) 54) y: (- (lever1 y:) 10))
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom doVerb: 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance hand2 of View
	(properties
		x 322
		y 124
		noun 28
		view 270
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(lever2 doVerb: theVerb &rest)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance lthrust of Prop
	(properties
		x 144
		y 169
		noun 25
		view 271
		loop 8
		signal 16384
	)

	(method (doit)
		(cond
			((== local8 1)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler))
				(self setCycle: Beg)
			)
		)
		(super doit: &rest)
	)
)

(instance rthrust of Prop
	(properties
		x 176
		y 169
		noun 30
		view 271
		loop 9
		signal 16384
	)

	(method (doit)
		(cond
			((== local8 2)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler))
				(self setCycle: Beg)
			)
		)
		(super doit: &rest)
	)
)

(instance fthrust of Prop
	(properties
		x 156
		y 159
		noun 21
		view 271
		loop 10
		signal 16384
	)

	(method (doit)
		(cond
			((== local8 3)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler))
				(self setCycle: Beg)
			)
		)
		(super doit: &rest)
	)
)

(instance bthrust of Prop
	(properties
		x 155
		y 175
		noun 13
		view 271
		loop 11
		signal 16384
	)

	(method (doit)
		(cond
			((== local8 4)
				(if (and (!= cel (self lastCel:)) (not cycler))
					(self setCycle: End)
				)
			)
			((and cel (not cycler))
				(self setCycle: Beg)
			)
		)
		(super doit: &rest)
	)
)

(instance oxygen of Prop
	(properties
		x 125
		y 112
		noun 26
		view 271
		loop 1
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self
			setCel:
				(if local22
					(- (self lastCel:) 1)
				else
					0
				)
		)
	)
)

(instance fuel of Prop
	(properties
		x 186
		y 112
		noun 22
		view 271
		priority 15
		signal 16400
	)
)

(instance cliffyBlip of Prop
	(properties
		noun 16
		view 272
		loop 3
		priority 7
		signal 16400
	)
)

(instance shipBlip of Prop
	(properties
		noun 19
		view 272
		loop 4
		priority 7
		signal 16400
	)
)

(instance target of Prop
	(properties
		view 272
		loop 7
		priority 14
		signal 16400
		detailLevel 3
	)

	(method (doit)
		(self x: (- (cliffy x:) 20) y: (- (cliffy y:) 34))
		(if local21
			(Display
				@local28
				dsFONT
				gUserFont
				dsCOORD
				65
				25
				dsCOLOR
				(if (= local1 (not local1)) global154 else global153)
			)
		)
		(super doit: &rest)
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(Display @local28 dsFONT gUserFont dsCOORD 65 25 dsCOLOR global153)
	)

	(method (dispose)
		(Display @local28 dsFONT gUserFont dsCOORD 65 25 dsCOLOR global151)
		(super dispose: &rest)
	)
)

(instance radar of Feature
	(properties
		y 10
		noun 27
		onMeCheck 8
	)
)

(instance headsUp of Feature
	(properties
		y 5
		noun 23
		onMeCheck 32
	)
)

(instance directions of Feature
	(properties
		y 200
		noun 18
		onMeCheck 2
	)
)

(instance fuelF of Feature
	(properties
		y 100
		noun 22
		onMeCheck 16
	)
)

(instance oxygenF of Feature
	(properties
		y 100
		noun 26
		onMeCheck 4
	)
)

(instance clawButton of Feature
	(properties
		y 200
		noun 14
		nsTop 124
		nsLeft 203
		nsBottom 149
		nsRight 226
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 87)
						(gMessager say: noun 4 2 0) ; "Not a good idea. That claw is strong enough to crush Cliffy like a tin can."
					)
					((arm cel:)
						(arm setScript: operateClaw)
					)
					(else
						(arm setScript: operateArm)
					)
				)
			)
		)
	)
)

(instance operateArm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lever2 startUpd:)
				(hand2 startUpd:)
				(= cycles 3)
			)
			(1
				(if (== (lever2 y:) 135)
					(lever2 y: 130)
					(hand2 y: 119)
				else
					(hand2 y: 124)
					(lever2 y: 135)
				)
				(= cycles 2)
			)
			(2
				(gSq5Music2 number: 106 loop: 1 play:)
				(if (== (lever2 y:) 130)
					(arm setCycle: CT 6 1 self)
					(lever2 y: 130)
					(hand2 y: 119)
				else
					(if (claw cel:)
						(claw setCycle: Beg self)
					else
						(= cycles 2)
					)
					(hand2 y: 124)
					(lever2 y: 135)
				)
			)
			(3
				(if (== (lever2 y:) 135)
					(claw dispose:)
					(arm setCel: 6 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(4
				(lever2 stopUpd:)
				(hand2 stopUpd:)
				(if (== (lever2 y:) 130)
					(claw init: stopUpd:)
					(arm setCel: 7)
				)
				(arm stopUpd:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance operateClaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(claw startUpd:)
				(= cycles 2)
			)
			(1
				(gSq5Music2 number: 108 loop: 1 play:)
				(if (claw cel:)
					(if (and local18 (<= 200 (cliffy x:) 210))
						(SetFlag 87)
						(= local21 0)
						(target dispose:)
						(claw setCel: (- (claw lastCel:) 1))
						(= cycles 2)
					else
						(claw setCycle: Beg self)
					)
				else
					(claw setCycle: End self)
				)
			)
			(2
				(if (IsFlag 87)
					(self setScript: getCliffy self)
				else
					(= cycles 1)
				)
			)
			(3
				(claw stopUpd:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance getCliffy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(claw setCel: (- (claw lastCel:) 1))
				(= cycles 2)
			)
			(1
				(SetScore 192 100)
				(UnLoad 128 273)
				(cliffy
					view: 272
					loop: 1
					cel: 0
					setPri: (- (claw priority:) 1)
					stopUpd:
				)
				(gMessager say: 2 0 2 0 self) ; "Cliffy has been successfully grappled. Now all that remains is to make it back to the Eureka... if you can find it."
			)
			(2
				(cliffy addToPic:)
				(claw addToPic:)
				(arm addToPic:)
				(hand2 addToPic:)
				(lever2 addToPic:)
				(self dispose:)
			)
		)
	)
)

(instance losingAir of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 20)
			)
			(1
				(if (!= (oxygen cel:) (oxygen lastCel:))
					(oxygen setCel: (+ (oxygen cel:) 1))
					(if (and (> (oxygen cel:) 9) (!= (theMusic3 number:) 282))
						(theMusic3 number: 282 loop: -1 play:)
					)
					(= state -1)
				)
				(if (not (breathing state:))
					(breathing seconds: 1)
				)
				(= cycles 1)
			)
			(2
				(gGame handsOff:)
				(gSq5Music1 fade: 0 10 5 1)
				(gSq5Music2 stop:)
				(switch local22
					(0
						(gMessager say: 26 0 3 0 self) ; "The tightness in your lungs and throat, along with the ''zero'' reading on the oxygen gauge, leads to the inescapable conclusion that you were a fool and spent too much time screwing around wasting your air."
					)
					(1
						(gMessager say: 26 0 5 0 self) ; "It might help to bring along a fully recharged oxygen tank."
					)
					(2
						(gMessager say: 26 0 4 0 self) ; "As the last wisps of oxygen filter through the pods life support system you try to yell for help, but the only sound that escapes your throat is a loud burping sound. As the world fades to black, you know your doomed is sealed: In space, no one can hear you belch."
					)
				)
			)
			(3
				((gTheIconBar at: 2) cursor: 982)
				(PalVary pvUNINIT)
				(aliens register: (if (== local22 2) 13 else 14))
				(gCurRoom setScript: aliens)
				(self dispose:)
			)
		)
	)
)

(instance breathing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (* (- 14 (oxygen cel:)) 2))
			)
			(1
				(theMusic4 number: 550 loop: 1 play:)
				(-= state 2)
				(= seconds 1)
			)
		)
	)
)

(instance outOfFuel of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((gTheIconBar at: 2) cursor: 982)
				(gSq5Music1 fade: 0 10 5 1)
				(gSq5Music2 stop:)
				(PalVary pvINIT 48 5)
				(= register 30)
				(= cycles 1)
			)
			(1
				(for ((= temp1 0)) (< temp1 (gCast size:)) ((++ temp1))
					(if
						(and
							((= temp0 (gCast at: temp1)) isKindOf: FloatObj)
							(not (and (== temp0 cliffy) (IsFlag 87)))
						)
						(temp0 startUpd: y: (- (temp0 y:) 2))
					)
				)
				(if (-- register)
					(-- state)
				)
				(= cycles 2)
			)
			(2
				(gMessager say: 22 0 3 0 self) ; "If this pod ran on stupidity you'd have nothing to worry about. As it is, you've exhausted your fuel supply and are caught in the gravity well of a nearby planet. The rest of your life should prove to be short but exciting."
			)
			(3
				((gTheIconBar at: 2) cursor: 982)
				(aliens register: 16)
				(PalVary pvUNINIT)
				(gCurRoom setScript: aliens)
				(self dispose:)
			)
		)
	)
)

(instance startItAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(hand1 setCel: 2)
				(hand2 setCel: 2)
				(= cycles 3)
			)
			(2
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance warning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 29 0 7 0 self) ; "Aren't you forgetting one tiny little detail like oh maybe..., lets say..., hmmm..., maybe... |f8|cliffy?!|f|"
				(= local20 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance returnToEureka of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetScore 193 50)
				(gMessager say: 29 0 6 0 self) ; "Good flying ace! You've returned to the safety of the Eureka."
				(gSq5Music1 fade: 0 10 5 1)
			)
			(1
				((gTheIconBar at: 2) cursor: 982)
				(= global137 2)
				(gSq5Music1 stop:)
				(gSq5Music2 stop:)
				(theMusic3 stop:)
				(gCurRoom newRoom: 250)
			)
		)
	)
)

(instance shootingStar of Actor
	(properties
		x 233
		y 42
		view 570
		priority 1
		signal 24592
		moveSpeed 1
	)
)

(instance aliens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 stop:)
				(theMusic3 stop:)
				(theMusic4 stop:)
				(gCast eachElementDo: #hide)
				(PalVary pvUNINIT)
				(target dispose:)
				(= cycles 3)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 56 -32758)
				(= seconds 3)
			)
			(2
				(shootingStar
					init:
					setCycle: Fwd
					setMotion: MoveTo 153 167 self
				)
			)
			(3
				(gMessager say: 1 2 1 0 self) ; "Ah look, Crumpella, a shooting star. Make a wish."
			)
			(4
				(EgoDead register)
			)
		)
	)
)

(instance alien1Tkr of Narrator
	(properties
		talkWidth 100
	)

	(method (init)
		(= gSystemWindow gSpeakWindow)
		(= font gUserFont)
		(gSystemWindow tailX: 80 xOffset: -20 tailY: 80 isBottom: 1)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance alien2Tkr of Narrator
	(properties
		talkWidth 100
	)

	(method (init)
		(= gSystemWindow gSpeakWindow)
		(= font gUserFont)
		(gSystemWindow tailX: 180 xOffset: 20 isBottom: 1 tailY: 80)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance theMusic4 of Sound
	(properties)
)

