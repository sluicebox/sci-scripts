;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use n951)
(use soundRoom)
(use DText)
(use Str)
(use Print)
(use Actor)
(use System)

(public
	shiversOptions 0
)

(local
	local0
	local1
)

(instance optionsSound of ShiversSound
	(properties)
)

(instance shiversOptions of ShiversRoom
	(properties
		picture 990
	)

	(method (init &tmp [temp0 2])
		(if gPBoatView
			(gPBoatView hide:)
			((gPBoatView crankObj:) hide:)
		)
		(ClearFlag 43)
		(vShivers init:)
		(vScore init:)
		(vVolume init:)
		(vBrightness init:)
		(spPlay init:)
		(if (== global186 0)
			(spSave init:)
			(spRestore init:)
		)
		(spFlashback init:)
		(spFullScreen init:)
		(spText init:)
		(spExit init:)
		(vVolumeRange init:)
		(spVolume init:)
		(vBrightRange init:)
		(spBright init:)
		(userScore init:)
		(if (or (>= gPrevRoomNum 1000) (< gPrevRoomNum 0)) ; rm1v00
			(= global343 gPrevRoomNum)
		)
		(gSound1 pause: 1)
		(gSound2 pause: 1)
		(gSound3 pause: 1)
		(gSound4 pause: 1)
		(gSound5 pause: 1)
		(gSound6 pause: 1)
		(super init: &rest)
	)

	(method (dispose)
		(spVolume dispose:)
		(spBright dispose:)
		(super dispose: &rest)
	)
)

(instance vShivers of View
	(properties
		x 20
		y 20
		view 990
		loop 7
	)
)

(instance vScore of View
	(properties
		x 30
		y 65
		view 990
		loop 8
	)
)

(instance spPlay of ShiversProp
	(properties
		x 161
		y 10
		view 990
		loop 5
	)

	(method (doVerb)
		(gCurRoom setScript: sPlay)
	)
)

(instance spSave of ShiversProp
	(properties
		x 161
		y 30
		view 990
		loop 6
	)

	(method (doVerb)
		(gCurRoom setScript: sSave)
	)
)

(instance spRestore of ShiversProp
	(properties
		x 161
		y 50
		view 990
		loop 11
	)

	(method (doVerb)
		(gCurRoom setScript: sRestore)
	)
)

(instance spFlashback of ShiversProp
	(properties
		x 161
		y 70
		view 990
		loop 2
	)

	(method (doVerb)
		(gCurRoom setScript: sFlashback)
	)
)

(instance spFullScreen of ShiversProp
	(properties
		x 161
		y 90
		view 990
		loop 3
	)

	(method (init)
		(if (IsFlag 38)
			(self cel: 0)
		else
			(self cel: 2)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sFullScreen)
	)
)

(instance spText of ShiversProp
	(properties
		x 161
		y 110
		view 990
		loop 1
	)

	(method (init)
		(if (IsFlag 39)
			(self cel: 0)
		else
			(self cel: 2)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sText)
	)
)

(instance spExit of ShiversProp
	(properties
		x 161
		y 130
		view 990
		loop 4
	)

	(method (doVerb)
		(gCurRoom setScript: sExit)
	)
)

(instance vVolume of View
	(properties
		x 30
		y 83
		view 990
		loop 9
	)
)

(instance vVolumeRange of View
	(properties
		x 30
		y 85
		view 990
		cel 1
	)
)

(instance spVolume of ShiversProp
	(properties
		x 110
		y 83
		priority 255
		fixPriority 1
		view 990
	)

	(method (init &tmp temp0)
		(= local0 0)
		(= temp0 (DoAudio audVOLUME))
		(self x: (+ (/ (* 78 temp0) 127) 32))
		(super init: &rest)
		(gTheDoits delete: self)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self doVerb: 1)
		)
		(if (and (& (event type:) evMOUSERELEASE) (== local0 1) (gUser canControl:))
			(event claimed: 1)
			(self doVerb: 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doit)
		(if (and (== local0 1) (> (- gMouseX 27) 32) (< (- gMouseX 27) 110))
			(self x: (- gMouseX 27) show:)
			(UpdateScreenItem self)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 1)
			(gTheDoits add: self)
			(= local0 1)
		else
			(gTheDoits delete: self)
			(= local0 0)
			(= temp0 (/ (* 127 (- (self x:) 32)) 78))
			(PrintDebug {new volume = %d} temp0)
			(DoAudio audVOLUME temp0)
			(optionsSound number: 15023 play: 90 self)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance vBrightness of View
	(properties
		x 30
		y 115
		view 990
		loop 10
	)
)

(instance vBrightRange of View
	(properties
		x 30
		y 117
		view 990
		cel 1
	)
)

(instance spBright of ShiversProp
	(properties
		x 110
		y 115
		priority 255
		fixPriority 1
		view 990
	)

	(method (init &tmp temp0)
		(= local1 0)
		(switch global549
			(0
				(self x: 32)
			)
			(1
				(self x: 52)
			)
			(2
				(self x: 71)
			)
			(3
				(self x: 90)
			)
			(4
				(self x: 110)
			)
		)
		(super init: &rest)
		(gTheDoits delete: self)
	)

	(method (handleEvent event)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
			)
			(event claimed: 1)
			(self doVerb: 1)
		)
		(if (and (& (event type:) evMOUSERELEASE) (== local1 1) (gUser canControl:))
			(event claimed: 1)
			(self doVerb: 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doit)
		(if (and (== local1 1) (> (- gMouseX 27) 32) (< (- gMouseX 27) 110))
			(cond
				((< (- gMouseX 27) 42)
					(self x: 32 show:)
					(= global549 0)
				)
				((< 41 (- gMouseX 27) 61)
					(self x: 52 show:)
					(= global549 1)
				)
				((< 60 (- gMouseX 27) 81)
					(self x: 71 show:)
					(= global549 2)
				)
				((< 80 (- gMouseX 27) 100)
					(self x: 90 show:)
					(= global549 3)
				)
				((< 99 (- gMouseX 27))
					(self x: 110 show:)
					(= global549 4)
				)
			)
			(UpdateScreenItem self)
			(Palette 4 global549) ; PalSetGamma
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 1)
			(gTheDoits add: self)
			(= local1 1)
		else
			(gTheDoits delete: self)
			(= local1 0)
			(optionsSound number: 15024 play: 90 self)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance userScore of DText
	(properties
		x 70
		y 58
		priority 255
		fixPriority 1
		fore 181
		font 2510
	)

	(method (init &tmp temp0)
		(if global349
			(= temp0 (Str format: {%3d%.3d} global349 gScore))
		else
			(= temp0 (Str format: {%-6d} gScore))
		)
		(self text: (temp0 data:) setSize: 250)
		(super init: &rest)
	)
)

(instance sPlay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spPlay cel: 1)
				(optionsSound number: 15018 play: 90 self)
			)
			(1
				(gSound1 pause: 0)
				(gSound2 pause: 0)
				(gSound3 pause: 0)
				(gSound4 pause: 0)
				(gSound5 pause: 0)
				(gSound6 pause: 0)
				(spPlay cel: 0)
				(if (IsFlag 45)
					(if
						(and
							(!= (gSound1 number:) 0)
							(== (gSound1 client:) 0)
							(== (gSound1 handle:) 0)
						)
						(gSound1 play: (gSound1 vol:) 0)
					)
					(if
						(and
							(!= (gSound2 number:) 0)
							(== (gSound2 client:) 0)
							(== (gSound2 handle:) 0)
						)
						(gSound2 play: (gSound2 vol:) 0)
					)
					(if
						(and
							(!= (gSound3 number:) 0)
							(== (gSound3 client:) 0)
							(== (gSound3 handle:) 0)
						)
						(gSound3 play: (gSound3 vol:) 0)
					)
					(if
						(and
							(!= (gSound4 number:) 0)
							(== (gSound4 client:) 0)
							(== (gSound4 handle:) 0)
						)
						(gSound4 play: (gSound4 vol:) 0)
					)
					(if
						(and
							(!= (gSound5 number:) 0)
							(== (gSound5 client:) 0)
							(== (gSound5 handle:) 0)
						)
						(gSound1 play: (gSound5 vol:) 0)
					)
					(if
						(and
							(!= (gSound6 number:) 0)
							(== (gSound6 client:) 0)
							(== (gSound6 handle:) 0)
						)
						(gSound1 play: (gSound6 vol:) 0)
					)
					(gGame handsOn:)
				)
				(gCurRoom newRoom: global343)
				(self dispose:)
			)
		)
	)
)

(instance sSave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spSave cel: 1)
				(optionsSound number: 15035 play: 82 self)
			)
			(1
				(gGame handsOn:)
				(spSave cel: 0)
				(gCurRoom newRoom: 993) ; saveGame
				(self dispose:)
			)
		)
	)
)

(instance sRestore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spRestore cel: 1)
				(optionsSound number: 15034 play: 90 self)
			)
			(1
				(spRestore cel: 0)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 927) ; oldGame
				(self dispose:)
			)
		)
	)
)

(instance sFlashback of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spFlashback cel: 1)
				(optionsSound number: 15019 play: 90 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 991) ; shiversFlashback
				(self dispose:)
			)
		)
	)
)

(instance sFullScreen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 38)
					(spFullScreen cel: 1)
				else
					(spFullScreen cel: 3)
				)
				(optionsSound number: 15020 play: 90 self)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 38)
					(spFullScreen cel: 2)
					(ClearFlag 38)
				else
					(spFullScreen cel: 0)
					(SetFlag 38)
				)
				(self dispose:)
			)
		)
	)
)

(instance sText of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 39)
					(spText cel: 1)
				else
					(spText cel: 3)
				)
				(optionsSound number: 15021 play: 90 self)
			)
			(1
				(gGame handsOn:)
				(if (IsFlag 39)
					(spText cel: 2)
					(ClearFlag 39)
				else
					(spText cel: 0)
					(SetFlag 39)
				)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spExit cel: 1)
				(optionsSound number: 15022 play: 90 self)
			)
			(1
				(spExit cel: 0)
				(cleanUp doit:)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(if (== global186 1)
					((ScriptID 950 0) dispose:) ; vInterfaceView
					(gCurRoom newRoom: 910) ; shiversLogo
				else
					(gGame setCursor: gNormalCursor)
					(switch
						(Print
							addBitmap: 990 12 0
							addButtonBM: 990 13 0 0 {} 135 25
							addButtonBM: 990 4 0 1 {} 75 25
							init:
						)
						(0
							(gSound1 pause: 1)
							(gSound2 pause: 1)
							(gSound3 pause: 1)
							(gSound4 pause: 1)
							(gSound5 pause: 1)
							(gSound6 pause: 1)
							(return)
						)
						(1
							(gCurRoom newRoom: 910) ; shiversLogo
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance cleanUp of Code
	(properties)

	(method (doit)
		(if (== global186 1)
			(if gShiversInvItem
				(= global105 0)
				(gShiversInvItem dispose:)
				(= gShiversInvItem 0)
			)
			(if (ScriptID 950 3) ; vSandPotView
				((ScriptID 950 3) dispose:) ; vSandPotView
			)
			(if (ScriptID 950 4) ; vCrystalPotView
				((ScriptID 950 4) dispose:) ; vCrystalPotView
			)
			(if (ScriptID 950 5) ; vMetalPotView
				((ScriptID 950 5) dispose:) ; vMetalPotView
			)
			(if (ScriptID 950 6) ; vTarPotView
				((ScriptID 950 6) dispose:) ; vTarPotView
			)
			(if (ScriptID 950 7) ; vWoodPotView
				((ScriptID 950 7) dispose:) ; vWoodPotView
			)
			(if (ScriptID 950 8) ; vElectricPotView
				((ScriptID 950 8) dispose:) ; vElectricPotView
			)
			(if (ScriptID 950 9) ; vAshPotView
				((ScriptID 950 9) dispose:) ; vAshPotView
			)
			(if (ScriptID 950 10) ; vWaterPotView
				((ScriptID 950 10) dispose:) ; vWaterPotView
			)
			(if (ScriptID 950 11) ; vFabricPotView
				((ScriptID 950 11) dispose:) ; vFabricPotView
			)
			(if (ScriptID 950 12) ; vWaxPotView
				((ScriptID 950 12) dispose:) ; vWaxPotView
			)
		)
	)
)

