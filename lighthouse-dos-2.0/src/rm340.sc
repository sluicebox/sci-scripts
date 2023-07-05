;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use LightRoom)
(use Portal)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm340 of LightRoom
	(properties
		picture 345
	)

	(method (init)
		(Lock rsAUDIO 13002 1)
		(Lock rsAUDIO 171 1)
		(Lock rsAUDIO 172 1)
		(super init: &rest)
		(if (not (OneOf gPrevRoomNum 320 330))
			(gIRandomMusic
				musicOne: 1301
				musicTwo: 1302
				musicThree: 1303
				play: 127 0
			)
		)
		(cond
			((== gPrevRoomNum 800)
				(gBackMusic2 loop: -1 number: 176 play: 127 0)
				(gCurRoom changeScene: 343 5)
			)
			((IsFlag 162)
				(gCurRoom changeScene: 340 1)
			)
			((and (gTimers contains: gTGlobalTimer) (not (IsFlag 267)))
				(= local2 1)
				(ClearFlag 266)
				(gTGlobalTimer delete: dispose:)
				(if (not (IsFlag 292))
					(gCurRoom setScript: sRandomBabySounds changeScene: 340 1)
				else
					(gCurRoom changeScene: 340 1)
				)
			)
			((and (IsFlag 267) (not (IsFlag 16)))
				(Lock rsAUDIO 13002 0)
				(SetFlag 16)
				(gCurRoom changeScene: 0)
			)
			((IsFlag 292)
				(gCurRoom changeScene: 340 1)
			)
			(else
				(gCurRoom setScript: sRandomBabySounds)
				(gCurRoom changeScene: 340 1)
			)
		)
		(if (and (IsFlag 172) (IsFlag 290))
			(gBackMusic2 fade: 127 10 5 0 0)
		)
	)

	(method (changeScene param1)
		(vToySoldier dispose:)
		(vNotes dispose:)
		(vAlarmClock dispose:)
		(vBlanket dispose:)
		(vBottle dispose:)
		(fBaby dispose:)
		(pBaby dispose:)
		(moveOutLeft dispose:)
		(moveOutRight dispose:)
		(moveUpLeft dispose:)
		(exitToBabyLeft dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(0
				(gTGlobalTimer delete: dispose:)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) hide:) ; PlCompass
				)
				(gIRandomMusic stop:)
				(gBackMusic2 stop:)
				(SetFlag 162)
				(SetFlag 290)
				(SetFlag 172)
				(gMySoundFX do: 1304)
				(proc0_8 130)
				(gCurRoom drawPic: 340)
				(if (and (IsFlag 172) (or (IsFlag 290) (IsFlag 413)))
					(Portal init: 6324 260 30)
					(Portal stopSound:)
				)
				(if (not (IsFlag 58))
					(vToySoldier init:)
				)
				(FrameOut)
				(gMySoundFX fade: 0 10 5 1 0)
				(gIRandomMusic
					musicOne: 1301
					musicTwo: 1302
					musicThree: 1303
					play: 127 0
				)
				(if (gPanels contains: (ScriptID 9 3)) ; PlCompass
					((ScriptID 9 3) show:) ; PlCompass
				)
				(gBackMusic2 loop: -1 number: 176 play: 127 0)
				(gInventory deleteItem: (ScriptID 9 10)) ; invBabyBottle
				(gCurRoom changeScene: 340 1)
			)
			(340
				(if (not (IsFlag 162))
					(pBaby init: setCycle: Fwd)
				)
				(if (and (IsFlag 172) (or (IsFlag 290) (IsFlag 413)))
					(Portal init: 6324 260 30)
					(Portal stopSound:)
				)
				((ScriptID 1 1) newPic: 345 1) ; exitForward
				((ScriptID 1 2) newPic: 343 5) ; exitBack
				(exitToBabyLeft newPic: 344 3)
				(if (not (IsFlag 65))
					(vNotes init:)
				)
				(if (not (IsFlag 58))
					(vToySoldier init:)
					((ScriptID 1 2) nsLeft: 210) ; exitBack
				)
			)
			(341
				(if (and (IsFlag 172) (or (IsFlag 290) (IsFlag 413)))
					(Portal init: 6325 161 0)
					(Portal stopSound:)
					((ScriptID 1 1) ; exitForward
						newRoom: 800
						createPoly:
							272
							66
							336
							48
							378
							86
							399
							218
							366
							274
							295
							275
							252
							212
							247
							128
					)
				)
				(if (not (IsFlag 65))
					(vNotes init:)
				)
				((ScriptID 1 3) newPic: 344 3) ; exitLeft
				((ScriptID 1 2) newPic: 343 5) ; exitBack
				(moveUpLeft newPic: 349 16)
			)
			(343
				(if (== local4 341)
					((ScriptID 1 2) newPic: 341 16) ; exitBack
				else
					((ScriptID 1 2) newPic: 345 1) ; exitBack
				)
				(moveOutLeft newRoom: 320)
				(moveOutRight newRoom: 320)
				((ScriptID 1 1) ; exitForward
					newRoom: 330
					createPoly: 226 81 274 81 274 267 226 267
				)
				((ScriptID 1 4) newPic: 344 3) ; exitRight
				(if (not (IsFlag 287))
					(vAlarmClock init:)
				)
			)
			(344
				(cond
					((IsFlag 162))
					((IsFlag 292)
						(Lock rsAUDIO 13002 1)
						(gBackMusic2 stop:)
					)
					(else
						(Lock rsAUDIO 171 1)
						(Lock rsAUDIO 172 1)
						(sndBabySound stop:)
					)
				)
				((ScriptID 1 4) newPic: 341 16 exitCode: exitBabyRight) ; exitRight
				((ScriptID 1 3) newPic: 343 5 exitCode: exitBabyLeft) ; exitLeft
				(if (IsFlag 162)
					(if (IsFlag 50)
						(vBottle init:)
					)
					(vBlanket init:)
				else
					(fBaby init:)
					(= local0 0)
					(= local1 0)
					(cond
						((IsFlag 50)
							(vBottle init:)
							(self setScript: sPlayRobot 0 104)
						)
						((IsFlag 292)
							(self setScript: sPlayRobot 0 101)
						)
						(else
							(self setScript: sPlayRobot 0 104)
						)
					)
				)
			)
			(345
				(if (and (IsFlag 172) (or (IsFlag 290) (IsFlag 413)))
					(Portal init: 4321 216 42)
					(Portal stopSound:)
				)
				(if (not (IsFlag 162))
					(pBaby init: setCycle: Fwd)
				)
				(if (not (IsFlag 65))
					(vNotes init:)
				)
				((ScriptID 1 1) newPic: 341 16) ; exitForward
				((ScriptID 1 2) newPic: 343 5) ; exitBack
				((ScriptID 1 3) newPic: 344 3) ; exitLeft
			)
			(349
				(if (not (IsFlag 65))
					(vNotes init:)
				)
				((ScriptID 1 7) newPic: 341 16) ; exitBackUp
			)
		)
		(= local4 param1)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (not (OneOf gNewRoomNum 320 330))
			(gIRandomMusic stop:)
			(if (and (IsFlag 172) (or (IsFlag 290) (IsFlag 413)))
				(gBackMusic2 stop:)
			)
		)
		(if local2
			(gTGlobalTimer setReal: gTGlobalTimer 30)
		)
		(Lock rsAUDIO 13002 0)
		(Lock rsAUDIO 171 0)
		(Lock rsAUDIO 172 0)
		(super dispose: &rest)
	)
)

(instance sPlayRobot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(KillRobot register local0 local1)
			)
			(1
				(if local3
					(= local3 0)
					(if (== register 104)
						(= register 101)
						(KillRobot 100 0 0)
					else
						(= register 109)
						(KillRobot 108 0 0)
					)
					(gGame handsOn:)
				else
					(= state -1)
					(self cue:)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sRandomBabySounds of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (== (Random 1 7) 3)
					(sndBabySound number: 172 play: 127 self)
				else
					(sndBabySound number: 171 play: 127 self)
				)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance pBaby of Prop
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(340
				(= view 102)
				(= cel (= loop 0))
				(= x 119)
				(= y 206)
			)
			(345
				(= view 103)
				(= x (= cel (= loop 0)))
				(= y 244)
			)
		)
		(super init: &rest)
	)
)

(instance vBottle of View
	(properties
		x 362
		y 220
		view 348
	)
)

(instance vBlanket of View
	(properties
		x 50
		y 180
		view 6310
	)
)

(instance vNotes of View
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(340
				(self view: 340 x: 283 y: 189)
			)
			(341
				(self view: 341 x: 92 y: 277)
			)
			(349
				(self view: 349 x: 169 y: 115)
			)
			(345
				(self view: 345 x: 255 y: 224)
			)
		)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (== (gCurRoom scene:) 349)
					(SetFlag 65)
					(gInventory addToNotebook: (ScriptID 9 28)) ; invBedroomNotes
					(self dispose:)
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

(instance vAlarmClock of View
	(properties
		x 124
		y 259
		view 6323
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 287)
				(gMySoundFX do: 178)
				(gInventory addItem: (ScriptID 9 69)) ; invAlarmClock
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vToySoldier of View
	(properties
		x 163
		y 291
		view 4324
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 17011)
				(SetFlag 58)
				(gInventory addItem: (ScriptID 9 24)) ; invToySoldier
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fBaby of Feature
	(properties)

	(method (init)
		(self createPoly: 167 39 321 39 321 297 166 297)
		(super init: &rest)
		(approachX hotVerbs: 5 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (and (not (IsFlag 292)) (not (IsFlag 50)))
					(gGame handsOff:)
					(= local3 1)
					(SetFlag 292)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(8 ; invBabyBottle
				(if (IsFlag 292)
					(gGame handsOff:)
					(gInventory deleteItem: (ScriptID 9 10)) ; invBabyBottle
					(= local3 1)
					(ClearFlag 292)
					(SetFlag 50)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance moveOutRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self createPoly: 274 81 319 81 319 267 274 267)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(self setPolygon: 0 createPoly: 274 81 319 81 319 267 274 267)
	)

	(method (doVerb theVerb)
		(SetFlag 70)
		(super doVerb: theVerb)
	)
)

(instance exitToBabyLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 8)
		(self createPoly: 87 131 87 220 198 220 198 131)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 8)
		(self setPolygon: 0 createPoly: 87 131 87 220 198 220 198 131)
	)
)

(instance moveOutLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(self createPoly: 181 81 226 81 226 267 181 267)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(self setPolygon: 0 createPoly: 181 81 226 81 226 267 181 267)
	)

	(method (doVerb theVerb)
		(ClearFlag 70)
		(super doVerb: theVerb)
	)
)

(instance sndBabySound of Sound
	(properties)
)

(instance exitBabyRight of Code
	(properties)

	(method (doit)
		(cond
			((IsFlag 162))
			((IsFlag 292)
				(gBackMusic2 loop: -1 number: 13002 play: 127 0)
			)
			(else
				(gCurRoom setScript: sRandomBabySounds)
			)
		)
		(gCurRoom changeScene: 341 16)
	)
)

(instance exitBabyLeft of Code
	(properties)

	(method (doit)
		(cond
			((IsFlag 162))
			((IsFlag 292)
				(gBackMusic2 loop: -1 number: 13002 play: 127 0)
			)
			(else
				(gCurRoom setScript: sRandomBabySounds)
			)
		)
		(gCurRoom changeScene: 343 5)
	)
)

(instance moveUpLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 9)
		(self createPoly: 64 224 165 224 165 299 64 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 9)
		(self createPoly: 64 224 165 224 165 299 64 299)
	)
)

