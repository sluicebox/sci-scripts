;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use TPSound)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use ScrollView)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro302 0
)

(local
	local0
	local1
	local2 = 2
	local3
	local4
	local5
)

(instance ro302 of L7Room
	(properties
		picture 30200
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 30000)
		(= global330 0)
		(= global345 0)
		(= global336 toDrewRV)
		(poDrew init:)
		(if (not ((ScriptID 64017 0) test: 60)) ; oFlags
			(global250 add: 128)
		else
			(global250 delete: 128)
		)
		(if (and ((ScriptID 64017 0) test: 285) ((ScriptID 64017 0) test: 116)) ; oFlags, oFlags
			(global250 add: 177)
		)
		(if ((ScriptID 64017 0) test: 271) ; oFlags
			(global250 add: 124)
			(UnmarkTopic global250 124)
		)
		(voFernLeft init:)
		(if (not ((ScriptID 64017 0) test: 60)) ; oFlags
			(voEroticBook init:)
		)
		(voLotion init:)
		(if ((ScriptID 64017 0) test: 275) ; oFlags
			(voDrink init:)
		)
		(foBody init:)
		(foBreasts init:)
		(foFace init:)
		(foHair init:)
		(foLegs init:)
		(foLapTop init:)
		(foCUExit init:)
		(L7TalkWindow init: poDrew global250)
		(gGame handsOn:)
		(proc64896_15 2 0)
	)

	(method (doit)
		(if (and (gUser canControl:) (== plane oDrewRVPlane))
			(gCurRoom deleteRoomPlane: oDrewRVPlane)
		)
		(super doit: &rest)
	)

	(method (gimme)
		(gCurRoom setScript: soSuitcaseToLarrysRoom)
	)

	(method (dispose)
		(= global330 0)
		(= global336 0)
		(= global345 0)
		(gOSound1 stop:)
		(if (and (!= gNewRoomNum 300) ((ScriptID 64017 0) test: 274)) ; ro300, oFlags
			((ScriptID 64017 0) set: 275) ; oFlags
		)
		(super dispose: &rest)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 300) ; ro300
	)
)

(instance soMyPlace of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(L7TalkWindow dispose:)
				(if (gEgo has: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
					(ShowEasterEgg 1)
					(= ticks 180)
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom addRoomPlane: oDrewCUPlane)
				(gMessager say: 2 181 0 1 self) ; "I would really enjoy having a more "in-depth" discussion with you, Drew."
			)
			(2
				(gMessager sayRange: 2 181 0 2 5 self) ; "Really? Me too. In fact, I could Fokker all night long!"
				(oDrewCUPlane panTo: 0 200 0 5 1 1)
			)
			(3
				(if (gEgo has: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
					(poDrewCULips show: setCycle: RandCycle)
					(= cycles 1)
				else
					(gMessager say: 2 0 4 1 self) ; "Excuse me! Could you look me in the eyes?"
				)
			)
			(4
				(if (gEgo has: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
					(oDrewCUPlane panTo: 0 400 self 2 1 1)
				else
					(oDrewCUPlane panTo: 0 0 0 1)
					(gMessager say: 2 0 4 2 self) ; "(CAUGHT IN THE ACT) Sorry."
				)
			)
			(5
				(gCurRoom deleteRoomPlane: oDrewCUPlane)
				((ScriptID 64017 0) set: 273) ; oFlags
				(L7TalkWindow init: poDrew global250)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDrewTalksClothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oDrewRVPlane)
				(gMessager say: 2 176 0 0 self) ; "You don't have any clothing at all, do you, Drew?"
			)
			(1
				(gMessager say: 2 0 5 1 self) ; "This tropical sun is brutal. I hope you don't mind, but I need to spend a few minutes rubbing this sunscreen all over my naked body."
				(poLarryEyes setCycle: Blink 130)
			)
			(2
				(gMessager say: 2 0 5 2 self) ; "Need help?"
				(poLarryEyes setCycle: Blink 100)
			)
			(3
				(gMessager say: 2 0 5 3 self) ; "No, but nice try."
				(poLarryEyes setCycle: Blink 50)
			)
			(4
				(gMessager say: 2 0 5 4 self) ; "I really like the way it makes my skin glisten. The way it brings out the soft little hairs on the back of my neck, my arms, my..."
				(poLarryEyes setCycle: Blink 8)
			)
			(5
				(poLarryCod setCycle: End self)
				(gOSound1 playSound: 30301)
				(gMessager say: 2 0 5 5 self) ; "(INTERRUPTING) STOP! I can't take it!"
			)
			(6 0)
			(7
				(gMessager say: 2 0 5 6 self) ; "Aw. I didn't realize I was being "hard on" you."
				(poLarryCod setCycle: Beg self)
				(poLarryEyes setCycle: Blink 120)
			)
			(8 0)
			(9
				(if
					(or
						(not ((ScriptID 64017 0) test: 274)) ; oFlags
						(== 0 (Random 0 2))
					)
					(self setScript: soDrewDrink self)
				else
					(self cue:)
				)
			)
			(10
				(gCurRoom deleteRoomPlane: oDrewRVPlane)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDrewTalksFokker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(L7TalkWindow dispose:)
				(if (gEgo has: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
					(ShowEasterEgg 1)
					(= ticks 180)
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom addRoomPlane: oDrewCUPlane)
				(gMessager say: 2 177 0 1 self) ; "I've always been very fond of that wonderful German inventer, Anton Fokker. Have you ever heard of him?"
			)
			(2
				(gMessager say: 2 177 0 2 self) ; "Anton Fokker? But, of course. I wrote the book on him."
				(oDrewCUPlane panTo: 0 200 0 12 1 1)
			)
			(3
				(gMessager sayRange: 2 177 0 3 8 self) ; "So you HAVE heard of him."
			)
			(4
				(= ticks 75)
			)
			(5
				(if (gEgo has: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
					(poDrewCULips show: setCycle: RandCycle)
					(= cycles 1)
				else
					(gMessager say: 2 0 4 1 self) ; "Excuse me! Could you look me in the eyes?"
				)
			)
			(6
				(if (gEgo has: ((ScriptID 64037 0) get: 9)) ; oInvHandler, ioEarPlugs
					(oDrewCUPlane panTo: 0 400 self 2 1 1)
				else
					(oDrewCUPlane panTo: 0 0 0 1)
					(gMessager say: 2 0 4 2 self) ; "(CAUGHT IN THE ACT) Sorry."
				)
			)
			(7
				(gCurRoom deleteRoomPlane: oDrewCUPlane)
				((ScriptID 64017 0) set: 58) ; oFlags
				(L7TalkWindow init: poDrew global250)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soDrewTalksGeneral of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oDrewCUPlane)
				(gMessager say: local2 local1 local3 0 self)
			)
			(1
				(gCurRoom deleteRoomPlane: oDrewCUPlane)
				(gGame handsOn:)
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
				(gGame handsOff:)
				(gMessager say: 2 86 0 1 self) ; "Drew, I'm gonna go now."
			)
			(1
				(if ((ScriptID 64017 0) test: 278) ; oFlags
					(gMessager sayRange: 2 86 0 2 3 self) ; "Okay. Maybe we'll be seeing more of each other soon."
				else
					(gMessager say: 2 86 2 1 self) ; "Okay."
				)
			)
			(2
				(gCurRoom newRoom: 300) ; ro300
			)
		)
	)
)

(instance soWhySuitcase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 124 0 1 self) ; "Drew! I've got your suitcase."
			)
			(1
				(gMessager sayRange: 2 124 10 2 3 self) ; "Why?"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soSuitcaseToLarrysRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom addRoomPlane: oDrewCUPlane)
				(gMessager say: 2 124 0 0 self) ; "Drew! I've got your suitcase."
			)
			(1
				((ScriptID 64017 0) set: 185) ; oFlags
				((ScriptID 64017 0) set: 56) ; oFlags
				(CopyWinningWallpaper 2)
				(gCurRoom newRoom: 300) ; ro300
			)
		)
	)
)

(instance soTakeBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 128 0 0 self) ; "Drew, would you mind if I borrowed your book?"
			)
			(1
				(voEroticBook dispose:)
				(RemoveTopic global250 128)
				(gEgo get: ((ScriptID 64037 0) get: 10)) ; oInvHandler, ioEroticBook
				((ScriptID 64017 0) set: 60) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTalkClothing of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 176 0 0 self) ; "You don't have any clothing at all, do you, Drew?"
			)
			(1
				(if
					(or
						(not ((ScriptID 64017 0) test: 274)) ; oFlags
						(== 0 (Random 0 2))
					)
					(self setScript: soDrewDrink self)
				else
					(self cue:)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oPlayerVoice of TPSound
	(properties
		type 2
	)
)

(instance soDrewDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom addRoomPlane: oDrewCUPlane)
				(gMessager say: 0 0 1 1 self) ; "Excuse me, Larry. Here comes a waiter. This'll just take a second. (OFF MIKE & LOUDER) Waiter. Oh, waiter!"
			)
			(1
				(if (proc64896_21 1)
					(oPlayerVoice playSubtitledSound: 1 0 0 1 2 self)
				else
					(gMessager say: 0 0 1 2 self) ; "Hello, beautiful! What can I do for you?"
				)
			)
			(2
				(gMessager say: 0 0 1 3 self) ; "I want a "gigantic erection.""
			)
			(3
				(if (proc64896_21 2)
					(oPlayerVoice playSubtitledSound: 2 0 0 1 4 self)
				else
					(gMessager say: 0 0 1 4 self) ; "Looks like your little buddy there has got ya covered!"
				)
			)
			(4
				(gMessager say: 0 0 1 5 self) ; "What? I said, "bring me a gigantic erection!""
			)
			(5
				(if (proc64896_21 3)
					(oPlayerVoice playSubtitledSound: 3 0 0 1 6 self)
				else
					(gMessager say: 0 0 1 6 self) ; "(COMING ON STRONGER) Well, okay, baby. I'm your man!"
				)
			)
			(6
				(gMessager say: 0 0 1 7 self) ; "Well, where is it?"
			)
			(7
				(if (proc64896_21 4)
					(oPlayerVoice playSubtitledSound: 4 0 0 1 8 self)
				else
					(gMessager say: 0 0 1 8 self) ; "I'm working on it. You mind moving that computer?"
				)
			)
			(8
				(gMessager say: 0 0 1 9 self) ; "Look. I want a mixed drink. A cocktail. You know, lime juice, 151-proof rum, vodka, triple sec, mayonnaise, with a hollowed-out frozen banana to suck through. You know: a "gigantic erection.""
			)
			(9
				(if (proc64896_21 5)
					(oPlayerVoice playSubtitledSound: 5 0 0 1 10 self)
				else
					(gMessager say: 0 0 1 10 self) ; "Oh. Okay, but it'll take a while, you know."
				)
			)
			(10
				(global250 add: 179)
				((ScriptID 64017 0) set: 274) ; oFlags
				(gCurRoom deleteRoomPlane: oDrewCUPlane)
				(self dispose:)
			)
		)
	)
)

(instance soLarryDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 179 0 1 self) ; "I think I'll have a drink myself. (TO OFF-SCREEN WAITER) Oh, waiter. I want the same thing the lady ordered."
			)
			(1
				(if (proc64896_21 7)
					(oPlayerVoice playSubtitledSound: 7 2 179 0 2 self)
				else
					(gMessager say: 2 179 0 2 self) ; "(SARCASTICALLY) Nice suit."
				)
			)
			(2
				(gMessager say: 2 179 0 3 self) ; "(THINKS HE DIDN'T HEAR) No, please bring me a "gigantic erection.""
			)
			(3
				(if (proc64896_21 8)
					(oPlayerVoice playSubtitledSound: 8 2 179 0 4 self)
				else
					(gMessager say: 2 179 0 4 self) ; "Oh, that'll take a while for the bartender to fix. Wait right here."
				)
			)
			(4
				(if ((ScriptID 64017 0) test: 285) ; oFlags
					(global258 add: 236)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poLarryCod of Prop
	(properties
		x 169
		y 307
		view 30400
		loop 2
	)

	(method (init)
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
	)
)

(instance voLotion of View
	(properties
		noun 11
		x 120
		y 340
		priority 90
		fixPriority 1
		view 30204
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance voDrink of View
	(properties
		noun 3
		x 120
		y 340
		priority 95
		fixPriority 1
		view 30204
		loop 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(49 ; Orgasmic Powder
				(= local5 1)
				(gMessager say: 0 67 4 1 0 16) ; "Do you have a "drinking problem?""
			)
			(67 ; Drink
				(if local5
					((ScriptID 64017 0) set: 301) ; oFlags
					(ShowEasterEgg)
					(gMessager say: 0 10 5 1 0 16) ; "You led a troubled, lonely childhood, didn't you?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(88 ; Suck
				(if local5
					((ScriptID 64017 0) set: 301) ; oFlags
					(ShowEasterEgg)
					(gMessager say: 0 10 5 1 0 16) ; "You led a troubled, lonely childhood, didn't you?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voEroticBook of View
	(properties
		noun 1
		x 120
		y 340
		priority 100
		fixPriority 1
		view 30204
		loop 2
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)
)

(instance voRVLotion of View
	(properties
		noun 11
		x 350
		y 250
		priority 425
		fixPriority 1
		view 30402
	)
)

(instance voRVDrink of View
	(properties
		noun 3
		x 350
		y 250
		priority 423
		fixPriority 1
		view 30402
		loop 1
	)
)

(instance voRVEroticBook of View
	(properties
		noun 1
		x 350
		y 250
		priority 420
		fixPriority 1
		view 30402
		loop 2
	)
)

(instance voWow of View
	(properties
		x 280
		y 960
		view 30300
		loop 2
	)
)

(instance voFernLeft of View
	(properties
		noun 10
		y 479
		priority 500
		fixPriority 1
		view 30299
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 152 64)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(160 ; Push
				(= local4 1)
				(= y 505)
				(self doit:)
				((ScriptID 64017 0) set: 307) ; oFlags
				(ShowEasterEgg)
				(oShortSound playSound: 103)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance oShortSound of TPSound
	(properties
		type 2
	)
)

(instance voFernRight of View
	(properties
		x 639
		y 479
		priority 500
		fixPriority 1
		view 30499
	)

	(method (init)
		(if local4
			(= y 516)
		)
		(super init: &rest)
	)
)

(instance foBody of Feature
	(properties
		noun 6
		x 229
		y 310
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 227 306 230 288 240 267 248 256 269 237 253 220 251 207 258 191 259 177 243 173 218 186 198 187 189 189 202 207 208 220 208 230 203 255 196 274 199 284 203 293
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poDrew doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance foBreasts of Feature
	(properties
		noun 7
		x 231
		y 320
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 243 171 260 178 272 170 277 160 268 148 252 141 241 137 227 144 211 144 190 150 185 161 189 173 201 183 223 185 230 177 238 167 246 173
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poDrew doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance foFace of Feature
	(properties
		noun 4
		x 213
		y 72
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 213 103 217 102 221 96 228 85 230 75 229 71 233 60 236 54 222 41 219 45 205 49 194 53 190 69 191 79 198 94 207 102
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poDrew doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance foHair of Feature
	(properties
		noun 5
		x 205
		y 58
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 109 188 96 188 80 196 87 199 82 190 75 192 60 194 52 218 45 223 42 235 51 237 53 231 64 230 68 229 75 229 79 238 71 246 59 243 49 238 34 225 17 210 7 201 10 190 19 179 26 173 37 170 55 165 62 164 76 171 88 173 92 164 101 171 106 177 109
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poDrew doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance foLegs of Feature
	(properties
		noun 8
		x 386
		y 320
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 520 360 520 360 531 353 535 351 534 343 529 343 521 334 520 328 512 328 497 315 481 303 454 287 423 263 392 235 384 227 380 218 365 212 340 221 321 233 313 241 292 241 264 248 249 254 243 261 237 286 241 300 249 308 275 306 293 295 332 281 345 281 354 283 368 297 388 310 407 317 434 321 459 330 457 335 459 343 465 345 480 348 488 351 495 358 507 358
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poDrew doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance foLapTop of Feature
	(properties
		noun 9
		x 290
		y 400
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 317 239 333 203 324 198 286 203 273 238 248 243 248 251 257 251 277 244 297 240 316 239
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 152 8)
	)
)

(instance poDrew of Prop
	(properties
		noun 2
		x 227
		y 308
		view 30200
	)

	(method (init)
		(super init: &rest)
		(poDrewHead init:)
		(poDrewArm init: setCycle: Fwd)
		(poDrewEyes init:)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(47 ; Kumquats
				(gEgo put: ((ScriptID 64037 0) get: 17)) ; oInvHandler, ioKumquat
				((ScriptID 64017 0) clear: 49) ; oFlags
				(super doVerb: theVerb &rest)
			)
			(176 ; Clothing
				(L7TalkWindow addTopic: 176)
				(global254 add: 171)
				(global255 add: 171)
				(gCurRoom setScript: soDrewTalksClothing)
			)
			(85 ; Sex
				(L7TalkWindow addTopic: 85)
				(gMessager say: 2 252 0 0) ; "I guess I don't have to tell you. I'm kind of a lonely guy."
			)
			(179 ; Drink
				(L7TalkWindow addTopic: 236)
				(L7TalkWindow addTopic: 179)
				(gCurRoom setScript: soLarryDrink)
			)
			(128 ; Your book
				(if ((ScriptID 64017 0) test: 60) ; oFlags
					(super doVerb: 70)
					(return)
				)
				(if
					(and
						((ScriptID 64017 0) test: 157) ; oFlags
						((ScriptID 64017 0) test: 33) ; oFlags
					)
					(gCurRoom setScript: soTakeBook)
				else
					(gMessager say: 2 128 11) ; "Drew, would you mind if I borrowed your book?"
				)
			)
			(177 ; Fokker
				(L7TalkWindow addTopic: 177 127)
				(gCurRoom setScript: soDrewTalksFokker)
			)
			(127 ; Anton Fokker
				(L7TalkWindow addTopic: 127 180)
				((ScriptID 64017 0) set: 58) ; oFlags
				(super doVerb: theVerb &rest)
			)
			(180 ; Anton's Fame
				(L7TalkWindow addTopic: 180 181)
				((ScriptID 64017 0) set: 58) ; oFlags
				(super doVerb: theVerb &rest)
			)
			(181 ; My place?
				(L7TalkWindow addTopic: 250)
				(if (not ((ScriptID 64017 0) test: 58)) ; oFlags
					(super doVerb: 70)
				else
					(gCurRoom setScript: soMyPlace)
				)
			)
			(250 ; You can't?
				(if (not ((ScriptID 64017 0) test: 273)) ; oFlags
					(super doVerb: 70)
				else
					(L7TalkWindow addTopic: 250)
					((ScriptID 64017 0) set: 278) ; oFlags
					(global254 add: 171)
					(global255 add: 171)
					(super doVerb: theVerb &rest)
				)
			)
			(124 ; Suitcase
				(L7TalkWindow addTopic: 124)
				(cond
					(((ScriptID 64017 0) test: 273) ; oFlags
						(if ((ScriptID 64017 0) test: 271) ; oFlags
							(gCurRoom setScript: soSuitcaseToLarrysRoom)
						else
							(gMessager say: 2 124 9 0) ; "So you want me to bring you your suitcase?"
						)
					)
					(((ScriptID 64017 0) test: 271) ; oFlags
						(gCurRoom setScript: soWhySuitcase)
					)
					(else
						(gMessager say: 2 124 10 0) ; "Do you have an old suitcase I could borrow?"
					)
				)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poDrewHead of Prop
	(properties
		noun 2
		x 227
		y 308
		view 30200
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: (+ (poDrew priority:) 1))
	)
)

(instance poDrewArm of Prop
	(properties
		noun 2
		x 235
		y 311
		view 30200
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: (+ (poDrew priority:) 1))
	)
)

(instance poDrewEyes of Prop
	(properties)

	(method (init)
		(= view (poDrew view:))
		(= loop (+ (poDrew loop:) 3))
		(= x (poDrew x:))
		(= y (poDrew y:))
		(self setPri: (+ (poDrew priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 200)
	)

	(method (show)
		(= view (poDrew view:))
		(= x (poDrew x:))
		(= y (poDrew y:))
		(super show: &rest)
		(self setCycle: Blink 200)
	)
)

(instance poDrewRV of Prop
	(properties
		noun 2
		x 460
		y 340
		priority 500
		fixPriority 1
		view 30401
	)

	(method (init)
		(super init: &rest)
		(poDrewRVEyes init:)
	)
)

(instance voDrewRVMouth of View
	(properties)

	(method (init)
		(= view (poDrewRV view:))
		(= loop (+ (poDrewRV loop:) 1))
		(= x (poDrewRV x:))
		(= y (poDrewRV y:))
		(self setPri: (+ (poDrewRV priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poDrewRV view:))
		(= loop (+ (poDrewRV loop:) 1))
		(= x (poDrewRV x:))
		(= y (poDrewRV y:))
		(self setPri: (+ (poDrewRV priority:) 1))
		(super show: &rest)
	)
)

(instance poDrewRVEyes of Prop
	(properties)

	(method (init)
		(= view (poDrewRV view:))
		(= loop (+ (poDrewRV loop:) 2))
		(= x (poDrewRV x:))
		(= y (poDrewRV y:))
		(self setPri: (+ (poDrewRV priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 150)
	)

	(method (show)
		(= view (poDrewRV view:))
		(= x (poDrewRV x:))
		(= y (poDrewRV y:))
		(super show: &rest)
		(self setCycle: Blink 150)
	)
)

(instance poDrewCU of Prop
	(properties
		noun 2
		x 280
		y 480
		priority 500
		fixPriority 1
		view 30300
	)

	(method (init)
		(super init: &rest)
		(poDrewCUEyes init:)
	)
)

(instance voDrewCUMouth of View
	(properties)

	(method (init)
		(= view (poDrewCU view:))
		(= loop (+ (poDrewCU loop:) 1))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(self setPri: (+ (poDrewCU priority:) 2))
		(super init: &rest)
	)

	(method (show)
		(= view (poDrewCU view:))
		(= loop (+ (poDrewCU loop:) 1))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(self setPri: (+ (poDrewCU priority:) 2))
		(super show: &rest)
	)
)

(instance toDrewCU of Talker
	(properties)

	(method (init)
		(= view (poDrewCU view:))
		(= loop (+ (poDrewCU loop:) 1))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(= priority (+ (poDrewCU priority:) 2))
		(voDrewCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voDrewCUMouth show:)
		(super dispose: &rest)
	)
)

(instance poDrewCUEyes of Prop
	(properties)

	(method (init)
		(= view (poDrewCU view:))
		(= loop (+ (poDrewCU loop:) 3))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(self setPri: (+ (poDrewCU priority:) 1))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 170)
	)

	(method (show)
		(= view (poDrewCU view:))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(super show: &rest)
		(self setCycle: Blink 170)
	)
)

(instance poDrewCULips of Prop
	(properties)

	(method (init)
		(= view (poDrewCU view:))
		(= loop (+ (poDrewCU loop:) 1))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(self setPri: (+ (poDrewCU priority:) 2))
		(super init: &rest)
	)

	(method (show)
		(= view (poDrewCU view:))
		(= loop (+ (poDrewCU loop:) 1))
		(= x (poDrewCU x:))
		(= y (poDrewCU y:))
		(self setPri: (+ (poDrewCU priority:) 2))
		(super show: &rest)
	)
)

(instance poLarry of Prop
	(properties
		x 125
		y 397
		view 30400
	)
)

(instance voLarry of View
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super init: &rest)
		(poLarryEyes init:)
	)

	(method (show)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 1))
		(super show: &rest)
	)
)

(instance toLarry of Talker
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 1))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(= priority (+ (poLarry priority:) 1))
		(voLarry hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarry show:)
		(super dispose: &rest)
	)
)

(instance poLarryEyes of Prop
	(properties)

	(method (init)
		(= view (poLarry view:))
		(= loop (+ (poLarry loop:) 3))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(self setPri: (+ (poLarry priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 170)
	)

	(method (show)
		(= view (poLarry view:))
		(= x (poLarry x:))
		(= y (poLarry y:))
		(super show: &rest)
		(self setCycle: Blink 170)
	)
)

(instance oDrewCUPlane of ScrollPlane
	(properties
		picture 30300
		priority 20
	)

	(method (init)
		(if (L7TalkWindow oPlane:)
			(L7TalkWindow dispose:)
		)
		(super init: 640 960 &rest)
		(poDrewCU x: 280 y: 480 init:)
		(voDrewCUMouth init:)
		(voWow init:)
		(= global336 toDrewCU)
	)

	(method (dispose)
		(= global330 0)
		(= global336 toDrewRV)
		(poDrewCU dispose:)
		(voDrewCUMouth dispose:)
		(super dispose: &rest)
		(L7TalkWindow init: poDrew global250)
	)
)

(instance oDrewRVPlane of Plane
	(properties
		picture 30400
		priority 20
	)

	(method (init)
		(if (L7TalkWindow oPlane:)
			(L7TalkWindow dispose:)
		)
		(super init: 0 0 639 479 &rest)
		(voFernRight init:)
		(poLarry init:)
		(voLarry init:)
		(poLarryCod init:)
		(= global330 toLarry)
		(voRVLotion init:)
		(if ((ScriptID 64017 0) test: 275) ; oFlags
			(voRVDrink init:)
		)
		(if (not ((ScriptID 64017 0) test: 60)) ; oFlags
			(voRVEroticBook init:)
		)
		(poDrewRV init:)
		(voDrewRVMouth init:)
	)

	(method (dispose)
		(= global330 0)
		(super dispose: &rest)
		(L7TalkWindow init: poDrew global250)
	)
)

(instance toDrewRV of Talker
	(properties)

	(method (init)
		(if (!= (gCurRoom plane:) oDrewRVPlane)
			(gCurRoom addRoomPlane: oDrewRVPlane)
		)
		(= view (poDrewRV view:))
		(= loop (+ (poDrewRV loop:) 1))
		(= x (poDrewRV x:))
		(= y (poDrewRV y:))
		(= priority (+ (poDrewRV priority:) 1))
		(voDrewRVMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voDrewRVMouth show:)
		(super dispose: &rest)
	)
)

