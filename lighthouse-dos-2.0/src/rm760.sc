;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 760)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use SwitchView)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm760 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0 param1 param2 param3)
	(if (> (+= param2 param3) (param1 lastCel:))
		(= param2 0)
	)
	(if (< param2 0)
		(= param2 (param1 lastCel:))
	)
	(return param2)
)

(procedure (localproc_1)
	(gBackMusic2 stop:)
	(ClearFlag 205)
	(ClearFlag 139)
	(sPowerUp dispose:)
)

(class Dial of View
	(properties
		ccwFeat 0
		cwFeat 0
		slave 0
		spinDelay 0
	)

	(method (init)
		(super init: &rest)
		((= ccwFeat (ccwDialFeat new:))
			heading: self
			nsLeft: nsLeft
			nsTop: nsTop
			nsRight: (+ nsLeft (/ (- nsRight nsLeft) 2))
			nsBottom: nsBottom
			init:
		)
		((= cwFeat (cwDialFeat new:))
			heading: self
			nsLeft: (+ nsLeft (/ (- nsRight nsLeft) 2))
			nsTop: nsTop
			nsRight: nsRight
			nsBottom: nsBottom
			init:
		)
		(approachX hotVerbs: 5 24)
	)

	(method (dispose)
		(if cwFeat
			(cwFeat dispose:)
			(= cwFeat 0)
		)
		(if ccwFeat
			(ccwFeat dispose:)
			(= ccwFeat 0)
		)
		(super dispose:)
	)

	(method (spin param1)
		(roomSfx number: 721 play:)
		(if (== param1 ccwFeat)
			(if (< (-- cel) 0)
				(= cel (self lastCel:))
			)
			(self control: -1)
		else
			(if (> (++ cel) (self lastCel:))
				(= cel 0)
			)
			(self control: 1)
		)
	)

	(method (control))
)

(instance ccwDialFeat of Feature
	(properties)

	(method (dispose)
		(heading ccwFeat: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((& (event type:) evMOUSERELEASE)
				(global206 delete: self)
				(return 0)
			)
			((and (self onMe: event) (== (event message:) $0018))
				(heading doVerb: (event message:))
			)
			((self onMe: event)
				(if (> (heading spinDelay:) 0)
					(heading spinDelay: (- (heading spinDelay:) 1))
				else
					(if (or (IsFlag 205) (not (IsFlag 150)))
						(heading spinDelay: 10)
					else
						(heading spinDelay: 5)
					)
					(heading spin: self)
				)
				(global206 add: self)
			)
		)
	)
)

(instance cwDialFeat of Feature
	(properties)

	(method (dispose)
		(heading cwFeat: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((& (event type:) evMOUSERELEASE)
				(global206 delete: self)
				(return 0)
			)
			((and (self onMe: event) (== (event message:) $0018))
				(heading doVerb: (event message:))
			)
			((self onMe: event)
				(if (> (heading spinDelay:) 0)
					(heading spinDelay: (- (heading spinDelay:) 1))
				else
					(if (or (IsFlag 205) (not (IsFlag 150)))
						(heading spinDelay: 10)
					else
						(heading spinDelay: 5)
					)
					(heading spin: self)
				)
				(global206 add: self)
			)
		)
	)
)

(class TVDial of View
	(properties
		ccwFeat 0
		cwFeat 0
		slave 0
		spinDelay 0
	)

	(method (init)
		(super init: &rest)
		((= ccwFeat (TVccwDialFeat new:))
			heading: self
			nsLeft: nsLeft
			nsTop: nsTop
			nsRight: (+ nsLeft (/ (- nsRight nsLeft) 2))
			nsBottom: nsBottom
			init:
		)
		((= cwFeat (TVcwDialFeat new:))
			heading: self
			nsLeft: (+ nsLeft (/ (- nsRight nsLeft) 2))
			nsTop: nsTop
			nsRight: nsRight
			nsBottom: nsBottom
			init:
		)
		(approachX hotVerbs: 5 24)
	)

	(method (dispose)
		(if cwFeat
			(cwFeat dispose:)
			(= cwFeat 0)
		)
		(if ccwFeat
			(ccwFeat dispose:)
			(= ccwFeat 0)
		)
		(super dispose:)
	)

	(method (spin param1)
		(roomSfx number: 721 play:)
		(if (== param1 ccwFeat)
			(if (< (-- cel) 0)
				(= cel (self lastCel:))
			)
			(self control: -1)
		else
			(if (> (++ cel) (self lastCel:))
				(= cel 0)
			)
			(self control: 1)
		)
	)

	(method (control))
)

(instance TVccwDialFeat of Feature
	(properties)

	(method (dispose)
		(heading ccwFeat: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((not (& (event type:) evMOUSEBUTTON))
				(return 0)
			)
			((and (self onMe: event) (== (event message:) $0018))
				(heading doVerb: (event message:))
			)
			((self onMe: event)
				(heading spin: self)
			)
		)
	)
)

(instance TVcwDialFeat of Feature
	(properties)

	(method (dispose)
		(heading cwFeat: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 0)
			)
			((not (& (event type:) evMOUSEBUTTON))
				(return 0)
			)
			((and (self onMe: event) (== (event message:) $0018))
				(heading doVerb: (event message:))
			)
			((self onMe: event)
				(heading spin: self)
			)
		)
	)
)

(instance rm760 of LightRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(= local1 1)
		(self changeScene: 768 1)
		(if (IsFlag 171)
			(sBatteryFlash init:)
		)
		(if (and (== global236 765) (not (IsFlag 234)))
			(= local0 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 18)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(if (== param1 768)
			(gGame normalizeCode: -1)
			(gGame normalizeCursor:)
		)
		(battLight0781 dispose:)
		(battLight1781 dispose:)
		(sBatteryFlash781 dispose:)
		(mainLirylSwitch dispose:)
		(mainBeamSwitch dispose:)
		(mainBoosterSwitch dispose:)
		(mainPulpitSwitch dispose:)
		(mainTPMonitor dispose:)
		(mainMainSwitch dispose:)
		(mainSolarSwitch dispose:)
		(mainPowerGauge dispose:)
		(mainOutElevSwitch dispose:)
		(mainInElevSwitch dispose:)
		(mainLights dispose:)
		(mainBulbs dispose:)
		(mainDomainMonitor dispose:)
		(mainFortressMonitor dispose:)
		(mainRoostMonitor dispose:)
		(mainTempleMonitor dispose:)
		(leftChain dispose:)
		(leftPulpitSwitch dispose:)
		(leftMainSwitch dispose:)
		(leftLights dispose:)
		(leftDomainMonitor dispose:)
		(leftFortressMonitor dispose:)
		(leftRoostMonitor dispose:)
		(leftTempleMonitor dispose:)
		(templeSwitch dispose:)
		(domainSwitch dispose:)
		(roostSwitch dispose:)
		(fortressSwitch dispose:)
		(lowerPulpitSwitch dispose:)
		(lowerOutElevSwitch dispose:)
		(lowerInElevSwitch dispose:)
		(lowerLights dispose:)
		(lowerBoosterSwitch dispose:)
		(lowerPowerGauge dispose:)
		(lowerSolarSwitch dispose:)
		(lowerBeamSwitch dispose:)
		(lowerScreenSwitch dispose:)
		(leftHorizDial dispose:)
		(leftVertDial dispose:)
		(rightHorizDial dispose:)
		(rightVertDial dispose:)
		(leftHorizLine dispose:)
		(rightHorizLine dispose:)
		(leftVertLine dispose:)
		(rightVertLine dispose:)
		(target dispose:)
		(rightMindProbe dispose:)
		(rightLirylSwitch dispose:)
		(rightSolarSwitch dispose:)
		(tpMonitorSwitch dispose:)
		(rightTPMonitor dispose:)
		(rightTPMonFeat dispose:)
		(coarseTPDial dispose:)
		(fineTPDial dispose:)
		(tpLockButton dispose:)
		(rightBulbs dispose:)
		(rightStatic dispose:)
		(if (not (OneOf param1 770 782))
			(monitorStatic stop:)
		)
		(upperLirylSwitch dispose:)
		(upperMainSwitch dispose:)
		(upperMainLights dispose:)
		(upperChain dispose:)
		(upperHatch dispose:)
		(upperDomainMonitor dispose:)
		(upperTempleMonitor dispose:)
		(upperBulbs dispose:)
		(upperPulpitSwitch dispose:)
		(upperSolarSwitch dispose:)
		(upperHatchFeat dispose:)
		(lirylFeat782 dispose:)
		(lirylControl782 dispose:)
		(lirylLights782 dispose:)
		(switch param1
			(762
				(gCurRoom setScript: sLirylExit)
			)
			(768
				((ScriptID 1 3) ; exitLeft
					newPic: 769 2
					arrowStyle: 8
					nsLeft: 45
					nsTop: 36
					nsRight: 175
					nsBottom: 208
				)
				((ScriptID 1 4) ; exitRight
					newPic: 770 8
					arrowStyle: 7
					nsLeft: 320
					nsTop: 36
					nsRight: 470
					nsBottom: 208
				)
				((ScriptID 1 6) ; exitUp
					newPic: 784 1
					arrowStyle: 5
					nsLeft: 176
					nsTop: 15
					nsRight: 339
					nsBottom: 177
				)
				((ScriptID 1 5) ; exitDown
					newPic: 783 1
					arrowStyle: 3
					nsLeft: 176
					nsTop: 178
					nsRight: 339
					nsBottom: 251
				)
				(mainLirylSwitch init:)
				(mainBeamSwitch init:)
				(mainBoosterSwitch init:)
				(mainPulpitSwitch init:)
				(mainTPMonitor init:)
				(mainMainSwitch init:)
				(mainSolarSwitch init:)
				(mainPowerGauge init:)
				(mainOutElevSwitch init:)
				(mainInElevSwitch init:)
				(mainLights init:)
				(mainBulbs init:)
				(mainDomainMonitor init:)
				(mainFortressMonitor init:)
				(mainRoostMonitor init:)
				(mainTempleMonitor init:)
				((ScriptID 1 2) newRoom: 765 1) ; exitBack
			)
			(769
				(leftChain init:)
				(leftPulpitSwitch init:)
				(leftMainSwitch init:)
				(leftLights init:)
				(leftDomainMonitor init:)
				(leftFortressMonitor init:)
				(leftRoostMonitor init:)
				(leftTempleMonitor init:)
				(templeSwitch init:)
				(domainSwitch init:)
				(roostSwitch init:)
				(fortressSwitch init:)
				((ScriptID 1 7) ; exitBackUp
					newPic: 768 1
					nsLeft: 113
					nsTop: 285
					nsRight: 331
					nsBottom: 300
				)
				((ScriptID 1 4) ; exitRight
					newPic: 784 1
					nsLeft: 441
					nsTop: 0
					nsRight: 499
					nsBottom: 131
				)
			)
			(770
				(rightMindProbe init:)
				(rightLirylSwitch init:)
				(rightSolarSwitch init:)
				(tpMonitorSwitch init:)
				(coarseTPDial init:)
				(fineTPDial init:)
				(tpLockButton init:)
				(rightTPMonitor init:)
				(rightTPMonFeat init:)
				(if (and (rightTPMonitor on:) (not local4) (not (IsFlag 173)))
					(rightStatic init:)
				)
				(if (and (IsFlag 188) (IsFlag 143))
					(rightBulbs init: setScript: sRightBulbs)
				)
				((ScriptID 1 7) newPic: 768 1 exitCode: cExitMindBottom) ; exitBackUp
				((ScriptID 1 3) newPic: 784 1 exitCode: cExitMindLeft) ; exitLeft
				(if local0
					((ScriptID 1 4) newPic: 782 7) ; exitRight
				)
			)
			(781
				(if (== script sPulpitExtend)
					(gCurRoom
						setScript: sShowPulpitExtending 0 (script register:)
					)
				else
					(gCurRoom
						setScript: sShowPulpitRetracting 0 (script register:)
					)
				)
				(battLight0781 init:)
				(battLight1781 init:)
				(sBatteryFlash781 init:)
			)
			(782
				((ScriptID 1 3) newPic: 770) ; exitLeft
				(lirylFeat782 init:)
				(lirylControl782 init:)
				(lirylLights782 init:)
			)
			(783
				(lowerPulpitSwitch init:)
				(lowerOutElevSwitch init:)
				(lowerInElevSwitch init:)
				(lowerLights init:)
				(lowerBoosterSwitch init:)
				(lowerPowerGauge init:)
				(lowerSolarSwitch init:)
				(lowerBeamSwitch init:)
				(lowerScreenSwitch init:)
				(leftHorizDial init:)
				(leftVertDial init:)
				(rightHorizDial init:)
				(rightVertDial init:)
				((ScriptID 1 7) ; exitBackUp
					newPic: 768 1
					nsLeft: 185
					nsTop: 192
					nsRight: 276
					nsBottom: 301
				)
				((ScriptID 1 6) ; exitUp
					newPic: 784 1
					nsLeft: 225
					nsTop: 45
					nsRight: 335
					nsBottom: 90
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 769 2
					arrowStyle: 8
					nsLeft: 1
					nsTop: 183
					nsRight: 103
					nsBottom: 299
				)
				((ScriptID 1 4) ; exitRight
					newPic: 770 8
					arrowStyle: 7
					nsLeft: 406
					nsTop: 183
					nsRight: 500
					nsBottom: 299
				)
				(if local0
					((ScriptID 1 4) ; exitRight
						newPic: 782 7
						nsLeft: 471
						nsTop: 90
						nsRight: 500
						nsBottom: 298
					)
				)
			)
			(784
				(upperLirylSwitch init:)
				(upperMainSwitch init:)
				(upperMainLights init:)
				(upperChain init:)
				(upperHatch init:)
				(upperDomainMonitor init:)
				(upperTempleMonitor init:)
				(upperBulbs init:)
				(if (IsFlag 141)
					(upperPulpitSwitch init:)
				)
				(if (IsFlag 144)
					(upperSolarSwitch init:)
				)
				((ScriptID 1 7) newPic: 783 1 exitCode: cExit784South) ; exitBackUp
				((ScriptID 1 4) newPic: 770 8 exitCode: cExit784Right) ; exitRight
				((ScriptID 1 3) newPic: 769 2 exitCode: cExit784Left) ; exitLeft
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
		(if local1
			(= local1 0)
			(if (and (IsFlag 188) (IsFlag 144))
				(lowerPowerGauge cel: 11)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 188) (IsFlag 144) (IsFlag 140))
			(gGame handsOff:)
			(gCurRoom setScript: sBlowUpLeaving)
		else
			(super newRoom: newRoomNumber)
		)
	)
)

(instance sBlowUpLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 170)
				(gBackMusic2 stop:)
				(roomSfx number: 788 play:)
				(cShutDown doit:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roomSfx of Sound
	(properties)
)

(instance powerBoostSnd of Sound
	(properties
		number 797
	)
)

(instance battLight0781 of View
	(properties
		x 338
		y 140
		view 7781
	)
)

(instance battLight1781 of View
	(properties
		x 436
		y 140
		loop 1
		view 7781
	)
)

(instance sBatteryFlash781 of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(battLight0781 hide:)
				(= ticks 30)
			)
			(1
				(battLight0781 show:)
				(battLight1781 hide:)
				(= ticks 30)
			)
			(2
				(battLight1781 show:)
				(= ticks 30)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance pulpit781 of View
	(properties
		x 149
		y 299
		loop 2
		view 7781
	)
)

(instance sShowPulpitExtending of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 787)
				(= cycles 2)
			)
			(1
				(KillRobot 7781 130 70 0 -1 1)
				(= cycles 2)
			)
			(2
				(roomSfx number: 787 play:)
			)
			(3
				(= seconds 2)
			)
			(4
				(self dispose:)
				(if (== register leftPulpitSwitch)
					(gCurRoom changeScene: 769 2)
				else
					(gCurRoom changeScene: 783 1)
				)
			)
		)
	)
)

(instance rReversePulpit of RobotPlayer
	(properties)
)

(instance sShowPulpitRetracting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pulpit781 init:)
				(Load rsAUDIO 787)
				(= cycles 2)
			)
			(1
				(pulpit781 dispose:)
				(rReversePulpit
					init: 7781 25 130 70 150
					caller: self
					start: 2 10
				)
				(= ticks 30)
			)
			(2
				(roomSfx number: 787 play:)
			)
			(3
				(if local6
					(= local6 0)
					(cShutDown doit:)
				)
				(rReversePulpit dispose:)
				(= seconds 2)
			)
			(4
				(self dispose:)
				(switch register
					(leftPulpitSwitch
						(gCurRoom changeScene: 769 2)
					)
					(mainPulpitSwitch
						(gCurRoom changeScene: 768 1)
					)
					(lowerPulpitSwitch
						(gCurRoom changeScene: 783 1)
					)
					(upperPulpitSwitch
						(gCurRoom changeScene: 784 1)
					)
					(else
						(gCurRoom changeScene: 783 1)
					)
				)
			)
		)
	)
)

(instance lirylLights782 of Prop
	(properties
		x 249
		y 182
		loop 1
		view 175
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: Fwd)
	)
)

(instance lirylFeat782 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				176
				141
				198
				141
				208
				153
				207
				177
				202
				188
				204
				193
				228
				191
				226
				243
				186
				245
				165
				253
				153
				220
				148
				237
				135
				239
				128
				226
				150
				193
				170
				190
				173
				183
				165
				177
				164
				152
		)
		(approachX hotVerbs: 5 60 96 19 51 94 20 21 47)
	)

	(method (doVerb theVerb)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(if (not (IsFlag 417))
					(SetFlag 417)
					(gGame handsOff:)
					(gCurRoom setScript: sFirstSpeech)
				else
					(gGame normalizeCode: myNormalizeCode)
					(gGame normalizeCursor:)
				)
			)
			(60 ; invCD
				(gMessager say: 9 0 20 1 0 720) ; "You are not of this land. To understand what has happened here, you must first learn our history."
			)
			(96 ; invBeingInBottle
				(gMessager say: 8 96 0 1 0 720) ; "Thank for saving our land. I could not have stopped him by myself."
			)
			(19 ; invShell
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 88)) ; invShell
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 88)) ; invShell
				)
			)
			(51 ; invBaubles
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 41)) ; invBaubles
				)
			)
			(94 ; invDooDads
				(if (IsFlag 234)
					(gMessager say: 8 19 17 1 0 720) ; "Thank you! These are beautiful. Maybe you are not so bad."
					(ClearFlag 234)
					(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
				else
					(gMessager say: 6 19 0 1 0 720) ; "Thank you, stranger! The priests used to bring me presents like these. Sometimes I make things to pass the time. These will be perfect!"
					(gInventory deleteItem: (ScriptID 9 85)) ; invDooDads
				)
			)
			(20 ; invFish
				(gMessager say: 6 20 0 1 0 720) ; "It stinks! Take it away!"
			)
			(21 ; invSparrow
				(gMessager say: 6 21 0 1 0 720) ; "It's beautifully made, but I don't need it."
			)
			(47 ; invBottleNote
				(gMessager say: 1 18 0 1 0 720) ; "This means they are dead! They will never return! I am alone here, with no-one to help me! No pretty stones for(click) Liryl(click) Nothing but tears, nothing but...(click) tears.( Liryl leaves )"
			)
			(24) ; ???
			(else
				(if (OneOf theVerb 73 40 69 68 67 71 66 70) ; invCannon, invIonizer, invPowerSupply, invStock, invVacuumPump, invBarrel, invCrystalBottle, invFiringMechanism
					(gMessager say: 6 22 0 1 0 720) ; "That's part of the device! They called it a particle ionizing vacuum cannon! If you can assemble it, I think you can defeat him."
				else
					(gMessager say: 6 0 0 1 0 720) ; "Liryl: That's interesting. What is it for?"
				)
			)
		)
	)
)

(instance sFirstSpeech of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 17 0 33 1 self 720) ; "I don't understand this machine, but I will help you as much as I can."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
				(gGame normalizeCode: myNormalizeCode)
				(gGame normalizeCursor:)
			)
		)
	)
)

(instance lirylControl782 of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 135 241 156 241 160 253 134 253)
	)

	(method (doVerb theVerb)
		(if (not (gTalkers isEmpty:))
			(gTalkers eachElementDo: #dispose)
		)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sLirylControl)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sLirylControl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (++ global230)
					(1
						(gMessager say: 7 0 1 1 self 720) ; "I use those controls to move about. Please don't hinder me by touching them."
					)
					(2
						(gMessager say: 7 0 8 1 self 720) ; "(scared)Go away!(rattle). Don't touch that!"
					)
					(3
						(gMessager say: 7 0 9 1 self 720) ; "Leave me alone! (pod rattles badly, shaking the girl)D..D..on't touch my controls! (crackle, Liryl turns and exits through pod door. She will not return unless coaxed from her room with shells and baubles.)"
					)
				)
			)
			(1
				(self dispose:)
				(if (== global230 3)
					(gGame normalizeCode: -1)
					(gGame normalizeCursor:)
					(gCurRoom changeScene: 762 7)
				else
					(gGame handsOn:)
				)
			)
		)
	)
)

(instance sLirylExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 762)
				(KillRobot 4174 50 33)
			)
			(1
				(self dispose:)
				(= local0 0)
				(= global230 0)
				(SetFlag 234)
				(gCurRoom changeScene: 768 1)
			)
		)
	)
)

(instance myNormalizeCode of Code
	(properties)

	(method (doit &tmp temp0)
		(gUser curVerb: 24)
		(if global106
			(= temp0 12)
		else
			(= temp0 11)
		)
		(gNormalCursor view: 1100 loop: temp0 cel: 0)
		(gGame cursHidden: 0)
		(gGame setCursor: gNormalCursor 1)
	)
)

(instance upperLirylSwitch of SwitchView
	(properties
		x 332
		y 272
		view 2733
		myFlag 138
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sUpperLirylSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperMainSwitch of SwitchView
	(properties
		x 71
		y 299
		view 2730
		myFlag 143
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 1)
			)
			(5 ; Do
				(self toggle:)
				(gGame handsOff:)
				(gCurRoom setScript: sUpperMainSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperMainLights of SwitchView
	(properties
		x 71
		y 299
		loop 1
		view 2730
		myFlag 151
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self setPri: (+ (upperMainSwitch priority:) 1) setCycle: Fwd)
		)
	)
)

(instance upperBulbs of SwitchView
	(properties
		x 179
		y 210
		loop 4
		view 784
		myFlag 151
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self setCycle: Fwd)
		)
	)
)

(instance upperChain of SwitchView
	(properties
		x 45
		y 226
		view 2734
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 5)
			)
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sUpperPullChain)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperDomainMonitor of SwitchView
	(properties
		y 242
		view 784
		myFlag 146
		offCel 0
		dontForce 1
	)
)

(instance upperTempleMonitor of SwitchView
	(properties
		y 242
		loop 1
		view 784
		myFlag 149
		offCel 0
		dontForce 1
	)
)

(instance upperPulpitSwitch of View
	(properties
		x 24
		y 299
		loop 1
		view 2733
	)
)

(instance upperSolarSwitch of View
	(properties
		x 426
		y 247
		loop 2
		view 2733
	)
)

(instance cExit784South of Code
	(properties)

	(method (doit)
		(if (upperHatch cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseHatch 0 783)
		else
			(gCurRoom changeScene: 783 1)
		)
	)
)

(instance cExit784Right of Code
	(properties)

	(method (doit)
		(if (upperHatch cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseHatch 0 770)
		else
			(gCurRoom changeScene: 770 8)
		)
	)
)

(instance cExit784Left of Code
	(properties)

	(method (doit)
		(if (upperHatch cel:)
			(gGame handsOff:)
			(gCurRoom setScript: sCloseHatch 0 769)
		else
			(gCurRoom changeScene: 769 2)
		)
	)
)

(instance emergencySwitch of SwitchView
	(properties
		x 365
		y 94
		loop 2
		view 784
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 12)
			)
			(5 ; Do
				(self quickToggle:)
				(if (IsFlag 188)
					(gGame handsOff:)
					(gCurRoom setScript: sEmergencySwitch)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upperHatch of Prop
	(properties
		x 420
		y 1
		view 2745
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(if cel
					(sSayHelp init: 0 0 16)
				else
					(sSayHelp init: 0 0 15)
				)
			)
			(5 ; Do
				(if (not cel)
					(gGame handsOff:)
					(gCurRoom setScript: sSwingHatch)
				)
			)
			(57 ; invMachinePart
				(cond
					((not (IsFlag 170))
						(super doVerb: theVerb)
					)
					((not (self cel:))
						(super doVerb: theVerb)
					)
					((IsFlag 201)
						(gGame handsOff:)
						(gCurRoom setScript: sAttachPart)
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

(instance upperHatchFeat of Feature
	(properties
		nsBottom 20
		nsLeft 111
		nsRight 402
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sSwingHatch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance partFeat of Feature
	(properties
		nsBottom 99
		nsLeft 167
		nsRight 333
		nsTop 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sRemovePart)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sRemovePart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 749 play:)
				(upperHatch view: 784 loop: 3 x: 68 y: 120)
				(= cycles 2)
				(SetFlag 209)
				(partFeat dispose:)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sAttachPart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 749 play:)
				(upperHatch view: 2745 loop: 3 x: 356 y: 2)
				(upperHatch cel: (upperHatch lastCel:))
				(gInventory deleteItem: (ScriptID 9 48)) ; invMachinePart
				(partFeat dispose:)
				(ClearFlag 170)
				(ClearFlag 209)
				(ClearFlag 201)
				(ClearFlag 200)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSwingHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (upperHatch cel:) 0)
					(cond
						((IsFlag 209)
							(upperHatch view: 784 loop: 3 x: 68 y: 120)
							((upperHatch approachX:) hotVerbs: 24 57)
						)
						((IsFlag 170)
							(upperHatch view: 2745 loop: 0 x: 420 y: 1)
							(partFeat init:)
							((upperHatch approachX:) hotVerbs: 5 24)
						)
						(else
							(upperHatch view: 2745 loop: 3 x: 356 y: 2)
							((upperHatch approachX:) hotVerbs: 24)
						)
					)
					(gCast addToFront: emergencySwitch)
					(emergencySwitch init:)
					(global105 delete: (emergencySwitch approachX:))
					(global105 addToFront: (emergencySwitch approachX:))
					(roomSfx number: 747 play:)
					(upperHatch setCycle: End self)
					(upperHatchFeat init:)
				else
					(partFeat dispose:)
					(emergencySwitch dispose:)
					(roomSfx number: 748 play:)
					(upperHatch setCycle: Beg self)
					(upperHatchFeat dispose:)
					((upperHatch approachX:) hotVerbs: 5)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCloseHatch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(upperHatchFeat dispose:)
				(self setScript: sSwingHatch self)
			)
			(1
				(self dispose:)
				(switch register
					(769
						(gCurRoom changeScene: register 2)
					)
					(770
						(gCurRoom changeScene: register 8)
					)
					(783
						(gCurRoom changeScene: register 1)
					)
				)
			)
		)
	)
)

(instance sEmergencySwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(upperMainSwitch setCycle: Beg self)
			)
			(1
				(gBackMusic2 stop:)
				(roomSfx number: 786 play:)
				(gCurRoom setScript: sResetLevers)
				(= local6 1)
			)
		)
	)
)

(instance sUpperLirylSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (upperLirylSwitch on:))
					(= register 0)
					(roomSfx number: 7011 play:)
					(upperLirylSwitch toggle: setCycle: End self)
				else
					(= register 1)
					(roomSfx number: 7010 play:)
					(upperLirylSwitch setCycle: Beg self)
				)
			)
			(1
				(if register
					(upperLirylSwitch toggle:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpperMainSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(roomSfx number: 717 play:)
				(if (not (upperMainSwitch cel:))
					(upperMainSwitch setCycle: End self)
				else
					(upperMainSwitch setCycle: Beg self)
					(if (IsFlag 188)
						(upperMainLights toggle: setCycle: 0)
					)
					(leftHorizLine dispose:)
					(rightHorizLine dispose:)
					(leftVertLine dispose:)
					(rightVertLine dispose:)
					(target dispose:)
					(ClearFlag 205)
				)
			)
			(1
				(if (and (IsFlag 171) (IsFlag 143) (not (IsFlag 170)))
					(roomSfx number: 718 play:)
					(upperMainLights
						toggle:
						setPri: (+ (upperMainSwitch priority:) 1)
						loop: 3
						cel: 0
						setCycle: End self
					)
					(upperBulbs init:)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((not (IsFlag 171))
						(= cycles 2)
					)
					((IsFlag 170)
						(= cycles 2)
					)
					((not (upperMainSwitch cel:))
						(gBackMusic2 stop:)
						(roomSfx number: 786 play:)
						(= register 1)
						(gCurRoom setScript: sResetLevers)
						(= local6 1)
					)
					(else
						(if (gCast contains: upperPulpitSwitch)
							(ClearFlag 141)
							(upperPulpitSwitch dispose:)
						)
						(upperMainLights loop: 1 setCycle: Fwd)
						(if (IsFlag 144)
							(sPowerUp init:)
						)
						(SetFlag 188)
						(ClearFlag 139)
						(gBackMusic2 number: 785 play:)
						(= cycles 2)
					)
				)
			)
			(3
				(if register
					(cShutDown doit:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpperPullChain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(upperChain setCycle: End self)
			)
			(1
				(roomSfx number: 734 play:)
				(upperChain setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rightLirylSwitch of SwitchView
	(properties
		x 2
		y 156
		loop 6
		view 7770
		myFlag 138
		dontForce 1
	)
)

(instance rightSolarSwitch of SwitchView
	(properties
		x 2
		y 214
		loop 3
		view 7770
		myFlag 144
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sRightSolarSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightMindProbe of Prop
	(properties
		x 490
		y 21
		cycleSpeed 4
		loop 4
		view 7770
	)
)

(instance tpMonitorSwitch of SwitchView
	(properties
		x 346
		y 218
		view 7770
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self quickToggle:)
				(if (IsFlag 188)
					(rightTPMonitor toggle:)
					(if (and (rightTPMonitor on:) (not local4))
						(rightStatic init:)
					)
					(if (and (rightTPMonitor on:) (not (rightMindProbe cel:)))
						(gGame handsOff:)
						(gCurRoom setScript: sMindProbe 0 0)
					)
					(if (and (not (rightTPMonitor on:)) (rightMindProbe cel:))
						(gGame handsOff:)
						(gCurRoom setScript: sMindProbe 0 0)
					)
					(if (not (rightTPMonitor on:))
						(= local4 0)
						(rightStatic dispose:)
						(localproc_1)
					)
				)
			)
			(24 ; ???
				(sSayHelp init: 0 0 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance coarseTPDial of TVDial
	(properties
		x 174
		y 270
		loop 5
		view 7770
	)

	(method (init)
		(super init: &rest)
		(= slave rightTPMonitor)
		(= local5 (Random 2 4))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (control param1 &tmp temp0 temp1)
		(if (not (rightTPMonitor on:))
			(return)
		)
		(slave view: 7771 loop: 0 x: 188 y: 194 show:)
		(ClearFlag 173)
		(= temp0 (slave cel:))
		(= temp1 0)
		(if (-- local5)
			(= temp1 7)
		else
			(= local5 (Random 2 4))
			(while 1
				(if
					(and
						(== (= temp0 (localproc_0 slave temp0 param1)) 0)
						(or (IsFlag 181) (IsFlag 182) (IsFlag 180))
					)
					(break)
				)
				(if
					(and
						(== temp0 1)
						(or (IsFlag 179) (IsFlag 178) (IsFlag 177))
					)
					(break)
				)
				(if
					(and
						(== temp0 2)
						(== global226 1)
						(or (and (IsFlag 185) (== global229 4)) (IsFlag 184))
					)
					(break)
				)
				(if (and (== temp0 3) (or (IsFlag 246) (IsFlag 183)))
					(break)
				)
				(if (and (== temp0 4) (IsFlag 226))
					(break)
				)
				(if (and (== temp0 5) (IsFlag 186))
					(break)
				)
				(if (>= (++ temp1) 6)
					(break)
				)
			)
		)
		(if (< temp1 6)
			(rightStatic dispose:)
			(= local4 1)
			(slave cel: temp0)
		else
			(= local4 0)
			(slave hide:)
			(rightStatic init:)
		)
	)
)

(instance fineTPDial of TVDial
	(properties
		x 229
		y 265
		loop 8
		view 7770
	)

	(method (init)
		(super init: &rest)
		(= slave rightTPMonitor)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (control param1 &tmp temp0)
		(if (or (not local4) (== (slave view:) 7770))
			(return)
		)
		(ClearFlag 173)
		(if (-- local5)
			(slave hide:)
			(rightStatic init:)
		else
			(rightStatic dispose:)
			(slave show:)
			(= local5 (Random 2 4))
			(if (== (slave loop:) 0)
				(slave
					loop:
						(switch (slave cel:)
							(0 1)
							(1 2)
							(2 4)
							(3 5)
							(4 6)
							(else 3)
						)
				)
				(= temp0 0)
			else
				(= temp0 (slave cel:))
			)
			(switch (slave loop:)
				(1
					(while 1
						(if
							(and
								(==
									(= temp0 (localproc_0 slave temp0 param1))
									0
								)
								(IsFlag 181)
							)
							(= global235 464)
							(break)
						)
						(if (and (== temp0 1) (IsFlag 182))
							(= global235 476)
							(break)
						)
						(if (and (== temp0 2) (IsFlag 180))
							(= global235 493)
							(break)
						)
					)
					(slave cel: temp0)
				)
				(2
					(while 1
						(if
							(and
								(==
									(= temp0 (localproc_0 slave temp0 param1))
									0
								)
								(IsFlag 179)
							)
							(= global235 352)
							(break)
						)
						(if (and (== temp0 1) (IsFlag 178))
							(= global235 373)
							(break)
						)
						(if (and (== temp0 2) (IsFlag 177))
							(= global235 376)
							(break)
						)
					)
					(slave cel: temp0)
				)
				(3
					(= global235 226)
					(slave cel: 0)
				)
				(4
					(while 1
						(if
							(and
								(==
									(= temp0 (localproc_0 slave temp0 param1))
									0
								)
								(IsFlag 184)
							)
							(= global235 839)
							(break)
						)
						(if (and (== temp0 1) (IsFlag 185) (== global229 4))
							(= global235 815)
							(break)
						)
					)
					(slave cel: temp0)
				)
				(5
					(while 1
						(= temp0 (localproc_0 slave temp0 param1))
						(if (== cel 0)
							(= cel 1)
						)
						(if (and (== temp0 1) (IsFlag 246))
							(= global235 611)
							(break)
						)
						(if (and (== temp0 2) (IsFlag 183))
							(= global235 656)
							(break)
						)
					)
					(slave cel: temp0)
				)
				(else
					(= global235 706)
					(slave cel: 0)
				)
			)
		)
	)
)

(instance tpLockButton of SwitchView
	(properties
		x 287
		y 251
		loop 9
		view 7770
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(switch theVerb
			(5 ; Do
				(self quickToggle:)
				(cond
					((not (rightTPMonitor on:)) 0)
					((gCast contains: rightStatic) 0)
					((IsFlag 173)
						(localproc_1)
						(if (not (rightMindProbe cel:))
							(gGame handsOff:)
							(gCurRoom setScript: sMindProbe 0 0)
						)
						(ClearFlag 173)
						(switch global235
							(226
								(= temp0 3)
								(= temp1 0)
							)
							(352
								(= temp0 2)
								(= temp1 0)
							)
							(373
								(= temp0 2)
								(= temp1 1)
							)
							(376
								(= temp0 2)
								(= temp1 2)
							)
							(464
								(= temp0 1)
								(= temp1 0)
							)
							(476
								(= temp0 1)
								(= temp1 1)
							)
							(493
								(= temp0 1)
								(= temp1 2)
							)
							(609
								(= temp0 5)
								(= temp1 0)
							)
							(611
								(= temp0 5)
								(= temp1 1)
							)
							(656
								(= temp0 5)
								(= temp1 2)
							)
							(839
								(= temp0 4)
								(= temp1 0)
							)
							(815
								(= temp0 4)
								(= temp1 1)
							)
							(else
								(= temp0 6)
								(= temp1 0)
							)
						)
						(rightTPMonitor
							view: 7771
							loop: temp0
							cel: temp1
							x: 188
							y: 194
						)
					)
					((== (rightTPMonitor loop:) 0) 0)
					(else
						(SetFlag 173)
						(rightTPMonitor
							view: 7770
							loop: 7
							cel: 0
							x: 184
							y: 197
							setCycle: End
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitorStatic of Sound
	(properties
		number 720
		loop -1
	)
)

(instance rightStatic of Prop
	(properties
		x 182
		y 70
		loop 1
		view 7770
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
		(monitorStatic play:)
	)

	(method (dispose)
		(monitorStatic stop:)
		(super dispose:)
	)
)

(instance rightTPMonFeat of Feature
	(properties
		nsBottom 198
		nsLeft 189
		nsRight 340
		nsTop 74
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightTPMonitor of SwitchView
	(properties
		x 182
		y 70
		loop 1
		view 7770
		myFlag 142
		offCel 0
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(cond
			((IsFlag 173)
				(self view: 7770 loop: 7 x: 184 y: 197 show:)
				(self cel: (self lastCel:))
			)
			((and (self on:) (not local4))
				(self hide:)
			)
		)
	)

	(method (initialCel)
		(if (and (self on:) local4)
			(self show:)
		else
			(self hide:)
		)
	)

	(method (toggle)
		(super toggle: &rest)
		(cond
			((not (self on:))
				(self hide:)
				(ClearFlag 173)
			)
			((not local4)
				(self hide:)
			)
			(else
				(self show:)
			)
		)
	)
)

(instance sMindProbe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (rightMindProbe cel:))
					(roomSfx number: 745 play:)
					(rightMindProbe setCycle: End self)
				else
					(roomSfx number: 746 play:)
					(rightMindProbe setCycle: Beg self)
				)
			)
			(1
				(self dispose:)
				(if (not register)
					(gGame handsOn:)
				else
					(gCurRoom changeScene: register)
				)
			)
		)
	)
)

(instance cExitMindLeft of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(if (rightTPMonitor on:)
			(if (not (IsFlag 173))
				(rightTPMonitor toggle:)
				(= local4 0)
			)
			(if (rightMindProbe cel:)
				(gCurRoom setScript: sMindProbe 0 784)
			else
				(gCurRoom changeScene: 784 1)
			)
		else
			(gCurRoom changeScene: 784 1)
		)
	)
)

(instance cExitMindBottom of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(if (rightTPMonitor on:)
			(if (not (IsFlag 173))
				(rightTPMonitor toggle:)
				(= local4 0)
			)
			(if (rightMindProbe cel:)
				(gCurRoom setScript: sMindProbe 0 768)
			else
				(gCurRoom changeScene: 768 1)
			)
		else
			(gCurRoom changeScene: 768 1)
		)
	)
)

(instance sRightSolarSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 741 play:)
				(if (not (rightSolarSwitch on:))
					(= register 0)
					(rightSolarSwitch toggle: setCycle: End self)
				else
					(= register 1)
					(rightSolarSwitch setCycle: Beg self)
				)
			)
			(1
				(if register
					(lowerSolarSwitch toggle:)
					(if (IsFlag 188)
						(proc0_8 2788)
						(if (IsFlag 139)
							(gCurRoom setScript: sBeamSwitch)
						else
							(gGame handsOn:)
							(self dispose:)
						)
					else
						(gGame handsOn:)
						(self dispose:)
					)
				else
					(if (IsFlag 188)
						(sPowerUp init:)
						(proc0_8 2787)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance rightBulbs of Prop
	(properties
		x 3
		y 60
		loop 2
		view 7770
	)
)

(instance sRightBulbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 1)
				(= ticks 15)
			)
			(1
				(client hide:)
				(= ticks 45)
			)
			(2
				(client show: cel: 0)
				(= ticks 15)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance lowerLights of SwitchView
	(properties
		x 48
		y 52
		loop 1
		view 5731
		myFlag 151
		offCel 0
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self setScript: sLowerLights)
		)
	)
)

(instance sLowerLights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(client hide:)
				(= ticks 30)
			)
			(2
				(client show:)
				(self init:)
			)
		)
	)
)

(instance lowerPulpitSwitch of SwitchView
	(properties
		y 206
		view 2736
		myFlag 141
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(self signal: (| (self signal:) $1000))
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 7)
			)
			(5 ; Do
				(if (self on:)
					(gGame handsOff:)
					(gCurRoom setScript: sPulpitRetract 0 self)
				else
					(gGame handsOff:)
					(self toggle:)
					(gCurRoom setScript: sPulpitExtend 0 self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerOutElevSwitch of SwitchView
	(properties
		x 127
		y 88
		view 2741
		myFlag 145
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sOutElevator)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerInElevSwitch of SwitchView
	(properties
		x 179
		y 88
		loop 1
		view 2741
		myFlag 152
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sInElevator)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerBoosterSwitch of SwitchView
	(properties
		x 177
		y 42
		view 2732
		myFlag 140
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(if (IsFlag 170)
					(sSayHelp init: 0 0 17)
				else
					(sSayHelp init: 0 0 14)
				)
			)
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sBoosterSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerPowerGauge of SwitchView
	(properties
		x 238
		y 88
		loop 1
		view 2732
		myFlag 188
		dontForce 1
	)

	(method (initialCel)
		(if (or (not (self on:)) (and (self on:) (not (IsFlag 144))))
			(= cel 0)
		)
	)
)

(instance lowerSolarSwitch of SwitchView
	(properties
		x 411
		y 200
		view 2735
		myFlag 144
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 8)
			)
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sSolarSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerBeamSwitch of SwitchView
	(properties
		x 204
		y 299
		cycleSpeed 4
		view 2737
		myFlag 139
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 10)
			)
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sBeamSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lowerScreenSwitch of SwitchView
	(properties
		x 131
		y 296
		view 2743
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 150)
			(leftHorizLine init:)
			(rightHorizLine init:)
			(leftVertLine init:)
			(rightVertLine init:)
			(target init:)
		)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self quickToggle:)
				(cond
					((not (IsFlag 188)) 0)
					((IsFlag 150)
						(ClearFlag 150)
						(leftHorizLine dispose:)
						(rightHorizLine dispose:)
						(leftVertLine dispose:)
						(rightVertLine dispose:)
						(target dispose:)
						(ClearFlag 205)
						(if (IsFlag 139)
							(gGame handsOff:)
							(gCurRoom setScript: sBeamSwitch)
						)
						(localproc_1)
					)
					(else
						(SetFlag 150)
						(leftHorizLine init:)
						(rightHorizLine init:)
						(leftVertLine init:)
						(rightVertLine init:)
						(target init:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftHorizDial of Dial
	(properties
		x 109
		y 150
		loop 3
		view 2743
	)

	(method (init)
		(super init: &rest)
		(= slave leftHorizLine)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (control param1 &tmp temp0)
		(if (not (IsFlag 205))
			(= temp0 (+ (slave y:) (* param1 1)))
			(= temp0 (Max temp0 108))
			(= temp0 (Min temp0 197))
			(slave y: temp0)
			(if
				(and
					(< (- (target y:) 8) (leftHorizLine y:) (+ (target y:) 8))
					(< (- (target y:) 8) (rightHorizLine y:) (+ (target y:) 8))
					(< (- (target x:) 8) (leftVertLine x:) (+ (target x:) 8))
					(< (- (target x:) 8) (rightVertLine x:) (+ (target x:) 8))
				)
				(gGame handsOff:)
				(gCurRoom setScript: sCenterTarget)
			)
		)
	)
)

(instance leftVertDial of Dial
	(properties
		x 101
		y 220
		loop 4
		view 2743
	)

	(method (init)
		(super init: &rest)
		(= slave leftVertLine)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (control param1 &tmp temp0)
		(if (not (IsFlag 205))
			(= temp0 (+ (slave x:) (* param1 1)))
			(= temp0 (Max temp0 208))
			(= temp0 (Min temp0 297))
			(slave x: temp0)
			(if
				(and
					(< (- (target y:) 8) (leftHorizLine y:) (+ (target y:) 8))
					(< (- (target y:) 8) (rightHorizLine y:) (+ (target y:) 8))
					(< (- (target x:) 8) (leftVertLine x:) (+ (target x:) 8))
					(< (- (target x:) 8) (rightVertLine x:) (+ (target x:) 8))
				)
				(gGame handsOff:)
				(gCurRoom setScript: sCenterTarget)
			)
		)
	)
)

(instance rightHorizDial of Dial
	(properties
		x 312
		y 148
		loop 1
		view 2743
	)

	(method (init)
		(super init: &rest)
		(= slave rightHorizLine)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (control param1 &tmp temp0)
		(if (not (IsFlag 205))
			(= temp0 (+ (slave y:) (* param1 1)))
			(= temp0 (Max temp0 108))
			(= temp0 (Min temp0 197))
			(slave y: temp0)
			(if
				(and
					(< (- (target y:) 8) (leftHorizLine y:) (+ (target y:) 8))
					(< (- (target y:) 8) (rightHorizLine y:) (+ (target y:) 8))
					(< (- (target x:) 8) (leftVertLine x:) (+ (target x:) 8))
					(< (- (target x:) 8) (rightVertLine x:) (+ (target x:) 8))
				)
				(gGame handsOff:)
				(gCurRoom setScript: sCenterTarget)
			)
		)
	)
)

(instance rightVertDial of Dial
	(properties
		x 319
		y 219
		loop 2
		view 2743
	)

	(method (init)
		(super init: &rest)
		(= slave rightVertLine)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (control param1 &tmp temp0)
		(if (not (IsFlag 205))
			(= temp0 (+ (slave x:) (* param1 1)))
			(= temp0 (Max temp0 208))
			(= temp0 (Min temp0 297))
			(slave x: temp0)
			(if
				(and
					(< (- (target y:) 8) (leftHorizLine y:) (+ (target y:) 8))
					(< (- (target y:) 8) (rightHorizLine y:) (+ (target y:) 8))
					(< (- (target x:) 8) (leftVertLine x:) (+ (target x:) 8))
					(< (- (target x:) 8) (rightVertLine x:) (+ (target x:) 8))
				)
				(gGame handsOff:)
				(gCurRoom setScript: sCenterTarget)
			)
		)
	)
)

(instance leftHorizLine of View
	(properties
		loop 5
		view 2743
	)

	(method (init)
		(super init: &rest)
		(= x 195)
		(if (IsFlag 205)
			(= y global248)
		else
			(= y (Random 108 197))
		)
		(approachX hotVerbs: 0)
	)
)

(instance leftVertLine of View
	(properties
		loop 5
		cel 1
		view 2743
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 205)
			(= x global247)
		else
			(= x (Random 208 297))
		)
		(= y 100)
		(approachX hotVerbs: 0)
	)
)

(instance rightHorizLine of View
	(properties
		loop 5
		cel 2
		view 2743
	)

	(method (init)
		(super init: &rest)
		(= x 195)
		(if (IsFlag 205)
			(= y global248)
		else
			(= y (Random 108 197))
		)
		(self setPri: (+ (leftVertLine priority:) 1))
		(approachX hotVerbs: 0)
	)
)

(instance rightVertLine of View
	(properties
		loop 5
		cel 3
		view 2743
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 205)
			(= x global247)
		else
			(= x (Random 208 297))
		)
		(= y 100)
		(self setPri: (+ (leftVertLine priority:) 1))
		(approachX hotVerbs: 0)
	)
)

(instance target of View
	(properties
		loop 5
		cel 4
		view 2743
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 205)
			(= x global247)
			(= y global248)
		else
			(= x (Random 219 297))
			(= y (Random 118 187))
		)
		(approachX hotVerbs: 0)
	)
)

(instance sCenterTarget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(if (< (leftHorizLine y:) (target y:))
					(leftHorizLine y: (+ (leftHorizLine y:) 1))
					(= register 1)
				)
				(if (> (leftHorizLine y:) (target y:))
					(leftHorizLine y: (- (leftHorizLine y:) 1))
					(= register 1)
				)
				(if (< (leftVertLine x:) (target x:))
					(leftVertLine x: (+ (leftVertLine x:) 1))
					(= register 1)
				)
				(if (> (leftVertLine x:) (target x:))
					(leftVertLine x: (- (leftVertLine x:) 1))
					(= register 1)
				)
				(if (< (rightHorizLine y:) (target y:))
					(rightHorizLine y: (+ (rightHorizLine y:) 1))
					(= register 1)
				)
				(if (> (rightHorizLine y:) (target y:))
					(rightHorizLine y: (- (rightHorizLine y:) 1))
					(= register 1)
				)
				(if (< (rightVertLine x:) (target x:))
					(rightVertLine x: (+ (rightVertLine x:) 1))
					(= register 1)
				)
				(if (> (rightVertLine x:) (target x:))
					(rightVertLine x: (- (rightVertLine x:) 1))
					(= register 1)
				)
				(= cycles 10)
			)
			(1
				(if (not register)
					(global206 delete: (leftHorizDial cwFeat:))
					(global206 delete: (leftHorizDial ccwFeat:))
					(global206 delete: (rightHorizDial cwFeat:))
					(global206 delete: (rightHorizDial ccwFeat:))
					(global206 delete: (leftVertDial cwFeat:))
					(global206 delete: (leftVertDial ccwFeat:))
					(global206 delete: (rightVertDial cwFeat:))
					(global206 delete: (rightVertDial ccwFeat:))
					(SetFlag 205)
					(= global247 (target x:))
					(= global248 (target y:))
					(gGame handsOn:)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance sOutElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 708 play:)
				(if (not (lowerOutElevSwitch on:))
					(= register 0)
					(lowerOutElevSwitch toggle: setCycle: End self)
				else
					(= register 1)
					(lowerOutElevSwitch setCycle: Beg self)
				)
			)
			(1
				(if register
					(lowerOutElevSwitch toggle:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sInElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 709 play:)
				(if (not (lowerInElevSwitch on:))
					(= register 0)
					(lowerInElevSwitch toggle: setCycle: End self)
				else
					(= register 1)
					(lowerInElevSwitch setCycle: Beg self)
				)
			)
			(1
				(if register
					(lowerInElevSwitch toggle:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBoosterSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 742 play:)
				(if (not (lowerBoosterSwitch on:))
					(= register 0)
					(lowerBoosterSwitch show: setCycle: End self)
				else
					(= register 1)
					(powerBoostSnd stop:)
					(ClearFlag 140)
					(lowerBoosterSwitch setCycle: Beg self)
				)
			)
			(1
				(if (not register)
					(lowerBoosterSwitch toggle:)
					(if (and (IsFlag 188) (IsFlag 144))
						(sPowerUp init:)
						(powerBoostSnd play:)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSolarSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 741 play:)
				(if (not (lowerSolarSwitch on:))
					(= register 0)
					(lowerSolarSwitch toggle: setCycle: End self)
				else
					(= register 1)
					(lowerSolarSwitch setCycle: Beg self)
				)
			)
			(1
				(if register
					(lowerSolarSwitch toggle:)
					(if (IsFlag 188)
						(proc0_8 2788)
						(if (IsFlag 139)
							(gCurRoom setScript: sBeamSwitch)
						else
							(gGame handsOn:)
							(self dispose:)
						)
					else
						(gGame handsOn:)
						(self dispose:)
					)
				else
					(if (IsFlag 188)
						(sPowerUp init:)
						(proc0_8 2787)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sBeamSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 743 play:)
				(if (not (lowerBeamSwitch on:))
					(= register 0)
					(lowerBeamSwitch toggle: setCycle: End self)
				else
					(= register 1)
					(lowerBeamSwitch setCycle: Beg self)
				)
			)
			(1
				(cond
					(register
						(lowerBeamSwitch toggle:)
						(localproc_1)
						(gGame handsOn:)
						(self dispose:)
					)
					(
						(and
							(IsFlag 188)
							(or
								(not (IsFlag 205))
								(not (IsFlag 141))
								(not (IsFlag 173))
								(< (lowerPowerGauge cel:) 11)
							)
						)
						(gCurRoom setScript: sBeamWarning)
						(sPowerUp dispose:)
						(sPowerDown init:)
					)
					(else
						(if (and (IsFlag 173) (IsFlag 205) (IsFlag 139))
							(gBackMusic2 stop:)
							(sStartBeamSound init:)
						)
						(sPowerUp dispose:)
						(sPowerDown init:)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance sStartBeamSound of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 7431 play: self)
			)
			(1
				(gBackMusic2 number: 723 loop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance sBeamWarning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 736 play: self)
			)
			(1
				(roomSfx number: 743 play:)
				(lowerBeamSwitch setCycle: Beg self)
			)
			(2
				(lowerBeamSwitch toggle:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPulpitExtend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 741 play:)
				(if (== register leftPulpitSwitch)
					(register setPri: (+ (leftMainSwitch priority:) 2))
				)
				(register setCycle: End self)
			)
			(1
				(if (IsFlag 188)
					(gCurRoom changeScene: 781 4)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sPulpitRetract of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 741 play:)
				(switch register
					(leftPulpitSwitch
						(register setPri: (+ (leftMainSwitch priority:) 2))
						(register setCycle: Beg self)
					)
					(lowerPulpitSwitch
						(register setCycle: Beg self)
					)
					(else
						(= cycles 2)
					)
				)
			)
			(1
				(if register
					(register toggle: 0)
				)
				(ClearFlag 173)
				(ClearFlag 205)
				(ClearFlag 139)
				(if (IsFlag 188)
					(gCurRoom changeScene: 781 4)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sPowerDown of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
		(= register 0)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lowerPowerGauge setCycle: Beg self)
			)
			(1
				(self dispose:)
				(sPowerUp init:)
			)
		)
	)
)

(instance sPowerUp of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
		(= register 0)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit)
		(if (not (IsFlag 188))
			(self dispose:)
		)
		(if (not (IsFlag 144))
			(self dispose:)
		)
		(if (and (not register) (IsFlag 140))
			(self register: 1 seconds: 0 ticks: 0 changeState: 0 cue:)
		)
		(if (and register (not (IsFlag 140)))
			(self register: 0 seconds: 0 ticks: 0 changeState: -1 cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 140)
					(= ticks 60)
				else
					(= seconds 12)
				)
			)
			(1
				(lowerPowerGauge cel: (+ (lowerPowerGauge cel:) 1))
				(= cycles 1)
			)
			(2
				(cond
					((and (not (IsFlag 140)) (>= (lowerPowerGauge cel:) 11))
						(lowerPowerGauge cel: 11)
						(self dispose:)
					)
					((and (IsFlag 140) (>= (lowerPowerGauge cel:) 12))
						(gGame handsOff:)
						(self cue:)
					)
					(else
						(self changeState: -1 cue:)
					)
				)
			)
			(3
				(if (gCurRoom script:)
					(self state: 2)
				)
				(= cycles 2)
			)
			(4
				(if (gCast contains: lowerPowerGauge)
					(lowerPowerGauge setCycle: End self)
				else
					(lowerPowerGauge cel: 0)
					(= cycles 2)
				)
				(roomSfx number: 788 play:)
				(if (and (gCast contains: upperHatch) (upperHatch cel:))
					(upperHatch loop: 0 x: 420 y: 1)
					(upperHatch cel: (upperHatch lastCel:))
					(partFeat init:)
				)
			)
			(5
				(if (gCast contains: lowerBoosterSwitch)
					(lowerBoosterSwitch setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(6
				(powerBoostSnd stop:)
				(SetFlag 170)
				(lowerPowerGauge cel: 0)
				(= local6 1)
				(gCurRoom setScript: sResetLevers)
			)
		)
	)
)

(instance sResetLevers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (gCurRoom scene:)
					(768
						(if (mainPulpitSwitch cel:)
							(= register mainPulpitSwitch)
							(gCurRoom changeScene: 781 4)
						else
							(cShutDown doit:)
							(= cycles 2)
						)
					)
					(769
						(if (leftPulpitSwitch cel:)
							(= register leftPulpitSwitch)
							(gCurRoom changeScene: 781 4)
						else
							(cShutDown doit:)
							(= cycles 2)
						)
					)
					(770
						(if (rightSolarSwitch cel:)
							(rightSolarSwitch setCycle: Beg self)
						else
							(= cycles 2)
						)
					)
					(783
						(if (lowerPulpitSwitch cel:)
							(= register lowerPulpitSwitch)
							(gCurRoom changeScene: 781 4)
						else
							(if (lowerSolarSwitch cel:)
								(lowerSolarSwitch setCycle: Beg)
							)
							(cShutDown doit:)
							(= cycles 2)
						)
					)
					(784
						(if (gCast contains: upperPulpitSwitch)
							(= register upperPulpitSwitch)
							(gCurRoom changeScene: 781 4)
						else
							(cShutDown doit:)
							(= cycles 2)
							(upperSolarSwitch dispose:)
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

(instance leftChain of SwitchView
	(properties
		x 326
		y 207
		loop 10
		view 7769
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 5)
			)
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: sPullChain)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftPulpitSwitch of SwitchView
	(properties
		x 346
		y 299
		loop 11
		view 7769
		myFlag 141
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(self signal: (| (self signal:) $1000))
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 7)
			)
			(5 ; Do
				(if (self on:)
					(gGame handsOff:)
					(gCurRoom setScript: sPulpitRetract 0 self)
				else
					(gGame handsOff:)
					(self toggle:)
					(gCurRoom setScript: sPulpitExtend 0 self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftMainSwitch of SwitchView
	(properties
		x 373
		y 299
		cycleSpeed 10
		loop 4
		view 7769
		myFlag 143
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 1)
			)
			(5 ; Do
				(self toggle:)
				(gGame handsOff:)
				(gCurRoom setScript: sMainSwitch)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftLights of SwitchView
	(properties
		x 371
		y 296
		loop 5
		view 7769
		myFlag 151
		offCel 0
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self setPri: (+ (leftMainSwitch priority:) 1) setCycle: Fwd)
		)
	)
)

(instance templeSwitch of SwitchView
	(properties
		x 93
		y 290
		view 7769
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 4)
			)
			(5 ; Do
				(self quickToggle:)
				(if (IsFlag 188)
					(leftTempleMonitor toggle:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance domainSwitch of SwitchView
	(properties
		x 155
		y 290
		loop 1
		view 7769
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 4)
			)
			(5 ; Do
				(self quickToggle:)
				(if (IsFlag 188)
					(leftDomainMonitor toggle:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance roostSwitch of SwitchView
	(properties
		x 209
		y 290
		loop 2
		view 7769
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 4)
			)
			(5 ; Do
				(self quickToggle:)
				(if (IsFlag 188)
					(leftRoostMonitor toggle:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fortressSwitch of SwitchView
	(properties
		x 262
		y 290
		loop 3
		view 7769
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5 24)
	)

	(method (quickToggle)
		(super quickToggle:)
		(roomSfx number: 719 play:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; ???
				(sSayHelp init: 0 0 4)
			)
			(5 ; Do
				(self quickToggle:)
				(if (IsFlag 188)
					(leftFortressMonitor toggle:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftTempleMonitor of SwitchView
	(properties
		x 48
		y 114
		cycleSpeed 36
		loop 3
		view 769
		myFlag 148
		offCel 0
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(if (self on:)
			(self setCycle: Fwd)
		)
	)

	(method (toggle)
		(super toggle: &rest)
		(cond
			((not (self on:))
				(self setCycle: 0)
			)
			((not cycler)
				(self setCycle: Fwd)
			)
		)
	)
)

(instance leftDomainMonitor of SwitchView
	(properties
		x 197
		y 121
		cycleSpeed 36
		loop 2
		view 769
		myFlag 146
		offCel 0
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(if (self on:)
			(self setCycle: Fwd)
		)
	)

	(method (toggle)
		(super toggle: &rest)
		(cond
			((not (self on:))
				(self setCycle: 0)
			)
			((not cycler)
				(self setCycle: Fwd)
			)
		)
	)
)

(instance leftRoostMonitor of SwitchView
	(properties
		x 93
		y 233
		cycleSpeed 36
		view 769
		myFlag 147
		offCel 0
		dontForce 1
	)

	(method (init)
		(super init: &rest)
		(if (self on:)
			(self setCycle: Fwd)
		)
	)

	(method (toggle)
		(super toggle: &rest)
		(cond
			((not (self on:))
				(self setCycle: 0)
			)
			((not cycler)
				(self setCycle: Fwd)
			)
		)
	)
)

(instance leftFortressMonitor of SwitchView
	(properties
		x 226
		y 229
		loop 1
		view 769
		myFlag 149
		offCel 0
		dontForce 1
	)
)

(instance sPullChain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leftChain setCycle: End self)
			)
			(1
				(roomSfx number: 734 play:)
				(leftChain setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMainSwitch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomSfx number: 717 play:)
				(if (not (leftMainSwitch cel:))
					(leftMainSwitch setCycle: End self)
				else
					(leftMainSwitch setCycle: Beg self)
					(if (IsFlag 188)
						(leftLights toggle: setCycle: 0)
					)
				)
			)
			(1
				(if (and (IsFlag 171) (IsFlag 143))
					(roomSfx number: 718 play:)
					(leftLights
						toggle:
						x: 373
						y: 299
						setPri: (+ (leftMainSwitch priority:) 1)
						loop: 13
						cel: 0
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((not (IsFlag 171))
						(= cycles 2)
					)
					((not (leftMainSwitch cel:))
						(gBackMusic2 stop:)
						(roomSfx number: 786 play:)
						(= local6 1)
						(gCurRoom setScript: sResetLevers)
					)
					((IsFlag 171)
						(if (leftPulpitSwitch cel:)
							(ClearFlag 141)
							(leftPulpitSwitch setCycle: Beg self)
						else
							(= cycles 2)
						)
						(leftLights loop: 5 x: 371 y: 296 setCycle: Fwd)
						(if (IsFlag 144)
							(sPowerUp init:)
						)
						(SetFlag 188)
						(ClearFlag 139)
						(gBackMusic2 number: 785 play:)
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

(instance mainLirylSwitch of SwitchView
	(properties
		x 296
		y 171
		view 7768
		myFlag 138
		offCel 0
	)
)

(instance mainBeamSwitch of SwitchView
	(properties
		x 233
		y 242
		loop 1
		view 7768
		myFlag 139
		offCel 0
	)
)

(instance mainBoosterSwitch of SwitchView
	(properties
		x 233
		y 184
		loop 2
		view 7768
		myFlag 140
		offCel 0
	)
)

(instance mainPulpitSwitch of SwitchView
	(properties
		x 148
		y 224
		loop 4
		view 7768
		myFlag 141
		offCel 0
	)
)

(instance mainTPMonitor of SwitchView
	(properties
		x 376
		y 171
		loop 24
		view 7768
		myFlag 142
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self cel: (self lastCel:))
		)
	)
)

(instance mainMainSwitch of SwitchView
	(properties
		x 187
		y 184
		loop 6
		view 7768
		myFlag 143
		offCel 0
	)
)

(instance mainSolarSwitch of SwitchView
	(properties
		x 312
		y 217
		loop 7
		view 7768
		myFlag 144
		offCel 0
	)
)

(instance mainPowerGauge of SwitchView
	(properties
		x 250
		y 195
		loop 9
		view 7768
		myFlag 144
		offCel 0
	)
)

(instance mainOutElevSwitch of SwitchView
	(properties
		x 199
		y 197
		loop 11
		view 7768
		myFlag 145
		offCel 0
	)
)

(instance mainInElevSwitch of SwitchView
	(properties
		x 224
		y 196
		loop 12
		view 7768
		myFlag 152
		offCel 0
	)
)

(instance mainLights of SwitchView
	(properties
		x 175
		y 185
		loop 13
		view 7768
		myFlag 151
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self setCycle: Fwd)
		)
	)
)

(instance mainBulbs of SwitchView
	(properties
		x 214
		y 163
		loop 23
		view 7768
		myFlag 151
		offCel 0
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag myFlag)
			(self setCycle: Fwd)
		)
	)
)

(instance mainTempleMonitor of SwitchView
	(properties
		x 15
		y 105
		loop 19
		view 7768
		myFlag 148
		offCel 0
	)
)

(instance mainDomainMonitor of SwitchView
	(properties
		x 100
		y 112
		loop 21
		view 7768
		myFlag 146
		offCel 0
	)
)

(instance mainRoostMonitor of SwitchView
	(properties
		x 30
		y 156
		loop 20
		view 7768
		myFlag 147
		offCel 0
	)
)

(instance mainFortressMonitor of SwitchView
	(properties
		x 104
		y 157
		loop 22
		view 7768
		myFlag 149
		offCel 0
	)
)

(instance cShutDown of Code
	(properties)

	(method (doit)
		(powerBoostSnd stop:)
		(ClearFlag 188)
		(ClearFlag 205)
		(localproc_1)
		(mainLirylSwitch toggle: 0)
		(mainBeamSwitch toggle: 0)
		(mainBoosterSwitch toggle: 0)
		(mainPulpitSwitch toggle: 0)
		(mainTPMonitor toggle: 0)
		(mainMainSwitch toggle: 0)
		(mainSolarSwitch toggle: 0)
		(mainPowerGauge toggle: 0)
		(mainOutElevSwitch toggle: 0)
		(mainInElevSwitch toggle: 0)
		(mainLights toggle: 0)
		(mainBulbs toggle: 0)
		(mainDomainMonitor toggle: 0)
		(mainFortressMonitor toggle: 0)
		(mainRoostMonitor toggle: 0)
		(mainTempleMonitor toggle: 0)
		(leftMainSwitch toggle: 0)
		(leftLights toggle: 0)
		(leftDomainMonitor toggle: 0)
		(leftFortressMonitor toggle: 0)
		(leftRoostMonitor toggle: 0)
		(leftTempleMonitor toggle: 0)
		(leftPulpitSwitch toggle: 0)
		(lowerPulpitSwitch toggle: 0)
		(lowerOutElevSwitch toggle: 0)
		(lowerInElevSwitch toggle: 0)
		(lowerLights toggle: 0 dispose:)
		(lowerBoosterSwitch toggle: 0)
		(lowerPowerGauge toggle: 0)
		(lowerSolarSwitch toggle: 0)
		(lowerBeamSwitch toggle: 0)
		(lowerScreenSwitch toggle: 0)
		(ClearFlag 150)
		(leftHorizLine dispose:)
		(rightHorizLine dispose:)
		(leftVertLine dispose:)
		(rightVertLine dispose:)
		(target dispose:)
		(rightLirylSwitch toggle: 0)
		(rightSolarSwitch toggle: 0)
		(rightTPMonitor toggle: 0)
		(rightBulbs dispose:)
		(monitorStatic stop:)
		(upperMainSwitch toggle: 0)
		(upperLirylSwitch toggle: 0)
		(upperMainLights toggle: 0)
		(upperBulbs toggle: 0)
		(upperDomainMonitor toggle: 0)
		(upperTempleMonitor toggle: 0)
	)
)

(instance sSayHelp of Script
	(properties)

	(method (init param1 param2 param3)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local2 (gCurRoom scene:))
				(gCurRoom changeScene: 782 7)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(switch register
					(1
						(gMessager say: 18 24 0 0 self 720) ; "That one looks important!"
					)
					(2
						(gMessager say: 19 24 0 0 self 720) ; "Think about(click) far away places! Then you will see!"
					)
					(3
						(gMessager say: 20 24 0 0 self 720) ; "The machine needs constant adjustment."
					)
					(4
						(gMessager say: 21 24 0 0 self 720) ; "The priests can see far away places."
					)
					(5
						(gMessager say: 22 24 0 0 self 720) ; "The gong calls us to worship."
					)
					(7
						(gMessager say: 24 24 0 0 self 720) ; "From here, the priests can travel to distant places."
					)
					(8
						(gMessager say: 25 24 0 0 self 720) ; "The sun powers the Temple. The sky can be revealed(click) to those inside."
					)
					(9
						(gMessager say: 26 24 0 0 self 720) ; "The Sun moves through the sky. The beam must be aligned."
					)
					(10
						(gMessager say: 27 24 0 0 self 720) ; "The light makes you disappear here and(snap)... reappear there!"
					)
					(12
						(gMessager say: 28 24 0 0 self 720) ; "I've never seen them touch that one."
					)
					(14
						(gMessager say: 30 24 0 0 self 720) ; "That one could be dangerous."
					)
					(15
						(gMessager say: 31 24 0 0 self 720) ; "Hmmm! I wonder what's in there?"
					)
					(16
						(gMessager say: 32 24 0 0 self 720) ; "Oooo.... That looks complicated!"
					)
					(17
						(gMessager say: 30 24 0 0 self 720) ; "That one could be dangerous."
					)
					(18
						(gMessager say: 17 0 28 0 self 720) ; "This chamber is used by the priests. I do not(click) know all their secrets."
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
				(if (>= (++ local3) 3)
					(= local3 0)
					(gGame normalizeCode: -1)
					(gGame normalizeCursor:)
				)
				(switch local2
					(762
						(= temp0 7)
					)
					(765
						(= temp0 1)
					)
					(768
						(= temp0 1)
					)
					(769
						(= temp0 2)
					)
					(770
						(= temp0 8)
					)
					(781
						(= temp0 4)
					)
					(782
						(= temp0 7)
					)
					(783
						(= temp0 1)
					)
					(784
						(= temp0 1)
					)
				)
				(gCurRoom changeScene: local2 temp0)
			)
		)
	)
)

(instance batteryNoise of Sound
	(properties
		number 740
	)
)

(instance sBatteryFlash of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(= lastTicks gGameTime)
		(self changeState: (+ state 1) &rest)
	)

	(method (doit)
		(if (IsFlag 343)
			(ClearFlag 343)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(batteryNoise setVol: 64 play:)
				(= ticks 30)
			)
			(2
				(self init:)
			)
		)
	)
)

