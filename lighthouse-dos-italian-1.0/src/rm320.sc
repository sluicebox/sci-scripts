;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use LightRoom)
(use Portal)
(use PanelPlane)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	local0
	local1
	[local2 5]
)

(instance rm320 of LightRoom
	(properties)

	(method (init)
		(Lock rsAUDIO 150 1)
		(super init: &rest)
		(gGame handsOff:)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(gBackMusic2 fade: 70 5 10 0 0)
		)
		(switch gPrevRoomNum
			(350
				(if (IsFlag 62)
					(gCurRoom changeScene: 329 3)
				else
					(gCurRoom changeScene: 327 7)
				)
				(gUser canInput: 0)
				(gMySoundFX do: 13201 self)
			)
			(340
				(if (IsFlag 70)
					(gCurRoom changeScene: 356 3)
				else
					(gCurRoom changeScene: 328 7)
				)
				(gUser canInput: 0)
				(gMySoundFX do: 13201 self)
			)
			(330
				(if (IsFlag 71)
					(gCurRoom changeScene: 328 7)
				else
					(gCurRoom changeScene: 356 3)
				)
			)
			(360
				(gIRandomMusic
					musicOne: 1301
					musicTwo: 1302
					musicThree: 1303
					play: 127 0
				)
				(gCurRoom changeScene: 358 7)
				(gUser canInput: 0)
				(gMySoundFX do: 135 self)
			)
			(300
				(gIRandomMusic
					musicOne: 1301
					musicTwo: 1302
					musicThree: 1303
					play: 127 0
				)
				(gCurRoom changeScene: 331 3)
				(gUser canInput: 0)
				(gMySoundFX do: 112 self)
			)
			(else
				(gIRandomMusic
					musicOne: 1301
					musicTwo: 1302
					musicThree: 1303
					play: 127 0
				)
				(gCurRoom changeScene: 331 3)
			)
		)
	)

	(method (changeScene param1)
		(fKeypad dispose:)
		(fPicture dispose:)
		(pStudyDoor dispose:)
		(pFrontDoor dispose:)
		(pBedroomDoor dispose:)
		(pLabDoor dispose:)
		(pDoorStuff dispose:)
		(moveStudyRight dispose:)
		(moveStudyLeft dispose:)
		(moveOilroomLeft dispose:)
		(moveBedroomRight dispose:)
		(moveFrontDoorForward dispose:)
		(moveBedroomLeft dispose:)
		(moveOilroomRight dispose:)
		(moveLabForward dispose:)
		(super changeScene: param1 &rest)
		(if (gSounds contains: fireFX)
			(fireFX stop:)
		)
		(switch param1
			(327
				((ScriptID 1 2) newPic: 331 3 exitCode: backExitCode) ; exitBack
				(pFrontDoor init:)
			)
			(328
				(pStudyDoor init:)
				((ScriptID 1 2) newPic: 327 7 exitCode: backExitCode) ; exitBack
				((ScriptID 1 1) newPic: 327 7 exitCode: forwardExitCode) ; exitForward
			)
			(329
				(pBedroomDoor init:)
				(fPicture init:)
				((ScriptID 1 1) newPic: 356 3 exitCode: forwardExitCode) ; exitForward
				(moveOilroomLeft newPic: 330 3 exitCode: rightExitCode)
				((ScriptID 1 2) newPic: 328 7 exitCode: backExitCode) ; exitBack
				(fireFX play: 26 0)
			)
			(331
				(pStudyDoor init:)
				((ScriptID 1 1) newPic: 329 3 exitCode: forwardExitCode) ; exitForward
				((ScriptID 1 2) newPic: 327 7 exitCode: backExitCode) ; exitBack
			)
			(356
				(pLabDoor init:)
				(fKeypad init:)
				((ScriptID 1 2) newPic: 358 7 exitCode: backExitCode) ; exitBack
			)
			(358
				((ScriptID 1 1) newPic: 328 7 exitCode: forwardExitCode) ; exitForward
				((ScriptID 1 2) newPic: 356 3 exitCode: backExitCode) ; exitBack
				(moveOilroomRight newRoom: 330 3 exitCode: rightExitCode)
				(pBedroomDoor init:)
			)
		)
		(= local1 param1)
		(gGame handsOn:)
	)

	(method (cue)
		(gUser canInput: 1)
	)

	(method (dispose)
		(Lock rsAUDIO 150 0)
		(if (not (OneOf gNewRoomNum 330 340 350 300 360))
			(gIRandomMusic stop:)
		)
		(super dispose: &rest)
	)
)

(instance sOpenLabDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 433)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(pplKeypad dispose:)
				(fKeypad dispose:)
				(= cycles 1)
			)
			(2
				(gMySoundFX do: 134)
				(pLabDoor setCycle: End self)
			)
			(3
				(moveLabForward newRoom: 360 3 exitCode: labExitCode)
				(if
					(or
						(and (IsFlag 172) (IsFlag 289))
						(and (IsFlag 37) (IsFlag 49))
					)
					(pDoorStuff init: setCycle: Fwd)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pDoorStuff of Prop
	(properties
		y 300
		loop 1
		z 1
	)

	(method (init)
		(cond
			((and (IsFlag 172) (IsFlag 289))
				(= view 4310)
				(= x 192)
			)
			((and (IsFlag 37) (IsFlag 49))
				(= view 4300)
				(= x 268)
			)
		)
		(super init: &rest)
	)
)

(instance pLabDoor of Prop
	(properties)

	(method (init)
		(= loop (= cel 0))
		(cond
			((and (IsFlag 172) (IsFlag 289))
				(= view 4310)
				(= x 138)
				(= y 299)
			)
			((and (IsFlag 37) (IsFlag 49))
				(= view 4300)
				(= x 138)
				(= y 299)
			)
			(else
				(= view 4309)
				(= x 138)
				(= y 8)
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if cel
					(gGame handsOff:)
					(pDoorStuff dispose:)
					(moveLabForward dispose:)
					(fKeypad init:)
					(gMySoundFX do: 135)
					(self setCycle: Beg self)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance pBedroomDoor of Prop
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 329)
			(self view: 4308 loop: 0 cel: 0 x: 375 y: 72 z: 0)
		else
			(self view: 5299 loop: 0 cel: 0 x: 0 y: 1 z 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(if (== (gCurRoom scene:) 329)
						(moveBedroomRight dispose:)
					else
						(moveBedroomLeft dispose:)
					)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 70 5 10 0 0)
					)
					(self setCycle: Beg self)
				else
					(if (== (gCurRoom scene:) 329)
						(moveBedroomRight newRoom: 340)
					else
						(moveBedroomLeft newRoom: 340)
					)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 100 5 10 0 0)
					)
					(gMySoundFX do: 133)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (not cel)
			(gMySoundFX do: 13201)
			(if (and (IsFlag 172) (IsFlag 290))
				(Portal fadeSound:)
			)
		)
		(gGame handsOn:)
	)
)

(instance pStudyDoor of Prop
	(properties)

	(method (init)
		(if (== (gCurRoom scene:) 328)
			(self view: 4313 loop: 0 cel: 0 x: 39 y: 299)
		else
			(self view: 4307 loop: 0 cel: 0 x: 393 y: 299)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					(if (== (gCurRoom scene:) 328)
						(moveStudyLeft dispose:)
					else
						(moveStudyRight dispose:)
					)
					(self setCycle: Beg self)
				else
					(if (== (gCurRoom scene:) 328)
						(moveStudyLeft newRoom: 350)
					else
						(moveStudyRight newRoom: 350)
					)
					(gMySoundFX do: 132)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (not cel)
			(gMySoundFX do: 13201)
		)
		(gGame handsOn:)
	)
)

(instance pFrontDoor of Prop
	(properties
		x 137
		y 299
		view 5300
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if cel
					((ScriptID 1 1) dispose:) ; exitForward
					(self setCycle: Beg self)
				else
					(gMySoundFX do: 111)
					((ScriptID 1 1) newRoom: 300 7 exitCode: outsideExitCode) ; exitForward
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if (not cel)
			(gMySoundFX do: 112)
		)
		(gGame handsOn:)
	)
)

(instance fKeypad of Feature
	(properties)

	(method (init)
		(self createPoly: 296 173 330 173 330 221 296 221)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (IsFlag 433)
					(gGame handsOff:)
					(sOpenLabDoor start: 2)
					(gCurRoom setScript: sOpenLabDoor)
				else
					(pplKeypad init:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance moveLabForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(self createPoly: 194 29 330 30 323 300 196 300)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(self setPolygon: 0 createPoly: 194 29 330 30 323 300 196 300)
	)
)

(instance moveFrontDoorForward of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 3)
		(self createPoly: 205 92 289 92 289 255 205 255)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 3)
		(self setPolygon: 0 createPoly: 205 92 289 92 289 255 205 255)
	)
)

(instance moveStudyRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self createPoly: 397 60 499 20 499 299 394 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(self setPolygon: 0 createPoly: 397 60 499 20 499 299 394 299)
	)
)

(instance moveStudyLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(self createPoly: 48 36 117 68 124 299 54 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(self setPolygon: 0 createPoly: 48 36 117 68 124 299 54 299)
	)
)

(instance moveBedroomRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self createPoly: 387 70 473 35 463 299 377 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(self setPolygon: 0 createPoly: 387 70 473 35 463 299 377 299)
	)
)

(instance moveBedroomLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(self createPoly: 44 299 9 0 61 0 103 18 128 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(self setPolygon: 0 createPoly: 44 299 9 0 61 0 103 18 128 299)
	)
)

(instance moveOilroomRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self createPoly: 426 17 469 0 498 0 498 52 465 299 408 299)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(self
			setPolygon: 0
			createPoly: 426 17 469 0 498 0 498 52 465 299 408 299
		)
	)
)

(instance moveOilroomLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(self createPoly: 132 299 0 299 0 12 125 65)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(self setPolygon: 0 createPoly: 132 299 0 299 0 12 125 65)
	)
)

(instance fireFX of Sound
	(properties
		number 150
		loop -1
	)
)

(instance sFadeTheMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
					(gBackMusic2 fade: 10 5 10 0 0)
				)
				(gIRandomMusic fade: 0 5 10 1)
				(= ticks 120)
			)
			(1
				(gCurRoom newRoom: register)
				(self dispose:)
			)
		)
	)
)

(instance labExitCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(gCurRoom setScript: sFadeTheMusic 0 360)
	)
)

(instance outsideExitCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(gCurRoom setScript: sFadeTheMusic 0 300)
	)
)

(instance rightExitCode of Code
	(properties)

	(method (doit)
		(if (pBedroomDoor cel:)
			(gGame handsOff:)
			(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
				(gBackMusic2 fade: 70 5 10 0 0)
			)
			(pBedroomDoor setCycle: Beg self)
		else
			(gCurRoom newRoom: 330 5)
		)
	)

	(method (cue)
		(if (and (IsFlag 172) (IsFlag 290))
			(Portal fadeSound:)
		)
		(gMySoundFX do: 13201)
		(gCurRoom newRoom: 330 5)
	)
)

(instance forwardExitCode of Code
	(properties)

	(method (doit)
		(switch (gCurRoom scene:)
			(328
				(if (pStudyDoor cel:)
					(gGame handsOff:)
					(pStudyDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 327 7)
				)
			)
			(329
				(if (pBedroomDoor cel:)
					(gGame handsOff:)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 70 5 10 0 0)
					)
					(pBedroomDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 356 3)
				)
			)
			(331
				(if (pStudyDoor cel:)
					(gGame handsOff:)
					(pStudyDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 329 3)
				)
			)
			(358
				(if (pBedroomDoor cel:)
					(gGame handsOff:)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 70 5 10 0 0)
					)
					(pBedroomDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 328 7)
				)
			)
		)
	)

	(method (cue)
		(gMySoundFX do: 13201)
		(switch (gCurRoom scene:)
			(328
				(gCurRoom changeScene: 327 7)
			)
			(329
				(if (and (IsFlag 172) (IsFlag 290))
					(Portal fadeSound:)
				)
				(gCurRoom changeScene: 356 3)
			)
			(331
				(gCurRoom changeScene: 329 3)
			)
			(358
				(if (and (IsFlag 172) (IsFlag 290))
					(Portal fadeSound:)
				)
				(gCurRoom changeScene: 328 7)
			)
		)
	)
)

(instance backExitCode of Code
	(properties)

	(method (doit)
		(switch (gCurRoom scene:)
			(327
				(if (pFrontDoor cel:)
					(gGame handsOff:)
					(pFrontDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 331 3)
				)
			)
			(328
				(if (pStudyDoor cel:)
					(gGame handsOff:)
					(pStudyDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 329 3)
				)
			)
			(329
				(if (pBedroomDoor cel:)
					(gGame handsOff:)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 70 5 10 0 0)
					)
					(pBedroomDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 328 7)
				)
			)
			(331
				(if (pStudyDoor cel:)
					(gGame handsOff:)
					(pStudyDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 327 7)
				)
			)
			(356
				(if (pLabDoor cel:)
					(gGame handsOff:)
					(gMySoundFX do: 135)
					(pDoorStuff dispose:)
					(pLabDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 358 7)
				)
			)
			(358
				(if (pBedroomDoor cel:)
					(gGame handsOff:)
					(if
						(or
							(IsFlag 290)
							(IsFlag 413)
							(IsFlag 292)
							(IsFlag 267)
						)
						(gBackMusic2 fade: 70 5 10 0 0)
					)
					(pBedroomDoor setCycle: Beg self)
				else
					(gCurRoom changeScene: 356 3)
				)
			)
		)
	)

	(method (cue)
		(switch (gCurRoom scene:)
			(327
				(gMySoundFX do: 112)
				(gCurRoom changeScene: 331 3)
			)
			(328
				(gMySoundFX do: 13201)
				(gCurRoom changeScene: 329 3)
			)
			(329
				(if (and (IsFlag 172) (IsFlag 290))
					(Portal fadeSound:)
				)
				(gMySoundFX do: 13201)
				(gCurRoom changeScene: 328 7)
			)
			(331
				(gMySoundFX do: 13201)
				(gCurRoom changeScene: 327 7)
			)
			(356
				(gCurRoom changeScene: 358 7)
			)
			(358
				(if (and (IsFlag 172) (IsFlag 290))
					(Portal fadeSound:)
				)
				(gMySoundFX do: 13201)
				(gCurRoom changeScene: 356 3)
			)
		)
	)
)

(instance pplKeypad of InsetPanelPlane
	(properties)

	(method (init)
		((ScriptID 1 1) dispose:) ; exitForward
		(Lock rsAUDIO 14 1)
		(super init: &rest)
		(self setBitmap: 4306 0 0)
		(pNumber1 init: self 1 1)
		(pNumber2 init: self 1 1)
		(pNumber3 init: self 1 1)
		(pNumber4 init: self 1 1)
		(pNumber5 init: self 1 1)
		(pNumber6 init: self 1 1)
		(pNumber7 init: self 1 1)
		(pNumber8 init: self 1 1)
		(pNumber9 init: self 1 1)
		(pNumber0 init: self 1 1)
		(pEnter init: self 1 1)
	)

	(method (dispose)
		(Lock rsAUDIO 14 0)
		(super dispose: &rest)
	)
)

(class ButtonProp of PanelProp
	(properties
		view 4306
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(self setScript: (ScriptID 0 3) self) ; sDepress
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(cond
			((== loop 11)
				(if
					(and
						(== [local2 0] 8)
						(== [local2 1] 2)
						(== [local2 2] 4)
						(== [local2 3] 9)
						(== [local2 4] 6)
						(IsFlag 61)
					)
					(gCurRoom setScript: sOpenLabDoor)
				)
				(= [local2 0] 0)
				(= [local2 1] 0)
				(= [local2 2] 0)
				(= [local2 3] 0)
				(= [local2 4] 0)
				(= local0 0)
			)
			((<= local0 4)
				(= [local2 local0] (self loop:))
				(++ local0)
			)
		)
	)
)

(instance pNumber1 of ButtonProp
	(properties
		x 81
		y 61
		loop 1
	)
)

(instance pNumber2 of ButtonProp
	(properties
		x 99
		y 61
		loop 2
	)
)

(instance pNumber3 of ButtonProp
	(properties
		x 117
		y 61
		loop 3
	)
)

(instance pNumber4 of ButtonProp
	(properties
		x 81
		y 80
		loop 4
	)
)

(instance pNumber5 of ButtonProp
	(properties
		x 99
		y 80
		loop 5
	)
)

(instance pNumber6 of ButtonProp
	(properties
		x 117
		y 80
		loop 6
	)
)

(instance pNumber7 of ButtonProp
	(properties
		x 81
		y 99
		loop 7
	)
)

(instance pNumber8 of ButtonProp
	(properties
		x 99
		y 99
		loop 8
	)
)

(instance pNumber9 of ButtonProp
	(properties
		x 117
		y 99
		loop 9
	)
)

(instance pNumber0 of ButtonProp
	(properties
		x 99
		y 119
		loop 10
	)
)

(instance pEnter of ButtonProp
	(properties
		x 77
		y 139
		loop 11
	)
)

(instance pplPicture of PanelPlane
	(properties)

	(method (handleEvent event)
		(cond
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: event))
					(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				)
				(event claimed: 1)
				(self dispose:)
			)
			((and (not (self onMe: event)) (not ((ScriptID 9 1) onMe: event))) ; PlInterface
				(event claimed: 1)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (init)
		(if casts
			(return)
		)
		(= priority (+ (GetHighPlanePri) 1))
		(= picture -1)
		(super init: 0 0 164 166)
		(self setBitmap: 6305 0 0)
	)
)

(instance fPicture of Feature
	(properties)

	(method (init)
		(self createPoly: 143 85 176 91 171 159 143 169)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplPicture init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buttonFX of Sound ; UNUSED
	(properties
		number 14
	)
)

