;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use GK2Ego)
(use n011)
(use PanelPlane)
(use System)

(public
	controlPlane 0
)

(local
	local0
)

(instance controlPlane of PanelPlane
	(properties
		picture -2
		priority 600
	)

	(method (init &tmp temp0)
		(if casts
			(return)
		)
		(= local0 ((ScriptID 0 4) active:)) ; inventoryButton
		(gGame disableInventory: 1)
		(if (!= gChapter 6)
			((ScriptID 0 5) mask:) ; recButton
		)
		((ScriptID 0 7) mask:) ; movieButton
		(= global135 0)
		((gUser hotCursor:) cage: 80 350 419 470)
		(super init: 99 361 419 470)
		(controlPanel init: self)
		(if local0
			(saveButton init: self 1 1)
		)
		(restoreButton init: self 1 1)
		(playButton init: self 1 1)
		(aboutButton init: self 1 1)
		(movieButton init: self 1 1)
		(quitButton init: self 1 1)
		(soundSlider init: self 1 1)
		(detailSlider init: self 1 1)
	)

	(method (dispose)
		(if (not (and (IsFlag 1099) (== gChapter 5)))
			(gGame disableInventory: (not local0))
		)
		(if (and (or (gEgo has: 6) (== gEgo GraceEgo)) (!= gChapter 6)) ; invTapeRecorder
			((ScriptID 0 5) mask: 0) ; recButton
		)
		(if (not (IsFlag 1167))
			((ScriptID 0 7) mask: 0) ; movieButton
		)
		(= global135 1)
		((gUser hotCursor:) cage:)
		(super dispose: &rest)
	)
)

(instance controlPanel of PanelView
	(properties
		view 140
	)
)

(instance saveButton of PanelButton
	(properties
		x 8
		y 8
		view 140
		loop 1
	)

	(method (doVerb)
		(controlPlane dispose:)
		(gGame panelObj: gGame)
		(gGame panelSelector: 82)
	)
)

(instance restoreButton of PanelButton
	(properties
		x 60
		y 8
		view 140
		loop 2
	)

	(method (doVerb)
		(controlPlane dispose:)
		(gGame restore:)
	)
)

(instance playButton of PanelButton
	(properties
		x 112
		y 8
		view 140
		loop 3
	)

	(method (doVerb)
		(controlPlane dispose:)
	)
)

(instance aboutButton of PanelButton
	(properties
		x 164
		y 8
		view 140
		loop 4
	)

	(method (doVerb)
		(controlPlane dispose:)
		((ScriptID 33 0) init:) ; aboutPlane
	)
)

(instance movieButton of PanelButton
	(properties
		x 216
		y 8
		view 140
		loop 5
	)

	(method (doVerb)
		(if (IsFlag 34)
			(ClearFlag 34)
			(= loop 5)
		else
			(SetFlag 34)
			(= loop 10)
		)
		(self show:)
	)
)

(instance quitButton of PanelButton
	(properties
		x 268
		y 8
		view 140
		loop 6
	)

	(method (doVerb)
		(gGame quitGame:)
	)
)

(class PanelSlider of PanelButton
	(properties
		maxVal 100
		maxOff 100
		baseOff 0
	)

	(method (init)
		(= x (self initialOff:))
		(super init: &rest)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= baseOff temp0 (+ maxOff 6)) (<= nsTop temp1 nsBottom)))
	)

	(method (waitMouseUp &tmp temp0 temp1 temp2)
		(while (!= evMOUSERELEASE ((= temp0 (Event new:)) type:))
			(temp0 localize: plane)
			(= temp1 (temp0 x:))
			(= temp2 (temp0 y:))
			(self slide: temp1 temp2)
			(self controlClient: (self newControlValue:))
			(temp0 dispose:)
		)
		(= temp1 (temp0 x:))
		(= temp2 (temp0 y:))
		(temp0 dispose:)
		(self onMe: temp1 temp2)
	)

	(method (slide param1)
		(= x (Max baseOff (Min param1 maxOff)))
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (newControlValue)
		(return (/ (* maxVal (- x baseOff)) (- maxOff baseOff)))
	)

	(method (controlClient))

	(method (initialVal))

	(method (initialOff)
		(Max
			baseOff
			(Min
				maxOff
				(+ (/ (* (self initialVal:) (- maxOff baseOff)) maxVal) baseOff)
			)
		)
	)
)

(instance soundSlider of PanelSlider
	(properties
		y 57
		view 140
		loop 9
		maxVal 127
		maxOff 272
		baseOff 100
	)

	(method (controlClient param1)
		(= gLastVolume param1)
		(gSounds eachElementDo: #setVol param1)
	)

	(method (initialVal)
		(return gLastVolume)
	)
)

(instance detailSlider of PanelSlider
	(properties
		y 83
		view 140
		loop 9
		maxVal 10
		maxOff 272
		baseOff 100
	)

	(method (controlClient param1)
		(gGame detailLevel: param1)
	)

	(method (initialVal)
		(gGame detailLevel:)
	)
)

