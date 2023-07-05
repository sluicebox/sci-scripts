;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use oFidgetTimer)
(use oAnnounceTimer)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Scaler)
(use ROsc)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro390 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7 = 1
	local8 = 1
	local9
	local10
	local11
)

(instance ro390 of L7Room
	(properties
		picture 39000
	)

	(method (init)
		(gEgo
			init:
			normalize: 3
			setScaler: Scaler 124 96 464 336
			posn: 340 450
		)
		(super init:)
		(gOMusic1 setMusic: 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 601 461 611 363 301 302 281 317 342 332 357 372 307 438 187 457 114 456 96 453 95 469 90 469
					yourself:
				)
		)
		(foLane init:)
		(foWalrus init:)
		(foExit init:)
		(poWalrusTailFlip init:)
		(poALarry init: hide:)
		(voWalrusTailUp init: hide:)
		(voBall init: hide:)
		(poABowler init:)
		(poSmallPins init:)
		(if (not ((ScriptID 64017 0) test: 236)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 453 440
				setDest: 400 527
				loop: 0
				setScaleDirect: 140
				setPri: 450
				nMyFlag: 236
				oAltScript: soDildo
				init:
			)
		)
		(oAlleySounds setAmbient: 39001)
		(gGame handsOn:)
	)

	(method (notify param1)
		(switch param1
			(0
				((ScriptID 64037 2) setPri: -1) ; oInvPlane
				(foLane doVerb: 57)
			)
			(1
				(gCurRoom setScript: soWipeBall)
			)
			(2
				(= local3 1)
				(gCurRoom setScript: soWipeBall)
			)
		)
	)

	(method (newRoom)
		(if (gEgo has: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
			(gCurRoom setScript: soReturnBall)
		else
			(super newRoom: &rest)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
		(gEgo get: ((ScriptID 64037 0) get: 53)) ; oInvHandler, ioHanky
		(gEgo get: ((ScriptID 64037 0) get: 48)) ; oInvHandler, ioHankyLubed
		((ScriptID 64017 0) set: 128) ; oFlags
	)

	(method (dispose)
		(if (gEgo has: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
			(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
		)
		(gOMusic1 stop:)
		(gOSound1 stop:)
		(super dispose: &rest)
	)
)

(instance soGetBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc60_1 0)
				(if local0
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(gGame handsOff:)
				(poALarry
					view: 39000
					loop: 0
					cel: 0
					posn: 350 420
					setPri: 500
					show:
					setCycle: End self 15 9999
				)
				(gEgo hide:)
			)
			(2
				(gOSound1 playSound: 39002)
			)
			(3
				(gEgo show:)
				(poALarry hide: setPri: 100)
				(poWalrusTailFlip
					loop: 1
					cel: 0
					show:
					setCycle: End self 6 9999
				)
			)
			(4
				(gOSound1 playSound: 39003)
			)
			(5
				(voWalrusTailUp show:)
				(voBall show:)
				(poWalrusTailFlip hide:)
				(= local0 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeFirstBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poALarry
					view: 39005
					loop: 0
					cel: 0
					posn: 304 384
					setPri: 500
					show:
					setCycle: End self 11 24 9999
				)
				(gEgo hide:)
			)
			(1
				(= local6 0)
				(gMessager say: 2 8 0 0 coEndTalk) ; "(SMALL HEAVY OBJECT) Umm."
			)
			(2
				(voBall hide:)
			)
			(3
				(foHeldBall init:)
				(foLane addHotspotVerb: 79)
				(= local7 0)
				(= local0 0)
				(gEgo get: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(if (not local6)
					(gMessager kill:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(poALarry
					view: 39005
					loop: 0
					cel: 16
					posn: 304 384
					setPri: 500
					show:
					setCycle: End self 24 9999
				)
				(gEgo hide:)
			)
			(1
				(voBall hide:)
			)
			(2
				(foHeldBall init:)
				(foLane addHotspotVerb: 79)
				(= local7 0)
				(= local0 0)
				(gEgo get: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(if (not local6)
					(gMessager kill:)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soWipeBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 64017 0) set: 14) ; oFlags
				(if (!= ((ScriptID 64037 2) priority:) -1) ; oInvPlane
					((ScriptID 64037 2) setPri: -1) ; oInvPlane
				)
				(= local6 0)
				(if local3
					(if ((ScriptID 64017 0) test: 128) ; oFlags
						(gMessager say: 2 56 2 1 coEndTalk) ; "Now things ought to happen!"
					else
						(gMessager say: 2 55 0 1 coEndTalk) ; "You carefully wipe off all traces of walrus from your ball."
					)
				else
					(gMessager say: 2 55 0 1 coEndTalk) ; "You carefully wipe off all traces of walrus from your ball."
				)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(poALarry
					view: 39005
					loop: 1
					cel: 0
					posn: 304 384
					show:
					setCycle: CT 9 1 self
				)
				(gEgo hide:)
			)
			(2
				(gOSound1 playSound: 39004)
				(poALarry setCycle: ROsc 2 9 16 self)
			)
			(3
				(poALarry setCycle: End self)
			)
			(4
				(if (not local6)
					(-= state 1)
				)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soTakeWipeBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local7
					(self setScript: soTakeFirstBall self)
				else
					(self setScript: soTakeBall self)
				)
			)
			(1
				(self setScript: soWipeBall self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLarryBowlsBad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(foHeldBall dispose:)
				(poALarry
					view: 39006
					loop: 0
					cel: 0
					posn: 304 384
					cycleSpeed: 6
					show:
					setCycle: End self 3 17
				)
				(gEgo hide:)
			)
			(1
				(proc80_1 0)
				(oShortSound playSound: 39101)
			)
			(2
				(switch (Random 0 3)
					(0
						(self setScript: soGutterBall self)
					)
					(1
						(self setScript: soCornerPins self)
					)
					(2
						(self setScript: soMorePins self)
					)
					(3
						(self setScript: soSplitPins self)
					)
				)
				(poWalrusTailFlip cel: 0 show:)
				(voWalrusTailUp hide:)
				(poALarry view: 39007 loop: 0 cel: 0 posn: 413 329 setCycle: 0)
			)
			(3
				(poALarry
					view: 39007
					loop: 0
					cel: 0
					posn: 413 329
					setCycle: End self 2
				)
			)
			(4
				(gMessager say: 3 57 2 1 self) ; "(BOWLING SOUNDS) Ugh. Ah."
			)
			(5
				(= local6 0)
				(if (and local4 ((ScriptID 64017 0) test: 128)) ; oFlags
					(gMessager say: 3 57 6 1 self) ; "That sucked."
				else
					(gMessager say: 3 57 6 (Random 2 5) self)
				)
			)
			(6
				(oShortSound playSound: 39103)
				(if (and local4 ((ScriptID 64017 0) test: 128)) ; oFlags
					(= local4 0)
					(poALarry setCycle: End self)
				else
					(poALarry setCycle: End self)
				)
				(gEgo posn: 408 325)
			)
			(7
				(gEgo normalize: 4 1 show:)
				(poALarry hide:)
				(= cycles 1)
			)
			(8
				(if ((ScriptID 64017 0) test: 128) ; oFlags
					(if local1
						(if local2
							(= cycles 1)
						else
							(= local2 1)
							(gMessager sayRange: 3 57 2 2 3 self) ; "The ship's movements cause your balls to careen madly."
						)
					else
						(= local1 1)
						(gMessager say: 3 57 2 2 self) ; "The ship's movements cause your balls to careen madly."
					)
				else
					(= cycles 1)
				)
			)
			(9
				(if local8
					(= local8 0)
				else
					(= local8 1)
				)
				(if (gEgo has: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
					(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				)
				(gGame handsOn:)
				(proc80_1 1)
				(proc60_1)
				(self dispose:)
			)
		)
	)
)

(instance soLarryStrikes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(foHeldBall dispose:)
				(gMessager say: 3 57 3 1 self) ; "This has got to do it!"
			)
			(1
				(poALarry
					view: 39006
					loop: 0
					cel: 0
					posn: 304 384
					setPri: 100
					show:
					setCycle: End self 17 9999
				)
				(proc80_1 0)
			)
			(2
				(gOSound1 playSound: 39101)
			)
			(3
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall view: 39101 loop: 0 cel: 0 init: hide:)
				(poExplodingPins view: 39102 loop: 0 cel: 0 init: hide:)
				(= ticks 10)
			)
			(4
				(poRolledBall show: setCycle: CT 4 1 self)
			)
			(5
				(poExplodingPins show: setCycle: End self)
				(poRolledBall hide:)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(= local9 1)
				(= local10 1)
				(= local11 1)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(6
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(7
				(proc64896_17 100)
				(poALarry
					view: 39008
					loop: 0
					cel: 0
					posn: 413 329
					show:
					setCycle: CycleCueList 15 1 self 11
				)
			)
			(8
				(gMessager say: 3 57 3 2 self) ; "Woof woof woof."
			)
			(9
				(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(self setScript: soStrikeFinale2 self)
			)
			(10
				(gEgo posn: 392 353 normalize: 4 show:)
				(poALarry hide:)
				((ScriptID 64017 0) set: 103) ; oFlags
				((ScriptID 80 0) setReal: (ScriptID 80 0) 5) ; oAnnounceTimer, oAnnounceTimer
				(gGame handsOn:)
				(proc80_1 1)
				(proc60_1)
				(self dispose:)
			)
		)
	)
)

(instance soStrikeFinale1 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSound: 39101)
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39101
					loop: 0
					cel: 0
					setPri: 600
					init:
					setCycle: CT 4 1 self
				)
			)
			(1
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
				(poRolledBall hide:)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(2
				(proc64896_1 1 15 self)
			)
			(3
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(4
				(proc64896_17 100)
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(5
				(proc64896_1 1 20 self)
			)
			(6
				(poCenterPins show:)
				(poLeftPins show:)
				(poRightPins show:)
				(poExplodingPins hide: cel: 0)
				(proc64896_17 100)
				(= ticks 60)
			)
			(7
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					show:
					setCycle: End self
				)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(8
				(proc64896_1 1 30 self)
			)
			(9
				(poCenterPins show:)
				(poLeftPins show:)
				(poRightPins show:)
				(poExplodingPins hide: cel: 0)
				(proc64896_17 100)
				(= ticks 60)
			)
			(10
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					show:
					setCycle: End self
				)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(11
				(proc64896_1 1 40 self)
			)
			(12
				(poCenterPins show:)
				(poLeftPins show:)
				(poRightPins show:)
				(poExplodingPins hide: cel: 0)
				(proc64896_17 100)
				(= ticks 60)
			)
			(13
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					show:
					setCycle: End self
				)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(14
				(proc64896_1 1 60 self)
			)
			(15
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(16
				(proc64896_17 100)
				(poALarry
					view: 39009
					loop: 0
					cel: 0
					posn: 391 349
					show:
					setCycle: CT 2 1 self
				)
			)
			(17
				(= ticks 120)
			)
			(18
				(poALarry setCycle: End self)
			)
			(19
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance soStrikeFinale2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 39104) ; WAVE
				(Load rsVIEW 39102)
				(gOSound1 playSound: 39101)
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39101
					loop: 0
					cel: 0
					init:
					setCycle: CT 4 1 self
				)
			)
			(1
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
				(poRolledBall hide:)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(2
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(3
				(proc64896_17 100)
				(poALarry show: setCycle: CT 20 1 self)
			)
			(4
				(gOSound1 playSound: 39101)
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39101
					loop: 0
					cel: 0
					init:
					setCycle: CT 4 1 self
				)
			)
			(5
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
				(poRolledBall hide:)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(6
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(7
				(proc64896_17 100)
				(poALarry show: setCycle: CT 39 1 self)
			)
			(8
				(gOSound1 playSound: 39101)
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39101
					loop: 0
					cel: 0
					init:
					setCycle: CT 4 1 self
				)
			)
			(9
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
				(poRolledBall hide:)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(10
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(11
				(proc64896_17 100)
				(poALarry show: setCycle: End self)
			)
			(12
				(poALarry
					view: 39009
					loop: 0
					cel: 0
					posn: 391 349
					doit:
					setCycle: CT 2 1 self
				)
			)
			(13
				(gOSound1 playSound: 39101)
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39101
					loop: 0
					cel: 0
					init:
					setCycle: CT 4 1 self
				)
			)
			(14
				(poExplodingPins
					view: 39102
					loop: 0
					cel: 0
					init:
					setCycle: End self
				)
				(poRolledBall hide:)
				(poCenterPins hide:)
				(poLeftPins hide:)
				(poRightPins hide:)
				(oShortSound setRelVol: 400 playSound: 39104)
			)
			(15
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(16
				(proc64896_17 100)
				(poALarry show: setCycle: End self)
			)
			(17
				(= ticks 120)
			)
			(18
				(poALarry setCycle: End self)
			)
			(19
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

(instance soGutterBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39100
					loop: (Random 0 1)
					cel: 0
					setPri: 400
					init:
					hide:
				)
				(= ticks 15)
			)
			(1
				(poRolledBall show: setCycle: End self 8 9)
			)
			(2
				(poRolledBall setPri: 1)
			)
			(3
				(poRolledBall hide:)
				(= local9 1)
				(= local10 1)
				(= local11 1)
				(= cycles 1)
			)
			(4
				(oShortSound playSound: 39102)
				(= ticks 30)
			)
			(5
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(6
				(poRolledBall dispose:)
				(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(self dispose:)
			)
		)
	)
)

(instance soCornerPins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39100
					loop: (Random 2 3)
					cel: 0
					setPri: 400
					init:
					hide:
				)
				(= ticks 15)
			)
			(1
				(poRolledBall show: setCycle: End self 6 8 9999)
			)
			(2
				(if (== (poRolledBall loop:) 2)
					(poLeftPins hide:)
					(= local9 1)
					(= local10 0)
					(= local11 1)
				else
					(poRightPins hide:)
					(= local9 1)
					(= local10 1)
					(= local11 0)
				)
			)
			(3
				(poRolledBall setPri: 10)
			)
			(4
				(poRolledBall hide:)
				(oShortSound playSound: 39102)
				(= ticks 30)
			)
			(5
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(6
				(poRolledBall dispose:)
				(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(self dispose:)
			)
		)
	)
)

(instance soMorePins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39100
					loop: (Random 2 3)
					cel: 0
					setPri: 400
					init:
					hide:
				)
				(= ticks 15)
			)
			(1
				(poRolledBall show: setCycle: End self 6 8 9999)
			)
			(2
				(poCenterPins hide:)
				(if (== (Random 1 3) 2)
					(if (== (poRolledBall loop:) 2)
						(poLeftPins hide:)
						(= local9 0)
						(= local10 0)
						(= local11 1)
					else
						(poRightPins hide:)
						(= local9 0)
						(= local10 1)
						(= local11 0)
					)
				)
			)
			(3
				(poRolledBall setPri: 10)
			)
			(4
				(poRolledBall hide:)
				(oShortSound playSound: 39102)
				(= ticks 30)
			)
			(5
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(6
				(poRolledBall dispose:)
				(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(self dispose:)
			)
		)
	)
)

(instance soSplitPins of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom addRoomPlane: oAlleyPlane)
				(poRolledBall
					view: 39101
					loop: 0
					cel: 0
					setPri: 400
					init:
					hide:
				)
				(= ticks 15)
			)
			(1
				(poRolledBall show: setCycle: End self 6 8 9999)
			)
			(2
				(= local9 0)
				(= local10 1)
				(= local11 1)
				(poCenterPins hide:)
				(poRolledBall hide:)
			)
			(3
				(poRolledBall setPri: 10)
			)
			(4
				(oShortSound playSound: 39102)
				(= ticks 30)
			)
			(5
				(gCurRoom deleteRoomPlane: oAlleyPlane)
				(= cycles 1)
			)
			(6
				(poRolledBall dispose:)
				(gEgo put: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
				(self dispose:)
			)
		)
	)
)

(instance soReturnBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 5 1 self 390) ; "Bowling balls may not be removed from the bowling area."
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soBowler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(self setScript: soBowlerPoses self)
			)
			(2
				(= ticks (Random 90 180))
			)
			(3
				(self setScript: soBowlerScratches self)
			)
			(4
				(= ticks (Random 90 180))
			)
			(5
				(self setScript: soBowlerWalksOff self)
			)
			(6
				(= ticks (Random 90 180))
			)
			(7
				(self setScript: soBowlerWalksOn self)
			)
			(8
				(= ticks (Random 90 180))
			)
			(9
				(self setScript: soBowlerWipesBall self)
			)
			(10
				(= ticks (Random 90 180))
			)
			(11
				(self setScript: soBowlerBowls self)
			)
			(12
				(self changeState: 1)
			)
		)
	)
)

(instance soBowlerPoses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local5
					(if (== 1 (Random 0 1))
						(poABowler
							view: 39002
							loop: 1
							cel: 0
							setCycle: CT 5 1 self
						)
					else
						(poABowler
							view: 39002
							loop: 1
							cel: 0
							setCycle: CT 9 1 self
						)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if local5
					(poABowler view: 39002 loop: 1 cel: 0 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soBowlerScratches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39003 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soBowlerWalksOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39001 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(poABowler hide:)
				(self dispose:)
			)
		)
	)
)

(instance soBowlerWalksOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39001 loop: 1 cel: 0 show: setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soBowlerWipesBall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39001 loop: 2 cel: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soBowlerBowls of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local5
					(= local5 0)
					(self setScript: soSinglePin self)
				else
					(switch (Random 0 1)
						(0
							(self setScript: soAllPinsA self)
							(= local5 0)
						)
						(1
							(self setScript: soAllPinsB self)
							(= local5 1)
						)
					)
				)
			)
			(1
				(if local5
					(= cycles 1)
				else
					(poSmallPins view: 39004 loop: 4 cel: 0)
					(poABowler view: 39002 loop: 1 cel: 0 setCycle: End self)
				)
			)
			(2
				(if local5
					(= cycles 1)
				else
					(poSmallPins cycleSpeed: 16 setCycle: End self)
				)
			)
			(3
				(if (not local5)
					(poSmallPins view: 39004 loop: 0 cel: 0 cycleSpeed: 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance soAllPinsA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39002 loop: 0 cel: 0 setCycle: End self 15)
			)
			(1
				(oBowlerSound playSound: 39101)
				(poSmallPins view: 39004 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(oBowlerSound playSound: 39102 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soAllPinsB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39002 loop: 0 cel: 0 setCycle: End self 15)
			)
			(1
				(oBowlerSound playSound: 39101)
				(poSmallPins view: 39004 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(oBowlerSound playSound: 39102 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soSinglePin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poABowler view: 39002 loop: 0 cel: 0 setCycle: End self 15)
			)
			(1
				(oBowlerSound playSound: 39101)
				(poSmallPins view: 39004 loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(oBowlerSound playSound: 39102 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soDildo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 50 0) ; oDildo
					setStep: 3 10
					setCycle: Walk
					setMotion: MoveTo 416 387 self
				)
			)
			(1
				((ScriptID 50 0) ; oDildo
					setStep: 4 20
					setPri: 600
					setCycle: Walk
					setMotion: MoveTo 447 432 self
				)
			)
			(2
				((ScriptID 50 0) ; oDildo
					setStep: 5 25
					setCycle: Walk
					setMotion: MoveTo 432 500 self
				)
			)
			(3
				((ScriptID 50 0) setStep: 6 30) ; oDildo
				(self dispose:)
			)
		)
	)
)

(instance poALarry of Prop
	(properties
		x 350
		y 420
		priority 100
		fixPriority 1
		view 39000
	)
)

(instance poLarryScans of Prop ; UNUSED
	(properties
		x 357
		y 429
		view 39000
	)
)

(instance poWalrusTailFlip of Prop
	(properties
		x 170
		y 325
		priority 420
		fixPriority 1
		view 39000
		loop 1
	)
)

(instance poABowler of Prop
	(properties
		noun 5
		approachX 50
		approachY 270
		x 50
		y 270
		view 39002
		loop 1
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
		(self setScript: soBowler)
	)
)

(instance poSmallPins of Prop
	(properties
		x 70
		y 258
		view 39004
	)
)

(instance poRolledBall of Prop
	(properties
		x 319
		y 448
		priority 400
		fixPriority 1
		view 39100
	)
)

(instance poCenterPins of Prop
	(properties
		x 315
		y 230
		view 39103
	)
)

(instance poLeftPins of Prop
	(properties
		x 315
		y 230
		view 39103
		loop 1
	)
)

(instance poRightPins of Prop
	(properties
		x 315
		y 230
		view 39103
		loop 2
	)
)

(instance poExplodingPins of Prop
	(properties
		x 319
		y 448
		priority 50
		fixPriority 1
		view 39102
	)
)

(instance voBall of View
	(properties
		noun 2
		approachX 111
		approachY 434
		x 42
		y 437
		priority 420
		fixPriority 1
		view 39000
		loop 2
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 8)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Take
				((ScriptID 64017 0) set: 101) ; oFlags
				(if local7
					(gCurRoom setScript: soTakeFirstBall)
				else
					(gCurRoom setScript: soTakeBall)
				)
			)
			(55 ; Woman's Handkerchief
				(= local4 1)
				(gCurRoom setScript: soTakeWipeBall)
			)
			(56 ; Treated Handkerchief
				(= local3 1)
				(gCurRoom setScript: soTakeWipeBall)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voWalrusTailUp of View
	(properties
		x 170
		y 325
		priority 410
		fixPriority 1
		view 39000
		loop 3
	)
)

(instance foLane of Feature
	(properties
		noun 3
		approachX 116
		approachY 453
		approachDist 1000
		x 495
		y 249
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 469 320 639 219 639 178 351 299
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(79 ; Play
				(if (gEgo has: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
					(if (and local3 ((ScriptID 64017 0) test: 128)) ; oFlags
						((ScriptID 64017 0) set: 102) ; oFlags
						(gCurRoom setScript: soLarryStrikes)
					else
						(gCurRoom setScript: soLarryBowlsBad)
					)
					(self deleteHotspotVerb: 79)
				else
					(gMessager say: 2 54 0 3) ; "Never mind."
				)
			)
			(57 ; Bowling Ball
				(if (and local3 ((ScriptID 64017 0) test: 128)) ; oFlags
					((ScriptID 64017 0) set: 102) ; oFlags
					(gCurRoom setScript: soLarryStrikes)
				else
					(gCurRoom setScript: soLarryBowlsBad)
				)
				(self deleteHotspotVerb: 79)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foWalrus of Feature
	(properties
		noun 1
		approachX 350
		approachY 420
		x 241
		y 338
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 401 302 380 308 356 313 351 314 342 312 331 305 320 297 314 293 309 292 298 284 286 276 280 264 277 252 269 248 268 241 266 226 266 196 282 177 303 168 330 169 350 172 360 182 366 182 374 185 383 191 389 194 386 205 373 214 373 222 371 237 374 255 369 260 368 258 393 259 409 262 410 264 387 269 369 277 368 285 362 290 359 298 359 294 379 290 396
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: ((ScriptID 64037 0) get: 2)) ; oInvHandler, ioBowlingBall
					(gMessager say: 1 1 1 1) ; "At least you now know where the bowling balls come from."
				else
					(gMessager say: 1 1 0 1) ; "Why would they decorate the bowling alley with a fiberglass walrus?"
				)
			)
			(16 ; TMT Scorecard
				((ScriptID 64017 0) set: 244) ; oFlags
				(cond
					(((ScriptID 64017 0) test: 103) ; oFlags
						(gMessager say: 2 54 0 3) ; "Never mind."
					)
					((or local0 (gEgo has: ((ScriptID 64037 0) get: 2))) ; oInvHandler, ioBowlingBall
						(gMessager say: 1 1 1 1) ; "At least you now know where the bowling balls come from."
					)
					(else
						(gCurRoom setScript: soGetBall)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foHeldBall of Feature
	(properties
		noun 2
		approachDist 1000
		x 407
		y 500
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 405 300 411 305 411 311 406 311 402 303
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 79)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; Woman's Handkerchief
				(= local4 1)
				(gCurRoom setScript: soWipeBall)
			)
			(56 ; Treated Handkerchief
				(= local3 1)
				(gCurRoom setScript: soWipeBall)
			)
			(79 ; Play
				(foLane doVerb: theVerb)
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
					init: 0 429 639 429 639 479 0 479
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

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local6 1)
	)
)

(instance oAlleySounds of TPSound
	(properties)
)

(instance oShortSound of TPSound
	(properties)
)

(instance oBowlerSound of TPSound
	(properties)
)

(instance oAlleyPlane of Plane
	(properties
		picture 39100
		priority 20
	)

	(method (init)
		(gThePlane drawPic: -1)
		(super
			init:
				(gThePlane left:)
				(gThePlane top:)
				(gThePlane right:)
				(gThePlane bottom:)
		)
		(if local8
			(poCenterPins init:)
			(poLeftPins init:)
			(poRightPins init:)
		else
			(if local9
				(poCenterPins init:)
			)
			(if local10
				(poLeftPins init:)
			)
			(if local11
				(poRightPins init:)
			)
		)
	)

	(method (dispose)
		(gThePlane drawPic: 39000)
		(super dispose: &rest)
	)
)

