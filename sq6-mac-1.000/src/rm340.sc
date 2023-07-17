;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQIconbar)
(use ExitFeature)
(use DText)
(use Str)
(use Array)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use DPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0 = 1
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8 = 9
	local9
	local10
	local11
	local12
	local13
	local14
	local15
)

(procedure (localproc_0 param1 param2 param3 param4)
	(Message msgGET 340 param1 param2 param3 param4 (local13 data:))
	(= local1 (IntArray with: 0 0 0 0))
	(Text 0 (local1 data:) (local13 data:) 340 60)
	((= local2 (DText new:))
		text: (KString 8 (local13 data:)) ; StrDup
		fore: 0
		font: 340
		x: (- 61 (/ (local1 at: 2) 2))
		y: 47
		mode: 1
		ignoreActors: 1
		setPri: 50
		setSize: 60
		init:
	)
)

(instance rm340 of SQRoom
	(properties
		noun 1
		picture 340
	)

	(method (init)
		(gEgo init: normalize:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 116 111 116 111 121 87 135 244 135 297 135 267 124 262 115 318 115 318 110 238 110 226 105 226 100 237 100 237 99 220 99 198 100 160 92 144 87 126 87 126 89 144 89 151 92 154 97 150 104 135 107 0 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 243 123 263 123 263 126 243 126
					yourself:
				)
		)
		(= local13 (Str newWith: 200 {}))
		(hole init:)
		(if (IsFlag 0)
			(if (!= gPrevRoomNum 24) ; whereTo
				(SQIconbar init:)
			)
			(gEgo
				view: 425
				setLoop: 0
				setCel: 0
				setCycle: 0
				setMotion: 0
				posn: 131 86
				setPri: 180
				cycleSpeed: 9
				get: 110 13 ; Whisk_Broom
			)
			(= local12 (Str newWith: 200 {}))
			(= gBuckazoidCount 1)
			(leftSide init:)
			(teleportOperator init:)
			(= gPrevRoomNum 420)
			(bicycle init:)
		else
			(bicycle init: approachVerbs: 4) ; Do
			(self setRegions: 222) ; streetRgn
			(if local3
				(boothPoly init:)
				(gCurRoom addObstacle: boothPoly)
			)
			(gEgo setScaler: Scaler 97 23 134 91)
		)
		(super init:)
		(gGame handsOff:)
		(if (not (IsFlag 2))
			(idCard init:)
		)
		(exit280 init: gTheExitCursor approachVerbs: 7) ; ExitRight
		(exit320 init: gTheExitWCursor approachVerbs: 8) ; ExitLeft
		(exit330 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
		(exitNot1 init: gTheExitNoneCursor)
		(exitNot2 init: (gTheExitNoneCursor new:))
		(exitPoly330 init:)
		(barrel init:)
		(barrel2 init:)
		(boots init:)
		(buildings init:)
		(buildings2 init:)
		(buildings3 init:)
		(cinema init:)
		(dumpster init:)
		(eyeFront init:)
		(graffiti init:)
		(lightPole init:)
		(puddle1 init:)
		(if (> (gGame detailLevel:) 2)
			(puddle2 init:)
		)
		(street init:)
		(vehicle init:)
		(openSign init:)
		(fireRight init: setCycle: Fwd)
		(fireLeft init: setCycle: Fwd)
		(drumFire init: setCycle: Fwd)
		(if (> (gGame detailLevel:) 2)
			(torch init: setCycle: Fwd)
		)
		(bum init: setScript: sWarmUp sightAngle: 40)
		(switch gPrevRoomNum
			(280
				(gEgo posn: 220 102)
				(gEgo normalize: 5)
				(self cue:)
			)
			(320
				(gEgo posn: 26 114)
				(gEgo normalize: 0)
				(self cue:)
			)
			(330
				(= local4 1)
				(gEgo posn: 157 95)
				(gEgo normalize: 2)
				(self cue:)
			)
			(480
				(gTheIconBar setupExit: 0)
				(gGSound1 number: 330 setLoop: -1 play:)
				(gEgo hide:)
				(gEgo setScript: sBeamIn)
			)
			(420
				(gTheIconBar enable:)
				(drumFire priority: 10)
				(tallWalker
					init:
					hide:
					setCycle: Walk
					setScaler: Scaler 100 55 120 104
					setScript: sRobotWalk
				)
				(hole hide:)
				(self setScript: sDoTransport)
			)
			(else
				(gEgo setScaler: Scaler 100 23 134 91 loop: 2 posn: 162 99)
				(gGame handsOn:)
			)
		)
		(PalCycle 0 133 137 -1 10) ; Start
		(Palette 2 64 79 100) ; PalIntensity
		(RemapColors 2 244 27) ; ByPercent
		(while (Message msgSIZE 340 22 0 0 local0)
			(++ local0)
		)
		(-- local0)
		(localproc_0 22 0 0 (RandomNumber 1 local0))
	)

	(method (cue)
		(= local4 0)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(gMessager say: 0 theVerb) ; "It's startlingly unimpressed."
			)
			(4 ; Do
				(if local6
					(gMessager say: 0 theVerb 1) ; "Your reach is about as great as your personal depth."
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if local6
					(gMessager say: noun theVerb 1) ; "So this is the location you were so fortunate to draw for surface leave. What a dump! And you thought Xenon looked bad. This place is in serious need of some janitorial expertise."
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(if local6
					(gMessager say: 0 theVerb) ; "GIVE THE BROOM A REST!"
				else
					(switch local7
						(0
							(gMessager say: 0 theVerb 4) ; "You're on R&R. Give it a rest."
							(++ local7)
						)
						(1
							(gMessager say: 0 theVerb 5) ; "Hey, take it easy. You're on R&R. You wouldn't be so anxious to use that if you were at work."
							(++ local7)
						)
						(else
							(gMessager say: 0 theVerb) ; "GIVE THE BROOM A REST!"
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
	)

	(method (notify param1)
		(switch param1
			(33
				(gEgo setScript: sBeamUp)
			)
			(1
				(= local3 1)
			)
			(2
				((self obstacles:) delete: boothPoly)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(RemapColors 0) ; Off
		(FrameOut)
		(if (== newRoomNumber 280)
			(gGSound1 fade: 0 3 1 1)
			(SetFlag 60)
		)
		(boxWalker dispose:)
		(barberWalker dispose:)
		(tallWalker dispose:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(RemapColors 0 244) ; Off
		(gEgo setScale: 0)
		(local1 dispose:)
		(local13 dispose:)
		(sfxSound dispose:)
		(super dispose:)
	)
)

(instance sExit330 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 126 87)
				(= local10 (gEgo x:))
				(= local11 (gEgo y:))
				(= local9 0)
				(= cycles 1)
			)
			(1
				(= cycles 10)
			)
			(2
				(if (and (== (gEgo x:) local10) (== (gEgo y:) local11))
					(+= local9 1)
				else
					(= local9 0)
					(= local10 (gEgo x:))
					(= local11 (gEgo y:))
				)
				(cond
					((and (== (gEgo y:) 87) (== (gEgo x:) 126))
						(self changeState: (+ state 1))
					)
					((< local9 10)
						(self changeState: (- state 1))
					)
					(else
						(self changeState: 4)
					)
				)
			)
			(3
				(gCurRoom newRoom: 330)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBeamUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(2
				(= ticks 40)
			)
			(3
				(sfxSound loop: 0 number: 344 play:)
				(gEgo
					view: 345
					setCel: 0
					setLoop: 1
					setScaler: Scaler 118 29 134 91
					setCycle: End self
				)
			)
			(4
				(gEgo setLoop: 1 setCycle: Fwd)
				(= ticks 320)
			)
			(5
				(gEgo setCel: 10 setLoop: 0 setCycle: Beg self)
			)
			(6
				(sfxSound stop:)
				(gEgo hide:)
				(= ticks 70)
			)
			(7
				(SetFlag 186)
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance sBeamIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 5)
			)
			(1
				(sfxSound loop: 0 number: 344 play:)
				(gEgo
					view: 345
					show:
					posn: 138 120
					setCel: 0
					setLoop: 0
					setScaler: Scaler 89 89 200 10
					setCycle: End self
				)
			)
			(2
				(gEgo setCel: 0 setLoop: 1 setCycle: Fwd)
				(= ticks 320)
			)
			(3
				(sfxSound stop:)
				(gEgo normalize: 2)
				(gEgo setScaler: Scaler 100 23 134 91)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoTransport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= ticks 80)
			)
			(2
				(= local14 (Str format: {Roger\n}))
				(gTextScroller addString: (local14 data:) 50 84 0)
				(local14 dispose:)
				(Message msgGET 340 0 0 8 1 (local12 data:)) ; "OK, I'm ready. Energize! (SCOTT DON'T ERASE THIS)"
				(= local14 (Str format: {%s\n\n} local12))
				(= local15
					(gTextScroller addString: (local14 data:) gUserFont 82 0 0)
				)
				(local14 dispose:)
				(local12 dispose:)
				(sfxSound number: 340 loop: 1 play:)
				(gEgo cycleSpeed: local8 setCycle: End self)
			)
			(3
				(= ticks 40)
			)
			(4
				(sfxSound number: 342 play:)
				(gEgo
					setLoop: 1
					setCel: 0
					cycleSpeed: local8
					setCycle: End self
				)
			)
			(5
				(if local15
					(gTextScroller addString: {} 50 84 0)
					(gTextScroller addString: {} gUserFont 82 0)
					(= local15 0)
				)
				(= ticks 40)
			)
			(6
				(teleportOperator setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(7
				(sfxSound number: 356 play:)
				(teleportOperator setCycle: CT 5 1 self)
			)
			(8
				(sfxSound number: 354 play:)
				(teleportOperator setCycle: CT 8 1 self)
			)
			(9
				(sfxSound number: 356 play:)
				(teleportOperator setCycle: End self)
			)
			(10
				(sfxSound number: 355 play:)
				(teleportOperator setCel: 0)
				(boxWalker
					init:
					hide:
					setCycle: Walk
					setStep: 1 1
					setScaler: Scaler 100 55 130 104
					setScript: (sRobotWalk new:)
				)
				(= ticks 60)
			)
			(11
				(ego2 init: hide:)
				(teleportOperator setLoop: 1 setCel: 0 setCycle: End self)
			)
			(12
				(sfxSound number: 344 play:)
				(gEgo
					view: 423
					setLoop: 0
					setCel: 0
					cycleSpeed: local8
					setCycle: End self
				)
				(ego2 show: cycleSpeed: local8 setCycle: End)
			)
			(13
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: local8 setCycle: Fwd)
				(ego2 setLoop: 1 cycleSpeed: local8 setCycle: Fwd)
				(= ticks 240)
			)
			(14
				(sfxSound number: 346 play:)
				(ego2 setLoop: 2 cycleSpeed: local8 setCycle: End self)
			)
			(15
				(ego2 loop: 2 cel: 0)
				(= cycles 1)
			)
			(16
				(ego2 dispose:)
				(gEgo hide:)
				(barberWalker
					init:
					hide:
					setCycle: Walk
					setScaler: Scaler 100 55 130 104
					setScript: (sRobotWalk new:)
				)
				(= ticks 120)
			)
			(17
				(teleportOperator view: 4200 setLoop: 2 setCel: 4)
				(= cycles 1)
			)
			(18
				(sfxSound number: 348 play:)
				(teleportOperator setCel: 0 setCycle: End self)
			)
			(19
				(gEgo
					show:
					setPri: -1
					posn: 254 125
					view: 342
					setLoop: 0
					setCel: 0
				)
				(gGSound1 number: 330 setLoop: -1 play:)
				(sfxSound number: 350 play:)
				(= ticks 70)
			)
			(20
				(gEgo cycleSpeed: local8 setCycle: End self)
			)
			(21
				(teleportOperator
					setMotion:
						MoveTo
						(- (teleportOperator x:) 90)
						(teleportOperator y:)
				)
				(leftSide
					setMotion: MoveTo (- (leftSide x:) 185) (leftSide y:) self
				)
			)
			(22
				(gEgo
					setLoop: 1
					setCel: 0
					cycleSpeed: local8
					setCycle: End self
				)
			)
			(23
				(= ticks 30)
			)
			(24
				(gEgo cycleSpeed: local8 setCycle: Beg self)
			)
			(25
				(= ticks 60)
			)
			(26
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(27
				(= ticks 30)
			)
			(28
				(gEgo cycleSpeed: local8 setCycle: Beg self)
			)
			(29
				(= ticks 60)
			)
			(30
				(gEgo
					setLoop: 3
					setCel: 0
					cycleSpeed: local8
					setCycle: End self
				)
			)
			(31
				(= ticks 40)
			)
			(32
				(gEgo setCel: 2)
				(= ticks 40)
			)
			(33
				(gEgo cycleSpeed: local8 setCycle: End self)
			)
			(34
				(= ticks 60)
			)
			(35
				(gEgo cycleSpeed: local8 setCycle: Beg self)
			)
			(36
				(= ticks 60)
			)
			(37
				(gEgo
					setLoop: 4 1
					setCel: 0
					cycleSpeed: local8
					setCycle: End self
				)
			)
			(38
				(gMessager say: 0 0 7 0 self) ; "As we join our hero, Roger Wilco, he has just been transported to the surface of Polysorbate LX to enjoy a little shore leave. Apparently, there was a minor glitch in the process."
			)
			(39
				(= ticks 1)
			)
			(40
				(gMessager say: 5 0 1 0 self) ; "Oh, great. Real wonderful! Nice beam job, you metallic piece of scrap."
			)
			(41
				(= local6 1)
				(ClearFlag 0)
				(drumFire priority: 150)
				(teleportOperator dispose:)
				(leftSide dispose:)
				(gGame handsOn:)
				(gTheIconBar disable: 0 show:)
				(gEgo
					cycleSpeed: local8
					setCycle: 0
					setMotion: 0
					setScript: sStuckInGround
				)
				(self dispose:)
			)
		)
	)
)

(instance sGetId of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client
					view: 344
					setCel: 0
					setLoop: 0
					cycleSpeed: 8
					setCycle: CT 4 1 self
				)
			)
			(1
				(idCard dispose:)
				(client cycleSpeed: local8 setCycle: End self)
			)
			(2
				(client normalize: 0)
				(SetFlag 2)
				(gGame points: 3)
				(gEgo get: 2) ; Alien_ID
				(gMessager say: (bicycle noun:) 4 2 0 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRobotWalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (RandomNumber 10 30))
			)
			(1
				(if (<= local5 1)
					(++ local5)
					(if (== client tallWalker)
						(if (> (tallWalker x:) 100)
							(tallWalker y: 121 setSpeed: 8)
						else
							(tallWalker y: 113)
						)
					)
					(cond
						((and (== client tallWalker) (> (client x:) 100))
							(client
								show:
								setCel: 6
								setMotion: DPath 226 121 -10 116 self
							)
						)
						((> (client x:) 100)
							(client
								show:
								setMotion: MoveTo -10 (client y:) self
							)
						)
						(else
							(client
								show:
								setMotion: MoveTo 340 (client y:) self
							)
						)
					)
				else
					(self changeState: 0)
				)
			)
			(2
				(client hide:)
				(-- local5)
				(self changeState: 0)
			)
		)
	)
)

(instance sWarmUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bum setLoop: 0 setCel: 0 setCycle: Fwd)
				(= ticks (RandomNumber 120 420))
			)
			(1
				(bum setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance sStuckInGround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= register 0)
					(= cycles 1)
				else
					(= ticks (* 60 (RandomNumber 5 10)))
				)
			)
			(1
				(gEgo
					setLoop: 4
					setCel: (gEgo lastCel:)
					cycleSpeed: local8
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					setLoop: (RandomNumber 1 3)
					cycleSpeed: local8
					setCycle: Osc 1 self
				)
			)
			(3
				(gEgo setLoop: 4 cycleSpeed: local8 setCycle: End self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sTryButFail of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cycleSpeed: local8 setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 5 cycleSpeed: local8 setCycle: End self)
			)
			(2
				(= ticks 120)
			)
			(3
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(gEgo cycleSpeed: 9 setScript: sStuckInGround 0 1)
				(self dispose:)
			)
		)
	)
)

(instance sHangOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cycleSpeed: local8 setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 1 cycleSpeed: local8 setCycle: End self)
			)
			(2
				(gEgo view: 343 setLoop: 0 setCel: 0 setPri: 200)
				(= cycles 1)
			)
			(3
				(if (> (tallWalker x:) 226)
					(-- state)
					(= cycles 1)
				else
					(tallWalker setMotion: 0 setCel: 0)
					(gEgo cycleSpeed: local8 setCycle: CT 1 1 self)
				)
			)
			(4
				(tallWalker hide:)
				(sfxSound number: 326 loop: 0 play:)
				(gEgo cycleSpeed: local8 setCycle: End self)
			)
			(5
				(gEgo
					setLoop: 1
					setCel: 0
					cycleSpeed: local8
					setCycle: Osc 2 self
				)
			)
			(6
				(sfxSound number: 326 loop: 0 play:)
				(gEgo
					setLoop: 2
					setCel: 0
					cycleSpeed: local8
					setCycle: End self
				)
			)
			(7
				(hole show:)
				(gEgo
					view: 3430
					setLoop: 0
					setCel: 0
					setPri: 130 1
					cycleSpeed: local8
					setCycle: CT 5 1 self
				)
				(sfxSound number: 327 loop: 0 play:)
			)
			(8
				(sfxSound number: 34004 loop: 0 play:)
				(gEgo setCycle: End self)
			)
			(9
				(gEgo view: 3431 setLoop: 0 setCel: 0 posn: 195 121)
				(tallWalker
					view: 3430
					setLoop: 1
					setCel: 0
					posn: 124 122
					show:
					setCycle: ForwardCounter 3 self
				)
			)
			(10
				(tallWalker view: 3432 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(11
				(tallWalker
					view: 341
					setLoop: 0
					setCel: 0
					setScaler: Scaler 100 55 120 104
					setCycle: Walk
					setMotion: PolyPath -10 (tallWalker y:)
				)
				(gEgo cycleSpeed: local8 setCycle: End self)
			)
			(12
				(gGame points: 10)
				(gEgo
					normalize:
					setLoop: 1
					setScaler: Scaler 100 23 134 91
					setPri: -1
					posn: 195 122
				)
				(gMessager say: 5 0 3 0 self) ; "Thank you, my good man."
			)
			(13
				(gGame handsOn:)
				(= local6 0)
				(bicycle init: approachVerbs: 4) ; Do
				(bum sightAngle: 40)
				(self dispose:)
			)
		)
	)
)

(instance openSign of Prop
	(properties
		view 3400
		loop 4
	)

	(method (init)
		(super init:)
		(self posn: 219 68 setCycle: Fwd)
	)
)

(instance leftSide of Actor
	(properties
		priority 140
		fixPriority 1
		view 347
		xStep 5
		moveSpeed 0
	)

	(method (init)
		(= xStep 15)
		(teleportOperator xStep: 15)
		(super init:)
	)
)

(instance teleportOperator of Actor
	(properties
		y 85
		priority 146
		fixPriority 1
		view 420
		loop 1
		signal 22529
		xStep 5
		moveSpeed 0
	)
)

(instance tallWalker of Actor
	(properties
		noun 3
		x -20
		y 113
		view 341
		cel 5
		signal 4129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(cond
					((or (== y 111) (< x 160))
						(if local6
							(gCurRoom doVerb: theVerb)
						else
							(super doVerb: theVerb)
						)
					)
					((> x (- (gEgo x:) 15))
						(gGame handsOff:)
						(sStuckInGround dispose:)
						(script dispose:)
						(self setScript: 0 setMotion: MoveTo 226 121)
						(gCurRoom setScript: sHangOn)
					)
					(else
						(gGame handsOff:)
						(sStuckInGround dispose:)
						(gEgo setScript: sTryButFail)
					)
				)
			)
			(2 ; Talk
				(if local6
					(gMessager say: noun theVerb 1) ; "He seems totally unphased by your sorry attempt at communication."
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxWalker of Actor
	(properties
		noun 4
		x 340
		y 107
		view 351
		cel 5
		signal 4129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barberWalker of Actor
	(properties
		noun 2
		x -20
		y 110
		z 12
		view 350
		cel 5
		signal 4129
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ego2 of Prop
	(properties
		x 244
		y 126
		view 345
		cycleSpeed 9
	)
)

(instance fireRight of Prop
	(properties
		noun 6
		x 260
		y 103
		view 3400
		cel 2
		signal 20513
	)

	(method (init)
		(self setPri: 90)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fireLeft of Prop
	(properties
		x 41
		y 100
		view 3400
		loop 1
		cel 1
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance drumFire of Prop
	(properties
		noun 6
		x 27
		y 110
		priority 150
		fixPriority 1
		view 3400
		loop 2
		signal 20513
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance torch of Prop
	(properties
		x 140
		y 9
		view 3400
		loop 3
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bum of Prop
	(properties
		noun 18
		x 44
		y 131
		view 340
		signal 20513
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(2 ; Talk
				(if local6
					(gEgo cue:)
					(gMessager say: noun theVerb 1) ; "He wisely ignores you."
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole of View
	(properties
		noun 19
		x 242
		y 191
		z 100
		view 3402
		signal 20513
	)

	(method (init)
		(self loop: 1 cel: 0 setPri: 91)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (= theVerb 1) ; Look
			(gMessager say: 19 1) ; "Yes, you actually left a cool-looking mold of your lower torso. Well, actually, it's not that impressive."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance idCard of View
	(properties
		noun 21
		x 311
		y 111
		view 3402
	)

	(method (init)
		(self setPri: 125)
		(super init:)
	)
)

(instance bicycle of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 290
		approachY 134
		x 303
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 288 116 300 103 293 97 299 96 316 103 319 108 319 128 299 117 291 118
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					(local6
						(gMessager say: 0 theVerb 1) ; "Your reach is about as great as your personal depth."
					)
					((not (IsFlag 2))
						(gEgo setScript: sGetId)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(if (IsFlag 2)
					(super doVerb: theVerb)
				else
					(gMessager say: noun theVerb 2) ; "That's an interesting piece of hardware. Your normally dim power of recollection actually recalls having seen a picture of one of these in the ship library. Get this -- it's called a bike. People used to actually get on these and use their own muscles to achieve locomotion. What losers."
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(67 ; Alien_ID
				(gMessager say: noun theVerb) ; "It doesn't want it back, but that is a nice thought."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrel of Feature
	(properties
		noun 6
		sightAngle 40
		x 34
		y 132
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 133 25 111 31 109 37 109 44 111 44 133
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance barrel2 of Feature
	(properties
		noun 6
		sightAngle 40
		x 261
		y 97
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 103 256 103 256 92 266 92
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(barrel doVerb: theVerb)
	)
)

(instance boots of Feature
	(properties
		noun 13
		sightAngle 40
		x 252
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 43 199 40 207 31 220 0 319 0 319 76 302 74 290 82 290 100 230 100 200 95 200 61 195 54 185 54
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buildings of Feature
	(properties
		noun 15
		sightAngle 40
		x 150
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 87 142 82 143 77 142 67 137 60 131 0 165 0 160 7 160 12 162 17 169 23 169 52 163 64 164 78 170 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buildings2 of Feature
	(properties
		noun 15
		sightAngle 40
		x 189
		y 75
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 92 180 59 186 55 194 55 199 62 199 96
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(buildings doVerb: theVerb)
	)
)

(instance buildings3 of Feature
	(properties
		noun 15
		sightAngle 40
		x 203
		y 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 42 186 0 220 0 208 30 198 40
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(buildings doVerb: theVerb)
	)
)

(instance cinema of Feature
	(properties
		noun 9
		sightAngle 40
		x 79
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 15 102 15 81 20 67 22 50 15 30 26 18 34 0 131 0 137 60 142 71 142 78 143 93 115 102
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dumpster of Feature
	(properties
		noun 10
		sightAngle 40
		x 305
		y 91
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 107 291 81 304 75 312 77 319 77 319 107
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eyeFront of Feature
	(properties
		noun 14
		sightAngle 40
		x 172
		y 46
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 171 91 164 78 163 63 169 52 168 22 160 14 160 7 166 0 185 0 184 54 180 58 179 92
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(67 ; Alien_ID
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance graffiti of Feature
	(properties
		noun 17
		sightAngle 40
		x 275
		y 104
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 73 288 60 295 68 294 77 264 90
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lightPole of Feature
	(properties
		noun 11
		sightAngle 40
		x 285
		y 60
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 303 119 294 120 290 117 294 107 295 49 274 49 274 42 294 42 296 17 291 5 286 0 270 0 266 7 265 18 269 24 265 25 255 25 251 23 259 20 261 9 265 0 291 0 298 11 299 18 300 41 319 38 319 46 300 48 300 114
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puddle1 of Feature
	(properties
		noun 12
		sightAngle 40
		x 176
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 162 100 168 97 179 97 190 102 177 103
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance puddle2 of Feature
	(properties
		noun 12
		sightAngle 40
		x 259
		y 113
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 113 258 111 265 111 270 114 263 116 256 116
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(puddle1 doVerb: theVerb)
	)
)

(instance street of Feature
	(properties
		noun 16
		sightAngle 40
		x 166
		y 113
	)

	(method (initialize))

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 14 123 14 107 134 107 150 100 151 94 145 90 161 92 218 108 318 108 318 115 267 116 268 122 318 134 318 137 240 137 224 127 197 124 189 122 181 115 176 117 174 126 141 135 133 128 128 129 125 137 59 137 103 122 103 117 31 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local6
					(gMessager say: noun theVerb 1) ; "Seldom have you had the good fortune to get to know a street so up close and personal. You feel you have a real bond growing."
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vehicle of Feature
	(properties
		noun 7
		sightAngle 40
		x 185
		y 127
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 138 129 130 133 130 141 137 163 129 176 127 178 117 182 116 190 124 206 123 224 127 244 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local6
					(gCurRoom doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(70 ; Whisk_Broom
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit280 of ExitFeature
	(properties
		nsLeft 218
		nsTop 65
		nsRight 255
		nsBottom 102
		approachX 237
		approachY 99
		nextRoom 280
		message 7
	)
)

(instance exit320 of ExitFeature
	(properties
		approachX 1
		approachY 112
		nextRoom 320
		message 8
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 32 0 30 9 22 22 14 31 19 43 21 53 19 68 14 82 14 124 0 130
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit330 of ExitFeature
	(properties
		nsLeft 137
		nsTop 77
		nsRight 155
		nsBottom 93
		approachX 156
		approachY 94
		nextRoom 330
		message 9
	)

	(method (handleEvent event)
		(= local4 1)
		(super handleEvent: event)
	)

	(method (cue)
		(super doVerb: 9)
	)
)

(instance exitNot1 of ExitFeature
	(properties
		nsLeft 314
		nsTop 102
		nsRight 320
		nsBottom 117
	)
)

(instance exitNot2 of ExitFeature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 57 138 71 132 314 132 320 133 320 138
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitPoly330 of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 98 166 90 161 89 149 94
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance boothPoly of Polygon
	(properties)

	(method (init)
		(self type: PBarredAccess)
		(super init: 148 120 194 114 235 121 196 125)
	)
)

(instance sfxSound of Sound
	(properties)
)

