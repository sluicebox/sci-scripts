;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Actor)
(use System)

(public
	vgHouseRm 0
)

(instance vgHouseRm of ExitRoom ; "Von Glower's House"
	(properties
		noun 3
		picture 3301
	)

	(method (init)
		(super init: &rest)
		(gEgo
			setScale: 0
			view: 22392
			setLoop: 0 1
			posn: 370 173
			cel: 0
			setPri: 400 1
			init:
			signal: 30753
			setScript: FidgetScript
		)
		(pVonGlower init: setPri: 250 setScript: (FidgetScript new:))
		(gUser canControl: 0)
		(fArch init:)
		(fMask init:)
		(cond
			((== gPrevRoomNum 3302)
				(gGame handsOn:)
			)
			((== gPrevRoomNum 3340)
				(PlayScene 397)
			)
			((not (IsFlag 510))
				(SetFlag 510)
				(self setScript: enterScript 0 391)
			)
			(else
				(gSoundManager sel_702: 1)
				(self setScript: enterScript 0 392)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 200) ; MunichMapRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PlayScene register self)
			)
			(1
				(gSoundManager play: 0 330 331)
				(self dispose:)
			)
		)
	)
)

(instance pVonGlower of Prop
	(properties
		sightAngle 360
		x 109
		y 184
		view 21392
		signal 30753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (proc11_15 3302)
					(gCurRoom newRoom: 3302)
				else
					(gMessager say: 5 62) ; "(TRY TO TALK TO VON GLOWER -- DIALOGUE DONE)I'm not sure what else to say."
				)
			)
			(else
				(gMessager say: 7 62) ; "(PICKUP, TRY TO SHOW INVENTORY TO VON GLOWER AT HIS HOUSE)I don't think the Baron would be interested in my stuff."
			)
		)
	)
)

(instance fArch of ExitFeature
	(properties
		sightAngle 360
		x 240
		y 48
		BAD_SELECTOR 1
	)

	(method (init)
		(self
			createPoly: 227 231 233 63 245 47 265 35 284 30 313 35 324 42 323 236
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame handsOff:)
				(if (IsFlag 50)
					(gSoundManager sel_702: 1)
					(PlayScene 394 0 200) ; MunichMapRm
				else
					(gSoundManager sel_702: 1)
					(PlayScene 393 0 200) ; MunichMapRm
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fWine of Feature ; UNUSED
	(properties)

	(method (init)
		(self createPoly: 294 239 316 239 316 274 294 277)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 395)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMask of Feature
	(properties)

	(method (init)
		(self
			createPoly: 522 4 516 33 521 37 523 49 535 60 530 82 558 80 559 66 575 48 582 31 576 12 561 0 529 0
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame handsOff:)
				(PlayScene 396 0 3340) ; rm3340
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

