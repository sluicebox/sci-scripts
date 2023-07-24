;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use LightRoom)
(use PanelPlane)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	local0
)

(instance rm330 of LightRoom
	(properties
		picture 333
	)

	(method (init)
		(Lock rsAUDIO 150 1)
		(Load rsAUDIO 152 153 154 155 158 159)
		(Load rsVIEW 335 339 338 3024 3018)
		(if (not (IsFlag 134))
			(Load rsVIEW 438)
		)
		(super init: &rest)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(gBackMusic2 fade: 40 5 10 0 0)
		)
		(if (not (OneOf gPrevRoomNum 320 340))
			(gIRandomMusic
				musicOne: 1301
				musicTwo: 1302
				musicThree: 1303
				play: 127 0
			)
		)
		(fireFX play: 48 0)
		(if (== gPrevRoomNum 340)
			(Load rsAUDIO 13201)
			(= local0 1)
		)
		(self changeScene: 333 5)
	)

	(method (changeScene param1)
		(fFridge dispose:)
		(fBookshelf dispose:)
		(fPicture dispose:)
		(moveOutRight dispose:)
		(moveOutLeft dispose:)
		(myMoveBack dispose:)
		(myMoveForward dispose:)
		(vKitchenNotes dispose:)
		(super changeScene: param1 &rest)
		(fireFX setVol: 48)
		(switch param1
			(333
				(myMoveForward newPic: 334 5)
				(myMoveBack newPic: 337 2)
				(proc0_9 4315 134 111)
				(if local0
					(= local0 0)
					(gMySoundFX do: 13201)
				)
			)
			(334
				(fPicture init:)
				((ScriptID 1 2) newPic: 337 2) ; exitBack
				((ScriptID 1 4) newPic: 335 11) ; exitRight
				((ScriptID 1 3) newPic: 336 6) ; exitLeft
				(fireFX setVol: 127)
				(proc0_9 4317 0 0)
			)
			(335
				(fFridge init:)
				(if (not (IsFlag 66))
					(vKitchenNotes init:)
				)
				((ScriptID 1 2) newPic: 336 6) ; exitBack
				((ScriptID 1 4) newPic: 337 2) ; exitRight
				((ScriptID 1 3) newPic: 334 5) ; exitLeft
			)
			(336
				(fPicture init:)
				(fBookshelf init:)
				((ScriptID 1 2) newPic: 335 11) ; exitBack
				((ScriptID 1 4) newPic: 334 5) ; exitRight
				((ScriptID 1 3) newPic: 337 2) ; exitLeft
			)
			(337
				(fPicture init:)
				((ScriptID 1 1) ; exitForward
					newRoom: 340
					createPoly: 273 84 304 81 304 211 273 207
					exitCode: bedroomExitCode
				)
				(moveOutRight newRoom: 320)
				(moveOutLeft newRoom: 320)
				((ScriptID 1 2) newPic: 334 5) ; exitBack
				((ScriptID 1 4) newPic: 336 6) ; exitRight
				((ScriptID 1 3) newPic: 335 11) ; exitLeft
			)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(gBackMusic2 fade: 70 5 10 0 0)
		)
		(Lock rsAUDIO 150 0)
		(if (not (OneOf gNewRoomNum 320 340))
			(gIRandomMusic stop:)
		)
		(super dispose: &rest)
	)
)

(instance vKitchenNotes of View
	(properties
		x 104
		y 182
		view 335
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(SetFlag 66)
				(gInventory addToNotebook: (ScriptID 9 29)) ; invKitchenNotes
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fFridge of Feature
	(properties)

	(method (init)
		(self
			createPoly: 120 33 120 158 232 164 232 151 260 141 260 36 220 22 187 19 151 20
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(pplFridge init:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fBookshelf of Feature
	(properties)

	(method (init)
		(self createPoly: 273 102 362 105 363 143 273 148)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb)
		(pplBookshelf init:)
	)
)

(instance pplFridge of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppFridgeDoor cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 155)
			(ppFridgeDoor setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(ppFridgeDoor loop: (if (IsFlag 17) 1 else 0) init: self 1 1)
	)

	(method (cue)
		(fridgeFan stop:)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance pplBookshelf of InsetPanelPlane
	(properties)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(& (event type:) evMOUSEBUTTON)
				(not (self onMe: event))
				(not ((ScriptID 9 1) onMe: event)) ; PlInterface
				(ppBookShelfDoor cel:)
			)
			(event claimed: 1)
			(gGame handsOff:)
			(gMySoundFX do: 159)
			(ppBookShelfDoor setCycle: Beg self)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 134)
			(self setBitmap: 438 0 0)
		else
			(self setBitmap: 338 0 0)
		)
		(global105 delete: (bitmap approachX:))
		(ppBookShelfDoor init: self 1 1)
		(pfBookShelfDoor init: self 1 1)
	)

	(method (cue)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance ppFridgeDoor of PanelProp
	(properties
		cycleSpeed 4
		view 339
	)

	(method (dispose)
		(fridgeFan stop:)
		(super dispose: &rest)
	)

	(method (init)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if cel
					(super doVerb: theVerb &rest)
				else
					(gGame handsOff:)
					(if (not (IsFlag 17))
						(pfBottle init: pplFridge 1 1)
					)
					(gMySoundFX do: 152)
					(self setCycle: End self)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(if cel
			(fridgeFan play:)
		)
		(gGame handsOn:)
	)
)

(instance ppBookShelfDoor of PanelProp
	(properties)

	(method (init)
		(= view (if (IsFlag 134) 438 else 338))
		(= cel 0)
		(= x (= loop 1))
		(= y 37)
		(super init: &rest)
		(approachX hotVerbs: 0)
	)

	(method (cue)
		(gGame handsOn:)
	)
)

(instance pfBottle of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 59 171 90 171 90 104 76 89 67 89 58 105)
		(super init: &rest)
	)

	(method (doVerb)
		(gMySoundFX do: 154)
		(ppFridgeDoor setLoop: 1)
		(SetFlag 17)
		(gInventory addItem: (ScriptID 9 10)) ; invBabyBottle
		(self dispose:)
	)
)

(instance pfBookShelfDoor of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 199 37 199 170 26 182 6 37)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(if (ppBookShelfDoor cel:)
					(if (not (IsFlag 134))
						(pfCompass dispose:)
					)
					(self createPoly: 199 37 199 170 26 182 6 37)
					(gMySoundFX do: 159)
					(ppBookShelfDoor setCycle: Beg ppBookShelfDoor)
				else
					(if (not (IsFlag 134))
						(pfCompass init: pplBookshelf 1 1)
					)
					(self createPoly: 199 31 199 53 0 54 0 32)
					(gMySoundFX do: 158)
					(ppBookShelfDoor setCycle: End ppBookShelfDoor)
				)
			)
		)
	)
)

(instance pfCompass of PanelFeature
	(properties)

	(method (init)
		(self createPoly: 86 146 102 144 118 146 118 159 111 166 95 167 86 158)
		(super init: &rest)
		(approachX hotVerbs: 5)
	)

	(method (doVerb)
		(gMySoundFX do: 4001)
		(pplBookshelf setBitmap: 438 0 0)
		(ppBookShelfDoor view: 438)
		(SetFlag 134)
		(if
			(and
				(not (IsFlag 162))
				(not (gTimers contains: gTGlobalTimer))
				(not (IsFlag 266))
			)
			(gTGlobalTimer setReal: gTGlobalTimer 30)
		)
		(gInventory addItem: (ScriptID 9 13)) ; invCompass
		(self dispose:)
	)
)

(instance fireFX of Sound
	(properties
		number 150
		loop -1
	)
)

(instance fridgeFan of Sound
	(properties
		number 153
		loop -1
	)
)

(instance moveOutRight of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 0)
		(self createPoly: 253 37 315 26 315 260 253 253)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 0)
		(self createPoly: 253 37 315 26 315 260 253 253)
	)

	(method (doVerb theVerb)
		(SetFlag 71)
		(super doVerb: theVerb)
	)
)

(instance moveOutLeft of ExitFeature
	(properties)

	(method (init)
		(= arrowStyle 1)
		(self createPoly: 194 47 253 37 253 253 194 243)
		(super init: &rest)
	)

	(method (resetProps)
		(super resetProps: &rest)
		(if onMeCheck
			(onMeCheck dispose:)
			(= onMeCheck 0)
		)
		(= arrowStyle 1)
		(self createPoly: 194 47 253 37 253 253 194 243)
	)

	(method (doVerb theVerb)
		(ClearFlag 71)
		(super doVerb: theVerb)
	)
)

(instance fPicture of Feature
	(properties)

	(method (init)
		(switch (gCurRoom scene:)
			(336
				(self createPoly: 41 52 152 60 156 123 37 128 35 69 52 63)
			)
			(337
				(self createPoly: 111 120 144 123 144 152 111 151)
			)
			(334
				(self createPoly: 330 43 363 41 361 79 329 78)
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
			(336
				(super init: 0 0 294 180)
				(self setBitmap: 6306 0 0)
			)
			(337
				(super init: 0 0 294 161)
				(self setBitmap: 6308 0 0)
			)
			(334
				(super init: 0 0 128 160)
				(self setBitmap: 334 0 0)
			)
		)
	)
)

(instance bedroomExitCode of Code
	(properties)

	(method (doit)
		(gGame handsOff:)
		(gMySoundFX do: 132)
		(if (or (IsFlag 290) (IsFlag 413) (IsFlag 292) (IsFlag 267))
			(gBackMusic2 fade: 80 5 10 0 0)
		)
		(pBedroomDoor init: setCycle: End self)
	)

	(method (cue)
		(gCurRoom newRoom: 340)
	)
)

(instance pBedroomDoor of Prop
	(properties
		x 273
		y 209
		view 6309
	)
)

(instance myMoveBack of ExitFeature
	(properties
		nsBottom 300
		nsLeft 100
		nsRight 400
		nsTop 221
		arrowStyle 4
	)
)

(instance myMoveForward of ExitFeature
	(properties
		nsBottom 220
		nsLeft 100
		nsRight 400
		nsTop 60
	)
)

