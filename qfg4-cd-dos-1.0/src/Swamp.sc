;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use DeathIcon)
(use Array)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Timer)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Swamp 0
	sDownCandy 1
	reflection 2
	sToJump 3
	sJumpWater 4
	sEgoDrownGlide 5
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
)

(instance Swamp of Rgn
	(properties
		modNum 10
	)

	(method (init &tmp temp0)
		(gLongSong number: 550 setLoop: -1 play:)
		(= local7 (IntArray with: 54 48 95 158 132))
		(= local8 (IntArray with: 175 108 119 142 178))
		(= local9 (IntArray with: 83 76 111 191 15))
		(= local10 (IntArray with: 160 103 130 171 136))
		(= local11 (IntArray with: 84 157 206 276))
		(= local12 (IntArray with: 157 176 139 173))
		(= local13 (IntArray with: 182 86 175 11))
		(= local14 (IntArray with: 112 138 171 173))
		(= local15 (IntArray with: 106 183 259 70 16))
		(= local16 (IntArray with: 121 142 149 156 137))
		(super init:)
		(switch gCurRoomNum
			(530
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					((hands new:)
						init: temp0 (local9 at: temp0) (local10 at: temp0)
					)
				)
			)
			(535
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					((hands new:)
						init: temp0 (local7 at: temp0) (local8 at: temp0)
					)
				)
			)
			(541 ; swamp1
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					((hands new:)
						init: temp0 (local11 at: temp0) (local12 at: temp0)
					)
				)
			)
			(542 ; swamp2
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					((hands new:)
						init: temp0 (local13 at: temp0) (local14 at: temp0)
					)
				)
			)
			(543 ; swamp3
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					((hands new:)
						init: temp0 (local15 at: temp0) (local16 at: temp0)
					)
				)
			)
		)
		(if
			(and
				gNight
				(OneOf gCurRoomNum 535 530)
				(not (IsFlag 459))
				(not (gEgo has: 41)) ; theWillowisp
			)
			(= local6 (IntArray new: 4))
			(for ((= temp0 0)) (< temp0 4) ((++ temp0))
				(local6 at: temp0 ((wisps new:) init: temp0 yourself:))
			)
		)
	)

	(method (doit)
		(if (and (IsFlag 359) (gEgo mover:))
			(gEgo useStamina: 8)
		)
		(if (and (not local22) (IsFlag 149) (< [gEgoStats 19] 20)) ; mana
			(gMessager say: 8 6 25 0 0 535) ; "You sense that your magic is weakening. You need to return to shore quickly before it is gone entirely, or you will surely drown."
			(= local22 1)
		)
		(if (and local22 (> [gEgoStats 19] 20)) ; mana
			(= local22 0)
		)
		(if (and (== local4 15) local3)
			(= local5 1)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3 ; Walk
				(if (IsFlag 359)
					(cond
						(
							(or
								(>
									(= temp0
										(GetAngle
											(gEgo x:)
											(gEgo y:)
											((User curEvent:) x:)
											((User curEvent:) y:)
										)
									)
									315
								)
								(< temp0 45)
							)
							(gEgo
								setMotion:
									PolyPath
									(gEgo x:)
									(- (gEgo y:) (gEgo yStep:))
							)
						)
						((or (>= temp0 45) (< temp0 135))
							(gEgo
								setMotion:
									PolyPath
									(+ (gEgo x:) (gEgo xStep:))
									(gEgo y:)
							)
						)
						((or (>= temp0 135) (< temp0 225))
							(gEgo
								setMotion:
									PolyPath
									(gEgo x:)
									(+ (gEgo y:) (gEgo yStep:))
							)
						)
						((or (>= temp0 225) (< temp0 315))
							(gEgo
								setMotion:
									PolyPath
									(- (gEgo x:) (gEgo xStep:))
									(gEgo y:)
							)
						)
					)
					(gEgo useStamina: 40)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(87 ; fetchSpell
				(if (and (not (gEgo has: 41)) local6) ; theWillowisp
					(gCurRoom
						setScript:
							(ScriptID 37 0) ; castFetchScript
							0
							(local6 at: 0)
							(local6 at: 1)
							(local6 at: 2)
							(local6 at: 3)
					)
				else
					(gCurRoom setScript: (ScriptID 37)) ; castFetchScript
				)
			)
			(86 ; flameDartSpell
				(if (IsFlag 167)
					(gMessager say: 8 6 2 0 0 535) ; "You are unable to cast that spell while mired in muck."
				else
					(gCurRoom setScript: (ScriptID 32) 0 86) ; project
				)
			)
			(88 ; forceBoltSpell
				(if (IsFlag 167)
					(gMessager say: 8 6 2 0 0 535) ; "You are unable to cast that spell while mired in muck."
				else
					(gCurRoom setScript: (ScriptID 32) 0 88) ; project
				)
			)
			(93 ; lightningBallSpell
				(if (IsFlag 167)
					(gMessager say: 8 6 2 0 0 535) ; "You are unable to cast that spell while mired in muck."
				else
					(gCurRoom setScript: (ScriptID 32) 0 93) ; project
				)
			)
			(81 ; detectMagicSpell
				(gMessager say: 0 81 0 0 0 535) ; "The grasping hands and the floating balls of light (such a surprise!) are magical. The rest is just nasty, mucky swamp."
			)
			(60 ; theWillowisp
				(self setScript: sReleaseWisps)
			)
			(104 ; Sleep all night
				(gMessager say: 8 6 24 0 0 535) ; "This is no place to sleep! If you didn't roll over and drown, and the reaching hands all missed you, pneumonia would surely seal your fate."
			)
			(else
				(GloryRm doVerb: theVerb)
			)
		)
	)

	(method (notify param1 param2)
		(= local0 param1)
		(= local1 param2)
	)

	(method (dispose &tmp temp0)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local10 dispose:)
		(local11 dispose:)
		(local12 dispose:)
		(local13 dispose:)
		(local14 dispose:)
		(local15 dispose:)
		(local16 dispose:)
		(if local6
			(local6 dispose:)
		)
		(super dispose:)
	)
)

(class SwampView of View
	(properties
		signal 20480
		extra 0
	)

	(method (handleEvent event)
		(= local20 (event x:))
		(= local21 (event y:))
		(super handleEvent: event)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(21 ; theRocks
				(if (not (IsFlag 167))
					(gCurRoom setScript: (ScriptID 32) 0 21) ; project
				)
			)
			(10 ; Jump
				(if (not (self onMe: gEgo))
					(if (or (IsFlag 149) (IsFlag 167))
						(gMessager say: 0 10 14 0 0 535) ; "The muck doesn't give you enough support to make a decent jump. Walk up onto a dry area first."
					else
						(if (< [gEgoStats 15] 150) ; acrobatics
							(= temp0 150)
						else
							(= temp0 [gEgoStats 15]) ; acrobatics
						)
						(= local1 (+ (/ temp0 3) 20))
						(= local0 (gEgo distanceTo: self))
						(if (<= local1 local0)
							(gEgo
								setHeading:
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										local20
										local21
									)
							)
							(gCurRoom setScript: sJumpWater 0 self)
						else
							(gCurRoom setScript: sToJump 0 self)
						)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(3 ; Walk
				(gCurRoom setScript: sGlideToHummock 0 self)
			)
			(4 ; Do
				(if (IsFlag 149)
					(gCurRoom setScript: sGlideToHummock 0 self)
				else
					(gCurRoom doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose: 1)
			(= heading 0)
		)
		(super dispose:)
	)
)

(class hands of TargActor
	(properties
		noun 5
		view 535
		signal 26624
		cycleSpeed 12
		illegalBits 0
		moveSpeed 0
		dead 0
	)

	(method (dispose)
		(if script
			(script disposeNow: 1 dispose:)
		)
		(= script 0)
		(super dispose:)
	)

	(method (getHurt &tmp [temp0 2])
		(self cycleSpeed: 6 setCycle: CT 0 -1 self dead: 1)
	)

	(method (init param1 param2 param3)
		(super init:)
		(= x param2)
		(= y param3)
		(= loop (Random 0 5))
		((Timer new:) setReal: self (Random 5 25))
		(self signal: (| (self signal:) $0001) setScaler: Scaler 100 60 125 65)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; theRocks
				(if (not (IsFlag 167))
					(gCurRoom setScript: (ScriptID 32) 0 21) ; project
				)
			)
			(86 ; flameDartSpell
				(Swamp doVerb: theVerb)
			)
			(88 ; forceBoltSpell
				(Swamp doVerb: theVerb)
			)
			(93 ; lightningBallSpell
				(Swamp doVerb: theVerb)
			)
			(36 ; theSword
				(if
					(and
						(!= cel 10)
						(or (== (gEgo view:) 56) (== (gEgo view:) 538))
					)
					(gCurRoom setScript: sArmFighting 0 self)
				)
			)
			(1 ; Look
				(gMessager say: 5 1 0 0 0 535) ; "The decayed remains of a human arm claw at you as if to drag you down to share its doom."
			)
			(4 ; Do
				(gMessager say: 5 4 0 0 0 535) ; "That would be your final handshake."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(cond
			(dead
				(self dispose:)
			)
			((or (== (gEgo view:) 56) (== (gEgo view:) 538))
				(self setCycle: (myEndLoop new:))
			)
			(else
				(self setCycle: (cueEndLoop new:))
			)
		)
	)
)

(instance myEndLoop of CT
	(properties)

	(method (init param1)
		(super
			init:
				param1
				(if (== argc 2)
					0
				else
					(param1 lastCel:)
				)
				(if (== argc 2) -1 else 1)
		)
	)

	(method (doit)
		(if
			(and
				(>= (client cel:) 2)
				(< (gEgo distanceTo: client) 10)
				(User canControl:)
			)
			(gCurRoom setScript: sEgoDrown)
		)
		(super doit: &rest)
	)

	(method (cycleDone)
		(if endCel
			(self init: client 1)
		else
			(if (User canControl:)
				(client setScript: (sSearchEgo new:) client client)
			)
			(super cycleDone:)
		)
	)
)

(instance cueEndLoop of CT
	(properties)

	(method (init param1)
		(super
			init:
				param1
				(if (== argc 2)
					0
				else
					(param1 lastCel:)
				)
				(if (== argc 2) -1 else 1)
		)
	)

	(method (doit)
		(if
			(and
				(>= (client cel:) 2)
				(< (gEgo distanceTo: client) 10)
				(User canControl:)
			)
			(gCurRoom setScript: sEgoDrown)
		)
		(super doit: &rest)
	)

	(method (cycleDone)
		(if endCel
			(self init: client 1)
		else
			((Timer new:) setReal: client (Random 5 25))
			(super cycleDone:)
		)
	)
)

(instance sJumpWater of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(= local1 (- local0 local1))
				(= temp2 (gEgo heading:))
				(= temp0 (+ (gEgo x:) (SinMult temp2 local1)))
				(= temp1 (- (gEgo y:) (CosMult temp2 local1)))
				(dummy
					x: (gEgo x:)
					y: (gEgo y:)
					setStep: local1 local1
					signal: (| (dummy signal:) $0001)
					init:
					setMotion: MoveTo temp0 temp1 self
				)
			)
			(1
				(if
					(and
						(register isMemberOf: Feature)
						(not
							(((gCurRoom obstacles:) at: 0)
								onMe: (dummy x:) (dummy y:)
							)
						)
					)
					(gMessager say: 8 6 5 0 0 535) ; "Either that hillock is too far away, or you need a little more practice with acrobatics before you can get around the swamp with this skill."
					(gGlory handsOn:)
					(self dispose:)
				else
					(= temp3 (gCast size:))
					(= local17 0)
					(for ((= temp4 (= register 0))) (< temp4 temp3) ((++ temp4))
						(if
							(and
								((gCast at: temp4) isKindOf: SwampView)
								((gCast at: temp4)
									onMe: (dummy x:) (dummy y:)
								)
								((gCast at: temp4) heading:)
							)
							(if ((gCast at: temp4) onMe: gEgo)
								(gMessager say: 8 6 5 0 0 535) ; "Either that hillock is too far away, or you need a little more practice with acrobatics before you can get around the swamp with this skill."
								(= register 1)
								(break)
							else
								(= local17 (gCast at: temp4))
							)
						)
					)
					(cond
						(register
							(gGlory handsOn:)
							(self dispose:)
						)
						(local17
							((gCurRoom obstacles:) dispose:)
							(gCurRoom
								obstacles: 0
								addObstacle: (local17 heading:)
							)
							(= gTempEgoSpeed (gEgo cycleSpeed:))
							(gEgo
								useStamina: 8
								useSkill: 15 ; acrobatics
								view: 30
								setLoop:
									(if (> (dummy x:) (gEgo x:)) 2 else 3)
								cel: 0
								code: 0
								cycleSpeed: 6
								moveSpeed: 6
								setScale: 0
								setPri: (local17 priority:)
								setCycle: CT 8 1
								setMotion:
									JumpTo
									(local17 approachX:)
									(local17 approachY:)
									self
							)
							(gCast delete: dummy)
							(dummy dispose:)
						)
						(else
							(gMessager say: 8 6 5 0 0 535) ; "Either that hillock is too far away, or you need a little more practice with acrobatics before you can get around the swamp with this skill."
							(= ticks (= register 1))
						)
					)
				)
			)
			(2
				(if register
					(gCast delete: dummy)
					(dummy dispose:)
					(gGlory handsOn:)
					(self dispose:)
				else
					(gEgo setCycle: End self)
				)
			)
			(3
				(gEgo
					setPri: -1
					view: 0
					z: 0
					setLoop: -1
					setLoop: (ScriptID 28 1) ; stopGroop
					setCycle: StopWalk 5
					setMotion: 0
					setPri: (+ (gEgo priority:) 2)
					changeGait: -1 0
					illegalBits: 0
					setPri: -1
					ignoreHorizon:
					state: 2
					x:
						(if (== (gEgo loop:) 3)
							(- (gEgo x:) 15)
						else
							(+ (gEgo x:) 15)
						)
					y: (+ (gEgo y:) 3)
					cycleSpeed: gTempEgoSpeed
					moveSpeed: gTempEgoSpeed
					setScaler: Scaler 100 60 125 65
				)
				(gEgo loop: 2)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGlideToHummock of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gWalkHandler delete: gCurRoom)
				(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
					(if ((gCast at: temp0) isMemberOf: SwampView)
						(gWalkHandler delete: (gCast at: temp0))
					)
				)
				(if gFShore
					(gWalkHandler delete: gFShore)
					(= gFShore 0)
				)
				(&= global393 $fffc)
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gCurRoom addObstacle: (register heading:))
			)
			(1
				(ClearFlag 149)
				(gEgo
					normalize:
					moveSpeed: gTempEgoSpeed
					cycleSpeed: gTempEgoSpeed
					setMotion:
						PolyPath
						(register approachX:)
						(+ (register approachY:) 1)
						self
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(class sSearchEgo of Script
	(properties
		disposeNow 0
	)

	(method (dispose)
		(if disposeNow
			(super dispose:)
		else
			(= disposeNow 1)
		)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(cond
			(disposeNow
				(self dispose:)
			)
			(cycles
				(if (not (-- cycles))
					(self cue:)
				)
			)
			(seconds
				(= temp0 (GetTime 1)) ; SysTime12
				(if (!= lastSeconds temp0)
					(= lastSeconds temp0)
					(if (not (-- seconds))
						(self cue:)
					)
				)
			)
			(ticks
				(if (<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
					(= ticks 0)
					(self cue:)
				)
				(= lastTicks gGameTime)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (+ (gEgo x:) (- 25 (Random 0 50))))
				(= temp1 (+ (gEgo y:) (- 20 (Random 0 40))))
				(register setMotion: PolyPath temp0 temp1 self)
			)
			(1
				(= ticks (Random 30 150))
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sArmFighting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath (register x:) (register y:) self)
			)
			(1
				(gEgo
					view: 53
					setLoop: (if (>= (gEgo heading:) 180) 0 else 1)
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(register setCycle: Beg self)
			)
			(3
				(gEgo view: 536 setLoop: -1 loop: 5 setCycle: StopWalk 538)
				((Timer new:) setReal: client (Random 5 25))
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoDrown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 1)
			)
			(1
				(EgoDead 1 535) ; "Got to HAND it to you, you walked into an alARMing situation. Bet you WRIST you hadn't done that."
				(self dispose:)
			)
		)
	)
)

(instance wisps of Actor
	(properties
		noun 10
		priority 190
		fixPriority 1
		view 532
		signal 26624
	)

	(method (doit)
		(super doit: &rest)
		(if local5
			(if local3
				(gEgo drop: 9 1 get: 41 1 solvePuzzle: 445 6) ; theFlask, theWillowisp
				(= local3 0)
				(gMessager say: 10 87 11 0 0 535) ; "As your Fetch spell draws the Will o' Wisps close, you deftly catch a few of them in a flask and close the stopper."
			)
			(self dispose:)
		)
	)

	(method (init param1 &tmp temp0 temp1)
		(= loop (Random 0 3))
		(= temp0 (Random 5 140))
		(= temp1 (Random 80 130))
		(super init:)
		(self setLoop: param1 1)
		(if (< argc 2)
			(self
				x: temp0
				y: temp1
				moveSpeed: (Random 0 3)
				cycleSpeed: 3
				signal: (| (self signal:) $0001)
				setScaler: Scaler 100 60 125 65
				setCycle: Fwd
				setMotion:
					MoveTo
					(+ temp0 (- 10 (Random 5 15)))
					(+ temp1 (- 3 (Random 0 5)))
					self
			)
		)
	)

	(method (motionCue)
		(if (and mover (mover completed:))
			(mover motionCue:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; theRocks
				(if (not (IsFlag 167))
					(gCurRoom setScript: (ScriptID 32) 0 21) ; project
				)
			)
			(24 ; theFlask
				(cond
					((not local4)
						(gMessager say: 10 60 17 0 0 535) ; "The Will o' Wisps are avoiding your touch. You need to find some way to attract them first."
					)
					((== local4 15)
						(gCurRoom setScript: sCatchWisps)
					)
					(else
						(gMessager say: 10 60 18 0 0 535) ; "Wait a moment -- they're almost in reach!"
					)
				)
			)
			(23 ; theCandy
				(gCurRoom setScript: sDownCandy)
			)
			(-87 ; fetchSpell (part 2)
				(if (gEgo has: 9) ; theFlask
					(= local3 1)
				else
					(gMessager say: 10 87 12 0 0 535) ; "Your Fetch spell draws the Will o' Wisps close, but you discover that you have nothing in which to hold them. The spell dissipates and the Will o' Wisps vanish."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue &tmp temp0 temp1)
		(cond
			((OneOf gCurRoomNum 541 542 543 545) ; swamp1, swamp2, swamp3
				(self dispose:)
			)
			(local2
				(self setScript: (sToCandy new:) 0 self)
			)
			(local3
				(self setScript: (sToFlask new:) 0 self)
			)
			(else
				(cond
					((< (= temp0 (+ x (- 5 (Random 0 10)))) 0)
						(= temp0 0)
					)
					((> temp0 148)
						(= temp0 148)
					)
				)
				(cond
					((> (= temp1 (+ y (- 3 (Random 0 6)))) 140)
						(= temp1 140)
					)
					((< temp1 80)
						(= temp1 80)
					)
				)
				(self setMotion: MoveTo temp0 temp1 self)
			)
		)
	)
)

(instance sDownCandy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 253 123 self)
			)
			(1
				(gEgo view: 4 setLoop: 0 setCycle: End self)
			)
			(2
				(gEgo drop: 8) ; theCandy
				(= local2 1)
				(gMessager say: 9 23 19 0 self 535) ; "You carefully place some of the candy on the ground."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sReleaseWisps of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gEgo drop: 41 1 get: 9 1) ; theWillowisp, theFlask
				(= local5 0)
				(= local2 0)
				(gMessager say: 0 60 28 0 0 535) ; "You release the Will o' Wisps back into the swamp."
				(= local6 (IntArray new: 4))
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(local6 at: temp0 (wisps new:))
					((local6 at: temp0)
						x: (gEgo x:)
						y: (gEgo y:)
						moveSpeed: (Random 0 5)
						cycleSpeed: 3
						setScaler: Scaler 100 60 125 65
						setPri: 190
						signal: (| ((local6 at: temp0) signal:) $0001)
						setCycle: Fwd
						init: temp0 1
					)
					(if (OneOf gCurRoomNum 530 535)
						((local6 at: temp0)
							setMotion:
								MoveTo
								(+ 100 (Random 5 25))
								(- (gEgo y:) (Random 5 20))
								(local6 at: temp0)
						)
					else
						((local6 at: temp0)
							setMotion:
								MoveTo
								(if (> (gEgo x:) 160) -10 else 330)
								(- (gEgo y:) (Random 20 30))
								(local6 at: temp0)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCatchWisps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 253 123 self)
			)
			(1
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo drop: 9 1 get: 41 1 solvePuzzle: 445 6) ; theFlask, theWillowisp
				(= local5 1)
				(gMessager say: 10 60 11 0 self 535) ; "You capture a few of the Will o' Wisps in a flask."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gGlory handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sToCandy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(register
					setSpeed: 0
					setMotion:
						MoveTo
						(+ 269 (Random 0 8))
						(- (+ 123 (Random 0 4)) 5)
						self
				)
			)
			(1
				(register setPri: -1)
				(for ((= temp0 0)) (& (>> local4 temp0) $0001) ((++ temp0))
				)
				(|= local4 (<< $0001 temp0))
				(self dispose:)
			)
		)
	)
)

(instance sToFlask of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(register
					setSpeed: 0
					setMotion:
						MoveTo
						(+ (- (gEgo x:) 5) (Random 0 5))
						(+ (- (gEgo y:) 25) (Random 0 4))
						self
				)
			)
			(1
				(register setPri: -1)
				(for ((= temp0 0)) (& (>> local4 temp0) $0001) ((++ temp0))
				)
				(|= local4 (<< $0001 temp0))
				(self dispose:)
			)
		)
	)
)

(instance sToJump of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= temp0 (register approachX:))
				(= temp1 (register approachY:))
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0 addObstacle: (register heading:))
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo
					useStamina: 8
					useSkill: 15 ; acrobatics
					view: 30
					setLoop: (if (> gMouseX (gEgo x:)) 2 else 3)
					cel: 0
					code: 0
					cycleSpeed: 6
					moveSpeed: 6
					setScale: 0
					setPri:
						(if (register isMemberOf: SwampView)
							(register priority:)
						else
							167
						)
					setCycle: CT 8 1
					setMotion: JumpTo temp0 temp1 self
				)
			)
			(1
				(gEgo setPri: -1 setCycle: End self)
			)
			(2
				(gEgo
					view: 0
					z: 0
					setLoop: -1
					setLoop: (ScriptID 28 1) ; stopGroop
					setCycle: StopWalk 5
					setMotion: 0
					changeGait: -1 0
					ignoreHorizon:
					x:
						(if (== (gEgo loop:) 3)
							(- (gEgo x:) 15)
						else
							(+ (gEgo x:) 15)
						)
					y: (+ (gEgo y:) 3)
					cycleSpeed: gTempEgoSpeed
					moveSpeed: gTempEgoSpeed
					setScaler: Scaler 100 60 125 65
				)
				(gEgo loop: 2)
				(if (register isKindOf: View)
					0
				else
					(gEgo setPri: -1)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEgoDrownGlide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 8 6 22 0 self 535) ; "Oh no!! You don't have enough mana to continue your Glide spell."
			)
			(1
				(gEgo
					view: 5
					setPri: (gEgo priority:)
					setStep: 0 10
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 15) self
				)
				(splash
					view: (if (OneOf gCurRoomNum 530 535) 531 else 551)
					x: (gEgo x:)
					y: (gEgo y:)
					setPri: (+ (gEgo priority:) 1)
					signal: (| (splash signal:) $0001)
					setCycle: End self
					init:
				)
			)
			(2
				(gEgo hide:)
			)
			(3
				(= cycles 12)
			)
			(4
				(EgoDead 23)
				(self dispose:)
			)
		)
	)
)

(class SwampPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance dummy of Actor
	(properties
		view 30
		loop 6
		signal 26624
		origStep 20560
		moveSpeed 0
	)
)

(instance reflection of Prop
	(properties
		priority 1
		fixPriority 1
		view 536
		signal 20480
		cycleSpeed 18
	)

	(method (init)
		(super init:)
		(self setScaler: Scaler 100 60 125 65)
		(self hide:)
	)

	(method (show)
		(super show: &rest)
		(= local19 gGameTime)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((gEgo mover:)
				(reflection
					x: (gEgo x:)
					y: (gEgo y:)
					loop: (+ (gEgo loop:) 8)
					cel: (gEgo cel:)
				)
			)
			((>= (Abs (- gGameTime local19)) cycleSpeed)
				(= local19 gGameTime)
				(if (> (= temp0 (+ (reflection cel:) 1)) 7)
					(reflection cel: 0)
				else
					(reflection cel: temp0)
				)
			)
		)
	)
)

(instance splash of Prop
	(properties
		signal 16384
	)
)

