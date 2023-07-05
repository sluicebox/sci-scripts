;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Scaler)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	ro530 0
)

(local
	local0
	local1
)

(instance ro530 of L7Room
	(properties
		picture 53000
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 55 23 474 298
			posn: 311 469
		)
		(super init: &rest)
		((ScriptID 64017 0) set: 135) ; oFlags
		(cond
			(((ScriptID 64017 0) test: 308) ; oFlags
				(gOMusic1 setMusic: 53000)
				(gEgo dispose:)
				(gCurRoom addRoomPlane: oCUPlane)
				(if (not ((ScriptID 64017 0) test: 134)) ; oFlags
					(voSuitcase init:)
				)
				(gGame handsOn:)
			)
			(((ScriptID 64017 0) test: 278) ; oFlags
				(gCurRoom setScript: soGorilla)
			)
			(else
				(gCurRoom setScript: soEmptyRoom)
			)
		)
	)
)

(instance soEmptyRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gGame handsOff:)
				(gOMusic1 setMusic: 53000)
				(Load rsVIEW 53200)
				(= ticks 60)
			)
			(2
				(gEgo setSpeed: 4 walkTo: 295 412 self 0 0 0)
			)
			(3
				(gEgo dispose:)
				(gCurRoom addRoomPlane: oCUPlane)
				(gEgo posn: 275 396 doit:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGorilla of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poCartGuy init:)
				(= cycles 3)
			)
			(1
				(gOMusic1 setMusic: 53000)
				((ScriptID 64017 0) set: 135) ; oFlags
				(= local0 0)
				(gGame handsOff:)
				(Load rsVIEW 53200)
				(= ticks 60)
			)
			(2
				(poCartGuy cycleSpeed: 12 setCycle: End self 16)
			)
			(3
				(= local0 0)
				(gMessager say: 0 0 1 1 coEndTalk) ; "(DISPAIR AT MOUNTAIN OF SUITCASES) Oh, no! How will I ever find Drew's suitcase among all these? It'd be like finding a needle in a haystack!"
				(gEgo setSpeed: 4 walkTo: 303 440 self 0 0 0)
			)
			(4
				(gEgo setSpeed: 3 walkTo: 295 412 self 0 0 0)
				(poJumpGorilla init: setCycle: End self)
			)
			(5 0)
			(6
				(poJumpGorilla dispose:)
				(= cycles 1)
			)
			(7
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(8
				(gEgo dispose:)
				(gCurRoom addRoomPlane: oCUPlane)
				(= cycles 1)
			)
			(9
				(oShortSound playSound: 53002 self)
				(poGorilla init: setCycle: End self 10)
			)
			(10
				(gOSound1 playSound: 53001)
				(poHitLarry init: setCycle: End self 2 9999)
				(gEgo hide:)
			)
			(11
				(oShortSound playSound: 53003 self)
			)
			(12
				(= cycles 1)
			)
			(13
				(gEgo show:)
				(voSuitcase init:)
				(proc64896_15 2)
				((ScriptID 64017 0) set: 308) ; oFlags
				(poHitLarry dispose:)
				(poGorilla dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance poCartGuy of Prop
	(properties
		x 332
		y 148
		view 53000
		loop 1
	)
)

(instance poJumpGorilla of Prop
	(properties
		x 191
		y 177
		view 53000
	)
)

(instance poGorilla of Prop
	(properties
		x 430
		y 69
		view 53200
	)
)

(instance poHitLarry of Prop
	(properties
		x 275
		y 396
		view 53201
	)
)

(instance voSuitcase of View
	(properties
		noun 1
		approachX 370
		approachY 400
		x 394
		y 466
		z 50
		view 53202
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				(gEgo get: ((ScriptID 64037 0) get: 45)) ; oInvHandler, ioSuitcase
				((ScriptID 64017 0) set: 134) ; oFlags
				((gCurRoom obstacles:) delete: local1)
				(if local1
					(local1 dispose:)
					(= local1 0)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 437 415 454 405 437 383 251 351 162 363 269 428 370 441
							yourself:
						)
				)
				(voSuitcase dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foExit of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 193 341 203 282 208 249 197 227 142 226 127 246 131 301 136 332 140 349 173 346
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance oCUPlane of Plane
	(properties
		picture 53200
		priority 20
	)

	(method (init)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(gEgo
			init:
			normalize: 2
			setScaler: Scaler 130 70 446 346
			posn: 275 396
			doit:
		)
		(if
			(or
				(not ((ScriptID 64017 0) test: 308)) ; oFlags
				((ScriptID 64017 0) test: 134) ; oFlags
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 437 415 454 405 437 383 251 351 162 363 269 428 370 441
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((= local1 (Polygon new:))
						type: PContainedAccess
						init: 459 407 463 391 417 374 252 350 162 362 268 426 337 441 313 412 318 382 360 374 405 377
						yourself:
					)
			)
		)
		(if (not ((ScriptID 64017 0) test: 240)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 138 414
				setDest: 573 423
				loop: 0
				cel: 6
				setPri: 414
				setScaleDirect: 74
				nMyFlag: 240
				init:
			)
		)
		(foExit init:)
	)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

(instance oShortSound of TPSound
	(properties)
)

