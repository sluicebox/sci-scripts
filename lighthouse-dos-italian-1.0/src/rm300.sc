;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use Print)
(use Dialog)
(use PanelPlane)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm300 of LightRoom
	(properties)

	(method (init)
		(if (not (IsFlag 33))
			(switch (Random 1 4)
				(1
					(= local0 whale)
				)
				(2
					(= local0 leftPot)
				)
				(3
					(= local0 rightPot)
				)
				(4
					(= local0 shell)
				)
			)
		)
		(super init: &rest)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(24
				(DisposeScript 3)
				(gCurRoom setScript: sDrive)
			)
			(320
				(= local3 1)
				(Lock rsAUDIO 101 1)
				(gBackMusic number: 101 loop: -1 play: 127 0)
				(sndWaves play: 0 0)
				(gCurRoom changeScene: 299 7)
			)
			(else
				(Lock rsAUDIO 101 1)
				(gBackMusic number: 101 loop: -1 play: 127 0)
				(sndWaves play: 0 0)
				(gCurRoom changeScene: 302 3)
			)
		)
	)

	(method (changeScene param1)
		(moveShed dispose:)
		(moveUpRight dispose:)
		(rShedDoor dispose:)
		(rFrontDoor dispose:)
		(fMailbox dispose:)
		(fFusebox dispose:)
		(fLantern dispose:)
		(vCrowbar dispose:)
		(vShedLockView dispose:)
		(vShedLockOpened dispose:)
		(vLeftWindow dispose:)
		(vRightWindow dispose:)
		(pLightning dispose:)
		(pDoorLock dispose:)
		(pDoorKnocker dispose:)
		(whale dispose:)
		(leftPot dispose:)
		(rightPot dispose:)
		(shell dispose:)
		(super changeScene: param1 &rest)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(if (OneOf (gCurRoom scene:) 308 309 310)
				(gBackMusic2 fade: 40 10 5 0 0)
			else
				(gBackMusic2 fade: 10 10 5 0 0)
			)
		)
		(if (gTimers contains: tBabyTimer)
			(cond
				((OneOf (gCurRoom scene:) 308 309 310)
					(sndBabyCry fade: 40 10 5 0 0)
				)
				((OneOf (gCurRoom scene:) 325 357)
					(sndBabyCry fade: 100 10 5 0 0)
				)
				(else
					(sndBabyCry fade: 10 10 5 0 0)
				)
			)
		)
		(cond
			((OneOf (gCurRoom scene:) 308 309 310)
				(sndWaves fade: 127 10 5 0 0)
			)
			((== (gCurRoom scene:) 290)
				(sndWaves fade: 90 10 5 0 0)
			)
			((OneOf (gCurRoom scene:) 313 302)
				(sndWaves fade: 50 10 5 0 0)
			)
			(else
				(sndWaves fade: 70 10 5 0 0)
			)
		)
		(switch param1
			(290
				(if (not (IsFlag 33))
					(pDoorLock init:)
				)
				(pDoorKnocker init:)
				(rFrontDoor init: 6316 0 0 0)
				((ScriptID 1 5) newPic: 301 3 exitCode: doorDownExitCode) ; exitDown
				((ScriptID 1 2) newPic: 299 7 exitCode: doorBackExitCode) ; exitBack
			)
			(299
				(if (== local2 290)
					((ScriptID 1 2) newPic: 290 3) ; exitBack
				else
					((ScriptID 1 2) newPic: 303 3) ; exitBack
				)
				((ScriptID 1 1) newPic: 305 7) ; exitForward
				((ScriptID 1 3) newPic: 308 4) ; exitLeft
				(if local3
					(= local3 0)
					(gMySoundFX do: 112)
				)
			)
			(301
				(whale init:)
				(shell init:)
				(leftPot init:)
				(rightPot init:)
				(if (IsFlag 35)
					((ScriptID 1 6) newPic: 306 3) ; exitUp
				else
					((ScriptID 1 6) newPic: 290 3) ; exitUp
				)
				((ScriptID 1 6) exitCode: potsExitCode) ; exitUp
				(if local3
					(= local3 0)
					(gMySoundFX do: 112)
				)
			)
			(302
				(fMailbox init:)
				(if (not (IsFlag 35))
					(vLeftWindow view: 324 loop: 0 x: 79 y: 82 init:)
					(vRightWindow view: 324 loop: 1 x: 275 y: 84 init:)
				)
				(pLightning init: setScript: sRandomStorm)
				((ScriptID 1 1) newPic: 304 3) ; exitForward
				((ScriptID 1 2) newPic: 313 7) ; exitBack
			)
			(303
				(fLantern init:)
				(if (IsFlag 35)
					((ScriptID 1 1) newPic: 306 3) ; exitForward
				else
					((ScriptID 1 1) newPic: 290 3) ; exitForward
				)
				((ScriptID 1 4) newPic: 308 4) ; exitRight
				((ScriptID 1 2) newPic: 299 7) ; exitBack
			)
			(304
				(if (not (IsFlag 35))
					(vLeftWindow view: 327 loop: 0 x: 0 y: 83 init:)
					(vRightWindow view: 327 loop: 1 x: 354 y: 85 init:)
				)
				(pLightning init: setScript: sRandomStorm)
				((ScriptID 1 1) newPic: 303 3) ; exitForward
				((ScriptID 1 2) newPic: 305 7) ; exitBack
				(moveShed newPic: 308 4)
			)
			(305
				((ScriptID 1 1) newPic: 313 7) ; exitForward
				((ScriptID 1 2) newPic: 304 3) ; exitBack
			)
			(306
				(if (not (IsFlag 33))
					(pDoorLock init:)
				)
				(pDoorKnocker init:)
				(rFrontDoor init: 6316 0 0 0)
				((ScriptID 1 5) newPic: 301 3 exitCode: doorDownExitCode) ; exitDown
				((ScriptID 1 2) newPic: 299 7 exitCode: doorBackExitCode) ; exitBack
			)
			(308
				(if (not (IsFlag 35))
					(vLeftWindow view: 323 loop: 2 x: 0 y: 25 init:)
					(vRightWindow view: 323 loop: 1 x: 407 y: 33 init:)
				)
				(if (IsFlag 56)
					(vShedLockOpened init:)
				)
				((ScriptID 1 1) newPic: 310 5) ; exitForward
				((ScriptID 1 3) newPic: 309 6) ; exitLeft
			)
			(309
				(if (IsFlag 56)
					(vShedLockOpened init:)
				)
				((ScriptID 1 1) ; exitForward
					newPic: 305 7
					createPoly: 99 105 230 105 230 207 99 207
				)
				(moveUpRight newPic: 303 3)
				((ScriptID 1 4) newPic: 308 4) ; exitRight
			)
			(310
				(if (not (IsFlag 56))
					(vShedLockView init:)
				)
				((ScriptID 1 7) newPic: 308 4 exitCode: shedSouthExitCode) ; exitBackUp
				((ScriptID 1 3) newPic: 309 6 exitCode: shedWestExitCode) ; exitLeft
				(rShedDoor init: 320 0 159 13 300)
			)
			(313
				((ScriptID 1 2) newPic: 302 3 exitCode: carDoorBackExitCode) ; exitBack
				(rCarDoor init: 4322 0 97 56 300)
			)
			(325
				(if
					(and
						(not (IsFlag 104))
						(not (IsFlag 16))
						(not (IsFlag 162))
					)
					(SetFlag 104)
					(gCurRoom setScript: sLightningStrike)
				else
					((ScriptID 1 2) newPic: 357 7) ; exitBack
				)
			)
			(357
				(= local3 1)
				((ScriptID 1 1) newPic: 299 7) ; exitForward
				((ScriptID 1 2) newPic: 325 3) ; exitBack
			)
		)
		(= local2 param1)
		(if (not (self script:))
			(gGame handsOn:)
		)
	)

	(method (dispose)
		(if (!= gNewRoomNum 320)
			(Lock rsAUDIO 101 0)
			(gBackMusic stop:)
			(sndWaves stop:)
		)
		(if (gTimers contains: tBabyTimer)
			(tBabyTimer dispose: delete:)
		)
		(rShedDoor dispose:)
		(rFrontDoor dispose:)
		(super dispose: &rest)
	)
)

(instance sRandomStorm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 60))
			)
			(1
				(client show: setCycle: End self)
			)
			(2
				(client setCel: 0 hide:)
				(= ticks (Random 45 90))
			)
			(3
				(if (Random 0 1)
					(gMySoundFX do: 10501)
				else
					(gMySoundFX do: 10502)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance sLightningStrike of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 90)
			)
			(1
				(gGame handsOff:)
				(Load rsPIC 324)
				(= cycles 1)
			)
			(2
				(gCurRoom drawPic: 324)
				(= cycles 30)
			)
			(3
				(gCurRoom drawPic: 325)
				(= cycles 30)
			)
			(4
				(gCurRoom drawPic: 324)
				(= cycles 30)
			)
			(5
				(gCurRoom drawPic: 325)
				(= cycles 30)
			)
			(6
				(gCurRoom drawPic: 324)
				(= cycles 120)
			)
			(7
				(gCurRoom drawPic: 325)
				(= cycles 30)
			)
			(8
				(gCurRoom drawPic: 324)
				(= cycles 30)
			)
			(9
				(gCurRoom drawPic: 325)
				(= cycles 120)
			)
			(10
				(gMySoundFX do: 13001 self)
				(sndBabyCry play: 0 0)
				(sndBabyCry fade: 100 10 10 0 0)
			)
			(11
				(tBabyTimer setReal: tBabyTimer 60)
				((ScriptID 1 2) newPic: 357 7) ; exitBack
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenFrontDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (rFrontDoor curFrame:)
					((ScriptID 1 1) dispose:) ; exitForward
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 10 5 10 0 0)
					)
					(if (gTimers contains: tBabyTimer)
						(sndBabyCry fade: 20 5 10 0 0)
					)
					(rFrontDoor caller: self start: 2 10)
				else
					(pDoorKnocker dispose:)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 40 5 10 0 0)
					)
					(if (gTimers contains: tBabyTimer)
						(sndBabyCry fade: 60 5 10 0 0)
					)
					(if (IsFlag 35)
						((ScriptID 1 1) ; exitForward
							newRoom: 320 3
							exitCode: interiorExitCode
						)
					else
						((ScriptID 1 1) newPic: 325 3) ; exitForward
					)
					(gMySoundFX do: 111)
					(rFrontDoor caller: self start: 1 10)
				)
			)
			(1
				(if (not (rFrontDoor curFrame:))
					(gMySoundFX do: 112)
					(pDoorKnocker init:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFadeTheMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 101 0)
				(gBackMusic fade: 0 5 10 1)
				(sndWaves fade:)
				(= ticks 120)
			)
			(1
				(gCurRoom newRoom: register)
				(self dispose:)
			)
		)
	)
)

(instance sOpenCarDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (rCarDoor curFrame:)
					(rCarDoor caller: self start: 2 50)
				else
					(gMySoundFX do: 10001)
					(rCarDoor caller: self start: 1 50)
				)
			)
			(1
				(if (not (rCarDoor curFrame:))
					(gMySoundFX do: 10003)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenShedDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (rShedDoor curFrame:)
					(rShedDoor caller: self start: 2 10)
				else
					(gMySoundFX do: 115)
					(rShedDoor caller: self start: 1 10)
					(fFusebox init:)
					(if (not (IsFlag 53))
						(vCrowbar init:)
					)
				)
			)
			(1
				(if (not (rShedDoor curFrame:))
					(fFusebox dispose:)
					(vCrowbar dispose:)
					(gMySoundFX do: 121)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 101 1)
				(gBackMusic number: 101 loop: -1 play: 127 0)
				(sndWaves play: 0 0)
				(= cycles 3)
			)
			(1
				((ScriptID 9 1) show:) ; PlInterface
				(gCurRoom changeScene: 302 3)
				(= cycles 3)
			)
			(2
				(gMySoundFX do: 100)
				(= ticks 120)
			)
			(3
				(pLightning init: show: setCycle: End self)
			)
			(4
				(pLightning setCel: 0 hide:)
				(= ticks (Random 45 90))
			)
			(5
				(if (Random 0 1)
					(gMySoundFX do: 10501)
				else
					(gMySoundFX do: 10502)
				)
				(pLightning setScript: sRandomStorm)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance whale of Prop
	(properties
		x 71
		y 30
		view 4302
	)

	(method (init)
		(if (== local0 self)
			(self setLoop: 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(moveCode doit: self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftPot of Prop
	(properties
		x 39
		y 132
		loop 2
		view 4302
	)

	(method (init)
		(if (== local0 self)
			(self setLoop: 3)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(moveCode doit: self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightPot of Prop
	(properties
		x 237
		y 62
		loop 4
		cel 6
		view 4302
	)

	(method (init)
		(if (== local0 self)
			(self setLoop: 5)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(moveCode doit: self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shell of Prop
	(properties
		x 286
		y 165
		loop 6
		cel 7
		view 4302
	)

	(method (init)
		(if (== local0 self)
			(self setLoop: 7)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(moveCode doit: self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vCrowbar of View
	(properties
		x 234
		y 262
		view 319
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 53)
				(gMySoundFX do: 116)
				(gInventory addItem: (ScriptID 9 17)) ; invCrowbar
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vShedLockView of View
	(properties
		priority 400
		x 142
		y 99
		view 326
		fixPriority 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; invShedKey
				(pplShedLockPlane init:)
			)
			(5 ; Do
				(pplShedLockPlane init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vLeftWindow of View
	(properties)
)

(instance vRightWindow of View
	(properties)
)

(instance vShedLockOpened of View
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 308)
			(self view: 323 x: 235 y: 94)
		else
			(self view: 4304 x: 386 y: 56)
		)
		(super init: &rest)
	)
)

(instance whaleKeyFeat of Feature
	(properties)

	(method (init)
		(self createPoly: 121 134 137 134 137 117 121 117)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 114)
				(whale setLoop: 0)
				(gInventory addItem: (ScriptID 9 14)) ; invLightHouseKey
				(= local0 0)
				(gMouseDownHandler delete: (self dispose: yourself:))
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance leftPotKeyFeat of Feature
	(properties)

	(method (init)
		(self createPoly: 89 201 106 201 106 182 89 182)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 114)
				(leftPot setLoop: 2)
				(gInventory addItem: (ScriptID 9 14)) ; invLightHouseKey
				(= local0 0)
				(gMouseDownHandler delete: (self dispose: yourself:))
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance rightPotKeyFeat of Feature
	(properties)

	(method (init)
		(self createPoly: 372 153 394 153 394 137 372 137)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 114)
				(rightPot setLoop: 4)
				(gInventory addItem: (ScriptID 9 14)) ; invLightHouseKey
				(= local0 0)
				(gMouseDownHandler delete: (self dispose: yourself:))
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance shellKeyFeat of Feature
	(properties)

	(method (init)
		(self createPoly: 363 207 383 207 383 187 363 187)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 114)
				(shell setLoop: 6)
				(gInventory addItem: (ScriptID 9 14)) ; invLightHouseKey
				(= local0 0)
				(gMouseDownHandler delete: (self dispose: yourself:))
			)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance fFusebox of Feature
	(properties
		nsBottom 480
		nsRight 640
	)

	(method (init)
		(self createPoly: 189 49 250 49 250 143 189 143)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplFuseboxPanel init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fLantern of Feature
	(properties)

	(method (init)
		(self createPoly: 79 107 75 45 98 32 120 47 119 107)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplLightPanel init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMailbox of Feature
	(properties)

	(method (init)
		(self createPoly: 376 160 374 191 413 199 433 198 432 170 422 165)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplMailboxPanel init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pfLantern of PanelFeature
	(properties
		x 122
		y 102
	)

	(method (init)
		(self
			createPoly:
				91
				200
				73
				184
				73
				47
				64
				43
				64
				37
				114
				14
				115
				4
				129
				4
				131
				14
				180
				35
				174
				45
				170
				47
				164
				200
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (ppShedKey cel:)
					(if (not (IsFlag 55))
						(pfShedKey dispose:)
					)
					(gMySoundFX do: 11002)
					(self setPolygon: 0)
					(self
						createPoly:
							91
							200
							73
							184
							73
							47
							64
							43
							64
							37
							114
							14
							115
							4
							129
							4
							131
							14
							180
							35
							174
							45
							170
							47
							164
							200
					)
					(ppShedKey setCycle: Beg ppShedKey)
				else
					(if (not (IsFlag 55))
						(pfShedKey init: pplLightPanel 1 1)
					)
					(gMySoundFX do: 11001)
					(self setPolygon: 0)
					(self
						createPoly:
							25
							184
							20
							39
							65
							46
							64
							38
							112
							15
							114
							4
							129
							4
							130
							15
							180
							34
							177
							44
							170
							48
							163
							199
							93
							199
							76
							179
							81
							172
							57
							172
					)
					(ppShedKey setCycle: End ppShedKey)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pfPadlock of PanelFeature
	(properties
		x 147
		y 129
	)

	(method (init)
		(self createPoly: 125 157 119 152 124 102 176 102 173 157)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(30 ; invShedKey
				(gGame handsOff:)
				(SetFlag 56)
				(gMySoundFX do: 11501)
				(ppShedLock setCycle: End ppShedLock)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pfLetter of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 118 112 122 114 150 110 118 96)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 107)
				(gInventory addItem: (ScriptID 9 25)) ; invEnvelope
				(ppMailboxDoor setLoop: 2)
				(UpdateScreenItem ppMailboxDoor)
				(SetFlag 57)
				(self dispose:)
			)
		)
	)
)

(instance pfShedKey of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 19 129 19 93 42 93 42 129)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(ppShedKey setLoop: 2)
				(UpdateScreenItem ppShedKey)
				(gInventory addItem: (ScriptID 9 22)) ; invShedKey
				(SetFlag 55)
				(gMySoundFX do: 11003)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pplShedLockPlane of InsetPanelPlane
	(properties)

	(method (init)
		(super init: &rest)
		(self setBitmap: 325 0 0)
		(ppShedLock init: self 1 1)
		(pfPadlock init: self 1 1)
	)
)

(instance pplLightPanel of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppShedKey cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 11002)
			(ppShedKey setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self setBitmap: 4303 0 0)
		(ppShedKey init: self 1 1 priority: 200 fixPriority: 1)
		(pfLantern init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplMailboxPanel of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppMailboxDoor cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 110)
			(ppMailboxDoor setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(ppMailboxDoor
			init: self 1 1
			priority: 200
			fixPriority: 1
			ignoreActors:
		)
		(self setBitmap: 312 0 0)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplFuseboxPanel of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppBoxLid cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 11701)
			(ppBoxLid setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(self setBitmap: 320 4 0)
		(ppLeftLever
			init: pplFuseboxPanel 1 1
			setCel:
				(if (IsFlag 35)
					(ppLeftLever lastCel:)
				else
					0
				)
		)
		(ppMiddleLever
			init: pplFuseboxPanel 1 1
			setCel:
				(if (IsFlag 37)
					(ppMiddleLever lastCel:)
				else
					0
				)
		)
		(ppRightLever
			init: pplFuseboxPanel 1 1
			setCel: (if (IsFlag 36) 9 else 0)
		)
		(ppBoxLid init: self 1 1 setCel: 0 setPri: 200)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance ppShedLock of PanelProp
	(properties
		y 1
		loop 1
		view 325
		z 1
	)

	(method (cue)
		(gInventory deleteItem: (ScriptID 9 22)) ; invShedKey
		(vShedLockView dispose:)
		(pplShedLockPlane dispose:)
		(gGame handsOn:)
	)
)

(instance ppShedKey of PanelProp
	(properties
		loop 1
		view 4303
	)

	(method (init)
		(= loop (if (IsFlag 55) 2 else 1))
		(= cel 0)
		(super init: &rest)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance ppMailboxDoor of PanelProp
	(properties
		view 312
	)

	(method (init)
		(= loop (if (IsFlag 57) 2 else 1))
		(= cel 0)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(self setCycle: Beg self)
					(gMySoundFX do: 110)
				else
					(self setCycle: End self)
					(gMySoundFX do: 106)
				)
			)
		)
	)

	(method (cue)
		(cond
			(cel
				(if (not (IsFlag 57))
					(pfLetter init: pplMailboxPanel)
				)
			)
			((not (IsFlag 57))
				(pfLetter dispose:)
			)
		)
		(gGame handsOn:)
	)
)

(instance ppBoxLid of PanelProp
	(properties
		view 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(gMySoundFX do: 11701)
					(self setCycle: Beg self)
				else
					(self setCycle: End self)
					(gMySoundFX do: 117)
				)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance ppLeftLever of PanelProp
	(properties
		x 46
		y 67
		loop 1
		view 320
	)

	(method (onMe)
		(if (ppBoxLid cel:)
			(super onMe: &rest)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (== cel 0)
					(SetFlag 35)
					(gMySoundFX do: 118)
					(self setCycle: End self)
				else
					(ClearFlag 35)
					(gMySoundFX do: 122)
					(self setCycle: Beg self)
				)
			)
		)
	)

	(method (cue)
		(if (gTimers contains: tBabyTimer)
			(sndBabyCry fade:)
			(tBabyTimer dispose: delete:)
		)
		(gGame handsOn:)
	)
)

(instance ppMiddleLever of PanelProp
	(properties
		x 70
		y 67
		loop 2
		view 320
	)

	(method (onMe)
		(if (ppBoxLid cel:)
			(super onMe: &rest)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(ClearFlag 160)
					(ClearFlag 159)
					(ClearFlag 156)
					(ClearFlag 157)
					(ClearFlag 158)
					(ClearFlag 103)
					(ClearFlag 95)
					(ClearFlag 37)
					(if (IsFlag 137)
						(ClearFlag 137)
						(ClearFlag 154)
					)
					(gMySoundFX do: 123)
					(self setCycle: Beg self)
				else
					(SetFlag 37)
					(if (IsFlag 42)
						(SetFlag 137)
					)
					(gMySoundFX do: 119)
					(self setCycle: End self)
				)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance ppRightLever of PanelProp
	(properties
		x 63
		y 47
		loop 3
		view 320
	)

	(method (onMe)
		(if (ppBoxLid cel:)
			(super onMe: &rest)
		else
			(return 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(cond
					(cel
						(if (IsFlag 103)
							(SetFlag 160)
						)
						(ClearFlag 36)
						(gMySoundFX do: 125)
						(self setCycle: Beg self)
					)
					(
						(and
							(IsFlag 99)
							(IsFlag 100)
							(IsFlag 101)
							(IsFlag 102)
						)
						(SetFlag 36)
						(gMySoundFX do: 124)
						(self setCycle: CT 9 1 self)
					)
					(else
						(gMySoundFX do: 120)
						(self setCycle: End self)
					)
				)
			)
		)
	)

	(method (cue)
		(if (not (IsFlag 36))
			(self setCel: 0)
		)
		(gGame handsOn:)
	)
)

(instance rShedDoor of RobotPlayer
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 56)
					(gCurRoom setScript: sOpenShedDoor)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rCarDoor of RobotPlayer
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (rCarDoor curFrame:)
					(Dialog mouseHiliting: 1)
					(gSystemPlane picture: -2)
					(if
						((Print new:)
							addBitmap: 1208 0 0 0
							addButtonBM: 1208 1 1 0 {} 59 119
							addButtonBM: 1208 2 0 1 {} 187 119
							init:
						)
						(gCurRoom setScript: sOpenCarDoor)
					else
						(= gQuit 1)
					)
					(gSystemPlane picture: -1)
					(Dialog mouseHiliting: 0)
				else
					(gCurRoom setScript: sOpenCarDoor)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance potsExitCode of Code
	(properties)

	(method (doit)
		(if
			(and
				(== (whale cel:) 0)
				(== (shell cel:) 7)
				(== (leftPot cel:) 0)
				(== (rightPot cel:) 6)
			)
			(if (IsFlag 35)
				(gCurRoom changeScene: 306 3)
			else
				(gCurRoom changeScene: 290 3)
			)
		else
			(gGame handsOff:)
			(if (whale cel:)
				(whale setCycle: Beg self)
			)
			(if (leftPot cel:)
				(leftPot setCycle: Beg self)
			)
			(if (< (shell cel:) 7)
				(shell setCycle: End self)
			)
			(if (< (rightPot cel:) 6)
				(rightPot setCycle: End self)
			)
		)
	)

	(method (cue)
		(if
			(and
				(== (whale cel:) 0)
				(== (shell cel:) 7)
				(== (leftPot cel:) 0)
				(== (rightPot cel:) 6)
			)
			(if (IsFlag 35)
				(gCurRoom changeScene: 306 3)
			else
				(gCurRoom changeScene: 290 3)
			)
		)
	)
)

(instance interiorExitCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(gCurRoom setScript: sFadeTheMusic 0 320)
	)
)

(instance shedSouthExitCode of Code
	(properties)

	(method (doit)
		(if (rShedDoor curFrame:)
			(gGame handsOff:)
			(gCurRoom setScript: sOpenShedDoor self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 308 4)
	)
)

(instance shedWestExitCode of Code
	(properties)

	(method (doit)
		(if (rShedDoor curFrame:)
			(gGame handsOff:)
			(gCurRoom setScript: sOpenShedDoor self)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 309 6)
	)
)

(instance doorDownExitCode of Code
	(properties)

	(method (doit)
		(if (rFrontDoor curFrame:)
			(gGame handsOff:)
			(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
				(gBackMusic2 fade: 10 5 10 0 0)
			)
			(= local3 1)
			(rFrontDoor caller: self start: 2 10)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 301 3)
	)
)

(instance doorBackExitCode of Code
	(properties)

	(method (doit)
		(if (rFrontDoor curFrame:)
			(gGame handsOff:)
			(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
				(gBackMusic2 fade: 10 5 10 0 0)
			)
			(= local3 1)
			(rFrontDoor caller: self start: 2 10)
		else
			(self cue:)
		)
	)

	(method (cue)
		(gCurRoom changeScene: 299 7)
	)
)

(instance carDoorBackExitCode of Code
	(properties)

	(method (doit)
		(if (rCarDoor curFrame:)
			(gGame handsOff:)
			(rCarDoor caller: self start: 2 50)
		else
			(self cue: 1)
		)
	)

	(method (cue)
		(if (not argc)
			(gMySoundFX do: 10003)
		)
		(gCurRoom changeScene: 302 3)
	)
)

(instance moveShed of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(self createPoly: 449 88 499 103 499 214 449 214)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(self setPolygon: 0 createPoly: 449 88 499 103 499 214 449 214)
	)
)

(instance pLightning of Prop
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 302)
			(self view: 6319 x: 0 y: 0 setPri: 1)
		else
			(self view: 6320 x: 443 y: 0 setPri: 1)
		)
		(super init: &rest)
		(self hide:)
	)
)

(instance rFrontDoor of RobotPlayer
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 33)
					(gCurRoom setScript: sOpenFrontDoor)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pDoorKnocker of Prop
	(properties
		x 200
		y 117
		view 6318
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gMySoundFX do: 11401)
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(self setCel: 0)
		(gGame handsOn:)
	)
)

(instance pDoorLock of Prop
	(properties
		x 94
		y 228
		view 6317
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 59 200 59 254 129 254 129 200
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; invLightHouseKey
				(gGame handsOff:)
				(SetFlag 33)
				(gInventory deleteItem: (ScriptID 9 14)) ; invLightHouseKey
				(gMySoundFX do: 11400)
				(self setCycle: End self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance moveCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= temp2 1)
		(= temp0 (param1 cel:))
		(= local1 gMouseX)
		(switch param1
			(whale
				(gMySoundFX number: 113 setLoop: 1 play: 127 0)
			)
			(leftPot
				(gMySoundFX number: 11300 setLoop: 1 play: 127 0)
			)
			(rightPot
				(gMySoundFX number: 11301 setLoop: 1 play: 127 0)
			)
			(shell
				(gMySoundFX number: 11302 setLoop: 1 play: 127 0)
			)
		)
		(while (or (!= ((= temp1 (Event new:)) type:) evMOUSERELEASE) temp2)
			(= temp2 0)
			(cond
				((> (temp1 x:) local1)
					(if (not (>= temp0 (param1 lastCel:)))
						(++ temp0)
						(= local1 (temp1 x:))
					)
				)
				((and (< (temp1 x:) local1) temp0)
					(-- temp0)
					(= local1 (temp1 x:))
				)
			)
			(if local0
				(switch local0
					(whale
						(if (>= (whale cel:) 4)
							(gMouseDownHandler add: (whaleKeyFeat init: yourself:))
						else
							(gMouseDownHandler delete: (whaleKeyFeat dispose: yourself:))
						)
					)
					(leftPot
						(if (>= (leftPot cel:) 4)
							(gMouseDownHandler add: (leftPotKeyFeat init: yourself:))
						else
							(gMouseDownHandler
								delete: (leftPotKeyFeat dispose: yourself:)
							)
						)
					)
					(rightPot
						(if (<= (rightPot cel:) 3)
							(gMouseDownHandler add: (rightPotKeyFeat init: yourself:))
						else
							(gMouseDownHandler
								delete: (rightPotKeyFeat dispose: yourself:)
							)
						)
					)
					(shell
						(if (<= (shell cel:) 3)
							(gMouseDownHandler add: (shellKeyFeat init: yourself:))
						else
							(gMouseDownHandler delete: (shellKeyFeat dispose: yourself:))
						)
					)
				)
			)
			(if (!= temp0 (param1 cel:))
				(param1 setCel: temp0)
				(UpdateScreenItem param1)
				(FrameOut)
			)
			(temp1 dispose:)
		)
		(gMySoundFX stop:)
		(temp1 dispose:)
	)
)

(instance sndBabyCry of Sound
	(properties
		number 13002
		loop -1
	)
)

(instance sndWaves of Sound
	(properties
		number 105
		loop -1
	)
)

(instance tBabyTimer of Timer
	(properties)

	(method (cue)
		(sndBabyCry fade:)
	)
)

(instance moveUpRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 7)
		(self createPoly: 230 105 330 105 330 207 230 207)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 7)
		(self createPoly: 230 105 330 105 330 207 230 207)
	)
)

