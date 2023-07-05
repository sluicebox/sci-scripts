;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16100)
(include sci.sh)
(use Main)
(use oBoogle)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use CueMe)
(use foEExit)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roCrystalCityMoat 0
	toZax 1
)

(local
	hideZaxTalker
)

(instance foExit of ExitFeature
	(properties
		approachX 115
		approachY 414
		x 114
		y 415
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) init: 78 293 323 302 301 329 50 326 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 8)) ; oSouthWestCursor
	)

	(method (doVerb)
		(gEgo approachThenFace: self self)
	)

	(method (cue)
		(gCurRoom newRoom: 16000) ; roCrystalCityLS
	)
)

(instance poMoatRipple of Prop
	(properties
		x 398
		y 272
		fixPriority 1
		view 16104
		cycleSpeed 12
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance poZax of Prop
	(properties
		x 488
		y 151
		priority 10
		fixPriority 1
		view 16101
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gMessager say: 4 1 3 0) ; "Somehow, I don't think throwing rocks at this guy is a good idea!"
			)
		)
	)
)

(instance toZax of Talker
	(properties
		x 488
		y 151
		view 16101
		loop 2
		priority 200
	)

	(method (init)
		(super init: &rest)
		(if hideZaxTalker
			(mouth hide:)
		)
	)
)

(instance soGuardOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= hideZaxTalker 1)
				(poZax init: setCel: 0 setLoop: 0 setCycle: CT 6 1 self)
			)
			(1
				(= hideZaxTalker 0)
				(if (toZax mouth:)
					((toZax mouth:) show:)
				)
				(poZax setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soGuardInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= hideZaxTalker 1)
				(if (toZax mouth:)
					((toZax mouth:) hide:)
				)
				(poZax setCel: 0 setLoop: 5 setCycle: End self)
			)
			(1
				(poZax dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soTossRock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(poTorin
					view: 16103
					loop: 0
					cel: 0
					setPri: (gEgo priority:)
					posn: (gEgo x:) (gEgo y:)
					init:
					setCycle: End self
				)
			)
			(1
				(goSound1 playSound: 16106 self)
				(poTorin dispose:)
				(gEgo show:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soGuardTalk1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 1 2 1 self) ; "Maybe this will get someone's attention."
				(self setScript: soTossRock self)
			)
			(1)
			(2
				(= ticks 100)
			)
			(3
				(self setScript: soGuardOutside self)
				(gMessager say: 3 1 2 2 self) ; "Halt! Who goes there?"
			)
			(4)
			(5
				(gMessager sayRange: 3 1 2 3 4 self) ; "Torin, of the Fahrman Valley."
			)
			(6
				(gMessager say: 3 1 2 5 self) ; "Yes, I see. But I thought perhaps I would (FADE AWAY) be able to convince you to..."
			)
			(7
				(self setScript: soGuardInside self)
				(= ticks 30)
			)
			(8
				(gMessager say: 3 1 2 6 self) ; "(QUIETLY) ...I guess not."
			)
			(9)
			(10
				(self dispose:)
			)
		)
	)
)

(instance soTorinDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: setMotion: MoveTo 253 285 self)
			)
			(1
				(gEgo setLoop: -1 setMotion: PolyPath 285 274 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance toNull of Talker
	(properties
		view 16101
		loop 2
		priority -1
	)

	(method (init)
		(super init: &rest)
		(mouth hide:)
	)
)

(instance soGuardTalk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gtTorin toNull)
				(gMessager say: 3 1 4 1 self) ; "Hallo!"
				(self setScript: soTossRock self)
			)
			(1)
			(2
				(= ticks 100)
			)
			(3
				(= gtTorin 0)
				(self setScript: soGuardOutside self)
				(gMessager sayRange: 3 1 4 2 3 self) ; "Halt! (PAUSE A BEAT) Oh. You ARE halted."
			)
			(4)
			(5
				(gMessager sayRange: 3 1 4 4 7 self) ; "Well, uh, would you mind moving a little?"
			)
			(6
				(self setScript: soTorinDance self)
			)
			(7
				(self setScript: soGuardInside self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance soGuardTalk3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soTossRock self)
			)
			(1
				(= ticks 100)
			)
			(2
				(self setScript: soGuardOutside self)
				(gMessager sayRange: 3 1 5 1 9 self) ; "Halt. Who goes there?"
			)
			(3)
			(4
				(gMessager say: 3 1 5 10 self) ; "But couldn't you..."
			)
			(5
				(self setScript: soGuardInside self)
				(= ticks 30)
			)
			(6
				(gMessager say: 3 1 5 11 self) ; "(QUIETLY)...I guess not."
			)
			(7)
			(8
				(self dispose:)
			)
		)
	)
)

(instance soGuardTalk4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soTossRock self)
			)
			(1
				(= ticks 100)
			)
			(2
				(self setScript: soGuardOutside self)
				(gMessager sayRange: 3 1 6 1 3 self) ; "Halt!"
			)
			(3)
			(4
				(gMessager say: 3 1 6 4 self) ; "I can see that. I thought perhaps you could..."
			)
			(5
				(self setScript: soGuardInside self)
				(= ticks 30)
			)
			(6
				(gMessager say: 3 1 6 5 self) ; "Hello! I guess he can't."
			)
			(7)
			(8
				(self dispose:)
			)
		)
	)
)

(instance soGuardTalk5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soTossRock self)
			)
			(1
				(= ticks 100)
			)
			(2
				(self setScript: soGuardOutside self)
				(gMessager sayRange: 3 1 7 1 9 self) ; "Halt!"
			)
			(3)
			(4
				(self setScript: soGuardInside self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soGuardTalk6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 1 4 1 self) ; "Hallo!"
			)
			(1
				(gMessager say: 3 1 8 0 self) ; "I can not hear you. I'm asleep!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soGuardTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 285 274 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(switch gZaxTalk
					(0
						(self setScript: soGuardTalk1 self)
					)
					(1
						(self setScript: soGuardTalk2 self)
					)
					(2
						(self setScript: soGuardTalk3 self)
					)
					(3
						(self setScript: soGuardTalk4 self)
					)
					(4
						(self setScript: soGuardTalk5 self)
					)
					(else
						(= hideZaxTalker 1)
						(self setScript: soGuardTalk6 self)
					)
				)
				(if (< gZaxTalk 6)
					(++ gZaxTalk)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foGuard of Feature
	(properties
		noun 3
		sightAngle 40
		x 486
		y 105
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 472 129 473 86 502 88 502 129
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gCurRoom setScript: soGuardTalk)
			)
		)
	)
)

(instance oMunchSound of TPSound
	(properties)
)

(instance poTorin of Prop
	(properties)
)

(instance poCroc of Prop
	(properties)
)

(instance soCrocEatTorin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 45)
			)
			(1
				(poCroc
					view: 16101
					loop: 4
					cel: 0
					posn: 506 323
					init:
					setPri: 190
					setCycle: CT 6 1 self
				)
			)
			(2
				(oMunchSound playSound: 16101 self)
			)
			(3
				(poCroc setCycle: End self)
			)
			(4
				(poCroc dispose:)
				(self dispose:)
			)
		)
	)
)

(instance oDisposeTorinWhenCued of CueMe
	(properties)

	(method (cue)
		(poTorin dispose:)
	)
)

(instance oDisposeCrocWhenCued of CueMe ; UNUSED
	(properties)

	(method (cue)
		(poCroc dispose:)
	)
)

(instance soTorinJumpInMoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 16103 16102 16101)
				(gEgo setMotion: PolyPath 285 274 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 16101
					loop: 3
					cel: 0
					setPri: (gEgo priority:)
					posn: 248 280
					init:
					setCycle: CT 1 1 self
				)
			)
			(3
				(goSound1 playSound: 16103)
				(poTorin setCycle: CT 5 1 self)
			)
			(4
				(poTorin setPri: 190 setCycle: CT 11 1 self)
			)
			(5
				(goSound1 playSound: 16102)
				(poTorin setCycle: End oDisposeTorinWhenCued)
				(self setScript: soCrocEatTorin self)
			)
			(6
				(gGame handsOn:)
				(if ((ScriptID 64019 0) show: 0 42 9) ; DeathDialog
					(gEgo show:)
				)
				(self dispose:)
			)
		)
	)
)

(instance foBoogleTree of BoogleLearnMeClass
	(properties
		approachX 34
		approachY 260
	)

	(method (cue)
		(soBoogleMovesAway cue:)
	)
)

(instance soBoogleMovesAway of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(foBoogleTree init: self)
				(gCurRoom addBoogleFeature: foBoogleTree)
				((ScriptID 64018 0) nDoits: 0) ; oBoogle
			)
			(1
				(gCurRoom delBoogleFeature: foBoogleTree)
				((ScriptID 64018 0) setWander: 0 setHeading: 90) ; oBoogle
				(self dispose:)
			)
		)
	)
)

(instance soThrowScum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poCroc
					view: 16102
					loop: 1
					cel: 0
					posn: 336 314
					init:
					setPri: 190
					setCycle: CT 19 1 self
				)
			)
			(1
				(goSound1 playSound: 16104)
				(poCroc setCycle: End self)
			)
			(2
				(poCroc dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soDropSnails of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(goSound1 preload: 16104)
				(gEgo setMotion: PolyPath 285 274 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(gEgo hide:)
				(poTorin
					view: 16102
					loop: 0
					cel: 0
					setPri: (gEgo priority:)
					posn: 285 274
					init:
					setCycle: CT 13 1 self
				)
			)
			(3
				(gMessager sayRange: 1 10 0 1 2 self) ; "Here we are, boys, the site of the next Moat Olympics. I hope you win the Gold Medal!"
				(gEgo put: ((ScriptID 64001 0) get: 6)) ; oInvHandler, ioSnails
			)
			(4
				(gMessager say: 1 10 0 3 self) ; "Yeah, thanks. And in return, I'll put in a good word for you with some of my croctopus friends."
				(poTorin setCycle: End self)
			)
			(5)
			(6
				(self setScript: soBoogleMovesAway self)
				(gMessager sayRange: 1 10 0 4 9 self) ; "Good word? I don't need good words. I need moat scum...and plenty of it!"
			)
			(7)
			(8
				(= ticks 45)
			)
			(9
				(poTorin loop: 2 cel: 0 setCycle: End self)
				(self setScript: soThrowScum self)
			)
			(10)
			(11
				(poTorin dispose:)
				(gEgo
					posn: 168 287
					cel: 4
					get: ((ScriptID 64001 0) get: 7) ; oInvHandler, ioMoatScum
					show:
				)
				((ScriptID 64017 0) set: 7) ; oFlags
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foMoat of Feature
	(properties
		noun 1
		sightAngle 40
		approachX 307
		approachY 259
		x 308
		y 258
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 243 1 229 3 221 200 232 634 297 632 312 447 315 341 266
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1 10)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Do
				(gEgo setScript: soTorinJumpInMoat)
			)
			(10 ; ioSnails
				(gEgo setScript: soDropSnails)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance foDrawbridge of Feature
	(properties
		noun 2
		sightAngle 40
		x 356
		y 148
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 272 266 266 43 446 12 432 288
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)
)

(instance roCrystalCityMoat of TPRoom
	(properties
		picture 16100
		west 16000
	)

	(method (init)
		(super init: &rest)
		(goMusic1 setMusic: 16000)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -2 256 -2 384 395 318 346 292 317 282 145 260
					yourself:
				)
		)
		(foMoat init:)
		(poMoatRipple init:)
		(foDrawbridge init:)
		(foGuard init:)
		(foExit init:)
		((ScriptID 64018 0) init: posn: 100 350 setHeading: 25 normalize:) ; oBoogle
		(gEgo
			init:
			normalize:
			posn: 120 347
			loop: 6
			setMotion: MoveTo 201 316 (ScriptID 64020 0) ; oHandsOnWhenCued
		)
		(Palette 1 10000) ; PalLoad
	)
)

