;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n370)
(use Submarine_806)
(use DigitalGauge)
(use Cat)
(use Sight)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	controlPanel 0
	tV 1
	mBut 2
	butSnd 3
)

(local
	local0
	local1
	local2
	local3
	[local4 6] = [5 0 5 20 40 60]
)

(procedure (localproc_0 param1)
	(if param1
		(silentRunInd setCycle: sVForward)
		(Submarine flags: (| (Submarine flags:) $0040))
		(self setCel: 2)
	else
		(silentRunInd setCycle: sVEndLoop silentRunInd)
		(self setCel: 1)
		(Submarine flags: (& (Submarine flags:) $ffbf))
	)
)

(instance controlPanel of Rm
	(properties
		picture 27
		horizon 1
	)

	(method (dispose)
		(proc0_3)
		(gIceKeyDownHandler delete: mBut bBut sonarSwitch silentSwitch)
		(= gSpeed local2)
		(depthDG dispose:)
		(speedDG dispose:)
		(tempDG dispose:)
		(rpmDG dispose:)
		(compassDG dispose:)
		(latDG dispose:)
		(longDG dispose:)
		(hourDG dispose:)
		(minuteDG dispose:)
		(super dispose:)
		(DisposeScript 816)
		(DisposeScript 808)
	)

	(method (init &tmp temp0)
		(= global133 59)
		(= global134 17)
		(= global135 21)
		(Submarine lastH: 21 lastM: global134)
		(engSnd init:)
		(butSnd init:)
		(tV init:)
		(super init:)
		(= local2 gSpeed)
		(wheel init: posn: (Submarine wheelX:))
		(gIceDirectionHandler add: wheel)
		(HandsOn)
		(sqSon init: setCel: 16)
		(vSLine1 init:)
		(vSLine2 init:)
		(if global132
			(scanPanelBlip init: setScript: scanLightsScript)
		)
		(mBut init:)
		(bBut init:)
		(bBORide init:)
		(strnBORide init:)
		(pbORide init:)
		(sbORide init:)
		(bBalLights init:)
		(strnBalLights init:)
		(pBalLights init:)
		(sBalLights init:)
		(bowPIndBot init:)
		(bowPIndTop init:)
		(sternPIndTop init:)
		(sternPIndBot init:)
		(bankTurnInd init:)
		(diveLever init: posn: 277 (Submarine diveLeverY:))
		(gIceDirectionHandler add: diveLever)
		(engineLever init:)
		(rpmLights init:)
		(sonarSwitch init:)
		(if (& (Submarine flags:) $0080)
			(sonarSwitch
				handleEvent: ((= temp0 (Event new:)) type: evKEYBOARD message: $5600)
			)
			(temp0 dispose:)
		)
		(silentSwitch init:)
		(diveIndLights init: stopUpd:)
		(hatch1Ind init:)
		(eBalGauge init:)
		(ebs init: hide:)
		(mapDisplay init: setPri: 12)
		(tB1 init:)
		(tB2 init:)
		(tB3 init:)
		(tB4 init:)
		(compassNeedle init:)
		(Load rsFONT 100)
		(hatch1Ind init: setCel: (if (& (Submarine flags:) $0008) 3 else 4))
		(silentRunInd init:)
		((ScriptID 366 0) init:) ; fCPanel
		((ScriptID 366 1) init: hide:) ; missleSelector
		(gIceKeyDownHandler add: mBut bBut sonarSwitch silentSwitch (ScriptID 366 0)) ; fCPanel
		(self replay: setRegions: 314) ; subMarine
		(switch (((ScriptID 314) script:) state:) ; subMarine
			(0
				(Submarine flags: (| (Submarine flags:) $0008))
				(subMarine cue:)
				(self setScript: (ScriptID 373)) ; pearlScript
			)
			(5
				(self setScript: (ScriptID 349)) ; firstCodedMsg
			)
			(6
				(self setScript: (ScriptID 347)) ; secondCoordsScript
			)
			(8
				(subMarine cue: 1)
				(ScriptID 396)
				(self setScript: (ScriptID 348)) ; battleShip
			)
			(11
				(self setScript: (ScriptID 344)) ; iceStationScript
			)
			(12
				(subMarine cue:)
				(ScriptID 396)
				(self setScript: (ScriptID 397)) ; russianSub
			)
			(13
				(ScriptID 396)
				(self setScript: (ScriptID 397)) ; russianSub
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'stand,exit,exit,get[<up][/room,panel]')
				(DisposeScript 370)
				(self newRoom: 25) ; controlRm
			)
			((Said 'look/panel,control')
				(Print 27 0) ; "The panels before you control and monitor those systems necessary for the operation of the submarine."
				(Print 27 1) ; "The documentation included in the packaging of this product explains the function of each instrument on the "Control Panel.""
			)
			((Said 'close/hatch')
				(if (& (Submarine flags:) $0008)
					(Print 27 2) ; "Using the pa system you order the hatches closed."
					(Submarine flags: (& $fff7 (Submarine flags:)))
					(hatch1Ind setCel: 4)
				else
					(Print 27 3) ; "The hatches are closed"
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(depthDG doit:)
		(speedDG doit:)
		(tempDG doit:)
		(rpmDG doit:)
		(compassDG doit:)
		(latDG doit:)
		(longDG doit:)
		(if (== ((= temp0 (User curEvent:)) type:) evKEYBOARD)
			(engineLever handleEvent: temp0)
		)
	)

	(method (replay)
		(proc370_0)
		(PicNotValid 1)
		(depthDG init: Submarine 352)
		(speedDG init: Submarine 358)
		(rpmDG init: Submarine 362)
		(tempDG init: Submarine 369)
		(hourDG init: Submarine 370)
		(minuteDG init: Submarine 371)
		(compassDG init: Submarine 353)
		(latDG init: Submarine 364)
		(longDG init: Submarine 363)
	)
)

(instance srForward of Fwd ; UNUSED
	(properties)
)

(instance butSnd of Sound
	(properties
		number 47
		priority 3
	)
)

(instance engSnd of Sound
	(properties
		number 54
		priority 2
	)
)

(instance depthDG of DigitalGauge
	(properties
		x 245
		y 36
	)
)

(instance tempDG of DigitalGauge
	(properties
		x 245
		y 46
	)
)

(instance hourDG of DigitalGauge
	(properties
		x 232
		y 56
	)
)

(instance minuteDG of DigitalGauge
	(properties
		x 245
		y 56
	)
)

(instance speedDG of DigitalGauge
	(properties
		x 245
		y 66
	)
)

(instance rpmDG of DigitalGauge
	(properties
		x 245
		y 76
	)
)

(instance compassDG of DigitalGauge
	(properties
		x 77
		y 90
	)
)

(instance latDG of DigitalGauge
	(properties
		x 124
		y 108
	)
)

(instance longDG of DigitalGauge
	(properties
		x 157
		y 108
	)
)

(instance wheel of Cat
	(properties
		y 163
		x 158
		view 127
		loop 8
		cel 6
		priority 15
		signal 16
	)

	(method (dispose)
		(gIceDirectionHandler delete: self)
		(Submarine wheelX: x)
		(super dispose:)
	)

	(method (posn param1 &tmp temp0)
		(cond
			((<= param1 109)
				(= x 109)
				(= y 188)
				(= cel 0)
			)
			((<= param1 122)
				(= x 122)
				(= y 178)
				(= cel 1)
			)
			((<= param1 125)
				(= x 125)
				(= y 175)
				(= cel 2)
			)
			((<= param1 128)
				(= x 128)
				(= y 171)
				(= cel 3)
			)
			((<= param1 136)
				(= x 136)
				(= y 167)
				(= cel 4)
			)
			((<= param1 144)
				(= x 144)
				(= y 165)
				(= cel 5)
			)
			((<= param1 158)
				(= x 158)
				(= y 163)
				(= cel 6)
			)
			((<= param1 174)
				(= x 174)
				(= y 165)
				(= cel 7)
			)
			((<= param1 181)
				(= x 181)
				(= y 167)
				(= cel 8)
			)
			((<= param1 189)
				(= x 189)
				(= y 171)
				(= cel 9)
			)
			((<= param1 192)
				(= x 192)
				(= y 175)
				(= cel 10)
			)
			(else
				(= x 204)
				(= y 187)
				(= cel 11)
			)
		)
		(super posn: x y)
		(Submarine turn: (- (AngleDiff 0 (GetAngle 158 215 x y))))
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event message:)
			(JOY_LEFT
				(self posn: (- x 16))
			)
			(JOY_RIGHT
				(self posn: (+ x 14))
			)
		)
	)
)

(instance sqSon of Prop
	(properties
		y 84
		x 210
		view 27
		priority 12
		signal 17
	)

	(method (cue)
		(self cel: 0 setCycle: sSEndLoop)
	)
)

(instance sSEndLoop of End
	(properties)
)

(instance sonarSwitch of View
	(properties
		y 159
		x 193
		view 227
		loop 3
		cel 3
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event) (== (event message:) $5600))
				(event claimed: 1)
				(butSnd number: (proc0_5 47) play:)
				(if (== cel 3)
					(self setCel: 4)
					(gIceGlobalSound number: 43 play: sqSon)
					(sqSon setCycle: swEndLoop)
					(vSLine1 setScript: vSonarScript)
					(Submarine flags: (| (Submarine flags:) $0080))
				else
					(self setCel: 3)
					(gIceGlobalSound client: 0 number: 11 play:)
					(sqSon setCel: 16 stopUpd:)
					(vSLine1 setScript: 0 hide:)
					(vSLine2 hide:)
					(Submarine flags: (& (Submarine flags:) $ff7f))
				)
			)
		)
	)
)

(instance swEndLoop of End
	(properties)
)

(instance vSonarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(vSLine1 y: 46 show: setCycle: topScanCycle)
				(vSLine2 y: 46 show: setCycle: bottomScanCycle)
				(= cycles 2)
			)
			(1
				(vSLine1 setMotion: vS1MoveTo (vSLine1 x:) 36 self)
				(vSLine2 setMotion: vS2MoveTo (vSLine2 x:) 56 self)
			)
			(2)
			(3
				(self init:)
			)
		)
	)
)

(instance vS1MoveTo of MoveTo
	(properties)
)

(instance vS2MoveTo of MoveTo
	(properties)
)

(instance bottomScanCycle of Cycle
	(properties)

	(method (doit)
		(if
			(>
				(* (- (client y:) 46) 10)
				(- (Submarine floor:) (Submarine _depth:))
			)
			(client cel: 2)
		else
			(client cel: 1)
		)
	)
)

(instance topScanCycle of Cycle
	(properties)

	(method (doit)
		(if
			(>
				(* (- 46 (client y:)) 10)
				(- (Submarine _depth:) (Submarine ceiling:))
			)
			(client cel: 3)
		else
			(client cel: 1)
		)
	)
)

(instance silentSwitch of View
	(properties
		y 157
		x 204
		view 227
		loop 3
		cel 1
	)

	(method (init)
		(super init:)
		(localproc_0 (& (Submarine flags:) $0040))
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event) (== (event message:) $5700))
				(butSnd number: (proc0_5 47) play:)
				(localproc_0 (!= cel 2))
				(event claimed: 1)
			)
		)
	)
)

(instance sVForward of Fwd
	(properties)
)

(instance sVEndLoop of End
	(properties)
)

(instance vSLine1 of Act
	(properties
		y 46
		x 225
		view 27
		loop 2
		cel 1
		priority 13
		signal 18449
	)
)

(instance vSLine2 of Act
	(properties
		y 46
		x 225
		view 27
		loop 2
		cel 1
		priority 13
		signal 18449
	)
)

(instance scanPanelBlip of Act
	(properties
		y 129
		x 123
		view 27
		loop 5
		cel 5
		priority 12
		signal 18448
		illegalBits 0
	)
)

(instance scanLightsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setMotion: sLMoveTo 186 (client y:) self)
			)
			(1
				(client posn: 123 129)
				(self init:)
			)
		)
	)
)

(instance sLMoveTo of MoveTo
	(properties)
)

(instance mBut of View
	(properties
		y 144
		x 117
		view 27
		loop 5
		priority 11
		signal 273
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event) (== (event message:) $5400))
				(event claimed: 1)
				(butSnd number: (proc0_5 47) play:)
				(if (== cel 0)
					(self setCel: 1)
					(if ((ScriptID 366 0) cel:) ; fCPanel
						((ScriptID 366 0) setCycle: Beg (ScriptID 366 0)) ; fCPanel, fCPanel
						(bBut setCel: 0)
					)
					(if (== ((subMarine script:) state:) 11)
						(tV setCel: 0 setPri: 0)
					else
						(tV setCel: 2 setPri: 15)
					)
				else
					(self setCel: 0)
					(tV setCel: 4 setPri: 13)
				)
			)
		)
	)
)

(instance bBut of View
	(properties
		y 156
		x 127
		view 27
		loop 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MousedOn self event) (== (event message:) $5500))
				(event claimed: 1)
				(butSnd number: (proc0_5 47) play:)
				(if (== cel 0)
					(self setCel: 1)
					((ScriptID 366 0) setCycle: End (ScriptID 366 0)) ; fCPanel, fCPanel
					(mBut setCel: 0)
				else
					(self setCel: 0)
					((ScriptID 366 0) setCycle: Beg (ScriptID 366 0)) ; fCPanel, fCPanel
				)
			)
		)
	)
)

(instance bBORide of View
	(properties
		y 112
		x 226
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance strnBORide of View
	(properties
		y 117
		x 222
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance pbORide of View
	(properties
		y 122
		x 218
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance sbORide of View
	(properties
		y 127
		x 214
		view 127
		loop 5
		cel 1
		priority 11
	)
)

(instance bBalLights of Prop
	(properties
		y 117
		x 237
		view 127
		loop 6
		priority 12
		signal 16
		cycleSpeed 10
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance strnBalLights of Prop
	(properties
		y 122
		x 233
		view 127
		loop 6
		priority 12
		signal 16
		cycleSpeed 10
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance pBalLights of Prop
	(properties
		y 127
		x 229
		view 127
		loop 6
		priority 12
		signal 16
		cycleSpeed 10
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance sBalLights of Prop
	(properties
		y 132
		x 225
		view 127
		loop 6
		priority 12
		signal 16
		cycleSpeed 10
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance bowPIndBot of Prop
	(properties
		y 117
		x 104
		view 27
		loop 7
		priority 12
		signal 17
	)

	(method (doit &tmp temp0)
		(self cel: (and (> (= temp0 (Submarine pitch:)) 0) (Abs (/ temp0 6))))
		(super doit:)
	)
)

(instance bowPIndTop of Prop
	(properties
		y 115
		x 101
		view 27
		loop 6
		priority 12
		signal 17
	)

	(method (doit &tmp temp0)
		(self cel: (and (< (= temp0 (Submarine pitch:)) 0) (Abs (/ temp0 6))))
		(super doit:)
	)
)

(instance sternPIndBot of Prop
	(properties
		y 117
		x 201
		view 27
		loop 9
		priority 12
		signal 17
	)

	(method (doit &tmp temp0)
		(self cel: (and (< (= temp0 (Submarine pitch:)) 0) (Abs (/ temp0 6))))
		(super doit:)
	)
)

(instance sternPIndTop of Prop
	(properties
		y 115
		x 202
		view 27
		loop 8
		priority 12
		signal 16
	)

	(method (doit &tmp temp0)
		(self cel: (and (> (= temp0 (Submarine pitch:)) 0) (Abs (/ temp0 6))))
		(super doit:)
	)
)

(instance bankTurnInd of Act
	(properties
		y 146
		x 156
		yStep 1
		view 227
		loop 1
		cel 4
		priority 12
		signal 18449
		cycleSpeed 4
		illegalBits 0
		moveSpeed 4
	)

	(method (cue)
		(if (not (or cycler mover))
			(self stopUpd:)
		)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (!= local0 (Submarine roll:))
			(bankTurnInd
				setCycle:
					tBCycleTo
					(= temp0 (+ (/ (Submarine roll:) 10) 4))
					(sign (- temp0 cel))
					self
			)
			(= local0 (Submarine roll:))
		)
		(if (!= local1 (Submarine pitch:))
			(self
				setMotion:
					tBMoveTo
					156
					(+ 146 (/ (Submarine pitch:) 10))
					bankTurnInd
			)
			(= local1 (Submarine pitch:))
		)
	)
)

(instance tBCycleTo of CT
	(properties)
)

(instance tBMoveTo of MoveTo
	(properties)
)

(instance silentRunInd of Prop
	(properties
		y 161
		x 196
		view 227
		loop 4
		priority 12
		cycleSpeed 2
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance diveLever of Cat
	(properties
		y 144
		x 277
		view 227
		loop 6
		cel 3
		priority 12
		signal 16
		top 139
		left 266
		bottom 149
		right 287
		diagonal -2
	)

	(method (dispose)
		(gIceDirectionHandler delete: self)
		(Submarine diveLeverY: y)
		(super dispose:)
	)

	(method (posn &tmp [temp0 2])
		(super posn: &rest)
		(self cel: (/ (- (- right x) 1) 3))
		(Submarine dive: cel)
		(diveIndLights
			setCycle:
				dICycleTo
				cel
				(- (* 2 (> cel (diveIndLights cel:))) 1)
				diveIndLights
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(switch (event message:)
			(JOY_UP
				(self posn: x (- y 2))
			)
			(JOY_DOWN
				(self posn: x (+ y 2))
			)
		)
	)
)

(instance dICycleTo of CT
	(properties)
)

(instance diveIndLights of Prop
	(properties
		y 180
		x 285
		view 227
		loop 5
		cycleSpeed 3
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance engineLever of Cat
	(properties
		y 177
		x 238
		view 127
		loop 9
		cel 2
		priority 13
		top 172
		left 229
		bottom 183
		right 244
		diagonal -2
	)

	(method (init)
		(super init: &rest)
		(self posn: 244 (Submarine throttleY:) setPri: priority caller: self)
		(gIceKeyDownHandler add: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(Submarine throttleY: y)
		(super dispose:)
	)

	(method (posn)
		(super posn: &rest)
		(self cel: (/ (- (- bottom y) 1) 2))
		(Submarine throttle: (- cel 1))
		(rpmLights setCel: cel)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_ADD
					(self posn: x (- y 2))
					(self cue:)
				)
				(KEY_SUBTRACT
					(self posn: x (+ y 2))
					(gGame setSpeed: 0)
					(self cue:)
				)
			)
		)
	)

	(method (cue &tmp temp0)
		(if
			(and
				(mod
					(= temp0
						(proc0_5
							(cond
								(
									(<
										[local4 (+ (Submarine throttle:) 1)]
										(Abs (Submarine hSpeed:))
									)
									55
								)
								(
									(>
										[local4 (+ (Submarine throttle:) 1)]
										(Abs (Submarine hSpeed:))
									)
									54
								)
							)
						)
					)
					200
				)
				(not (and (== temp0 (engSnd number:)) (== (engSnd state:) 3)))
			)
			(engSnd number: temp0 play:)
		)
	)
)

(instance rpmLights of View
	(properties
		y 167
		x 205
		view 427
		loop 4
	)
)

(instance hatch1Ind of View
	(properties
		y 135
		x 38
		view 427
		loop 3
		cel 4
		priority 12
		signal 273
	)
)

(instance eBalGauge of Prop
	(properties
		y 156
		x 25
		view 427
		loop 6
		priority 12
		cycleSpeed 8
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance ebs of View
	(properties
		y 163
		x 29
		view 427
		loop 5
		cel 1
		priority 12
		signal 273
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MousedOn self event)
				(if (& signal $0080)
					(self show:)
					(eBalGauge setCycle: End eBalGauge)
					(Submarine emergencyBallast: 0)
					(Submarine vSpeed:)
				else
					(self hide:)
					(eBalGauge setCycle: Beg eBalGauge)
					(Submarine emergencyBallast: 480)
					(Submarine vSpeed:)
				)
			)
		)
	)
)

(instance mapDisplay of View
	(properties
		y 82
		x 74
		view 527
		loop 2
		cel 1
	)
)

(instance tB1 of View
	(properties
		y 187
		x 67
		view 427
		loop 7
		cel 1
	)
)

(instance tB2 of View
	(properties
		y 181
		x 74
		view 427
		loop 7
		cel 1
	)
)

(instance tB3 of View
	(properties
		y 175
		x 81
		view 427
		loop 7
		cel 1
		priority 14
		signal 273
	)
)

(instance tB4 of View
	(properties
		y 169
		x 88
		view 427
		loop 7
		cel 1
		priority 14
		signal 273
	)
)

(instance compassNeedle of View
	(properties
		y 123
		x 83
		view 127
		priority 13
		signal 17
	)

	(method (doit &tmp temp0)
		(if (not (mod (++ local3) 10))
			(super doit:)
			(if (!= (= temp0 (mod (/ (Submarine _absHeading:) 22) 16)) cel)
				(self setCel: temp0)
			)
		)
	)
)

(instance tV of View
	(properties
		y 98
		x 157
		view 527
		loop 3
		cel 4
		priority 13
		signal 16657
	)
)

