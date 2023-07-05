;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use foEExit)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roLeaves 0
)

(instance poLeaf of Prop
	(properties
		x 467
		y 141
		view 12005
	)

	(method (doVerb theVerb &tmp nPri)
		(cond
			(((ScriptID 64017 0) test: 11) ; oFlags
				(gMessager say: 3 1 3) ; "I don't need any more leaves."
			)
			((== theVerb 18) ; ioInchworm
				((ScriptID 64017 0) set: 12) ; oFlags
				(gCurRoom setScript: soWind)
			)
			((== theVerb 1) ; Do
				(cond
					(((ScriptID 64017 0) test: 11) ; oFlags
						(gMessager say: 3 1 2) ; "Hey! Come back here. (PAUSE) Now which one is it?"
					)
					((not ((ScriptID 64017 0) test: 27)) ; oFlags
						(gMessager say: 1 1 4) ; "Why am I taking a leaf?"
					)
					(else
						(gMessager say: 3 1 5) ; "This might be the biggest leaf here...but then again, it might not."
					)
				)
			)
		)
	)
)

(instance poGrab of Prop
	(properties
		x 301
		y 315
		view 12001
	)
)

(instance poStomp of Prop
	(properties
		x 301
		y 315
		view 12004
	)
)

(instance poPeel of Prop
	(properties
		x 305
		y 315
		view 12000
	)
)

(instance soHideUglyFoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poStomp y: (+ (poStomp y:) 100))
				(UpdateScreenItem poStomp)
				(= ticks 6)
			)
			(1
				(poStomp hide:)
				(self dispose:)
			)
		)
	)
)

(instance soPullInchieOffShoe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poStomp setCycle: CT 17 1 self)
			)
			(1
				(gMessager say: 3 1 2 5 self) ; "(PAUSE) Ooooh, yuck! Uh, hey, Boogle! Get that, will you?"
			)
			(2
				(goSound1 playSound: 12006 self)
			)
			(3
				(poStomp setCel: 18)
				(UpdateScreenItem poStomp)
				(poPeel
					setPri: (+ (poStomp priority:) 1)
					setCel: 1
					show:
					setCycle: CT 3 1 self
				)
				(UpdateScreenItem poPeel)
			)
			(4
				(goSound1 playSound: 12003)
				(poPeel setCycle: CT 12 1 self)
			)
			(5
				(poPeel setCycle: CT 31 1 self)
				(self setScript: soHideUglyFoot self)
			)
			(6)
			(7
				(goSound1 playSound: 12004)
				(poPeel setCycle: End self)
			)
			(8
				(= ticks 40)
			)
			(9
				(self setScript: soCheezyBoogleChange self)
			)
			(10
				(= ticks 140)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance soCheezyBoogleChange of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 60011 self)
			)
			(1
				(= ticks 20)
			)
			(2
				(goSound1 playSound: 60019 self)
			)
			(3
				(gEgo get: ((ScriptID 64001 1) get: 1)) ; oBoogleHandler, ioBoogleWorm
				(self dispose:)
			)
		)
	)
)

(instance soPeelInchie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poStomp show: setCycle: CT 5 1 self)
			)
			(1
				(self setScript: soPullInchieOffShoe self)
			)
			(2
				((ScriptID 64017 0) set: 11) ; oFlags
				(gEgo
					get: ((ScriptID 64001 0) get: 13) ; oInvHandler, ioLeaf
					put: ((ScriptID 64001 0) get: 3) ; oInvHandler, ioInchworm
				)
				(poPeel dispose:)
				(poStomp dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soLeafBlow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeaf setCel: 0 setCycle: End self)
				(UpdateScreenItem poLeaf)
			)
			(1
				(poLeaf cel: 0 x: (- (poLeaf x:) 120) y: (+ (poLeaf y:) 30))
				(UpdateScreenItem poLeaf)
				(self dispose:)
			)
		)
	)
)

(instance soGrabAndLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 12001)
				(= ticks 45)
			)
			(1
				(self setScript: soLeafBlow self)
				(poGrab setCel: 0 show: setCycle: End self)
				(UpdateScreenItem poGrab)
			)
			(2)
			(3
				(poGrab hide:)
				(self dispose:)
			)
		)
	)
)

(instance soStompAndSquish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poGrab setCel: 0 show: setCycle: CT 7 1 self)
				(UpdateScreenItem poGrab)
				(gMessager say: 3 1 2 3 self) ; "Gotcha!!"
			)
			(1)
			(2
				(goSound1 playSound: 12002 self)
			)
			(3
				(= ticks 100)
			)
			(4
				(gMessager say: 3 1 2 4 self) ; "(QUIETLY) Oops."
			)
			(5
				(poLeaf hide:)
				(poGrab setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance soGrabAndSquish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 12001)
				(= ticks 45)
			)
			(1
				(self setScript: soLeafBlow self)
			)
			(2
				(self setScript: soStompAndSquish self)
			)
			(3
				(poGrab dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soWind of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 preload: 12001 12002 12003)
				(poPeel init: hide:)
				(poStomp init: hide:)
				(poGrab init: hide:)
				(gGame handsOff:)
				(gMessager say: 3 18 2 0 self) ; "STOP! That's it."
			)
			(1
				(poGrab view: 12001 cel: 0)
				(self setScript: soGrabAndLeaves self)
			)
			(2
				(gMessager say: 3 1 2 1 self) ; "Hey! Come back here. (PAUSE) Now which one is it?"
			)
			(3
				(poGrab view: 12002 cel: 0)
				(self setScript: soGrabAndLeaves self)
			)
			(4
				(gMessager say: 3 1 2 2 self) ; "Oh, not again!"
			)
			(5
				(poGrab x: 173 view: 12003 cel: 0)
				(self setScript: soGrabAndSquish self)
			)
			(6
				(poLeaf dispose:)
				(self setScript: soPeelInchie self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foAllOthers of Feature
	(properties
		nsRight 631
		nsBottom 315
	)

	(method (doVerb theVerb)
		(cond
			(((ScriptID 64017 0) test: 11) ; oFlags
				(gMessager say: 1 1 3) ; "I don't need any more leaves."
			)
			((== theVerb 18) ; ioInchworm
				(goSound1 playMessage: 1 18 1 (Random 1 35) 0 gCurRoomNum 1)
			)
			((== theVerb 1) ; Do
				(gMessager say: 1 1 4) ; "Why am I taking a leaf?"
			)
		)
	)
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 10100
	)
)

(instance roLeaves of TPRoom
	(properties
		picture 12000
		style 0
		exitStyle 0
		south 10100
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 13) ; oFlags
		(foExit init: myPriority: 100)
		(goMusic1 setMusic: 12000)
		(foAllOthers init: plane myPriority: 1 addHotspotVerb: 1 18)
		(if (not ((ScriptID 64017 0) test: 11)) ; oFlags
			(poLeaf init: plane myPriority: 100 addHotspotVerb: 1 18)
		)
		(gGame handsOn:)
	)
)

