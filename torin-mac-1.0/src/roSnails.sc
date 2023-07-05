;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use TPSound)
(use foEExit)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	roSnails 0
	toSlim 1
	toSlime 2
)

(instance foExit of CUExitFeature
	(properties
		rExitTo 10100
	)
)

(instance poSlimNormalEyes of Prop
	(properties
		x 240
		y 220
		priority 300
		fixPriority 1
		view 10116
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setScript: soSlimBlink)
	)
)

(instance poSlimBlink of Prop
	(properties
		x 240
		y 220
		priority 300
		fixPriority 1
		view 10116
		loop 4
	)
)

(instance voSlimNormalMouth of View
	(properties
		x 240
		y 220
		priority 300
		fixPriority 1
		view 10116
		loop 1
		cel 2
	)
)

(instance toSlim of Talker
	(properties
		x 240
		y 220
		view 10116
		loop 1
		priority 300
	)

	(method (init)
		(voSlimNormalMouth hide:)
		(poSlimNormalEyes hide:)
		(= eyes poSlimBlink)
		(super init: &rest)
	)

	(method (dispose)
		(voSlimNormalMouth show:)
		(poSlimNormalEyes show:)
		(super dispose: &rest)
	)
)

(instance poSlim of Prop
	(properties
		x 240
		y 220
		view 10116
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1 2 8 21 18 4 9 23)
		(|= signal $1000)
		(poSlimNormalEyes init:)
		(voSlimNormalMouth init:)
	)

	(method (dispose)
		(poSlimNormalEyes dispose:)
		(voSlimNormalMouth dispose:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(23 ; ioLeaf
				(gCurRoom setScript: soPickUpSnails)
			)
			(1 ; Do
				(switch gnSnailTalk
					(0)
					(1
						(++ gnSnailTalk)
						(gCurRoom setScript: soTalk1)
					)
					(2
						(++ gnSnailTalk)
						(gCurRoom setScript: soTalk2)
					)
					(3
						(if ((ScriptID 64017 0) test: 30) ; oFlags
							(++ gnSnailTalk)
							(gCurRoom setScript: soTalk3NeedSlugs)
						else
							(gCurRoom setScript: soTalk3NoSlugs)
						)
					)
					(4
						(++ gnSnailTalk)
						(gCurRoom setScript: soTalk4)
						((ScriptID 64017 0) set: 27) ; oFlags
					)
					(5
						(gCurRoom setScript: soTalk5)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soTalk1 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSlap preload: 10125 10127)
				(gMessager sayRange: 0 1 1 1 9 self) ; "Waddayou lookin' at?"
			)
			(1
				(self setScript: soEyeFive self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(self setScript: 0)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soTalk2 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSlap preload: 10125 10127)
				(gMessager sayRange: 0 1 2 1 7 self) ; "Slim and Slime? You guys seem different from the others I've met around here."
			)
			(1
				(self setScript: soEyeFive self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(self setScript: 0)
		(gGame handsOn:)
		(self dispose:)
	)
)

(instance soTalk3NeedSlugs of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSlap preload: 10125 10127)
				(gMessager sayRange: 0 1 3 1 11 self) ; "Say, guys, could you could help me with those slugs over there on the next tree? I can't even get close to them. How can I trap them?"
			)
			(1
				(self setScript: soEyeFive self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gGame handsOn:)
		(self setScript: 0)
		(self dispose:)
	)
)

(instance soTalk3NoSlugs of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSlap preload: 10125 10127)
				(gMessager sayRange: 0 1 8 1 8 self) ; "What's so funny about being a pair?"
			)
			(1
				(self setScript: soEyeFive self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gGame handsOn:)
		(self setScript: 0)
		(self dispose:)
	)
)

(instance soTalk4 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 1 4 0 self) ; "While I'm not totally unfamiliar with 12-step programs..."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gGame handsOn:)
		(self setScript: 0)
		(self dispose:)
	)
)

(instance soTalk5 of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 1 5 0 self) ; "So, if I can find you a really big leaf..."
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (ff)
		(gGame handsOn:)
		(self setScript: 0)
		(self dispose:)
	)
)

(instance poSlimeNormalEyes of Prop
	(properties
		x 369
		y 218
		priority 300
		fixPriority 1
		view 10116
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self setScript: soSlimeBlink)
		(self setCycle: Blink 200)
	)
)

(instance soSlimBlink of Script
	(properties)

	(method (changeState newState &tmp nLoopRand)
		(switch (= state newState)
			(0
				(= ticks (Random 100 200))
				(= nLoopRand (Random 1 10))
				(cond
					((<= 1 nLoopRand 5)
						(client loop: 4)
					)
					((<= 6 nLoopRand 7)
						(client loop: 2)
					)
					((== nLoopRand 8)
						(client loop: 3)
					)
					((== nLoopRand 9)
						(client loop: 5)
					)
					((== nLoopRand 10)
						(client loop: 2)
					)
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= ticks (Random 5 15))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance soSlimeBlink of Script
	(properties)

	(method (changeState newState &tmp nLoopRand)
		(switch (= state newState)
			(0
				(= ticks (Random 100 200))
				(= nLoopRand (Random 1 10))
				(cond
					((<= 1 nLoopRand 4)
						(client loop: 10)
					)
					((<= 5 nLoopRand 8)
						(client loop: 12)
					)
					((== nLoopRand 9)
						(client loop: 9)
					)
					((== nLoopRand 10)
						(client loop: 11)
					)
				)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= ticks (Random 5 15))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance poSlimeBlink of Prop
	(properties
		x 369
		y 218
		priority 300
		fixPriority 1
		view 10116
		loop 10
	)
)

(instance voSlimeNormalMouth of Prop
	(properties
		x 369
		y 218
		priority 300
		fixPriority 1
		view 10116
		loop 8
		cel 2
	)
)

(instance toSlime of Talker
	(properties
		x 369
		y 218
		view 10116
		loop 8
		priority 300
	)

	(method (init)
		(voSlimeNormalMouth hide:)
		(poSlimeNormalEyes hide:)
		(= eyes poSlimeBlink)
		(super init: &rest)
	)

	(method (dispose)
		(voSlimeNormalMouth show:)
		(poSlimeNormalEyes show:)
		(super dispose: &rest)
	)
)

(instance poSlime of Prop
	(properties
		x 369
		y 218
		view 10116
		loop 7
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
		(poSlimeNormalEyes init:)
		(voSlimeNormalMouth init:)
	)

	(method (dispose)
		(poSlimeNormalEyes dispose:)
		(voSlimeNormalMouth dispose:)
		(super dispose: &rest)
	)

	(method (testHotspotVerb)
		(poSlim testHotspotVerb: &rest)
	)

	(method (doVerb theVerb)
		(poSlim doVerb: theVerb)
	)
)

(instance oSlap of TPSound
	(properties)
)

(instance poEyeFive of Prop
	(properties)
)

(instance soEyeFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poSlim hide:)
				(voSlimNormalMouth hide:)
				(poSlimNormalEyes hide:)
				(poSlime hide:)
				(voSlimeNormalMouth hide:)
				(poSlimeNormalEyes hide:)
				(poEyeFive
					view: 10116
					loop: 13
					cel: 0
					posn: 244 221
					init:
					setCycle: CT 8 1 self
				)
				(goSound1 playSound: 10127)
			)
			(1
				(oSlap playSound: 10125)
				(poEyeFive setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(poEyeFive dispose:)
		(poSlim show:)
		(voSlimNormalMouth show:)
		(poSlimNormalEyes show:)
		(poSlime show:)
		(voSlimeNormalMouth show:)
		(poSlimeNormalEyes show:)
		(oSlap stop:)
		(goSound1 stop:)
		(super dispose: &rest)
	)
)

(instance soPickUpSnails of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> gnSnailTalk 4)
					(gMessager sayRange: 0 23 9 1 4 self) ; "I found it, boys. This is the biggest leaf in all the woods."
				else
					(self cue:)
				)
			)
			(1
				(gEgo put: ((ScriptID 64001 0) get: 13)) ; oInvHandler, ioLeaf
				(self setScript: soBringInLeaf self)
			)
			(2
				(if (> gnSnailTalk 4)
					(gMessager sayRange: 0 23 9 5 15 self) ; "Yep. And here it is. Now...tell me about those slugs. How can I capture them?"
				else
					(gMessager say: 0 23 10 0 self) ; "Could you two use a larger leaf, maybe?"
				)
			)
			(3
				(gMessager say: 0 23 11 0 self) ; "Yeah. Pond scum is good."
			)
			(4
				(self setScript: soHopOnLeaf self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo get: ((ScriptID 64001 0) get: 6)) ; oInvHandler, ioSnails
				((ScriptID 64017 0) set: 6) ; oFlags
				((ScriptID 64017 0) set: 27) ; oFlags
				(poSlim dispose:)
				(poSlime dispose:)
				(gCurRoom newRoom: 10100) ; roForestScroll
				(self dispose:)
			)
		)
	)
)

(instance poLeaf of Prop
	(properties)
)

(instance poLeafMask of Prop
	(properties)
)

(instance poSlimHops of Prop
	(properties)
)

(instance poSlimeHops of Prop
	(properties)
)

(instance soBringInLeaf of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLeaf
					view: 10121
					loop: 0
					cel: 0
					posn: 541 315
					init:
					setCycle: End self
				)
			)
			(1
				(poLeaf loop: 1 cel: 0 setPri: 1)
				(poLeafMask
					view: 10121
					loop: 4
					cel: 0
					posn: 541 315
					setPri: 500
					init:
				)
				(self dispose:)
			)
		)
	)
)

(instance soHopOnLeaf of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poSlim dispose:)
				(poSlimHops
					view: 10121
					loop: 2
					cel: 0
					posn: 235 218
					setPri: 300
					init:
					setCycle: CT 7 1 self
				)
			)
			(1
				(poSlimHops setCycle: End self)
				(poLeaf setCycle: End self)
				(poLeafMask setCycle: End self)
			)
			(2)
			(3)
			(4
				(poLeaf cel: 0)
				(poLeafMask cel: 0)
				(poSlime dispose:)
				(poSlimeHops
					view: 10121
					loop: 3
					cel: 0
					posn: 389 212
					setPri: 299
					init:
					setCycle: CT 9 1 self
				)
			)
			(5
				(= ticks (poSlimeHops cycleSpeed:))
			)
			(6
				(poSlimeHops cel: 10)
				(poLeaf cel: 1)
				(poLeafMask cel: 1)
				(poSlimHops posn: 235 258)
				(= ticks (poSlimeHops cycleSpeed:))
			)
			(7
				(poSlimeHops cel: 11)
				(poLeaf cel: 2)
				(poLeafMask cel: 2)
				(poSlimHops posn: 235 243)
				(= ticks (poSlimeHops cycleSpeed:))
			)
			(8
				(poSlimeHops cel: 12)
				(poLeaf cel: 3)
				(poLeafMask cel: 3)
				(poSlimHops posn: 235 228)
				(= ticks (poSlimeHops cycleSpeed:))
			)
			(9
				(poSlimeHops cel: 13)
				(poLeaf cel: 4)
				(poLeafMask cel: 4)
				(poSlimHops posn: 235 218)
				(self dispose:)
			)
		)
	)
)

(instance roSnails of TPRoom
	(properties
		picture 14000
	)

	(method (init)
		(super init: &rest)
		((ScriptID 64017 0) set: 26) ; oFlags
		(goMusic1 setMusic: 14000)
		(gGame handsOn:)
		(foExit init:)
		(if (not ((ScriptID 64017 0) test: 6)) ; oFlags
			(poSlim init:)
			(poSlime init:)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64001 0) get: 13)) ; oInvHandler, ioLeaf
		(gEgo get: ((ScriptID 64001 0) get: 3)) ; oInvHandler, ioInchworm
		((ScriptID 64017 0) set: 30) ; oFlags
	)
)

