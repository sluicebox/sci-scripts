;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use LightRoom)
(use Portal)
(use PanelPlane)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm400 0
	proc400_1 1
)

(local
	[local0 3]
	local3
	local4
	local5
)

(procedure (proc400_1 param1)
	(gCurRoom compassDir: param1)
	(if (IsFlag 368)
		((gGame compassFace:) setLoop: param1 setCel: 0)
	)
)

(class RockView of View
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gInventory contains: (ScriptID 9 11))) ; invRocks
					(gInventory addItem: (ScriptID 9 11)) ; invRocks
				else
					((ScriptID 9 11) cel: (+ ((ScriptID 9 11) cel:) 1)) ; invRocks, invRocks
				)
				(gMySoundFX number: 41602 setLoop: 0 play:)
				(gInventory draw:)
				(self dispose:)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance rm400 of LightRoom
	(properties
		picture 409
	)

	(method (init)
		(super init: &rest)
		(Lock rsAUDIO 1005 1)
		(Lock rsAUDIO 412 1)
		(Lock rsAUDIO 414 1)
		(Lock rsAUDIO 41602 1)
		(gBackMusic number: 1005 setLoop: -1 play: 0 0 fade: 127 25 10 0)
		(gBackMusic2 stop:)
		(cond
			((and (== gPrevRoomNum 440) (IsFlag 172))
				(self changeScene: 409)
			)
			((== gPrevRoomNum 800)
				(ClearFlag 172)
				(= local3 1)
				(self changeScene: 406)
			)
			(else
				(self changeScene: 434)
			)
		)
	)

	(method (dispose)
		(gBackMusic stop:)
		(randomFXTimer dispose: delete:)
		(randomFX dispose:)
		(waveSound dispose:)
		(aSound dispose:)
		(beachPortal stopSound:)
		(Lock rsAUDIO 1005 0)
		(Lock rsAUDIO 412 0)
		(Lock rsAUDIO 414 0)
		(Lock rsAUDIO 41602 0)
		(gMySoundFX stop:)
		(super dispose: &rest)
	)

	(method (changeScene param1)
		((ScriptID 1 1) arrowStyle: 3) ; exitForward
		(move430 dispose:)
		(move430_2 dispose:)
		(move402 dispose:)
		(move404 dispose:)
		(move401 dispose:)
		(bigForward dispose:)
		(beachPortal dispose:)
		(beachPortal stopSound:)
		(cork dispose:)
		(moveDownRight dispose:)
		(keyView dispose:)
		(rock1 dispose:)
		(rock2 dispose:)
		(rock3 dispose:)
		(waves dispose:)
		(gMySoundFX stop:)
		(bottleFeature dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(400
				(proc400_1 1)
				((ScriptID 1 2) newPic: 434) ; exitBack
				(if (IsFlag 172)
					(= local5 1)
					(gBackMusic stop:)
					((ScriptID 1 1) ; exitForward
						newPic: 434
						exitCode: portalExitCode
						arrowStyle: 3
					)
					((ScriptID 1 3) ; exitLeft
						newPic: 435
						arrowStyle: 3
						nsTop: 90
						nsLeft: 1
						nsBottom: 275
						nsRight: 120
					)
					((ScriptID 1 4) ; exitRight
						newPic: 435
						arrowStyle: 3
						nsTop: 90
						nsLeft: 335
						nsBottom: 275
						nsRight: 499
					)
					(== local4 1)
					(beachPortal init: 4400 0 0 41601)
				else
					(bigForward init: newPic: 435)
				)
			)
			(401
				(proc400_1 5)
				((ScriptID 1 1) newPic: 431 arrowStyle: 7) ; exitForward
				((ScriptID 1 2) newPic: 402) ; exitBack
				(if (IsFlag 172)
					(gMySoundFX number: 41601 setLoop: -1 play: setVol: 25)
				)
			)
			(402
				(proc400_1 9)
				((ScriptID 1 1) newPic: 400) ; exitForward
				((ScriptID 1 3) newPic: 431) ; exitLeft
				(if (IsFlag 172)
					(gMySoundFX number: 41601 setLoop: -1 play: setVol: 25)
				)
			)
			(403
				(proc400_1 5)
				((ScriptID 1 1) newPic: 432) ; exitForward
				((ScriptID 1 2) newPic: 400) ; exitBack
				(if (IsFlag 172)
					(gMySoundFX number: 41601 setLoop: -1 play: setVol: 25)
				)
			)
			(404
				(proc400_1 1)
				(bigForward init: newPic: 400)
				((ScriptID 1 4) newPic: 432) ; exitRight
				(if (IsFlag 172)
					(gMySoundFX number: 41601 setLoop: -1 play: setVol: 25)
				)
			)
			(405
				(proc400_1 1)
				(waveSound dispose:)
				((ScriptID 1 2) newPic: 430) ; exitBack
				((ScriptID 1 4) ; exitRight
					newPic: 402
					arrowStyle: ((ScriptID 1 1) arrowStyle:) ; exitForward
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 404 1
					arrowStyle: ((ScriptID 1 1) arrowStyle:) ; exitForward
				)
			)
			(406
				(if local3
					(gCurRoom setScript: fadeIn)
				)
				(proc400_1 11)
				(waveSound init: number: 412 setLoop: -1 play: 50 0)
				(bigForward init: newPic: 408)
				((ScriptID 1 2) newPic: 433) ; exitBack
				(proc0_9 4406 2 82)
			)
			(407
				(proc400_1 7)
				(gCurRoom setScript: 0)
				(bigForward init: newPic: 433)
				((ScriptID 1 2) newPic: 408) ; exitBack
				((ScriptID 1 3) newPic: 411) ; exitLeft
				((ScriptID 1 4) newPic: 413) ; exitRight
			)
			(408
				(proc400_1 3)
				(waveSound setVol: 127)
				(bigForward init: newPic: 410)
				((ScriptID 1 2) newPic: 407) ; exitBack
				((ScriptID 1 3) newPic: 413) ; exitLeft
				((ScriptID 1 4) newPic: 411) ; exitRight
				(proc0_9 4408 0 128)
			)
			(409
				(proc400_1 5)
				((ScriptID 1 2) newPic: 435) ; exitBack
				(if (IsFlag 172)
					(= local5 1)
					(gBackMusic stop:)
					((ScriptID 1 1) ; exitForward
						newPic: 434
						exitCode: portalExitCode
						arrowStyle: 3
					)
					((ScriptID 1 4) ; exitRight
						newPic: 434
						arrowStyle: ((ScriptID 1 1) arrowStyle:) ; exitForward
					)
					((ScriptID 1 3) ; exitLeft
						newPic: 434
						arrowStyle: ((ScriptID 1 1) arrowStyle:) ; exitForward
					)
					(== local4 1)
					(beachPortal init: 4409 95 19 41601)
				else
					((ScriptID 1 1) newPic: 434) ; exitForward
				)
			)
			(410
				(proc400_1 2)
				(randomFXTimer setReal: randomFXTimer 7)
				(bigForward init: newPic: 412)
				((ScriptID 1 2) newPic: 407) ; exitBack
				(proc0_9 4410 0 127)
			)
			(411
				(proc400_1 1)
				(waves dispose:)
				((ScriptID 1 2) newPic: 413) ; exitBack
				((ScriptID 1 3) newPic: 408) ; exitLeft
				((ScriptID 1 4) newPic: 407) ; exitRight
				(if (IsFlag 176)
					(proc0_9 4411 0 134)
				else
					(switch global209
						(3
							(proc0_9 5410 0 0)
						)
						(2
							(proc0_9 5411 0 0)
						)
						(1
							(proc0_9 5412 0 0)
						)
					)
				)
				(if (not (IsFlag 18))
					(if (IsFlag 425)
						(rock1 view: 3411 cel: 0 posn: 51 289 init:)
					else
						(rock1 view: 3411 cel: 0 posn: 397 283 init:)
					)
				)
				(if (not (IsFlag 19))
					(if (IsFlag 419)
						(rock2 view: 3411 cel: 1 posn: 405 233 init:)
					else
						(rock2 view: 3411 cel: 1 posn: 340 296 init:)
					)
				)
				(if (not (IsFlag 20))
					(if (IsFlag 420)
						(rock3 view: 3411 cel: 2 posn: 397 283 init:)
					else
						(rock3 view: 3411 cel: 2 posn: 173 247 init:)
					)
				)
			)
			(412
				(proc400_1 3)
				(bigForward init: newPic: 414)
				((ScriptID 1 2) newPic: 407) ; exitBack
				(proc0_9 4412 0 128)
			)
			(413
				(proc400_1 5)
				(if (not (IsFlag 94))
					(bottleFeature init:)
				else
					(cork init:)
				)
				((ScriptID 1 2) newPic: 411) ; exitBack
				((ScriptID 1 3) newPic: 407) ; exitLeft
				((ScriptID 1 4) newPic: 408) ; exitRight
				(waves init:)
			)
			(414
				(proc400_1 3)
				((ScriptID 1 2) newPic: 418) ; exitBack
				((ScriptID 1 4) newPic: 420) ; exitRight
				((ScriptID 1 3) newPic: 416) ; exitLeft
				(proc0_9 4414 0 136)
			)
			(416
				(proc400_1 5)
				((ScriptID 1 2) newPic: 420) ; exitBack
				((ScriptID 1 4) newPic: 414) ; exitRight
				((ScriptID 1 3) newPic: 418) ; exitLeft
				(proc0_9 4416 1 117)
			)
			(418
				(proc400_1 7)
				(Lock rsAUDIO 416 0)
				(bigForward init: newPic: 407)
				((ScriptID 1 2) newPic: 414) ; exitBack
				((ScriptID 1 4) newPic: 416) ; exitRight
				((ScriptID 1 3) newPic: 420) ; exitLeft
				(proc0_9 4418 0 206)
			)
			(420
				(proc400_1 9)
				(bigForward init: newPic: 422)
				((ScriptID 1 2) newPic: 416) ; exitBack
				((ScriptID 1 4) newPic: 418) ; exitRight
				((ScriptID 1 3) newPic: 414) ; exitLeft
				(if (IsFlag 176)
					(proc0_9 4420 45 129)
				else
					(switch global209
						(3
							(proc0_9 5413 0 0)
						)
						(2
							(proc0_9 5414 0 0)
						)
						(1
							(proc0_9 5415 0 0)
						)
					)
				)
			)
			(422
				(proc400_1 1)
				((ScriptID 1 2) newPic: 428) ; exitBack
				(moveDownRight newPic: 424 init:)
				(if (IsFlag 176)
					(proc0_9 4422 90 126)
				else
					(switch global209
						(3
							(proc0_9 5416 94 0)
						)
						(2
							(proc0_9 5417 94 0)
						)
						(1
							(proc0_9 5418 94 0)
						)
					)
				)
			)
			(424
				(proc400_1 8)
				(bigForward init: newPic: 426)
				((ScriptID 1 4) newPic: 428) ; exitRight
				(proc0_9 4424 0 0)
				(if (not (IsFlag 15))
					(keyView view: 434 x: 201 y: 161 setPri: 888 init:)
				)
			)
			(426
				(proc400_1 16)
				(Lock rsAUDIO 416 1)
				((ScriptID 1 3) newPic: 427) ; exitLeft
				(proc0_9 4426 0 0)
				(if (not (IsFlag 15))
					(keyView view: 433 x: 289 y: 29 init:)
				)
			)
			(427
				(proc400_1 3)
				((ScriptID 1 1) ; exitForward
					newPic: 428
					nsTop: 17
					nsLeft: 213
					nsBottom: 180
					nsRight: 392
				)
				((ScriptID 1 2) newPic: 426) ; exitBack
				(proc0_9 4427 225 137)
			)
			(428
				(proc400_1 5)
				((ScriptID 1 1) ; exitForward
					newPic: 416
					nsTop: 45
					nsLeft: 58
					nsBottom: 257
					nsRight: 271
				)
				((ScriptID 1 2) newPic: 422) ; exitBack
				((ScriptID 1 3) newPic: 424) ; exitLeft
				(proc0_9 4428 0 90)
			)
			(430
				(proc400_1 4)
				(bigForward init: newPic: 406)
				((ScriptID 1 2) newPic: 405) ; exitBack
			)
			(431
				(proc400_1 11)
				(move430 init: newPic: 430)
				((ScriptID 1 4) newPic: 402) ; exitRight
				(move404 init: newPic: 404)
				(if (not (IsFlag 21))
					(if (IsFlag 421)
						(rock1 view: 3431 cel: 0 posn: 216 274 init:)
					else
						(rock1 view: 3431 cel: 0 posn: 439 273 init:)
					)
				)
				(if (not (IsFlag 22))
					(if (IsFlag 422)
						(rock2 view: 3431 cel: 1 posn: 311 247 init:)
					else
						(rock2 view: 3431 cel: 1 posn: 129 309 init:)
					)
				)
			)
			(432
				(proc400_1 6)
				(move430_2 init: newPic: 430)
				(move402 init: newPic: 402)
				((ScriptID 1 3) newPic: 404) ; exitLeft
			)
			(433
				(proc400_1 8)
				(waveSound setVol: 30)
				(bigForward init: newPic: 405)
				((ScriptID 1 2) newPic: 406) ; exitBack
				(if (not (IsFlag 23))
					(if (IsFlag 423)
						(rock1 view: 3433 cel: 0 posn: 281 232 init:)
					else
						(rock1 view: 3433 cel: 0 posn: 148 246 init:)
					)
				)
				(if (not (IsFlag 24))
					(if (IsFlag 424)
						(rock2 view: 3433 cel: 1 posn: 481 293 init:)
					else
						(rock2 view: 3433 cel: 1 posn: 96 239 init:)
					)
				)
			)
			(434
				(proc400_1 5)
				((ScriptID 1 2) newPic: 400) ; exitBack
				(move401
					init:
					newPic: 403
					arrowStyle: ((ScriptID 1 1) arrowStyle:) ; exitForward
				)
				((ScriptID 1 3) ; exitLeft
					newPic: 401
					arrowStyle: ((ScriptID 1 1) arrowStyle:) ; exitForward
				)
				(if local5
					(= local5 0)
					(gBackMusic
						number: 1005
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(if (IsFlag 172)
					(gMySoundFX number: 41601 setLoop: -1 play: setVol: 60)
				)
			)
			(435
				(proc400_1 1)
				(bigForward init: newRoom: 440)
				(if (IsFlag 172)
					((ScriptID 1 2) newPic: 409) ; exitBack
				else
					((ScriptID 1 2) newPic: 434) ; exitBack
				)
				(if (not (IsFlag 176))
					(switch global209
						(3
							(proc0_9 5419 0 0)
						)
						(2
							(proc0_9 5420 0 0)
						)
						(1
							(proc0_9 5421 0 0)
						)
					)
				)
				(if local5
					(= local5 0)
					(gBackMusic
						number: 1005
						setLoop: -1
						play: 0 0
						fade: 127 25 10 0
					)
				)
				(if (IsFlag 172)
					(gMySoundFX number: 41601 setLoop: -1 play: setVol: 60)
				)
			)
		)
	)
)

(instance getNoteFromBottle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bottle init: bottlePanel 1 1)
				(aSound number: 41600 setLoop: 0 play:)
				(bottle setCycle: End self)
			)
			(1
				(SetFlag 46)
				(bottleFeature dispose:)
				(notePanel init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fadeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom fade: 1 1 self)
			)
			(1
				(= local3 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance waves of Prop
	(properties
		x 245
		y 199
		view 4413
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance cork of View
	(properties
		x 298
		y 233
		view 413
	)
)

(instance bottleBackGround of PanelProp
	(properties
		y 200
		view 4439
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 200)
	)
)

(instance bottle of PanelProp
	(properties
		y 200
		view 4439
	)

	(method (init)
		(self setLoop: 0 setCel: 0 setPri: 205)
		(super init: &rest)
	)
)

(instance keyView of Prop
	(properties)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 426)
					(SetFlag 15)
					(aSound number: 416 setLoop: 0 play:)
					(gInventory addItem: (ScriptID 9 9)) ; invDrawbridgeKey
					(self dispose:)
				)
			)
		)
	)
)

(instance rock1 of RockView
	(properties)

	(method (doVerb theVerb)
		(switch (gCurRoom scene:)
			(411
				(SetFlag 18)
			)
			(431
				(SetFlag 21)
			)
			(433
				(SetFlag 23)
			)
			(435
				(SetFlag 25)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance rock2 of RockView
	(properties)

	(method (doVerb theVerb)
		(switch (gCurRoom scene:)
			(411
				(SetFlag 19)
			)
			(431
				(SetFlag 22)
			)
			(433
				(SetFlag 24)
			)
			(435
				(SetFlag 26)
			)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance rock3 of RockView
	(properties)

	(method (doVerb theVerb)
		(SetFlag 20)
		(super doVerb: theVerb &rest)
	)
)

(instance notePanel of PanelPlane
	(properties)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 150 20 550 420)
		(self setBitmap: 4438 0 0)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evMOUSEBUTTON) (not (self onMe: event)))
			(event claimed: 1)
			(self dispose:)
		else
			(event claimed: 1)
		)
	)

	(method (dispose)
		(gInventory addItem: (ScriptID 9 38)) ; invBottleNote
		(SetFlag 94)
		(cork init:)
		(super dispose: &rest)
	)
)

(instance bottleFeature of Feature
	(properties
		nsLeft 309
		nsTop 231
		nsRight 363
		nsBottom 283
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(bottlePanel init:)
			)
		)
	)
)

(instance bottlePanel of PanelPlane
	(properties)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		((ScriptID 1 3) dispose:) ; exitLeft
		(= priority (+ (GetHighPlanePri) 1))
		(super init: 0 0 200 200)
		(bottleBackGround init: self 1 1)
		(hotFeature init: self 1 1)
	)

	(method (dispose)
		((ScriptID 1 3) init: newPic: 407) ; exitLeft
		(super dispose: &rest)
	)
)

(instance hotFeature of PanelFeature
	(properties
		nsLeft 130
		nsTop 130
		nsRight 155
		nsBottom 160
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: getNoteFromBottle)
			)
		)
	)
)

(instance move401 of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 348)
		(= nsTop 93)
		(= nsRight 451)
		(= nsBottom 204)
		(super init: &rest)
	)
)

(instance move402 of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 115)
		(= nsTop 85)
		(= nsRight 290)
		(= nsBottom 215)
		(= arrowStyle 8)
		(super init: &rest)
	)
)

(instance move404 of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 250)
		(= nsTop 95)
		(= nsRight 400)
		(= nsBottom 225)
		(= arrowStyle 7)
		(super init: &rest)
	)
)

(instance move430 of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 0)
		(= nsTop 115)
		(= nsRight 165)
		(= nsBottom 230)
		(= arrowStyle 8)
		(super init: &rest)
	)
)

(instance move430_2 of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 355)
		(= nsTop 115)
		(= nsRight 499)
		(= nsBottom 230)
		(= arrowStyle 7)
		(super init: &rest)
	)
)

(instance bigForward of ExitFeature
	(properties)

	(method (init)
		(= nsLeft 115)
		(= nsTop 70)
		(= nsRight 385)
		(= nsBottom 205)
		(super init: &rest)
	)
)

(instance moveDownRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 10)
		(= nsLeft 377)
		(= nsTop 175)
		(= nsRight 498)
		(= nsBottom 287)
		(super init: &rest)
	)
)

(instance randomFX of Sound
	(properties)
)

(instance aSound of Sound
	(properties)
)

(instance waveSound of Sound
	(properties)
)

(instance randomFXTimer of Timer
	(properties)

	(method (cue)
		(if
			(OneOf
				(gCurRoom scene:)
				410
				412
				414
				418
				420
				422
				424
				426
				427
				428
			)
			(randomFX number: 414 setLoop: 0 play: 127 0)
		)
		(self setReal: self (Random 7 11))
	)
)

(instance portalExitCode of Code
	(properties)

	(method (doit)
		(cond
			((IsFlag 172)
				(gCurRoom newRoom: 360)
				(beachPortal stopSound:)
			)
			((== (gCurRoom scene:) 400)
				(gCurRoom changeScene: 435)
			)
			(else
				(gCurRoom changeScene: 434)
			)
		)
	)
)

(instance beachPortal of Portal
	(properties)
)

