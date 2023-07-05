;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 432)
(include sci.sh)
(use Main)
(use TPSound)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	ro432 0
)

(local
	local0 = 1
	local1 = 1
)

(instance ro432 of L7Room
	(properties
		picture 43200
	)

	(method (init)
		(super init: &rest)
		(= global330 0)
		(= gToVicki toVicki)
		(poVicki init:)
		(voVicki init: hide:)
		(global247 add: 126 131 129 104 85 247 86)
		(if (not ((ScriptID 64017 0) test: 120)) ; oFlags
			(voMucilage init:)
		)
		(if (not (gOMusic1 isPlaying:))
			(gOMusic1 setMusic: 43200 setRelVol: 50)
		)
		(poScreenText init:)
		(foComputer init:)
		(foRubberStamp init:)
		(foCalendar init:)
		(foLamp init:)
		(foCurtains init:)
		(foFlowers init:)
		(foBigPhoto init:)
		(foSmallPhoto init:)
		(foTeaSet init:)
		(foPen init:)
		(foBook1 init:)
		(foBook2 init:)
		(foBook3 init:)
		(foBook4 init:)
		(foVickiBody init:)
		(foVickiBreasts init:)
		(foVickiEyes init:)
		(foVickiFace init:)
		(foVickiHair init:)
		(if ((ScriptID 64017 0) test: 272) ; oFlags
			(voEroticBook init:)
		)
		(foExitSouth init:)
		(poOcean init:)
		(= local0 0)
		(if ((ScriptID 64017 0) test: 122) ; oFlags
			(poVicki view: 43201 loop: 0 cel: 0 doit:)
			(voVicki show: doit:)
			(poVickiEyes show: doit:)
			(voComboBook init:)
			(if local1
				(= local1 0)
				(if ((ScriptID 64017 0) test: 166) ; oFlags
					(gMessager say: 20 101 0 0 self) ; "Hi ya, Vicki!"
				else
					((ScriptID 64017 0) set: 166) ; oFlags
					(gMessager say: 20 100 0 0 self) ; "Excuse me, Miss?"
				)
			)
		else
			(self setScript: soLibraryTame)
		)
	)

	(method (cue)
		((ScriptID 64040 2) init: poVicki global247) ; L7TalkWindow
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(poVicki setCycle: 0 setScript: 0)
		(poScreenText setCycle: 0)
		(if (and ((ScriptID 64017 0) test: 199) (!= newRoomNumber 430)) ; oFlags, ro430
			((ScriptID 64017 0) clear: 199) ; oFlags
		)
		(cond
			(
				(or
					(gEgo has: ((ScriptID 64037 0) get: 33)) ; oInvHandler, ioPrudeAndProud
					(and
						(gEgo has: ((ScriptID 64037 0) get: 35)) ; oInvHandler, ioNoCoverPrudeBk
						(not ((ScriptID 64017 0) test: 122)) ; oFlags
					)
					(gEgo has: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
				)
				(gCurRoom setScript: soLeaveWithBook 0 newRoomNumber)
			)
			(local0
				(gCurRoom setScript: soLeaveNotLooking 0 newRoomNumber)
			)
			(else
				(= global330 0)
				(= gToShamara 0)
				(if (== newRoomNumber 430) ; ro430
					(gOMusic1 setRelVol: 50)
				else
					(gOMusic1 stop: setRelVol: 100)
				)
				(super newRoom: newRoomNumber)
			)
		)
	)

	(method (dispose)
		(if (gOSound1 isPlaying:)
			(gOSound1 stop:)
		)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 10)) ; oInvHandler, ioEroticBook
	)
)

(instance soLibraryTame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(= local0 0)
				(voPrudishBook init: hide:)
				(= ticks 120)
			)
			(2
				(poVicki
					view: 43200
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(voVicki hide:)
			)
			(3
				(poVicki view: 43200 loop: 1 cel: 0 setCycle: End self 6 7 9999)
			)
			(4
				(oSFX playSound: 43202)
			)
			(5
				(voPrudishBook show:)
			)
			(6
				(poVicki view: 43201 loop: 0 cel: 0)
				(poVickiEyes show: doit:)
				(UpdateScreenItem poVicki)
				(voVicki show:)
				(= cycles 1)
			)
			(7
				(if local1
					(= local1 0)
					(if ((ScriptID 64017 0) test: 166) ; oFlags
						(gMessager say: 20 101 0 0 self) ; "Hi ya, Vicki!"
					else
						((ScriptID 64017 0) set: 166) ; oFlags
						(gMessager say: 20 100 0 0 self) ; "Excuse me, Miss?"
					)
				)
			)
			(8
				(L7TalkWindow init: poVicki global247)
				((ScriptID 64017 0) set: 119) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soVickiTurnsTypes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(poVicki view: 43201 loop: 0 cel: 0)
				(= cycles 1)
			)
			(1
				(gMessager say: 6 4 0 1 self) ; "Just a moment. Let me look that up for you."
			)
			(2
				(poVicki
					view: 43202
					loop: 0
					cel: 0
					cycleSpeed: 6
					doit:
					setCycle: End self
				)
				(poVickiEyes hide:)
				(voVicki hide:)
			)
			(3
				(gGame handsOn:)
				(poVicki
					view: 43203
					loop: 0
					cel: 0
					cycleSpeed: 6
					doit:
					setCycle: ForwardCounter 5 self
				)
				(gOSound1 playSound: 43205 self)
				(poScreenText setCycle: Fwd)
			)
			(4 0)
			(5
				(poVicki setCycle: ForwardCounter 5 self)
				(gOSound1 playSound: 43205 self)
			)
			(6 0)
			(7
				(poVicki setCycle: ForwardCounter 5 self)
				(gOSound1 playSound: 43205 self)
			)
			(8 0)
			(9
				(if (gTalkers isEmpty:)
					(poVicki setScript: soVickiTurnsBack)
					(self dispose:)
				else
					(-- state)
					(= cycles 3)
				)
			)
		)
	)
)

(instance soVickiTurnsBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTalkers isEmpty:)
					(gGame handsOff:)
					(= cycles 1)
				else
					(-= state 1)
					(= cycles 1)
				)
			)
			(1
				(gOSound1 stop:)
				(poScreenText setCycle: 0)
				(if
					(and
						(== (poVicki view:) 43202)
						(== (poVicki loop:) 0)
						(> (poVicki cel:) 0)
					)
					(poVicki cycleSpeed: 6 setCycle: Beg self)
				else
					(poVicki
						view: 43202
						loop: 0
						cel: 9
						cycleSpeed: 6
						setCycle: Beg self
					)
				)
			)
			(2
				(poVicki view: 43201 loop: 0 cel: 0)
				(UpdateScreenItem poVicki)
				(poVickiEyes show:)
				(voVicki show:)
				(= cycles 1)
			)
			(3
				(if (gTalkers isEmpty:)
					(gMessager say: 6 4 0 (Random 2 7) self)
				else
					(-- state)
					(= cycles 3)
				)
			)
			(4
				(if
					(and
						(not ((ScriptID 64040 2) oPlane:)) ; L7TalkWindow
						(not
							(OneOf
								client
								soLeaveWithBook
								soLeaveNotLooking
							)
						)
					)
					((ScriptID 64040 2) init: poVicki global247) ; L7TalkWindow
				)
				(= local0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLeaveNotLooking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soVickiTurnsBack self)
			)
			(1
				(L7TalkWindow dispose:)
				(gCurRoom newRoom: register)
				(self dispose:)
			)
		)
	)
)

(instance soEroticOnPrudish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soVickiTurnsBack self)
			)
			(1
				(gMessager say: 20 28 0 0 self) ; "Oh, my goodness! I never read literature like that! That's shocking. At least, I know I'm shocked."
			)
			(2
				(oShortSound playSound: 43203)
				(voEroticBook dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLeaveWithBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(self setScript: soVickiTurnsBack self)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager sayRange: 0 0 3 1 4 self) ; "Excuse me, Mr. Laffer, but that book is checked out...to me!"
			)
			(2
				(if (gEgo has: ((ScriptID 64037 0) get: 34)) ; oInvHandler, ioBookJacket
					(gMessager say: 5 138 0 0 self) ; "Hmm, I think I'd better slip this back into its dust jacket so she doesn't notice!"
				else
					(= cycles 1)
				)
			)
			(3
				(if (gEgo has: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
					(gEgo put: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
					((ScriptID 64017 0) set: 199) ; oFlags
					((ScriptID 64017 0) set: 122) ; oFlags
					((ScriptID 64017 0) set: 167) ; oFlags
					(oSFX playSound: 43202 self)
					(voComboBook init:)
				else
					(if (gEgo has: ((ScriptID 64037 0) get: 34)) ; oInvHandler, ioBookJacket
						(gEgo put: ((ScriptID 64037 0) get: 34)) ; oInvHandler, ioBookJacket
					)
					(if
						(or
							(gEgo has: ((ScriptID 64037 0) get: 33)) ; oInvHandler, ioPrudeAndProud
							(gEgo has: ((ScriptID 64037 0) get: 35)) ; oInvHandler, ioNoCoverPrudeBk
						)
						(gEgo
							put: ((ScriptID 64037 0) get: 33) ; oInvHandler, ioPrudeAndProud
							put: ((ScriptID 64037 0) get: 35) ; oInvHandler, ioNoCoverPrudeBk
						)
						(oSFX playSound: 43202 self)
						(if ((ScriptID 64017 0) test: 272) ; oFlags
							(voPrudishBook
								view: 43204
								loop: 0
								cel: 0
								posn: 107 279
								setPri: 600
								init:
							)
						else
							(voPrudishBook view: 43204 loop: 0 cel: 0 init:)
						)
					else
						(= cycles 1)
					)
				)
			)
			(4
				(gMessager sayRange: 0 0 3 5 6 self) ; "Thanks."
			)
			(5
				(gCurRoom newRoom: register)
				(self dispose:)
			)
		)
	)
)

(instance soGoodBooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poVicki view: 43201 loop: 0 cel: 0)
				(gMessager say: 20 105 0 0 self) ; "So? Ya got any good books?"
			)
			(1
				((ScriptID 64040 2) addTopic: 106) ; L7TalkWindow
				(self dispose:)
			)
		)
	)
)

(instance soCheckOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poVicki view: 43201 loop: 0 cel: 0)
				(gMessager say: 20 106 0 0 self) ; "What about these?"
			)
			(1
				((ScriptID 64040 2) addTopic: 107) ; L7TalkWindow
				(self dispose:)
			)
		)
	)
)

(instance soPileOfBooks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poVicki view: 43201 loop: 0 cel: 0)
				(gMessager sayRange: 20 107 0 2 4 self) ; "Oh, those? Those are already checked out... to me!"
			)
			(1
				((ScriptID 64040 2) addTopic: 108) ; L7TalkWindow
				(self dispose:)
			)
		)
	)
)

(instance soPutBackPrudeBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(= cycles 1)
				else
					(gMessager say: 20 26 0 0 self) ; "How did you get that? Did it fall off the counter? Thanks for picking it up for me. I'll just leave it here."
				)
			)
			(1
				(gEgo put: ((ScriptID 64037 0) get: 33)) ; oInvHandler, ioPrudeAndProud
				(oSFX playSound: 43202 self)
				(voPrudishBook view: 43204 loop: 0 cel: 0 posn: 100 300 init:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPutBackNoCoverPrudeBk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 5 138 0 0 self) ; "Hmm, I think I'd better slip this back into its dust jacket so she doesn't notice!"
			)
			(1
				(if (gEgo has: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
					(gEgo
						put: ((ScriptID 64037 0) get: 11) ; oInvHandler, ioEroticAndProud
						get: ((ScriptID 64037 0) get: 10) ; oInvHandler, ioEroticBook
					)
				)
				(gEgo
					put: ((ScriptID 64037 0) get: 35) ; oInvHandler, ioNoCoverPrudeBk
					put: ((ScriptID 64037 0) get: 34) ; oInvHandler, ioBookJacket
				)
				(oSFX playSound: 43202 self)
				(voPrudishBook view: 43204 loop: 0 cel: 0 posn: 100 300 init:)
			)
			(2
				(if local0
					(= cycles 1)
				else
					(gMessager say: 20 26 0 0 self) ; "How did you get that? Did it fall off the counter? Thanks for picking it up for me. I'll just leave it here."
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPutComboBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSFX playSound: 43202 self)
				(gEgo put: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
				((ScriptID 64017 0) set: 199) ; oFlags
				((ScriptID 64017 0) set: 122) ; oFlags
				((ScriptID 64017 0) set: 167) ; oFlags
				(voComboBook init:)
			)
			(1
				(gMessager say: 5 29 4 0 self) ; "Nice going, Larry. That ought to stimulate her "inner woman!""
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGiveBackBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 20 26 0 0 self) ; "How did you get that? Did it fall off the counter? Thanks for picking it up for me. I'll just leave it here."
			)
			(1
				(if (gEgo has: ((ScriptID 64037 0) get: 34)) ; oInvHandler, ioBookJacket
					(gEgo put: ((ScriptID 64037 0) get: 34)) ; oInvHandler, ioBookJacket
					(gMessager say: 5 138 0 0 self) ; "Hmm, I think I'd better slip this back into its dust jacket so she doesn't notice!"
				else
					(= cycles 1)
				)
			)
			(2
				(oSFX playSound: 43202 self)
				(if (gEgo has: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
					(gEgo put: ((ScriptID 64037 0) get: 11)) ; oInvHandler, ioEroticAndProud
					((ScriptID 64017 0) set: 199) ; oFlags
					((ScriptID 64017 0) set: 122) ; oFlags
					((ScriptID 64017 0) set: 167) ; oFlags
					(voComboBook init:)
				else
					(voPrudishBook view: 43204 loop: 0 cel: 0 init:)
				)
				(gEgo
					put: ((ScriptID 64037 0) get: 33) ; oInvHandler, ioPrudeAndProud
					put: ((ScriptID 64037 0) get: 35) ; oInvHandler, ioNoCoverPrudeBk
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLookAndFlip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 19 1 4) ; "While she's looking the other way, let's just see what she's reading. (PAGE THROUGH BOOK) Borrrrr-ing!"
				(= ticks 260)
			)
			(1
				(oShortSound setRelVol: 200 playSound: 43206)
				(= ticks 90)
			)
			(2
				(oShortSound setRelVol: 100)
				(self dispose:)
			)
		)
	)
)

(instance soTakeEroticBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 18 8 8 0 self) ; "What did you think of THIS book, Victorian?"
			)
			(1
				(oShortSound playSound: 43203)
				(gEgo get: ((ScriptID 64037 0) get: 10)) ; oInvHandler, ioEroticBook
				((ScriptID 64017 0) clear: 272) ; oFlags
				(voEroticBook dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soGoodbye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 20 86 0 0 self) ; "Nice talking to you, Victorian. Perhaps I'll stop by later."
			)
			(1
				(gCurRoom newRoom: 430) ; ro430
				(self dispose:)
			)
		)
	)
)

(instance poScreenText of Prop
	(properties
		x 224
		y 224
		priority 50
		fixPriority 1
		view 43295
	)
)

(instance voMucilage of View
	(properties
		noun 1
		x 100
		y 300
		priority 500
		fixPriority 1
		view 43204
		loop 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if local0
					(gEgo get: ((ScriptID 64037 0) get: 26)) ; oInvHandler, ioMucilage
					((ScriptID 64017 0) set: 120) ; oFlags
					(oShortSound playSound: 43203)
					(self case: 4)
					(self dispose:)
				else
					(poVicki view: 43201 loop: 0 cel: 0)
					(self case: 0)
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voPrudishBook of View
	(properties
		noun 19
		x 100
		y 300
		priority 490
		fixPriority 1
		view 43204
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gCurRoom setScript: soLookAndFlip)
				else
					(gMessager say: 19 1 0) ; "Prudish and Proud" Yes, this gal brings new meaning to the word "up tight!"
				)
			)
			(28 ; "The Erotic Adventures of Hercules"
				(if local0
					(gGame handsOff:)
					(oSFX playSound: 43202)
					(voEroticBook cel: 2 posn: 107 279 setPri: 500 init:)
					(gCurRoom setScript: soEroticOnPrudish)
				else
					(gMessager say: 20 28) ; "Oh, my goodness! I never read literature like that! That's shocking. At least, I know I'm shocked."
				)
			)
			(8 ; Take
				(if local0
					(gEgo get: ((ScriptID 64037 0) get: 33)) ; oInvHandler, ioPrudeAndProud
					((ScriptID 64017 0) set: 121) ; oFlags
					(oShortSound playSound: 43203)
					(gMessager say: 19 8 4) ; "Maybe I can just slip this out of here while she's not looking..."
					(self dispose:)
				else
					(poVicki view: 43201 loop: 0 cel: 0)
					(gMessager say: 19 8) ; "I'm sorry, sir. I'm reading that particular book."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voEroticBook of View
	(properties
		noun 18
		x 100
		y 300
		priority 490
		fixPriority 1
		view 43204
		cel 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== cel 2)
					(gMessager say: 18 1) ; "You can't wait until she reads your "special" book. (Perhaps she's just waiting for you to leave?)"
				else
					(gMessager say: 18 1 8) ; "Didn't you place that book on her "to be read" pile?"
				)
			)
			(8 ; Take
				(cond
					(local0
						(oShortSound playSound: 43203)
						(gEgo get: ((ScriptID 64037 0) get: 10)) ; oInvHandler, ioEroticBook
						((ScriptID 64017 0) clear: 272) ; oFlags
						(self dispose:)
					)
					((== cel 2)
						(gMessager say: 18 8) ; "You don't want to take it... you want Victorian to read it!"
					)
					(else
						(gCurRoom setScript: soTakeEroticBook)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voComboBook of View
	(properties
		noun 18
		x 100
		y 300
		priority 490
		fixPriority 1
		view 43204
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance foComputer of Feature
	(properties
		noun 4
		x 194
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 259 303 261 270 212 267 208 261 263 254 266 248 273 193 280 151 229 136 178 130 140 159 109 191 123 228 131 257 174 264 169 270 123 278 123 288 174 289 178 294 177 304 175 306 158 312 202 319
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRubberStamp of Feature
	(properties
		noun 2
		x 41
		y 410
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 18 393 21 390 27 393 27 396 25 399 25 409 43 409 44 418 51 413 56 412 56 401 52 398 54 392 61 392 65 393 64 398 60 401 60 412 78 413 77 420 64 430 38 428 38 423 27 428 4 424 6 416 19 409 19 399 17 396 17 393
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPen of Feature
	(properties
		noun 23
		x 171
		y 392
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 151 404 151 406 155 407 159 405 191 380 191 377 168 390 158 392 151 402
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCalendar of Feature
	(properties
		noun 3
		x 391
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 325 65 362 57 390 55 438 57 460 60 446 149 451 160 452 191 456 220 446 232 440 240 331 241 322 234 326 219 328 190 330 172 333 158 338 151 329 106
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCurtains of Feature
	(properties
		noun 16
		x 65
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 278 104 197 107 189 108 179 121 97 130 99 120 60 124 57 46 0 1 2 0 313 20 303 0 235 3 155 41 57 45 67 54 72 63 131 82 187 79 188 83 197 83 206 64 278 71 285 84 292 105 291 122 285
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foFlowers of Feature
	(properties
		noun 15
		x 588
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 603 282 608 265 604 250 610 242 606 224 613 227 619 214 617 193 606 197 609 180 617 165 625 172 635 166 639 158 638 47 635 41 627 34 621 37 614 23 600 37 588 37 573 30 575 55 555 61 563 67 561 74 547 77 537 92 543 99 539 108 549 114 555 119 554 139 559 146 565 159 580 159 591 200 584 196 580 210 585 222 590 221 583 241 585 251 585 266 593 276
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foTeaSet of Feature
	(properties
		noun 17
		x 528
		y 353
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 637 420 614 407 616 394 611 365 606 352 623 334 622 314 607 312 600 300 596 294 596 284 586 286 591 296 574 316 581 335 558 372 550 361 557 340 568 321 565 311 542 306 541 316 558 316 537 363 541 382 508 368 472 381 458 373 469 348 451 344 433 346 419 341 420 355 425 363 437 373 420 376 422 382 444 386 488 421 636 423
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLamp of Feature
	(properties
		noun 14
		x 487
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 494 313 493 295 506 295 504 285 498 274 499 268 512 266 525 263 531 261 531 249 536 237 506 197 513 184 506 182 496 181 485 180 477 180 468 183 474 196 438 240 438 257 448 263 455 263 470 266 470 272 462 279 468 280 465 289 460 293 466 313 480 316
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBigPhoto of Feature
	(properties
		noun 13
		x 437
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 451 317 467 281 463 279 427 280 408 311
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foSmallPhoto of Feature
	(properties
		noun 13
		x 508
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 525 322 514 294 492 294 495 320
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBook1 of Feature
	(properties
		noun 9
		x 100
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 328 156 321 152 310 115 308 61 318 60 321 63 323 65 331 60 337 60 342 108 344
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(if
					(or
						(gEgo has: ((ScriptID 64037 0) get: 33)) ; oInvHandler, ioPrudeAndProud
						(gEgo has: ((ScriptID 64037 0) get: 35)) ; oInvHandler, ioNoCoverPrudeBk
					)
					(gMessager say: 5 8 9) ; "You've already taken one of her books; you don't need any more!"
				else
					(super doVerb: theVerb)
				)
			)
			(29 ; "Erotic" Book In "Prudish" Jacket
				(if local0
					(gCurRoom setScript: soPutComboBook)
				else
					(gMessager say: 5 29) ; "Not now, Larry. She'll see you!"
				)
			)
			(28 ; "The Erotic Adventures of Hercules"
				(cond
					((and local0 (gCast contains: voPrudishBook))
						(gGame handsOff:)
						(oSFX playSound: 43202)
						(voEroticBook cel: 2 posn: 107 279 setPri: 500 init:)
						(gCurRoom setScript: soEroticOnPrudish)
					)
					(local0
						((ScriptID 64017 0) set: 272) ; oFlags
						(oSFX playSound: 43202)
						(gEgo put: ((ScriptID 64037 0) get: 10)) ; oInvHandler, ioEroticBook
						(voEroticBook cel: 2 posn: 100 300 setPri: 490 init:)
					)
					(else
						(gMessager say: 20 28) ; "Oh, my goodness! I never read literature like that! That's shocking. At least, I know I'm shocked."
					)
				)
			)
			(26 ; "Prudish and Proud"
				(gCurRoom setScript: soPutBackPrudeBook)
			)
			(138 ; "Prudish And Proud" Sans Jacket
				(gCurRoom setScript: soPutBackNoCoverPrudeBk)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBook2 of Feature
	(properties
		noun 10
		x 100
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					init: 171 344 175 338 167 328 154 328 110 344 59 342 63 335 35 344 33 365 114 367
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(foBook1 doVerb: theVerb)
		)
	)
)

(instance foBook3 of Feature
	(properties
		noun 11
		x 100
		y 30
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 358 160 348 113 368 45 366 40 384 112 385
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(foBook1 doVerb: theVerb)
		)
	)
)

(instance foBook4 of Feature
	(properties
		noun 12
		x 100
		y 40
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 170 379 174 369 173 359 161 357 111 385 41 384 40 380 29 383 40 393 32 404 120 408
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(super doVerb: theVerb)
		else
			(foBook1 doVerb: theVerb)
		)
	)
)

(instance foVickiBody of Feature
	(properties
		noun 25
		x 382
		y 420
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 386 340 386 339 391 327 402 318 406 310 420 290 419 277 417 258 425 236 434 216 420 219 407 213 385 216 367 209 355 214 344 231 340 248 333 262 331 270 334 280 341 291 348 311 351 331 365 339 378 346 380 344
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiBreasts of Feature
	(properties
		noun 7
		x 374
		y 430
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 373 288 391 291 408 286 416 280 416 265 409 250 398 246 369 254 352 242 339 250 332 265 334 279 338 284 354 283 360 283
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiEyes of Feature
	(properties
		noun 21
		x 376
		y 420
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 389 155 395 149 389 146 382 152 365 152 362 150 358 153 358 155 365 156 388 155
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiFace of Feature
	(properties
		noun 24
		x 378
		y 410
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 378 194 387 191 400 181 404 149 382 123 357 125 353 141 359 154 361 157 360 167 364 175 367 180 370 189
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if local0
			(self noun: 22)
		else
			(self noun: 24)
		)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foVickiHair of Feature
	(properties
		noun 22
		x 386
		y 430
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 401 181 405 183 410 181 412 178 415 169 411 174 408 175 406 171 409 160 415 143 418 124 414 105 424 105 434 94 431 74 415 61 403 61 393 66 388 74 387 84 382 85 379 88 373 86 363 87 357 95 350 100 346 109 342 116 341 120 346 127 347 137 347 140 338 136 344 144 353 141 357 125 382 123 389 138 394 146 400 146 402 155 398 169
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poVicki doVerb: theVerb &rest)
			(return)
		)
		(if (== theVerb 4) ; Talk
			(poVicki doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 460 640 460 640 480 0 480
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gCurRoom newRoom: 430) ; ro430
	)
)

(instance poLarry of Prop
	(properties
		priority 50
		fixPriority 1
		view 11015
	)
)

(instance toLarry of Talker ; UNUSED
	(properties)

	(method (init)
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= priority (+ (poLarry priority:) 5))
		(super init: &rest)
	)
)

(instance poVicki of Prop
	(properties
		noun 20
		x 369
		y 306
		priority 200
		fixPriority 1
		view 43200
	)

	(method (init)
		(super init: &rest)
		(poVickiEyes init: hide:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if local0
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(if local1
					(if ((ScriptID 64017 0) test: 166) ; oFlags
						(gMessager say: 20 101) ; "Hi ya, Vicki!"
					else
						(gMessager say: 20 100) ; "Excuse me, Miss?"
						((ScriptID 64017 0) set: 166) ; oFlags
					)
					(= local1 0)
				)
				(L7TalkWindow init: self global247)
			)
			(29 ; "Erotic" Book In "Prudish" Jacket
				(gCurRoom setScript: soGiveBackBook)
			)
			(26 ; "Prudish and Proud"
				(gCurRoom setScript: soGiveBackBook)
			)
			(138 ; "Prudish And Proud" Sans Jacket
				(if ((ScriptID 64017 0) test: 122) ; oFlags
					(super doVerb: theVerb)
				else
					(gCurRoom setScript: soGiveBackBook)
				)
			)
			(28 ; "The Erotic Adventures of Hercules"
				(gMessager say: 20 28) ; "Oh, my goodness! I never read literature like that! That's shocking. At least, I know I'm shocked."
			)
			(105 ; Good books
				(gCurRoom setScript: soGoodBooks)
			)
			(106 ; Check out
				(gCurRoom setScript: soCheckOut)
			)
			(107 ; Pile of books
				(gCurRoom setScript: soPileOfBooks)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(else
				(cond
					((and (!= theVerb 70) (Message msgGET 432 noun theVerb 0 1)) ; Huh?
						(poVicki view: 43201 loop: 0 cel: 0)
						(super doVerb: theVerb)
					)
					((proc64040_1 theVerb)
						((ScriptID 64040 2) dispose:) ; L7TalkWindow
						(poVicki setScript: soVickiTurnsTypes)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance voVicki of View
	(properties)

	(method (init)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 1))
		(super show: &rest)
	)
)

(instance poVickiEyes of Prop
	(properties
		view 43201
		loop 2
	)

	(method (init)
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 2))
		(super init: &rest)
		(self setCycle: Blink 120)
	)
)

(instance toVicki of Talker
	(properties)

	(method (init)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(= priority (+ (poVicki priority:) 1))
		(voVicki hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voVicki show:)
		(super dispose: &rest)
	)
)

(instance soMotion of OceanMotionSin
	(properties
		nCenterY 290
		nRange 12
	)
)

(instance poOcean of Prop
	(properties
		y 290
		priority 2
		fixPriority 1
		view 43299
	)

	(method (init)
		(super init: &rest)
		(self setScript: soMotion)
	)
)

(instance oShortSound of TPSound
	(properties)
)

(instance oSFX of TPSound
	(properties)
)

