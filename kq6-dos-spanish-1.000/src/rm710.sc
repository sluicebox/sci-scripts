;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 710)
(include sci.sh)
(use Main)
(use rgCastle)
(use n913)
(use PanelInset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm710 0
)

(local
	[local0 7] = [1 12 9 28 5 2 21]
	local7
	local8
	local9
	local10
	local11
	local12
)

(procedure (localproc_0 param1) ; UNUSED
	(= local8 (gEgo y:))
	(if (>= argc 1)
		(= local7 [param1 0])
		(if (>= argc 2)
			(= local8 [param1 1])
		)
	)
)

(class DungeonDoor of Prop
	(properties
		noun 4
		sightAngle 45
		view 710
		cycleSpeed 8
		dungeon# 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 35 2) ; Do, skeletonKey, Talk
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(cond
					(
						(or
							((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
							((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
						)
						(gMessager say: noun theVerb 8 1) ; "The wedding music has begun! Alexander doesn't want to get trapped inside the dungeon now!"
					)
					((not ((ScriptID 80 0) tstFlag: #rFlag1 2)) ; rgCastle
						((ScriptID 80 0) dungeonEntered: dungeon#) ; rgCastle
						(gCurRoom setScript: enterDungeon 0 self)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rm710 of CastleRoom
	(properties
		noun 8
		picture 710
		style 10
		north 720
		east 840
		minScaleSize 37
		minScaleY 112
		maxScaleY 173
	)

	(method (init &tmp temp0 temp1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 176 243 176 192 141 198 141 177 128 171 128 152 115 177 115 177 111 102 111 75 129 70 129 48 143 54 143 0 179
					yourself:
				)
		)
		(gFeatures add: armour roomStuff eachElementDo: #init)
		((ScriptID 80 6) noun: 13 actions: guardDoVerb) ; guard2
		((ScriptID 81 0) guard2Code: path2Code setupGuards:) ; RgBasement
		(= spotEgoScr captureEgo)
		(super init: &rest)
		(dungeonDoor1 init: stopUpd:)
		(dungeonDoor2 init: stopUpd:)
		(dungeonDoor3 init: stopUpd:)
		(treasureDoor init: stopUpd:)
		(= temp1 0)
		(gEgo
			init:
			reset:
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(switch gPrevRoomNum
			(770
				(gEgo posn: 65 134)
				(if ((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
					((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
					((ScriptID 81 0) startGuard:) ; RgBasement
				)
			)
			(720
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 512)) ; rgCastle
					(= temp1 1)
				)
				(gEgo posn: 148 114)
			)
			(820
				((ScriptID 80 0) clrFlag: #rFlag1 8192) ; rgCastle
				(switch ((ScriptID 80 0) dungeonEntered:) ; rgCastle
					(1
						(gEgo
							posn:
								(dungeonDoor1 approachX:)
								(dungeonDoor1 approachY:)
						)
					)
					(2
						(gEgo
							posn:
								(dungeonDoor2 approachX:)
								(dungeonDoor2 approachY:)
						)
					)
					(3
						(gEgo
							posn:
								(dungeonDoor3 approachX:)
								(dungeonDoor3 approachY:)
						)
						(cond
							(((ScriptID 80 0) tstFlag: #rFlag1 1) ; rgCastle
								((ScriptID 80 0) clrFlag: #rFlag1 1) ; rgCastle
								(jollo
									view: 717
									loop: 4
									cel: 2
									posn: 170 154
									setScale:
										Scaler
										(gCurRoom maxScaleSize:)
										(gCurRoom minScaleSize:)
										(gCurRoom maxScaleY:)
										(gCurRoom minScaleY:)
									init:
									ignoreActors: 1
									setCycle: StopWalk -1
								)
								(self setScript: jolloHelpedEgo)
							)
							(((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
								(gGlobalSound fadeTo: 701 -1)
								((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
								(self setScript: tempScript)
							)
						)
					)
				)
			)
			(840
				(= temp1 1)
				(gEgo posn: 305 184)
			)
			(else
				(gEgo posn: 88 132)
				(SetFlag 15)
				(self setScript: (ScriptID 711 0)) ; magicDoorAppears
			)
		)
		(if
			(and
				temp1
				(not ((ScriptID 81 0) tstFlag: #rFlag1 1)) ; RgBasement
				(not ((ScriptID 81 0) tstFlag: #rFlag1 2)) ; RgBasement
				(not (Random 0 5))
			)
			((ScriptID 81 0) setFlag: #rFlag1 2 loiterTimer: 1) ; RgBasement
		)
		((gEgo scaler:) doit:)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (notify param1)
		((ScriptID 80 0) stopTimers: 0) ; rgCastle
		(if param1
			((gCurRoom script:) changeState: 2)
		else
			((gCurRoom script:) changeState: 7)
		)
	)

	(method (doit)
		(= local9 (gEgo onControl: 1))
		(cond
			(script 0)
			((& local9 $4000)
				(gCurRoom newRoom: 720)
			)
			((& local9 $2000)
				(gCurRoom newRoom: 820)
			)
			((& local9 $0400)
				(gCurRoom newRoom: 770)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gEgo setMotion: 0)
		((ScriptID 80 6) actions: 0) ; guard2
		(super newRoom: newRoomNumber &rest)
	)

	(method (warnUser param1 param2 &tmp temp0 temp1)
		(switch param1
			(5
				(if (= temp0 (self roomToEdge: param2))
					(switch temp0
						(1
							(gMessager say: 9 0 19) ; "Alexander hears the guard enter the north hall."
						)
						(2
							(gMessager say: 9 0 18) ; "Alexander hears the guard enter the east hall."
						)
					)
				)
			)
			(6
				(if (== param2 8)
					(gMessager say: 9 0 35) ; "Alexander hears a door off the north hall open, then the sound of guard dog footsteps. The footsteps are headed this way!"
				else
					(gMessager say: 9 0 34) ; "From the east hall, Alexander hears the sounds of a door opening and a guard's footsteps trudging heavily down a flight of stairs."
				)
			)
			(4
				(if ((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
					((ScriptID 81 0) clrFlag: #rFlag1 1) ; RgBasement
					((ScriptID 80 5) dispose:) ; guard1
					(gMessager say: 9 0 37) ; "Alexander hears the guard go into a room off the north hall, shutting the door behind him."
				else
					((ScriptID 81 0) clrFlag: #rFlag1 2) ; RgBasement
					((ScriptID 80 6) dispose:) ; guard2
					(gMessager say: 9 0 36) ; "Alexander hears the guard to the east go up a staircase. A door opens, and the sounds die away. The guard has apparently left the basement."
				)
			)
			(1
				(= temp1 0)
				(cond
					((>= ((ScriptID 80 0) weddingMusicCount:) 3) ; rgCastle
						(if (not (gCast contains: alphaInset))
							((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
						else
							((ScriptID 81 0) setFlag: #rFlag1 16) ; RgBasement
						)
					)
					((not ((ScriptID 80 0) weddingMusicCount:)) ; rgCastle
						(if (== gPrevRoomNum 770)
							((ScriptID 80 0) ; rgCastle
								weddingMusicCount: 2
								weddingRemind: 2
							)
						)
						(= temp1 24)
					)
					(else
						(= temp1 25)
					)
				)
				((ScriptID 81 0) warnUser: param1 9 0 temp1) ; RgBasement
			)
			(else
				(super warnUser: param1 &rest)
			)
		)
	)

	(method (dispose)
		((ScriptID 81 0) clrFlag: #rFlag1 16) ; RgBasement
		(super dispose:)
		(DisposeScript 964)
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
					(gMessager say: 1 14 1 0 0 899) ; MISSING MESSAGE
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

(instance tempScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				((ScriptID 81 0) startGuard:) ; RgBasement
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterDungeon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 4 5 7 0 self) ; "Alexander opens the dungeon door and slips inside."
			)
			(1
				(gGlobalSound4 number: 821 loop: 1 play:)
				(gEgo setPri: (gEgo priority:))
				(register setCycle: End)
				(gEgo
					view: 711
					normal: 0
					loop: 1
					cel: 0
					cycleSpeed: 8
					posn: (+ (gEgo x:) 2) (+ (gEgo y:) 7)
					setCycle: End self
				)
			)
			(2
				(gEgo dispose:)
				(= cycles 4)
			)
			(3
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance doTreasureDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 11 2 31 0 self) ; "Since the door on the west wall has no visible knob or handle, Alexander decides to try to open it with his voice. He composes his words carefully...."
			)
			(1
				(= local10 ((ScriptID 81 0) loiterTimer:)) ; RgBasement
				((ScriptID 81 0) loiterTimer: 0) ; RgBasement
				((ScriptID 80 0) stopTimers: 1) ; rgCastle
				(gGame handsOn:)
				(gTheIconBar disable: 0 2 3 4 5)
				(alphaInset
					view: 713
					offsetX: 30
					offsetY: 20
					maxCol: 5
					maxRow: 5
					numButtons: 30
					posn: 87 39
					init: @local0 7
				)
			)
			(2
				(gGame handsOff:)
				(= cycles 2)
			)
			(3
				(gMessager say: 2 5 4 1 self) ; "Listen, Door! I would have you open! ALI ZEBU!"
			)
			(4
				(gGlobalSound4 number: 901 loop: 1 play:)
				(treasureDoor cycleSpeed: 10 setCycle: End self)
			)
			(5
				(gGlobalSound4 stop:)
				(gMessager say: 2 5 4 2 self) ; "It worked!"
			)
			(6
				(proc80_2 4)
				(self dispose:)
			)
			(7
				(gGame handsOff:)
				(= cycles 2)
			)
			(8
				(gMessager say: 2 5 6 0 self) ; "Having chosen his words, Alexander uses them to firmly address the door."
			)
			(9
				(gGame handsOn:)
				(if ((ScriptID 81 0) tstFlag: #rFlag1 16) ; RgBasement
					((ScriptID 81 0) setFlag: #rFlag1 2 clrFlag: #rFlag1 16) ; RgBasement
					((ScriptID 81 0) startGuard:) ; RgBasement
				)
				((ScriptID 81 0) loiterTimer: local10) ; RgBasement
				(= local10 0)
				(self dispose:)
			)
		)
	)
)

(instance jolloHelpedEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gMessager say: 9 0 9 0 self) ; "But how did you know I was...?"
			)
			(2
				(jollo setSpeed: 6 setMotion: MoveTo 184 180 self)
			)
			(3
				(jollo setMotion: MoveTo 343 180 self)
			)
			(4
				(if ((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
					((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
					((ScriptID 81 0) startGuard:) ; RgBasement
				)
				(if ((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
					(gGlobalSound fadeTo: 701 -1)
					((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
					((ScriptID 81 0) startGuard:) ; RgBasement
					(jollo dispose:)
				else
					(gGlobalSound fadeTo: 704 -1)
					(jollo hide: setScript: followTimer)
				)
				(gGame handsOn:)
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
				(= seconds 6)
			)
			(1
				((ScriptID 80 0) clrFlag: #rFlag3 32768) ; rgCastle
				(jollo dispose:)
			)
		)
	)
)

(instance talkToGuards of Script
	(properties)

	(method (dispose)
		(= register 0)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (register perform: path2Code))
			(gEgo setMotion: 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 5) okToCheck: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0 checkCode: 0) ; guard2
				(= register (CueObj client:))
				(gMessager say: 13 2 0 1 self) ; "Alexander decides to take the direct approach with the guard dog."
			)
			(1
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
				(gMessager say: 13 2 0 2 self oneOnly: 0) ; "Er, hello there. Could you tell me how I might go about getting an audience with the vizier?"
			)
			(5
				(client setScript: captureEgo 0 register)
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
				(if (not register)
					(gMessager say: 9 0 17 1 self) ; "Uh, oh! A guard dog! Alexander's been seen!"
				else
					(= cycles 1)
				)
			)
			(1
				(Face (ScriptID 80 6) gEgo self) ; guard2
			)
			(2
				(gMessager say: 9 0 17 2 self) ; "Hey! You! You're not allowed down here!"
			)
			(3
				((ScriptID 80 6) setScript: (ScriptID 80 4) self 1) ; guard2, guardsGetEgo
			)
			(4
				(gMessager say: 9 0 17 3 self) ; "Er, I think I'm a little lost. I was looking for the wedding and...."
			)
			(5
				(gMessager say: 9 0 17 4 self) ; "<GRRR> Be quiet! The vizier told us to look out for a saboteur! My nose tells me that's you! GUARDS!"
			)
			(6
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98)
				(= cycles 4)
			)
			(7
				(gMessager say: 9 0 17 5 self) ; "Alexander watches helplessly as the guards descend upon him!"
			)
			(8
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance dungeonDoor1 of DungeonDoor
	(properties
		x 165
		y 110
		approachX 150
		approachY 121
		loop 3
		priority 8
		signal 20496
		dungeon# 1
	)
)

(instance dungeonDoor2 of DungeonDoor
	(properties
		x 193
		y 117
		approachX 175
		approachY 133
		loop 2
		signal 20480
		dungeon# 2
	)
)

(instance dungeonDoor3 of DungeonDoor
	(properties
		x 227
		y 134
		approachX 199
		approachY 160
		signal 20480
		dungeon# 3
	)
)

(instance treasureDoor of Prop
	(properties
		x 52
		y 109
		noun 11
		sightAngle 45
		approachX 66
		approachY 134
		view 710
		loop 1
		signal 20480
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 2) ; Do, Talk
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if
					(or
						((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
						((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
					)
					(gMessager say: noun 2 30 1) ; "There's no time for that now! There are guard dogs about!"
				else
					(gCurRoom setScript: doTreasureDoor)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance alphaInset of PanelInset
	(properties
		noun 2
	)

	(method (init)
		(gTheIconBar disable: 6)
		(super init: &rest)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(if (< charCount strLen)
			(gCurRoom setScript: clearedInset 0 charCount)
		)
		(super dispose:)
		(= local11 (= local12 0))
	)

	(method (drawButton &tmp temp0)
		(= temp0 0)
		(if (not (OneOf value 26 27 29 30))
			(if (not (& [local11 (/ value 16)] (>> $8000 (mod value 16))))
				(= [local11 (/ value 16)]
					(| [local11 (/ value 16)] (>> $8000 (mod value 16)))
				)
				(= temp0 (super drawButton: &rest))
				(gGlobalSound3 number: 910 setLoop: 1 play:)
			else
				(= temp0 0)
			)
		)
		(return temp0)
	)
)

(instance clearedInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if register
					(gMessager say: 2 5 6 0 self) ; "Having chosen his words, Alexander uses them to firmly address the door."
				else
					(gMessager say: 2 5 5 0 self) ; "Unable to think of a thing to say, Alexander says nothing to the door."
				)
			)
			(2
				(gGame handsOn:)
				((ScriptID 80 0) stopTimers: 0) ; rgCastle
				((ScriptID 81 0) loiterTimer: local10) ; RgBasement
				(self dispose:)
			)
		)
	)
)

(instance armour of Feature
	(properties
		x 151
		y 111
		z 10
		noun 10
		nsTop 91
		nsLeft 148
		nsBottom 111
		nsRight 155
		sightAngle 45
		approachX 149
		approachY 112
	)
)

(instance roomStuff of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1 &tmp temp0)
		(= temp0 (OnControl CONTROL (param1 x:) (param1 y:)))
		(return
			(or
				(and (& $1000 temp0) (= noun 14))
				(and (& $0002 temp0) (= noun 3))
				(and (& $6404 temp0) (= noun 12))
				(and (& $0188 temp0) (= noun 5))
			)
		)
	)
)

(instance jollo of Actor
	(properties)
)

(instance path2Code of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp0 0)
		(if
			(and
				(== ((param1 regPathID:) currentRoom:) gCurRoomNum)
				(not (param1 inRect: 140 0 320 116))
				(>= 320 (param1 x:) 0)
			)
			(= temp1 (param1 onControl: 1))
			(= temp0 (or (== local9 temp1) (& (| local9 temp1) $0100)))
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

