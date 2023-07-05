;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use LightRoom)
(use RobotPlayer)
(use PanelPlane)
(use Feature)
(use Cursor)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	[local0 2]
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 4]
)

(instance rm350 of LightRoom
	(properties
		picture 350
	)

	(method (init)
		(super init: &rest)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(gBackMusic2 fade: 40 10 5 0 0)
		)
		(if (!= gPrevRoomNum 320)
			(gIRandomMusic
				musicOne: 1301
				musicTwo: 1302
				musicThree: 1303
				play: 127 0
			)
		)
		(switch gPrevRoomNum
			(351
				(= local5 1)
				(self changeScene: 354 7)
			)
			(765
				(self changeScene: 352 1)
			)
			(else
				(self changeScene: 350 1)
			)
		)
	)

	(method (changeScene param1)
		(rRollTop dispose:)
		(fWallSafe dispose:)
		(fDeskDrawer dispose:)
		(fRollTopDesk dispose:)
		(fPicture dispose:)
		(pBooks dispose:)
		(vBooks dispose:)
		(vSparrow dispose:)
		(vJems dispose:)
		(vBaubles dispose:)
		(moveOutLeft dispose:)
		(moveOutRight dispose:)
		(super changeScene: param1 &rest)
		(switch param1
			(350
				(vBooks init:)
				((ScriptID 1 1) newPic: 352 1) ; exitForward
				((ScriptID 1 2) newPic: 353 5) ; exitBack
				((ScriptID 1 4) newPic: 354 7) ; exitRight
			)
			(351
				((ScriptID 1 2) newPic: 354 7) ; exitBack
				((ScriptID 1 4) newPic: 352 1) ; exitRight
				((ScriptID 1 3) newPic: 353 5) ; exitLeft
				(if (not (IsFlag 123))
					(vSparrow init:)
				)
				(if (not (IsFlag 124))
					(vJems init:)
				)
				(if (not (IsFlag 125))
					(vBaubles init:)
				)
			)
			(352
				(SetFlag 179)
				(fPicture init:)
				(pBooks init:)
				(if (== global211 (pBooks lastCel:))
					(fWallSafe init:)
				)
				((ScriptID 1 2) newPic: 353 5) ; exitBack
				((ScriptID 1 3) newPic: 351 3) ; exitLeft
				((ScriptID 1 4) newPic: 354 7) ; exitRight
			)
			(353
				(fPicture init:)
				(moveOutRight newRoom: 320)
				(moveOutLeft newRoom: 320)
				((ScriptID 1 2) newPic: 352 1) ; exitBack
				((ScriptID 1 4) newPic: 351 3) ; exitRight
				((ScriptID 1 3) ; exitLeft
					newPic: 354 7
					nsTop: 103
					nsLeft: 1
					nsBottom: 284
					nsRight: 212
				)
			)
			(354
				(Load rsAUDIO 194 193 19300 19400)
				(fPicture init:)
				(cond
					((== local5 1)
						(= local5 0)
						(if (not (IsFlag 169))
							(fLittleBox init:)
						)
						(if (IsFlag 64)
							(rRollTop init: 4364 18 204 95)
						else
							(fStudyNotes init:)
							(rRollTop init: 4361 18 202 92)
						)
					)
					((IsFlag 64)
						(rRollTop init: 4364 0 204 95)
					)
					(else
						(rRollTop init: 4361 0 202 92)
					)
				)
				((ScriptID 1 2) newPic: 351 3 exitCode: myBackExitCode) ; exitBack
				((ScriptID 1 3) newPic: 352 1 exitCode: myLeftExitCode) ; exitLeft
				((ScriptID 1 4) newPic: 353 5 exitCode: myRightExitCode) ; exitRight
				(fDeskDrawer init:)
				(fRollTopDesk init:)
			)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(rRollTop dispose:)
		(if (not (OneOf gNewRoomNum 320 351))
			(gIRandomMusic stop:)
		)
		(super dispose: &rest)
	)
)

(instance sOpenRollTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (rRollTop curFrame:)
					(if (not (IsFlag 64))
						(fStudyNotes dispose:)
					)
					(if (not (IsFlag 169))
						(fLittleBox dispose:)
					)
					(gMySoundFX do: 194)
					(rRollTop caller: self start: 2 40)
				else
					(fRollTopDesk dispose:)
					(if (not (IsFlag 64))
						(fStudyNotes init:)
					)
					(if (not (IsFlag 169))
						(fLittleBox init:)
					)
					(fRollTopDesk init:)
					(gMySoundFX do: 193)
					(rRollTop caller: self start: 1 40)
				)
			)
			(1
				(if (rRollTop curFrame:)
					(gMySoundFX do: 19300)
				else
					(gMySoundFX do: 19400)
				)
				(switch register
					(1
						(gCurRoom changeScene: 351 3)
					)
					(2
						(gCurRoom changeScene: 352 1)
					)
					(3
						(gCurRoom changeScene: 353 5)
					)
					(4
						(gGame handsOn:)
						(pplDrawerPanel init:)
					)
					(else
						(gGame handsOn:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance pBooks of Prop
	(properties
		x 90
		y 51
		view 4362
	)

	(method (init)
		(= cel global211)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					((and (> gMouseX 260) (!= global211 (self lastCel:)))
						(++ global211)
						(self setCel: global211)
					)
					((and (< gMouseX 260) (!= global211 0))
						(-- global211)
						(self setCel: global211)
					)
				)
				(gMySoundFX do: (+ 195 (Random 0 2)))
				(if (== global211 (self lastCel:))
					(fWallSafe init:)
				else
					(fWallSafe dispose:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vBooks of View
	(properties
		priority 500
		x 126
		y 41
		view 4360
		fixPriority 1
	)

	(method (init)
		(= cel global211)
		(super init: &rest)
	)
)

(instance vSparrow of View
	(properties
		x 230
		y 59
		loop 2
		view 4365
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 19903)
				(SetFlag 123)
				(gInventory addItem: (ScriptID 9 40)) ; invSparrow
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vJems of View
	(properties
		x 159
		y 114
		loop 1
		view 4365
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 19901)
				(SetFlag 124)
				(gInventory addItem: (ScriptID 9 42)) ; invJems
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vBaubles of View
	(properties
		x 244
		y 112
		view 4365
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 19902)
				(SetFlag 125)
				(gInventory addItem: (ScriptID 9 41)) ; invBaubles
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fWallSafe of Feature
	(properties)

	(method (init)
		(self createPoly: 217 64 256 64 256 97 217 97)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplWallSafe init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fLittleBox of Feature
	(properties
		y 100
	)

	(method (init)
		(self createPoly: 251 169 268 176 286 169 284 145 263 142 250 148)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: 351)
	)
)

(instance fDeskDrawer of Feature
	(properties)

	(method (init)
		(self createPoly: 309 98 388 98 388 71 309 71)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (rRollTop curFrame:)
					(gCurRoom setScript: sOpenRollTop 0 4)
				else
					(pplDrawerPanel init:)
				)
			)
		)
	)
)

(instance fRollTopDesk of Feature
	(properties)

	(method (init)
		(self
			createPoly: 217 101 391 101 402 113 408 135 408 175 216 175 215 120
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(or
				(and
					(not (self onMe: event))
					(& (event type:) evMOUSEBUTTON)
					(rRollTop curFrame:)
				)
				(and
					(self onMe: event)
					(& (event type:) evMOUSEBUTTON)
					(not (rRollTop curFrame:))
				)
			)
			(gCurRoom setScript: sOpenRollTop 0 0)
		)
		(super handleEvent: event &rest)
	)
)

(instance pplDrawerPanel of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppDrawer cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 199)
			(ppDrawer setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(ppDrawer init: self 1 1)
		(pfDrawer init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplWallSafe of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppWallSafe cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 191)
			(ppWallSafe setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(ppWallSafe init: self 1 1)
		(pfHandle init: self 1 1)
		(pfComboLock init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplCombinationLock of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
			)
			(event claimed: 1)
			(pplWallSafe init:)
			(self dispose:)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(if (not (Platform 4))
			(DoAudio 18 1) ; AudDACCritical
		)
		(= normalizeTheCursor 1)
		(super init: &rest)
		(self setBitmap: 4327 3 0)
		(ppCombinationLock init: self 1 1)
	)

	(method (dispose)
		(if (not (Platform 4))
			(DoAudio 18 0) ; AudDACCritical
		)
		(super dispose: &rest)
		(gGame normalizeCursor:)
	)
)

(instance ppDrawer of PanelProp
	(properties
		view 4326
	)

	(method (init)
		(self setLoop: (if (IsFlag 60) 1 else 0) setCel: 0)
		(super init: &rest)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance ppWallSafe of PanelProp
	(properties
		view 4325
	)

	(method (init)
		(self setLoop: (if (IsFlag 61) 1 else 0) setCel: 0)
		(super init: &rest)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(class ppCombinationLock of PanelProp
	(properties
		x 24
		y 26
		view 4327
	)

	(method (turnLeft)
		(if (IsFlag 32)
			(++ local8)
		)
		(if (== (self cel:) (self lastCel:))
			(self setCel: 0)
		else
			(self setCel: (+ (self cel:) 1))
		)
	)

	(method (turnRight)
		(if (IsFlag 32)
			(++ local3)
			(++ local9)
		)
		(if (and (not local2) (>= local3 35))
			(= local2 1)
		)
		(if (== (self cel:) 0)
			(self setCel: (self lastCel:))
		else
			(self setCel: (- (self cel:) 1))
		)
	)

	(method (resetTumblers)
		(= local7 0)
		(= local2 0)
		(= local6 0)
		(= local3 0)
		(= local8 0)
		(= local9 0)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(self onMe: event)
					(> gMouseX 100)
					(!= gTheCursor rightCursor)
				)
				(gGame setCursor: rightCursor)
			)
			((and (self onMe: event) (< gMouseX 100) (!= gTheCursor leftCursor))
				(gGame setCursor: leftCursor)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(gUser canInput: 0)
		(if local7
			(self resetTumblers:)
		)
		(Lock rsAUDIO (spinSound number:) 1)
		(if (== gTheCursor rightCursor)
			(self turnRight:)
		else
			(self turnLeft:)
		)
		(UpdateScreenItem self)
		(FrameOut)
		(spinSound loop: 1 play:)
		(= temp4 gGameTime)
		(= temp5 10)
		(while
			(> (-= temp5 (Abs (- (= gGameTime (+ gTickOffset (GetTime))) temp4))) 0)
			(= temp4 gGameTime)
		)
		(cond
			((not local2))
			((and (== local6 0) (== gTheCursor leftCursor))
				(= local8 0)
				(= [local10 local6] (self cel:))
				(++ local6)
			)
			((and (== local6 1) (== gTheCursor rightCursor) (== local8 48))
				(= local9 0)
				(= [local10 local6] (self cel:))
				(++ local6)
			)
			((and (== local6 2) (== gTheCursor rightCursor) (== local9 25))
				(= [local10 local6] (self cel:))
				(++ local6)
			)
			(
				(or
					(and (== local6 1) (== gTheCursor leftCursor) (> local8 48))
					(and (== local6 1) (== gTheCursor rightCursor) (< local8 48))
					(and (== local6 2) (== gTheCursor leftCursor) (< local9 25))
					(and (== local6 2) (== gTheCursor rightCursor) (> local9 25))
				)
				(self resetTumblers:)
			)
		)
		(= temp3 0)
		(if (and (not (Platform 4)) (not temp3))
			(= temp3 1)
			(gIRandomMusic pause: 1)
		)
		(= temp4 gGameTime)
		(= temp5 5)
		(while (not (& ((= temp6 (Event new:)) type:) evMOUSERELEASE))
			(if
				(<=
					(-=
						temp5
						(Abs (- (= gGameTime (+ gTickOffset (GetTime))) temp4))
					)
					0
				)
				(if (== gTheCursor rightCursor)
					(self turnRight:)
				else
					(self turnLeft:)
				)
				(spinSound loop: 1 play:)
				(UpdateScreenItem self)
				(FrameOut)
				(= temp5 5)
			)
			(= temp4 gGameTime)
			(temp6 dispose:)
		)
		(temp6 dispose:)
		(spinSound stop:)
		(Lock rsAUDIO (spinSound number:) 0)
		(gIRandomMusic pause: 0)
		(while ((= temp1 (Event new: 3)) type:)
			(temp1 dispose:)
		)
		(temp1 dispose:)
		(if
			(and
				(IsFlag 32)
				(== local6 3)
				(== [local10 0] 6)
				(== [local10 1] 17)
				(== [local10 2] 28)
			)
			(= local7 1)
			(pplWallSafe init:)
			(pplCombinationLock dispose:)
		)
		(gUser canInput: 1)
	)
)

(instance pfSafeDoor of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 135 67 198 16 198 199 138 136)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (not (IsFlag 61))
					(pfNotebook dispose: pplWallSafe 1 1)
				)
				(pfComboLock init: pplWallSafe 1 1)
				(pfHandle init: pplWallSafe 1 1)
				(gMySoundFX do: 191)
				(ppWallSafe setCycle: Beg ppWallSafe)
				(self dispose: pplWallSafe 1 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pfNotebook of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 88 133 137 133 148 155 68 155)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMySoundFX do: 19201)
				(SetFlag 61)
				(gInventory deleteItem: (ScriptID 9 12)) ; invLetter
				(gInventory addItem: (ScriptID 9 26)) ; invNotebook
				(ppWallSafe setLoop: 1)
				(UpdateScreenItem ppWallSafe)
				(if (IsFlag 64)
					(gInventory deleteItem: (ScriptID 9 27)) ; invStudyNotes
				)
				(if (IsFlag 65)
					(gInventory deleteItem: (ScriptID 9 28)) ; invBedroomNotes
				)
				(if (IsFlag 66)
					(gInventory deleteItem: (ScriptID 9 29)) ; invKitchenNotes
				)
				(if (IsFlag 67)
					(gInventory deleteItem: (ScriptID 9 30)) ; invLabNotes
				)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pfHandle of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 29 77 48 67 61 78 56 92 55 134 29 134)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if local7
					(gGame handsOff:)
					(if (not (IsFlag 61))
						(pfNotebook init: pplWallSafe 1 1)
					)
					(gMySoundFX do: 190)
					(ppWallSafe setCycle: End ppWallSafe)
					(pfSafeDoor init: pplWallSafe 1 1)
					(pfComboLock dispose: pplWallSafe 1 1)
					(self dispose: pplWallSafe 1 1)
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

(instance pfComboLock of PanelFeature
	(properties)

	(method (init)
		(self
			createPoly: 100 65 124 76 136 97 128 122 99 135 74 122 69 98 78 76
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplWallSafe dispose:)
				(pplCombinationLock init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pfDrawer of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 0 148 155 85 166 32 0 78)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (ppDrawer cel:)
					(self setPolygon: 0)
					(self createPoly: 0 148 155 85 166 32 0 78)
					(if (gFeatures contains: pfLetterOpener)
						(pfLetterOpener dispose:)
					)
					(gMySoundFX do: 199)
					(ppDrawer setCycle: Beg ppDrawer)
				else
					(if (not (IsFlag 60))
						(pfLetterOpener init: pplDrawerPanel)
					)
					(self setPolygon: 0)
					(self createPoly: 0 199 51 199 199 137 199 87 0 166)
					(gMySoundFX do: 198)
					(ppDrawer setCycle: End ppDrawer)
				)
			)
		)
	)
)

(instance pfLetterOpener of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 84 120 145 69 127 58 67 110)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 60)
				(gMySoundFX do: 4001)
				(gInventory addItem: (ScriptID 9 15)) ; invLetterOpener
				(ppDrawer setLoop: 1)
				(self dispose:)
			)
		)
	)
)

(instance rRollTop of RobotPlayer
	(properties)
)

(instance rightCursor of Cursor
	(properties
		loop 1
		cel 1
		view 4327
	)
)

(instance leftCursor of Cursor
	(properties
		loop 1
		view 4327
	)
)

(instance myBackExitCode of Code
	(properties)

	(method (doit)
		(if (rRollTop curFrame:)
			(gCurRoom setScript: sOpenRollTop 0 1)
		else
			(gCurRoom changeScene: 351 3)
		)
	)
)

(instance myLeftExitCode of Code
	(properties)

	(method (doit)
		(if (rRollTop curFrame:)
			(gCurRoom setScript: sOpenRollTop 0 2)
		else
			(gCurRoom changeScene: 352 1)
		)
	)
)

(instance myRightExitCode of Code
	(properties)

	(method (doit)
		(if (rRollTop curFrame:)
			(gCurRoom setScript: sOpenRollTop 0 3)
		else
			(gCurRoom changeScene: 353 5)
		)
	)
)

(instance moveOutRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self createPoly: 337 27 337 284 433 284 433 27)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(self setPolygon: 0 createPoly: 337 27 337 284 433 284 433 27)
	)

	(method (doVerb theVerb)
		(SetFlag 62)
		(super doVerb: theVerb)
	)
)

(instance moveOutLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(self createPoly: 241 27 336 27 336 284 241 284)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(self setPolygon: 0 createPoly: 241 27 336 27 336 284 241 284)
	)

	(method (doVerb theVerb)
		(ClearFlag 62)
		(super doVerb: theVerb)
	)
)

(instance fStudyNotes of Feature
	(properties)

	(method (init)
		(self createPoly: 332 158 374 158 399 175 341 175)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 64)
				(gInventory addToNotebook: (ScriptID 9 27)) ; invStudyNotes
				(rRollTop init: 4364 18 204 95)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sndCombo of Sound ; UNUSED
	(properties
		number 192
	)
)

(instance spinSound of Sound
	(properties
		number 192
		flags 1
	)
)

(instance fPicture of Feature
	(properties
		x 467
		y 72
	)

	(method (init)
		(switch (gCurRoom scene:)
			(352
				(self createPoly: 441 27 500 0 500 144 435 139)
			)
			(353
				(self createPoly: 171 7 243 7 243 151 171 151)
			)
			(354
				(self createPoly: 275 0 339 0 337 30 328 31 323 39 275 39)
			)
		)
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
		(switch (gCurRoom scene:)
			(352
				(super init: 0 0 186 233)
				(self setBitmap: 6330 0 0)
			)
			(353
				(super init: 0 0 136 285)
				(self setBitmap: 6331 0 0)
			)
			(354
				(super init: 0 0 172 219)
				(self setBitmap: 6332 0 0)
			)
		)
	)
)

