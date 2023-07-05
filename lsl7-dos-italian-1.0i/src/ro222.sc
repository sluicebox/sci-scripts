;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 222)
(include sci.sh)
(use Main)
(use TPSound)
(use oInvHandler)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro222 0
)

(local
	local0
	local1
)

(procedure (localproc_0) ; UNUSED
	(poLarryArm cel: 1)
	(if (poLarryArm plane:)
		(poLarryArm doit:)
	)
)

(procedure (localproc_1) ; UNUSED
	(poLarryArm cel: 0)
	(if (poLarryArm plane:)
		(poLarryArm doit:)
	)
)

(procedure (localproc_2 param1 &tmp temp0)
	(if argc
		(= temp0 param1)
	else
		(= temp0 0)
	)
	(poLarryArm hide:)
	(voLarryMouth hide:)
	(if (poLarry plane:)
		(poLarry loop: 2 cel: 0 cycleSpeed: 15 setCycle: End temp0)
	else
		(poLarry loop: 2 cel: 2)
		(if temp0
			(temp0 cue:)
		)
	)
)

(procedure (localproc_3 param1 &tmp temp0)
	(if argc
		(= temp0 param1)
	else
		(= temp0 0)
	)
	(if (poLarry plane:)
		(poLarry setScript: soLarryLookUp temp0)
	else
		(poLarry loop: 0 cel: 0)
		(poLarryArm show:)
		(voLarryMouth show:)
		(if temp0
			(temp0 cue:)
		)
	)
)

(procedure (localproc_4)
	(poThyghArms setCycle: End)
)

(procedure (localproc_5)
	(poThyghArms setCycle: Beg)
)

(instance ro222 of L7Room
	(properties
		picture 22800
	)

	(method (init)
		(super init:)
		(gOMusic1 setMusic: 0)
		(oNature setAmbient: 22301)
		(poThygh init:)
		(poThyghEyes init:)
		(voThyghMouth init:)
		(poThyghArms init:)
		(= global332 toThygh)
		(poLarry init:)
		(voLarryMouth init:)
		(poLarryArm init:)
		(= global330 toLarry)
		(foCUExit init:)
		(foFace init:)
		(foTits init:)
		(foLips init:)
		(foBody init:)
		(foLegs init:)
		(gGame handsOn:)
		(if (not ((ScriptID 64017 0) test: 29)) ; oFlags
			(voLarryMouth hide:)
			(poLarryArm hide:)
			(poLarry cel: 2 loop: 2 doit:)
		)
		(gCurRoom setScript: soThyghIntro)
	)

	(method (dispose)
		(= global332 0)
		(= global330 0)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 44)) ; oInvHandler, ioStock
	)
)

(instance oNature of TPSound
	(properties)
)

(instance poThygh of Prop
	(properties
		noun 1
		x 212
		y 255
		view 22802
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(164 ; Ennui
				(L7TalkWindow addTopic: 165)
				(super doVerb: theVerb &rest)
			)
			(165 ; But I won!
				(L7TalkWindow addTopic: 165)
				(L7TalkWindow addTopic: 166)
				(gCurRoom setScript: soTalkButIWon)
			)
			(166 ; Life
				(L7TalkWindow addTopic: 66)
				(super doVerb: theVerb &rest)
			)
			(66 ; Sex Fatigue
				(L7TalkWindow addTopic: 247)
				(super doVerb: theVerb &rest)
			)
			(85 ; Sex
				(L7TalkWindow addTopic: 85)
				(gMessager say: 1 110 0 0) ; "But I thought you just automatically had sex with every guy who won your contest?!"
			)
			(162 ; Excited
				(L7TalkWindow addTopic: 163)
				(super doVerb: theVerb &rest)
			)
			(163 ; Free ticket
				(L7TalkWindow addTopic: 164)
				(super doVerb: theVerb &rest)
			)
			(86 ; Goodbye
				(gCurRoom setScript: soGoodbye)
			)
			(59 ; Stock Certificate
				(gCurRoom setScript: soWinThatGame)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance voThyghMouth of View
	(properties
		priority 310
		x 212
		y 255
		loop 1
		view 22802
		fixPriority 1
	)
)

(instance poThyghEyes of Prop
	(properties
		priority 310
		x 212
		y 255
		loop 3
		view 22802
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 100)
	)
)

(instance poThyghArms of Prop
	(properties
		noun 1
		priority 310
		x 212
		y 255
		loop 2
		view 22802
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(poThygh doVerb: theVerb &rest)
	)
)

(instance toThygh of Talker
	(properties
		priority 310
		x 212
		y 255
		loop 1
		view 22802
	)

	(method (init)
		(voThyghMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voThyghMouth show:)
		(super dispose: &rest)
	)
)

(instance voThygh2Mouth of View
	(properties
		priority 310
		x 213
		y 254
		loop 1
		view 22803
		fixPriority 1
	)
)

(instance poThygh2Eyes of Prop
	(properties
		priority 310
		x 213
		y 254
		loop 2
		view 22803
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 100)
	)
)

(instance toThygh2 of Talker
	(properties
		priority 310
		x 213
		y 254
		loop 1
		view 22803
	)

	(method (init)
		(voThygh2Mouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voThygh2Mouth show:)
		(super dispose: &rest)
	)
)

(instance poLarry of Prop
	(properties
		x 451
		y 455
		view 22800
	)
)

(instance voLarryMouth of View
	(properties
		priority 456
		x 451
		y 455
		loop 1
		view 22800
		fixPriority 1
	)
)

(instance poLarryArm of Prop
	(properties
		priority 457
		x 451
		y 455
		loop 3
		view 22800
		fixPriority 1
	)
)

(instance toLarry of Talker
	(properties
		priority 456
		x 451
		y 455
		loop 1
		view 22800
	)

	(method (init)
		(voLarryMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryMouth show:)
		(super dispose: &rest)
	)
)

(instance poCertificate of Prop
	(properties
		priority 454
		x 451
		y 455
		loop 1
		view 22801
		fixPriority 1
	)
)

(instance soLarryLookUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLarry loop: 2 cel: 2 cycleSpeed: 15 setCycle: Beg self)
			)
			(1
				(poLarry loop: 0 cel: 0)
				(poLarryArm show:)
				(voLarryMouth show:)
				(self dispose:)
			)
		)
	)
)

(instance soThyghIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if ((ScriptID 64017 0) test: 29) ; oFlags
					(gMessager say: 1 101 0 0 self) ; "I'm back!"
				else
					((ScriptID 64017 0) set: 29) ; oFlags
					(self setScript: soIntro1 self)
				)
			)
			(1
				(L7TalkWindow init: poThygh global253)
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
				(gMessager say: 1 86 0 0 self) ; "I just remembered... I've got a meeting. Bye bye."
			)
			(1
				(gCurRoom newRoom: 220) ; ro220
			)
		)
	)
)

(instance soIntro1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 100 0 1 self) ; "There's been some terrible error. I was told the winner of my competition was one "Larry Laffer.""
				(= cycles 1)
			)
			(1
				(= ticks 60)
			)
			(2
				(localproc_3 self)
			)
			(3)
			(4
				(gMessager say: 1 100 0 2 self) ; "Oh, that's me, all righty!"
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soTalkButIWon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 165 0 1 self) ; "But, how can you change the rules now? I thought I'd won the game!"
			)
			(1
				(localproc_4)
				(gMessager say: 1 165 0 2 self) ; "After seeing you, Larry Laffer, suddenly I expect something more. And besides, I always say "a man should give before he gets.""
				(= cycles 1)
			)
			(2
				(= ticks 45)
			)
			(3
				(localproc_2 self)
			)
			(4)
			(5
				(localproc_5)
				(localproc_3 self)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWinThatGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 28) ; oFlags
				(gMessager sayRange: 1 59 0 1 5 self) ; "You know, Cappy, I just might be the boy who makes your dreams come true."
			)
			(1
				(= local0 1)
				(gMessager say: 1 59 0 6 coDoneTalking) ; "God, how crude!"
				(voLarryMouth hide:)
				(poLarryArm hide:)
				(poLarry
					view: 22801
					loop: 0
					cel: 0
					cycleSpeed: 7
					doit:
					setCycle: CycleCueList 4 1 self 4
				)
			)
			(2
				(poCertificate cel: 0 init: setCycle: End self)
			)
			(3
				(if local0
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(poThyghArms dispose:)
				(poThyghEyes dispose:)
				(voThyghMouth dispose:)
				(poThygh
					view: 22803
					loop: 3
					cel: 0
					posn: 213 254
					cycleSpeed: 9
					doit:
					setCycle: End self 8
				)
			)
			(5
				(poCertificate dispose:)
				(poLarry setCycle: End self)
			)
			(6
				(poLarry view: 22800 loop: 0 cel: 0 doit:)
				(voLarryMouth show:)
				(poLarryArm show:)
				(gMessager say: 1 59 0 7 self) ; "Yep, crude it is! Crude OIL shipping."
			)
			(7
				(poThygh2Eyes init:)
				(voThygh2Mouth init:)
				(poThygh loop: 0 cel: 0 doit:)
				(= global332 toThygh2)
				(gMessager sayRange: 1 59 0 8 12 self) ; "(SOTTE VOCE) Well, I'll be damned! (TO LARRY) Does this say what I think it says? That you're..."
			)
			(8
				(= global332 0)
				(= global330 0)
				(L7TalkWindow dispose:)
				(gCurRoom addRoomPlane: oClamClosePlane)
				(gMessager sayRange: 1 59 0 13 13 self) ; "Well, I AM looking for someone to "fill a position directly under me!""
			)
			(9
				((ScriptID 64017 0) set: 305) ; oFlags
				(gOMusic1 playSound: 22302)
				(gMessager sayRange: 1 59 0 14 14 self) ; "(SMILES HER CONSENT) Mmmmm."
			)
			(10
				(= global332 0)
				(= global330 0)
				(gCurRoom addRoomPlane: oClamClosePlane)
				(poClam cycleSpeed: 15 setCycle: End self)
			)
			(11
				(gMessager sayRange: 1 59 0 15 15 self) ; "(SOFTLY, SEXY) Oh, Larry."
			)
			(12
				(gMessager say: 1 59 0 18 self) ; "Although I truly appreciate opera, do you mind putting on some of MY music?"
			)
			(13
				(= local1 1)
				(gOMusic1 playSound: 15000)
				(= cycles 1)
			)
			(14
				(= ticks 120)
			)
			(15
				(poClam loop: 1 cel: 0 cycleSpeed: 10 setCycle: Fwd)
				(= ticks 60)
			)
			(16
				(gMessager sayRange: 1 59 0 16 17 self) ; "(APPROACHING NIRVANA) Oh, baby! You're the GREATest! This has got to be the BEST night of my life!!"
			)
			(17
				(proc64896_1 1 5 self)
			)
			(18
				(CopyWinningWallpaper 6)
				(gCurRoom newRoom: 150) ; ro150
			)
		)
	)
)

(instance oClamClosePlane of Plane
	(properties)

	(method (init)
		(= picture 22200)
		(Palette 1 225) ; PalLoad
		(super init: 0 0 639 479)
		(poClam cel: 0 loop: 0 init:)
	)
)

(instance poClam of Prop
	(properties
		x 203
		y 78
		view 22500
	)
)

(instance coMusicDone of CueMe ; UNUSED
	(properties)

	(method (cue)
		(= local1 0)
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local0 0)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom newRoom: 220) ; ro220
	)
)

(instance foFace of Feature
	(properties
		noun 5
		x 201
		y 256
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 188 148 186 121 191 117 217 123 213 137 213 150 202 158
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poThygh doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foLips of Feature
	(properties
		noun 7
		x 204
		y 257
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 200 148 205 144 209 148 206 153 201 153
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poThygh doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foBody of Feature
	(properties
		noun 6
		x 204
		y 258
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 172 213 168 228 184 240 220 226 254 230 276 218 286 173 301 168 283 181 264 197 250 184 225 179 217
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poThygh doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foLegs of Feature
	(properties
		noun 4
		x 204
		y 258
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 218 287 243 279 295 316 290 334 204 371 167 395 167 377 114 409 114 390 132 372 146 375 187 341 204 332 209 328 182 313 199 296 215 289
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poThygh doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance foTits of Feature
	(properties
		noun 2
		x 224
		y 259
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 192 201 208 191 234 188 250 188 257 200 253 217 239 219 209 229 192 217
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(if (proc64037_3 theVerb)
			(poThygh doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

