;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 261)
(include sci.sh)
(use Main)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CueMe)
(use foEExit)
(use Talker)
(use Sync)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	ro261 0
)

(local
	local0
)

(instance ro261 of L7Room
	(properties
		picture 26100
	)

	(method (init)
		(super init:)
		(= global341 toPeggyTalker)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(global254 add: 96)
		)
		(if ((ScriptID 64017 0) test: 278) ; oFlags
			(global254 add: 171)
		)
		(poPeggy init: doVerb: 4)
		(foEyes init:)
		(foFace init:)
		(foChest init:)
		(foHair init:)
		(foExit init:)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 95) ; oFlags
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 230 260 262)) ; ro230, ro260, ro262
			(gOMusic1 fadeOut:)
		)
		(if (not (OneOf newRoomNumber 210 220 230 250 260 261 262)) ; ro210, ro220, ro230, ro250, ro260, ro261, ro262
			(gOAmbience stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global341 0)
		(super dispose:)
	)
)

(instance soGoodbye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 86 0 0 self) ; "I'll see you around, Miss Peggy."
			)
			(1
				(gCurRoom newRoom: global219)
			)
		)
	)
)

(instance soPeggyIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(
						(and
							((ScriptID 64017 0) test: 177) ; oFlags
							((ScriptID 64017 0) test: 127) ; oFlags
						)
						(gMessager say: 1 101 4 0 self) ; "Hi, Miss Peggy. I'm back."
					)
					(((ScriptID 64017 0) test: 177) ; oFlags
						(gMessager say: 1 101 0 0 self) ; "Hello again, Miss Peggy."
					)
					(else
						((ScriptID 64017 0) set: 177) ; oFlags
						(gMessager say: 1 100 0 0 self) ; "Excuse me, Ma'am. May I bother you for a moment?"
					)
				)
			)
			(1
				(L7TalkWindow init: poPeggy global254)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLaugh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 5 20))
			)
			(1
				(client cel: 1 doit:)
				(= ticks (Random 5 20))
			)
			(2
				(client cel: 0 doit:)
				(self changeState: 0)
			)
		)
	)
)

(instance poPeggy of Prop
	(properties
		noun 1
		x 332
		y 468
		view 26100
	)

	(method (init)
		(super init:)
		(poPeggyMouth init:)
		(poPeggyEye init:)
		(AddDefaultVerbs self)
		(if
			(and
				((ScriptID 64017 0) test: 50) ; oFlags
				((ScriptID 64017 0) test: 95) ; oFlags
				((ScriptID 64017 0) test: 285) ; oFlags
			)
			(global254 add: 254)
		)
		(if
			(and
				((ScriptID 64017 0) test: 285) ; oFlags
				((ScriptID 64017 0) test: 288) ; oFlags
				(proc64040_5 global254 254)
			)
			(global254 add: 134)
		)
		(if
			(and
				((ScriptID 64017 0) test: 285) ; oFlags
				((ScriptID 64017 0) test: 309) ; oFlags
				((ScriptID 64017 0) test: 52) ; oFlags
			)
			(global254 add: 173)
		)
		(if ((ScriptID 64017 0) test: 29) ; oFlags
			(global254 add: 15)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(254 ; Break room
				(L7TalkWindow addTopic: 254)
				(if
					(and
						((ScriptID 64017 0) test: 285) ; oFlags
						((ScriptID 64017 0) test: 288) ; oFlags
					)
					(= local0 134)
				)
				(gMessager say: 1 254 0 0 self) ; "Peggy, I've been in that employees' break room and I didn't see a soul. It was completely deserted, as if no one works on this ship."
			)
			(171 ; Cabin boy
				((ScriptID 64017 0) set: 50) ; oFlags
				(L7TalkWindow addTopic: 171)
				(if
					(and
						((ScriptID 64017 0) test: 95) ; oFlags
						((ScriptID 64017 0) test: 285) ; oFlags
					)
					(= local0 254)
				)
				(gMessager say: 1 171 0 0 self) ; "So, where can I find a cabin boy, Peggy?"
			)
			(173 ; Combination
				(if ((ScriptID 64017 0) test: 54) ; oFlags
					(gMessager say: noun theVerb 5) ; "What was that combination again?"
				else
					((ScriptID 64017 0) set: 54) ; oFlags
					(super doVerb: theVerb)
				)
			)
			(134 ; Locker
				((ScriptID 64017 0) set: 52) ; oFlags
				(L7TalkWindow addTopic: 134)
				(if
					(and
						((ScriptID 64017 0) test: 285) ; oFlags
						((ScriptID 64017 0) test: 309) ; oFlags
					)
					(= local0 173)
				)
				(gMessager say: 1 134 0 0 self) ; "Which locker is Xqwzts in?"
			)
			(174 ; Peg leg
				((ScriptID 64017 0) set: 51) ; oFlags
				(super doVerb: theVerb)
			)
			(4 ; Talk
				(if (not (L7TalkWindow oPlane:))
					(gCurRoom setScript: soPeggyIntro)
				)
			)
			(167 ; Xqwzts
				(= local0 168)
				(L7TalkWindow addTopic: 167)
				((ScriptID 64017 0) set: 53) ; oFlags
				(gMessager say: 1 167 0 0 self) ; "So, Miss Peggy, would you tell me about Xqwzts?"
			)
			(169 ; Xqwzts's needs
				(= local0 170)
				(L7TalkWindow addTopic: 169)
				(gMessager say: 1 169 0 0 self) ; "Is there anything Xqwzts needs? Something I could give him to gain his favor?"
			)
			(170 ; Xqwzts's wants
				(global255 add: 122)
				(super doVerb: theVerb)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(switch local0
			(254
				((ScriptID 64040 2) addTopic: 254) ; L7TalkWindow
			)
			(173
				((ScriptID 64040 2) addTopic: 173) ; L7TalkWindow
			)
			(134
				((ScriptID 64040 2) addTopic: 134) ; L7TalkWindow
			)
			(168
				((ScriptID 64040 2) addTopic: 168 169) ; L7TalkWindow
			)
			(170
				((ScriptID 64040 2) addTopic: 170) ; L7TalkWindow
			)
		)
	)
)

(instance poPeggyMouth of Prop
	(properties
		noun 1
		x 332
		y 468
		priority 500
		fixPriority 1
		view 26100
		loop 1
	)

	(method (init)
		(super init:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(poPeggy doVerb: theVerb)
	)
)

(instance poPeggyEye of Prop
	(properties
		noun 1
		x 332
		y 468
		priority 550
		fixPriority 1
		view 26100
		loop 2
	)

	(method (init)
		(super init:)
		(self setCycle: Blink 90)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(poPeggy doVerb: theVerb)
	)
)

(instance foEyes of Feature
	(properties
		noun 2
		x 342
		y 600
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 281 166 314 156 363 157 403 176 401 193 392 213 362 212 354 194 327 194 317 207 298 213 283 200
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poPeggy doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(poPeggy doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foFace of Feature
	(properties
		noun 4
		x 328
		y 600
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 216 401 216 409 237 405 264 376 302 333 323 315 322 249 273 247 241
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poPeggy doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(poPeggy doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foChest of Feature
	(properties
		noun 3
		x 342
		y 500
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 347 459 347 476 370 483 398 476 420 439 437 382 423 311 422 290 434 249 440 217 421 201 373
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poPeggy doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(poPeggy doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foHair of Feature
	(properties
		noun 6
		x 313
		y 500
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 221 135 241 140 245 155 254 148 262 148 274 120 307 90 335 78 358 84 381 97 399 120 406 141 403 155 408 167 378 148 327 144 280 159 260 173 251 175 241 189 222 184 219 162 228 147
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poPeggy doVerb: theVerb)
			(return)
		)
		(switch theVerb
			(4 ; Talk
				(poPeggy doVerb: 4)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foExit of CUExitFeature
	(properties)

	(method (init)
		(= rExitTo global219)
		(super init:)
	)
)

(instance toPeggyTalker of Talker
	(properties
		x 332
		y 468
		priority 500
	)

	(method (init)
		(MouthSync oSpecialSync: coHandleLaugh)
		(MouthSync nSpecialSelector: 181)
		(super init: poPeggyTalkMouth)
		(poPeggyMouth hide:)
	)

	(method (dispose)
		(poLaugher dispose:)
		(poPeggyMouth show:)
		(super dispose:)
	)
)

(instance poPeggyTalkMouth of Prop
	(properties
		x 332
		y 468
		priority 500
		fixPriority 1
		view 26100
		loop 1
	)
)

(instance coHandleLaugh of CueMe
	(properties)

	(method (cue param1)
		(switch param1
			(8
				(poLaugher dispose:)
			)
			(9
				(poLaugher init:)
			)
		)
	)
)

(instance poLaugher of Prop
	(properties
		x 332
		y 468
		priority 600
		fixPriority 1
		view 26100
		loop 3
	)

	(method (init)
		(super init: &rest)
		(poPeggy hide:)
		(self setScript: soLaugh)
	)

	(method (dispose)
		(poPeggy show:)
		(super dispose: &rest)
	)
)

