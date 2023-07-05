;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2142)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use PolyEdit)
(use System)

(public
	livingRoomCH2SR4 0
)

(local
	[local0 8] = [453 68 534 245 96 260 137 278]
)

(instance livingRoomCH2SR4 of CloseupRoom
	(properties
		picture 91
		style 0
	)

	(method (init)
		(gEgo put: 12) ; lockerI
		(cond
			((and (not (IsFlag 254)) (not (IsFlag 255)))
				(footlocker x: 20 y: 246 loop: 4)
				(footlocker init:)
				(laceFeat init:)
				(folderFeat init:)
			)
			((and (IsFlag 254) (not (IsFlag 255)))
				(footlocker x: 8 y: 253 loop: 1)
				(footlocker init:)
				(laceOnlyFeat init:)
			)
			((and (IsFlag 255) (not (IsFlag 254)))
				(footlocker x: 21 y: 242 loop: 2)
				(footlocker init:)
				(folderOnlyFeat init:)
			)
			(else
				(lockedPanel init:)
			)
		)
		((ScriptID 63000 3) exitScene: 2144) ; wExit
		((ScriptID 63000 2) exitScene: 2144) ; eExit
		((ScriptID 63000 1) exitScene: 2144) ; sExit
		((ScriptID 63000 0) exitScene: 2144) ; nExit
		(if (or (< gPrevRoomNum 2100) (> gPrevRoomNum 2199))
			(= exitRoom 2122)
		else
			(= exitRoom gPrevRoomNum)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(gEgo get: 12) ; lockerI
		(super dispose: &rest)
	)
)

(instance footlocker of View
	(properties
		view 91
	)
)

(instance folderFeat of P2Feature
	(properties
		scene 1802
		sceneScored 1
		doneFlag 254
		invItem 15
	)

	(method (init)
		(= whoDoit itemCode)
		(super
			init:
				(proc63002_10
					69
					73
					229
					55
					371
					60
					386
					76
					388
					216
					145
					227
					145
					227
					40
					223
					46
					134
					57
					87
				)
		)
	)
)

(instance folderOnlyFeat of P2Feature
	(properties
		scene 1802
		sceneScored 1
		doneFlag 254
		invItem 15
	)

	(method (init)
		(= whoDoit itemCode)
		(super
			init:
				(proc63002_10
					44
					220
					57
					79
					68
					67
					174
					69
					241
					62
					376
					72
					387
					86
					393
					220
					187
					225
				)
		)
	)
)

(instance laceFeat of P2Feature
	(properties
		scene 3240
		sceneScored 1
		doneFlag 255
		invItem 22
	)

	(method (init)
		(= whoDoit itemCode)
		(super
			init:
				(proc63002_10
					393
					227
					391
					78
					475
					71
					527
					74
					559
					68
					563
					82
					576
					86
					583
					222
				)
		)
	)
)

(instance laceOnlyFeat of P2Feature
	(properties
		scene 3240
		sceneScored 1
		doneFlag 255
		invItem 22
	)

	(method (init)
		(= whoDoit itemCode)
		(super init: (proc63002_10 128 224 100 134 118 86 572 72 578 226))
	)
)

(instance itemCode of Code
	(properties)

	(method (doit)
		(cond
			((and (IsFlag 254) (not (IsFlag 255)))
				(footlocker x: 8 y: 253)
				(footlocker setLoop: 1)
				(laceFeat dispose:)
				(laceOnlyFeat init:)
			)
			((and (IsFlag 255) (not (IsFlag 254)))
				(footlocker x: 21 y: 242)
				(footlocker setLoop: 2)
				(folderFeat dispose:)
				(folderOnlyFeat init:)
			)
			(else
				(footlocker dispose:)
				(lockedPanel init:)
			)
		)
	)
)

(instance lockedPanel of P2View
	(properties
		x 10
		y 245
		view 91
		loop 3
	)

	(method (init)
		(= whoDoit panelCode)
		(super init: &rest)
		(if (IsFlag 257)
			(self delVerb: 4)
		)
		(if (not (IsFlag 256))
			(self addVerb: 15)
		)
	)
)

(instance panelCode of Code
	(properties)

	(method (doit)
		(switch gVerb
			(4 ; Do
				(lockedPanel delVerb: 4)
				(SetFlag 257)
				(proc63002_7 1810)
			)
			(15 ; screwdriverI
				(lockedPanel delVerb: 15)
				(SetFlag 256)
				(proc63002_7 1800)
			)
		)
	)
)

(instance exitLocker of ExitFeature ; UNUSED
	(properties
		exitDir 4
		exitScene 2144
	)

	(method (init)
		(= nextRoom gPrevRoomNum)
		(super init: 10 228 608 334)
	)
)

