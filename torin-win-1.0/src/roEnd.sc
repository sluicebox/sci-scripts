;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51400)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPSound)
(use SoTwinkle)
(use CueMe)
(use n64896)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	roEnd 0
	toPa 1
	toMa 2
)

(local
	bTorinMouth
	bLycentiaMouth
	bPecandMouth
	lTorinMouth = -1
	lLycentiaMouth = -1
	lPecandMouth = -1
	curScript
)

(procedure (roomMusic nSound nLoop cue &tmp whoCue)
	(if (< argc 3)
		(= whoCue 0)
	else
		(= whoCue cue)
	)
	(oRoomMusic newSound: nSound setLoop: nLoop play: gMusicVol whoCue)
)

(instance oOtherSound of TPSound
	(properties)
)

(instance oRoomMusic of TPSound
	(properties
		type 1
	)
)

(instance poNull69 of Prop
	(properties)
)

(instance poTorin of Prop
	(properties
		x 275
		y 157
		view 51400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; ioBagpipes
				(poNull69 setScript: soBagpipes)
			)
		)
	)
)

(instance poTorinMouth of Prop
	(properties)

	(method (init)
		(= view (poTorin view:))
		(= loop (+ (poTorin loop:) 1))
		(= cel 0)
		(= x (poTorin x:))
		(= y (poTorin y:))
		(= priority (+ (poTorin priority:) 1))
		(= bTorinMouth 1)
		(super init: &rest)
	)

	(method (dispose)
		(= bTorinMouth 0)
		(super dispose:)
	)
)

(instance toTorin of Talker
	(properties)

	(method (init)
		(= view (poTorin view:))
		(if (!= -1 lTorinMouth)
			(= loop lTorinMouth)
		else
			(= loop (+ (poTorin loop:) 1))
		)
		(= cel 0)
		(= x (poTorin x:))
		(= y (poTorin y:))
		(= priority (+ (poTorin priority:) 1))
		(super init: &rest)
		(if bTorinMouth
			(poTorinMouth hide:)
		)
	)

	(method (dispose)
		(if bTorinMouth
			(poTorinMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance poLycentiaCollar of Prop
	(properties
		x 449
		y 252
		priority 1
		fixPriority 1
		view 51462
	)

	(method (init)
		(if (== (gCurRoom picture:) 51401)
			(= view 51462)
			(= x 449)
			(= y 252)
		else
			(= view 51463)
			(= x 537)
			(= y 249)
		)
		(super init: &rest)
	)
)

(instance poLycentia of Prop
	(properties
		x 538
		y 314
		view 51465
	)

	(method (cue)
		(goSound1 playSound: 51436)
		(self setCycle: End)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; ioMagicBook
				(self deleteHotspotVerb: 62)
				(soCartoon cue:)
			)
			(63 ; ioBagpipes
				(poNull69 setScript: soBagpipes)
			)
		)
	)
)

(instance poLycentiaMouth of Prop
	(properties)

	(method (init)
		(= view (poLycentia view:))
		(= loop (+ (poLycentia loop:) 1))
		(= cel 0)
		(= x (poLycentia x:))
		(= y (poLycentia y:))
		(= priority (+ (poLycentia priority:) 1))
		(= bLycentiaMouth 1)
		(super init: &rest)
	)

	(method (dispose)
		(= bLycentiaMouth 0)
		(super dispose:)
	)
)

(instance toLycentia of Talker
	(properties)

	(method (init)
		(= view (poLycentia view:))
		(if (!= -1 lLycentiaMouth)
			(= loop lLycentiaMouth)
		else
			(= loop (+ (poLycentia loop:) 1))
		)
		(= cel 0)
		(= x (poLycentia x:))
		(= y (poLycentia y:))
		(= priority (+ (poLycentia priority:) 1))
		(super init: &rest)
		(if bLycentiaMouth
			(poLycentiaMouth hide:)
		)
	)

	(method (dispose)
		(if bLycentiaMouth
			(poLycentiaMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance poPecandMouth of Prop
	(properties)

	(method (init)
		(= view (poPecand view:))
		(= cel 0)
		(= loop (+ (poPecand loop:) 1))
		(= x (poPecand x:))
		(= y (poPecand y:))
		(= priority (+ (poPecand priority:) 1))
		(super init: &rest)
		(= bPecandMouth 1)
	)

	(method (dispose)
		(= bPecandMouth 0)
		(super dispose:)
	)
)

(instance toPecand of Talker
	(properties)

	(method (init)
		(= view (poPecand view:))
		(= cel 0)
		(if (!= -1 lPecandMouth)
			(= loop lPecandMouth)
		else
			(= loop (+ (poPecand loop:) 1))
		)
		(= x (poPecand x:))
		(= y (poPecand y:))
		(= priority (+ (poPecand priority:) 1))
		(super init: &rest)
		(if bPecandMouth
			(poPecandMouth hide:)
		)
	)

	(method (dispose)
		(if bPecandMouth
			(poPecandMouth show:)
		)
		(super dispose: &rest)
	)
)

(instance foPecand of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 392 109 413 140 409 163 400 167 409 185 382 203 355 201 323 214 298 223 296 191 309 177 275 161 282 131 309 122 326 153 345 157 328 177 334 194 361 173 377 172 363 148 366 131 379 113
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance poPecand of Prop
	(properties
		x 423
		y 142
		view 51470
	)

	(method (onMe ev)
		(return (foPecand onMe: ev))
	)

	(method (doVerb)
		(self deleteHotspotVerb: 62)
		(foPecand dispose:)
		(soCartoon cue:)
	)
)

(instance soPecandBlink of SoTwinkle
	(properties
		minCycle 7
		maxCycle 9
	)
)

(instance poPecandEyes of Prop
	(properties
		x 423
		y 142
		view 51472
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soPecandBlink)
	)
)

(instance foLavaPit of Feature
	(properties
		nsLeft 293
		nsTop 112
		nsRight 395
		nsBottom 160
	)

	(method (init)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(self dispose:)
		(soCartoon cue:)
	)
)

(instance poParents of Prop
	(properties)
)

(instance poWhirlwind of Prop
	(properties)
)

(instance poPa of Prop
	(properties)
)

(instance toPa of Talker
	(properties)

	(method (init)
		(= view (poPa view:))
		(= loop (+ (poPa loop:) 1))
		(= cel 0)
		(= x (poPa x:))
		(= y (poPa y:))
		(= priority (+ (poPa priority:) 1))
		(super init: &rest)
	)
)

(instance poMa of Prop
	(properties)
)

(instance toMa of Talker
	(properties)

	(method (init)
		(= view (poMa view:))
		(= loop (+ (poMa loop:) 1))
		(= cel 0)
		(= x (poMa x:))
		(= y (poMa y:))
		(= priority (+ (poMa priority:) 1))
		(super init: &rest)
	)
)

(instance poBoogle of Prop
	(properties)
)

(instance soPutBookAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin
					view: 51453
					setCel: 0
					setLoop: 0
					posn: 547 305
					setCycle: CT 15 1 self
				)
			)
			(1
				(goSound1 playSound: 51407)
				(gEgo get: ((ScriptID 64001 0) get: 51)) ; oInvHandler, ioMagicBook
				(poTorin setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soTossBeakers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia
					view: 51454
					setLoop: 0
					setCel: 0
					posn: 223 173
					setCycle: CT 8 1 self
				)
				(UpdateScreenItem poLycentia)
			)
			(1
				(goSound1 playSound: 51409)
				(poLycentia setCycle: End self)
			)
			(2
				(poLycentia setLoop: 1 setCel: 0)
				(UpdateScreenItem poLycentia)
				(= gtLycentia toLycentia)
				(gMessager say: 0 0 0 1 self 57000) ; "What? You dare enter my home and attempt your little magic spells on me?!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soTorinSpellsLycentia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64017 0) set: 227) ; oFlags
				(gEgo dispose:)
				(gGame handsOff:)
				(poTorin
					view: 51451
					setLoop: 0
					setCel: 0
					posn: 219 173
					init:
					setCycle: CT 54 1 self
				)
				(goSound1 stop: preload: 51438 51408 51407 51409 51410 51411)
			)
			(1
				(roomMusic 51438 1)
				(goSound1 playSound: 51408)
				(poTorin setCycle: End self)
			)
			(2
				(poLycentia
					view: 51452
					setCel: 0
					setLoop: 0
					posn: 219 173
					setScript: 0
					setCycle: End self
				)
				(UpdateScreenItem poLycentia)
				(poTorin
					view: 51452
					setCel: 0
					setLoop: 1
					posn: 547 305
					setCycle: End self
				)
			)
			(3)
			(4
				(self setScript: soTossBeakers self)
				(poTorin setScript: soPutBookAway self)
			)
			(5)
			(6
				(poLycentia
					view: 51454
					setLoop: 1
					setCel: 0
					setCycle: CT 5 1 self
				)
				(UpdateScreenItem poLycentia)
			)
			(7
				(goSound1 playSound: 51410)
				(poLycentia setCycle: End self)
			)
			(8
				(poTorin
					view: 51455
					setLoop: 0
					setCel: 0
					posn: 223 173
					setCycle: End self
				)
				(poLycentia
					view: 51455
					setLoop: 1
					setCel: 0
					posn: 570 298
					setCycle: End self
				)
				(UpdateScreenItem poLycentia)
			)
			(9)
			(10
				(poTorin
					view: 51456
					setLoop: 0
					setCel: 0
					posn: 213 169
					setCycle: End self
				)
				(poLycentia
					view: 51456
					setLoop: 1
					setCel: 0
					posn: 549 309
					setCycle: End self
				)
				(UpdateScreenItem poLycentia)
			)
			(11)
			(12
				(self dispose:)
			)
		)
	)
)

(instance soLycentiaChoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia
					view: 51403
					cel: 0
					setLoop: 0
					posn: 588 202
					init:
					setCycle: End self
				)
				(goSound1 preload: 51411 51436)
			)
			(1
				(poLycentia
					view: 51403
					setLoop: 3
					setCel: 0
					setCycle: CT 12 1 self
				)
				(UpdateScreenItem poLycentia)
			)
			(2
				(goSound1 playSound: 51411)
				(poLycentia setCycle: CT 47 1 self)
			)
			(3
				(goSound1 playSound: 51436)
				(poLycentia setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soLycentiaInflate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin dispose:)
				(poLycentia dispose:)
				(Purge 1500)
				(poTorin
					view: 51403
					setCel: 0
					setLoop: 1
					posn: 293 247
					init:
					setCycle: End self
				)
				(self setScript: soLycentiaChoke self)
				(gCurRoom picture: 51401 drawPic: 51401)
			)
			(1)
			(2
				(poTorin
					view: 51403
					setLoop: 4
					setCel: 0
					posn: 292 248
					setCycle: End self
				)
			)
			(3
				(poLycentia dispose:)
				(poTorin dispose:)
				(self dispose:)
			)
		)
	)
)

(instance foLycentiasCollar of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 166 329 171 342 185 337 240 318 289 295 308 240 310 234 291 253 269 262 229 288 198
					yourself:
				)
		)
		(super init: &rest)
		(self addHotspotVerb: 1)
	)

	(method (doVerb)
		(self dispose:)
		(soCartoon cue:)
	)
)

(instance coHideTorin of CueMe
	(properties)

	(method (cue)
		(poTorin dispose:)
	)
)

(instance soTouchCollar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin
					view: 51404
					setCel: 0
					setLoop: 1
					posn: 377 1
					init:
					setPri: (+ (poLycentia priority:) 10)
					setCycle: CT 18 1 self
				)
				(goSound1 preload: 51412 51413)
			)
			(1
				(goSound1 playSound: 51412 self)
				(poTorin setCycle: End coHideTorin)
			)
			(2
				(goSound1 playSound: 51413)
				(poLycentia setCycle: End self)
			)
			(3
				(poLycentia dispose:)
				(poTorin setPri: -1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soTorinOfCourse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia setCycle: End self)
			)
			(1
				(poLycentia cycleSpeed: 7 dispose:)
				(poTorin dispose:)
				(poPecand dispose:)
				(poPecandEyes dispose:)
				(gCurRoom picture: 51404 drawPic: 51404)
				(self dispose:)
			)
		)
	)
)

(instance soLittleFinger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oRoomMusic stop:)
				(Purge 2000)
				(gGame setScript: soLycentiaMusic)
				((ScriptID 64017 0) set: 228) ; oFlags
				(poLycentia
					view: 51466
					setLoop: 0
					setCel: 0
					posn: 409 255
					init:
					setCycle: End self
				)
				(poTorin
					view: 51405
					setLoop: 0
					setCel: 3
					posn: 340 247
					init:
					setCycle: CT 11 1 self
				)
				(gCurRoom picture: 51401 drawPic: 51401)
				(goSound1 preload: 51437 51414 51415)
			)
			(1)
			(2
				(poPecand
					view: 51470
					loop: 0
					cel: 0
					posn: 423 142
					init:
					setPri: 14
					setCycle: End
				)
				(goSound1 playSound: 51437)
				(= gtLycentia toLycentia)
				(gMessager say: 0 0 0 2 self 57000) ; "Foolish boy. I have more power in my little finger than you'll ever possess!"
			)
			(3
				(= gtLycentia 0)
				(poLycentia
					view: 51467
					setLoop: 0
					setCel: 0
					setCycle: CT 12 1 self
				)
				(UpdateScreenItem poLycentia)
			)
			(4
				(poPecandEyes
					view: 51470
					loop: 1
					cel: 0
					posn: 396 60
					init:
					setPri: 15
				)
				(goSound1 playSound: 51414)
				(poLycentia setCycle: End)
				(poTorin view: 51468 setLoop: 0 setCel: 0 setCycle: CT 5 1 self)
				(UpdateScreenItem poTorin)
			)
			(5
				(goSound1 playSound: 51415)
				(poTorin setCycle: End self)
			)
			(6
				(poLycentia
					view: 51469
					setLoop: 0
					setCel: 0
					posn: 372 259
					setCycle: CT 18 1 self
				)
				(UpdateScreenItem poLycentia)
			)
			(7
				(gMessager say: 0 0 0 32 self 57000) ; "(CHOKE) (Gasp.) The collar..."
				(poLycentia cycleSpeed: 10 setCycle: CT 47 1 self)
			)
			(8)
			(9
				(gMessager say: 0 0 0 3 self 57000) ; "Torin!! Of course. Who else could remove the collar?"
				(self setScript: soTorinOfCourse self)
			)
			(10)
			(11
				(self dispose:)
			)
		)
	)
)

(instance soPecandViewerGone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 51437)
				(poPecandEyes dispose:)
				(poPecand setCycle: End self)
			)
			(1
				(poPecand dispose:)
				(self dispose:)
			)
		)
	)
)

(instance soTorinWhoAreYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Purge 1500)
				(poPecand
					view: 51472
					loop: 0
					cel: 0
					posn: 619 104
					init:
					setPri: 14
				)
				(poPecandEyes
					view: 51472
					loop: 1
					cel: 0
					posn: 585 35
					init:
					setPri: 15
					setCycle: Blink
				)
				(poTorin view: 51473 setLoop: 0 setCel: 0 posn: 57 214 init:)
				(poLycentia
					view: 51471
					setLoop: 0
					setCel: 0
					posn: 240 197
					init:
					setPri: (+ (poTorin priority:) 1)
					setCycle: End self
				)
				(UpdateScreenItem poTorin)
				(gCurRoom picture: 51405 drawPic: 51405)
				(= gtLycentia toLycentia)
				(= gtTorin toTorin)
			)
			(1
				(poTorin setCycle: End self)
			)
			(2
				(gMessager say: 0 0 0 4 self 57000) ; "How do you know my name?"
			)
			(3
				(poPecand setCycle: CT 4 1 self)
				(poPecandEyes dispose:)
				(= ticks 120)
			)
			(4)
			(5
				(poPecand setCycle: CT 6 1 self)
				(gMessager say: 0 0 0 5 self 57000) ; "I was your nanny."
			)
			(6)
			(7
				(gMessager say: 0 0 0 6 self 57000) ; "Nanny?"
				(self setScript: soPecandViewerGone self)
			)
			(8)
			(9
				(= gtLycentia 0)
				(= gtTorin 0)
				(= gtTorin 0)
				(= cycles 1)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance soTorinLearnsAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin dispose:)
				(poLycentia setPri: -1 dispose:)
				(= gtTorin toTorin)
				(= gtLycentia toLycentia)
				(poLycentia
					view: 51407
					setCel: 0
					setLoop: 2
					posn: 410 285
					init:
				)
				(poLycentiaMouth init:)
				(gCurRoom picture: 51414 drawPic: 51414)
				(gMessager say: 0 0 0 7 self 57000) ; "I saved your life...the night your parents were murdered!"
			)
			(1
				(poTorin view: 51407 setLoop: 4 setCel: 0 posn: 140 292 init:)
				(poLycentiaMouth dispose:)
				(poLycentia dispose:)
				(poTorin init:)
				(poTorinMouth init:)
				(gCurRoom picture: 51413 drawPic: 51413)
				(gMessager say: 0 0 0 8 self 57000) ; "(AGHAST) Murdered? No! How could you? I thought you had them in a magic spell."
			)
			(2
				(poTorin dispose:)
				(poTorinMouth dispose:)
				(poLycentia init:)
				(poLycentiaMouth init:)
				(gCurRoom picture: 51414 drawPic: 51414)
				(poLycentia view: 51407 setLoop: 2)
				(UpdateScreenItem poLycentia)
				(= lLycentiaMouth 3)
				(gMessager say: 0 0 0 9 self 57000) ; "No, Torin. The Fahrmans are safe. But they're not your real parents. Your real parents were the King and Queen of The Lands Above!"
			)
			(3
				(poLycentiaMouth dispose:)
				(poLycentia dispose:)
				(gCurRoom picture: 51413 drawPic: 51413)
				(poTorin setLoop: 0 init:)
				(poTorinMouth dispose: init:)
				(gMessager say: 0 0 0 10 self 57000) ; "What? (REALIZATION SINKS IN) But, then... I'm..."
			)
			(4
				(poTorinMouth dispose:)
				(poTorin dispose:)
				(gCurRoom picture: 51405 drawPic: 51405)
				(poTorin view: 51473 setLoop: 0 posn: 57 214 init:)
				(poTorin setCel: (poTorin lastCel:))
				(UpdateScreenItem poTorin)
				(poLycentia
					view: 51471
					setLoop: 0
					setCel: 19
					posn: 252 197
					setPri: (+ (poTorin priority:) 1)
					init:
				)
				(gMessager say: 0 0 0 11 self 57000) ; "That's right. You're the next king!"
			)
			(5
				(= gtTorin 0)
				(= gtLycentia 0)
				(= lLycentiaMouth -1)
				(self dispose:)
			)
		)
	)
)

(instance soLycentiaFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia
					view: 51461
					setLoop: 0
					setCel: 0
					posn: 165 218
					init:
					setCycle: CT 2 1 self
				)
			)
			(1
				(goSound1 playSound: 51436)
				(poLycentia setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soShouldHaveDied of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 180)
			)
			(1
				(poLycentia dispose:)
				(poTorin dispose:)
				(poPecand view: 51409 setLoop: 0 setCel: 0 posn: 376 306)
				(UpdateScreenItem poPecand)
				(poPecandMouth init: hide:)
				(= bPecandMouth 1)
				((toPecand mouth:) view: 51409 setLoop: 1 posn: 376 306)
				(UpdateScreenItem (toPecand mouth:))
				(gCurRoom picture: 51409 drawPic: 51409)
				(self dispose:)
			)
		)
	)
)

(instance soPecandArrivesPart2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand setCycle: CT 24 1 self)
			)
			(1
				(poLycentia setPri: -1 dispose:)
				(poPecand setCycle: CT 28 1 self)
			)
			(2
				(poPecand setCycle: End self)
			)
			(3
				(goSound1 playSound: 51435)
				(poPecand view: 51459 setLoop: 0 setCel: 0 setCycle: End self)
				(UpdateScreenItem poPecand)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soPecandArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oRoomMusic stop:)
				(Purge 2000)
				(poPecand
					view: 51408
					setCel: 0
					setLoop: 0
					posn: 180 184
					init:
					setPri: (+ (poTorin priority:) 1)
					setCycle: CT 7 1 self
				)
				(goSound1 preload: 51441 51416 51435 51436 51402)
				(roomMusic 51441 -1)
				(goSound1 playSound: 51416)
			)
			(1
				(self setScript: soPecandArrivesPart2 self)
				(gMessager say: 0 0 0 12 self 57000) ; "No, that's wrong. I'm the next king!"
			)
			(2)
			(3
				(poPecand view: 51460 setLoop: 0 setCel: 0 setCycle: End self)
				(UpdateScreenItem poPecand)
				(self setScript: soLycentiaFly self)
			)
			(4)
			(5
				(poPecandMouth init:)
				(= gtPecand toPecand)
				(gMessager say: 0 0 0 13 self 57000) ; "You should have died in your cradle that night, little nephew! After searching for you all these years, you won't escape me now!"
				(self setScript: soShouldHaveDied)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance soPecandTreatens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand dispose:)
				(poPecandMouth dispose:)
				(= gtPecand 0)
				(poLycentia dispose:)
				(poTorin view: 51458 setLoop: 0 setCel: 0 posn: 228 304 init:)
				(gCurRoom picture: 51406 drawPic: 51406)
				(gMessager say: 0 0 0 14 self 57000) ; "I killed your parents..."
				(poTorin setCycle: CT 4 1)
			)
			(1
				(poTorin setCycle: End self)
			)
			(2
				(= ticks 30)
				(Load rsPIC 51409)
			)
			(3
				(poTorin dispose:)
				(gCurRoom picture: 51409 drawPic: 51409)
				(poPecand view: 51409 setLoop: 0 setCel: 1 posn: 376 306 init:)
				(= gtPecand toPecand)
				(poPecandMouth init:)
				(gMessager say: 0 0 0 15 self 57000) ; "...and now, I'll kill you!"
			)
			(4
				(= gtPecand 0)
				(super dispose:)
			)
		)
	)
)

(instance soPecandPushedBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand
					view: 51475
					setLoop: 0
					setCel: 0
					posn: 252 282
					init:
					setCycle: CT 2 1 self
				)
			)
			(1
				(goSound1 playSound: 51422)
				(poPecand setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soTorinAndPecandFight1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oRoomMusic stop:)
				(Purge 2000)
				(gGame setScript: soFightMusic)
				(poPecand dispose:)
				(poPecandMouth dispose:)
				(= gtPecand 0)
				(poTorin
					view: 51410
					setLoop: 0
					setCel: 0
					posn: 252 280
					init:
					setCycle: CT 3 1 self
				)
				(gCurRoom picture: 51412 drawPic: 51412)
				(goSound1 preload: 51417 51422 51418 51423)
			)
			(1
				(goSound1 playSound: 51417)
				(poTorin setCycle: CT 7 1 self)
			)
			(2
				(= ticks (poTorin cycleSpeed:))
			)
			(3
				(poTorin setCel: 8 setCycle: End self)
				(UpdateScreenItem poTorin)
				(self setScript: soPecandPushedBack self)
			)
			(4)
			(5
				(poPecand
					view: 51476
					setLoop: 0
					setCel: 0
					setCycle: CT 1 1 self
				)
				(UpdateScreenItem poPecand)
			)
			(6
				(goSound1 playSound: 51418)
				(poPecand setCycle: CT 5 1 self)
				(poTorin dispose:)
			)
			(7
				(poTorin
					view: 51478
					setLoop: 0
					setCel: 0
					posn: 319 295
					init:
					setCycle: End self
				)
				(goSound1 playSound: 51423)
				(poPecand
					view: 51477
					setLoop: 0
					setCel: 0
					posn: 266 288
					setCycle: End self
				)
				(UpdateScreenItem poPecand)
			)
			(8)
			(9
				(self dispose:)
			)
		)
	)
)

(instance soTorinAndPecandFight2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand dispose:)
				(Purge 1500)
				(poLycentia
					view: 51410
					setLoop: 1
					setCel: 0
					posn: 165 220
					init:
				)
				(poTorin
					view: 51479
					setLoop: 0
					setCel: 0
					posn: 162 195
					setCycle: CT 17 1 self
				)
				(UpdateScreenItem poTorin)
				(gCurRoom picture: 51405 drawPic: 51405)
				(goSound1 preload: 51419 51424 51420 51425 51421 51426 51436)
			)
			(1
				(goSound1 playSound: 51419)
				(poTorin setCycle: CT 24 1 self)
			)
			(2
				(goSound1 playSound: 51424)
				(poTorin setCycle: CT 34 1 self)
			)
			(3
				(goSound1 playSound: 51420)
				(oOtherSound playSound: 51425)
				(poTorin setCycle: CT 42 1 self)
			)
			(4
				(poTorin setCel: 43)
				(UpdateScreenItem poTorin)
				(poPecand view: 51480 setLoop: 0 setCel: 0 posn: 284 215 init:)
				(= ticks (poPecand cycleSpeed:))
			)
			(5
				(poTorin setCycle: End)
				(poLycentia dispose:)
				(poPecand setCycle: CT 1 1 self)
			)
			(6
				(goSound1 playSound: 51436)
				(poPecand setCycle: CT 3 1 self)
			)
			(7
				(goSound1 playSound: 51426)
				(poPecand setCycle: End self)
			)
			(8
				(= ticks 120)
			)
			(9
				(poPecand
					view: 51411
					setCel: 0
					setLoop: 0
					posn: 369 306
					setCycle: End self
				)
				(UpdateScreenItem poPecand)
			)
			(10
				(gMessager say: 0 0 0 16 self 57000) ; "One step closer, boy, and I'll finish her."
			)
			(11
				(gGame handsOn:)
				(foLavaPit init:)
				(super dispose:)
			)
		)
	)
)

(instance soTorinClimbsLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 64017 0) set: 230) ; oFlags
				(poTorin
					view: 51481
					setLoop: 0
					setCel: 0
					posn: 166 177
					setCycle: CT 10 1 self
				)
				(UpdateScreenItem poTorin)
			)
			(1
				(poTorin setCycle: End self)
				(gMessager say: 0 0 0 17 self 57000) ; "No! Don't!"
			)
			(2)
			(3
				(poTorin
					view: 51482
					setLoop: 0
					setCel: 0
					posn: 270 170
					setCycle: End self
				)
				(UpdateScreenItem poTorin)
			)
			(4
				(poTorin
					view: 51483
					setLoop: 0
					setCel: 0
					posn: 319 133
					setCycle: Fwd
				)
				(UpdateScreenItem poTorin)
				(gGame handsOn:)
				(poPecand addHotspotVerb: 62)
				(foPecand init:)
				(super dispose:)
			)
		)
	)
)

(instance soPecandIntoLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setScript: 0)
				(oRoomMusic stop:)
				(Purge 2000)
				(roomMusic 51444 1)
				(gGame handsOff:)
				((ScriptID 64017 0) set: 231) ; oFlags
				(poPecand
					view: 51412
					setLoop: 0
					setCel: 0
					posn: 413 269
					init:
					setCycle: CT 5 1
				)
				(poTorin
					view: 51484
					setLoop: 0
					setCel: 0
					posn: 335 121
					init:
					setCycle: End self
				)
				(goSound1 playSound: 51408 preload: 51427)
			)
			(1
				(poTorin setCycle: End self)
			)
			(2
				(gMessager say: 0 0 0 18 self 57000) ; "(SCREAMS OF ANGUISH AS YOU FALL INTO HOT LAVA) Arrrggh!"
				(poTorin
					view: 51485
					setLoop: 0
					setCel: 0
					setCycle: CT 13 1 self
				)
				(UpdateScreenItem poTorin)
			)
			(3)
			(4
				(goSound1 playSound: 51427)
				(poTorin setCycle: End self)
			)
			(5
				(poTorin dispose:)
				(poPecand setCycle: End self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance soAreYouOkay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand dispose:)
				(Purge 1500)
				(poLycentia
					view: 51486
					setLoop: 1
					setCel: 0
					posn: 377 112
					init:
				)
				(poPa view: 51486 setLoop: 0 setCel: 0 posn: 377 113 init:)
				(poTorin view: 51413 setLoop: 0 setCel: 0 posn: 169 306 init:)
				(poTorinMouth init:)
				(= gtTorin toTorin)
				(gCurRoom picture: 51406 drawPic: 51406)
				(gMessager say: 0 0 0 19 self 57000) ; "Lycentia? Lycentia, are you okay?"
			)
			(1
				(= gtTorin 0)
				(poLycentia setCycle: CT 32 1 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPecandOutOfLava of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand
					view: 51414
					setLoop: 0
					setCel: 0
					posn: 291 241
					init:
					setCycle: CT 20 1 self
				)
				(gCurRoom picture: 51407 drawPic: 51407)
				(goSound1 preload: 51428)
			)
			(1
				(goSound1 playSound: 51428)
				(poPecand setCycle: End self)
			)
			(2
				(poPecand dispose:)
				(poTorin view: 51488 setLoop: 0 setCel: 0 init:)
				(poLycentia
					view: 51487
					setLoop: 0
					setCel: 0
					posn: 343 295
					init:
					setPri: (+ (poTorin priority:) 1)
					setCycle: CT 3 1 self
				)
				(gCurRoom picture: 51406 drawPic: 51406)
				(goSound1 preload: 51429)
			)
			(3
				(goSound1 playSound: 51429)
				(poLycentia setCycle: End self)
				(poTorin setCycle: End self)
			)
			(4)
			(5
				(self dispose:)
			)
		)
	)
)

(instance soDramaticScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia dispose:)
				(poPa dispose:)
				(poTorin dispose:)
				(poTorinMouth dispose:)
				(oRoomMusic stop:)
				(Purge 2400)
				(roomMusic 51445 1)
				(Load rsPIC 51406 51407)
				(goSound1 preload: 51429)
				(Load rsVIEW 51414 51487 51488)
				(self setScript: soPecandOutOfLava self)
				(gMessager say: 0 0 0 20 self 57000) ; "That was close. I thought he had you there for a second. Hey, Lycentia??"
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPecandCrystal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia dispose:)
				(poTorin dispose:)
				(Purge 1500)
				(poLycentia
					view: 51415
					setLoop: 0
					setCel: 0
					posn: 278 311
					init:
					setPri: -1
					setCycle: End self
				)
				(poPecand
					view: 51489
					setLoop: 0
					setCel: 0
					posn: 135 247
					init:
					setCycle: End self
				)
				(poTorin
					view: 51490
					setLoop: 0
					setCel: 0
					posn: 370 271
					init:
					setCycle: End self
				)
				(gCurRoom picture: 51405 drawPic: 51405)
				(goSound1 playSound: 51430 preload: 51431)
			)
			(1)
			(2)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soPecandFlyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecand dispose:)
				(poLycentia dispose:)
				(poTorin dispose:)
				(Purge 1500)
				(poPecand
					view: 51416
					setCel: 0
					setLoop: 0
					posn: 308 249
					init:
					setCycle: End self
				)
				(gCurRoom picture: 51410 drawPic: 51410)
				(goSound1 playSound: 51431)
			)
			(1
				(poPecand dispose:)
				(super dispose:)
			)
		)
	)
)

(instance soParentalPoof of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oRoomMusic stop:)
				(Purge 2000)
				(roomMusic 51403 -1)
				(poParents view: 51417 setLoop: 0 setCel: 0 posn: 11 212 init:)
				(poTorin view: 51417 setLoop: 3 setCel: 0 posn: 506 306 init:)
				(poTorinMouth init:)
				(poLycentia
					view: 51417
					setLoop: 1
					setCel: 0
					posn: 363 314
					init:
				)
				(poLycentiaMouth init:)
				(gCurRoom picture: 51408 drawPic: 51408)
				(= gtTorin toTorin)
				(= gtLycentia toLycentia)
				(gMessager sayRange: 0 0 0 21 22 self 57000) ; "But the lava?"
			)
			(1
				(goSound1 preload: 51432)
				(= ticks 100)
			)
			(2
				(gMessager say: 0 0 0 23 self 57000) ; "What about my parents? And Boogle?"
			)
			(3
				(gMessager say: 0 0 0 33 self 57000) ; "Of course,..."
			)
			(4
				(= gtTorin 0)
				(= gtLycentia 0)
				(poTorinMouth dispose:)
				(poLycentiaMouth dispose:)
				(poTorin view: 51492 setLoop: 0 setCel: 0 setCycle: End)
				(UpdateScreenItem poTorin)
				(poLycentia
					view: 51491
					setLoop: 0
					setCel: 0
					setCycle: CT 11 1 self
				)
				(UpdateScreenItem poLycentia)
			)
			(5
				(poLycentia setCycle: End self)
				(gMessager say: 0 0 0 24 0 57000) ; "Torin, I think it's time for all of us to go back home...to The Lands Above!"
			)
			(6
				(goSound1 playSound: 51432)
				(poWhirlwind
					view: 51492
					setLoop: 1
					setCel: 0
					posn: 33 213
					init:
					setCycle: CT 5 1 self
				)
			)
			(7
				(poParents dispose:)
				(poWhirlwind setCycle: End self)
			)
			(8
				(poWhirlwind
					view: 51493
					setLoop: 0
					setCel: 0
					posn: 302 301
					setPri: 500
					setCycle: CT 5 1 self
				)
			)
			(9
				(poTorin dispose:)
				(poLycentia dispose:)
				(gCurRoom picture: -1 drawPic: -1)
				(= ticks 1)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance soTorinAndLycentiaArrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin
					view: 51442
					setLoop: 0
					setCel: 0
					posn: 385 271
					init:
					setCycle: CT 22 1 self
				)
				(poLycentia
					view: 51443
					setLoop: 0
					setCel: 0
					posn: 258 297
					init:
					setCycle: CT 35 1 self
				)
			)
			(1)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPaArrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 51433)
				(poWhirlwind
					view: 51444
					setLoop: 0
					setCel: 0
					posn: 229 98
					init:
					setPri: 235
					setCycle: End self
				)
			)
			(1
				(poWhirlwind dispose:)
				(poPa
					view: 51418
					setCel: 0
					setLoop: 0
					posn: 235 235
					init:
					setCycle: CT 17 1 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soMaArrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goSound1 playSound: 51433)
				(poWhirlwind
					view: 51444
					setLoop: 0
					setCel: 0
					posn: 289 129
					init:
					setPri: 235
					setCycle: End self
				)
			)
			(1
				(poWhirlwind dispose:)
				(poMa
					view: 51440
					setLoop: 0
					setCel: 0
					posn: 275 235
					init:
					setCycle: CT 13 1 self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soBoogleArrive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poWhirlwind
					view: 51444
					setLoop: 0
					setCel: 0
					posn: 241 88
					init:
					setPri: 235
					setCycle: End self
				)
				(goSound1 playSound: 51433 preload: 51448)
			)
			(1
				(poWhirlwind dispose:)
				(poBoogle
					view: 51441
					setLoop: 0
					setCel: 0
					posn: 255 235
					init:
					setCycle: CT 5 1 self
				)
			)
			(2
				(goSound1 playSound: 51448)
				(poBoogle setCycle: End self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soReachForHug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poTorin setCycle: CT 34 1 self)
				(poPa setCycle: End self)
				(poMa setCycle: End self)
			)
			(1)
			(2)
			(3
				(poTorin dispose:)
				(poPa dispose:)
				(poMa dispose:)
				(poBoogle dispose:)
				(poLycentia dispose:)
				(Purge 1500)
				(poPa
					view: 51419
					setCel: 0
					setLoop: 1
					posn: 247 201
					init:
					setCycle: End
				)
				(poBoogle
					view: 51419
					setCel: 0
					setLoop: 2
					posn: 360 222
					init:
					setCycle: End
				)
				(poLycentia
					view: 51419
					setCel: 0
					setLoop: 0
					posn: 522 288
					init:
					setCycle: End
				)
				(gCurRoom picture: 51411 drawPic: 51411)
				(self dispose:)
			)
		)
	)
)

(instance soArriveHome of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Purge 1500)
				(gCurRoom picture: 10004 drawPic: 10004)
				(goSound1 preload: 51433)
				(poWhirlwind setCycle: End self)
			)
			(1
				(poWhirlwind dispose:)
				(= ticks 1)
			)
			(2
				(self setScript: soTorinAndLycentiaArrive self)
			)
			(3
				(self setScript: soPaArrive self)
			)
			(4
				(gMessager say: 0 0 0 25 self 57000) ; "Torin! Where's my tools? From town? Remember?"
				(self setScript: soMaArrive self)
			)
			(5)
			(6
				(gMessager say: 0 0 0 26 self 57000) ; "Son!? Who's this lady? And is she gonna stay for dinner?"
				(self setScript: soBoogleArrive self)
			)
			(7)
			(8
				(gMessager say: 0 0 0 27 self 57000) ; "Mom! Dad! Oh, it's great to be home again!"
				(= ticks 90)
			)
			(9
				(if ticks
					(= ticks 1)
				)
				(self setScript: soReachForHug self)
			)
			(10)
			(11
				(gMessager say: 0 0 0 29 self 57000) ; "(MISC. SIGHS & HUGS) Ahh."
			)
			(12
				(self dispose:)
			)
		)
	)
)

(instance oPourSound of TPSound
	(properties)
)

(instance soLycentiaPour of Script
	(properties)

	(method (init)
		(oPourSound playSound: 51406)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poLycentia setCel: 0 setCycle: CT 10 1 self)
				(UpdateScreenItem poLycentia)
			)
			(1
				(oPourSound stop:)
				(poLycentia setCycle: CT 29 1 self)
			)
			(2
				(oPourSound playSound: 51406)
				(poLycentia setCycle: CT 43 1 self)
			)
			(3
				(oPourSound playSound: 51406)
				(poLycentia setCycle: End self)
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance soLycentiaMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomMusic 51440 1 self)
			)
			(1
				(roomMusic 51401 -1)
			)
		)
	)

	(method (dispose)
		(oRoomMusic stop:)
		(super dispose:)
	)
)

(instance soFightMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roomMusic 51442 1 self)
			)
			(1
				(roomMusic 51443 -1)
			)
		)
	)

	(method (dispose)
		(oRoomMusic stop:)
		(super dispose:)
	)
)

(instance soClickedBookOnLycentia of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: soTorinSpellsLycentia self)
			)
			(1
				(self setScript: soLycentiaInflate self)
			)
			(2
				(roomMusic 51439 -1)
				(poLycentia
					view: 51404
					setCel: 0
					setLoop: 0
					posn: 292 298
					init:
				)
				(gGame handsOn:)
				(foLycentiasCollar init:)
				(gCurRoom picture: 51403 drawPic: 51403)
				(self dispose:)
			)
		)
	)
)

(instance soRemoveCollar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(self setScript: soTouchCollar self)
			)
			(1
				((ScriptID 64017 0) set: 229) ; oFlags
				(self setScript: soLittleFinger self)
			)
			(2
				(self setScript: soTorinWhoAreYou self)
			)
			(3
				(self setScript: soTorinLearnsAll self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soFightScene of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame setScript: 0)
				(self setScript: soPecandArrives self)
			)
			(1
				(self setScript: soPecandTreatens self)
			)
			(2
				(self setScript: soTorinAndPecandFight1 self)
			)
			(3
				(self setScript: soTorinAndPecandFight2 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance soTouchyFeely of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: ((ScriptID 64001 0) get: 51)) ; oInvHandler, ioMagicBook
				(self setScript: soPecandIntoLava self)
			)
			(1
				(self setScript: soAreYouOkay self)
			)
			(2
				(self setScript: soDramaticScene self)
			)
			(3
				(self setScript: soPecandCrystal self)
			)
			(4
				(self setScript: soPecandFlyAway self)
			)
			(5
				(self setScript: soParentalPoof self)
			)
			(6
				(self setScript: soArriveHome self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance soBagpipes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(((ScriptID 64001 0) get: 46) moveTo: -3) ; oInvHandler, ioBagpipes
				(poTorin
					view: 51464
					loop: 0
					cel: 0
					posn: 220 171
					doit:
					setCycle: CT 20 1 self
				)
			)
			(1
				(poTorin setCycle: End self)
				(poLycentia
					setCycle: 0
					setScript: 0
					view: 51464
					loop: 1
					cel: 0
					posn: 542 316
					doit:
					setCycle: End self
				)
				(goSound1 playSound: 51106)
			)
			(2)
			(3
				(poTorin dispose:)
				(poLycentia dispose:)
				(gCurRoom picture: 51401 drawPic: 51401)
				(poTorin view: 51499 loop: 1 cel: 0 posn: 269 262 init:)
				(poLycentia
					view: 51499
					loop: 0
					cel: 0
					posn: 555 212
					init:
					setCycle: CT 11 1 self
				)
			)
			(4
				(goSound1 playSound: 51408)
				(poLycentia setCycle: CT 12 1 self)
			)
			(5
				(poTorin setCycle: End self)
				(poLycentia setCycle: End self)
			)
			(6)
			(7
				(oRoomMusic setMusic: 0)
				((ScriptID 64019 0) show: 1 63 0 57000) ; DeathDialog
				(oRoomMusic setMusic: 51400)
				(poTorin dispose:)
				(poLycentia dispose:)
				(gCurRoom picture: 51400 drawPic: 51400)
				(poTorin view: 51400 loop: 0 posn: 275 157)
				(poTorin cel: (poTorin lastCel:) init: addHotspotVerb: 63)
				(poLycentia
					view: 51465
					cel: 0
					loop: 0
					posn: 538 314
					init:
					setScript: soLycentiaPour
					addHotspotVerb: 62 63
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oRoomMusic setMusic: 51400)
				(poTorin init: addHotspotVerb: 63)
				(poLycentia
					init:
					setScript: soLycentiaPour
					addHotspotVerb: 62 63
				)
				(FadeToBlack 0 10 self)
			)
			(1
				(poTorin setCycle: End self)
			)
			(2
				(gGame handsOn:)
			)
			(3
				(poTorin deleteHotspotVerb: 63)
				(poLycentia deleteHotspotVerb: 63)
				(self setScript: soClickedBookOnLycentia)
			)
			(4
				(self setScript: soRemoveCollar self)
			)
			(5
				(self setScript: soFightScene)
			)
			(6
				(self setScript: soTorinClimbsLava)
			)
			(7
				(self setScript: soTouchyFeely self)
			)
			(8
				(= ticks 180)
			)
			(9
				(FadeToBlack 1 10 self)
			)
			(10
				(poLycentia dispose:)
				(poBoogle dispose:)
				(poTorin dispose:)
				(poPa dispose:)
				(poMa dispose:)
				(gGame script: 0)
				(gCurRoom newRoom: 51500) ; roCredits
			)
		)
	)
)

(instance roEnd of TPRoom
	(properties
		picture 51400
	)

	(method (init)
		(goMusic1 stop:)
		(Purge 2500)
		(super init: &rest)
		(Palette 1 51400) ; PalLoad
		(= gtLycentia 0)
		(= gtTorin 0)
		(= gtPecand 0)
		(gCurRoom setScript: soCartoon)
	)

	(method (drawPic numb)
		(super drawPic: numb)
		(if
			(and
				(or (== numb 51401) (== numb 51405))
				((ScriptID 64017 0) test: 228) ; oFlags
			)
			(poLycentiaCollar init:)
		else
			(poLycentiaCollar dispose:)
		)
	)
)

