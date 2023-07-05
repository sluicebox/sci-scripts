;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use Teller)
(use bridgeIcon)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm470 0
	proc470_1 1
	climbDown 2
	climbRope 3
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
	[local9 20] = [0 0 0 0 0 0 4 1 14 1 7 8 0 11 0 19 5 25 0 0]
	[local29 8] = [0 9 20 -2 -3 -1 42 999]
	[local37 3]
	[local40 8] = [0 5 6 7 8 56 55 999]
	[local48 5] = [0 21 54 53 999]
	[local53 8] = [0 18 24 17 15 51 52 999]
	[local61 2]
)

(procedure (proc470_1)
	(rope approachVerbs: 4) ; Do
	(rope2 approachVerbs: 4) ; Do
	(bridge approachVerbs: 4) ; Do
	(gWalkHandler delete: gCurRoom)
)

(instance rm470 of Rm
	(properties
		noun 3
		picture 470
		east 420
		vanishingY -300
	)

	(method (init)
		(HandsOff)
		(Load rsMESSAGE 470)
		(LoadMany rsVIEW 470 39 7 12)
		(cond
			((== gBaseHeroType 2) ; Thief
				(Load rsVIEW 30)
			)
			((== gPrevRoomNum 460)
				(LoadMany rsVIEW 475 472 473)
			)
			(else
				(LoadMany rsVIEW 475 972 971 471 474)
			)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 6 139 71 139 74 146 8 146
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 257 121 278 121 307 145 249 148 234 132
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 0 319 0 319 96 0 96 yourself:)
		)
		(= [local37 0] @local29)
		(= [local37 1] 999)
		(egoActions init: gEgo @local29 @local37)
		(rope approachVerbs: 4 init:) ; Do
		(rope2 approachVerbs: 4 init:) ; Do
		(bridge approachVerbs: 4 init:) ; Do
		(wall init:)
		(bridge init:)
		(rock init:)
		(leftTreeTop init:)
		(rightTreeTop init:)
		((ScriptID 34 0) x: 200 textX: -175 talkWidth: 135) ; uhuraTalker
		(cond
			((== gPrevRoomNum 460)
				(gCurRoom setScript: initContest)
			)
			((== gPrevRoomNum 480)
				(gCurRoom setScript: enterRoomL)
			)
			(else
				(gCurRoom setScript: enterRoomB)
			)
		)
		(super init:)
	)

	(method (doit)
		(cond
			(script 0)
			(
				(and
					(gEgo mover:)
					(not ((ScriptID 34 1) script:)) ; Uhura
					(== (gEgo view:) 12)
					(< (gEgo y:) 90)
				)
				(egoActions doVerb: 3)
			)
			((>= (gEgo x:) 315)
				(gCurRoom setScript: exitTo420)
			)
			((>= (gEgo y:) 183)
				(gCurRoom setScript: walkOut)
			)
			((and (not (IsFlag 59)) (gCast contains: (ScriptID 34 1)) local1) ; Uhura
				(SetFlag 59)
				(= local1 0)
				(gMessager say: 2 6 10) ; "Very good, young hero. You be learning well how to balance on the bridge."
			)
			((<= (gEgo x:) 5)
				(gCurRoom setScript: exitTo480)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (< (gEgo y:) 90)
					(egoActions doVerb: 3)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(if (!= (gLongSong number:) 160)
			(gLongSong setLoop: -1 number: 160 play: 127)
		)
		(gEgo setScript: 0)
		(LoadMany 0 34 39 56 53 471)
		(super dispose:)
	)

	(method (notify param1 param2 &tmp temp0)
		(switch param1
			(1
				(if (> argc 1)
					(= local6 param2)
				)
				(= temp0 local6)
			)
			(3
				(if (> argc 1)
					(= local0 param2)
					(switch param2
						(3
							(= [local61 0] @local48)
							(uhuraTeller init: (ScriptID 34 1) @local48 @local61) ; Uhura
						)
						(4
							(= [local61 0] @local53)
							(uhuraTeller init: (ScriptID 34 1) @local53 @local61) ; Uhura
						)
						(10
							((ScriptID 34 1) dispose:) ; Uhura
						)
					)
				)
				(= temp0 local0)
			)
		)
		(return temp0)
	)
)

(instance egoActions of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-2
				(and (gCast contains: (ScriptID 34 1)) local6 (not local4)) ; Uhura
				-3
				(and (gCast contains: (ScriptID 34 1)) local6 (not local4)) ; Uhura
				-1
				(gCast contains: (ScriptID 34 1)) ; Uhura
				20
				(and (== local0 3) (gCast contains: (ScriptID 34 1))) ; Uhura
				42
				(and (== local0 4) (gCast contains: (ScriptID 34 1))) ; Uhura
				9
				(and
					(or (== local0 2) (== local0 1))
					(gCast contains: (ScriptID 34 1)) ; Uhura
				)
		)
	)

	(method (doChild)
		(switch query
			(-2
				(= local4 1)
				(proc471_6 0 (= local7 global209))
				(gCurRoom setScript: 0)
				((ScriptID 34 1) setScript: (ScriptID 471 3)) ; Uhura, uhuraCompete
				(return 0)
			)
			(-3
				(gCurRoom setScript: uhuraLeave)
				(return 0)
			)
			(-1
				(gCurRoom setScript: uhuraLeave)
				(return 0)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(3 ; Walk
				(gCurRoom setScript: walkBridge)
				((User curEvent:) claimed: 1)
			)
			(else
				(gEgo doVerb: theVerb)
			)
		)
	)
)

(instance uhuraTeller of Teller
	(properties)

	(method (showDialog)
		(super showDialog: 56 (== local0 1) 55 (== local0 2))
	)
)

(instance uhuraInstruct of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 152)
				(HandsOff)
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(1
				(gEgo setHeading: 0)
				((ScriptID 34 1) setMotion: PolyPath 287 144 self) ; Uhura
			)
			(2
				((ScriptID 34 1) ; Uhura
					view: 471
					setLoop: 0
					cel: 0
					setPri: 10
					setCycle: Fwd
					setScale:
					scaleX: 109
					scaleY: 109
					setStep: 3 3
					setMotion: MoveTo 287 132 self
				)
			)
			(3
				((ScriptID 34 1) ; Uhura
					setLoop: 2
					cel: 0
					x: 287
					y: 105
					setCycle: End self
				)
			)
			(4
				((ScriptID 34 1) ; Uhura
					setLoop: 3
					cel: 0
					x: 292
					y: 76
					setCycle: End self
				)
			)
			(5
				(gMessager say: 2 6 12 0 self) ; "Walking on the bridge be the easy part. It be when someone else be on the bridge that it gets tricky."
			)
			(6
				((ScriptID 34 1) ; Uhura
					setStep: 3 2
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 160 ((ScriptID 34 1) y:) self ; Uhura
				)
			)
			(7
				(gMessager say: 2 6 13 0 self) ; "When you walk on this bridge, keep your feet on the outside logs. Feet apart give better balance."
			)
			(8
				(= ticks 30)
			)
			(9
				(proc471_6 0 (= local7 global209))
				(self setScript: (ScriptID 471 5) self 1) ; oppActs
			)
			(10
				(= ticks 30)
			)
			(11
				(gMessager say: 2 6 15 0 self) ; "One way to make your opponent off balance is to jump. Keep your knees bent when you land because the boards under your feet will be moving up and down from the jump."
			)
			(12
				(= ticks 30)
			)
			(13
				(self setScript: (ScriptID 471 5) self 2) ; oppActs
			)
			(14
				(= ticks 30)
			)
			(15
				(gMessager say: 2 6 16 0 self) ; "Another way to throw your opponent off be to lean hard to one side and put all your weight on one foot."
			)
			(16
				(= ticks 30)
			)
			(17
				(self setScript: (ScriptID 471 5) self 4) ; oppActs
			)
			(18
				(= ticks 30)
			)
			(19
				(gMessager say: 2 6 17 0 self) ; "Yet another way to be making your opponent fall be dropping down."
			)
			(20
				(gMessager say: 2 6 18 0 self) ; "You should practice these moves next time you are up here. It takes practice to do them and not fall off yourself."
			)
			(21
				((ScriptID 34 1) view: 471 setLoop: 4 cel: 0) ; Uhura
				(= local5 0)
				(= cycles 1)
			)
			(22
				((ScriptID 34 1) ; Uhura
					cel: (++ local5)
					x: (+ ((ScriptID 34 1) x:) [local9 (* local5 2)]) ; Uhura
					y: (+ ((ScriptID 34 1) y:) [local9 (+ (* local5 2) 1)]) ; Uhura
				)
				(= ticks 6)
			)
			(23
				(if (== local5 8)
					(= cycles 1)
				else
					(self changeState: (-- state))
				)
			)
			(24
				(gMessager say: 2 6 19 0 self) ; "When you be good at these moves, maybe you and I can practice together. It be a long time since I last worked with someone else on the wrestling bridge."
			)
			(25
				((ScriptID 34 1) ; Uhura
					view: 971
					setLoop: -1
					setScale: 200
					setCycle: StopWalk 969
					setMotion: PolyPath ((ScriptID 34 1) x:) 250 self ; Uhura
				)
			)
			(26
				(= local0 10)
				(HandsOn)
				((ScriptID 34 1) dispose:) ; Uhura
			)
		)
	)
)

(instance uhuraLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 1 5 1 0 self) ; "You say good-bye to Uhura."
			)
			(1
				((ScriptID 34 1) ; Uhura
					setMotion: PolyPath ((ScriptID 34 1) x:) 250 self ; Uhura
				)
			)
			(2
				(if (!= (gLongSong number:) 160)
					(gLongSong changeTo: 160)
				)
				((ScriptID 34 1) dispose:) ; Uhura
				(HandsOn)
				(= local0 10)
				(if (and (IsFlag 152) (<= (gEgo y:) 90))
					(proc471_7)
				)
				(self dispose:)
			)
		)
	)
)

(instance enterRoomL of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setScale: 200
					x: -10
					y: 170
					actions: egoActions
					noun: 1
					normalize:
					init:
					setMotion: PolyPath 50 170 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterRoomB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setScale: 200
					x: 160
					y: 210
					actions: egoActions
					noun: 1
					normalize:
					init:
					setMotion: PolyPath 160 175 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitTo480 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (- (gEgo x:) 30) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 480)
			)
		)
	)
)

(instance exitTo420 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 30) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath (gEgo x:) 210 self)
			)
			(1
				(gCurRoom newRoom: 420)
			)
		)
	)
)

(instance uhuraEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((and local1 (== gBaseHeroType 0) (not (IsFlag 59))) ; Fighter
						(= local1 0)
						(= local0 2)
						(gMessager say: 2 6 10 0 self) ; "Very good, young hero. You be learning well how to balance on the bridge."
						(= local2 0)
					)
					((== local0 1)
						(gMessager say: 2 6 4 0 self) ; "Habari, hero of Shapeir. This be the place where the Simbani practice balance and judgement. This is the wrestling bridge. The last part of the initiation contests are held here."
						(= local2 1)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(1
				(gLongSong changeTo: 460)
				(= [local61 0] @local40)
				(uhuraTeller init: (ScriptID 34 1) @local40 @local61) ; Uhura
				((ScriptID 34 1) ; Uhura
					x: 180
					y: 250
					actions: uhuraTeller
					setScale: 200
					noun: 2
					init:
					setCycle: StopWalk 969
					setMotion: PolyPath 190 180 self
				)
			)
			(2
				(if (< (gEgo y:) 90)
					(gMessager say: 2 6 11 0 self) ; "If you wish to be learning how this bridge is used for the initiation contests, come down and I will show you."
				else
					(= ticks 1)
				)
			)
			(3
				(if local2
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance uhuraEnterC of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong changeTo: 460)
				(= cycles 3)
			)
			(1
				(HandsOff)
				(= local6 1)
				(gMessager say: 2 6 (if (== local0 3) 20 else 42) 0 self 470)
			)
			(2
				((ScriptID 34 1) ; Uhura
					x: 180
					y: 250
					setLoop: -1
					show:
					setCycle: StopWalk 969
					setMotion: PolyPath 180 170 self
				)
			)
			(3
				(proc0_13)
				(self dispose:)
			)
		)
	)
)

(instance walkBridge of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch local7
					(1
						(= temp0 150)
					)
					(2
						(= temp0 175)
					)
					(else
						(= temp0 200)
					)
				)
				(= local8 (- 285 (gEgo x:)))
				(gEgo useSkill: 2 100) ; agility
				(if (> (gEgo trySkill: 2 temp0) 0) ; agility
					(= temp1 local8)
					(= local1 (if (>= [gEgoStats 2] temp0) 1 else -1)) ; agility
				else
					(= local1 0)
					(= temp1
						(-
							(= temp1
								(/
									(*
										(- local8 50)
										(+ 100 (- [gEgoStats 2] temp0)) ; agility
									)
									100
								)
							)
							(Random 1 20)
						)
					)
				)
				(if (<= temp1 10)
					(= temp1 (Random 1 20))
				)
				(gEgo
					setSpeed: 6
					setMotion: MoveTo (+ (gEgo x:) temp1) 80 self
				)
			)
			(1
				(if local1
					(self setScript: climbDown self)
				else
					(self setScript: (ScriptID 471 2) self) ; fallDown
				)
			)
			(2
				(proc470_1)
				(self dispose:)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 0 setCycle: Walk setMotion: MoveTo 288 80 self)
			)
			(1
				(if (== local1 -1)
					(= local1 0)
				)
				(= local3 0)
				(if (and (== gBaseHeroType 0) (not (IsFlag 59)) local1) ; Fighter
					(SetFlag 59)
					(= local0 2)
					(if (gCast contains: (ScriptID 34 1)) ; Uhura
						(= local3 1)
						(gMessager say: 2 6 10 0 self) ; "Very good, young hero. You be learning well how to balance on the bridge."
					else
						(self setScript: uhuraEnter self)
						(SetFlag 59)
					)
					(= local1 0)
				else
					(= cycles 1)
				)
			)
			(2
				(if local3
					(= local3 0)
					(gMessager say: 2 6 11 0 self) ; "If you wish to be learning how this bridge is used for the initiation contests, come down and I will show you."
				else
					(= ticks 1)
				)
			)
			(3
				(gEgo
					view: 7
					setLoop: 4
					setPri: 10
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(gEgo
					y: (+ (gEgo y:) 57)
					x: (- (gEgo x:) 5)
					setLoop: 1
					setCel: (gEgo lastCel:)
					setCycle: CT 0 -1 self
				)
			)
			(5
				(gEgo
					y: (+ (gEgo y:) 14)
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(6
				(gEgo
					view: 7
					y: (- (gEgo y:) 3)
					setLoop: 0
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(7
				(gEgo view: 0 setScale: 200 normalize:)
				(if (== local0 2)
					((ScriptID 34 1) setScript: uhuraInstruct) ; Uhura
				else
					(HandsOn)
				)
				(proc470_1)
				(self dispose:)
			)
		)
	)
)

(instance crossOverHand of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setSpeed: 6 setMotion: PolyPath 83 140 self)
			)
			(1
				(switch global209
					(1
						(= temp1 150)
					)
					(2
						(= temp1 180)
					)
					(3
						(= temp1 210)
					)
				)
				(gEgo useSkill: 0 100) ; strength
				(if (> (gEgo trySkill: 0 temp1) 0) ; strength
					(= temp0 148)
				else
					(= temp0 (/ (* 148 (+ 100 (- [gEgoStats 0] temp1))) 100)) ; strength
				)
				(if (<= temp0 20)
					(= temp0 (Random 10 30))
				)
				(gEgo
					view: 39
					setCycle: Fwd
					y: 79
					setScale:
					scaleX: 111
					scaleY: 111
					setMotion: MoveTo (+ (gEgo x:) temp0) 79 self
				)
			)
			(2
				(gEgo view: 0 y: 141 setScale: 200 normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local7 global209)
				(rope approachVerbs: 0)
				(rope2 approachVerbs: 0)
				(bridge approachVerbs: 0)
				(gEgo
					setMotion: MoveTo (rope approachX:) (rope approachY:) self
				)
			)
			(1
				(gEgo
					view: 7
					setLoop: 0
					cel: 0
					setStep: 3 2
					setSpeed: 6
					yStep: 2
					xStep: 3
					setPri: 10
					ignoreActors: 1
					setScale:
					scaleX: 109
					scaleY: 109
					setCycle: End self
				)
			)
			(2
				(gLongSong2 number: 928 setLoop: 1 play: 127)
				(gEgo setLoop: 1 y: 155 cel: 0 setCycle: End self)
			)
			(3
				(gEgo cel: 0 y: (- (gEgo y:) 14) setCycle: End self)
			)
			(4
				(gEgo cel: 0 y: (- (gEgo y:) 14) setCycle: CT 5 1 self)
			)
			(5
				(gEgo
					y: (- (gEgo y:) 48)
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo
					setLoop: 0
					view: 12
					setCycle: Walk
					setMotion: MoveTo 90 80 self
				)
			)
			(7
				(gWalkHandler addToFront: gCurRoom)
				(cond
					((== local0 5)
						(gEgo setMotion: MoveTo 135 (gEgo y:) self)
					)
					(local6
						(gEgo setMotion: MoveTo 135 (gEgo y:) self)
					)
					((and (!= local0 1) (IsFlag 59))
						(self setScript: walkToCenter self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(8
				(if
					(or
						(gCast contains: (ScriptID 39 1)) ; Yesufu
						(and
							(gCast contains: (ScriptID 34 1)) ; Uhura
							(< ((ScriptID 34 1) y:) 90) ; Uhura
						)
					)
					0
				else
					(HandsOn)
				)
				(if (== local0 5)
					((ScriptID 39 1) setScript: (ScriptID 471 4)) ; Yesufu, yesufuCompete
				)
				(self dispose:)
			)
		)
	)
)

(instance walkToCenter of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo setSpeed: 6 setMotion: MoveTo 100 (gEgo y:) self)
			)
			(1
				(proc471_6 0 (= local7 global209))
				(= temp0 (+ 140 (* local7 25)))
				(cond
					((== gBaseHeroType 2) ; Thief
						(proc471_8)
						(self dispose:)
					)
					(
						(and
							(not local6)
							(!= local0 10)
							(>= [gEgoStats 2] temp0) ; agility
							(not (IsFlag 153))
							(not (and (IsFlag 100) (== gDay global425)))
							(not (gCast contains: (ScriptID 34 1))) ; Uhura
						)
						(if (IsFlag 100)
							(= temp1 4)
						else
							(= temp1 3)
						)
						(gCurRoom notify: 3 temp1)
						((ScriptID 34 1) ; Uhura
							x: 180
							y: 250
							setScale: 200
							noun: 2
							init:
							hide:
							setScript: uhuraEnterC
						)
						(self dispose:)
					)
					((IsFlag 152)
						(self dispose:)
						(proc471_7)
					)
					(else
						(HandsOn)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance initContest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 5)
				(gEgo
					normalize:
					setSpeed: 6
					setScale: 200
					setHeading: 180
					x: 30
					y: 149
					init:
				)
				((ScriptID 39 1) ; Yesufu
					setScale: 200
					setHeading: 180
					x: 287
					y: 144
					ignoreActors: 1
					init:
				)
				(gLongSong changeTo: 490)
				(= cycles 1)
			)
			(1
				(gMessager say: 8 6 47 0 self) ; "You may climb the bridge now."
			)
			(2
				(gEgo
					view: 7
					setLoop: 0
					cel: 0
					setPri: 10
					ignoreActors: 1
					setScale:
					scaleX: 109
					scaleY: 109
					setCycle: End self
				)
				((ScriptID 39 1) setHeading: 0) ; Yesufu
			)
			(3
				(gEgo setLoop: 1 y: 155 cel: 0 setCycle: End self)
				((ScriptID 39 1) ; Yesufu
					view: 472
					setLoop: 3
					setPri: 11
					setScale:
					scaleX: 109
					scaleY: 109
					cel: 0
					setCycle: End self
				)
			)
			(4)
			(5
				(gEgo cel: 0 y: (- (gEgo y:) 14) setCycle: End self)
				((ScriptID 39 1) ; Yesufu
					setLoop: 0
					cel: 0
					x: 281
					y: 143
					setCycle: Fwd
					setStep: 3 3
					setMotion: MoveTo 289 119 self
				)
			)
			(6
				(gEgo cel: 0 y: (- (gEgo y:) 14) setCycle: CT 4 1 self)
			)
			(7)
			(8
				(gEgo
					y: (- (gEgo y:) 48)
					x: (- (gEgo x:) 6)
					setLoop: 5
					cel: 0
					setCycle: End self
				)
				((ScriptID 39 1) ; Yesufu
					setLoop: 2
					cel: 0
					x: 293
					y: 79
					setPri: 10
					setStep: 4 2
					setCycle: End self
				)
			)
			(9)
			(10
				(gEgo
					view: 0
					setCycle: StopWalk 5
					setMotion: MoveTo 30 80 self
				)
			)
			(11
				(gEgo
					view: 12
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 135 (gEgo y:) self
				)
				((ScriptID 39 1) ; Yesufu
					setLoop: 1
					cel: 0
					x: 285
					y: 76
					setCycle: Walk
					setMotion: MoveTo 160 76 self
				)
			)
			(12)
			(13
				(gMessager say: 8 6 48 0 self) ; "You may now begin the combat."
			)
			(14
				(proc471_6 1 (= local7 global209))
				(client setScript: (ScriptID 471 4)) ; yesufuCompete
			)
		)
	)
)

(instance rock of Feature
	(properties
		x 53
		y 175
		noun 7
		nsTop 167
		nsLeft 36
		nsBottom 183
		nsRight 71
		sightAngle 180
	)
)

(instance leftTreeTop of Feature
	(properties
		x 38
		y 26
		noun 9
		nsTop 17
		nsLeft 8
		nsBottom 35
		nsRight 68
		sightAngle 180
	)
)

(instance rightTreeTop of Feature
	(properties
		x 218
		y 25
		noun 10
		nsTop 16
		nsLeft 166
		nsBottom 35
		nsRight 271
		sightAngle 180
	)
)

(instance bridge of Feature
	(properties
		x 154
		y 76
		noun 4
		nsTop 68
		nsLeft 12
		nsBottom 82
		nsRight 311
		sightAngle 180
		approachX 83
		approachY 140
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 4) ; Do
				(super doVerb: theVerb &rest)
			)
			((gCurRoom script:) 0)
			((<= (gEgo y:) 90)
				(gCurRoom doVerb: 3)
			)
			((== local0 1)
				(gMessager say: 2 6 57) ; "That not be the way we Simbani be using the bridge. You be climbing the rope to practice."
			)
			(else
				(gCurRoom setScript: crossOverHand)
			)
		)
	)
)

(instance rope of Feature
	(properties
		x 35
		y 104
		noun 5
		nsTop 68
		nsLeft 11
		nsBottom 158
		nsRight 52
		sightAngle 180
		approachX 30
		approachY 143
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 4) ; Do
				(super doVerb: theVerb &rest)
			)
			((or (gCurRoom script:) (<= (gEgo y:) 90))
				(bridge doVerb: &rest)
			)
			((not (IsFlag 61))
				(SetFlag 61)
				(= local0 1)
				(gCurRoom setScript: uhuraEnter)
			)
			(else
				(gCurRoom setScript: climbRope)
			)
		)
	)
)

(instance rope2 of Feature
	(properties
		x 282
		y 97
		nsTop 82
		nsLeft 246
		nsBottom 166
		nsRight 301
		sightAngle 180
		approachX 30
		approachY 143
	)

	(method (doVerb theVerb)
		(rope doVerb: theVerb &rest)
	)
)

(instance wall of Feature
	(properties
		x 159
		y 65
		noun 6
		nsTop 39
		nsBottom 92
		nsRight 319
		sightAngle 40
		approachX 159
		approachY 65
	)
)

