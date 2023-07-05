;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
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
	rm720 0
)

(local
	local0
	local1
)

(instance rm720 of CastleRoom
	(properties
		noun 7
		picture 720
		style 10
		east 840
		west 710
		vanishingY -400
		minScaleSize 75
		minScaleY 143
		maxScaleY 189
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 -10 319 -10 319 139 296 139 290 142 214 142 209 139 89 139 86 142 39 142 27 147 0 147
					yourself:
				)
		)
		(gFeatures
			add: statue ceiling theWindows floorOrCeiling
			eachElementDo: #init
		)
		((ScriptID 80 5) noun: 5) ; guard1
		((ScriptID 80 6) noun: 5) ; guard2
		((ScriptID 81 0) ; RgBasement
			guard1Code: path1Code
			guard2Code: path1Code
			setupGuards:
		)
		(if ((ScriptID 81 0) tstFlag: #rFlag1 4) ; RgBasement
			((ScriptID 80 0) weddingRemind: 0) ; rgCastle
			((ScriptID 80 5) ; guard1
				setMotion: 0
				posn: 131 154 0
				loop: 3
				okToCheck: 1
				init:
				setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
			)
			((ScriptID 80 6) ; guard2
				setMotion: 0
				posn: 140 146 0
				loop: 2
				okToCheck: 1
				init:
				setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
			)
			(= moveOtherGuard 1)
		)
		(guardDoor init: stopUpd:)
		(super init: &rest)
		(hiddenDoor init:)
		(arm init:)
		(= spotEgoScr captureEgo)
		(= local1 1)
		(gEgo
			init:
			setScale: Scaler maxScaleSize minScaleSize maxScaleY minScaleY
		)
		(switch gPrevRoomNum
			(800
				(= local1 0)
				(arm startUpd: cel: 1 stopUpd:)
				(hiddenDoor startUpd: cel: 7 stopUpd:)
				(gEgo posn: 48 144)
				(self setScript: closeDoor)
				(if ((ScriptID 80 0) tstFlag: #rFlag2 256) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 512) ; rgCastle
					((ScriptID 80 0) weddingRemind: 121) ; rgCastle
				)
			)
			(840
				(gEgo posn: 305 168)
			)
			(else
				(gEgo posn: 13 167)
			)
		)
		(if
			(and
				(gCast contains: (ScriptID 80 6)) ; guard2
				(IsObject ((ScriptID 80 6) regPathID:)) ; guard2
				((ScriptID 80 6) mover:) ; guard2
				(< (((ScriptID 80 6) regPathID:) value:) 6) ; guard2
			)
			(guardDoor cel: 4)
			((ScriptID 80 6) posn: 108 142) ; guard2
			(((ScriptID 80 6) regPathID:) value: 6 moveDone:) ; guard2
		)
		((gEgo scaler:) doit:)
		(if
			(and
				local1
				(not ((ScriptID 81 0) tstFlag: #rFlag1 4)) ; RgBasement
				(not ((ScriptID 81 0) tstFlag: #rFlag1 1)) ; RgBasement
				(not ((ScriptID 81 0) tstFlag: #rFlag1 2)) ; RgBasement
				(not (Random 0 5))
			)
			((ScriptID 81 0) setFlag: #rFlag1 1 loiterTimer: 1) ; RgBasement
		)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (warnUser param1 param2 &tmp temp0 temp1)
		(switch param1
			(5
				(if (= temp0 (self roomToEdge: [param2 0]))
					(switch temp0
						(2
							(gMessager say: 10 0 17) ; "Alexander hears the guard enter the east hall."
						)
					)
				)
			)
			(6
				(if (not ((ScriptID 81 0) tstFlag: #rFlag1 4)) ; RgBasement
					(if (== param2 7)
						(gMessager say: 10 0 22) ; "From the east hall, Alexander hears the sounds of a door opening and a guard's footsteps trudging heavily down a flight of stairs."
					else
						(gMessager say: 10 0 24) ; "!!!Do not print this. Comment msg only."
					)
				)
			)
			(1
				(cond
					((>= ((ScriptID 80 0) weddingMusicCount:) 3) ; rgCastle
						(if (>= ((ScriptID 80 0) weddingMusicCount:) 4) ; rgCastle
							(gGame handsOff:)
							((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
						else
							(= temp1 33)
							((ScriptID 80 0) weddingRemind: 15) ; rgCastle
						)
					)
					((not ((ScriptID 80 0) weddingMusicCount:)) ; rgCastle
						(= temp1 28)
					)
					(else
						(= temp1 29)
					)
				)
				((ScriptID 81 0) warnUser: param1 10 0 temp1) ; RgBasement
			)
			(4
				(if (not ((ScriptID 81 0) tstFlag: #rFlag1 4)) ; RgBasement
					((ScriptID 81 0) clrFlag: #rFlag1 2) ; RgBasement
					((ScriptID 80 6) dispose:) ; guard2
					(gMessager say: 10 0 23) ; "Alexander hears the guard to the east go up a staircase. A door opens, and the sounds die away. The guard has apparently left the basement."
				)
			)
			(else
				(super warnUser: param1 param2 &rest)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== newRoomNumber 840)
				(>= ((ScriptID 80 0) weddingMusicCount:) 3) ; rgCastle
				(not ((ScriptID 81 0) tstFlag: #rFlag1 2)) ; RgBasement
			)
			((ScriptID 81 0) setFlag: #rFlag1 2) ; RgBasement
			((ScriptID 80 0) ; rgCastle
				weddingRemind: (+ ((ScriptID 80 0) weddingRemind:) 9) ; rgCastle
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 964)
	)

	(method (scriptCheck param1 &tmp temp0)
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

(instance enterGuardDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 81 0) resetGuard: (ScriptID 80 5) 1) ; RgBasement, guard1
				((ScriptID 81 0) resetGuard: (ScriptID 80 6) 2) ; RgBasement, guard2
				(gMessager say: 4 5 4 1 self) ; "Against his better judgement, Alexander decides to open the door."
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gGlobalSound4 number: 901 loop: 1 play:)
				(guardDoor setCycle: End self)
			)
			(3
				(gGlobalSound4 stop:)
				(gMessager say: 4 5 4 2 self) ; "Somehow, he just knew that wasn't such a good idea."
			)
			(4
				(gEgo setSpeed: 5 setMotion: MoveTo 37 158)
				(= ticks 90)
			)
			(5
				((ScriptID 80 5) ; guard1
					init:
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					posn: 130 135 0
					illegalBits: 0
					setSpeed: 5
					setMotion: MoveTo 109 135 self
				)
			)
			(6
				((ScriptID 80 5) setMotion: MoveTo 107 140 self) ; guard1
			)
			(7
				(gMessager say: 4 5 4 3 self) ; "And where might you think you're going?"
			)
			(8
				(gGame handsOff:)
				(Face gEgo (ScriptID 80 5) self) ; guard1
			)
			(9
				(= cycles 4)
			)
			(10
				((ScriptID 80 5) setScript: (ScriptID 80 4)) ; guard1, guardsGetEgo
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
						(IsObject ((ScriptID 80 5) regPathID:)) ; guard1
						(==
							(((ScriptID 80 5) regPathID:) currentRoom:) ; guard1
							gCurRoomNum
						)
						(IsObject ((ScriptID 80 6) regPathID:)) ; guard2
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
				(gMessager say: 10 0 16 1 self) ; "Uh, oh! A guard dog! Alexander's been seen!"
			)
			(2
				(Face register gEgo self)
			)
			(3
				(gMessager say: 10 0 16 2 self) ; "Hey! You! You're not allowed down here!"
			)
			(4
				(register setScript: (ScriptID 80 4) self 1) ; guardsGetEgo
			)
			(5
				(gMessager say: 10 0 16 3 self) ; "Er, I think I'm a little lost. I was looking for the wedding and...."
			)
			(6
				(gMessager say: 10 0 16 4 self) ; "<GRRR> Be quiet! The vizier told us to look out for a saboteur! My nose tells me that's you! GUARDS!"
			)
			(7
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98)
				(= cycles 4)
			)
			(8
				(gMessager say: 10 0 16 5 self) ; "Alexander watches helplessly as the guards descend upon him!"
			)
			(9
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance statue of Feature
	(properties
		x 23
		y 144
		z 30
		noun 11
		sightAngle 45
		onMeCheck 2
		approachX 9
		approachY 147
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance arm of View
	(properties
		x 18
		y 101
		noun 8
		approachX 8
		approachY 147
		view 720
		loop 2
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(if (== (gKq6ApproachCode doit: theVerb) -32768)
			(gMessager say: 11) ; "There's no reason to use that on the suit of armor."
		else
			(switch theVerb
				(2 ; Talk
					(gMessager say: 11 theVerb) ; "There is no one inside the suit of armor to talk to."
				)
				(5 ; Do
					(cond
						((not ((ScriptID 80 0) tstFlag: #rFlag1 32768)) ; rgCastle
							(gMessager say: noun theVerb 9) ; "Alexander can see nothing unusual about that suit of armor."
						)
						(((ScriptID 80 0) tstFlag: #rFlag1 2) ; rgCastle
							(gMessager say: noun theVerb 7) ; "There's no time for the secret passage now! The wedding music has started!"
						)
						(else
							(gCurRoom setScript: openSecretDoor)
						)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGlobalSound4 number: 909 loop: 1 play:)
				(hiddenDoor setCycle: Beg self)
			)
			(2
				(gGlobalSound4 stop:)
				(arm cel: 0 forceUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openSecretDoor of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 80 5) okToCheck: 0 setMotion: 0) ; guard1
				((ScriptID 80 6) okToCheck: 0 setMotion: 0) ; guard2
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 2)) ; rgCastle
					(gGame givePoints: 2)
					(gMessager say: 8 5 5 1 self) ; "Remembering what the little boy ghost said, Alexander experiments with the suit of armor. He pushes down, then pulls up on the knight's right arm."
				else
					(gMessager say: 8 5 6 0 self) ; "Alexander opens the secret passage."
				)
			)
			(1
				(gEgo
					normal: 0
					view: 722
					loop: 0
					cel: 0
					posn: 5 146
					cycleSpeed: 8
					setScale:
					scaleX: 107
					scaleY: 107
					setCycle: CT 3 1 self
				)
				(arm startUpd:)
			)
			(2
				(gGlobalSound4 number: 720 loop: 1 play:)
				(arm cel: 1 stopUpd:)
				(gEgo setCycle: Beg self)
				(hiddenDoor startUpd:)
			)
			(3
				(gGlobalSound4 number: 909 loop: 1 play:)
				(hiddenDoor setCycle: End self)
			)
			(4
				(gGlobalSound4 stop:)
				(hiddenDoor stopUpd:)
				(gEgo reset: 3 900)
				(= cycles 1)
			)
			(5
				(if
					(or
						(and
							(gCast contains: (ScriptID 80 5)) ; guard1
							(==
								(((ScriptID 80 5) regPathID:) currentRoom:) ; guard1
								gCurRoomNum
							)
							(= temp0 (ScriptID 80 5)) ; guard1
						)
						(and
							(gCast contains: (ScriptID 80 6)) ; guard2
							(==
								(((ScriptID 80 6) regPathID:) currentRoom:) ; guard2
								gCurRoomNum
							)
							(= temp0 (ScriptID 80 6)) ; guard2
						)
					)
					(gCurRoom spotEgo: temp0)
				else
					(= ticks 1)
				)
			)
			(6
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 2)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 2) ; rgCastle
					(gMessager say: 8 5 5 2 self) ; "A secret passage!"
				else
					(= cycles 1)
				)
			)
			(7
				(gEgo
					setSpeed: 8
					setScale:
						Scaler
						(gCurRoom maxScaleSize:)
						(gCurRoom minScaleSize:)
						(gCurRoom maxScaleY:)
						(gCurRoom minScaleY:)
					setMotion: PolyPath 51 141 self
				)
			)
			(8
				(gEgo setHeading: 0 self)
			)
			(9
				(gEgo
					normal: 0
					view: 722
					loop: 1
					cel: 0
					cycleSpeed: 8
					posn: 51 143
					setScale:
					scaleX: 106
					scaleY: 106
					setCycle: End self
				)
			)
			(10
				(gEgo dispose:)
				(= cycles 4)
			)
			(11
				(gCurRoom newRoom: 800)
			)
		)
	)
)

(instance hiddenDoor of Prop
	(properties
		x 40
		y 117
		noun 9
		view 720
		loop 1
		signal 16385
	)

	(method (onMe param1)
		(return (and (super onMe: param1) ((ScriptID 80 0) tstFlag: #rFlag3 2))) ; rgCastle
	)

	(method (doVerb theVerb)
		(if (== (gKq6ApproachCode doit: theVerb) -32768)
			(= theVerb 0)
		)
		(gMessager say: noun theVerb 10)
	)
)

(instance guardDoor of Prop
	(properties
		x 99
		y 117
		noun 4
		sightAngle 40
		approachX 110
		approachY 139
		view 720
		cycleSpeed 0
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 ((ScriptID 80 5) onControl: 1)) ; guard1
		(= temp1 ((ScriptID 80 6) onControl: 1)) ; guard2
		(super doit:)
		(if (not cycler)
			(cond
				(
					(and
						(not cel)
						(or
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
								(IsObject ((ScriptID 80 5) regPathID:)) ; guard1
								(==
									(((ScriptID 80 5) regPathID:) currentRoom:) ; guard1
									gCurRoomNum
								)
								(& temp0 $4000)
							)
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
								(IsObject ((ScriptID 80 6) regPathID:)) ; guard2
								(==
									(((ScriptID 80 6) regPathID:) currentRoom:) ; guard2
									gCurRoomNum
								)
								(& temp1 $4000)
							)
						)
					)
					(self cue: 1 setCycle: End)
				)
				(
					(and
						cel
						(or
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 1) ; RgBasement
								(IsObject ((ScriptID 80 5) regPathID:)) ; guard1
								(==
									(((ScriptID 80 5) regPathID:) currentRoom:) ; guard1
									gCurRoomNum
								)
								(not (& temp0 $4000))
							)
							(and
								((ScriptID 81 0) tstFlag: #rFlag1 2) ; RgBasement
								(IsObject ((ScriptID 80 6) regPathID:)) ; guard2
								(==
									(((ScriptID 80 6) regPathID:) currentRoom:) ; guard2
									gCurRoomNum
								)
								(not (& temp1 $4000))
							)
						)
					)
					(self setCycle: Beg self)
				)
				(else 0)
			)
		)
	)

	(method (cue)
		(if argc
			(gGlobalSound4 number: 901 loop: 1 play:)
		else
			(gGlobalSound4 number: 902 loop: 1 play:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if local0
					(gCurRoom setScript: enterGuardDoor)
				else
					(gMessager say: noun theVerb (+ 3 local0))
				)
				(= local0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		y 2
		noun 2
		onMeCheck 16
	)
)

(instance rightArm of Feature ; UNUSED
	(properties
		y 144
		noun 8
		onMeCheck 8
		approachX 9
		approachY 147
	)

	(method (onMe param1)
		(= x (param1 x:))
		(return (super onMe: param1))
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)
)

(instance theWindows of Feature
	(properties
		y 75
		noun 13
		onMeCheck 4
	)

	(method (onMe param1)
		(= x (param1 x:))
		(return (super onMe: param1))
	)
)

(instance floorOrCeiling of Feature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
	)

	(method (onMe param1)
		(return
			(or
				(and (<= (param1 y:) 137) (= noun 12))
				(and (> (param1 y:) 137) (= noun 3))
			)
		)
	)
)

(instance path1Code of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(= temp0 0)
		(if
			(or
				(not (IsObject (param1 regPathID:)))
				(== ((param1 regPathID:) currentRoom:) gCurRoomNum)
			)
			(= temp0 (>= 320 (param1 x:) 0))
		)
		(return temp0)
	)
)

