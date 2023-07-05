;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40400)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use Motion)
(use Actor)

(public
	roSpittinSandCu 0
)

(instance poTorinLands of Prop
	(properties
		x 303
		y 248
		view 40400
	)
)

(instance poBoogleLands of Prop
	(properties
		x 303
		y 248
		view 40400
		loop 1
	)
)

(instance poTorinLiftsHead of Prop
	(properties
		x 303
		y 248
		view 40400
		loop 2
	)
)

(instance poBoogleLaughs of Prop
	(properties
		x 526
		y 283
		view 40400
		loop 3
	)
)

(instance poBoogleSquished of Prop
	(properties
		x 526
		y 283
		view 40400
		loop 4
	)
)

(instance voBoogleSquished of Prop
	(properties
		x 526
		y 283
		view 40400
		loop 8
	)
)

(instance poTorinSavesBoogle of Prop
	(properties
		x 526
		y 283
		view 40400
		loop 5
	)
)

(instance voBall of View
	(properties
		x 563
		y 276
		view 40400
		loop 9
	)
)

(instance oWhistle of TPSound
	(properties)
)

(instance soSpittinSand of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: ((ScriptID 64001 0) get: 38)) ; oInvHandler, ioCannonball1
				(gEgo put: ((ScriptID 64001 0) get: 39)) ; oInvHandler, ioCannonball2
				(gEgo put: ((ScriptID 64001 0) get: 40)) ; oInvHandler, ioCannonball3
				(gEgo put: ((ScriptID 64001 0) get: 41)) ; oInvHandler, ioCannonball4
				(gEgo put: ((ScriptID 64001 0) get: 42)) ; oInvHandler, ioCannonball5
				(gEgo put: ((ScriptID 64001 0) get: 43)) ; oInvHandler, ioCannonball6
				(= ticks 1)
				((ScriptID 64017 0) set: 143) ; oFlags
				(poTorinLands init:)
			)
			(1
				(= ticks 180)
				(goSound1 preload: 40402 40404 40405 10112 40406 40403)
			)
			(2
				(poTorinLands setCycle: CT 4 1 self)
			)
			(3
				(= ticks 30)
			)
			(4
				(poTorinLands setCycle: End self)
				(gMessager say: 0 0 1 1 self) ; "(SPITTING OUT SAND) Spyfh! Ick! Pooey!"
			)
			(5)
			(6
				(goSound1 playSound: 40408)
				(= ticks 180)
			)
			(7
				(poTorinLands dispose:)
				(poBoogleLands init: setCycle: CT 5 1 self)
			)
			(8
				(goSound1 playSound: 40402)
				(poBoogleLands setCycle: End self)
			)
			(9
				(poBoogleLands dispose:)
				(poTorinLiftsHead init: setCycle: CT 21 1)
				(poBoogleLaughs init: setCycle: CT 7 1 self)
				(goSound1 playSound: 10112)
			)
			(10
				(goSound1 setAmbient: 40405)
				(poBoogleLaughs setCycle: CT 15 1 self)
			)
			(11
				(= ticks (poBoogleLaughs cycleSpeed:))
			)
			(12
				(poBoogleLaughs setCel: 13 setCycle: CT 15 1 self)
			)
			(13
				(= ticks (poBoogleLaughs cycleSpeed:))
			)
			(14
				(poBoogleLaughs setCel: 13 setCycle: CT 15 1 self)
			)
			(15
				(= ticks (poBoogleLaughs cycleSpeed:))
			)
			(16
				(poBoogleLaughs setCel: 13 setCycle: CT 15 1 self)
			)
			(17
				(oWhistle playSound: 40408)
				(= ticks (poBoogleLaughs cycleSpeed:))
			)
			(18
				(poBoogleLaughs setCel: 13 setCycle: CT 15 1 self)
			)
			(19
				(= ticks (poBoogleLaughs cycleSpeed:))
			)
			(20
				(poBoogleLaughs setCel: 13 setCycle: CT 15 1 self)
			)
			(21
				(= ticks (poBoogleLaughs cycleSpeed:))
			)
			(22
				(poBoogleLaughs setCel: 13 setCycle: End self)
			)
			(23
				(= ticks (* 2 (poBoogleLaughs cycleSpeed:)))
			)
			(24
				(poBoogleLaughs dispose:)
				(poBoogleSquished init: setCycle: CT 1 1 self)
				(oWhistle playSound: 40403)
			)
			(25
				(poBoogleSquished setCycle: CT 4 1 self)
			)
			(26
				(poBoogleSquished setCycle: End self)
				(goSound1 stop:)
			)
			(27
				(= ticks (poBoogleSquished cycleSpeed:))
			)
			(28
				(poBoogleSquished dispose:)
				(voBoogleSquished init:)
				(poTorinLiftsHead setCycle: CT 21 1 self)
			)
			(29
				(= ticks 30)
			)
			(30
				(poTorinLiftsHead setCycle: CT 28 1 self)
			)
			(31
				(goSound1 playSound: 40404)
				(poTorinLiftsHead setCycle: End self)
			)
			(32
				(poTorinLiftsHead dispose:)
				(poTorinSavesBoogle init: setCycle: CT 11 1 self)
				(goSound1 playSound: 40406)
			)
			(33
				(= ticks (poTorinSavesBoogle cycleSpeed:))
			)
			(34
				(voBoogleSquished dispose:)
				(poTorinSavesBoogle setCel: 12)
				(= ticks 20)
			)
			(35
				(poTorinSavesBoogle setCycle: CT 16 1 self)
			)
			(36
				(= ticks (poTorinSavesBoogle cycleSpeed:))
				(voBall init:)
			)
			(37
				(poTorinSavesBoogle setCycle: End self)
			)
			(38
				(gCurRoom newRoom: 40300) ; roSpitsOfLand
			)
		)
	)
)

(instance roSpittinSandCu of TPRoom
	(properties
		picture 40400
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 40200)
		(gGame handsOff:)
		(gCurRoom setScript: soSpittinSand)
	)

	(method (gimme))
)

