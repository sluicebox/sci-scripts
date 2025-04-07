;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use soFlashCyberSniff)
(use foEExit)
(use Plane)
(use Array)
(use Talker)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	ro220 0
	proc220_1 1
)

(local
	local0
)

(procedure (proc220_1 &tmp temp0 temp1)
	(if (not global241)
		(= global241 (IntArray newWith: 13))
	)
	(if (not ((ScriptID 64017 0) test: 33)) ; oFlags
		(return)
	)
	(for ((= temp0 0)) (< temp0 13) ((++ temp0))
		(cond
			((or (== (= temp1 (global241 at: temp0)) 5) (== temp1 -1)))
			((== (Random 0 (* (+ temp1 4) 8)) 1)
				(++ temp1)
				(global241 at: temp0 temp1)
			)
		)
	)
)

(instance ro220 of L7Room
	(properties
		picture 22000
	)

	(method (init)
		(gEgo init: setScaler: Scaler 150 90 475 294)
		(switch gPrevRoomNum
			(222 ; ro222
				(gEgo posn: 211 342 normalize: 4)
			)
			(else
				(gEgo posn: 108 382 normalize: 4)
			)
		)
		(super init: &rest)
		(gOMusic1 setMusic: 0)
		(gOAmbience setAmbient: 13001)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 102 343 57 367 248 459 425 474 425 422 444 350 491 296 473 293
					yourself:
				)
		)
		(poDoor init:)
		(foExitWest init:)
		(foThyghEntrance init:)
		(foBoard init:)
		(foRailing init:)
		(if (not ((ScriptID 64017 0) test: 29)) ; oFlags
			(foPorthole init:)
		)
		(gGame handsOn:)
	)

	(method (gimme)
		((ScriptID 64017 0) set: 115 113 89 103 45 127 33) ; oFlags
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 210 220 230 250 260 262)) ; ro210, ro220, ro230, ro250, ro260, ro262
			(gOAmbience stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance oAmbience of TPSound ; UNUSED
	(properties)
)

(instance soTestScoreboard of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (gCurRoom plane:) oScoreboardPlane)
					(gCurRoom addRoomPlane: oScoreboardPlane)
				)
				(= local0 0)
				(= cycles 1)
			)
			(1
				(gCurRoom deleteRoomPlane: oScoreboardPlane)
				(proc220_1)
				(gCurRoom addRoomPlane: oScoreboardPlane)
				(++ local0)
				(PrintDebug {Cranks: %d} local0)
				(= cycles 1)
				(if (< local0 100)
					(-- state)
				)
			)
			(2
				(gCurRoom deleteRoomPlane: oScoreboardPlane)
				(self dispose:)
			)
		)
	)
)

(instance foExitWest of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 0 40 0 40 480 0 480 yourself:)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 4)) ; oWestCursor
	)

	(method (doVerb)
		(gCurRoom exitRoom: 210 -35 345)
	)
)

(instance foBoard of Feature
	(properties
		noun 2
		x 354
		y 276
		approachX 387
		approachY 323
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 110 440 139 435 251 296 265
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(if ((ScriptID 64017 0) test: 33) ; oFlags
			(self addApproachVerb: 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 64017 0) test: 33) ; oFlags
					(gCurRoom addRoomPlane: oScoreboardPlane)
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

(instance oScoreboardPlane of Plane
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= picture 22100)
		(super init: 0 0 639 479)
		(foCUExit init:)
		(foScoreboardCU init:)
		(if (not global241)
			(= global241 (IntArray newWith: 13))
		)
		(if (> (= temp2 (proc64896_22)) 0)
			(global241 at: 12 -1)
			(global241 at: 5 -1)
		)
		(if (> temp2 1)
			(global241 at: 3 -1)
			(global241 at: 8 -1)
		)
		(if (> temp2 2)
			(global241 at: 2 -1)
			(global241 at: 0 -1)
		)
		(if (> temp2 3)
			(global241 at: 4 -1)
			(global241 at: 11 -1)
		)
		(if (> temp2 4)
			(global241 at: 1 -1)
			(global241 at: 7 -1)
		)
		(if (> temp2 5)
			(for ((= temp0 0)) (< temp0 13) ((++ temp0))
				(global241 at: temp0 -1)
			)
		)
		(for ((= temp0 0)) (< temp0 13) ((++ temp0))
			(= temp3 (ScoreMarker new:))
			(if (== temp0 9)
				(= temp1 temp2)
			else
				(= temp1 (global241 at: temp0))
			)
			(temp3 nLine: temp0 nScore: temp1 init:)
		)
	)
)

(instance foCUExit of CUExitFeature
	(properties)

	(method (doVerb)
		(gCurRoom deleteRoomPlane: oScoreboardPlane)
	)
)

(instance foScoreboardCU of Feature
	(properties)

	(method (init)
		(self setRect: 0 0 639 479)
		(= y -5)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (getName)
		(MakeMessageText 0 68 0 1 221) ; "Captain Thygh's Leader Board"
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: soLookAtBoardCU)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance soLookAtBoardCU of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 1 0 1 self 221) ; "Captain Thygh's whiteboard graphically displays the relative progress of the leading contestants in her "Thygh's Man Trophy" race."
			)
			(1
				(switch (proc64896_22)
					(0
						(gMessager say: 0 1 1 1 self 221) ; "You're not doing very well."
					)
					(1
						(gMessager say: 0 1 1 1 self 221) ; "You're not doing very well."
					)
					(2
						(gMessager say: 0 1 1 2 self 221) ; "You're doing all right, but you're a long way from first place."
					)
					(3
						(gMessager say: 0 1 1 3 self 221) ; "You know, you just might be able to pull this one together, Larry."
					)
					(4
						(gMessager say: 0 1 1 4 self 221) ; "Your cheating has served you well. Now, just don't get caught now!"
					)
					(5
						(gMessager say: 0 1 1 5 self 221) ; "You can almost taste the sweetness of victory... if you can win, that is."
					)
					(6
						(gMessager say: 0 1 1 4 self 221) ; "Your cheating has served you well. Now, just don't get caught now!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foPorthole of Feature
	(properties
		noun 4
		x 198
		y 295
		approachX 238
		approachY 345
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 198 129 213 139 219 164 209 188 195 197 176 188 171 166 175 146 189 129
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foRailing of Feature
	(properties
		noun 3
		x 242
		y 55
		approachDist 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 26 61 1 238 1 333 16 488 68 473 111 303 65 104 41 2 73
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance poDoor of Prop
	(properties
		priority 20
		x 198
		y 318
		view 22050
		fixPriority 1
	)

	(method (init)
		(if ((ScriptID 64017 0) test: 29) ; oFlags
			(= cel 3)
		else
			(= cel 0)
		)
		(super init: &rest)
	)
)

(instance foThyghEntrance of Feature
	(properties
		x 198
		y 294
		approachX 238
		approachY 345
	)

	(method (init)
		(self setRect: 137 95 248 315)
		(super init: &rest)
		(if ((ScriptID 64017 0) test: 29) ; oFlags
			(self forceCursor: (ScriptID 64006 6)) ; oNorthWestCursor
			(= noun 0)
		else
			(= noun 1)
			(AddDefaultVerbs self)
			(self addHotspotVerb: 61)
		)
	)

	(method (doVerb theVerb)
		(if ((ScriptID 64017 0) test: 29) ; oFlags
			(gCurRoom setScript: soExitToThygh)
			(return)
		)
		(switch theVerb
			(222 ; Knock
				(if
					(and
						((ScriptID 64017 0) test: 115) ; oFlags
						((ScriptID 64017 0) test: 113) ; oFlags
						((ScriptID 64017 0) test: 89) ; oFlags
						((ScriptID 64017 0) test: 103) ; oFlags
						((ScriptID 64017 0) test: 45) ; oFlags
						((ScriptID 64017 0) test: 127) ; oFlags
					)
					(gCurRoom setScript: soEnterThyghFirstTime)
				else
					(gCurRoom setScript: soKnock)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance oPlayerVoice of TPSound
	(properties
		type 2
	)
)

(instance soKnock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 222 0 1 self) ; "Is this a good idea?"
			)
			(1
				(gOSound1 playSound: 22000 self)
			)
			(2
				(gCurRoom addRoomPlane: oPlayerPlane)
				(if (proc64896_21 9)
					(oPlayerVoice playSubtitledSound: 9 1 222 0 2 self)
				else
					(gMessager say: 1 222 0 2 self) ; "Waddaya want? I'm busy! Ooohhh."
				)
			)
			(3
				(gMessager sayRange: 1 222 0 3 4 self) ; "Uh, nothing."
			)
			(4
				(if (proc64896_21 10)
					(oPlayerVoice playSubtitledSound: 10 1 222 0 5 self)
				else
					(gMessager say: 1 222 0 5 self) ; "Okay! I, I... I gotta go!"
				)
			)
			(5
				(gCurRoom deleteRoomPlane: oPlayerPlane)
				(gMessager say: 1 222 0 6 self) ; "(OFF MIKE) Get the Mazola oil!"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oPlayerPlane of Plane
	(properties
		picture 22300
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(if (proc64896_19)
			(voPlayerBMP init:)
		)
	)
)

(instance voPlayerBMP of View
	(properties
		priority 1
		x 150
		y 75
		fixPriority 1
	)

	(method (init)
		(= bitmap (proc64896_20 340 340))
		(if (not bitmap)
			(PrintDebug {Failure to create bitmap})
			(return)
		)
		(super init: &rest)
	)

	(method (dispose)
		(if bitmap
			(Bitmap 1 bitmap) ; Dispose
			(= bitmap 0)
		)
		(super dispose: &rest)
	)
)

(instance soEnterThyghFirstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gOSound1 playSound: 22000 self)
			)
			(1
				(gEgo walkTo: 281 333 self)
			)
			(2
				(gEgo setHeading: 315 self)
			)
			(3
				(gMessager say: 1 222 1 1 self) ; "(SUPREMELY CONFIDENT) Okay, Cap'n. Prepare to meet your new master!"
			)
			(4
				(poDoor cel: 1 cycleSpeed: 15 doit: setCycle: End self)
				(poSteam
					view: 22000
					posn: 198 318
					cel: 0
					cycleSpeed: 10
					init:
					setCycle: End
				)
			)
			(5
				(poLarry
					view: 22002
					loop: 0
					cel: 0
					posn: 287 336
					init:
					setCycle: CT 4 1 self
				)
				(gEgo hide:)
			)
			(6
				(= ticks 60)
			)
			(7
				(poLarry setCycle: End self 11 999)
			)
			(8
				(poArm
					view: 22005
					loop: 0
					cel: 0
					posn: 135 212
					setPri: 21
					init:
					setCycle: End
				)
			)
			(9
				(= ticks 40)
			)
			(10
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(poLarryCUBody view: 22007 loop: 0 cel: 0 posn: 290 403 init:)
				(poLarryCUHead
					view: 22007
					loop: 1
					cel: 0
					posn: 290 403
					setPri: 404
					cycleSpeed: 15
					init:
					setCycle: End self
				)
			)
			(11
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(poArm dispose:)
				(poSteam dispose:)
				(poLarry view: 22015 loop: 0 cel: 0 posn: 320 374 doit:)
				(= cycles 1)
			)
			(12
				(= ticks 120)
			)
			(13
				(poLarry dispose:)
				(gCurRoom addRoomPlane: oStretcherPlane)
				(FrameOut)
				(= ticks 60)
			)
			(14
				(gMessager say: 1 222 1 2 self) ; "(SHOCKED AND SCARED) God, man! What happened to you!?"
			)
			(15
				(poStretcherMouth setCycle: RandCycle)
				(if (proc64896_21 11)
					(oPlayerVoice playSubtitledSound: 11 1 222 1 3 self)
				else
					(gMessager say: 1 222 1 3 self) ; "I'm last week's winner. Or... what's left of me!"
				)
			)
			(16
				(poStretcherMouth setCycle: 0)
				(gCurRoom deleteRoomPlane: oStretcherPlane)
				(gCurRoom addRoomPlane: oLarryCUPlane)
				(poLarryCUBody view: 22009 loop: 0 cel: 0 posn: 290 403 init:)
				(poLarryCUHead
					view: 22009
					loop: 1
					cel: 0
					posn: 290 403
					cycleSpeed: 15
					setPri: 404
					init:
					setCycle: CT 2 1 self
				)
				(if (proc64896_21 12)
					(oPlayerVoice playSubtitledSound: 12 1 222 1 4 self)
				else
					(gMessager say: 1 222 1 4 self) ; "Don't go in there!!"
				)
			)
			(17)
			(18
				(poLarryCUHead setCycle: CT 6 1 self)
				(gMessager say: 1 222 1 5 self) ; "Are you sure you want to continue, Larry?"
			)
			(19)
			(20
				(= ticks 40)
			)
			(21
				(poLarryCUHead setCycle: End self)
			)
			(22
				(poLarryCUHead dispose:)
				(poLarryCUBody view: 22010 loop: 0 cel: 0 doit:)
				(voLarryCUMouth init:)
				(= global330 toLarryCU)
				(gMessager say: 1 222 1 6 self) ; "I made it this far; I'm not quitting now!"
			)
			(23
				(= global330 0)
				(= ticks 40)
			)
			(24
				(gCurRoom deleteRoomPlane: oLarryCUPlane)
				(gEgo
					hide:
					posn: 335 338
					normalize: 5 1
					show:
					walkTo: 211 338 self
				)
			)
			(25
				(gEgo setHeading: 315 self)
			)
			(26
				(gCurRoom newRoom: 221) ; ro221
			)
		)
	)
)

(instance soExitToThygh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo walkTo: 211 338 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 315 self)
			)
			(2
				(gCurRoom newRoom: 222) ; ro222
			)
		)
	)
)

(instance poLarry of Prop
	(properties)
)

(instance poArm of Prop
	(properties)
)

(instance poSteam of Prop
	(properties)
)

(instance poLarryCUHead of Prop
	(properties)
)

(instance poLarryCUBody of Prop
	(properties)
)

(instance voLarryCUMouth of View
	(properties
		priority 404
		x 290
		y 403
		loop 1
		view 22010
		fixPriority 1
	)
)

(instance toLarryCU of Talker
	(properties
		priority 404
		x 290
		y 403
		loop 1
		view 22010
	)

	(method (init)
		(voLarryCUMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voLarryCUMouth show:)
		(super dispose: &rest)
	)
)

(instance oLarryCUPlane of Plane
	(properties
		picture 22310
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
	)
)

(instance oStretcherPlane of Plane
	(properties
		picture 22320
	)

	(method (init)
		(super init: 0 0 639 479 &rest)
		(poStretcherMouth cel: 0 init:)
	)
)

(instance poStretcherMouth of Prop
	(properties
		x 532
		y 416
		view 22017
	)
)

(class ScoreMarker of View
	(properties
		view 22150
		nLine 0
		nScore 0
	)

	(method (init)
		(if (== nScore -1)
			(= loop 1)
			(= cel 0)
			(= x 88)
			(= y (+ 53 (* nLine 31)))
			(+= x (- (mod (* nLine 13) 5) 2))
			(+= y (- (mod (* nLine 17) 5) 2))
		else
			(= loop 0)
			(= cel (/ (+ nScore 1) 3))
			(= x (+ 159 (* nScore 37)))
			(= y (+ 50 (* nLine 31)))
		)
		(super init: &rest)
	)
)

