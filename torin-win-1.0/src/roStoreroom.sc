;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50100)
(include sci.sh)
(use Main)
(use oInterface)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use n64896)
(use Plane)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roStoreroom 0
)

(local
	oBoogPlane
	bOnBoxes
)

(instance foDuctExit of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:) type: PTotalAccess init: -1 42 58 49 50 6 0 1 yourself:)
		)
		(self addHotspotVerb: 1 51)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gCurRoom setScript: soTryVent)
			)
			(51 ; ioKnife
				(gCurRoom setScript: soLeaveRoom)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soClimbBoxes of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 262 272 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(gGame handsOff:)
				(gEgo hide:)
				(poTorinClimbs
					view: 50102
					loop: 0
					cel: 0
					posn: 260 273
					init:
					setCycle: CT 3 1 self
				)
			)
			(3
				(goSound1 playSound: 50110)
				(poTorinClimbs setCycle: CT 9 1 self)
			)
			(4
				(goSound1 playSound: 50110)
				(poTorinClimbs setCycle: End self)
			)
			(5
				(= bOnBoxes 1)
				(foFloor init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soComeDown of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poTorinClimbs
					view: 50102
					loop: 1
					cel: 0
					posn: 97 278
					init:
					setCycle: CT 3 1 self
				)
			)
			(1
				(goSound1 playSound: 20612)
				(poTorinClimbs setCycle: End self)
			)
			(2
				(= bOnBoxes 0)
				(foFloor dispose:)
				(poTorinClimbs dispose:)
				(gEgo posn: 97 269 normalize: 1 60100 2 show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLeaveRoom of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(((ScriptID 64001 0) get: 34) moveTo: -3) ; oInvHandler, ioKnife
				(goSound1 preload: 50110 50105)
				(if (not bOnBoxes)
					(self setScript: soClimbBoxes self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(poTorinClimbs
					view: 50104
					loop: 2
					cel: 0
					posn: 93 53
					setCycle: CT 9 1 self
				)
			)
			(2
				(poTorinClimbs cel: 10)
				(= ticks 10)
			)
			(3
				(goSound1 playSound: 50110)
				(poTorinClimbs cel: 9)
				(= ticks 10)
			)
			(4
				(poTorinClimbs cel: 10)
				(= ticks 10)
			)
			(5
				(poTorinClimbs cel: 9)
				(= ticks 60)
			)
			(6
				(poTorinClimbs cel: 10)
				(= ticks 10)
			)
			(7
				(goSound1 playSound: 50110)
				(poTorinClimbs cel: 9)
				(= ticks 10)
			)
			(8
				(poTorinClimbs cel: 10)
				(= ticks 10)
			)
			(9
				(poTorinClimbs cel: 9)
				(= ticks 10)
			)
			(10
				(poTorinClimbs cel: 10)
				(= ticks 10)
			)
			(11
				(poTorinClimbs cel: 9)
				(= ticks 10)
			)
			(12
				(poTorinClimbs cel: 10)
				(= ticks 10)
			)
			(13
				(poTorinClimbs cel: 9)
				(= ticks 60)
			)
			(14
				(goSound1 playSound: 50105)
				(poTorinClimbs cycleSpeed: 10 setCycle: End self)
			)
			(15
				((ScriptID 64017 0) set: 180) ; oFlags
				((ScriptID 64017 0) clear: 232) ; oFlags
				(gCurRoom newRoom: 50200) ; roAirDuct1
				(self dispose:)
			)
		)
	)
)

(instance soTryVent of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 50110)
				(if (not bOnBoxes)
					(self setScript: soClimbBoxes self)
				else
					(self cue:)
				)
			)
			(1
				(gGame handsOff:)
				(poTorinClimbs
					view: 50104
					loop: 1
					cel: 0
					posn: 91 55
					setCycle: CT 4 1 self
				)
			)
			(2
				(= ticks 10)
			)
			(3
				(goSound1 playSound: 50110)
				(poTorinClimbs cel: 5)
				(= ticks 45)
			)
			(4
				(poTorinClimbs cel: 4)
				(= ticks 60)
			)
			(5
				(poTorinClimbs cel: 5)
				(goSound1 playSound: 50110)
				(= ticks 90)
			)
			(6
				(poTorinClimbs setCycle: End self)
			)
			(7
				(poTorinClimbs view: 50104 loop: 0 cel: 0 posn: 91 55)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poTorinClimbs of Prop
	(properties)
)

(instance foBoxes of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 2 57 127 57 149 67 149 88 164 99 173 139 204 141 212 188 278 190 276 239 244 261 187 261 118 240 82 239 52 257 0 254
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(if bOnBoxes
					(gCurRoom setScript: soComeDown)
				else
					(gCurRoom setScript: soClimbBoxes)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foFloor of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PContainedAccess
					init: 179 270 124 266 4 259 4 309 206 309 271 311 628 312 611 287 423 294 394 249 290 243 245 270 216 271
					yourself:
				)
		)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gCurRoom setScript: soComeDown)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foPhenocryst of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			onMeCheck:
				((Polygon new:)
					type: PTotalAccess
					init: 574 70 556 128 568 184 610 230 631 240 630 17
					yourself:
				)
		)
		(self addHotspotVerb: 1 13)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: 2 1 0 0) ; "No. I'm not going back. I WILL find Lycentia!"
			)
			(13 ; ioEressdy
				(gMessager say: 2 1 0 0) ; "No. I'm not going back. I WILL find Lycentia!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poTorinEnters of Prop
	(properties
		view 50101
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 71)
		(|= signal $1000)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soBoogleWorries)
			)
			(71 ; ioBoogleRedCross
				(gCurRoom setScript: soReviveTorin)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voStraightPipe of View
	(properties
		x 476
		y 287
		view 50101
		loop 2
	)
)

(instance voBentPipe of View
	(properties
		x 477
		y 286
		view 50105
	)
)

(instance poBoogle of Prop
	(properties
		view 50101
	)
)

(instance soBoogleWorries of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poBoogle setScript: 0)
				(gMessager say: 3 1 0 0 self) ; "(WHAT CAN I DO? HOW CAN I HELP?) Bwark!"
			)
			(1
				(poBoogle setScript: soBoogleShowsConcern)
				(self dispose:)
			)
		)
	)
)

(instance oBoogleConcern of TPSound
	(properties)
)

(instance soBoogleShowsConcern of Script
	(properties)

	(method (changeState newState &tmp nMsg)
		(switch (= state newState)
			(0
				(= ticks (Random 260 500))
			)
			(1
				(for
					((= nMsg register))
					(== nMsg register)
					((= nMsg (Random 1 3)))
				)
				(= register nMsg)
				(oBoogleConcern playMessage: 3 71 0 register self)
			)
			(2
				(self changeState: 0)
			)
		)
	)

	(method (dispose)
		(oBoogleConcern stop:)
		(super dispose: &rest)
	)
)

(instance soReviveTorin of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1
					preload: 50112 50111 60019 50103 50113 50115 50107 50114
				)
				(((ScriptID 64001 0) get: 35) moveTo: -1) ; oInvHandler, ioAmmonia
				(((ScriptID 64001 0) get: 36) moveTo: -1) ; oInvHandler, ioOpenAmmonia
				(((ScriptID 64001 0) get: 36) moveTo: -3) ; oInvHandler, ioOpenAmmonia
				(((ScriptID 64001 1) get: 5) moveTo: -3) ; oBoogleHandler, ioBoogleRedCross
				(poBoogle setScript: 0)
				(poBoogle
					view: 50103
					loop: 0
					cel: 0
					posn: 426 316
					setCycle: CT 2 1 self
				)
			)
			(1
				(goSound1 playSound: 50111)
				(poBoogle setCycle: CT 3 1)
				(= ticks 60)
			)
			(2
				(poBoogle setCycle: CT 8 1 self)
			)
			(3
				(goSound1 playSound: 60019)
				(poBoogle setCycle: End self)
			)
			(4
				(= ticks 90)
			)
			(5
				(poBoogle loop: 1 cel: 0 posn: 366 306 setCycle: CT 6 1 self)
			)
			(6
				(poTorinEnters dispose:)
				(poBoogle setCycle: CT 20 1 self)
			)
			(7
				(poBoogle setCycle: CT 22 1 self)
				(goSound1 playSound: 50103)
			)
			(8
				(= ticks 90)
			)
			(9
				(poBoogle setCycle: CT 20 -1 self)
				(goSound1 playSound: 50103)
			)
			(10
				(poBoogle setCycle: End self)
				(goSound1 playSound: 50103)
			)
			(11
				(= ticks 120)
			)
			(12
				(poBoogle loop: 2 cel: 0 posn: 366 306 setCycle: CT 2 1 self)
			)
			(13
				(goSound1 playSound: 50112)
				(poBoogle cel: 2 setCycle: CT 6 1 self)
			)
			(14
				(goSound1 playSound: 50112)
				(poBoogle cel: 2 setCycle: CT 6 1 self)
			)
			(15
				(goSound1 playSound: 50112)
				(poBoogle cel: 2 setCycle: CT 6 1 self)
			)
			(16
				(goSound1 playSound: 50112)
				(poBoogle cel: 2 setCycle: CT 6 1 self)
			)
			(17
				(goSound1 playSound: 50112)
				(poBoogle cel: 2 setCycle: CT 6 1 self)
			)
			(18
				(goSound1 playSound: 50112)
				(poBoogle cel: 2 setCycle: End self)
			)
			(19
				(= ticks 90)
			)
			(20
				(poBoogle
					loop: 3
					cel: 0
					posn: 366 306
					setPri: 400
					setCycle: CT 4 1 self
				)
			)
			(21
				(= ticks 30)
			)
			(22
				(goSound1 playSound: 50113)
				(poBoogle setCycle: CT 6 1 self)
			)
			(23
				(= ticks 60)
			)
			(24
				(poTorinEnters view: 50103 loop: 7 cel: 0 posn: 423 308 init:)
				(poBoogle cel: 7)
				(= ticks 100)
			)
			(25
				(poBoogle setCycle: End self)
			)
			(26
				(= oBoogPlane (Plane new:))
				(oBoogPlane picture: -2 init: 4 4 600 460 setPri: 700)
				(poBoogle dispose:)
				(poBoogle
					loop: 4
					cel: 0
					posn: 366 306
					init: oBoogPlane
					setCycle: CT 1 1 self
				)
			)
			(27
				(= ticks 50)
			)
			(28
				(poBoogle setCycle: CT 37 1 self)
			)
			(29
				(= ticks 50)
			)
			(30
				(poBoogle setCycle: End self)
			)
			(31
				(goSound1 playSound: 50114)
				(ActivateGameInventory)
				(oBoogPlane setPri: 10)
				(oBoogPlane setPri: 700)
				(= ticks 60)
			)
			(32
				(poBoogle loop: 5 cel: 0 setCycle: CT 5 1 self)
				(goSound1 playSound: 50115)
			)
			(33
				(((ScriptID 64001 0) get: 35) moveTo: -1) ; oInvHandler, ioAmmonia
				(((ScriptID 64001 0) get: 36) moveTo: -1) ; oInvHandler, ioOpenAmmonia
				(poBoogle setCycle: End self)
			)
			(34
				(poBoogle dispose:)
				(oBoogPlane dispose:)
				(= oBoogPlane 0)
				(poBoogle
					view: 50103
					loop: 6
					cel: 0
					posn: 391 315
					setPri: 400
					init:
					setCycle: CT 13 1 self
				)
			)
			(35
				(= ticks 120)
			)
			(36
				(goSound1 playSound: 50107 self)
			)
			(37
				(= ticks 90)
			)
			(38
				(poTorinEnters
					view: 50103
					loop: 7
					cel: 0
					cycleSpeed: 9
					setCycle: End self
				)
				(poBoogle setCycle: End self)
			)
			(39)
			(40
				((ScriptID 64017 0) set: 179) ; oFlags
				((ScriptID 64018 0) setWander: 0 posn: 385 315 setLoop: 7 show:) ; oBoogle
				(poBoogle dispose:)
				(poTorinEnters dispose:)
				(foBoxes init:)
				(foPhenocryst init:)
				(foDuctExit init:)
				(gEgo
					posn: 422 310
					normalize: 1 60100 4
					setScaler: Scaler 100 84 313 262
					show:
				)
				(gEgo setHeading: 225 self)
				((ScriptID 64018 0) setHeading: 45 self) ; oBoogle
			)
			(41)
			(42
				(gMessager say: 3 71 0 5 self) ; "(GROGGY) Uh, thanks, Boog. Hey, how did you do that?"
			)
			(43
				(gMessager say: 4 1 12 3 self 20600) ; "(HEH, HEH, HEH) Bwark!"
			)
			(44
				(goMusic1 fadeOut:)
				(self setScript: (ScriptID 64018 1) self) ; soBoogleIntoPouch
			)
			(45
				(goMusic1 fadeIn: 50100)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (rewind)
		(goMusic1 stop:)
		(goMusic1 setMusic: 50199)
		((ScriptID 64017 0) unSet: 179) ; oFlags
		(ActivateBoogleInventory)
		(((ScriptID 64001 0) get: 35) moveTo: -1) ; oInvHandler, ioAmmonia
		(((ScriptID 64001 0) get: 36) moveTo: -3) ; oInvHandler, ioOpenAmmonia
		(poBoogle dispose:)
		(poTorinEnters dispose:)
		(if oBoogPlane
			(oBoogPlane dispose:)
			(= oBoogPlane 0)
		)
		(poBoogle view: 50101 loop: 1)
		(poBoogle cel: (poBoogle lastCel:) posn: 432 310 init:)
		(poTorinEnters view: 50101 loop: 0)
		(poTorinEnters cel: (poTorinEnters lastCel:) posn: 424 303 init:)
		(gEgo hide:)
		((ScriptID 64018 0) hide:) ; oBoogle
		(gCurRoom setScript: self)
	)

	(method (ff)
		(goMusic1 stop:)
		(goMusic1 setMusic: 50100)
		((ScriptID 64017 0) set: 179) ; oFlags
		(if oBoogPlane
			(oBoogPlane dispose:)
			(= oBoogPlane 0)
		)
		(((ScriptID 64001 0) get: 36) moveTo: -1) ; oInvHandler, ioOpenAmmonia
		(((ScriptID 64001 0) get: 35) moveTo: -1) ; oInvHandler, ioAmmonia
		(poBoogle dispose:)
		(poTorinEnters dispose:)
		(foBoxes init:)
		(foPhenocryst init:)
		(foDuctExit init:)
		(gEgo
			posn: 425 306
			setLoop: 4
			setScaler: Scaler 100 84 313 262
			show:
		)
		((ScriptID 64018 0) posn: 384 313 setLoop: 7 hide: setWander: 0) ; oBoogle
		((ScriptID 64017 0) set: 232) ; oFlags
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soEnterRoom of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 50106 50199)
				(voStraightPipe init:)
				(goMusic1 setMusic: 50199)
				(FadeToBlack 0 10 self)
			)
			(1
				(= ticks 120)
			)
			(2
				(Load rsVIEW 50101)
				(goSound1 playSound: 50106)
				(= ticks 50)
			)
			(3
				(poTorinEnters
					view: 50101
					loop: 0
					cel: 0
					posn: 425 282
					init:
					setCycle: CT 1 1 self
				)
			)
			(4
				(= ticks (poTorinEnters cycleSpeed:))
			)
			(5
				(poTorinEnters cel: 2 doit:)
				(voStraightPipe dispose:)
				(= ticks (poTorinEnters cycleSpeed:))
			)
			(6
				(poTorinEnters cel: 3 doit:)
				(= ticks (poTorinEnters cycleSpeed:))
			)
			(7
				(voBentPipe init:)
				(poTorinEnters cel: 4 doit:)
				(= ticks (poTorinEnters cycleSpeed:))
			)
			(8
				(poTorinEnters cel: 5 doit:)
				(= ticks (poTorinEnters cycleSpeed:))
			)
			(9
				(poTorinEnters cel: 6 posn: 424 292 doit:)
				(= ticks (poTorinEnters cycleSpeed:))
			)
			(10
				(poTorinEnters
					cel: 7
					posn: 424 303
					doit:
					setCycle: CT 10 1 self
				)
			)
			(11
				(poTorinEnters setCycle: End)
				(poBoogle
					view: 50101
					loop: 1
					cel: 0
					posn: 432 310
					init:
					setCycle: CT 6 1 self
				)
			)
			(12
				(= ticks 120)
			)
			(13
				(poBoogle setCycle: End self)
			)
			(14
				(poBoogle setScript: soBoogleShowsConcern)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance roStoreroom of TPRoom
	(properties
		picture 50100
	)

	(method (init)
		(Palette 1 50000) ; PalLoad
		(super init: &rest)
		(= gnChapter 5)
		(goMusic1 setMusic: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 179 270 124 266 4 259 4 309 206 309 271 311 628 312 611 287 423 294 394 249 290 243 245 270 216 271
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 67 295 68 276 144 278 145 296
					yourself:
				)
		)
		(gEgo init: normalize: hide:)
		(gGame handsOn:)
		(gCurRoom setScript: soEnterRoom)
		(switch gPrevRoomNum
			(else
				(gEgo posn: 600 300)
			)
		)
		((ScriptID 64018 0) posn: 600 300 init: normalize: setWander: 0 hide:) ; oBoogle
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 1) get: 5)) ; oBoogleHandler, ioBoogleRedCross
		(gEgo get: ((ScriptID 64001 0) get: 34)) ; oInvHandler, ioKnife
		(gEgo get: ((ScriptID 64001 0) get: 35)) ; oInvHandler, ioAmmonia
	)
)

