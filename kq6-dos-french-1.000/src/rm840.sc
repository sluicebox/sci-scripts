;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 840)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm840 0
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
)

(instance rm840 of CastleRoom
	(properties
		noun 9
		picture 840
		style 10
		horizon 10
		north 720
		west 710
		vanishingX 202
		vanishingY 95
		minScaleSize 35
		minScaleY 111
		maxScaleY 173
	)

	(method (init)
		(= scalerCode guardScalerCode)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: -260 -10 319 -10 319 179 266 142 272 142 252 129 246 129 220 111 147 111 147 115 171 115 137 135 85 103 65 55 31 55 31 58 58 58 80 105 134 139 77 178 -260 178
					yourself:
				)
		)
		(gFeatures add: stairCase roomFeatures floors eachElementDo: #init)
		(super init: &rest)
		(= spotEgoScr captureEgo)
		((ScriptID 80 5) noun: 1 okToCheck: CheckCode actions: guardDoVerb) ; guard1
		((ScriptID 80 6) noun: 1 okToCheck: CheckCode actions: guardDoVerb) ; guard2
		((ScriptID 81 0) ; RgBasement
			guard1Code: path1Code
			guard2Code: path1Code
			setupGuards:
		)
		(clownDoor init: stopUpd:)
		(grandHallDoor init: stopUpd:)
		(gEgo
			init:
			actions: egoDoVerb
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(switch gPrevRoomNum
			(720
				(gEgo posn: 175 116)
			)
			(710
				(gEgo posn: 16 184)
			)
			(780
				(gEgo posn: 232 122)
			)
			(else
				(= local1 (= local2 1))
				(gEgo posn: 48 58 setScale: scaleX: 107 scaleY: 107)
			)
		)
		(if (IsObject (gEgo scaler:))
			((gEgo scaler:) doit:)
		)
		(if
			(and
				((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
				(not ((ScriptID 81 0) tstFlag: #rFlag1 8)) ; RgBasement
			)
			(self setScript: weddingCorralCrunch)
		)
		(if ((ScriptID 80 0) tstFlag: #rFlag3 32768) ; rgCastle
			(if script
				(followedClown next: script)
			)
			(self setScript: followedClown)
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (doit &tmp temp0)
		(= local0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& local0 $4000)
				(gCurRoom newRoom: 720)
			)
			((and (not local7) (& local0 $3000))
				(self setScript: climbStairs)
			)
			((& local0 $0800)
				(gCurRoom newRoom: 780)
			)
			((and (InRect 61 45 137 130 gEgo) (gEgo isStopped:))
				(self setScript: climbStairs 0 1)
			)
		)
		(if
			(and
				(InRect 61 45 136 137 gEgo)
				(gEgo isBlocked:)
				(!= script captureEgo)
			)
			(if (= temp0 (gCast firstTrue: #perform RoomCheck))
				(self spotEgo: temp0)
			else
				(gEgo ignoreActors: 1)
			)
		)
		(if local1
			(if (gEgo inRect: 0 0 85 78)
				(= local3 0)
				(if (not local2)
					(= local2 1)
					(gEgo
						oldScaleSignal: 0
						setScale:
						scaleX: 107
						scaleY: 107
					)
				)
			else
				(= local2 0)
				(if (not local3)
					(= local3 1)
					(gEgo
						oldScaleSignal: 0
						setScale:
							Scaler
							maxScaleSize
							minScaleSize
							maxScaleY
							minScaleY
					)
				)
			)
		)
		(cond
			((and local1 (& local0 $0008))
				(= local1 0)
			)
			((and (not local1) (& local0 $1000))
				(= local1 1)
			)
		)
		(super doit: &rest)
	)

	(method (doLoiter)
		(if (not argc)
			(gMessager say: 10 0 26) ; "Alexander hears the sound of guard dog voices coming from behind the door at the top of the stairs. One of them must be on his way down!"
			((ScriptID 81 0) loiterTimer: 15) ; RgBasement
		)
	)

	(method (warnUser param1 param2 &tmp temp0)
		(switch param1
			(1
				(= local9 0)
				(cond
					((>= ((ScriptID 80 0) weddingMusicCount:) 3) ; rgCastle
						(= local9 30)
						((ScriptID 81 0) setFlag: #rFlag1 1 2) ; RgBasement
					)
					((not ((ScriptID 80 0) weddingMusicCount:)) ; rgCastle
						(clownDoor _approachVerbs: 0)
						(= local9 28)
					)
					(else
						(= local9 29)
					)
				)
				((ScriptID 81 0) warnUser: param1 10 0 local9) ; RgBasement
			)
			(6
				(gMessager say: 10 0 22) ; "The door at the top of the stairs opens. A guard dog emerges and starts down the stairs."
			)
			(5
				(if
					(and
						(not (== (gCurRoom script:) weddingCorralCrunch))
						(= temp0 (self roomToEdge: param2))
					)
					(switch temp0
						(4
							(gMessager say: 10 0 19) ; "Alexander hears the guard enter the west hall."
						)
						(1
							(gMessager say: 10 0 18) ; "Alexander hears the guard enter the north hall."
						)
					)
				)
			)
			(4
				(if (not ((ScriptID 81 0) tstFlag: #rFlag1 4)) ; RgBasement
					(if ((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
						(gMessager say: 10 0 23) ; "The guard dog opens the door at the top of the stairs and leaves the basement."
					else
						(gMessager say: 10 0 21) ; "Alexander hears the guard go into a room off the north hall, shutting the door behind him."
					)
				)
			)
			(else
				(super warnUser: param1 &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		((ScriptID 80 5) actions: 0) ; guard1
		((ScriptID 80 6) actions: 0) ; guard2
		((ScriptID 80 0) clrFlag: #rFlag3 32768) ; rgCastle
		(super newRoom: newRoomNumber &rest)
	)

	(method (scriptCheck param1)
		(cond
			((OneOf param1 87 908)
				(if
					(or
						((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
						((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
						((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
					)
					(gMessager say: 3 14 1 0 0 899) ; MISSING MESSAGE
					(return 0)
				else
					(return (super scriptCheck: param1 &rest))
				)
			)
			(
				(or
					((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
					((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
				)
				(gMessager say: 0 0 6 0 0 899) ; "There's no time for that now! There are guard dogs about!"
				(return 0)
			)
			(else
				(return (super scriptCheck: param1 &rest))
			)
		)
	)
)

(instance RoomCheck of Code
	(properties)

	(method (doit param1)
		(return
			(and
				(param1 isKindOf: GuardDog)
				(== ((param1 regPathID:) currentRoom:) gCurRoomNum)
			)
		)
	)
)

(instance talkToGuards of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (register perform: (register checkCode:)))
			(gEgo setMotion: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0) ; guard2
				(= register (CueObj client:))
				(gMessager say: 1 2 0 1 self) ; "Alexander decides to take the direct approach with the guard dog."
			)
			(1
				(= local6 1)
				(= local7 1)
				(gEgo setMotion: PolyPath (register x:) (register y:))
			)
			(2
				(if (not (gEgo facingMe: register))
					(Face gEgo register self)
				else
					(= cycles 1)
				)
			)
			(3
				(= cycles 1)
			)
			(4
				(gMessager say: 1 2 0 2 self oneOnly: 0) ; "Er, hello there. Could you tell me how I might go about getting an audience with the vizier?"
			)
			(5
				(gCurRoom spotEgo: register)
			)
		)
	)
)

(instance captureEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(gCast contains: (ScriptID 80 5)) ; guard1
						(gCast contains: (ScriptID 80 6)) ; guard2
						(==
							(((ScriptID 80 5) regPathID:) currentRoom:) ; guard1
							gCurRoomNum
						)
						(==
							(((ScriptID 80 6) regPathID:) currentRoom:) ; guard2
							gCurRoomNum
						)
					)
					(gCurRoom moveOtherGuard: 1)
				)
				(= ticks 2)
			)
			(1
				(if (not local6)
					(gMessager say: 10 0 16 1 self) ; "Uh, oh! A guard dog! Alexander's been seen!"
				else
					(= cycles 1)
				)
			)
			(2
				(Face register gEgo self)
			)
			(3
				(= cycles 14)
			)
			(4
				(gEgo stopUpd:)
				(grandHallDoor setCycle: 0 stopUpd:)
				(= cycles 4)
			)
			(5
				(gMessager say: 10 0 16 2 self) ; "Hey! You! You're not allowed down here!"
			)
			(6
				(register setScript: (ScriptID 80 4) self 1) ; guardsGetEgo
			)
			(7
				(register stopUpd:)
				(= cycles 4)
			)
			(8
				(gMessager say: 10 0 16 3 self) ; "Er, I think I'm a little lost. I was looking for the wedding and...."
			)
			(9
				(gMessager say: 10 0 16 4 self) ; "<GRRR> Be quiet! The vizier told us to look out for a saboteur! My nose tells me that's you! GUARDS!"
			)
			(10
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98)
				(= cycles 4)
			)
			(11
				(gMessager say: 10 0 16 5 self) ; "Alexander watches helplessly as the guards descend upon him!"
			)
			(12
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance weddingCorralCrunch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (< (((ScriptID 80 6) regPathID:) value:) 8) ; guard2
					(((ScriptID 80 6) regPathID:) value: 8 moveDone:) ; guard2
				)
				((ScriptID 81 0) setFlag: #rFlag1 1 8) ; RgBasement
				(gMessager say: 10 0 15 0 self) ; "Alexander hears the sound of a guard's footsteps coming from the north."
			)
			(2
				((ScriptID 81 0) startGuard:) ; RgBasement
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(= register
						(if (<= (gEgo x:) 88) grandHallDoor else stairCase)
					)
				else
					(= register
						(if (& local0 $2000) grandHallDoor else stairCase)
					)
				)
				(gEgo
					setMotion:
						PolyPath
						(register approachX:)
						(register approachY:)
						self
				)
			)
			(1
				(gGame handsOn:)
				(= register 0)
				(gEgo oldScaleSignal: 0 reset:)
				(self dispose:)
			)
		)
	)
)

(instance followedClown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 0) clrFlag: #rFlag3 32768) ; rgCastle
				(jollo view: 717 loop: 8)
				(if (== gPrevRoomNum 710)
					(jollo posn: 142 150 loop: 3)
				else
					(jollo posn: 177 130 loop: 1)
				)
				(jollo
					ignoreActors: 1
					setCycle: Walk
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					init:
				)
				(= cycles 2)
			)
			(1
				(if (== ((gInventory at: 25) owner:) 750) ; newLamp
					(self setScript: jolloClimbStairs self)
				else
					(self setScript: jolloGotoBed self)
				)
			)
			(2
				(if (not next)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance jolloClimbStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jollo setMotion: MoveTo 132 134 self)
			)
			(1
				(jollo setMotion: PolyPath 90 134 self)
			)
			(2
				(jollo
					setScale:
					scaleX: 107
					scaleY: 107
					setMotion: PolyPath 48 55 self
				)
			)
			(3
				(gGlobalSound4 number: 901 loop: 1 play:)
				(grandHallDoor priority: 10 setCycle: End self)
			)
			(4
				(gGlobalSound4 stop:)
				(jollo setMotion: MoveTo (- (jollo x:) 15) (jollo y:) self)
			)
			(5
				(jollo hide:)
				(grandHallDoor priority: 0 setCycle: Beg self)
			)
			(6
				(gGlobalSound4 number: 902 loop: 1 play:)
				(grandHallDoor stopUpd:)
				(if (== ((gInventory at: 25) owner:) 750) ; newLamp
					(jollo setScript: followTimer)
				else
					(jollo dispose:)
				)
				(self dispose:)
			)
		)
	)
)

(instance followTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 0) setFlag: #rFlag3 32768) ; rgCastle
				(= seconds 10)
			)
			(1
				((ScriptID 80 0) clrFlag: #rFlag3 32768) ; rgCastle
				(jollo dispose:)
			)
		)
	)
)

(instance jolloGotoBed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jollo setMotion: MoveTo 236 124 self)
			)
			(1
				(gGlobalSound4 number: 901 loop: 1 play:)
				(clownDoor setCycle: End self)
			)
			(2
				(gGlobalSound4 stop:)
				(jollo setMotion: MoveTo 238 121 self)
			)
			(3
				(jollo setMotion: MoveTo (+ (jollo x:) 10) (jollo y:) self)
			)
			(4
				(jollo dispose:)
				(clownDoor setCycle: Beg self)
			)
			(5
				(gGlobalSound4 number: 902 loop: 1 play:)
				(clownDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance clownDoor of Prop
	(properties
		x 237
		y 104
		noun 5
		sightAngle 45
		approachX 234
		approachY 122
		view 840
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1 yStep: -1)
		(if (not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
			(self approachVerbs: 5) ; Do
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 80 0) tstFlag: #rFlag1 4) ; rgCastle
					(gMessager say: noun theVerb 9 0) ; "On the east wall is the door to Jollo's bedroom."
				else
					(gMessager say: noun theVerb 8 0) ; "There's a door on the east wall."
				)
			)
			(5 ; Do
				(cond
					(
						(or
							((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
							((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
						)
						(gMessager say: noun theVerb 7 0) ; "The wedding music has begun! Alexander doesn't want to get trapped in a bedroom now!"
					)
					(
						(or
							((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
							((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
						)
						(if ((ScriptID 80 0) tstFlag: #rFlag1 4) ; rgCastle
							(gMessager say: noun theVerb 6 0 self) ; "Alexander decides to evade the guard dogs by ducking into Jollo's room."
						else
							(gMessager say: noun theVerb 5 0 self) ; "Alexander decides to evade the guard dog by ducking into another room."
						)
					)
					((not ((ScriptID 80 0) tstFlag: #rFlag1 4)) ; rgCastle
						(gMessager say: noun theVerb 3 0 self) ; "Alexander decides to find out what's on the other side of that door."
					)
					(else
						(self cue: 0)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue param1)
		(switch (= param1 (++ yStep))
			(0
				(gGame handsOff:)
				(self ignoreActors: setCycle: End self)
				(gGlobalSound3 number: 901 setLoop: 1 play:)
			)
			(1
				((ScriptID 80 0) setFlag: #rFlag1 4) ; rgCastle
				(proc80_2 2)
			)
		)
	)
)

(instance grandHallDoor of Prop
	(properties
		x 26
		y 55
		z 36
		noun 7
		sightAngle 45
		approachX 48
		approachY 55
		view 840
		loop 1
		cycleSpeed 0
	)

	(method (init)
		(super init: &rest)
		(|= signal $0010)
		(self approachVerbs: 5) ; Do
	)

	(method (onMe param1 &tmp temp0)
		(= local7 0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(&
					_approachVerbs
					(gKq6ApproachCode doit: ((gTheIconBar curIcon:) message:))
				)
			)
			(= local7 1)
		)
		(return temp0)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 ((ScriptID 80 5) onControl: 1)) ; guard1
		(= temp1 ((ScriptID 80 6) onControl: 1)) ; guard2
		(super doit:)
		(if (not cycler)
			(cond
				(
					(and
						cel
						(or
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
								(not (& temp0 $0400))
							)
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
								(IsObject ((ScriptID 80 6) regPathID:)) ; guard2
								(==
									(((ScriptID 80 6) regPathID:) currentRoom:) ; guard2
									gCurRoomNum
								)
								(not (& temp1 $0400))
							)
						)
					)
					(self setCycle: Beg self)
				)
				(
					(and
						(not cel)
						(or
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
								((ScriptID 80 5) mover:) ; guard1
								(& temp0 $0400)
							)
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
								(IsObject ((ScriptID 80 6) regPathID:)) ; guard2
								(==
									(((ScriptID 80 6) regPathID:) currentRoom:) ; guard2
									gCurRoomNum
								)
								(& temp1 $0400)
							)
						)
					)
					(self cue: 1 setCycle: End)
				)
				(else 0)
			)
		)
	)

	(method (cue)
		(self ignoreActors: (not (& signal $4000)))
		(if (not local5)
			(if argc
				(= priority 10)
				(gGlobalSound4 number: 901 loop: 1 play:)
			else
				(= priority 0)
				(self stopUpd:)
				(gGlobalSound4 number: 902 loop: 1 play:)
			)
		else
			(gCurRoom newRoom: 730)
		)
	)

	(method (doVerb theVerb)
		(= local7 0)
		(switch theVerb
			(5 ; Do
				(gGame handsOff:)
				(gCurRoom newRoom: 730)
			)
			(1 ; Look
				(if (not local4)
					(++ local4)
					(|= _approachVerbs (gKq6ApproachCode doit: 1))
					(gMessager say: noun theVerb 11) ; "There's a door at the top of the stairs that must lead to an upper floor."
				else
					(gEgo
						oldScaleSignal: 0
						oldMaxScale: 0
						oldBackSize: 0
						oldFrontY: 0
						oldBackY: 0
					)
					(gGame handsOff:)
					(gMessager say: noun theVerb 10 1) ; "Alexander peeks through the keyhole."
					(gCurRoom setScript: (ScriptID 82) 0 lookIntoGrandHall) ; keyHoleScr
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyHoleActions of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
					(gMessager say: 8 theVerb 32) ; "There is no one on the other side of the door."
				else
					(= temp0 0)
				)
			)
			(else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance lookIntoGrandHall of Script
	(properties)

	(method (dispose)
		(if register
			(= register 0)
			(tempGuard1 dispose:)
			(tempGuard2 dispose:)
		)
		(accessaryView dispose:)
		(if ((ScriptID 80 0) tstFlag: #rFlag3 32768) ; rgCastle
			(jollo dispose:)
		)
		((ScriptID 80 0) clrFlag: #rFlag3 32768) ; rgCastle
		(super dispose:)
		((ScriptID 80 0) stopTimers: 0) ; rgCastle
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 0) stopTimers: 1) ; rgCastle
				((ScriptID 82 1) ; keyHoleView
					noun: 8
					actions: keyHoleActions
					init: 793 0 0 74 46
				)
				(jollo setScript: 0)
				(accessaryView init:)
				(if (not (= register ((ScriptID 80 0) tstFlag: #rFlag1 2))) ; rgCastle
					(tempGuard1 init: stopUpd:)
					(tempGuard2 init: stopUpd:)
				)
				(= cycles 2)
			)
			(1
				(= local9 (if register 32 else 10))
				(gMessager say: 7 1 local9 2 self)
			)
			(2
				(if ((ScriptID 80 0) tstFlag: #rFlag3 32768) ; rgCastle
					(jollo
						view: 717
						loop: 0
						cel: 5
						x: 143
						y: 96
						setScale:
						scaleX: 49
						scaleY: 49
						priority: 12
						setCycle: Walk
						signal: 16400
						init:
						setMotion: MoveTo 173 79
					)
				)
			)
		)
	)
)

(instance accessaryView of View
	(properties
		view 793
		cel 1
		priority 11
		signal 16400
	)

	(method (init)
		(= x ((ScriptID 82 1) x:)) ; keyHoleView
		(= y ((ScriptID 82 1) y:)) ; keyHoleView
		(super init: &rest)
	)
)

(instance tempGuard1 of View
	(properties
		x 148
		y 128
		noun 8
		sightAngle 180
		view 793
		loop 1
		priority 14
		signal 16400
		scaleSignal 1
	)
)

(instance tempGuard2 of View
	(properties
		x 167
		y 126
		noun 8
		sightAngle 180
		view 793
		loop 1
		cel 1
		priority 14
		signal 16400
		scaleSignal 1
	)
)

(instance stairCase of Feature
	(properties
		x 129
		y 136
		z 24
		noun 11
		nsTop 90
		nsLeft 123
		nsBottom 135
		nsRight 136
		sightAngle 45
		approachX 141
		approachY 137
	)
)

(instance roomFeatures of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(return
			(or
				(and (& $0010 temp0) (= noun 13))
				(and (& $0002 temp0) (= noun 4))
				(and (& $7804 temp0) (= noun 12))
			)
		)
	)
)

(instance floors of Feature
	(properties
		noun 6
		onMeCheck 392
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(= local7 0)
		(if
			(and
				(& (event type:) evMOVE)
				(not (event modifiers:))
				(self onMe: event)
			)
			(= local7 1)
		else
			(super handleEvent: event)
		)
	)
)

(instance jollo of Actor
	(properties)
)

(instance guardScalerCode of Code
	(properties)

	(method (doit param1)
		(cond
			((param1 inRect: 0 0 88 86)
				(if (param1 scaler:)
					(param1 setScale: scaleX: 107 scaleY: 107)
				)
			)
			((not (param1 scaler:))
				(param1
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
				)
				((param1 scaler:) doit:)
			)
		)
	)
)

(instance CheckCode of Code
	(properties)

	(method (doit param1)
		(return
			(and
				(param1 regPathID:)
				(== ((param1 regPathID:) currentRoom:) gCurRoomNum)
				(not (param1 inRect: 136 64 174 118))
				(not (param1 inRect: -20 0 35 67))
				(> (param1 x:) 0)
			)
		)
	)
)

(instance path1Code of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 0)
		(= temp0 (param1 onControl: 1))
		(if (param1 regPathID:)
			(if (and (not local1) (!= (gCurRoom script:) climbStairs))
				(= temp1
					(if
						(and
							(== ((param1 regPathID:) currentRoom:) gCurRoomNum)
							(& temp0 $0188)
						)
						(if (== (param1 loop:) 3)
							(<= (gEgo y:) (param1 y:))
						else
							(or (== local0 temp0) (& (| local0 temp0) $0100))
						)
					else
						0
					)
				)
			else
				(= temp1
					(if (== ((param1 regPathID:) currentRoom:) gCurRoomNum)
						(param1 inRect: 0 0 119 131)
					)
				)
			)
		)
		(return temp1)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(if (OneOf theVerb 14 19) ; potion, egg
			(if
				(or
					((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
					((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
					((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
				)
				(gMessager say: 3 14 1) ; MISSING MESSAGE
			else
				(= temp0 0)
			)
		else
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance guardDoVerb of Actions
	(properties)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 1)
		(if (== theVerb 2) ; Talk
			(gCurRoom setScript: talkToGuards)
		else
			(= temp0 0)
		)
		(return temp0)
	)
)

