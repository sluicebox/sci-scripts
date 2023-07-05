;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use WalkieTalkie)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1)
	(gCurRoom compassDir: param1)
	(if (IsFlag 368)
		((gGame compassFace:) setLoop: param1 setCel: 0)
	)
)

(instance rm440 of LightRoom
	(properties
		picture 442
	)

	(method (init)
		(gBackMusic stop:)
		(waterSound init: number: 427 setLoop: -1 play: setVol: 120)
		(gBackMusic2 number: 1005 setLoop: -1 play: 0 0 fade: 127 25 10 0)
		(gGame handsOn:)
		(super init: &rest)
		(Lock rsAUDIO 1006 1)
		(Lock rsAUDIO 10060 1)
		(Lock rsAUDIO 420 1)
		(Lock rsAUDIO 432 1)
		(switch gPrevRoomNum
			(441
				(self changeScene: 445)
			)
			(447
				(self changeScene: 455)
			)
			(else
				(self changeScene: 440)
			)
		)
	)

	(method (changeScene param1)
		((ScriptID 1 1) arrowStyle: 3) ; exitForward
		(drawBridge dispose:)
		(rightColumn dispose:)
		(rail dispose:)
		(fountain dispose:)
		(hawkTimer dispose: delete:)
		(bridgeDown dispose:)
		(fountainSound dispose:)
		(windSound dispose:)
		(= local0 param1)
		(super changeScene: param1 &rest)
		(switch param1
			(415
				(localproc_0 5)
				(proc0_9 4432 0 0)
				((ScriptID 1 1) ; exitForward
					newRoom: 400
					nsTop: 140
					nsLeft: 35
					nsBottom: 299
					nsRight: 230
				)
				(cond
					((== local1 440)
						((ScriptID 1 4) newPic: 440) ; exitRight
					)
					((IsFlag 30)
						((ScriptID 1 4) newPic: 5442) ; exitRight
					)
					(else
						((ScriptID 1 4) newPic: 442) ; exitRight
					)
				)
			)
			(440
				(localproc_0 2)
				(gMySoundFX number: 10060 setLoop: 0 play: 127 0)
				(if (IsFlag 30)
					(drawBridge init:)
				)
				(rail init:)
				(if (IsFlag 30)
					((ScriptID 1 1) newPic: 5442) ; exitForward
				else
					((ScriptID 1 1) newPic: 442) ; exitForward
				)
				((ScriptID 1 1) ; exitForward
					nsTop: 120
					nsLeft: 195
					nsBottom: 270
					nsRight: 350
					arrowStyle: 8
				)
				(= local1 440)
				((ScriptID 1 3) newPic: 415) ; exitLeft
				(if (IsFlag 176)
					(proc0_9 4443 0 138)
				else
					(switch global209
						(3
							(proc0_9 5422 0 0)
						)
						(2
							(proc0_9 5423 0 0)
						)
						(1
							(proc0_9 5424 0 0)
						)
					)
				)
			)
			(442
				(localproc_0 10)
				(= local1 442)
				(proc0_9 4444 0 0)
				((ScriptID 1 1) newPic: 445) ; exitForward
				((ScriptID 1 3) newPic: 415) ; exitLeft
			)
			(444
				(localproc_0 3)
				((ScriptID 1 5) newPic: 445) ; exitDown
				(if (not (IsFlag 176))
					(hawkTimer setReal: hawkTimer (Random 5 10))
				)
				(gMySoundFX number: 10060 setLoop: 0 play: 127 0)
				(if (not (IsFlag 176))
					(switch global209
						(3
							(proc0_9 4490 0 0)
						)
						(2
							(proc0_9 4491 0 0)
						)
						(1
							(proc0_9 4492 0 0)
						)
					)
				)
			)
			(445
				(localproc_0 3)
				(rightColumn init:)
				((ScriptID 1 6) newPic: 444) ; exitUp
				(if (IsFlag 30)
					((ScriptID 1 2) newPic: 5442 arrowStyle: 2) ; exitBack
					(bridgeDown init:)
					(if (IsFlag 93)
						(fountain init:)
					)
					((ScriptID 1 1) newRoom: 447) ; exitForward
				else
					((ScriptID 1 2) newPic: 442 arrowStyle: 2) ; exitBack
				)
				(cond
					((IsFlag 409)
						(ClearFlag 409)
						(gCurRoom setScript: lowerBridge)
					)
					((not (IsFlag 176))
						(hawkTimer setReal: hawkTimer (Random 5 10))
					)
				)
			)
			(455
				(localproc_0 7)
				((ScriptID 1 1) ; exitForward
					newPic: 415
					nsTop: 120
					nsLeft: 220
					nsBottom: 235
					nsRight: 410
					arrowStyle: 7
				)
				((ScriptID 1 4) newRoom: 447) ; exitRight
				(fountainSound init: number: 43301 setLoop: -1 setVol: 70 play:)
				(windSound init: number: 41100 setLoop: -1 play: setVol: 70)
				((ScriptID 1 2) ; exitBack
					newRoom: 447
					nsTop: 240
					nsLeft: 120
					nsBottom: 299
					nsRight: 390
				)
			)
			(5442
				(fountain init:)
				(= local1 5442)
				(proc0_9 4444 0 0)
				(localproc_0 10)
				((ScriptID 1 1) newPic: 445) ; exitForward
				((ScriptID 1 3) newPic: 415) ; exitLeft
			)
		)
	)

	(method (dispose)
		(gBackMusic2 stop:)
		(DoRobot)
		(hawkTimer dispose: delete:)
		(Lock rsAUDIO 1006 0)
		(Lock rsAUDIO 10060 0)
		(Lock rsAUDIO 420 0)
		(Lock rsAUDIO 432 0)
		(fountainSound dispose:)
		(windSound dispose:)
		(hawkSound dispose:)
		(waterSound dispose:)
		(super dispose: &rest)
	)
)

(instance lowerBridge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hawkTimer dispose: delete:)
				(rightColumn setLoop: 1 setCel: 32)
				(KillRobot 4431 -56 -89 0 -1)
			)
			(1
				(WalkieTalkie showFrame: 4431 42 -56 -89)
				(SetFlag 93)
				(SetFlag 30)
				(bridgeDown init:)
				(fountain init:)
				((ScriptID 1 1) newRoom: 447) ; exitForward
				((ScriptID 1 2) newPic: 5442 arrowStyle: 2) ; exitBack
				(gGame handsOn:)
				(hawkTimer setReal: hawkTimer (Random 5 10))
				(self dispose:)
			)
		)
	)
)

(instance rail of View
	(properties
		x 195
		y 237
		view 443
	)

	(method (init)
		(self setLoop: 2)
		(self setPri: 999)
		(super init: &rest)
	)
)

(instance bridgeDown of View
	(properties
		x 138
		y 299
		view 4431
	)
)

(instance rightColumn of Prop
	(properties
		y 299
		view 4434
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 34)
			(self setLoop: 1 setCel: 34)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(5 ; Do
					(cond
						((IsFlag 30) 1)
						((and (IsFlag 34) (not (IsFlag 30)))
							(hawkTimer dispose: delete:)
							(gCurRoom newRoom: 441)
						)
						(else
							(gMySoundFX number: 420 setLoop: 0 play:)
							(if (!= loop 1)
								(if (== cel 0)
									(self setCycle: End)
								else
									(self setCycle: Beg)
								)
							)
						)
					)
				)
				(7 ; invDrawbridgeKey
					(if (== cel (self lastCel:))
						(gGame handsOff:)
						(gMySoundFX number: 421 setLoop: 0 play:)
						(gInventory deleteItem: (ScriptID 9 9)) ; invDrawbridgeKey
						(self setCel: 0 setLoop: 1 setCycle: End self)
						(SetFlag 34)
					)
				)
			)
		)
	)
)

(instance drawBridge of View
	(properties
		x 158
		y 186
		view 443
	)

	(method (init)
		(self setPri: 888)
		(super init: &rest)
	)
)

(instance fountain of Prop
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 5442)
			(self view: 4445 x: 183 y: 208)
		else
			(self view: 4462 x: 219 y: 181 setPri: 599)
		)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance myPlayer of RobotPlayer ; UNUSED
	(properties)
)

(instance hawkTimer of Timer
	(properties)

	(method (cue)
		(hawkSound number: (Random 428 430) setLoop: 0 play:)
		(self setReal: self (Random 5 10))
	)
)

(instance hawkSound of Sound
	(properties)
)

(instance fountainSound of Sound
	(properties)
)

(instance waterSound of Sound
	(properties)
)

(instance windSound of Sound
	(properties)
)

